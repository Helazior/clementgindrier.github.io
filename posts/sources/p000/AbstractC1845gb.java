package p000;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import fr.smoney.android.izly.p005ui.widget.CustomEmptyView;

/* renamed from: gb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1845gb extends ViewDataBinding {

    /* renamed from: a */
    public final View f5088a;

    /* renamed from: b */
    public final CustomEmptyView f5089b;

    /* renamed from: c */
    public final SwipeRefreshLayout f5090c;

    /* renamed from: d */
    public final RecyclerView f5091d;

    public AbstractC1845gb(Object obj, View view, int i, View view2, CustomEmptyView customEmptyView, SwipeRefreshLayout swipeRefreshLayout, RecyclerView recyclerView) {
        super(obj, view, i);
        this.f5088a = view2;
        this.f5089b = customEmptyView;
        this.f5090c = swipeRefreshLayout;
        this.f5091d = recyclerView;
    }
}
