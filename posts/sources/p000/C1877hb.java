package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: hb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1877hb extends AbstractC1845gb {

    /* renamed from: h */
    public static final SparseIntArray f5219h;

    /* renamed from: f */
    public final ConstraintLayout f5220f;

    /* renamed from: g */
    public long f5221g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5219h = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131296789, 3);
        sparseIntArray.put(2131296548, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1877hb(androidx.databinding.DataBindingComponent r12, android.view.View r13) {
        /*
            r11 = this;
            android.util.SparseIntArray r0 = p000.C1877hb.f5219h
            r1 = 5
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r12, r13, r1, r2, r0)
            r1 = 2
            r1 = r0[r1]
            r7 = r1
            android.view.View r7 = (android.view.View) r7
            r1 = 4
            r1 = r0[r1]
            r8 = r1
            fr.smoney.android.izly.ui.widget.CustomEmptyView r8 = (fr.smoney.android.izly.p005ui.widget.CustomEmptyView) r8
            r1 = 0
            r1 = r0[r1]
            r9 = r1
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r9 = (androidx.swiperefreshlayout.widget.SwipeRefreshLayout) r9
            r1 = 3
            r1 = r0[r1]
            r10 = r1
            androidx.recyclerview.widget.RecyclerView r10 = (androidx.recyclerview.widget.RecyclerView) r10
            r6 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r3 = -1
            r11.f5221g = r3
            r12 = 1
            r12 = r0[r12]
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r11.f5220f = r12
            r12.setTag(r2)
            androidx.swiperefreshlayout.widget.SwipeRefreshLayout r12 = r11.f5090c
            r12.setTag(r2)
            r11.setRootTag(r13)
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1877hb.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f5221g = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f5221g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f5221g = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }
}
