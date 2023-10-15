package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: K3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0234K3 extends C0369Q3 {

    /* renamed from: b */
    public static Class<?> f721b = null;

    /* renamed from: c */
    public static Constructor<?> f722c = null;

    /* renamed from: d */
    public static Method f723d = null;

    /* renamed from: e */
    public static Method f724e = null;

    /* renamed from: f */
    public static boolean f725f = false;

    /* renamed from: f */
    public static boolean m2346f(Object obj, String str, int i, boolean z) {
        m2345g();
        try {
            return ((Boolean) f723d.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: g */
    public static void m2345g() {
        Method method;
        Class<?> cls;
        Method method2;
        if (f725f) {
            return;
        }
        f725f = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        f722c = constructor;
        f721b = cls;
        f723d = method2;
        f724e = method;
    }

    @Override // p000.C0369Q3
    /* renamed from: a */
    public Typeface mo2129a(Context context, C0017A3 c0017a3, Resources resources, int i) {
        C0036B3[] c0036b3Arr;
        m2345g();
        try {
            Object newInstance = f722c.newInstance(new Object[0]);
            for (C0036B3 c0036b3 : c0017a3.f125a) {
                File m2662P = LayoutInflater$Factory2C0000A.C0010h.m2662P(context);
                if (m2662P == null) {
                    return null;
                }
                try {
                    if (!LayoutInflater$Factory2C0000A.C0010h.m2619q(m2662P, resources, c0036b3.f180f)) {
                        return null;
                    }
                    if (!m2346f(newInstance, m2662P.getPath(), c0036b3.f176b, c0036b3.f177c)) {
                        return null;
                    }
                    m2662P.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    m2662P.delete();
                }
            }
            m2345g();
            try {
                Object newInstance2 = Array.newInstance(f721b, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) f724e.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // p000.C0369Q3
    /* renamed from: b */
    public Typeface mo2128b(Context context, CancellationSignal cancellationSignal, C2171p4[] c2171p4Arr, int i) {
        File file;
        String readlink;
        if (c2171p4Arr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(((C2171p4) C0369Q3.m2125e(c2171p4Arr, i, new C0350P3(this))).f6216a, "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
            } catch (ErrnoException unused) {
            }
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                file = new File(readlink);
                if (file != null && file.canRead()) {
                    Typeface createFromFile = Typeface.createFromFile(file);
                    openFileDescriptor.close();
                    return createFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface mo2127c = mo2127c(context, fileInputStream);
                fileInputStream.close();
                openFileDescriptor.close();
                return mo2127c;
            }
            file = null;
            if (file != null) {
                Typeface createFromFile2 = Typeface.createFromFile(file);
                openFileDescriptor.close();
                return createFromFile2;
            }
            FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
            Typeface mo2127c2 = mo2127c(context, fileInputStream2);
            fileInputStream2.close();
            openFileDescriptor.close();
            return mo2127c2;
        } catch (IOException unused2) {
            return null;
        }
    }
}
