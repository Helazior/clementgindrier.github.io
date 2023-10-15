package androidx.databinding;

import androidx.databinding.ViewDataBinding;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class OnRebindCallback<T extends ViewDataBinding> {
    public void onBound(T t) {
    }

    public void onCanceled(T t) {
    }

    public boolean onPreBind(T t) {
        return true;
    }
}
