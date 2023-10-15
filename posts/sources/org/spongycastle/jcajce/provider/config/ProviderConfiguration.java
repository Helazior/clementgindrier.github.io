package org.spongycastle.jcajce.provider.config;

import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.jce.spec.ECParameterSpec;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ProviderConfiguration {
    DHParameterSpec getDHDefaultParameters();

    ECParameterSpec getEcImplicitlyCa();
}
