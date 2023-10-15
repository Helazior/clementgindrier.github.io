package com.nhaarman.listviewanimations;

import android.database.DataSetObserver;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import com.nhaarman.listviewanimations.util.AbsListViewWrapper;
import com.nhaarman.listviewanimations.util.Insertable;
import com.nhaarman.listviewanimations.util.ListViewWrapper;
import com.nhaarman.listviewanimations.util.ListViewWrapperSetter;
import com.nhaarman.listviewanimations.util.Swappable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class BaseAdapterDecorator extends BaseAdapter implements SectionIndexer, Swappable, Insertable, ListViewWrapperSetter {
    private final BaseAdapter mDecoratedBaseAdapter;
    private ListViewWrapper mListViewWrapper;

    public BaseAdapterDecorator(BaseAdapter baseAdapter) {
        this.mDecoratedBaseAdapter = baseAdapter;
    }

    @Override // com.nhaarman.listviewanimations.util.Insertable
    public void add(int i, Object obj) {
        BaseAdapter baseAdapter = this.mDecoratedBaseAdapter;
        if (baseAdapter instanceof Insertable) {
            ((Insertable) baseAdapter).add(i, obj);
        } else {
            Log.w("ListViewAnimations", "Warning: add called on an adapter that does not implement Insertable!");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean areAllItemsEnabled() {
        return this.mDecoratedBaseAdapter.areAllItemsEnabled();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDecoratedBaseAdapter.getCount();
    }

    public BaseAdapter getDecoratedBaseAdapter() {
        return this.mDecoratedBaseAdapter;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return this.mDecoratedBaseAdapter.getDropDownView(i, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mDecoratedBaseAdapter.getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return this.mDecoratedBaseAdapter.getItemId(i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.mDecoratedBaseAdapter.getItemViewType(i);
    }

    public ListViewWrapper getListViewWrapper() {
        return this.mListViewWrapper;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        BaseAdapter baseAdapter = this.mDecoratedBaseAdapter;
        if (baseAdapter instanceof SectionIndexer) {
            return ((SectionIndexer) baseAdapter).getPositionForSection(i);
        }
        return 0;
    }

    public BaseAdapter getRootAdapter() {
        BaseAdapter baseAdapter = this.mDecoratedBaseAdapter;
        while (baseAdapter instanceof BaseAdapterDecorator) {
            baseAdapter = ((BaseAdapterDecorator) baseAdapter).getDecoratedBaseAdapter();
        }
        return baseAdapter;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        BaseAdapter baseAdapter = this.mDecoratedBaseAdapter;
        if (baseAdapter instanceof SectionIndexer) {
            return ((SectionIndexer) baseAdapter).getSectionForPosition(i);
        }
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        Object[] objArr = new Object[0];
        BaseAdapter baseAdapter = this.mDecoratedBaseAdapter;
        return baseAdapter instanceof SectionIndexer ? ((SectionIndexer) baseAdapter).getSections() : objArr;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.mDecoratedBaseAdapter.getView(i, view, viewGroup);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return this.mDecoratedBaseAdapter.getViewTypeCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return this.mDecoratedBaseAdapter.hasStableIds();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        return this.mDecoratedBaseAdapter.isEmpty();
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return this.mDecoratedBaseAdapter.isEnabled(i);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        BaseAdapter baseAdapter = this.mDecoratedBaseAdapter;
        if (baseAdapter instanceof ArrayAdapter) {
            return;
        }
        baseAdapter.notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        this.mDecoratedBaseAdapter.notifyDataSetInvalidated();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDecoratedBaseAdapter.registerDataSetObserver(dataSetObserver);
    }

    public void setAbsListView(AbsListView absListView) {
        setListViewWrapper(new AbsListViewWrapper(absListView));
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapperSetter
    public void setListViewWrapper(ListViewWrapper listViewWrapper) {
        this.mListViewWrapper = listViewWrapper;
        BaseAdapter baseAdapter = this.mDecoratedBaseAdapter;
        if (baseAdapter instanceof ListViewWrapperSetter) {
            ((ListViewWrapperSetter) baseAdapter).setListViewWrapper(listViewWrapper);
        }
    }

    @Override // com.nhaarman.listviewanimations.util.Swappable
    public void swapItems(int i, int i2) {
        BaseAdapter baseAdapter = this.mDecoratedBaseAdapter;
        if (baseAdapter instanceof Swappable) {
            ((Swappable) baseAdapter).swapItems(i, i2);
        } else {
            Log.w("ListViewAnimations", "Warning: swapItems called on an adapter that does not implement Swappable!");
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mDecoratedBaseAdapter.unregisterDataSetObserver(dataSetObserver);
    }

    public void notifyDataSetChanged(boolean z) {
        if (z || !(this.mDecoratedBaseAdapter instanceof ArrayAdapter)) {
            this.mDecoratedBaseAdapter.notifyDataSetChanged();
        }
    }
}
