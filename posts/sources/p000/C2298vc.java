package p000;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.IconButton;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;

/* renamed from: vc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2297vc extends AbstractC2280uc {

    /* renamed from: b */
    public long f6710b;

    public C2297vc(DataBindingComponent dataBindingComponent, View view) {
        super(dataBindingComponent, view, 0, (IconButton) ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null)[0]);
        this.f6710b = -1L;
        this.f6633a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f6710b = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f6710b != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f6710b = 1L;
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
