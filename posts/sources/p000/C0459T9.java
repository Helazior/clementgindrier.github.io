package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: T9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0459T9 extends AbstractC0436S9 {

    /* renamed from: j */
    public static final SparseIntArray f1603j;

    /* renamed from: g */
    public final ScrollView f1604g;

    /* renamed from: h */
    public final ConstraintLayout f1605h;

    /* renamed from: i */
    public long f1606i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1603j = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131296761, 3);
        sparseIntArray.put(2131296979, 4);
        sparseIntArray.put(2131296478, 5);
        sparseIntArray.put(2131296479, 6);
        sparseIntArray.put(2131296480, 7);
        sparseIntArray.put(2131296840, 8);
        sparseIntArray.put(2131296977, 9);
        sparseIntArray.put(2131296368, 10);
        sparseIntArray.put(2131296370, 11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0459T9(androidx.databinding.DataBindingComponent r19, android.view.View r20) {
        /*
            r18 = this;
            r14 = r18
            r15 = r20
            android.util.SparseIntArray r0 = p000.C0459T9.f1603j
            r1 = 12
            r13 = 0
            r2 = r19
            java.lang.Object[] r16 = androidx.databinding.ViewDataBinding.mapBindings(r2, r15, r1, r13, r0)
            r0 = 2
            r0 = r16[r0]
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            r0 = 10
            r0 = r16[r0]
            r5 = r0
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 11
            r0 = r16[r0]
            r6 = r0
            android.widget.Button r6 = (android.widget.Button) r6
            r0 = 5
            r0 = r16[r0]
            r7 = r0
            fr.smoney.android.izly.ui.widget.CustomIconTextView r7 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r7
            r0 = 6
            r0 = r16[r0]
            r8 = r0
            fr.smoney.android.izly.ui.widget.CustomIconTextView r8 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r8
            r0 = 7
            r0 = r16[r0]
            r9 = r0
            fr.smoney.android.izly.ui.widget.CustomIconTextView r9 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r9
            r0 = 3
            r0 = r16[r0]
            r10 = r0
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r0 = 8
            r0 = r16[r0]
            r11 = r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleSpinner r11 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleSpinner) r11
            r0 = 9
            r0 = r16[r0]
            r12 = r0
            fr.smoney.android.izly.ui.widget.CustomIconTextView r12 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r12
            r0 = 4
            r0 = r16[r0]
            r17 = r0
            android.widget.TextView r17 = (android.widget.TextView) r17
            r3 = 0
            r0 = r18
            r1 = r19
            r2 = r20
            r15 = r13
            r13 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r0 = -1
            r14.f1606i = r0
            r0 = 0
            r0 = r16[r0]
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r14.f1604g = r0
            r0.setTag(r15)
            r0 = 1
            r0 = r16[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r14.f1605h = r0
            r0.setTag(r15)
            r0 = r20
            r14.setRootTag(r0)
            r18.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0459T9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f1606i = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f1606i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1606i = 1L;
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
