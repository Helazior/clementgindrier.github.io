package p000;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;
import p000.InterfaceC2186q0;

/* renamed from: i0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1882i0 extends BaseAdapter {

    /* renamed from: a */
    public C1905j0 f5225a;

    /* renamed from: b */
    public int f5226b = -1;

    /* renamed from: c */
    public boolean f5227c;

    /* renamed from: d */
    public final boolean f5228d;

    /* renamed from: f */
    public final LayoutInflater f5229f;

    /* renamed from: g */
    public final int f5230g;

    public C1882i0(C1905j0 c1905j0, LayoutInflater layoutInflater, boolean z, int i) {
        this.f5228d = z;
        this.f5229f = layoutInflater;
        this.f5225a = c1905j0;
        this.f5230g = i;
        m752a();
    }

    /* renamed from: a */
    public void m752a() {
        C1950l0 expandedItem = this.f5225a.getExpandedItem();
        if (expandedItem != null) {
            ArrayList<C1950l0> nonActionItems = this.f5225a.getNonActionItems();
            int size = nonActionItems.size();
            for (int i = 0; i < size; i++) {
                if (nonActionItems.get(i) == expandedItem) {
                    this.f5226b = i;
                    return;
                }
            }
        }
        this.f5226b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public C1950l0 getItem(int i) {
        ArrayList<C1950l0> nonActionItems = this.f5228d ? this.f5225a.getNonActionItems() : this.f5225a.getVisibleItems();
        int i2 = this.f5226b;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return nonActionItems.get(i);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<C1950l0> nonActionItems = this.f5228d ? this.f5225a.getNonActionItems() : this.f5225a.getVisibleItems();
        if (this.f5226b < 0) {
            return nonActionItems.size();
        }
        return nonActionItems.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f5229f.inflate(this.f5230g, viewGroup, false);
        }
        int i2 = getItem(i).f5412b;
        int i3 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.f5225a.isGroupDividerEnabled() && i2 != (i3 >= 0 ? getItem(i3).f5412b : i2));
        InterfaceC2186q0.InterfaceC2187a interfaceC2187a = (InterfaceC2186q0.InterfaceC2187a) view;
        if (this.f5227c) {
            listMenuItemView.setForceShowIcon(true);
        }
        interfaceC2187a.initialize(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m752a();
        super.notifyDataSetChanged();
    }
}
