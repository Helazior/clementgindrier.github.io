package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;

/* renamed from: fr.smoney.android.izly.ui.widget.CustomEmptyView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CustomEmptyView extends RelativeLayout {

    /* renamed from: a */
    public AbstractC0025Aa f4983a;

    /* renamed from: b */
    public AttributeSet f4984b;

    /* renamed from: c */
    public String f4985c;

    /* renamed from: d */
    public String f4986d;

    /* renamed from: f */
    public Context f4987f;

    /* renamed from: g */
    public Boolean f4988g;

    /* renamed from: h */
    public int f4989h;

    /* renamed from: fr.smoney.android.izly.ui.widget.CustomEmptyView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1819a {
        ERROR(0),
        WARNING(1);
        

        /* renamed from: a */
        public final int f4993a;

        EnumC1819a(int i) {
            this.f4993a = i;
        }
    }

    public CustomEmptyView(Context context) {
        super(context);
        this.f4988g = Boolean.TRUE;
        this.f4989h = 0;
        this.f4987f = context;
        m817a();
    }

    /* renamed from: a */
    public final void m817a() {
        this.f4983a = (AbstractC0025Aa) DataBindingUtil.inflate((LayoutInflater) this.f4987f.getSystemService("layout_inflater"), 2131492927, this, true);
        TypedArray obtainStyledAttributes = this.f4987f.obtainStyledAttributes(this.f4984b, C2404z8.CustomEmptyView);
        if (obtainStyledAttributes != null) {
            this.f4989h = obtainStyledAttributes.getInt(0, 0);
            this.f4985c = obtainStyledAttributes.getString(1);
            this.f4986d = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
        }
        m816b();
    }

    /* renamed from: b */
    public final void m816b() {
        if (this.f4989h != 0) {
            if (TextUtils.isEmpty(this.f4985c)) {
                this.f4985c = this.f4987f.getResources().getString(2131689770);
            }
        } else if (TextUtils.isEmpty(this.f4985c)) {
            this.f4985c = this.f4987f.getResources().getString(2131689771);
        }
        if (!TextUtils.isEmpty(this.f4986d)) {
            this.f4983a.f144c.setVisibility(0);
            this.f4983a.f144c.setText(this.f4986d);
        } else {
            this.f4983a.f144c.setVisibility(8);
        }
        if (this.f4988g.booleanValue()) {
            this.f4983a.f142a.setVisibility(0);
        } else {
            this.f4983a.f142a.setVisibility(8);
        }
        this.f4983a.f143b.setText(this.f4985c);
    }

    public void setLayout(String str, EnumC1819a enumC1819a) {
        this.f4985c = str;
        if (enumC1819a != null) {
            this.f4989h = enumC1819a.f4993a;
        }
        m816b();
    }

    public void setMsg(String str) {
        this.f4983a.f143b.setText(str);
        m816b();
    }

    public void setType(EnumC1819a enumC1819a) {
        this.f4989h = enumC1819a.f4993a;
        m816b();
    }

    public void setLayout(String str, String str2, EnumC1819a enumC1819a) {
        this.f4988g = Boolean.FALSE;
        this.f4985c = str2;
        this.f4986d = str;
        if (enumC1819a != null) {
            this.f4989h = enumC1819a.f4993a;
        }
        m816b();
    }

    public CustomEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4988g = Boolean.TRUE;
        this.f4989h = 0;
        this.f4984b = attributeSet;
        this.f4987f = context;
        m817a();
    }

    public CustomEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4988g = Boolean.TRUE;
        this.f4989h = 0;
        this.f4984b = attributeSet;
        this.f4987f = context;
        m817a();
    }
}
