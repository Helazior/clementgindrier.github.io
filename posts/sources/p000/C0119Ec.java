package p000;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Ec */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0119Ec extends RecyclerView.AbstractC0832g<C0121b> {

    /* renamed from: a */
    public InterfaceC0120a f422a;

    /* renamed from: Ec$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0120a {
        /* renamed from: a */
        void mo608a(@Nullable EnumC0435S8 enumC0435S8);
    }

    /* renamed from: Ec$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0121b extends RecyclerView.AbstractC0824B {
        @NotNull

        /* renamed from: a */
        public AbstractC0252K9 f423a;

        /* renamed from: b */
        public final /* synthetic */ C0119Ec f424b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0121b(@NotNull C0119Ec c0119Ec, AbstractC0252K9 abstractC0252K9) {
            super(abstractC0252K9.getRoot());
            C0581Yd.m1766e(abstractC0252K9, "itemView");
            this.f424b = c0119Ec;
            this.f423a = abstractC0252K9;
        }
    }

    public C0119Ec(@Nullable InterfaceC0120a interfaceC0120a) {
        this.f422a = interfaceC0120a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        EnumC0435S8.values();
        return 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(C0121b c0121b, int i) {
        C0121b c0121b2 = c0121b;
        C0581Yd.m1766e(c0121b2, "holder");
        EnumC0435S8 enumC0435S8 = EnumC0435S8.values()[i];
        C0581Yd.m1766e(enumC0435S8, "item");
        c0121b2.f423a.f790b.setImageResource(enumC0435S8.f1420a);
        c0121b2.f423a.f791c.setText(enumC0435S8.f1421b);
        int i2 = enumC0435S8.f1421b;
        if (i2 == 2131690092) {
            TextView textView = c0121b2.f423a.f789a;
            C0581Yd.m1767d(textView, "itemViews.newbanner");
            textView.setVisibility(0);
        } else if (i2 == 2131690089) {
            TextView textView2 = c0121b2.f423a.f789a;
            C0581Yd.m1767d(textView2, "itemViews.newbanner");
            textView2.setVisibility(0);
            c0121b2.f423a.f789a.setText(enumC0435S8.f1422c);
        } else {
            TextView textView3 = c0121b2.f423a.f789a;
            C0581Yd.m1767d(textView3, "itemViews.newbanner");
            textView3.setVisibility(8);
        }
        c0121b2.f423a.getRoot().setOnClickListener(new View$OnClickListenerC0139Fc(c0121b2, enumC0435S8));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public C0121b onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        int i2 = AbstractC0252K9.f788d;
        AbstractC0252K9 abstractC0252K9 = (AbstractC0252K9) ViewDataBinding.inflateInternal(from, 2131492904, viewGroup, false, DataBindingUtil.getDefaultComponent());
        C0581Yd.m1767d(abstractC0252K9, "AddFundsAdatapterTypeCel….context), parent, false)");
        return new C0121b(this, abstractC0252K9);
    }
}
