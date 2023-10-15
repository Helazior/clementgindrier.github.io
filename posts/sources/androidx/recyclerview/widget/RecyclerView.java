package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.kxml2.wap.Wbxml;
import p000.C0217J6;
import p000.C0247K6;
import p000.C0454T6;
import p000.C0492V4;
import p000.C1617d5;
import p000.C1659e7;
import p000.C1862h7;
import p000.C1891i7;
import p000.RunnableC0515V6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RecyclerView extends ViewGroup implements InterfaceC0215J4 {
    public static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
    public static final boolean ALLOW_THREAD_GAP_WORK;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_ORIENTATION = 1;
    public static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION;
    public static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
    public static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
    public static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = {16843830};
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    public static final boolean POST_UPDATES_ON_ANIMATION;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    public static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    public static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    public static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    public static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    public static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    public static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    public static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    public static final Interpolator sQuinticInterpolator;
    public C1659e7 mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    public AbstractC0832g mAdapter;
    public C0217J6 mAdapterHelper;
    public boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private InterfaceC0835j mChildDrawingOrderCallback;
    public C0247K6 mChildHelper;
    public boolean mClipToPadding;
    public boolean mDataSetHasChangedAfterLayout;
    public boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private C0836k mEdgeEffectFactory;
    public boolean mEnableFastScroller;
    public boolean mFirstLayoutComplete;
    public RunnableC0515V6 mGapWorker;
    public boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private InterfaceC0850r mInterceptingOnItemTouchListener;
    public boolean mIsAttached;
    public AbstractC0837l mItemAnimator;
    private AbstractC0837l.InterfaceC0839b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    public final ArrayList<AbstractC0842n> mItemDecorations;
    public boolean mItemsAddedOrRemoved;
    public boolean mItemsChanged;
    private int mLastTouchX;
    private int mLastTouchY;
    public AbstractC0843o mLayout;
    private int mLayoutOrScrollCounter;
    public boolean mLayoutSuppressed;
    public boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final C0856w mObserver;
    private List<InterfaceC0848p> mOnChildAttachStateListeners;
    private AbstractC0849q mOnFlingListener;
    private final ArrayList<InterfaceC0850r> mOnItemTouchListeners;
    public final List<AbstractC0824B> mPendingAccessibilityImportanceChange;
    private SavedState mPendingSavedState;
    public boolean mPostedAnimatorRunner;
    public RunnableC0515V6.C0517b mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    public final C0854u mRecycler;
    public InterfaceC0855v mRecyclerListener;
    public final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private AbstractC0851s mScrollListener;
    private List<AbstractC0851s> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private C0235K4 mScrollingChildHelper;
    public final C0860y mState;
    public final Rect mTempRect;
    private final Rect mTempRect2;
    public final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    public final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    public final RunnableC0823A mViewFlinger;
    private final C1891i7.InterfaceC1893b mViewInfoProcessCallback;
    public final C1891i7 mViewInfoStore;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$A */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0823A implements Runnable {

        /* renamed from: a */
        public int f3211a;

        /* renamed from: b */
        public int f3212b;

        /* renamed from: c */
        public OverScroller f3213c;

        /* renamed from: d */
        public Interpolator f3214d;

        /* renamed from: f */
        public boolean f3215f;

        /* renamed from: g */
        public boolean f3216g;

        public RunnableC0823A() {
            Interpolator interpolator = RecyclerView.sQuinticInterpolator;
            this.f3214d = interpolator;
            this.f3215f = false;
            this.f3216g = false;
            this.f3213c = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        /* renamed from: a */
        public void m1392a() {
            if (this.f3215f) {
                this.f3216g = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            RecyclerView recyclerView = RecyclerView.this;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1931m(recyclerView, this);
        }

        /* renamed from: b */
        public void m1391b(int i, int i2, int i3, Interpolator interpolator) {
            int i4;
            if (i3 == Integer.MIN_VALUE) {
                int abs = Math.abs(i);
                int abs2 = Math.abs(i2);
                boolean z = abs > abs2;
                int sqrt = (int) Math.sqrt(0);
                int sqrt2 = (int) Math.sqrt((i2 * i2) + (i * i));
                RecyclerView recyclerView = RecyclerView.this;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                int i5 = width / 2;
                float f = width;
                float f2 = i5;
                float sin = (((float) Math.sin((Math.min(1.0f, (sqrt2 * 1.0f) / f) - 0.5f) * 0.47123894f)) * f2) + f2;
                if (sqrt > 0) {
                    i4 = Math.round(Math.abs(sin / sqrt) * 1000.0f) * 4;
                } else {
                    if (!z) {
                        abs = abs2;
                    }
                    i4 = (int) (((abs / f) + 1.0f) * 300.0f);
                }
                i3 = Math.min(i4, (int) RecyclerView.MAX_SCROLL_DURATION);
            }
            int i6 = i3;
            if (interpolator == null) {
                interpolator = RecyclerView.sQuinticInterpolator;
            }
            if (this.f3214d != interpolator) {
                this.f3214d = interpolator;
                this.f3213c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f3212b = 0;
            this.f3211a = 0;
            RecyclerView.this.setScrollState(2);
            this.f3213c.startScroll(0, 0, i, i2, i6);
            if (Build.VERSION.SDK_INT < 23) {
                this.f3213c.computeScrollOffset();
            }
            m1392a();
        }

        /* renamed from: c */
        public void m1390c() {
            RecyclerView.this.removeCallbacks(this);
            this.f3213c.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.mLayout == null) {
                m1390c();
                return;
            }
            this.f3216g = false;
            this.f3215f = true;
            recyclerView.consumePendingUpdateOperations();
            OverScroller overScroller = this.f3213c;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.f3211a;
                int i4 = currY - this.f3212b;
                this.f3211a = currX;
                this.f3212b = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.mReusableIntPair;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.dispatchNestedPreScroll(i3, i4, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.mReusableIntPair;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.considerReleasingGlowsOnScroll(i3, i4);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.mAdapter != null) {
                    int[] iArr3 = recyclerView3.mReusableIntPair;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.scrollStep(i3, i4, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.mReusableIntPair;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i3 -= i2;
                    i4 -= i;
                    AbstractC0857x abstractC0857x = recyclerView4.mLayout.mSmoothScroller;
                    if (abstractC0857x != null && !abstractC0857x.isPendingInitialRun() && abstractC0857x.isRunning()) {
                        int m1341b = RecyclerView.this.mState.m1341b();
                        if (m1341b == 0) {
                            abstractC0857x.stop();
                        } else if (abstractC0857x.getTargetPosition() >= m1341b) {
                            abstractC0857x.setTargetPosition(m1341b - 1);
                            abstractC0857x.onAnimation(i2, i);
                        } else {
                            abstractC0857x.onAnimation(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.mItemDecorations.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.mReusableIntPair;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.dispatchNestedScroll(i2, i, i3, i4, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.mReusableIntPair;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    recyclerView6.dispatchOnScrolled(i2, i);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                AbstractC0857x abstractC0857x2 = RecyclerView.this.mLayout.mSmoothScroller;
                if (!(abstractC0857x2 != null && abstractC0857x2.isPendingInitialRun()) && z) {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.absorbGlows(i7, currVelocity);
                    }
                    if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                        RunnableC0515V6.C0517b c0517b = RecyclerView.this.mPrefetchRegistry;
                        int[] iArr7 = c0517b.f1834c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        c0517b.f1835d = 0;
                    }
                } else {
                    m1392a();
                    RecyclerView recyclerView7 = RecyclerView.this;
                    RunnableC0515V6 runnableC0515V6 = recyclerView7.mGapWorker;
                    if (runnableC0515V6 != null) {
                        runnableC0515V6.m1832a(recyclerView7, i2, i);
                    }
                }
            }
            AbstractC0857x abstractC0857x3 = RecyclerView.this.mLayout.mSmoothScroller;
            if (abstractC0857x3 != null && abstractC0857x3.isPendingInitialRun()) {
                abstractC0857x3.onAnimation(0, 0);
            }
            this.f3215f = false;
            if (this.f3216g) {
                RecyclerView.this.removeCallbacks(this);
                RecyclerView recyclerView8 = RecyclerView.this;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0495c.m1931m(recyclerView8, this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.stopNestedScroll(1);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$B */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0824B {
        public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        public static final int FLAG_BOUND = 1;
        public static final int FLAG_IGNORE = 128;
        public static final int FLAG_INVALID = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_NOT_RECYCLABLE = 16;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_RETURNED_FROM_SCRAP = 32;
        public static final int FLAG_TMP_DETACHED = 256;
        public static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        public int mFlags;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public RecyclerView mOwnerRecyclerView;
        public int mPosition = -1;
        public int mOldPosition = -1;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public int mPreLayoutPosition = -1;
        public AbstractC0824B mShadowedHolder = null;
        public AbstractC0824B mShadowingHolder = null;
        public List<Object> mPayloads = null;
        public List<Object> mUnmodifiedPayloads = null;
        private int mIsRecyclableCount = 0;
        public C0854u mScrapContainer = null;
        public boolean mInChangeScrap = false;
        private int mWasImportantForAccessibilityBeforeHidden = 0;
        public int mPendingAccessibilityState = -1;

        public AbstractC0824B(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0) {
                View view = this.itemView;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                if (C0492V4.C0495c.m1935i(view)) {
                    return true;
                }
            }
            return false;
        }

        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.getAdapterPositionFor(this);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) == 0) {
                List<Object> list = this.mPayloads;
                if (list != null && list.size() != 0) {
                    return this.mUnmodifiedPayloads;
                }
                return FULLUPDATE_PAYLOADS;
            }
            return FULLUPDATE_PAYLOADS;
        }

        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0) {
                View view = this.itemView;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                if (!C0492V4.C0495c.m1935i(view)) {
                    return true;
                }
            }
            return false;
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f3220c = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                View view = this.itemView;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                this.mWasImportantForAccessibilityBeforeHidden = C0492V4.C0495c.m1941c(view);
            }
            recyclerView.setChildImportantForAccessibilityInternal(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1L;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && i2 == 0) {
                this.mFlags &= -17;
            }
        }

        public void setScrapContainer(C0854u c0854u, boolean z) {
            this.mScrapContainer = c0854u;
            this.mInChangeScrap = z;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder m252s = outline.m252s(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            m252s.append(Integer.toHexString(hashCode()));
            m252s.append(" position=");
            m252s.append(this.mPosition);
            m252s.append(" id=");
            m252s.append(this.mItemId);
            m252s.append(", oldPos=");
            m252s.append(this.mOldPosition);
            m252s.append(", pLpos:");
            m252s.append(this.mPreLayoutPosition);
            StringBuilder sb = new StringBuilder(m252s.toString());
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder m253r = outline.m253r(" not recyclable(");
                m253r.append(this.mIsRecyclableCount);
                m253r.append(")");
                sb.append(m253r.toString());
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.m1348l(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0826a implements Runnable {
        public RunnableC0826a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.mFirstLayoutComplete || recyclerView.isLayoutRequested()) {
                return;
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            if (!recyclerView2.mIsAttached) {
                recyclerView2.requestLayout();
            } else if (recyclerView2.mLayoutSuppressed) {
                recyclerView2.mLayoutWasDefered = true;
            } else {
                recyclerView2.consumePendingUpdateOperations();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0827b implements Runnable {
        public RunnableC0827b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0837l abstractC0837l = RecyclerView.this.mItemAnimator;
            if (abstractC0837l != null) {
                C0454T6 c0454t6 = (C0454T6) abstractC0837l;
                boolean z = !c0454t6.f1572h.isEmpty();
                boolean z2 = !c0454t6.f1574j.isEmpty();
                boolean z3 = !c0454t6.f1575k.isEmpty();
                boolean z4 = !c0454t6.f1573i.isEmpty();
                if (z || z2 || z4 || z3) {
                    Iterator<AbstractC0824B> it = c0454t6.f1572h.iterator();
                    while (it.hasNext()) {
                        AbstractC0824B next = it.next();
                        View view = next.itemView;
                        ViewPropertyAnimator animate = view.animate();
                        c0454t6.f1581q.add(next);
                        animate.setDuration(c0454t6.f3231d).alpha(0.0f).setListener(new C0334O6(c0454t6, next, animate, view)).start();
                    }
                    c0454t6.f1572h.clear();
                    if (z2) {
                        ArrayList<C0454T6.C0456b> arrayList = new ArrayList<>();
                        arrayList.addAll(c0454t6.f1574j);
                        c0454t6.f1577m.add(arrayList);
                        c0454t6.f1574j.clear();
                        RunnableC0270L6 runnableC0270L6 = new RunnableC0270L6(c0454t6, arrayList);
                        if (z) {
                            View view2 = arrayList.get(0).f1589a.itemView;
                            long j = c0454t6.f3231d;
                            AtomicInteger atomicInteger = C0492V4.f1798a;
                            C0492V4.C0495c.m1930n(view2, runnableC0270L6, j);
                        } else {
                            runnableC0270L6.run();
                        }
                    }
                    if (z3) {
                        ArrayList<C0454T6.C0455a> arrayList2 = new ArrayList<>();
                        arrayList2.addAll(c0454t6.f1575k);
                        c0454t6.f1578n.add(arrayList2);
                        c0454t6.f1575k.clear();
                        RunnableC0289M6 runnableC0289M6 = new RunnableC0289M6(c0454t6, arrayList2);
                        if (z) {
                            View view3 = arrayList2.get(0).f1583a.itemView;
                            long j2 = c0454t6.f3231d;
                            AtomicInteger atomicInteger2 = C0492V4.f1798a;
                            C0492V4.C0495c.m1930n(view3, runnableC0289M6, j2);
                        } else {
                            runnableC0289M6.run();
                        }
                    }
                    if (z4) {
                        ArrayList<AbstractC0824B> arrayList3 = new ArrayList<>();
                        arrayList3.addAll(c0454t6.f1573i);
                        c0454t6.f1576l.add(arrayList3);
                        c0454t6.f1573i.clear();
                        RunnableC0312N6 runnableC0312N6 = new RunnableC0312N6(c0454t6, arrayList3);
                        if (!z && !z2 && !z3) {
                            runnableC0312N6.run();
                        } else {
                            long j3 = z ? c0454t6.f3231d : 0L;
                            long j4 = z2 ? c0454t6.f3232e : 0L;
                            long j5 = z3 ? c0454t6.f3233f : 0L;
                            View view4 = arrayList3.get(0).itemView;
                            AtomicInteger atomicInteger3 = C0492V4.f1798a;
                            C0492V4.C0495c.m1930n(view4, runnableC0312N6, Math.max(j4, j5) + j3);
                        }
                    }
                }
            }
            RecyclerView.this.mPostedAnimatorRunner = false;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$c  reason: invalid class name */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class animationInterpolatorC0828c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0829d implements C1891i7.InterfaceC1893b {
        public C0829d() {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0830e implements C0247K6.InterfaceC0249b {
        public C0830e() {
        }

        /* renamed from: a */
        public View m1386a(int i) {
            return RecyclerView.this.getChildAt(i);
        }

        /* renamed from: b */
        public int m1385b() {
            return RecyclerView.this.getChildCount();
        }

        /* renamed from: c */
        public void m1384c(int i) {
            View childAt = RecyclerView.this.getChildAt(i);
            if (childAt != null) {
                RecyclerView.this.dispatchChildDetached(childAt);
                childAt.clearAnimation();
            }
            RecyclerView.this.removeViewAt(i);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0831f implements C0217J6.InterfaceC0218a {
        public C0831f() {
        }

        /* renamed from: a */
        public void m1383a(C0217J6.C0219b c0219b) {
            int i = c0219b.f689a;
            if (i == 1) {
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mLayout.onItemsAdded(recyclerView, c0219b.f690b, c0219b.f692d);
            } else if (i == 2) {
                RecyclerView recyclerView2 = RecyclerView.this;
                recyclerView2.mLayout.onItemsRemoved(recyclerView2, c0219b.f690b, c0219b.f692d);
            } else if (i == 4) {
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.mLayout.onItemsUpdated(recyclerView3, c0219b.f690b, c0219b.f692d, c0219b.f691c);
            } else if (i != 8) {
            } else {
                RecyclerView recyclerView4 = RecyclerView.this;
                recyclerView4.mLayout.onItemsMoved(recyclerView4, c0219b.f690b, c0219b.f692d, 1);
            }
        }

        /* renamed from: b */
        public AbstractC0824B m1382b(int i) {
            AbstractC0824B findViewHolderForPosition = RecyclerView.this.findViewHolderForPosition(i, true);
            if (findViewHolderForPosition == null || RecyclerView.this.mChildHelper.m2245k(findViewHolderForPosition.itemView)) {
                return null;
            }
            return findViewHolderForPosition;
        }

        /* renamed from: c */
        public void m1381c(int i, int i2, Object obj) {
            RecyclerView.this.viewRangeUpdate(i, i2, obj);
            RecyclerView.this.mItemsChanged = true;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0833h extends Observable<AbstractC0834i> {
        /* renamed from: a */
        public boolean m1380a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        /* renamed from: b */
        public void m1379b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0834i) ((Observable) this).mObservers.get(size)).onChanged();
            }
        }

        /* renamed from: c */
        public void m1378c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0834i) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i, i2, 1);
            }
        }

        /* renamed from: d */
        public void m1377d(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0834i) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i, i2, obj);
            }
        }

        /* renamed from: e */
        public void m1376e(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0834i) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i, i2);
            }
        }

        /* renamed from: f */
        public void m1375f(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((AbstractC0834i) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i, i2);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0834i {
        public void onChanged() {
        }

        public void onItemRangeChanged(int i, int i2) {
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onItemRangeChanged(i, i2);
        }

        public void onItemRangeInserted(int i, int i2) {
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
        }

        public void onItemRangeRemoved(int i, int i2) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0835j {
        /* renamed from: a */
        int m1374a(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0836k {
        /* renamed from: a */
        public EdgeEffect m1373a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$l */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0837l {

        /* renamed from: a */
        public InterfaceC0839b f3228a = null;

        /* renamed from: b */
        public ArrayList<InterfaceC0838a> f3229b = new ArrayList<>();

        /* renamed from: c */
        public long f3230c = 120;

        /* renamed from: d */
        public long f3231d = 120;

        /* renamed from: e */
        public long f3232e = 250;

        /* renamed from: f */
        public long f3233f = 250;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$l$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public interface InterfaceC0838a {
            /* renamed from: a */
            void m1365a();
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$l$b */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public interface InterfaceC0839b {
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$l$c */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0840c {

            /* renamed from: a */
            public int f3234a;

            /* renamed from: b */
            public int f3235b;
        }

        /* renamed from: b */
        public static int m1372b(AbstractC0824B abstractC0824B) {
            int i = abstractC0824B.mFlags & 14;
            if (abstractC0824B.isInvalid()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int oldPosition = abstractC0824B.getOldPosition();
                int adapterPosition = abstractC0824B.getAdapterPosition();
                return (oldPosition == -1 || adapterPosition == -1 || oldPosition == adapterPosition) ? i : i | 2048;
            }
            return i;
        }

        /* renamed from: a */
        public abstract boolean mo986a(AbstractC0824B abstractC0824B, AbstractC0824B abstractC0824B2, C0840c c0840c, C0840c c0840c2);

        /* renamed from: c */
        public final void m1371c(AbstractC0824B abstractC0824B) {
            InterfaceC0839b interfaceC0839b = this.f3228a;
            if (interfaceC0839b != null) {
                C0841m c0841m = (C0841m) interfaceC0839b;
                Objects.requireNonNull(c0841m);
                abstractC0824B.setIsRecyclable(true);
                if (abstractC0824B.mShadowedHolder != null && abstractC0824B.mShadowingHolder == null) {
                    abstractC0824B.mShadowedHolder = null;
                }
                abstractC0824B.mShadowingHolder = null;
                if (abstractC0824B.shouldBeKeptAsChild() || RecyclerView.this.removeAnimatingView(abstractC0824B.itemView) || !abstractC0824B.isTmpDetached()) {
                    return;
                }
                RecyclerView.this.removeDetachedView(abstractC0824B.itemView, false);
            }
        }

        /* renamed from: d */
        public final void m1370d() {
            int size = this.f3229b.size();
            for (int i = 0; i < size; i++) {
                this.f3229b.get(i).m1365a();
            }
            this.f3229b.clear();
        }

        /* renamed from: e */
        public abstract void mo1369e(AbstractC0824B abstractC0824B);

        /* renamed from: f */
        public abstract void mo1368f();

        /* renamed from: g */
        public abstract boolean mo1367g();

        /* renamed from: h */
        public C0840c m1366h(AbstractC0824B abstractC0824B) {
            C0840c c0840c = new C0840c();
            View view = abstractC0824B.itemView;
            c0840c.f3234a = view.getLeft();
            c0840c.f3235b = view.getTop();
            view.getRight();
            view.getBottom();
            return c0840c;
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0841m implements AbstractC0837l.InterfaceC0839b {
        public C0841m() {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$n */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0842n {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, C0860y c0860y) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C0860y c0860y) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, C0860y c0860y) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).m1389a(), recyclerView);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$o */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0843o {
        public boolean mAutoMeasure;
        public C0247K6 mChildHelper;
        private int mHeight;
        private int mHeightMode;
        public C1862h7 mHorizontalBoundCheck;
        private final C1862h7.InterfaceC1864b mHorizontalBoundCheckCallback;
        public boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        public int mPrefetchMaxCountObserved;
        public boolean mPrefetchMaxObservedInInitialPrefetch;
        public RecyclerView mRecyclerView;
        public boolean mRequestedSimpleAnimations;
        public AbstractC0857x mSmoothScroller;
        public C1862h7 mVerticalBoundCheck;
        private final C1862h7.InterfaceC1864b mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0844a implements C1862h7.InterfaceC1864b {
            public C0844a() {
            }

            @Override // p000.C1862h7.InterfaceC1864b
            /* renamed from: a */
            public int mo770a() {
                return AbstractC0843o.this.getWidth() - AbstractC0843o.this.getPaddingRight();
            }

            @Override // p000.C1862h7.InterfaceC1864b
            /* renamed from: b */
            public int mo769b(View view) {
                return AbstractC0843o.this.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).leftMargin;
            }

            @Override // p000.C1862h7.InterfaceC1864b
            /* renamed from: c */
            public int mo768c() {
                return AbstractC0843o.this.getPaddingLeft();
            }

            @Override // p000.C1862h7.InterfaceC1864b
            /* renamed from: d */
            public int mo767d(View view) {
                return AbstractC0843o.this.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).rightMargin;
            }

            @Override // p000.C1862h7.InterfaceC1864b
            public View getChildAt(int i) {
                return AbstractC0843o.this.getChildAt(i);
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$b */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0845b implements C1862h7.InterfaceC1864b {
            public C0845b() {
            }

            @Override // p000.C1862h7.InterfaceC1864b
            /* renamed from: a */
            public int mo770a() {
                return AbstractC0843o.this.getHeight() - AbstractC0843o.this.getPaddingBottom();
            }

            @Override // p000.C1862h7.InterfaceC1864b
            /* renamed from: b */
            public int mo769b(View view) {
                return AbstractC0843o.this.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).topMargin;
            }

            @Override // p000.C1862h7.InterfaceC1864b
            /* renamed from: c */
            public int mo768c() {
                return AbstractC0843o.this.getPaddingTop();
            }

            @Override // p000.C1862h7.InterfaceC1864b
            /* renamed from: d */
            public int mo767d(View view) {
                return AbstractC0843o.this.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((LayoutParams) view.getLayoutParams())).bottomMargin;
            }

            @Override // p000.C1862h7.InterfaceC1864b
            public View getChildAt(int i) {
                return AbstractC0843o.this.getChildAt(i);
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$c */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public interface InterfaceC0846c {
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$o$d */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0847d {

            /* renamed from: a */
            public int f3239a;

            /* renamed from: b */
            public int f3240b;

            /* renamed from: c */
            public boolean f3241c;

            /* renamed from: d */
            public boolean f3242d;
        }

        public AbstractC0843o() {
            C0844a c0844a = new C0844a();
            this.mHorizontalBoundCheckCallback = c0844a;
            C0845b c0845b = new C0845b();
            this.mVerticalBoundCheckCallback = c0845b;
            this.mHorizontalBoundCheck = new C1862h7(c0844a);
            this.mVerticalBoundCheck = new C1862h7(c0845b);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View view, int i, boolean z) {
            AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!z && !childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.m737f(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.m742a(childViewHolderInt);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (!childViewHolderInt.wasReturnedFromScrap() && !childViewHolderInt.isScrap()) {
                if (view.getParent() == this.mRecyclerView) {
                    int m2246j = this.mChildHelper.m2246j(view);
                    if (i == -1) {
                        i = this.mChildHelper.m2251e();
                    }
                    if (m2246j == -1) {
                        StringBuilder m253r = outline.m253r("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        m253r.append(this.mRecyclerView.indexOfChild(view));
                        throw new IllegalStateException(outline.m276E(this.mRecyclerView, m253r));
                    } else if (m2246j != i) {
                        this.mRecyclerView.mLayout.moveView(m2246j, i);
                    }
                } else {
                    this.mChildHelper.m2255a(view, i, false);
                    layoutParams.f3220c = true;
                    AbstractC0857x abstractC0857x = this.mSmoothScroller;
                    if (abstractC0857x != null && abstractC0857x.isRunning()) {
                        this.mSmoothScroller.onChildAttachedToWindow(view);
                    }
                }
            } else {
                if (childViewHolderInt.isScrap()) {
                    childViewHolderInt.unScrap();
                } else {
                    childViewHolderInt.clearReturnedFromScrapFlag();
                }
                this.mChildHelper.m2254b(view, i, view.getLayoutParams(), false);
            }
            if (layoutParams.f3221d) {
                childViewHolderInt.itemView.invalidate();
                layoutParams.f3221d = false;
            }
        }

        public static int chooseSize(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        private void detachViewInternal(int i, View view) {
            this.mChildHelper.m2253c(i);
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x000a, code lost:
            if (r3 >= 0) goto L8;
         */
        @java.lang.Deprecated
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            /*
                int r1 = r1 - r2
                r2 = 0
                int r1 = java.lang.Math.max(r2, r1)
                r0 = 1073741824(0x40000000, float:2.0)
                if (r4 == 0) goto Lf
                if (r3 < 0) goto Ld
                goto L11
            Ld:
                r3 = 0
                goto L21
            Lf:
                if (r3 < 0) goto L14
            L11:
                r2 = 1073741824(0x40000000, float:2.0)
                goto L21
            L14:
                r4 = -1
                if (r3 != r4) goto L1b
                r2 = 1073741824(0x40000000, float:2.0)
            L19:
                r3 = r1
                goto L21
            L1b:
                r4 = -2
                if (r3 != r4) goto Ld
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L19
            L21:
                int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AbstractC0843o.getChildMeasureSpec(int, int, int, boolean):int");
        }

        private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
            int[] iArr = new int[2];
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width2 = rect.width() + left;
            int height2 = rect.height() + top;
            int i = left - paddingLeft;
            int min = Math.min(0, i);
            int i2 = top - paddingTop;
            int min2 = Math.min(0, i2);
            int i3 = width2 - width;
            int max = Math.max(0, i3);
            int max2 = Math.max(0, height2 - height);
            if (getLayoutDirection() != 1) {
                if (min == 0) {
                    min = Math.min(i, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i3);
            }
            if (min2 == 0) {
                min2 = Math.min(i2, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        public static C0847d getProperties(Context context, AttributeSet attributeSet, int i, int i2) {
            C0847d c0847d = new C0847d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0198I6.RecyclerView, i, i2);
            c0847d.f3239a = obtainStyledAttributes.getInt(C0198I6.RecyclerView_android_orientation, 1);
            c0847d.f3240b = obtainStyledAttributes.getInt(C0198I6.RecyclerView_spanCount, 1);
            c0847d.f3241c = obtainStyledAttributes.getBoolean(C0198I6.RecyclerView_reverseLayout, false);
            c0847d.f3242d = obtainStyledAttributes.getBoolean(C0198I6.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return c0847d;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(focusedChild, rect);
            return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
        }

        private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 <= 0 || i == i3) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i;
                } else {
                    return true;
                }
            }
            return false;
        }

        private void scrapOrRecycleView(C0854u c0854u, int i, View view) {
            AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.shouldIgnore()) {
                return;
            }
            if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
                removeViewAt(i);
                c0854u.m1351i(childViewHolderInt);
                return;
            }
            detachViewAt(i);
            c0854u.m1350j(view);
            this.mRecyclerView.mViewInfoStore.m737f(childViewHolderInt);
        }

        public void addDisappearingView(View view) {
            addDisappearingView(view, -1);
        }

        public void addView(View view) {
            addView(view, -1);
        }

        public void assertInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertInLayoutOrScroll(str);
            }
        }

        public void assertNotInLayoutOrScroll(String str) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.assertNotInLayoutOrScroll(str);
            }
        }

        public void attachView(View view, int i, LayoutParams layoutParams) {
            AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isRemoved()) {
                this.mRecyclerView.mViewInfoStore.m742a(childViewHolderInt);
            } else {
                this.mRecyclerView.mViewInfoStore.m737f(childViewHolderInt);
            }
            this.mChildHelper.m2254b(view, i, layoutParams, childViewHolderInt.isRemoved());
        }

        public void calculateItemDecorationsForChild(View view, Rect rect) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.getItemDecorInsetsForChild(view));
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        public void collectAdjacentPrefetchPositions(int i, int i2, C0860y c0860y, InterfaceC0846c interfaceC0846c) {
        }

        public void collectInitialPrefetchPositions(int i, InterfaceC0846c interfaceC0846c) {
        }

        public int computeHorizontalScrollExtent(C0860y c0860y) {
            return 0;
        }

        public int computeHorizontalScrollOffset(C0860y c0860y) {
            return 0;
        }

        public int computeHorizontalScrollRange(C0860y c0860y) {
            return 0;
        }

        public int computeVerticalScrollExtent(C0860y c0860y) {
            return 0;
        }

        public int computeVerticalScrollOffset(C0860y c0860y) {
            return 0;
        }

        public int computeVerticalScrollRange(C0860y c0860y) {
            return 0;
        }

        public void detachAndScrapAttachedViews(C0854u c0854u) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                scrapOrRecycleView(c0854u, childCount, getChildAt(childCount));
            }
        }

        public void detachAndScrapView(View view, C0854u c0854u) {
            scrapOrRecycleView(c0854u, this.mChildHelper.m2246j(view), view);
        }

        public void detachAndScrapViewAt(int i, C0854u c0854u) {
            scrapOrRecycleView(c0854u, i, getChildAt(i));
        }

        public void detachView(View view) {
            int m2246j = this.mChildHelper.m2246j(view);
            if (m2246j >= 0) {
                detachViewInternal(m2246j, view);
            }
        }

        public void detachViewAt(int i) {
            detachViewInternal(i, getChildAt(i));
        }

        public void dispatchAttachedToWindow(RecyclerView recyclerView) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(recyclerView);
        }

        public void dispatchDetachedFromWindow(RecyclerView recyclerView, C0854u c0854u) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(recyclerView, c0854u);
        }

        public void endAnimation(View view) {
            AbstractC0837l abstractC0837l = this.mRecyclerView.mItemAnimator;
            if (abstractC0837l != null) {
                abstractC0837l.mo1369e(RecyclerView.getChildViewHolderInt(view));
            }
        }

        public View findContainingItemView(View view) {
            View findContainingItemView;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (findContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.f782c.contains(findContainingItemView)) {
                return null;
            }
            return findContainingItemView;
        }

        public View findViewByPosition(int i) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
                if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.f3271g || !childViewHolderInt.isRemoved())) {
                    return childAt;
                }
            }
            return null;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof LayoutParams) {
                return new LayoutParams((LayoutParams) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new LayoutParams(layoutParams);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3219b.bottom;
        }

        public View getChildAt(int i) {
            C0247K6 c0247k6 = this.mChildHelper;
            if (c0247k6 != null) {
                return ((C0830e) c0247k6.f780a).m1386a(c0247k6.m2250f(i));
            }
            return null;
        }

        public int getChildCount() {
            C0247K6 c0247k6 = this.mChildHelper;
            if (c0247k6 != null) {
                return c0247k6.m2251e();
            }
            return 0;
        }

        public boolean getClipToPadding() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.mClipToPadding;
        }

        public int getColumnCountForAccessibility(C0854u c0854u, C0860y c0860y) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollHorizontally()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getDecoratedBottom(View view) {
            return getBottomDecorationHeight(view) + view.getBottom();
        }

        public void getDecoratedBoundsWithMargins(View view, Rect rect) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
        }

        public int getDecoratedLeft(View view) {
            return view.getLeft() - getLeftDecorationWidth(view);
        }

        public int getDecoratedMeasuredHeight(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f3219b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int getDecoratedMeasuredWidth(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f3219b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int getDecoratedRight(View view) {
            return getRightDecorationWidth(view) + view.getRight();
        }

        public int getDecoratedTop(View view) {
            return view.getTop() - getTopDecorationHeight(view);
        }

        public View getFocusedChild() {
            View focusedChild;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.f782c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView recyclerView = this.mRecyclerView;
            AbstractC0832g adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int getItemViewType(View view) {
            return RecyclerView.getChildViewHolderInt(view).getItemViewType();
        }

        public int getLayoutDirection() {
            RecyclerView recyclerView = this.mRecyclerView;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            return C0492V4.C0496d.m1921d(recyclerView);
        }

        public int getLeftDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3219b.left;
        }

        public int getMinimumHeight() {
            RecyclerView recyclerView = this.mRecyclerView;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            return C0492V4.C0495c.m1940d(recyclerView);
        }

        public int getMinimumWidth() {
            RecyclerView recyclerView = this.mRecyclerView;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            return C0492V4.C0495c.m1939e(recyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                AtomicInteger atomicInteger = C0492V4.f1798a;
                return C0492V4.C0496d.m1920e(recyclerView);
            }
            return 0;
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                AtomicInteger atomicInteger = C0492V4.f1798a;
                return C0492V4.C0496d.m1919f(recyclerView);
            }
            return 0;
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int getPosition(View view) {
            return ((LayoutParams) view.getLayoutParams()).m1389a();
        }

        public int getRightDecorationWidth(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3219b.right;
        }

        public int getRowCountForAccessibility(C0854u c0854u, C0860y c0860y) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || recyclerView.mAdapter == null || !canScrollVertically()) {
                return 1;
            }
            return this.mRecyclerView.mAdapter.getItemCount();
        }

        public int getSelectionModeForAccessibility(C0854u c0854u, C0860y c0860y) {
            return 0;
        }

        public int getTopDecorationHeight(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3219b.top;
        }

        public void getTransformedBoundingBox(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f3219b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.mRecyclerView.mTempRectF;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ViewGroup.LayoutParams layoutParams = getChildAt(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean hasFocus() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.hasFocus();
        }

        public void ignoreView(View view) {
            ViewParent parent = view.getParent();
            RecyclerView recyclerView = this.mRecyclerView;
            if (parent == recyclerView && recyclerView.indexOfChild(view) != -1) {
                AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                childViewHolderInt.addFlags(128);
                this.mRecyclerView.mViewInfoStore.m736g(childViewHolderInt);
                return;
            }
            throw new IllegalArgumentException(outline.m276E(this.mRecyclerView, outline.m253r("View should be fully attached to be ignored")));
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView recyclerView = this.mRecyclerView;
            return recyclerView != null && recyclerView.isFocused();
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(C0854u c0854u, C0860y c0860y) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            AbstractC0857x abstractC0857x = this.mSmoothScroller;
            return abstractC0857x != null && abstractC0857x.isRunning();
        }

        public boolean isViewPartiallyVisible(View view, boolean z, boolean z2) {
            boolean z3 = this.mHorizontalBoundCheck.m773b(view, 24579) && this.mVerticalBoundCheck.m773b(view, 24579);
            return z ? z3 : !z3;
        }

        public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f3219b;
            view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f3219b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        }

        public void measureChild(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void measureChildWithMargins(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
            int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
            int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
            int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i3, ((ViewGroup.MarginLayoutParams) layoutParams).width, canScrollHorizontally());
            int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, canScrollVertically());
            if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, layoutParams)) {
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }

        public void moveView(int i, int i2) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                detachViewAt(i);
                attachView(childAt, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenHorizontal(i);
            }
        }

        public void offsetChildrenVertical(int i) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.offsetChildrenVertical(i);
            }
        }

        public void onAdapterChanged(AbstractC0832g abstractC0832g, AbstractC0832g abstractC0832g2) {
        }

        public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView recyclerView) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView recyclerView) {
        }

        public void onDetachedFromWindow(RecyclerView recyclerView, C0854u c0854u) {
            onDetachedFromWindow(recyclerView);
        }

        public View onFocusSearchFailed(View view, int i, C0854u c0854u, C0860y c0860y) {
            return null;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(C1617d5 c1617d5) {
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, c1617d5);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View view, C1617d5 c1617d5) {
            AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.m2245k(childViewHolderInt.itemView)) {
                return;
            }
            RecyclerView recyclerView = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, c1617d5);
        }

        public View onInterceptFocusSearch(View view, int i) {
            return null;
        }

        public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsChanged(RecyclerView recyclerView) {
        }

        public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        }

        public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        }

        public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
            onItemsUpdated(recyclerView, i, i2);
        }

        public void onLayoutChildren(C0854u c0854u, C0860y c0860y) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public void onLayoutCompleted(C0860y c0860y) {
        }

        public void onMeasure(C0854u c0854u, C0860y c0860y, int i, int i2) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
        }

        @Deprecated
        public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
            return isSmoothScrolling() || recyclerView.isComputingLayout();
        }

        public void onRestoreInstanceState(Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int i) {
        }

        public void onSmoothScrollerStopped(AbstractC0857x abstractC0857x) {
            if (this.mSmoothScroller == abstractC0857x) {
                this.mSmoothScroller = null;
            }
        }

        public boolean performAccessibilityAction(int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
        }

        public boolean performAccessibilityActionForItem(View view, int i, Bundle bundle) {
            RecyclerView recyclerView = this.mRecyclerView;
            return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
        }

        public boolean performAccessibilityActionForItem(C0854u c0854u, C0860y c0860y, View view, int i, Bundle bundle) {
            return false;
        }

        public void postOnAnimation(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0495c.m1931m(recyclerView, runnable);
            }
        }

        public void removeAllViews() {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                this.mChildHelper.m2244l(childCount);
            }
        }

        public void removeAndRecycleAllViews(C0854u c0854u) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                    removeAndRecycleViewAt(childCount, c0854u);
                }
            }
        }

        public void removeAndRecycleScrapInt(C0854u c0854u) {
            int size = c0854u.f3249a.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = c0854u.f3249a.get(i).itemView;
                AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
                if (!childViewHolderInt.shouldIgnore()) {
                    childViewHolderInt.setIsRecyclable(false);
                    if (childViewHolderInt.isTmpDetached()) {
                        this.mRecyclerView.removeDetachedView(view, false);
                    }
                    AbstractC0837l abstractC0837l = this.mRecyclerView.mItemAnimator;
                    if (abstractC0837l != null) {
                        abstractC0837l.mo1369e(childViewHolderInt);
                    }
                    childViewHolderInt.setIsRecyclable(true);
                    AbstractC0824B childViewHolderInt2 = RecyclerView.getChildViewHolderInt(view);
                    childViewHolderInt2.mScrapContainer = null;
                    childViewHolderInt2.mInChangeScrap = false;
                    childViewHolderInt2.clearReturnedFromScrapFlag();
                    c0854u.m1351i(childViewHolderInt2);
                }
            }
            c0854u.f3249a.clear();
            ArrayList<AbstractC0824B> arrayList = c0854u.f3250b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.mRecyclerView.invalidate();
            }
        }

        public void removeAndRecycleView(View view, C0854u c0854u) {
            removeView(view);
            c0854u.m1352h(view);
        }

        public void removeAndRecycleViewAt(int i, C0854u c0854u) {
            View childAt = getChildAt(i);
            removeViewAt(i);
            c0854u.m1352h(childAt);
        }

        public boolean removeCallbacks(Runnable runnable) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public void removeDetachedView(View view) {
            this.mRecyclerView.removeDetachedView(view, false);
        }

        public void removeView(View view) {
            C0247K6 c0247k6 = this.mChildHelper;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild < 0) {
                return;
            }
            if (c0247k6.f781b.m2237f(indexOfChild)) {
                c0247k6.m2243m(view);
            }
            ((C0830e) c0247k6.f780a).m1384c(indexOfChild);
        }

        public void removeViewAt(int i) {
            if (getChildAt(i) != null) {
                this.mChildHelper.m2244l(i);
            }
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return requestChildRectangleOnScreen(recyclerView, view, rect, z, false);
        }

        public void requestLayout() {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int i, C0854u c0854u, C0860y c0860y) {
            return 0;
        }

        public void scrollToPosition(int i) {
        }

        public int scrollVerticallyBy(int i, C0854u c0854u, C0860y c0860y) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean z) {
            this.mAutoMeasure = z;
        }

        public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean z) {
            if (z != this.mItemPrefetchEnabled) {
                this.mItemPrefetchEnabled = z;
                this.mPrefetchMaxCountObserved = 0;
                RecyclerView recyclerView = this.mRecyclerView;
                if (recyclerView != null) {
                    recyclerView.mRecycler.m1347m();
                }
            }
        }

        public void setMeasureSpecs(int i, int i2) {
            this.mWidth = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.mWidthMode = mode;
            if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                this.mWidth = 0;
            }
            this.mHeight = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mHeightMode = mode2;
            if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
                return;
            }
            this.mHeight = 0;
        }

        public void setMeasuredDimension(Rect rect, int i, int i2) {
            setMeasuredDimension(chooseSize(i, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i2, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int i, int i2) {
            int childCount = getChildCount();
            if (childCount == 0) {
                this.mRecyclerView.defaultOnMeasure(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                Rect rect = this.mRecyclerView.mTempRect;
                getDecoratedBoundsWithMargins(childAt, rect);
                int i8 = rect.left;
                if (i8 < i5) {
                    i5 = i8;
                }
                int i9 = rect.right;
                if (i9 > i3) {
                    i3 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i4) {
                    i4 = i11;
                }
            }
            this.mRecyclerView.mTempRect.set(i5, i6, i3, i4);
            setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
        }

        public void setMeasurementCacheEnabled(boolean z) {
            this.mMeasurementCacheEnabled = z;
        }

        public void setRecyclerView(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.mRecyclerView = null;
                this.mChildHelper = null;
                this.mWidth = 0;
                this.mHeight = 0;
            } else {
                this.mRecyclerView = recyclerView;
                this.mChildHelper = recyclerView.mChildHelper;
                this.mWidth = recyclerView.getWidth();
                this.mHeight = recyclerView.getHeight();
            }
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
        }

        public boolean shouldMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View view, int i, int i2, LayoutParams layoutParams) {
            return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, C0860y c0860y, int i) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(AbstractC0857x abstractC0857x) {
            AbstractC0857x abstractC0857x2 = this.mSmoothScroller;
            if (abstractC0857x2 != null && abstractC0857x != abstractC0857x2 && abstractC0857x2.isRunning()) {
                this.mSmoothScroller.stop();
            }
            this.mSmoothScroller = abstractC0857x;
            abstractC0857x.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View view) {
            AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            childViewHolderInt.stopIgnoring();
            childViewHolderInt.resetInternal();
            childViewHolderInt.addFlags(4);
        }

        public void stopSmoothScroller() {
            AbstractC0857x abstractC0857x = this.mSmoothScroller;
            if (abstractC0857x != null) {
                abstractC0857x.stop();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public void addDisappearingView(View view, int i) {
            addViewInt(view, i, true);
        }

        public void addView(View view, int i) {
            addViewInt(view, i, false);
        }

        public void onInitializeAccessibilityEvent(C0854u c0854u, C0860y c0860y, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            AbstractC0832g abstractC0832g = this.mRecyclerView.mAdapter;
            if (abstractC0832g != null) {
                accessibilityEvent.setItemCount(abstractC0832g.getItemCount());
            }
        }

        public void onInitializeAccessibilityNodeInfo(C0854u c0854u, C0860y c0860y, C1617d5 c1617d5) {
            if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
                c1617d5.f3986a.addAction(8192);
                c1617d5.f3986a.setScrollable(true);
            }
            if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
                c1617d5.f3986a.addAction(4096);
                c1617d5.f3986a.setScrollable(true);
            }
            c1617d5.m1019n(C1617d5.C1619b.m1013a(getRowCountForAccessibility(c0854u, c0860y), getColumnCountForAccessibility(c0854u, c0860y), isLayoutHierarchical(c0854u, c0860y), getSelectionModeForAccessibility(c0854u, c0860y)));
        }

        public boolean onRequestChildFocus(RecyclerView recyclerView, C0860y c0860y, View view, View view2) {
            return onRequestChildFocus(recyclerView, view, view2);
        }

        public boolean performAccessibilityAction(C0854u c0854u, C0860y c0860y, int i, Bundle bundle) {
            int height;
            int width;
            int i2;
            int i3;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView == null) {
                return false;
            }
            if (i == 4096) {
                height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
                if (this.mRecyclerView.canScrollHorizontally(1)) {
                    width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            } else if (i != 8192) {
                i3 = 0;
                i2 = 0;
            } else {
                height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
                if (this.mRecyclerView.canScrollHorizontally(-1)) {
                    width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                    i2 = height;
                    i3 = width;
                }
                i2 = height;
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
            return true;
        }

        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
            int i = childRectangleOnScreenScrollAmount[0];
            int i2 = childRectangleOnScreenScrollAmount[1];
            if ((!z2 || isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) && !(i == 0 && i2 == 0)) {
                if (z) {
                    recyclerView.scrollBy(i, i2);
                } else {
                    recyclerView.smoothScrollBy(i, i2);
                }
                return true;
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (r5 == 1073741824) goto L8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L1a
                if (r7 < 0) goto L11
                goto L1c
            L11:
                if (r7 != r1) goto L2f
                if (r5 == r2) goto L21
                if (r5 == 0) goto L2f
                if (r5 == r3) goto L21
                goto L2f
            L1a:
                if (r7 < 0) goto L1f
            L1c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L31
            L1f:
                if (r7 != r1) goto L23
            L21:
                r7 = r4
                goto L31
            L23:
                if (r7 != r0) goto L2f
                if (r5 == r2) goto L2c
                if (r5 != r3) goto L2a
                goto L2c
            L2a:
                r5 = 0
                goto L21
            L2c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L21
            L2f:
                r5 = 0
                r7 = 0
            L31:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AbstractC0843o.getChildMeasureSpec(int, int, int, int, boolean):int");
        }

        public void onInitializeAccessibilityNodeInfoForItem(C0854u c0854u, C0860y c0860y, View view, C1617d5 c1617d5) {
            c1617d5.m1018o(C1617d5.C1620c.m1012a(canScrollVertically() ? getPosition(view) : 0, 1, canScrollHorizontally() ? getPosition(view) : 0, 1, false, false));
        }

        public void attachView(View view, int i) {
            attachView(view, i, (LayoutParams) view.getLayoutParams());
        }

        public LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public void setMeasuredDimension(int i, int i2) {
            this.mRecyclerView.setMeasuredDimension(i, i2);
        }

        public void attachView(View view) {
            attachView(view, -1);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$p */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0848p {
        /* renamed from: a */
        void mo298a(View view);

        /* renamed from: b */
        void mo297b(View view);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$q */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0849q {
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$r */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0850r {
        /* renamed from: a */
        boolean mo1364a(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: b */
        void mo1363b(RecyclerView recyclerView, MotionEvent motionEvent);

        /* renamed from: c */
        void mo1362c(boolean z);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$s */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0851s {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$t */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0852t {

        /* renamed from: a */
        public SparseArray<C0853a> f3243a = new SparseArray<>();

        /* renamed from: b */
        public int f3244b = 0;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$t$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0853a {

            /* renamed from: a */
            public final ArrayList<AbstractC0824B> f3245a = new ArrayList<>();

            /* renamed from: b */
            public int f3246b = 5;

            /* renamed from: c */
            public long f3247c = 0;

            /* renamed from: d */
            public long f3248d = 0;
        }

        /* renamed from: a */
        public final C0853a m1361a(int i) {
            C0853a c0853a = this.f3243a.get(i);
            if (c0853a == null) {
                C0853a c0853a2 = new C0853a();
                this.f3243a.put(i, c0853a2);
                return c0853a2;
            }
            return c0853a;
        }

        /* renamed from: b */
        public long m1360b(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$u */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0854u {

        /* renamed from: a */
        public final ArrayList<AbstractC0824B> f3249a;

        /* renamed from: b */
        public ArrayList<AbstractC0824B> f3250b;

        /* renamed from: c */
        public final ArrayList<AbstractC0824B> f3251c;

        /* renamed from: d */
        public final List<AbstractC0824B> f3252d;

        /* renamed from: e */
        public int f3253e;

        /* renamed from: f */
        public int f3254f;

        /* renamed from: g */
        public C0852t f3255g;

        public C0854u() {
            ArrayList<AbstractC0824B> arrayList = new ArrayList<>();
            this.f3249a = arrayList;
            this.f3250b = null;
            this.f3251c = new ArrayList<>();
            this.f3252d = Collections.unmodifiableList(arrayList);
            this.f3253e = 2;
            this.f3254f = 2;
        }

        /* renamed from: a */
        public void m1359a(AbstractC0824B abstractC0824B, boolean z) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(abstractC0824B);
            View view = abstractC0824B.itemView;
            C1659e7 c1659e7 = RecyclerView.this.mAccessibilityDelegate;
            if (c1659e7 != null) {
                C0130F4 itemDelegate = c1659e7.getItemDelegate();
                C0492V4.m1950u(view, itemDelegate instanceof C1659e7.C1660a ? ((C1659e7.C1660a) itemDelegate).f4142b.remove(view) : null);
            }
            if (z) {
                InterfaceC0855v interfaceC0855v = RecyclerView.this.mRecyclerListener;
                if (interfaceC0855v != null) {
                    interfaceC0855v.m1346a(abstractC0824B);
                }
                AbstractC0832g abstractC0832g = RecyclerView.this.mAdapter;
                if (abstractC0832g != null) {
                    abstractC0832g.onViewRecycled(abstractC0824B);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mState != null) {
                    recyclerView.mViewInfoStore.m736g(abstractC0824B);
                }
            }
            abstractC0824B.mOwnerRecyclerView = null;
            C0852t m1356d = m1356d();
            Objects.requireNonNull(m1356d);
            int itemViewType = abstractC0824B.getItemViewType();
            ArrayList<AbstractC0824B> arrayList = m1356d.m1361a(itemViewType).f3245a;
            if (m1356d.f3243a.get(itemViewType).f3246b <= arrayList.size()) {
                return;
            }
            abstractC0824B.resetInternal();
            arrayList.add(abstractC0824B);
        }

        /* renamed from: b */
        public void m1358b() {
            this.f3249a.clear();
            m1354f();
        }

        /* renamed from: c */
        public int m1357c(int i) {
            if (i >= 0 && i < RecyclerView.this.mState.m1341b()) {
                RecyclerView recyclerView = RecyclerView.this;
                return !recyclerView.mState.f3271g ? i : recyclerView.mAdapterHelper.m2367f(i, 0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("invalid position ");
            sb.append(i);
            sb.append(". State item count is ");
            sb.append(RecyclerView.this.mState.m1341b());
            throw new IndexOutOfBoundsException(outline.m276E(RecyclerView.this, sb));
        }

        /* renamed from: d */
        public C0852t m1356d() {
            if (this.f3255g == null) {
                this.f3255g = new C0852t();
            }
            return this.f3255g;
        }

        /* renamed from: e */
        public final void m1355e(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    m1355e((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        /* renamed from: f */
        public void m1354f() {
            for (int size = this.f3251c.size() - 1; size >= 0; size--) {
                m1353g(size);
            }
            this.f3251c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK) {
                RunnableC0515V6.C0517b c0517b = RecyclerView.this.mPrefetchRegistry;
                int[] iArr = c0517b.f1834c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                c0517b.f1835d = 0;
            }
        }

        /* renamed from: g */
        public void m1353g(int i) {
            m1359a(this.f3251c.get(i), true);
            this.f3251c.remove(i);
        }

        /* renamed from: h */
        public void m1352h(View view) {
            AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else if (childViewHolderInt.wasReturnedFromScrap()) {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            m1351i(childViewHolderInt);
            if (RecyclerView.this.mItemAnimator == null || childViewHolderInt.isRecyclable()) {
                return;
            }
            RecyclerView.this.mItemAnimator.mo1369e(childViewHolderInt);
        }

        /* renamed from: i */
        public void m1351i(AbstractC0824B abstractC0824B) {
            boolean z = true;
            if (!abstractC0824B.isScrap() && abstractC0824B.itemView.getParent() == null) {
                if (!abstractC0824B.isTmpDetached()) {
                    if (!abstractC0824B.shouldIgnore()) {
                        boolean doesTransientStatePreventRecycling = abstractC0824B.doesTransientStatePreventRecycling();
                        AbstractC0832g abstractC0832g = RecyclerView.this.mAdapter;
                        if ((abstractC0832g != null && doesTransientStatePreventRecycling && abstractC0832g.onFailedToRecycleView(abstractC0824B)) || abstractC0824B.isRecyclable()) {
                            if (this.f3254f <= 0 || abstractC0824B.hasAnyOfTheFlags(526)) {
                                r1 = false;
                            } else {
                                int size = this.f3251c.size();
                                if (size >= this.f3254f && size > 0) {
                                    m1353g(0);
                                    size--;
                                }
                                if (RecyclerView.ALLOW_THREAD_GAP_WORK && size > 0 && !RecyclerView.this.mPrefetchRegistry.m1827c(abstractC0824B.mPosition)) {
                                    do {
                                        size--;
                                        if (size < 0) {
                                            break;
                                        }
                                    } while (RecyclerView.this.mPrefetchRegistry.m1827c(this.f3251c.get(size).mPosition));
                                    size++;
                                }
                                this.f3251c.add(size, abstractC0824B);
                                r1 = true;
                            }
                            if (!r1) {
                                m1359a(abstractC0824B, true);
                                RecyclerView.this.mViewInfoStore.m736g(abstractC0824B);
                                if (r1 && !z && doesTransientStatePreventRecycling) {
                                    abstractC0824B.mOwnerRecyclerView = null;
                                    return;
                                }
                                return;
                            }
                        }
                        z = false;
                        RecyclerView.this.mViewInfoStore.m736g(abstractC0824B);
                        if (r1) {
                            return;
                        }
                        return;
                    }
                    throw new IllegalArgumentException(outline.m276E(RecyclerView.this, outline.m253r("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(abstractC0824B);
                throw new IllegalArgumentException(outline.m276E(RecyclerView.this, sb));
            }
            StringBuilder m253r = outline.m253r("Scrapped or attached views may not be recycled. isScrap:");
            m253r.append(abstractC0824B.isScrap());
            m253r.append(" isAttached:");
            m253r.append(abstractC0824B.itemView.getParent() != null);
            throw new IllegalArgumentException(outline.m276E(RecyclerView.this, m253r));
        }

        /* renamed from: j */
        public void m1350j(View view) {
            AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (!childViewHolderInt.hasAnyOfTheFlags(12) && childViewHolderInt.isUpdated() && !RecyclerView.this.canReuseUpdatedViewHolder(childViewHolderInt)) {
                if (this.f3250b == null) {
                    this.f3250b = new ArrayList<>();
                }
                childViewHolderInt.setScrapContainer(this, true);
                this.f3250b.add(childViewHolderInt);
            } else if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !RecyclerView.this.mAdapter.hasStableIds()) {
                throw new IllegalArgumentException(outline.m276E(RecyclerView.this, outline.m253r("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            } else {
                childViewHolderInt.setScrapContainer(this, false);
                this.f3249a.add(childViewHolderInt);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:162:0x0318, code lost:
            r7 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:166:0x0323, code lost:
            r7 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:236:0x0485, code lost:
            if ((r8 == 0 || r8 + r5 < r21) == false) goto L230;
         */
        /* JADX WARN: Removed duplicated region for block: B:130:0x025d  */
        /* JADX WARN: Removed duplicated region for block: B:215:0x041c  */
        /* JADX WARN: Removed duplicated region for block: B:229:0x046e  */
        /* JADX WARN: Removed duplicated region for block: B:240:0x04b1  */
        /* JADX WARN: Removed duplicated region for block: B:255:0x04ec  */
        /* JADX WARN: Removed duplicated region for block: B:259:0x04f7  */
        /* JADX WARN: Removed duplicated region for block: B:260:0x0505  */
        /* JADX WARN: Removed duplicated region for block: B:266:0x0521 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x01c2  */
        /* renamed from: k */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public androidx.recyclerview.widget.RecyclerView.AbstractC0824B m1349k(int r19, boolean r20, long r21) {
            /*
                Method dump skipped, instructions count: 1370
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C0854u.m1349k(int, boolean, long):androidx.recyclerview.widget.RecyclerView$B");
        }

        /* renamed from: l */
        public void m1348l(AbstractC0824B abstractC0824B) {
            if (abstractC0824B.mInChangeScrap) {
                this.f3250b.remove(abstractC0824B);
            } else {
                this.f3249a.remove(abstractC0824B);
            }
            abstractC0824B.mScrapContainer = null;
            abstractC0824B.mInChangeScrap = false;
            abstractC0824B.clearReturnedFromScrapFlag();
        }

        /* renamed from: m */
        public void m1347m() {
            AbstractC0843o abstractC0843o = RecyclerView.this.mLayout;
            this.f3254f = this.f3253e + (abstractC0843o != null ? abstractC0843o.mPrefetchMaxCountObserved : 0);
            for (int size = this.f3251c.size() - 1; size >= 0 && this.f3251c.size() > this.f3254f; size--) {
                m1353g(size);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$v */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0855v {
        /* renamed from: a */
        void m1346a(AbstractC0824B abstractC0824B);
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$w */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0856w extends AbstractC0834i {
        public C0856w() {
        }

        /* renamed from: a */
        public void m1345a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.mHasFixedSize && recyclerView.mIsAttached) {
                    Runnable runnable = recyclerView.mUpdateChildViewsRunnable;
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    C0492V4.C0495c.m1931m(recyclerView, runnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.mAdapterUpdateDuringMeasure = true;
            recyclerView2.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public void onChanged() {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.mState.f3270f = true;
            recyclerView.processDataSetCompletelyChanged(true);
            if (RecyclerView.this.mAdapterHelper.m2366g()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public void onItemRangeChanged(int i, int i2, Object obj) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            C0217J6 c0217j6 = RecyclerView.this.mAdapterHelper;
            Objects.requireNonNull(c0217j6);
            boolean z = false;
            if (i2 >= 1) {
                c0217j6.f684b.add(c0217j6.m2365h(4, i, i2, obj));
                c0217j6.f688f |= 4;
                if (c0217j6.f684b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                m1345a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public void onItemRangeInserted(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            C0217J6 c0217j6 = RecyclerView.this.mAdapterHelper;
            Objects.requireNonNull(c0217j6);
            boolean z = false;
            if (i2 >= 1) {
                c0217j6.f684b.add(c0217j6.m2365h(1, i, i2, null));
                c0217j6.f688f |= 1;
                if (c0217j6.f684b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                m1345a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public void onItemRangeMoved(int i, int i2, int i3) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            C0217J6 c0217j6 = RecyclerView.this.mAdapterHelper;
            Objects.requireNonNull(c0217j6);
            boolean z = false;
            if (i != i2) {
                if (i3 == 1) {
                    c0217j6.f684b.add(c0217j6.m2365h(8, i, i2, null));
                    c0217j6.f688f |= 8;
                    if (c0217j6.f684b.size() == 1) {
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
                }
            }
            if (z) {
                m1345a();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public void onItemRangeRemoved(int i, int i2) {
            RecyclerView.this.assertNotInLayoutOrScroll(null);
            C0217J6 c0217j6 = RecyclerView.this.mAdapterHelper;
            Objects.requireNonNull(c0217j6);
            boolean z = false;
            if (i2 >= 1) {
                c0217j6.f684b.add(c0217j6.m2365h(2, i, i2, null));
                c0217j6.f688f |= 2;
                if (c0217j6.f684b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                m1345a();
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$x */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0857x {
        private AbstractC0843o mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private boolean mRunning;
        private boolean mStarted;
        private View mTargetView;
        private int mTargetPosition = -1;
        private final C0858a mRecyclingAction = new C0858a(0, 0);

        /* renamed from: androidx.recyclerview.widget.RecyclerView$x$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0858a {

            /* renamed from: a */
            public int f3258a;

            /* renamed from: b */
            public int f3259b;

            /* renamed from: d */
            public int f3261d = -1;

            /* renamed from: f */
            public boolean f3263f = false;

            /* renamed from: g */
            public int f3264g = 0;

            /* renamed from: c */
            public int f3260c = Integer.MIN_VALUE;

            /* renamed from: e */
            public Interpolator f3262e = null;

            public C0858a(int i, int i2) {
                this.f3258a = i;
                this.f3259b = i2;
            }

            /* renamed from: a */
            public void m1344a(RecyclerView recyclerView) {
                int i = this.f3261d;
                if (i >= 0) {
                    this.f3261d = -1;
                    recyclerView.jumpToPositionForSmoothScroller(i);
                    this.f3263f = false;
                } else if (this.f3263f) {
                    Interpolator interpolator = this.f3262e;
                    if (interpolator != null && this.f3260c < 1) {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                    int i2 = this.f3260c;
                    if (i2 >= 1) {
                        recyclerView.mViewFlinger.m1391b(this.f3258a, this.f3259b, i2, interpolator);
                        int i3 = this.f3264g + 1;
                        this.f3264g = i3;
                        if (i3 > 10) {
                            Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.f3263f = false;
                        return;
                    }
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    this.f3264g = 0;
                }
            }

            /* renamed from: b */
            public void m1343b(int i, int i2, int i3, Interpolator interpolator) {
                this.f3258a = i;
                this.f3259b = i2;
                this.f3260c = i3;
                this.f3262e = interpolator;
                this.f3263f = true;
            }
        }

        /* renamed from: androidx.recyclerview.widget.RecyclerView$x$b */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public interface InterfaceC0859b {
            PointF computeScrollVectorForPosition(int i);
        }

        public PointF computeScrollVectorForPosition(int i) {
            AbstractC0843o layoutManager = getLayoutManager();
            if (layoutManager instanceof InterfaceC0859b) {
                return ((InterfaceC0859b) layoutManager).computeScrollVectorForPosition(i);
            }
            StringBuilder m253r = outline.m253r("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            m253r.append(InterfaceC0859b.class.getCanonicalName());
            Log.w(RecyclerView.TAG, m253r.toString());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.mLayout.findViewByPosition(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.getChildLayoutPosition(view);
        }

        public AbstractC0843o getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.scrollToPosition(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f2 * f2) + (f * f));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            RecyclerView recyclerView = this.mRecyclerView;
            if (this.mTargetPosition == -1 || recyclerView == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null) {
                float f = computeScrollVectorForPosition.x;
                if (f != 0.0f || computeScrollVectorForPosition.y != 0.0f) {
                    recyclerView.scrollStep((int) Math.signum(f), (int) Math.signum(computeScrollVectorForPosition.y), null);
                }
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, recyclerView.mState, this.mRecyclingAction);
                    this.mRecyclingAction.m1344a(recyclerView);
                    stop();
                } else {
                    Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, recyclerView.mState, this.mRecyclingAction);
                C0858a c0858a = this.mRecyclingAction;
                boolean z = c0858a.f3261d >= 0;
                c0858a.m1344a(recyclerView);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    recyclerView.mViewFlinger.m1392a();
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        public abstract void onSeekTargetStep(int i, int i2, C0860y c0860y, C0858a c0858a);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View view, C0860y c0860y, C0858a c0858a);

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public void start(RecyclerView recyclerView, AbstractC0843o abstractC0843o) {
            recyclerView.mViewFlinger.m1390c();
            if (this.mStarted) {
                StringBuilder m253r = outline.m253r("An instance of ");
                m253r.append(getClass().getSimpleName());
                m253r.append(" was started more than once. Each instance of");
                m253r.append(getClass().getSimpleName());
                m253r.append(" is intended to only be used once. You should create a new instance for each use.");
                Log.w(RecyclerView.TAG, m253r.toString());
            }
            this.mRecyclerView = recyclerView;
            this.mLayoutManager = abstractC0843o;
            int i = this.mTargetPosition;
            if (i != -1) {
                recyclerView.mState.f3265a = i;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.mViewFlinger.m1392a();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.mState.f3265a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.onSmoothScrollerStopped(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$y */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0860y {

        /* renamed from: a */
        public int f3265a = -1;

        /* renamed from: b */
        public int f3266b = 0;

        /* renamed from: c */
        public int f3267c = 0;

        /* renamed from: d */
        public int f3268d = 1;

        /* renamed from: e */
        public int f3269e = 0;

        /* renamed from: f */
        public boolean f3270f = false;

        /* renamed from: g */
        public boolean f3271g = false;

        /* renamed from: h */
        public boolean f3272h = false;

        /* renamed from: i */
        public boolean f3273i = false;

        /* renamed from: j */
        public boolean f3274j = false;

        /* renamed from: k */
        public boolean f3275k = false;

        /* renamed from: l */
        public int f3276l;

        /* renamed from: m */
        public long f3277m;

        /* renamed from: n */
        public int f3278n;

        /* renamed from: a */
        public void m1342a(int i) {
            if ((this.f3268d & i) != 0) {
                return;
            }
            StringBuilder m253r = outline.m253r("Layout state should be one of ");
            m253r.append(Integer.toBinaryString(i));
            m253r.append(" but it is ");
            m253r.append(Integer.toBinaryString(this.f3268d));
            throw new IllegalStateException(m253r.toString());
        }

        /* renamed from: b */
        public int m1341b() {
            return this.f3271g ? this.f3266b - this.f3267c : this.f3269e;
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("State{mTargetPosition=");
            m253r.append(this.f3265a);
            m253r.append(", mData=");
            m253r.append((Object) null);
            m253r.append(", mItemCount=");
            m253r.append(this.f3269e);
            m253r.append(", mIsMeasuring=");
            m253r.append(this.f3273i);
            m253r.append(", mPreviousLayoutItemCount=");
            m253r.append(this.f3266b);
            m253r.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            m253r.append(this.f3267c);
            m253r.append(", mStructureChanged=");
            m253r.append(this.f3270f);
            m253r.append(", mInPreLayout=");
            m253r.append(this.f3271g);
            m253r.append(", mRunSimpleAnimations=");
            m253r.append(this.f3274j);
            m253r.append(", mRunPredictiveAnimations=");
            m253r.append(this.f3275k);
            m253r.append('}');
            return m253r.toString();
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$z */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0861z {
    }

    static {
        int i = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = i >= 23;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class<?> cls = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, cls, cls};
        sQuinticInterpolator = new animationInterpolatorC0828c();
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    private void addAnimatingView(AbstractC0824B abstractC0824B) {
        View view = abstractC0824B.itemView;
        boolean z = view.getParent() == this;
        this.mRecycler.m1348l(getChildViewHolder(view));
        if (abstractC0824B.isTmpDetached()) {
            this.mChildHelper.m2254b(view, -1, view.getLayoutParams(), true);
        } else if (!z) {
            this.mChildHelper.m2255a(view, -1, true);
        } else {
            C0247K6 c0247k6 = this.mChildHelper;
            int indexOfChild = RecyclerView.this.indexOfChild(view);
            if (indexOfChild >= 0) {
                c0247k6.f781b.m2235h(indexOfChild);
                c0247k6.m2247i(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    private void animateChange(AbstractC0824B abstractC0824B, AbstractC0824B abstractC0824B2, AbstractC0837l.C0840c c0840c, AbstractC0837l.C0840c c0840c2, boolean z, boolean z2) {
        abstractC0824B.setIsRecyclable(false);
        if (z) {
            addAnimatingView(abstractC0824B);
        }
        if (abstractC0824B != abstractC0824B2) {
            if (z2) {
                addAnimatingView(abstractC0824B2);
            }
            abstractC0824B.mShadowedHolder = abstractC0824B2;
            addAnimatingView(abstractC0824B);
            this.mRecycler.m1348l(abstractC0824B);
            abstractC0824B2.setIsRecyclable(false);
            abstractC0824B2.mShadowingHolder = abstractC0824B;
        }
        if (this.mItemAnimator.mo986a(abstractC0824B, abstractC0824B2, c0840c, c0840c2)) {
            postAnimationRunner();
        }
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    public static void clearNestedRecyclerViewIfNotNested(AbstractC0824B abstractC0824B) {
        WeakReference<RecyclerView> weakReference = abstractC0824B.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView == abstractC0824B.itemView) {
                    return;
                }
                ViewParent parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            abstractC0824B.mNestedRecyclerView = null;
        }
    }

    private void createLayoutManager(Context context, String str, AttributeSet attributeSet, int i, int i2) {
        ClassLoader classLoader;
        Constructor constructor;
        if (str != null) {
            String trim = str.trim();
            if (trim.isEmpty()) {
                return;
            }
            String fullClassName = getFullClassName(context, trim);
            try {
                if (isInEditMode()) {
                    classLoader = getClass().getClassLoader();
                } else {
                    classLoader = context.getClassLoader();
                }
                Class<? extends U> asSubclass = Class.forName(fullClassName, false, classLoader).asSubclass(AbstractC0843o.class);
                Object[] objArr = null;
                try {
                    constructor = asSubclass.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);
                    objArr = new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2)};
                } catch (NoSuchMethodException e) {
                    try {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    } catch (NoSuchMethodException e2) {
                        e2.initCause(e);
                        throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + fullClassName, e2);
                    }
                }
                constructor.setAccessible(true);
                setLayoutManager((AbstractC0843o) constructor.newInstance(objArr));
            } catch (ClassCastException e3) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + fullClassName, e3);
            } catch (ClassNotFoundException e4) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + fullClassName, e4);
            } catch (IllegalAccessException e5) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + fullClassName, e5);
            } catch (InstantiationException e6) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + fullClassName, e7);
            }
        }
    }

    private boolean didChildRangeChange(int i, int i2) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] iArr = this.mMinMaxLayoutPositions;
        return (iArr[0] == i && iArr[1] == i2) ? false : true;
    }

    private void dispatchContentChangedIfNecessary() {
        int i = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (i == 0 || !isAccessibilityEnabled()) {
            return;
        }
        AccessibilityEvent obtain = AccessibilityEvent.obtain();
        obtain.setEventType(2048);
        obtain.setContentChangeTypes(i);
        sendAccessibilityEventUnchecked(obtain);
    }

    private void dispatchLayoutStep1() {
        this.mState.m1342a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f3273i = false;
        startInterceptRequestLayout();
        C1891i7 c1891i7 = this.mViewInfoStore;
        c1891i7.f5276a.clear();
        c1891i7.f5277b.m2569b();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        C0860y c0860y = this.mState;
        c0860y.f3272h = c0860y.f3274j && this.mItemsChanged;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        c0860y.f3271g = c0860y.f3275k;
        c0860y.f3269e = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.f3274j) {
            int m2251e = this.mChildHelper.m2251e();
            for (int i = 0; i < m2251e; i++) {
                AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2252d(i));
                if (!childViewHolderInt.shouldIgnore() && (!childViewHolderInt.isInvalid() || this.mAdapter.hasStableIds())) {
                    AbstractC0837l abstractC0837l = this.mItemAnimator;
                    AbstractC0837l.m1372b(childViewHolderInt);
                    childViewHolderInt.getUnmodifiedPayloads();
                    this.mViewInfoStore.m740c(childViewHolderInt, abstractC0837l.m1366h(childViewHolderInt));
                    if (this.mState.f3272h && childViewHolderInt.isUpdated() && !childViewHolderInt.isRemoved() && !childViewHolderInt.shouldIgnore() && !childViewHolderInt.isInvalid()) {
                        this.mViewInfoStore.f5277b.m2564g(getChangedHolderKey(childViewHolderInt), childViewHolderInt);
                    }
                }
            }
        }
        if (this.mState.f3275k) {
            saveOldPositions();
            C0860y c0860y2 = this.mState;
            boolean z = c0860y2.f3270f;
            c0860y2.f3270f = false;
            this.mLayout.onLayoutChildren(this.mRecycler, c0860y2);
            this.mState.f3270f = z;
            for (int i2 = 0; i2 < this.mChildHelper.m2251e(); i2++) {
                AbstractC0824B childViewHolderInt2 = getChildViewHolderInt(this.mChildHelper.m2252d(i2));
                if (!childViewHolderInt2.shouldIgnore()) {
                    C1891i7.C1892a c1892a = this.mViewInfoStore.f5276a.get(childViewHolderInt2);
                    if (!((c1892a == null || (c1892a.f5279a & 4) == 0) ? false : true)) {
                        AbstractC0837l.m1372b(childViewHolderInt2);
                        boolean hasAnyOfTheFlags = childViewHolderInt2.hasAnyOfTheFlags(8192);
                        AbstractC0837l abstractC0837l2 = this.mItemAnimator;
                        childViewHolderInt2.getUnmodifiedPayloads();
                        AbstractC0837l.C0840c m1366h = abstractC0837l2.m1366h(childViewHolderInt2);
                        if (hasAnyOfTheFlags) {
                            recordAnimationInfoIfBouncedHiddenView(childViewHolderInt2, m1366h);
                        } else {
                            C1891i7 c1891i72 = this.mViewInfoStore;
                            C1891i7.C1892a c1892a2 = c1891i72.f5276a.get(childViewHolderInt2);
                            if (c1892a2 == null) {
                                c1892a2 = C1891i7.C1892a.m735a();
                                c1891i72.f5276a.put(childViewHolderInt2, c1892a2);
                            }
                            c1892a2.f5279a |= 2;
                            c1892a2.f5280b = m1366h;
                        }
                    }
                }
            }
            clearOldPositions();
        } else {
            clearOldPositions();
        }
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f3268d = 2;
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.m1342a(6);
        this.mAdapterHelper.m2370c();
        this.mState.f3269e = this.mAdapter.getItemCount();
        C0860y c0860y = this.mState;
        c0860y.f3267c = 0;
        c0860y.f3271g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, c0860y);
        C0860y c0860y2 = this.mState;
        c0860y2.f3270f = false;
        this.mPendingSavedState = null;
        c0860y2.f3274j = c0860y2.f3274j && this.mItemAnimator != null;
        c0860y2.f3268d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
    }

    private void dispatchLayoutStep3() {
        boolean mo985i;
        this.mState.m1342a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        C0860y c0860y = this.mState;
        c0860y.f3268d = 1;
        if (c0860y.f3274j) {
            for (int m2251e = this.mChildHelper.m2251e() - 1; m2251e >= 0; m2251e--) {
                AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2252d(m2251e));
                if (!childViewHolderInt.shouldIgnore()) {
                    long changedHolderKey = getChangedHolderKey(childViewHolderInt);
                    Objects.requireNonNull(this.mItemAnimator);
                    AbstractC0837l.C0840c c0840c = new AbstractC0837l.C0840c();
                    View view = childViewHolderInt.itemView;
                    c0840c.f3234a = view.getLeft();
                    c0840c.f3235b = view.getTop();
                    view.getRight();
                    view.getBottom();
                    AbstractC0824B m2565f = this.mViewInfoStore.f5277b.m2565f(changedHolderKey, null);
                    if (m2565f != null && !m2565f.shouldIgnore()) {
                        boolean m739d = this.mViewInfoStore.m739d(m2565f);
                        boolean m739d2 = this.mViewInfoStore.m739d(childViewHolderInt);
                        if (m739d && m2565f == childViewHolderInt) {
                            this.mViewInfoStore.m741b(childViewHolderInt, c0840c);
                        } else {
                            AbstractC0837l.C0840c m738e = this.mViewInfoStore.m738e(m2565f, 4);
                            this.mViewInfoStore.m741b(childViewHolderInt, c0840c);
                            AbstractC0837l.C0840c m738e2 = this.mViewInfoStore.m738e(childViewHolderInt, 8);
                            if (m738e == null) {
                                handleMissingPreInfoForChangeError(changedHolderKey, childViewHolderInt, m2565f);
                            } else {
                                animateChange(m2565f, childViewHolderInt, m738e, m738e2, m739d, m739d2);
                            }
                        }
                    } else {
                        this.mViewInfoStore.m741b(childViewHolderInt, c0840c);
                    }
                }
            }
            C1891i7 c1891i7 = this.mViewInfoStore;
            C1891i7.InterfaceC1893b interfaceC1893b = this.mViewInfoProcessCallback;
            for (int size = c1891i7.f5276a.size() - 1; size >= 0; size--) {
                AbstractC0824B keyAt = c1891i7.f5276a.keyAt(size);
                C1891i7.C1892a removeAt = c1891i7.f5276a.removeAt(size);
                int i = removeAt.f5279a;
                if ((i & 3) == 3) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.mLayout.removeAndRecycleView(keyAt.itemView, recyclerView.mRecycler);
                } else if ((i & 1) != 0) {
                    AbstractC0837l.C0840c c0840c2 = removeAt.f5280b;
                    if (c0840c2 == null) {
                        RecyclerView recyclerView2 = RecyclerView.this;
                        recyclerView2.mLayout.removeAndRecycleView(keyAt.itemView, recyclerView2.mRecycler);
                    } else {
                        AbstractC0837l.C0840c c0840c3 = removeAt.f5281c;
                        C0829d c0829d = (C0829d) interfaceC1893b;
                        RecyclerView.this.mRecycler.m1348l(keyAt);
                        RecyclerView.this.animateDisappearance(keyAt, c0840c2, c0840c3);
                    }
                } else if ((i & 14) == 14) {
                    RecyclerView.this.animateAppearance(keyAt, removeAt.f5280b, removeAt.f5281c);
                } else if ((i & 12) == 12) {
                    AbstractC0837l.C0840c c0840c4 = removeAt.f5280b;
                    AbstractC0837l.C0840c c0840c5 = removeAt.f5281c;
                    C0829d c0829d2 = (C0829d) interfaceC1893b;
                    Objects.requireNonNull(c0829d2);
                    keyAt.setIsRecyclable(false);
                    RecyclerView recyclerView3 = RecyclerView.this;
                    if (recyclerView3.mDataSetHasChangedAfterLayout) {
                        if (recyclerView3.mItemAnimator.mo986a(keyAt, keyAt, c0840c4, c0840c5)) {
                            RecyclerView.this.postAnimationRunner();
                        }
                    } else {
                        AbstractC1681f7 abstractC1681f7 = (AbstractC1681f7) recyclerView3.mItemAnimator;
                        Objects.requireNonNull(abstractC1681f7);
                        int i2 = c0840c4.f3234a;
                        int i3 = c0840c5.f3234a;
                        if (i2 == i3 && c0840c4.f3235b == c0840c5.f3235b) {
                            abstractC1681f7.m1371c(keyAt);
                            mo985i = false;
                        } else {
                            mo985i = abstractC1681f7.mo985i(keyAt, i2, c0840c4.f3235b, i3, c0840c5.f3235b);
                        }
                        if (mo985i) {
                            RecyclerView.this.postAnimationRunner();
                        }
                    }
                } else if ((i & 4) != 0) {
                    AbstractC0837l.C0840c c0840c6 = removeAt.f5280b;
                    C0829d c0829d3 = (C0829d) interfaceC1893b;
                    RecyclerView.this.mRecycler.m1348l(keyAt);
                    RecyclerView.this.animateDisappearance(keyAt, c0840c6, null);
                } else if ((i & 8) != 0) {
                    RecyclerView.this.animateAppearance(keyAt, removeAt.f5280b, removeAt.f5281c);
                }
                C1891i7.C1892a.m734b(removeAt);
            }
        }
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        C0860y c0860y2 = this.mState;
        c0860y2.f3266b = c0860y2.f3269e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        c0860y2.f3274j = false;
        c0860y2.f3275k = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<AbstractC0824B> arrayList = this.mRecycler.f3250b;
        if (arrayList != null) {
            arrayList.clear();
        }
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o.mPrefetchMaxObservedInInitialPrefetch) {
            abstractC0843o.mPrefetchMaxCountObserved = 0;
            abstractC0843o.mPrefetchMaxObservedInInitialPrefetch = false;
            this.mRecycler.m1347m();
        }
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        C1891i7 c1891i72 = this.mViewInfoStore;
        c1891i72.f5276a.clear();
        c1891i72.f5277b.m2569b();
        int[] iArr = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(iArr[0], iArr[1])) {
            dispatchOnScrolled(0, 0);
        }
        recoverFocusFromState();
        resetFocusInfo();
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent motionEvent) {
        InterfaceC0850r interfaceC0850r = this.mInterceptingOnItemTouchListener;
        if (interfaceC0850r == null) {
            if (motionEvent.getAction() == 0) {
                return false;
            }
            return findInterceptingOnItemTouchListener(motionEvent);
        }
        interfaceC0850r.mo1363b(this, motionEvent);
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mInterceptingOnItemTouchListener = null;
        }
        return true;
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            InterfaceC0850r interfaceC0850r = this.mOnItemTouchListeners.get(i);
            if (interfaceC0850r.mo1364a(this, motionEvent) && action != 3) {
                this.mInterceptingOnItemTouchListener = interfaceC0850r;
                return true;
            }
        }
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] iArr) {
        int m2251e = this.mChildHelper.m2251e();
        if (m2251e == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < m2251e; i3++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2252d(i3));
            if (!childViewHolderInt.shouldIgnore()) {
                int layoutPosition = childViewHolderInt.getLayoutPosition();
                if (layoutPosition < i) {
                    i = layoutPosition;
                }
                if (layoutPosition > i2) {
                    i2 = layoutPosition;
                }
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
    }

    public static RecyclerView findNestedRecyclerView(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof RecyclerView) {
                return (RecyclerView) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                RecyclerView findNestedRecyclerView = findNestedRecyclerView(viewGroup.getChildAt(i));
                if (findNestedRecyclerView != null) {
                    return findNestedRecyclerView;
                }
            }
            return null;
        }
        return null;
    }

    private View findNextViewToFocus() {
        AbstractC0824B findViewHolderForAdapterPosition;
        C0860y c0860y = this.mState;
        int i = c0860y.f3276l;
        if (i == -1) {
            i = 0;
        }
        int m1341b = c0860y.m1341b();
        for (int i2 = i; i2 < m1341b; i2++) {
            AbstractC0824B findViewHolderForAdapterPosition2 = findViewHolderForAdapterPosition(i2);
            if (findViewHolderForAdapterPosition2 == null) {
                break;
            } else if (findViewHolderForAdapterPosition2.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition2.itemView;
            }
        }
        int min = Math.min(m1341b, i);
        while (true) {
            min--;
            if (min < 0 || (findViewHolderForAdapterPosition = findViewHolderForAdapterPosition(min)) == null) {
                return null;
            }
            if (findViewHolderForAdapterPosition.itemView.hasFocusable()) {
                return findViewHolderForAdapterPosition.itemView;
            }
        }
    }

    public static AbstractC0824B getChildViewHolderInt(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f3218a;
    }

    public static void getDecoratedBoundsWithMarginsInt(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f3219b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
    }

    private int getDeepestFocusedViewWithId(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    private String getFullClassName(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    private C0235K4 getScrollingChildHelper() {
        if (this.mScrollingChildHelper == null) {
            this.mScrollingChildHelper = new C0235K4(this);
        }
        return this.mScrollingChildHelper;
    }

    private void handleMissingPreInfoForChangeError(long j, AbstractC0824B abstractC0824B, AbstractC0824B abstractC0824B2) {
        int m2251e = this.mChildHelper.m2251e();
        for (int i = 0; i < m2251e; i++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2252d(i));
            if (childViewHolderInt != abstractC0824B && getChangedHolderKey(childViewHolderInt) == j) {
                AbstractC0832g abstractC0832g = this.mAdapter;
                if (abstractC0832g != null && abstractC0832g.hasStableIds()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:");
                    sb.append(childViewHolderInt);
                    sb.append(" \n View Holder 2:");
                    sb.append(abstractC0824B);
                    throw new IllegalStateException(outline.m276E(this, sb));
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:");
                sb2.append(childViewHolderInt);
                sb2.append(" \n View Holder 2:");
                sb2.append(abstractC0824B);
                throw new IllegalStateException(outline.m276E(this, sb2));
            }
        }
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + abstractC0824B2 + " cannot be found but it is necessary for " + abstractC0824B + exceptionLabel());
    }

    private boolean hasUpdatedView() {
        int m2251e = this.mChildHelper.m2251e();
        for (int i = 0; i < m2251e; i++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2252d(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    private void initAutofill() {
        AtomicInteger atomicInteger = C0492V4.f1798a;
        int i = Build.VERSION.SDK_INT;
        if ((i >= 26 ? C0492V4.C0504k.m1864b(this) : 0) != 0 || i < 26) {
            return;
        }
        C0492V4.C0504k.m1854l(this, 8);
    }

    private void initChildrenHelper() {
        this.mChildHelper = new C0247K6(new C0830e());
    }

    private boolean isPreferredNextFocus(View view, View view2, int i) {
        int i2;
        if (view2 == null || view2 == this || findContainingItemView(view2) == null) {
            return false;
        }
        if (view == null || findContainingItemView(view) == null) {
            return true;
        }
        this.mTempRect.set(0, 0, view.getWidth(), view.getHeight());
        this.mTempRect2.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        offsetDescendantRectToMyCoords(view2, this.mTempRect2);
        char c = 65535;
        int i3 = this.mLayout.getLayoutDirection() == 1 ? -1 : 1;
        Rect rect = this.mTempRect;
        int i4 = rect.left;
        Rect rect2 = this.mTempRect2;
        int i5 = rect2.left;
        if ((i4 < i5 || rect.right <= i5) && rect.right < rect2.right) {
            i2 = 1;
        } else {
            int i6 = rect.right;
            int i7 = rect2.right;
            i2 = ((i6 > i7 || i4 >= i7) && i4 > i5) ? -1 : 0;
        }
        int i8 = rect.top;
        int i9 = rect2.top;
        if ((i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom) {
            c = 1;
        } else {
            int i10 = rect.bottom;
            int i11 = rect2.bottom;
            if ((i10 <= i11 && i8 < i11) || i8 <= i9) {
                c = 0;
            }
        }
        if (i == 1) {
            return c < 0 || (c == 0 && i2 * i3 <= 0);
        } else if (i == 2) {
            return c > 0 || (c == 0 && i2 * i3 >= 0);
        } else if (i == 17) {
            return i2 < 0;
        } else if (i == 33) {
            return c < 0;
        } else if (i == 66) {
            return i2 > 0;
        } else if (i == 130) {
            return c > 0;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid direction: ");
            sb.append(i);
            throw new IllegalArgumentException(outline.m276E(this, sb));
        }
    }

    private void onPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mScrollPointerId) {
            int i = actionIndex == 0 ? 1 : 0;
            this.mScrollPointerId = motionEvent.getPointerId(i);
            int x = (int) (motionEvent.getX(i) + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY(i) + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
        }
    }

    private boolean predictiveItemAnimationsEnabled() {
        return this.mItemAnimator != null && this.mLayout.supportsPredictiveItemAnimations();
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        boolean z;
        boolean z2 = false;
        if (this.mDataSetHasChangedAfterLayout) {
            C0217J6 c0217j6 = this.mAdapterHelper;
            c0217j6.m2361l(c0217j6.f684b);
            c0217j6.m2361l(c0217j6.f685c);
            c0217j6.f688f = 0;
            if (this.mDispatchItemsChangedEvent) {
                this.mLayout.onItemsChanged(this);
            }
        }
        if (predictiveItemAnimationsEnabled()) {
            this.mAdapterHelper.m2363j();
        } else {
            this.mAdapterHelper.m2370c();
        }
        boolean z3 = this.mItemsAddedOrRemoved || this.mItemsChanged;
        this.mState.f3274j = this.mFirstLayoutComplete && this.mItemAnimator != null && ((z = this.mDataSetHasChangedAfterLayout) || z3 || this.mLayout.mRequestedSimpleAnimations) && (!z || this.mAdapter.hasStableIds());
        C0860y c0860y = this.mState;
        if (c0860y.f3274j && z3 && !this.mDataSetHasChangedAfterLayout && predictiveItemAnimationsEnabled()) {
            z2 = true;
        }
        c0860y.f3275k = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void pullGlows(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L21
            r6.ensureLeftGlow()
            android.widget.EdgeEffect r3 = r6.mLeftGlow
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
            r3.onPull(r4, r9)
        L1f:
            r9 = 1
            goto L3c
        L21:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L3b
            r6.ensureRightGlow()
            android.widget.EdgeEffect r3 = r6.mRightGlow
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            r3.onPull(r4, r9)
            goto L1f
        L3b:
            r9 = 0
        L3c:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L56
            r6.ensureTopGlow()
            android.widget.EdgeEffect r9 = r6.mTopGlow
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            r9.onPull(r0, r7)
            goto L72
        L56:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L71
            r6.ensureBottomGlow()
            android.widget.EdgeEffect r9 = r6.mBottomGlow
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            r9.onPull(r3, r0)
            goto L72
        L71:
            r1 = r9
        L72:
            if (r1 != 0) goto L7c
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L7c
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L81
        L7c:
            java.util.concurrent.atomic.AtomicInteger r7 = p000.C0492V4.f1798a
            p000.C0492V4.C0495c.m1933k(r6)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.pullGlows(float, float, float, float):void");
    }

    private void recoverFocusFromState() {
        View findViewById;
        if (!this.mPreserveFocusAfterLayout || this.mAdapter == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (IGNORE_DETACHED_FOCUSED_CHILD && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.mChildHelper.m2251e() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.mChildHelper.m2245k(focusedChild)) {
                return;
            }
        }
        View view = null;
        AbstractC0824B findViewHolderForItemId = (this.mState.f3277m == -1 || !this.mAdapter.hasStableIds()) ? null : findViewHolderForItemId(this.mState.f3277m);
        if (findViewHolderForItemId != null && !this.mChildHelper.m2245k(findViewHolderForItemId.itemView) && findViewHolderForItemId.itemView.hasFocusable()) {
            view = findViewHolderForItemId.itemView;
        } else if (this.mChildHelper.m2251e() > 0) {
            view = findNextViewToFocus();
        }
        if (view != null) {
            int i = this.mState.f3278n;
            if (i != -1 && (findViewById = view.findViewById(i)) != null && findViewById.isFocusable()) {
                view = findViewById;
            }
            view.requestFocus();
        }
    }

    private void releaseGlows() {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z = this.mLeftGlow.isFinished();
        } else {
            z = false;
        }
        EdgeEffect edgeEffect2 = this.mTopGlow;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mRightGlow;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1933k(this);
        }
    }

    private void requestChildOnScreen(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.mTempRect.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f3220c) {
                Rect rect = layoutParams2.f3219b;
                Rect rect2 = this.mTempRect;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.mTempRect);
            offsetRectIntoDescendantCoords(view, this.mTempRect);
        }
        this.mLayout.requestChildRectangleOnScreen(this, view, this.mTempRect, !this.mFirstLayoutComplete, view2 == null);
    }

    private void resetFocusInfo() {
        C0860y c0860y = this.mState;
        c0860y.f3277m = -1L;
        c0860y.f3276l = -1;
        c0860y.f3278n = -1;
    }

    private void resetScroll() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        int adapterPosition;
        View focusedChild = (this.mPreserveFocusAfterLayout && hasFocus() && this.mAdapter != null) ? getFocusedChild() : null;
        AbstractC0824B findContainingViewHolder = focusedChild != null ? findContainingViewHolder(focusedChild) : null;
        if (findContainingViewHolder == null) {
            resetFocusInfo();
            return;
        }
        this.mState.f3277m = this.mAdapter.hasStableIds() ? findContainingViewHolder.getItemId() : -1L;
        C0860y c0860y = this.mState;
        if (this.mDataSetHasChangedAfterLayout) {
            adapterPosition = -1;
        } else {
            adapterPosition = findContainingViewHolder.isRemoved() ? findContainingViewHolder.mOldPosition : findContainingViewHolder.getAdapterPosition();
        }
        c0860y.f3276l = adapterPosition;
        this.mState.f3278n = getDeepestFocusedViewWithId(findContainingViewHolder.itemView);
    }

    private void setAdapterInternal(AbstractC0832g abstractC0832g, boolean z, boolean z2) {
        AbstractC0832g abstractC0832g2 = this.mAdapter;
        if (abstractC0832g2 != null) {
            abstractC0832g2.unregisterAdapterDataObserver(this.mObserver);
            this.mAdapter.onDetachedFromRecyclerView(this);
        }
        if (!z || z2) {
            removeAndRecycleViews();
        }
        C0217J6 c0217j6 = this.mAdapterHelper;
        c0217j6.m2361l(c0217j6.f684b);
        c0217j6.m2361l(c0217j6.f685c);
        c0217j6.f688f = 0;
        AbstractC0832g abstractC0832g3 = this.mAdapter;
        this.mAdapter = abstractC0832g;
        if (abstractC0832g != null) {
            abstractC0832g.registerAdapterDataObserver(this.mObserver);
            abstractC0832g.onAttachedToRecyclerView(this);
        }
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            abstractC0843o.onAdapterChanged(abstractC0832g3, this.mAdapter);
        }
        C0854u c0854u = this.mRecycler;
        AbstractC0832g abstractC0832g4 = this.mAdapter;
        c0854u.m1358b();
        C0852t m1356d = c0854u.m1356d();
        Objects.requireNonNull(m1356d);
        if (abstractC0832g3 != null) {
            m1356d.f3244b--;
        }
        if (!z && m1356d.f3244b == 0) {
            for (int i = 0; i < m1356d.f3243a.size(); i++) {
                m1356d.f3243a.valueAt(i).f3245a.clear();
            }
        }
        if (abstractC0832g4 != null) {
            m1356d.f3244b++;
        }
        this.mState.f3270f = true;
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.m1390c();
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            abstractC0843o.stopSmoothScroller();
        }
    }

    public void absorbGlows(int i, int i2) {
        if (i < 0) {
            ensureLeftGlow();
            if (this.mLeftGlow.isFinished()) {
                this.mLeftGlow.onAbsorb(-i);
            }
        } else if (i > 0) {
            ensureRightGlow();
            if (this.mRightGlow.isFinished()) {
                this.mRightGlow.onAbsorb(i);
            }
        }
        if (i2 < 0) {
            ensureTopGlow();
            if (this.mTopGlow.isFinished()) {
                this.mTopGlow.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            ensureBottomGlow();
            if (this.mBottomGlow.isFinished()) {
                this.mBottomGlow.onAbsorb(i2);
            }
        }
        if (i == 0 && i2 == 0) {
            return;
        }
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1933k(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o == null || !abstractC0843o.onAddFocusables(this, arrayList, i, i2)) {
            super.addFocusables(arrayList, i, i2);
        }
    }

    public void addItemDecoration(AbstractC0842n abstractC0842n, int i) {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            abstractC0843o.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
        }
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i < 0) {
            this.mItemDecorations.add(abstractC0842n);
        } else {
            this.mItemDecorations.add(i, abstractC0842n);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void addOnChildAttachStateChangeListener(InterfaceC0848p interfaceC0848p) {
        if (this.mOnChildAttachStateListeners == null) {
            this.mOnChildAttachStateListeners = new ArrayList();
        }
        this.mOnChildAttachStateListeners.add(interfaceC0848p);
    }

    public void addOnItemTouchListener(InterfaceC0850r interfaceC0850r) {
        this.mOnItemTouchListeners.add(interfaceC0850r);
    }

    public void addOnScrollListener(AbstractC0851s abstractC0851s) {
        if (this.mScrollListeners == null) {
            this.mScrollListeners = new ArrayList();
        }
        this.mScrollListeners.add(abstractC0851s);
    }

    public void animateAppearance(AbstractC0824B abstractC0824B, AbstractC0837l.C0840c c0840c, AbstractC0837l.C0840c c0840c2) {
        boolean z;
        int i;
        int i2;
        abstractC0824B.setIsRecyclable(false);
        AbstractC1681f7 abstractC1681f7 = (AbstractC1681f7) this.mItemAnimator;
        Objects.requireNonNull(abstractC1681f7);
        if (c0840c != null && ((i = c0840c.f3234a) != (i2 = c0840c2.f3234a) || c0840c.f3235b != c0840c2.f3235b)) {
            z = abstractC1681f7.mo985i(abstractC0824B, i, c0840c.f3235b, i2, c0840c2.f3235b);
        } else {
            C0454T6 c0454t6 = (C0454T6) abstractC1681f7;
            c0454t6.m2003n(abstractC0824B);
            abstractC0824B.itemView.setAlpha(0.0f);
            c0454t6.f1573i.add(abstractC0824B);
            z = true;
        }
        if (z) {
            postAnimationRunner();
        }
    }

    public void animateDisappearance(AbstractC0824B abstractC0824B, AbstractC0837l.C0840c c0840c, AbstractC0837l.C0840c c0840c2) {
        boolean z;
        addAnimatingView(abstractC0824B);
        abstractC0824B.setIsRecyclable(false);
        AbstractC1681f7 abstractC1681f7 = (AbstractC1681f7) this.mItemAnimator;
        Objects.requireNonNull(abstractC1681f7);
        int i = c0840c.f3234a;
        int i2 = c0840c.f3235b;
        View view = abstractC0824B.itemView;
        int left = c0840c2 == null ? view.getLeft() : c0840c2.f3234a;
        int top = c0840c2 == null ? view.getTop() : c0840c2.f3235b;
        if (!abstractC0824B.isRemoved() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            z = abstractC1681f7.mo985i(abstractC0824B, i, i2, left, top);
        } else {
            C0454T6 c0454t6 = (C0454T6) abstractC1681f7;
            c0454t6.m2003n(abstractC0824B);
            c0454t6.f1572h.add(abstractC0824B);
            z = true;
        }
        if (z) {
            postAnimationRunner();
        }
    }

    public void assertInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            return;
        }
        if (str == null) {
            throw new IllegalStateException(outline.m276E(this, outline.m253r("Cannot call this method unless RecyclerView is computing a layout or scrolling")));
        }
        throw new IllegalStateException(outline.m276E(this, outline.m253r(str)));
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (isComputingLayout()) {
            if (str == null) {
                throw new IllegalStateException(outline.m276E(this, outline.m253r("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.mDispatchScrollCounter > 0) {
            Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(outline.m276E(this, outline.m253r(""))));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean canReuseUpdatedViewHolder(androidx.recyclerview.widget.RecyclerView.AbstractC0824B r5) {
        /*
            r4 = this;
            androidx.recyclerview.widget.RecyclerView$l r0 = r4.mItemAnimator
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L2b
            java.util.List r3 = r5.getUnmodifiedPayloads()
            T6 r0 = (p000.C0454T6) r0
            java.util.Objects.requireNonNull(r0)
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L28
            boolean r0 = r0.f4180g
            if (r0 == 0) goto L22
            boolean r5 = r5.isInvalid()
            if (r5 == 0) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L26
            goto L28
        L26:
            r5 = 0
            goto L29
        L28:
            r5 = 1
        L29:
            if (r5 == 0) goto L2c
        L2b:
            r1 = 1
        L2c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.canReuseUpdatedViewHolder(androidx.recyclerview.widget.RecyclerView$B):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.mLayout.checkLayoutParams((LayoutParams) layoutParams);
    }

    public void clearOldPositions() {
        int m2248h = this.mChildHelper.m2248h();
        for (int i = 0; i < m2248h; i++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2249g(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.clearOldPosition();
            }
        }
        C0854u c0854u = this.mRecycler;
        int size = c0854u.f3251c.size();
        for (int i2 = 0; i2 < size; i2++) {
            c0854u.f3251c.get(i2).clearOldPosition();
        }
        int size2 = c0854u.f3249a.size();
        for (int i3 = 0; i3 < size2; i3++) {
            c0854u.f3249a.get(i3).clearOldPosition();
        }
        ArrayList<AbstractC0824B> arrayList = c0854u.f3250b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i4 = 0; i4 < size3; i4++) {
                c0854u.f3250b.get(i4).clearOldPosition();
            }
        }
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<InterfaceC0848p> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            list.clear();
        }
    }

    public void clearOnScrollListeners() {
        List<AbstractC0851s> list = this.mScrollListeners;
        if (list != null) {
            list.clear();
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null && abstractC0843o.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null && abstractC0843o.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null && abstractC0843o.canScrollHorizontally()) {
            return this.mLayout.computeHorizontalScrollRange(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null && abstractC0843o.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollExtent(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null && abstractC0843o.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollOffset(this.mState);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null && abstractC0843o.canScrollVertically()) {
            return this.mLayout.computeVerticalScrollRange(this.mState);
        }
        return 0;
    }

    public void considerReleasingGlowsOnScroll(int i, int i2) {
        boolean z;
        EdgeEffect edgeEffect = this.mLeftGlow;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            z = false;
        } else {
            this.mLeftGlow.onRelease();
            z = this.mLeftGlow.isFinished();
        }
        EdgeEffect edgeEffect2 = this.mRightGlow;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.mRightGlow.onRelease();
            z |= this.mRightGlow.isFinished();
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i2 > 0) {
            this.mTopGlow.onRelease();
            z |= this.mTopGlow.isFinished();
        }
        EdgeEffect edgeEffect4 = this.mBottomGlow;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i2 < 0) {
            this.mBottomGlow.onRelease();
            z |= this.mBottomGlow.isFinished();
        }
        if (z) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1933k(this);
        }
    }

    public void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete && !this.mDataSetHasChangedAfterLayout) {
            if (this.mAdapterHelper.m2366g()) {
                C0217J6 c0217j6 = this.mAdapterHelper;
                int i = c0217j6.f688f;
                if ((i & 4) != 0) {
                    if (!((i & 11) != 0)) {
                        int i2 = C1616d4.f3984a;
                        Trace.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
                        startInterceptRequestLayout();
                        onEnterLayoutOrScroll();
                        this.mAdapterHelper.m2363j();
                        if (!this.mLayoutWasDefered) {
                            if (hasUpdatedView()) {
                                dispatchLayout();
                            } else {
                                this.mAdapterHelper.m2371b();
                            }
                        }
                        stopInterceptRequestLayout(true);
                        onExitLayoutOrScroll();
                        Trace.endSection();
                        return;
                    }
                }
                if (c0217j6.m2366g()) {
                    int i3 = C1616d4.f3984a;
                    Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
                    dispatchLayout();
                    Trace.endSection();
                    return;
                }
                return;
            }
            return;
        }
        int i4 = C1616d4.f3984a;
        Trace.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        Trace.endSection();
    }

    public void defaultOnMeasure(int i, int i2) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        AtomicInteger atomicInteger = C0492V4.f1798a;
        setMeasuredDimension(AbstractC0843o.chooseSize(i, paddingRight, C0492V4.C0495c.m1939e(this)), AbstractC0843o.chooseSize(i2, getPaddingBottom() + getPaddingTop(), C0492V4.C0495c.m1940d(this)));
    }

    public void dispatchChildAttached(View view) {
        AbstractC0824B childViewHolderInt = getChildViewHolderInt(view);
        onChildAttachedToWindow(view);
        AbstractC0832g abstractC0832g = this.mAdapter;
        if (abstractC0832g != null && childViewHolderInt != null) {
            abstractC0832g.onViewAttachedToWindow(childViewHolderInt);
        }
        List<InterfaceC0848p> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).mo298a(view);
            }
        }
    }

    public void dispatchChildDetached(View view) {
        AbstractC0824B childViewHolderInt = getChildViewHolderInt(view);
        onChildDetachedFromWindow(view);
        AbstractC0832g abstractC0832g = this.mAdapter;
        if (abstractC0832g != null && childViewHolderInt != null) {
            abstractC0832g.onViewDetachedFromWindow(childViewHolderInt);
        }
        List<InterfaceC0848p> list = this.mOnChildAttachStateListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mOnChildAttachStateListeners.get(size).mo297b(view);
            }
        }
    }

    public void dispatchLayout() {
        if (this.mAdapter == null) {
            Log.e(TAG, "No adapter attached; skipping layout");
        } else if (this.mLayout == null) {
            Log.e(TAG, "No layout manager attached; skipping layout");
        } else {
            C0860y c0860y = this.mState;
            boolean z = false;
            c0860y.f3273i = false;
            if (c0860y.f3268d == 1) {
                dispatchLayoutStep1();
                this.mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
            } else {
                C0217J6 c0217j6 = this.mAdapterHelper;
                if (!c0217j6.f685c.isEmpty() && !c0217j6.f684b.isEmpty()) {
                    z = true;
                }
                if (!z && this.mLayout.getWidth() == getWidth() && this.mLayout.getHeight() == getHeight()) {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                } else {
                    this.mLayout.setExactMeasureSpecsFrom(this);
                    dispatchLayoutStep2();
                }
            }
            dispatchLayoutStep3();
        }
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return getScrollingChildHelper().m2344a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().m2343b(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().m2342c(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return getScrollingChildHelper().m2341d(i, i2, i3, i4, iArr);
    }

    public void dispatchOnScrollStateChanged(int i) {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            abstractC0843o.onScrollStateChanged(i);
        }
        onScrollStateChanged(i);
        AbstractC0851s abstractC0851s = this.mScrollListener;
        if (abstractC0851s != null) {
            abstractC0851s.onScrollStateChanged(this, i);
        }
        List<AbstractC0851s> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrollStateChanged(this, i);
            }
        }
    }

    public void dispatchOnScrolled(int i, int i2) {
        this.mDispatchScrollCounter++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i2);
        onScrolled(i, i2);
        AbstractC0851s abstractC0851s = this.mScrollListener;
        if (abstractC0851s != null) {
            abstractC0851s.onScrolled(this, i, i2);
        }
        List<AbstractC0851s> list = this.mScrollListeners;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.mScrollListeners.get(size).onScrolled(this, i, i2);
            }
        }
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int i;
        for (int size = this.mPendingAccessibilityImportanceChange.size() - 1; size >= 0; size--) {
            AbstractC0824B abstractC0824B = this.mPendingAccessibilityImportanceChange.get(size);
            if (abstractC0824B.itemView.getParent() == this && !abstractC0824B.shouldIgnore() && (i = abstractC0824B.mPendingAccessibilityState) != -1) {
                View view = abstractC0824B.itemView;
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0495c.m1925s(view, i);
                abstractC0824B.mPendingAccessibilityState = -1;
            }
        }
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        int size = this.mItemDecorations.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDrawOver(canvas, this, this.mState);
        }
        EdgeEffect edgeEffect = this.mLeftGlow;
        boolean z3 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.mClipToPadding ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.mLeftGlow;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.mTopGlow;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.mClipToPadding) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.mTopGlow;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.mRightGlow;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.mClipToPadding ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.mRightGlow;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.mBottomGlow;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.mClipToPadding) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.mBottomGlow;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(save4);
        }
        if (z || this.mItemAnimator == null || this.mItemDecorations.size() <= 0 || !this.mItemAnimator.mo1367g()) {
            z3 = z;
        }
        if (z3) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1933k(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow != null) {
            return;
        }
        EdgeEffect m1373a = this.mEdgeEffectFactory.m1373a(this);
        this.mBottomGlow = m1373a;
        if (this.mClipToPadding) {
            m1373a.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            m1373a.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow != null) {
            return;
        }
        EdgeEffect m1373a = this.mEdgeEffectFactory.m1373a(this);
        this.mLeftGlow = m1373a;
        if (this.mClipToPadding) {
            m1373a.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            m1373a.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureRightGlow() {
        if (this.mRightGlow != null) {
            return;
        }
        EdgeEffect m1373a = this.mEdgeEffectFactory.m1373a(this);
        this.mRightGlow = m1373a;
        if (this.mClipToPadding) {
            m1373a.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            m1373a.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void ensureTopGlow() {
        if (this.mTopGlow != null) {
            return;
        }
        EdgeEffect m1373a = this.mEdgeEffectFactory.m1373a(this);
        this.mTopGlow = m1373a;
        if (this.mClipToPadding) {
            m1373a.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            m1373a.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String exceptionLabel() {
        StringBuilder m253r = outline.m253r(" ");
        m253r.append(super.toString());
        m253r.append(", adapter:");
        m253r.append(this.mAdapter);
        m253r.append(", layout:");
        m253r.append(this.mLayout);
        m253r.append(", context:");
        m253r.append(getContext());
        return m253r.toString();
    }

    public final void fillRemainingScrollValues(C0860y c0860y) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.mViewFlinger.f3213c;
            overScroller.getFinalX();
            overScroller.getCurrX();
            Objects.requireNonNull(c0860y);
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        Objects.requireNonNull(c0860y);
    }

    public View findChildViewUnder(float f, float f2) {
        for (int m2251e = this.mChildHelper.m2251e() - 1; m2251e >= 0; m2251e--) {
            View m2252d = this.mChildHelper.m2252d(m2251e);
            float translationX = m2252d.getTranslationX();
            float translationY = m2252d.getTranslationY();
            if (f >= m2252d.getLeft() + translationX && f <= m2252d.getRight() + translationX && f2 >= m2252d.getTop() + translationY && f2 <= m2252d.getBottom() + translationY) {
                return m2252d;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View findContainingItemView(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findContainingItemView(android.view.View):android.view.View");
    }

    public AbstractC0824B findContainingViewHolder(View view) {
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        return getChildViewHolder(findContainingItemView);
    }

    public AbstractC0824B findViewHolderForAdapterPosition(int i) {
        AbstractC0824B abstractC0824B = null;
        if (this.mDataSetHasChangedAfterLayout) {
            return null;
        }
        int m2248h = this.mChildHelper.m2248h();
        for (int i2 = 0; i2 < m2248h; i2++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2249g(i2));
            if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && getAdapterPositionFor(childViewHolderInt) == i) {
                if (!this.mChildHelper.m2245k(childViewHolderInt.itemView)) {
                    return childViewHolderInt;
                }
                abstractC0824B = childViewHolderInt;
            }
        }
        return abstractC0824B;
    }

    public AbstractC0824B findViewHolderForItemId(long j) {
        AbstractC0832g abstractC0832g = this.mAdapter;
        AbstractC0824B abstractC0824B = null;
        if (abstractC0832g != null && abstractC0832g.hasStableIds()) {
            int m2248h = this.mChildHelper.m2248h();
            for (int i = 0; i < m2248h; i++) {
                AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2249g(i));
                if (childViewHolderInt != null && !childViewHolderInt.isRemoved() && childViewHolderInt.getItemId() == j) {
                    if (!this.mChildHelper.m2245k(childViewHolderInt.itemView)) {
                        return childViewHolderInt;
                    }
                    abstractC0824B = childViewHolderInt;
                }
            }
        }
        return abstractC0824B;
    }

    public AbstractC0824B findViewHolderForLayoutPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    @Deprecated
    public AbstractC0824B findViewHolderForPosition(int i) {
        return findViewHolderForPosition(i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x015c, code lost:
        if (r0 < r13) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean fling(int r20, int r21) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.fling(int, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i) {
        View view2;
        boolean z;
        View onInterceptFocusSearch = this.mLayout.onInterceptFocusSearch(view, i);
        if (onInterceptFocusSearch != null) {
            return onInterceptFocusSearch;
        }
        boolean z2 = (this.mAdapter == null || this.mLayout == null || isComputingLayout() || this.mLayoutSuppressed) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z2 && (i == 2 || i == 1)) {
            if (this.mLayout.canScrollVertically()) {
                int i2 = i == 2 ? Wbxml.EXT_T_2 : 33;
                z = focusFinder.findNextFocus(this, view, i2) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i2;
                }
            } else {
                z = false;
            }
            if (!z && this.mLayout.canScrollHorizontally()) {
                int i3 = (this.mLayout.getLayoutDirection() == 1) ^ (i == 2) ? 66 : 17;
                boolean z3 = focusFinder.findNextFocus(this, view, i3) == null;
                if (FORCE_ABS_FOCUS_SEARCH_DIRECTION) {
                    i = i3;
                }
                z = z3;
            }
            if (z) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            }
            view2 = focusFinder.findNextFocus(this, view, i);
        } else {
            View findNextFocus = focusFinder.findNextFocus(this, view, i);
            if (findNextFocus == null && z2) {
                consumePendingUpdateOperations();
                if (findContainingItemView(view) == null) {
                    return null;
                }
                startInterceptRequestLayout();
                view2 = this.mLayout.onFocusSearchFailed(view, i, this.mRecycler, this.mState);
                stopInterceptRequestLayout(false);
            } else {
                view2 = findNextFocus;
            }
        }
        if (view2 == null || view2.hasFocusable()) {
            return isPreferredNextFocus(view, view2, i) ? view2 : super.focusSearch(view, i);
        } else if (getFocusedChild() == null) {
            return super.focusSearch(view, i);
        } else {
            requestChildOnScreen(view2, null);
            return view;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            return abstractC0843o.generateDefaultLayoutParams();
        }
        throw new IllegalStateException(outline.m276E(this, outline.m253r("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            return abstractC0843o.generateLayoutParams(getContext(), attributeSet);
        }
        throw new IllegalStateException(outline.m276E(this, outline.m253r("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public AbstractC0832g getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionFor(AbstractC0824B abstractC0824B) {
        if (abstractC0824B.hasAnyOfTheFlags(524) || !abstractC0824B.isBound()) {
            return -1;
        }
        C0217J6 c0217j6 = this.mAdapterHelper;
        int i = abstractC0824B.mPosition;
        int size = c0217j6.f684b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0217J6.C0219b c0219b = c0217j6.f684b.get(i2);
            int i3 = c0219b.f689a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = c0219b.f690b;
                    if (i4 <= i) {
                        int i5 = c0219b.f692d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = c0219b.f690b;
                    if (i6 == i) {
                        i = c0219b.f692d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (c0219b.f692d <= i) {
                            i++;
                        }
                    }
                }
            } else if (c0219b.f690b <= i) {
                i += c0219b.f692d;
            }
        }
        return i;
    }

    @Override // android.view.View
    public int getBaseline() {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            return abstractC0843o.getBaseline();
        }
        return super.getBaseline();
    }

    public long getChangedHolderKey(AbstractC0824B abstractC0824B) {
        return this.mAdapter.hasStableIds() ? abstractC0824B.getItemId() : abstractC0824B.mPosition;
    }

    public int getChildAdapterPosition(View view) {
        AbstractC0824B childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getAdapterPosition();
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        InterfaceC0835j interfaceC0835j = this.mChildDrawingOrderCallback;
        if (interfaceC0835j == null) {
            return super.getChildDrawingOrder(i, i2);
        }
        return interfaceC0835j.m1374a(i, i2);
    }

    public long getChildItemId(View view) {
        AbstractC0824B childViewHolderInt;
        AbstractC0832g abstractC0832g = this.mAdapter;
        if (abstractC0832g == null || !abstractC0832g.hasStableIds() || (childViewHolderInt = getChildViewHolderInt(view)) == null) {
            return -1L;
        }
        return childViewHolderInt.getItemId();
    }

    public int getChildLayoutPosition(View view) {
        AbstractC0824B childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            return childViewHolderInt.getLayoutPosition();
        }
        return -1;
    }

    @Deprecated
    public int getChildPosition(View view) {
        return getChildAdapterPosition(view);
    }

    public AbstractC0824B getChildViewHolder(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return getChildViewHolderInt(view);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public C1659e7 getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public C0836k getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public AbstractC0837l getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f3220c) {
            return layoutParams.f3219b;
        }
        if (this.mState.f3271g && (layoutParams.m1388b() || layoutParams.f3218a.isInvalid())) {
            return layoutParams.f3219b;
        }
        Rect rect = layoutParams.f3219b;
        rect.set(0, 0, 0, 0);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mTempRect.set(0, 0, 0, 0);
            this.mItemDecorations.get(i).getItemOffsets(this.mTempRect, view, this, this.mState);
            int i2 = rect.left;
            Rect rect2 = this.mTempRect;
            rect.left = i2 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        layoutParams.f3220c = false;
        return rect;
    }

    public AbstractC0842n getItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            return this.mItemDecorations.get(i);
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public AbstractC0843o getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK) {
            return System.nanoTime();
        }
        return 0L;
    }

    public AbstractC0849q getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public C0852t getRecycledViewPool() {
        return this.mRecycler.m1356d();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().m2338g(0);
    }

    public boolean hasPendingAdapterUpdates() {
        return !this.mFirstLayoutComplete || this.mDataSetHasChangedAfterLayout || this.mAdapterHelper.m2366g();
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new C0217J6(new C0831f());
    }

    public void initFastScroller(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new C0473U6(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(C0173H6.fastscroll_default_thickness), resources.getDimensionPixelSize(C0173H6.fastscroll_minimum_range), resources.getDimensionPixelOffset(C0173H6.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException(outline.m276E(this, outline.m253r("Trying to set fast scroller without both required drawables.")));
    }

    public void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() == 0) {
            return;
        }
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            abstractC0843o.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = this.mAccessibilityManager;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean isAnimating() {
        AbstractC0837l abstractC0837l = this.mItemAnimator;
        return abstractC0837l != null && abstractC0837l.mo1367g();
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        return this.mLayoutOrScrollCounter > 0;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f729d;
    }

    public void jumpToPositionForSmoothScroller(int i) {
        if (this.mLayout == null) {
            return;
        }
        setScrollState(2);
        this.mLayout.scrollToPosition(i);
        awakenScrollBars();
    }

    public void markItemDecorInsetsDirty() {
        int m2248h = this.mChildHelper.m2248h();
        for (int i = 0; i < m2248h; i++) {
            ((LayoutParams) this.mChildHelper.m2249g(i).getLayoutParams()).f3220c = true;
        }
        C0854u c0854u = this.mRecycler;
        int size = c0854u.f3251c.size();
        for (int i2 = 0; i2 < size; i2++) {
            LayoutParams layoutParams = (LayoutParams) c0854u.f3251c.get(i2).itemView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f3220c = true;
            }
        }
    }

    public void markKnownViewsInvalid() {
        int m2248h = this.mChildHelper.m2248h();
        for (int i = 0; i < m2248h; i++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2249g(i));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.addFlags(6);
            }
        }
        markItemDecorInsetsDirty();
        C0854u c0854u = this.mRecycler;
        int size = c0854u.f3251c.size();
        for (int i2 = 0; i2 < size; i2++) {
            AbstractC0824B abstractC0824B = c0854u.f3251c.get(i2);
            if (abstractC0824B != null) {
                abstractC0824B.addFlags(6);
                abstractC0824B.addChangePayload(null);
            }
        }
        AbstractC0832g abstractC0832g = RecyclerView.this.mAdapter;
        if (abstractC0832g == null || !abstractC0832g.hasStableIds()) {
            c0854u.m1354f();
        }
    }

    public void offsetChildrenHorizontal(int i) {
        int m2251e = this.mChildHelper.m2251e();
        for (int i2 = 0; i2 < m2251e; i2++) {
            this.mChildHelper.m2252d(i2).offsetLeftAndRight(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        int m2251e = this.mChildHelper.m2251e();
        for (int i2 = 0; i2 < m2251e; i2++) {
            this.mChildHelper.m2252d(i2).offsetTopAndBottom(i);
        }
    }

    public void offsetPositionRecordsForInsert(int i, int i2) {
        int m2248h = this.mChildHelper.m2248h();
        for (int i3 = 0; i3 < m2248h; i3++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2249g(i3));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && childViewHolderInt.mPosition >= i) {
                childViewHolderInt.offsetPosition(i2, false);
                this.mState.f3270f = true;
            }
        }
        C0854u c0854u = this.mRecycler;
        int size = c0854u.f3251c.size();
        for (int i4 = 0; i4 < size; i4++) {
            AbstractC0824B abstractC0824B = c0854u.f3251c.get(i4);
            if (abstractC0824B != null && abstractC0824B.mPosition >= i) {
                abstractC0824B.offsetPosition(i2, true);
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int m2248h = this.mChildHelper.m2248h();
        int i10 = -1;
        if (i < i2) {
            i4 = i;
            i3 = i2;
            i5 = -1;
        } else {
            i3 = i;
            i4 = i2;
            i5 = 1;
        }
        for (int i11 = 0; i11 < m2248h; i11++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2249g(i11));
            if (childViewHolderInt != null && (i9 = childViewHolderInt.mPosition) >= i4 && i9 <= i3) {
                if (i9 == i) {
                    childViewHolderInt.offsetPosition(i2 - i, false);
                } else {
                    childViewHolderInt.offsetPosition(i5, false);
                }
                this.mState.f3270f = true;
            }
        }
        C0854u c0854u = this.mRecycler;
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        int size = c0854u.f3251c.size();
        for (int i12 = 0; i12 < size; i12++) {
            AbstractC0824B abstractC0824B = c0854u.f3251c.get(i12);
            if (abstractC0824B != null && (i8 = abstractC0824B.mPosition) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    abstractC0824B.offsetPosition(i2 - i, false);
                } else {
                    abstractC0824B.offsetPosition(i10, false);
                }
            }
        }
        requestLayout();
    }

    public void offsetPositionRecordsForRemove(int i, int i2, boolean z) {
        int i3 = i + i2;
        int m2248h = this.mChildHelper.m2248h();
        for (int i4 = 0; i4 < m2248h; i4++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2249g(i4));
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore()) {
                int i5 = childViewHolderInt.mPosition;
                if (i5 >= i3) {
                    childViewHolderInt.offsetPosition(-i2, z);
                    this.mState.f3270f = true;
                } else if (i5 >= i) {
                    childViewHolderInt.flagRemovedAndOffsetPosition(i - 1, -i2, z);
                    this.mState.f3270f = true;
                }
            }
        }
        C0854u c0854u = this.mRecycler;
        int size = c0854u.f3251c.size();
        while (true) {
            size--;
            if (size >= 0) {
                AbstractC0824B abstractC0824B = c0854u.f3251c.get(size);
                if (abstractC0824B != null) {
                    int i6 = abstractC0824B.mPosition;
                    if (i6 >= i3) {
                        abstractC0824B.offsetPosition(-i2, z);
                    } else if (i6 >= i) {
                        abstractC0824B.addFlags(8);
                        c0854u.m1353g(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean z = true;
        this.mIsAttached = true;
        this.mFirstLayoutComplete = (!this.mFirstLayoutComplete || isLayoutRequested()) ? false : false;
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            abstractC0843o.dispatchAttachedToWindow(this);
        }
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK) {
            ThreadLocal<RunnableC0515V6> threadLocal = RunnableC0515V6.f1826f;
            RunnableC0515V6 runnableC0515V6 = threadLocal.get();
            this.mGapWorker = runnableC0515V6;
            if (runnableC0515V6 == null) {
                this.mGapWorker = new RunnableC0515V6();
                AtomicInteger atomicInteger = C0492V4.f1798a;
                Display m1923b = C0492V4.C0496d.m1923b(this);
                float f = 60.0f;
                if (!isInEditMode() && m1923b != null) {
                    float refreshRate = m1923b.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f = refreshRate;
                    }
                }
                RunnableC0515V6 runnableC0515V62 = this.mGapWorker;
                runnableC0515V62.f1830c = 1.0E9f / f;
                threadLocal.set(runnableC0515V62);
            }
            this.mGapWorker.f1828a.add(this);
        }
    }

    public void onChildAttachedToWindow(View view) {
    }

    public void onChildDetachedFromWindow(View view) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        RunnableC0515V6 runnableC0515V6;
        super.onDetachedFromWindow();
        AbstractC0837l abstractC0837l = this.mItemAnimator;
        if (abstractC0837l != null) {
            abstractC0837l.mo1368f();
        }
        stopScroll();
        this.mIsAttached = false;
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            abstractC0843o.dispatchDetachedFromWindow(this, this.mRecycler);
        }
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        Objects.requireNonNull(this.mViewInfoStore);
        do {
        } while (C1891i7.C1892a.f5278d.acquire() != null);
        if (!ALLOW_THREAD_GAP_WORK || (runnableC0515V6 = this.mGapWorker) == null) {
            return;
        }
        runnableC0515V6.f1828a.remove(this);
        this.mGapWorker = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.mItemDecorations.size();
        for (int i = 0; i < size; i++) {
            this.mItemDecorations.get(i).onDraw(canvas, this, this.mState);
        }
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.mLayout
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            boolean r0 = r5.mLayoutSuppressed
            if (r0 == 0) goto Lb
            return r1
        Lb:
            int r0 = r6.getAction()
            r2 = 8
            if (r0 != r2) goto L77
            int r0 = r6.getSource()
            r0 = r0 & 2
            r2 = 0
            if (r0 == 0) goto L3c
            androidx.recyclerview.widget.RecyclerView$o r0 = r5.mLayout
            boolean r0 = r0.canScrollVertically()
            if (r0 == 0) goto L2c
            r0 = 9
            float r0 = r6.getAxisValue(r0)
            float r0 = -r0
            goto L2d
        L2c:
            r0 = 0
        L2d:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L61
            r3 = 10
            float r3 = r6.getAxisValue(r3)
            goto L62
        L3c:
            int r0 = r6.getSource()
            r3 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r3
            if (r0 == 0) goto L60
            r0 = 26
            float r0 = r6.getAxisValue(r0)
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.canScrollVertically()
            if (r3 == 0) goto L55
            float r0 = -r0
            goto L61
        L55:
            androidx.recyclerview.widget.RecyclerView$o r3 = r5.mLayout
            boolean r3 = r3.canScrollHorizontally()
            if (r3 == 0) goto L60
            r3 = r0
            r0 = 0
            goto L62
        L60:
            r0 = 0
        L61:
            r3 = 0
        L62:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L6a
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 == 0) goto L77
        L6a:
            float r2 = r5.mScaledHorizontalScrollFactor
            float r3 = r3 * r2
            int r2 = (int) r3
            float r3 = r5.mScaledVerticalScrollFactor
            float r0 = r0 * r3
            int r0 = (int) r0
            r5.scrollByInternal(r2, r0, r6)
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (this.mLayoutSuppressed) {
            return false;
        }
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(motionEvent)) {
            cancelScroll();
            return true;
        }
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o == null) {
            return false;
        }
        boolean canScrollHorizontally = abstractC0843o.canScrollHorizontally();
        boolean canScrollVertically = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.mIgnoreMotionEventTillDown) {
                this.mIgnoreMotionEventTillDown = false;
            }
            this.mScrollPointerId = motionEvent.getPointerId(0);
            int x = (int) (motionEvent.getX() + 0.5f);
            this.mLastTouchX = x;
            this.mInitialTouchX = x;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.mLastTouchY = y;
            this.mInitialTouchY = y;
            if (this.mScrollState == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                stopNestedScroll(1);
            }
            int[] iArr = this.mNestedOffsets;
            iArr[1] = 0;
            iArr[0] = 0;
            int i = canScrollHorizontally;
            if (canScrollVertically) {
                i = (canScrollHorizontally ? 1 : 0) | 2;
            }
            startNestedScroll(i, 0);
        } else if (actionMasked == 1) {
            this.mVelocityTracker.clear();
            stopNestedScroll(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.mScrollPointerId);
            if (findPointerIndex < 0) {
                StringBuilder m253r = outline.m253r("Error processing scroll; pointer index for id ");
                m253r.append(this.mScrollPointerId);
                m253r.append(" not found. Did any MotionEvents get skipped?");
                Log.e(TAG, m253r.toString());
                return false;
            }
            int x2 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.mScrollState != 1) {
                int i2 = x2 - this.mInitialTouchX;
                int i3 = y2 - this.mInitialTouchY;
                if (!canScrollHorizontally || Math.abs(i2) <= this.mTouchSlop) {
                    z = false;
                } else {
                    this.mLastTouchX = x2;
                    z = true;
                }
                if (canScrollVertically && Math.abs(i3) > this.mTouchSlop) {
                    this.mLastTouchY = y2;
                    z = true;
                }
                if (z) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            cancelScroll();
        } else if (actionMasked == 5) {
            this.mScrollPointerId = motionEvent.getPointerId(actionIndex);
            int x3 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.mLastTouchX = x3;
            this.mInitialTouchX = x3;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.mLastTouchY = y3;
            this.mInitialTouchY = y3;
        } else if (actionMasked == 6) {
            onPointerUp(motionEvent);
        }
        return this.mScrollState == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = C1616d4.f3984a;
        Trace.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        Trace.endSection();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o == null) {
            defaultOnMeasure(i, i2);
            return;
        }
        boolean z = false;
        if (abstractC0843o.isAutoMeasureEnabled()) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z = true;
            }
            if (z || this.mAdapter == null) {
                return;
            }
            if (this.mState.f3268d == 1) {
                dispatchLayoutStep1();
            }
            this.mLayout.setMeasureSpecs(i, i2);
            this.mState.f3273i = true;
            dispatchLayoutStep2();
            this.mLayout.setMeasuredDimensionFromChildren(i, i2);
            if (this.mLayout.shouldMeasureTwice()) {
                this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.mState.f3273i = true;
                dispatchLayoutStep2();
                this.mLayout.setMeasuredDimensionFromChildren(i, i2);
            }
        } else if (this.mHasFixedSize) {
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
        } else {
            if (this.mAdapterUpdateDuringMeasure) {
                startInterceptRequestLayout();
                onEnterLayoutOrScroll();
                processAdapterUpdatesAndSetAnimationFlags();
                onExitLayoutOrScroll();
                C0860y c0860y = this.mState;
                if (c0860y.f3275k) {
                    c0860y.f3271g = true;
                } else {
                    this.mAdapterHelper.m2370c();
                    this.mState.f3271g = false;
                }
                this.mAdapterUpdateDuringMeasure = false;
                stopInterceptRequestLayout(false);
            } else if (this.mState.f3275k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            AbstractC0832g abstractC0832g = this.mAdapter;
            if (abstractC0832g != null) {
                this.mState.f3269e = abstractC0832g.getItemCount();
            } else {
                this.mState.f3269e = 0;
            }
            startInterceptRequestLayout();
            this.mLayout.onMeasure(this.mRecycler, this.mState, i, i2);
            stopInterceptRequestLayout(false);
            this.mState.f3271g = false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (isComputingLayout()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.mPendingSavedState = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o == null || (parcelable2 = this.mPendingSavedState.f3222a) == null) {
            return;
        }
        abstractC0843o.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.mPendingSavedState;
        if (savedState2 != null) {
            savedState.f3222a = savedState2.f3222a;
        } else {
            AbstractC0843o abstractC0843o = this.mLayout;
            if (abstractC0843o != null) {
                savedState.f3222a = abstractC0843o.onSaveInstanceState();
            } else {
                savedState.f3222a = null;
            }
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onScrolled(int i, int i2) {
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        invalidateGlows();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner || !this.mIsAttached) {
            return;
        }
        Runnable runnable = this.mItemAnimatorRunner;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1931m(this, runnable);
        this.mPostedAnimatorRunner = true;
    }

    public void processDataSetCompletelyChanged(boolean z) {
        this.mDispatchItemsChangedEvent = z | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public void recordAnimationInfoIfBouncedHiddenView(AbstractC0824B abstractC0824B, AbstractC0837l.C0840c c0840c) {
        abstractC0824B.setFlags(0, 8192);
        if (this.mState.f3272h && abstractC0824B.isUpdated() && !abstractC0824B.isRemoved() && !abstractC0824B.shouldIgnore()) {
            this.mViewInfoStore.f5277b.m2564g(getChangedHolderKey(abstractC0824B), abstractC0824B);
        }
        this.mViewInfoStore.m740c(abstractC0824B, c0840c);
    }

    public void removeAndRecycleViews() {
        AbstractC0837l abstractC0837l = this.mItemAnimator;
        if (abstractC0837l != null) {
            abstractC0837l.mo1368f();
        }
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            abstractC0843o.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        }
        this.mRecycler.m1358b();
    }

    public boolean removeAnimatingView(View view) {
        startInterceptRequestLayout();
        C0247K6 c0247k6 = this.mChildHelper;
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        boolean z = true;
        if (indexOfChild == -1) {
            c0247k6.m2243m(view);
        } else if (c0247k6.f781b.m2239d(indexOfChild)) {
            c0247k6.f781b.m2237f(indexOfChild);
            c0247k6.m2243m(view);
            ((C0830e) c0247k6.f780a).m1384c(indexOfChild);
        } else {
            z = false;
        }
        if (z) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(view);
            this.mRecycler.m1348l(childViewHolderInt);
            this.mRecycler.m1351i(childViewHolderInt);
        }
        stopInterceptRequestLayout(!z);
        return z;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z) {
        AbstractC0824B childViewHolderInt = getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached()) {
                childViewHolderInt.clearTmpDetachFlag();
            } else if (!childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(outline.m276E(this, sb));
            }
        }
        view.clearAnimation();
        dispatchChildDetached(view);
        super.removeDetachedView(view, z);
    }

    public void removeItemDecoration(AbstractC0842n abstractC0842n) {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            abstractC0843o.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
        }
        this.mItemDecorations.remove(abstractC0842n);
        if (this.mItemDecorations.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public void removeItemDecorationAt(int i) {
        int itemDecorationCount = getItemDecorationCount();
        if (i >= 0 && i < itemDecorationCount) {
            removeItemDecoration(getItemDecorationAt(i));
            return;
        }
        throw new IndexOutOfBoundsException(i + " is an invalid index for size " + itemDecorationCount);
    }

    public void removeOnChildAttachStateChangeListener(InterfaceC0848p interfaceC0848p) {
        List<InterfaceC0848p> list = this.mOnChildAttachStateListeners;
        if (list == null) {
            return;
        }
        list.remove(interfaceC0848p);
    }

    public void removeOnItemTouchListener(InterfaceC0850r interfaceC0850r) {
        this.mOnItemTouchListeners.remove(interfaceC0850r);
        if (this.mInterceptingOnItemTouchListener == interfaceC0850r) {
            this.mInterceptingOnItemTouchListener = null;
        }
    }

    public void removeOnScrollListener(AbstractC0851s abstractC0851s) {
        List<AbstractC0851s> list = this.mScrollListeners;
        if (list != null) {
            list.remove(abstractC0851s);
        }
    }

    public void repositionShadowingViews() {
        AbstractC0824B abstractC0824B;
        int m2251e = this.mChildHelper.m2251e();
        for (int i = 0; i < m2251e; i++) {
            View m2252d = this.mChildHelper.m2252d(i);
            AbstractC0824B childViewHolder = getChildViewHolder(m2252d);
            if (childViewHolder != null && (abstractC0824B = childViewHolder.mShadowingHolder) != null) {
                View view = abstractC0824B.itemView;
                int left = m2252d.getLeft();
                int top = m2252d.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.mLayout.onRequestChildFocus(this, this.mState, view, view2) && view2 != null) {
            requestChildOnScreen(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.mLayout.requestChildRectangleOnScreen(this, view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        int size = this.mOnItemTouchListeners.size();
        for (int i = 0; i < size; i++) {
            this.mOnItemTouchListeners.get(i).mo1362c(z);
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0 && !this.mLayoutSuppressed) {
            super.requestLayout();
        } else {
            this.mLayoutWasDefered = true;
        }
    }

    public void saveOldPositions() {
        int m2248h = this.mChildHelper.m2248h();
        for (int i = 0; i < m2248h; i++) {
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(this.mChildHelper.m2249g(i));
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.saveOldPosition();
            }
        }
    }

    @Override // android.view.View
    public void scrollBy(int i, int i2) {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o == null) {
            Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            boolean canScrollHorizontally = abstractC0843o.canScrollHorizontally();
            boolean canScrollVertically = this.mLayout.canScrollVertically();
            if (canScrollHorizontally || canScrollVertically) {
                if (!canScrollHorizontally) {
                    i = 0;
                }
                if (!canScrollVertically) {
                    i2 = 0;
                }
                scrollByInternal(i, i2, null);
            }
        }
    }

    public boolean scrollByInternal(int i, int i2, MotionEvent motionEvent) {
        int i3;
        int i4;
        int i5;
        int i6;
        consumePendingUpdateOperations();
        if (this.mAdapter != null) {
            int[] iArr = this.mReusableIntPair;
            iArr[0] = 0;
            iArr[1] = 0;
            scrollStep(i, i2, iArr);
            int[] iArr2 = this.mReusableIntPair;
            int i7 = iArr2[0];
            int i8 = iArr2[1];
            i3 = i8;
            i4 = i7;
            i5 = i - i7;
            i6 = i2 - i8;
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
        }
        if (!this.mItemDecorations.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.mReusableIntPair;
        iArr3[0] = 0;
        iArr3[1] = 0;
        dispatchNestedScroll(i4, i3, i5, i6, this.mScrollOffset, 0, iArr3);
        int[] iArr4 = this.mReusableIntPair;
        int i9 = i5 - iArr4[0];
        int i10 = i6 - iArr4[1];
        boolean z = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i11 = this.mLastTouchX;
        int[] iArr5 = this.mScrollOffset;
        this.mLastTouchX = i11 - iArr5[0];
        this.mLastTouchY -= iArr5[1];
        int[] iArr6 = this.mNestedOffsets;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent != null) {
                if (!((motionEvent.getSource() & 8194) == 8194)) {
                    pullGlows(motionEvent.getX(), i9, motionEvent.getY(), i10);
                }
            }
            considerReleasingGlowsOnScroll(i, i2);
        }
        if (i4 != 0 || i3 != 0) {
            dispatchOnScrolled(i4, i3);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z && i4 == 0 && i3 == 0) ? false : true;
    }

    public void scrollStep(int i, int i2, int[] iArr) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        int i3 = C1616d4.f3984a;
        Trace.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        int scrollHorizontallyBy = i != 0 ? this.mLayout.scrollHorizontallyBy(i, this.mRecycler, this.mState) : 0;
        int scrollVerticallyBy = i2 != 0 ? this.mLayout.scrollVerticallyBy(i2, this.mRecycler, this.mState) : 0;
        Trace.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (iArr != null) {
            iArr[0] = scrollHorizontallyBy;
            iArr[1] = scrollVerticallyBy;
        }
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        stopScroll();
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o == null) {
            Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        abstractC0843o.scrollToPosition(i);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (shouldDeferAccessibilityEvent(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(C1659e7 c1659e7) {
        this.mAccessibilityDelegate = c1659e7;
        C0492V4.m1950u(this, c1659e7);
    }

    public void setAdapter(AbstractC0832g abstractC0832g) {
        setLayoutFrozen(false);
        setAdapterInternal(abstractC0832g, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(InterfaceC0835j interfaceC0835j) {
        if (interfaceC0835j == this.mChildDrawingOrderCallback) {
            return;
        }
        this.mChildDrawingOrderCallback = interfaceC0835j;
        setChildrenDrawingOrderEnabled(interfaceC0835j != null);
    }

    public boolean setChildImportantForAccessibilityInternal(AbstractC0824B abstractC0824B, int i) {
        if (isComputingLayout()) {
            abstractC0824B.mPendingAccessibilityState = i;
            this.mPendingAccessibilityImportanceChange.add(abstractC0824B);
            return false;
        }
        View view = abstractC0824B.itemView;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1925s(view, i);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.mClipToPadding) {
            invalidateGlows();
        }
        this.mClipToPadding = z;
        super.setClipToPadding(z);
        if (this.mFirstLayoutComplete) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(C0836k c0836k) {
        Objects.requireNonNull(c0836k);
        this.mEdgeEffectFactory = c0836k;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean z) {
        this.mHasFixedSize = z;
    }

    public void setItemAnimator(AbstractC0837l abstractC0837l) {
        AbstractC0837l abstractC0837l2 = this.mItemAnimator;
        if (abstractC0837l2 != null) {
            abstractC0837l2.mo1368f();
            this.mItemAnimator.f3228a = null;
        }
        this.mItemAnimator = abstractC0837l;
        if (abstractC0837l != null) {
            abstractC0837l.f3228a = this.mItemAnimatorListener;
        }
    }

    public void setItemViewCacheSize(int i) {
        C0854u c0854u = this.mRecycler;
        c0854u.f3253e = i;
        c0854u.m1347m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(AbstractC0843o abstractC0843o) {
        if (abstractC0843o == this.mLayout) {
            return;
        }
        stopScroll();
        if (this.mLayout != null) {
            AbstractC0837l abstractC0837l = this.mItemAnimator;
            if (abstractC0837l != null) {
                abstractC0837l.mo1368f();
            }
            this.mLayout.removeAndRecycleAllViews(this.mRecycler);
            this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
            this.mRecycler.m1358b();
            if (this.mIsAttached) {
                this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
            }
            this.mLayout.setRecyclerView(null);
            this.mLayout = null;
        } else {
            this.mRecycler.m1358b();
        }
        C0247K6 c0247k6 = this.mChildHelper;
        C0247K6.C0248a c0248a = c0247k6.f781b;
        c0248a.f783a = 0L;
        C0247K6.C0248a c0248a2 = c0248a.f784b;
        if (c0248a2 != null) {
            c0248a2.m2236g();
        }
        int size = c0247k6.f782c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C0830e c0830e = (C0830e) c0247k6.f780a;
            Objects.requireNonNull(c0830e);
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(c0247k6.f782c.get(size));
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
            c0247k6.f782c.remove(size);
        }
        C0830e c0830e2 = (C0830e) c0247k6.f780a;
        int m1385b = c0830e2.m1385b();
        for (int i = 0; i < m1385b; i++) {
            View m1386a = c0830e2.m1386a(i);
            RecyclerView.this.dispatchChildDetached(m1386a);
            m1386a.clearAnimation();
        }
        RecyclerView.this.removeAllViews();
        this.mLayout = abstractC0843o;
        if (abstractC0843o != null) {
            if (abstractC0843o.mRecyclerView == null) {
                abstractC0843o.setRecyclerView(this);
                if (this.mIsAttached) {
                    this.mLayout.dispatchAttachedToWindow(this);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("LayoutManager ");
                sb.append(abstractC0843o);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(outline.m276E(abstractC0843o.mRecyclerView, sb));
            }
        }
        this.mRecycler.m1347m();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        C0235K4 scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f729d) {
            View view = scrollingChildHelper.f728c;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0500h.m1875z(view);
        }
        scrollingChildHelper.f729d = z;
    }

    public void setOnFlingListener(AbstractC0849q abstractC0849q) {
        this.mOnFlingListener = abstractC0849q;
    }

    @Deprecated
    public void setOnScrollListener(AbstractC0851s abstractC0851s) {
        this.mScrollListener = abstractC0851s;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.mPreserveFocusAfterLayout = z;
    }

    public void setRecycledViewPool(C0852t c0852t) {
        C0852t c0852t2;
        C0854u c0854u = this.mRecycler;
        if (c0854u.f3255g != null) {
            c0852t2.f3244b--;
        }
        c0854u.f3255g = c0852t;
        if (c0852t == null || RecyclerView.this.getAdapter() == null) {
            return;
        }
        c0854u.f3255g.f3244b++;
    }

    public void setRecyclerListener(InterfaceC0855v interfaceC0855v) {
        this.mRecyclerListener = interfaceC0855v;
    }

    public void setScrollState(int i) {
        if (i == this.mScrollState) {
            return;
        }
        this.mScrollState = i;
        if (i != 2) {
            stopScrollersInternal();
        }
        dispatchOnScrollStateChanged(i);
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i != 1) {
                Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
            } else {
                this.mTouchSlop = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(AbstractC0861z abstractC0861z) {
        Objects.requireNonNull(this.mRecycler);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (isComputingLayout()) {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.mEatenAccessibilityChangeFlags |= contentChangeTypes != 0 ? contentChangeTypes : 0;
            return true;
        }
        return false;
    }

    public void smoothScrollBy(int i, int i2) {
        smoothScrollBy(i, i2, null);
    }

    public void smoothScrollToPosition(int i) {
        if (this.mLayoutSuppressed) {
            return;
        }
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            abstractC0843o.smoothScrollToPosition(this, this.mState, i);
        }
    }

    public void startInterceptRequestLayout() {
        int i = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = i;
        if (i != 1 || this.mLayoutSuppressed) {
            return;
        }
        this.mLayoutWasDefered = false;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return getScrollingChildHelper().m2337h(i, 0);
    }

    public void stopInterceptRequestLayout(boolean z) {
        if (this.mInterceptRequestLayoutDepth < 1) {
            this.mInterceptRequestLayoutDepth = 1;
        }
        if (!z && !this.mLayoutSuppressed) {
            this.mLayoutWasDefered = false;
        }
        if (this.mInterceptRequestLayoutDepth == 1) {
            if (z && this.mLayoutWasDefered && !this.mLayoutSuppressed && this.mLayout != null && this.mAdapter != null) {
                dispatchLayout();
            }
            if (!this.mLayoutSuppressed) {
                this.mLayoutWasDefered = false;
            }
        }
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().m2336i(0);
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.mLayoutSuppressed) {
            assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.mLayoutSuppressed = false;
                if (this.mLayoutWasDefered && this.mLayout != null && this.mAdapter != null) {
                    requestLayout();
                }
                this.mLayoutWasDefered = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.mLayoutSuppressed = true;
            this.mIgnoreMotionEventTillDown = true;
            stopScroll();
        }
    }

    public void swapAdapter(AbstractC0832g abstractC0832g, boolean z) {
        setLayoutFrozen(false);
        setAdapterInternal(abstractC0832g, true, z);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void viewRangeUpdate(int i, int i2, Object obj) {
        int i3;
        int i4;
        int m2248h = this.mChildHelper.m2248h();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < m2248h; i6++) {
            View m2249g = this.mChildHelper.m2249g(i6);
            AbstractC0824B childViewHolderInt = getChildViewHolderInt(m2249g);
            if (childViewHolderInt != null && !childViewHolderInt.shouldIgnore() && (i4 = childViewHolderInt.mPosition) >= i && i4 < i5) {
                childViewHolderInt.addFlags(2);
                childViewHolderInt.addChangePayload(obj);
                ((LayoutParams) m2249g.getLayoutParams()).f3220c = true;
            }
        }
        C0854u c0854u = this.mRecycler;
        int size = c0854u.f3251c.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            AbstractC0824B abstractC0824B = c0854u.f3251c.get(size);
            if (abstractC0824B != null && (i3 = abstractC0824B.mPosition) >= i && i3 < i5) {
                abstractC0824B.addFlags(2);
                c0854u.m1353g(size);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.RecyclerView$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0832g<VH extends AbstractC0824B> {
        private final C0833h mObservable = new C0833h();
        private boolean mHasStableIds = false;

        public final void bindViewHolder(VH vh, int i) {
            vh.mPosition = i;
            if (hasStableIds()) {
                vh.mItemId = getItemId(i);
            }
            vh.setFlags(1, 519);
            int i2 = C1616d4.f3984a;
            Trace.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            vh.clearPayload();
            ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
            if (layoutParams instanceof LayoutParams) {
                ((LayoutParams) layoutParams).f3220c = true;
            }
            Trace.endSection();
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                int i2 = C1616d4.f3984a;
                Trace.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    Trace.endSection();
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } catch (Throwable th) {
                int i3 = C1616d4.f3984a;
                Trace.endSection();
                throw th;
            }
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1L;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final boolean hasObservers() {
            return this.mObservable.m1380a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.m1379b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.m1377d(i, 1, null);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.m1376e(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.m1378c(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.m1377d(i, i2, null);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.m1376e(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.m1375f(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.m1375f(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(AbstractC0834i abstractC0834i) {
            this.mObservable.registerObserver(abstractC0834i);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void unregisterAdapterDataObserver(AbstractC0834i abstractC0834i) {
            this.mObservable.unregisterObserver(abstractC0834i);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.m1377d(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.m1377d(i, i2, obj);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0152G6.recyclerViewStyle);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return getScrollingChildHelper().m2340e(i, i2, i3, i4, iArr, i5, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.recyclerview.widget.RecyclerView.AbstractC0824B findViewHolderForPosition(int r6, boolean r7) {
        /*
            r5 = this;
            K6 r0 = r5.mChildHelper
            int r0 = r0.m2248h()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            K6 r3 = r5.mChildHelper
            android.view.View r3 = r3.m2249g(r2)
            androidx.recyclerview.widget.RecyclerView$B r3 = getChildViewHolderInt(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.isRemoved()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.mPosition
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.getLayoutPosition()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            K6 r1 = r5.mChildHelper
            android.view.View r4 = r3.itemView
            boolean r1 = r1.m2245k(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.findViewHolderForPosition(int, boolean):androidx.recyclerview.widget.RecyclerView$B");
    }

    public void onExitLayoutOrScroll(boolean z) {
        int i = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = i;
        if (i < 1) {
            this.mLayoutOrScrollCounter = 0;
            if (z) {
                dispatchContentChangedIfNecessary();
                dispatchPendingImportantForAccessibilityChanges();
            }
        }
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator) {
        smoothScrollBy(i, i2, interpolator, Integer.MIN_VALUE);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        float m1820a;
        float m1820a2;
        this.mObserver = new C0856w();
        this.mRecycler = new C0854u();
        this.mViewInfoStore = new C1891i7();
        this.mUpdateChildViewsRunnable = new RunnableC0826a();
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mItemDecorations = new ArrayList<>();
        this.mOnItemTouchListeners = new ArrayList<>();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new C0836k();
        this.mItemAnimator = new C0454T6();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new RunnableC0823A();
        this.mPrefetchRegistry = ALLOW_THREAD_GAP_WORK ? new RunnableC0515V6.C0517b() : null;
        this.mState = new C0860y();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new C0841m();
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new RunnableC0827b();
        this.mViewInfoProcessCallback = new C0829d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        Method method = C0535W4.f1890a;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            m1820a = viewConfiguration.getScaledHorizontalScrollFactor();
        } else {
            m1820a = C0535W4.m1820a(viewConfiguration, context);
        }
        this.mScaledHorizontalScrollFactor = m1820a;
        if (i2 >= 26) {
            m1820a2 = viewConfiguration.getScaledVerticalScrollFactor();
        } else {
            m1820a2 = C0535W4.m1820a(viewConfiguration, context);
        }
        this.mScaledVerticalScrollFactor = m1820a2;
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.mItemAnimator.f3228a = this.mItemAnimatorListener;
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        AtomicInteger atomicInteger = C0492V4.f1798a;
        if (C0492V4.C0495c.m1941c(this) == 0) {
            C0492V4.C0495c.m1925s(this, 1);
        }
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new C1659e7(this));
        int[] iArr = C0198I6.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        if (i2 >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        }
        String string = obtainStyledAttributes.getString(C0198I6.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(C0198I6.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.mClipToPadding = obtainStyledAttributes.getBoolean(C0198I6.RecyclerView_android_clipToPadding, true);
        boolean z = obtainStyledAttributes.getBoolean(C0198I6.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = z;
        if (z) {
            initFastScroller((StateListDrawable) obtainStyledAttributes.getDrawable(C0198I6.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(C0198I6.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(C0198I6.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(C0198I6.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        createLayoutManager(context, string, attributeSet, i, 0);
        int[] iArr2 = NESTED_SCROLLING_ATTRS;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i, 0);
        if (i2 >= 29) {
            saveAttributeDataForStyleable(context, iArr2, attributeSet, obtainStyledAttributes2, i, 0);
        }
        boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return getScrollingChildHelper().m2342c(i, i2, iArr, iArr2, i3);
    }

    public boolean hasNestedScrollingParent(int i) {
        return getScrollingChildHelper().m2339f(i) != null;
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3) {
        smoothScrollBy(i, i2, interpolator, i3, false);
    }

    public boolean startNestedScroll(int i, int i2) {
        return getScrollingChildHelper().m2337h(i, i2);
    }

    public void stopNestedScroll(int i) {
        getScrollingChildHelper().m2336i(i);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public AbstractC0824B f3218a;

        /* renamed from: b */
        public final Rect f3219b;

        /* renamed from: c */
        public boolean f3220c;

        /* renamed from: d */
        public boolean f3221d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3219b = new Rect();
            this.f3220c = true;
            this.f3221d = false;
        }

        /* renamed from: a */
        public int m1389a() {
            return this.f3218a.getLayoutPosition();
        }

        /* renamed from: b */
        public boolean m1388b() {
            return this.f3218a.isUpdated();
        }

        /* renamed from: c */
        public boolean m1387c() {
            return this.f3218a.isRemoved();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3219b = new Rect();
            this.f3220c = true;
            this.f3221d = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3219b = new Rect();
            this.f3220c = true;
            this.f3221d = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3219b = new Rect();
            this.f3220c = true;
            this.f3221d = false;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.LayoutParams) layoutParams);
            this.f3219b = new Rect();
            this.f3220c = true;
            this.f3221d = false;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0825a();

        /* renamed from: a */
        public Parcelable f3222a;

        /* renamed from: androidx.recyclerview.widget.RecyclerView$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0825a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3222a = parcel.readParcelable(classLoader == null ? AbstractC0843o.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f3222a, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public final void dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        getScrollingChildHelper().m2340e(i, i2, i3, i4, iArr, i5, iArr2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o != null) {
            return abstractC0843o.generateLayoutParams(layoutParams);
        }
        throw new IllegalStateException(outline.m276E(this, outline.m253r("RecyclerView has no LayoutManager")));
    }

    public void smoothScrollBy(int i, int i2, Interpolator interpolator, int i3, boolean z) {
        AbstractC0843o abstractC0843o = this.mLayout;
        if (abstractC0843o == null) {
            Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.mLayoutSuppressed) {
        } else {
            if (!abstractC0843o.canScrollHorizontally()) {
                i = 0;
            }
            if (!this.mLayout.canScrollVertically()) {
                i2 = 0;
            }
            if (i == 0 && i2 == 0) {
                return;
            }
            if (i3 == Integer.MIN_VALUE || i3 > 0) {
                if (z) {
                    int i4 = i != 0 ? 1 : 0;
                    if (i2 != 0) {
                        i4 |= 2;
                    }
                    startNestedScroll(i4, 1);
                }
                this.mViewFlinger.m1391b(i, i2, i3, interpolator);
                return;
            }
            scrollBy(i, i2);
        }
    }

    public void addItemDecoration(AbstractC0842n abstractC0842n) {
        addItemDecoration(abstractC0842n, -1);
    }
}
