package org.spongycastle.crypto.tls;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SecurityParameters {
    public byte[] clientRandom = null;
    public byte[] serverRandom = null;
    public byte[] masterSecret = null;

    public byte[] getClientRandom() {
        return this.clientRandom;
    }

    public byte[] getMasterSecret() {
        return this.masterSecret;
    }

    public byte[] getServerRandom() {
        return this.serverRandom;
    }
}
