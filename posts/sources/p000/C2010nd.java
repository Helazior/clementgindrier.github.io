package p000;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import org.jetbrains.annotations.NotNull;

/* renamed from: nd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2010nd extends Animation {

    /* renamed from: a */
    public final /* synthetic */ View f5558a;

    /* renamed from: b */
    public final /* synthetic */ int f5559b;

    public C2010nd(View view, int i) {
        this.f5558a = view;
        this.f5559b = i;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, @NotNull Transformation transformation) {
        C0581Yd.m1766e(transformation, "t");
        this.f5558a.getLayoutParams().height = f == 1.0f ? -2 : (int) (this.f5559b * f);
        this.f5558a.requestLayout();
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}
