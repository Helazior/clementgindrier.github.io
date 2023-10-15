package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PBESecretKeyFactory extends BaseSecretKeyFactory implements PBE {
    private int digest;
    private boolean forCipher;
    private int ivSize;
    private int keySize;
    private int scheme;

    public PBESecretKeyFactory(String str, DERObjectIdentifier dERObjectIdentifier, boolean z, int i, int i2, int i3, int i4) {
        super(str, dERObjectIdentifier);
        this.forCipher = z;
        this.scheme = i;
        this.digest = i2;
        this.keySize = i3;
        this.ivSize = i4;
    }

    @Override // org.spongycastle.jcajce.provider.symmetric.util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
    public SecretKey engineGenerateSecret(KeySpec keySpec) {
        CipherParameters makePBEMacParameters;
        if (keySpec instanceof PBEKeySpec) {
            PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
            if (pBEKeySpec.getSalt() == null) {
                return new BCPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, pBEKeySpec, null);
            }
            if (this.forCipher) {
                makePBEMacParameters = PBE.Util.makePBEParameters(pBEKeySpec, this.scheme, this.digest, this.keySize, this.ivSize);
            } else {
                makePBEMacParameters = PBE.Util.makePBEMacParameters(pBEKeySpec, this.scheme, this.digest, this.keySize);
            }
            return new BCPBEKey(this.algName, this.algOid, this.scheme, this.digest, this.keySize, this.ivSize, pBEKeySpec, makePBEMacParameters);
        }
        throw new InvalidKeySpecException("Invalid KeySpec");
    }
}
