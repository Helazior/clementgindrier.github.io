package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* renamed from: a */
    public TypedValue f2499a;

    /* renamed from: b */
    public TypedValue f2500b;

    /* renamed from: c */
    public TypedValue f2501c;

    /* renamed from: d */
    public TypedValue f2502d;

    /* renamed from: f */
    public TypedValue f2503f;

    /* renamed from: g */
    public TypedValue f2504g;

    /* renamed from: h */
    public final Rect f2505h;

    /* renamed from: i */
    public InterfaceC0670a f2506i;

    /* renamed from: androidx.appcompat.widget.ContentFrameLayout$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0670a {
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        InterfaceC0670a interfaceC0670a = this.f2506i;
        if (interfaceC0670a != null) {
            Objects.requireNonNull((C0051C) interfaceC0670a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0670a interfaceC0670a = this.f2506i;
        if (interfaceC0670a != null) {
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = ((C0051C) interfaceC0670a).f221a;
            InterfaceC0210J0 interfaceC0210J0 = layoutInflater$Factory2C0000A.f37l;
            if (interfaceC0210J0 != null) {
                interfaceC0210J0.mo1663g();
            }
            if (layoutInflater$Factory2C0000A.f42q != null) {
                layoutInflater$Factory2C0000A.f31f.getDecorView().removeCallbacks(layoutInflater$Factory2C0000A.f43r);
                if (layoutInflater$Factory2C0000A.f42q.isShowing()) {
                    try {
                        layoutInflater$Factory2C0000A.f42q.dismiss();
                    } catch (IllegalArgumentException unused) {
                    }
                }
                layoutInflater$Factory2C0000A.f42q = null;
            }
            layoutInflater$Factory2C0000A.m2701H();
            C1905j0 c1905j0 = layoutInflater$Factory2C0000A.m2696M(0).f94h;
            if (c1905j0 != null) {
                c1905j0.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public void setAttachListener(InterfaceC0670a interfaceC0670a) {
        this.f2506i = interfaceC0670a;
    }

    public void setDecorPadding(int i, int i2, int i3, int i4) {
        this.f2505h.set(i, i2, i3, i4);
        AtomicInteger atomicInteger = C0492V4.f1798a;
        if (C0492V4.C0498f.m1908c(this)) {
            requestLayout();
        }
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2505h = new Rect();
    }
}
