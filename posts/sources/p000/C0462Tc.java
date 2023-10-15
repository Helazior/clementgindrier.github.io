package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.IconTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Tc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0462Tc extends ArrayAdapter<EnumC0458T8> {

    /* renamed from: a */
    public AbstractC2200qb f1614a;

    /* renamed from: b */
    public EnumC0458T8[] f1615b;

    /* renamed from: c */
    public Context f1616c;

    /* renamed from: d */
    public int f1617d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0462Tc(@NotNull Context context, int i, @NotNull EnumC0458T8[] enumC0458T8Arr) {
        super(context, i, enumC0458T8Arr);
        C0581Yd.m1766e(context, "context");
        C0581Yd.m1766e(enumC0458T8Arr, "objects");
        this.f1615b = enumC0458T8Arr;
        this.f1616c = context;
        this.f1617d = i;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f1615b.length;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @Nullable
    public View getDropDownView(int i, @Nullable View view, @NotNull ViewGroup viewGroup) {
        C0581Yd.m1766e(viewGroup, "viewGroup");
        View view2 = getView(i, view, viewGroup);
        AbstractC2200qb abstractC2200qb = this.f1614a;
        if (abstractC2200qb == null) {
            C0581Yd.m1761j("binding");
            throw null;
        }
        IconTextView iconTextView = abstractC2200qb.f6299a;
        C0581Yd.m1767d(iconTextView, "binding.chevron");
        iconTextView.setVisibility(8);
        return view2;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public Object getItem(int i) {
        return this.f1615b[i];
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int i, @Nullable View view, @NotNull ViewGroup viewGroup) {
        C0581Yd.m1766e(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(this.f1616c), this.f1617d, viewGroup, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…resLayout, parent, false)");
        AbstractC2200qb abstractC2200qb = (AbstractC2200qb) inflate;
        this.f1614a = abstractC2200qb;
        abstractC2200qb.f6300b.setText(this.f1615b[i].f1602b);
        AbstractC2200qb abstractC2200qb2 = this.f1614a;
        if (abstractC2200qb2 == null) {
            C0581Yd.m1761j("binding");
            throw null;
        }
        View root = abstractC2200qb2.getRoot();
        C0581Yd.m1767d(root, "binding.root");
        return root;
    }
}
