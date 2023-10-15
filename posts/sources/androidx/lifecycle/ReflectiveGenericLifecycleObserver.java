package androidx.lifecycle;

import p000.AbstractC1917j6;
import p000.C1837g6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ReflectiveGenericLifecycleObserver implements InterfaceC1938k6 {

    /* renamed from: a */
    public final Object f3172a;

    /* renamed from: b */
    public final C1837g6.C1838a f3173b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f3172a = obj;
        this.f3173b = C1837g6.f5075c.m798b(obj.getClass());
    }

    @Override // p000.InterfaceC1938k6
    /* renamed from: d */
    public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
        C1837g6.C1838a c1838a = this.f3173b;
        Object obj = this.f3172a;
        C1837g6.C1838a.m796a(c1838a.f5078a.get(enumC1918a), interfaceC1979m6, enumC1918a, obj);
        C1837g6.C1838a.m796a(c1838a.f5078a.get(AbstractC1917j6.EnumC1918a.ON_ANY), interfaceC1979m6, enumC1918a, obj);
    }
}
