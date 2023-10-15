package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.nhaarman.listviewanimations.itemmanipulation.TouchEventHandler;
import com.nhaarman.listviewanimations.util.AdapterViewUtil;
import com.nhaarman.listviewanimations.util.ListViewWrapper;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class SwipeTouchListener implements View.OnTouchListener, TouchEventHandler {
    private static final String ALPHA = "alpha";
    private static final int MIN_FLING_VELOCITY_FACTOR = 16;
    private static final String TRANSLATION_X = "translationX";
    private int mActiveSwipeCount;
    private final long mAnimationTime;
    private boolean mCanDismissCurrent;
    private View mCurrentView;
    private DismissableManager mDismissableManager;
    private float mDownX;
    private float mDownY;
    private final ListViewWrapper mListViewWrapper;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private float mMinimumAlpha;
    private boolean mParentIsHorizontalScrollContainer;
    private final int mSlop;
    private boolean mSwiping;
    private View mSwipingView;
    private int mTouchChildResId;
    private VelocityTracker mVelocityTracker;
    private int mViewWidth = 1;
    private int mCurrentPosition = -1;
    private int mVirtualListCount = -1;
    private boolean mSwipeEnabled = true;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class FlingAnimatorListener extends AnimatorListenerAdapter {
        private final int mPosition;
        private final View mView;

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeTouchListener.access$210(SwipeTouchListener.this);
            SwipeTouchListener.this.afterViewFling(this.mView, this.mPosition);
        }

        private FlingAnimatorListener(View view, int i) {
            this.mView = view;
            this.mPosition = i;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RestoreAnimatorListener extends AnimatorListenerAdapter {
        private final int mPosition;
        private final View mView;

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SwipeTouchListener.access$210(SwipeTouchListener.this);
            SwipeTouchListener.this.afterCancelSwipe(this.mView, this.mPosition);
        }

        private RestoreAnimatorListener(View view, int i) {
            this.mView = view;
            this.mPosition = i;
        }
    }

    public SwipeTouchListener(ListViewWrapper listViewWrapper) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(listViewWrapper.getListView().getContext());
        this.mSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.mMaxFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mAnimationTime = listViewWrapper.getListView().getContext().getResources().getInteger(17694720);
        this.mListViewWrapper = listViewWrapper;
    }

    public static /* synthetic */ int access$210(SwipeTouchListener swipeTouchListener) {
        int i = swipeTouchListener.mActiveSwipeCount;
        swipeTouchListener.mActiveSwipeCount = i - 1;
        return i;
    }

    private void disableHorizontalScrollContainerIfNecessary(MotionEvent motionEvent, View view) {
        if (this.mParentIsHorizontalScrollContainer) {
            this.mListViewWrapper.getListView().requestDisallowInterceptTouchEvent(true);
            return;
        }
        int i = this.mTouchChildResId;
        if (i != 0) {
            this.mParentIsHorizontalScrollContainer = false;
            View findViewById = view.findViewById(i);
            if (findViewById == null || !getChildViewRect(this.mListViewWrapper.getListView(), findViewById).contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return;
            }
            this.mListViewWrapper.getListView().requestDisallowInterceptTouchEvent(true);
        }
    }

    private View findDownView(MotionEvent motionEvent) {
        Rect rect = new Rect();
        int childCount = this.mListViewWrapper.getChildCount();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        View view = null;
        for (int i = 0; i < childCount && view == null; i++) {
            View childAt = this.mListViewWrapper.getChildAt(i);
            if (childAt != null) {
                childAt.getHitRect(rect);
                if (rect.contains(x, y)) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    private void flingCurrentView(boolean z) {
        View view = this.mCurrentView;
        if (view != null) {
            flingView(view, this.mCurrentPosition, z);
        }
    }

    private void flingView(View view, int i, boolean z) {
        if (this.mViewWidth < 2) {
            this.mViewWidth = this.mListViewWrapper.getListView().getWidth();
        }
        View swipeView = getSwipeView(view);
        float[] fArr = new float[1];
        fArr[0] = z ? this.mViewWidth : -this.mViewWidth;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(swipeView, TRANSLATION_X, fArr);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(swipeView, ALPHA, 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(this.mAnimationTime);
        animatorSet.addListener(new FlingAnimatorListener(view, i));
        animatorSet.start();
    }

    private static Rect getChildViewRect(View view, View view2) {
        Rect rect = new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        boolean equals = view.equals(view2);
        ViewGroup viewGroup = view2;
        if (!equals) {
            while (true) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                if (viewGroup2.equals(view)) {
                    break;
                }
                rect.offset(viewGroup2.getLeft(), viewGroup2.getTop());
                viewGroup = viewGroup2;
            }
        }
        return rect;
    }

    private boolean handleCancelEvent() {
        View view;
        if (this.mVelocityTracker != null && (view = this.mCurrentView) != null) {
            int i = this.mCurrentPosition;
            if (i != -1 && this.mSwiping) {
                onCancelSwipe(view, i);
                restoreCurrentViewTranslation();
            }
            reset();
        }
        return false;
    }

    private boolean handleDownEvent(View view, MotionEvent motionEvent) {
        View findDownView;
        if (this.mSwipeEnabled && (findDownView = findDownView(motionEvent)) != null) {
            int positionForView = AdapterViewUtil.getPositionForView(this.mListViewWrapper, findDownView);
            this.mCanDismissCurrent = isDismissable(positionForView);
            if (this.mCurrentPosition == positionForView || positionForView >= this.mVirtualListCount) {
                return false;
            }
            if (view != null) {
                view.onTouchEvent(motionEvent);
            }
            disableHorizontalScrollContainerIfNecessary(motionEvent, findDownView);
            this.mDownX = motionEvent.getX();
            this.mDownY = motionEvent.getY();
            this.mCurrentView = findDownView;
            this.mSwipingView = getSwipeView(findDownView);
            this.mCurrentPosition = positionForView;
            VelocityTracker obtain = VelocityTracker.obtain();
            this.mVelocityTracker = obtain;
            obtain.addMovement(motionEvent);
            return true;
        }
        return false;
    }

    private boolean handleMoveEvent(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null && this.mCurrentView != null) {
            velocityTracker.addMovement(motionEvent);
            float x = motionEvent.getX() - this.mDownX;
            float y = motionEvent.getY() - this.mDownY;
            if (Math.abs(x) > this.mSlop && Math.abs(x) > Math.abs(y)) {
                if (!this.mSwiping) {
                    this.mActiveSwipeCount++;
                    onStartSwipe(this.mCurrentView, this.mCurrentPosition);
                }
                this.mSwiping = true;
                this.mListViewWrapper.getListView().requestDisallowInterceptTouchEvent(true);
                if (view != null) {
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                    view.onTouchEvent(obtain);
                    obtain.recycle();
                }
            }
            if (this.mSwiping) {
                if (this.mCanDismissCurrent) {
                    ViewHelper.setTranslationX(this.mSwipingView, x);
                    ViewHelper.setAlpha(this.mSwipingView, Math.max(this.mMinimumAlpha, Math.min(1.0f, 1.0f - ((Math.abs(x) * 2.0f) / this.mViewWidth))));
                } else {
                    ViewHelper.setTranslationX(this.mSwipingView, x * 0.1f);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        if (r0 > 0.0f) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        r8 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
        if (r7.mVelocityTracker.getXVelocity() > 0.0f) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean handleUpEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            android.view.VelocityTracker r0 = r7.mVelocityTracker
            r1 = 0
            if (r0 == 0) goto L9a
            android.view.View r0 = r7.mCurrentView
            if (r0 != 0) goto Lb
            goto L9a
        Lb:
            boolean r0 = r7.mSwiping
            if (r0 == 0) goto L97
            boolean r0 = r7.mCanDismissCurrent
            r2 = 1
            if (r0 == 0) goto L6f
            float r0 = r8.getX()
            float r3 = r7.mDownX
            float r0 = r0 - r3
            android.view.VelocityTracker r3 = r7.mVelocityTracker
            r3.addMovement(r8)
            android.view.VelocityTracker r8 = r7.mVelocityTracker
            r3 = 1000(0x3e8, float:1.401E-42)
            r8.computeCurrentVelocity(r3)
            android.view.VelocityTracker r8 = r7.mVelocityTracker
            float r8 = r8.getXVelocity()
            float r8 = java.lang.Math.abs(r8)
            android.view.VelocityTracker r3 = r7.mVelocityTracker
            float r3 = r3.getYVelocity()
            float r3 = java.lang.Math.abs(r3)
            float r4 = java.lang.Math.abs(r0)
            int r5 = r7.mViewWidth
            int r5 = r5 / 2
            float r5 = (float) r5
            r6 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L52
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 <= 0) goto L4f
        L4d:
            r8 = 1
            goto L50
        L4f:
            r8 = 0
        L50:
            r0 = 1
            goto L71
        L52:
            int r0 = r7.mMinFlingVelocity
            float r0 = (float) r0
            int r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r0 > 0) goto L6f
            int r0 = r7.mMaxFlingVelocity
            float r0 = (float) r0
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r0 > 0) goto L6f
            int r8 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r8 >= 0) goto L6f
            android.view.VelocityTracker r8 = r7.mVelocityTracker
            float r8 = r8.getXVelocity()
            int r8 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r8 <= 0) goto L4f
            goto L4d
        L6f:
            r8 = 0
            r0 = 0
        L71:
            if (r0 == 0) goto L8d
            android.view.View r0 = r7.mCurrentView
            int r3 = r7.mCurrentPosition
            r7.beforeViewFling(r0, r3)
            android.view.View r0 = r7.mCurrentView
            int r3 = r7.mCurrentPosition
            boolean r0 = r7.willLeaveDataSetOnFling(r0, r3)
            if (r0 == 0) goto L89
            int r0 = r7.mVirtualListCount
            int r0 = r0 - r2
            r7.mVirtualListCount = r0
        L89:
            r7.flingCurrentView(r8)
            goto L97
        L8d:
            android.view.View r8 = r7.mCurrentView
            int r0 = r7.mCurrentPosition
            r7.onCancelSwipe(r8, r0)
            r7.restoreCurrentViewTranslation()
        L97:
            r7.reset()
        L9a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeTouchListener.handleUpEvent(android.view.MotionEvent):boolean");
    }

    private boolean isDismissable(int i) {
        if (this.mListViewWrapper.getAdapter() == null) {
            return false;
        }
        if (this.mDismissableManager != null) {
            return this.mDismissableManager.isDismissable(this.mListViewWrapper.getAdapter().getItemId(i), i);
        }
        return true;
    }

    private void reset() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.mVelocityTracker = null;
        this.mDownX = 0.0f;
        this.mDownY = 0.0f;
        this.mCurrentView = null;
        this.mSwipingView = null;
        this.mCurrentPosition = -1;
        this.mSwiping = false;
        this.mCanDismissCurrent = false;
    }

    private void restoreCurrentViewTranslation() {
        if (this.mCurrentView == null) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mSwipingView, TRANSLATION_X, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mSwipingView, ALPHA, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(this.mAnimationTime);
        animatorSet.addListener(new RestoreAnimatorListener(this.mCurrentView, this.mCurrentPosition));
        animatorSet.start();
    }

    public void afterCancelSwipe(View view, int i) {
    }

    public abstract void afterViewFling(View view, int i);

    public void beforeViewFling(View view, int i) {
    }

    public void disableSwipe() {
        this.mSwipeEnabled = false;
    }

    public void enableSwipe() {
        this.mSwipeEnabled = true;
    }

    public void fling(int i) {
        int firstVisiblePosition = this.mListViewWrapper.getFirstVisiblePosition();
        int lastVisiblePosition = this.mListViewWrapper.getLastVisiblePosition();
        if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
            View viewForPosition = AdapterViewUtil.getViewForPosition(this.mListViewWrapper, i);
            if (viewForPosition != null) {
                flingView(viewForPosition, i, true);
                this.mActiveSwipeCount++;
                this.mVirtualListCount--;
                return;
            }
            throw new IllegalStateException(outline.m273H("No view found for position ", i));
        }
        throw new IllegalArgumentException("View for position " + i + " not visible!");
    }

    public int getActiveSwipeCount() {
        return this.mActiveSwipeCount;
    }

    public ListViewWrapper getListViewWrapper() {
        return this.mListViewWrapper;
    }

    public View getSwipeView(View view) {
        return view;
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.TouchEventHandler
    public boolean isInteracting() {
        return this.mSwiping;
    }

    public boolean isSwiping() {
        return this.mSwiping;
    }

    public void notifyDataSetChanged() {
        if (this.mListViewWrapper.getAdapter() != null) {
            this.mVirtualListCount = this.mListViewWrapper.getCount() - this.mListViewWrapper.getHeaderViewsCount();
        }
    }

    public void onCancelSwipe(View view, int i) {
    }

    public void onStartSwipe(View view, int i) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mListViewWrapper.getAdapter() == null) {
            return false;
        }
        if (this.mVirtualListCount == -1 || this.mActiveSwipeCount == 0) {
            this.mVirtualListCount = this.mListViewWrapper.getCount() - this.mListViewWrapper.getHeaderViewsCount();
        }
        if (this.mViewWidth < 2) {
            this.mViewWidth = this.mListViewWrapper.getListView().getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        return false;
                    }
                    return handleCancelEvent();
                }
                return handleMoveEvent(view, motionEvent);
            }
            return handleUpEvent(motionEvent);
        }
        return handleDownEvent(view, motionEvent);
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.TouchEventHandler
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouch(null, motionEvent);
    }

    public void restoreViewPresentation(View view) {
        View swipeView = getSwipeView(view);
        ViewHelper.setAlpha(swipeView, 1.0f);
        ViewHelper.setTranslationX(swipeView, 0.0f);
    }

    public void setDismissableManager(DismissableManager dismissableManager) {
        this.mDismissableManager = dismissableManager;
    }

    public void setMinimumAlpha(float f) {
        this.mMinimumAlpha = f;
    }

    public void setParentIsHorizontalScrollContainer() {
        this.mParentIsHorizontalScrollContainer = true;
        this.mTouchChildResId = 0;
    }

    public void setTouchChild(int i) {
        this.mTouchChildResId = i;
        this.mParentIsHorizontalScrollContainer = false;
    }

    public abstract boolean willLeaveDataSetOnFling(View view, int i);
}
