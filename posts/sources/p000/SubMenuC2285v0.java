package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: v0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SubMenuC2285v0 extends MenuC2205r0 implements SubMenu {

    /* renamed from: e */
    public final InterfaceSubMenuC0570Y3 f6639e;

    public SubMenuC2285v0(Context context, InterfaceSubMenuC0570Y3 interfaceSubMenuC0570Y3) {
        super(context, interfaceSubMenuC0570Y3);
        this.f6639e = interfaceSubMenuC0570Y3;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        this.f6639e.clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return m989c(this.f6639e.getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        this.f6639e.setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        this.f6639e.setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        this.f6639e.setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f6639e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        this.f6639e.setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        this.f6639e.setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f6639e.setIcon(drawable);
        return this;
    }
}
