package p000;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Objects;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: B6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0039B6 extends AbstractC0020A6 {

    /* renamed from: a */
    public final InterfaceC1979m6 f191a;

    /* renamed from: b */
    public final C0041b f192b;

    /* renamed from: B6$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0040a<D> extends C2212r6<D> {
        @Override // androidx.lifecycle.LiveData
        /* renamed from: e */
        public void mo1419e() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        /* renamed from: f */
        public void mo1418f() {
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        /* renamed from: g */
        public void mo1417g(InterfaceC2233s6<? super D> interfaceC2233s6) {
            super.mo1417g(interfaceC2233s6);
        }

        @Override // p000.C2212r6
        /* renamed from: h */
        public void mo419h(D d) {
            super.mo419h(d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(0);
            sb.append(" : ");
            LayoutInflater$Factory2C0000A.C0010h.m2643e(null, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: B6$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0041b extends AbstractC2292v6 {

        /* renamed from: c */
        public static final InterfaceC2323w6 f193c = new C0042a();

        /* renamed from: b */
        public C0127F1<C0040a> f194b = new C0127F1<>(10);

        /* renamed from: B6$b$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0042a implements InterfaceC2323w6 {
            /* renamed from: a */
            public <T extends AbstractC2292v6> T m2557a(Class<T> cls) {
                return new C0041b();
            }
        }

        @Override // p000.AbstractC2292v6
        /* renamed from: a */
        public void mo281a() {
            if (this.f194b.m2448i() <= 0) {
                C0127F1<C0040a> c0127f1 = this.f194b;
                int i = c0127f1.f436d;
                Object[] objArr = c0127f1.f435c;
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = null;
                }
                c0127f1.f436d = 0;
                c0127f1.f433a = false;
                return;
            }
            Objects.requireNonNull(this.f194b.m2447j(0));
            throw null;
        }
    }

    public C0039B6(InterfaceC1979m6 interfaceC1979m6, C2385y6 c2385y6) {
        AbstractC2292v6 m2557a;
        this.f191a = interfaceC1979m6;
        InterfaceC2323w6 interfaceC2323w6 = C0041b.f193c;
        String canonicalName = C0041b.class.getCanonicalName();
        if (canonicalName != null) {
            String m266e = outline.m266e("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            AbstractC2292v6 abstractC2292v6 = c2385y6.f6876a.get(m266e);
            if (!C0041b.class.isInstance(abstractC2292v6)) {
                if (interfaceC2323w6 instanceof AbstractC2350x6) {
                    m2557a = ((AbstractC2350x6) interfaceC2323w6).m131a(m266e, C0041b.class);
                } else {
                    m2557a = ((C0041b.C0042a) interfaceC2323w6).m2557a(C0041b.class);
                }
                abstractC2292v6 = m2557a;
                AbstractC2292v6 put = c2385y6.f6876a.put(m266e, abstractC2292v6);
                if (put != null) {
                    put.mo281a();
                }
            }
            this.f192b = (C0041b) abstractC2292v6;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // p000.AbstractC0020A6
    @Deprecated
    /* renamed from: a */
    public void mo2558a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        C0041b c0041b = this.f192b;
        if (c0041b.f194b.m2448i() > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (c0041b.f194b.m2448i() <= 0) {
                return;
            }
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(c0041b.f194b.m2451f(0));
            printWriter.print(": ");
            printWriter.println(c0041b.f194b.m2447j(0).toString());
            printWriter.print(str2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str2);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            throw null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        LayoutInflater$Factory2C0000A.C0010h.m2643e(this.f191a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
