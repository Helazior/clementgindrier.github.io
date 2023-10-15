package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.dagger.Binds;
import com.google.android.datatransport.runtime.dagger.Module;

@Module
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class BackendRegistryModule {
    @Binds
    public abstract BackendRegistry backendRegistry(MetadataBackendRegistry metadataBackendRegistry);
}
