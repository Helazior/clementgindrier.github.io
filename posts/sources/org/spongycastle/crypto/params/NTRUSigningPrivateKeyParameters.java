package org.spongycastle.crypto.params;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.math.ntru.polynomial.Polynomial;
import org.spongycastle.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.math.ntru.polynomial.SparseTernaryPolynomial;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUSigningPrivateKeyParameters extends AsymmetricKeyParameter {
    private List<Basis> bases;
    private NTRUSigningPublicKeyParameters publicKey;

    public NTRUSigningPrivateKeyParameters(byte[] bArr, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
        this(new ByteArrayInputStream(bArr), nTRUSigningKeyGenerationParameters);
    }

    private void add(Basis basis) {
        this.bases.add(basis);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters = (NTRUSigningPrivateKeyParameters) obj;
            List<Basis> list = this.bases;
            if ((list != null || nTRUSigningPrivateKeyParameters.bases == null) && list.size() == nTRUSigningPrivateKeyParameters.bases.size()) {
                for (int i = 0; i < this.bases.size(); i++) {
                    Basis basis = this.bases.get(i);
                    Basis basis2 = nTRUSigningPrivateKeyParameters.bases.get(i);
                    if (!basis.f6055f.equals(basis2.f6055f) || !basis.fPrime.equals(basis2.fPrime)) {
                        return false;
                    }
                    if ((i != 0 && !basis.f6056h.equals(basis2.f6056h)) || !basis.params.equals(basis2.params)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public Basis getBasis(int i) {
        return this.bases.get(i);
    }

    public byte[] getEncoded() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while (i < this.bases.size()) {
            this.bases.get(i).encode(byteArrayOutputStream, i != 0);
            i++;
        }
        byteArrayOutputStream.write(this.publicKey.getEncoded());
        return byteArrayOutputStream.toByteArray();
    }

    public NTRUSigningPublicKeyParameters getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        List<Basis> list = this.bases;
        int hashCode = 31 + (list == null ? 0 : list.hashCode());
        for (Basis basis : this.bases) {
            hashCode += basis.hashCode();
        }
        return hashCode;
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(getEncoded());
    }

    public NTRUSigningPrivateKeyParameters(InputStream inputStream, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
        super(true);
        this.bases = new ArrayList();
        int i = 0;
        while (i <= nTRUSigningKeyGenerationParameters.f6041B) {
            add(new Basis(inputStream, nTRUSigningKeyGenerationParameters, i != 0));
            i++;
        }
        this.publicKey = new NTRUSigningPublicKeyParameters(inputStream, nTRUSigningKeyGenerationParameters.getSigningParameters());
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class Basis {

        /* renamed from: f */
        public Polynomial f6055f;
        public Polynomial fPrime;

        /* renamed from: h */
        public IntegerPolynomial f6056h;
        public NTRUSigningKeyGenerationParameters params;

        public Basis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            this.f6055f = polynomial;
            this.fPrime = polynomial2;
            this.f6056h = integerPolynomial;
            this.params = nTRUSigningKeyGenerationParameters;
        }

        private byte[] getEncoded(Polynomial polynomial) {
            if (polynomial instanceof ProductFormPolynomial) {
                return ((ProductFormPolynomial) polynomial).toBinary();
            }
            return polynomial.toIntegerPolynomial().toBinary3Tight();
        }

        public void encode(OutputStream outputStream, boolean z) {
            int i = this.params.f6047q;
            outputStream.write(getEncoded(this.f6055f));
            if (this.params.basisType == 0) {
                IntegerPolynomial integerPolynomial = this.fPrime.toIntegerPolynomial();
                int i2 = 0;
                while (true) {
                    int[] iArr = integerPolynomial.coeffs;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    iArr[i2] = (i / 2) + iArr[i2];
                    i2++;
                }
                outputStream.write(integerPolynomial.toBinary(i));
            } else {
                outputStream.write(getEncoded(this.fPrime));
            }
            if (z) {
                outputStream.write(this.f6056h.toBinary(i));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Basis)) {
                Basis basis = (Basis) obj;
                Polynomial polynomial = this.f6055f;
                if (polynomial == null) {
                    if (basis.f6055f != null) {
                        return false;
                    }
                } else if (!polynomial.equals(basis.f6055f)) {
                    return false;
                }
                Polynomial polynomial2 = this.fPrime;
                if (polynomial2 == null) {
                    if (basis.fPrime != null) {
                        return false;
                    }
                } else if (!polynomial2.equals(basis.fPrime)) {
                    return false;
                }
                IntegerPolynomial integerPolynomial = this.f6056h;
                if (integerPolynomial == null) {
                    if (basis.f6056h != null) {
                        return false;
                    }
                } else if (!integerPolynomial.equals(basis.f6056h)) {
                    return false;
                }
                NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
                if (nTRUSigningKeyGenerationParameters == null) {
                    if (basis.params != null) {
                        return false;
                    }
                } else if (!nTRUSigningKeyGenerationParameters.equals(basis.params)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            Polynomial polynomial = this.f6055f;
            int hashCode = ((polynomial == null ? 0 : polynomial.hashCode()) + 31) * 31;
            Polynomial polynomial2 = this.fPrime;
            int hashCode2 = (hashCode + (polynomial2 == null ? 0 : polynomial2.hashCode())) * 31;
            IntegerPolynomial integerPolynomial = this.f6056h;
            int hashCode3 = (hashCode2 + (integerPolynomial == null ? 0 : integerPolynomial.hashCode())) * 31;
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
            return hashCode3 + (nTRUSigningKeyGenerationParameters != null ? nTRUSigningKeyGenerationParameters.hashCode() : 0);
        }

        public Basis(InputStream inputStream, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters, boolean z) {
            int i = nTRUSigningKeyGenerationParameters.f6042N;
            int i2 = nTRUSigningKeyGenerationParameters.f6047q;
            int i3 = nTRUSigningKeyGenerationParameters.f6044d1;
            int i4 = nTRUSigningKeyGenerationParameters.f6045d2;
            int i5 = nTRUSigningKeyGenerationParameters.f6046d3;
            boolean z2 = nTRUSigningKeyGenerationParameters.sparse;
            this.params = nTRUSigningKeyGenerationParameters;
            if (nTRUSigningKeyGenerationParameters.polyType == 1) {
                this.f6055f = ProductFormPolynomial.fromBinary(inputStream, i, i3, i4, i5 + 1, i5);
            } else {
                IntegerPolynomial fromBinary3Tight = IntegerPolynomial.fromBinary3Tight(inputStream, i);
                this.f6055f = z2 ? new SparseTernaryPolynomial(fromBinary3Tight) : new DenseTernaryPolynomial(fromBinary3Tight);
            }
            if (nTRUSigningKeyGenerationParameters.basisType == 0) {
                IntegerPolynomial fromBinary = IntegerPolynomial.fromBinary(inputStream, i, i2);
                int i6 = 0;
                while (true) {
                    int[] iArr = fromBinary.coeffs;
                    if (i6 >= iArr.length) {
                        break;
                    }
                    iArr[i6] = iArr[i6] - (i2 / 2);
                    i6++;
                }
                this.fPrime = fromBinary;
            } else if (nTRUSigningKeyGenerationParameters.polyType == 1) {
                this.fPrime = ProductFormPolynomial.fromBinary(inputStream, i, i3, i4, i5 + 1, i5);
            } else {
                this.fPrime = IntegerPolynomial.fromBinary3Tight(inputStream, i);
            }
            if (z) {
                this.f6056h = IntegerPolynomial.fromBinary(inputStream, i, i2);
            }
        }
    }

    public NTRUSigningPrivateKeyParameters(List<Basis> list, NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters) {
        super(true);
        this.bases = new ArrayList(list);
        this.publicKey = nTRUSigningPublicKeyParameters;
    }
}
