package p000;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import fr.smoney.android.izly.p005ui.widget.CustomEmptyView;

/* renamed from: Sa */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0437Sa extends ViewDataBinding {

    /* renamed from: a */
    public final View f1428a;

    /* renamed from: b */
    public final CustomEmptyView f1429b;

    /* renamed from: c */
    public final SwipeRefreshLayout f1430c;

    /* renamed from: d */
    public final RecyclerView f1431d;

    public AbstractC0437Sa(Object obj, View view, int i, View view2, CustomEmptyView customEmptyView, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f1428a = view2;
        this.f1429b = customEmptyView;
        this.f1430c = swipeRefreshLayout;
        this.f1431d = recyclerView;
    }
}
