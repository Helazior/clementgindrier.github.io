package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.data.model.Event;
import fr.smoney.android.izly.p005ui.widget.CustomFontTextView;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

/* renamed from: Nc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0318Nc extends RecyclerView.AbstractC0832g<RecyclerView.AbstractC0824B> {

    /* renamed from: a */
    public AbstractC0481Ua f1048a;

    /* renamed from: b */
    public final ArrayList<Event> f1049b;
    @NotNull

    /* renamed from: c */
    public LayoutInflater f1050c;

    /* renamed from: Nc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0319a extends RecyclerView.AbstractC0824B {
        @NotNull

        /* renamed from: a */
        public final AbstractC0481Ua f1051a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0319a(@NotNull C0318Nc c0318Nc, AbstractC0481Ua abstractC0481Ua) {
            super(abstractC0481Ua.getRoot());
            C0581Yd.m1766e(abstractC0481Ua, "v");
            this.f1051a = abstractC0481Ua;
        }
    }

    public C0318Nc(@NotNull Context context) {
        C0581Yd.m1766e(context, "context");
        this.f1049b = new ArrayList<>();
        LayoutInflater from = LayoutInflater.from(context);
        C0581Yd.m1767d(from, "LayoutInflater.from(context)");
        this.f1050c = from;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f1049b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(@NotNull RecyclerView.AbstractC0824B abstractC0824B, int i) {
        C0581Yd.m1766e(abstractC0824B, "holder");
        Event event = this.f1049b.get(i);
        C0581Yd.m1767d(event, "mEventList[position]");
        Event event2 = event;
        C0319a c0319a = (C0319a) abstractC0824B;
        C0581Yd.m1766e(event2, "item");
        CustomFontTextView customFontTextView = c0319a.f1051a.f1763a;
        C0581Yd.m1767d(customFontTextView, "v.ctvEventName");
        customFontTextView.setText(event2.f4271a);
        CustomFontTextView customFontTextView2 = c0319a.f1051a.f1764b;
        C0581Yd.m1767d(customFontTextView2, "v.ctvEventValue");
        customFontTextView2.setText(event2.f4272b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    @NotNull
    public RecyclerView.AbstractC0824B onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        ViewDataBinding inflate = DataBindingUtil.inflate(this.f1050c, 2131492958, viewGroup, false);
        C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…list_item, parent, false)");
        this.f1048a = (AbstractC0481Ua) inflate;
        AbstractC0481Ua abstractC0481Ua = this.f1048a;
        if (abstractC0481Ua != null) {
            return new C0319a(this, abstractC0481Ua);
        }
        C0581Yd.m1761j("mDataBinding");
        throw null;
    }
}
