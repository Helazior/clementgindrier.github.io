package p000;

import android.view.View;

/* renamed from: D */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC0074D implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ LayoutInflater$Factory2C0000A f313a;

    /* renamed from: D$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0075a extends C0588Z4 {
        public C0075a() {
        }

        @Override // p000.InterfaceC0571Y4
        /* renamed from: b */
        public void mo223b(View view) {
            RunnableC0074D.this.f313a.f41p.setAlpha(1.0f);
            RunnableC0074D.this.f313a.f44s.m1806d(null);
            RunnableC0074D.this.f313a.f44s = null;
        }

        @Override // p000.C0588Z4, p000.InterfaceC0571Y4
        /* renamed from: c */
        public void mo222c(View view) {
            RunnableC0074D.this.f313a.f41p.setVisibility(0);
        }
    }

    public RunnableC0074D(LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A) {
        this.f313a = layoutInflater$Factory2C0000A;
    }

    @Override // java.lang.Runnable
    public void run() {
        LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = this.f313a;
        layoutInflater$Factory2C0000A.f42q.showAtLocation(layoutInflater$Factory2C0000A.f41p, 55, 0, 0);
        this.f313a.m2701H();
        if (this.f313a.m2688U()) {
            this.f313a.f41p.setAlpha(0.0f);
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A2 = this.f313a;
            C0554X4 m1969b = C0492V4.m1969b(layoutInflater$Factory2C0000A2.f41p);
            m1969b.m1809a(1.0f);
            layoutInflater$Factory2C0000A2.f44s = m1969b;
            C0554X4 c0554x4 = this.f313a.f44s;
            C0075a c0075a = new C0075a();
            View view = c0554x4.f1987a.get();
            if (view != null) {
                c0554x4.m1805e(view, c0075a);
                return;
            }
            return;
        }
        this.f313a.f41p.setAlpha(1.0f);
        this.f313a.f41p.setVisibility(0);
    }
}
