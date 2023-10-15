package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: Db */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0094Db extends AbstractC0068Cb {

    /* renamed from: i */
    public static final SparseIntArray f360i;

    /* renamed from: g */
    public final ConstraintLayout f361g;

    /* renamed from: h */
    public long f362h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f360i = sparseIntArray;
        sparseIntArray.put(2131296345, 1);
        sparseIntArray.put(2131296990, 2);
        sparseIntArray.put(2131296989, 3);
        sparseIntArray.put(2131296991, 4);
        sparseIntArray.put(2131296972, 5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0094Db(androidx.databinding.DataBindingComponent r13, android.view.View r14) {
        /*
            r12 = this;
            android.util.SparseIntArray r0 = p000.C0094Db.f360i
            r1 = 6
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r1 = 5
            r1 = r0[r1]
            r8 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r8 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r8
            r1 = 3
            r1 = r0[r1]
            r9 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r9 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r9
            r1 = 2
            r1 = r0[r1]
            r10 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r10 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r10
            r1 = 4
            r1 = r0[r1]
            r11 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r11 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r11
            r6 = 0
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = -1
            r12.f362h = r3
            r13 = 0
            r13 = r0[r13]
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r12.f361g = r13
            r13.setTag(r2)
            r12.setRootTag(r14)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0094Db.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f362h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f362h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f362h = 1L;
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
