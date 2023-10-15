package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: xa */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2354xa extends AbstractC2331wa {

    /* renamed from: d */
    public static final SparseIntArray f6836d;

    /* renamed from: b */
    public final ConstraintLayout f6837b;

    /* renamed from: c */
    public long f6838c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6836d = sparseIntArray;
        sparseIntArray.put(2131296501, 1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2354xa(androidx.databinding.DataBindingComponent r7, android.view.View r8) {
        /*
            r6 = this;
            android.util.SparseIntArray r0 = p000.C2354xa.f6836d
            r1 = 2
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r7, r8, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            android.widget.LinearLayout r1 = (android.widget.LinearLayout) r1
            r3 = 0
            r6.<init>(r7, r8, r3, r1)
            r4 = -1
            r6.f6838c = r4
            r7 = r0[r3]
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            r6.f6837b = r7
            r7.setTag(r2)
            r6.setRootTag(r8)
            r6.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2354xa.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6838c = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6838c != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6838c = 1L;
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
