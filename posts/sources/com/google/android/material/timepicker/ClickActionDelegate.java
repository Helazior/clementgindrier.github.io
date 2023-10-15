package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import p000.C1617d5;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ClickActionDelegate extends C0130F4 {
    private final C1617d5.C1618a clickAction;

    public ClickActionDelegate(Context context, int i) {
        this.clickAction = new C1617d5.C1618a(16, context.getString(i));
    }

    @Override // p000.C0130F4
    public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
        super.onInitializeAccessibilityNodeInfo(view, c1617d5);
        c1617d5.m1032a(this.clickAction);
    }
}
