package p000;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: U5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0471U5 {

    /* renamed from: a */
    public static final int[] f1632a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b */
    public static final AbstractC0589Z5 f1633b = new C0510V5();

    /* renamed from: c */
    public static final AbstractC0589Z5 f1634c;

    /* renamed from: U5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0472a {

        /* renamed from: a */
        public Fragment f1635a;

        /* renamed from: b */
        public boolean f1636b;

        /* renamed from: c */
        public C0088D5 f1637c;

        /* renamed from: d */
        public Fragment f1638d;

        /* renamed from: e */
        public boolean f1639e;

        /* renamed from: f */
        public C0088D5 f1640f;
    }

    static {
        AbstractC0589Z5 abstractC0589Z5;
        try {
            abstractC0589Z5 = (AbstractC0589Z5) Class.forName("w7").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            abstractC0589Z5 = null;
        }
        f1634c = abstractC0589Z5;
    }

    /* renamed from: a */
    public static void m1998a(ArrayList<View> arrayList, C2339x1<String, View> c2339x1, Collection<String> collection) {
        for (int size = c2339x1.size() - 1; size >= 0; size--) {
            View valueAt = c2339x1.valueAt(size);
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if (collection.contains(C0492V4.C0500h.m1890k(valueAt))) {
                arrayList.add(valueAt);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0038, code lost:
        if (r6.mAdded != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0076, code lost:
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0088, code lost:
        if (r6.mHidden == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x008a, code lost:
        r12 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00ed A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ae A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d4 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00dc  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m1997b(p000.C0088D5 r11, p000.AbstractC0352P5.C0353a r12, android.util.SparseArray<p000.C0471U5.C0472a> r13, boolean r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0471U5.m1997b(D5, P5$a, android.util.SparseArray, boolean, boolean):void");
    }

    /* renamed from: c */
    public static void m1996c(Fragment fragment, Fragment fragment2, boolean z, C2339x1<String, View> c2339x1, boolean z2) {
        AbstractC2289v3 enterTransitionCallback;
        if (z) {
            enterTransitionCallback = fragment2.getEnterTransitionCallback();
        } else {
            enterTransitionCallback = fragment.getEnterTransitionCallback();
        }
        if (enterTransitionCallback != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = c2339x1 == null ? 0 : c2339x1.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(c2339x1.keyAt(i));
                arrayList.add(c2339x1.valueAt(i));
            }
            if (z2) {
                throw null;
            }
            throw null;
        }
    }

    /* renamed from: d */
    public static boolean m1995d(AbstractC0589Z5 abstractC0589Z5, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!abstractC0589Z5.mo163e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    public static C2339x1<String, View> m1994e(AbstractC0589Z5 abstractC0589Z5, C2339x1<String, String> c2339x1, Object obj, C0472a c0472a) {
        AbstractC2289v3 enterTransitionCallback;
        ArrayList<String> arrayList;
        Fragment fragment = c0472a.f1635a;
        View view = fragment.getView();
        if (!c2339x1.isEmpty() && obj != null && view != null) {
            C2339x1<String, View> c2339x12 = new C2339x1<>();
            abstractC0589Z5.m1745i(c2339x12, view);
            C0088D5 c0088d5 = c0472a.f1637c;
            if (c0472a.f1636b) {
                enterTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = c0088d5.f1201n;
            } else {
                enterTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = c0088d5.f1202o;
            }
            if (arrayList != null) {
                c2339x12.retainAll(arrayList);
                c2339x12.retainAll(c2339x1.values());
            }
            if (enterTransitionCallback == null) {
                int size = c2339x1.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        return c2339x12;
                    }
                    if (!c2339x12.containsKey(c2339x1.valueAt(size))) {
                        c2339x1.removeAt(size);
                    }
                }
            } else {
                throw null;
            }
        } else {
            c2339x1.clear();
            return null;
        }
    }

    /* renamed from: f */
    public static C2339x1<String, View> m1993f(AbstractC0589Z5 abstractC0589Z5, C2339x1<String, String> c2339x1, Object obj, C0472a c0472a) {
        AbstractC2289v3 exitTransitionCallback;
        ArrayList<String> arrayList;
        if (!c2339x1.isEmpty() && obj != null) {
            Fragment fragment = c0472a.f1638d;
            C2339x1<String, View> c2339x12 = new C2339x1<>();
            abstractC0589Z5.m1745i(c2339x12, fragment.requireView());
            C0088D5 c0088d5 = c0472a.f1640f;
            if (c0472a.f1639e) {
                exitTransitionCallback = fragment.getEnterTransitionCallback();
                arrayList = c0088d5.f1202o;
            } else {
                exitTransitionCallback = fragment.getExitTransitionCallback();
                arrayList = c0088d5.f1201n;
            }
            c2339x12.retainAll(arrayList);
            if (exitTransitionCallback == null) {
                c2339x1.retainAll(c2339x12.keySet());
                return c2339x12;
            }
            throw null;
        }
        c2339x1.clear();
        return null;
    }

    /* renamed from: g */
    public static AbstractC0589Z5 m1992g(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        AbstractC0589Z5 abstractC0589Z5 = f1633b;
        if (m1995d(abstractC0589Z5, arrayList)) {
            return abstractC0589Z5;
        }
        AbstractC0589Z5 abstractC0589Z52 = f1634c;
        if (abstractC0589Z52 == null || !m1995d(abstractC0589Z52, arrayList)) {
            throw new IllegalArgumentException("Invalid Transition types");
        }
        return abstractC0589Z52;
    }

    /* renamed from: h */
    public static ArrayList<View> m1991h(AbstractC0589Z5 abstractC0589Z5, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj != null) {
            ArrayList<View> arrayList2 = new ArrayList<>();
            View view2 = fragment.getView();
            if (view2 != null) {
                abstractC0589Z5.m1747f(arrayList2, view2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (arrayList2.isEmpty()) {
                return arrayList2;
            }
            arrayList2.add(view);
            abstractC0589Z5.mo165b(obj, arrayList2);
            return arrayList2;
        }
        return null;
    }

    /* renamed from: i */
    public static Object m1990i(AbstractC0589Z5 abstractC0589Z5, Fragment fragment, boolean z) {
        Object enterTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            enterTransition = fragment.getReenterTransition();
        } else {
            enterTransition = fragment.getEnterTransition();
        }
        return abstractC0589Z5.mo162g(enterTransition);
    }

    /* renamed from: j */
    public static Object m1989j(AbstractC0589Z5 abstractC0589Z5, Fragment fragment, boolean z) {
        Object exitTransition;
        if (fragment == null) {
            return null;
        }
        if (z) {
            exitTransition = fragment.getReturnTransition();
        } else {
            exitTransition = fragment.getExitTransition();
        }
        return abstractC0589Z5.mo162g(exitTransition);
    }

    /* renamed from: k */
    public static View m1988k(C2339x1<String, View> c2339x1, C0472a c0472a, Object obj, boolean z) {
        ArrayList<String> arrayList;
        String str;
        C0088D5 c0088d5 = c0472a.f1637c;
        if (obj == null || c2339x1 == null || (arrayList = c0088d5.f1201n) == null || arrayList.isEmpty()) {
            return null;
        }
        if (z) {
            str = c0088d5.f1201n.get(0);
        } else {
            str = c0088d5.f1202o.get(0);
        }
        return c2339x1.get(str);
    }

    /* renamed from: l */
    public static Object m1987l(AbstractC0589Z5 abstractC0589Z5, Fragment fragment, Fragment fragment2, boolean z) {
        Object sharedElementEnterTransition;
        if (z) {
            sharedElementEnterTransition = fragment2.getSharedElementReturnTransition();
        } else {
            sharedElementEnterTransition = fragment.getSharedElementEnterTransition();
        }
        return abstractC0589Z5.mo151v(abstractC0589Z5.mo162g(sharedElementEnterTransition));
    }

    /* renamed from: m */
    public static Object m1986m(AbstractC0589Z5 abstractC0589Z5, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        boolean z2;
        if (obj == null || obj2 == null || fragment == null) {
            z2 = true;
        } else if (z) {
            z2 = fragment.getAllowReturnTransitionOverlap();
        } else {
            z2 = fragment.getAllowEnterTransitionOverlap();
        }
        if (z2) {
            return abstractC0589Z5.mo160m(obj2, obj, obj3);
        }
        return abstractC0589Z5.mo161l(obj2, obj, obj3);
    }

    /* renamed from: n */
    public static void m1985n(AbstractC0589Z5 abstractC0589Z5, Object obj, Object obj2, C2339x1<String, View> c2339x1, boolean z, C0088D5 c0088d5) {
        String str;
        ArrayList<String> arrayList = c0088d5.f1201n;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (z) {
            str = c0088d5.f1202o.get(0);
        } else {
            str = c0088d5.f1201n.get(0);
        }
        View view = c2339x1.get(str);
        abstractC0589Z5.mo154s(obj, view);
        if (obj2 != null) {
            abstractC0589Z5.mo154s(obj2, view);
        }
    }

    /* renamed from: o */
    public static void m1984o(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:165:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0454 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0224  */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m1983p(p000.LayoutInflater$Factory2C0236K5 r39, java.util.ArrayList<p000.C0088D5> r40, java.util.ArrayList<java.lang.Boolean> r41, int r42, int r43, boolean r44) {
        /*
            Method dump skipped, instructions count: 1129
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0471U5.m1983p(K5, java.util.ArrayList, java.util.ArrayList, int, int, boolean):void");
    }
}
