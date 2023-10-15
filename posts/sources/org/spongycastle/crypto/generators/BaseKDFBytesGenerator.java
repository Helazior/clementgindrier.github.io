package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.ISO18033KDFParameters;
import org.spongycastle.crypto.params.KDFParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BaseKDFBytesGenerator implements DerivationFunction {
    private int counterStart;
    private Digest digest;

    /* renamed from: iv */
    private byte[] f5950iv;
    private byte[] shared;

    public BaseKDFBytesGenerator(int i, Digest digest) {
        this.counterStart = i;
        this.digest = digest;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        if (bArr.length - i2 >= i) {
            long j = i2;
            int digestSize = this.digest.getDigestSize();
            if (j <= 8589934591L) {
                long j2 = digestSize;
                int i3 = (int) (((j + j2) - 1) / j2);
                byte[] bArr2 = new byte[this.digest.getDigestSize()];
                int i4 = this.counterStart;
                for (int i5 = 0; i5 < i3; i5++) {
                    Digest digest = this.digest;
                    byte[] bArr3 = this.shared;
                    digest.update(bArr3, 0, bArr3.length);
                    this.digest.update((byte) (i4 >> 24));
                    this.digest.update((byte) (i4 >> 16));
                    this.digest.update((byte) (i4 >> 8));
                    this.digest.update((byte) i4);
                    byte[] bArr4 = this.f5950iv;
                    if (bArr4 != null) {
                        this.digest.update(bArr4, 0, bArr4.length);
                    }
                    this.digest.doFinal(bArr2, 0);
                    if (i2 > digestSize) {
                        System.arraycopy(bArr2, 0, bArr, i, digestSize);
                        i += digestSize;
                        i2 -= digestSize;
                    } else {
                        System.arraycopy(bArr2, 0, bArr, i, i2);
                    }
                    i4++;
                }
                this.digest.reset();
                return i2;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new DataLengthException("output buffer too small");
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFParameters) {
            KDFParameters kDFParameters = (KDFParameters) derivationParameters;
            this.shared = kDFParameters.getSharedSecret();
            this.f5950iv = kDFParameters.getIV();
        } else if (derivationParameters instanceof ISO18033KDFParameters) {
            this.shared = ((ISO18033KDFParameters) derivationParameters).getSeed();
            this.f5950iv = null;
        } else {
            throw new IllegalArgumentException("KDF parameters required for KDF2Generator");
        }
    }
}
