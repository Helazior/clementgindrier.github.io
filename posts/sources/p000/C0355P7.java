package p000;

import android.os.Build;
import android.view.ViewGroup;
import java.lang.reflect.Method;

/* renamed from: P7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0355P7 {

    /* renamed from: a */
    public static boolean f1216a = true;

    /* renamed from: b */
    public static Method f1217b;

    /* renamed from: c */
    public static boolean f1218c;

    /* renamed from: a */
    public static void m2148a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z);
        } else if (f1216a) {
            try {
                viewGroup.suppressLayout(z);
            } catch (NoSuchMethodError unused) {
                f1216a = false;
            }
        }
    }
}
