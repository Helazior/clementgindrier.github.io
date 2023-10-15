package org.spongycastle.crypto.params;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.math.ntru.polynomial.IntegerPolynomial;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUEncryptionPublicKeyParameters extends NTRUEncryptionKeyParameters {

    /* renamed from: h */
    public IntegerPolynomial f6040h;

    public NTRUEncryptionPublicKeyParameters(IntegerPolynomial integerPolynomial, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(false, nTRUEncryptionParameters);
        this.f6040h = integerPolynomial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NTRUEncryptionPublicKeyParameters)) {
            NTRUEncryptionPublicKeyParameters nTRUEncryptionPublicKeyParameters = (NTRUEncryptionPublicKeyParameters) obj;
            IntegerPolynomial integerPolynomial = this.f6040h;
            if (integerPolynomial == null) {
                if (nTRUEncryptionPublicKeyParameters.f6040h != null) {
                    return false;
                }
            } else if (!integerPolynomial.equals(nTRUEncryptionPublicKeyParameters.f6040h)) {
                return false;
            }
            NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
            if (nTRUEncryptionParameters == null) {
                if (nTRUEncryptionPublicKeyParameters.params != null) {
                    return false;
                }
            } else if (!nTRUEncryptionParameters.equals(nTRUEncryptionPublicKeyParameters.params)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public byte[] getEncoded() {
        return this.f6040h.toBinary(this.params.f6036q);
    }

    public int hashCode() {
        IntegerPolynomial integerPolynomial = this.f6040h;
        int hashCode = ((integerPolynomial == null ? 0 : integerPolynomial.hashCode()) + 31) * 31;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        return hashCode + (nTRUEncryptionParameters != null ? nTRUEncryptionParameters.hashCode() : 0);
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(getEncoded());
    }

    public NTRUEncryptionPublicKeyParameters(byte[] bArr, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(false, nTRUEncryptionParameters);
        this.f6040h = IntegerPolynomial.fromBinary(bArr, nTRUEncryptionParameters.f6030N, nTRUEncryptionParameters.f6036q);
    }

    public NTRUEncryptionPublicKeyParameters(InputStream inputStream, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(false, nTRUEncryptionParameters);
        this.f6040h = IntegerPolynomial.fromBinary(inputStream, nTRUEncryptionParameters.f6030N, nTRUEncryptionParameters.f6036q);
    }
}
