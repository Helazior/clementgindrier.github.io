package p000;

import android.graphics.drawable.Drawable;

/* renamed from: w1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2305w1 extends Drawable {

    /* renamed from: a */
    public static final double f6734a = Math.cos(Math.toRadians(45.0d));

    /* renamed from: a */
    public static float m221a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((1.0d - f6734a) * f2) + f);
        }
        return f;
    }

    /* renamed from: b */
    public static float m220b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((1.0d - f6734a) * f2) + (f * 1.5f));
        }
        return f * 1.5f;
    }
}
