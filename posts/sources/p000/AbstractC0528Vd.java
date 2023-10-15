package p000;

import java.util.Iterator;

/* renamed from: Vd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0528Vd implements Iterator<Integer> {
    /* renamed from: a */
    public abstract int mo1723a();

    @Override // java.util.Iterator
    public Integer next() {
        return Integer.valueOf(mo1723a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
