package p000;

import android.view.View;

/* renamed from: h7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1862h7 {

    /* renamed from: a */
    public final InterfaceC1864b f5143a;

    /* renamed from: b */
    public C1863a f5144b = new C1863a();

    /* renamed from: h7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1863a {

        /* renamed from: a */
        public int f5145a = 0;

        /* renamed from: b */
        public int f5146b;

        /* renamed from: c */
        public int f5147c;

        /* renamed from: d */
        public int f5148d;

        /* renamed from: e */
        public int f5149e;

        /* renamed from: a */
        public boolean m772a() {
            int i = this.f5145a;
            if ((i & 7) == 0 || (i & (m771b(this.f5148d, this.f5146b) << 0)) != 0) {
                int i2 = this.f5145a;
                if ((i2 & 112) == 0 || (i2 & (m771b(this.f5148d, this.f5147c) << 4)) != 0) {
                    int i3 = this.f5145a;
                    if ((i3 & 1792) == 0 || (i3 & (m771b(this.f5149e, this.f5146b) << 8)) != 0) {
                        int i4 = this.f5145a;
                        return (i4 & 28672) == 0 || (i4 & (m771b(this.f5149e, this.f5147c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        /* renamed from: b */
        public int m771b(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }
    }

    /* renamed from: h7$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1864b {
        /* renamed from: a */
        int mo770a();

        /* renamed from: b */
        int mo769b(View view);

        /* renamed from: c */
        int mo768c();

        /* renamed from: d */
        int mo767d(View view);

        View getChildAt(int i);
    }

    public C1862h7(InterfaceC1864b interfaceC1864b) {
        this.f5143a = interfaceC1864b;
    }

    /* renamed from: a */
    public View m774a(int i, int i2, int i3, int i4) {
        int mo768c = this.f5143a.mo768c();
        int mo770a = this.f5143a.mo770a();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = this.f5143a.getChildAt(i);
            int mo769b = this.f5143a.mo769b(childAt);
            int mo767d = this.f5143a.mo767d(childAt);
            C1863a c1863a = this.f5144b;
            c1863a.f5146b = mo768c;
            c1863a.f5147c = mo770a;
            c1863a.f5148d = mo769b;
            c1863a.f5149e = mo767d;
            if (i3 != 0) {
                c1863a.f5145a = 0;
                c1863a.f5145a = i3 | 0;
                if (c1863a.m772a()) {
                    return childAt;
                }
            }
            if (i4 != 0) {
                C1863a c1863a2 = this.f5144b;
                c1863a2.f5145a = 0;
                c1863a2.f5145a = i4 | 0;
                if (c1863a2.m772a()) {
                    view = childAt;
                }
            }
            i += i5;
        }
        return view;
    }

    /* renamed from: b */
    public boolean m773b(View view, int i) {
        C1863a c1863a = this.f5144b;
        int mo768c = this.f5143a.mo768c();
        int mo770a = this.f5143a.mo770a();
        int mo769b = this.f5143a.mo769b(view);
        int mo767d = this.f5143a.mo767d(view);
        c1863a.f5146b = mo768c;
        c1863a.f5147c = mo770a;
        c1863a.f5148d = mo769b;
        c1863a.f5149e = mo767d;
        if (i != 0) {
            C1863a c1863a2 = this.f5144b;
            c1863a2.f5145a = 0;
            c1863a2.f5145a = 0 | i;
            return c1863a2.m772a();
        }
        return false;
    }
}
