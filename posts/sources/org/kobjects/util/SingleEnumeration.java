package org.kobjects.util;

import java.util.Enumeration;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SingleEnumeration implements Enumeration {
    public Object object;

    public SingleEnumeration(Object obj) {
        this.object = obj;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.object != null;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object obj = this.object;
        this.object = null;
        return obj;
    }
}
