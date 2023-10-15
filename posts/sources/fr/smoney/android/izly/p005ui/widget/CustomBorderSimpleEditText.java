package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.DataBindingUtil;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CustomBorderSimpleEditText extends LinearLayout {

    /* renamed from: a */
    public AbstractC2237sa f4966a;

    /* renamed from: b */
    public Context f4967b;

    /* renamed from: c */
    public LayoutInflater f4968c;

    /* renamed from: d */
    public AttributeSet f4969d;

    /* renamed from: f */
    public ArrayList<AbstractC0096Dd> f4970f;

    public CustomBorderSimpleEditText(Context context) {
        super(context);
        this.f4967b = context;
        m823c();
    }

    /* renamed from: a */
    public void m825a() {
        this.f4966a.f6403a.setEnabled(false);
        this.f4966a.f6403a.setTextColor(getResources().getColor(2131099756));
    }

    /* renamed from: b */
    public String m824b() {
        return this.f4966a.f6403a.getText().toString();
    }

    /* renamed from: c */
    public final void m823c() {
        LayoutInflater layoutInflater = (LayoutInflater) this.f4967b.getSystemService("layout_inflater");
        this.f4968c = layoutInflater;
        this.f4966a = (AbstractC2237sa) DataBindingUtil.inflate(layoutInflater, 2131492923, this, true);
        this.f4970f = new ArrayList<>();
        TypedArray obtainStyledAttributes = this.f4967b.obtainStyledAttributes(this.f4969d, C2404z8.CustomBorderSimpleEditText);
        if (obtainStyledAttributes == null) {
            return;
        }
        if (!obtainStyledAttributes.getBoolean(0, true)) {
            this.f4966a.f6404b.setVisibility(8);
        }
        String string = obtainStyledAttributes.getString(1);
        if (!TextUtils.isEmpty(string)) {
            this.f4966a.f6406d.setText(string);
        }
        String string2 = obtainStyledAttributes.getString(2);
        if (!TextUtils.isEmpty(string2)) {
            this.f4966a.f6403a.setText(string2);
        }
        String string3 = obtainStyledAttributes.getString(3);
        if (!TextUtils.isEmpty(string3)) {
            this.f4966a.f6403a.setHint(string3);
        }
        obtainStyledAttributes.recycle();
    }

    /* renamed from: d */
    public boolean m822d() {
        String obj = this.f4966a.f6403a.getText().toString();
        Iterator<AbstractC0096Dd> it = this.f4970f.iterator();
        while (it.hasNext()) {
            if (!it.next().mo2475a(obj)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public boolean m821e() {
        String m824b = m824b();
        if (m824b.isEmpty()) {
            return false;
        }
        Iterator<AbstractC0096Dd> it = this.f4970f.iterator();
        while (it.hasNext()) {
            AbstractC0096Dd next = it.next();
            if (!next.mo2475a(m824b)) {
                setError(next.f365a);
                return false;
            }
        }
        setValid();
        return true;
    }

    public void setError(String str) {
        this.f4966a.f6405c.setText(str);
        this.f4966a.f6405c.setVisibility(0);
    }

    public void setLabel(String str) {
        this.f4966a.f6406d.setText(str);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f4966a.f6403a.setOnClickListener(onClickListener);
    }

    public void setText(String str) {
        this.f4966a.f6403a.setText(str);
    }

    public void setValid() {
        this.f4966a.f6405c.setVisibility(8);
    }

    public CustomBorderSimpleEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4969d = attributeSet;
        this.f4967b = context;
        m823c();
    }

    public CustomBorderSimpleEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4969d = attributeSet;
        this.f4967b = context;
        m823c();
    }
}
