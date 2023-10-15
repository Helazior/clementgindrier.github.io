package p000;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

@SuppressLint({"UnknownNullness"})
/* renamed from: Z5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0589Z5 {
    /* renamed from: d */
    public static void m1748d(List<View> list, View view) {
        int size = list.size();
        if (m1746h(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!m1746h(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    /* renamed from: h */
    public static boolean m1746h(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public static boolean m1743k(List list) {
        return list == null || list.isEmpty();
    }

    /* renamed from: a */
    public abstract void mo166a(Object obj, View view);

    /* renamed from: b */
    public abstract void mo165b(Object obj, ArrayList<View> arrayList);

    /* renamed from: c */
    public abstract void mo164c(ViewGroup viewGroup, Object obj);

    /* renamed from: e */
    public abstract boolean mo163e(Object obj);

    /* renamed from: f */
    public void m1747f(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.isTransitionGroup()) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m1747f(arrayList, viewGroup.getChildAt(i));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    /* renamed from: g */
    public abstract Object mo162g(Object obj);

    /* renamed from: i */
    public void m1745i(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            String m1890k = C0492V4.C0500h.m1890k(view);
            if (m1890k != null) {
                map.put(m1890k, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m1745i(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* renamed from: j */
    public void m1744j(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], view.getWidth() + iArr[0], view.getHeight() + iArr[1]);
    }

    /* renamed from: l */
    public abstract Object mo161l(Object obj, Object obj2, Object obj3);

    /* renamed from: m */
    public abstract Object mo160m(Object obj, Object obj2, Object obj3);

    /* renamed from: n */
    public abstract void mo159n(Object obj, View view);

    /* renamed from: o */
    public abstract void mo158o(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: p */
    public abstract void mo157p(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: q */
    public abstract void mo156q(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* renamed from: r */
    public abstract void mo155r(Object obj, Rect rect);

    /* renamed from: s */
    public abstract void mo154s(Object obj, View view);

    /* renamed from: t */
    public abstract void mo153t(Object obj, View view, ArrayList<View> arrayList);

    /* renamed from: u */
    public abstract void mo152u(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* renamed from: v */
    public abstract Object mo151v(Object obj);
}
