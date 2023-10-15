package p000;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: g7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1840g7 extends RecyclerView.AbstractC0849q {

    /* renamed from: a */
    public RecyclerView f5082a;

    /* renamed from: b */
    public final RecyclerView.AbstractC0851s f5083b = new C1841a();

    /* renamed from: g7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1841a extends RecyclerView.AbstractC0851s {

        /* renamed from: a */
        public boolean f5084a = false;

        public C1841a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0851s
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && this.f5084a) {
                this.f5084a = false;
                AbstractC1840g7.this.m792d();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0851s
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.f5084a = true;
        }
    }

    /* renamed from: a */
    public void m795a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f5082a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.f5083b);
            this.f5082a.setOnFlingListener(null);
        }
        this.f5082a = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() == null) {
                this.f5082a.addOnScrollListener(this.f5083b);
                this.f5082a.setOnFlingListener(this);
                new Scroller(this.f5082a.getContext(), new DecelerateInterpolator());
                m792d();
                return;
            }
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
    }

    /* renamed from: b */
    public abstract int[] mo794b(RecyclerView.AbstractC0843o abstractC0843o, View view);

    /* renamed from: c */
    public abstract View mo793c(RecyclerView.AbstractC0843o abstractC0843o);

    /* renamed from: d */
    public void m792d() {
        RecyclerView.AbstractC0843o layoutManager;
        View mo793c;
        RecyclerView recyclerView = this.f5082a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (mo793c = mo793c(layoutManager)) == null) {
            return;
        }
        int[] mo794b = mo794b(layoutManager, mo793c);
        if (mo794b[0] == 0 && mo794b[1] == 0) {
            return;
        }
        this.f5082a.smoothScrollBy(mo794b[0], mo794b[1]);
    }
}
