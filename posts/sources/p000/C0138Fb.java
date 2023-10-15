package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: Fb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0138Fb extends AbstractC0118Eb {

    /* renamed from: n */
    public static final SparseIntArray f451n;

    /* renamed from: k */
    public final ScrollView f452k;

    /* renamed from: l */
    public final ConstraintLayout f453l;

    /* renamed from: m */
    public long f454m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f451n = sparseIntArray;
        sparseIntArray.put(2131296763, 2);
        sparseIntArray.put(2131296442, 3);
        sparseIntArray.put(2131296762, 4);
        sparseIntArray.put(2131296988, 5);
        sparseIntArray.put(2131296542, 6);
        sparseIntArray.put(2131296992, 7);
        sparseIntArray.put(2131296547, 8);
        sparseIntArray.put(2131296375, 9);
        sparseIntArray.put(2131296727, 10);
        sparseIntArray.put(2131296724, 11);
        sparseIntArray.put(2131296962, 12);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0138Fb(androidx.databinding.DataBindingComponent r20, android.view.View r21) {
        /*
            r19 = this;
            r15 = r19
            r14 = r21
            android.util.SparseIntArray r0 = p000.C0138Fb.f451n
            r1 = 13
            r13 = 0
            r2 = r20
            java.lang.Object[] r16 = androidx.databinding.ViewDataBinding.mapBindings(r2, r14, r1, r13, r0)
            r0 = 9
            r0 = r16[r0]
            r4 = r0
            android.widget.Button r4 = (android.widget.Button) r4
            r0 = 3
            r0 = r16[r0]
            r5 = r0
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            r0 = 6
            r0 = r16[r0]
            r6 = r0
            android.widget.EditText r6 = (android.widget.EditText) r6
            r0 = 8
            r0 = r16[r0]
            r7 = r0
            android.widget.EditText r7 = (android.widget.EditText) r7
            r0 = 11
            r0 = r16[r0]
            r8 = r0
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r0 = 10
            r0 = r16[r0]
            r9 = r0
            android.widget.TextView r9 = (android.widget.TextView) r9
            r0 = 4
            r0 = r16[r0]
            r10 = r0
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r0 = 2
            r0 = r16[r0]
            r11 = r0
            android.view.View r11 = (android.view.View) r11
            r0 = 12
            r0 = r16[r0]
            r12 = r0
            android.widget.TextView r12 = (android.widget.TextView) r12
            r0 = 5
            r0 = r16[r0]
            r17 = r0
            android.widget.TextView r17 = (android.widget.TextView) r17
            r0 = 7
            r0 = r16[r0]
            r18 = r0
            android.widget.TextView r18 = (android.widget.TextView) r18
            r3 = 0
            r0 = r19
            r1 = r20
            r2 = r21
            r13 = r17
            r14 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = -1
            r15.f454m = r0
            r0 = 0
            r0 = r16[r0]
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r15.f452k = r0
            r1 = 0
            r0.setTag(r1)
            r0 = 1
            r0 = r16[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r15.f453l = r0
            r0.setTag(r1)
            r0 = r21
            r15.setRootTag(r0)
            r19.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0138Fb.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f454m = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f454m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f454m = 1L;
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
