package org.spongycastle.x509;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class X509CollectionStoreParameters implements X509StoreParameters {
    private Collection collection;

    public X509CollectionStoreParameters(Collection collection) {
        Objects.requireNonNull(collection, "collection cannot be null");
        this.collection = collection;
    }

    public Object clone() {
        return new X509CollectionStoreParameters(this.collection);
    }

    public Collection getCollection() {
        return new ArrayList(this.collection);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("X509CollectionStoreParameters: [\n");
        StringBuilder m253r = outline.m253r("  collection: ");
        m253r.append(this.collection);
        m253r.append("\n");
        stringBuffer.append(m253r.toString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
