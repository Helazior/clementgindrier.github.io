package p000;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* renamed from: O0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractView$OnTouchListenerC0325O0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final float f1102a;

    /* renamed from: b */
    public final int f1103b;

    /* renamed from: c */
    public final int f1104c;

    /* renamed from: d */
    public final View f1105d;

    /* renamed from: f */
    public Runnable f1106f;

    /* renamed from: g */
    public Runnable f1107g;

    /* renamed from: h */
    public boolean f1108h;

    /* renamed from: i */
    public int f1109i;

    /* renamed from: j */
    public final int[] f1110j = new int[2];

    /* renamed from: O0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0326a implements Runnable {
        public RunnableC0326a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = AbstractView$OnTouchListenerC0325O0.this.f1105d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* renamed from: O0$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0327b implements Runnable {
        public RunnableC0327b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractView$OnTouchListenerC0325O0 abstractView$OnTouchListenerC0325O0 = AbstractView$OnTouchListenerC0325O0.this;
            abstractView$OnTouchListenerC0325O0.m2165a();
            View view = abstractView$OnTouchListenerC0325O0.f1105d;
            if (view.isEnabled() && !view.isLongClickable() && abstractView$OnTouchListenerC0325O0.mo1639c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                abstractView$OnTouchListenerC0325O0.f1108h = true;
            }
        }
    }

    public AbstractView$OnTouchListenerC0325O0(View view) {
        this.f1105d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1102a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1103b = tapTimeout;
        this.f1104c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    /* renamed from: a */
    public final void m2165a() {
        Runnable runnable = this.f1107g;
        if (runnable != null) {
            this.f1105d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1106f;
        if (runnable2 != null) {
            this.f1105d.removeCallbacks(runnable2);
        }
    }

    /* renamed from: b */
    public abstract InterfaceC2222s0 mo1640b();

    /* renamed from: c */
    public abstract boolean mo1639c();

    /* renamed from: d */
    public boolean mo1638d() {
        InterfaceC2222s0 mo1640b = mo1640b();
        if (mo1640b == null || !mo1640b.mo394a()) {
            return true;
        }
        mo1640b.dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
        if (r4 != 3) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0113  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractView$OnTouchListenerC0325O0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1108h = false;
        this.f1109i = -1;
        Runnable runnable = this.f1106f;
        if (runnable != null) {
            this.f1105d.removeCallbacks(runnable);
        }
    }
}
