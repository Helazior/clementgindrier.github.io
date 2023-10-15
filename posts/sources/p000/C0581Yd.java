package p000;

import java.util.Arrays;

/* renamed from: Yd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0581Yd {
    /* renamed from: a */
    public static boolean m1770a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* renamed from: b */
    public static void m1769b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(outline.m266e(str, " must not be null"));
        m1763h(illegalStateException);
        throw illegalStateException;
    }

    /* renamed from: c */
    public static void m1768c(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        m1763h(nullPointerException);
        throw nullPointerException;
    }

    /* renamed from: d */
    public static void m1767d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(outline.m266e(str, " must not be null"));
        m1763h(nullPointerException);
        throw nullPointerException;
    }

    /* renamed from: e */
    public static void m1766e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(m1764g(str));
        m1763h(nullPointerException);
        throw nullPointerException;
    }

    /* renamed from: f */
    public static void m1765f(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(m1764g(str));
        m1763h(illegalArgumentException);
        throw illegalArgumentException;
    }

    /* renamed from: g */
    public static String m1764g(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    /* renamed from: h */
    public static <T extends Throwable> T m1763h(T t) {
        String name = C0581Yd.class.getName();
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (name.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    /* renamed from: i */
    public static void m1762i() {
        C0320Nd c0320Nd = new C0320Nd();
        m1763h(c0320Nd);
        throw c0320Nd;
    }

    /* renamed from: j */
    public static void m1761j(String str) {
        C0407Rd c0407Rd = new C0407Rd(outline.m265f("lateinit property ", str, " has not been initialized"));
        m1763h(c0407Rd);
        throw c0407Rd;
    }
}
