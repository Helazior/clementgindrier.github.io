package androidx.databinding.adapters;

import android.widget.ExpandableListView;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;

@BindingMethods({@BindingMethod(attribute = "android:onChildClick", method = "setOnChildClickListener", type = ExpandableListView.class), @BindingMethod(attribute = "android:onGroupClick", method = "setOnGroupClickListener", type = ExpandableListView.class), @BindingMethod(attribute = "android:onGroupCollapse", method = "setOnGroupCollapseListener", type = ExpandableListView.class), @BindingMethod(attribute = "android:onGroupExpand", method = "setOnGroupExpandListener", type = ExpandableListView.class)})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ExpandableListViewBindingAdapter {
}
