package p000;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* renamed from: t8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2256t8 extends RecyclerView.AbstractC0851s {

    /* renamed from: a */
    public ViewPager2.AbstractC0942g f6560a;

    /* renamed from: b */
    public final ViewPager2 f6561b;

    /* renamed from: c */
    public final RecyclerView f6562c;

    /* renamed from: d */
    public final LinearLayoutManager f6563d;

    /* renamed from: e */
    public int f6564e;

    /* renamed from: f */
    public int f6565f;

    /* renamed from: g */
    public C2257a f6566g;

    /* renamed from: h */
    public int f6567h;

    /* renamed from: i */
    public int f6568i;

    /* renamed from: j */
    public boolean f6569j;

    /* renamed from: k */
    public boolean f6570k;

    /* renamed from: l */
    public boolean f6571l;

    /* renamed from: m */
    public boolean f6572m;

    /* renamed from: t8$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C2257a {

        /* renamed from: a */
        public int f6573a;

        /* renamed from: b */
        public float f6574b;

        /* renamed from: c */
        public int f6575c;

        /* renamed from: a */
        public void m341a() {
            this.f6573a = -1;
            this.f6574b = 0.0f;
            this.f6575c = 0;
        }
    }

    public C2256t8(ViewPager2 viewPager2) {
        this.f6561b = viewPager2;
        RecyclerView recyclerView = viewPager2.f3618k;
        this.f6562c = recyclerView;
        this.f6563d = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f6566g = new C2257a();
        m343c();
    }

    /* renamed from: a */
    public final void m345a(int i) {
        ViewPager2.AbstractC0942g abstractC0942g = this.f6560a;
        if (abstractC0942g != null) {
            abstractC0942g.onPageSelected(i);
        }
    }

    /* renamed from: b */
    public final void m344b(int i) {
        if ((this.f6564e == 3 && this.f6565f == 0) || this.f6565f == i) {
            return;
        }
        this.f6565f = i;
        ViewPager2.AbstractC0942g abstractC0942g = this.f6560a;
        if (abstractC0942g != null) {
            abstractC0942g.onPageScrollStateChanged(i);
        }
    }

    /* renamed from: c */
    public final void m343c() {
        this.f6564e = 0;
        this.f6565f = 0;
        this.f6566g.m341a();
        this.f6567h = -1;
        this.f6568i = -1;
        this.f6569j = false;
        this.f6570k = false;
        this.f6572m = false;
        this.f6571l = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0131, code lost:
        if (r4[r2 - 1][1] >= r3) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0136, code lost:
        r2 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016b  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m342d() {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2256t8.m342d():void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0851s
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        ViewPager2.AbstractC0942g abstractC0942g;
        int i2 = this.f6564e;
        boolean z = true;
        if (!(i2 == 1 && this.f6565f == 1) && i == 1) {
            this.f6572m = false;
            this.f6564e = 1;
            int i3 = this.f6568i;
            if (i3 != -1) {
                this.f6567h = i3;
                this.f6568i = -1;
            } else if (this.f6567h == -1) {
                this.f6567h = this.f6563d.findFirstVisibleItemPosition();
            }
            m344b(1);
            return;
        }
        if ((i2 == 1 || i2 == 4) && i == 2) {
            if (this.f6570k) {
                m344b(2);
                this.f6569j = true;
                return;
            }
            return;
        }
        if ((i2 == 1 || i2 == 4) && i == 0) {
            m342d();
            if (!this.f6570k) {
                int i4 = this.f6566g.f6573a;
                if (i4 != -1 && (abstractC0942g = this.f6560a) != null) {
                    abstractC0942g.onPageScrolled(i4, 0.0f, 0);
                }
            } else {
                C2257a c2257a = this.f6566g;
                if (c2257a.f6575c == 0) {
                    int i5 = this.f6567h;
                    int i6 = c2257a.f6573a;
                    if (i5 != i6) {
                        m345a(i6);
                    }
                } else {
                    z = false;
                }
            }
            if (z) {
                m344b(0);
                m343c();
            }
        }
        if (this.f6564e == 2 && i == 0 && this.f6571l) {
            m342d();
            C2257a c2257a2 = this.f6566g;
            if (c2257a2.f6575c == 0) {
                int i7 = this.f6568i;
                int i8 = c2257a2.f6573a;
                if (i7 != i8) {
                    if (i8 == -1) {
                        i8 = 0;
                    }
                    m345a(i8);
                }
                m344b(0);
                m343c();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
        if ((r6 < 0) == r4.f6561b.m1223e()) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0851s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r5, int r6, int r7) {
        /*
            r4 = this;
            r5 = 1
            r4.f6570k = r5
            r4.m342d()
            boolean r0 = r4.f6569j
            r1 = 0
            r2 = -1
            if (r0 == 0) goto L3d
            r4.f6569j = r1
            if (r7 > 0) goto L22
            if (r7 != 0) goto L20
            if (r6 >= 0) goto L16
            r6 = 1
            goto L17
        L16:
            r6 = 0
        L17:
            androidx.viewpager2.widget.ViewPager2 r7 = r4.f6561b
            boolean r7 = r7.m1223e()
            if (r6 != r7) goto L20
            goto L22
        L20:
            r6 = 0
            goto L23
        L22:
            r6 = 1
        L23:
            if (r6 == 0) goto L2f
            t8$a r6 = r4.f6566g
            int r7 = r6.f6575c
            if (r7 == 0) goto L2f
            int r6 = r6.f6573a
            int r6 = r6 + r5
            goto L33
        L2f:
            t8$a r6 = r4.f6566g
            int r6 = r6.f6573a
        L33:
            r4.f6568i = r6
            int r7 = r4.f6567h
            if (r7 == r6) goto L4b
            r4.m345a(r6)
            goto L4b
        L3d:
            int r6 = r4.f6564e
            if (r6 != 0) goto L4b
            t8$a r6 = r4.f6566g
            int r6 = r6.f6573a
            if (r6 != r2) goto L48
            r6 = 0
        L48:
            r4.m345a(r6)
        L4b:
            t8$a r6 = r4.f6566g
            int r7 = r6.f6573a
            if (r7 != r2) goto L52
            r7 = 0
        L52:
            float r0 = r6.f6574b
            int r6 = r6.f6575c
            androidx.viewpager2.widget.ViewPager2$g r3 = r4.f6560a
            if (r3 == 0) goto L5d
            r3.onPageScrolled(r7, r0, r6)
        L5d:
            t8$a r6 = r4.f6566g
            int r7 = r6.f6573a
            int r0 = r4.f6568i
            if (r7 == r0) goto L67
            if (r0 != r2) goto L75
        L67:
            int r6 = r6.f6575c
            if (r6 != 0) goto L75
            int r6 = r4.f6565f
            if (r6 == r5) goto L75
            r4.m344b(r1)
            r4.m343c()
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2256t8.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
