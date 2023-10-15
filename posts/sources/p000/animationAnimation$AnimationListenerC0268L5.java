package p000;

import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;

/* renamed from: L5  reason: invalid class name */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class animationAnimation$AnimationListenerC0268L5 implements Animation.AnimationListener {

    /* renamed from: a */
    public final /* synthetic */ ViewGroup f890a;

    /* renamed from: b */
    public final /* synthetic */ Fragment f891b;

    /* renamed from: c */
    public final /* synthetic */ LayoutInflater$Factory2C0236K5 f892c;

    /* renamed from: L5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0269a implements Runnable {
        public RunnableC0269a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (animationAnimation$AnimationListenerC0268L5.this.f891b.getAnimatingAway() != null) {
                animationAnimation$AnimationListenerC0268L5.this.f891b.setAnimatingAway(null);
                animationAnimation$AnimationListenerC0268L5 animationanimation_animationlistenerc0268l5 = animationAnimation$AnimationListenerC0268L5.this;
                LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = animationanimation_animationlistenerc0268l5.f892c;
                Fragment fragment = animationanimation_animationlistenerc0268l5.f891b;
                layoutInflater$Factory2C0236K5.m2290j0(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
            }
        }
    }

    public animationAnimation$AnimationListenerC0268L5(LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5, ViewGroup viewGroup, Fragment fragment) {
        this.f892c = layoutInflater$Factory2C0236K5;
        this.f890a = viewGroup;
        this.f891b = fragment;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f890a.post(new RunnableC0269a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
