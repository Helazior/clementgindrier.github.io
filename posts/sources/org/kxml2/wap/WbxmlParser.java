package org.kxml2.wap;

import com.bumptech.glide.load.Key;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlPullParserException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class WbxmlParser implements XmlPullParser {
    public static final String HEX_DIGITS = "0123456789abcdef";
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    public static final int WAP_EXTENSION = 64;
    private String[] attrStartTable;
    private String[] attrValueTable;
    private int attributeCount;
    private boolean degenerated;
    private int depth;
    private String encoding;

    /* renamed from: in */
    private InputStream f5636in;
    private boolean isWhitespace;
    private String name;
    private String namespace;
    private String prefix;
    private boolean processNsp;
    private int publicIdentifierId;
    private byte[] stringTable;
    private String[] tagTable;
    private String text;
    private int type;
    private int version;
    private int wapCode;
    private Object wapExtensionData;
    private int TAG_TABLE = 0;
    private int ATTR_START_TABLE = 1;
    private int ATTR_VALUE_TABLE = 2;
    private Hashtable cacheStringTable = null;
    private String[] elementStack = new String[16];
    private String[] nspStack = new String[8];
    private int[] nspCounts = new int[4];
    private String[] attributes = new String[16];
    private int nextId = -2;
    private Vector tables = new Vector();

    private final boolean adjustNsp() {
        int i;
        String str;
        int i2 = 0;
        boolean z = false;
        while (true) {
            i = this.attributeCount;
            if (i2 >= (i << 2)) {
                break;
            }
            String str2 = this.attributes[i2 + 2];
            int indexOf = str2.indexOf(58);
            if (indexOf != -1) {
                String substring = str2.substring(0, indexOf);
                str = str2.substring(indexOf + 1);
                str2 = substring;
            } else if (str2.equals("xmlns")) {
                str = null;
            } else {
                i2 += 4;
            }
            if (str2.equals("xmlns")) {
                int[] iArr = this.nspCounts;
                int i3 = this.depth;
                int i4 = iArr[i3];
                iArr[i3] = i4 + 1;
                int i5 = i4 << 1;
                String[] ensureCapacity = ensureCapacity(this.nspStack, i5 + 2);
                this.nspStack = ensureCapacity;
                ensureCapacity[i5] = str;
                String[] strArr = this.attributes;
                int i6 = i2 + 3;
                ensureCapacity[i5 + 1] = strArr[i6];
                if (str != null && strArr[i6].equals("")) {
                    exception("illegal empty namespace");
                }
                String[] strArr2 = this.attributes;
                int i7 = this.attributeCount - 1;
                this.attributeCount = i7;
                System.arraycopy(strArr2, i2 + 4, strArr2, i2, (i7 << 2) - i2);
                i2 -= 4;
            } else {
                z = true;
            }
            i2 += 4;
        }
        if (z) {
            int i8 = i << 2;
            while (true) {
                i8 -= 4;
                if (i8 < 0) {
                    break;
                }
                int i9 = i8 + 2;
                String str3 = this.attributes[i9];
                int indexOf2 = str3.indexOf(58);
                if (indexOf2 == 0) {
                    throw new RuntimeException("illegal attribute name: " + str3 + " at " + this);
                } else if (indexOf2 != -1) {
                    String substring2 = str3.substring(0, indexOf2);
                    String substring3 = str3.substring(indexOf2 + 1);
                    String namespace = getNamespace(substring2);
                    if (namespace != null) {
                        String[] strArr3 = this.attributes;
                        strArr3[i8] = namespace;
                        strArr3[i8 + 1] = substring2;
                        strArr3[i9] = substring3;
                        int i10 = this.attributeCount << 2;
                        while (true) {
                            i10 -= 4;
                            if (i10 > i8) {
                                if (substring3.equals(this.attributes[i10 + 2]) && namespace.equals(this.attributes[i10])) {
                                    exception("Duplicate Attribute: {" + namespace + "}" + substring3);
                                }
                            }
                        }
                    } else {
                        throw new RuntimeException("Undefined Prefix: " + substring2 + " in " + this);
                    }
                }
            }
        }
        int indexOf3 = this.name.indexOf(58);
        if (indexOf3 == 0) {
            StringBuilder m253r = outline.m253r("illegal tag name: ");
            m253r.append(this.name);
            exception(m253r.toString());
        } else if (indexOf3 != -1) {
            this.prefix = this.name.substring(0, indexOf3);
            this.name = this.name.substring(indexOf3 + 1);
        }
        String namespace2 = getNamespace(this.prefix);
        this.namespace = namespace2;
        if (namespace2 == null) {
            if (this.prefix != null) {
                StringBuilder m253r2 = outline.m253r("undefined prefix: ");
                m253r2.append(this.prefix);
                exception(m253r2.toString());
            }
            this.namespace = "";
        }
        return z;
    }

    private final String[] ensureCapacity(String[] strArr, int i) {
        if (strArr.length >= i) {
            return strArr;
        }
        String[] strArr2 = new String[i + 16];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    private final void exception(String str) {
        throw new XmlPullParserException(str, this, null);
    }

    private final void nextImpl() {
        if (this.type == 3) {
            this.depth--;
        }
        if (this.degenerated) {
            this.type = 3;
            this.degenerated = false;
            return;
        }
        this.text = null;
        this.prefix = null;
        this.name = null;
        int peekId = peekId();
        while (peekId == 0) {
            this.nextId = -2;
            selectPage(readByte(), true);
            peekId = peekId();
        }
        this.nextId = -2;
        if (peekId == -1) {
            this.type = 1;
        } else if (peekId == 1) {
            int i = (this.depth - 1) << 2;
            this.type = 3;
            String[] strArr = this.elementStack;
            this.namespace = strArr[i];
            this.prefix = strArr[i + 1];
            this.name = strArr[i + 2];
        } else if (peekId == 2) {
            this.type = 6;
            char readInt = (char) readInt();
            this.text = "" + readInt;
            this.name = outline.m273H("#", readInt);
        } else if (peekId != 3) {
            switch (peekId) {
                case 64:
                case 65:
                case 66:
                    break;
                case 67:
                    throw new RuntimeException("PI curr. not supp.");
                default:
                    switch (peekId) {
                        case 128:
                        case Wbxml.EXT_T_1 /* 129 */:
                        case Wbxml.EXT_T_2 /* 130 */:
                            break;
                        case Wbxml.STR_T /* 131 */:
                            this.type = 4;
                            this.text = readStrT();
                            return;
                        default:
                            switch (peekId) {
                                case 192:
                                case Wbxml.EXT_1 /* 193 */:
                                case Wbxml.EXT_2 /* 194 */:
                                case Wbxml.OPAQUE /* 195 */:
                                    break;
                                default:
                                    parseElement(peekId);
                                    return;
                            }
                    }
            }
            this.type = 64;
            this.wapCode = peekId;
            this.wapExtensionData = parseWapExtension(peekId);
        } else {
            this.type = 4;
            this.text = readStrI();
        }
    }

    private int peekId() {
        if (this.nextId == -2) {
            this.nextId = this.f5636in.read();
        }
        return this.nextId;
    }

    private void selectPage(int i, boolean z) {
        if (this.tables.size() == 0 && i == 0) {
            return;
        }
        int i2 = i * 3;
        if (i2 > this.tables.size()) {
            exception("Code Page " + i + " undefined!");
        }
        if (z) {
            this.tagTable = (String[]) this.tables.elementAt(i2 + this.TAG_TABLE);
            return;
        }
        this.attrStartTable = (String[]) this.tables.elementAt(this.ATTR_START_TABLE + i2);
        this.attrValueTable = (String[]) this.tables.elementAt(i2 + this.ATTR_VALUE_TABLE);
    }

    private final void setTable(int i, int i2, String[] strArr) {
        if (this.stringTable != null) {
            throw new RuntimeException("setXxxTable must be called before setInput!");
        }
        while (true) {
            int i3 = i * 3;
            if (this.tables.size() < i3 + 3) {
                this.tables.addElement(null);
            } else {
                this.tables.setElementAt(strArr, i3 + i2);
                return;
            }
        }
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int getAttributeCount() {
        return this.attributeCount;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getAttributeName(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getAttributeNamespace(int i) {
        if (i < this.attributeCount) {
            return this.attributes[i << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getAttributePrefix(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getAttributeType(int i) {
        return "CDATA";
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getAttributeValue(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int getColumnNumber() {
        return -1;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int getDepth() {
        return this.depth;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int getEventType() {
        return this.type;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public boolean getFeature(String str) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.processNsp;
        }
        return false;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getInputEncoding() {
        return this.encoding;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int getLineNumber() {
        return -1;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getName() {
        return this.name;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getNamespace(String str) {
        if ("xml".equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(str)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (int namespaceCount = (getNamespaceCount(this.depth) << 1) - 2; namespaceCount >= 0; namespaceCount -= 2) {
            if (str == null) {
                String[] strArr = this.nspStack;
                if (strArr[namespaceCount] == null) {
                    return strArr[namespaceCount + 1];
                }
            } else if (str.equals(this.nspStack[namespaceCount])) {
                return this.nspStack[namespaceCount + 1];
            }
        }
        return null;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int getNamespaceCount(int i) {
        if (i <= this.depth) {
            return this.nspCounts[i];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getNamespacePrefix(int i) {
        return this.nspStack[i << 1];
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getNamespaceUri(int i) {
        return this.nspStack[(i << 1) + 1];
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getPositionDescription() {
        int i = this.type;
        String[] strArr = XmlPullParser.TYPES;
        StringBuffer stringBuffer = new StringBuffer(i < strArr.length ? strArr[i] : "unknown");
        stringBuffer.append(' ');
        int i2 = this.type;
        if (i2 == 2 || i2 == 3) {
            if (this.degenerated) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append('<');
            if (this.type == 3) {
                stringBuffer.append('/');
            }
            if (this.prefix != null) {
                StringBuilder m253r = outline.m253r("{");
                m253r.append(this.namespace);
                m253r.append("}");
                m253r.append(this.prefix);
                m253r.append(":");
                stringBuffer.append(m253r.toString());
            }
            stringBuffer.append(this.name);
            int i3 = this.attributeCount << 2;
            for (int i4 = 0; i4 < i3; i4 += 4) {
                stringBuffer.append(' ');
                int i5 = i4 + 1;
                if (this.attributes[i5] != null) {
                    StringBuilder m253r2 = outline.m253r("{");
                    m253r2.append(this.attributes[i4]);
                    m253r2.append("}");
                    m253r2.append(this.attributes[i5]);
                    m253r2.append(":");
                    stringBuffer.append(m253r2.toString());
                }
                stringBuffer.append(this.attributes[i4 + 2] + "='" + this.attributes[i4 + 3] + "'");
            }
            stringBuffer.append('>');
        } else if (i2 != 7) {
            if (i2 != 4) {
                stringBuffer.append(getText());
            } else if (this.isWhitespace) {
                stringBuffer.append("(whitespace)");
            } else {
                String text = getText();
                if (text.length() > 16) {
                    text = text.substring(0, 16) + "...";
                }
                stringBuffer.append(text);
            }
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public Object getProperty(String str) {
        return null;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getText() {
        return this.text;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        if (this.type >= 4) {
            iArr[0] = 0;
            iArr[1] = this.text.length();
            char[] cArr = new char[this.text.length()];
            String str = this.text;
            str.getChars(0, str.length(), cArr, 0);
            return cArr;
        }
        iArr[0] = -1;
        iArr[1] = -1;
        return null;
    }

    public int getWapCode() {
        return this.wapCode;
    }

    public Object getWapExtensionData() {
        return this.wapExtensionData;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public boolean isAttributeDefault(int i) {
        return false;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public boolean isEmptyElementTag() {
        if (this.type != 2) {
            exception(ILLEGAL_TYPE);
        }
        return this.degenerated;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public boolean isWhitespace() {
        int i = this.type;
        if (i != 4 && i != 7 && i != 5) {
            exception(ILLEGAL_TYPE);
        }
        return this.isWhitespace;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int next() {
        this.isWhitespace = true;
        int i = 9999;
        while (true) {
            String str = this.text;
            nextImpl();
            int i2 = this.type;
            if (i2 < i) {
                i = i2;
            }
            if (i <= 5) {
                if (i >= 4) {
                    if (str != null) {
                        if (this.text != null) {
                            StringBuilder m253r = outline.m253r(str);
                            m253r.append(this.text);
                            str = m253r.toString();
                        }
                        this.text = str;
                    }
                    int peekId = peekId();
                    if (peekId != 2 && peekId != 3 && peekId != 4 && peekId != 68 && peekId != 196 && peekId != 131 && peekId != 132) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.type = i;
        if (i > 4) {
            this.type = 4;
        }
        return this.type;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int nextTag() {
        next();
        if (this.type == 4 && this.isWhitespace) {
            next();
        }
        int i = this.type;
        if (i != 3 && i != 2) {
            exception("unexpected type");
        }
        return this.type;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String nextText() {
        String str;
        if (this.type != 2) {
            exception("precondition: START_TAG");
        }
        next();
        if (this.type == 4) {
            str = getText();
            next();
        } else {
            str = "";
        }
        if (this.type != 3) {
            exception("END_TAG expected");
        }
        return str;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int nextToken() {
        this.isWhitespace = true;
        nextImpl();
        return this.type;
    }

    public void parseElement(int i) {
        this.type = 2;
        this.name = resolveId(this.tagTable, i & 63);
        this.attributeCount = 0;
        if ((i & 128) != 0) {
            readAttr();
        }
        this.degenerated = (i & 64) == 0;
        int i2 = this.depth;
        this.depth = i2 + 1;
        int i3 = i2 << 2;
        String[] ensureCapacity = ensureCapacity(this.elementStack, i3 + 4);
        this.elementStack = ensureCapacity;
        ensureCapacity[i3 + 3] = this.name;
        int i4 = this.depth;
        int[] iArr = this.nspCounts;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[i4 + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.nspCounts = iArr2;
        }
        int[] iArr3 = this.nspCounts;
        int i5 = this.depth;
        iArr3[i5] = iArr3[i5 - 1];
        for (int i6 = this.attributeCount - 1; i6 > 0; i6--) {
            for (int i7 = 0; i7 < i6; i7++) {
                if (getAttributeName(i6).equals(getAttributeName(i7))) {
                    StringBuilder m253r = outline.m253r("Duplicate Attribute: ");
                    m253r.append(getAttributeName(i6));
                    exception(m253r.toString());
                }
            }
        }
        if (this.processNsp) {
            adjustNsp();
        } else {
            this.namespace = "";
        }
        String[] strArr = this.elementStack;
        strArr[i3] = this.namespace;
        strArr[i3 + 1] = this.prefix;
        strArr[i3 + 2] = this.name;
    }

    public Object parseWapExtension(int i) {
        switch (i) {
            case 64:
            case 65:
            case 66:
                return readStrI();
            default:
                switch (i) {
                    case 128:
                    case Wbxml.EXT_T_1 /* 129 */:
                    case Wbxml.EXT_T_2 /* 130 */:
                        return new Integer(readInt());
                    default:
                        byte[] bArr = null;
                        switch (i) {
                            case 192:
                            case Wbxml.EXT_1 /* 193 */:
                            case Wbxml.EXT_2 /* 194 */:
                                break;
                            default:
                                exception(outline.m273H("illegal id: ", i));
                                return null;
                            case Wbxml.OPAQUE /* 195 */:
                                int readInt = readInt();
                                bArr = new byte[readInt];
                                int i2 = readInt;
                                while (i2 > 0) {
                                    i2 -= this.f5636in.read(bArr, readInt - i2, i2);
                                }
                                break;
                        }
                        return bArr;
                }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void readAttr() {
        StringBuffer stringBuffer;
        int readByte = readByte();
        int i = 0;
        while (readByte != 1) {
            while (readByte == 0) {
                selectPage(readByte(), false);
                readByte = readByte();
            }
            String resolveId = resolveId(this.attrStartTable, readByte);
            int indexOf = resolveId.indexOf(61);
            if (indexOf == -1) {
                stringBuffer = new StringBuffer();
            } else {
                StringBuffer stringBuffer2 = new StringBuffer(resolveId.substring(indexOf + 1));
                resolveId = resolveId.substring(0, indexOf);
                stringBuffer = stringBuffer2;
            }
            int readByte2 = readByte();
            while (true) {
                if (readByte2 > 128 || readByte2 == 0 || readByte2 == 2 || readByte2 == 3 || readByte2 == 131 || ((readByte2 >= 64 && readByte2 <= 66) || (readByte2 >= 128 && readByte2 <= 130))) {
                    if (readByte2 == 0) {
                        selectPage(readByte(), false);
                    } else if (readByte2 == 2) {
                        stringBuffer.append((char) readInt());
                    } else if (readByte2 != 3) {
                        switch (readByte2) {
                            default:
                                switch (readByte2) {
                                    case 128:
                                    case Wbxml.EXT_T_1 /* 129 */:
                                    case Wbxml.EXT_T_2 /* 130 */:
                                        break;
                                    case Wbxml.STR_T /* 131 */:
                                        stringBuffer.append(readStrT());
                                        break;
                                    default:
                                        switch (readByte2) {
                                            case 192:
                                            case Wbxml.EXT_1 /* 193 */:
                                            case Wbxml.EXT_2 /* 194 */:
                                            case Wbxml.OPAQUE /* 195 */:
                                                break;
                                            default:
                                                stringBuffer.append(resolveId(this.attrValueTable, readByte2));
                                                break;
                                        }
                                }
                            case 64:
                            case 65:
                            case 66:
                                stringBuffer.append(resolveWapExtension(readByte2, parseWapExtension(readByte2)));
                                break;
                        }
                    } else {
                        stringBuffer.append(readStrI());
                    }
                    readByte2 = readByte();
                }
            }
            String[] ensureCapacity = ensureCapacity(this.attributes, i + 4);
            this.attributes = ensureCapacity;
            int i2 = i + 1;
            ensureCapacity[i] = "";
            int i3 = i2 + 1;
            ensureCapacity[i2] = null;
            int i4 = i3 + 1;
            ensureCapacity[i3] = resolveId;
            i = i4 + 1;
            ensureCapacity[i4] = stringBuffer.toString();
            this.attributeCount++;
            readByte = readByte2;
        }
    }

    public int readByte() {
        int read = this.f5636in.read();
        if (read != -1) {
            return read;
        }
        throw new IOException(UNEXPECTED_EOF);
    }

    public int readInt() {
        int readByte;
        int i = 0;
        do {
            readByte = readByte();
            i = (i << 7) | (readByte & 127);
        } while ((readByte & 128) != 0);
        return i;
    }

    public String readStrI() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z = true;
        while (true) {
            int read = this.f5636in.read();
            if (read == 0) {
                this.isWhitespace = z;
                String str = new String(byteArrayOutputStream.toByteArray(), this.encoding);
                byteArrayOutputStream.close();
                return str;
            } else if (read != -1) {
                if (read > 32) {
                    z = false;
                }
                byteArrayOutputStream.write(read);
            } else {
                throw new IOException(UNEXPECTED_EOF);
            }
        }
    }

    public String readStrT() {
        int readInt = readInt();
        if (this.cacheStringTable == null) {
            this.cacheStringTable = new Hashtable();
        }
        String str = (String) this.cacheStringTable.get(new Integer(readInt));
        if (str == null) {
            int i = readInt;
            while (true) {
                byte[] bArr = this.stringTable;
                if (i >= bArr.length || bArr[i] == 0) {
                    break;
                }
                i++;
            }
            String str2 = new String(this.stringTable, readInt, i - readInt, this.encoding);
            this.cacheStringTable.put(new Integer(readInt), str2);
            return str2;
        }
        return str;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void require(int i, String str, String str2) {
        String str3;
        if (i == this.type && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
            return;
        }
        StringBuilder m253r = outline.m253r("expected: ");
        if (i == 64) {
            str3 = "WAP Ext.";
        } else {
            str3 = XmlPullParser.TYPES[i] + " {" + str + "}" + str2;
        }
        m253r.append(str3);
        exception(m253r.toString());
    }

    public String resolveId(String[] strArr, int i) {
        int i2 = (i & 127) - 5;
        if (i2 == -1) {
            this.wapCode = -1;
            return readStrT();
        } else if (i2 >= 0 && strArr != null && i2 < strArr.length && strArr[i2] != null) {
            this.wapCode = i2 + 5;
            return strArr[i2];
        } else {
            throw new IOException("id " + i + " undef.");
        }
    }

    public String resolveWapExtension(int i, Object obj) {
        if (obj instanceof byte[]) {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = (byte[]) obj;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                stringBuffer.append(HEX_DIGITS.charAt((bArr[i2] >> 4) & 15));
                stringBuffer.append(HEX_DIGITS.charAt(bArr[i2] & 15));
            }
            return stringBuffer.toString();
        }
        return "$(" + obj + ")";
    }

    public void setAttrStartTable(int i, String[] strArr) {
        setTable(i, this.ATTR_START_TABLE, strArr);
    }

    public void setAttrValueTable(int i, String[] strArr) {
        setTable(i, this.ATTR_VALUE_TABLE, strArr);
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void setFeature(String str, boolean z) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.processNsp = z;
        } else {
            exception(outline.m266e("unsupported feature: ", str));
        }
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void setInput(Reader reader) {
        exception("InputStream required");
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void setProperty(String str, Object obj) {
        throw new XmlPullParserException(outline.m266e("unsupported property: ", str));
    }

    public void setTagTable(int i, String[] strArr) {
        setTable(i, this.TAG_TABLE, strArr);
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void setInput(InputStream inputStream, String str) {
        this.f5636in = inputStream;
        try {
            this.version = readByte();
            int readInt = readInt();
            this.publicIdentifierId = readInt;
            if (readInt == 0) {
                readInt();
            }
            int readInt2 = readInt();
            if (str != null) {
                this.encoding = str;
            } else if (readInt2 == 4) {
                this.encoding = "ISO-8859-1";
            } else if (readInt2 == 106) {
                this.encoding = Key.STRING_CHARSET_NAME;
            } else {
                throw new UnsupportedEncodingException("" + readInt2);
            }
            int readInt3 = readInt();
            this.stringTable = new byte[readInt3];
            int i = 0;
            while (i < readInt3) {
                int read = inputStream.read(this.stringTable, i, readInt3 - i);
                if (read <= 0) {
                    break;
                }
                i += read;
            }
            selectPage(0, true);
            selectPage(0, false);
        } catch (IOException unused) {
            exception("Illegal input format");
        }
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getAttributeValue(String str, String str2) {
        for (int i = (this.attributeCount << 2) - 4; i >= 0; i -= 4) {
            if (this.attributes[i + 2].equals(str2) && (str == null || this.attributes[i].equals(str))) {
                return this.attributes[i + 3];
            }
        }
        return null;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getNamespace() {
        return this.namespace;
    }
}
