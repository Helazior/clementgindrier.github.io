package p000;

import android.animation.TypeEvaluator;

/* renamed from: v7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2293v7 implements TypeEvaluator<float[]> {

    /* renamed from: a */
    public float[] f6699a;

    public C2293v7(float[] fArr) {
        this.f6699a = fArr;
    }

    @Override // android.animation.TypeEvaluator
    public float[] evaluate(float f, float[] fArr, float[] fArr2) {
        float[] fArr3 = fArr;
        float[] fArr4 = fArr2;
        float[] fArr5 = this.f6699a;
        if (fArr5 == null) {
            fArr5 = new float[fArr3.length];
        }
        for (int i = 0; i < fArr5.length; i++) {
            float f2 = fArr3[i];
            fArr5[i] = outline.m270a(fArr4[i], f2, f, f2);
        }
        return fArr5;
    }
}
