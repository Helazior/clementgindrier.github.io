package com.google.android.material.internal;

import android.content.Context;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NavigationSubMenu extends SubMenuC2267u0 {
    public NavigationSubMenu(Context context, NavigationMenu navigationMenu, C1950l0 c1950l0) {
        super(context, navigationMenu, c1950l0);
    }

    @Override // p000.C1905j0
    public void onItemsChanged(boolean z) {
        super.onItemsChanged(z);
        ((C1905j0) getParentMenu()).onItemsChanged(z);
    }
}
