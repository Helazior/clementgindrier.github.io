package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: R9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0403R9 extends AbstractC0376Q9 {

    /* renamed from: i */
    public static final SparseIntArray f1356i;

    /* renamed from: g */
    public final ConstraintLayout f1357g;

    /* renamed from: h */
    public long f1358h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1356i = sparseIntArray;
        sparseIntArray.put(2131296999, 1);
        sparseIntArray.put(2131297000, 2);
        sparseIntArray.put(2131296629, 3);
        sparseIntArray.put(2131296628, 4);
        sparseIntArray.put(2131296509, 5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0403R9(androidx.databinding.DataBindingComponent r13, android.view.View r14) {
        /*
            r12 = this;
            android.util.SparseIntArray r0 = p000.C0403R9.f1356i
            r1 = 6
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r1, r2, r0)
            r1 = 5
            r1 = r0[r1]
            r7 = r1
            android.view.View r7 = (android.view.View) r7
            r1 = 4
            r1 = r0[r1]
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 3
            r1 = r0[r1]
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r1 = 1
            r1 = r0[r1]
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            r1 = 2
            r1 = r0[r1]
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            r6 = 0
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = -1
            r12.f1358h = r3
            r13 = 0
            r13 = r0[r13]
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r12.f1357g = r13
            r13.setTag(r2)
            r12.setRootTag(r14)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0403R9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f1358h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f1358h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1358h = 1L;
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
