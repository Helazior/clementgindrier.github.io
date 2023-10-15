package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import p000.C0454T6;

/* renamed from: R6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0398R6 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ C0454T6.C0455a f1346a;

    /* renamed from: b */
    public final /* synthetic */ ViewPropertyAnimator f1347b;

    /* renamed from: c */
    public final /* synthetic */ View f1348c;

    /* renamed from: d */
    public final /* synthetic */ C0454T6 f1349d;

    public C0398R6(C0454T6 c0454t6, C0454T6.C0455a c0455a, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f1349d = c0454t6;
        this.f1346a = c0455a;
        this.f1347b = viewPropertyAnimator;
        this.f1348c = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1347b.setListener(null);
        this.f1348c.setAlpha(1.0f);
        this.f1348c.setTranslationX(0.0f);
        this.f1348c.setTranslationY(0.0f);
        this.f1349d.m1371c(this.f1346a.f1583a);
        this.f1349d.f1582r.remove(this.f1346a.f1583a);
        this.f1349d.m2006k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        C0454T6 c0454t6 = this.f1349d;
        RecyclerView.AbstractC0824B abstractC0824B = this.f1346a.f1583a;
        Objects.requireNonNull(c0454t6);
    }
}
