package androidx.databinding.adapters;

import android.widget.Toolbar;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:onMenuItemClick", method = "setOnMenuItemClickListener", type = Toolbar.class), @BindingMethod(attribute = "android:onNavigationClick", method = "setNavigationOnClickListener", type = Toolbar.class)})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ToolbarBindingAdapter {
}
