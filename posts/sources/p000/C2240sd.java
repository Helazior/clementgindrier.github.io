package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* renamed from: sd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2240sd extends RecyclerView.AbstractC0832g<RecyclerView.AbstractC0824B> {

    /* renamed from: a */
    public AbstractC2027ob f6415a;

    /* renamed from: b */
    public Context f6416b;

    /* renamed from: c */
    public final List<C0383Qd<String, Object>> f6417c;

    /* renamed from: sd$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C2241a extends RecyclerView.AbstractC0824B {
        @NotNull

        /* renamed from: a */
        public final AbstractC2027ob f6418a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C2241a(@NotNull C2240sd c2240sd, AbstractC2027ob abstractC2027ob) {
            super(abstractC2027ob.getRoot());
            C0581Yd.m1766e(abstractC2027ob, "v");
            this.f6418a = abstractC2027ob;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2240sd(@NotNull List<? extends C0383Qd<String, ? extends Object>> list) {
        C0581Yd.m1766e(list, "types");
        this.f6417c = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f6417c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(@NotNull RecyclerView.AbstractC0824B abstractC0824B, int i) {
        C0581Yd.m1766e(abstractC0824B, "holder");
        C0383Qd<String, Object> c0383Qd = this.f6417c.get(i);
        C2241a c2241a = (C2241a) abstractC0824B;
        C0581Yd.m1766e(c0383Qd, "item");
        TextView textView = c2241a.f6418a.f5604b;
        C0581Yd.m1767d(textView, "v.tvInfoLabel");
        textView.setText(c0383Qd.f1293a);
        TextView textView2 = c2241a.f6418a.f5605c;
        C0581Yd.m1767d(textView2, "v.tvInfoValue");
        textView2.setText(c0383Qd.f1294b.toString());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    @NotNull
    public RecyclerView.AbstractC0824B onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        Context context = viewGroup.getContext();
        C0581Yd.m1767d(context, "parent.context");
        this.f6416b = context;
        if (context != null) {
            LayoutInflater from = LayoutInflater.from(context);
            C0581Yd.m1767d(from, "LayoutInflater.from(context)");
            ViewDataBinding inflate = DataBindingUtil.inflate(from, 2131492973, viewGroup, false);
            C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…          false\n        )");
            this.f6415a = (AbstractC2027ob) inflate;
            AbstractC2027ob abstractC2027ob = this.f6415a;
            if (abstractC2027ob != null) {
                return new C2241a(this, abstractC2027ob);
            }
            C0581Yd.m1761j("mDataBinding");
            throw null;
        }
        C0581Yd.m1761j("context");
        throw null;
    }
}
