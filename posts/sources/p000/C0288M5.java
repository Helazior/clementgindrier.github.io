package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* renamed from: M5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0288M5 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ ViewGroup f964a;

    /* renamed from: b */
    public final /* synthetic */ View f965b;

    /* renamed from: c */
    public final /* synthetic */ Fragment f966c;

    /* renamed from: d */
    public final /* synthetic */ LayoutInflater$Factory2C0236K5 f967d;

    public C0288M5(LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f967d = layoutInflater$Factory2C0236K5;
        this.f964a = viewGroup;
        this.f965b = view;
        this.f966c = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f964a.endViewTransition(this.f965b);
        Animator animator2 = this.f966c.getAnimator();
        this.f966c.setAnimator(null);
        if (animator2 == null || this.f964a.indexOfChild(this.f965b) >= 0) {
            return;
        }
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f967d;
        Fragment fragment = this.f966c;
        layoutInflater$Factory2C0236K5.m2290j0(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
    }
}
