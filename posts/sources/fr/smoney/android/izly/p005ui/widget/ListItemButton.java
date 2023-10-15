package fr.smoney.android.izly.p005ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

/* renamed from: fr.smoney.android.izly.ui.widget.ListItemButton */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ListItemButton extends Button {
    public ListItemButton(Context context) {
        super(context);
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (z && (getParent() instanceof View) && ((View) getParent()).isPressed()) {
            return;
        }
        super.setPressed(z);
    }

    public ListItemButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListItemButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
