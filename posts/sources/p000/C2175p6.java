package p000;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: p6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2175p6 {

    /* renamed from: a */
    public static Map<Class, Integer> f6231a = new HashMap();

    /* renamed from: b */
    public static Map<Class, List<Constructor<? extends InterfaceC1890i6>>> f6232b = new HashMap();

    /* renamed from: a */
    public static InterfaceC1890i6 m442a(Constructor<? extends InterfaceC1890i6> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: b */
    public static String m441b(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    /* renamed from: c */
    public static int m440c(Class<?> cls) {
        Constructor<?> constructor;
        boolean z;
        ArrayList arrayList;
        Integer num = f6231a.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int i = 1;
        if (cls.getCanonicalName() != null) {
            try {
                Package r4 = cls.getPackage();
                String canonicalName = cls.getCanonicalName();
                String name = r4 != null ? r4.getName() : "";
                if (!name.isEmpty()) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String m441b = m441b(canonicalName);
                if (!name.isEmpty()) {
                    m441b = name + "." + m441b;
                }
                constructor = Class.forName(m441b).getDeclaredConstructor(cls);
                if (!constructor.isAccessible()) {
                    constructor.setAccessible(true);
                }
            } catch (ClassNotFoundException unused) {
                constructor = null;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            if (constructor != null) {
                f6232b.put(cls, Collections.singletonList(constructor));
            } else {
                C1837g6 c1837g6 = C1837g6.f5075c;
                Boolean bool = c1837g6.f5077b.get(cls);
                if (bool != null) {
                    z = bool.booleanValue();
                } else {
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        int length = declaredMethods.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                if (((InterfaceC2254t6) declaredMethods[i2].getAnnotation(InterfaceC2254t6.class)) != null) {
                                    c1837g6.m799a(cls, declaredMethods);
                                    z = true;
                                    break;
                                }
                                i2++;
                            } else {
                                c1837g6.f5077b.put(cls, Boolean.FALSE);
                                z = false;
                                break;
                            }
                        }
                    } catch (NoClassDefFoundError e2) {
                        throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
                    }
                }
                if (!z) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    if (superclass != null && InterfaceC1958l6.class.isAssignableFrom(superclass)) {
                        arrayList = m440c(superclass) != 1 ? new ArrayList(f6232b.get(superclass)) : null;
                    }
                    Class<?>[] interfaces = cls.getInterfaces();
                    int length2 = interfaces.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length2) {
                            Class<?> cls2 = interfaces[i3];
                            if (cls2 != null && InterfaceC1958l6.class.isAssignableFrom(cls2)) {
                                if (m440c(cls2) == 1) {
                                    break;
                                }
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.addAll(f6232b.get(cls2));
                            }
                            i3++;
                        } else if (arrayList != null) {
                            f6232b.put(cls, arrayList);
                        }
                    }
                }
            }
            i = 2;
        }
        f6231a.put(cls, Integer.valueOf(i));
        return i;
    }
}
