package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PKCS12ParametersGenerator extends PBEParametersGenerator {
    public static final int IV_MATERIAL = 2;
    public static final int KEY_MATERIAL = 1;
    public static final int MAC_MATERIAL = 3;
    private Digest digest;

    /* renamed from: u */
    private int f5955u;

    /* renamed from: v */
    private int f5956v;

    public PKCS12ParametersGenerator(Digest digest) {
        this.digest = digest;
        if (digest instanceof ExtendedDigest) {
            this.f5955u = digest.getDigestSize();
            this.f5956v = ((ExtendedDigest) digest).getByteLength();
            return;
        }
        StringBuilder m253r = outline.m253r("Digest ");
        m253r.append(digest.getAlgorithmName());
        m253r.append(" unsupported");
        throw new IllegalArgumentException(m253r.toString());
    }

    private void adjust(byte[] bArr, int i, byte[] bArr2) {
        int i2 = (bArr2[bArr2.length - 1] & 255) + (bArr[(bArr2.length + i) - 1] & 255) + 1;
        bArr[(bArr2.length + i) - 1] = (byte) i2;
        int i3 = i2 >>> 8;
        for (int length = bArr2.length - 2; length >= 0; length--) {
            int i4 = i + length;
            int i5 = (bArr2[length] & 255) + (bArr[i4] & 255) + i3;
            bArr[i4] = (byte) i5;
            i3 = i5 >>> 8;
        }
    }

    private byte[] generateDerivedKey(int i, int i2) {
        byte[] bArr;
        byte[] bArr2;
        int i3 = this.f5956v;
        byte[] bArr3 = new byte[i3];
        byte[] bArr4 = new byte[i2];
        int i4 = 0;
        for (int i5 = 0; i5 != i3; i5++) {
            bArr3[i5] = (byte) i;
        }
        byte[] bArr5 = this.salt;
        if (bArr5 == null || bArr5.length == 0) {
            bArr = new byte[0];
        } else {
            int i6 = this.f5956v;
            int length = (((bArr5.length + i6) - 1) / i6) * i6;
            bArr = new byte[length];
            for (int i7 = 0; i7 != length; i7++) {
                byte[] bArr6 = this.salt;
                bArr[i7] = bArr6[i7 % bArr6.length];
            }
        }
        byte[] bArr7 = this.password;
        if (bArr7 == null || bArr7.length == 0) {
            bArr2 = new byte[0];
        } else {
            int i8 = this.f5956v;
            int length2 = (((bArr7.length + i8) - 1) / i8) * i8;
            bArr2 = new byte[length2];
            for (int i9 = 0; i9 != length2; i9++) {
                byte[] bArr8 = this.password;
                bArr2[i9] = bArr8[i9 % bArr8.length];
            }
        }
        int length3 = bArr.length + bArr2.length;
        byte[] bArr9 = new byte[length3];
        System.arraycopy(bArr, 0, bArr9, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr9, bArr.length, bArr2.length);
        int i10 = this.f5956v;
        byte[] bArr10 = new byte[i10];
        int i11 = this.f5955u;
        int i12 = ((i2 + i11) - 1) / i11;
        int i13 = 1;
        while (i13 <= i12) {
            int i14 = this.f5955u;
            byte[] bArr11 = new byte[i14];
            this.digest.update(bArr3, i4, i3);
            this.digest.update(bArr9, i4, length3);
            this.digest.doFinal(bArr11, i4);
            for (int i15 = 1; i15 < this.iterationCount; i15++) {
                this.digest.update(bArr11, i4, i14);
                this.digest.doFinal(bArr11, i4);
            }
            for (int i16 = 0; i16 != i10; i16++) {
                bArr10[i16] = bArr11[i16 % i14];
            }
            int i17 = 0;
            while (true) {
                int i18 = this.f5956v;
                if (i17 == length3 / i18) {
                    break;
                }
                adjust(bArr9, i18 * i17, bArr10);
                i17++;
            }
            if (i13 == i12) {
                int i19 = i13 - 1;
                int i20 = this.f5955u;
                System.arraycopy(bArr11, 0, bArr4, i19 * i20, i2 - (i19 * i20));
            } else {
                System.arraycopy(bArr11, 0, bArr4, (i13 - 1) * this.f5955u, i14);
            }
            i13++;
            i4 = 0;
        }
        return bArr4;
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(generateDerivedKey(3, i2), 0, i2);
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(generateDerivedKey(1, i2), 0, i2);
    }

    @Override // org.spongycastle.crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] generateDerivedKey = generateDerivedKey(1, i3);
        return new ParametersWithIV(new KeyParameter(generateDerivedKey, 0, i3), generateDerivedKey(2, i4), 0, i4);
    }
}
