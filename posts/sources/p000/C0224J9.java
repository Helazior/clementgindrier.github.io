package p000;

import android.util.SparseIntArray;
import androidx.cardview.widget.CardView;

/* renamed from: J9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0224J9 extends AbstractC0201I9 {

    /* renamed from: g */
    public static final SparseIntArray f703g;

    /* renamed from: d */
    public final CardView f704d;

    /* renamed from: f */
    public long f705f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f703g = sparseIntArray;
        sparseIntArray.put(2131296626, 1);
        sparseIntArray.put(2131296997, 2);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0224J9(androidx.databinding.DataBindingComponent r10, android.view.View r11) {
        /*
            r9 = this;
            android.util.SparseIntArray r0 = p000.C0224J9.f703g
            r1 = 3
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r1 = 2
            r1 = r0[r1]
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6 = 0
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r3 = -1
            r9.f705f = r3
            r10 = 0
            r10 = r0[r10]
            androidx.cardview.widget.CardView r10 = (androidx.cardview.widget.CardView) r10
            r9.f704d = r10
            r10.setTag(r2)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0224J9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f705f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f705f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f705f = 1L;
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
