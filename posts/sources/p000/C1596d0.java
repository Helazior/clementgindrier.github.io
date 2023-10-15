package p000;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p000.C2307w3;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: d0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1596d0 implements InterfaceMenuItemC0553X3 {

    /* renamed from: a */
    public CharSequence f3941a;

    /* renamed from: b */
    public CharSequence f3942b;

    /* renamed from: c */
    public Intent f3943c;

    /* renamed from: d */
    public char f3944d;

    /* renamed from: f */
    public char f3946f;

    /* renamed from: h */
    public Drawable f3948h;

    /* renamed from: i */
    public Context f3949i;

    /* renamed from: j */
    public CharSequence f3950j;

    /* renamed from: k */
    public CharSequence f3951k;

    /* renamed from: e */
    public int f3945e = 4096;

    /* renamed from: g */
    public int f3947g = 4096;

    /* renamed from: l */
    public ColorStateList f3952l = null;

    /* renamed from: m */
    public PorterDuff.Mode f3953m = null;

    /* renamed from: n */
    public boolean f3954n = false;

    /* renamed from: o */
    public boolean f3955o = false;

    /* renamed from: p */
    public int f3956p = 16;

    public C1596d0(Context context, int i, int i2, int i3, CharSequence charSequence) {
        this.f3949i = context;
        this.f3941a = charSequence;
    }

    @Override // p000.InterfaceMenuItemC0553X3
    /* renamed from: a */
    public InterfaceMenuItemC0553X3 mo649a(AbstractC0148G4 abstractC0148G4) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.InterfaceMenuItemC0553X3
    /* renamed from: b */
    public AbstractC0148G4 mo648b() {
        return null;
    }

    /* renamed from: c */
    public final void m1062c() {
        Drawable drawable = this.f3948h;
        if (drawable != null) {
            if (this.f3954n || this.f3955o) {
                Drawable m2604x0 = LayoutInflater$Factory2C0000A.C0010h.m2604x0(drawable);
                this.f3948h = m2604x0;
                Drawable mutate = m2604x0.mutate();
                this.f3948h = mutate;
                if (this.f3954n) {
                    mutate.setTintList(this.f3952l);
                }
                if (this.f3955o) {
                    this.f3948h.setTintMode(this.f3953m);
                }
            }
        }
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f3947g;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f3946f;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f3950j;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f3948h;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f3952l;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f3953m;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f3943c;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return 16908332;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f3945e;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f3944d;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f3941a;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f3942b;
        return charSequence != null ? charSequence : this.f3941a;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f3951k;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f3956p & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f3956p & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f3956p & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f3956p & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f3946f = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f3956p = (z ? 1 : 0) | (this.f3956p & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f3956p = (z ? 2 : 0) | (this.f3956p & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f3950j = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f3956p = (z ? 16 : 0) | (this.f3956p & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f3948h = drawable;
        m1062c();
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f3952l = colorStateList;
        this.f3954n = true;
        m1062c();
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f3953m = mode;
        this.f3955o = true;
        m1062c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f3943c = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f3944d = c;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f3944d = c;
        this.f3946f = Character.toLowerCase(c2);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f3941a = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f3942b = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f3951k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f3956p = (this.f3956p & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f3946f = Character.toLowerCase(c);
        this.f3947g = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public InterfaceMenuItemC0553X3 setContentDescription(CharSequence charSequence) {
        this.f3950j = charSequence;
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f3944d = c;
        this.f3945e = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f3941a = this.f3949i.getResources().getString(i);
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public InterfaceMenuItemC0553X3 setTooltipText(CharSequence charSequence) {
        this.f3951k = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        Context context = this.f3949i;
        Object obj = C2307w3.f6741a;
        this.f3948h = C2307w3.C2310c.m202b(context, i);
        m1062c();
        return this;
    }

    @Override // p000.InterfaceMenuItemC0553X3, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f3944d = c;
        this.f3945e = KeyEvent.normalizeMetaState(i);
        this.f3946f = Character.toLowerCase(c2);
        this.f3947g = KeyEvent.normalizeMetaState(i2);
        return this;
    }
}
