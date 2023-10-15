package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: X9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0561X9 extends AbstractC0540W9 {

    /* renamed from: i */
    public static final SparseIntArray f2006i;

    /* renamed from: f */
    public final ScrollView f2007f;

    /* renamed from: g */
    public final ConstraintLayout f2008g;

    /* renamed from: h */
    public long f2009h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2006i = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131296954, 3);
        sparseIntArray.put(2131296436, 4);
        sparseIntArray.put(2131296439, 5);
        sparseIntArray.put(2131296396, 6);
        sparseIntArray.put(2131296398, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0561X9(androidx.databinding.DataBindingComponent r14, android.view.View r15) {
        /*
            r13 = this;
            android.util.SparseIntArray r0 = p000.C0561X9.f2006i
            r1 = 8
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r1, r2, r0)
            r1 = 2
            r1 = r0[r1]
            r7 = r1
            android.view.View r7 = (android.view.View) r7
            r1 = 6
            r1 = r0[r1]
            r8 = r1
            android.widget.Button r8 = (android.widget.Button) r8
            r1 = 7
            r1 = r0[r1]
            r9 = r1
            android.widget.Button r9 = (android.widget.Button) r9
            r1 = 4
            r1 = r0[r1]
            r10 = r1
            fr.smoney.android.izly.ui.widget.CustomIconTextView r10 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r10
            r1 = 5
            r1 = r0[r1]
            r11 = r1
            fr.smoney.android.izly.ui.widget.CustomIconTextView r11 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r11
            r1 = 3
            r1 = r0[r1]
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            r6 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r3 = -1
            r13.f2009h = r3
            r14 = 0
            r14 = r0[r14]
            android.widget.ScrollView r14 = (android.widget.ScrollView) r14
            r13.f2007f = r14
            r14.setTag(r2)
            r14 = 1
            r14 = r0[r14]
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r13.f2008g = r14
            r14.setTag(r2)
            r13.setRootTag(r15)
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0561X9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f2009h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f2009h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f2009h = 1L;
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
