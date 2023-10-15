package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.SpinnerAdapter;
import androidx.databinding.DataBindingUtil;

/* renamed from: fr.smoney.android.izly.ui.widget.CustomBorderSimpleSpinner */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CustomBorderSimpleSpinner extends LinearLayout {

    /* renamed from: a */
    public AbstractC2278ua f4971a;

    /* renamed from: b */
    public Context f4972b;

    /* renamed from: c */
    public LayoutInflater f4973c;

    /* renamed from: d */
    public AttributeSet f4974d;

    public CustomBorderSimpleSpinner(Context context) {
        super(context);
        this.f4972b = context;
        m820a();
    }

    /* renamed from: a */
    public final void m820a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f4972b.getSystemService("layout_inflater");
        this.f4973c = layoutInflater;
        this.f4971a = (AbstractC2278ua) DataBindingUtil.inflate(layoutInflater, 2131492924, this, true);
        TypedArray obtainStyledAttributes = this.f4972b.obtainStyledAttributes(this.f4974d, C2404z8.CustomBorderSimpleSpinner);
        if (obtainStyledAttributes == null) {
            return;
        }
        if (!obtainStyledAttributes.getBoolean(0, true)) {
            this.f4971a.f6628a.setVisibility(8);
        }
        String string = obtainStyledAttributes.getString(2);
        if (!TextUtils.isEmpty(string)) {
            this.f4971a.f6630c.setText(string);
        }
        String string2 = obtainStyledAttributes.getString(1);
        if (!TextUtils.isEmpty(string2)) {
            this.f4971a.f6629b.setPrompt(string2);
        }
        obtainStyledAttributes.recycle();
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        this.f4971a.f6629b.setAdapter(spinnerAdapter);
    }

    public void setSelection(int i) {
        this.f4971a.f6629b.setSelection(i);
    }

    public CustomBorderSimpleSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4974d = attributeSet;
        this.f4972b = context;
        m820a();
    }

    public CustomBorderSimpleSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4974d = attributeSet;
        this.f4972b = context;
        m820a();
    }
}
