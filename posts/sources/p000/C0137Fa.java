package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: Fa */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0137Fa extends AbstractC0117Ea {

    /* renamed from: k */
    public static final SparseIntArray f448k;

    /* renamed from: i */
    public final ConstraintLayout f449i;

    /* renamed from: j */
    public long f450j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f448k = sparseIntArray;
        sparseIntArray.put(2131296467, 1);
        sparseIntArray.put(2131296969, 2);
        sparseIntArray.put(2131296654, 3);
        sparseIntArray.put(2131296510, 4);
        sparseIntArray.put(2131296884, 5);
        sparseIntArray.put(2131296511, 6);
        sparseIntArray.put(2131296465, 7);
        sparseIntArray.put(2131296653, 8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0137Fa(androidx.databinding.DataBindingComponent r17, android.view.View r18) {
        /*
            r16 = this;
            r12 = r16
            r13 = r18
            android.util.SparseIntArray r0 = p000.C0137Fa.f448k
            r1 = 9
            r14 = 0
            r2 = r17
            java.lang.Object[] r15 = androidx.databinding.ViewDataBinding.mapBindings(r2, r13, r1, r14, r0)
            r0 = 7
            r0 = r15[r0]
            r4 = r0
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            r0 = 1
            r0 = r15[r0]
            r5 = r0
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            r0 = 4
            r0 = r15[r0]
            r6 = r0
            android.view.View r6 = (android.view.View) r6
            r0 = 6
            r0 = r15[r0]
            r7 = r0
            android.view.View r7 = (android.view.View) r7
            r0 = 8
            r0 = r15[r0]
            r8 = r0
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r0 = 3
            r0 = r15[r0]
            r9 = r0
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            r0 = 5
            r0 = r15[r0]
            r10 = r0
            android.widget.TextView r10 = (android.widget.TextView) r10
            r0 = 2
            r0 = r15[r0]
            r11 = r0
            android.widget.TextView r11 = (android.widget.TextView) r11
            r3 = 0
            r0 = r16
            r1 = r17
            r2 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = -1
            r12.f450j = r0
            r0 = 0
            r0 = r15[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r12.f449i = r0
            r0.setTag(r14)
            r12.setRootTag(r13)
            r16.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0137Fa.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f450j = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f450j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f450j = 1L;
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
