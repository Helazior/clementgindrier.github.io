package org.kobjects.util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Csv {
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ab, code lost:
        r10 = r0.size();
        r1 = new java.lang.String[r10];
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b1, code lost:
        if (r2 >= r10) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b3, code lost:
        r1[r2] = (java.lang.String) r0.elementAt(r2);
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00be, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] decode(java.lang.String r10) {
        /*
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
            int r1 = r10.length()
            r2 = 0
            r3 = 0
        Lb:
            r4 = 32
            if (r3 >= r1) goto L18
            char r5 = r10.charAt(r3)
            if (r5 > r4) goto L18
            int r3 = r3 + 1
            goto Lb
        L18:
            if (r3 < r1) goto L1c
            goto Lab
        L1c:
            char r5 = r10.charAt(r3)
            r6 = 44
            r7 = 34
            if (r5 != r7) goto L99
            int r3 = r3 + 1
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>()
        L2d:
            int r8 = r3 + 1
            char r3 = r10.charAt(r3)
            r9 = 94
            if (r3 != r9) goto L49
            if (r8 >= r1) goto L49
            int r3 = r8 + 1
            char r8 = r10.charAt(r8)
            if (r8 != r9) goto L42
            goto L45
        L42:
            int r8 = r8 + (-64)
            char r8 = (char) r8
        L45:
            r5.append(r8)
            goto L2d
        L49:
            if (r3 != r7) goto L94
            if (r8 == r1) goto L57
            char r9 = r10.charAt(r8)
            if (r9 == r7) goto L54
            goto L57
        L54:
            int r8 = r8 + 1
            goto L94
        L57:
            java.lang.String r3 = r5.toString()
            r0.addElement(r3)
        L5e:
            if (r8 >= r1) goto L69
            char r3 = r10.charAt(r8)
            if (r3 > r4) goto L69
            int r8 = r8 + 1
            goto L5e
        L69:
            if (r8 < r1) goto L6c
            goto Lab
        L6c:
            char r3 = r10.charAt(r8)
            if (r3 != r6) goto L75
            int r3 = r8 + 1
            goto Lb
        L75:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Comma expected at "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = " line: "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10)
            throw r0
        L94:
            r5.append(r3)
            r3 = r8
            goto L2d
        L99:
            int r4 = r10.indexOf(r6, r3)
            r5 = -1
            if (r4 != r5) goto Lbf
            java.lang.String r10 = r10.substring(r3)
            java.lang.String r10 = r10.trim()
            r0.addElement(r10)
        Lab:
            int r10 = r0.size()
            java.lang.String[] r1 = new java.lang.String[r10]
        Lb1:
            if (r2 >= r10) goto Lbe
            java.lang.Object r3 = r0.elementAt(r2)
            java.lang.String r3 = (java.lang.String) r3
            r1[r2] = r3
            int r2 = r2 + 1
            goto Lb1
        Lbe:
            return r1
        Lbf:
            java.lang.String r3 = r10.substring(r3, r4)
            java.lang.String r3 = r3.trim()
            r0.addElement(r3)
            int r3 = r4 + 1
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kobjects.util.Csv.decode(java.lang.String):java.lang.String[]");
    }

    public static String encode(String str, char c) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == c || charAt == '^') {
                stringBuffer.append(charAt);
                stringBuffer.append(charAt);
            } else if (charAt < ' ') {
                stringBuffer.append('^');
                stringBuffer.append((char) (charAt + '@'));
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static String encode(Object[] objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < objArr.length; i++) {
            if (i != 0) {
                stringBuffer.append(',');
            }
            Object obj = objArr[i];
            if (!(obj instanceof Number) && !(obj instanceof Boolean)) {
                stringBuffer.append('\"');
                stringBuffer.append(encode(obj.toString(), '\"'));
                stringBuffer.append('\"');
            } else {
                stringBuffer.append(obj.toString());
            }
        }
        return stringBuffer.toString();
    }
}
