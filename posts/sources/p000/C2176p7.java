package p000;

import android.animation.Animator;
import p000.C2195q7;

/* renamed from: p7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2176p7 implements Animator.AnimatorListener {

    /* renamed from: a */
    public final /* synthetic */ C2195q7.C2196a f6233a;

    /* renamed from: b */
    public final /* synthetic */ C2195q7 f6234b;

    public C2176p7(C2195q7 c2195q7, C2195q7.C2196a c2196a) {
        this.f6234b = c2195q7;
        this.f6233a = c2196a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.f6234b.m430a(1.0f, this.f6233a, true);
        C2195q7.C2196a c2196a = this.f6233a;
        c2196a.f6283k = c2196a.f6277e;
        c2196a.f6284l = c2196a.f6278f;
        c2196a.f6285m = c2196a.f6279g;
        c2196a.m426a((c2196a.f6282j + 1) % c2196a.f6281i.length);
        C2195q7 c2195q7 = this.f6234b;
        if (c2195q7.f6272g) {
            c2195q7.f6272g = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f6233a.m425b(false);
            return;
        }
        c2195q7.f6271f += 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f6234b.f6271f = 0.0f;
    }
}
