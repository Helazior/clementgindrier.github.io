package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;
import java.util.ArrayList;
import java.util.Iterator;
import org.spongycastle.asn1.x509.DisplayText;

/* renamed from: fr.smoney.android.izly.ui.widget.FormEditText */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FormEditText extends AppCompatEditText {

    /* renamed from: a */
    public Drawable f4999a;

    /* renamed from: b */
    public Drawable f5000b;

    /* renamed from: c */
    public Drawable f5001c;

    /* renamed from: d */
    public String f5002d;

    /* renamed from: f */
    public String f5003f;

    /* renamed from: g */
    public CharSequence f5004g;

    /* renamed from: h */
    public Drawable f5005h;

    /* renamed from: i */
    public Drawable f5006i;

    /* renamed from: j */
    public Drawable f5007j;

    /* renamed from: k */
    public Drawable f5008k;

    /* renamed from: l */
    public Drawable f5009l;

    /* renamed from: m */
    public Drawable f5010m;

    /* renamed from: n */
    public Drawable f5011n;

    /* renamed from: o */
    public Drawable f5012o;

    /* renamed from: p */
    public EnumC1820a f5013p;

    /* renamed from: q */
    public C1821b f5014q;

    /* renamed from: r */
    public C1822c f5015r;

    /* renamed from: s */
    public boolean f5016s;

    /* renamed from: t */
    public boolean f5017t;

    /* renamed from: u */
    public ArrayList<AbstractC0096Dd> f5018u;

    /* renamed from: fr.smoney.android.izly.ui.widget.FormEditText$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1820a {
        NORMAL,
        VALID,
        ERROR
    }

    /* renamed from: fr.smoney.android.izly.ui.widget.FormEditText$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1821b implements TextWatcher {
        public C1821b() {
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            FormEditText.this.m814a();
            FormEditText.this.m809f();
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: fr.smoney.android.izly.ui.widget.FormEditText$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1822c extends PopupWindow {

        /* renamed from: a */
        public boolean f5024a;

        /* renamed from: b */
        public TextView f5025b;

        public C1822c(TextView textView, int i, int i2) {
            super(textView, i, i2);
            this.f5024a = false;
            this.f5025b = textView;
        }

        /* renamed from: a */
        public void m808a(boolean z) {
            EnumC1820a enumC1820a = EnumC1820a.ERROR;
            EnumC1820a enumC1820a2 = EnumC1820a.NORMAL;
            this.f5024a = z;
            if (z) {
                FormEditText formEditText = FormEditText.this;
                EnumC1820a enumC1820a3 = formEditText.f5013p;
                if (enumC1820a3 == enumC1820a2) {
                    this.f5025b.setBackgroundDrawable(formEditText.f5009l);
                    return;
                } else if (enumC1820a3 == enumC1820a) {
                    this.f5025b.setBackgroundDrawable(formEditText.f5008k);
                    return;
                } else {
                    return;
                }
            }
            FormEditText formEditText2 = FormEditText.this;
            EnumC1820a enumC1820a4 = formEditText2.f5013p;
            if (enumC1820a4 == enumC1820a2) {
                this.f5025b.setBackgroundDrawable(formEditText2.f5007j);
            } else if (enumC1820a4 == enumC1820a) {
                this.f5025b.setBackgroundDrawable(formEditText2.f5006i);
            }
        }

        @Override // android.widget.PopupWindow
        public void update(int i, int i2, int i3, int i4, boolean z) {
            super.update(i, i2, i3, i4, z);
            boolean isAboveAnchor = isAboveAnchor();
            if (isAboveAnchor != this.f5024a) {
                m808a(isAboveAnchor);
            }
        }
    }

    public FormEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2404z8.FormEditText);
        Drawable drawable = obtainStyledAttributes.getDrawable(4);
        this.f5010m = drawable;
        if (drawable == null) {
            this.f5010m = new IconDrawable(context, Iconify.IconValue.fa_exclamation_circle).colorRes(2131099803).sizeDp(30);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(7);
        this.f5011n = drawable2;
        if (drawable2 == null) {
            this.f5011n = context.getResources().getDrawable(2131231004);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(11);
        this.f5012o = drawable3;
        if (drawable3 == null) {
            this.f5012o = new IconDrawable(context, Iconify.IconValue.fa_check_circle).colorRes(2131099791).sizeDp(30);
        }
        Drawable drawable4 = obtainStyledAttributes.getDrawable(2);
        this.f5006i = drawable4;
        if (drawable4 == null) {
            this.f5006i = context.getResources().getDrawable(2131230827);
        }
        Drawable drawable5 = obtainStyledAttributes.getDrawable(3);
        this.f5008k = drawable5;
        if (drawable5 == null) {
            this.f5008k = context.getResources().getDrawable(2131230826);
        }
        Drawable drawable6 = obtainStyledAttributes.getDrawable(5);
        this.f5007j = drawable6;
        if (drawable6 == null) {
            this.f5007j = context.getResources().getDrawable(2131230829);
        }
        Drawable drawable7 = obtainStyledAttributes.getDrawable(6);
        this.f5009l = drawable7;
        if (drawable7 == null) {
            this.f5009l = context.getResources().getDrawable(2131230828);
        }
        String string = obtainStyledAttributes.getString(8);
        this.f5002d = string;
        if (string == null) {
            this.f5002d = context.getString(2131689816);
        }
        this.f5016s = obtainStyledAttributes.getBoolean(9, true);
        this.f5003f = context.getString(2131689815);
        Drawable drawable8 = obtainStyledAttributes.getDrawable(1);
        this.f4999a = drawable8;
        if (drawable8 == null) {
            this.f4999a = context.getResources().getDrawable(2131231025);
        }
        Drawable drawable9 = obtainStyledAttributes.getDrawable(10);
        this.f5000b = drawable9;
        if (drawable9 == null) {
            this.f5000b = context.getResources().getDrawable(2131231015);
        }
        this.f5001c = getBackground();
        obtainStyledAttributes.getBoolean(0, false);
        this.f5017t = obtainStyledAttributes.getBoolean(12, true);
        obtainStyledAttributes.recycle();
        this.f5018u = new ArrayList<>();
        C1821b c1821b = new C1821b();
        this.f5014q = c1821b;
        addTextChangedListener(c1821b);
        m811d();
    }

    /* renamed from: a */
    public void m814a() {
        C1822c c1822c = this.f5015r;
        if (c1822c == null || !c1822c.isShowing()) {
            return;
        }
        this.f5015r.dismiss();
    }

    /* renamed from: b */
    public final void m813b() {
        C1822c c1822c = new C1822c((TextView) LayoutInflater.from(getContext()).inflate(2131493056, (ViewGroup) null), 0, 0);
        this.f5015r = c1822c;
        c1822c.setFocusable(false);
        this.f5015r.setInputMethodMode(1);
    }

    /* renamed from: c */
    public final void m812c(String str) {
        this.f5004g = str;
        EnumC1820a enumC1820a = this.f5013p;
        EnumC1820a enumC1820a2 = EnumC1820a.ERROR;
        if (enumC1820a != enumC1820a2) {
            this.f5013p = enumC1820a2;
            Drawable drawable = this.f5010m;
            this.f5005h = drawable;
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            setBackgroundDrawable(this.f4999a);
            setPadding(30, 0, 15, 0);
        }
    }

    /* renamed from: d */
    public final void m811d() {
        EnumC1820a enumC1820a = this.f5013p;
        EnumC1820a enumC1820a2 = EnumC1820a.NORMAL;
        if (enumC1820a != enumC1820a2) {
            this.f5013p = enumC1820a2;
            this.f5004g = this.f5002d;
            Drawable drawable = this.f5011n;
            this.f5005h = drawable;
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            setBackgroundDrawable(this.f5001c);
            setPadding(30, 0, 15, 0);
        }
    }

    /* renamed from: e */
    public final void m810e() {
        if (getWindowToken() == null || !this.f5016s) {
            return;
        }
        if (this.f5015r == null) {
            m813b();
        }
        TextView textView = (TextView) this.f5015r.getContentView();
        C1822c c1822c = this.f5015r;
        CharSequence charSequence = this.f5004g;
        int paddingRight = textView.getPaddingRight() + textView.getPaddingLeft();
        int paddingBottom = textView.getPaddingBottom() + textView.getPaddingTop();
        int width = getWidth() - paddingRight;
        int i = width < 0 ? DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE : width;
        if (charSequence == null) {
            charSequence = "";
        }
        StaticLayout staticLayout = new StaticLayout(charSequence, textView.getPaint(), i, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        float f = 0.0f;
        for (int i2 = 0; i2 < staticLayout.getLineCount(); i2++) {
            f = Math.max(f, staticLayout.getLineWidth(i2));
        }
        c1822c.setWidth(paddingRight + ((int) Math.ceil(f)));
        c1822c.setHeight(staticLayout.getHeight() + paddingBottom);
        textView.setText(this.f5004g);
        this.f5015r.showAsDropDown(this, getWidth(), 0);
        C1822c c1822c2 = this.f5015r;
        c1822c2.m808a(c1822c2.isAboveAnchor());
    }

    /* renamed from: f */
    public void m809f() {
        if (this.f5017t) {
            String obj = getText().toString();
            if (TextUtils.isEmpty(obj)) {
                m811d();
                return;
            }
            Iterator<AbstractC0096Dd> it = this.f5018u.iterator();
            while (it.hasNext()) {
                AbstractC0096Dd next = it.next();
                if (!next.mo2475a(obj)) {
                    String str = next.f365a;
                    if (str != null) {
                        m812c(str);
                        return;
                    } else {
                        m812c(this.f5003f);
                        return;
                    }
                }
            }
            EnumC1820a enumC1820a = this.f5013p;
            EnumC1820a enumC1820a2 = EnumC1820a.VALID;
            if (enumC1820a != enumC1820a2) {
                this.f5013p = enumC1820a2;
                this.f5004g = null;
                Drawable drawable = this.f5012o;
                this.f5005h = drawable;
                setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
                setBackgroundDrawable(this.f5000b);
                setPadding(30, 0, 15, 0);
            }
        }
    }

    public void finalize() {
        removeTextChangedListener(this.f5014q);
        this.f4999a = null;
        this.f5000b = null;
        this.f5001c = null;
        this.f5005h = null;
        this.f5006i = null;
        this.f5007j = null;
        this.f5008k = null;
        this.f5009l = null;
        this.f5010m = null;
        this.f5011n = null;
        this.f5012o = null;
        super.finalize();
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            return;
        }
        m814a();
        m809f();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.f5004g != null) {
                if (x >= (getRight() - this.f5005h.getBounds().width()) - 0 && x <= (getRight() - getPaddingRight()) + 0 && y >= getPaddingTop() - 0 && y <= (getHeight() - getPaddingBottom()) + 0) {
                    C1822c c1822c = this.f5015r;
                    if (c1822c != null && c1822c.isShowing()) {
                        m814a();
                    } else {
                        m810e();
                    }
                    requestFocus();
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (this.f5015r == null) {
            m813b();
            this.f5015r.getContentView().setVisibility(8);
            m810e();
            m814a();
            this.f5015r.getContentView().setVisibility(0);
        }
        return frame;
    }

    public void setNoIcon() {
        setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
    }
}
