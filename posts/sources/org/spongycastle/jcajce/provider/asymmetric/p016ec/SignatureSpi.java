package org.spongycastle.jcajce.provider.asymmetric.p016ec;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.ECPublicKey;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERInteger;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.NullDigest;
import org.spongycastle.crypto.digests.RIPEMD160Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.signers.ECDSASigner;
import org.spongycastle.crypto.signers.ECNRSigner;
import org.spongycastle.jcajce.provider.asymmetric.util.DSABase;
import org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder;
import org.spongycastle.jce.interfaces.ECKey;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SignatureSpi extends DSABase {

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$CVCDSAEncoder */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class CVCDSAEncoder implements DSAEncoder {
        private CVCDSAEncoder() {
        }

        private byte[] makeUnsigned(BigInteger bigInteger) {
            byte[] byteArray = bigInteger.toByteArray();
            if (byteArray[0] == 0) {
                int length = byteArray.length - 1;
                byte[] bArr = new byte[length];
                System.arraycopy(byteArray, 1, bArr, 0, length);
                return bArr;
            }
            return byteArray;
        }

        @Override // org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder
        public BigInteger[] decode(byte[] bArr) {
            int length = bArr.length / 2;
            byte[] bArr2 = new byte[length];
            int length2 = bArr.length / 2;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            System.arraycopy(bArr, length, bArr3, 0, length2);
            return new BigInteger[]{new BigInteger(1, bArr2), new BigInteger(1, bArr3)};
        }

        @Override // org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder
        public byte[] encode(BigInteger bigInteger, BigInteger bigInteger2) {
            byte[] bArr;
            byte[] makeUnsigned = makeUnsigned(bigInteger);
            byte[] makeUnsigned2 = makeUnsigned(bigInteger2);
            if (makeUnsigned.length > makeUnsigned2.length) {
                bArr = new byte[makeUnsigned.length * 2];
            } else {
                bArr = new byte[makeUnsigned2.length * 2];
            }
            System.arraycopy(makeUnsigned, 0, bArr, (bArr.length / 2) - makeUnsigned.length, makeUnsigned.length);
            System.arraycopy(makeUnsigned2, 0, bArr, bArr.length - makeUnsigned2.length, makeUnsigned2.length);
            return bArr;
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$StdDSAEncoder */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class StdDSAEncoder implements DSAEncoder {
        private StdDSAEncoder() {
        }

        @Override // org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder
        public BigInteger[] decode(byte[] bArr) {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) ASN1Primitive.fromByteArray(bArr);
            return new BigInteger[]{((DERInteger) aSN1Sequence.getObjectAt(0)).getValue(), ((DERInteger) aSN1Sequence.getObjectAt(1)).getValue()};
        }

        @Override // org.spongycastle.jcajce.provider.asymmetric.util.DSAEncoder
        public byte[] encode(BigInteger bigInteger, BigInteger bigInteger2) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.add(new DERInteger(bigInteger));
            aSN1EncodableVector.add(new DERInteger(bigInteger2));
            return new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecCVCDSA extends SignatureSpi {
        public ecCVCDSA() {
            super(new SHA1Digest(), new ECDSASigner(), new CVCDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA224 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecCVCDSA224 extends SignatureSpi {
        public ecCVCDSA224() {
            super(new SHA224Digest(), new ECDSASigner(), new CVCDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecCVCDSA256 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecCVCDSA256 extends SignatureSpi {
        public ecCVCDSA256() {
            super(new SHA256Digest(), new ECDSASigner(), new CVCDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecDSA extends SignatureSpi {
        public ecDSA() {
            super(new SHA1Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA224 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecDSA224 extends SignatureSpi {
        public ecDSA224() {
            super(new SHA224Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA256 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecDSA256 extends SignatureSpi {
        public ecDSA256() {
            super(new SHA256Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA384 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecDSA384 extends SignatureSpi {
        public ecDSA384() {
            super(new SHA384Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSA512 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecDSA512 extends SignatureSpi {
        public ecDSA512() {
            super(new SHA512Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSARipeMD160 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecDSARipeMD160 extends SignatureSpi {
        public ecDSARipeMD160() {
            super(new RIPEMD160Digest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecDSAnone */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecDSAnone extends SignatureSpi {
        public ecDSAnone() {
            super(new NullDigest(), new ECDSASigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecNR extends SignatureSpi {
        public ecNR() {
            super(new SHA1Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR224 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecNR224 extends SignatureSpi {
        public ecNR224() {
            super(new SHA224Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR256 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecNR256 extends SignatureSpi {
        public ecNR256() {
            super(new SHA256Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR384 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecNR384 extends SignatureSpi {
        public ecNR384() {
            super(new SHA384Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    /* renamed from: org.spongycastle.jcajce.provider.asymmetric.ec.SignatureSpi$ecNR512 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ecNR512 extends SignatureSpi {
        public ecNR512() {
            super(new SHA512Digest(), new ECNRSigner(), new StdDSAEncoder());
        }
    }

    public SignatureSpi(Digest digest, DSA dsa, DSAEncoder dSAEncoder) {
        super(digest, dsa, dSAEncoder);
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) {
        if (privateKey instanceof ECKey) {
            AsymmetricKeyParameter generatePrivateKeyParameter = ECUtil.generatePrivateKeyParameter(privateKey);
            this.digest.reset();
            SecureRandom secureRandom = ((java.security.SignatureSpi) this).appRandom;
            if (secureRandom != null) {
                this.signer.init(true, new ParametersWithRandom(generatePrivateKeyParameter, secureRandom));
                return;
            } else {
                this.signer.init(true, generatePrivateKeyParameter);
                return;
            }
        }
        throw new InvalidKeyException("can't recognise key type in ECDSA based signer");
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) {
        AsymmetricKeyParameter generatePublicKeyParameter;
        if (publicKey instanceof ECPublicKey) {
            generatePublicKeyParameter = ECUtil.generatePublicKeyParameter(publicKey);
        } else {
            try {
                PublicKey publicKey2 = BouncyCastleProvider.getPublicKey(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
                if (publicKey2 instanceof ECPublicKey) {
                    generatePublicKeyParameter = ECUtil.generatePublicKeyParameter(publicKey2);
                } else {
                    throw new InvalidKeyException("can't recognise key type in ECDSA based signer");
                }
            } catch (Exception unused) {
                throw new InvalidKeyException("can't recognise key type in ECDSA based signer");
            }
        }
        this.digest.reset();
        this.signer.init(false, generatePublicKeyParameter);
    }
}
