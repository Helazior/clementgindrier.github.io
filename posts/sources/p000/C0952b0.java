package p000;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: b0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0952b0 {

    /* renamed from: c */
    public Interpolator f3652c;

    /* renamed from: d */
    public InterfaceC0571Y4 f3653d;

    /* renamed from: e */
    public boolean f3654e;

    /* renamed from: b */
    public long f3651b = -1;

    /* renamed from: f */
    public final C0588Z4 f3655f = new C0953a();

    /* renamed from: a */
    public final ArrayList<C0554X4> f3650a = new ArrayList<>();

    /* renamed from: b0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0953a extends C0588Z4 {

        /* renamed from: a */
        public boolean f3656a = false;

        /* renamed from: b */
        public int f3657b = 0;

        public C0953a() {
        }

        @Override // p000.InterfaceC0571Y4
        /* renamed from: b */
        public void mo223b(View view) {
            int i = this.f3657b + 1;
            this.f3657b = i;
            if (i == C0952b0.this.f3650a.size()) {
                InterfaceC0571Y4 interfaceC0571Y4 = C0952b0.this.f3653d;
                if (interfaceC0571Y4 != null) {
                    interfaceC0571Y4.mo223b(null);
                }
                this.f3657b = 0;
                this.f3656a = false;
                C0952b0.this.f3654e = false;
            }
        }

        @Override // p000.C0588Z4, p000.InterfaceC0571Y4
        /* renamed from: c */
        public void mo222c(View view) {
            if (this.f3656a) {
                return;
            }
            this.f3656a = true;
            InterfaceC0571Y4 interfaceC0571Y4 = C0952b0.this.f3653d;
            if (interfaceC0571Y4 != null) {
                interfaceC0571Y4.mo222c(null);
            }
        }
    }

    /* renamed from: a */
    public void m1215a() {
        if (this.f3654e) {
            Iterator<C0554X4> it = this.f3650a.iterator();
            while (it.hasNext()) {
                it.next().m1808b();
            }
            this.f3654e = false;
        }
    }

    /* renamed from: b */
    public void m1214b() {
        View view;
        if (this.f3654e) {
            return;
        }
        Iterator<C0554X4> it = this.f3650a.iterator();
        while (it.hasNext()) {
            C0554X4 next = it.next();
            long j = this.f3651b;
            if (j >= 0) {
                next.m1807c(j);
            }
            Interpolator interpolator = this.f3652c;
            if (interpolator != null && (view = next.f1987a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.f3653d != null) {
                next.m1806d(this.f3655f);
            }
            View view2 = next.f1987a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.f3654e = true;
    }
}
