package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: N9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0315N9 extends AbstractC0292M9 {

    /* renamed from: m */
    public static final SparseIntArray f1037m;

    /* renamed from: j */
    public final ScrollView f1038j;

    /* renamed from: k */
    public final ConstraintLayout f1039k;

    /* renamed from: l */
    public long f1040l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1037m = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131296537, 3);
        sparseIntArray.put(2131296994, 4);
        sparseIntArray.put(2131296541, 5);
        sparseIntArray.put(2131296996, 6);
        sparseIntArray.put(2131296539, 7);
        sparseIntArray.put(2131296995, 8);
        sparseIntArray.put(2131296477, 9);
        sparseIntArray.put(2131296374, 10);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0315N9(androidx.databinding.DataBindingComponent r18, android.view.View r19) {
        /*
            r17 = this;
            r13 = r17
            r14 = r19
            android.util.SparseIntArray r0 = p000.C0315N9.f1037m
            r1 = 11
            r15 = 0
            r2 = r18
            java.lang.Object[] r16 = androidx.databinding.ViewDataBinding.mapBindings(r2, r14, r1, r15, r0)
            r0 = 2
            r0 = r16[r0]
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            r0 = 10
            r0 = r16[r0]
            r5 = r0
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 9
            r0 = r16[r0]
            r6 = r0
            fr.smoney.android.izly.ui.widget.CustomIconTextView r6 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r6
            r0 = 3
            r0 = r16[r0]
            r7 = r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r7 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText) r7
            r0 = 7
            r0 = r16[r0]
            r8 = r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r8 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText) r8
            r0 = 5
            r0 = r16[r0]
            r9 = r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r9 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText) r9
            r0 = 4
            r0 = r16[r0]
            r10 = r0
            android.widget.TextView r10 = (android.widget.TextView) r10
            r0 = 8
            r0 = r16[r0]
            r11 = r0
            android.widget.TextView r11 = (android.widget.TextView) r11
            r0 = 6
            r0 = r16[r0]
            r12 = r0
            android.widget.TextView r12 = (android.widget.TextView) r12
            r3 = 0
            r0 = r17
            r1 = r18
            r2 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = -1
            r13.f1040l = r0
            r0 = 0
            r0 = r16[r0]
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r13.f1038j = r0
            r0.setTag(r15)
            r0 = 1
            r0 = r16[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r13.f1039k = r0
            r0.setTag(r15)
            r13.setRootTag(r14)
            r17.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0315N9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f1040l = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f1040l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1040l = 1L;
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
