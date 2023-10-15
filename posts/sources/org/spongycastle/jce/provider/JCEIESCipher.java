package org.spongycastle.jce.provider;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHPrivateKey;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.IESParameters;
import org.spongycastle.jcajce.provider.asymmetric.p016ec.ECUtil;
import org.spongycastle.jce.interfaces.ECPrivateKey;
import org.spongycastle.jce.interfaces.ECPublicKey;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class JCEIESCipher extends CipherSpi {
    private IESEngine cipher;
    private int state = -1;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private AlgorithmParameters engineParam = null;
    private IESParameterSpec engineParams = null;
    private Class[] availableSpecs = {IESParameterSpec.class};

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class BrokenECIES extends JCEIESCipher {
        public BrokenECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new BrokenKDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class BrokenIES extends JCEIESCipher {
        public BrokenIES() {
            super(new IESEngine(new DHBasicAgreement(), new BrokenKDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ECIES extends JCEIESCipher {
        public ECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class IES extends JCEIESCipher {
        public IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public JCEIESCipher(IESEngine iESEngine) {
        this.cipher = iESEngine;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        if (i2 != 0) {
            this.buffer.write(bArr, i, i2);
        }
        try {
            byte[] byteArray = this.buffer.toByteArray();
            this.buffer.reset();
            return this.cipher.processBlock(byteArray, 0, byteArray.length);
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        if (key instanceof IESKey) {
            IESKey iESKey = (IESKey) key;
            if (iESKey.getPrivate() instanceof DHPrivateKey) {
                return ((DHPrivateKey) iESKey.getPrivate()).getX().bitLength();
            }
            if (iESKey.getPrivate() instanceof ECPrivateKey) {
                return ((ECPrivateKey) iESKey.getPrivate()).getD().bitLength();
            }
            throw new IllegalArgumentException("not an IE key!");
        }
        throw new IllegalArgumentException("must be passed IE key");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        int i2 = this.state;
        if (i2 == 1 || i2 == 3) {
            return this.buffer.size() + i + 20;
        }
        if (i2 != 2 && i2 != 4) {
            throw new IllegalStateException("cipher not initialised");
        }
        return (this.buffer.size() + i) - 20;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        if (this.engineParam == null && this.engineParams != null) {
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("IES", BouncyCastleProvider.PROVIDER_NAME);
                this.engineParam = algorithmParameters;
                algorithmParameters.init(this.engineParams);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParam;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        AsymmetricKeyParameter generatePublicKeyParameter;
        AsymmetricKeyParameter generatePrivateKeyParameter;
        if (key instanceof IESKey) {
            if (algorithmParameterSpec == null && (i == 1 || i == 3)) {
                byte[] bArr = new byte[16];
                byte[] bArr2 = new byte[16];
                if (secureRandom == null) {
                    secureRandom = new SecureRandom();
                }
                secureRandom.nextBytes(bArr);
                secureRandom.nextBytes(bArr2);
                algorithmParameterSpec = new IESParameterSpec(bArr, bArr2, 128);
            } else if (!(algorithmParameterSpec instanceof IESParameterSpec)) {
                throw new InvalidAlgorithmParameterException("must be passed IES parameters");
            }
            IESKey iESKey = (IESKey) key;
            if (iESKey.getPublic() instanceof ECPublicKey) {
                generatePublicKeyParameter = ECUtil.generatePublicKeyParameter(iESKey.getPublic());
                generatePrivateKeyParameter = ECUtil.generatePrivateKeyParameter(iESKey.getPrivate());
            } else {
                generatePublicKeyParameter = DHUtil.generatePublicKeyParameter(iESKey.getPublic());
                generatePrivateKeyParameter = DHUtil.generatePrivateKeyParameter(iESKey.getPrivate());
            }
            IESParameterSpec iESParameterSpec = (IESParameterSpec) algorithmParameterSpec;
            this.engineParams = iESParameterSpec;
            IESParameters iESParameters = new IESParameters(iESParameterSpec.getDerivationV(), this.engineParams.getEncodingV(), this.engineParams.getMacKeySize());
            this.state = i;
            this.buffer.reset();
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            System.out.println("eeek!");
                            return;
                        }
                    }
                }
                this.cipher.init(false, generatePrivateKeyParameter, generatePublicKeyParameter, iESParameters);
                return;
            }
            this.cipher.init(true, generatePrivateKeyParameter, generatePublicKeyParameter, iESParameters);
            return;
        }
        throw new InvalidKeyException("must be passed IES key");
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) {
        throw new IllegalArgumentException(outline.m266e("can't support mode ", str));
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) {
        throw new NoSuchPaddingException(outline.m266e(str, " unavailable with RSA."));
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.buffer.write(bArr, i, i2);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.buffer.write(bArr, i, i2);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 != 0) {
            this.buffer.write(bArr, i, i2);
        }
        try {
            byte[] byteArray = this.buffer.toByteArray();
            this.buffer.reset();
            byte[] processBlock = this.cipher.processBlock(byteArray, 0, byteArray.length);
            System.arraycopy(processBlock, 0, bArr2, i3, processBlock.length);
            return processBlock.length;
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException(e.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i2 = 0;
            while (true) {
                Class[] clsArr = this.availableSpecs;
                if (i2 == clsArr.length) {
                    break;
                }
                try {
                    algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i2]);
                    break;
                } catch (Exception unused) {
                    i2++;
                }
            }
            if (algorithmParameterSpec == null) {
                StringBuilder m253r = outline.m253r("can't handle parameter ");
                m253r.append(algorithmParameters.toString());
                throw new InvalidAlgorithmParameterException(m253r.toString());
            }
        }
        this.engineParam = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) {
        if (i == 1 || i == 3) {
            try {
                engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
                return;
            } catch (InvalidAlgorithmParameterException unused) {
            }
        }
        throw new IllegalArgumentException("can't handle null parameter spec in IES");
    }
}
