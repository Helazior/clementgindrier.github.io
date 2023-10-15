package p000;

import android.animation.TypeEvaluator;
import android.graphics.Rect;

/* renamed from: E7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0114E7 implements TypeEvaluator<Rect> {

    /* renamed from: a */
    public Rect f395a;

    public C0114E7() {
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, Rect rect, Rect rect2) {
        Rect rect3 = rect;
        Rect rect4 = rect2;
        int i = rect3.left;
        int i2 = i + ((int) ((rect4.left - i) * f));
        int i3 = rect3.top;
        int i4 = i3 + ((int) ((rect4.top - i3) * f));
        int i5 = rect3.right;
        int i6 = i5 + ((int) ((rect4.right - i5) * f));
        int i7 = rect3.bottom;
        int i8 = i7 + ((int) ((rect4.bottom - i7) * f));
        Rect rect5 = this.f395a;
        if (rect5 == null) {
            return new Rect(i2, i4, i6, i8);
        }
        rect5.set(i2, i4, i6, i8);
        return this.f395a;
    }

    public C0114E7(Rect rect) {
        this.f395a = rect;
    }
}
