package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* renamed from: O6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0334O6 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.AbstractC0824B f1125a;

    /* renamed from: b */
    public final /* synthetic */ ViewPropertyAnimator f1126b;

    /* renamed from: c */
    public final /* synthetic */ View f1127c;

    /* renamed from: d */
    public final /* synthetic */ C0454T6 f1128d;

    public C0334O6(C0454T6 c0454t6, RecyclerView.AbstractC0824B abstractC0824B, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1128d = c0454t6;
        this.f1125a = abstractC0824B;
        this.f1126b = viewPropertyAnimator;
        this.f1127c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1126b.setListener(null);
        this.f1127c.setAlpha(1.0f);
        this.f1128d.m1371c(this.f1125a);
        this.f1128d.f1581q.remove(this.f1125a);
        this.f1128d.m2006k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f1128d);
    }
}
