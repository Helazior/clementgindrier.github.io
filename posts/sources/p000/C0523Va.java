package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: Va */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0523Va extends AbstractC0481Ua {

    /* renamed from: g */
    public static final SparseIntArray f1855g;

    /* renamed from: d */
    public final ConstraintLayout f1856d;

    /* renamed from: f */
    public long f1857f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1855g = sparseIntArray;
        sparseIntArray.put(2131296472, 1);
        sparseIntArray.put(2131296473, 2);
        sparseIntArray.put(2131296512, 3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0523Va(androidx.databinding.DataBindingComponent r11, android.view.View r12) {
        /*
            r10 = this;
            android.util.SparseIntArray r0 = p000.C0523Va.f1855g
            r1 = 4
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r7 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r7
            r1 = 2
            r1 = r0[r1]
            r8 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r8 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r8
            r1 = 3
            r1 = r0[r1]
            r9 = r1
            android.view.View r9 = (android.view.View) r9
            r6 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r3 = -1
            r10.f1857f = r3
            r11 = 0
            r11 = r0[r11]
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            r10.f1856d = r11
            r11.setTag(r2)
            r10.setRootTag(r12)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0523Va.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f1857f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f1857f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1857f = 1L;
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
