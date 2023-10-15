package org.spongycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DHKEKGenerator implements DerivationFunction {
    private DERObjectIdentifier algorithm;
    private final Digest digest;
    private int keySize;
    private byte[] partyAInfo;

    /* renamed from: z */
    private byte[] f5721z;

    public DHKEKGenerator(Digest digest) {
        this.digest = digest;
    }

    private byte[] integerToBytes(int i) {
        return new byte[]{(byte) (i >> 24), (byte) (i >> 16), (byte) (i >> 8), (byte) i};
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i, int i2) {
        if (bArr.length - i2 >= i) {
            long j = i2;
            int digestSize = this.digest.getDigestSize();
            if (j <= 8589934591L) {
                long j2 = digestSize;
                int i3 = (int) (((j + j2) - 1) / j2);
                byte[] bArr2 = new byte[this.digest.getDigestSize()];
                int i4 = 1;
                for (int i5 = 0; i5 < i3; i5++) {
                    Digest digest = this.digest;
                    byte[] bArr3 = this.f5721z;
                    digest.update(bArr3, 0, bArr3.length);
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.add(this.algorithm);
                    aSN1EncodableVector2.add(new DEROctetString(integerToBytes(i4)));
                    aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
                    byte[] bArr4 = this.partyAInfo;
                    if (bArr4 != null) {
                        aSN1EncodableVector.add(new DERTaggedObject(true, 0, new DEROctetString(bArr4)));
                    }
                    aSN1EncodableVector.add(new DERTaggedObject(true, 2, new DEROctetString(integerToBytes(this.keySize))));
                    try {
                        byte[] encoded = new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.DER);
                        this.digest.update(encoded, 0, encoded.length);
                        this.digest.doFinal(bArr2, 0);
                        if (i2 > digestSize) {
                            System.arraycopy(bArr2, 0, bArr, i, digestSize);
                            i += digestSize;
                            i2 -= digestSize;
                        } else {
                            System.arraycopy(bArr2, 0, bArr, i, i2);
                        }
                        i4++;
                    } catch (IOException e) {
                        StringBuilder m253r = outline.m253r("unable to encode parameter info: ");
                        m253r.append(e.getMessage());
                        throw new IllegalArgumentException(m253r.toString());
                    }
                }
                this.digest.reset();
                return i2;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new DataLengthException("output buffer too small");
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public Digest getDigest() {
        return this.digest;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.algorithm = dHKDFParameters.getAlgorithm();
        this.keySize = dHKDFParameters.getKeySize();
        this.f5721z = dHKDFParameters.getZ();
        this.partyAInfo = dHKDFParameters.getExtraInfo();
    }
}
