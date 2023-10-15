package p000;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: Q3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0369Q3 {
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: a */
    public ConcurrentHashMap<Long, C0017A3> f1263a = new ConcurrentHashMap<>();

    /* renamed from: Q3$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0370a<T> {
        /* renamed from: a */
        int mo2124a(T t);

        /* renamed from: b */
        boolean mo2123b(T t);
    }

    /* renamed from: e */
    public static <T> T m2125e(T[] tArr, int i, InterfaceC0370a<T> interfaceC0370a) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(interfaceC0370a.mo2124a(t2) - i2) * 2) + (interfaceC0370a.mo2123b(t2) == z ? 0 : 1);
            if (t == null || i3 > abs) {
                t = t2;
                i3 = abs;
            }
        }
        return t;
    }

    /* renamed from: a */
    public Typeface mo2129a(Context context, C0017A3 c0017a3, Resources resources, int i) {
        throw null;
    }

    /* renamed from: b */
    public Typeface mo2128b(Context context, CancellationSignal cancellationSignal, C2171p4[] c2171p4Arr, int i) {
        throw null;
    }

    /* renamed from: c */
    public Typeface mo2127c(Context context, InputStream inputStream) {
        File m2662P = LayoutInflater$Factory2C0000A.C0010h.m2662P(context);
        if (m2662P == null) {
            return null;
        }
        try {
            if (LayoutInflater$Factory2C0000A.C0010h.m2617r(m2662P, inputStream)) {
                return Typeface.createFromFile(m2662P.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            m2662P.delete();
        }
    }

    /* renamed from: d */
    public Typeface mo2126d(Context context, Resources resources, int i, String str, int i2) {
        File m2662P = LayoutInflater$Factory2C0000A.C0010h.m2662P(context);
        if (m2662P == null) {
            return null;
        }
        try {
            if (LayoutInflater$Factory2C0000A.C0010h.m2619q(m2662P, resources, i)) {
                return Typeface.createFromFile(m2662P.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            m2662P.delete();
        }
    }
}
