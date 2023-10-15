package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ToggleButton;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AppCompatToggleButton extends ToggleButton {

    /* renamed from: a */
    public final C0164H0 f2496a;

    public AppCompatToggleButton(Context context) {
        this(context, null);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842827);
    }

    public AppCompatToggleButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0530W0.m1825a(this, getContext());
        C0164H0 c0164h0 = new C0164H0(this);
        this.f2496a = c0164h0;
        c0164h0.m2422e(attributeSet, i);
    }
}
