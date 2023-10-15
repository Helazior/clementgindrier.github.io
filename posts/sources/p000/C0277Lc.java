package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import fr.smoney.android.izly.data.model.MoneyInCbCb;
import fr.smoney.android.izly.p005ui.widget.CustomFontTextView;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Lc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0277Lc extends ArrayAdapter<MoneyInCbCb> {

    /* renamed from: a */
    public AbstractC2200qb f917a;

    /* renamed from: b */
    public AbstractC0203Ib f918b;

    /* renamed from: c */
    public LayoutInflater f919c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0277Lc(@NotNull Context context) {
        super(context, 2131492974);
        C0581Yd.m1766e(context, "context");
        Object systemService = context.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        this.f919c = (LayoutInflater) systemService;
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    @NotNull
    public View getDropDownView(int i, @Nullable View view, @Nullable ViewGroup viewGroup) {
        LayoutInflater layoutInflater = this.f919c;
        C0581Yd.m1768c(layoutInflater);
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131493000, null, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…opdown_item, null, false)");
        AbstractC0203Ib abstractC0203Ib = (AbstractC0203Ib) inflate;
        this.f918b = abstractC0203Ib;
        if (abstractC0203Ib != null) {
            abstractC0203Ib.getRoot();
            C0227Jc c0227Jc = new C0227Jc(this);
            AbstractC0203Ib abstractC0203Ib2 = this.f918b;
            if (abstractC0203Ib2 != null) {
                View root = abstractC0203Ib2.getRoot();
                C0581Yd.m1767d(root, "mDataBindingDropdown.root");
                root.setTag(c0227Jc);
                MoneyInCbCb item = getItem(i);
                C0277Lc c0277Lc = c0227Jc.f711a;
                C0581Yd.m1768c(c0277Lc);
                AbstractC0203Ib abstractC0203Ib3 = c0277Lc.f918b;
                if (abstractC0203Ib3 != null) {
                    CheckedTextView checkedTextView = abstractC0203Ib3.f661a;
                    C0581Yd.m1767d(checkedTextView, "adapter!!.mDataBindingDropdown.text1");
                    C0581Yd.m1768c(item);
                    checkedTextView.setText(item.f4419b);
                    AbstractC0203Ib abstractC0203Ib4 = this.f918b;
                    if (abstractC0203Ib4 == null) {
                        C0581Yd.m1761j("mDataBindingDropdown");
                        throw null;
                    }
                    View root2 = abstractC0203Ib4.getRoot();
                    C0581Yd.m1767d(root2, "mDataBindingDropdown.root");
                    return root2;
                }
                C0581Yd.m1761j("mDataBindingDropdown");
                throw null;
            }
            C0581Yd.m1761j("mDataBindingDropdown");
            throw null;
        }
        C0581Yd.m1761j("mDataBindingDropdown");
        throw null;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    @NotNull
    public View getView(int i, @Nullable View view, @NotNull ViewGroup viewGroup) {
        C0581Yd.m1766e(viewGroup, "parent");
        if (view == null) {
            LayoutInflater layoutInflater = this.f919c;
            C0581Yd.m1768c(layoutInflater);
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, 2131492974, null, false);
            C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…zly_spinner, null, false)");
            this.f917a = (AbstractC2200qb) inflate;
        }
        MoneyInCbCb item = getItem(i);
        if (item != null) {
            AbstractC2200qb abstractC2200qb = this.f917a;
            if (abstractC2200qb == null) {
                C0581Yd.m1761j("mDataBinding");
                throw null;
            }
            CustomFontTextView customFontTextView = abstractC2200qb.f6300b;
            C0581Yd.m1767d(customFontTextView, "mDataBinding.text");
            customFontTextView.setText(item.f4419b);
        }
        AbstractC2200qb abstractC2200qb2 = this.f917a;
        if (abstractC2200qb2 == null) {
            C0581Yd.m1761j("mDataBinding");
            throw null;
        }
        View root = abstractC2200qb2.getRoot();
        C0581Yd.m1767d(root, "mDataBinding.root");
        return root;
    }
}
