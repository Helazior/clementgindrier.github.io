package p000;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;
import p000.AbstractC0485V;

/* renamed from: Z */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0582Z extends ActionMode {

    /* renamed from: a */
    public final Context f2061a;

    /* renamed from: b */
    public final AbstractC0485V f2062b;

    /* renamed from: Z$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0583a implements AbstractC0485V.InterfaceC0486a {

        /* renamed from: a */
        public final ActionMode.Callback f2063a;

        /* renamed from: b */
        public final Context f2064b;

        /* renamed from: c */
        public final ArrayList<C0582Z> f2065c = new ArrayList<>();

        /* renamed from: d */
        public final C0101E1<Menu, Menu> f2066d = new C0101E1<>();

        public C0583a(Context context, ActionMode.Callback callback) {
            this.f2064b = context;
            this.f2063a = callback;
        }

        @Override // p000.AbstractC0485V.InterfaceC0486a
        /* renamed from: a */
        public boolean mo1760a(AbstractC0485V abstractC0485V, Menu menu) {
            return this.f2063a.onPrepareActionMode(m1756e(abstractC0485V), m1755f(menu));
        }

        @Override // p000.AbstractC0485V.InterfaceC0486a
        /* renamed from: b */
        public void mo1759b(AbstractC0485V abstractC0485V) {
            this.f2063a.onDestroyActionMode(m1756e(abstractC0485V));
        }

        @Override // p000.AbstractC0485V.InterfaceC0486a
        /* renamed from: c */
        public boolean mo1758c(AbstractC0485V abstractC0485V, MenuItem menuItem) {
            return this.f2063a.onActionItemClicked(m1756e(abstractC0485V), new MenuItemC1968m0(this.f2064b, (InterfaceMenuItemC0553X3) menuItem));
        }

        @Override // p000.AbstractC0485V.InterfaceC0486a
        /* renamed from: d */
        public boolean mo1757d(AbstractC0485V abstractC0485V, Menu menu) {
            return this.f2063a.onCreateActionMode(m1756e(abstractC0485V), m1755f(menu));
        }

        /* renamed from: e */
        public ActionMode m1756e(AbstractC0485V abstractC0485V) {
            int size = this.f2065c.size();
            for (int i = 0; i < size; i++) {
                C0582Z c0582z = this.f2065c.get(i);
                if (c0582z != null && c0582z.f2062b == abstractC0485V) {
                    return c0582z;
                }
            }
            C0582Z c0582z2 = new C0582Z(this.f2064b, abstractC0485V);
            this.f2065c.add(c0582z2);
            return c0582z2;
        }

        /* renamed from: f */
        public final Menu m1755f(Menu menu) {
            Menu menu2 = this.f2066d.get(menu);
            if (menu2 == null) {
                MenuC2205r0 menuC2205r0 = new MenuC2205r0(this.f2064b, (InterfaceMenuC0534W3) menu);
                this.f2066d.put(menu, menuC2205r0);
                return menuC2205r0;
            }
            return menu2;
        }
    }

    public C0582Z(Context context, AbstractC0485V abstractC0485V) {
        this.f2061a = context;
        this.f2062b = abstractC0485V;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f2062b.mo1792a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f2062b.mo1791b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new MenuC2205r0(this.f2061a, (InterfaceMenuC0534W3) this.f2062b.mo1790c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f2062b.mo1789d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f2062b.mo1788e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f2062b.f1770a;
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f2062b.mo1787f();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f2062b.f1771b;
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f2062b.mo1786g();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f2062b.mo1785h();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f2062b.mo1784i(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f2062b.mo1782k(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f2062b.f1770a = obj;
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f2062b.mo1780m(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f2062b.mo1779n(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f2062b.mo1783j(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f2062b.mo1781l(i);
    }
}
