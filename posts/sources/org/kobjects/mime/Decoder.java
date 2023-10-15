package org.kobjects.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import org.kobjects.base64.Base64;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Decoder {
    public String boundary;
    public char[] buf;
    public String characterEncoding;
    public boolean consumed;
    public boolean eof;
    public Hashtable header;

    /* renamed from: is */
    public InputStream f5632is;

    public Decoder(InputStream inputStream, String str) {
        this(inputStream, str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007b A[EDGE_INSN: B:38:0x007b->B:29:0x007b ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Hashtable getHeaderElements(java.lang.String r9) {
        /*
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            int r1 = r9.length()
            java.lang.String r2 = ""
            r3 = 0
        Lc:
            if (r3 >= r1) goto L19
            char r4 = r9.charAt(r3)
            r5 = 32
            if (r4 > r5) goto L19
            int r3 = r3 + 1
            goto Lc
        L19:
            if (r3 < r1) goto L1c
            goto L7b
        L1c:
            char r4 = r9.charAt(r3)
            r5 = 59
            r6 = 34
            r7 = -1
            if (r4 != r6) goto L5c
            int r3 = r3 + 1
            int r4 = r9.indexOf(r6, r3)
            if (r4 == r7) goto L50
            java.lang.String r3 = r9.substring(r3, r4)
            r0.put(r2, r3)
            int r4 = r4 + 2
            if (r4 < r1) goto L3b
            goto L7b
        L3b:
            int r2 = r4 + (-1)
            char r2 = r9.charAt(r2)
            if (r2 != r5) goto L44
            goto L73
        L44:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "; expected in "
            java.lang.String r9 = p000.outline.m266e(r1, r9)
            r0.<init>(r9)
            throw r0
        L50:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "End quote expected in "
            java.lang.String r9 = p000.outline.m266e(r1, r9)
            r0.<init>(r9)
            throw r0
        L5c:
            int r4 = r9.indexOf(r5, r3)
            if (r4 != r7) goto L6a
            java.lang.String r9 = r9.substring(r3)
            r0.put(r2, r9)
            goto L7b
        L6a:
            java.lang.String r3 = r9.substring(r3, r4)
            r0.put(r2, r3)
            int r4 = r4 + 1
        L73:
            r2 = 61
            int r2 = r9.indexOf(r2, r4)
            if (r2 != r7) goto L7c
        L7b:
            return r0
        L7c:
            java.lang.String r3 = r9.substring(r4, r2)
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r3 = r3.trim()
            int r2 = r2 + 1
            r8 = r3
            r3 = r2
            r2 = r8
            goto Lc
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kobjects.mime.Decoder.getHeaderElements(java.lang.String):java.util.Hashtable");
    }

    private final String readLine() {
        int i = 0;
        while (true) {
            int read = this.f5632is.read();
            if (read == -1 && i == 0) {
                return null;
            }
            if (read == -1 || read == 10) {
                break;
            } else if (read != 13) {
                char[] cArr = this.buf;
                if (i >= cArr.length) {
                    char[] cArr2 = new char[(cArr.length * 3) / 2];
                    System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                    this.buf = cArr2;
                }
                this.buf[i] = (char) read;
                i++;
            }
        }
        return new String(this.buf, 0, i);
    }

    public String getHeader(String str) {
        return (String) this.header.get(str.toLowerCase());
    }

    public Enumeration getHeaderNames() {
        return this.header.keys();
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0055, code lost:
        r5.consumed = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0058, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean next() {
        /*
            r5 = this;
            boolean r0 = r5.consumed
            if (r0 != 0) goto L8
            r0 = 0
            r5.readContent(r0)
        L8:
            boolean r0 = r5.eof
            r1 = 0
            if (r0 == 0) goto Le
            return r1
        Le:
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r5.header = r0
        L15:
            java.lang.String r0 = r5.readLine()
            if (r0 == 0) goto L55
            java.lang.String r2 = ""
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L24
            goto L55
        L24:
            r2 = 58
            int r2 = r0.indexOf(r2)
            r3 = -1
            if (r2 == r3) goto L49
            java.util.Hashtable r3 = r5.header
            java.lang.String r4 = r0.substring(r1, r2)
            java.lang.String r4 = r4.trim()
            java.lang.String r4 = r4.toLowerCase()
            int r2 = r2 + 1
            java.lang.String r0 = r0.substring(r2)
            java.lang.String r0 = r0.trim()
            r3.put(r4, r0)
            goto L15
        L49:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "colon missing in multipart header line: "
            java.lang.String r0 = p000.outline.m266e(r2, r0)
            r1.<init>(r0)
            throw r1
        L55:
            r5.consumed = r1
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kobjects.mime.Decoder.next():boolean");
    }

    public String readContent() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        readContent(byteArrayOutputStream);
        String str = this.characterEncoding == null ? new String(byteArrayOutputStream.toByteArray()) : new String(byteArrayOutputStream.toByteArray(), this.characterEncoding);
        PrintStream printStream = System.out;
        printStream.println("Field content: '" + str + "'");
        return str;
    }

    public Decoder(InputStream inputStream, String str, String str2) {
        String readLine;
        this.buf = new char[256];
        this.characterEncoding = str2;
        this.f5632is = inputStream;
        this.boundary = outline.m266e("--", str);
        do {
            readLine = readLine();
            if (readLine == null) {
                throw new IOException("Unexpected EOF");
            }
        } while (!readLine.startsWith(this.boundary));
        if (readLine.endsWith("--")) {
            this.eof = true;
            inputStream.close();
        }
        this.consumed = true;
    }

    public void readContent(OutputStream outputStream) {
        String readLine;
        if (!this.consumed) {
            getHeader("Content-Type");
            if ("base64".equals(getHeader("Content-Transfer-Encoding"))) {
                new ByteArrayOutputStream();
                while (true) {
                    readLine = readLine();
                    if (readLine != null) {
                        if (readLine.startsWith(this.boundary)) {
                            break;
                        }
                        Base64.decode(readLine, outputStream);
                    } else {
                        throw new IOException("Unexpected EOF");
                    }
                }
            } else {
                StringBuilder m253r = outline.m253r("\r\n");
                m253r.append(this.boundary);
                String sb = m253r.toString();
                int i = 0;
                while (true) {
                    int read = this.f5632is.read();
                    if (read != -1) {
                        char c = (char) read;
                        if (c == sb.charAt(i)) {
                            i++;
                            if (i == sb.length()) {
                                readLine = readLine();
                                break;
                            }
                        } else {
                            if (i > 0) {
                                for (int i2 = 0; i2 < i; i2++) {
                                    outputStream.write((byte) sb.charAt(i2));
                                }
                                i = c == sb.charAt(0) ? 1 : 0;
                            }
                            if (i == 0) {
                                outputStream.write((byte) read);
                            }
                        }
                    } else {
                        throw new RuntimeException("Unexpected EOF");
                    }
                }
            }
            if (readLine.endsWith("--")) {
                this.eof = true;
            }
            this.consumed = true;
            return;
        }
        throw new RuntimeException("Content already consumed!");
    }
}
