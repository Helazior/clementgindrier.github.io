package p000;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import p000.AbstractC1917j6;

/* renamed from: g6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1837g6 {

    /* renamed from: c */
    public static C1837g6 f5075c = new C1837g6();

    /* renamed from: a */
    public final Map<Class, C1838a> f5076a = new HashMap();

    /* renamed from: b */
    public final Map<Class, Boolean> f5077b = new HashMap();

    /* renamed from: g6$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1838a {

        /* renamed from: a */
        public final Map<AbstractC1917j6.EnumC1918a, List<C1839b>> f5078a = new HashMap();

        /* renamed from: b */
        public final Map<C1839b, AbstractC1917j6.EnumC1918a> f5079b;

        public C1838a(Map<C1839b, AbstractC1917j6.EnumC1918a> map) {
            this.f5079b = map;
            for (Map.Entry<C1839b, AbstractC1917j6.EnumC1918a> entry : map.entrySet()) {
                AbstractC1917j6.EnumC1918a value = entry.getValue();
                List<C1839b> list = this.f5078a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f5078a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        /* renamed from: a */
        public static void m796a(List<C1839b> list, InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    C1839b c1839b = list.get(size);
                    Objects.requireNonNull(c1839b);
                    try {
                        int i = c1839b.f5080a;
                        if (i == 0) {
                            c1839b.f5081b.invoke(obj, new Object[0]);
                        } else if (i == 1) {
                            c1839b.f5081b.invoke(obj, interfaceC1979m6);
                        } else if (i == 2) {
                            c1839b.f5081b.invoke(obj, interfaceC1979m6, enumC1918a);
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to call observer method", e2.getCause());
                    }
                }
            }
        }
    }

    /* renamed from: g6$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1839b {

        /* renamed from: a */
        public final int f5080a;

        /* renamed from: b */
        public final Method f5081b;

        public C1839b(int i, Method method) {
            this.f5080a = i;
            this.f5081b = method;
            method.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C1839b.class != obj.getClass()) {
                return false;
            }
            C1839b c1839b = (C1839b) obj;
            return this.f5080a == c1839b.f5080a && this.f5081b.getName().equals(c1839b.f5081b.getName());
        }

        public int hashCode() {
            return this.f5081b.getName().hashCode() + (this.f5080a * 31);
        }
    }

    /* renamed from: a */
    public final C1838a m799a(Class cls, Method[] methodArr) {
        int i;
        C1838a m798b;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (m798b = m798b(superclass)) != null) {
            hashMap.putAll(m798b.f5079b);
        }
        for (Class cls2 : cls.getInterfaces()) {
            for (Map.Entry<C1839b, AbstractC1917j6.EnumC1918a> entry : m798b(cls2).f5079b.entrySet()) {
                m797c(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            InterfaceC2254t6 interfaceC2254t6 = (InterfaceC2254t6) method.getAnnotation(InterfaceC2254t6.class);
            if (interfaceC2254t6 != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (!parameterTypes[0].isAssignableFrom(InterfaceC1979m6.class)) {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                } else {
                    i = 1;
                }
                AbstractC1917j6.EnumC1918a value = interfaceC2254t6.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(AbstractC1917j6.EnumC1918a.class)) {
                        if (value != AbstractC1917j6.EnumC1918a.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    m797c(hashMap, new C1839b(i, method), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C1838a c1838a = new C1838a(hashMap);
        this.f5076a.put(cls, c1838a);
        this.f5077b.put(cls, Boolean.valueOf(z));
        return c1838a;
    }

    /* renamed from: b */
    public C1838a m798b(Class cls) {
        C1838a c1838a = this.f5076a.get(cls);
        return c1838a != null ? c1838a : m799a(cls, null);
    }

    /* renamed from: c */
    public final void m797c(Map<C1839b, AbstractC1917j6.EnumC1918a> map, C1839b c1839b, AbstractC1917j6.EnumC1918a enumC1918a, Class cls) {
        AbstractC1917j6.EnumC1918a enumC1918a2 = map.get(c1839b);
        if (enumC1918a2 == null || enumC1918a == enumC1918a2) {
            if (enumC1918a2 == null) {
                map.put(c1839b, enumC1918a);
                return;
            }
            return;
        }
        Method method = c1839b.f5081b;
        StringBuilder m253r = outline.m253r("Method ");
        m253r.append(method.getName());
        m253r.append(" in ");
        m253r.append(cls.getName());
        m253r.append(" already declared with different @OnLifecycleEvent value: previous value ");
        m253r.append(enumC1918a2);
        m253r.append(", new value ");
        m253r.append(enumC1918a);
        throw new IllegalArgumentException(m253r.toString());
    }
}
