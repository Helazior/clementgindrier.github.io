package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: dc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1630dc extends AbstractC0996cc {

    /* renamed from: s */
    public static final SparseIntArray f4031s;

    /* renamed from: p */
    public final ScrollView f4032p;

    /* renamed from: q */
    public final ConstraintLayout f4033q;

    /* renamed from: r */
    public long f4034r;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4031s = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131297019, 3);
        sparseIntArray.put(2131297011, 4);
        sparseIntArray.put(2131296406, 5);
        sparseIntArray.put(2131297018, 6);
        sparseIntArray.put(2131296985, 7);
        sparseIntArray.put(2131296984, 8);
        sparseIntArray.put(2131296405, 9);
        sparseIntArray.put(2131297020, 10);
        sparseIntArray.put(2131297012, 11);
        sparseIntArray.put(2131296404, 12);
        sparseIntArray.put(2131296513, 13);
        sparseIntArray.put(2131297010, 14);
        sparseIntArray.put(2131296394, 15);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1630dc(androidx.databinding.DataBindingComponent r20, android.view.View r21) {
        /*
            r19 = this;
            r2 = r19
            r1 = r21
            android.util.SparseIntArray r0 = p000.C1630dc.f4031s
            r3 = 16
            r15 = 0
            r14 = r20
            java.lang.Object[] r18 = androidx.databinding.ViewDataBinding.mapBindings(r14, r1, r3, r15, r0)
            r0 = 2
            r0 = r18[r0]
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            r0 = 15
            r0 = r18[r0]
            r5 = r0
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 12
            r0 = r18[r0]
            r6 = r0
            android.widget.Button r6 = (android.widget.Button) r6
            r0 = 9
            r0 = r18[r0]
            r7 = r0
            android.widget.Button r7 = (android.widget.Button) r7
            r0 = 5
            r0 = r18[r0]
            r8 = r0
            android.widget.Button r8 = (android.widget.Button) r8
            r0 = 13
            r0 = r18[r0]
            r9 = r0
            android.view.View r9 = (android.view.View) r9
            r0 = 8
            r0 = r18[r0]
            r10 = r0
            android.widget.TextView r10 = (android.widget.TextView) r10
            r0 = 7
            r0 = r18[r0]
            r11 = r0
            android.widget.TextView r11 = (android.widget.TextView) r11
            r0 = 14
            r0 = r18[r0]
            r12 = r0
            android.widget.TextView r12 = (android.widget.TextView) r12
            r0 = 4
            r0 = r18[r0]
            r13 = r0
            android.widget.TextView r13 = (android.widget.TextView) r13
            r0 = 11
            r0 = r18[r0]
            android.widget.TextView r0 = (android.widget.TextView) r0
            r14 = r0
            r0 = 6
            r0 = r18[r0]
            android.widget.TextView r0 = (android.widget.TextView) r0
            r3 = r15
            r15 = r0
            r0 = 3
            r0 = r18[r0]
            r16 = r0
            android.widget.TextView r16 = (android.widget.TextView) r16
            r0 = 10
            r0 = r18[r0]
            r17 = r0
            android.widget.TextView r17 = (android.widget.TextView) r17
            r0 = 0
            r3 = r0
            r0 = r19
            r1 = r20
            r2 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r0 = -1
            r2 = r19
            r2.f4034r = r0
            r0 = 0
            r0 = r18[r0]
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r2.f4032p = r0
            r1 = 0
            r0.setTag(r1)
            r0 = 1
            r0 = r18[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r2.f4033q = r0
            r0.setTag(r1)
            r0 = r21
            r2.setRootTag(r0)
            r19.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1630dc.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f4034r = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f4034r != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f4034r = 1L;
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
