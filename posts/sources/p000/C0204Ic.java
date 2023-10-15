package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fr.smoney.android.izly.data.model.MoneyInCbCb;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

/* renamed from: Ic */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0204Ic extends RecyclerView.AbstractC0832g<RecyclerView.AbstractC0824B> {

    /* renamed from: a */
    public AbstractC1942ka f662a;
    @NotNull

    /* renamed from: b */
    public LayoutInflater f663b;

    /* renamed from: c */
    public final ArrayList<MoneyInCbCb> f664c;

    /* renamed from: d */
    public final Context f665d;

    /* renamed from: e */
    public final InterfaceC0205a f666e;

    /* renamed from: Ic$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0205a {
        /* renamed from: c */
        void mo878c(@NotNull MoneyInCbCb moneyInCbCb);
    }

    /* renamed from: Ic$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0206b extends RecyclerView.AbstractC0824B {
        @NotNull

        /* renamed from: a */
        public final AbstractC1942ka f667a;

        /* renamed from: b */
        public final /* synthetic */ C0204Ic f668b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0206b(@NotNull C0204Ic c0204Ic, AbstractC1942ka abstractC1942ka) {
            super(abstractC1942ka.getRoot());
            C0581Yd.m1766e(abstractC1942ka, "v");
            this.f668b = c0204Ic;
            this.f667a = abstractC1942ka;
        }
    }

    /* renamed from: Ic$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class View$OnClickListenerC0207c implements View.OnClickListener {

        /* renamed from: b */
        public final /* synthetic */ MoneyInCbCb f670b;

        public View$OnClickListenerC0207c(MoneyInCbCb moneyInCbCb) {
            this.f670b = moneyInCbCb;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            C0204Ic.this.f666e.mo878c(this.f670b);
        }
    }

    public C0204Ic(@NotNull ArrayList<MoneyInCbCb> arrayList, @NotNull Context context, @NotNull InterfaceC0205a interfaceC0205a) {
        C0581Yd.m1766e(arrayList, "myDataset");
        C0581Yd.m1766e(context, "context");
        C0581Yd.m1766e(interfaceC0205a, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f664c = arrayList;
        this.f665d = context;
        this.f666e = interfaceC0205a;
        LayoutInflater from = LayoutInflater.from(context);
        C0581Yd.m1767d(from, "LayoutInflater.from(context)");
        this.f663b = from;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f664c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(@NotNull RecyclerView.AbstractC0824B abstractC0824B, int i) {
        C0581Yd.m1766e(abstractC0824B, "holder");
        MoneyInCbCb moneyInCbCb = this.f664c.get(i);
        C0581Yd.m1767d(moneyInCbCb, "myDataset[position]");
        MoneyInCbCb moneyInCbCb2 = moneyInCbCb;
        C0206b c0206b = (C0206b) abstractC0824B;
        C0581Yd.m1766e(moneyInCbCb2, "item");
        TextView textView = c0206b.f667a.f5387b;
        C0581Yd.m1767d(textView, "v.tvCardName");
        textView.setText(moneyInCbCb2.f4419b);
        TextView textView2 = c0206b.f667a.f5389d;
        C0581Yd.m1767d(textView2, "v.tvCardType");
        textView2.setText(MoneyInCbCb.m968a(c0206b.f668b.f665d, moneyInCbCb2.f4420c));
        TextView textView3 = c0206b.f667a.f5388c;
        C0581Yd.m1767d(textView3, "v.tvCardNumber");
        textView3.setText(moneyInCbCb2.f4421d);
        if (moneyInCbCb2.f4422f) {
            TextView textView4 = c0206b.f667a.f5386a;
            C0581Yd.m1767d(textView4, "v.tvCardDefault");
            String obj = textView4.getText().toString();
            TextView textView5 = c0206b.f667a.f5386a;
            C0581Yd.m1767d(textView5, "v.tvCardDefault");
            Locale locale = Locale.ROOT;
            C0581Yd.m1767d(locale, "Locale.ROOT");
            Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
            String upperCase = obj.toUpperCase(locale);
            C0581Yd.m1767d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            textView5.setText(upperCase);
            TextView textView6 = c0206b.f667a.f5386a;
            C0581Yd.m1767d(textView6, "v.tvCardDefault");
            textView6.setVisibility(0);
        } else {
            TextView textView7 = c0206b.f667a.f5386a;
            C0581Yd.m1767d(textView7, "v.tvCardDefault");
            textView7.setVisibility(8);
        }
        abstractC0824B.itemView.setOnClickListener(new View$OnClickListenerC0207c(moneyInCbCb2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    @NotNull
    public RecyclerView.AbstractC0824B onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.f663b, 2131492919, viewGroup, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…list_item, parent, false)");
        this.f662a = (AbstractC1942ka) inflate;
        AbstractC1942ka abstractC1942ka = this.f662a;
        if (abstractC1942ka != null) {
            return new C0206b(this, abstractC1942ka);
        }
        C0581Yd.m1761j("mDataBinding");
        throw null;
    }
}
