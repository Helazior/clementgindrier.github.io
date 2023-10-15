package p000;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import org.jetbrains.annotations.NotNull;

/* renamed from: md */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1986md extends Animation {

    /* renamed from: a */
    public final /* synthetic */ View f5505a;

    /* renamed from: b */
    public final /* synthetic */ int f5506b;

    public C1986md(View view, int i) {
        this.f5505a = view;
        this.f5506b = i;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, @NotNull Transformation transformation) {
        C0581Yd.m1766e(transformation, "t");
        if (f == 1.0f) {
            this.f5505a.setVisibility(8);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f5505a.getLayoutParams();
        int i = this.f5506b;
        layoutParams.height = i - ((int) (i * f));
        this.f5505a.requestLayout();
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}
