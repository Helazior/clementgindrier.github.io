package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FitWindowsLinearLayout extends LinearLayout {

    /* renamed from: a */
    public InterfaceC0306N0 f2508a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        InterfaceC0306N0 interfaceC0306N0 = this.f2508a;
        if (interfaceC0306N0 != null) {
            interfaceC0306N0.m2185a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(InterfaceC0306N0 interfaceC0306N0) {
        this.f2508a = interfaceC0306N0;
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
