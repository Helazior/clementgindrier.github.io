package com.devsmart.android.p003ui;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.devsmart.android.ui.HorizontalListView */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HorizontalListView extends AdapterView<ListAdapter> {
    public ListAdapter mAdapter;
    public boolean mAlwaysOverrideTouch;
    public int mCurrentX;
    private boolean mDataChanged;
    private DataSetObserver mDataObserver;
    private int mDisplayOffset;
    private GestureDetector mGesture;
    private int mLeftViewIndex;
    private int mMaxX;
    public int mNextX;
    private GestureDetector.OnGestureListener mOnGesture;
    private AdapterView.OnItemClickListener mOnItemClicked;
    private AdapterView.OnItemLongClickListener mOnItemLongClicked;
    private AdapterView.OnItemSelectedListener mOnItemSelected;
    private Queue<View> mRemovedViewQueue;
    private int mRightViewIndex;
    public Scroller mScroller;

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAlwaysOverrideTouch = true;
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mDisplayOffset = 0;
        this.mRemovedViewQueue = new LinkedList();
        this.mDataChanged = false;
        this.mDataObserver = new DataSetObserver() { // from class: com.devsmart.android.ui.HorizontalListView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                synchronized (HorizontalListView.this) {
                    HorizontalListView.this.mDataChanged = true;
                }
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                HorizontalListView.this.reset();
                HorizontalListView.this.invalidate();
                HorizontalListView.this.requestLayout();
            }
        };
        this.mOnGesture = new GestureDetector.SimpleOnGestureListener() { // from class: com.devsmart.android.ui.HorizontalListView.3
            private boolean isEventWithinView(MotionEvent motionEvent, View view) {
                Rect rect = new Rect();
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                rect.set(i, i2, view.getWidth() + i, view.getHeight() + i2);
                return rect.contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return HorizontalListView.this.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return HorizontalListView.this.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                int childCount = HorizontalListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = HorizontalListView.this.getChildAt(i);
                    if (isEventWithinView(motionEvent, childAt)) {
                        if (HorizontalListView.this.mOnItemLongClicked != null) {
                            AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListView.this.mOnItemLongClicked;
                            HorizontalListView horizontalListView = HorizontalListView.this;
                            int i2 = horizontalListView.mLeftViewIndex + 1 + i;
                            HorizontalListView horizontalListView2 = HorizontalListView.this;
                            onItemLongClickListener.onItemLongClick(horizontalListView, childAt, i2, horizontalListView2.mAdapter.getItemId(horizontalListView2.mLeftViewIndex + 1 + i));
                            return;
                        }
                        return;
                    }
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                HorizontalListView horizontalListView;
                synchronized (HorizontalListView.this) {
                    horizontalListView = HorizontalListView.this;
                    horizontalListView.mNextX += (int) f;
                }
                horizontalListView.requestLayout();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i = 0;
                while (true) {
                    if (i >= HorizontalListView.this.getChildCount()) {
                        break;
                    }
                    View childAt = HorizontalListView.this.getChildAt(i);
                    if (isEventWithinView(motionEvent, childAt)) {
                        if (HorizontalListView.this.mOnItemClicked != null) {
                            AdapterView.OnItemClickListener onItemClickListener = HorizontalListView.this.mOnItemClicked;
                            HorizontalListView horizontalListView = HorizontalListView.this;
                            int i2 = horizontalListView.mLeftViewIndex + 1 + i;
                            HorizontalListView horizontalListView2 = HorizontalListView.this;
                            onItemClickListener.onItemClick(horizontalListView, childAt, i2, horizontalListView2.mAdapter.getItemId(horizontalListView2.mLeftViewIndex + 1 + i));
                        }
                        if (HorizontalListView.this.mOnItemSelected != null) {
                            AdapterView.OnItemSelectedListener onItemSelectedListener = HorizontalListView.this.mOnItemSelected;
                            HorizontalListView horizontalListView3 = HorizontalListView.this;
                            int i3 = horizontalListView3.mLeftViewIndex + 1 + i;
                            HorizontalListView horizontalListView4 = HorizontalListView.this;
                            onItemSelectedListener.onItemSelected(horizontalListView3, childAt, i3, horizontalListView4.mAdapter.getItemId(horizontalListView4.mLeftViewIndex + 1 + i));
                        }
                    } else {
                        i++;
                    }
                }
                return true;
            }
        };
        initView();
    }

    private void addAndMeasureChild(View view, int i) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
    }

    private void attemptClaimDrag() {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
    }

    private void fillList(int i) {
        View childAt = getChildAt(getChildCount() - 1);
        fillListRight(childAt != null ? childAt.getRight() : 0, i);
        View childAt2 = getChildAt(0);
        fillListLeft(childAt2 != null ? childAt2.getLeft() : 0, i);
    }

    private void fillListLeft(int i, int i2) {
        int i3;
        while (i + i2 > 0 && (i3 = this.mLeftViewIndex) >= 0) {
            View view = this.mAdapter.getView(i3, this.mRemovedViewQueue.poll(), this);
            addAndMeasureChild(view, 0);
            i -= view.getMeasuredWidth();
            this.mLeftViewIndex--;
            this.mDisplayOffset -= view.getMeasuredWidth();
        }
    }

    private void fillListRight(int i, int i2) {
        while (i + i2 < getWidth() && this.mRightViewIndex < this.mAdapter.getCount()) {
            View view = this.mAdapter.getView(this.mRightViewIndex, this.mRemovedViewQueue.poll(), this);
            addAndMeasureChild(view, -1);
            i += view.getMeasuredWidth();
            if (this.mRightViewIndex == this.mAdapter.getCount() - 1) {
                this.mMaxX = (this.mCurrentX + i) - getWidth();
            }
            if (this.mMaxX < 0) {
                this.mMaxX = 0;
            }
            this.mRightViewIndex++;
        }
    }

    private synchronized void initView() {
        this.mLeftViewIndex = -1;
        this.mRightViewIndex = 0;
        this.mDisplayOffset = 0;
        this.mCurrentX = 0;
        this.mNextX = 0;
        this.mMaxX = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        if (!isInEditMode()) {
            this.mGesture = new GestureDetector(getContext(), this.mOnGesture);
        }
    }

    private void positionItems(int i) {
        if (getChildCount() > 0) {
            int i2 = this.mDisplayOffset + i;
            this.mDisplayOffset = i2;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                int measuredWidth = childAt.getMeasuredWidth();
                childAt.layout(i2, 0, i2 + measuredWidth, childAt.getMeasuredHeight());
                i2 += childAt.getPaddingRight() + measuredWidth;
            }
        }
    }

    private void removeNonVisibleItems(int i) {
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i <= 0) {
            this.mDisplayOffset = childAt.getMeasuredWidth() + this.mDisplayOffset;
            this.mRemovedViewQueue.offer(childAt);
            removeViewInLayout(childAt);
            this.mLeftViewIndex++;
            childAt = getChildAt(0);
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i >= getWidth()) {
            this.mRemovedViewQueue.offer(childAt2);
            removeViewInLayout(childAt2);
            this.mRightViewIndex--;
            childAt2 = getChildAt(getChildCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void reset() {
        initView();
        removeAllViewsInLayout();
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.mGesture.onTouchEvent(motionEvent) | super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.AdapterView
    public View getSelectedView() {
        return null;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.mScroller.forceFinished(true);
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        synchronized (this) {
            this.mScroller.fling(this.mNextX, 0, (int) (-f), 0, 0, this.mMaxX, 0, 0);
        }
        requestLayout();
        return true;
    }

    @Override // android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public synchronized void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mAdapter == null) {
            return;
        }
        if (this.mDataChanged) {
            int i5 = this.mCurrentX;
            initView();
            removeAllViewsInLayout();
            this.mNextX = i5;
            this.mDataChanged = false;
        }
        if (this.mScroller.computeScrollOffset()) {
            this.mNextX = this.mScroller.getCurrX();
        }
        if (this.mNextX <= 0) {
            this.mNextX = 0;
            this.mScroller.forceFinished(true);
        }
        int i6 = this.mNextX;
        int i7 = this.mMaxX;
        if (i6 >= i7) {
            this.mNextX = i7;
            this.mScroller.forceFinished(true);
        }
        int i8 = this.mCurrentX - this.mNextX;
        removeNonVisibleItems(i8);
        fillList(i8);
        positionItems(i8);
        this.mCurrentX = this.mNextX;
        if (!this.mScroller.isFinished()) {
            post(new Runnable() { // from class: com.devsmart.android.ui.HorizontalListView.2
                @Override // java.lang.Runnable
                public void run() {
                    HorizontalListView.this.requestLayout();
                }
            });
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            attemptClaimDrag();
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    public synchronized void scrollTo(int i) {
        Scroller scroller = this.mScroller;
        int i2 = this.mNextX;
        scroller.startScroll(i2, 0, i - i2, 0);
        requestLayout();
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClicked = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClicked = onItemLongClickListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.mOnItemSelected = onItemSelectedListener;
    }

    @Override // android.widget.AdapterView
    public void setSelection(int i) {
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter listAdapter2 = this.mAdapter;
        if (listAdapter2 != null) {
            listAdapter2.unregisterDataSetObserver(this.mDataObserver);
        }
        this.mAdapter = listAdapter;
        listAdapter.registerDataSetObserver(this.mDataObserver);
        reset();
    }
}
