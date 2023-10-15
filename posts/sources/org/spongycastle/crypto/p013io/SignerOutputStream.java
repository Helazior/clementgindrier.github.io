package org.spongycastle.crypto.p013io;

import java.io.OutputStream;
import org.spongycastle.crypto.Signer;

/* renamed from: org.spongycastle.crypto.io.SignerOutputStream */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SignerOutputStream extends OutputStream {
    public Signer signer;

    public SignerOutputStream(Signer signer) {
        this.signer = signer;
    }

    public Signer getSigner() {
        return this.signer;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.signer.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.signer.update(bArr, i, i2);
    }
}
