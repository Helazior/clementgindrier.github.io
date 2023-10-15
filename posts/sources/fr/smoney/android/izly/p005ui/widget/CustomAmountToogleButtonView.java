package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.RelativeSizeSpan;
import android.text.style.SuperscriptSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.C0445T2;

/* renamed from: fr.smoney.android.izly.ui.widget.CustomAmountToogleButtonView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CustomAmountToogleButtonView extends LinearLayout implements TextWatcher {

    /* renamed from: a */
    public AbstractC2199qa f4953a;

    /* renamed from: b */
    public EditText f4954b;

    /* renamed from: c */
    public TextView f4955c;

    /* renamed from: d */
    public ConstraintLayout f4956d;

    /* renamed from: f */
    public InterfaceC1818a f4957f;

    /* renamed from: g */
    public double f4958g;

    /* renamed from: h */
    public String f4959h;

    /* renamed from: i */
    public Context f4960i;

    /* renamed from: j */
    public int f4961j;

    /* renamed from: k */
    public double f4962k;

    /* renamed from: l */
    public ArrayList<Integer> f4963l;

    /* renamed from: m */
    public int[] f4964m;

    /* renamed from: n */
    public int f4965n;

    /* renamed from: fr.smoney.android.izly.ui.widget.CustomAmountToogleButtonView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1818a {
        /* renamed from: j */
        void mo826j(boolean z);
    }

    public CustomAmountToogleButtonView(Context context) {
        super(context);
        this.f4961j = 0;
        this.f4963l = new ArrayList<>();
        this.f4964m = new int[1];
        this.f4960i = context;
        m831b();
    }

    /* renamed from: a */
    public double m832a(C2329w8 c2329w8) {
        if (this.f4954b.getVisibility() == 0 && !this.f4954b.getEditableText().toString().isEmpty()) {
            try {
                try {
                    double parseDouble = Double.parseDouble(C0374Q7.m2088g(this.f4954b.getEditableText().toString()));
                    if (parseDouble > ShadowDrawableWrapper.COS_45) {
                        return parseDouble;
                    }
                    throw new C2391yc();
                } catch (NumberFormatException unused) {
                    throw new C2391yc();
                }
            } catch (C2391yc unused2) {
                c2329w8.m126E(C0543Wc.m1819s(this.f4960i.getString(2131689822), this.f4960i.getString(2131689821), this.f4960i.getString(17039370)));
                return -1.0d;
            }
        }
        this.f4954b.setTextSize(10.0f);
        return this.f4958g;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f4954b.getEditableText().toString().isEmpty()) {
            if (this.f4961j == 0) {
                m829d(0, true);
            }
            this.f4954b.setTextSize(10.0f);
            this.f4954b.setHint(this.f4959h);
            this.f4955c.setVisibility(8);
        } else {
            this.f4954b.setHint("");
            this.f4955c.setVisibility(0);
            this.f4954b.setTextSize(30.0f);
        }
        invalidate();
        m828e();
    }

    /* renamed from: b */
    public final void m831b() {
        this.f4953a = (AbstractC2199qa) DataBindingUtil.inflate((LayoutInflater) this.f4960i.getSystemService("layout_inflater"), 2131492922, this, true);
        new GridLayoutManager(getContext(), 3, 1, false);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* renamed from: c */
    public final void m830c(C0445T2 c0445t2, ArrayList<Integer> arrayList, int i, EnumC1847gd enumC1847gd) {
        float f;
        int i2 = enumC1847gd.f5101a;
        float f2 = enumC1847gd.f5102b;
        int i3 = enumC1847gd.f5103c;
        int i4 = (int) ((f / 2.0f) - (getResources().getDisplayMetrics().widthPixels * 0.0825d));
        int i5 = 0;
        while (i5 < i2) {
            i5++;
            C0445T2.C0447b c0447b = c0445t2.m2025h(arrayList.get(i5).intValue()).f1459d;
            c0447b.f1522x = i;
            c0447b.f1523y = i4;
            c0447b.f1524z = f2;
            f2 -= i3;
        }
    }

    /* renamed from: d */
    public void m829d(int i, boolean z) {
        double d = i;
        this.f4958g = d;
        this.f4961j++;
        if (i != 2131689970) {
            if (!z && d != ShadowDrawableWrapper.COS_45) {
                this.f4961j = 0;
                Iterator<Integer> it = this.f4963l.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (intValue == this.f4963l.get(0).intValue()) {
                        this.f4954b.setText(String.format("%.2f", Float.valueOf(i)));
                        EditText editText = this.f4954b;
                        editText.setSelection(editText.getText().length());
                    } else if (intValue != this.f4964m[0] && ((ToggleButton) this.f4953a.f6297a.findViewById(intValue).findViewById(2131296783)).isChecked()) {
                        ((ToggleButton) this.f4953a.f6297a.findViewById(intValue).findViewById(2131296783)).setChecked(false);
                    }
                }
            } else {
                this.f4954b.setText("");
                for (int i2 = 1; i2 < this.f4963l.size(); i2++) {
                    ((ToggleButton) this.f4953a.f6297a.findViewById(this.f4963l.get(i2).intValue()).findViewById(2131296783)).setChecked(false);
                }
            }
        }
        m828e();
    }

    /* renamed from: e */
    public void m828e() {
        boolean z = false;
        try {
            if (Double.parseDouble(C0374Q7.m2088g(this.f4954b.getText().toString())) > ShadowDrawableWrapper.COS_45) {
                z = true;
            }
        } catch (NumberFormatException unused) {
        }
        this.f4957f.mo826j(z);
    }

    /* renamed from: f */
    public void m827f(String str, List list) {
        this.f4953a.f6297a.removeAllViews();
        C0445T2 c0445t2 = new C0445T2();
        LayoutInflater layoutInflater = (LayoutInflater) this.f4960i.getSystemService("layout_inflater");
        double d = getResources().getDisplayMetrics().widthPixels;
        this.f4962k = 0.285d * d * 2.0d;
        ViewGroup viewGroup = null;
        View inflate = layoutInflater.inflate(2131492930, (ViewGroup) null);
        ((EditText) inflate.findViewById(2131296540)).setTextSize(10.0f);
        inflate.setId(1005000);
        this.f4963l.add(1005000);
        this.f4953a.f6297a.addView(inflate);
        double d2 = this.f4962k;
        setDimensions(inflate, ((int) d2) + 50, ((int) d2) + 50);
        this.f4954b = (EditText) inflate.findViewById(2131296540);
        this.f4955c = (TextView) inflate.findViewById(2131296973);
        this.f4956d = (ConstraintLayout) inflate.findViewById(2131296655);
        this.f4954b.addTextChangedListener(this);
        this.f4954b.setKeyListener(new C0180Hd(true, 3, 2, 6));
        ((GradientDrawable) inflate.findViewById(2131296655).getBackground()).setCornerRadius(500.0f);
        double d3 = this.f4962k;
        ((GradientDrawable) inflate.findViewById(2131296655).getBackground()).setSize((int) d3, (int) d3);
        ConstraintLayout constraintLayout = this.f4956d;
        double d4 = this.f4962k;
        setDimensions(constraintLayout, (int) d4, (int) d4);
        c0445t2.m2029d(this.f4953a.f6297a);
        c0445t2.m2028e(inflate.getId(), 1, this.f4953a.f6297a.getId(), 1);
        c0445t2.m2028e(inflate.getId(), 2, this.f4953a.f6297a.getId(), 2);
        c0445t2.m2028e(inflate.getId(), 3, this.f4953a.f6297a.getId(), 3);
        c0445t2.m2031b(this.f4953a.f6297a);
        for (Object obj : list) {
            if (list.isEmpty() || list.size() < 7) {
                View inflate2 = layoutInflater.inflate(2131492929, viewGroup);
                SpannableString spannableString = new SpannableString(String.format("%s%s", obj, str));
                spannableString.setSpan(new SuperscriptSpan(), spannableString.length() - 1, spannableString.length(), 33);
                spannableString.setSpan(new RelativeSizeSpan(0.65f), spannableString.length() - 1, spannableString.length(), 33);
                ((ToggleButton) inflate2.findViewById(2131296783)).setTextOn(spannableString);
                ((ToggleButton) inflate2.findViewById(2131296783)).setTextOff(spannableString);
                ((ToggleButton) inflate2.findViewById(2131296783)).setText(spannableString, TextView.BufferType.SPANNABLE);
                int indexOf = list.indexOf(obj) + 1002000;
                this.f4965n = indexOf;
                inflate2.setId(indexOf);
                this.f4963l.add(Integer.valueOf(this.f4965n));
                int i = (int) (0.0825d * d);
                ((ToggleButton) inflate2.findViewById(2131296783)).getBackground().setBounds(i, i, i, i);
                ((ToggleButton) inflate2.findViewById(2131296783)).setOnClickListener(new View$OnClickListenerC0122Ed(this, inflate2, obj));
                this.f4953a.f6297a.addView(inflate2);
            }
            viewGroup = null;
        }
        c0445t2.m2029d(this.f4953a.f6297a);
        switch (list.size()) {
            case 1:
                m830c(c0445t2, this.f4963l, inflate.getId(), EnumC1847gd.One);
                break;
            case 2:
                m830c(c0445t2, this.f4963l, inflate.getId(), EnumC1847gd.Two);
                break;
            case 3:
                m830c(c0445t2, this.f4963l, inflate.getId(), EnumC1847gd.Three);
                break;
            case 4:
                m830c(c0445t2, this.f4963l, inflate.getId(), EnumC1847gd.Four);
                break;
            case 5:
                m830c(c0445t2, this.f4963l, inflate.getId(), EnumC1847gd.Five);
                break;
            case 6:
                m830c(c0445t2, this.f4963l, inflate.getId(), EnumC1847gd.Six);
                break;
        }
        c0445t2.m2031b(this.f4953a.f6297a);
        requestLayout();
        invalidate();
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void setDimensions(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public CustomAmountToogleButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4961j = 0;
        this.f4963l = new ArrayList<>();
        this.f4964m = new int[1];
        this.f4960i = context;
        m831b();
    }

    public CustomAmountToogleButtonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4961j = 0;
        this.f4963l = new ArrayList<>();
        this.f4964m = new int[1];
        this.f4960i = context;
        m831b();
    }
}
