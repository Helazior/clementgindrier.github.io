package p000;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: M3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0286M3 extends C0234K3 {

    /* renamed from: g */
    public final Class<?> f957g;

    /* renamed from: h */
    public final Constructor<?> f958h;

    /* renamed from: i */
    public final Method f959i;

    /* renamed from: j */
    public final Method f960j;

    /* renamed from: k */
    public final Method f961k;

    /* renamed from: l */
    public final Method f962l;

    /* renamed from: m */
    public final Method f963m;

    public C0286M3() {
        Method method;
        Method method2;
        Constructor<?> constructor;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(new Class[0]);
            method3 = m2196n(cls2);
            method4 = m2195o(cls2);
            method5 = cls2.getMethod("freeze", new Class[0]);
            method2 = cls2.getMethod("abortCreation", new Class[0]);
            method = mo2176p(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            StringBuilder m253r = outline.m253r("Unable to collect necessary methods for class ");
            m253r.append(e.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", m253r.toString(), e);
            method = null;
            method2 = null;
            constructor = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f957g = cls;
        this.f958h = constructor;
        this.f959i = method3;
        this.f960j = method4;
        this.f961k = method5;
        this.f962l = method2;
        this.f963m = method;
    }

    /* renamed from: m */
    private Object m2197m() {
        try {
            return this.f958h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // p000.C0234K3, p000.C0369Q3
    /* renamed from: a */
    public Typeface mo2129a(Context context, C0017A3 c0017a3, Resources resources, int i) {
        C0036B3[] c0036b3Arr;
        if (!m2198l()) {
            return super.mo2129a(context, c0017a3, resources, i);
        }
        Object m2197m = m2197m();
        if (m2197m == null) {
            return null;
        }
        for (C0036B3 c0036b3 : c0017a3.f125a) {
            if (!m2200i(context, m2197m, c0036b3.f175a, c0036b3.f179e, c0036b3.f176b, c0036b3.f177c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0036b3.f178d))) {
                m2201h(m2197m);
                return null;
            }
        }
        if (m2199k(m2197m)) {
            return mo2177j(m2197m);
        }
        return null;
    }

    @Override // p000.C0234K3, p000.C0369Q3
    /* renamed from: b */
    public Typeface mo2128b(Context context, CancellationSignal cancellationSignal, C2171p4[] c2171p4Arr, int i) {
        Typeface mo2177j;
        boolean z;
        if (c2171p4Arr.length < 1) {
            return null;
        }
        if (!m2198l()) {
            C2171p4 c2171p4 = (C2171p4) C0369Q3.m2125e(c2171p4Arr, i, new C0350P3(this));
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(c2171p4.f6216a, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(c2171p4.f6218c).setItalic(c2171p4.f6219d).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap hashMap = new HashMap();
        for (C2171p4 c2171p42 : c2171p4Arr) {
            if (c2171p42.f6220e == 0) {
                Uri uri = c2171p42.f6216a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, LayoutInflater$Factory2C0000A.C0010h.m2655W(context, cancellationSignal, uri));
                }
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
        Object m2197m = m2197m();
        if (m2197m == null) {
            return null;
        }
        boolean z2 = false;
        for (C2171p4 c2171p43 : c2171p4Arr) {
            ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(c2171p43.f6216a);
            if (byteBuffer != null) {
                try {
                    z = ((Boolean) this.f960j.invoke(m2197m, byteBuffer, Integer.valueOf(c2171p43.f6217b), null, Integer.valueOf(c2171p43.f6218c), Integer.valueOf(c2171p43.f6219d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    z = false;
                }
                if (!z) {
                    m2201h(m2197m);
                    return null;
                }
                z2 = true;
            }
        }
        if (!z2) {
            m2201h(m2197m);
            return null;
        } else if (m2199k(m2197m) && (mo2177j = mo2177j(m2197m)) != null) {
            return Typeface.create(mo2177j, i);
        } else {
            return null;
        }
    }

    @Override // p000.C0369Q3
    /* renamed from: d */
    public Typeface mo2126d(Context context, Resources resources, int i, String str, int i2) {
        if (!m2198l()) {
            return super.mo2126d(context, resources, i, str, i2);
        }
        Object m2197m = m2197m();
        if (m2197m == null) {
            return null;
        }
        if (!m2200i(context, m2197m, str, 0, -1, -1, null)) {
            m2201h(m2197m);
            return null;
        } else if (m2199k(m2197m)) {
            return mo2177j(m2197m);
        } else {
            return null;
        }
    }

    /* renamed from: h */
    public final void m2201h(Object obj) {
        try {
            this.f962l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    /* renamed from: i */
    public final boolean m2200i(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f959i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: j */
    public Typeface mo2177j(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f957g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f963m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* renamed from: k */
    public final boolean m2199k(Object obj) {
        try {
            return ((Boolean) this.f961k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* renamed from: l */
    public final boolean m2198l() {
        if (this.f959i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f959i != null;
    }

    /* renamed from: n */
    public Method m2196n(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    /* renamed from: o */
    public Method m2195o(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    /* renamed from: p */
    public Method mo2176p(Class<?> cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
