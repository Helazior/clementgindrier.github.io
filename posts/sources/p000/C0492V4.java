package p000;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0130F4;
import p000.C0492V4;
import p000.C0958b5;
import p000.C1617d5;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: V4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0492V4 {

    /* renamed from: c */
    public static Field f1800c;

    /* renamed from: e */
    public static ThreadLocal<Rect> f1802e;

    /* renamed from: a */
    public static final AtomicInteger f1798a = new AtomicInteger(1);

    /* renamed from: b */
    public static WeakHashMap<View, C0554X4> f1799b = null;

    /* renamed from: d */
    public static boolean f1801d = false;

    /* renamed from: f */
    public static final int[] f1803f = {C1675f3.accessibility_custom_action_0, C1675f3.accessibility_custom_action_1, C1675f3.accessibility_custom_action_2, C1675f3.accessibility_custom_action_3, C1675f3.accessibility_custom_action_4, C1675f3.accessibility_custom_action_5, C1675f3.accessibility_custom_action_6, C1675f3.accessibility_custom_action_7, C1675f3.accessibility_custom_action_8, C1675f3.accessibility_custom_action_9, C1675f3.accessibility_custom_action_10, C1675f3.accessibility_custom_action_11, C1675f3.accessibility_custom_action_12, C1675f3.accessibility_custom_action_13, C1675f3.accessibility_custom_action_14, C1675f3.accessibility_custom_action_15, C1675f3.accessibility_custom_action_16, C1675f3.accessibility_custom_action_17, C1675f3.accessibility_custom_action_18, C1675f3.accessibility_custom_action_19, C1675f3.accessibility_custom_action_20, C1675f3.accessibility_custom_action_21, C1675f3.accessibility_custom_action_22, C1675f3.accessibility_custom_action_23, C1675f3.accessibility_custom_action_24, C1675f3.accessibility_custom_action_25, C1675f3.accessibility_custom_action_26, C1675f3.accessibility_custom_action_27, C1675f3.accessibility_custom_action_28, C1675f3.accessibility_custom_action_29, C1675f3.accessibility_custom_action_30, C1675f3.accessibility_custom_action_31};

    /* renamed from: V4$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0494b {
        /* renamed from: a */
        public static boolean m1944a(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* renamed from: V4$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0495c {
        /* renamed from: a */
        public static AccessibilityNodeProvider m1943a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        /* renamed from: b */
        public static boolean m1942b(View view) {
            return view.getFitsSystemWindows();
        }

        /* renamed from: c */
        public static int m1941c(View view) {
            return view.getImportantForAccessibility();
        }

        /* renamed from: d */
        public static int m1940d(View view) {
            return view.getMinimumHeight();
        }

        /* renamed from: e */
        public static int m1939e(View view) {
            return view.getMinimumWidth();
        }

        /* renamed from: f */
        public static ViewParent m1938f(View view) {
            return view.getParentForAccessibility();
        }

        /* renamed from: g */
        public static int m1937g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        /* renamed from: h */
        public static boolean m1936h(View view) {
            return view.hasOverlappingRendering();
        }

        /* renamed from: i */
        public static boolean m1935i(View view) {
            return view.hasTransientState();
        }

        /* renamed from: j */
        public static boolean m1934j(View view, int i, Bundle bundle) {
            return view.performAccessibilityAction(i, bundle);
        }

        /* renamed from: k */
        public static void m1933k(View view) {
            view.postInvalidateOnAnimation();
        }

        /* renamed from: l */
        public static void m1932l(View view, int i, int i2, int i3, int i4) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        }

        /* renamed from: m */
        public static void m1931m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        /* renamed from: n */
        public static void m1930n(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        /* renamed from: o */
        public static void m1929o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        /* renamed from: p */
        public static void m1928p(View view) {
            view.requestFitSystemWindows();
        }

        /* renamed from: q */
        public static void m1927q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        /* renamed from: r */
        public static void m1926r(View view, boolean z) {
            view.setHasTransientState(z);
        }

        /* renamed from: s */
        public static void m1925s(View view, int i) {
            view.setImportantForAccessibility(i);
        }
    }

    /* renamed from: V4$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0496d {
        /* renamed from: a */
        public static int m1924a() {
            return View.generateViewId();
        }

        /* renamed from: b */
        public static Display m1923b(View view) {
            return view.getDisplay();
        }

        /* renamed from: c */
        public static int m1922c(View view) {
            return view.getLabelFor();
        }

        /* renamed from: d */
        public static int m1921d(View view) {
            return view.getLayoutDirection();
        }

        /* renamed from: e */
        public static int m1920e(View view) {
            return view.getPaddingEnd();
        }

        /* renamed from: f */
        public static int m1919f(View view) {
            return view.getPaddingStart();
        }

        /* renamed from: g */
        public static boolean m1918g(View view) {
            return view.isPaddingRelative();
        }

        /* renamed from: h */
        public static void m1917h(View view, int i) {
            view.setLabelFor(i);
        }

        /* renamed from: i */
        public static void m1916i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        /* renamed from: j */
        public static void m1915j(View view, int i) {
            view.setLayoutDirection(i);
        }

        /* renamed from: k */
        public static void m1914k(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }
    }

    /* renamed from: V4$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0497e {
        /* renamed from: a */
        public static Rect m1913a(View view) {
            return view.getClipBounds();
        }

        /* renamed from: b */
        public static boolean m1912b(View view) {
            return view.isInLayout();
        }

        /* renamed from: c */
        public static void m1911c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    /* renamed from: V4$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0498f {
        /* renamed from: a */
        public static int m1910a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        /* renamed from: b */
        public static boolean m1909b(View view) {
            return view.isAttachedToWindow();
        }

        /* renamed from: c */
        public static boolean m1908c(View view) {
            return view.isLaidOut();
        }

        /* renamed from: d */
        public static boolean m1907d(View view) {
            return view.isLayoutDirectionResolved();
        }

        /* renamed from: e */
        public static void m1906e(ViewParent viewParent, View view, View view2, int i) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i);
        }

        /* renamed from: f */
        public static void m1905f(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        /* renamed from: g */
        public static void m1904g(AccessibilityEvent accessibilityEvent, int i) {
            accessibilityEvent.setContentChangeTypes(i);
        }
    }

    /* renamed from: V4$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0499g {
        /* renamed from: a */
        public static WindowInsets m1903a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        /* renamed from: b */
        public static WindowInsets m1902b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        /* renamed from: c */
        public static void m1901c(View view) {
            view.requestApplyInsets();
        }
    }

    /* renamed from: V4$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0500h {

        /* renamed from: V4$h$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class View$OnApplyWindowInsetsListenerC0501a implements View.OnApplyWindowInsetsListener {

            /* renamed from: a */
            public C0958b5 f1808a = null;

            /* renamed from: b */
            public final /* synthetic */ View f1809b;

            /* renamed from: c */
            public final /* synthetic */ InterfaceC0331O4 f1810c;

            public View$OnApplyWindowInsetsListenerC0501a(View view, InterfaceC0331O4 interfaceC0331O4) {
                this.f1809b = view;
                this.f1810c = interfaceC0331O4;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                C0958b5 m1179k = C0958b5.m1179k(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    C0500h.m1900a(windowInsets, this.f1809b);
                    if (m1179k.equals(this.f1808a)) {
                        return this.f1810c.onApplyWindowInsets(view, m1179k).m1181i();
                    }
                }
                this.f1808a = m1179k;
                C0958b5 onApplyWindowInsets = this.f1810c.onApplyWindowInsets(view, m1179k);
                if (i >= 30) {
                    return onApplyWindowInsets.m1181i();
                }
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0499g.m1901c(view);
                return onApplyWindowInsets.m1181i();
            }
        }

        /* renamed from: a */
        public static void m1900a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(C1675f3.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        /* renamed from: b */
        public static C0958b5 m1899b(View view, C0958b5 c0958b5, Rect rect) {
            WindowInsets m1181i = c0958b5.m1181i();
            if (m1181i != null) {
                return C0958b5.m1179k(view.computeSystemWindowInsets(m1181i, rect), view);
            }
            rect.setEmpty();
            return c0958b5;
        }

        /* renamed from: c */
        public static boolean m1898c(View view, float f, float f2, boolean z) {
            return view.dispatchNestedFling(f, f2, z);
        }

        /* renamed from: d */
        public static boolean m1897d(View view, float f, float f2) {
            return view.dispatchNestedPreFling(f, f2);
        }

        /* renamed from: e */
        public static boolean m1896e(View view, int i, int i2, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        }

        /* renamed from: f */
        public static boolean m1895f(View view, int i, int i2, int i3, int i4, int[] iArr) {
            return view.dispatchNestedScroll(i, i2, i3, i4, iArr);
        }

        /* renamed from: g */
        public static ColorStateList m1894g(View view) {
            return view.getBackgroundTintList();
        }

        /* renamed from: h */
        public static PorterDuff.Mode m1893h(View view) {
            return view.getBackgroundTintMode();
        }

        /* renamed from: i */
        public static float m1892i(View view) {
            return view.getElevation();
        }

        /* renamed from: j */
        public static C0958b5 m1891j(View view) {
            C0958b5.C0963e c0960b;
            if (C0958b5.C0959a.f3686d && view.isAttachedToWindow()) {
                try {
                    Object obj = C0958b5.C0959a.f3683a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) C0958b5.C0959a.f3684b.get(obj);
                        Rect rect2 = (Rect) C0958b5.C0959a.f3685c.get(obj);
                        if (rect == null || rect2 == null) {
                            return null;
                        }
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 30) {
                            c0960b = new C0958b5.C0962d();
                        } else if (i >= 29) {
                            c0960b = new C0958b5.C0961c();
                        } else {
                            c0960b = new C0958b5.C0960b();
                        }
                        c0960b.mo1177b(C0170H3.m2412a(rect.left, rect.top, rect.right, rect.bottom));
                        c0960b.mo1176c(C0170H3.m2412a(rect2.left, rect2.top, rect2.right, rect2.bottom));
                        C0958b5 mo1178a = c0960b.mo1178a();
                        mo1178a.f3682a.mo1163m(mo1178a);
                        mo1178a.f3682a.mo1172d(view.getRootView());
                        return mo1178a;
                    }
                    return null;
                } catch (IllegalAccessException e) {
                    StringBuilder m253r = outline.m253r("Failed to get insets from AttachInfo. ");
                    m253r.append(e.getMessage());
                    Log.w("WindowInsetsCompat", m253r.toString(), e);
                    return null;
                }
            }
            return null;
        }

        /* renamed from: k */
        public static String m1890k(View view) {
            return view.getTransitionName();
        }

        /* renamed from: l */
        public static float m1889l(View view) {
            return view.getTranslationZ();
        }

        /* renamed from: m */
        public static float m1888m(View view) {
            return view.getZ();
        }

        /* renamed from: n */
        public static boolean m1887n(View view) {
            return view.hasNestedScrollingParent();
        }

        /* renamed from: o */
        public static boolean m1886o(View view) {
            return view.isImportantForAccessibility();
        }

        /* renamed from: p */
        public static boolean m1885p(View view) {
            return view.isNestedScrollingEnabled();
        }

        /* renamed from: q */
        public static void m1884q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        /* renamed from: r */
        public static void m1883r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        /* renamed from: s */
        public static void m1882s(View view, float f) {
            view.setElevation(f);
        }

        /* renamed from: t */
        public static void m1881t(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        /* renamed from: u */
        public static void m1880u(View view, InterfaceC0331O4 interfaceC0331O4) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(C1675f3.tag_on_apply_window_listener, interfaceC0331O4);
            }
            if (interfaceC0331O4 == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(C1675f3.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new View$OnApplyWindowInsetsListenerC0501a(view, interfaceC0331O4));
            }
        }

        /* renamed from: v */
        public static void m1879v(View view, String str) {
            view.setTransitionName(str);
        }

        /* renamed from: w */
        public static void m1878w(View view, float f) {
            view.setTranslationZ(f);
        }

        /* renamed from: x */
        public static void m1877x(View view, float f) {
            view.setZ(f);
        }

        /* renamed from: y */
        public static boolean m1876y(View view, int i) {
            return view.startNestedScroll(i);
        }

        /* renamed from: z */
        public static void m1875z(View view) {
            view.stopNestedScroll();
        }
    }

    /* renamed from: V4$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0502i {
        /* renamed from: a */
        public static int m1874a(View view) {
            return view.getScrollIndicators();
        }

        /* renamed from: b */
        public static void m1873b(View view, int i) {
            view.setScrollIndicators(i);
        }

        /* renamed from: c */
        public static void m1872c(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* renamed from: V4$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0503j {
        /* renamed from: a */
        public static void m1871a(View view) {
            view.cancelDragAndDrop();
        }

        /* renamed from: b */
        public static void m1870b(View view) {
            view.dispatchFinishTemporaryDetach();
        }

        /* renamed from: c */
        public static void m1869c(View view) {
            view.dispatchStartTemporaryDetach();
        }

        /* renamed from: d */
        public static void m1868d(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }

        /* renamed from: e */
        public static boolean m1867e(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
            return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
        }

        /* renamed from: f */
        public static void m1866f(View view, View.DragShadowBuilder dragShadowBuilder) {
            view.updateDragShadow(dragShadowBuilder);
        }
    }

    /* renamed from: V4$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0504k {
        /* renamed from: a */
        public static void m1865a(View view, Collection<View> collection, int i) {
            view.addKeyboardNavigationClusters(collection, i);
        }

        /* renamed from: b */
        public static int m1864b(View view) {
            return view.getImportantForAutofill();
        }

        /* renamed from: c */
        public static int m1863c(View view) {
            return view.getNextClusterForwardId();
        }

        /* renamed from: d */
        public static boolean m1862d(View view) {
            return view.hasExplicitFocusable();
        }

        /* renamed from: e */
        public static boolean m1861e(View view) {
            return view.isFocusedByDefault();
        }

        /* renamed from: f */
        public static boolean m1860f(View view) {
            return view.isImportantForAutofill();
        }

        /* renamed from: g */
        public static boolean m1859g(View view) {
            return view.isKeyboardNavigationCluster();
        }

        /* renamed from: h */
        public static View m1858h(View view, View view2, int i) {
            return view.keyboardNavigationClusterSearch(view2, i);
        }

        /* renamed from: i */
        public static boolean m1857i(View view) {
            return view.restoreDefaultFocus();
        }

        /* renamed from: j */
        public static void m1856j(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        /* renamed from: k */
        public static void m1855k(View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        /* renamed from: l */
        public static void m1854l(View view, int i) {
            view.setImportantForAutofill(i);
        }

        /* renamed from: m */
        public static void m1853m(View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        /* renamed from: n */
        public static void m1852n(View view, int i) {
            view.setNextClusterForwardId(i);
        }

        /* renamed from: o */
        public static void m1851o(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* renamed from: V4$l */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0505l {
        /* renamed from: a */
        public static void m1850a(View view, final InterfaceC0508o interfaceC0508o) {
            int i = C1675f3.tag_unhandled_key_listeners;
            C0101E1 c0101e1 = (C0101E1) view.getTag(i);
            if (c0101e1 == null) {
                c0101e1 = new C0101E1();
                view.setTag(i, c0101e1);
            }
            Objects.requireNonNull(interfaceC0508o);
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener = new View.OnUnhandledKeyEventListener() { // from class: E4
                @Override // android.view.View.OnUnhandledKeyEventListener
                public final boolean onUnhandledKeyEvent(View view2, KeyEvent keyEvent) {
                    return C0492V4.InterfaceC0508o.this.onUnhandledKeyEvent(view2, keyEvent);
                }
            };
            c0101e1.put(interfaceC0508o, onUnhandledKeyEventListener);
            view.addOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        /* renamed from: b */
        public static CharSequence m1849b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        /* renamed from: c */
        public static boolean m1848c(View view) {
            return view.isAccessibilityHeading();
        }

        /* renamed from: d */
        public static boolean m1847d(View view) {
            return view.isScreenReaderFocusable();
        }

        /* renamed from: e */
        public static void m1846e(View view, InterfaceC0508o interfaceC0508o) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            C0101E1 c0101e1 = (C0101E1) view.getTag(C1675f3.tag_unhandled_key_listeners);
            if (c0101e1 == null || (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) c0101e1.get(interfaceC0508o)) == null) {
                return;
            }
            view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
        }

        /* renamed from: f */
        public static <T> T m1845f(View view, int i) {
            return (T) view.requireViewById(i);
        }

        /* renamed from: g */
        public static void m1844g(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        /* renamed from: h */
        public static void m1843h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        /* renamed from: i */
        public static void m1842i(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    /* renamed from: V4$m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0506m {
        /* renamed from: a */
        public static View.AccessibilityDelegate m1841a(View view) {
            return view.getAccessibilityDelegate();
        }

        /* renamed from: b */
        public static List<Rect> m1840b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        /* renamed from: c */
        public static void m1839c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        /* renamed from: d */
        public static void m1838d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* renamed from: V4$n */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0507n {
        /* renamed from: a */
        public static CharSequence m1837a(View view) {
            return view.getStateDescription();
        }

        /* renamed from: b */
        public static void m1836b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* renamed from: V4$o */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0508o {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    /* renamed from: V4$p */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0509p {

        /* renamed from: d */
        public static final ArrayList<WeakReference<View>> f1811d = new ArrayList<>();

        /* renamed from: a */
        public WeakHashMap<View, Boolean> f1812a = null;

        /* renamed from: b */
        public SparseArray<WeakReference<View>> f1813b = null;

        /* renamed from: c */
        public WeakReference<KeyEvent> f1814c = null;

        /* renamed from: a */
        public final View m1835a(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1812a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View m1835a = m1835a(viewGroup.getChildAt(childCount), keyEvent);
                        if (m1835a != null) {
                            return m1835a;
                        }
                    }
                }
                if (m1834b(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        /* renamed from: b */
        public final boolean m1834b(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(C1675f3.tag_unhandled_key_listeners);
            if (arrayList != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    if (((InterfaceC0508o) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
    }

    static {
        new WeakHashMap();
    }

    /* renamed from: a */
    public static void m1970a(View view, C1617d5.C1618a c1618a) {
        C0130F4 m1964g = m1964g(view);
        if (m1964g == null) {
            m1964g = new C0130F4();
        }
        m1950u(view, m1964g);
        m1953r(c1618a.m1015a(), view);
        m1961j(view).add(c1618a);
        m1958m(view, 0);
    }

    /* renamed from: b */
    public static C0554X4 m1969b(View view) {
        if (f1799b == null) {
            f1799b = new WeakHashMap<>();
        }
        C0554X4 c0554x4 = f1799b.get(view);
        if (c0554x4 == null) {
            C0554X4 c0554x42 = new C0554X4(view);
            f1799b.put(view, c0554x42);
            return c0554x42;
        }
        return c0554x4;
    }

    /* renamed from: c */
    public static void m1968c(View view, int i) {
        view.offsetLeftAndRight(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m1948w((View) parent);
            }
        }
    }

    /* renamed from: d */
    public static void m1967d(View view, int i) {
        view.offsetTopAndBottom(i);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                m1948w((View) parent);
            }
        }
    }

    /* renamed from: e */
    public static C0958b5 m1966e(View view, C0958b5 c0958b5) {
        WindowInsets m1181i = c0958b5.m1181i();
        if (m1181i != null) {
            WindowInsets m1903a = C0499g.m1903a(view, m1181i);
            if (!m1903a.equals(m1181i)) {
                return C0958b5.m1179k(m1903a, view);
            }
        }
        return c0958b5;
    }

    /* renamed from: f */
    public static boolean m1965f(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = C0509p.f1811d;
        int i = C1675f3.tag_unhandled_key_event_manager;
        C0509p c0509p = (C0509p) view.getTag(i);
        if (c0509p == null) {
            c0509p = new C0509p();
            view.setTag(i, c0509p);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = c0509p.f1812a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = C0509p.f1811d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (c0509p.f1812a == null) {
                        c0509p.f1812a = new WeakHashMap<>();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList<WeakReference<View>> arrayList3 = C0509p.f1811d;
                        View view2 = arrayList3.get(size).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            c0509p.f1812a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                c0509p.f1812a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View m1835a = c0509p.m1835a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (m1835a != null && !KeyEvent.isModifierKey(keyCode)) {
                if (c0509p.f1813b == null) {
                    c0509p.f1813b = new SparseArray<>();
                }
                c0509p.f1813b.put(keyCode, new WeakReference<>(m1835a));
            }
        }
        return m1835a != null;
    }

    /* renamed from: g */
    public static C0130F4 m1964g(View view) {
        View.AccessibilityDelegate m1963h = m1963h(view);
        if (m1963h == null) {
            return null;
        }
        if (m1963h instanceof C0130F4.C0131a) {
            return ((C0130F4.C0131a) m1963h).f440a;
        }
        return new C0130F4(m1963h);
    }

    /* renamed from: h */
    public static View.AccessibilityDelegate m1963h(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return C0506m.m1841a(view);
        }
        if (f1801d) {
            return null;
        }
        if (f1800c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1800c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1801d = true;
                return null;
            }
        }
        try {
            Object obj = f1800c.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f1801d = true;
            return null;
        }
    }

    /* renamed from: i */
    public static CharSequence m1962i(View view) {
        return new C0431S4(C1675f3.tag_accessibility_pane_title, CharSequence.class, 8, 28).m1945c(view);
    }

    /* renamed from: j */
    public static List<C1617d5.C1618a> m1961j(View view) {
        int i = C1675f3.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            view.setTag(i, arrayList2);
            return arrayList2;
        }
        return arrayList;
    }

    /* renamed from: k */
    public static Rect m1960k() {
        if (f1802e == null) {
            f1802e = new ThreadLocal<>();
        }
        Rect rect = f1802e.get();
        if (rect == null) {
            rect = new Rect();
            f1802e.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    /* renamed from: l */
    public static C0958b5 m1959l(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            C0958b5 m1180j = C0958b5.m1180j(rootWindowInsets);
            m1180j.f3682a.mo1163m(m1180j);
            m1180j.f3682a.mo1172d(view.getRootView());
            return m1180j;
        }
        return C0500h.m1891j(view);
    }

    /* renamed from: m */
    public static void m1958m(View view, int i) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = m1962i(view) != null && view.getVisibility() == 0;
            if (C0498f.m1910a(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                C0498f.m1904g(obtain, i);
                if (z) {
                    obtain.getText().add(m1962i(view));
                    if (C0495c.m1941c(view) == 0) {
                        C0495c.m1925s(view, 1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        } else if (C0495c.m1941c((View) parent) == 4) {
                            C0495c.m1925s(view, 2);
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                C0498f.m1904g(obtain2, i);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(m1962i(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    C0498f.m1906e(view.getParent(), view, view, i);
                } catch (AbstractMethodError e) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e);
                }
            }
        }
    }

    /* renamed from: n */
    public static void m1957n(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i);
            return;
        }
        Rect m1960k = m1960k();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            m1960k.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !m1960k.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        m1968c(view, i);
        if (z && m1960k.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(m1960k);
        }
    }

    /* renamed from: o */
    public static void m1956o(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i);
            return;
        }
        Rect m1960k = m1960k();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            m1960k.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !m1960k.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        m1967d(view, i);
        if (z && m1960k.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(m1960k);
        }
    }

    /* renamed from: p */
    public static C0958b5 m1955p(View view, C0958b5 c0958b5) {
        WindowInsets m1181i = c0958b5.m1181i();
        if (m1181i != null) {
            WindowInsets m1902b = C0499g.m1902b(view, m1181i);
            if (!m1902b.equals(m1181i)) {
                return C0958b5.m1179k(m1902b, view);
            }
        }
        return c0958b5;
    }

    /* renamed from: q */
    public static void m1954q(View view, int i) {
        m1953r(i, view);
        m1958m(view, 0);
    }

    /* renamed from: r */
    public static void m1953r(int i, View view) {
        List<C1617d5.C1618a> m1961j = m1961j(view);
        for (int i2 = 0; i2 < m1961j.size(); i2++) {
            if (m1961j.get(i2).m1015a() == i) {
                m1961j.remove(i2);
                return;
            }
        }
    }

    /* renamed from: s */
    public static void m1952s(View view, C1617d5.C1618a c1618a, CharSequence charSequence, InterfaceC1677f5 interfaceC1677f5) {
        if (interfaceC1677f5 == null) {
            m1953r(c1618a.m1015a(), view);
            m1958m(view, 0);
            return;
        }
        m1970a(view, new C1617d5.C1618a(null, c1618a.f4001b, null, interfaceC1677f5, c1618a.f4002c));
    }

    /* renamed from: t */
    public static void m1951t(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            C0506m.m1839c(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    /* renamed from: u */
    public static void m1950u(View view, C0130F4 c0130f4) {
        if (c0130f4 == null && (m1963h(view) instanceof C0130F4.C0131a)) {
            c0130f4 = new C0130F4();
        }
        view.setAccessibilityDelegate(c0130f4 == null ? null : c0130f4.getBridge());
    }

    /* renamed from: v */
    public static void m1949v(View view, C0371Q4 c0371q4) {
        if (Build.VERSION.SDK_INT >= 24) {
            C0503j.m1868d(view, (PointerIcon) (c0371q4 != null ? c0371q4.f1264a : null));
        }
    }

    /* renamed from: w */
    public static void m1948w(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }

    /* renamed from: V4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0493a<T> {

        /* renamed from: a */
        public final int f1804a;

        /* renamed from: b */
        public final Class<T> f1805b;

        /* renamed from: c */
        public final int f1806c;

        /* renamed from: d */
        public final int f1807d;

        public AbstractC0493a(int i, Class<T> cls, int i2) {
            this.f1804a = i;
            this.f1805b = cls;
            this.f1807d = 0;
            this.f1806c = i2;
        }

        /* renamed from: a */
        public boolean m1947a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        /* renamed from: b */
        public abstract T mo1946b(View view);

        /* renamed from: c */
        public T m1945c(View view) {
            if (Build.VERSION.SDK_INT >= this.f1806c) {
                return mo1946b(view);
            }
            T t = (T) view.getTag(this.f1804a);
            if (this.f1805b.isInstance(t)) {
                return t;
            }
            return null;
        }

        public AbstractC0493a(int i, Class<T> cls, int i2, int i3) {
            this.f1804a = i;
            this.f1805b = cls;
            this.f1807d = i2;
            this.f1806c = i3;
        }
    }
}
