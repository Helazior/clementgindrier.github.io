package p000;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: X7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0559X7 {

    /* renamed from: a */
    public static Field f1995a;

    /* renamed from: b */
    public static boolean f1996b;

    /* renamed from: a */
    public void mo1802a(View view) {
        throw null;
    }

    /* renamed from: b */
    public float mo1801b(View view) {
        throw null;
    }

    /* renamed from: c */
    public void mo1800c(View view) {
        throw null;
    }

    /* renamed from: d */
    public void mo1799d(View view, Matrix matrix) {
        throw null;
    }

    /* renamed from: e */
    public void mo1798e(View view, int i, int i2, int i3, int i4) {
        throw null;
    }

    /* renamed from: f */
    public void mo1797f(View view, float f) {
        throw null;
    }

    /* renamed from: g */
    public void mo1796g(View view, int i) {
        if (!f1996b) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f1995a = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f1996b = true;
        }
        Field field = f1995a;
        if (field != null) {
            try {
                f1995a.setInt(view, i | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    /* renamed from: h */
    public void mo1795h(View view, Matrix matrix) {
        throw null;
    }

    /* renamed from: i */
    public void mo1794i(View view, Matrix matrix) {
        throw null;
    }
}
