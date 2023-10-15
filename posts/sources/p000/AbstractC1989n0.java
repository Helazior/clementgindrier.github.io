package p000;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: n0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1989n0 implements InterfaceC2222s0, InterfaceC2165p0, AdapterView.OnItemClickListener {

    /* renamed from: a */
    public Rect f5507a;

    /* renamed from: d */
    public static int m589d(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        C1882i0 c1882i0 = (C1882i0) listAdapter;
        int count = c1882i0.getCount();
        FrameLayout frameLayout = null;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = c1882i0.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = c1882i0.getView(i4, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    /* renamed from: l */
    public static boolean m588l(C1905j0 c1905j0) {
        int size = c1905j0.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c1905j0.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public abstract void mo393b(C1905j0 c1905j0);

    /* renamed from: c */
    public boolean mo590c() {
        return true;
    }

    @Override // p000.InterfaceC2165p0
    public boolean collapseItemActionView(C1905j0 c1905j0, C1950l0 c1950l0) {
        return false;
    }

    /* renamed from: e */
    public abstract void mo392e(View view);

    @Override // p000.InterfaceC2165p0
    public boolean expandItemActionView(C1905j0 c1905j0, C1950l0 c1950l0) {
        return false;
    }

    /* renamed from: f */
    public abstract void mo391f(boolean z);

    /* renamed from: g */
    public abstract void mo390g(int i);

    @Override // p000.InterfaceC2165p0
    public int getId() {
        return 0;
    }

    /* renamed from: h */
    public abstract void mo389h(int i);

    /* renamed from: i */
    public abstract void mo388i(PopupWindow.OnDismissListener onDismissListener);

    @Override // p000.InterfaceC2165p0
    public void initForMenu(Context context, C1905j0 c1905j0) {
    }

    /* renamed from: j */
    public abstract void mo387j(boolean z);

    /* renamed from: k */
    public abstract void mo386k(int i);

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C1882i0 c1882i0;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            c1882i0 = (C1882i0) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            c1882i0 = (C1882i0) listAdapter;
        }
        c1882i0.f5225a.performItemAction((MenuItem) listAdapter.getItem(i), this, mo590c() ? 0 : 4);
    }
}
