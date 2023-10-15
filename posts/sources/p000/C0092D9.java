package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;

/* renamed from: D9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0092D9 extends AbstractC0066C9 {

    /* renamed from: g */
    public static final SparseIntArray f353g;

    /* renamed from: c */
    public final ScrollView f354c;

    /* renamed from: d */
    public final ConstraintLayout f355d;

    /* renamed from: f */
    public long f356f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f353g = sparseIntArray;
        sparseIntArray.put(2131296917, 2);
        sparseIntArray.put(2131296790, 3);
        sparseIntArray.put(2131296440, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0092D9(androidx.databinding.DataBindingComponent r11, android.view.View r12) {
        /*
            r10 = this;
            android.util.SparseIntArray r0 = p000.C0092D9.f353g
            r1 = 5
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r1, r2, r0)
            r1 = 4
            r1 = r0[r1]
            r7 = r1
            fr.smoney.android.izly.ui.widget.CustomIconTextView r7 = (fr.smoney.android.izly.p005ui.widget.CustomIconTextView) r7
            r1 = 3
            r1 = r0[r1]
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            r1 = 2
            r1 = r0[r1]
            r9 = r1
            android.view.View r9 = (android.view.View) r9
            r6 = 0
            r3 = r10
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r3 = -1
            r10.f356f = r3
            r11 = 0
            r11 = r0[r11]
            android.widget.ScrollView r11 = (android.widget.ScrollView) r11
            r10.f354c = r11
            r11.setTag(r2)
            r11 = 1
            r11 = r0[r11]
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            r10.f355d = r11
            r11.setTag(r2)
            r10.setRootTag(r12)
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0092D9.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f356f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f356f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f356f = 1L;
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
