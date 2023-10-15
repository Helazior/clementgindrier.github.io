package org.spongycastle.crypto.params;

import org.spongycastle.crypto.DerivationParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class KDFParameters implements DerivationParameters {

    /* renamed from: iv */
    public byte[] f6022iv;
    public byte[] shared;

    public KDFParameters(byte[] bArr, byte[] bArr2) {
        this.shared = bArr;
        this.f6022iv = bArr2;
    }

    public byte[] getIV() {
        return this.f6022iv;
    }

    public byte[] getSharedSecret() {
        return this.shared;
    }
}
