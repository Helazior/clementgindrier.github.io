package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: fr.smoney.android.izly.ui.widget.CustomFontTextView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CustomFontTextView extends TextView {
    public CustomFontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Typeface createFromAsset;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2404z8.CustomFontTextView);
        String string = obtainStyledAttributes.getString(0);
        if (!isInEditMode() && string != null && (createFromAsset = Typeface.createFromAsset(context.getAssets(), string)) != null) {
            setTypeface(createFromAsset);
        }
        obtainStyledAttributes.recycle();
    }

    public CustomFontTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomFontTextView(Context context) {
        this(context, null);
    }
}
