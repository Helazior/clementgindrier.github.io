package androidx.databinding;

import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ObservableList<T> extends List<T> {

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class OnListChangedCallback<T extends ObservableList> {
        public abstract void onChanged(T t);

        public abstract void onItemRangeChanged(T t, int i, int i2);

        public abstract void onItemRangeInserted(T t, int i, int i2);

        public abstract void onItemRangeMoved(T t, int i, int i2, int i3);

        public abstract void onItemRangeRemoved(T t, int i, int i2);
    }

    void addOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);

    void removeOnListChangedCallback(OnListChangedCallback<? extends ObservableList<T>> onListChangedCallback);
}
