package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AppCompatCheckedTextView extends CheckedTextView {

    /* renamed from: b */
    public static final int[] f2463b = {16843016};

    /* renamed from: a */
    public final C0164H0 f2464a;

    public AppCompatCheckedTextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C0164H0 c0164h0 = this.f2464a;
        if (c0164h0 != null) {
            c0164h0.m2425b();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        LayoutInflater$Factory2C0000A.C0010h.m2652Z(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C0279M.m2210b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(LayoutInflater$Factory2C0000A.C0010h.m2602y0(this, callback));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        C0164H0 c0164h0 = this.f2464a;
        if (c0164h0 != null) {
            c0164h0.m2421f(context, i);
        }
    }

    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0567Y0.m1778a(context);
        C0530W0.m1825a(this, getContext());
        C0164H0 c0164h0 = new C0164H0(this);
        this.f2464a = c0164h0;
        c0164h0.m2422e(attributeSet, i);
        c0164h0.m2425b();
        C0954b1 m1196r = C0954b1.m1196r(getContext(), attributeSet, f2463b, i, 0);
        setCheckMarkDrawable(m1196r.m1207g(0));
        m1196r.f3660b.recycle();
    }
}
