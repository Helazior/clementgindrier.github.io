package p000;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: f0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1672f0 {

    /* renamed from: a */
    public final Context f4166a;

    /* renamed from: b */
    public C0101E1<InterfaceMenuItemC0553X3, MenuItem> f4167b;

    /* renamed from: c */
    public C0101E1<InterfaceSubMenuC0570Y3, SubMenu> f4168c;

    public AbstractC1672f0(Context context) {
        this.f4166a = context;
    }

    /* renamed from: c */
    public final MenuItem m989c(MenuItem menuItem) {
        if (menuItem instanceof InterfaceMenuItemC0553X3) {
            InterfaceMenuItemC0553X3 interfaceMenuItemC0553X3 = (InterfaceMenuItemC0553X3) menuItem;
            if (this.f4167b == null) {
                this.f4167b = new C0101E1<>();
            }
            MenuItem menuItem2 = this.f4167b.get(menuItem);
            if (menuItem2 == null) {
                MenuItemC1968m0 menuItemC1968m0 = new MenuItemC1968m0(this.f4166a, interfaceMenuItemC0553X3);
                this.f4167b.put(interfaceMenuItemC0553X3, menuItemC1968m0);
                return menuItemC1968m0;
            }
            return menuItem2;
        }
        return menuItem;
    }

    /* renamed from: d */
    public final SubMenu m988d(SubMenu subMenu) {
        if (subMenu instanceof InterfaceSubMenuC0570Y3) {
            InterfaceSubMenuC0570Y3 interfaceSubMenuC0570Y3 = (InterfaceSubMenuC0570Y3) subMenu;
            if (this.f4168c == null) {
                this.f4168c = new C0101E1<>();
            }
            SubMenu subMenu2 = this.f4168c.get(interfaceSubMenuC0570Y3);
            if (subMenu2 == null) {
                SubMenuC2285v0 subMenuC2285v0 = new SubMenuC2285v0(this.f4166a, interfaceSubMenuC0570Y3);
                this.f4168c.put(interfaceSubMenuC0570Y3, subMenuC2285v0);
                return subMenuC2285v0;
            }
            return subMenu2;
        }
        return subMenu;
    }
}
