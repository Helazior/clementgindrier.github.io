package p000;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Od */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0343Od implements Comparable<C0343Od> {
    @NotNull

    /* renamed from: f */
    public static final C0343Od f1157f = new C0343Od(1, 5, 10);

    /* renamed from: a */
    public final int f1158a;

    /* renamed from: b */
    public final int f1159b;

    /* renamed from: c */
    public final int f1160c;

    /* renamed from: d */
    public final int f1161d;

    public C0343Od(int i, int i2, int i3) {
        this.f1159b = i;
        this.f1160c = i2;
        this.f1161d = i3;
        if (i >= 0 && 255 >= i && i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3) {
            this.f1158a = (i << 16) + (i2 << 8) + i3;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    @Override // java.lang.Comparable
    public int compareTo(C0343Od c0343Od) {
        C0343Od c0343Od2 = c0343Od;
        C0581Yd.m1766e(c0343Od2, "other");
        return this.f1158a - c0343Od2.f1158a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0343Od)) {
            obj = null;
        }
        C0343Od c0343Od = (C0343Od) obj;
        return c0343Od != null && this.f1158a == c0343Od.f1158a;
    }

    public int hashCode() {
        return this.f1158a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1159b);
        sb.append('.');
        sb.append(this.f1160c);
        sb.append('.');
        sb.append(this.f1161d);
        return sb.toString();
    }
}
