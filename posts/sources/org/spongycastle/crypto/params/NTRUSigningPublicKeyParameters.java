package org.spongycastle.crypto.params;

import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.math.ntru.polynomial.IntegerPolynomial;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUSigningPublicKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: h */
    public IntegerPolynomial f6057h;
    private NTRUSigningParameters params;

    public NTRUSigningPublicKeyParameters(IntegerPolynomial integerPolynomial, NTRUSigningParameters nTRUSigningParameters) {
        super(false);
        this.f6057h = integerPolynomial;
        this.params = nTRUSigningParameters;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = (NTRUSigningPublicKeyParameters) obj;
            IntegerPolynomial integerPolynomial = this.f6057h;
            if (integerPolynomial == null) {
                if (nTRUSigningPublicKeyParameters.f6057h != null) {
                    return false;
                }
            } else if (!integerPolynomial.equals(nTRUSigningPublicKeyParameters.f6057h)) {
                return false;
            }
            NTRUSigningParameters nTRUSigningParameters = this.params;
            if (nTRUSigningParameters == null) {
                if (nTRUSigningPublicKeyParameters.params != null) {
                    return false;
                }
            } else if (!nTRUSigningParameters.equals(nTRUSigningPublicKeyParameters.params)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public byte[] getEncoded() {
        return this.f6057h.toBinary(this.params.f6054q);
    }

    public int hashCode() {
        IntegerPolynomial integerPolynomial = this.f6057h;
        int hashCode = ((integerPolynomial == null ? 0 : integerPolynomial.hashCode()) + 31) * 31;
        NTRUSigningParameters nTRUSigningParameters = this.params;
        return hashCode + (nTRUSigningParameters != null ? nTRUSigningParameters.hashCode() : 0);
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(getEncoded());
    }

    public NTRUSigningPublicKeyParameters(byte[] bArr, NTRUSigningParameters nTRUSigningParameters) {
        super(false);
        this.f6057h = IntegerPolynomial.fromBinary(bArr, nTRUSigningParameters.f6049N, nTRUSigningParameters.f6054q);
        this.params = nTRUSigningParameters;
    }

    public NTRUSigningPublicKeyParameters(InputStream inputStream, NTRUSigningParameters nTRUSigningParameters) {
        super(false);
        this.f6057h = IntegerPolynomial.fromBinary(inputStream, nTRUSigningParameters.f6049N, nTRUSigningParameters.f6054q);
        this.params = nTRUSigningParameters;
    }
}
