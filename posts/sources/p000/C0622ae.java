package p000;

import java.util.NoSuchElementException;

/* renamed from: ae */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0622ae extends AbstractC0528Vd {

    /* renamed from: a */
    public final int f2189a;

    /* renamed from: b */
    public boolean f2190b;

    /* renamed from: c */
    public int f2191c;

    /* renamed from: d */
    public final int f2192d;

    public C0622ae(int i, int i2, int i3) {
        this.f2192d = i3;
        this.f2189a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f2190b = z;
        this.f2191c = z ? i : i2;
    }

    @Override // p000.AbstractC0528Vd
    /* renamed from: a */
    public int mo1723a() {
        int i = this.f2191c;
        if (i == this.f2189a) {
            if (this.f2190b) {
                this.f2190b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f2191c = this.f2192d + i;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2190b;
    }
}
