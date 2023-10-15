package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NavigationMenu extends C1905j0 {
    public NavigationMenu(Context context) {
        super(context);
    }

    @Override // p000.C1905j0, android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C1950l0 c1950l0 = (C1950l0) addInternal(i, i2, i3, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(getContext(), this, c1950l0);
        c1950l0.f5425o = navigationSubMenu;
        navigationSubMenu.setHeaderTitle(c1950l0.f5415e);
        return navigationSubMenu;
    }
}
