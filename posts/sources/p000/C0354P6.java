package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* renamed from: P6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0354P6 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.AbstractC0824B f1212a;

    /* renamed from: b */
    public final /* synthetic */ View f1213b;

    /* renamed from: c */
    public final /* synthetic */ ViewPropertyAnimator f1214c;

    /* renamed from: d */
    public final /* synthetic */ C0454T6 f1215d;

    public C0354P6(C0454T6 c0454t6, RecyclerView.AbstractC0824B abstractC0824B, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1215d = c0454t6;
        this.f1212a = abstractC0824B;
        this.f1213b = view;
        this.f1214c = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f1213b.setAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1214c.setListener(null);
        this.f1215d.m1371c(this.f1212a);
        this.f1215d.f1579o.remove(this.f1212a);
        this.f1215d.m2006k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f1215d);
    }
}
