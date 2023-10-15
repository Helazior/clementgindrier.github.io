package com.bumptech.glide.load.engine.bitmap_recycle;

import java.util.Map;
import java.util.TreeMap;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder m253r = outline.m253r("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            m253r.append('{');
            m253r.append(entry.getKey());
            m253r.append(':');
            m253r.append(entry.getValue());
            m253r.append("}, ");
        }
        if (!isEmpty()) {
            m253r.replace(m253r.length() - 2, m253r.length(), "");
        }
        m253r.append(" )");
        return m253r.toString();
    }
}
