package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: F9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0136F9 extends AbstractC0116E9 {

    /* renamed from: i */
    public static final SparseIntArray f445i;

    /* renamed from: g */
    public final ConstraintLayout f446g;

    /* renamed from: h */
    public long f447h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f445i = sparseIntArray;
        sparseIntArray.put(2131296614, 1);
        sparseIntArray.put(2131296621, 2);
        sparseIntArray.put(2131296943, 3);
        sparseIntArray.put(2131296942, 4);
        sparseIntArray.put(2131296401, 5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0136F9(androidx.databinding.DataBindingComponent r13, android.view.View r14) {
        /*
            r12 = this;
            android.util.SparseIntArray r0 = p000.C0136F9.f445i
            r1 = 6
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r1, r2, r0)
            r1 = 5
            r1 = r0[r1]
            r7 = r1
            android.widget.Button r7 = (android.widget.Button) r7
            r1 = 1
            r1 = r0[r1]
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 2
            r1 = r0[r1]
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r1 = 4
            r1 = r0[r1]
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            r1 = 3
            r1 = r0[r1]
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            r6 = 0
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = -1
            r12.f447h = r3
            r13 = 0
            r13 = r0[r13]
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r12.f446g = r13
            r13.setTag(r2)
            r12.setRootTag(r14)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0136F9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f447h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f447h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f447h = 1L;
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
