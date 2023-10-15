package org.spongycastle.crypto;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AsymmetricCipherKeyPair {
    private CipherParameters privateParam;
    private CipherParameters publicParam;

    public AsymmetricCipherKeyPair(CipherParameters cipherParameters, CipherParameters cipherParameters2) {
        this.publicParam = cipherParameters;
        this.privateParam = cipherParameters2;
    }

    public CipherParameters getPrivate() {
        return this.privateParam;
    }

    public CipherParameters getPublic() {
        return this.publicParam;
    }
}
