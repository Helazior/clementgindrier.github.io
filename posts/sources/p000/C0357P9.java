package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: P9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0357P9 extends AbstractC0338O9 {

    /* renamed from: h */
    public static final SparseIntArray f1227h;

    /* renamed from: d */
    public final ScrollView f1228d;

    /* renamed from: f */
    public final ConstraintLayout f1229f;

    /* renamed from: g */
    public long f1230g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1227h = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131296500, 3);
        sparseIntArray.put(2131296397, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0357P9(androidx.databinding.DataBindingComponent r11, android.view.View r12) {
        /*
            r10 = this;
            android.util.SparseIntArray r0 = p000.C0357P9.f1227h
            r1 = 5
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r1, r2, r0)
            r1 = 2
            r1 = r0[r1]
            r7 = r1
            android.view.View r7 = (android.view.View) r7
            r1 = 4
            r1 = r0[r1]
            r8 = r1
            android.widget.Button r8 = (android.widget.Button) r8
            r1 = 3
            r1 = r0[r1]
            r9 = r1
            fr.smoney.android.izly.ui.widget.CustomDetailBodyView r9 = (fr.smoney.android.izly.p005ui.widget.CustomDetailBodyView) r9
            r6 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r3 = -1
            r10.f1230g = r3
            r11 = 0
            r11 = r0[r11]
            android.widget.ScrollView r11 = (android.widget.ScrollView) r11
            r10.f1228d = r11
            r11.setTag(r2)
            r11 = 1
            r11 = r0[r11]
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            r10.f1229f = r11
            r11.setTag(r2)
            r10.setRootTag(r12)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0357P9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f1230g = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f1230g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1230g = 1L;
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
