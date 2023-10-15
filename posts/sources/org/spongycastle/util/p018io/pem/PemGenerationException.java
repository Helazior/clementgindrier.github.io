package org.spongycastle.util.p018io.pem;

import java.io.IOException;

/* renamed from: org.spongycastle.util.io.pem.PemGenerationException */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PemGenerationException extends IOException {
    private Throwable cause;

    public PemGenerationException(String str, Throwable th) {
        super(str);
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public PemGenerationException(String str) {
        super(str);
    }
}
