package org.spongycastle.crypto.tls;

import java.security.SecureRandom;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Signer;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.DSADigestSigner;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class TlsDSASigner implements TlsSigner {
    @Override // org.spongycastle.crypto.tls.TlsSigner
    public byte[] calculateRawSignature(SecureRandom secureRandom, AsymmetricKeyParameter asymmetricKeyParameter, byte[] bArr) {
        DSADigestSigner dSADigestSigner = new DSADigestSigner(createDSAImpl(), new NullDigest());
        dSADigestSigner.init(true, new ParametersWithRandom(asymmetricKeyParameter, secureRandom));
        dSADigestSigner.update(bArr, 16, 20);
        return dSADigestSigner.generateSignature();
    }

    public abstract DSA createDSAImpl();

    @Override // org.spongycastle.crypto.tls.TlsSigner
    public Signer createVerifyer(AsymmetricKeyParameter asymmetricKeyParameter) {
        DSADigestSigner dSADigestSigner = new DSADigestSigner(createDSAImpl(), new SHA1Digest());
        dSADigestSigner.init(false, asymmetricKeyParameter);
        return dSADigestSigner;
    }
}
