package p000;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: h1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1852h1 {

    /* renamed from: a */
    public static Method f5113a;

    static {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
            f5113a = declaredMethod;
            if (declaredMethod.isAccessible()) {
                return;
            }
            f5113a.setAccessible(true);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
        }
    }

    /* renamed from: a */
    public static void m787a(View view, Rect rect, Rect rect2) {
        Method method = f5113a;
        if (method != null) {
            try {
                method.invoke(view, rect, rect2);
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    /* renamed from: b */
    public static boolean m786b(View view) {
        AtomicInteger atomicInteger = C0492V4.f1798a;
        return C0492V4.C0496d.m1921d(view) == 1;
    }
}
