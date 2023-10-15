package org.spongycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.params.KDFParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ECDHKEKGenerator implements DerivationFunction {
    private ASN1ObjectIdentifier algorithm;
    private DerivationFunction kdf;
    private int keySize;

    /* renamed from: z */
    private byte[] f5722z;

    public ECDHKEKGenerator(Digest digest) {
        this.kdf = new KDF2BytesGenerator(digest);
    }

    private byte[] integerToBytes(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new AlgorithmIdentifier(this.algorithm, (ASN1Encodable) new DERNull()));
        aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(integerToBytes(this.keySize))));
        try {
            this.kdf.init(new KDFParameters(this.f5722z, new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER)));
            return this.kdf.generateBytes(bArr, i, i2);
        } catch (IOException e) {
            StringBuilder m253r = outline.m253r("unable to initialise kdf: ");
            m253r.append(e.getMessage());
            throw new IllegalArgumentException(m253r.toString());
        }
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public Digest getDigest() {
        return this.kdf.getDigest();
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.keySize = dHKDFParameters.getKeySize();
        this.f5722z = dHKDFParameters.getZ();
    }
}
