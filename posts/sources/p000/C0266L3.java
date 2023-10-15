package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: L3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0266L3 extends C0369Q3 {

    /* renamed from: b */
    public static final Class<?> f886b;

    /* renamed from: c */
    public static final Constructor<?> f887c;

    /* renamed from: d */
    public static final Method f888d;

    /* renamed from: e */
    public static final Method f889e;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        f887c = constructor;
        f886b = cls;
        f888d = method2;
        f889e = method;
    }

    /* renamed from: f */
    public static boolean m2220f(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f888d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: g */
    public static Typeface m2219g(Object obj) {
        try {
            Object newInstance = Array.newInstance(f886b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f889e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // p000.C0369Q3
    /* renamed from: a */
    public Typeface mo2129a(Context context, C0017A3 c0017a3, Resources resources, int i) {
        Object obj;
        C0036B3[] c0036b3Arr;
        MappedByteBuffer mappedByteBuffer;
        try {
            obj = f887c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        for (C0036B3 c0036b3 : c0017a3.f125a) {
            int i2 = c0036b3.f180f;
            File m2662P = LayoutInflater$Factory2C0000A.C0010h.m2662P(context);
            if (m2662P != null) {
                try {
                    if (LayoutInflater$Factory2C0000A.C0010h.m2619q(m2662P, resources, i2)) {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(m2662P);
                            try {
                                FileChannel channel = fileInputStream.getChannel();
                                mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                                fileInputStream.close();
                            } finally {
                                break;
                            }
                        } catch (IOException unused2) {
                            mappedByteBuffer = null;
                        }
                        if (mappedByteBuffer != null || !m2220f(obj, mappedByteBuffer, c0036b3.f179e, c0036b3.f176b, c0036b3.f177c)) {
                            return null;
                        }
                    }
                } finally {
                    m2662P.delete();
                }
            }
            mappedByteBuffer = null;
            if (mappedByteBuffer != null) {
                return null;
            }
        }
        return m2219g(obj);
    }

    @Override // p000.C0369Q3
    /* renamed from: b */
    public Typeface mo2128b(Context context, CancellationSignal cancellationSignal, C2171p4[] c2171p4Arr, int i) {
        Object obj;
        try {
            obj = f887c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        C0101E1 c0101e1 = new C0101E1();
        for (C2171p4 c2171p4 : c2171p4Arr) {
            Uri uri = c2171p4.f6216a;
            ByteBuffer byteBuffer = (ByteBuffer) c0101e1.get(uri);
            if (byteBuffer == null) {
                byteBuffer = LayoutInflater$Factory2C0000A.C0010h.m2655W(context, cancellationSignal, uri);
                c0101e1.put(uri, byteBuffer);
            }
            if (byteBuffer == null || !m2220f(obj, byteBuffer, c2171p4.f6217b, c2171p4.f6218c, c2171p4.f6219d)) {
                return null;
            }
        }
        Typeface m2219g = m2219g(obj);
        if (m2219g == null) {
            return null;
        }
        return Typeface.create(m2219g, i);
    }
}
