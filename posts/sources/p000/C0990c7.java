package p000;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: c7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0990c7 extends C0558X6 {

    /* renamed from: a */
    public final /* synthetic */ C1622d7 f3796a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0990c7(C1622d7 c1622d7, Context context) {
        super(context);
        this.f3796a = c1622d7;
    }

    @Override // p000.C0558X6
    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // p000.C0558X6
    public int calculateTimeForScrolling(int i) {
        return Math.min(100, super.calculateTimeForScrolling(i));
    }

    @Override // p000.C0558X6, androidx.recyclerview.widget.RecyclerView.AbstractC0857x
    public void onTargetFound(View view, RecyclerView.C0860y c0860y, RecyclerView.AbstractC0857x.C0858a c0858a) {
        C1622d7 c1622d7 = this.f3796a;
        int[] mo794b = c1622d7.mo794b(c1622d7.f5082a.getLayoutManager(), view);
        int i = mo794b[0];
        int i2 = mo794b[1];
        int calculateTimeForDeceleration = calculateTimeForDeceleration(Math.max(Math.abs(i), Math.abs(i2)));
        if (calculateTimeForDeceleration > 0) {
            c0858a.m1343b(i, i2, calculateTimeForDeceleration, this.mDecelerateInterpolator);
        }
    }
}
