package p000;

import android.animation.ValueAnimator;
import p000.C2195q7;

/* renamed from: o7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2023o7 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ C2195q7.C2196a f5588a;

    /* renamed from: b */
    public final /* synthetic */ C2195q7 f5589b;

    public C2023o7(C2195q7 c2195q7, C2195q7.C2196a c2196a) {
        this.f5589b = c2195q7;
        this.f5588a = c2196a;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f5589b.m427d(floatValue, this.f5588a);
        this.f5589b.m430a(floatValue, this.f5588a, false);
        this.f5589b.invalidateSelf();
    }
}
