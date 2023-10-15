package org.spongycastle.crypto.generators;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.NTRUSigningKeyGenerationParameters;
import org.spongycastle.crypto.params.NTRUSigningPrivateKeyParameters;
import org.spongycastle.crypto.params.NTRUSigningPublicKeyParameters;
import org.spongycastle.math.ntru.euclid.BigIntEuclidean;
import org.spongycastle.math.ntru.polynomial.BigDecimalPolynomial;
import org.spongycastle.math.ntru.polynomial.BigIntPolynomial;
import org.spongycastle.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.math.ntru.polynomial.Polynomial;
import org.spongycastle.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.math.ntru.polynomial.Resultant;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUSigningKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NTRUSigningKeyGenerationParameters params;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class BasisGenerationTask implements Callable<NTRUSigningPrivateKeyParameters.Basis> {
        private BasisGenerationTask() {
        }

        @Override // java.util.concurrent.Callable
        public NTRUSigningPrivateKeyParameters.Basis call() {
            return NTRUSigningKeyPairGenerator.this.generateBoundedBasis();
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class FGBasis extends NTRUSigningPrivateKeyParameters.Basis {

        /* renamed from: F */
        public IntegerPolynomial f5953F;

        /* renamed from: G */
        public IntegerPolynomial f5954G;

        public FGBasis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            super(polynomial, polynomial2, integerPolynomial, nTRUSigningKeyGenerationParameters);
            this.f5953F = integerPolynomial2;
            this.f5954G = integerPolynomial3;
        }

        public boolean isNormOk() {
            double d = NTRUSigningKeyPairGenerator.this.params.keyNormBoundSq;
            int i = NTRUSigningKeyPairGenerator.this.params.f6047q;
            return ((double) this.f5953F.centeredNormSq(i)) < d && ((double) this.f5954G.centeredNormSq(i)) < d;
        }
    }

    private FGBasis generateBasis() {
        int i;
        Polynomial generateRandom;
        Polynomial polynomial;
        IntegerPolynomial integerPolynomial;
        IntegerPolynomial invertFq;
        int i2;
        Resultant resultant;
        int i3;
        IntegerPolynomial integerPolynomial2;
        int i4;
        IntegerPolynomial integerPolynomial3;
        int i5;
        Polynomial polynomial2;
        Polynomial generateRandom2;
        Polynomial polynomial3;
        IntegerPolynomial integerPolynomial4;
        Resultant resultant2;
        BigIntEuclidean calculate;
        BigIntPolynomial round;
        IntegerPolynomial mult;
        Polynomial polynomial4;
        NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
        int i6 = nTRUSigningKeyGenerationParameters.f6042N;
        int i7 = nTRUSigningKeyGenerationParameters.f6047q;
        int i8 = nTRUSigningKeyGenerationParameters.f6043d;
        int i9 = nTRUSigningKeyGenerationParameters.f6044d1;
        int i10 = nTRUSigningKeyGenerationParameters.f6045d2;
        int i11 = nTRUSigningKeyGenerationParameters.f6046d3;
        int i12 = nTRUSigningKeyGenerationParameters.basisType;
        int i13 = (i6 * 2) + 1;
        boolean z = nTRUSigningKeyGenerationParameters.primeCheck;
        while (true) {
            if (this.params.polyType == 0) {
                generateRandom = DenseTernaryPolynomial.generateRandom(i6, i8 + 1, i8, new SecureRandom());
                i = i13;
            } else {
                i = i13;
                generateRandom = ProductFormPolynomial.generateRandom(i6, i9, i10, i11 + 1, i11, new SecureRandom());
            }
            polynomial = generateRandom;
            integerPolynomial = polynomial.toIntegerPolynomial();
            if ((!z || !integerPolynomial.resultant(i).res.equals(BigInteger.ZERO)) && (invertFq = integerPolynomial.invertFq(i7)) != null) {
                break;
            }
            i13 = i;
        }
        Resultant resultant3 = integerPolynomial.resultant();
        while (true) {
            if (this.params.polyType == 0) {
                generateRandom2 = DenseTernaryPolynomial.generateRandom(i6, i8 + 1, i8, new SecureRandom());
                i2 = i8;
                i3 = i9;
                i4 = i10;
                i5 = i11;
                resultant = resultant3;
                integerPolynomial2 = invertFq;
                integerPolynomial3 = integerPolynomial;
                polynomial2 = polynomial;
            } else {
                int i14 = i9;
                i2 = i8;
                resultant = resultant3;
                int i15 = i10;
                i3 = i9;
                integerPolynomial2 = invertFq;
                i4 = i10;
                integerPolynomial3 = integerPolynomial;
                int i16 = i11;
                i5 = i11;
                polynomial2 = polynomial;
                generateRandom2 = ProductFormPolynomial.generateRandom(i6, i14, i15, i11 + 1, i16, new SecureRandom());
            }
            polynomial3 = generateRandom2;
            integerPolynomial4 = polynomial3.toIntegerPolynomial();
            if (!z || !integerPolynomial4.resultant(i).res.equals(BigInteger.ZERO)) {
                if (integerPolynomial4.invertFq(i7) != null) {
                    resultant2 = integerPolynomial4.resultant();
                    calculate = BigIntEuclidean.calculate(resultant.res, resultant2.res);
                    if (calculate.gcd.equals(BigInteger.ONE)) {
                        break;
                    }
                }
            }
            resultant3 = resultant;
            invertFq = integerPolynomial2;
            integerPolynomial = integerPolynomial3;
            polynomial = polynomial2;
            i10 = i4;
            i8 = i2;
            i9 = i3;
            i11 = i5;
        }
        BigIntPolynomial bigIntPolynomial = (BigIntPolynomial) resultant.rho.clone();
        bigIntPolynomial.mult(calculate.f6159x.multiply(BigInteger.valueOf(i7)));
        BigIntPolynomial bigIntPolynomial2 = (BigIntPolynomial) resultant2.rho.clone();
        bigIntPolynomial2.mult(calculate.f6160y.multiply(BigInteger.valueOf(-i7)));
        int i17 = 0;
        if (this.params.keyGenAlg == 0) {
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            iArr[0] = integerPolynomial3.coeffs[0];
            iArr2[0] = integerPolynomial4.coeffs[0];
            for (int i18 = 1; i18 < i6; i18++) {
                int i19 = i6 - i18;
                iArr[i18] = integerPolynomial3.coeffs[i19];
                iArr2[i18] = integerPolynomial4.coeffs[i19];
            }
            IntegerPolynomial integerPolynomial5 = new IntegerPolynomial(iArr);
            IntegerPolynomial integerPolynomial6 = new IntegerPolynomial(iArr2);
            IntegerPolynomial mult2 = polynomial2.mult(integerPolynomial5);
            mult2.add(polynomial3.mult(integerPolynomial6));
            Resultant resultant4 = mult2.resultant();
            BigIntPolynomial mult3 = integerPolynomial5.mult(bigIntPolynomial2);
            mult3.add(integerPolynomial6.mult(bigIntPolynomial));
            round = mult3.mult(resultant4.rho);
            round.div(resultant4.res);
        } else {
            for (int i20 = 1; i20 < i6; i20 *= 10) {
                i17++;
            }
            BigDecimalPolynomial div = resultant.rho.div(new BigDecimal(resultant.res), bigIntPolynomial2.getMaxCoeffLength() + 1 + i17);
            BigDecimalPolynomial div2 = resultant2.rho.div(new BigDecimal(resultant2.res), bigIntPolynomial.getMaxCoeffLength() + 1 + i17);
            BigDecimalPolynomial mult4 = div.mult(bigIntPolynomial2);
            mult4.add(div2.mult(bigIntPolynomial));
            mult4.halve();
            round = mult4.round();
        }
        BigIntPolynomial bigIntPolynomial3 = (BigIntPolynomial) bigIntPolynomial2.clone();
        bigIntPolynomial3.sub(polynomial2.mult(round));
        BigIntPolynomial bigIntPolynomial4 = (BigIntPolynomial) bigIntPolynomial.clone();
        bigIntPolynomial4.sub(polynomial3.mult(round));
        IntegerPolynomial integerPolynomial7 = new IntegerPolynomial(bigIntPolynomial3);
        IntegerPolynomial integerPolynomial8 = new IntegerPolynomial(bigIntPolynomial4);
        minimizeFG(integerPolynomial3, integerPolynomial4, integerPolynomial7, integerPolynomial8, i6);
        if (i12 == 0) {
            mult = polynomial3.mult(integerPolynomial2, i7);
            polynomial4 = integerPolynomial7;
        } else {
            mult = integerPolynomial7.mult(integerPolynomial2, i7);
            polynomial4 = polynomial3;
        }
        mult.modPositive(i7);
        return new FGBasis(polynomial2, polynomial4, mult, integerPolynomial7, integerPolynomial8, this.params);
    }

    private void minimizeFG(IntegerPolynomial integerPolynomial, IntegerPolynomial integerPolynomial2, IntegerPolynomial integerPolynomial3, IntegerPolynomial integerPolynomial4, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int[] iArr = integerPolynomial.coeffs;
            int i4 = iArr[i3] * iArr[i3];
            int[] iArr2 = integerPolynomial2.coeffs;
            i2 += ((iArr2[i3] * iArr2[i3]) + i4) * i * 2;
        }
        int i5 = i2 - 4;
        IntegerPolynomial integerPolynomial5 = (IntegerPolynomial) integerPolynomial.clone();
        IntegerPolynomial integerPolynomial6 = (IntegerPolynomial) integerPolynomial2.clone();
        int i6 = 0;
        int i7 = 0;
        while (i6 < i && i7 < i) {
            int i8 = 0;
            for (int i9 = 0; i9 < i; i9++) {
                i8 += ((integerPolynomial3.coeffs[i9] * integerPolynomial.coeffs[i9]) + (integerPolynomial4.coeffs[i9] * integerPolynomial2.coeffs[i9])) * i * 4;
            }
            int sumCoeffs = i8 - ((integerPolynomial4.sumCoeffs() + integerPolynomial3.sumCoeffs()) * 4);
            if (sumCoeffs > i5) {
                integerPolynomial3.sub(integerPolynomial5);
                integerPolynomial4.sub(integerPolynomial6);
            } else if (sumCoeffs < (-i5)) {
                integerPolynomial3.add(integerPolynomial5);
                integerPolynomial4.add(integerPolynomial6);
            } else {
                i7++;
                integerPolynomial5.rotate1();
                integerPolynomial6.rotate1();
            }
            i6++;
            i7 = 0;
            i7++;
            integerPolynomial5.rotate1();
            integerPolynomial6.rotate1();
        }
    }

    public NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis() {
        FGBasis generateBasis;
        do {
            generateBasis = generateBasis();
        } while (!generateBasis.isNormOk());
        return generateBasis;
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        ArrayList arrayList = new ArrayList();
        int i = this.params.f6041B;
        while (true) {
            nTRUSigningPublicKeyParameters = null;
            if (i < 0) {
                break;
            }
            arrayList.add(newCachedThreadPool.submit(new BasisGenerationTask()));
            i--;
        }
        newCachedThreadPool.shutdown();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = this.params.f6041B; i2 >= 0; i2--) {
            Future future = (Future) arrayList.get(i2);
            try {
                arrayList2.add(future.get());
                if (i2 == this.params.f6041B) {
                    nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(((NTRUSigningPrivateKeyParameters.Basis) future.get()).f6056h, this.params.getSigningParameters());
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return new AsymmetricCipherKeyPair(nTRUSigningPublicKeyParameters, new NTRUSigningPrivateKeyParameters(arrayList2, nTRUSigningPublicKeyParameters));
    }

    public AsymmetricCipherKeyPair generateKeyPairSingleThread() {
        ArrayList arrayList = new ArrayList();
        NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = null;
        for (int i = this.params.f6041B; i >= 0; i--) {
            NTRUSigningPrivateKeyParameters.Basis generateBoundedBasis = generateBoundedBasis();
            arrayList.add(generateBoundedBasis);
            if (i == 0) {
                nTRUSigningPublicKeyParameters = new NTRUSigningPublicKeyParameters(generateBoundedBasis.f6056h, this.params.getSigningParameters());
            }
        }
        return new AsymmetricCipherKeyPair(nTRUSigningPublicKeyParameters, new NTRUSigningPrivateKeyParameters(arrayList, nTRUSigningPublicKeyParameters));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.params = (NTRUSigningKeyGenerationParameters) keyGenerationParameters;
    }
}
