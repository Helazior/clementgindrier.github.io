package p000;

import android.util.SparseIntArray;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/* renamed from: La */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0275La extends AbstractC0253Ka {

    /* renamed from: o */
    public static final SparseIntArray f910o;

    /* renamed from: l */
    public final ScrollView f911l;

    /* renamed from: m */
    public final LinearLayout f912m;

    /* renamed from: n */
    public long f913n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f910o = sparseIntArray;
        sparseIntArray.put(2131296454, 2);
        sparseIntArray.put(2131296456, 3);
        sparseIntArray.put(2131296980, 4);
        sparseIntArray.put(2131296615, 5);
        sparseIntArray.put(2131296694, 6);
        sparseIntArray.put(2131296779, 7);
        sparseIntArray.put(2131296476, 8);
        sparseIntArray.put(2131296366, 9);
        sparseIntArray.put(2131296364, 10);
        sparseIntArray.put(2131296455, 11);
        sparseIntArray.put(2131296866, 12);
        sparseIntArray.put(2131296367, 13);
        sparseIntArray.put(2131296365, 14);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0275La(androidx.databinding.DataBindingComponent r19, android.view.View r20) {
        /*
            r18 = this;
            r2 = r18
            r1 = r20
            android.util.SparseIntArray r0 = p000.C0275La.f910o
            r3 = 15
            r15 = 0
            r14 = r19
            java.lang.Object[] r17 = androidx.databinding.ViewDataBinding.mapBindings(r14, r1, r3, r15, r0)
            r0 = 10
            r0 = r17[r0]
            r4 = r0
            android.widget.IconTextView r4 = (android.widget.IconTextView) r4
            r0 = 14
            r0 = r17[r0]
            r5 = r0
            android.widget.IconTextView r5 = (android.widget.IconTextView) r5
            r0 = 9
            r0 = r17[r0]
            r6 = r0
            android.widget.IconTextView r6 = (android.widget.IconTextView) r6
            r0 = 13
            r0 = r17[r0]
            r7 = r0
            android.widget.IconTextView r7 = (android.widget.IconTextView) r7
            r0 = 2
            r0 = r17[r0]
            r8 = r0
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            r0 = 11
            r0 = r17[r0]
            r9 = r0
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            r0 = 3
            r0 = r17[r0]
            r10 = r0
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r0 = 8
            r0 = r17[r0]
            r11 = r0
            fr.smoney.android.izly.ui.widget.CustomIconTextView r11 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r11
            r0 = 5
            r0 = r17[r0]
            r12 = r0
            android.widget.ImageView r12 = (android.widget.ImageView) r12
            r0 = 6
            r0 = r17[r0]
            r13 = r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleSpinner r13 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleSpinner) r13
            r0 = 7
            r0 = r17[r0]
            fr.smoney.android.izly.ui.widget.CustomFontTextView r0 = (fr.smoney.android.izly.p005ui.widget.CustomFontTextView) r0
            r14 = r0
            r0 = 12
            r0 = r17[r0]
            fr.smoney.android.izly.ui.widget.CustomDetailBodyView r0 = (fr.smoney.android.izly.p005ui.widget.CustomDetailBodyView) r0
            r3 = r15
            r15 = r0
            r0 = 4
            r0 = r17[r0]
            r16 = r0
            android.widget.TextView r16 = (android.widget.TextView) r16
            r0 = 0
            r3 = r0
            r0 = r18
            r1 = r19
            r2 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = -1
            r2 = r18
            r2.f913n = r0
            r0 = 0
            r0 = r17[r0]
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r2.f911l = r0
            r1 = 0
            r0.setTag(r1)
            r0 = 1
            r0 = r17[r0]
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r2.f912m = r0
            r0.setTag(r1)
            r0 = r20
            r2.setRootTag(r0)
            r18.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0275La.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f913n = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f913n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f913n = 1L;
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
