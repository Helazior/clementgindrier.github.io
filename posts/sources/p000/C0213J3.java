package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.Method;
import p000.C0103E3;

/* renamed from: J3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0213J3 {

    /* renamed from: a */
    public static final C0369Q3 f678a;

    /* renamed from: b */
    public static final C0053C1<String, Typeface> f679b;

    /* renamed from: J3$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0214a extends C2191q4 {

        /* renamed from: a */
        public C0103E3.AbstractC0106c f680a;

        public C0214a(C0103E3.AbstractC0106c abstractC0106c) {
            this.f680a = abstractC0106c;
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f678a = new C0330O3();
        } else if (i >= 28) {
            f678a = new C0309N3();
        } else if (i >= 26) {
            f678a = new C0286M3();
        } else {
            if (i >= 24) {
                Method method = C0266L3.f888d;
                if (method == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (method != null) {
                    f678a = new C0266L3();
                }
            }
            f678a = new C0234K3();
        }
        f679b = new C0053C1<>(16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r0.equals(r4) == false) goto L11;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface m2375a(android.content.Context r5, p000.InterfaceC2398z3 r6, android.content.res.Resources r7, int r8, int r9, p000.C0103E3.AbstractC0106c r10, android.os.Handler r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0213J3.m2375a(android.content.Context, z3, android.content.res.Resources, int, int, E3$c, android.os.Handler, boolean):android.graphics.Typeface");
    }

    /* renamed from: b */
    public static Typeface m2374b(Context context, Resources resources, int i, String str, int i2) {
        Typeface mo2126d = f678a.mo2126d(context, resources, i, str, i2);
        if (mo2126d != null) {
            f679b.put(m2373c(resources, i, i2), mo2126d);
        }
        return mo2126d;
    }

    /* renamed from: c */
    public static String m2373c(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
