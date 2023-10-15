package org.spongycastle.crypto.params;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.math.ntru.polynomial.Polynomial;
import org.spongycastle.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.math.ntru.polynomial.SparseTernaryPolynomial;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUEncryptionPrivateKeyParameters extends NTRUEncryptionKeyParameters {

    /* renamed from: fp */
    public IntegerPolynomial f6037fp;

    /* renamed from: h */
    public IntegerPolynomial f6038h;

    /* renamed from: t */
    public Polynomial f6039t;

    public NTRUEncryptionPrivateKeyParameters(IntegerPolynomial integerPolynomial, Polynomial polynomial, IntegerPolynomial integerPolynomial2, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(true, nTRUEncryptionParameters);
        this.f6038h = integerPolynomial;
        this.f6039t = polynomial;
        this.f6037fp = integerPolynomial2;
    }

    private void init() {
        if (this.params.fastFp) {
            IntegerPolynomial integerPolynomial = new IntegerPolynomial(this.params.f6030N);
            this.f6037fp = integerPolynomial;
            integerPolynomial.coeffs[0] = 1;
            return;
        }
        this.f6037fp = this.f6039t.toIntegerPolynomial().invertF3();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NTRUEncryptionPrivateKeyParameters)) {
            NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters = (NTRUEncryptionPrivateKeyParameters) obj;
            NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
            if (nTRUEncryptionParameters == null) {
                if (nTRUEncryptionPrivateKeyParameters.params != null) {
                    return false;
                }
            } else if (!nTRUEncryptionParameters.equals(nTRUEncryptionPrivateKeyParameters.params)) {
                return false;
            }
            Polynomial polynomial = this.f6039t;
            if (polynomial == null) {
                if (nTRUEncryptionPrivateKeyParameters.f6039t != null) {
                    return false;
                }
            } else if (!polynomial.equals(nTRUEncryptionPrivateKeyParameters.f6039t)) {
                return false;
            }
            return this.f6038h.equals(nTRUEncryptionPrivateKeyParameters.f6038h);
        }
        return false;
    }

    public byte[] getEncoded() {
        byte[] binary3Tight;
        byte[] binary = this.f6038h.toBinary(this.params.f6036q);
        Polynomial polynomial = this.f6039t;
        if (polynomial instanceof ProductFormPolynomial) {
            binary3Tight = ((ProductFormPolynomial) polynomial).toBinary();
        } else {
            binary3Tight = polynomial.toIntegerPolynomial().toBinary3Tight();
        }
        byte[] bArr = new byte[binary.length + binary3Tight.length];
        System.arraycopy(binary, 0, bArr, 0, binary.length);
        System.arraycopy(binary3Tight, 0, bArr, binary.length, binary3Tight.length);
        return bArr;
    }

    public int hashCode() {
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        int hashCode = ((nTRUEncryptionParameters == null ? 0 : nTRUEncryptionParameters.hashCode()) + 31) * 31;
        Polynomial polynomial = this.f6039t;
        int hashCode2 = (hashCode + (polynomial == null ? 0 : polynomial.hashCode())) * 31;
        IntegerPolynomial integerPolynomial = this.f6038h;
        return hashCode2 + (integerPolynomial != null ? integerPolynomial.hashCode() : 0);
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(getEncoded());
    }

    public NTRUEncryptionPrivateKeyParameters(byte[] bArr, NTRUEncryptionParameters nTRUEncryptionParameters) {
        this(new ByteArrayInputStream(bArr), nTRUEncryptionParameters);
    }

    public NTRUEncryptionPrivateKeyParameters(InputStream inputStream, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(true, nTRUEncryptionParameters);
        if (nTRUEncryptionParameters.polyType == 1) {
            int i = nTRUEncryptionParameters.f6030N;
            int i2 = nTRUEncryptionParameters.df1;
            int i3 = nTRUEncryptionParameters.df2;
            int i4 = nTRUEncryptionParameters.df3;
            int i5 = nTRUEncryptionParameters.fastFp ? i4 : i4 - 1;
            this.f6038h = IntegerPolynomial.fromBinary(inputStream, i, nTRUEncryptionParameters.f6036q);
            this.f6039t = ProductFormPolynomial.fromBinary(inputStream, i, i2, i3, i4, i5);
        } else {
            this.f6038h = IntegerPolynomial.fromBinary(inputStream, nTRUEncryptionParameters.f6030N, nTRUEncryptionParameters.f6036q);
            IntegerPolynomial fromBinary3Tight = IntegerPolynomial.fromBinary3Tight(inputStream, nTRUEncryptionParameters.f6030N);
            this.f6039t = nTRUEncryptionParameters.sparse ? new SparseTernaryPolynomial(fromBinary3Tight) : new DenseTernaryPolynomial(fromBinary3Tight);
        }
        init();
    }
}
