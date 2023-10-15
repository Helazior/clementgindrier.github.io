package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.MD2Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.TigerDigest;
import org.spongycastle.crypto.generators.OpenSSLPBEParametersGenerator;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S1ParametersGenerator;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.DESParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface PBE {
    public static final int MD2 = 5;
    public static final int MD5 = 0;
    public static final int OPENSSL = 3;
    public static final int PKCS12 = 2;
    public static final int PKCS5S1 = 0;
    public static final int PKCS5S2 = 1;
    public static final int RIPEMD160 = 2;
    public static final int SHA1 = 1;
    public static final int SHA256 = 4;
    public static final int TIGER = 3;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Util {
        private static PBEParametersGenerator makePBEGenerator(int i, int i2) {
            if (i == 0) {
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 5) {
                            return new PKCS5S1ParametersGenerator(new MD2Digest());
                        }
                        throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
                    }
                    return new PKCS5S1ParametersGenerator(new SHA1Digest());
                }
                return new PKCS5S1ParametersGenerator(new MD5Digest());
            } else if (i == 1) {
                return new PKCS5S2ParametersGenerator();
            } else {
                if (i == 2) {
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                if (i2 != 3) {
                                    if (i2 != 4) {
                                        if (i2 == 5) {
                                            return new PKCS12ParametersGenerator(new MD2Digest());
                                        }
                                        throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                                    }
                                    return new PKCS12ParametersGenerator(new SHA256Digest());
                                }
                                return new PKCS12ParametersGenerator(new TigerDigest());
                            }
                            return new PKCS12ParametersGenerator(new RIPEMD160Digest());
                        }
                        return new PKCS12ParametersGenerator(new SHA1Digest());
                    }
                    return new PKCS12ParametersGenerator(new MD5Digest());
                }
                return new OpenSSLPBEParametersGenerator();
            }
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec != null && (algorithmParameterSpec instanceof PBEParameterSpec)) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                PBEParametersGenerator makePBEGenerator = makePBEGenerator(bCPBEKey.getType(), bCPBEKey.getDigest());
                byte[] encoded = bCPBEKey.getEncoded();
                if (bCPBEKey.shouldTryWrongPKCS12()) {
                    encoded = new byte[2];
                }
                makePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                CipherParameters generateDerivedMacParameters = makePBEGenerator.generateDerivedMacParameters(bCPBEKey.getKeySize());
                for (int i = 0; i != encoded.length; i++) {
                    encoded[i] = 0;
                }
                return generateDerivedMacParameters;
            }
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }

        public static CipherParameters makePBEParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            CipherParameters generateDerivedParameters;
            if (algorithmParameterSpec != null && (algorithmParameterSpec instanceof PBEParameterSpec)) {
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                PBEParametersGenerator makePBEGenerator = makePBEGenerator(bCPBEKey.getType(), bCPBEKey.getDigest());
                byte[] encoded = bCPBEKey.getEncoded();
                if (bCPBEKey.shouldTryWrongPKCS12()) {
                    encoded = new byte[2];
                }
                makePBEGenerator.init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
                if (bCPBEKey.getIvSize() != 0) {
                    generateDerivedParameters = makePBEGenerator.generateDerivedParameters(bCPBEKey.getKeySize(), bCPBEKey.getIvSize());
                } else {
                    generateDerivedParameters = makePBEGenerator.generateDerivedParameters(bCPBEKey.getKeySize());
                }
                if (str.startsWith("DES")) {
                    if (generateDerivedParameters instanceof ParametersWithIV) {
                        DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) generateDerivedParameters).getParameters()).getKey());
                    } else {
                        DESParameters.setOddParity(((KeyParameter) generateDerivedParameters).getKey());
                    }
                }
                for (int i = 0; i != encoded.length; i++) {
                    encoded[i] = 0;
                }
                return generateDerivedParameters;
            }
            throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
        }

        public static CipherParameters makePBEMacParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3) {
            byte[] PKCS5PasswordToBytes;
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(i, i2);
            if (i == 2) {
                PKCS5PasswordToBytes = PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword());
            } else {
                PKCS5PasswordToBytes = PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
            }
            makePBEGenerator.init(PKCS5PasswordToBytes, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters generateDerivedMacParameters = makePBEGenerator.generateDerivedMacParameters(i3);
            for (int i4 = 0; i4 != PKCS5PasswordToBytes.length; i4++) {
                PKCS5PasswordToBytes[i4] = 0;
            }
            return generateDerivedMacParameters;
        }

        public static CipherParameters makePBEParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3, int i4) {
            byte[] PKCS5PasswordToBytes;
            CipherParameters generateDerivedParameters;
            PBEParametersGenerator makePBEGenerator = makePBEGenerator(i, i2);
            if (i == 2) {
                PKCS5PasswordToBytes = PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword());
            } else {
                PKCS5PasswordToBytes = PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
            }
            makePBEGenerator.init(PKCS5PasswordToBytes, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            if (i4 != 0) {
                generateDerivedParameters = makePBEGenerator.generateDerivedParameters(i3, i4);
            } else {
                generateDerivedParameters = makePBEGenerator.generateDerivedParameters(i3);
            }
            for (int i5 = 0; i5 != PKCS5PasswordToBytes.length; i5++) {
                PKCS5PasswordToBytes[i5] = 0;
            }
            return generateDerivedParameters;
        }
    }
}
