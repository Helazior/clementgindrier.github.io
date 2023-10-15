package org.spongycastle.x509;

import java.io.InputStream;
import java.util.Collection;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class X509StreamParserSpi {
    public abstract void engineInit(InputStream inputStream);

    public abstract Object engineRead();

    public abstract Collection engineReadAll();
}
