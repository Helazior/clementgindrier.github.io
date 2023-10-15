package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: X4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0554X4 {

    /* renamed from: a */
    public WeakReference<View> f1987a;

    /* renamed from: b */
    public int f1988b = -1;

    /* renamed from: X4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0555a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC0571Y4 f1989a;

        /* renamed from: b */
        public final /* synthetic */ View f1990b;

        public C0555a(C0554X4 c0554x4, InterfaceC0571Y4 interfaceC0571Y4, View view) {
            this.f1989a = interfaceC0571Y4;
            this.f1990b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1989a.mo224a(this.f1990b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1989a.mo223b(this.f1990b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f1989a.mo222c(this.f1990b);
        }
    }

    /* renamed from: X4$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0556b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC0609a5 f1991a;

        /* renamed from: b */
        public final /* synthetic */ View f1992b;

        public C0556b(C0554X4 c0554x4, InterfaceC0609a5 interfaceC0609a5, View view) {
            this.f1991a = interfaceC0609a5;
            this.f1992b = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ((View) C0258L.this.f848d.getParent()).invalidate();
        }
    }

    public C0554X4(View view) {
        this.f1987a = new WeakReference<>(view);
    }

    /* renamed from: a */
    public C0554X4 m1809a(float f) {
        View view = this.f1987a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* renamed from: b */
    public void m1808b() {
        View view = this.f1987a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* renamed from: c */
    public C0554X4 m1807c(long j) {
        View view = this.f1987a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* renamed from: d */
    public C0554X4 m1806d(InterfaceC0571Y4 interfaceC0571Y4) {
        View view = this.f1987a.get();
        if (view != null) {
            m1805e(view, interfaceC0571Y4);
        }
        return this;
    }

    /* renamed from: e */
    public final void m1805e(View view, InterfaceC0571Y4 interfaceC0571Y4) {
        if (interfaceC0571Y4 != null) {
            view.animate().setListener(new C0555a(this, interfaceC0571Y4, view));
        } else {
            view.animate().setListener(null);
        }
    }

    /* renamed from: f */
    public C0554X4 m1804f(InterfaceC0609a5 interfaceC0609a5) {
        View view = this.f1987a.get();
        if (view != null) {
            view.animate().setUpdateListener(interfaceC0609a5 != null ? new C0556b(this, interfaceC0609a5, view) : null);
        }
        return this;
    }

    /* renamed from: g */
    public C0554X4 m1803g(float f) {
        View view = this.f1987a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }
}
