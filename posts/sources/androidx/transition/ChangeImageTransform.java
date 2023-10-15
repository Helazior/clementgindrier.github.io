package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;
import p000.C0271L7;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ChangeImageTransform extends Transition {

    /* renamed from: a */
    public static final String[] f3421a = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* renamed from: b */
    public static final TypeEvaluator<Matrix> f3422b = new C0887a();

    /* renamed from: c */
    public static final Property<ImageView, Matrix> f3423c = new C0888b(Matrix.class, "animatedTransform");

    /* renamed from: androidx.transition.ChangeImageTransform$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0887a implements TypeEvaluator<Matrix> {
        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return null;
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0888b extends Property<ImageView, Matrix> {
        public C0888b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        public void set(ImageView imageView, Matrix matrix) {
            ImageView imageView2 = imageView;
            Matrix matrix2 = matrix;
            if (Build.VERSION.SDK_INT >= 29) {
                imageView2.animateTransform(matrix2);
            } else if (matrix2 == null) {
                Drawable drawable = imageView2.getDrawable();
                if (drawable != null) {
                    drawable.setBounds(0, 0, (imageView2.getWidth() - imageView2.getPaddingLeft()) - imageView2.getPaddingRight(), (imageView2.getHeight() - imageView2.getPaddingTop()) - imageView2.getPaddingBottom());
                    imageView2.invalidate();
                }
            } else if (C0043B7.f195a) {
                try {
                    imageView2.animateTransform(matrix2);
                } catch (NoSuchMethodError unused) {
                    C0043B7.f195a = false;
                }
            }
        }
    }

    /* renamed from: androidx.transition.ChangeImageTransform$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static /* synthetic */ class C0889c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f3424a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            f3424a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3424a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ChangeImageTransform() {
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
    }

    public final void captureValues(C0290M7 c0290m7) {
        Matrix matrix;
        View view = c0290m7.f971b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = c0290m7.f970a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            Drawable drawable = imageView.getDrawable();
            if (drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0) {
                int i = C0889c.f3424a[imageView.getScaleType().ordinal()];
                if (i == 1) {
                    Drawable drawable2 = imageView.getDrawable();
                    Matrix matrix2 = new Matrix();
                    matrix2.postScale(imageView.getWidth() / drawable2.getIntrinsicWidth(), imageView.getHeight() / drawable2.getIntrinsicHeight());
                    matrix = matrix2;
                } else if (i == 2) {
                    Drawable drawable3 = imageView.getDrawable();
                    int intrinsicWidth = drawable3.getIntrinsicWidth();
                    float width = imageView.getWidth();
                    float f = intrinsicWidth;
                    int intrinsicHeight = drawable3.getIntrinsicHeight();
                    float height = imageView.getHeight();
                    float f2 = intrinsicHeight;
                    float max = Math.max(width / f, height / f2);
                    int round = Math.round((width - (f * max)) / 2.0f);
                    int round2 = Math.round((height - (f2 * max)) / 2.0f);
                    matrix = new Matrix();
                    matrix.postScale(max, max);
                    matrix.postTranslate(round, round2);
                }
                map.put("android:changeImageTransform:matrix", matrix);
            }
            matrix = new Matrix(imageView.getImageMatrix());
            map.put("android:changeImageTransform:matrix", matrix);
        }
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C0290M7 c0290m7, C0290M7 c0290m72) {
        if (c0290m7 == null || c0290m72 == null) {
            return null;
        }
        Rect rect = (Rect) c0290m7.f970a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) c0290m72.f970a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) c0290m7.f970a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) c0290m72.f970a.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) c0290m72.f971b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            if (matrix == null) {
                matrix = C0063C7.f288a;
            }
            if (matrix2 == null) {
                matrix2 = C0063C7.f288a;
            }
            Property<ImageView, Matrix> property = f3423c;
            property.set(imageView, matrix);
            return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property, (TypeEvaluator) new C0271L7.C0272a(), (Object[]) new Matrix[]{matrix, matrix2});
        }
        Property<ImageView, Matrix> property2 = f3423c;
        TypeEvaluator<Matrix> typeEvaluator = f3422b;
        Matrix matrix3 = C0063C7.f288a;
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) property2, (TypeEvaluator) typeEvaluator, (Object[]) new Matrix[]{matrix3, matrix3});
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f3421a;
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
