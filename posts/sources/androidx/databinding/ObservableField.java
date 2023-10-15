package androidx.databinding;

import java.io.Serializable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ObservableField<T> extends BaseObservableField implements Serializable {
    public static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField(T t) {
        this.mValue = t;
    }

    public T get() {
        return this.mValue;
    }

    public void set(T t) {
        if (t != this.mValue) {
            this.mValue = t;
            notifyChange();
        }
    }

    public ObservableField() {
    }

    public ObservableField(Observable... observableArr) {
        super(observableArr);
    }
}
