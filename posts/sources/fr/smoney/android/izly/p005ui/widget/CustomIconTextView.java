package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;

/* renamed from: fr.smoney.android.izly.ui.widget.CustomIconTextView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CustomIconTextView extends LinearLayout {

    /* renamed from: a */
    public AbstractC0067Ca f4994a;

    /* renamed from: b */
    public Context f4995b;

    /* renamed from: c */
    public LayoutInflater f4996c;

    /* renamed from: d */
    public AttributeSet f4997d;

    public CustomIconTextView(Context context) {
        super(context);
        this.f4995b = context;
        m815a();
    }

    /* renamed from: a */
    public final void m815a() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f4995b.getSystemService("layout_inflater");
        this.f4996c = layoutInflater;
        this.f4994a = (AbstractC0067Ca) DataBindingUtil.inflate(layoutInflater, 2131492928, this, true);
        TypedArray obtainStyledAttributes = this.f4995b.obtainStyledAttributes(this.f4997d, C2404z8.CustomIconTextView);
        if (obtainStyledAttributes == null) {
            return;
        }
        String string = obtainStyledAttributes.getString(1);
        if (!TextUtils.isEmpty(string)) {
            this.f4994a.f299b.setText(string);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        if (drawable != null) {
            this.f4994a.f298a.setImageDrawable(drawable);
        }
        this.f4994a.f299b.setTextSize(obtainStyledAttributes.getInt(2, 16));
        obtainStyledAttributes.recycle();
    }

    public CustomIconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4997d = attributeSet;
        this.f4995b = context;
        m815a();
    }

    public CustomIconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4997d = attributeSet;
        this.f4995b = context;
        m815a();
    }
}
