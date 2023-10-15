package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import fr.smoney.android.izly.data.items.KeyValueObject;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: fr.smoney.android.izly.ui.widget.CustomDetailBodyView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CustomDetailBodyView extends LinearLayout {

    /* renamed from: a */
    public AbstractC2331wa f4975a;

    /* renamed from: b */
    public AttributeSet f4976b;

    /* renamed from: c */
    public Context f4977c;

    /* renamed from: d */
    public int f4978d;

    /* renamed from: f */
    public int f4979f;

    /* renamed from: g */
    public Paint f4980g;

    /* renamed from: h */
    public Paint f4981h;

    /* renamed from: i */
    public LayoutInflater f4982i;

    public CustomDetailBodyView(Context context) {
        super(context);
        this.f4977c = context;
        m818b();
    }

    /* renamed from: a */
    public void m819a(ArrayList<KeyValueObject> arrayList) {
        this.f4975a.f6787a.removeAllViews();
        Iterator<KeyValueObject> it = arrayList.iterator();
        while (it.hasNext()) {
            KeyValueObject next = it.next();
            AbstractC2389ya abstractC2389ya = (AbstractC2389ya) DataBindingUtil.inflate(this.f4982i, 2131492926, null, false);
            abstractC2389ya.f6883a.setText(next.f4213a);
            abstractC2389ya.f6883a.setTextSize(this.f4978d);
            abstractC2389ya.f6884b.setText(next.f4214b);
            abstractC2389ya.f6884b.setTextSize(this.f4979f);
            this.f4975a.f6787a.addView(abstractC2389ya.getRoot());
        }
        requestLayout();
        invalidate();
    }

    /* renamed from: b */
    public final void m818b() {
        setWillNotDraw(false);
        this.f4980g = new Paint();
        this.f4981h = new Paint();
        LayoutInflater layoutInflater = (LayoutInflater) this.f4977c.getSystemService("layout_inflater");
        this.f4982i = layoutInflater;
        this.f4975a = (AbstractC2331wa) DataBindingUtil.inflate(layoutInflater, 2131492925, this, true);
        TypedArray obtainStyledAttributes = this.f4977c.obtainStyledAttributes(this.f4976b, C2404z8.CustomDetailHeaderView);
        if (obtainStyledAttributes == null) {
            return;
        }
        if (obtainStyledAttributes.getBoolean(3, true)) {
            setBorderWidth(obtainStyledAttributes.getDimension(2, getContext().getResources().getDisplayMetrics().density * 2.0f));
            setBorderColor(obtainStyledAttributes.getColor(1, -1));
        }
        this.f4978d = obtainStyledAttributes.getInt(4, 14);
        this.f4979f = obtainStyledAttributes.getInt(5, 16);
        setBackgroundColor(obtainStyledAttributes.getColor(0, -1));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f4981h.setColor(i);
        invalidate();
    }

    public void setBorderColor(int i) {
        this.f4980g.setColor(i);
        invalidate();
    }

    public void setBorderWidth(float f) {
        requestLayout();
        invalidate();
    }

    public CustomDetailBodyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4976b = attributeSet;
        this.f4977c = context;
        m818b();
    }

    public CustomDetailBodyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4976b = attributeSet;
        this.f4977c = context;
        m818b();
    }
}
