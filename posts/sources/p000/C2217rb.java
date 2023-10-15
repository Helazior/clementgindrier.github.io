package p000;

import android.util.SparseIntArray;
import android.widget.RelativeLayout;

/* renamed from: rb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2217rb extends AbstractC2200qb {

    /* renamed from: f */
    public static final SparseIntArray f6354f;

    /* renamed from: c */
    public final RelativeLayout f6355c;

    /* renamed from: d */
    public long f6356d;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6354f = sparseIntArray;
        sparseIntArray.put(2131296600, 1);
        sparseIntArray.put(2131296889, 2);
        sparseIntArray.put(2131296427, 3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2217rb(androidx.databinding.DataBindingComponent r11, android.view.View r12) {
        /*
            r10 = this;
            android.util.SparseIntArray r0 = p000.C2217rb.f6354f
            r1 = 4
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r1, r2, r0)
            r1 = 3
            r1 = r0[r1]
            r7 = r1
            android.widget.IconTextView r7 = (android.widget.IconTextView) r7
            r1 = 1
            r1 = r0[r1]
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 2
            r1 = r0[r1]
            r9 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r9 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r9
            r6 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r3 = -1
            r10.f6356d = r3
            r11 = 0
            r11 = r0[r11]
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            r10.f6355c = r11
            r11.setTag(r2)
            r10.setRootTag(r12)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2217rb.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6356d = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6356d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6356d = 1L;
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
