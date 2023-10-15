package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ScrollingTabContainerView;
import androidx.appcompat.widget.Toolbar;
import p000.C1905j0;
import p000.InterfaceC2165p0;

/* renamed from: d1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1597d1 implements InterfaceC0231K0 {

    /* renamed from: a */
    public Toolbar f3957a;

    /* renamed from: b */
    public int f3958b;

    /* renamed from: c */
    public View f3959c;

    /* renamed from: d */
    public View f3960d;

    /* renamed from: e */
    public Drawable f3961e;

    /* renamed from: f */
    public Drawable f3962f;

    /* renamed from: g */
    public Drawable f3963g;

    /* renamed from: h */
    public boolean f3964h;

    /* renamed from: i */
    public CharSequence f3965i;

    /* renamed from: j */
    public CharSequence f3966j;

    /* renamed from: k */
    public CharSequence f3967k;

    /* renamed from: l */
    public Window.Callback f3968l;

    /* renamed from: m */
    public boolean f3969m;

    /* renamed from: n */
    public ActionMenuPresenter f3970n;

    /* renamed from: o */
    public int f3971o;

    /* renamed from: p */
    public Drawable f3972p;

    /* renamed from: d1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1598a extends C0588Z4 {

        /* renamed from: a */
        public boolean f3973a = false;

        /* renamed from: b */
        public final /* synthetic */ int f3974b;

        public C1598a(int i) {
            this.f3974b = i;
        }

        @Override // p000.C0588Z4, p000.InterfaceC0571Y4
        /* renamed from: a */
        public void mo224a(View view) {
            this.f3973a = true;
        }

        @Override // p000.InterfaceC0571Y4
        /* renamed from: b */
        public void mo223b(View view) {
            if (this.f3973a) {
                return;
            }
            C1597d1.this.f3957a.setVisibility(this.f3974b);
        }

        @Override // p000.C0588Z4, p000.InterfaceC0571Y4
        /* renamed from: c */
        public void mo222c(View view) {
            C1597d1.this.f3957a.setVisibility(0);
        }
    }

    public C1597d1(Toolbar toolbar, boolean z) {
        int i;
        Drawable drawable;
        int i2 = C1967m.abc_action_bar_up_description;
        this.f3971o = 0;
        this.f3957a = toolbar;
        this.f3965i = toolbar.getTitle();
        this.f3966j = toolbar.getSubtitle();
        this.f3964h = this.f3965i != null;
        this.f3963g = toolbar.getNavigationIcon();
        C0954b1 m1196r = C0954b1.m1196r(toolbar.getContext(), null, C2012o.ActionBar, C1671f.actionBarStyle, 0);
        this.f3972p = m1196r.m1207g(C2012o.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence m1199o = m1196r.m1199o(C2012o.ActionBar_title);
            if (!TextUtils.isEmpty(m1199o)) {
                setTitle(m1199o);
            }
            CharSequence m1199o2 = m1196r.m1199o(C2012o.ActionBar_subtitle);
            if (!TextUtils.isEmpty(m1199o2)) {
                this.f3966j = m1199o2;
                if ((this.f3958b & 8) != 0) {
                    this.f3957a.setSubtitle(m1199o2);
                }
            }
            Drawable m1207g = m1196r.m1207g(C2012o.ActionBar_logo);
            if (m1207g != null) {
                this.f3962f = m1207g;
                m1037y();
            }
            Drawable m1207g2 = m1196r.m1207g(C2012o.ActionBar_icon);
            if (m1207g2 != null) {
                this.f3961e = m1207g2;
                m1037y();
            }
            if (this.f3963g == null && (drawable = this.f3972p) != null) {
                this.f3963g = drawable;
                m1038x();
            }
            mo1049m(m1196r.m1204j(C2012o.ActionBar_displayOptions, 0));
            int m1201m = m1196r.m1201m(C2012o.ActionBar_customNavigationLayout, 0);
            if (m1201m != 0) {
                View inflate = LayoutInflater.from(this.f3957a.getContext()).inflate(m1201m, (ViewGroup) this.f3957a, false);
                View view = this.f3960d;
                if (view != null && (this.f3958b & 16) != 0) {
                    this.f3957a.removeView(view);
                }
                this.f3960d = inflate;
                if (inflate != null && (this.f3958b & 16) != 0) {
                    this.f3957a.addView(inflate);
                }
                mo1049m(this.f3958b | 16);
            }
            int m1202l = m1196r.m1202l(C2012o.ActionBar_height, 0);
            if (m1202l > 0) {
                ViewGroup.LayoutParams layoutParams = this.f3957a.getLayoutParams();
                layoutParams.height = m1202l;
                this.f3957a.setLayoutParams(layoutParams);
            }
            int m1209e = m1196r.m1209e(C2012o.ActionBar_contentInsetStart, -1);
            int m1209e2 = m1196r.m1209e(C2012o.ActionBar_contentInsetEnd, -1);
            if (m1209e >= 0 || m1209e2 >= 0) {
                this.f3957a.setContentInsetsRelative(Math.max(m1209e, 0), Math.max(m1209e2, 0));
            }
            int m1201m2 = m1196r.m1201m(C2012o.ActionBar_titleTextStyle, 0);
            if (m1201m2 != 0) {
                Toolbar toolbar2 = this.f3957a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), m1201m2);
            }
            int m1201m3 = m1196r.m1201m(C2012o.ActionBar_subtitleTextStyle, 0);
            if (m1201m3 != 0) {
                Toolbar toolbar3 = this.f3957a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), m1201m3);
            }
            int m1201m4 = m1196r.m1201m(C2012o.ActionBar_popupTheme, 0);
            if (m1201m4 != 0) {
                this.f3957a.setPopupTheme(m1201m4);
            }
        } else {
            if (this.f3957a.getNavigationIcon() != null) {
                i = 15;
                this.f3972p = this.f3957a.getNavigationIcon();
            } else {
                i = 11;
            }
            this.f3958b = i;
        }
        m1196r.f3660b.recycle();
        if (i2 != this.f3971o) {
            this.f3971o = i2;
            if (TextUtils.isEmpty(this.f3957a.getNavigationContentDescription())) {
                int i3 = this.f3971o;
                this.f3967k = i3 != 0 ? mo1051k().getString(i3) : null;
                m1039w();
            }
        }
        this.f3967k = this.f3957a.getNavigationContentDescription();
        this.f3957a.setNavigationOnClickListener(new View$OnClickListenerC0981c1(this));
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: a */
    public boolean mo1061a() {
        return this.f3957a.isOverflowMenuShowing();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: b */
    public boolean mo1060b() {
        return this.f3957a.isOverflowMenuShowPending();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: c */
    public boolean mo1059c() {
        return this.f3957a.hideOverflowMenu();
    }

    @Override // p000.InterfaceC0231K0
    public void collapseActionView() {
        this.f3957a.collapseActionView();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: d */
    public boolean mo1058d() {
        return this.f3957a.showOverflowMenu();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: e */
    public boolean mo1057e() {
        return this.f3957a.canShowOverflowMenu();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: f */
    public void mo1056f() {
        this.f3957a.dismissPopupMenus();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: g */
    public void mo1055g(InterfaceC2165p0.InterfaceC2166a interfaceC2166a, C1905j0.InterfaceC1906a interfaceC1906a) {
        this.f3957a.setMenuCallbacks(interfaceC2166a, interfaceC1906a);
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: h */
    public void mo1054h(ScrollingTabContainerView scrollingTabContainerView) {
        View view = this.f3959c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f3957a;
            if (parent == toolbar) {
                toolbar.removeView(this.f3959c);
            }
        }
        this.f3959c = null;
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: i */
    public ViewGroup mo1053i() {
        return this.f3957a;
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: j */
    public void mo1052j(boolean z) {
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: k */
    public Context mo1051k() {
        return this.f3957a.getContext();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: l */
    public boolean mo1050l() {
        return this.f3957a.hasExpandedActionView();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: m */
    public void mo1049m(int i) {
        View view;
        int i2 = this.f3958b ^ i;
        this.f3958b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m1039w();
                }
                m1038x();
            }
            if ((i2 & 3) != 0) {
                m1037y();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f3957a.setTitle(this.f3965i);
                    this.f3957a.setSubtitle(this.f3966j);
                } else {
                    this.f3957a.setTitle((CharSequence) null);
                    this.f3957a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.f3960d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f3957a.addView(view);
            } else {
                this.f3957a.removeView(view);
            }
        }
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: n */
    public int mo1048n() {
        return this.f3958b;
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: o */
    public Menu mo1047o() {
        return this.f3957a.getMenu();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: p */
    public void mo1046p(int i) {
        this.f3962f = i != 0 ? C0279M.m2210b(mo1051k(), i) : null;
        m1037y();
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: q */
    public int mo1045q() {
        return 0;
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: r */
    public C0554X4 mo1044r(int i, long j) {
        C0554X4 m1969b = C0492V4.m1969b(this.f3957a);
        m1969b.m1809a(i == 0 ? 1.0f : 0.0f);
        m1969b.m1807c(j);
        C1598a c1598a = new C1598a(i);
        View view = m1969b.f1987a.get();
        if (view != null) {
            m1969b.m1805e(view, c1598a);
        }
        return m1969b;
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: s */
    public void mo1043s() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // p000.InterfaceC0231K0
    public void setIcon(int i) {
        this.f3961e = i != 0 ? C0279M.m2210b(mo1051k(), i) : null;
        m1037y();
    }

    @Override // p000.InterfaceC0231K0
    public void setMenu(Menu menu, InterfaceC2165p0.InterfaceC2166a interfaceC2166a) {
        if (this.f3970n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f3957a.getContext());
            this.f3970n = actionMenuPresenter;
            actionMenuPresenter.f4106j = C1930k.action_menu_presenter;
        }
        ActionMenuPresenter actionMenuPresenter2 = this.f3970n;
        actionMenuPresenter2.f4102f = interfaceC2166a;
        this.f3957a.setMenu((C1905j0) menu, actionMenuPresenter2);
    }

    @Override // p000.InterfaceC0231K0
    public void setMenuPrepared() {
        this.f3969m = true;
    }

    @Override // p000.InterfaceC0231K0
    public void setTitle(CharSequence charSequence) {
        this.f3964h = true;
        this.f3965i = charSequence;
        if ((this.f3958b & 8) != 0) {
            this.f3957a.setTitle(charSequence);
        }
    }

    @Override // p000.InterfaceC0231K0
    public void setVisibility(int i) {
        this.f3957a.setVisibility(i);
    }

    @Override // p000.InterfaceC0231K0
    public void setWindowCallback(Window.Callback callback) {
        this.f3968l = callback;
    }

    @Override // p000.InterfaceC0231K0
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f3964h) {
            return;
        }
        this.f3965i = charSequence;
        if ((this.f3958b & 8) != 0) {
            this.f3957a.setTitle(charSequence);
        }
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: t */
    public void mo1042t() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: u */
    public void mo1041u(boolean z) {
        this.f3957a.setCollapsible(z);
    }

    @Override // p000.InterfaceC0231K0
    /* renamed from: v */
    public void mo1040v(int i) {
        this.f3963g = i != 0 ? C0279M.m2210b(mo1051k(), i) : null;
        m1038x();
    }

    /* renamed from: w */
    public final void m1039w() {
        if ((this.f3958b & 4) != 0) {
            if (TextUtils.isEmpty(this.f3967k)) {
                this.f3957a.setNavigationContentDescription(this.f3971o);
            } else {
                this.f3957a.setNavigationContentDescription(this.f3967k);
            }
        }
    }

    /* renamed from: x */
    public final void m1038x() {
        if ((this.f3958b & 4) != 0) {
            Toolbar toolbar = this.f3957a;
            Drawable drawable = this.f3963g;
            if (drawable == null) {
                drawable = this.f3972p;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f3957a.setNavigationIcon((Drawable) null);
    }

    /* renamed from: y */
    public final void m1037y() {
        Drawable drawable;
        int i = this.f3958b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.f3962f;
            if (drawable == null) {
                drawable = this.f3961e;
            }
        } else {
            drawable = this.f3961e;
        }
        this.f3957a.setLogo(drawable);
    }

    @Override // p000.InterfaceC0231K0
    public void setIcon(Drawable drawable) {
        this.f3961e = drawable;
        m1037y();
    }
}
