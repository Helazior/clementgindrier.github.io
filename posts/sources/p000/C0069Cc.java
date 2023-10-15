package p000;

import android.content.Context;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fr.smoney.android.izly.data.model.ActuDetail;
import fr.smoney.android.izly.data.model.ActuList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.MessageBundle;
import p000.C2307w3;

/* renamed from: Cc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0069Cc extends RecyclerView.AbstractC0832g<RecyclerView.AbstractC0824B> {

    /* renamed from: a */
    public AbstractC0116E9 f305a;

    /* renamed from: b */
    public InterfaceC0070a f306b;

    /* renamed from: c */
    public Context f307c;

    /* renamed from: d */
    public ActuList f308d;

    /* renamed from: Cc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0070a {
        /* renamed from: j */
        void mo438j(@Nullable ActuDetail actuDetail);
    }

    /* renamed from: Cc$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0071b extends RecyclerView.AbstractC0824B {
        @NotNull

        /* renamed from: a */
        public final AbstractC0116E9 f309a;

        /* renamed from: b */
        public final /* synthetic */ C0069Cc f310b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0071b(@NotNull C0069Cc c0069Cc, AbstractC0116E9 abstractC0116E9) {
            super(abstractC0116E9.getRoot());
            C0581Yd.m1766e(abstractC0116E9, "v");
            this.f310b = c0069Cc;
            this.f309a = abstractC0116E9;
        }
    }

    public C0069Cc(@NotNull ActuList actuList, @NotNull InterfaceC0070a interfaceC0070a) {
        C0581Yd.m1766e(actuList, "actus");
        C0581Yd.m1766e(interfaceC0070a, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f308d = actuList;
        this.f306b = interfaceC0070a;
    }

    @NotNull
    /* renamed from: a */
    public final Context m2493a() {
        Context context = this.f307c;
        if (context != null) {
            return context;
        }
        C0581Yd.m1761j("context");
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f308d.m974a().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public void onBindViewHolder(@NotNull RecyclerView.AbstractC0824B abstractC0824B, int i) {
        C0581Yd.m1766e(abstractC0824B, "holder");
        ActuDetail actuDetail = this.f308d.m974a().get(i);
        C0581Yd.m1767d(actuDetail, "actus.actuList[position]");
        ActuDetail actuDetail2 = actuDetail;
        C0071b c0071b = (C0071b) abstractC0824B;
        C0581Yd.m1766e(actuDetail2, "item");
        TextView textView = c0071b.f309a.f404d;
        C0581Yd.m1767d(textView, "v.tvActuItemDesc");
        String str = actuDetail2.f4225f;
        if (str != null) {
            textView.setText(str);
            TextView textView2 = c0071b.f309a.f405f;
            C0581Yd.m1767d(textView2, "v.tvActuItemTitle");
            String str2 = actuDetail2.f4222b;
            if (str2 != null) {
                textView2.setText(str2);
                EnumC0520V8 enumC0520V8 = actuDetail2.f4226g;
                if (enumC0520V8 != null) {
                    int ordinal = enumC0520V8.ordinal();
                    if (ordinal == 0) {
                        ImageView imageView = c0071b.f309a.f403c;
                        Context m2493a = c0071b.f310b.m2493a();
                        Object obj = C2307w3.f6741a;
                        imageView.setImageDrawable(C2307w3.C2310c.m202b(m2493a, 2131230954));
                    } else if (ordinal == 1) {
                        ImageView imageView2 = c0071b.f309a.f403c;
                        Context m2493a2 = c0071b.f310b.m2493a();
                        Object obj2 = C2307w3.f6741a;
                        imageView2.setImageDrawable(C2307w3.C2310c.m202b(m2493a2, 2131230976));
                    } else if (ordinal == 2) {
                        ImageView imageView3 = c0071b.f309a.f403c;
                        Context m2493a3 = c0071b.f310b.m2493a();
                        Object obj3 = C2307w3.f6741a;
                        imageView3.setImageDrawable(C2307w3.C2310c.m202b(m2493a3, 2131230987));
                    } else if (ordinal == 3) {
                        ImageView imageView4 = c0071b.f309a.f403c;
                        Context m2493a4 = c0071b.f310b.m2493a();
                        Object obj4 = C2307w3.f6741a;
                        imageView4.setImageDrawable(C2307w3.C2310c.m202b(m2493a4, 2131230980));
                    } else if (ordinal != 4) {
                        ImageView imageView5 = c0071b.f309a.f403c;
                        Context m2493a5 = c0071b.f310b.m2493a();
                        Object obj5 = C2307w3.f6741a;
                        imageView5.setImageDrawable(C2307w3.C2310c.m202b(m2493a5, 2131230954));
                    } else {
                        ImageView imageView6 = c0071b.f309a.f403c;
                        Context m2493a6 = c0071b.f310b.m2493a();
                        Object obj6 = C2307w3.f6741a;
                        imageView6.setImageDrawable(C2307w3.C2310c.m202b(m2493a6, 2131230941));
                    }
                    String str3 = actuDetail2.f4227h;
                    if (str3 != null) {
                        Glide.with(c0071b.f310b.m2493a()).asBitmap().load(Base64.decode(str3, 0)).placeholder(C2307w3.C2310c.m202b(c0071b.f310b.m2493a(), 2131230812)).error(C2307w3.C2310c.m202b(c0071b.f310b.m2493a(), 2131230812)).into(c0071b.f309a.f402b);
                        c0071b.f309a.f401a.setOnClickListener(new View$OnClickListenerC0095Dc(c0071b, actuDetail2));
                        return;
                    }
                    C0581Yd.m1761j("image");
                    throw null;
                }
                C0581Yd.m1761j("iconValue");
                throw null;
            }
            C0581Yd.m1761j(MessageBundle.TITLE_ENTRY);
            throw null;
        }
        C0581Yd.m1761j("longDesc");
        throw null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    @NotNull
    public RecyclerView.AbstractC0824B onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        Context context = viewGroup.getContext();
        C0581Yd.m1767d(context, "parent.context");
        this.f307c = context;
        if (context != null) {
            LayoutInflater from = LayoutInflater.from(context);
            C0581Yd.m1767d(from, "LayoutInflater.from(context)");
            ViewDataBinding inflate = DataBindingUtil.inflate(from, 2131492901, viewGroup, false);
            C0581Yd.m1767d(inflate, "DataBindingUtil.inflate(…actu_item, parent, false)");
            this.f305a = (AbstractC0116E9) inflate;
            AbstractC0116E9 abstractC0116E9 = this.f305a;
            if (abstractC0116E9 != null) {
                return new C0071b(this, abstractC0116E9);
            }
            C0581Yd.m1761j("mDataBinding");
            throw null;
        }
        C0581Yd.m1761j("context");
        throw null;
    }
}
