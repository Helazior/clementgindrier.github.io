package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: pa */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2179pa extends AbstractC2026oa {

    /* renamed from: k */
    public static final SparseIntArray f6241k;

    /* renamed from: h */
    public final ScrollView f6242h;

    /* renamed from: i */
    public final ConstraintLayout f6243i;

    /* renamed from: j */
    public long f6244j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6241k = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131296546, 3);
        sparseIntArray.put(2131296544, 4);
        sparseIntArray.put(2131296611, 5);
        sparseIntArray.put(2131296545, 6);
        sparseIntArray.put(2131296368, 7);
        sparseIntArray.put(2131296370, 8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2179pa(androidx.databinding.DataBindingComponent r16, android.view.View r17) {
        /*
            r15 = this;
            r11 = r15
            r12 = r17
            android.util.SparseIntArray r0 = p000.C2179pa.f6241k
            r1 = 9
            r13 = 0
            r2 = r16
            java.lang.Object[] r14 = androidx.databinding.ViewDataBinding.mapBindings(r2, r12, r1, r13, r0)
            r0 = 2
            r0 = r14[r0]
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            r0 = 7
            r0 = r14[r0]
            r5 = r0
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 8
            r0 = r14[r0]
            r6 = r0
            android.widget.Button r6 = (android.widget.Button) r6
            r0 = 4
            r0 = r14[r0]
            r7 = r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r7 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText) r7
            r0 = 6
            r0 = r14[r0]
            r8 = r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r8 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText) r8
            r0 = 3
            r0 = r14[r0]
            r9 = r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r9 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText) r9
            r0 = 5
            r0 = r14[r0]
            r10 = r0
            fr.smoney.android.izly.ui.widget.CustomIconTextView r10 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r10
            r3 = 0
            r0 = r15
            r1 = r16
            r2 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = -1
            r11.f6244j = r0
            r0 = 0
            r0 = r14[r0]
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r11.f6242h = r0
            r0.setTag(r13)
            r0 = 1
            r0 = r14[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r11.f6243i = r0
            r0.setTag(r13)
            r15.setRootTag(r12)
            r15.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2179pa.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6244j = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6244j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6244j = 1L;
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
