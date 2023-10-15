package p000;

import android.os.Bundle;
import androidx.savedstate.Recreator;
import java.util.Map;
import java.util.Objects;
import p000.AbstractC1917j6;
import p000.C1920j7;

/* renamed from: k7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1939k7 {

    /* renamed from: a */
    public final InterfaceC1959l7 f5384a;

    /* renamed from: b */
    public final C1920j7 f5385b = new C1920j7();

    public C1939k7(InterfaceC1959l7 interfaceC1959l7) {
        this.f5384a = interfaceC1959l7;
    }

    /* renamed from: a */
    public void m679a(Bundle bundle) {
        AbstractC1917j6 lifecycle = this.f5384a.getLifecycle();
        if (((C2002n6) lifecycle).f5539b == AbstractC1917j6.EnumC1919b.INITIALIZED) {
            lifecycle.mo575a(new Recreator(this.f5384a));
            final C1920j7 c1920j7 = this.f5385b;
            if (!c1920j7.f5348c) {
                if (bundle != null) {
                    c1920j7.f5347b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
                }
                lifecycle.mo575a(new InterfaceC1938k6() { // from class: androidx.savedstate.SavedStateRegistry$1
                    @Override // p000.InterfaceC1938k6
                    /* renamed from: d */
                    public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
                        if (enumC1918a == AbstractC1917j6.EnumC1918a.ON_START) {
                            Objects.requireNonNull(C1920j7.this);
                        } else if (enumC1918a == AbstractC1917j6.EnumC1918a.ON_STOP) {
                            Objects.requireNonNull(C1920j7.this);
                        }
                    }
                });
                c1920j7.f5348c = true;
                return;
            }
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
    }

    /* renamed from: b */
    public void m678b(Bundle bundle) {
        C1920j7 c1920j7 = this.f5385b;
        Objects.requireNonNull(c1920j7);
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = c1920j7.f5347b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        C1990n1<String, C1920j7.InterfaceC1922b>.C1994d m586b = c1920j7.f5346a.m586b();
        while (m586b.hasNext()) {
            Map.Entry entry = (Map.Entry) m586b.next();
            bundle2.putBundle((String) entry.getKey(), ((C1920j7.InterfaceC1922b) entry.getValue()).m699a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
