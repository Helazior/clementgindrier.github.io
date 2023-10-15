package p000;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: n4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1999n4 {

    /* renamed from: a */
    public static final C0053C1<String, Typeface> f5526a = new C0053C1<>(16);

    /* renamed from: b */
    public static final ExecutorService f5527b;

    /* renamed from: c */
    public static final Object f5528c;

    /* renamed from: d */
    public static final C0101E1<String, ArrayList<InterfaceC2365y4<C2000a>>> f5529d;

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new ThreadFactoryC2209r4("fonts-androidx", 10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f5527b = threadPoolExecutor;
        f5528c = new Object();
        f5529d = new C0101E1<>();
    }

    /* renamed from: a */
    public static C2000a m576a(String str, Context context, C1886i4 c1886i4, int i) {
        int i2;
        Typeface typeface = f5526a.get(str);
        if (typeface != null) {
            return new C2000a(typeface);
        }
        try {
            C2020o4 m781a = C1858h4.m781a(context, c1886i4, null);
            int i3 = m781a.f5586a;
            int i4 = 1;
            if (i3 != 0) {
                if (i3 == 1) {
                    i2 = -2;
                }
                i2 = -3;
            } else {
                C2171p4[] c2171p4Arr = m781a.f5587b;
                if (c2171p4Arr != null && c2171p4Arr.length != 0) {
                    for (C2171p4 c2171p4 : c2171p4Arr) {
                        int i5 = c2171p4.f6220e;
                        if (i5 != 0) {
                            if (i5 >= 0) {
                                i2 = i5;
                            }
                            i2 = -3;
                        }
                    }
                    i4 = 0;
                }
                i2 = i4;
            }
            if (i2 != 0) {
                return new C2000a(i2);
            }
            Typeface mo2128b = C0213J3.f678a.mo2128b(context, null, m781a.f5587b, i);
            if (mo2128b != null) {
                f5526a.put(str, mo2128b);
                return new C2000a(mo2128b);
            }
            return new C2000a(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C2000a(-1);
        }
    }

    /* renamed from: n4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C2000a {

        /* renamed from: a */
        public final Typeface f5530a;

        /* renamed from: b */
        public final int f5531b;

        public C2000a(int i) {
            this.f5530a = null;
            this.f5531b = i;
        }

        @SuppressLint({"WrongConstant"})
        public C2000a(Typeface typeface) {
            this.f5530a = typeface;
            this.f5531b = 0;
        }
    }
}
