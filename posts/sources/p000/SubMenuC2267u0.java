package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import p000.C1905j0;

/* renamed from: u0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SubMenuC2267u0 extends C1905j0 implements SubMenu {
    private C1950l0 mItem;
    private C1905j0 mParentMenu;

    public SubMenuC2267u0(Context context, C1905j0 c1905j0, C1950l0 c1950l0) {
        super(context);
        this.mParentMenu = c1905j0;
        this.mItem = c1950l0;
    }

    @Override // p000.C1905j0
    public boolean collapseItemActionView(C1950l0 c1950l0) {
        return this.mParentMenu.collapseItemActionView(c1950l0);
    }

    @Override // p000.C1905j0
    public boolean dispatchMenuItemSelected(C1905j0 c1905j0, MenuItem menuItem) {
        return super.dispatchMenuItemSelected(c1905j0, menuItem) || this.mParentMenu.dispatchMenuItemSelected(c1905j0, menuItem);
    }

    @Override // p000.C1905j0
    public boolean expandItemActionView(C1950l0 c1950l0) {
        return this.mParentMenu.expandItemActionView(c1950l0);
    }

    @Override // p000.C1905j0
    public String getActionViewStatesKey() {
        C1950l0 c1950l0 = this.mItem;
        int i = c1950l0 != null ? c1950l0.f5411a : 0;
        if (i == 0) {
            return null;
        }
        return super.getActionViewStatesKey() + ":" + i;
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.mItem;
    }

    public Menu getParentMenu() {
        return this.mParentMenu;
    }

    @Override // p000.C1905j0
    public C1905j0 getRootMenu() {
        return this.mParentMenu.getRootMenu();
    }

    @Override // p000.C1905j0
    public boolean isGroupDividerEnabled() {
        return this.mParentMenu.isGroupDividerEnabled();
    }

    @Override // p000.C1905j0
    public boolean isQwertyMode() {
        return this.mParentMenu.isQwertyMode();
    }

    @Override // p000.C1905j0
    public boolean isShortcutsVisible() {
        return this.mParentMenu.isShortcutsVisible();
    }

    @Override // p000.C1905j0
    public void setCallback(C1905j0.InterfaceC1906a interfaceC1906a) {
        this.mParentMenu.setCallback(interfaceC1906a);
    }

    @Override // p000.C1905j0, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.mParentMenu.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.setHeaderIconInt(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.setHeaderTitleInt(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.setHeaderViewInt(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.mItem.setIcon(drawable);
        return this;
    }

    @Override // p000.C1905j0, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.mParentMenu.setQwertyMode(z);
    }

    @Override // p000.C1905j0
    public void setShortcutsVisible(boolean z) {
        this.mParentMenu.setShortcutsVisible(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.setHeaderIconInt(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.setHeaderTitleInt(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.mItem.setIcon(i);
        return this;
    }
}
