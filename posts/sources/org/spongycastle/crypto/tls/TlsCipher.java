package org.spongycastle.crypto.tls;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface TlsCipher {
    byte[] decodeCiphertext(short s, byte[] bArr, int i, int i2);

    byte[] encodePlaintext(short s, byte[] bArr, int i, int i2);
}
