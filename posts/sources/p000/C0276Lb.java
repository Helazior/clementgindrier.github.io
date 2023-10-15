package p000;

import android.util.SparseIntArray;
import android.widget.ScrollView;

/* renamed from: Lb */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0276Lb extends AbstractC0254Kb {

    /* renamed from: L */
    public static final SparseIntArray f914L;

    /* renamed from: J */
    public final ScrollView f915J;

    /* renamed from: K */
    public long f916K;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f914L = sparseIntArray;
        sparseIntArray.put(2131296766, 1);
        sparseIntArray.put(2131296651, 2);
        sparseIntArray.put(2131296947, 3);
        sparseIntArray.put(2131296650, 4);
        sparseIntArray.put(2131296946, 5);
        sparseIntArray.put(2131296652, 6);
        sparseIntArray.put(2131296948, 7);
        sparseIntArray.put(2131296649, 8);
        sparseIntArray.put(2131296945, 9);
        sparseIntArray.put(2131296417, 10);
        sparseIntArray.put(2131296419, 11);
        sparseIntArray.put(2131296418, 12);
        sparseIntArray.put(2131296836, 13);
        sparseIntArray.put(2131296420, 14);
        sparseIntArray.put(2131296373, 15);
        sparseIntArray.put(2131296961, 16);
        sparseIntArray.put(2131296960, 17);
        sparseIntArray.put(2131296623, 18);
        sparseIntArray.put(2131296964, 19);
        sparseIntArray.put(2131296966, 20);
        sparseIntArray.put(2131296965, 21);
        sparseIntArray.put(2131297016, 22);
        sparseIntArray.put(2131297015, 23);
        sparseIntArray.put(2131296971, 24);
        sparseIntArray.put(2131296970, 25);
        sparseIntArray.put(2131296311, 26);
        sparseIntArray.put(2131296317, 27);
        sparseIntArray.put(2131296306, 28);
        sparseIntArray.put(2131296314, 29);
        sparseIntArray.put(2131296316, 30);
        sparseIntArray.put(2131296309, 31);
        sparseIntArray.put(2131296315, 32);
        sparseIntArray.put(2131296318, 33);
        sparseIntArray.put(2131296308, 34);
        sparseIntArray.put(2131296313, 35);
        sparseIntArray.put(2131296307, 36);
        sparseIntArray.put(2131296312, 37);
        sparseIntArray.put(2131296310, 38);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C0276Lb(androidx.databinding.DataBindingComponent r44, android.view.View r45) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0276Lb.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f916K = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f916K != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f916K = 1L;
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
