package com.tekle.oss.android.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FlipAnimation extends Animation {
    public static final float SCALE_DEFAULT = 0.75f;
    private Camera mCamera;
    private final float mCenterX;
    private final float mCenterY;
    private final float mFromDegrees;
    private final float mToDegrees;
    private float scale;
    private final ScaleUpDownEnum scaleType;

    /* renamed from: com.tekle.oss.android.animation.FlipAnimation$1 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static /* synthetic */ class C15941 {

        /* renamed from: $SwitchMap$com$tekle$oss$android$animation$FlipAnimation$ScaleUpDownEnum */
        public static final /* synthetic */ int[] f3938xdb05edd;

        static {
            ScaleUpDownEnum.values();
            int[] iArr = new int[4];
            f3938xdb05edd = iArr;
            try {
                ScaleUpDownEnum scaleUpDownEnum = ScaleUpDownEnum.SCALE_UP;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f3938xdb05edd;
                ScaleUpDownEnum scaleUpDownEnum2 = ScaleUpDownEnum.SCALE_DOWN;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f3938xdb05edd;
                ScaleUpDownEnum scaleUpDownEnum3 = ScaleUpDownEnum.SCALE_CYCLE;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum ScaleUpDownEnum {
        SCALE_UP,
        SCALE_DOWN,
        SCALE_CYCLE,
        SCALE_NONE;

        public float getScale(float f, float f2) {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        return 1.0f;
                    }
                    if (((double) f2) > 0.5d) {
                        return ((f2 - 0.5f) * (1.0f - f) * 2.0f) + f;
                    }
                    return 1.0f - ((f2 * 2.0f) * (1.0f - f));
                }
                return 1.0f - ((1.0f - f) * f2);
            }
            return outline.m270a(1.0f, f, f2, f);
        }
    }

    public FlipAnimation(float f, float f2, float f3, float f4, float f5, ScaleUpDownEnum scaleUpDownEnum) {
        this.mFromDegrees = f;
        this.mToDegrees = f2;
        this.mCenterX = f3;
        this.mCenterY = f4;
        this.scale = (f5 <= 0.0f || f5 >= 1.0f) ? 0.75f : 0.75f;
        this.scaleType = scaleUpDownEnum == null ? ScaleUpDownEnum.SCALE_CYCLE : scaleUpDownEnum;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.mFromDegrees;
        float m270a = outline.m270a(this.mToDegrees, f2, f, f2);
        float f3 = this.mCenterX;
        float f4 = this.mCenterY;
        Camera camera = this.mCamera;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        camera.rotateY(m270a);
        camera.getMatrix(matrix);
        camera.restore();
        matrix.preTranslate(-f3, -f4);
        matrix.postTranslate(f3, f4);
        matrix.preScale(this.scaleType.getScale(this.scale, f), this.scaleType.getScale(this.scale, f), f3, f4);
    }

    @Override // android.view.animation.Animation
    public void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.mCamera = new Camera();
    }
}
