package org.spongycastle.crypto.tls;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1928023487348344086L;

    /* renamed from: e */
    public Throwable f6072e;

    public TlsRuntimeException(String str, Throwable th) {
        super(str);
        this.f6072e = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f6072e;
    }

    public TlsRuntimeException(String str) {
        super(str);
    }
}
