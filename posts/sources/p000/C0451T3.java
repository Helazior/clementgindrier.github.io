package p000;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: T3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0451T3 extends Drawable implements Drawable.Callback, InterfaceC0430S3, InterfaceC0395R3 {

    /* renamed from: h */
    public static final PorterDuff.Mode f1552h = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    public int f1553a;

    /* renamed from: b */
    public PorterDuff.Mode f1554b;

    /* renamed from: c */
    public boolean f1555c;

    /* renamed from: d */
    public C0491V3 f1556d;

    /* renamed from: f */
    public boolean f1557f;

    /* renamed from: g */
    public Drawable f1558g;

    public C0451T3(C0491V3 c0491v3, Resources resources) {
        Drawable.ConstantState constantState;
        this.f1556d = c0491v3;
        if (c0491v3 == null || (constantState = c0491v3.f1795b) == null) {
            return;
        }
        mo2010a(constantState.newDrawable(resources));
    }

    @Override // p000.InterfaceC0430S3
    /* renamed from: a */
    public final void mo2010a(Drawable drawable) {
        Drawable drawable2 = this.f1558g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1558g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            C0491V3 c0491v3 = this.f1556d;
            if (c0491v3 != null) {
                c0491v3.f1795b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // p000.InterfaceC0430S3
    /* renamed from: b */
    public final Drawable mo2009b() {
        return this.f1558g;
    }

    /* renamed from: c */
    public boolean mo2002c() {
        throw null;
    }

    /* renamed from: d */
    public final boolean m2008d(int[] iArr) {
        if (mo2002c()) {
            C0491V3 c0491v3 = this.f1556d;
            ColorStateList colorStateList = c0491v3.f1796c;
            PorterDuff.Mode mode = c0491v3.f1797d;
            if (colorStateList != null && mode != null) {
                int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
                if (!this.f1555c || colorForState != this.f1553a || mode != this.f1554b) {
                    setColorFilter(colorForState, mode);
                    this.f1553a = colorForState;
                    this.f1554b = mode;
                    this.f1555c = true;
                    return true;
                }
            } else {
                this.f1555c = false;
                clearColorFilter();
            }
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f1558g.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        C0491V3 c0491v3 = this.f1556d;
        return changingConfigurations | (c0491v3 != null ? c0491v3.getChangingConfigurations() : 0) | this.f1558g.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        C0491V3 c0491v3 = this.f1556d;
        if (c0491v3 != null) {
            if (c0491v3.f1795b != null) {
                c0491v3.f1794a = getChangingConfigurations();
                return this.f1556d;
            }
            return null;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1558g.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1558g.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1558g.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getLayoutDirection() {
        return LayoutInflater$Factory2C0000A.C0010h.m2676B(this.f1558g);
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f1558g.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f1558g.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f1558g.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f1558g.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f1558g.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f1558g.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1558g.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0491V3 c0491v3;
        ColorStateList colorStateList = (!mo2002c() || (c0491v3 = this.f1556d) == null) ? null : c0491v3.f1796c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f1558g.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f1558g.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1557f && super.mutate() == this) {
            this.f1556d = new C0491V3(this.f1556d);
            Drawable drawable = this.f1558g;
            if (drawable != null) {
                drawable.mutate();
            }
            C0491V3 c0491v3 = this.f1556d;
            if (c0491v3 != null) {
                Drawable drawable2 = this.f1558g;
                c0491v3.f1795b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.f1557f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1558g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return LayoutInflater$Factory2C0000A.C0010h.m2632j0(this.f1558g, i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.f1558g.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f1558g.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f1558g.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f1558g.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1558g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f1558g.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f1558g.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return m2008d(iArr) || this.f1558g.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f1558g.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    public C0451T3(Drawable drawable) {
        this.f1556d = new C0491V3(this.f1556d);
        mo2010a(drawable);
    }
}
