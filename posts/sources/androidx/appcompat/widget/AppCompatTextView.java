package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p000.C2271u4;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AppCompatTextView extends TextView implements InterfaceC2021o5, InterfaceC1916j5 {
    private final C2395z0 mBackgroundTintHelper;
    private Future<C2271u4> mPrecomputedTextFuture;
    private final C0143G0 mTextClassifierHelper;
    private final C0164H0 mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<C2271u4> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                LayoutInflater$Factory2C0000A.C0010h.m2626m0(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
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

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
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

    @Override // android.widget.TextView
    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        C0143G0 c0143g0;
        if (Build.VERSION.SDK_INT < 28 && (c0143g0 = this.mTextClassifierHelper) != null) {
            return c0143g0.m2446a();
        }
        return super.getTextClassifier();
    }

    public C2271u4.C2272a getTextMetricsParamsCompat() {
        return LayoutInflater$Factory2C0000A.C0010h.m2661Q(this);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        LayoutInflater$Factory2C0000A.C0010h.m2652Z(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
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

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i, i2);
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
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2425b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2425b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2425b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2425b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(LayoutInflater$Factory2C0000A.C0010h.m2602y0(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            LayoutInflater$Factory2C0000A.C0010h.m2636h0(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            LayoutInflater$Factory2C0000A.C0010h.m2634i0(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        LayoutInflater$Factory2C0000A.C0010h.m2630k0(this, i);
    }

    public void setPrecomputedText(C2271u4 c2271u4) {
        LayoutInflater$Factory2C0000A.C0010h.m2626m0(this, c2271u4);
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
    public void setTextClassifier(TextClassifier textClassifier) {
        C0143G0 c0143g0;
        if (Build.VERSION.SDK_INT < 28 && (c0143g0 = this.mTextClassifierHelper) != null) {
            c0143g0.f465b = textClassifier;
        } else {
            super.setTextClassifier(textClassifier);
        }
    }

    public void setTextFuture(Future<C2271u4> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(C2271u4.C2272a c2272a) {
        int i = Build.VERSION.SDK_INT;
        TextDirectionHeuristic textDirectionHeuristic = c2272a.f6625b;
        int i2 = 1;
        if (textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_RTL && textDirectionHeuristic != TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            if (textDirectionHeuristic == TextDirectionHeuristics.ANYRTL_LTR) {
                i2 = 2;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LTR) {
                i2 = 3;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.RTL) {
                i2 = 4;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.LOCALE) {
                i2 = 5;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                i2 = 6;
            } else if (textDirectionHeuristic == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                i2 = 7;
            }
        }
        setTextDirection(i2);
        if (i < 23) {
            float textScaleX = c2272a.f6624a.getTextScaleX();
            getPaint().set(c2272a.f6624a);
            if (textScaleX == getTextScaleX()) {
                setTextScaleX((textScaleX / 2.0f) + 1.0f);
            }
            setTextScaleX(textScaleX);
            return;
        }
        getPaint().set(c2272a.f6624a);
        setBreakStrategy(c2272a.f6626c);
        setHyphenationFrequency(c2272a.f6627d);
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

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        Typeface typeface2;
        if (typeface == null || i <= 0) {
            typeface2 = null;
        } else {
            Context context = getContext();
            C0369Q3 c0369q3 = C0213J3.f678a;
            if (context != null) {
                typeface2 = Typeface.create(typeface, i);
            } else {
                throw new IllegalArgumentException("Context cannot be null");
            }
        }
        if (typeface2 != null) {
            typeface = typeface2;
        }
        super.setTypeface(typeface, i);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
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
        this.mTextClassifierHelper = new C0143G0(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? C0279M.m2210b(context, i) : null, i2 != 0 ? C0279M.m2210b(context, i2) : null, i3 != 0 ? C0279M.m2210b(context, i3) : null, i4 != 0 ? C0279M.m2210b(context, i4) : null);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2425b();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? C0279M.m2210b(context, i) : null, i2 != 0 ? C0279M.m2210b(context, i2) : null, i3 != 0 ? C0279M.m2210b(context, i3) : null, i4 != 0 ? C0279M.m2210b(context, i4) : null);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2425b();
        }
    }
}
