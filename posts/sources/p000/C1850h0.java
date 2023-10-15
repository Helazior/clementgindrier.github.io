package p000;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ExpandedMenuView;
import java.util.ArrayList;
import java.util.Objects;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import p000.DialogInterfaceC2336x;
import p000.InterfaceC2165p0;
import p000.InterfaceC2186q0;

/* renamed from: h0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1850h0 implements InterfaceC2165p0, AdapterView.OnItemClickListener {

    /* renamed from: a */
    public Context f5104a;

    /* renamed from: b */
    public LayoutInflater f5105b;

    /* renamed from: c */
    public C1905j0 f5106c;

    /* renamed from: d */
    public ExpandedMenuView f5107d;

    /* renamed from: f */
    public int f5108f;

    /* renamed from: g */
    public InterfaceC2165p0.InterfaceC2166a f5109g;

    /* renamed from: h */
    public C1851a f5110h;

    /* renamed from: h0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1851a extends BaseAdapter {

        /* renamed from: a */
        public int f5111a = -1;

        public C1851a() {
            m789a();
        }

        /* renamed from: a */
        public void m789a() {
            C1950l0 expandedItem = C1850h0.this.f5106c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<C1950l0> nonActionItems = C1850h0.this.f5106c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i = 0; i < size; i++) {
                    if (nonActionItems.get(i) == expandedItem) {
                        this.f5111a = i;
                        return;
                    }
                }
            }
            this.f5111a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b */
        public C1950l0 getItem(int i) {
            ArrayList<C1950l0> nonActionItems = C1850h0.this.f5106c.getNonActionItems();
            Objects.requireNonNull(C1850h0.this);
            int i2 = i + 0;
            int i3 = this.f5111a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return nonActionItems.get(i2);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = C1850h0.this.f5106c.getNonActionItems().size();
            Objects.requireNonNull(C1850h0.this);
            int i = size + 0;
            return this.f5111a < 0 ? i : i - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                C1850h0 c1850h0 = C1850h0.this;
                view = c1850h0.f5105b.inflate(c1850h0.f5108f, viewGroup, false);
            }
            ((InterfaceC2186q0.InterfaceC2187a) view).initialize(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            m789a();
            super.notifyDataSetChanged();
        }
    }

    public C1850h0(Context context, int i) {
        this.f5108f = i;
        this.f5104a = context;
        this.f5105b = LayoutInflater.from(context);
    }

    /* renamed from: a */
    public ListAdapter m790a() {
        if (this.f5110h == null) {
            this.f5110h = new C1851a();
        }
        return this.f5110h;
    }

    @Override // p000.InterfaceC2165p0
    public boolean collapseItemActionView(C1905j0 c1905j0, C1950l0 c1950l0) {
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public boolean expandItemActionView(C1905j0 c1905j0, C1950l0 c1950l0) {
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public boolean flagActionItems() {
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public int getId() {
        return 0;
    }

    @Override // p000.InterfaceC2165p0
    public void initForMenu(Context context, C1905j0 c1905j0) {
        if (this.f5104a != null) {
            this.f5104a = context;
            if (this.f5105b == null) {
                this.f5105b = LayoutInflater.from(context);
            }
        }
        this.f5106c = c1905j0;
        C1851a c1851a = this.f5110h;
        if (c1851a != null) {
            c1851a.notifyDataSetChanged();
        }
    }

    @Override // p000.InterfaceC2165p0
    public void onCloseMenu(C1905j0 c1905j0, boolean z) {
        InterfaceC2165p0.InterfaceC2166a interfaceC2166a = this.f5109g;
        if (interfaceC2166a != null) {
            interfaceC2166a.onCloseMenu(c1905j0, z);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f5106c.performItemAction(this.f5110h.getItem(i), this, 0);
    }

    @Override // p000.InterfaceC2165p0
    public void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f5107d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // p000.InterfaceC2165p0
    public Parcelable onSaveInstanceState() {
        if (this.f5107d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f5107d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // p000.InterfaceC2165p0
    public boolean onSubMenuSelected(SubMenuC2267u0 subMenuC2267u0) {
        if (subMenuC2267u0.hasVisibleItems()) {
            DialogInterface$OnKeyListenerC1931k0 dialogInterface$OnKeyListenerC1931k0 = new DialogInterface$OnKeyListenerC1931k0(subMenuC2267u0);
            DialogInterfaceC2336x.C2337a c2337a = new DialogInterfaceC2336x.C2337a(subMenuC2267u0.getContext());
            C1850h0 c1850h0 = new C1850h0(c2337a.getContext(), C1949l.abc_list_menu_item_layout);
            dialogInterface$OnKeyListenerC1931k0.f5372c = c1850h0;
            c1850h0.f5109g = dialogInterface$OnKeyListenerC1931k0;
            dialogInterface$OnKeyListenerC1931k0.f5370a.addMenuPresenter(c1850h0);
            c2337a.setAdapter(dialogInterface$OnKeyListenerC1931k0.f5372c.m790a(), dialogInterface$OnKeyListenerC1931k0);
            View headerView = subMenuC2267u0.getHeaderView();
            if (headerView != null) {
                c2337a.setCustomTitle(headerView);
            } else {
                c2337a.setIcon(subMenuC2267u0.getHeaderIcon()).setTitle(subMenuC2267u0.getHeaderTitle());
            }
            c2337a.setOnKeyListener(dialogInterface$OnKeyListenerC1931k0);
            DialogInterfaceC2336x create = c2337a.create();
            dialogInterface$OnKeyListenerC1931k0.f5371b = create;
            create.setOnDismissListener(dialogInterface$OnKeyListenerC1931k0);
            WindowManager.LayoutParams attributes = dialogInterface$OnKeyListenerC1931k0.f5371b.getWindow().getAttributes();
            attributes.type = 1003;
            attributes.flags |= PKIFailureInfo.unsupportedVersion;
            dialogInterface$OnKeyListenerC1931k0.f5371b.show();
            InterfaceC2165p0.InterfaceC2166a interfaceC2166a = this.f5109g;
            if (interfaceC2166a != null) {
                interfaceC2166a.mo458a(subMenuC2267u0);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public void setCallback(InterfaceC2165p0.InterfaceC2166a interfaceC2166a) {
        this.f5109g = interfaceC2166a;
    }

    @Override // p000.InterfaceC2165p0
    public void updateMenuView(boolean z) {
        C1851a c1851a = this.f5110h;
        if (c1851a != null) {
            c1851a.notifyDataSetChanged();
        }
    }
}
