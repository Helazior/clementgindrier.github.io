package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FitWindowsFrameLayout extends FrameLayout {

    /* renamed from: a */
    public InterfaceC0306N0 f2507a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        InterfaceC0306N0 interfaceC0306N0 = this.f2507a;
        if (interfaceC0306N0 != null) {
            interfaceC0306N0.m2185a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    public void setOnFitSystemWindowsListener(InterfaceC0306N0 interfaceC0306N0) {
        this.f2507a = interfaceC0306N0;
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
