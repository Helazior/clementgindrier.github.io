package p000;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import android.os.Build;

/* renamed from: L7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0271L7 {

    /* renamed from: a */
    public static final boolean f896a;

    /* renamed from: b */
    public static final boolean f897b;

    /* renamed from: c */
    public static final boolean f898c;

    /* renamed from: L7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0272a implements TypeEvaluator<Matrix> {

        /* renamed from: a */
        public final float[] f899a = new float[9];

        /* renamed from: b */
        public final float[] f900b = new float[9];

        /* renamed from: c */
        public final Matrix f901c = new Matrix();

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            matrix.getValues(this.f899a);
            matrix2.getValues(this.f900b);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f900b;
                float f2 = fArr[i];
                float[] fArr2 = this.f899a;
                fArr[i] = ((f2 - fArr2[i]) * f) + fArr2[i];
            }
            this.f901c.setValues(this.f900b);
            return this.f901c;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f896a = true;
        f897b = true;
        f898c = i >= 28;
    }

    /* renamed from: a */
    public static Animator m2218a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator, animator2);
        return animatorSet;
    }
}
