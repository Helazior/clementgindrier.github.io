package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: Na */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0316Na extends AbstractC0293Ma {

    /* renamed from: m */
    public static final SparseIntArray f1041m;

    /* renamed from: k */
    public final ConstraintLayout f1042k;

    /* renamed from: l */
    public long f1043l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f1041m = sparseIntArray;
        sparseIntArray.put(2131297005, 1);
        sparseIntArray.put(2131297004, 2);
        sparseIntArray.put(2131297009, 3);
        sparseIntArray.put(2131297008, 4);
        sparseIntArray.put(2131297007, 5);
        sparseIntArray.put(2131297006, 6);
        sparseIntArray.put(2131297003, 7);
        sparseIntArray.put(2131297002, 8);
        sparseIntArray.put(2131296399, 9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0316Na(androidx.databinding.DataBindingComponent r18, android.view.View r19) {
        /*
            r17 = this;
            r13 = r17
            r14 = r19
            android.util.SparseIntArray r0 = p000.C0316Na.f1041m
            r1 = 10
            r15 = 0
            r2 = r18
            java.lang.Object[] r16 = androidx.databinding.ViewDataBinding.mapBindings(r2, r14, r1, r15, r0)
            r0 = 9
            r0 = r16[r0]
            r4 = r0
            android.widget.Button r4 = (android.widget.Button) r4
            r0 = 8
            r0 = r16[r0]
            r5 = r0
            android.widget.TextView r5 = (android.widget.TextView) r5
            r0 = 7
            r0 = r16[r0]
            r6 = r0
            android.widget.TextView r6 = (android.widget.TextView) r6
            r0 = 2
            r0 = r16[r0]
            r7 = r0
            android.widget.TextView r7 = (android.widget.TextView) r7
            r0 = 1
            r0 = r16[r0]
            r8 = r0
            android.widget.TextView r8 = (android.widget.TextView) r8
            r0 = 6
            r0 = r16[r0]
            r9 = r0
            android.widget.TextView r9 = (android.widget.TextView) r9
            r0 = 5
            r0 = r16[r0]
            r10 = r0
            android.widget.TextView r10 = (android.widget.TextView) r10
            r0 = 4
            r0 = r16[r0]
            r11 = r0
            android.widget.TextView r11 = (android.widget.TextView) r11
            r0 = 3
            r0 = r16[r0]
            r12 = r0
            android.widget.TextView r12 = (android.widget.TextView) r12
            r3 = 0
            r0 = r17
            r1 = r18
            r2 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = -1
            r13.f1043l = r0
            r0 = 0
            r0 = r16[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r13.f1042k = r0
            r0.setTag(r15)
            r13.setRootTag(r14)
            r17.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0316Na.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f1043l = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f1043l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f1043l = 1L;
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
