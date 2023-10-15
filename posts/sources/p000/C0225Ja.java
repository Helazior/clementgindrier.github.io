package p000;

import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;

/* renamed from: Ja */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0225Ja extends AbstractC0202Ia {

    /* renamed from: m */
    public static final ViewDataBinding.IncludedLayouts f706m;

    /* renamed from: n */
    public static final SparseIntArray f707n;

    /* renamed from: k */
    public final ConstraintLayout f708k;

    /* renamed from: l */
    public long f709l;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        f706m = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"item_homepage_button", "item_homepage_button", "item_homepage_button", "item_homepage_state", "item_homepage_state", "item_homepage_state"}, new int[]{4, 5, 6, 7, 8, 9}, new int[]{2131492971, 2131492971, 2131492971, 2131492972, 2131492972, 2131492972});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f707n = sparseIntArray;
        sparseIntArray.put(2131297031, 1);
        sparseIntArray.put(2131297032, 2);
        sparseIntArray.put(2131296591, 3);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0225Ja(androidx.databinding.DataBindingComponent r18, android.view.View r19) {
        /*
            r17 = this;
            r13 = r17
            r14 = r19
            androidx.databinding.ViewDataBinding$IncludedLayouts r0 = p000.C0225Ja.f706m
            android.util.SparseIntArray r1 = p000.C0225Ja.f707n
            r2 = 10
            r3 = r18
            java.lang.Object[] r15 = androidx.databinding.ViewDataBinding.mapBindings(r3, r14, r2, r0, r1)
            r0 = 9
            r0 = r15[r0]
            r4 = r0
            mb r4 = (p000.AbstractC1984mb) r4
            r0 = 7
            r0 = r15[r0]
            r5 = r0
            mb r5 = (p000.AbstractC1984mb) r5
            r0 = 8
            r0 = r15[r0]
            r6 = r0
            mb r6 = (p000.AbstractC1984mb) r6
            r0 = 3
            r0 = r15[r0]
            r7 = r0
            android.view.View r7 = (android.view.View) r7
            r0 = 5
            r0 = r15[r0]
            r8 = r0
            kb r8 = (p000.AbstractC1943kb) r8
            r0 = 4
            r0 = r15[r0]
            r9 = r0
            kb r9 = (p000.AbstractC1943kb) r9
            r0 = 6
            r0 = r15[r0]
            r10 = r0
            kb r10 = (p000.AbstractC1943kb) r10
            r0 = 1
            r0 = r15[r0]
            r11 = r0
            android.view.View r11 = (android.view.View) r11
            r0 = 2
            r0 = r15[r0]
            r12 = r0
            android.view.View r12 = (android.view.View) r12
            r16 = 6
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = -1
            r13.f709l = r0
            mb r0 = r13.f652a
            r13.setContainedBinding(r0)
            mb r0 = r13.f653b
            r13.setContainedBinding(r0)
            mb r0 = r13.f654c
            r13.setContainedBinding(r0)
            kb r0 = r13.f656f
            r13.setContainedBinding(r0)
            kb r0 = r13.f657g
            r13.setContainedBinding(r0)
            kb r0 = r13.f658h
            r13.setContainedBinding(r0)
            r0 = 0
            r0 = r15[r0]
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            r13.f708k = r0
            r1 = 0
            r0.setTag(r1)
            r13.setRootTag(r14)
            r17.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0225Ja.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f709l = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f657g);
        ViewDataBinding.executeBindingsOn(this.f656f);
        ViewDataBinding.executeBindingsOn(this.f658h);
        ViewDataBinding.executeBindingsOn(this.f653b);
        ViewDataBinding.executeBindingsOn(this.f654c);
        ViewDataBinding.executeBindingsOn(this.f652a);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f709l != 0) {
                return true;
            }
            return this.f657g.hasPendingBindings() || this.f656f.hasPendingBindings() || this.f658h.hasPendingBindings() || this.f653b.hasPendingBindings() || this.f654c.hasPendingBindings() || this.f652a.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f709l = 64L;
        }
        this.f657g.invalidateAll();
        this.f656f.invalidateAll();
        this.f658h.invalidateAll();
        this.f653b.invalidateAll();
        this.f654c.invalidateAll();
        this.f652a.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            AbstractC1943kb abstractC1943kb = (AbstractC1943kb) obj;
            if (i2 == 0) {
                synchronized (this) {
                    this.f709l |= 1;
                }
                return true;
            }
            return false;
        } else if (i == 1) {
            AbstractC1984mb abstractC1984mb = (AbstractC1984mb) obj;
            if (i2 == 0) {
                synchronized (this) {
                    this.f709l |= 2;
                }
                return true;
            }
            return false;
        } else if (i == 2) {
            AbstractC1984mb abstractC1984mb2 = (AbstractC1984mb) obj;
            if (i2 == 0) {
                synchronized (this) {
                    this.f709l |= 4;
                }
                return true;
            }
            return false;
        } else if (i == 3) {
            AbstractC1943kb abstractC1943kb2 = (AbstractC1943kb) obj;
            if (i2 == 0) {
                synchronized (this) {
                    this.f709l |= 8;
                }
                return true;
            }
            return false;
        } else if (i == 4) {
            AbstractC1943kb abstractC1943kb3 = (AbstractC1943kb) obj;
            if (i2 == 0) {
                synchronized (this) {
                    this.f709l |= 16;
                }
                return true;
            }
            return false;
        } else if (i != 5) {
            return false;
        } else {
            AbstractC1984mb abstractC1984mb3 = (AbstractC1984mb) obj;
            if (i2 == 0) {
                synchronized (this) {
                    this.f709l |= 32;
                }
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(InterfaceC1979m6 interfaceC1979m6) {
        super.setLifecycleOwner(interfaceC1979m6);
        this.f657g.setLifecycleOwner(interfaceC1979m6);
        this.f656f.setLifecycleOwner(interfaceC1979m6);
        this.f658h.setLifecycleOwner(interfaceC1979m6);
        this.f653b.setLifecycleOwner(interfaceC1979m6);
        this.f654c.setLifecycleOwner(interfaceC1979m6);
        this.f652a.setLifecycleOwner(interfaceC1979m6);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }
}
