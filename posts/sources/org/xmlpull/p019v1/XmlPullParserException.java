package org.xmlpull.p019v1;

import java.io.PrintStream;

/* renamed from: org.xmlpull.v1.XmlPullParserException */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class XmlPullParserException extends Exception {
    public int column;
    public Throwable detail;
    public int row;

    public XmlPullParserException(String str) {
        super(str);
        this.row = -1;
        this.column = -1;
    }

    public int getColumnNumber() {
        return this.column;
    }

    public Throwable getDetail() {
        return this.detail;
    }

    public int getLineNumber() {
        return this.row;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.detail == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            printStream.println(super.getMessage() + "; nested exception is:");
            this.detail.printStackTrace();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public XmlPullParserException(java.lang.String r4, org.xmlpull.p019v1.XmlPullParser r5, java.lang.Throwable r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = ""
            if (r4 != 0) goto Lb
            r4 = r1
            goto L11
        Lb:
            java.lang.String r2 = " "
            java.lang.String r4 = p000.outline.m266e(r4, r2)
        L11:
            r0.append(r4)
            if (r5 != 0) goto L18
            r4 = r1
            goto L24
        L18:
            java.lang.String r4 = "(position:"
            java.lang.StringBuilder r4 = p000.outline.m253r(r4)
            java.lang.String r2 = ") "
            java.lang.String r4 = p000.outline.m255p(r5, r4, r2)
        L24:
            r0.append(r4)
            if (r6 != 0) goto L2a
            goto L3b
        L2a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = "caused by: "
            r4.append(r1)
            r4.append(r6)
            java.lang.String r1 = r4.toString()
        L3b:
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3.<init>(r4)
            r4 = -1
            r3.row = r4
            r3.column = r4
            if (r5 == 0) goto L58
            int r4 = r5.getLineNumber()
            r3.row = r4
            int r4 = r5.getColumnNumber()
            r3.column = r4
        L58:
            r3.detail = r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.p019v1.XmlPullParserException.<init>(java.lang.String, org.xmlpull.v1.XmlPullParser, java.lang.Throwable):void");
    }
}
