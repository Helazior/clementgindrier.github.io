package org.spongycastle.crypto.generators;

import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.params.NTRUEncryptionKeyGenerationParameters;
import org.spongycastle.crypto.params.NTRUEncryptionPrivateKeyParameters;
import org.spongycastle.crypto.params.NTRUEncryptionPublicKeyParameters;
import org.spongycastle.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.math.ntru.polynomial.Polynomial;
import org.spongycastle.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.math.ntru.util.Util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUEncryptionKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private NTRUEncryptionKeyGenerationParameters params;

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        Polynomial generateRandomTernary;
        IntegerPolynomial integerPolynomial;
        IntegerPolynomial invertFq;
        IntegerPolynomial integerPolynomial2;
        DenseTernaryPolynomial generateRandom;
        NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters = this.params;
        int i = nTRUEncryptionKeyGenerationParameters.f6023N;
        int i2 = nTRUEncryptionKeyGenerationParameters.f6029q;
        int i3 = nTRUEncryptionKeyGenerationParameters.f6026df;
        int i4 = nTRUEncryptionKeyGenerationParameters.df1;
        int i5 = nTRUEncryptionKeyGenerationParameters.df2;
        int i6 = nTRUEncryptionKeyGenerationParameters.df3;
        int i7 = nTRUEncryptionKeyGenerationParameters.f6027dg;
        boolean z = nTRUEncryptionKeyGenerationParameters.fastFp;
        boolean z2 = nTRUEncryptionKeyGenerationParameters.sparse;
        IntegerPolynomial integerPolynomial3 = null;
        while (true) {
            if (z) {
                NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters2 = this.params;
                generateRandomTernary = nTRUEncryptionKeyGenerationParameters2.polyType == 0 ? Util.generateRandomTernary(i, i3, i3, z2, nTRUEncryptionKeyGenerationParameters2.getRandom()) : ProductFormPolynomial.generateRandom(i, i4, i5, i6, i6, nTRUEncryptionKeyGenerationParameters2.getRandom());
                integerPolynomial = generateRandomTernary.toIntegerPolynomial();
                integerPolynomial.mult(3);
                int[] iArr = integerPolynomial.coeffs;
                iArr[0] = iArr[0] + 1;
            } else {
                NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters3 = this.params;
                generateRandomTernary = nTRUEncryptionKeyGenerationParameters3.polyType == 0 ? Util.generateRandomTernary(i, i3, i3 - 1, z2, nTRUEncryptionKeyGenerationParameters3.getRandom()) : ProductFormPolynomial.generateRandom(i, i4, i5, i6, i6 - 1, nTRUEncryptionKeyGenerationParameters3.getRandom());
                integerPolynomial = generateRandomTernary.toIntegerPolynomial();
                integerPolynomial3 = integerPolynomial.invertF3();
                if (integerPolynomial3 == null) {
                    continue;
                }
            }
            invertFq = integerPolynomial.invertFq(i2);
            if (invertFq != null) {
                break;
            }
        }
        if (z) {
            integerPolynomial2 = new IntegerPolynomial(i);
            integerPolynomial2.coeffs[0] = 1;
        } else {
            integerPolynomial2 = integerPolynomial3;
        }
        do {
            generateRandom = DenseTernaryPolynomial.generateRandom(i, i7, i7 - 1, this.params.getRandom());
        } while (generateRandom.invertFq(i2) == null);
        IntegerPolynomial mult = generateRandom.mult(invertFq, i2);
        mult.mult3(i2);
        mult.ensurePositive(i2);
        generateRandom.clear();
        invertFq.clear();
        return new AsymmetricCipherKeyPair(new NTRUEncryptionPublicKeyParameters(mult, this.params.getEncryptionParameters()), new NTRUEncryptionPrivateKeyParameters(mult, generateRandomTernary, integerPolynomial2, this.params.getEncryptionParameters()));
    }

    @Override // org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.params = (NTRUEncryptionKeyGenerationParameters) keyGenerationParameters;
    }
}
