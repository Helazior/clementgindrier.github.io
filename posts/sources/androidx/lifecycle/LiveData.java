package androidx.lifecycle;

import java.util.Map;
import p000.AbstractC1917j6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class LiveData<T> {

    /* renamed from: i */
    public static final Object f3157i = new Object();

    /* renamed from: a */
    public final Object f3158a = new Object();

    /* renamed from: b */
    public C1990n1<InterfaceC2233s6<? super T>, LiveData<T>.AbstractC0816a> f3159b = new C1990n1<>();

    /* renamed from: c */
    public int f3160c = 0;

    /* renamed from: d */
    public volatile Object f3161d;

    /* renamed from: e */
    public volatile Object f3162e;

    /* renamed from: f */
    public int f3163f;

    /* renamed from: g */
    public boolean f3164g;

    /* renamed from: h */
    public boolean f3165h;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class LifecycleBoundObserver extends LiveData<T>.AbstractC0816a implements Object {

        /* renamed from: e */
        public final InterfaceC1979m6 f3166e;

        public LifecycleBoundObserver(InterfaceC1979m6 interfaceC1979m6, InterfaceC2233s6<? super T> interfaceC2233s6) {
            super(interfaceC2233s6);
            this.f3166e = interfaceC1979m6;
        }

        /* renamed from: d */
        public void m1416d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
            if (((C2002n6) this.f3166e.getLifecycle()).f5539b == AbstractC1917j6.EnumC1919b.DESTROYED) {
                LiveData.this.mo1417g(this.f3168a);
            } else {
                m1415h(mo1412k());
            }
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0816a
        /* renamed from: i */
        public void mo1414i() {
            ((C2002n6) this.f3166e.getLifecycle()).f5538a.mo583e(this);
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0816a
        /* renamed from: j */
        public boolean mo1413j(InterfaceC1979m6 interfaceC1979m6) {
            return this.f3166e == interfaceC1979m6;
        }

        @Override // androidx.lifecycle.LiveData.AbstractC0816a
        /* renamed from: k */
        public boolean mo1412k() {
            return ((C2002n6) this.f3166e.getLifecycle()).f5539b.compareTo(AbstractC1917j6.EnumC1919b.STARTED) >= 0;
        }
    }

    /* renamed from: androidx.lifecycle.LiveData$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public abstract class AbstractC0816a {

        /* renamed from: a */
        public final InterfaceC2233s6<? super T> f3168a;

        /* renamed from: b */
        public boolean f3169b;

        /* renamed from: c */
        public int f3170c = -1;

        public AbstractC0816a(InterfaceC2233s6<? super T> interfaceC2233s6) {
            this.f3168a = interfaceC2233s6;
        }

        /* renamed from: h */
        public void m1415h(boolean z) {
            if (z == this.f3169b) {
                return;
            }
            this.f3169b = z;
            LiveData liveData = LiveData.this;
            int i = liveData.f3160c;
            boolean z2 = i == 0;
            liveData.f3160c = i + (z ? 1 : -1);
            if (z2 && z) {
                liveData.mo1419e();
            }
            LiveData liveData2 = LiveData.this;
            if (liveData2.f3160c == 0 && !this.f3169b) {
                liveData2.mo1418f();
            }
            if (this.f3169b) {
                LiveData.this.m1421c(this);
            }
        }

        /* renamed from: i */
        public void mo1414i() {
        }

        /* renamed from: j */
        public boolean mo1413j(InterfaceC1979m6 interfaceC1979m6) {
            return false;
        }

        /* renamed from: k */
        public abstract boolean mo1412k();
    }

    public LiveData() {
        Object obj = f3157i;
        this.f3161d = obj;
        this.f3162e = obj;
        this.f3163f = -1;
    }

    /* renamed from: a */
    public static void m1423a(String str) {
        if (C1908j1.m722b().f5311a.mo635a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    /* renamed from: b */
    public final void m1422b(LiveData<T>.AbstractC0816a abstractC0816a) {
        if (abstractC0816a.f3169b) {
            if (!abstractC0816a.mo1412k()) {
                abstractC0816a.m1415h(false);
                return;
            }
            int i = abstractC0816a.f3170c;
            int i2 = this.f3163f;
            if (i >= i2) {
                return;
            }
            abstractC0816a.f3170c = i2;
            abstractC0816a.f3168a.onChanged((Object) this.f3161d);
        }
    }

    /* renamed from: c */
    public void m1421c(LiveData<T>.AbstractC0816a abstractC0816a) {
        if (this.f3164g) {
            this.f3165h = true;
            return;
        }
        this.f3164g = true;
        do {
            this.f3165h = false;
            if (abstractC0816a != null) {
                m1422b(abstractC0816a);
                abstractC0816a = null;
            } else {
                C1990n1<InterfaceC2233s6<? super T>, LiveData<T>.AbstractC0816a>.C1994d m586b = this.f3159b.m586b();
                while (m586b.hasNext()) {
                    m1422b((AbstractC0816a) ((Map.Entry) m586b.next()).getValue());
                    if (this.f3165h) {
                        break;
                    }
                }
            }
        } while (this.f3165h);
        this.f3164g = false;
    }

    /* renamed from: d */
    public void m1420d(InterfaceC1979m6 interfaceC1979m6, InterfaceC2233s6<? super T> interfaceC2233s6) {
        m1423a("observe");
        if (((C2002n6) interfaceC1979m6.getLifecycle()).f5539b == AbstractC1917j6.EnumC1919b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(interfaceC1979m6, interfaceC2233s6);
        LiveData<T>.AbstractC0816a mo584d = this.f3159b.mo584d(interfaceC2233s6, lifecycleBoundObserver);
        if (mo584d != null && !mo584d.mo1413j(interfaceC1979m6)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (mo584d != null) {
            return;
        }
        interfaceC1979m6.getLifecycle().mo575a(lifecycleBoundObserver);
    }

    /* renamed from: e */
    public void mo1419e() {
    }

    /* renamed from: f */
    public void mo1418f() {
    }

    /* renamed from: g */
    public void mo1417g(InterfaceC2233s6<? super T> interfaceC2233s6) {
        m1423a("removeObserver");
        LiveData<T>.AbstractC0816a mo583e = this.f3159b.mo583e(interfaceC2233s6);
        if (mo583e == null) {
            return;
        }
        mo583e.mo1414i();
        mo583e.m1415h(false);
    }
}
