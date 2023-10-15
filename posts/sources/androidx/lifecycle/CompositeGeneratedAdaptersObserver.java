package androidx.lifecycle;

import p000.AbstractC1917j6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class CompositeGeneratedAdaptersObserver implements InterfaceC1938k6 {

    /* renamed from: a */
    public final InterfaceC1890i6[] f3154a;

    public CompositeGeneratedAdaptersObserver(InterfaceC1890i6[] interfaceC1890i6Arr) {
        this.f3154a = interfaceC1890i6Arr;
    }

    @Override // p000.InterfaceC1938k6
    /* renamed from: d */
    public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
        C2194q6 c2194q6 = new C2194q6();
        for (InterfaceC1890i6 interfaceC1890i6 : this.f3154a) {
            interfaceC1890i6.m743a(interfaceC1979m6, enumC1918a, false, c2194q6);
        }
        for (InterfaceC1890i6 interfaceC1890i62 : this.f3154a) {
            interfaceC1890i62.m743a(interfaceC1979m6, enumC1918a, true, c2194q6);
        }
    }
}
