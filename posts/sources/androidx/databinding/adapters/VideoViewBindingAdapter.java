package androidx.databinding.adapters;

import android.widget.VideoView;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:onCompletion", method = "setOnCompletionListener", type = VideoView.class), @BindingMethod(attribute = "android:onError", method = "setOnErrorListener", type = VideoView.class), @BindingMethod(attribute = "android:onInfo", method = "setOnInfoListener", type = VideoView.class), @BindingMethod(attribute = "android:onPrepared", method = "setOnPreparedListener", type = VideoView.class)})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class VideoViewBindingAdapter {
}
