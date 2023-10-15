package org.spongycastle.jcajce.provider.asymmetric.dsa;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.DSAParameterSpec;
import org.spongycastle.crypto.generators.DSAParametersGenerator;
import org.spongycastle.crypto.params.DSAParameters;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AlgorithmParameterGeneratorSpi extends java.security.AlgorithmParameterGeneratorSpi {
    public SecureRandom random;
    public int strength = 1024;

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public AlgorithmParameters engineGenerateParameters() {
        DSAParametersGenerator dSAParametersGenerator = new DSAParametersGenerator();
        SecureRandom secureRandom = this.random;
        if (secureRandom != null) {
            dSAParametersGenerator.init(this.strength, 20, secureRandom);
        } else {
            dSAParametersGenerator.init(this.strength, 20, new SecureRandom());
        }
        DSAParameters generateParameters = dSAParametersGenerator.generateParameters();
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("DSA", BouncyCastleProvider.PROVIDER_NAME);
            algorithmParameters.init(new DSAParameterSpec(generateParameters.getP(), generateParameters.getQ(), generateParameters.getG()));
            return algorithmParameters;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(int i, SecureRandom secureRandom) {
        if (i >= 512 && i <= 1024 && i % 64 == 0) {
            this.strength = i;
            this.random = secureRandom;
            return;
        }
        throw new InvalidParameterException("strength must be from 512 - 1024 and a multiple of 64");
    }

    @Override // java.security.AlgorithmParameterGeneratorSpi
    public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) {
        throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSA parameter generation.");
    }
}
