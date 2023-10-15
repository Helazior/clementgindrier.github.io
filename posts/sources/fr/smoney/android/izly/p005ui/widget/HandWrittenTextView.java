package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;
import com.nineoldandroids.view.animation.AnimatorProxy;

/* renamed from: fr.smoney.android.izly.ui.widget.HandWrittenTextView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HandWrittenTextView extends TextView {
    public HandWrittenTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m807a(context);
    }

    /* renamed from: a */
    public final void m807a(Context context) {
        if (!isInEditMode()) {
            setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/ardleyshandregular.ttf"));
        }
        AnimatorProxy.wrap(this).setRotation(-4.0f);
    }

    public HandWrittenTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m807a(context);
    }

    public HandWrittenTextView(Context context) {
        super(context);
        m807a(context);
    }
}
