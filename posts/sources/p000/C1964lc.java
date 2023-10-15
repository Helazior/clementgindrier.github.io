package p000;

import android.util.SparseIntArray;

/* renamed from: lc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1964lc extends AbstractC1944kc {

    /* renamed from: d */
    public static final SparseIntArray f5467d;

    /* renamed from: c */
    public long f5468c;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5467d = sparseIntArray;
        sparseIntArray.put(2131296359, 1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1964lc(androidx.databinding.DataBindingComponent r10, android.view.View r11) {
        /*
            r9 = this;
            android.util.SparseIntArray r0 = p000.C1964lc.f5467d
            r1 = 2
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r7 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText) r7
            r1 = 0
            r0 = r0[r1]
            r8 = r0
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            r6 = 0
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r0 = -1
            r9.f5468c = r0
            androidx.constraintlayout.widget.ConstraintLayout r10 = r9.f5393b
            r10.setTag(r2)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1964lc.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f5468c = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f5468c != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f5468c = 1L;
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
