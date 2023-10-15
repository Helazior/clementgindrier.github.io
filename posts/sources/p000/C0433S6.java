package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import p000.C0454T6;

/* renamed from: S6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0433S6 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ C0454T6.C0455a f1410a;

    /* renamed from: b */
    public final /* synthetic */ ViewPropertyAnimator f1411b;

    /* renamed from: c */
    public final /* synthetic */ View f1412c;

    /* renamed from: d */
    public final /* synthetic */ C0454T6 f1413d;

    public C0433S6(C0454T6 c0454t6, C0454T6.C0455a c0455a, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1413d = c0454t6;
        this.f1410a = c0455a;
        this.f1411b = viewPropertyAnimator;
        this.f1412c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1411b.setListener(null);
        this.f1412c.setAlpha(1.0f);
        this.f1412c.setTranslationX(0.0f);
        this.f1412c.setTranslationY(0.0f);
        this.f1413d.m1371c(this.f1410a.f1584b);
        this.f1413d.f1582r.remove(this.f1410a.f1584b);
        this.f1413d.m2006k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        C0454T6 c0454t6 = this.f1413d;
        RecyclerView.AbstractC0824B abstractC0824B = this.f1410a.f1584b;
        Objects.requireNonNull(c0454t6);
    }
}
