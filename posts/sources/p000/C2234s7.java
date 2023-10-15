package p000;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* renamed from: s7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2234s7 extends Animation {

    /* renamed from: a */
    public final /* synthetic */ SwipeRefreshLayout f6394a;

    public C2234s7(SwipeRefreshLayout swipeRefreshLayout) {
        this.f6394a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f6394a;
        float f2 = swipeRefreshLayout.f3376y;
        swipeRefreshLayout.m1285i(((-f2) * f) + f2);
        this.f6394a.m1288f(f);
    }
}
