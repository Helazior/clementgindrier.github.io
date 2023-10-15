package p000;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: be */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0978be extends C0598Zd {
    static {
        new C0978be(1, 0);
    }

    public C0978be(int i, int i2) {
        super(i, i2, 1);
    }

    @Override // p000.C0598Zd
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C0978be) {
            if (!isEmpty() || !((C0978be) obj).isEmpty()) {
                C0978be c0978be = (C0978be) obj;
                if (this.f2118a != c0978be.f2118a || this.f2119b != c0978be.f2119b) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p000.C0598Zd
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.f2118a * 31) + this.f2119b;
    }

    @Override // p000.C0598Zd
    public boolean isEmpty() {
        return this.f2118a > this.f2119b;
    }

    @Override // p000.C0598Zd
    @NotNull
    public String toString() {
        return this.f2118a + ".." + this.f2119b;
    }
}
