package org.spongycastle.util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class StreamParsingException extends Exception {

    /* renamed from: _e */
    public Throwable f6171_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f6171_e = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f6171_e;
    }
}
