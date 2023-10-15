package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* renamed from: fr.smoney.android.izly.ui.widget.ToggleView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ToggleView extends RelativeLayout {

    /* renamed from: a */
    public Context f5031a;

    /* renamed from: b */
    public TextView f5032b;

    /* renamed from: c */
    public ImageView f5033c;

    public ToggleView(Context context) {
        super(context);
        this.f5031a = context;
        m804a(0);
    }

    /* renamed from: a */
    public final void m804a(int i) {
        View inflate;
        LayoutInflater from = LayoutInflater.from(this.f5031a);
        if (i != 0) {
            inflate = from.inflate(i, (ViewGroup) this, false);
        } else {
            inflate = from.inflate(2131493074, (ViewGroup) this, false);
        }
        addView(inflate);
        this.f5032b = (TextView) inflate.findViewById(2131296916);
        this.f5033c = (ImageView) inflate.findViewById(2131296915);
    }

    public void setChecked(boolean z) {
        setSelected(z);
        this.f5032b.setSelected(z);
    }

    public ToggleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5031a = context;
        m804a(0);
    }

    public ToggleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5031a = context;
        m804a(0);
    }
}
