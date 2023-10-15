package org.spongycastle.crypto.tls;

import java.security.SecureRandom;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.RSABlindedEngine;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.signers.GenericSigner;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsRSASigner implements TlsSigner {
    @Override // org.spongycastle.crypto.tls.TlsSigner
    public byte[] calculateRawSignature(SecureRandom secureRandom, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        GenericSigner genericSigner = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), new NullDigest());
        genericSigner.init(true, new ParametersWithRandom(asymmetricKeyParameter, secureRandom));
        genericSigner.update(bArr, 0, bArr.length);
        return genericSigner.generateSignature();
    }

    @Override // org.spongycastle.crypto.tls.TlsSigner
    public Signer createVerifyer(AsymmetricKeyParameter asymmetricKeyParameter) {
        GenericSigner genericSigner = new GenericSigner(new PKCS1Encoding(new RSABlindedEngine()), new CombinedHash());
        genericSigner.init(false, asymmetricKeyParameter);
        return genericSigner;
    }

    @Override // org.spongycastle.crypto.tls.TlsSigner
    public boolean isValidPublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        return (asymmetricKeyParameter instanceof RSAKeyParameters) && !asymmetricKeyParameter.isPrivate();
    }
}
