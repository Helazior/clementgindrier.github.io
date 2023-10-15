package p000;

import android.util.SparseIntArray;

/* renamed from: nc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2009nc extends AbstractC1985mc {

    /* renamed from: g */
    public static final SparseIntArray f5556g;

    /* renamed from: f */
    public long f5557f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5556g = sparseIntArray;
        sparseIntArray.put(2131296319, 1);
        sparseIntArray.put(2131296320, 2);
        sparseIntArray.put(2131296483, 3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2009nc(androidx.databinding.DataBindingComponent r12, android.view.View r13) {
        /*
            r11 = this;
            android.util.SparseIntArray r0 = p000.C2009nc.f5556g
            r1 = 4
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r12, r13, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            r1 = 2
            r1 = r0[r1]
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            r1 = 3
            r1 = r0[r1]
            r9 = r1
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r9 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText) r9
            r1 = 0
            r0 = r0[r1]
            r10 = r0
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r6 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r0 = -1
            r11.f5557f = r0
            androidx.constraintlayout.widget.ConstraintLayout r12 = r11.f5504d
            r12.setTag(r2)
            r11.setRootTag(r13)
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2009nc.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f5557f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f5557f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f5557f = 1L;
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
