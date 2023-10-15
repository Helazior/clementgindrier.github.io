package org.kxml2.wap;

import com.bumptech.glide.load.Key;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.p019v1.XmlSerializer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class WbxmlSerializer implements XmlSerializer {
    private int attrPage;
    public int depth;
    private String encoding;
    public String name;
    public String namespace;
    public OutputStream out;
    public String pending;
    private int tagPage;
    public Hashtable stringTable = new Hashtable();
    public ByteArrayOutputStream buf = new ByteArrayOutputStream();
    public ByteArrayOutputStream stringTableBuf = new ByteArrayOutputStream();
    public Vector attributes = new Vector();
    public Hashtable attrStartTable = new Hashtable();
    public Hashtable attrValueTable = new Hashtable();
    public Hashtable tagTable = new Hashtable();
    private boolean headerSent = false;

    public static void writeInt(OutputStream outputStream, int i) {
        int i2;
        byte[] bArr = new byte[5];
        int i3 = 0;
        while (true) {
            i2 = i3 + 1;
            bArr[i3] = (byte) (i & 127);
            i >>= 7;
            if (i == 0) {
                break;
            }
            i3 = i2;
        }
        while (i2 > 1) {
            i2--;
            outputStream.write(bArr[i2] | 128);
        }
        outputStream.write(bArr[0]);
    }

    private void writeStr(String str) {
        int length = str.length();
        if (this.headerSent) {
            writeStrI(this.buf, str);
            return;
        }
        int i = 0;
        int i2 = 0;
        while (i < length) {
            while (i < length && str.charAt(i) < 'A') {
                i++;
            }
            int i3 = i;
            while (i3 < length && str.charAt(i3) >= 'A') {
                i3++;
            }
            if (i3 - i > 10) {
                if (i > i2 && str.charAt(i - 1) == ' ' && this.stringTable.get(str.substring(i, i3)) == null) {
                    this.buf.write(Wbxml.STR_T);
                    writeStrT(str.substring(i2, i3), false);
                } else {
                    if (i > i2 && str.charAt(i - 1) == ' ') {
                        i--;
                    }
                    if (i > i2) {
                        this.buf.write(Wbxml.STR_T);
                        writeStrT(str.substring(i2, i), false);
                    }
                    this.buf.write(Wbxml.STR_T);
                    writeStrT(str.substring(i, i3), true);
                }
                i2 = i3;
            }
            i = i3;
        }
        if (i2 < length) {
            this.buf.write(Wbxml.STR_T);
            writeStrT(str.substring(i2, length), false);
        }
    }

    private final void writeStrT(String str, boolean z) {
        Integer num = (Integer) this.stringTable.get(str);
        writeInt(this.buf, num == null ? addToStringTable(str, z) : num.intValue());
    }

    public int addToStringTable(String str, boolean z) {
        int i;
        if (!this.headerSent) {
            int size = this.stringTableBuf.size();
            if (str.charAt(0) < '0' || !z) {
                i = size;
            } else {
                str = ' ' + str;
                i = size + 1;
            }
            this.stringTable.put(str, new Integer(size));
            if (str.charAt(0) == ' ') {
                this.stringTable.put(str.substring(1), new Integer(size + 1));
            }
            int lastIndexOf = str.lastIndexOf(32);
            if (lastIndexOf > 1) {
                int i2 = size + lastIndexOf;
                this.stringTable.put(str.substring(lastIndexOf), new Integer(i2));
                this.stringTable.put(str.substring(lastIndexOf + 1), new Integer(i2 + 1));
            }
            writeStrI(this.stringTableBuf, str);
            this.stringTableBuf.flush();
            return i;
        }
        throw new IOException("stringtable sent");
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public XmlSerializer attribute(String str, String str2, String str3) {
        this.attributes.addElement(str2);
        this.attributes.addElement(str3);
        return this;
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void cdsect(String str) {
        text(str);
    }

    public void checkPending(boolean z) {
        if (this.pending == null) {
            return;
        }
        int size = this.attributes.size();
        int[] iArr = (int[]) this.tagTable.get(this.pending);
        if (iArr == null) {
            this.buf.write(size == 0 ? z ? 4 : 68 : z ? Wbxml.LITERAL_A : Wbxml.LITERAL_AC);
            writeStrT(this.pending, false);
        } else {
            if (iArr[0] != this.tagPage) {
                this.tagPage = iArr[0];
                this.buf.write(0);
                this.buf.write(this.tagPage);
            }
            this.buf.write(size == 0 ? z ? iArr[1] : iArr[1] | 64 : z ? iArr[1] | 128 : iArr[1] | 192);
        }
        int i = 0;
        while (i < size) {
            int[] iArr2 = (int[]) this.attrStartTable.get(this.attributes.elementAt(i));
            if (iArr2 == null) {
                this.buf.write(4);
                writeStrT((String) this.attributes.elementAt(i), false);
            } else {
                if (iArr2[0] != this.attrPage) {
                    this.attrPage = iArr2[0];
                    this.buf.write(0);
                    this.buf.write(this.attrPage);
                }
                this.buf.write(iArr2[1]);
            }
            int i2 = i + 1;
            int[] iArr3 = (int[]) this.attrValueTable.get(this.attributes.elementAt(i2));
            if (iArr3 == null) {
                writeStr((String) this.attributes.elementAt(i2));
            } else {
                if (iArr3[0] != this.attrPage) {
                    this.attrPage = iArr3[0];
                    this.buf.write(0);
                    this.buf.write(this.attrPage);
                }
                this.buf.write(iArr3[1]);
            }
            i = i2 + 1;
        }
        if (size > 0) {
            this.buf.write(1);
        }
        this.pending = null;
        this.attributes.removeAllElements();
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void comment(String str) {
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void docdecl(String str) {
        throw new RuntimeException("Cannot write docdecl for WBXML");
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void endDocument() {
        flush();
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public XmlSerializer endTag(String str, String str2) {
        if (this.pending != null) {
            checkPending(true);
        } else {
            this.buf.write(1);
        }
        this.depth--;
        return this;
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void entityRef(String str) {
        throw new RuntimeException("EntityReference not supported for WBXML");
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void flush() {
        checkPending(false);
        if (!this.headerSent) {
            writeInt(this.out, this.stringTableBuf.size());
            this.out.write(this.stringTableBuf.toByteArray());
            this.headerSent = true;
        }
        this.out.write(this.buf.toByteArray());
        this.buf.reset();
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public int getDepth() {
        return this.depth;
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public boolean getFeature(String str) {
        return false;
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public String getName() {
        return this.pending;
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public String getNamespace() {
        return null;
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public String getPrefix(String str, boolean z) {
        throw new RuntimeException("NYI");
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public Object getProperty(String str) {
        return null;
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void ignorableWhitespace(String str) {
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void processingInstruction(String str) {
        throw new RuntimeException("PI NYI");
    }

    public void setAttrStartTable(int i, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2] != null) {
                this.attrStartTable.put(strArr[i2], new int[]{i, i2 + 5});
            }
        }
    }

    public void setAttrValueTable(int i, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2] != null) {
                this.attrValueTable.put(strArr[i2], new int[]{i, i2 + 133});
            }
        }
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void setFeature(String str, boolean z) {
        throw new IllegalArgumentException(outline.m266e("unknown feature ", str));
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void setOutput(Writer writer) {
        throw new RuntimeException("Wbxml requires an OutputStream!");
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void setPrefix(String str, String str2) {
        throw new RuntimeException("NYI");
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void setProperty(String str, Object obj) {
        throw new IllegalArgumentException(outline.m266e("unknown property ", str));
    }

    public void setTagTable(int i, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (strArr[i2] != null) {
                this.tagTable.put(strArr[i2], new int[]{i, i2 + 5});
            }
        }
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void startDocument(String str, Boolean bool) {
        this.out.write(3);
        this.out.write(1);
        if (str != null) {
            this.encoding = str;
        }
        if (this.encoding.toUpperCase().equals(Key.STRING_CHARSET_NAME)) {
            this.out.write(106);
        } else if (this.encoding.toUpperCase().equals("ISO-8859-1")) {
            this.out.write(4);
        } else {
            throw new UnsupportedEncodingException(str);
        }
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public XmlSerializer startTag(String str, String str2) {
        if (str != null && !"".equals(str)) {
            throw new RuntimeException("NSP NYI");
        }
        checkPending(false);
        this.pending = str2;
        this.depth++;
        return this;
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public XmlSerializer text(char[] cArr, int i, int i2) {
        checkPending(false);
        writeStr(new String(cArr, i, i2));
        return this;
    }

    public void writeStrI(OutputStream outputStream, String str) {
        outputStream.write(str.getBytes(this.encoding));
        outputStream.write(0);
    }

    public void writeWapExtension(int i, Object obj) {
        checkPending(false);
        this.buf.write(i);
        switch (i) {
            case 64:
            case 65:
            case 66:
                writeStrI(this.buf, (String) obj);
                return;
            default:
                switch (i) {
                    case 128:
                    case Wbxml.EXT_T_1 /* 129 */:
                    case Wbxml.EXT_T_2 /* 130 */:
                        writeStrT((String) obj, false);
                        return;
                    default:
                        switch (i) {
                            case 192:
                            case Wbxml.EXT_1 /* 193 */:
                            case Wbxml.EXT_2 /* 194 */:
                                return;
                            case Wbxml.OPAQUE /* 195 */:
                                byte[] bArr = (byte[]) obj;
                                writeInt(this.buf, bArr.length);
                                this.buf.write(bArr);
                                return;
                            default:
                                throw new IllegalArgumentException();
                        }
                }
        }
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public void setOutput(OutputStream outputStream, String str) {
        if (str == null) {
            str = Key.STRING_CHARSET_NAME;
        }
        this.encoding = str;
        this.out = outputStream;
        this.buf = new ByteArrayOutputStream();
        this.stringTableBuf = new ByteArrayOutputStream();
        this.headerSent = false;
    }

    @Override // org.xmlpull.p019v1.XmlSerializer
    public XmlSerializer text(String str) {
        checkPending(false);
        writeStr(str);
        return this;
    }
}
