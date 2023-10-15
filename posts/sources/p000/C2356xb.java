package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: xb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2355xb extends AbstractC2332wb {

    /* renamed from: g */
    public static final SparseIntArray f6839g;

    /* renamed from: d */
    public final ConstraintLayout f6840d;

    /* renamed from: f */
    public long f6841f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6839g = sparseIntArray;
        sparseIntArray.put(2131296356, 1);
        sparseIntArray.put(2131296730, 2);
        sparseIntArray.put(2131296646, 3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2355xb(androidx.databinding.DataBindingComponent r11, android.view.View r12) {
        /*
            r10 = this;
            android.util.SparseIntArray r0 = p000.C2355xb.f6839g
            r1 = 4
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            android.view.View r7 = (android.view.View) r7
            r1 = 3
            r1 = r0[r1]
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            r1 = 2
            r1 = r0[r1]
            r9 = r1
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            r6 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r3 = -1
            r10.f6841f = r3
            r11 = 0
            r11 = r0[r11]
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            r10.f6840d = r11
            r11.setTag(r2)
            r10.setRootTag(r12)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2355xb.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6841f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6841f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6841f = 1L;
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
