package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AppCompatImageButton extends ImageButton {
    private final C2395z0 mBackgroundTintHelper;
    private final C0052C0 mImageHelper;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2395z0 c2395z0 = this.mBackgroundTintHelper;
        if (c2395z0 != null) {
            c2395z0.m21a();
        }
        C0052C0 c0052c0 = this.mImageHelper;
        if (c0052c0 != null) {
            c0052c0.m2550a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2395z0 c2395z0 = this.mBackgroundTintHelper;
        if (c2395z0 != null) {
            return c2395z0.m20b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2395z0 c2395z0 = this.mBackgroundTintHelper;
        if (c2395z0 != null) {
            return c2395z0.m19c();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C0584Z0 c0584z0;
        C0052C0 c0052c0 = this.mImageHelper;
        if (c0052c0 == null || (c0584z0 = c0052c0.f223b) == null) {
            return null;
        }
        return c0584z0.f2067a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C0584Z0 c0584z0;
        C0052C0 c0052c0 = this.mImageHelper;
        if (c0052c0 == null || (c0584z0 = c0052c0.f223b) == null) {
            return null;
        }
        return c0584z0.f2068b;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return ((this.mImageHelper.f222a.getBackground() instanceof RippleDrawable) ^ true) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2395z0 c2395z0 = this.mBackgroundTintHelper;
        if (c2395z0 != null) {
            c2395z0.m17e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C2395z0 c2395z0 = this.mBackgroundTintHelper;
        if (c2395z0 != null) {
            c2395z0.m16f(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0052C0 c0052c0 = this.mImageHelper;
        if (c0052c0 != null) {
            c0052c0.m2550a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C0052C0 c0052c0 = this.mImageHelper;
        if (c0052c0 != null) {
            c0052c0.m2550a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.mImageHelper.m2548c(i);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0052C0 c0052c0 = this.mImageHelper;
        if (c0052c0 != null) {
            c0052c0.m2550a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2395z0 c2395z0 = this.mBackgroundTintHelper;
        if (c2395z0 != null) {
            c2395z0.m14h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2395z0 c2395z0 = this.mBackgroundTintHelper;
        if (c2395z0 != null) {
            c2395z0.m13i(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0052C0 c0052c0 = this.mImageHelper;
        if (c0052c0 != null) {
            c0052c0.m2547d(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0052C0 c0052c0 = this.mImageHelper;
        if (c0052c0 != null) {
            c0052c0.m2546e(mode);
        }
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1671f.imageButtonStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0567Y0.m1778a(context);
        C0530W0.m1825a(this, getContext());
        C2395z0 c2395z0 = new C2395z0(this);
        this.mBackgroundTintHelper = c2395z0;
        c2395z0.m18d(attributeSet, i);
        C0052C0 c0052c0 = new C0052C0(this);
        this.mImageHelper = c0052c0;
        c0052c0.m2549b(attributeSet, i);
    }
}
