package androidx.databinding.adapters;

import android.widget.RatingBar;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethod;
import androidx.databinding.InverseBindingMethods;

@InverseBindingMethods({@InverseBindingMethod(attribute = "android:rating", type = RatingBar.class)})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RatingBarBindingAdapter {
    @BindingAdapter(requireAll = false, value = {"android:onRatingChanged", "android:ratingAttrChanged"})
    public static void setListeners(RatingBar ratingBar, final RatingBar.OnRatingBarChangeListener onRatingBarChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            ratingBar.setOnRatingBarChangeListener(onRatingBarChangeListener);
        } else {
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() { // from class: androidx.databinding.adapters.RatingBarBindingAdapter.1
                @Override // android.widget.RatingBar.OnRatingBarChangeListener
                public void onRatingChanged(RatingBar ratingBar2, float f, boolean z) {
                    RatingBar.OnRatingBarChangeListener onRatingBarChangeListener2 = onRatingBarChangeListener;
                    if (onRatingBarChangeListener2 != null) {
                        onRatingBarChangeListener2.onRatingChanged(ratingBar2, f, z);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }

    @BindingAdapter({"android:rating"})
    public static void setRating(RatingBar ratingBar, float f) {
        if (ratingBar.getRating() != f) {
            ratingBar.setRating(f);
        }
    }
}
