package p000;

import android.animation.TypeEvaluator;

/* renamed from: f8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1682f8 implements TypeEvaluator {

    /* renamed from: a */
    public static final C1682f8 f4181a = new C1682f8();

    @Override // android.animation.TypeEvaluator
    public Object evaluate(float f, Object obj, Object obj2) {
        int intValue = ((Integer) obj).intValue();
        float f2 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = ((Integer) obj2).intValue();
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float m270a = outline.m270a(((intValue2 >> 24) & 255) / 255.0f, f2, f, f2);
        float m270a2 = outline.m270a(pow4, pow, f, pow);
        float m270a3 = outline.m270a((float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d), pow2, f, pow2);
        float m270a4 = outline.m270a((float) Math.pow((intValue2 & 255) / 255.0f, 2.2d), pow3, f, pow3);
        int round = Math.round(((float) Math.pow(m270a2, 0.45454545454545453d)) * 255.0f) << 16;
        return Integer.valueOf(Math.round(((float) Math.pow(m270a4, 0.45454545454545453d)) * 255.0f) | round | (Math.round(m270a * 255.0f) << 24) | (Math.round(((float) Math.pow(m270a3, 0.45454545454545453d)) * 255.0f) << 8));
    }
}
