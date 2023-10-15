package org.spongycastle.math.ntru.polynomial;

import java.security.SecureRandom;
import org.spongycastle.math.ntru.util.Util;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DenseTernaryPolynomial extends IntegerPolynomial implements TernaryPolynomial {
    public DenseTernaryPolynomial(int i) {
        super(i);
        checkTernarity();
    }

    private void checkTernarity() {
        int i;
        int i2 = 0;
        while (true) {
            int[] iArr = this.coeffs;
            if (i2 == iArr.length) {
                return;
            }
            i = iArr[i2];
            if (i < -1 || i > 1) {
                break;
            }
            i2++;
        }
        throw new IllegalStateException("Illegal value: " + i + ", must be one of {-1, 0, 1}");
    }

    public static DenseTernaryPolynomial generateRandom(int i, int i2, int i3, SecureRandom secureRandom) {
        return new DenseTernaryPolynomial(Util.generateRandomTernary(i, i2, i3, secureRandom));
    }

    @Override // org.spongycastle.math.ntru.polynomial.TernaryPolynomial
    public int[] getNegOnes() {
        int length = this.coeffs.length;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.coeffs[i2] == -1) {
                iArr[i] = i2;
                i++;
            }
        }
        return Arrays.copyOf(iArr, i);
    }

    @Override // org.spongycastle.math.ntru.polynomial.TernaryPolynomial
    public int[] getOnes() {
        int length = this.coeffs.length;
        int[] iArr = new int[length];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.coeffs[i2] == 1) {
                iArr[i] = i2;
                i++;
            }
        }
        return Arrays.copyOf(iArr, i);
    }

    @Override // org.spongycastle.math.ntru.polynomial.IntegerPolynomial, org.spongycastle.math.ntru.polynomial.Polynomial
    public IntegerPolynomial mult(IntegerPolynomial integerPolynomial, int i) {
        if (i == 2048) {
            IntegerPolynomial integerPolynomial2 = (IntegerPolynomial) integerPolynomial.clone();
            integerPolynomial2.modPositive(2048);
            return new LongPolynomial5(integerPolynomial2).mult(this).toIntegerPolynomial();
        }
        return super.mult(integerPolynomial, i);
    }

    @Override // org.spongycastle.math.ntru.polynomial.TernaryPolynomial
    public int size() {
        return this.coeffs.length;
    }

    public DenseTernaryPolynomial(IntegerPolynomial integerPolynomial) {
        this(integerPolynomial.coeffs);
    }

    public static DenseTernaryPolynomial generateRandom(int i, SecureRandom secureRandom) {
        DenseTernaryPolynomial denseTernaryPolynomial = new DenseTernaryPolynomial(i);
        for (int i2 = 0; i2 < i; i2++) {
            denseTernaryPolynomial.coeffs[i2] = secureRandom.nextInt(3) - 1;
        }
        return denseTernaryPolynomial;
    }

    public DenseTernaryPolynomial(int[] iArr) {
        super(iArr);
        checkTernarity();
    }
}
