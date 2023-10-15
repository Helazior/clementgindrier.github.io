package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: Xb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0563Xb extends AbstractC0542Wb {

    /* renamed from: g */
    public static final SparseIntArray f2013g;

    /* renamed from: d */
    public final ConstraintLayout f2014d;

    /* renamed from: f */
    public long f2015f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2013g = sparseIntArray;
        sparseIntArray.put(2131296605, 1);
        sparseIntArray.put(2131296763, 2);
        sparseIntArray.put(2131296599, 3);
        sparseIntArray.put(2131296896, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0563Xb(androidx.databinding.DataBindingComponent r12, android.view.View r13) {
        /*
            r11 = this;
            android.util.SparseIntArray r0 = p000.C0563Xb.f2013g
            r1 = 5
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r12, r13, r1, r2, r0)
            r1 = 3
            r1 = r0[r1]
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r1 = 1
            r1 = r0[r1]
            r8 = r1
            android.view.View r8 = (android.view.View) r8
            r1 = 2
            r1 = r0[r1]
            r9 = r1
            android.view.View r9 = (android.view.View) r9
            r1 = 4
            r1 = r0[r1]
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            r6 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r3 = -1
            r11.f2015f = r3
            r12 = 0
            r12 = r0[r12]
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r11.f2014d = r12
            r12.setTag(r2)
            r11.setRootTag(r13)
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0563Xb.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f2015f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f2015f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f2015f = 1L;
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
