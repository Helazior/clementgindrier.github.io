package p000;

import android.util.SparseIntArray;

/* renamed from: bc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0976bc extends AbstractC0616ac {

    /* renamed from: f */
    public static final SparseIntArray f3741f;

    /* renamed from: d */
    public long f3742d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3741f = sparseIntArray;
        sparseIntArray.put(2131296539, 1);
        sparseIntArray.put(2131296541, 2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0976bc(androidx.databinding.DataBindingComponent r11, android.view.View r12) {
        /*
            r10 = this;
            android.util.SparseIntArray r0 = p000.C0976bc.f3741f
            r1 = 3
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            android.widget.EditText r7 = (android.widget.EditText) r7
            r1 = 2
            r1 = r0[r1]
            r8 = r1
            android.widget.EditText r8 = (android.widget.EditText) r8
            r1 = 0
            r0 = r0[r1]
            r9 = r0
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            r6 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0 = -1
            r10.f3742d = r0
            android.widget.LinearLayout r11 = r10.f2180c
            r11.setTag(r2)
            r10.setRootTag(r12)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0976bc.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f3742d = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f3742d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f3742d = 1L;
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
