package com.nhaarman.listviewanimations.itemmanipulation.dragdrop;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.TouchEventHandler;
import com.nhaarman.listviewanimations.util.Swappable;

@TargetApi(14)
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DragAndDropHandler implements TouchEventHandler {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INVALID_ID = -1;
    private ListAdapter mAdapter;
    private float mDownX;
    private float mDownY;
    private DraggableManager mDraggableManager;
    private HoverDrawable mHoverDrawable;
    private boolean mIsSettlingHoverDrawable;
    private float mLastMotionEventY;
    private long mMobileItemId;
    private View mMobileView;
    private OnItemMovedListener mOnItemMovedListener;
    private int mOriginalMobileItemPosition;
    private final ScrollHandler mScrollHandler;
    private final int mSlop;
    private final SwitchViewAnimator mSwitchViewAnimator;
    private final DragAndDropListViewWrapper mWrapper;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class DefaultDraggableManager implements DraggableManager {
        private DefaultDraggableManager() {
        }

        @Override // com.nhaarman.listviewanimations.itemmanipulation.dragdrop.DraggableManager
        public boolean isDraggable(View view, int i, float f, float f2) {
            return false;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class KitKatSwitchViewAnimator implements SwitchViewAnimator {
        public static final /* synthetic */ boolean $assertionsDisabled = false;

        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class AnimateSwitchViewOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
            private final View mPreviousMobileView;
            private final long mSwitchId;
            private final float mTranslationY;

            public AnimateSwitchViewOnPreDrawListener(View view, long j, float f) {
                this.mPreviousMobileView = view;
                this.mSwitchId = j;
                this.mTranslationY = f;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                DragAndDropHandler.this.mWrapper.getListView().getViewTreeObserver().removeOnPreDrawListener(this);
                View viewForId = DragAndDropHandler.this.getViewForId(this.mSwitchId);
                if (viewForId != null) {
                    viewForId.setTranslationY(this.mTranslationY);
                    viewForId.animate().translationY(0.0f).start();
                }
                this.mPreviousMobileView.setVisibility(0);
                if (DragAndDropHandler.this.mMobileView != null) {
                    DragAndDropHandler.this.mMobileView.setVisibility(4);
                    return true;
                }
                return true;
            }
        }

        private KitKatSwitchViewAnimator() {
        }

        @Override // com.nhaarman.listviewanimations.itemmanipulation.dragdrop.DragAndDropHandler.SwitchViewAnimator
        public void animateSwitchView(long j, float f) {
            DragAndDropHandler.this.mWrapper.getListView().getViewTreeObserver().addOnPreDrawListener(new AnimateSwitchViewOnPreDrawListener(DragAndDropHandler.this.mMobileView, j, f));
            DragAndDropHandler dragAndDropHandler = DragAndDropHandler.this;
            dragAndDropHandler.mMobileView = dragAndDropHandler.getViewForId(dragAndDropHandler.mMobileItemId);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class LSwitchViewAnimator implements SwitchViewAnimator {

        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class AnimateSwitchViewOnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
            public static final /* synthetic */ boolean $assertionsDisabled = false;
            private final long mSwitchId;
            private final float mTranslationY;

            public AnimateSwitchViewOnPreDrawListener(long j, float f) {
                this.mSwitchId = j;
                this.mTranslationY = f;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                DragAndDropHandler.this.mWrapper.getListView().getViewTreeObserver().removeOnPreDrawListener(this);
                View viewForId = DragAndDropHandler.this.getViewForId(this.mSwitchId);
                if (viewForId != null) {
                    viewForId.setTranslationY(this.mTranslationY);
                    viewForId.animate().translationY(0.0f).start();
                }
                DragAndDropHandler.this.mMobileView.setVisibility(0);
                DragAndDropHandler dragAndDropHandler = DragAndDropHandler.this;
                dragAndDropHandler.mMobileView = dragAndDropHandler.getViewForId(dragAndDropHandler.mMobileItemId);
                DragAndDropHandler.this.mMobileView.setVisibility(4);
                return true;
            }
        }

        private LSwitchViewAnimator() {
        }

        @Override // com.nhaarman.listviewanimations.itemmanipulation.dragdrop.DragAndDropHandler.SwitchViewAnimator
        public void animateSwitchView(long j, float f) {
            DragAndDropHandler.this.mWrapper.getListView().getViewTreeObserver().addOnPreDrawListener(new AnimateSwitchViewOnPreDrawListener(j, f));
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ScrollHandler implements AbsListView.OnScrollListener {
        public static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int SMOOTH_SCROLL_DP = 3;
        private int mCurrentFirstVisibleItem;
        private int mCurrentLastVisibleItem;
        private final int mSmoothScrollPx;
        private float mScrollSpeedFactor = 1.0f;
        private int mPreviousFirstVisibleItem = -1;
        private int mPreviousLastVisibleItem = -1;

        public ScrollHandler() {
            this.mSmoothScrollPx = (int) TypedValue.applyDimension(1, 3.0f, DragAndDropHandler.this.mWrapper.getListView().getResources().getDisplayMetrics());
        }

        private void checkAndHandleFirstVisibleCellChange() {
            if (DragAndDropHandler.this.mHoverDrawable == null || DragAndDropHandler.this.mAdapter == null || this.mCurrentFirstVisibleItem >= this.mPreviousFirstVisibleItem) {
                return;
            }
            DragAndDropHandler dragAndDropHandler = DragAndDropHandler.this;
            int positionForId = dragAndDropHandler.getPositionForId(dragAndDropHandler.mMobileItemId);
            if (positionForId == -1) {
                return;
            }
            int i = positionForId - 1;
            long itemId = i - DragAndDropHandler.this.mWrapper.getHeaderViewsCount() >= 0 ? DragAndDropHandler.this.mAdapter.getItemId(i - DragAndDropHandler.this.mWrapper.getHeaderViewsCount()) : -1L;
            View viewForId = DragAndDropHandler.this.getViewForId(itemId);
            if (viewForId != null) {
                DragAndDropHandler.this.switchViews(viewForId, itemId, -viewForId.getHeight());
            }
        }

        private void checkAndHandleLastVisibleCellChange() {
            if (DragAndDropHandler.this.mHoverDrawable == null || DragAndDropHandler.this.mAdapter == null || this.mCurrentLastVisibleItem <= this.mPreviousLastVisibleItem) {
                return;
            }
            DragAndDropHandler dragAndDropHandler = DragAndDropHandler.this;
            int positionForId = dragAndDropHandler.getPositionForId(dragAndDropHandler.mMobileItemId);
            if (positionForId == -1) {
                return;
            }
            int i = positionForId + 1;
            long itemId = i - DragAndDropHandler.this.mWrapper.getHeaderViewsCount() < DragAndDropHandler.this.mAdapter.getCount() ? DragAndDropHandler.this.mAdapter.getItemId(i - DragAndDropHandler.this.mWrapper.getHeaderViewsCount()) : -1L;
            View viewForId = DragAndDropHandler.this.getViewForId(itemId);
            if (viewForId != null) {
                DragAndDropHandler.this.switchViews(viewForId, itemId, viewForId.getHeight());
            }
        }

        public void handleMobileCellScroll() {
            if (DragAndDropHandler.this.mHoverDrawable == null || DragAndDropHandler.this.mIsSettlingHoverDrawable) {
                return;
            }
            Rect bounds = DragAndDropHandler.this.mHoverDrawable.getBounds();
            int computeVerticalScrollOffset = DragAndDropHandler.this.mWrapper.computeVerticalScrollOffset();
            int height = DragAndDropHandler.this.mWrapper.getListView().getHeight();
            int computeVerticalScrollExtent = DragAndDropHandler.this.mWrapper.computeVerticalScrollExtent();
            int computeVerticalScrollRange = DragAndDropHandler.this.mWrapper.computeVerticalScrollRange();
            int i = bounds.top;
            int height2 = bounds.height();
            int max = (int) Math.max(1.0f, this.mSmoothScrollPx * this.mScrollSpeedFactor);
            if (i <= 0 && computeVerticalScrollOffset > 0) {
                DragAndDropHandler.this.mWrapper.smoothScrollBy(-max, 0);
            } else if (i + height2 < height || computeVerticalScrollOffset + computeVerticalScrollExtent >= computeVerticalScrollRange) {
            } else {
                DragAndDropHandler.this.mWrapper.smoothScrollBy(max, 0);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            this.mCurrentFirstVisibleItem = i;
            int i4 = i2 + i;
            this.mCurrentLastVisibleItem = i4;
            int i5 = this.mPreviousFirstVisibleItem;
            if (i5 != -1) {
                i = i5;
            }
            this.mPreviousFirstVisibleItem = i;
            int i6 = this.mPreviousLastVisibleItem;
            if (i6 != -1) {
                i4 = i6;
            }
            this.mPreviousLastVisibleItem = i4;
            if (DragAndDropHandler.this.mHoverDrawable != null) {
                DragAndDropHandler.this.mHoverDrawable.onScroll(DragAndDropHandler.this.mMobileView.getY());
            }
            if (!DragAndDropHandler.this.mIsSettlingHoverDrawable) {
                checkAndHandleFirstVisibleCellChange();
                checkAndHandleLastVisibleCellChange();
            }
            this.mPreviousFirstVisibleItem = this.mCurrentFirstVisibleItem;
            this.mPreviousLastVisibleItem = this.mCurrentLastVisibleItem;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0 || DragAndDropHandler.this.mHoverDrawable == null) {
                return;
            }
            handleMobileCellScroll();
        }

        public void setScrollSpeed(float f) {
            this.mScrollSpeedFactor = f;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class SettleHoverDrawableAnimatorListener extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private final HoverDrawable mAnimatingHoverDrawable;
        private final View mAnimatingMobileView;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.mAnimatingMobileView.setVisibility(0);
            DragAndDropHandler.this.mHoverDrawable = null;
            DragAndDropHandler.this.mMobileView = null;
            DragAndDropHandler.this.mMobileItemId = -1L;
            DragAndDropHandler.this.mOriginalMobileItemPosition = -1;
            DragAndDropHandler.this.mIsSettlingHoverDrawable = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            DragAndDropHandler.this.mIsSettlingHoverDrawable = true;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.mAnimatingHoverDrawable.setTop(((Integer) valueAnimator.getAnimatedValue()).intValue());
            DragAndDropHandler.this.mWrapper.getListView().postInvalidate();
        }

        private SettleHoverDrawableAnimatorListener(HoverDrawable hoverDrawable, View view) {
            this.mAnimatingHoverDrawable = hoverDrawable;
            this.mAnimatingMobileView = view;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface SwitchViewAnimator {
        void animateSwitchView(long j, float f);
    }

    public DragAndDropHandler(DynamicListView dynamicListView) {
        this(new DynamicListViewWrapper(dynamicListView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPositionForId(long j) {
        View viewForId = getViewForId(j);
        if (viewForId == null) {
            return -1;
        }
        return this.mWrapper.getPositionForView(viewForId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View getViewForId(long j) {
        ListAdapter listAdapter = this.mAdapter;
        View view = null;
        if (j != -1 && listAdapter != null) {
            int firstVisiblePosition = this.mWrapper.getFirstVisiblePosition();
            for (int i = 0; i < this.mWrapper.getChildCount() && view == null; i++) {
                int i2 = firstVisiblePosition + i;
                if (i2 - this.mWrapper.getHeaderViewsCount() >= 0 && listAdapter.getItemId(i2 - this.mWrapper.getHeaderViewsCount()) == j) {
                    view = this.mWrapper.getChildAt(i);
                }
            }
        }
        return view;
    }

    private boolean handleCancelEvent() {
        return handleUpEvent();
    }

    private boolean handleDownEvent(MotionEvent motionEvent) {
        this.mDownX = motionEvent.getRawX();
        this.mDownY = motionEvent.getRawY();
        return true;
    }

    private boolean handleMoveEvent(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - this.mDownX;
        float rawY = motionEvent.getRawY() - this.mDownY;
        if (this.mHoverDrawable == null && Math.abs(rawY) > this.mSlop && Math.abs(rawY) > Math.abs(rawX)) {
            int pointToPosition = this.mWrapper.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1) {
                DragAndDropListViewWrapper dragAndDropListViewWrapper = this.mWrapper;
                View childAt = dragAndDropListViewWrapper.getChildAt(pointToPosition - dragAndDropListViewWrapper.getFirstVisiblePosition());
                if (this.mDraggableManager.isDraggable(childAt, pointToPosition - this.mWrapper.getHeaderViewsCount(), motionEvent.getX() - childAt.getX(), motionEvent.getY() - childAt.getY())) {
                    startDragging(pointToPosition - this.mWrapper.getHeaderViewsCount());
                    return true;
                }
            }
        } else {
            HoverDrawable hoverDrawable = this.mHoverDrawable;
            if (hoverDrawable != null) {
                hoverDrawable.handleMoveEvent(motionEvent);
                switchIfNecessary();
                this.mWrapper.getListView().invalidate();
                return true;
            }
        }
        return false;
    }

    private boolean handleUpEvent() {
        OnItemMovedListener onItemMovedListener;
        if (this.mMobileView == null) {
            return false;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(this.mHoverDrawable.getTop(), (int) this.mMobileView.getY());
        SettleHoverDrawableAnimatorListener settleHoverDrawableAnimatorListener = new SettleHoverDrawableAnimatorListener(this.mHoverDrawable, this.mMobileView);
        ofInt.addUpdateListener(settleHoverDrawableAnimatorListener);
        ofInt.addListener(settleHoverDrawableAnimatorListener);
        ofInt.start();
        int positionForId = getPositionForId(this.mMobileItemId) - this.mWrapper.getHeaderViewsCount();
        int i = this.mOriginalMobileItemPosition;
        if (i != positionForId && (onItemMovedListener = this.mOnItemMovedListener) != null) {
            onItemMovedListener.onItemMoved(i, positionForId);
        }
        return true;
    }

    private void setAdapterInternal(ListAdapter listAdapter) {
        if (listAdapter instanceof WrapperListAdapter) {
            listAdapter = ((WrapperListAdapter) listAdapter).getWrappedAdapter();
        }
        if (listAdapter.hasStableIds()) {
            if (listAdapter instanceof Swappable) {
                this.mAdapter = listAdapter;
                return;
            }
            throw new IllegalArgumentException("Adapter should implement Swappable!");
        }
        throw new IllegalStateException("Adapter doesn't have stable ids! Make sure your adapter has stable ids, and override hasStableIds() to return true.");
    }

    private void switchIfNecessary() {
        if (this.mHoverDrawable == null || this.mAdapter == null) {
            return;
        }
        int positionForId = getPositionForId(this.mMobileItemId);
        int i = positionForId - 1;
        long itemId = i - this.mWrapper.getHeaderViewsCount() >= 0 ? this.mAdapter.getItemId(i - this.mWrapper.getHeaderViewsCount()) : -1L;
        int i2 = positionForId + 1;
        long itemId2 = i2 - this.mWrapper.getHeaderViewsCount() < this.mAdapter.getCount() ? this.mAdapter.getItemId(i2 - this.mWrapper.getHeaderViewsCount()) : -1L;
        if (!this.mHoverDrawable.isMovingUpwards()) {
            itemId = itemId2;
        }
        View viewForId = getViewForId(itemId);
        int deltaY = this.mHoverDrawable.getDeltaY();
        if (viewForId != null && Math.abs(deltaY) > this.mHoverDrawable.getIntrinsicHeight()) {
            switchViews(viewForId, itemId, this.mHoverDrawable.getIntrinsicHeight() * (deltaY < 0 ? -1 : 1));
        }
        this.mScrollHandler.handleMobileCellScroll();
        this.mWrapper.getListView().invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchViews(View view, long j, float f) {
        ((Swappable) this.mAdapter).swapItems(this.mWrapper.getPositionForView(view) - this.mWrapper.getHeaderViewsCount(), this.mWrapper.getPositionForView(this.mMobileView) - this.mWrapper.getHeaderViewsCount());
        ((BaseAdapter) this.mAdapter).notifyDataSetChanged();
        this.mHoverDrawable.shift(view.getHeight());
        this.mSwitchViewAnimator.animateSwitchView(j, f);
    }

    public void dispatchDraw(Canvas canvas) {
        HoverDrawable hoverDrawable = this.mHoverDrawable;
        if (hoverDrawable != null) {
            hoverDrawable.draw(canvas);
        }
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.TouchEventHandler
    public boolean isInteracting() {
        return this.mMobileItemId != -1;
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.TouchEventHandler
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mIsSettlingHoverDrawable) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mLastMotionEventY = motionEvent.getY();
            return handleDownEvent(motionEvent);
        } else if (action == 1) {
            boolean handleUpEvent = handleUpEvent();
            this.mLastMotionEventY = -1.0f;
            return handleUpEvent;
        } else if (action == 2) {
            this.mLastMotionEventY = motionEvent.getY();
            return handleMoveEvent(motionEvent);
        } else if (action != 3) {
            return false;
        } else {
            boolean handleCancelEvent = handleCancelEvent();
            this.mLastMotionEventY = -1.0f;
            return handleCancelEvent;
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        setAdapterInternal(listAdapter);
    }

    public void setDraggableManager(DraggableManager draggableManager) {
        this.mDraggableManager = draggableManager;
    }

    public void setOnItemMovedListener(OnItemMovedListener onItemMovedListener) {
        this.mOnItemMovedListener = onItemMovedListener;
    }

    public void setScrollSpeed(float f) {
        this.mScrollHandler.setScrollSpeed(f);
    }

    public void startDragging(int i) {
        if (this.mMobileItemId != -1) {
            return;
        }
        if (this.mLastMotionEventY >= 0.0f) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null) {
                if (i < 0 || i >= listAdapter.getCount()) {
                    return;
                }
                DragAndDropListViewWrapper dragAndDropListViewWrapper = this.mWrapper;
                View childAt = dragAndDropListViewWrapper.getChildAt(this.mWrapper.getHeaderViewsCount() + (i - dragAndDropListViewWrapper.getFirstVisiblePosition()));
                this.mMobileView = childAt;
                if (childAt != null) {
                    this.mOriginalMobileItemPosition = i;
                    this.mMobileItemId = this.mAdapter.getItemId(i);
                    this.mHoverDrawable = new HoverDrawable(this.mMobileView, this.mLastMotionEventY);
                    this.mMobileView.setVisibility(4);
                    return;
                }
                return;
            }
            throw new IllegalStateException("This DynamicListView has no adapter set!");
        }
        throw new IllegalStateException("User must be touching the DynamicListView!");
    }

    public DragAndDropHandler(DragAndDropListViewWrapper dragAndDropListViewWrapper) {
        this.mLastMotionEventY = -1.0f;
        this.mOriginalMobileItemPosition = -1;
        this.mWrapper = dragAndDropListViewWrapper;
        if (dragAndDropListViewWrapper.getAdapter() != null) {
            setAdapterInternal(dragAndDropListViewWrapper.getAdapter());
        }
        ScrollHandler scrollHandler = new ScrollHandler();
        this.mScrollHandler = scrollHandler;
        dragAndDropListViewWrapper.setOnScrollListener(scrollHandler);
        this.mDraggableManager = new DefaultDraggableManager();
        this.mSwitchViewAnimator = new LSwitchViewAnimator();
        this.mMobileItemId = -1L;
        this.mSlop = ViewConfiguration.get(dragAndDropListViewWrapper.getListView().getContext()).getScaledTouchSlop();
    }
}
