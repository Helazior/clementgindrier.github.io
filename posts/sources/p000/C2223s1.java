package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.cardview.widget.CardView;

/* renamed from: s1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2223s1 implements InterfaceC2268u1 {
    @Override // p000.InterfaceC2268u1
    /* renamed from: a */
    public float mo331a(InterfaceC2247t1 interfaceC2247t1) {
        return m415o(interfaceC2247t1).f6644e;
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: b */
    public ColorStateList mo330b(InterfaceC2247t1 interfaceC2247t1) {
        return m415o(interfaceC2247t1).f6647h;
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: c */
    public void mo329c(InterfaceC2247t1 interfaceC2247t1, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C2286v1 c2286v1 = new C2286v1(colorStateList, f);
        CardView.C0704a c0704a = (CardView.C0704a) interfaceC2247t1;
        c0704a.f2658a = c2286v1;
        CardView.this.setBackgroundDrawable(c2286v1);
        CardView cardView = CardView.this;
        cardView.setClipToOutline(true);
        cardView.setElevation(f2);
        mo318n(interfaceC2247t1, f3);
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: d */
    public void mo328d(InterfaceC2247t1 interfaceC2247t1, float f) {
        C2286v1 m415o = m415o(interfaceC2247t1);
        if (f == m415o.f6640a) {
            return;
        }
        m415o.f6640a = f;
        m415o.m291c(null);
        m415o.invalidateSelf();
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: e */
    public float mo327e(InterfaceC2247t1 interfaceC2247t1) {
        return CardView.this.getElevation();
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: f */
    public void mo326f(InterfaceC2247t1 interfaceC2247t1) {
        CardView.C0704a c0704a = (CardView.C0704a) interfaceC2247t1;
        if (!CardView.this.getUseCompatPadding()) {
            c0704a.m1583b(0, 0, 0, 0);
            return;
        }
        float f = m415o(interfaceC2247t1).f6644e;
        float f2 = m415o(interfaceC2247t1).f6640a;
        int ceil = (int) Math.ceil(C2305w1.m221a(f, f2, c0704a.m1584a()));
        int ceil2 = (int) Math.ceil(C2305w1.m220b(f, f2, c0704a.m1584a()));
        c0704a.m1583b(ceil, ceil2, ceil, ceil2);
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: g */
    public float mo325g(InterfaceC2247t1 interfaceC2247t1) {
        return m415o(interfaceC2247t1).f6640a;
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: h */
    public float mo324h(InterfaceC2247t1 interfaceC2247t1) {
        return m415o(interfaceC2247t1).f6640a * 2.0f;
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: i */
    public float mo323i(InterfaceC2247t1 interfaceC2247t1) {
        return m415o(interfaceC2247t1).f6640a * 2.0f;
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: j */
    public void mo322j(InterfaceC2247t1 interfaceC2247t1) {
        mo318n(interfaceC2247t1, m415o(interfaceC2247t1).f6644e);
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: k */
    public void mo321k(InterfaceC2247t1 interfaceC2247t1, float f) {
        CardView.this.setElevation(f);
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: l */
    public void mo320l(InterfaceC2247t1 interfaceC2247t1) {
        mo318n(interfaceC2247t1, m415o(interfaceC2247t1).f6644e);
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: m */
    public void mo319m(InterfaceC2247t1 interfaceC2247t1, ColorStateList colorStateList) {
        C2286v1 m415o = m415o(interfaceC2247t1);
        m415o.m292b(colorStateList);
        m415o.invalidateSelf();
    }

    @Override // p000.InterfaceC2268u1
    /* renamed from: n */
    public void mo318n(InterfaceC2247t1 interfaceC2247t1, float f) {
        C2286v1 m415o = m415o(interfaceC2247t1);
        CardView.C0704a c0704a = (CardView.C0704a) interfaceC2247t1;
        boolean useCompatPadding = CardView.this.getUseCompatPadding();
        boolean m1584a = c0704a.m1584a();
        if (f != m415o.f6644e || m415o.f6645f != useCompatPadding || m415o.f6646g != m1584a) {
            m415o.f6644e = f;
            m415o.f6645f = useCompatPadding;
            m415o.f6646g = m1584a;
            m415o.m291c(null);
            m415o.invalidateSelf();
        }
        mo326f(interfaceC2247t1);
    }

    /* renamed from: o */
    public final C2286v1 m415o(InterfaceC2247t1 interfaceC2247t1) {
        return (C2286v1) ((CardView.C0704a) interfaceC2247t1).f2658a;
    }
}
