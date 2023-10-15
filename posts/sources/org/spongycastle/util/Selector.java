package org.spongycastle.util;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Selector extends Cloneable {
    Object clone();

    boolean match(Object obj);
}
