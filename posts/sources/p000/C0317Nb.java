package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: Nb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0317Nb extends AbstractC0294Mb {

    /* renamed from: i */
    public static final SparseIntArray f1044i;

    /* renamed from: f */
    public final ConstraintLayout f1045f;

    /* renamed from: g */
    public final ConstraintLayout f1046g;

    /* renamed from: h */
    public long f1047h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1044i = sparseIntArray;
        sparseIntArray.put(2131296917, 2);
        sparseIntArray.put(2131296601, 3);
        sparseIntArray.put(2131296975, 4);
        sparseIntArray.put(2131296998, 5);
        sparseIntArray.put(2131296791, 6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0317Nb(androidx.databinding.DataBindingComponent r13, android.view.View r14) {
        /*
            r12 = this;
            android.util.SparseIntArray r0 = p000.C0317Nb.f1044i
            r1 = 7
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r1, r2, r0)
            r1 = 3
            r1 = r0[r1]
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r1 = 6
            r1 = r0[r1]
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            r1 = 2
            r1 = r0[r1]
            r9 = r1
            android.view.View r9 = (android.view.View) r9
            r1 = 4
            r1 = r0[r1]
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            r1 = 5
            r1 = r0[r1]
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            r6 = 0
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = -1
            r12.f1047h = r3
            r13 = 0
            r13 = r0[r13]
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r12.f1045f = r13
            r13.setTag(r2)
            r13 = 1
            r13 = r0[r13]
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r12.f1046g = r13
            r13.setTag(r2)
            r12.setRootTag(r14)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0317Nb.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f1047h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f1047h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1047h = 1L;
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
