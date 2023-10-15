package p000;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionMenuPresenter;
import java.lang.ref.WeakReference;
import p000.AbstractC0485V;
import p000.C1905j0;

/* renamed from: Y */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0566Y extends AbstractC0485V implements C1905j0.InterfaceC1906a {

    /* renamed from: c */
    public Context f2016c;

    /* renamed from: d */
    public ActionBarContextView f2017d;

    /* renamed from: f */
    public AbstractC0485V.InterfaceC0486a f2018f;

    /* renamed from: g */
    public WeakReference<View> f2019g;

    /* renamed from: h */
    public boolean f2020h;

    /* renamed from: i */
    public C1905j0 f2021i;

    public C0566Y(Context context, ActionBarContextView actionBarContextView, AbstractC0485V.InterfaceC0486a interfaceC0486a, boolean z) {
        this.f2016c = context;
        this.f2017d = actionBarContextView;
        this.f2018f = interfaceC0486a;
        C1905j0 defaultShowAsAction = new C1905j0(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f2021i = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
    }

    @Override // p000.AbstractC0485V
    /* renamed from: a */
    public void mo1792a() {
        if (this.f2020h) {
            return;
        }
        this.f2020h = true;
        this.f2017d.sendAccessibilityEvent(32);
        this.f2018f.mo1759b(this);
    }

    @Override // p000.AbstractC0485V
    /* renamed from: b */
    public View mo1791b() {
        WeakReference<View> weakReference = this.f2019g;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // p000.AbstractC0485V
    /* renamed from: c */
    public Menu mo1790c() {
        return this.f2021i;
    }

    @Override // p000.AbstractC0485V
    /* renamed from: d */
    public MenuInflater mo1789d() {
        return new C0602a0(this.f2017d.getContext());
    }

    @Override // p000.AbstractC0485V
    /* renamed from: e */
    public CharSequence mo1788e() {
        return this.f2017d.f2345k;
    }

    @Override // p000.AbstractC0485V
    /* renamed from: f */
    public CharSequence mo1787f() {
        return this.f2017d.f2344j;
    }

    @Override // p000.AbstractC0485V
    /* renamed from: g */
    public void mo1786g() {
        this.f2018f.mo1760a(this, this.f2021i);
    }

    @Override // p000.AbstractC0485V
    /* renamed from: h */
    public boolean mo1785h() {
        return this.f2017d.f2353s;
    }

    @Override // p000.AbstractC0485V
    /* renamed from: i */
    public void mo1784i(View view) {
        this.f2017d.setCustomView(view);
        this.f2019g = view != null ? new WeakReference<>(view) : null;
    }

    @Override // p000.AbstractC0485V
    /* renamed from: j */
    public void mo1783j(int i) {
        this.f2017d.setSubtitle(this.f2016c.getString(i));
    }

    @Override // p000.AbstractC0485V
    /* renamed from: k */
    public void mo1782k(CharSequence charSequence) {
        this.f2017d.setSubtitle(charSequence);
    }

    @Override // p000.AbstractC0485V
    /* renamed from: l */
    public void mo1781l(int i) {
        this.f2017d.setTitle(this.f2016c.getString(i));
    }

    @Override // p000.AbstractC0485V
    /* renamed from: m */
    public void mo1780m(CharSequence charSequence) {
        this.f2017d.setTitle(charSequence);
    }

    @Override // p000.AbstractC0485V
    /* renamed from: n */
    public void mo1779n(boolean z) {
        this.f1771b = z;
        this.f2017d.setTitleOptional(z);
    }

    @Override // p000.C1905j0.InterfaceC1906a
    public boolean onMenuItemSelected(C1905j0 c1905j0, MenuItem menuItem) {
        return this.f2018f.mo1758c(this, menuItem);
    }

    @Override // p000.C1905j0.InterfaceC1906a
    public void onMenuModeChange(C1905j0 c1905j0) {
        mo1786g();
        ActionMenuPresenter actionMenuPresenter = this.f2017d.f6726d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.m1653f();
        }
    }
}
