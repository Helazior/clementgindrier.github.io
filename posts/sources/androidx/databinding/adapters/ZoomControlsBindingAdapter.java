package androidx.databinding.adapters;

import android.widget.ZoomControls;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:onZoomIn", method = "setOnZoomInClickListener", type = ZoomControls.class), @BindingMethod(attribute = "android:onZoomOut", method = "setOnZoomOutClickListener", type = ZoomControls.class)})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ZoomControlsBindingAdapter {
}
