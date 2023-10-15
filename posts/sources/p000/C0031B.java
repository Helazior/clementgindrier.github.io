package p000;

import android.view.View;

/* renamed from: B */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0031B implements InterfaceC0331O4 {

    /* renamed from: a */
    public final /* synthetic */ LayoutInflater$Factory2C0000A f159a;

    public C0031B(LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A) {
        this.f159a = layoutInflater$Factory2C0000A;
    }

    @Override // p000.InterfaceC0331O4
    public C0958b5 onApplyWindowInsets(View view, C0958b5 c0958b5) {
        int m1185e = c0958b5.m1185e();
        int m2686W = this.f159a.m2686W(c0958b5, null);
        if (m1185e != m2686W) {
            c0958b5 = c0958b5.m1182h(c0958b5.m1187c(), m2686W, c0958b5.m1186d(), c0958b5.m1188b());
        }
        return C0492V4.m1955p(view, c0958b5);
    }
}
