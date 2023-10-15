package p000;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.data.model.Support;
import fr.smoney.android.izly.p005ui.widget.CustomFontTextView;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* renamed from: Sc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0439Sc extends RecyclerView.AbstractC0832g<RecyclerView.AbstractC0824B> {

    /* renamed from: a */
    public AbstractC1898ic f1434a;
    @NotNull

    /* renamed from: b */
    public LayoutInflater f1435b;

    /* renamed from: c */
    public final Context f1436c;

    /* renamed from: d */
    public List<? extends Support> f1437d;

    /* renamed from: e */
    public final Activity f1438e;

    /* renamed from: Sc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0440a extends RecyclerView.AbstractC0824B {
        @NotNull

        /* renamed from: a */
        public final AbstractC1898ic f1439a;

        /* renamed from: b */
        public final /* synthetic */ C0439Sc f1440b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0440a(@NotNull C0439Sc c0439Sc, AbstractC1898ic abstractC1898ic) {
            super(abstractC1898ic.getRoot());
            C0581Yd.m1766e(abstractC1898ic, "v");
            this.f1440b = c0439Sc;
            this.f1439a = abstractC1898ic;
        }
    }

    public C0439Sc(@NotNull Context context, @NotNull List<? extends Support> list, @NotNull Activity activity) {
        C0581Yd.m1766e(context, "context");
        C0581Yd.m1766e(list, "supports");
        C0581Yd.m1766e(activity, "mActivity");
        this.f1436c = context;
        this.f1437d = list;
        this.f1438e = activity;
        LayoutInflater from = LayoutInflater.from(context);
        C0581Yd.m1767d(from, "LayoutInflater.from(context)");
        this.f1435b = from;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f1437d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(@NotNull RecyclerView.AbstractC0824B abstractC0824B, int i) {
        C0581Yd.m1766e(abstractC0824B, "holder");
        Support support = this.f1437d.get(i);
        C0440a c0440a = (C0440a) abstractC0824B;
        C0581Yd.m1766e(support, "item");
        CustomFontTextView customFontTextView = c0440a.f1439a.f5303d;
        EnumC0576Y8 enumC0576Y8 = support.f4612b;
        C0581Yd.m1767d(enumC0576Y8, "item.type");
        customFontTextView.setText(enumC0576Y8.f2048a);
        String str = support.f4616g;
        if (str != null && str.length() > 0) {
            c0440a.f1439a.f5301b.setImageDrawable(c0440a.f1440b.f1438e.getResources().getDrawable(2131230918));
            c0440a.f1439a.f5302c.setText(2131690246);
            CustomFontTextView customFontTextView2 = c0440a.f1439a.f5304f;
            C0581Yd.m1767d(customFontTextView2, "v.supportValue");
            customFontTextView2.setText(c0440a.f1440b.f1436c.getString(2131690053, support.m958b()));
        } else {
            EnumC0576Y8 enumC0576Y82 = support.f4612b;
            if (enumC0576Y82 != null) {
                int ordinal = enumC0576Y82.ordinal();
                if (ordinal == 0) {
                    CustomFontTextView customFontTextView3 = c0440a.f1439a.f5304f;
                    C0581Yd.m1767d(customFontTextView3, "v.supportValue");
                    customFontTextView3.setText(c0440a.f1440b.f1436c.getString(2131689805, support.m959a()));
                    StringBuilder sb = new StringBuilder();
                    CustomFontTextView customFontTextView4 = c0440a.f1439a.f5303d;
                    C0581Yd.m1767d(customFontTextView4, "v.supportName");
                    sb.append(customFontTextView4.getText().toString());
                    sb.append(" Nº ");
                    sb.append(support.f4614d);
                    String sb2 = sb.toString();
                    CustomFontTextView customFontTextView5 = c0440a.f1439a.f5303d;
                    C0581Yd.m1767d(customFontTextView5, "v.supportName");
                    customFontTextView5.setText(sb2);
                } else if (ordinal == 2) {
                    CustomFontTextView customFontTextView6 = c0440a.f1439a.f5304f;
                    C0581Yd.m1767d(customFontTextView6, "v.supportValue");
                    customFontTextView6.setText(c0440a.f1440b.f1436c.getString(2131689805, support.m959a()));
                }
            }
        }
        c0440a.f1439a.f5302c.setOnClickListener(new View$OnClickListenerC0406Rc(c0440a, support));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    @NotNull
    public RecyclerView.AbstractC0824B onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.f1435b, 2131493057, viewGroup, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…port_cell, parent, false)");
        this.f1434a = (AbstractC1898ic) inflate;
        AbstractC1898ic abstractC1898ic = this.f1434a;
        if (abstractC1898ic != null) {
            return new C0440a(this, abstractC1898ic);
        }
        C0581Yd.m1761j("mDataBinding");
        throw null;
    }
}
