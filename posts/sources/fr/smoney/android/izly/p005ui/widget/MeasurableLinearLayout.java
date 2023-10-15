package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;

/* renamed from: fr.smoney.android.izly.ui.widget.MeasurableLinearLayout */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MeasurableLinearLayout extends LinearLayout {

    /* renamed from: a */
    public WeakReference<InterfaceC1823a> f5027a;

    /* renamed from: fr.smoney.android.izly.ui.widget.MeasurableLinearLayout$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1823a {
        /* renamed from: a */
        void m806a(MeasurableLinearLayout measurableLinearLayout, int i, int i2);
    }

    public MeasurableLinearLayout(Context context) {
        this(context, null);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        InterfaceC1823a interfaceC1823a;
        super.onLayout(z, i, i2, i3, i4);
        WeakReference<InterfaceC1823a> weakReference = this.f5027a;
        if (weakReference == null || (interfaceC1823a = weakReference.get()) == null) {
            return;
        }
        interfaceC1823a.m806a(this, getWidth(), getHeight());
    }

    public void setOnMeasuredListener(InterfaceC1823a interfaceC1823a) {
        this.f5027a = new WeakReference<>(interfaceC1823a);
    }

    public MeasurableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
