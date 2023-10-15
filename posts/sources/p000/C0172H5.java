package p000;

import androidx.fragment.app.Fragment;
import java.lang.reflect.InvocationTargetException;

/* renamed from: H5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0172H5 {

    /* renamed from: a */
    public static final C0101E1<String, Class<?>> f567a = new C0101E1<>();

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: b */
    public static Class<? extends Fragment> m2409b(ClassLoader classLoader, String str) {
        try {
            C0101E1<String, Class<?>> c0101e1 = f567a;
            Class<? extends Fragment> cls = (Class) c0101e1.get(str);
            if (cls == null) {
                Class cls2 = Class.forName(str, false, classLoader);
                c0101e1.put(str, cls2);
                return cls2;
            }
            return cls;
        } catch (ClassCastException e) {
            throw new Fragment.C0809e(outline.m265f("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e);
        } catch (ClassNotFoundException e2) {
            throw new Fragment.C0809e(outline.m265f("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        }
    }

    /* renamed from: a */
    public Fragment mo2258a(ClassLoader classLoader, String str) {
        try {
            return m2409b(classLoader, str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (IllegalAccessException e) {
            throw new Fragment.C0809e(outline.m265f("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new Fragment.C0809e(outline.m265f("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new Fragment.C0809e(outline.m265f("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new Fragment.C0809e(outline.m265f("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }
}
