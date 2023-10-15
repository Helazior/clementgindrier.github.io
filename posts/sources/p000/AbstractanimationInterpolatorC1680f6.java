package p000;

import android.view.animation.Interpolator;

/* renamed from: f6  reason: invalid class name */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractanimationInterpolatorC1680f6 implements Interpolator {

    /* renamed from: a */
    public final float[] f4178a;

    /* renamed from: b */
    public final float f4179b;

    public AbstractanimationInterpolatorC1680f6(float[] fArr) {
        this.f4178a = fArr;
        this.f4179b = 1.0f / (fArr.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f4178a;
        int min = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f4179b;
        float f3 = (f - (min * f2)) / f2;
        float[] fArr2 = this.f4178a;
        return outline.m270a(fArr2[min + 1], fArr2[min], f3, fArr2[min]);
    }
}
