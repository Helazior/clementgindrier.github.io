package org.spongycastle.ocsp;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class OCSPException extends Exception {

    /* renamed from: e */
    public Exception f6168e;

    public OCSPException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f6168e;
    }

    public Exception getUnderlyingException() {
        return this.f6168e;
    }

    public OCSPException(String str, Exception exc) {
        super(str);
        this.f6168e = exc;
    }
}
