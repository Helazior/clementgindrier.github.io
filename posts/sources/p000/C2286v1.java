package p000;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: v1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2286v1 extends Drawable {

    /* renamed from: a */
    public float f6640a;

    /* renamed from: c */
    public final RectF f6642c;

    /* renamed from: d */
    public final Rect f6643d;

    /* renamed from: e */
    public float f6644e;

    /* renamed from: h */
    public ColorStateList f6647h;

    /* renamed from: i */
    public PorterDuffColorFilter f6648i;

    /* renamed from: j */
    public ColorStateList f6649j;

    /* renamed from: f */
    public boolean f6645f = false;

    /* renamed from: g */
    public boolean f6646g = true;

    /* renamed from: k */
    public PorterDuff.Mode f6650k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    public final Paint f6641b = new Paint(5);

    public C2286v1(ColorStateList colorStateList, float f) {
        this.f6640a = f;
        m292b(colorStateList);
        this.f6642c = new RectF();
        this.f6643d = new Rect();
    }

    /* renamed from: a */
    public final PorterDuffColorFilter m293a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* renamed from: b */
    public final void m292b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f6647h = colorStateList;
        this.f6641b.setColor(colorStateList.getColorForState(getState(), this.f6647h.getDefaultColor()));
    }

    /* renamed from: c */
    public final void m291c(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f6642c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f6643d.set(rect);
        if (this.f6645f) {
            float m220b = C2305w1.m220b(this.f6644e, this.f6640a, this.f6646g);
            this.f6643d.inset((int) Math.ceil(C2305w1.m221a(this.f6644e, this.f6640a, this.f6646g)), (int) Math.ceil(m220b));
            this.f6642c.set(this.f6643d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f6641b;
        if (this.f6648i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f6648i);
            z = true;
        }
        RectF rectF = this.f6642c;
        float f = this.f6640a;
        canvas.drawRoundRect(rectF, f, f, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f6643d, this.f6640a);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f6649j;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f6647h) != null && colorStateList.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m291c(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.f6647h;
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        boolean z = colorForState != this.f6641b.getColor();
        if (z) {
            this.f6641b.setColor(colorForState);
        }
        ColorStateList colorStateList2 = this.f6649j;
        if (colorStateList2 == null || (mode = this.f6650k) == null) {
            return z;
        }
        this.f6648i = m293a(colorStateList2, mode);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f6641b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f6641b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f6649j = colorStateList;
        this.f6648i = m293a(colorStateList, this.f6650k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f6650k = mode;
        this.f6648i = m293a(this.f6649j, mode);
        invalidateSelf();
    }
}
