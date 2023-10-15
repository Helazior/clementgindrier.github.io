package p000;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

/* renamed from: Jb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0226Jb extends AbstractC0203Ib {

    /* renamed from: b */
    public long f710b;

    public C0226Jb(DataBindingComponent dataBindingComponent, View view) {
        super(dataBindingComponent, view, 0, (CheckedTextView) ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null)[0]);
        this.f710b = -1L;
        this.f661a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f710b = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f710b != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f710b = 1L;
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
