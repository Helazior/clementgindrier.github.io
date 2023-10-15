package p000;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;
import p000.AbstractC0148G4;

/* renamed from: m0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MenuItemC1968m0 extends AbstractC1672f0 implements MenuItem {

    /* renamed from: d */
    public final InterfaceMenuItemC0553X3 f5469d;

    /* renamed from: e */
    public Method f5470e;

    /* renamed from: m0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1969a extends AbstractC0148G4 {

        /* renamed from: c */
        public final ActionProvider f5471c;

        public C1969a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f5471c = actionProvider;
        }

        @Override // p000.AbstractC0148G4
        /* renamed from: a */
        public boolean mo607a() {
            return this.f5471c.hasSubMenu();
        }

        @Override // p000.AbstractC0148G4
        /* renamed from: c */
        public View mo606c() {
            return this.f5471c.onCreateActionView();
        }

        @Override // p000.AbstractC0148G4
        /* renamed from: e */
        public boolean mo605e() {
            return this.f5471c.onPerformDefaultAction();
        }

        @Override // p000.AbstractC0148G4
        /* renamed from: f */
        public void mo604f(SubMenu subMenu) {
            this.f5471c.onPrepareSubMenu(MenuItemC1968m0.this.m988d(subMenu));
        }
    }

    /* renamed from: m0$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ActionProvider$VisibilityListenerC1970b extends C1969a implements ActionProvider.VisibilityListener {

        /* renamed from: e */
        public AbstractC0148G4.InterfaceC0150b f5473e;

        public ActionProvider$VisibilityListenerC1970b(MenuItemC1968m0 menuItemC1968m0, Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // p000.AbstractC0148G4
        /* renamed from: b */
        public boolean mo603b() {
            return this.f5471c.isVisible();
        }

        @Override // p000.AbstractC0148G4
        /* renamed from: d */
        public View mo602d(MenuItem menuItem) {
            return this.f5471c.onCreateActionView(menuItem);
        }

        @Override // p000.AbstractC0148G4
        /* renamed from: g */
        public boolean mo601g() {
            return this.f5471c.overridesItemVisibility();
        }

        @Override // p000.AbstractC0148G4
        /* renamed from: h */
        public void mo600h(AbstractC0148G4.InterfaceC0150b interfaceC0150b) {
            this.f5473e = interfaceC0150b;
            this.f5471c.setVisibilityListener(this);
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            AbstractC0148G4.InterfaceC0150b interfaceC0150b = this.f5473e;
            if (interfaceC0150b != null) {
                C1950l0 c1950l0 = C1950l0.this;
                c1950l0.f5424n.onItemVisibleChanged(c1950l0);
            }
        }
    }

    /* renamed from: m0$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1971c extends FrameLayout implements InterfaceC0529W {

        /* renamed from: a */
        public final CollapsibleActionView f5474a;

        public C1971c(View view) {
            super(view.getContext());
            this.f5474a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // p000.InterfaceC0529W
        /* renamed from: b */
        public void mo599b() {
            this.f5474a.onActionViewExpanded();
        }

        @Override // p000.InterfaceC0529W
        /* renamed from: c */
        public void mo598c() {
            this.f5474a.onActionViewCollapsed();
        }
    }

    /* renamed from: m0$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class MenuItem$OnActionExpandListenerC1972d implements MenuItem.OnActionExpandListener {

        /* renamed from: a */
        public final MenuItem.OnActionExpandListener f5475a;

        public MenuItem$OnActionExpandListenerC1972d(MenuItem.OnActionExpandListener onActionExpandListener) {
            this.f5475a = onActionExpandListener;
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return this.f5475a.onMenuItemActionCollapse(MenuItemC1968m0.this.m989c(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return this.f5475a.onMenuItemActionExpand(MenuItemC1968m0.this.m989c(menuItem));
        }
    }

    /* renamed from: m0$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class MenuItem$OnMenuItemClickListenerC1973e implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a */
        public final MenuItem.OnMenuItemClickListener f5477a;

        public MenuItem$OnMenuItemClickListenerC1973e(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            this.f5477a = onMenuItemClickListener;
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return this.f5477a.onMenuItemClick(MenuItemC1968m0.this.m989c(menuItem));
        }
    }

    public MenuItemC1968m0(Context context, InterfaceMenuItemC0553X3 interfaceMenuItemC0553X3) {
        super(context);
        if (interfaceMenuItemC0553X3 != null) {
            this.f5469d = interfaceMenuItemC0553X3;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return this.f5469d.collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return this.f5469d.expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0148G4 mo648b = this.f5469d.mo648b();
        if (mo648b instanceof C1969a) {
            return ((C1969a) mo648b).f5471c;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = this.f5469d.getActionView();
        return actionView instanceof C1971c ? (View) ((C1971c) actionView).f5474a : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f5469d.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f5469d.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f5469d.getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f5469d.getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f5469d.getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f5469d.getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f5469d.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f5469d.getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f5469d.getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f5469d.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return this.f5469d.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f5469d.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f5469d.getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return m988d(this.f5469d.getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f5469d.getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f5469d.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f5469d.getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f5469d.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f5469d.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return this.f5469d.isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return this.f5469d.isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return this.f5469d.isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return this.f5469d.isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ActionProvider$VisibilityListenerC1970b actionProvider$VisibilityListenerC1970b = new ActionProvider$VisibilityListenerC1970b(this, this.f4166a, actionProvider);
        InterfaceMenuItemC0553X3 interfaceMenuItemC0553X3 = this.f5469d;
        if (actionProvider == null) {
            actionProvider$VisibilityListenerC1970b = null;
        }
        interfaceMenuItemC0553X3.mo649a(actionProvider$VisibilityListenerC1970b);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C1971c(view);
        }
        this.f5469d.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f5469d.setAlphabeticShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f5469d.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f5469d.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.f5469d.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f5469d.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f5469d.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f5469d.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f5469d.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f5469d.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f5469d.setNumericShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f5469d.setOnActionExpandListener(onActionExpandListener != null ? new MenuItem$OnActionExpandListenerC1972d(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f5469d.setOnMenuItemClickListener(onMenuItemClickListener != null ? new MenuItem$OnMenuItemClickListenerC1973e(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f5469d.setShortcut(c, c2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        this.f5469d.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        this.f5469d.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f5469d.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f5469d.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.f5469d.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return this.f5469d.setVisible(z);
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f5469d.setAlphabeticShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f5469d.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f5469d.setNumericShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f5469d.setShortcut(c, c2, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f5469d.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        this.f5469d.setActionView(i);
        View actionView = this.f5469d.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            this.f5469d.setActionView(new C1971c(actionView));
        }
        return this;
    }
}
