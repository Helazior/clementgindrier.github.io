package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AppCompatAutoCompleteTextView extends AutoCompleteTextView {
    private static final int[] TINT_ATTRS = {16843126};
    private final C2395z0 mBackgroundTintHelper;
    private final C0164H0 mTextHelper;

    public AppCompatAutoCompleteTextView(Context context) {
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

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        LayoutInflater$Factory2C0000A.C0010h.m2652Z(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
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

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0279M.m2210b(getContext(), i));
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0164H0 c0164h0 = this.mTextHelper;
        if (c0164h0 != null) {
            c0164h0.m2421f(context, i);
        }
    }

    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1671f.autoCompleteTextViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0567Y0.m1778a(context);
        C0530W0.m1825a(this, getContext());
        C0954b1 m1196r = C0954b1.m1196r(getContext(), attributeSet, TINT_ATTRS, i, 0);
        if (m1196r.m1198p(0)) {
            setDropDownBackgroundDrawable(m1196r.m1207g(0));
        }
        m1196r.f3660b.recycle();
        C2395z0 c2395z0 = new C2395z0(this);
        this.mBackgroundTintHelper = c2395z0;
        c2395z0.m18d(attributeSet, i);
        C0164H0 c0164h0 = new C0164H0(this);
        this.mTextHelper = c0164h0;
        c0164h0.m2422e(attributeSet, i);
        c0164h0.m2425b();
    }
}
