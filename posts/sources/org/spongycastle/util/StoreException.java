package org.spongycastle.util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class StoreException extends RuntimeException {

    /* renamed from: _e */
    private Throwable f6170_e;

    public StoreException(String str, Throwable th) {
        super(str);
        this.f6170_e = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f6170_e;
    }
}
