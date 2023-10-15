package org.spongycastle.crypto.modes.gcm;

import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BasicGCMExponentiator implements GCMExponentiator {

    /* renamed from: x */
    private byte[] f5987x;

    @Override // org.spongycastle.crypto.modes.gcm.GCMExponentiator
    public void exponentiateX(long j, byte[] bArr) {
        byte[] oneAsBytes = GCMUtil.oneAsBytes();
        if (j > 0) {
            byte[] clone = Arrays.clone(this.f5987x);
            do {
                if ((1 & j) != 0) {
                    GCMUtil.multiply(oneAsBytes, clone);
                }
                GCMUtil.multiply(clone, clone);
                j >>>= 1;
            } while (j > 0);
            System.arraycopy(oneAsBytes, 0, bArr, 0, 16);
        }
        System.arraycopy(oneAsBytes, 0, bArr, 0, 16);
    }

    @Override // org.spongycastle.crypto.modes.gcm.GCMExponentiator
    public void init(byte[] bArr) {
        this.f5987x = Arrays.clone(bArr);
    }
}
