package p000;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;

/* renamed from: P4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ViewTreeObserver$OnPreDrawListenerC0351P4 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a */
    public final View f1185a;

    /* renamed from: b */
    public ViewTreeObserver f1186b;

    /* renamed from: c */
    public final Runnable f1187c;

    public ViewTreeObserver$OnPreDrawListenerC0351P4(View view, Runnable runnable) {
        this.f1185a = view;
        this.f1186b = view.getViewTreeObserver();
        this.f1187c = runnable;
    }

    /* renamed from: a */
    public static ViewTreeObserver$OnPreDrawListenerC0351P4 m2156a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        ViewTreeObserver$OnPreDrawListenerC0351P4 viewTreeObserver$OnPreDrawListenerC0351P4 = new ViewTreeObserver$OnPreDrawListenerC0351P4(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC0351P4);
        view.addOnAttachStateChangeListener(viewTreeObserver$OnPreDrawListenerC0351P4);
        return viewTreeObserver$OnPreDrawListenerC0351P4;
    }

    /* renamed from: b */
    public void m2155b() {
        if (this.f1186b.isAlive()) {
            this.f1186b.removeOnPreDrawListener(this);
        } else {
            this.f1185a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f1185a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        m2155b();
        this.f1187c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f1186b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m2155b();
    }
}
