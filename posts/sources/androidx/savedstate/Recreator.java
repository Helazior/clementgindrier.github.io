package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import p000.AbstractC1917j6;
import p000.C1920j7;

@SuppressLint({"RestrictedApi"})
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Recreator implements InterfaceC1938k6 {

    /* renamed from: a */
    public final InterfaceC1959l7 f3333a;

    public Recreator(InterfaceC1959l7 interfaceC1959l7) {
        this.f3333a = interfaceC1959l7;
    }

    @Override // p000.InterfaceC1938k6
    /* renamed from: d */
    public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
        Class cls;
        if (enumC1918a == AbstractC1917j6.EnumC1918a.ON_CREATE) {
            ((C2002n6) interfaceC1979m6.getLifecycle()).f5538a.mo583e(this);
            C1920j7 savedStateRegistry = this.f3333a.getSavedStateRegistry();
            if (savedStateRegistry.f5348c) {
                Bundle bundle = savedStateRegistry.f5347b;
                Bundle bundle2 = null;
                if (bundle != null) {
                    Bundle bundle3 = bundle.getBundle("androidx.savedstate.Restarter");
                    savedStateRegistry.f5347b.remove("androidx.savedstate.Restarter");
                    if (savedStateRegistry.f5347b.isEmpty()) {
                        savedStateRegistry.f5347b = null;
                    }
                    bundle2 = bundle3;
                }
                if (bundle2 == null) {
                    return;
                }
                ArrayList<String> stringArrayList = bundle2.getStringArrayList("classes_to_restore");
                if (stringArrayList != null) {
                    Iterator<String> it = stringArrayList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        try {
                            try {
                                Constructor declaredConstructor = Class.forName(next, false, Recreator.class.getClassLoader()).asSubclass(C1920j7.InterfaceC1921a.class).getDeclaredConstructor(new Class[0]);
                                declaredConstructor.setAccessible(true);
                                try {
                                    ((C1920j7.InterfaceC1921a) declaredConstructor.newInstance(new Object[0])).m700a(this.f3333a);
                                } catch (Exception e) {
                                    throw new RuntimeException(outline.m266e("Failed to instantiate ", next), e);
                                }
                            } catch (NoSuchMethodException e2) {
                                StringBuilder m253r = outline.m253r("Class");
                                m253r.append(cls.getSimpleName());
                                m253r.append(" must have default constructor in order to be automatically recreated");
                                throw new IllegalStateException(m253r.toString(), e2);
                            }
                        } catch (ClassNotFoundException e3) {
                            throw new RuntimeException(outline.m265f("Class ", next, " wasn't found"), e3);
                        }
                    }
                    return;
                }
                throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            }
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        throw new AssertionError("Next event must be ON_CREATE");
    }
}
