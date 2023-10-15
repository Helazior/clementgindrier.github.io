package org.kobjects.xml;

import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class XmlReader {
    public static final int CDSECT = 5;
    public static final int END_DOCUMENT = 1;
    public static final int END_TAG = 3;
    public static final int ENTITY_REF = 6;
    private static final int LEGACY = 999;
    public static final int START_DOCUMENT = 0;
    public static final int START_TAG = 2;
    public static final int TEXT = 4;
    private static final String UNEXPECTED_EOF = "Unexpected EOF";
    private String[] TYPES;
    private int attributeCount;
    private String[] attributes;
    private int column;
    private boolean degenerated;
    private int depth;
    private String[] elementStack = new String[4];
    private Hashtable entityMap;
    private boolean eof;
    private boolean isWhitespace;
    private int line;
    private String name;
    private int peek0;
    private int peek1;
    private Reader reader;
    public boolean relaxed;
    private char[] srcBuf;
    private int srcCount;
    private int srcPos;
    private String text;
    private char[] txtBuf;
    private int txtPos;
    private int type;

    public XmlReader(Reader reader) {
        this.srcBuf = new char[Runtime.getRuntime().freeMemory() >= 1048576 ? 8192 : 128];
        this.txtBuf = new char[128];
        this.attributes = new String[16];
        this.TYPES = new String[]{"Start Document", "End Document", "Start Tag", "End Tag", "Text"};
        this.reader = reader;
        this.peek0 = reader.read();
        this.peek1 = reader.read();
        this.eof = this.peek0 == -1;
        Hashtable hashtable = new Hashtable();
        this.entityMap = hashtable;
        hashtable.put("amp", "&");
        this.entityMap.put("apos", "'");
        this.entityMap.put("gt", ">");
        this.entityMap.put("lt", "<");
        this.entityMap.put("quot", "\"");
        this.line = 1;
        this.column = 1;
    }

    private static final String[] ensureCapacity(String[] strArr, int i) {
        if (strArr.length >= i) {
            return strArr;
        }
        String[] strArr2 = new String[i + 16];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    private final void exception(String str) {
        StringBuilder m252s = outline.m252s(str, " pos: ");
        m252s.append(getPositionDescription());
        throw new IOException(m252s.toString());
    }

    private final void parseDoctype() {
        int i = 1;
        while (true) {
            int read = read();
            if (read == -1) {
                exception(UNEXPECTED_EOF);
            } else if (read != 60) {
                if (read == 62 && i - 1 == 0) {
                    return;
                }
            }
            i++;
        }
    }

    private final void parseEndTag() {
        read();
        read();
        this.name = readName();
        if (this.depth == 0 && !this.relaxed) {
            exception("element stack empty");
        }
        if (this.name.equals(this.elementStack[this.depth - 1])) {
            this.depth--;
        } else if (!this.relaxed) {
            StringBuilder m253r = outline.m253r("expected: ");
            m253r.append(this.elementStack[this.depth]);
            exception(m253r.toString());
        }
        skip();
        read('>');
    }

    private final void parseLegacy(boolean z) {
        String str;
        read();
        int read = read();
        int i = 45;
        if (read == 63) {
            str = "";
            i = 63;
        } else if (read != 33) {
            if (read != 91) {
                exception(outline.m273H("cantreachme: ", read));
            }
            i = 93;
            str = "CDATA[";
        } else if (this.peek0 == 45) {
            str = "--";
        } else {
            str = "DOCTYPE";
            i = -1;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            read(str.charAt(i2));
        }
        if (i == -1) {
            parseDoctype();
            return;
        }
        while (true) {
            if (this.eof) {
                exception(UNEXPECTED_EOF);
            }
            int read2 = read();
            if (z) {
                push(read2);
            }
            if (i == 63 || read2 == i) {
                if (this.peek0 == i && this.peek1 == 62) {
                    break;
                }
            }
        }
        read();
        read();
        if (!z || i == 63) {
            return;
        }
        pop(this.txtPos - 1);
    }

    private final void parseStartTag() {
        read();
        this.name = readName();
        String[] ensureCapacity = ensureCapacity(this.elementStack, this.depth + 1);
        this.elementStack = ensureCapacity;
        int i = this.depth;
        this.depth = i + 1;
        ensureCapacity[i] = this.name;
        while (true) {
            skip();
            int i2 = this.peek0;
            if (i2 == 47) {
                this.degenerated = true;
                read();
                skip();
                read('>');
                return;
            } else if (i2 == 62) {
                read();
                return;
            } else {
                if (i2 == -1) {
                    exception(UNEXPECTED_EOF);
                }
                String readName = readName();
                if (readName.length() == 0) {
                    exception("attr name expected");
                }
                skip();
                read('=');
                skip();
                int read = read();
                if (read != 39 && read != 34) {
                    if (!this.relaxed) {
                        StringBuilder m253r = outline.m253r("<");
                        m253r.append(this.name);
                        m253r.append(">: invalid delimiter: ");
                        m253r.append((char) read);
                        exception(m253r.toString());
                    }
                    read = 32;
                }
                int i3 = this.attributeCount;
                this.attributeCount = i3 + 1;
                int i4 = i3 << 1;
                String[] ensureCapacity2 = ensureCapacity(this.attributes, i4 + 4);
                this.attributes = ensureCapacity2;
                ensureCapacity2[i4] = readName;
                int i5 = this.txtPos;
                pushText(read);
                this.attributes[i4 + 1] = pop(i5);
                if (read != 32) {
                    read();
                }
            }
        }
    }

    private final int peekType() {
        int i = this.peek0;
        if (i != -1) {
            if (i != 38) {
                if (i != 60) {
                    return 4;
                }
                int i2 = this.peek1;
                if (i2 != 33) {
                    if (i2 != 47) {
                        if (i2 != 63) {
                            return i2 != 91 ? 2 : 5;
                        }
                        return 999;
                    }
                    return 3;
                }
                return 999;
            }
            return 6;
        }
        return 1;
    }

    private final String pop(int i) {
        String str = new String(this.txtBuf, i, this.txtPos - i);
        this.txtPos = i;
        return str;
    }

    private final void push(int i) {
        if (i == 0) {
            return;
        }
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

    private final boolean pushText(int i) {
        int i2 = this.peek0;
        boolean z = true;
        while (!this.eof && i2 != i && (i != 32 || (i2 > 32 && i2 != 62))) {
            if (i2 == 38) {
                if (!pushEntity()) {
                    z = false;
                }
            } else {
                if (i2 > 32) {
                    z = false;
                }
                push(read());
            }
            i2 = this.peek0;
        }
        return z;
    }

    private final int read() {
        int i = this.peek0;
        int i2 = this.peek1;
        this.peek0 = i2;
        if (i2 == -1) {
            this.eof = true;
            return i;
        }
        if (i == 10 || i == 13) {
            this.line++;
            this.column = 0;
            if (i == 13 && i2 == 10) {
                this.peek0 = 0;
            }
        }
        this.column++;
        if (this.srcPos >= this.srcCount) {
            Reader reader = this.reader;
            char[] cArr = this.srcBuf;
            int read = reader.read(cArr, 0, cArr.length);
            this.srcCount = read;
            if (read <= 0) {
                this.peek1 = -1;
                return i;
            }
            this.srcPos = 0;
        }
        char[] cArr2 = this.srcBuf;
        int i3 = this.srcPos;
        this.srcPos = i3 + 1;
        this.peek1 = cArr2[i3];
        return i;
    }

    private final String readName() {
        int i = this.txtPos;
        int i2 = this.peek0;
        if ((i2 < 97 || i2 > 122) && ((i2 < 65 || i2 > 90) && i2 != 95 && i2 != 58 && !this.relaxed)) {
            exception("name expected");
        }
        while (true) {
            push(read());
            int i3 = this.peek0;
            if (i3 < 97 || i3 > 122) {
                if (i3 < 65 || i3 > 90) {
                    if (i3 < 48 || i3 > 57) {
                        if (i3 != 95 && i3 != 45 && i3 != 58 && i3 != 46) {
                            return pop(i);
                        }
                    }
                }
            }
        }
    }

    private final void skip() {
        while (!this.eof && this.peek0 <= 32) {
            read();
        }
    }

    public void defineCharacterEntity(String str, String str2) {
        this.entityMap.put(str, str2);
    }

    public int getAttributeCount() {
        return this.attributeCount;
    }

    public String getAttributeName(int i) {
        if (i < this.attributeCount) {
            return this.attributes[i << 1];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeValue(int i) {
        if (i < this.attributeCount) {
            return this.attributes[(i << 1) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    public int getColumnNumber() {
        return this.column;
    }

    public int getDepth() {
        return this.depth;
    }

    public int getLineNumber() {
        return this.line;
    }

    public String getName() {
        return this.name;
    }

    public String getPositionDescription() {
        int i = this.type;
        String[] strArr = this.TYPES;
        StringBuffer stringBuffer = new StringBuffer(i < strArr.length ? strArr[i] : "Other");
        StringBuilder m253r = outline.m253r(" @");
        m253r.append(this.line);
        m253r.append(":");
        m253r.append(this.column);
        m253r.append(": ");
        stringBuffer.append(m253r.toString());
        int i2 = this.type;
        if (i2 != 2 && i2 != 3) {
            if (this.isWhitespace) {
                stringBuffer.append("[whitespace]");
            } else {
                stringBuffer.append(getText());
            }
        } else {
            stringBuffer.append('<');
            if (this.type == 3) {
                stringBuffer.append('/');
            }
            stringBuffer.append(this.name);
            stringBuffer.append('>');
        }
        return stringBuffer.toString();
    }

    public String getText() {
        if (this.text == null) {
            this.text = pop(0);
        }
        return this.text;
    }

    public int getType() {
        return this.type;
    }

    public boolean isEmptyElementTag() {
        return this.degenerated;
    }

    public boolean isWhitespace() {
        return this.isWhitespace;
    }

    public int next() {
        if (this.degenerated) {
            this.type = 3;
            this.degenerated = false;
            this.depth--;
            return 3;
        }
        this.txtPos = 0;
        this.isWhitespace = true;
        while (true) {
            this.attributeCount = 0;
            this.name = null;
            this.text = null;
            int peekType = peekType();
            this.type = peekType;
            switch (peekType) {
                case 1:
                    break;
                case 2:
                    parseStartTag();
                    break;
                case 3:
                    parseEndTag();
                    break;
                case 4:
                    this.isWhitespace &= pushText(60);
                    break;
                case 5:
                    parseLegacy(true);
                    this.isWhitespace = false;
                    this.type = 4;
                    break;
                case 6:
                    this.isWhitespace &= pushEntity();
                    this.type = 4;
                    break;
                default:
                    parseLegacy(false);
                    break;
            }
            int i = this.type;
            if (i > 4 || (i == 4 && peekType() >= 4)) {
            }
        }
        boolean z = this.isWhitespace;
        int i2 = this.type;
        this.isWhitespace = z & (i2 == 4);
        return i2;
    }

    public final boolean pushEntity() {
        read();
        int i = this.txtPos;
        while (!this.eof && this.peek0 != 59) {
            push(read());
        }
        String pop = pop(i);
        read();
        boolean z = true;
        if (pop.length() > 0 && pop.charAt(0) == '#') {
            int parseInt = pop.charAt(1) == 'x' ? Integer.parseInt(pop.substring(2), 16) : Integer.parseInt(pop.substring(1));
            push(parseInt);
            return parseInt <= 32;
        }
        String str = (String) this.entityMap.get(pop);
        if (str == null) {
            str = outline.m265f("&", pop, ";");
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt > ' ') {
                z = false;
            }
            push(charAt);
        }
        return z;
    }

    public String readText() {
        if (this.type != 4) {
            return "";
        }
        String text = getText();
        next();
        return text;
    }

    public void require(int i, String str) {
        if (this.type == 4 && i != 4 && isWhitespace()) {
            next();
        }
        if (i == this.type && (str == null || str.equals(getName()))) {
            return;
        }
        exception(outline.m261j(outline.m253r("expected: "), this.TYPES[i], "/", str));
    }

    public String getAttributeValue(String str) {
        for (int i = (this.attributeCount << 1) - 2; i >= 0; i -= 2) {
            if (this.attributes[i].equals(str)) {
                return this.attributes[i + 1];
            }
        }
        return null;
    }

    private final void read(char c) {
        if (read() != c) {
            if (this.relaxed) {
                if (c <= ' ') {
                    skip();
                    read();
                    return;
                }
                return;
            }
            exception("expected: '" + c + "'");
        }
    }
}
