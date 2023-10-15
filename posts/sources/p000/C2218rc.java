package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: rc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2218rc extends AbstractC2201qc {

    /* renamed from: i */
    public static final SparseIntArray f6357i;

    /* renamed from: g */
    public final ConstraintLayout f6358g;

    /* renamed from: h */
    public long f6359h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6357i = sparseIntArray;
        sparseIntArray.put(2131296918, 2);
        sparseIntArray.put(2131296500, 3);
        sparseIntArray.put(2131296368, 4);
        sparseIntArray.put(2131296393, 5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2218rc(androidx.databinding.DataBindingComponent r13, android.view.View r14) {
        /*
            r12 = this;
            android.util.SparseIntArray r0 = p000.C2218rc.f6357i
            r1 = 6
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r1, r2, r0)
            r1 = 4
            r1 = r0[r1]
            r7 = r1
            android.widget.Button r7 = (android.widget.Button) r7
            r1 = 5
            r1 = r0[r1]
            r8 = r1
            android.widget.IconButton r8 = (android.widget.IconButton) r8
            r1 = 0
            r1 = r0[r1]
            r9 = r1
            androidx.coordinatorlayout.widget.CoordinatorLayout r9 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r9
            r1 = 3
            r1 = r0[r1]
            r10 = r1
            fr.smoney.android.izly.ui.widget.CustomDetailBodyView r10 = (fr.smoney.android.izly.p005ui.widget.CustomDetailBodyView) r10
            r1 = 2
            r1 = r0[r1]
            r11 = r1
            android.view.View r11 = (android.view.View) r11
            r6 = 0
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = -1
            r12.f6359h = r3
            androidx.coordinatorlayout.widget.CoordinatorLayout r13 = r12.f6303c
            r13.setTag(r2)
            r13 = 1
            r13 = r0[r13]
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r12.f6358g = r13
            r13.setTag(r2)
            r12.setRootTag(r14)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2218rc.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6359h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6359h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6359h = 1L;
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
