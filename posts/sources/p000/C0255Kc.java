package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import p000.C2307w3;

/* renamed from: Kc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0255Kc extends RecyclerView.AbstractC0832g<RecyclerView.AbstractC0824B> {
    @NotNull

    /* renamed from: a */
    public LayoutInflater f836a;

    /* renamed from: b */
    public AbstractC0155G9 f837b;

    /* renamed from: c */
    public final Context f838c;

    /* renamed from: d */
    public final EnumC0402R8[] f839d;

    /* renamed from: Kc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0256a extends RecyclerView.AbstractC0824B {
        @NotNull

        /* renamed from: a */
        public final AbstractC0155G9 f840a;

        /* renamed from: b */
        public final /* synthetic */ C0255Kc f841b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0256a(@NotNull C0255Kc c0255Kc, AbstractC0155G9 abstractC0155G9) {
            super(abstractC0155G9.getRoot());
            C0581Yd.m1766e(abstractC0155G9, "v");
            this.f841b = c0255Kc;
            this.f840a = abstractC0155G9;
        }
    }

    public C0255Kc(@NotNull Context context, @NotNull EnumC0402R8[] enumC0402R8Arr) {
        C0581Yd.m1766e(context, "context");
        C0581Yd.m1766e(enumC0402R8Arr, "list");
        this.f838c = context;
        this.f839d = enumC0402R8Arr;
        LayoutInflater from = LayoutInflater.from(context);
        C0581Yd.m1767d(from, "LayoutInflater.from(context)");
        this.f836a = from;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f839d.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(@NotNull RecyclerView.AbstractC0824B abstractC0824B, int i) {
        C0581Yd.m1766e(abstractC0824B, "holder");
        EnumC0402R8 enumC0402R8 = this.f839d[i];
        C0256a c0256a = (C0256a) abstractC0824B;
        C0581Yd.m1766e(enumC0402R8, "item");
        ImageView imageView = c0256a.f840a.f500a;
        Context context = c0256a.f841b.f838c;
        int i2 = enumC0402R8.f1354a;
        Object obj = C2307w3.f6741a;
        imageView.setImageDrawable(C2307w3.C2310c.m202b(context, i2));
        TextView textView = c0256a.f840a.f501b;
        C0581Yd.m1767d(textView, "v.adapterCampusTvLabel");
        textView.setText(c0256a.f841b.f838c.getString(enumC0402R8.f1355b));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    @NotNull
    public RecyclerView.AbstractC0824B onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.f836a, 2131492902, viewGroup, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…mpus_item, parent, false)");
        this.f837b = (AbstractC0155G9) inflate;
        AbstractC0155G9 abstractC0155G9 = this.f837b;
        if (abstractC0155G9 != null) {
            return new C0256a(this, abstractC0155G9);
        }
        C0581Yd.m1761j("mDataBinding");
        throw null;
    }
}
