package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ElGamalGenParameterSpec implements AlgorithmParameterSpec {
    private int primeSize;

    public ElGamalGenParameterSpec(int i) {
        this.primeSize = i;
    }

    public int getPrimeSize() {
        return this.primeSize;
    }
}
