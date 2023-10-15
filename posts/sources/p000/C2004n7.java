package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.animation.Animation;
import android.widget.ImageView;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: n7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2004n7 extends ImageView {

    /* renamed from: a */
    public Animation.AnimationListener f5547a;

    /* renamed from: b */
    public int f5548b;

    /* renamed from: c */
    public int f5549c;

    public C2004n7(Context context) {
        super(context);
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f5548b = (int) (3.5f * f);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(C1980m7.SwipeRefreshLayout);
        this.f5549c = obtainStyledAttributes.getColor(C1980m7.f5492xaa980688, -328966);
        obtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0500h.m1882s(this, f * 4.0f);
        shapeDrawable.getPaint().setColor(this.f5549c);
        C0492V4.C0495c.m1927q(this, shapeDrawable);
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        super.onAnimationEnd();
        Animation.AnimationListener animationListener = this.f5547a;
        if (animationListener != null) {
            animationListener.onAnimationEnd(getAnimation());
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        super.onAnimationStart();
        Animation.AnimationListener animationListener = this.f5547a;
        if (animationListener != null) {
            animationListener.onAnimationStart(getAnimation());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
            this.f5549c = i;
        }
    }
}
