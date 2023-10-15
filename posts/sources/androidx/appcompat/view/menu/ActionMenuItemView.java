package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.AppCompatTextView;
import p000.C1905j0;
import p000.InterfaceC2186q0;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements InterfaceC2186q0.InterfaceC2187a, View.OnClickListener, ActionMenuView.InterfaceC0650a {

    /* renamed from: a */
    public C1950l0 f2303a;

    /* renamed from: b */
    public CharSequence f2304b;

    /* renamed from: c */
    public Drawable f2305c;

    /* renamed from: d */
    public C1905j0.InterfaceC1907b f2306d;

    /* renamed from: f */
    public AbstractView$OnTouchListenerC0325O0 f2307f;

    /* renamed from: g */
    public AbstractC0636b f2308g;

    /* renamed from: h */
    public boolean f2309h;

    /* renamed from: i */
    public boolean f2310i;

    /* renamed from: j */
    public int f2311j;

    /* renamed from: k */
    public int f2312k;

    /* renamed from: l */
    public int f2313l;

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0635a extends AbstractView$OnTouchListenerC0325O0 {
        public C0635a() {
            super(ActionMenuItemView.this);
        }

        @Override // p000.AbstractView$OnTouchListenerC0325O0
        /* renamed from: b */
        public InterfaceC2222s0 mo1640b() {
            ActionMenuPresenter.C0643a c0643a;
            AbstractC0636b abstractC0636b = ActionMenuItemView.this.f2308g;
            if (abstractC0636b == null || (c0643a = ActionMenuPresenter.this.f2404w) == null) {
                return null;
            }
            return c0643a.m544a();
        }

        @Override // p000.AbstractView$OnTouchListenerC0325O0
        /* renamed from: c */
        public boolean mo1639c() {
            InterfaceC2222s0 mo1640b;
            ActionMenuItemView actionMenuItemView = ActionMenuItemView.this;
            C1905j0.InterfaceC1907b interfaceC1907b = actionMenuItemView.f2306d;
            return interfaceC1907b != null && interfaceC1907b.mo723a(actionMenuItemView.f2303a) && (mo1640b = mo1640b()) != null && mo1640b.mo394a();
        }
    }

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0636b {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0650a
    /* renamed from: a */
    public boolean mo1647a() {
        return m1680c();
    }

    @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0650a
    /* renamed from: b */
    public boolean mo1646b() {
        return m1680c() && this.f2303a.getIcon() == null;
    }

    /* renamed from: c */
    public boolean m1680c() {
        return !TextUtils.isEmpty(getText());
    }

    /* renamed from: d */
    public final boolean m1679d() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    /* renamed from: e */
    public final void m1678e() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f2304b);
        if (this.f2305c != null) {
            if (!((this.f2303a.f5435y & 4) == 4) || (!this.f2309h && !this.f2310i)) {
                z = false;
            }
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f2304b : null);
        CharSequence charSequence = this.f2303a.f5427q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z3 ? null : this.f2303a.f5415e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.f2303a.f5428r;
        if (TextUtils.isEmpty(charSequence2)) {
            LayoutInflater$Factory2C0000A.C0010h.m2616r0(this, z3 ? null : this.f2303a.f5415e);
        } else {
            LayoutInflater$Factory2C0000A.C0010h.m2616r0(this, charSequence2);
        }
    }

    @Override // p000.InterfaceC2186q0.InterfaceC2187a
    public C1950l0 getItemData() {
        return this.f2303a;
    }

    @Override // p000.InterfaceC2186q0.InterfaceC2187a
    public void initialize(C1950l0 c1950l0, int i) {
        this.f2303a = c1950l0;
        setIcon(c1950l0.getIcon());
        setTitle(c1950l0.getTitleCondensed());
        setId(c1950l0.f5411a);
        setVisibility(c1950l0.isVisible() ? 0 : 8);
        setEnabled(c1950l0.isEnabled());
        if (c1950l0.hasSubMenu() && this.f2307f == null) {
            this.f2307f = new C0635a();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1905j0.InterfaceC1907b interfaceC1907b = this.f2306d;
        if (interfaceC1907b != null) {
            interfaceC1907b.mo723a(this.f2303a);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f2309h = m1679d();
        m1678e();
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        boolean m1680c = m1680c();
        if (m1680c && (i4 = this.f2312k) >= 0) {
            super.setPadding(i4, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        if (mode == Integer.MIN_VALUE) {
            i3 = Math.min(size, this.f2311j);
        } else {
            i3 = this.f2311j;
        }
        if (mode != 1073741824 && this.f2311j > 0 && measuredWidth < i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
        }
        if (m1680c || this.f2305c == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f2305c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractView$OnTouchListenerC0325O0 abstractView$OnTouchListenerC0325O0;
        if (this.f2303a.hasSubMenu() && (abstractView$OnTouchListenerC0325O0 = this.f2307f) != null && abstractView$OnTouchListenerC0325O0.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f2310i != z) {
            this.f2310i = z;
            C1950l0 c1950l0 = this.f2303a;
            if (c1950l0 != null) {
                c1950l0.f5424n.onItemActionRequestChanged(c1950l0);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f2305c = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f2313l;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        m1678e();
    }

    public void setItemInvoker(C1905j0.InterfaceC1907b interfaceC1907b) {
        this.f2306d = interfaceC1907b;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f2312k = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(AbstractC0636b abstractC0636b) {
        this.f2308g = abstractC0636b;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTitle(CharSequence charSequence) {
        this.f2304b = charSequence;
        m1678e();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f2309h = m1679d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2012o.ActionMenuItemView, i, 0);
        this.f2311j = obtainStyledAttributes.getDimensionPixelSize(C2012o.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f2313l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f2312k = -1;
        setSaveEnabled(false);
    }
}
