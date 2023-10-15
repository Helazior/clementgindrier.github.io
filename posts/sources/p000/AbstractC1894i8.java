package p000;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: i8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1894i8 {

    /* renamed from: a */
    public final C2339x1<String, Method> f5282a;

    /* renamed from: b */
    public final C2339x1<String, Method> f5283b;

    /* renamed from: c */
    public final C2339x1<String, Class> f5284c;

    public AbstractC1894i8(C2339x1<String, Method> c2339x1, C2339x1<String, Method> c2339x12, C2339x1<String, Class> c2339x13) {
        this.f5282a = c2339x1;
        this.f5283b = c2339x12;
        this.f5284c = c2339x13;
    }

    /* renamed from: a */
    public abstract void mo698a();

    /* renamed from: b */
    public abstract AbstractC1894i8 mo697b();

    /* renamed from: c */
    public final Class m733c(Class<? extends InterfaceC1940k8> cls) {
        Class cls2 = this.f5284c.get(cls.getName());
        if (cls2 == null) {
            Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.f5284c.put(cls.getName(), cls3);
            return cls3;
        }
        return cls2;
    }

    /* renamed from: d */
    public final Method m732d(String str) {
        Method method = this.f5282a.get(str);
        if (method == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, AbstractC1894i8.class.getClassLoader()).getDeclaredMethod("read", AbstractC1894i8.class);
            this.f5282a.put(str, declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    /* renamed from: e */
    public final Method m731e(Class cls) {
        Method method = this.f5283b.get(cls.getName());
        if (method == null) {
            Class m733c = m733c(cls);
            System.currentTimeMillis();
            Method declaredMethod = m733c.getDeclaredMethod("write", cls, AbstractC1894i8.class);
            this.f5283b.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return method;
    }

    /* renamed from: f */
    public abstract boolean mo696f();

    /* renamed from: g */
    public abstract byte[] mo695g();

    /* renamed from: h */
    public abstract CharSequence mo694h();

    /* renamed from: i */
    public abstract boolean mo693i(int i);

    /* renamed from: j */
    public abstract int mo692j();

    /* renamed from: k */
    public int m730k(int i, int i2) {
        return !mo693i(i2) ? i : mo692j();
    }

    /* renamed from: l */
    public abstract <T extends Parcelable> T mo691l();

    /* renamed from: m */
    public <T extends Parcelable> T m729m(T t, int i) {
        return !mo693i(i) ? t : (T) mo691l();
    }

    /* renamed from: n */
    public abstract String mo690n();

    /* renamed from: o */
    public <T extends InterfaceC1940k8> T m728o() {
        String mo690n = mo690n();
        if (mo690n == null) {
            return null;
        }
        try {
            return (T) m732d(mo690n).invoke(null, mo697b());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* renamed from: p */
    public abstract void mo689p(int i);

    /* renamed from: q */
    public abstract void mo688q(boolean z);

    /* renamed from: r */
    public abstract void mo687r(byte[] bArr);

    /* renamed from: s */
    public abstract void mo686s(CharSequence charSequence);

    /* renamed from: t */
    public abstract void mo685t(int i);

    /* renamed from: u */
    public abstract void mo684u(Parcelable parcelable);

    /* renamed from: v */
    public abstract void mo683v(String str);

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: w */
    public void m727w(InterfaceC1940k8 interfaceC1940k8) {
        if (interfaceC1940k8 == null) {
            mo683v(null);
            return;
        }
        try {
            mo683v(m733c(interfaceC1940k8.getClass()).getName());
            AbstractC1894i8 mo697b = mo697b();
            try {
                m731e(interfaceC1940k8.getClass()).invoke(null, interfaceC1940k8, mo697b);
                mo697b.mo698a();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (e4.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e4.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(interfaceC1940k8.getClass().getSimpleName() + " does not have a Parcelizer", e5);
        }
    }
}
