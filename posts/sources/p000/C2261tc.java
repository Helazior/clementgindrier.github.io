package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: tc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2261tc extends AbstractC2239sc {

    /* renamed from: j */
    public static final SparseIntArray f6586j;

    /* renamed from: h */
    public final ConstraintLayout f6587h;

    /* renamed from: i */
    public long f6588i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6586j = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131297001, 3);
        sparseIntArray.put(2131296500, 4);
        sparseIntArray.put(2131296392, 5);
        sparseIntArray.put(2131296982, 6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2261tc(androidx.databinding.DataBindingComponent r14, android.view.View r15) {
        /*
            r13 = this;
            android.util.SparseIntArray r0 = p000.C2261tc.f6586j
            r1 = 7
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r1, r2, r0)
            r1 = 2
            r1 = r0[r1]
            r7 = r1
            android.view.View r7 = (android.view.View) r7
            r1 = 5
            r1 = r0[r1]
            r8 = r1
            android.widget.IconButton r8 = (android.widget.IconButton) r8
            r1 = 0
            r1 = r0[r1]
            r9 = r1
            androidx.coordinatorlayout.widget.CoordinatorLayout r9 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r9
            r1 = 4
            r1 = r0[r1]
            r10 = r1
            fr.smoney.android.izly.ui.widget.CustomDetailBodyView r10 = (fr.smoney.android.izly.p005ui.widget.CustomDetailBodyView) r10
            r1 = 6
            r1 = r0[r1]
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            r1 = 3
            r1 = r0[r1]
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            r6 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r3 = -1
            r13.f6588i = r3
            androidx.coordinatorlayout.widget.CoordinatorLayout r14 = r13.f6411c
            r14.setTag(r2)
            r14 = 1
            r14 = r0[r14]
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r13.f6587h = r14
            r14.setTag(r2)
            r13.setRootTag(r15)
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2261tc.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6588i = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6588i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6588i = 1L;
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
