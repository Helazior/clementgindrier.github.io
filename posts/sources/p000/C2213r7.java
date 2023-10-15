package p000;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

/* renamed from: r7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2213r7 extends Animation {

    /* renamed from: a */
    public final /* synthetic */ SwipeRefreshLayout f6345a;

    public C2213r7(SwipeRefreshLayout swipeRefreshLayout) {
        this.f6345a = swipeRefreshLayout;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f6345a;
        swipeRefreshLayout.f3373v.setScaleX(f);
        swipeRefreshLayout.f3373v.setScaleY(f);
    }
}
