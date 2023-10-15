package p000;

import android.util.SparseIntArray;
import android.widget.LinearLayout;

/* renamed from: bb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0975bb extends AbstractC0615ab {

    /* renamed from: c */
    public static final SparseIntArray f3738c;

    /* renamed from: a */
    public final LinearLayout f3739a;

    /* renamed from: b */
    public long f3740b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f3738c = sparseIntArray;
        sparseIntArray.put(2131296644, 1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0975bb(androidx.databinding.DataBindingComponent r7, android.view.View r8) {
        /*
            r6 = this;
            android.util.SparseIntArray r0 = p000.C0975bb.f3738c
            r1 = 2
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r7, r8, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            android.widget.ListView r1 = (android.widget.ListView) r1
            r3 = 0
            r6.<init>(r7, r8, r3, r1)
            r4 = -1
            r6.f3740b = r4
            r7 = r0[r3]
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            r6.f3739a = r7
            r7.setTag(r2)
            r6.setRootTag(r8)
            r6.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0975bb.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f3740b = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f3740b != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f3740b = 1L;
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
