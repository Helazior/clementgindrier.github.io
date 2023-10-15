package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: ja */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1925ja extends AbstractC1896ia {

    /* renamed from: g */
    public static final SparseIntArray f5357g;

    /* renamed from: d */
    public final ConstraintLayout f5358d;

    /* renamed from: f */
    public long f5359f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5357g = sparseIntArray;
        sparseIntArray.put(2131296353, 1);
        sparseIntArray.put(2131296659, 2);
        sparseIntArray.put(2131296624, 3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1925ja(androidx.databinding.DataBindingComponent r11, android.view.View r12) {
        /*
            r10 = this;
            android.util.SparseIntArray r0 = p000.C1925ja.f5357g
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
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r1 = 2
            r1 = r0[r1]
            r9 = r1
            androidx.recyclerview.widget.RecyclerView r9 = (androidx.recyclerview.widget.RecyclerView) r9
            r6 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r3 = -1
            r10.f5359f = r3
            r11 = 0
            r11 = r0[r11]
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            r10.f5358d = r11
            r11.setTag(r2)
            r10.setRootTag(r12)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1925ja.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f5359f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f5359f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f5359f = 1L;
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
