package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;
import p000.AbstractC1917j6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ImmLeaksCleaner implements InterfaceC1938k6 {

    /* renamed from: b */
    public static int f2201b;

    /* renamed from: c */
    public static Field f2202c;

    /* renamed from: d */
    public static Field f2203d;

    /* renamed from: e */
    public static Field f2204e;

    /* renamed from: a */
    public Activity f2205a;

    public ImmLeaksCleaner(Activity activity) {
        this.f2205a = activity;
    }

    @Override // p000.InterfaceC1938k6
    /* renamed from: d */
    public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
        if (enumC1918a != AbstractC1917j6.EnumC1918a.ON_DESTROY) {
            return;
        }
        if (f2201b == 0) {
            try {
                f2201b = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                f2203d = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                f2204e = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                f2202c = declaredField3;
                declaredField3.setAccessible(true);
                f2201b = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f2201b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f2205a.getSystemService("input_method");
            try {
                Object obj = f2202c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f2203d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f2204e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused2) {
                            }
                        } catch (ClassCastException unused3) {
                        } catch (IllegalAccessException unused4) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
