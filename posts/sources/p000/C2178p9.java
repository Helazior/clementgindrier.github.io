package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: p9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2178p9 extends AbstractC2025o9 {

    /* renamed from: l */
    public static final SparseIntArray f6237l;

    /* renamed from: i */
    public final ScrollView f6238i;

    /* renamed from: j */
    public final ConstraintLayout f6239j;

    /* renamed from: k */
    public long f6240k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6237l = sparseIntArray;
        sparseIntArray.put(2131296917, 2);
        sparseIntArray.put(2131296987, 3);
        sparseIntArray.put(2131296402, 4);
        sparseIntArray.put(2131297024, 5);
        sparseIntArray.put(2131296408, 6);
        sparseIntArray.put(2131297014, 7);
        sparseIntArray.put(2131296407, 8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2178p9(androidx.databinding.DataBindingComponent r16, android.view.View r17) {
        /*
            r15 = this;
            r11 = r15
            r12 = r17
            android.util.SparseIntArray r0 = p000.C2178p9.f6237l
            r1 = 9
            r13 = 0
            r2 = r16
            java.lang.Object[] r14 = androidx.databinding.ViewDataBinding.mapBindings(r2, r12, r1, r13, r0)
            r0 = 4
            r0 = r14[r0]
            r4 = r0
            android.widget.Button r4 = (android.widget.Button) r4
            r0 = 8
            r0 = r14[r0]
            r5 = r0
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 6
            r0 = r14[r0]
            r6 = r0
            android.widget.Button r6 = (android.widget.Button) r6
            r0 = 2
            r0 = r14[r0]
            r7 = r0
            android.view.View r7 = (android.view.View) r7
            r0 = 3
            r0 = r14[r0]
            r8 = r0
            android.widget.TextView r8 = (android.widget.TextView) r8
            r0 = 7
            r0 = r14[r0]
            r9 = r0
            android.widget.TextView r9 = (android.widget.TextView) r9
            r0 = 5
            r0 = r14[r0]
            r10 = r0
            android.widget.TextView r10 = (android.widget.TextView) r10
            r3 = 0
            r0 = r15
            r1 = r16
            r2 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = -1
            r11.f6240k = r0
            r0 = 0
            r0 = r14[r0]
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r11.f6238i = r0
            r0.setTag(r13)
            r0 = 1
            r0 = r14[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r11.f6239j = r0
            r0.setTag(r13)
            r15.setRootTag(r12)
            r15.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2178p9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6240k = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6240k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6240k = 1L;
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
