package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: C0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0052C0 {

    /* renamed from: a */
    public final ImageView f222a;

    /* renamed from: b */
    public C0584Z0 f223b;

    public C0052C0(ImageView imageView) {
        this.f222a = imageView;
    }

    /* renamed from: a */
    public void m2550a() {
        C0584Z0 c0584z0;
        Drawable drawable = this.f222a.getDrawable();
        if (drawable != null) {
            int[] iArr = C0263L0.f878a;
        }
        if (drawable == null || (c0584z0 = this.f223b) == null) {
            return;
        }
        C0032B0.m2575f(drawable, c0584z0, this.f222a.getDrawableState());
    }

    /* renamed from: b */
    public void m2549b(AttributeSet attributeSet, int i) {
        int m1201m;
        Context context = this.f222a.getContext();
        int[] iArr = C2012o.AppCompatImageView;
        C0954b1 m1196r = C0954b1.m1196r(context, attributeSet, iArr, i, 0);
        ImageView imageView = this.f222a;
        C0492V4.m1951t(imageView, imageView.getContext(), iArr, attributeSet, m1196r.f3660b, i, 0);
        try {
            Drawable drawable = this.f222a.getDrawable();
            if (drawable == null && (m1201m = m1196r.m1201m(C2012o.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = C0279M.m2210b(this.f222a.getContext(), m1201m)) != null) {
                this.f222a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                int[] iArr2 = C0263L0.f878a;
            }
            int i2 = C2012o.AppCompatImageView_tint;
            if (m1196r.m1198p(i2)) {
                this.f222a.setImageTintList(m1196r.m1211c(i2));
            }
            int i3 = C2012o.AppCompatImageView_tintMode;
            if (m1196r.m1198p(i3)) {
                this.f222a.setImageTintMode(C0263L0.m2226c(m1196r.m1204j(i3, -1), null));
            }
            m1196r.f3660b.recycle();
        } catch (Throwable th) {
            m1196r.f3660b.recycle();
            throw th;
        }
    }

    /* renamed from: c */
    public void m2548c(int i) {
        if (i != 0) {
            Drawable m2210b = C0279M.m2210b(this.f222a.getContext(), i);
            if (m2210b != null) {
                int[] iArr = C0263L0.f878a;
            }
            this.f222a.setImageDrawable(m2210b);
        } else {
            this.f222a.setImageDrawable(null);
        }
        m2550a();
    }

    /* renamed from: d */
    public void m2547d(ColorStateList colorStateList) {
        if (this.f223b == null) {
            this.f223b = new C0584Z0();
        }
        C0584Z0 c0584z0 = this.f223b;
        c0584z0.f2067a = colorStateList;
        c0584z0.f2070d = true;
        m2550a();
    }

    /* renamed from: e */
    public void m2546e(PorterDuff.Mode mode) {
        if (this.f223b == null) {
            this.f223b = new C0584Z0();
        }
        C0584Z0 c0584z0 = this.f223b;
        c0584z0.f2068b = mode;
        c0584z0.f2069c = true;
        m2550a();
    }
}
