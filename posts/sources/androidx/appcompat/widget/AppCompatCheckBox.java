package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AppCompatCheckBox extends CheckBox {
    private final C2395z0 mBackgroundTintHelper;
    private final C0014A0 mCompoundButtonHelper;
    private final C0164H0 mTextHelper;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2395z0 c2395z0 = this.mBackgroundTintHelper;
        if (c2395z0 != null) {
            c2395z0.m21a();
        }
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2425b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        C0014A0 c0014a0 = this.mCompoundButtonHelper;
        return compoundPaddingLeft;
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

    public ColorStateList getSupportButtonTintList() {
        C0014A0 c0014a0 = this.mCompoundButtonHelper;
        if (c0014a0 != null) {
            return c0014a0.f106b;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        C0014A0 c0014a0 = this.mCompoundButtonHelper;
        if (c0014a0 != null) {
            return c0014a0.f107c;
        }
        return null;
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

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        C0014A0 c0014a0 = this.mCompoundButtonHelper;
        if (c0014a0 != null) {
            if (c0014a0.f110f) {
                c0014a0.f110f = false;
                return;
            }
            c0014a0.f110f = true;
            c0014a0.m2599a();
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

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        C0014A0 c0014a0 = this.mCompoundButtonHelper;
        if (c0014a0 != null) {
            c0014a0.f106b = colorStateList;
            c0014a0.f108d = true;
            c0014a0.m2599a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        C0014A0 c0014a0 = this.mCompoundButtonHelper;
        if (c0014a0 != null) {
            c0014a0.f107c = mode;
            c0014a0.f109e = true;
            c0014a0.m2599a();
        }
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1671f.checkboxStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0567Y0.m1778a(context);
        C0530W0.m1825a(this, getContext());
        C0014A0 c0014a0 = new C0014A0(this);
        this.mCompoundButtonHelper = c0014a0;
        c0014a0.m2598b(attributeSet, i);
        C2395z0 c2395z0 = new C2395z0(this);
        this.mBackgroundTintHelper = c2395z0;
        c2395z0.m18d(attributeSet, i);
        C0164H0 c0164h0 = new C0164H0(this);
        this.mTextHelper = c0164h0;
        c0164h0.m2422e(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(C0279M.m2210b(getContext(), i));
    }
}
