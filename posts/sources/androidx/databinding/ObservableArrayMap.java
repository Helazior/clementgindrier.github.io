package androidx.databinding;

import androidx.databinding.ObservableMap;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ObservableArrayMap<K, V> extends C2339x1<K, V> implements ObservableMap<K, V> {
    private transient MapChangeRegistry mListeners;

    private void notifyChange(Object obj) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.notifyCallbacks(this, 0, obj);
        }
    }

    @Override // androidx.databinding.ObservableMap
    public void addOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        if (this.mListeners == null) {
            this.mListeners = new MapChangeRegistry();
        }
        this.mListeners.add(onMapChangedCallback);
    }

    @Override // p000.C0101E1, java.util.Map
    public void clear() {
        if (isEmpty()) {
            return;
        }
        super.clear();
        notifyChange(null);
    }

    @Override // p000.C0101E1, java.util.Map
    public V put(K k, V v) {
        super.put(k, v);
        notifyChange(k);
        return v;
    }

    @Override // p000.C2339x1
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            int indexOfKey = indexOfKey(it.next());
            if (indexOfKey >= 0) {
                z = true;
                removeAt(indexOfKey);
            }
        }
        return z;
    }

    @Override // p000.C0101E1
    public V removeAt(int i) {
        K keyAt = keyAt(i);
        V v = (V) super.removeAt(i);
        if (v != null) {
            notifyChange(keyAt);
        }
        return v;
    }

    @Override // androidx.databinding.ObservableMap
    public void removeOnMapChangedCallback(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.mListeners;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.remove(onMapChangedCallback);
        }
    }

    @Override // p000.C2339x1
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(keyAt(size))) {
                removeAt(size);
                z = true;
            }
        }
        return z;
    }

    @Override // p000.C0101E1
    public V setValueAt(int i, V v) {
        K keyAt = keyAt(i);
        V v2 = (V) super.setValueAt(i, v);
        notifyChange(keyAt);
        return v2;
    }
}
