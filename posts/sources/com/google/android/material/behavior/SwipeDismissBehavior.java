package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.C1617d5;
import p000.C2319w5;
import p000.InterfaceC1677f5;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    private boolean interceptingEvents;
    public OnDismissListener listener;
    private boolean sensitivitySet;
    public C2319w5 viewDragHelper;
    private float sensitivity = DEFAULT_ALPHA_START_DISTANCE;
    public int swipeDirection = 2;
    public float dragDismissThreshold = 0.5f;
    public float alphaStartSwipeDistance = DEFAULT_ALPHA_START_DISTANCE;
    public float alphaEndSwipeDistance = 0.5f;
    private final C2319w5.AbstractC2322c dragCallback = new C2319w5.AbstractC2322c() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        private boolean shouldDismiss(View view, float f) {
            int i = (f > SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE ? 1 : (f == SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE ? 0 : -1));
            if (i == 0) {
                return Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.dragDismissThreshold);
            }
            AtomicInteger atomicInteger = C0492V4.f1798a;
            boolean z = C0492V4.C0496d.m1921d(view) == 1;
            int i2 = SwipeDismissBehavior.this.swipeDirection;
            if (i2 == 2) {
                return true;
            }
            if (i2 == 0) {
                if (z) {
                    if (f >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                        return false;
                    }
                } else if (i <= 0) {
                    return false;
                }
                return true;
            } else if (i2 == 1) {
                if (z) {
                    if (i <= 0) {
                        return false;
                    }
                } else if (f >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // p000.C2319w5.AbstractC2322c
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int width;
            int width2;
            int width3;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            boolean z = C0492V4.C0496d.m1921d(view) == 1;
            int i3 = SwipeDismissBehavior.this.swipeDirection;
            if (i3 == 0) {
                if (z) {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                } else {
                    width = this.originalCapturedViewLeft;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i3 != 1) {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = view.getWidth() + this.originalCapturedViewLeft;
            } else if (z) {
                width = this.originalCapturedViewLeft;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = this.originalCapturedViewLeft;
            }
            return SwipeDismissBehavior.clamp(width, i, width2);
        }

        @Override // p000.C2319w5.AbstractC2322c
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // p000.C2319w5.AbstractC2322c
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onViewCaptured(View view, int i) {
            this.activePointerId = i;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onViewDragStateChanged(int i) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i);
            }
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width = (view.getWidth() * SwipeDismissBehavior.this.alphaStartSwipeDistance) + this.originalCapturedViewLeft;
            float width2 = (view.getWidth() * SwipeDismissBehavior.this.alphaEndSwipeDistance) + this.originalCapturedViewLeft;
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp((float) SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE, 1.0f - SwipeDismissBehavior.fraction(width, width2, f), 1.0f));
            }
        }

        @Override // p000.C2319w5.AbstractC2322c
        public void onViewReleased(View view, float f, float f2) {
            int i;
            boolean z;
            OnDismissListener onDismissListener;
            this.activePointerId = -1;
            int width = view.getWidth();
            if (shouldDismiss(view, f)) {
                int left = view.getLeft();
                int i2 = this.originalCapturedViewLeft;
                i = left < i2 ? i2 - width : i2 + width;
                z = true;
            } else {
                i = this.originalCapturedViewLeft;
                z = false;
            }
            if (SwipeDismissBehavior.this.viewDragHelper.m170v(i, view.getTop())) {
                SettleRunnable settleRunnable = new SettleRunnable(view, z);
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0495c.m1931m(view, settleRunnable);
            } else if (!z || (onDismissListener = SwipeDismissBehavior.this.listener) == null) {
            } else {
                onDismissListener.onDismiss(view);
            }
        }

        @Override // p000.C2319w5.AbstractC2322c
        public boolean tryCaptureView(View view, int i) {
            int i2 = this.activePointerId;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }
    };

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        public SettleRunnable(View view, boolean z) {
            this.view = view;
            this.dismiss = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            OnDismissListener onDismissListener;
            C2319w5 c2319w5 = SwipeDismissBehavior.this.viewDragHelper;
            if (c2319w5 != null && c2319w5.m183i(true)) {
                View view = this.view;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0495c.m1931m(view, this);
            } else if (!this.dismiss || (onDismissListener = SwipeDismissBehavior.this.listener) == null) {
            } else {
                onDismissListener.onDismiss(this.view);
            }
        }
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        C2319w5 c2319w5;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                c2319w5 = C2319w5.m182j(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                c2319w5 = new C2319w5(viewGroup.getContext(), viewGroup, this.dragCallback);
            }
            this.viewDragHelper = c2319w5;
        }
    }

    public static float fraction(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    private void updateAccessibilityActions(View view) {
        C0492V4.m1953r(1048576, view);
        C0492V4.m1958m(view, 0);
        if (canSwipeDismissView(view)) {
            C0492V4.m1952s(view, C1617d5.C1618a.f3996l, null, new InterfaceC1677f5() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                @Override // p000.InterfaceC1677f5
                public boolean perform(View view2, InterfaceC1677f5.AbstractC1678a abstractC1678a) {
                    boolean z = false;
                    if (SwipeDismissBehavior.this.canSwipeDismissView(view2)) {
                        AtomicInteger atomicInteger = C0492V4.f1798a;
                        boolean z2 = C0492V4.C0496d.m1921d(view2) == 1;
                        int i = SwipeDismissBehavior.this.swipeDirection;
                        if ((i == 0 && z2) || (i == 1 && !z2)) {
                            z = true;
                        }
                        int width = view2.getWidth();
                        if (z) {
                            width = -width;
                        }
                        C0492V4.m1957n(view2, width);
                        view2.setAlpha(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
                        OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
                        if (onDismissListener != null) {
                            onDismissListener.onDismiss(view2);
                        }
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    public int getDragState() {
        C2319w5 c2319w5 = this.viewDragHelper;
        if (c2319w5 != null) {
            return c2319w5.f6752a;
        }
        return 0;
    }

    public OnDismissListener getListener() {
        return this.listener;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (z) {
            ensureViewDragHelper(coordinatorLayout);
            return this.viewDragHelper.m169w(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v, i);
        AtomicInteger atomicInteger = C0492V4.f1798a;
        if (C0492V4.C0495c.m1941c(v) == 0) {
            C0492V4.C0495c.m1925s(v, 1);
            updateAccessibilityActions(v);
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        C2319w5 c2319w5 = this.viewDragHelper;
        if (c2319w5 != null) {
            c2319w5.m176p(motionEvent);
            return true;
        }
        return false;
    }

    public void setDragDismissDistance(float f) {
        this.dragDismissThreshold = clamp((float) DEFAULT_ALPHA_START_DISTANCE, f, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f) {
        this.alphaEndSwipeDistance = clamp((float) DEFAULT_ALPHA_START_DISTANCE, f, 1.0f);
    }

    public void setListener(OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public void setSensitivity(float f) {
        this.sensitivity = f;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f) {
        this.alphaStartSwipeDistance = clamp((float) DEFAULT_ALPHA_START_DISTANCE, f, 1.0f);
    }

    public void setSwipeDirection(int i) {
        this.swipeDirection = i;
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }
}
