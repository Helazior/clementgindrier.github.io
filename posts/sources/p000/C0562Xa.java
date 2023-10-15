package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: Xa */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0562Xa extends AbstractC0541Wa {

    /* renamed from: c */
    public static final SparseIntArray f2010c;

    /* renamed from: a */
    public final ConstraintLayout f2011a;

    /* renamed from: b */
    public long f2012b;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f2010c = sparseIntArray;
        sparseIntArray.put(2131297042, 1);
        sparseIntArray.put(2131296756, 2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0562Xa(androidx.databinding.DataBindingComponent r10, android.view.View r11) {
        /*
            r9 = this;
            android.util.SparseIntArray r0 = p000.C0562Xa.f2010c
            r1 = 3
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r1, r2, r0)
            r1 = 2
            r1 = r0[r1]
            r7 = r1
            android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
            r1 = 1
            r1 = r0[r1]
            r8 = r1
            android.webkit.WebView r8 = (android.webkit.WebView) r8
            r6 = 0
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r3 = -1
            r9.f2012b = r3
            r10 = 0
            r10 = r0[r10]
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r9.f2011a = r10
            r10.setTag(r2)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0562Xa.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f2012b = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f2012b != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f2012b = 1L;
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
