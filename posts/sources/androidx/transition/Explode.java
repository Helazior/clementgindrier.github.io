package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Explode extends Visibility {

    /* renamed from: b */
    public static final TimeInterpolator f3448b = new DecelerateInterpolator();

    /* renamed from: c */
    public static final TimeInterpolator f3449c = new AccelerateInterpolator();

    /* renamed from: a */
    public int[] f3450a;

    public Explode() {
        this.f3450a = new int[2];
        setPropagation(new C2275u7());
    }

    /* renamed from: a */
    public final void m1273a(View view, Rect rect, int[] iArr) {
        int centerX;
        int centerY;
        view.getLocationOnScreen(this.f3450a);
        int[] iArr2 = this.f3450a;
        int i = iArr2[0];
        int i2 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            centerX = Math.round(view.getTranslationX()) + (view.getWidth() / 2) + i;
            centerY = Math.round(view.getTranslationY()) + (view.getHeight() / 2) + i2;
        } else {
            centerX = epicenter.centerX();
            centerY = epicenter.centerY();
        }
        float centerX2 = rect.centerX() - centerX;
        float centerY2 = rect.centerY() - centerY;
        if (centerX2 == 0.0f && centerY2 == 0.0f) {
            centerX2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY2 = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float sqrt = (float) Math.sqrt((centerY2 * centerY2) + (centerX2 * centerX2));
        int i3 = centerX - i;
        int i4 = centerY - i2;
        float max = Math.max(i3, view.getWidth() - i3);
        float max2 = Math.max(i4, view.getHeight() - i4);
        float sqrt2 = (float) Math.sqrt((max2 * max2) + (max * max));
        iArr[0] = Math.round((centerX2 / sqrt) * sqrt2);
        iArr[1] = Math.round(sqrt2 * (centerY2 / sqrt));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(C0290M7 c0290m7) {
        super.captureEndValues(c0290m7);
        captureValues(c0290m7);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(C0290M7 c0290m7) {
        super.captureStartValues(c0290m7);
        captureValues(c0290m7);
    }

    public final void captureValues(C0290M7 c0290m7) {
        View view = c0290m7.f971b;
        view.getLocationOnScreen(this.f3450a);
        int[] iArr = this.f3450a;
        int i = iArr[0];
        int i2 = iArr[1];
        c0290m7.f970a.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        Rect rect = (Rect) c0290m72.f970a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        m1273a(viewGroup, rect, this.f3450a);
        int[] iArr = this.f3450a;
        return C0335O7.m2161a(view, c0290m72, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, f3448b, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        float f;
        float f2;
        Rect rect = (Rect) c0290m7.f970a.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c0290m7.f971b.getTag(C0090D7.transition_position);
        if (iArr != null) {
            f = (iArr[0] - rect.left) + translationX;
            f2 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        m1273a(viewGroup, rect, this.f3450a);
        int[] iArr2 = this.f3450a;
        return C0335O7.m2161a(view, c0290m7, i, i2, translationX, translationY, f + iArr2[0], f2 + iArr2[1], f3449c, this);
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3450a = new int[2];
        setPropagation(new C2275u7());
    }
}
