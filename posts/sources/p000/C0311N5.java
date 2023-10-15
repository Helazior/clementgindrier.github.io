package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* renamed from: N5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0311N5 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ ViewGroup f1025a;

    /* renamed from: b */
    public final /* synthetic */ View f1026b;

    /* renamed from: c */
    public final /* synthetic */ Fragment f1027c;

    public C0311N5(LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f1025a = viewGroup;
        this.f1026b = view;
        this.f1027c = fragment;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f1025a.endViewTransition(this.f1026b);
        animator.removeListener(this);
        Fragment fragment = this.f1027c;
        View view = fragment.mView;
        if (view == null || !fragment.mHidden) {
            return;
        }
        view.setVisibility(8);
    }
}
