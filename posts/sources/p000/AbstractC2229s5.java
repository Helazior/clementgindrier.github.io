package p000;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.kxml2.wap.Wbxml;
import p000.C0492V4;

/* renamed from: s5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2229s5 extends C0130F4 {
    private static final String DEFAULT_CLASS_NAME = "android.view.View";
    public static final int HOST_ID = -1;
    public static final int INVALID_ID = Integer.MIN_VALUE;
    private static final Rect INVALID_PARENT_BOUNDS = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    private static final InterfaceC2253t5<C1617d5> NODE_ADAPTER = new C2230a();
    private static final InterfaceC2273u5<C0127F1<C1617d5>, C1617d5> SPARSE_VALUES_ADAPTER = new C2231b();
    private final View mHost;
    private final AccessibilityManager mManager;
    private C2232c mNodeProvider;
    private final Rect mTempScreenRect = new Rect();
    private final Rect mTempParentRect = new Rect();
    private final Rect mTempVisibleRect = new Rect();
    private final int[] mTempGlobalRect = new int[2];
    public int mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
    public int mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
    private int mHoveredVirtualViewId = Integer.MIN_VALUE;

    /* renamed from: s5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2230a implements InterfaceC2253t5<C1617d5> {
        /* renamed from: a */
        public void m399a(Object obj, Rect rect) {
            ((C1617d5) obj).f3986a.getBoundsInParent(rect);
        }
    }

    /* renamed from: s5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2231b implements InterfaceC2273u5<C0127F1<C1617d5>, C1617d5> {
    }

    /* renamed from: s5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2232c extends C1654e5 {
        public C2232c() {
        }

        @Override // p000.C1654e5
        /* renamed from: a */
        public C1617d5 mo398a(int i) {
            return new C1617d5(AccessibilityNodeInfo.obtain(AbstractC2229s5.this.obtainAccessibilityNodeInfo(i).f3986a));
        }

        @Override // p000.C1654e5
        /* renamed from: b */
        public C1617d5 mo397b(int i) {
            int i2 = i == 2 ? AbstractC2229s5.this.mAccessibilityFocusedVirtualViewId : AbstractC2229s5.this.mKeyboardFocusedVirtualViewId;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return new C1617d5(AccessibilityNodeInfo.obtain(AbstractC2229s5.this.obtainAccessibilityNodeInfo(i2).f3986a));
        }

        @Override // p000.C1654e5
        /* renamed from: c */
        public boolean mo396c(int i, int i2, Bundle bundle) {
            return AbstractC2229s5.this.performAction(i, i2, bundle);
        }
    }

    public AbstractC2229s5(View view) {
        if (view != null) {
            this.mHost = view;
            this.mManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if (C0492V4.C0495c.m1941c(view) == 0) {
                C0492V4.C0495c.m1925s(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private boolean clearAccessibilityFocus(int i) {
        if (this.mAccessibilityFocusedVirtualViewId == i) {
            this.mAccessibilityFocusedVirtualViewId = Integer.MIN_VALUE;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 65536);
            return true;
        }
        return false;
    }

    private boolean clickKeyboardFocusedVirtualView() {
        int i = this.mKeyboardFocusedVirtualViewId;
        return i != Integer.MIN_VALUE && onPerformActionForVirtualView(i, 16, null);
    }

    private AccessibilityEvent createEvent(int i, int i2) {
        if (i != -1) {
            return createEventForChild(i, i2);
        }
        return createEventForHost(i2);
    }

    private AccessibilityEvent createEventForChild(int i, int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        C1617d5 obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(i);
        obtain.getText().add(obtainAccessibilityNodeInfo.m1024i());
        obtain.setContentDescription(obtainAccessibilityNodeInfo.m1026g());
        obtain.setScrollable(obtainAccessibilityNodeInfo.f3986a.isScrollable());
        obtain.setPassword(obtainAccessibilityNodeInfo.f3986a.isPassword());
        obtain.setEnabled(obtainAccessibilityNodeInfo.m1023j());
        obtain.setChecked(obtainAccessibilityNodeInfo.f3986a.isChecked());
        onPopulateEventForVirtualView(i, obtain);
        if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
        }
        obtain.setClassName(obtainAccessibilityNodeInfo.m1028e());
        obtain.setSource(this.mHost, i);
        obtain.setPackageName(this.mHost.getContext().getPackageName());
        return obtain;
    }

    private AccessibilityEvent createEventForHost(int i) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i);
        this.mHost.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private C1617d5 createNodeForChild(int i) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        C1617d5 c1617d5 = new C1617d5(obtain);
        obtain.setEnabled(true);
        c1617d5.f3986a.setFocusable(true);
        c1617d5.f3986a.setClassName(DEFAULT_CLASS_NAME);
        Rect rect = INVALID_PARENT_BOUNDS;
        c1617d5.f3986a.setBoundsInParent(rect);
        c1617d5.f3986a.setBoundsInScreen(rect);
        c1617d5.m1016q(this.mHost);
        onPopulateNodeForVirtualView(i, c1617d5);
        if (c1617d5.m1024i() == null && c1617d5.m1026g() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        c1617d5.f3986a.getBoundsInParent(this.mTempParentRect);
        if (!this.mTempParentRect.equals(rect)) {
            int m1029d = c1617d5.m1029d();
            if ((m1029d & 64) == 0) {
                if ((m1029d & 128) == 0) {
                    c1617d5.f3986a.setPackageName(this.mHost.getContext().getPackageName());
                    View view = this.mHost;
                    c1617d5.f3988c = i;
                    c1617d5.f3986a.setSource(view, i);
                    if (this.mAccessibilityFocusedVirtualViewId == i) {
                        c1617d5.f3986a.setAccessibilityFocused(true);
                        c1617d5.f3986a.addAction(128);
                    } else {
                        c1617d5.f3986a.setAccessibilityFocused(false);
                        c1617d5.f3986a.addAction(64);
                    }
                    boolean z = this.mKeyboardFocusedVirtualViewId == i;
                    if (z) {
                        c1617d5.f3986a.addAction(2);
                    } else if (c1617d5.m1022k()) {
                        c1617d5.f3986a.addAction(1);
                    }
                    c1617d5.f3986a.setFocused(z);
                    this.mHost.getLocationOnScreen(this.mTempGlobalRect);
                    c1617d5.f3986a.getBoundsInScreen(this.mTempScreenRect);
                    if (this.mTempScreenRect.equals(rect)) {
                        c1617d5.f3986a.getBoundsInParent(this.mTempScreenRect);
                        if (c1617d5.f3987b != -1) {
                            C1617d5 c1617d52 = new C1617d5(AccessibilityNodeInfo.obtain());
                            for (int i2 = c1617d5.f3987b; i2 != -1; i2 = c1617d52.f3987b) {
                                View view2 = this.mHost;
                                c1617d52.f3987b = -1;
                                c1617d52.f3986a.setParent(view2, -1);
                                c1617d52.f3986a.setBoundsInParent(INVALID_PARENT_BOUNDS);
                                onPopulateNodeForVirtualView(i2, c1617d52);
                                c1617d52.f3986a.getBoundsInParent(this.mTempParentRect);
                                Rect rect2 = this.mTempScreenRect;
                                Rect rect3 = this.mTempParentRect;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            c1617d52.f3986a.recycle();
                        }
                        this.mTempScreenRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                    }
                    if (this.mHost.getLocalVisibleRect(this.mTempVisibleRect)) {
                        this.mTempVisibleRect.offset(this.mTempGlobalRect[0] - this.mHost.getScrollX(), this.mTempGlobalRect[1] - this.mHost.getScrollY());
                        if (this.mTempScreenRect.intersect(this.mTempVisibleRect)) {
                            c1617d5.f3986a.setBoundsInScreen(this.mTempScreenRect);
                            if (isVisibleToUser(this.mTempScreenRect)) {
                                c1617d5.f3986a.setVisibleToUser(true);
                            }
                        }
                    }
                    return c1617d5;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    private C1617d5 createNodeForHost() {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.mHost);
        C1617d5 c1617d5 = new C1617d5(obtain);
        View view = this.mHost;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        view.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        if (c1617d5.f3986a.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            c1617d5.f3986a.addChild(this.mHost, ((Integer) arrayList.get(i)).intValue());
        }
        return c1617d5;
    }

    private C0127F1<C1617d5> getAllNodes() {
        ArrayList arrayList = new ArrayList();
        getVisibleVirtualViews(arrayList);
        C0127F1<C1617d5> c0127f1 = new C0127F1<>(10);
        for (int i = 0; i < arrayList.size(); i++) {
            c0127f1.m2450g(i, createNodeForChild(i));
        }
        return c0127f1;
    }

    private void getBoundsInParent(int i, Rect rect) {
        obtainAccessibilityNodeInfo(i).f3986a.getBoundsInParent(rect);
    }

    private static Rect guessPreviouslyFocusedRect(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
        } else if (i == 33) {
            rect.set(0, height, width, height);
        } else if (i == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean isVisibleToUser(Rect rect) {
        if (rect == null || rect.isEmpty() || this.mHost.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.mHost.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int keyToDirection(int i) {
        if (i != 19) {
            if (i != 21) {
                if (i != 22) {
                    return Wbxml.EXT_T_2;
                }
                return 66;
            }
            return 17;
        }
        return 33;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f4, code lost:
        if (r13 < ((r18 * r18) + ((r17 * 13) * r17))) goto L41;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean moveFocus(int r21, android.graphics.Rect r22) {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2229s5.moveFocus(int, android.graphics.Rect):boolean");
    }

    private boolean performActionForChild(int i, int i2, Bundle bundle) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 64) {
                    if (i2 != 128) {
                        return onPerformActionForVirtualView(i, i2, bundle);
                    }
                    return clearAccessibilityFocus(i);
                }
                return requestAccessibilityFocus(i);
            }
            return clearKeyboardFocusForVirtualView(i);
        }
        return requestKeyboardFocusForVirtualView(i);
    }

    private boolean performActionForHost(int i, Bundle bundle) {
        View view = this.mHost;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        return C0492V4.C0495c.m1934j(view, i, bundle);
    }

    private boolean requestAccessibilityFocus(int i) {
        int i2;
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled() && (i2 = this.mAccessibilityFocusedVirtualViewId) != i) {
            if (i2 != Integer.MIN_VALUE) {
                clearAccessibilityFocus(i2);
            }
            this.mAccessibilityFocusedVirtualViewId = i;
            this.mHost.invalidate();
            sendEventForVirtualView(i, 32768);
            return true;
        }
        return false;
    }

    private void updateHoveredVirtualView(int i) {
        int i2 = this.mHoveredVirtualViewId;
        if (i2 == i) {
            return;
        }
        this.mHoveredVirtualViewId = i;
        sendEventForVirtualView(i, 128);
        sendEventForVirtualView(i2, 256);
    }

    public final boolean clearKeyboardFocusForVirtualView(int i) {
        if (this.mKeyboardFocusedVirtualViewId != i) {
            return false;
        }
        this.mKeyboardFocusedVirtualViewId = Integer.MIN_VALUE;
        onVirtualViewKeyboardFocusChanged(i, false);
        sendEventForVirtualView(i, 8);
        return true;
    }

    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (this.mManager.isEnabled() && this.mManager.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action == 10 && this.mHoveredVirtualViewId != Integer.MIN_VALUE) {
                    updateHoveredVirtualView(Integer.MIN_VALUE);
                    return true;
                }
                return false;
            }
            int virtualViewAt = getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            updateHoveredVirtualView(virtualViewAt);
            return virtualViewAt != Integer.MIN_VALUE;
        }
        return false;
    }

    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                int keyToDirection = keyToDirection(keyCode);
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z = false;
                                while (i < repeatCount && moveFocus(keyToDirection, null)) {
                                    i++;
                                    z = true;
                                }
                                return z;
                            }
                            return false;
                        case 23:
                            break;
                        default:
                            return false;
                    }
                }
                if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                    clickKeyboardFocusedVirtualView();
                    return true;
                }
                return false;
            } else if (keyEvent.hasNoModifiers()) {
                return moveFocus(2, null);
            } else {
                if (keyEvent.hasModifiers(1)) {
                    return moveFocus(1, null);
                }
                return false;
            }
        }
        return false;
    }

    public final int getAccessibilityFocusedVirtualViewId() {
        return this.mAccessibilityFocusedVirtualViewId;
    }

    @Override // p000.C0130F4
    public C1654e5 getAccessibilityNodeProvider(View view) {
        if (this.mNodeProvider == null) {
            this.mNodeProvider = new C2232c();
        }
        return this.mNodeProvider;
    }

    @Deprecated
    public int getFocusedVirtualView() {
        return getAccessibilityFocusedVirtualViewId();
    }

    public final int getKeyboardFocusedVirtualViewId() {
        return this.mKeyboardFocusedVirtualViewId;
    }

    public abstract int getVirtualViewAt(float f, float f2);

    public abstract void getVisibleVirtualViews(List<Integer> list);

    public final void invalidateRoot() {
        invalidateVirtualView(-1, 1);
    }

    public final void invalidateVirtualView(int i) {
        invalidateVirtualView(i, 0);
    }

    public C1617d5 obtainAccessibilityNodeInfo(int i) {
        if (i == -1) {
            return createNodeForHost();
        }
        return createNodeForChild(i);
    }

    public final void onFocusChanged(boolean z, int i, Rect rect) {
        int i2 = this.mKeyboardFocusedVirtualViewId;
        if (i2 != Integer.MIN_VALUE) {
            clearKeyboardFocusForVirtualView(i2);
        }
        if (z) {
            moveFocus(i, rect);
        }
    }

    @Override // p000.C0130F4
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        onPopulateEventForHost(accessibilityEvent);
    }

    @Override // p000.C0130F4
    public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
        super.onInitializeAccessibilityNodeInfo(view, c1617d5);
        onPopulateNodeForHost(c1617d5);
    }

    public abstract boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle);

    public void onPopulateEventForHost(AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
    }

    public void onPopulateNodeForHost(C1617d5 c1617d5) {
    }

    public abstract void onPopulateNodeForVirtualView(int i, C1617d5 c1617d5);

    public void onVirtualViewKeyboardFocusChanged(int i, boolean z) {
    }

    public boolean performAction(int i, int i2, Bundle bundle) {
        if (i != -1) {
            return performActionForChild(i, i2, bundle);
        }
        return performActionForHost(i2, bundle);
    }

    public final boolean requestKeyboardFocusForVirtualView(int i) {
        int i2;
        if ((this.mHost.isFocused() || this.mHost.requestFocus()) && (i2 = this.mKeyboardFocusedVirtualViewId) != i) {
            if (i2 != Integer.MIN_VALUE) {
                clearKeyboardFocusForVirtualView(i2);
            }
            this.mKeyboardFocusedVirtualViewId = i;
            onVirtualViewKeyboardFocusChanged(i, true);
            sendEventForVirtualView(i, 8);
            return true;
        }
        return false;
    }

    public final boolean sendEventForVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.mHost, createEvent(i, i2));
    }

    public final void invalidateVirtualView(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.mManager.isEnabled() || (parent = this.mHost.getParent()) == null) {
            return;
        }
        AccessibilityEvent createEvent = createEvent(i, 2048);
        createEvent.setContentChangeTypes(i2);
        parent.requestSendAccessibilityEvent(this.mHost, createEvent);
    }
}
