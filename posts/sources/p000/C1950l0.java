package p000;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import p000.AbstractC0148G4;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: l0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1950l0 implements InterfaceMenuItemC0553X3 {

    /* renamed from: A */
    public AbstractC0148G4 f5407A;

    /* renamed from: B */
    public MenuItem.OnActionExpandListener f5408B;

    /* renamed from: D */
    public ContextMenu.ContextMenuInfo f5410D;

    /* renamed from: a */
    public final int f5411a;

    /* renamed from: b */
    public final int f5412b;

    /* renamed from: c */
    public final int f5413c;

    /* renamed from: d */
    public final int f5414d;

    /* renamed from: e */
    public CharSequence f5415e;

    /* renamed from: f */
    public CharSequence f5416f;

    /* renamed from: g */
    public Intent f5417g;

    /* renamed from: h */
    public char f5418h;

    /* renamed from: j */
    public char f5420j;

    /* renamed from: l */
    public Drawable f5422l;

    /* renamed from: n */
    public C1905j0 f5424n;

    /* renamed from: o */
    public SubMenuC2267u0 f5425o;

    /* renamed from: p */
    public MenuItem.OnMenuItemClickListener f5426p;

    /* renamed from: q */
    public CharSequence f5427q;

    /* renamed from: r */
    public CharSequence f5428r;

    /* renamed from: y */
    public int f5435y;

    /* renamed from: z */
    public View f5436z;

    /* renamed from: i */
    public int f5419i = 4096;

    /* renamed from: k */
    public int f5421k = 4096;

    /* renamed from: m */
    public int f5423m = 0;

    /* renamed from: s */
    public ColorStateList f5429s = null;

    /* renamed from: t */
    public PorterDuff.Mode f5430t = null;

    /* renamed from: u */
    public boolean f5431u = false;

    /* renamed from: v */
    public boolean f5432v = false;

    /* renamed from: w */
    public boolean f5433w = false;

    /* renamed from: x */
    public int f5434x = 16;

    /* renamed from: C */
    public boolean f5409C = false;

    /* renamed from: l0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1951a implements AbstractC0148G4.InterfaceC0150b {
        public C1951a() {
        }
    }

    public C1950l0(C1905j0 c1905j0, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f5435y = 0;
        this.f5424n = c1905j0;
        this.f5411a = i2;
        this.f5412b = i;
        this.f5413c = i3;
        this.f5414d = i4;
        this.f5415e = charSequence;
        this.f5435y = i5;
    }

    /* renamed from: c */
    public static void m647c(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    @Override // p000.InterfaceMenuItemC0553X3
    /* renamed from: a */
    public InterfaceMenuItemC0553X3 mo649a(AbstractC0148G4 abstractC0148G4) {
        AbstractC0148G4 abstractC0148G42 = this.f5407A;
        if (abstractC0148G42 != null) {
            abstractC0148G42.f496b = null;
            abstractC0148G42.f495a = null;
        }
        this.f5436z = null;
        this.f5407A = abstractC0148G4;
        this.f5424n.onItemsChanged(true);
        AbstractC0148G4 abstractC0148G43 = this.f5407A;
        if (abstractC0148G43 != null) {
            abstractC0148G43.mo600h(new C1951a());
        }
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3
    /* renamed from: b */
    public AbstractC0148G4 mo648b() {
        return this.f5407A;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f5435y & 8) == 0) {
            return false;
        }
        if (this.f5436z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.f5408B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f5424n.collapseItemActionView(this);
        }
        return false;
    }

    /* renamed from: d */
    public final Drawable m646d(Drawable drawable) {
        if (drawable != null && this.f5433w && (this.f5431u || this.f5432v)) {
            drawable = LayoutInflater$Factory2C0000A.C0010h.m2604x0(drawable).mutate();
            if (this.f5431u) {
                drawable.setTintList(this.f5429s);
            }
            if (this.f5432v) {
                drawable.setTintMode(this.f5430t);
            }
            this.f5433w = false;
        }
        return drawable;
    }

    /* renamed from: e */
    public char m645e() {
        return this.f5424n.isQwertyMode() ? this.f5420j : this.f5418h;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public boolean expandActionView() {
        if (m644f()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.f5408B;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.f5424n.expandItemActionView(this);
            }
            return false;
        }
        return false;
    }

    /* renamed from: f */
    public boolean m644f() {
        AbstractC0148G4 abstractC0148G4;
        if ((this.f5435y & 8) != 0) {
            if (this.f5436z == null && (abstractC0148G4 = this.f5407A) != null) {
                this.f5436z = abstractC0148G4.mo602d(this);
            }
            return this.f5436z != null;
        }
        return false;
    }

    /* renamed from: g */
    public boolean m643g() {
        return (this.f5434x & 32) == 32;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public View getActionView() {
        View view = this.f5436z;
        if (view != null) {
            return view;
        }
        AbstractC0148G4 abstractC0148G4 = this.f5407A;
        if (abstractC0148G4 != null) {
            View mo602d = abstractC0148G4.mo602d(this);
            this.f5436z = mo602d;
            return mo602d;
        }
        return null;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f5421k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f5420j;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f5427q;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f5412b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f5422l;
        if (drawable != null) {
            return m646d(drawable);
        }
        if (this.f5423m != 0) {
            Drawable m2210b = C0279M.m2210b(this.f5424n.getContext(), this.f5423m);
            this.f5423m = 0;
            this.f5422l = m2210b;
            return m646d(m2210b);
        }
        return null;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f5429s;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f5430t;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f5417g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f5411a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f5410D;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f5419i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f5418h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f5413c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f5425o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f5415e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f5416f;
        return charSequence != null ? charSequence : this.f5415e;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f5428r;
    }

    /* renamed from: h */
    public boolean m642h() {
        return (this.f5434x & 4) != 0;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f5425o != null;
    }

    /* renamed from: i */
    public InterfaceMenuItemC0553X3 m641i(View view) {
        int i;
        this.f5436z = view;
        this.f5407A = null;
        if (view != null && view.getId() == -1 && (i = this.f5411a) > 0) {
            view.setId(i);
        }
        this.f5424n.onItemActionRequestChanged(this);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f5409C;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f5434x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f5434x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f5434x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        AbstractC0148G4 abstractC0148G4 = this.f5407A;
        return (abstractC0148G4 == null || !abstractC0148G4.mo601g()) ? (this.f5434x & 8) == 0 : (this.f5434x & 8) == 0 && this.f5407A.mo603b();
    }

    /* renamed from: j */
    public void m640j(boolean z) {
        int i = this.f5434x;
        int i2 = (z ? 2 : 0) | (i & (-3));
        this.f5434x = i2;
        if (i != i2) {
            this.f5424n.onItemsChanged(false);
        }
    }

    /* renamed from: k */
    public void m639k(boolean z) {
        this.f5434x = (z ? 4 : 0) | (this.f5434x & (-5));
    }

    /* renamed from: l */
    public void m638l(boolean z) {
        if (z) {
            this.f5434x |= 32;
        } else {
            this.f5434x &= -33;
        }
    }

    /* renamed from: m */
    public boolean m637m(boolean z) {
        int i = this.f5434x;
        int i2 = (z ? 0 : 8) | (i & (-9));
        this.f5434x = i2;
        return i != i2;
    }

    /* renamed from: n */
    public boolean m636n() {
        return this.f5424n.isShortcutsVisible() && m645e() != 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        m641i(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f5420j == c) {
            return this;
        }
        this.f5420j = Character.toLowerCase(c);
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f5434x;
        int i2 = (z ? 1 : 0) | (i & (-2));
        this.f5434x = i2;
        if (i != i2) {
            this.f5424n.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.f5434x & 4) != 0) {
            this.f5424n.setExclusiveItemChecked(this);
        } else {
            m640j(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f5427q = charSequence;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f5434x |= 16;
        } else {
            this.f5434x &= -17;
        }
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f5423m = 0;
        this.f5422l = drawable;
        this.f5433w = true;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f5429s = colorStateList;
        this.f5431u = true;
        this.f5433w = true;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f5430t = mode;
        this.f5432v = true;
        this.f5433w = true;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f5417g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f5418h == c) {
            return this;
        }
        this.f5418h = c;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f5408B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f5426p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f5418h = c;
        this.f5420j = Character.toLowerCase(c2);
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f5435y = i;
        this.f5424n.onItemActionRequestChanged(this);
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f5415e = charSequence;
        this.f5424n.onItemsChanged(false);
        SubMenuC2267u0 subMenuC2267u0 = this.f5425o;
        if (subMenuC2267u0 != null) {
            subMenuC2267u0.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f5416f = charSequence;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f5428r = charSequence;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m637m(z)) {
            this.f5424n.onItemVisibleChanged(this);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.f5415e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setActionView(int i) {
        Context context = this.f5424n.getContext();
        m641i(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public InterfaceMenuItemC0553X3 setContentDescription(CharSequence charSequence) {
        this.f5427q = charSequence;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public InterfaceMenuItemC0553X3 setTooltipText(CharSequence charSequence) {
        this.f5428r = charSequence;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f5420j == c && this.f5421k == i) {
            return this;
        }
        this.f5420j = Character.toLowerCase(c);
        this.f5421k = KeyEvent.normalizeMetaState(i);
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f5418h == c && this.f5419i == i) {
            return this;
        }
        this.f5418h = c;
        this.f5419i = KeyEvent.normalizeMetaState(i);
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f5418h = c;
        this.f5419i = KeyEvent.normalizeMetaState(i);
        this.f5420j = Character.toLowerCase(c2);
        this.f5421k = KeyEvent.normalizeMetaState(i2);
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f5422l = null;
        this.f5423m = i;
        this.f5433w = true;
        this.f5424n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        setTitle(this.f5424n.getContext().getString(i));
        return this;
    }
}
