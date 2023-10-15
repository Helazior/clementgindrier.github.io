package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;

/* renamed from: Q6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0373Q6 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ RecyclerView.AbstractC0824B f1266a;

    /* renamed from: b */
    public final /* synthetic */ int f1267b;

    /* renamed from: c */
    public final /* synthetic */ View f1268c;

    /* renamed from: d */
    public final /* synthetic */ int f1269d;

    /* renamed from: e */
    public final /* synthetic */ ViewPropertyAnimator f1270e;

    /* renamed from: f */
    public final /* synthetic */ C0454T6 f1271f;

    public C0373Q6(C0454T6 c0454t6, RecyclerView.AbstractC0824B abstractC0824B, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f1271f = c0454t6;
        this.f1266a = abstractC0824B;
        this.f1267b = i;
        this.f1268c = view;
        this.f1269d = i2;
        this.f1270e = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        if (this.f1267b != 0) {
            this.f1268c.setTranslationX(0.0f);
        }
        if (this.f1269d != 0) {
            this.f1268c.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1270e.setListener(null);
        this.f1271f.m1371c(this.f1266a);
        this.f1271f.f1580p.remove(this.f1266a);
        this.f1271f.m2006k();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Objects.requireNonNull(this.f1271f);
    }
}
