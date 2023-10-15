package org.spongycastle.jce.provider;

import java.security.Permission;
import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.jcajce.provider.asymmetric.p016ec.EC5Util;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.config.ProviderConfigurationPermission;
import org.spongycastle.jce.spec.ECParameterSpec;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BouncyCastleProviderConfiguration implements ProviderConfiguration {
    private volatile DHParameterSpec dhDefaultParams;
    private volatile ECParameterSpec ecImplicitCaParams;
    private static Permission BC_EC_LOCAL_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA);
    private static Permission BC_EC_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.EC_IMPLICITLY_CA);
    private static Permission BC_DH_LOCAL_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.THREAD_LOCAL_DH_DEFAULT_PARAMS);
    private static Permission BC_DH_PERMISSION = new ProviderConfigurationPermission(BouncyCastleProvider.PROVIDER_NAME, ConfigurableProvider.DH_DEFAULT_PARAMS);
    private ThreadLocal ecThreadSpec = new ThreadLocal();
    private ThreadLocal dhThreadSpec = new ThreadLocal();

    @Override // org.spongycastle.jcajce.provider.config.ProviderConfiguration
    public DHParameterSpec getDHDefaultParameters() {
        DHParameterSpec dHParameterSpec = (DHParameterSpec) this.dhThreadSpec.get();
        return dHParameterSpec != null ? dHParameterSpec : this.dhDefaultParams;
    }

    @Override // org.spongycastle.jcajce.provider.config.ProviderConfiguration
    public ECParameterSpec getEcImplicitlyCa() {
        ECParameterSpec eCParameterSpec = (ECParameterSpec) this.ecThreadSpec.get();
        return eCParameterSpec != null ? eCParameterSpec : this.ecImplicitCaParams;
    }

    public void setParameter(String str, Object obj) {
        ECParameterSpec eCParameterSpec;
        SecurityManager securityManager = System.getSecurityManager();
        if (str.equals(ConfigurableProvider.THREAD_LOCAL_EC_IMPLICITLY_CA)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_EC_LOCAL_PERMISSION);
            }
            if (!(obj instanceof ECParameterSpec) && obj != null) {
                eCParameterSpec = EC5Util.convertSpec((java.security.spec.ECParameterSpec) obj, false);
            } else {
                eCParameterSpec = (ECParameterSpec) obj;
            }
            if (eCParameterSpec == null) {
                this.ecThreadSpec.remove();
            } else {
                this.ecThreadSpec.set(eCParameterSpec);
            }
        } else if (str.equals(ConfigurableProvider.EC_IMPLICITLY_CA)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_EC_PERMISSION);
            }
            if (!(obj instanceof ECParameterSpec) && obj != null) {
                this.ecImplicitCaParams = EC5Util.convertSpec((java.security.spec.ECParameterSpec) obj, false);
            } else {
                this.ecImplicitCaParams = (ECParameterSpec) obj;
            }
        } else if (str.equals(ConfigurableProvider.THREAD_LOCAL_DH_DEFAULT_PARAMS)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_DH_LOCAL_PERMISSION);
            }
            if (!(obj instanceof DHParameterSpec) && obj != null) {
                throw new IllegalArgumentException("not a valid DHParameterSpec");
            }
            DHParameterSpec dHParameterSpec = (DHParameterSpec) obj;
            if (dHParameterSpec == null) {
                this.dhThreadSpec.remove();
            } else {
                this.dhThreadSpec.set(dHParameterSpec);
            }
        } else if (str.equals(ConfigurableProvider.DH_DEFAULT_PARAMS)) {
            if (securityManager != null) {
                securityManager.checkPermission(BC_DH_PERMISSION);
            }
            if (!(obj instanceof DHParameterSpec) && obj != null) {
                throw new IllegalArgumentException("not a valid DHParameterSpec");
            }
            this.dhDefaultParams = (DHParameterSpec) obj;
        }
    }
}
