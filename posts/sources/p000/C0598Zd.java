package p000;

import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Zd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0598Zd implements Iterable<Integer> {

    /* renamed from: a */
    public final int f2118a;

    /* renamed from: b */
    public final int f2119b;

    /* renamed from: c */
    public final int f2120c;

    public C0598Zd(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f2118a = i;
            if (i3 > 0) {
                if (i < i2) {
                    i2 -= C0374Q7.m2085j(C0374Q7.m2085j(i2, i3) - C0374Q7.m2085j(i, i3), i3);
                }
            } else if (i3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            } else {
                if (i > i2) {
                    int i4 = -i3;
                    i2 += C0374Q7.m2085j(C0374Q7.m2085j(i, i4) - C0374Q7.m2085j(i2, i4), i4);
                }
            }
            this.f2119b = i2;
            this.f2120c = i3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C0598Zd) {
            if (!isEmpty() || !((C0598Zd) obj).isEmpty()) {
                C0598Zd c0598Zd = (C0598Zd) obj;
                if (this.f2118a != c0598Zd.f2118a || this.f2119b != c0598Zd.f2119b || this.f2120c != c0598Zd.f2120c) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f2118a * 31) + this.f2119b) * 31) + this.f2120c;
    }

    public boolean isEmpty() {
        if (this.f2120c > 0) {
            if (this.f2118a > this.f2119b) {
                return true;
            }
        } else if (this.f2118a < this.f2119b) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new C0622ae(this.f2118a, this.f2119b, this.f2120c);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f2120c > 0) {
            sb = new StringBuilder();
            sb.append(this.f2118a);
            sb.append("..");
            sb.append(this.f2119b);
            sb.append(" step ");
            i = this.f2120c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f2118a);
            sb.append(" downTo ");
            sb.append(this.f2119b);
            sb.append(" step ");
            i = -this.f2120c;
        }
        sb.append(i);
        return sb.toString();
    }
}
