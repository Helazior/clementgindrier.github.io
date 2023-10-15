package com.nhaarman.listviewanimations;

import android.widget.BaseAdapter;
import com.nhaarman.listviewanimations.util.Insertable;
import com.nhaarman.listviewanimations.util.Swappable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ArrayAdapter<T> extends BaseAdapter implements Swappable, Insertable<T> {
    private BaseAdapter mDataSetChangedSlavedAdapter;
    private final List<T> mItems;

    public ArrayAdapter() {
        this(null);
    }

    public boolean add(T t) {
        boolean add = this.mItems.add(t);
        notifyDataSetChanged();
        return add;
    }

    public boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.mItems.addAll(collection);
        notifyDataSetChanged();
        return addAll;
    }

    public void clear() {
        this.mItems.clear();
        notifyDataSetChanged();
    }

    public boolean contains(T t) {
        return this.mItems.contains(t);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mItems.size();
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return this.mItems.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<T> getItems() {
        return this.mItems;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        BaseAdapter baseAdapter = this.mDataSetChangedSlavedAdapter;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    public void propagateNotifyDataSetChanged(BaseAdapter baseAdapter) {
        this.mDataSetChangedSlavedAdapter = baseAdapter;
    }

    public boolean remove(Object obj) {
        boolean remove = this.mItems.remove(obj);
        notifyDataSetChanged();
        return remove;
    }

    @Override // com.nhaarman.listviewanimations.util.Swappable
    public void swapItems(int i, int i2) {
        T t = this.mItems.set(i, getItem(i2));
        notifyDataSetChanged();
        this.mItems.set(i2, t);
    }

    public ArrayAdapter(List<T> list) {
        if (list != null) {
            this.mItems = list;
        } else {
            this.mItems = new ArrayList();
        }
    }

    @Override // com.nhaarman.listviewanimations.util.Insertable
    public void add(int i, T t) {
        this.mItems.add(i, t);
        notifyDataSetChanged();
    }

    public T remove(int i) {
        T remove = this.mItems.remove(i);
        notifyDataSetChanged();
        return remove;
    }
}
