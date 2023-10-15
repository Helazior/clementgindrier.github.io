package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Qc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0379Qc extends RecyclerView.AbstractC0832g<RecyclerView.AbstractC0824B> {
    @NotNull

    /* renamed from: a */
    public LayoutInflater f1285a;

    /* renamed from: b */
    public final EnumC0560X8[] f1286b;

    /* renamed from: c */
    public final Context f1287c;

    /* renamed from: d */
    public final InterfaceC0380a f1288d;

    /* renamed from: Qc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0380a {
        /* renamed from: e */
        void mo418e(@Nullable EnumC0560X8 enumC0560X8);
    }

    /* renamed from: Qc$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0381b extends RecyclerView.AbstractC0824B {

        /* renamed from: a */
        public final AbstractC0201I9 f1289a;

        /* renamed from: b */
        public final /* synthetic */ C0379Qc f1290b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0381b(@NotNull C0379Qc c0379Qc, AbstractC0201I9 abstractC0201I9) {
            super(abstractC0201I9.getRoot());
            C0581Yd.m1766e(abstractC0201I9, "itemBinding");
            this.f1290b = c0379Qc;
            this.f1289a = abstractC0201I9;
        }
    }

    /* renamed from: Qc$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class View$OnClickListenerC0382c implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ int f1292b;

        public View$OnClickListenerC0382c(int i) {
            this.f1292b = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0379Qc c0379Qc = C0379Qc.this;
            c0379Qc.f1288d.mo418e(c0379Qc.f1286b[this.f1292b]);
        }
    }

    public C0379Qc(@NotNull EnumC0560X8[] enumC0560X8Arr, @NotNull Context context, @NotNull InterfaceC0380a interfaceC0380a) {
        C0581Yd.m1766e(enumC0560X8Arr, "myDataset");
        C0581Yd.m1766e(context, "context");
        C0581Yd.m1766e(interfaceC0380a, "mAdapter");
        this.f1286b = enumC0560X8Arr;
        this.f1287c = context;
        this.f1288d = interfaceC0380a;
        LayoutInflater from = LayoutInflater.from(context);
        C0581Yd.m1767d(from, "LayoutInflater.from(context)");
        this.f1285a = from;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f1286b.length;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(@NotNull RecyclerView.AbstractC0824B abstractC0824B, int i) {
        C0581Yd.m1766e(abstractC0824B, "holder");
        EnumC0560X8 enumC0560X8 = this.f1286b[i];
        C0381b c0381b = (C0381b) abstractC0824B;
        C0581Yd.m1766e(enumC0560X8, "item");
        c0381b.f1289a.f650a.setImageResource(enumC0560X8.f2005b);
        TextView textView = c0381b.f1289a.f651b;
        C0581Yd.m1767d(textView, "itemBinding.tvPlusItem");
        C0379Qc c0379Qc = c0381b.f1290b;
        String string = c0379Qc.f1287c.getString(enumC0560X8.f2004a);
        C0581Yd.m1767d(string, "context.getString(string)");
        textView.setText(string);
        abstractC0824B.itemView.setOnClickListener(new View$OnClickListenerC0382c(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public RecyclerView.AbstractC0824B onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        LayoutInflater layoutInflater = this.f1285a;
        int i2 = AbstractC0201I9.f649c;
        AbstractC0201I9 abstractC0201I9 = (AbstractC0201I9) ViewDataBinding.inflateInternal(layoutInflater, 2131492903, viewGroup, false, DataBindingUtil.getDefaultComponent());
        C0581Yd.m1767d(abstractC0201I9, "AdapterPlusItemBinding.i…tInflater, parent, false)");
        return new C0381b(this, abstractC0201I9);
    }
}
