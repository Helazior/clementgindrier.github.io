package org.kxml2.p009io;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Hashtable;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlPullParserException;

/* renamed from: org.kxml2.io.KXmlParser */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class KXmlParser implements XmlPullParser {
    private static final String ILLEGAL_TYPE = "Wrong event type";
    private static final int LEGACY = 999;
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    private static final int XML_DECL = 998;
    private int attributeCount;
    private int column;
    private boolean degenerated;
    private int depth;
    private String encoding;
    private Hashtable entityMap;
    private String error;
    private boolean isWhitespace;
    private int line;
    private Object location;
    private String name;
    private String namespace;
    private int peekCount;
    private String prefix;
    private boolean processNsp;
    private Reader reader;
    private boolean relaxed;
    private char[] srcBuf;
    private int srcCount;
    private int srcPos;
    private Boolean standalone;
    private boolean token;
    private int txtPos;
    private int type;
    private boolean unresolved;
    private String version;
    private boolean wasCR;
    private String[] elementStack = new String[16];
    private String[] nspStack = new String[8];
    private int[] nspCounts = new int[4];
    private char[] txtBuf = new char[128];
    private String[] attributes = new String[16];
    private int[] peek = new int[2];

    public KXmlParser() {
        this.srcBuf = new char[Runtime.getRuntime().freeMemory() >= 1048576 ? 8192 : 128];
    }

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
                    error("illegal empty namespace");
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
                if (indexOf2 == 0 && !this.relaxed) {
                    throw new RuntimeException("illegal attribute name: " + str3 + " at " + this);
                } else if (indexOf2 != -1) {
                    String substring2 = str3.substring(0, indexOf2);
                    String substring3 = str3.substring(indexOf2 + 1);
                    String namespace = getNamespace(substring2);
                    if (namespace == null && !this.relaxed) {
                        throw new RuntimeException("Undefined Prefix: " + substring2 + " in " + this);
                    }
                    String[] strArr3 = this.attributes;
                    strArr3[i8] = namespace;
                    strArr3[i8 + 1] = substring2;
                    strArr3[i9] = substring3;
                }
            }
        }
        int indexOf3 = this.name.indexOf(58);
        if (indexOf3 == 0) {
            StringBuilder m253r = outline.m253r("illegal tag name: ");
            m253r.append(this.name);
            error(m253r.toString());
        }
        if (indexOf3 != -1) {
            this.prefix = this.name.substring(0, indexOf3);
            this.name = this.name.substring(indexOf3 + 1);
        }
        String namespace2 = getNamespace(this.prefix);
        this.namespace = namespace2;
        if (namespace2 == null) {
            if (this.prefix != null) {
                StringBuilder m253r2 = outline.m253r("undefined prefix: ");
                m253r2.append(this.prefix);
                error(m253r2.toString());
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

    private final void error(String str) {
        if (this.relaxed) {
            if (this.error == null) {
                this.error = outline.m266e("ERR: ", str);
                return;
            }
            return;
        }
        exception(str);
    }

    private final void exception(String str) {
        if (str.length() >= 100) {
            str = str.substring(0, 100) + "\n";
        }
        throw new XmlPullParserException(str, this, null);
    }

    private final String get(int i) {
        return new String(this.txtBuf, i, this.txtPos - i);
    }

    private final boolean isProp(String str, boolean z, String str2) {
        if (str.startsWith("http://xmlpull.org/v1/doc/")) {
            if (z) {
                return str.substring(42).equals(str2);
            }
            return str.substring(40).equals(str2);
        }
        return false;
    }

    private final void nextImpl() {
        int parseLegacy;
        if (this.reader == null) {
            exception("No Input specified");
        }
        if (this.type == 3) {
            this.depth--;
        }
        do {
            this.attributeCount = -1;
            if (this.degenerated) {
                this.degenerated = false;
                this.type = 3;
                return;
            } else if (this.error != null) {
                for (int i = 0; i < this.error.length(); i++) {
                    push(this.error.charAt(i));
                }
                this.error = null;
                this.type = 9;
                return;
            } else {
                this.prefix = null;
                this.name = null;
                this.namespace = null;
                int peekType = peekType();
                this.type = peekType;
                if (peekType == 1) {
                    return;
                }
                if (peekType == 2) {
                    parseStartTag(false);
                    return;
                } else if (peekType == 3) {
                    parseEndTag();
                    return;
                } else if (peekType == 4) {
                    pushText(60, !this.token);
                    if (this.depth == 0 && this.isWhitespace) {
                        this.type = 7;
                        return;
                    }
                    return;
                } else if (peekType != 6) {
                    parseLegacy = parseLegacy(this.token);
                    this.type = parseLegacy;
                } else {
                    pushEntity();
                    return;
                }
            }
        } while (parseLegacy == XML_DECL);
    }

    private final void parseDoctype(boolean z) {
        int i = 1;
        boolean z2 = false;
        while (true) {
            int read = read();
            if (read == -1) {
                error(UNEXPECTED_EOF);
                return;
            }
            if (read == 39) {
                z2 = !z2;
            } else if (read != 60) {
                if (read == 62 && !z2 && i - 1 == 0) {
                    return;
                }
            } else if (!z2) {
                i++;
            }
            if (z) {
                push(read);
            }
        }
    }

    private final void parseEndTag() {
        read();
        read();
        this.name = readName();
        skip();
        read('>');
        int i = this.depth;
        int i2 = (i - 1) << 2;
        if (i == 0) {
            error("element stack empty");
            this.type = 9;
        } else if (this.relaxed) {
        } else {
            int i3 = i2 + 3;
            if (!this.name.equals(this.elementStack[i3])) {
                StringBuilder m253r = outline.m253r("expected: /");
                m253r.append(this.elementStack[i3]);
                m253r.append(" read: ");
                m253r.append(this.name);
                error(m253r.toString());
            }
            String[] strArr = this.elementStack;
            this.namespace = strArr[i2];
            this.prefix = strArr[i2 + 1];
            this.name = strArr[i2 + 2];
        }
    }

    private final int parseLegacy(boolean z) {
        String str;
        int i;
        int i2;
        read();
        int read = read();
        if (read == 63) {
            if ((peek(0) == 120 || peek(0) == 88) && (peek(1) == 109 || peek(1) == 77)) {
                if (z) {
                    push(peek(0));
                    push(peek(1));
                }
                read();
                read();
                if ((peek(0) == 108 || peek(0) == 76) && peek(1) <= 32) {
                    if (this.line != 1 || this.column > 4) {
                        error("PI must not start with xml");
                    }
                    parseStartTag(true);
                    int i3 = 2;
                    if (this.attributeCount < 1 || !"version".equals(this.attributes[2])) {
                        error("version expected");
                    }
                    String[] strArr = this.attributes;
                    this.version = strArr[3];
                    if (1 >= this.attributeCount || !"encoding".equals(strArr[6])) {
                        i3 = 1;
                    } else {
                        this.encoding = this.attributes[7];
                    }
                    if (i3 < this.attributeCount) {
                        int i4 = i3 * 4;
                        if ("standalone".equals(this.attributes[i4 + 2])) {
                            String str2 = this.attributes[i4 + 3];
                            if ("yes".equals(str2)) {
                                this.standalone = new Boolean(true);
                            } else if ("no".equals(str2)) {
                                this.standalone = new Boolean(false);
                            } else {
                                error(outline.m266e("illegal standalone value: ", str2));
                            }
                            i3++;
                        }
                    }
                    if (i3 != this.attributeCount) {
                        error("illegal xmldecl");
                    }
                    this.isWhitespace = true;
                    this.txtPos = 0;
                    return XML_DECL;
                }
            }
            str = "";
            i = 63;
            i2 = 8;
        } else if (read == 33) {
            if (peek(0) == 45) {
                str = "--";
                i = 45;
                i2 = 9;
            } else if (peek(0) == 91) {
                str = "[CDATA[";
                z = true;
                i = 93;
                i2 = 5;
            } else {
                str = "DOCTYPE";
                i = -1;
                i2 = 10;
            }
        } else {
            error(outline.m273H("illegal: <", read));
            return 9;
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            read(str.charAt(i5));
        }
        if (i2 == 10) {
            parseDoctype(z);
        } else {
            int i6 = 0;
            while (true) {
                int read2 = read();
                if (read2 == -1) {
                    error(UNEXPECTED_EOF);
                    return 9;
                }
                if (z) {
                    push(read2);
                }
                if ((i == 63 || read2 == i) && peek(0) == i && peek(1) == 62) {
                    if (i == 45 && i6 == 45 && !this.relaxed) {
                        error("illegal comment delimiter: --->");
                    }
                    read();
                    read();
                    if (z && i != 63) {
                        this.txtPos--;
                    }
                } else {
                    i6 = read2;
                }
            }
        }
        return i2;
    }

    private final void parseStartTag(boolean z) {
        if (!z) {
            read();
        }
        this.name = readName();
        this.attributeCount = 0;
        while (true) {
            skip();
            int peek = peek(0);
            if (!z) {
                if (peek != 47) {
                    if (peek == 62 && !z) {
                        read();
                        break;
                    }
                } else {
                    this.degenerated = true;
                    read();
                    skip();
                    read('>');
                    break;
                }
            } else if (peek == 63) {
                read();
                read('>');
                return;
            }
            if (peek == -1) {
                error(UNEXPECTED_EOF);
                return;
            }
            String readName = readName();
            if (readName.length() == 0) {
                error("attr name expected");
                break;
            }
            int i = this.attributeCount;
            this.attributeCount = i + 1;
            int i2 = i << 2;
            String[] ensureCapacity = ensureCapacity(this.attributes, i2 + 4);
            this.attributes = ensureCapacity;
            int i3 = i2 + 1;
            ensureCapacity[i2] = "";
            int i4 = i3 + 1;
            ensureCapacity[i3] = null;
            int i5 = i4 + 1;
            ensureCapacity[i4] = readName;
            skip();
            if (peek(0) != 61) {
                if (!this.relaxed) {
                    error(outline.m266e("Attr.value missing f. ", readName));
                }
                this.attributes[i5] = readName;
            } else {
                read('=');
                skip();
                int peek2 = peek(0);
                if (peek2 != 39 && peek2 != 34) {
                    if (!this.relaxed) {
                        error("attr value delimiter missing!");
                    }
                    peek2 = 32;
                } else {
                    read();
                }
                int i6 = this.txtPos;
                pushText(peek2, true);
                this.attributes[i5] = get(i6);
                this.txtPos = i6;
                if (peek2 != 32) {
                    read();
                }
            }
        }
        int i7 = this.depth;
        this.depth = i7 + 1;
        int i8 = i7 << 2;
        String[] ensureCapacity2 = ensureCapacity(this.elementStack, i8 + 4);
        this.elementStack = ensureCapacity2;
        ensureCapacity2[i8 + 3] = this.name;
        int i9 = this.depth;
        int[] iArr = this.nspCounts;
        if (i9 >= iArr.length) {
            int[] iArr2 = new int[i9 + 4];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.nspCounts = iArr2;
        }
        int[] iArr3 = this.nspCounts;
        int i10 = this.depth;
        iArr3[i10] = iArr3[i10 - 1];
        if (this.processNsp) {
            adjustNsp();
        } else {
            this.namespace = "";
        }
        String[] strArr = this.elementStack;
        strArr[i8] = this.namespace;
        strArr[i8 + 1] = this.prefix;
        strArr[i8 + 2] = this.name;
    }

    private final int peek(int i) {
        char c;
        while (i >= this.peekCount) {
            char[] cArr = this.srcBuf;
            if (cArr.length <= 1) {
                c = this.reader.read();
            } else {
                int i2 = this.srcPos;
                if (i2 < this.srcCount) {
                    this.srcPos = i2 + 1;
                    c = cArr[i2];
                } else {
                    int read = this.reader.read(cArr, 0, cArr.length);
                    this.srcCount = read;
                    char c2 = read <= 0 ? (char) 65535 : this.srcBuf[0];
                    this.srcPos = 1;
                    c = c2;
                }
            }
            if (c == '\r') {
                this.wasCR = true;
                int[] iArr = this.peek;
                int i3 = this.peekCount;
                this.peekCount = i3 + 1;
                iArr[i3] = 10;
            } else {
                if (c == '\n') {
                    if (!this.wasCR) {
                        int[] iArr2 = this.peek;
                        int i4 = this.peekCount;
                        this.peekCount = i4 + 1;
                        iArr2[i4] = 10;
                    }
                } else {
                    int[] iArr3 = this.peek;
                    int i5 = this.peekCount;
                    this.peekCount = i5 + 1;
                    iArr3[i5] = c;
                }
                this.wasCR = false;
            }
        }
        return this.peek[i];
    }

    private final int peekType() {
        int peek = peek(0);
        if (peek != -1) {
            if (peek != 38) {
                if (peek != 60) {
                    return 4;
                }
                int peek2 = peek(1);
                if (peek2 != 33) {
                    if (peek2 != 47) {
                        return peek2 != 63 ? 2 : 999;
                    }
                    return 3;
                }
                return 999;
            }
            return 6;
        }
        return 1;
    }

    private final void push(int i) {
        this.isWhitespace &= i <= 32;
        int i2 = this.txtPos;
        char[] cArr = this.txtBuf;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[((i2 * 4) / 3) + 4];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.txtBuf = cArr2;
        }
        char[] cArr3 = this.txtBuf;
        int i3 = this.txtPos;
        this.txtPos = i3 + 1;
        cArr3[i3] = (char) i;
    }

    private final void pushEntity() {
        push(read());
        int i = this.txtPos;
        while (true) {
            int peek = peek(0);
            if (peek == 59) {
                read();
                String str = get(i);
                this.txtPos = i - 1;
                if (this.token && this.type == 6) {
                    this.name = str;
                }
                if (str.charAt(0) == '#') {
                    push(str.charAt(1) == 'x' ? Integer.parseInt(str.substring(2), 16) : Integer.parseInt(str.substring(1)));
                    return;
                }
                String str2 = (String) this.entityMap.get(str);
                boolean z = str2 == null;
                this.unresolved = z;
                if (z) {
                    if (this.token) {
                        return;
                    }
                    error(outline.m265f("unresolved: &", str, ";"));
                    return;
                }
                for (int i2 = 0; i2 < str2.length(); i2++) {
                    push(str2.charAt(i2));
                }
                return;
            } else if (peek < 128 && ((peek < 48 || peek > 57) && ((peek < 97 || peek > 122) && ((peek < 65 || peek > 90) && peek != 95 && peek != 45 && peek != 35)))) {
                if (!this.relaxed) {
                    error("unterminated entity ref");
                }
                PrintStream printStream = System.out;
                StringBuilder m253r = outline.m253r("broken entitiy: ");
                m253r.append(get(i - 1));
                printStream.println(m253r.toString());
                return;
            } else {
                push(read());
            }
        }
    }

    private final void pushText(int i, boolean z) {
        int peek = peek(0);
        int i2 = 0;
        while (peek != -1 && peek != i) {
            if (i == 32 && (peek <= 32 || peek == 62)) {
                return;
            }
            if (peek == 38) {
                if (!z) {
                    return;
                }
                pushEntity();
            } else if (peek == 10 && this.type == 2) {
                read();
                push(32);
            } else {
                push(read());
            }
            if (peek == 62 && i2 >= 2 && i != 93) {
                error("Illegal: ]]>");
            }
            i2 = peek == 93 ? i2 + 1 : 0;
            peek = peek(0);
        }
    }

    private final void read(char c) {
        int read = read();
        if (read != c) {
            error("expected: '" + c + "' actual: '" + ((char) read) + "'");
        }
    }

    private final String readName() {
        int i = this.txtPos;
        int peek = peek(0);
        if ((peek < 97 || peek > 122) && ((peek < 65 || peek > 90) && peek != 95 && peek != 58 && peek < 192 && !this.relaxed)) {
            error("name expected");
        }
        while (true) {
            push(read());
            int peek2 = peek(0);
            if (peek2 < 97 || peek2 > 122) {
                if (peek2 < 65 || peek2 > 90) {
                    if (peek2 < 48 || peek2 > 57) {
                        if (peek2 != 95 && peek2 != 45 && peek2 != 58 && peek2 != 46 && peek2 < 183) {
                            String str = get(i);
                            this.txtPos = i;
                            return str;
                        }
                    }
                }
            }
        }
    }

    private final void skip() {
        while (true) {
            int peek = peek(0);
            if (peek > 32 || peek == -1) {
                return;
            }
            read();
        }
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void defineEntityReplacementText(String str, String str2) {
        Hashtable hashtable = this.entityMap;
        if (hashtable != null) {
            hashtable.put(str, str2);
            return;
        }
        throw new RuntimeException("entity replacement text must be defined after setInput!");
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
        return this.column;
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
        if (isProp(str, false, "relaxed")) {
            return this.relaxed;
        }
        return false;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getInputEncoding() {
        return this.encoding;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public int getLineNumber() {
        return this.line;
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
        StringBuilder m253r3 = outline.m253r("@");
        m253r3.append(this.line);
        m253r3.append(":");
        m253r3.append(this.column);
        stringBuffer.append(m253r3.toString());
        if (this.location != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.location);
        } else if (this.reader != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.reader.toString());
        }
        return stringBuffer.toString();
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getPrefix() {
        return this.prefix;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public Object getProperty(String str) {
        if (isProp(str, true, "xmldecl-version")) {
            return this.version;
        }
        if (isProp(str, true, "xmldecl-standalone")) {
            return this.standalone;
        }
        if (isProp(str, true, "location")) {
            Object obj = this.location;
            return obj != null ? obj : this.reader.toString();
        }
        return null;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public String getText() {
        int i = this.type;
        if (i < 4 || (i == 6 && this.unresolved)) {
            return null;
        }
        return get(0);
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public char[] getTextCharacters(int[] iArr) {
        int i = this.type;
        if (i < 4) {
            iArr[0] = -1;
            iArr[1] = -1;
            return null;
        } else if (i == 6) {
            iArr[0] = 0;
            iArr[1] = this.name.length();
            return this.name.toCharArray();
        } else {
            iArr[0] = 0;
            iArr[1] = this.txtPos;
            return this.txtBuf;
        }
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
        this.txtPos = 0;
        this.isWhitespace = true;
        this.token = false;
        int i = 9999;
        while (true) {
            nextImpl();
            int i2 = this.type;
            if (i2 < i) {
                i = i2;
            }
            if (i > 6 || (i >= 4 && peekType() >= 4)) {
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
        this.txtPos = 0;
        this.token = true;
        nextImpl();
        return this.type;
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void require(int i, String str, String str2) {
        if (i == this.type && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
            return;
        }
        StringBuilder m253r = outline.m253r("expected: ");
        m253r.append(XmlPullParser.TYPES[i]);
        m253r.append(" {");
        m253r.append(str);
        m253r.append("}");
        m253r.append(str2);
        exception(m253r.toString());
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void setFeature(String str, boolean z) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.processNsp = z;
        } else if (isProp(str, false, "relaxed")) {
            this.relaxed = z;
        } else {
            exception(outline.m266e("unsupported feature: ", str));
        }
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void setInput(Reader reader) {
        this.reader = reader;
        this.line = 1;
        this.column = 0;
        this.type = 0;
        this.name = null;
        this.namespace = null;
        this.degenerated = false;
        this.attributeCount = -1;
        this.encoding = null;
        this.version = null;
        this.standalone = null;
        if (reader == null) {
            return;
        }
        this.srcPos = 0;
        this.srcCount = 0;
        this.peekCount = 0;
        this.depth = 0;
        Hashtable hashtable = new Hashtable();
        this.entityMap = hashtable;
        hashtable.put("amp", "&");
        this.entityMap.put("apos", "'");
        this.entityMap.put("gt", ">");
        this.entityMap.put("lt", "<");
        this.entityMap.put("quot", "\"");
    }

    @Override // org.xmlpull.p019v1.XmlPullParser
    public void setProperty(String str, Object obj) {
        if (isProp(str, true, "location")) {
            this.location = obj;
            return;
        }
        throw new XmlPullParserException(outline.m266e("unsupported property: ", str));
    }

    public void skipSubTree() {
        require(2, null, null);
        int i = 1;
        while (i > 0) {
            int next = next();
            if (next == 3) {
                i--;
            } else if (next == 2) {
                i++;
            }
        }
    }

    private final int read() {
        int i;
        if (this.peekCount == 0) {
            i = peek(0);
        } else {
            int[] iArr = this.peek;
            int i2 = iArr[0];
            iArr[0] = iArr[1];
            i = i2;
        }
        this.peekCount--;
        this.column++;
        if (i == 10) {
            this.line++;
            this.column = 1;
        }
        return i;
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00bb A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:7:0x0014, B:9:0x001a, B:12:0x0021, B:13:0x0030, B:16:0x003a, B:40:0x00b3, B:42:0x00bb, B:56:0x00f6, B:46:0x00cf, B:47:0x00de, B:49:0x00e5, B:18:0x003f, B:21:0x0047, B:23:0x0056, B:25:0x0067, B:27:0x006f, B:29:0x0077, B:30:0x007a, B:31:0x0089, B:32:0x0093, B:33:0x009a, B:34:0x00a3, B:35:0x00a6, B:37:0x00ae), top: B:62:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f5  */
    @Override // org.xmlpull.p019v1.XmlPullParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setInput(java.io.InputStream r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.p009io.KXmlParser.setInput(java.io.InputStream, java.lang.String):void");
    }
}
