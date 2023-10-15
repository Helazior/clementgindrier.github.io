package org.spongycastle.crypto.tls;

import java.security.SecureRandom;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface TlsSigner {
    byte[] calculateRawSignature(SecureRandom secureRandom, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr);

    Signer createVerifyer(AsymmetricKeyParameter asymmetricKeyParameter);

    boolean isValidPublicKey(AsymmetricKeyParameter asymmetricKeyParameter);
}
