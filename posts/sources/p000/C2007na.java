package p000;

import android.util.SparseIntArray;
import android.widget.LinearLayout;

/* renamed from: na */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2007na extends AbstractC1983ma {

    /* renamed from: j */
    public static final SparseIntArray f5550j;

    /* renamed from: h */
    public final LinearLayout f5551h;

    /* renamed from: i */
    public long f5552i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5550j = sparseIntArray;
        sparseIntArray.put(2131296838, 1);
        sparseIntArray.put(2131296841, 2);
        sparseIntArray.put(2131296842, 3);
        sparseIntArray.put(2131296839, 4);
        sparseIntArray.put(2131296837, 5);
        sparseIntArray.put(2131296834, 6);
        sparseIntArray.put(2131296373, 7);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2007na(androidx.databinding.DataBindingComponent r16, android.view.View r17) {
        /*
            r15 = this;
            r11 = r15
            r12 = r17
            android.util.SparseIntArray r0 = p000.C2007na.f5550j
            r1 = 8
            r13 = 0
            r2 = r16
            java.lang.Object[] r14 = androidx.databinding.ViewDataBinding.mapBindings(r2, r12, r1, r13, r0)
            r0 = 7
            r0 = r14[r0]
            r4 = r0
            android.widget.Button r4 = (android.widget.Button) r4
            r0 = 6
            r0 = r14[r0]
            r5 = r0
            android.widget.Button r5 = (android.widget.Button) r5
            r0 = 5
            r0 = r14[r0]
            r6 = r0
            android.widget.Button r6 = (android.widget.Button) r6
            r0 = 1
            r0 = r14[r0]
            r7 = r0
            android.widget.Button r7 = (android.widget.Button) r7
            r0 = 4
            r0 = r14[r0]
            r8 = r0
            android.widget.Button r8 = (android.widget.Button) r8
            r0 = 2
            r0 = r14[r0]
            r9 = r0
            android.widget.Button r9 = (android.widget.Button) r9
            r0 = 3
            r0 = r14[r0]
            r10 = r0
            android.widget.Button r10 = (android.widget.Button) r10
            r3 = 0
            r0 = r15
            r1 = r16
            r2 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = -1
            r11.f5552i = r0
            r0 = 0
            r0 = r14[r0]
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r11.f5551h = r0
            r0.setTag(r13)
            r15.setRootTag(r12)
            r15.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2007na.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f5552i = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f5552i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f5552i = 1L;
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
