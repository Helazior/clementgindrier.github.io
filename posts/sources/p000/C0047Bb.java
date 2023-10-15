package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: Bb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0047Bb extends AbstractC0026Ab {

    /* renamed from: j */
    public static final SparseIntArray f211j;

    /* renamed from: h */
    public final ConstraintLayout f212h;

    /* renamed from: i */
    public long f213i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f211j = sparseIntArray;
        sparseIntArray.put(2131296345, 1);
        sparseIntArray.put(2131296990, 2);
        sparseIntArray.put(2131296989, 3);
        sparseIntArray.put(2131296991, 4);
        sparseIntArray.put(2131296972, 5);
        sparseIntArray.put(2131296617, 6);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0047Bb(androidx.databinding.DataBindingComponent r14, android.view.View r15) {
        /*
            r13 = this;
            android.util.SparseIntArray r0 = p000.C0047Bb.f211j
            r1 = 7
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r1 = 6
            r1 = r0[r1]
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 5
            r1 = r0[r1]
            r9 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r9 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r9
            r1 = 3
            r1 = r0[r1]
            r10 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r10 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r10
            r1 = 2
            r1 = r0[r1]
            r11 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r11 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r11
            r1 = 4
            r1 = r0[r1]
            r12 = r1
            fr.smoney.android.izly.ui.widget.CustomFontTextView r12 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r12
            r6 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r3 = -1
            r13.f213i = r3
            r14 = 0
            r14 = r0[r14]
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r13.f212h = r14
            r14.setTag(r2)
            r13.setRootTag(r15)
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0047Bb.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f213i = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f213i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f213i = 1L;
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
