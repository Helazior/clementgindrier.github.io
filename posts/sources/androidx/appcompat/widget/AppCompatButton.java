package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AppCompatButton extends Button implements InterfaceC1916j5, InterfaceC2021o5 {
    private final C2395z0 mBackgroundTintHelper;
    private final C0164H0 mTextHelper;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
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

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (InterfaceC1916j5.f5339e) {
            return super.getAutoSizeMaxTextSize();
        }
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            return Math.round(c0164h0.f529i.f617e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (InterfaceC1916j5.f5339e) {
            return super.getAutoSizeMinTextSize();
        }
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            return Math.round(c0164h0.f529i.f616d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (InterfaceC1916j5.f5339e) {
            return super.getAutoSizeStepGranularity();
        }
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            return Math.round(c0164h0.f529i.f615c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (InterfaceC1916j5.f5339e) {
            return super.getAutoSizeTextAvailableSizes();
        }
        C0164H0 c0164h0 = this.mTextHelper;
        return c0164h0 != null ? c0164h0.f529i.f618f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (InterfaceC1916j5.f5339e) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            return c0164h0.f529i.f613a;
        }
        return 0;
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

    public ColorStateList getSupportCompoundDrawablesTintList() {
        C0584Z0 c0584z0 = this.mTextHelper.f528h;
        if (c0584z0 != null) {
            return c0584z0.f2067a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        C0584Z0 c0584z0 = this.mTextHelper.f528h;
        if (c0584z0 != null) {
            return c0584z0.f2068b;
        }
        return null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 == null || InterfaceC1916j5.f5339e) {
            return;
        }
        c0164h0.f529i.m2406a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 == null || InterfaceC1916j5.f5339e || !c0164h0.m2423d()) {
            return;
        }
        this.mTextHelper.f529i.m2406a();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (InterfaceC1916j5.f5339e) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2420g(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (InterfaceC1916j5.f5339e) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2419h(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (InterfaceC1916j5.f5339e) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2418i(i);
        }
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(LayoutInflater$Factory2C0000A.C0010h.m2602y0(this, callback));
    }

    public void setSupportAllCaps(boolean z) {
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.f521a.setAllCaps(z);
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

    @Override // p000.InterfaceC2021o5
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.m2417j(colorStateList);
        this.mTextHelper.m2425b();
    }

    @Override // p000.InterfaceC2021o5
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.m2416k(mode);
        this.mTextHelper.m2425b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2421f(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        boolean z = InterfaceC1916j5.f5339e;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 == null || z || c0164h0.m2423d()) {
            return;
        }
        c0164h0.f529i.m2401f(i, f);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1671f.buttonStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0567Y0.m1778a(context);
        C0530W0.m1825a(this, getContext());
        C2395z0 c2395z0 = new C2395z0(this);
        this.mBackgroundTintHelper = c2395z0;
        c2395z0.m18d(attributeSet, i);
        C0164H0 c0164h0 = new C0164H0(this);
        this.mTextHelper = c0164h0;
        c0164h0.m2422e(attributeSet, i);
        c0164h0.m2425b();
    }
}
