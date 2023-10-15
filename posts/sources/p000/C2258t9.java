package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: t9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2258t9 extends AbstractC2236s9 {

    /* renamed from: k */
    public static final SparseIntArray f6576k;

    /* renamed from: h */
    public final ScrollView f6577h;

    /* renamed from: i */
    public final ConstraintLayout f6578i;

    /* renamed from: j */
    public long f6579j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6576k = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131296941, 3);
        sparseIntArray.put(2131296939, 4);
        sparseIntArray.put(2131296940, 5);
        sparseIntArray.put(2131296613, 6);
        sparseIntArray.put(2131296400, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2258t9(androidx.databinding.DataBindingComponent r14, android.view.View r15) {
        /*
            r13 = this;
            android.util.SparseIntArray r0 = p000.C2258t9.f6576k
            r1 = 8
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r1, r2, r0)
            r1 = 2
            r1 = r0[r1]
            r7 = r1
            android.view.View r7 = (android.view.View) r7
            r1 = 7
            r1 = r0[r1]
            r8 = r1
            android.widget.Button r8 = (android.widget.Button) r8
            r1 = 6
            r1 = r0[r1]
            r9 = r1
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r1 = 4
            r1 = r0[r1]
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            r1 = 5
            r1 = r0[r1]
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
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
            r13.f6579j = r3
            r14 = 0
            r14 = r0[r14]
            android.widget.ScrollView r14 = (android.widget.ScrollView) r14
            r13.f6577h = r14
            r14.setTag(r2)
            r14 = 1
            r14 = r0[r14]
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r13.f6578i = r14
            r14.setTag(r2)
            r13.setRootTag(r15)
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2258t9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6579j = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6579j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6579j = 1L;
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
