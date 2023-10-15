package p000;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.LayoutInflater$Factory2C0000A;

@SuppressLint({"ViewConstructor"})
/* renamed from: A7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0021A7 extends ViewGroup implements InterfaceC2351x7 {

    /* renamed from: h */
    public static final /* synthetic */ int f130h = 0;

    /* renamed from: a */
    public ViewGroup f131a;

    /* renamed from: b */
    public View f132b;

    /* renamed from: c */
    public final View f133c;

    /* renamed from: d */
    public int f134d;

    /* renamed from: f */
    public Matrix f135f;

    /* renamed from: g */
    public final ViewTreeObserver.OnPreDrawListener f136g;

    /* renamed from: A7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ViewTreeObserver$OnPreDrawListenerC0022a implements ViewTreeObserver.OnPreDrawListener {
        public ViewTreeObserver$OnPreDrawListenerC0022a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            C0021A7 c0021a7 = C0021A7.this;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1933k(c0021a7);
            C0021A7 c0021a72 = C0021A7.this;
            ViewGroup viewGroup = c0021a72.f131a;
            if (viewGroup == null || (view = c0021a72.f132b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            C0492V4.C0495c.m1933k(C0021A7.this.f131a);
            C0021A7 c0021a73 = C0021A7.this;
            c0021a73.f131a = null;
            c0021a73.f132b = null;
            return true;
        }
    }

    public C0021A7(View view) {
        super(view.getContext());
        this.f136g = new ViewTreeObserver$OnPreDrawListenerC0022a();
        this.f133c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    /* renamed from: b */
    public static void m2588b(View view, View view2) {
        C0399R7.m2045b(view2, view2.getLeft(), view2.getTop(), view.getWidth() + view2.getLeft(), view.getHeight() + view2.getTop());
    }

    /* renamed from: c */
    public static C0021A7 m2587c(View view) {
        return (C0021A7) view.getTag(C0090D7.ghost_view);
    }

    @Override // p000.InterfaceC2351x7
    /* renamed from: a */
    public void mo4a(ViewGroup viewGroup, View view) {
        this.f131a = viewGroup;
        this.f132b = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f133c.setTag(C0090D7.ghost_view, this);
        this.f133c.getViewTreeObserver().addOnPreDrawListener(this.f136g);
        C0399R7.f1350a.mo1796g(this.f133c, 4);
        if (this.f133c.getParent() != null) {
            ((View) this.f133c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f133c.getViewTreeObserver().removeOnPreDrawListener(this.f136g);
        C0399R7.f1350a.mo1796g(this.f133c, 0);
        this.f133c.setTag(C0090D7.ghost_view, null);
        if (this.f133c.getParent() != null) {
            ((View) this.f133c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        LayoutInflater$Factory2C0000A.C0010h.m2609v(canvas, true);
        canvas.setMatrix(this.f135f);
        View view = this.f133c;
        C0559X7 c0559x7 = C0399R7.f1350a;
        c0559x7.mo1796g(view, 0);
        this.f133c.invalidate();
        c0559x7.mo1796g(this.f133c, 4);
        drawChild(canvas, this.f133c, getDrawingTime());
        LayoutInflater$Factory2C0000A.C0010h.m2609v(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View, p000.InterfaceC2351x7
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (m2587c(this.f133c) == this) {
            C0399R7.f1350a.mo1796g(this.f133c, i == 0 ? 4 : 0);
        }
    }
}
