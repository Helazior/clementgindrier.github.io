package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/* renamed from: fr.smoney.android.izly.ui.widget.ExpandableGridView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ExpandableGridView extends GridView {

    /* renamed from: a */
    public boolean f4998a;

    public ExpandableGridView(Context context) {
        this(context, null, 0);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f4998a) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i, i2);
    }

    public void setExpanded(boolean z) {
        this.f4998a = z;
    }

    public ExpandableGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ExpandableGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4998a = false;
    }
}
