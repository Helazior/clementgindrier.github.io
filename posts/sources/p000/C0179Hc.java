package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.IconTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import fr.smoney.android.izly.p005ui.widget.CustomFontTextView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Hc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0179Hc extends ArrayAdapter<EnumC0375Q8> {

    /* renamed from: a */
    public AbstractC2200qb f586a;
    @NotNull

    /* renamed from: b */
    public final Context f587b;

    /* renamed from: c */
    public final int f588c;
    @NotNull

    /* renamed from: d */
    public final EnumC0375Q8[] f589d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0179Hc(@NotNull Context context, int i, @NotNull EnumC0375Q8[] enumC0375Q8Arr) {
        super(context, i);
        C0581Yd.m1766e(context, "ctx");
        C0581Yd.m1766e(enumC0375Q8Arr, "values");
        this.f587b = context;
        this.f588c = i;
        this.f589d = enumC0375Q8Arr;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f589d.length;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @NotNull
    public View getDropDownView(int i, @Nullable View view, @NotNull ViewGroup viewGroup) {
        C0581Yd.m1766e(viewGroup, "viewGroup");
        View view2 = getView(i, view, viewGroup);
        AbstractC2200qb abstractC2200qb = this.f586a;
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
        return this.f589d[i];
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int i, @Nullable View view, @NotNull ViewGroup viewGroup) {
        C0581Yd.m1766e(viewGroup, "adapterView");
        ViewDataBinding inflate = DataBindingUtil.inflate(LayoutInflater.from(this.f587b), this.f588c, viewGroup, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…rces, adapterView, false)");
        AbstractC2200qb abstractC2200qb = (AbstractC2200qb) inflate;
        this.f586a = abstractC2200qb;
        EnumC0375Q8 enumC0375Q8 = this.f589d[i];
        CustomFontTextView customFontTextView = abstractC2200qb.f6300b;
        C0581Yd.m1767d(customFontTextView, "binding.text");
        customFontTextView.setText(this.f587b.getString(enumC0375Q8.f1274a));
        AbstractC2200qb abstractC2200qb2 = this.f586a;
        if (abstractC2200qb2 == null) {
            C0581Yd.m1761j("binding");
            throw null;
        }
        View root = abstractC2200qb2.getRoot();
        C0581Yd.m1767d(root, "binding.root");
        return root;
    }
}
