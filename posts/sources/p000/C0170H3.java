package p000;

import android.graphics.Insets;

/* renamed from: H3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0170H3 {

    /* renamed from: e */
    public static final C0170H3 f561e = new C0170H3(0, 0, 0, 0);

    /* renamed from: a */
    public final int f562a;

    /* renamed from: b */
    public final int f563b;

    /* renamed from: c */
    public final int f564c;

    /* renamed from: d */
    public final int f565d;

    public C0170H3(int i, int i2, int i3, int i4) {
        this.f562a = i;
        this.f563b = i2;
        this.f564c = i3;
        this.f565d = i4;
    }

    /* renamed from: a */
    public static C0170H3 m2412a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return f561e;
        }
        return new C0170H3(i, i2, i3, i4);
    }

    /* renamed from: b */
    public static C0170H3 m2411b(Insets insets) {
        return m2412a(insets.left, insets.top, insets.right, insets.bottom);
    }

    /* renamed from: c */
    public Insets m2410c() {
        return Insets.of(this.f562a, this.f563b, this.f564c, this.f565d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0170H3.class != obj.getClass()) {
            return false;
        }
        C0170H3 c0170h3 = (C0170H3) obj;
        return this.f565d == c0170h3.f565d && this.f562a == c0170h3.f562a && this.f564c == c0170h3.f564c && this.f563b == c0170h3.f563b;
    }

    public int hashCode() {
        return (((((this.f562a * 31) + this.f563b) * 31) + this.f564c) * 31) + this.f565d;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("Insets{left=");
        m253r.append(this.f562a);
        m253r.append(", top=");
        m253r.append(this.f563b);
        m253r.append(", right=");
        m253r.append(this.f564c);
        m253r.append(", bottom=");
        m253r.append(this.f565d);
        m253r.append('}');
        return m253r.toString();
    }
}
