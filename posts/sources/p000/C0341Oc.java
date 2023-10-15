package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.data.model.NewsFeedItem;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Oc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0341Oc extends RecyclerView.AbstractC0832g<C0342a> {

    /* renamed from: a */
    public AbstractC0026Ab f1151a;

    /* renamed from: b */
    public List<NewsFeedItem> f1152b;

    /* renamed from: c */
    public final C0479U8 f1153c;

    /* renamed from: d */
    public final Context f1154d;

    /* renamed from: Oc$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0342a extends RecyclerView.AbstractC0824B {
        @Nullable

        /* renamed from: a */
        public AbstractC0026Ab f1155a;
        @NotNull

        /* renamed from: b */
        public Context f1156b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0342a(@Nullable AbstractC0026Ab abstractC0026Ab, @NotNull Context context) {
            super(abstractC0026Ab.getRoot());
            C0581Yd.m1766e(context, "mContext");
            C0581Yd.m1768c(abstractC0026Ab);
            this.f1155a = abstractC0026Ab;
            this.f1156b = context;
        }
    }

    public C0341Oc(@NotNull C0479U8 c0479u8, @NotNull Context context) {
        C0581Yd.m1766e(c0479u8, "mMemoryProvider");
        C0581Yd.m1766e(context, "context");
        this.f1153c = c0479u8;
        this.f1154d = context;
        this.f1152b = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public int getItemCount() {
        return this.f1152b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBindViewHolder(p000.C0341Oc.C0342a r17, int r18) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0341Oc.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$B, int):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0832g
    public C0342a onCreateViewHolder(ViewGroup viewGroup, int i) {
        C0581Yd.m1766e(viewGroup, "parent");
        this.f1151a = (AbstractC0026Ab) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), 2131492980, viewGroup, false);
        return new C0342a(this.f1151a, this.f1154d);
    }
}
