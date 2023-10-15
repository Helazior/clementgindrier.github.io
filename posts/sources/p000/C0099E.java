package p000;

import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: E */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0099E extends C0588Z4 {

    /* renamed from: a */
    public final /* synthetic */ LayoutInflater$Factory2C0000A f366a;

    public C0099E(LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A) {
        this.f366a = layoutInflater$Factory2C0000A;
    }

    @Override // p000.InterfaceC0571Y4
    /* renamed from: b */
    public void mo223b(View view) {
        this.f366a.f41p.setAlpha(1.0f);
        this.f366a.f44s.m1806d(null);
        this.f366a.f44s = null;
    }

    @Override // p000.C0588Z4, p000.InterfaceC0571Y4
    /* renamed from: c */
    public void mo222c(View view) {
        this.f366a.f41p.setVisibility(0);
        this.f366a.f41p.sendAccessibilityEvent(32);
        if (this.f366a.f41p.getParent() instanceof View) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0499g.m1901c((View) this.f366a.f41p.getParent());
        }
    }
}
