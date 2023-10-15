package org.spongycastle.crypto.p013io;

import java.io.OutputStream;
import org.spongycastle.crypto.Digest;

/* renamed from: org.spongycastle.crypto.io.DigestOutputStream */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DigestOutputStream extends OutputStream {
    public Digest digest;

    public DigestOutputStream(Digest digest) {
        this.digest = digest;
    }

    public byte[] getDigest() {
        byte[] bArr = new byte[this.digest.getDigestSize()];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.digest.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }
}
