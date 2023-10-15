package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SSL3Mac implements Mac {
    private Digest digest;
    private byte[] ipad;
    private byte[] opad;
    private byte[] secret;
    private static final byte IPAD = 54;
    public static final byte[] MD5_IPAD = genPad(IPAD, 48);
    private static final byte OPAD = 92;
    public static final byte[] MD5_OPAD = genPad(OPAD, 48);
    public static final byte[] SHA1_IPAD = genPad(IPAD, 40);
    public static final byte[] SHA1_OPAD = genPad(OPAD, 40);

    public SSL3Mac(Digest digest) {
        this.digest = digest;
        if (digest.getDigestSize() == 20) {
            this.ipad = SHA1_IPAD;
            this.opad = SHA1_OPAD;
            return;
        }
        this.ipad = MD5_IPAD;
        this.opad = MD5_OPAD;
    }

    private static byte[] genPad(byte b, int i) {
        byte[] bArr = new byte[i];
        Arrays.fill(bArr, b);
        return bArr;
    }

    @Override // org.spongycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) {
        int digestSize = this.digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize];
        this.digest.doFinal(bArr2, 0);
        Digest digest = this.digest;
        byte[] bArr3 = this.secret;
        digest.update(bArr3, 0, bArr3.length);
        Digest digest2 = this.digest;
        byte[] bArr4 = this.opad;
        digest2.update(bArr4, 0, bArr4.length);
        this.digest.update(bArr2, 0, digestSize);
        int doFinal = this.digest.doFinal(bArr, i);
        reset();
        return doFinal;
    }

    @Override // org.spongycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.digest.getAlgorithmName() + "/SSL3MAC";
    }

    @Override // org.spongycastle.crypto.Mac
    public int getMacSize() {
        return this.digest.getDigestSize();
    }

    public Digest getUnderlyingDigest() {
        return this.digest;
    }

    @Override // org.spongycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        this.secret = Arrays.clone(((KeyParameter) cipherParameters).getKey());
        reset();
    }

    @Override // org.spongycastle.crypto.Mac
    public void reset() {
        this.digest.reset();
        Digest digest = this.digest;
        byte[] bArr = this.secret;
        digest.update(bArr, 0, bArr.length);
        Digest digest2 = this.digest;
        byte[] bArr2 = this.ipad;
        digest2.update(bArr2, 0, bArr2.length);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte b) {
        this.digest.update(b);
    }

    @Override // org.spongycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) {
        this.digest.update(bArr, i, i2);
    }
}
