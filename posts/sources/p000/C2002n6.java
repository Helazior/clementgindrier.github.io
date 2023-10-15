package p000;

import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p000.AbstractC1917j6;
import p000.C1990n1;

/* renamed from: n6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2002n6 extends AbstractC1917j6 {

    /* renamed from: c */
    public final WeakReference<InterfaceC1979m6> f5540c;

    /* renamed from: a */
    public C1974m1<InterfaceC1958l6, C2003a> f5538a = new C1974m1<>();

    /* renamed from: d */
    public int f5541d = 0;

    /* renamed from: e */
    public boolean f5542e = false;

    /* renamed from: f */
    public boolean f5543f = false;

    /* renamed from: g */
    public ArrayList<AbstractC1917j6.EnumC1919b> f5544g = new ArrayList<>();

    /* renamed from: b */
    public AbstractC1917j6.EnumC1919b f5539b = AbstractC1917j6.EnumC1919b.INITIALIZED;

    /* renamed from: n6$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2003a {

        /* renamed from: a */
        public AbstractC1917j6.EnumC1919b f5545a;

        /* renamed from: b */
        public InterfaceC1938k6 f5546b;

        public C2003a(InterfaceC1958l6 interfaceC1958l6, AbstractC1917j6.EnumC1919b enumC1919b) {
            InterfaceC1938k6 reflectiveGenericLifecycleObserver;
            Map<Class, Integer> map = C2175p6.f6231a;
            boolean z = interfaceC1958l6 instanceof InterfaceC1938k6;
            boolean z2 = interfaceC1958l6 instanceof InterfaceC1861h6;
            if (z && z2) {
                reflectiveGenericLifecycleObserver = new FullLifecycleObserverAdapter((InterfaceC1861h6) interfaceC1958l6, (InterfaceC1938k6) interfaceC1958l6);
            } else if (z2) {
                reflectiveGenericLifecycleObserver = new FullLifecycleObserverAdapter((InterfaceC1861h6) interfaceC1958l6, null);
            } else if (z) {
                reflectiveGenericLifecycleObserver = (InterfaceC1938k6) interfaceC1958l6;
            } else {
                Class<?> cls = interfaceC1958l6.getClass();
                if (C2175p6.m440c(cls) == 2) {
                    List<Constructor<? extends InterfaceC1890i6>> list = C2175p6.f6232b.get(cls);
                    if (list.size() == 1) {
                        reflectiveGenericLifecycleObserver = new SingleGeneratedAdapterObserver(C2175p6.m442a(list.get(0), interfaceC1958l6));
                    } else {
                        InterfaceC1890i6[] interfaceC1890i6Arr = new InterfaceC1890i6[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            interfaceC1890i6Arr[i] = C2175p6.m442a(list.get(i), interfaceC1958l6);
                        }
                        reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(interfaceC1890i6Arr);
                    }
                } else {
                    reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(interfaceC1958l6);
                }
            }
            this.f5546b = reflectiveGenericLifecycleObserver;
            this.f5545a = enumC1919b;
        }

        /* renamed from: a */
        public void m566a(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
            AbstractC1917j6.EnumC1919b m573c = C2002n6.m573c(enumC1918a);
            this.f5545a = C2002n6.m571e(this.f5545a, m573c);
            this.f5546b.mo680d(interfaceC1979m6, enumC1918a);
            this.f5545a = m573c;
        }
    }

    public C2002n6(InterfaceC1979m6 interfaceC1979m6) {
        this.f5540c = new WeakReference<>(interfaceC1979m6);
    }

    /* renamed from: c */
    public static AbstractC1917j6.EnumC1919b m573c(AbstractC1917j6.EnumC1918a enumC1918a) {
        int ordinal = enumC1918a.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    return AbstractC1917j6.EnumC1919b.RESUMED;
                }
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return AbstractC1917j6.EnumC1919b.DESTROYED;
                        }
                        throw new IllegalArgumentException("Unexpected event value " + enumC1918a);
                    }
                }
            }
            return AbstractC1917j6.EnumC1919b.STARTED;
        }
        return AbstractC1917j6.EnumC1919b.CREATED;
    }

    /* renamed from: e */
    public static AbstractC1917j6.EnumC1919b m571e(AbstractC1917j6.EnumC1919b enumC1919b, AbstractC1917j6.EnumC1919b enumC1919b2) {
        return (enumC1919b2 == null || enumC1919b2.compareTo(enumC1919b) >= 0) ? enumC1919b : enumC1919b2;
    }

    /* renamed from: i */
    public static AbstractC1917j6.EnumC1918a m567i(AbstractC1917j6.EnumC1919b enumC1919b) {
        int ordinal = enumC1919b.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return AbstractC1917j6.EnumC1918a.ON_CREATE;
        }
        if (ordinal != 2) {
            if (ordinal != 3) {
                if (ordinal != 4) {
                    throw new IllegalArgumentException("Unexpected state value " + enumC1919b);
                }
                throw new IllegalArgumentException();
            }
            return AbstractC1917j6.EnumC1918a.ON_RESUME;
        }
        return AbstractC1917j6.EnumC1918a.ON_START;
    }

    @Override // p000.AbstractC1917j6
    /* renamed from: a */
    public void mo575a(InterfaceC1958l6 interfaceC1958l6) {
        InterfaceC1979m6 interfaceC1979m6;
        AbstractC1917j6.EnumC1919b enumC1919b = this.f5539b;
        AbstractC1917j6.EnumC1919b enumC1919b2 = AbstractC1917j6.EnumC1919b.DESTROYED;
        if (enumC1919b != enumC1919b2) {
            enumC1919b2 = AbstractC1917j6.EnumC1919b.INITIALIZED;
        }
        C2003a c2003a = new C2003a(interfaceC1958l6, enumC1919b2);
        if (this.f5538a.mo584d(interfaceC1958l6, c2003a) == null && (interfaceC1979m6 = this.f5540c.get()) != null) {
            boolean z = this.f5541d != 0 || this.f5542e;
            AbstractC1917j6.EnumC1919b m574b = m574b(interfaceC1958l6);
            this.f5541d++;
            while (c2003a.f5545a.compareTo(m574b) < 0 && this.f5538a.f5479f.containsKey(interfaceC1958l6)) {
                this.f5544g.add(c2003a.f5545a);
                c2003a.m566a(interfaceC1979m6, m567i(c2003a.f5545a));
                m569g();
                m574b = m574b(interfaceC1958l6);
            }
            if (!z) {
                m568h();
            }
            this.f5541d--;
        }
    }

    /* renamed from: b */
    public final AbstractC1917j6.EnumC1919b m574b(InterfaceC1958l6 interfaceC1958l6) {
        C1974m1<InterfaceC1958l6, C2003a> c1974m1 = this.f5538a;
        AbstractC1917j6.EnumC1919b enumC1919b = null;
        C1990n1.C1993c<InterfaceC1958l6, C2003a> c1993c = c1974m1.f5479f.containsKey(interfaceC1958l6) ? c1974m1.f5479f.get(interfaceC1958l6).f5515d : null;
        AbstractC1917j6.EnumC1919b enumC1919b2 = c1993c != null ? c1993c.f5513b.f5545a : null;
        if (!this.f5544g.isEmpty()) {
            ArrayList<AbstractC1917j6.EnumC1919b> arrayList = this.f5544g;
            enumC1919b = arrayList.get(arrayList.size() - 1);
        }
        return m571e(m571e(this.f5539b, enumC1919b2), enumC1919b);
    }

    /* renamed from: d */
    public void m572d(AbstractC1917j6.EnumC1918a enumC1918a) {
        m570f(m573c(enumC1918a));
    }

    /* renamed from: f */
    public final void m570f(AbstractC1917j6.EnumC1919b enumC1919b) {
        if (this.f5539b == enumC1919b) {
            return;
        }
        this.f5539b = enumC1919b;
        if (!this.f5542e && this.f5541d == 0) {
            this.f5542e = true;
            m568h();
            this.f5542e = false;
            return;
        }
        this.f5543f = true;
    }

    /* renamed from: g */
    public final void m569g() {
        ArrayList<AbstractC1917j6.EnumC1919b> arrayList = this.f5544g;
        arrayList.remove(arrayList.size() - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0132 A[SYNTHETIC] */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m568h() {
        /*
            Method dump skipped, instructions count: 317
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2002n6.m568h():void");
    }
}
