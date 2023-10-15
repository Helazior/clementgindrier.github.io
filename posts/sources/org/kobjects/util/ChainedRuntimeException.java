package org.kobjects.util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ChainedRuntimeException extends RuntimeException {
    public Exception chain;

    public ChainedRuntimeException() {
    }

    public static ChainedRuntimeException create(Exception exc, String str) {
        try {
            return ((ChainedRuntimeException) Class.forName("org.kobjects.util.ChainedRuntimeExceptionSE").newInstance())._create(exc, str);
        } catch (Exception unused) {
            return new ChainedRuntimeException(exc, str);
        }
    }

    public ChainedRuntimeException _create(Exception exc, String str) {
        throw new RuntimeException("ERR!");
    }

    public Exception getChained() {
        return this.chain;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        super.printStackTrace();
        Exception exc = this.chain;
        if (exc != null) {
            exc.printStackTrace();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ChainedRuntimeException(java.lang.Exception r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            if (r3 != 0) goto L9
            java.lang.String r3 = "rethrown"
        L9:
            r0.append(r3)
            java.lang.String r3 = ": "
            r0.append(r3)
            java.lang.String r3 = r2.toString()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r1.<init>(r3)
            r1.chain = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kobjects.util.ChainedRuntimeException.<init>(java.lang.Exception, java.lang.String):void");
    }
}
