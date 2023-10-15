package p000;

import javax.annotation.Nullable;

/* renamed from: ze */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2410ze {
    @Nullable

    /* renamed from: a */
    public static C2393ye f6936a;

    /* renamed from: b */
    public static long f6937b;

    /* renamed from: a */
    public static void m1a(C2393ye c2393ye) {
        if (c2393ye.f6893f == null && c2393ye.f6894g == null) {
            if (c2393ye.f6891d) {
                return;
            }
            synchronized (C2410ze.class) {
                long j = f6937b + 8192;
                if (j > 65536) {
                    return;
                }
                f6937b = j;
                c2393ye.f6893f = f6936a;
                c2393ye.f6890c = 0;
                c2393ye.f6889b = 0;
                f6936a = c2393ye;
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /* renamed from: b */
    public static C2393ye m0b() {
        synchronized (C2410ze.class) {
            C2393ye c2393ye = f6936a;
            if (c2393ye != null) {
                f6936a = c2393ye.f6893f;
                c2393ye.f6893f = null;
                f6937b -= 8192;
                return c2393ye;
            }
            return new C2393ye();
        }
    }
}
