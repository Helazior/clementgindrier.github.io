package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Tables1kGCMExponentiator implements GCMExponentiator {
    public byte[][] lookupPowX2 = new byte[64];

    @Override // org.spongycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long j, byte[] bArr) {
        byte[] oneAsBytes = GCMUtil.oneAsBytes();
        int i = 1;
        while (j > 0) {
            if ((1 & j) != 0) {
                GCMUtil.multiply(oneAsBytes, this.lookupPowX2[i]);
            }
            i++;
            j >>>= 1;
        }
        System.arraycopy(oneAsBytes, 0, bArr, 0, 16);
    }

    @Override // org.spongycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] bArr) {
        this.lookupPowX2[0] = GCMUtil.oneAsBytes();
        this.lookupPowX2[1] = Arrays.clone(bArr);
        for (int i = 2; i != 64; i++) {
            byte[] clone = Arrays.clone(this.lookupPowX2[i - 1]);
            GCMUtil.multiply(clone, clone);
            this.lookupPowX2[i] = clone;
        }
    }
}
