package p000;

import android.util.SparseIntArray;
import androidx.databinding.ViewDataBinding;

/* renamed from: pc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2181pc extends AbstractC2028oc {

    /* renamed from: t */
    public static final ViewDataBinding.IncludedLayouts f6248t;

    /* renamed from: u */
    public static final SparseIntArray f6249u;

    /* renamed from: s */
    public long f6250s;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(19);
        f6248t = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"secure_transaction_view", "tiers_input_view", "sepa_bic_iban_layout", "transfer_layout", "register_credit_card_layout", "message_view", "view_submit_button"}, new int[]{3, 4, 5, 6, 7, 8, 9}, new int[]{2131493043, 2131493073, 2131493048, 2131493075, 2131493041, 2131492999, 2131493079});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f6249u = sparseIntArray;
        sparseIntArray.put(2131296920, 2);
        sparseIntArray.put(2131296449, 10);
        sparseIntArray.put(2131296381, 11);
        sparseIntArray.put(2131296558, 12);
        sparseIntArray.put(2131296813, 13);
        sparseIntArray.put(2131296907, 14);
        sparseIntArray.put(2131296350, 15);
        sparseIntArray.put(2131296835, 16);
        sparseIntArray.put(2131296366, 17);
        sparseIntArray.put(2131296648, 18);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2181pc(androidx.databinding.DataBindingComponent r24, android.view.View r25) {
        /*
            Method dump skipped, instructions count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2181pc.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6250s = 0L;
        }
        ViewDataBinding.executeBindingsOn(this.f5616l);
        ViewDataBinding.executeBindingsOn(this.f5620p);
        ViewDataBinding.executeBindingsOn(this.f5617m);
        ViewDataBinding.executeBindingsOn(this.f5622r);
        ViewDataBinding.executeBindingsOn(this.f5614j);
        ViewDataBinding.executeBindingsOn(this.f5613i);
        ViewDataBinding.executeBindingsOn(this.f5608c);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f6250s != 0) {
                return true;
            }
            return this.f5616l.hasPendingBindings() || this.f5620p.hasPendingBindings() || this.f5617m.hasPendingBindings() || this.f5622r.hasPendingBindings() || this.f5614j.hasPendingBindings() || this.f5613i.hasPendingBindings() || this.f5608c.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6250s = 128L;
        }
        this.f5616l.invalidateAll();
        this.f5620p.invalidateAll();
        this.f5617m.invalidateAll();
        this.f5622r.invalidateAll();
        this.f5614j.invalidateAll();
        this.f5613i.invalidateAll();
        this.f5608c.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                AbstractC1985mc abstractC1985mc = (AbstractC1985mc) obj;
                if (i2 == 0) {
                    synchronized (this) {
                        this.f6250s |= 1;
                    }
                    return true;
                }
                return false;
            case 1:
                AbstractC0616ac abstractC0616ac = (AbstractC0616ac) obj;
                if (i2 == 0) {
                    synchronized (this) {
                        this.f6250s |= 2;
                    }
                    return true;
                }
                return false;
            case 2:
                AbstractC0482Ub abstractC0482Ub = (AbstractC0482Ub) obj;
                if (i2 == 0) {
                    synchronized (this) {
                        this.f6250s |= 4;
                    }
                    return true;
                }
                return false;
            case 3:
                AbstractC0579Yb abstractC0579Yb = (AbstractC0579Yb) obj;
                if (i2 == 0) {
                    synchronized (this) {
                        this.f6250s |= 8;
                    }
                    return true;
                }
                return false;
            case 4:
                AbstractC0157Gb abstractC0157Gb = (AbstractC0157Gb) obj;
                if (i2 == 0) {
                    synchronized (this) {
                        this.f6250s |= 16;
                    }
                    return true;
                }
                return false;
            case 5:
                AbstractC2280uc abstractC2280uc = (AbstractC2280uc) obj;
                if (i2 == 0) {
                    synchronized (this) {
                        this.f6250s |= 32;
                    }
                    return true;
                }
                return false;
            case 6:
                AbstractC1944kc abstractC1944kc = (AbstractC1944kc) obj;
                if (i2 == 0) {
                    synchronized (this) {
                        this.f6250s |= 64;
                    }
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(InterfaceC1979m6 interfaceC1979m6) {
        super.setLifecycleOwner(interfaceC1979m6);
        this.f5616l.setLifecycleOwner(interfaceC1979m6);
        this.f5620p.setLifecycleOwner(interfaceC1979m6);
        this.f5617m.setLifecycleOwner(interfaceC1979m6);
        this.f5622r.setLifecycleOwner(interfaceC1979m6);
        this.f5614j.setLifecycleOwner(interfaceC1979m6);
        this.f5613i.setLifecycleOwner(interfaceC1979m6);
        this.f5608c.setLifecycleOwner(interfaceC1979m6);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        return true;
    }
}
