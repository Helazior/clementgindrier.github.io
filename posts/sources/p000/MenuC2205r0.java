package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: r0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MenuC2205r0 extends AbstractC1672f0 implements Menu {

    /* renamed from: d */
    public final InterfaceMenuC0534W3 f6313d;

    public MenuC2205r0(Context context, InterfaceMenuC0534W3 interfaceMenuC0534W3) {
        super(context);
        if (interfaceMenuC0534W3 != null) {
            this.f6313d = interfaceMenuC0534W3;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m989c(this.f6313d.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.f6313d.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m989c(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return m988d(this.f6313d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        C0101E1<InterfaceMenuItemC0553X3, MenuItem> c0101e1 = this.f4167b;
        if (c0101e1 != null) {
            c0101e1.clear();
        }
        C0101E1<InterfaceSubMenuC0570Y3, SubMenu> c0101e12 = this.f4168c;
        if (c0101e12 != null) {
            c0101e12.clear();
        }
        this.f6313d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.f6313d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return m989c(this.f6313d.findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return m989c(this.f6313d.getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.f6313d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.f6313d.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.f6313d.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.f6313d.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        if (this.f4167b != null) {
            int i2 = 0;
            while (i2 < this.f4167b.size()) {
                if (this.f4167b.keyAt(i2).getGroupId() == i) {
                    this.f4167b.removeAt(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.f6313d.removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        if (this.f4167b != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= this.f4167b.size()) {
                    break;
                } else if (this.f4167b.keyAt(i2).getItemId() == i) {
                    this.f4167b.removeAt(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.f6313d.removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.f6313d.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.f6313d.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.f6313d.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f6313d.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f6313d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m989c(this.f6313d.add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return m988d(this.f6313d.addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m989c(this.f6313d.add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m988d(this.f6313d.addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m989c(this.f6313d.add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m988d(this.f6313d.addSubMenu(i, i2, i3, i4));
    }
}
