package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: fa */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1684fa extends AbstractC1665ea {

    /* renamed from: p */
    public static final SparseIntArray f4182p;

    /* renamed from: m */
    public final ScrollView f4183m;

    /* renamed from: n */
    public final ConstraintLayout f4184n;

    /* renamed from: o */
    public long f4185o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f4182p = sparseIntArray;
        sparseIntArray.put(2131296353, 2);
        sparseIntArray.put(2131296424, 3);
        sparseIntArray.put(2131296963, 4);
        sparseIntArray.put(2131296537, 5);
        sparseIntArray.put(2131297022, 6);
        sparseIntArray.put(2131297021, 7);
        sparseIntArray.put(2131296958, 8);
        sparseIntArray.put(2131296957, 9);
        sparseIntArray.put(2131296371, 10);
        sparseIntArray.put(2131296372, 11);
        sparseIntArray.put(2131296375, 12);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C1684fa(androidx.databinding.DataBindingComponent r20, android.view.View r21) {
        /*
            r19 = this;
            r15 = r19
            r14 = r21
            android.util.SparseIntArray r0 = p000.C1684fa.f4182p
            r1 = 13
            r13 = 0
            r2 = r20
            java.lang.Object[] r16 = androidx.databinding.ViewDataBinding.mapBindings(r2, r14, r1, r13, r0)
            r0 = 2
            r0 = r16[r0]
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            r0 = 10
            r0 = r16[r0]
            r5 = r0
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 11
            r0 = r16[r0]
            r6 = r0
            android.widget.Button r6 = (android.widget.Button) r6
            r0 = 12
            r0 = r16[r0]
            r7 = r0
            android.widget.Button r7 = (android.widget.Button) r7
            r0 = 3
            r0 = r16[r0]
            r8 = r0
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r0 = 5
            r0 = r16[r0]
            r9 = r0
            fr.smoney.android.izly.ui.widget.CustomBorderSimpleEditText r9 = (fr.smoney.android.izly.p005ui.widget.CustomBorderSimpleEditText) r9
            r0 = 9
            r0 = r16[r0]
            r10 = r0
            android.widget.TextView r10 = (android.widget.TextView) r10
            r0 = 8
            r0 = r16[r0]
            r11 = r0
            android.widget.TextView r11 = (android.widget.TextView) r11
            r0 = 4
            r0 = r16[r0]
            r12 = r0
            android.widget.TextView r12 = (android.widget.TextView) r12
            r0 = 7
            r0 = r16[r0]
            r17 = r0
            android.widget.TextView r17 = (android.widget.TextView) r17
            r0 = 6
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
            r15.f4185o = r0
            r0 = 0
            r0 = r16[r0]
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r15.f4183m = r0
            r1 = 0
            r0.setTag(r1)
            r0 = 1
            r0 = r16[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r15.f4184n = r0
            r0.setTag(r1)
            r0 = r21
            r15.setRootTag(r0)
            r19.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1684fa.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f4185o = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f4185o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f4185o = 1L;
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
