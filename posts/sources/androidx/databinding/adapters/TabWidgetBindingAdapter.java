package androidx.databinding.adapters;

import android.widget.TabWidget;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:divider", method = "setDividerDrawable", type = TabWidget.class), @BindingMethod(attribute = "android:tabStripEnabled", method = "setStripEnabled", type = TabWidget.class), @BindingMethod(attribute = "android:tabStripLeft", method = "setLeftStripDrawable", type = TabWidget.class), @BindingMethod(attribute = "android:tabStripRight", method = "setRightStripDrawable", type = TabWidget.class)})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TabWidgetBindingAdapter {
}
