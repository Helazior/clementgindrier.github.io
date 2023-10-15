package p000;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.InterfaceC2165p0;

/* renamed from: o0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2013o0 {

    /* renamed from: a */
    public final Context f5565a;

    /* renamed from: b */
    public final C1905j0 f5566b;

    /* renamed from: c */
    public final boolean f5567c;

    /* renamed from: d */
    public final int f5568d;

    /* renamed from: e */
    public final int f5569e;

    /* renamed from: f */
    public View f5570f;

    /* renamed from: h */
    public boolean f5572h;

    /* renamed from: i */
    public InterfaceC2165p0.InterfaceC2166a f5573i;

    /* renamed from: j */
    public AbstractC1989n0 f5574j;

    /* renamed from: k */
    public PopupWindow.OnDismissListener f5575k;

    /* renamed from: g */
    public int f5571g = 8388611;

    /* renamed from: l */
    public final PopupWindow.OnDismissListener f5576l = new C2014a();

    /* renamed from: o0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2014a implements PopupWindow.OnDismissListener {
        public C2014a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            C2013o0.this.mo542c();
        }
    }

    public C2013o0(Context context, C1905j0 c1905j0, View view, boolean z, int i, int i2) {
        this.f5565a = context;
        this.f5566b = c1905j0;
        this.f5570f = view;
        this.f5567c = z;
        this.f5568d = i;
        this.f5569e = i2;
    }

    /* renamed from: a */
    public AbstractC1989n0 m544a() {
        AbstractC1989n0 view$OnKeyListenerC2244t0;
        if (this.f5574j == null) {
            Display defaultDisplay = ((WindowManager) this.f5565a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= this.f5565a.getResources().getDimensionPixelSize(C1881i.abc_cascading_menus_min_smallest_width)) {
                view$OnKeyListenerC2244t0 = new View$OnKeyListenerC1826g0(this.f5565a, this.f5570f, this.f5568d, this.f5569e, this.f5567c);
            } else {
                view$OnKeyListenerC2244t0 = new View$OnKeyListenerC2244t0(this.f5565a, this.f5566b, this.f5570f, this.f5568d, this.f5569e, this.f5567c);
            }
            view$OnKeyListenerC2244t0.mo393b(this.f5566b);
            view$OnKeyListenerC2244t0.mo388i(this.f5576l);
            view$OnKeyListenerC2244t0.mo392e(this.f5570f);
            view$OnKeyListenerC2244t0.setCallback(this.f5573i);
            view$OnKeyListenerC2244t0.mo391f(this.f5572h);
            view$OnKeyListenerC2244t0.mo390g(this.f5571g);
            this.f5574j = view$OnKeyListenerC2244t0;
        }
        return this.f5574j;
    }

    /* renamed from: b */
    public boolean m543b() {
        AbstractC1989n0 abstractC1989n0 = this.f5574j;
        return abstractC1989n0 != null && abstractC1989n0.mo394a();
    }

    /* renamed from: c */
    public void mo542c() {
        this.f5574j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f5575k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* renamed from: d */
    public void m541d(InterfaceC2165p0.InterfaceC2166a interfaceC2166a) {
        this.f5573i = interfaceC2166a;
        AbstractC1989n0 abstractC1989n0 = this.f5574j;
        if (abstractC1989n0 != null) {
            abstractC1989n0.setCallback(interfaceC2166a);
        }
    }

    /* renamed from: e */
    public final void m540e(int i, int i2, boolean z, boolean z2) {
        AbstractC1989n0 m544a = m544a();
        m544a.mo387j(z2);
        if (z) {
            int i3 = this.f5571g;
            View view = this.f5570f;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if ((Gravity.getAbsoluteGravity(i3, C0492V4.C0496d.m1921d(view)) & 7) == 5) {
                i -= this.f5570f.getWidth();
            }
            m544a.mo389h(i);
            m544a.mo386k(i2);
            int i4 = (int) ((this.f5565a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            m544a.f5507a = new Rect(i - i4, i2 - i4, i + i4, i2 + i4);
        }
        m544a.show();
    }

    /* renamed from: f */
    public boolean m539f() {
        if (m543b()) {
            return true;
        }
        if (this.f5570f == null) {
            return false;
        }
        m540e(0, 0, false, false);
        return true;
    }
}
