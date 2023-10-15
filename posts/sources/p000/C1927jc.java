package p000;

import android.util.SparseIntArray;

/* renamed from: jc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1927jc extends AbstractC1898ic {

    /* renamed from: i */
    public static final SparseIntArray f5365i;

    /* renamed from: h */
    public long f5366h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5365i = sparseIntArray;
        sparseIntArray.put(2131296863, 1);
        sparseIntArray.put(2131296864, 2);
        sparseIntArray.put(2131296617, 3);
        sparseIntArray.put(2131296865, 4);
        sparseIntArray.put(2131296514, 5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1927jc(androidx.databinding.DataBindingComponent r14, android.view.View r15) {
        /*
            r13 = this;
            android.util.SparseIntArray r0 = p000.C1927jc.f5365i
            r1 = 6
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r1, r2, r0)
            r1 = 5
            r1 = r0[r1]
            r7 = r1
            android.view.View r7 = (android.view.View) r7
            r1 = 3
            r1 = r0[r1]
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 4
            r1 = r0[r1]
            r9 = r1
            android.widget.Button r9 = (android.widget.Button) r9
            r1 = 1
            r1 = r0[r1]
            r10 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r10 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r10
            r1 = 2
            r1 = r0[r1]
            r11 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r11 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r11
            r1 = 0
            r0 = r0[r1]
            r12 = r0
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            r6 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = -1
            r13.f5366h = r0
            android.widget.RelativeLayout r14 = r13.f5305g
            r14.setTag(r2)
            r13.setRootTag(r15)
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1927jc.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f5366h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f5366h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f5366h = 1L;
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
