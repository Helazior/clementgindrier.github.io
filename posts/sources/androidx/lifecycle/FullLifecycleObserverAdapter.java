package androidx.lifecycle;

import p000.AbstractC1917j6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FullLifecycleObserverAdapter implements InterfaceC1938k6 {

    /* renamed from: a */
    public final InterfaceC1861h6 f3155a;

    /* renamed from: b */
    public final InterfaceC1938k6 f3156b;

    public FullLifecycleObserverAdapter(InterfaceC1861h6 interfaceC1861h6, InterfaceC1938k6 interfaceC1938k6) {
        this.f3155a = interfaceC1861h6;
        this.f3156b = interfaceC1938k6;
    }

    @Override // p000.InterfaceC1938k6
    /* renamed from: d */
    public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
        switch (enumC1918a.ordinal()) {
            case 0:
                this.f3155a.m778c(interfaceC1979m6);
                break;
            case 1:
                this.f3155a.m776f(interfaceC1979m6);
                break;
            case 2:
                this.f3155a.m780a(interfaceC1979m6);
                break;
            case 3:
                this.f3155a.m777e(interfaceC1979m6);
                break;
            case 4:
                this.f3155a.m775g(interfaceC1979m6);
                break;
            case 5:
                this.f3155a.m779b(interfaceC1979m6);
                break;
            case 6:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        InterfaceC1938k6 interfaceC1938k6 = this.f3156b;
        if (interfaceC1938k6 != null) {
            interfaceC1938k6.mo680d(interfaceC1979m6, enumC1918a);
        }
    }
}
