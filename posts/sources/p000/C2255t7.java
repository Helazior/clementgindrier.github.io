package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.view.View;
import androidx.transition.ChangeTransform;

/* renamed from: t7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2255t7 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public boolean f6552a;

    /* renamed from: b */
    public Matrix f6553b = new Matrix();

    /* renamed from: c */
    public final /* synthetic */ boolean f6554c;

    /* renamed from: d */
    public final /* synthetic */ Matrix f6555d;

    /* renamed from: e */
    public final /* synthetic */ View f6556e;

    /* renamed from: f */
    public final /* synthetic */ ChangeTransform.C0894e f6557f;

    /* renamed from: g */
    public final /* synthetic */ ChangeTransform.C0893d f6558g;

    /* renamed from: h */
    public final /* synthetic */ ChangeTransform f6559h;

    public C2255t7(ChangeTransform changeTransform, boolean z, Matrix matrix, View view, ChangeTransform.C0894e c0894e, ChangeTransform.C0893d c0893d) {
        this.f6559h = changeTransform;
        this.f6554c = z;
        this.f6555d = matrix;
        this.f6556e = view;
        this.f6557f = c0894e;
        this.f6558g = c0893d;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f6552a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.f6552a) {
            if (this.f6554c && this.f6559h.f3430a) {
                this.f6553b.set(this.f6555d);
                this.f6556e.setTag(C0090D7.transition_transform, this.f6553b);
                this.f6557f.m1274a(this.f6556e);
            } else {
                this.f6556e.setTag(C0090D7.transition_transform, null);
                this.f6556e.setTag(C0090D7.parent_matrix, null);
            }
        }
        C0399R7.f1350a.mo1799d(this.f6556e, null);
        this.f6557f.m1274a(this.f6556e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        this.f6553b.set(this.f6558g.f3435a);
        this.f6556e.setTag(C0090D7.transition_transform, this.f6553b);
        this.f6557f.m1274a(this.f6556e);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        ChangeTransform.m1276a(this.f6556e);
    }
}
