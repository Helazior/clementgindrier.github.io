package com.nhaarman.listviewanimations.itemmanipulation;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.nhaarman.listviewanimations.itemmanipulation.animateaddition.AnimateAdditionAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.DragAndDropHandler;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.DraggableManager;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.DynamicListViewWrapper;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.OnItemMovedListener;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.DismissableManager;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissTouchListener;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeTouchListener;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SwipeUndoAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SwipeUndoTouchListener;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.UndoCallback;
import java.util.Collection;
import java.util.HashSet;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DynamicListView extends ListView {
    private AnimateAdditionAdapter<Object> mAnimateAdditionAdapter;
    private TouchEventHandler mCurrentHandlingTouchEventHandler;
    private DragAndDropHandler mDragAndDropHandler;
    private final MyOnScrollListener mMyOnScrollListener;
    private SwipeTouchListener mSwipeTouchListener;
    private SwipeUndoAdapter mSwipeUndoAdapter;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class MyOnScrollListener implements AbsListView.OnScrollListener {
        private final Collection<AbsListView.OnScrollListener> mOnScrollListeners;

        private MyOnScrollListener() {
            this.mOnScrollListeners = new HashSet();
        }

        public void addOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
            this.mOnScrollListeners.add(onScrollListener);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            for (AbsListView.OnScrollListener onScrollListener : this.mOnScrollListeners) {
                onScrollListener.onScroll(absListView, i, i2, i3);
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            for (AbsListView.OnScrollListener onScrollListener : this.mOnScrollListeners) {
                onScrollListener.onScrollStateChanged(absListView, i);
            }
            if (i == 1 && (DynamicListView.this.mSwipeTouchListener instanceof SwipeUndoTouchListener)) {
                ((SwipeUndoTouchListener) DynamicListView.this.mSwipeTouchListener).dimissPending();
            }
        }
    }

    public DynamicListView(Context context) {
        this(context, null);
    }

    private void sendCancelEvent(TouchEventHandler touchEventHandler, MotionEvent motionEvent) {
        if (touchEventHandler != null) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            touchEventHandler.onTouchEvent(obtain);
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.widget.AbsListView, android.view.View
    public int computeVerticalScrollOffset() {
        return super.computeVerticalScrollOffset();
    }

    @Override // android.widget.AbsListView, android.view.View
    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    public void disableDragAndDrop() {
        this.mDragAndDropHandler = null;
    }

    public void disableSwipeToDismiss() {
        this.mSwipeTouchListener = null;
    }

    public void dismiss(int i) {
        SwipeTouchListener swipeTouchListener = this.mSwipeTouchListener;
        if (swipeTouchListener != null) {
            if (swipeTouchListener instanceof SwipeDismissTouchListener) {
                ((SwipeDismissTouchListener) swipeTouchListener).dismiss(i);
                return;
            }
            throw new IllegalStateException("Enabled swipe functionality does not support dismiss");
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        DragAndDropHandler dragAndDropHandler = this.mDragAndDropHandler;
        if (dragAndDropHandler != null) {
            dragAndDropHandler.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        DragAndDropHandler dragAndDropHandler;
        boolean isInteracting;
        SwipeTouchListener swipeTouchListener;
        if (this.mCurrentHandlingTouchEventHandler == null) {
            SwipeTouchListener swipeTouchListener2 = this.mSwipeTouchListener;
            if (((swipeTouchListener2 instanceof SwipeUndoTouchListener) && ((SwipeUndoTouchListener) swipeTouchListener2).hasPendingItems()) || (dragAndDropHandler = this.mDragAndDropHandler) == null) {
                isInteracting = false;
            } else {
                dragAndDropHandler.onTouchEvent(motionEvent);
                isInteracting = this.mDragAndDropHandler.isInteracting();
                if (isInteracting) {
                    this.mCurrentHandlingTouchEventHandler = this.mDragAndDropHandler;
                    sendCancelEvent(this.mSwipeTouchListener, motionEvent);
                }
            }
            if (this.mCurrentHandlingTouchEventHandler == null && (swipeTouchListener = this.mSwipeTouchListener) != null) {
                swipeTouchListener.onTouchEvent(motionEvent);
                isInteracting = this.mSwipeTouchListener.isInteracting();
                if (isInteracting) {
                    this.mCurrentHandlingTouchEventHandler = this.mSwipeTouchListener;
                    sendCancelEvent(this.mDragAndDropHandler, motionEvent);
                }
            }
            if (isInteracting) {
                MotionEvent obtain = MotionEvent.obtain(motionEvent);
                obtain.setAction(3);
                super.onTouchEvent(obtain);
            }
            return isInteracting || super.dispatchTouchEvent(motionEvent);
        }
        return onTouchEvent(motionEvent);
    }

    public void enableDragAndDrop() {
        this.mDragAndDropHandler = new DragAndDropHandler(this);
    }

    public void enableSimpleSwipeUndo() {
        if (this.mSwipeUndoAdapter != null) {
            SwipeUndoTouchListener swipeUndoTouchListener = new SwipeUndoTouchListener(new DynamicListViewWrapper(this), this.mSwipeUndoAdapter.getUndoCallback());
            this.mSwipeTouchListener = swipeUndoTouchListener;
            this.mSwipeUndoAdapter.setSwipeUndoTouchListener(swipeUndoTouchListener);
            return;
        }
        throw new IllegalStateException("enableSimpleSwipeUndo requires a SwipeUndoAdapter to be set as an adapter");
    }

    public void enableSwipeToDismiss(OnDismissCallback onDismissCallback) {
        this.mSwipeTouchListener = new SwipeDismissTouchListener(new DynamicListViewWrapper(this), onDismissCallback);
    }

    public void enableSwipeUndo(UndoCallback undoCallback) {
        this.mSwipeTouchListener = new SwipeUndoTouchListener(new DynamicListViewWrapper(this), undoCallback);
    }

    @Override // android.widget.AbsListView
    public void fling(int i) {
        SwipeTouchListener swipeTouchListener = this.mSwipeTouchListener;
        if (swipeTouchListener != null) {
            swipeTouchListener.fling(i);
        }
    }

    public void insert(int i, Object obj) {
        AnimateAdditionAdapter<Object> animateAdditionAdapter = this.mAnimateAdditionAdapter;
        if (animateAdditionAdapter != null) {
            animateAdditionAdapter.insert(i, (int) obj);
            return;
        }
        throw new IllegalStateException("Adapter should implement Insertable!");
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        TouchEventHandler touchEventHandler = this.mCurrentHandlingTouchEventHandler;
        if (touchEventHandler != null) {
            touchEventHandler.onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() == 1 || motionEvent.getActionMasked() == 3) {
            this.mCurrentHandlingTouchEventHandler = null;
        }
        return this.mCurrentHandlingTouchEventHandler != null || super.onTouchEvent(motionEvent);
    }

    public void setDismissableManager(DismissableManager dismissableManager) {
        SwipeTouchListener swipeTouchListener = this.mSwipeTouchListener;
        if (swipeTouchListener != null) {
            swipeTouchListener.setDismissableManager(dismissableManager);
        }
    }

    public void setDraggableManager(DraggableManager draggableManager) {
        DragAndDropHandler dragAndDropHandler = this.mDragAndDropHandler;
        if (dragAndDropHandler != null) {
            dragAndDropHandler.setDraggableManager(draggableManager);
        }
    }

    public void setMinimumAlpha(float f) {
        SwipeTouchListener swipeTouchListener = this.mSwipeTouchListener;
        if (swipeTouchListener != null) {
            swipeTouchListener.setMinimumAlpha(f);
        }
    }

    public void setOnItemMovedListener(OnItemMovedListener onItemMovedListener) {
        DragAndDropHandler dragAndDropHandler = this.mDragAndDropHandler;
        if (dragAndDropHandler != null) {
            dragAndDropHandler.setOnItemMovedListener(onItemMovedListener);
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mMyOnScrollListener.addOnScrollListener(onScrollListener);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        if (onTouchListener instanceof SwipeTouchListener) {
            return;
        }
        super.setOnTouchListener(onTouchListener);
    }

    public void setScrollSpeed(float f) {
        DragAndDropHandler dragAndDropHandler = this.mDragAndDropHandler;
        if (dragAndDropHandler != null) {
            dragAndDropHandler.setScrollSpeed(f);
        }
    }

    public void setSwipeTouchChild(int i) {
        SwipeTouchListener swipeTouchListener = this.mSwipeTouchListener;
        if (swipeTouchListener != null) {
            swipeTouchListener.setTouchChild(i);
        }
    }

    public void startDragging(int i) {
        DragAndDropHandler dragAndDropHandler;
        SwipeTouchListener swipeTouchListener = this.mSwipeTouchListener;
        if (((swipeTouchListener instanceof SwipeUndoTouchListener) && ((SwipeUndoTouchListener) swipeTouchListener).hasPendingItems()) || (dragAndDropHandler = this.mDragAndDropHandler) == null) {
            return;
        }
        dragAndDropHandler.startDragging(i);
    }

    public void undo(View view) {
        SwipeTouchListener swipeTouchListener = this.mSwipeTouchListener;
        if (swipeTouchListener != null) {
            if (swipeTouchListener instanceof SwipeUndoTouchListener) {
                ((SwipeUndoTouchListener) swipeTouchListener).undo(view);
                return;
            }
            throw new IllegalStateException("Enabled swipe functionality does not support undo");
        }
    }

    public DynamicListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, Resources.getSystem().getIdentifier("listViewStyle", "attr", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.AdapterView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setAdapter(android.widget.ListAdapter r4) {
        /*
            r3 = this;
            r0 = 0
            r3.mSwipeUndoAdapter = r0
            boolean r0 = r4 instanceof android.widget.BaseAdapter
            if (r0 == 0) goto L30
            r0 = r4
            android.widget.BaseAdapter r0 = (android.widget.BaseAdapter) r0
            r1 = r0
        Lb:
            boolean r2 = r1 instanceof com.nhaarman.listviewanimations.BaseAdapterDecorator
            if (r2 == 0) goto L1f
            boolean r2 = r1 instanceof com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SwipeUndoAdapter
            if (r2 == 0) goto L18
            r2 = r1
            com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SwipeUndoAdapter r2 = (com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.SwipeUndoAdapter) r2
            r3.mSwipeUndoAdapter = r2
        L18:
            com.nhaarman.listviewanimations.BaseAdapterDecorator r1 = (com.nhaarman.listviewanimations.BaseAdapterDecorator) r1
            android.widget.BaseAdapter r1 = r1.getDecoratedBaseAdapter()
            goto Lb
        L1f:
            boolean r1 = r1 instanceof com.nhaarman.listviewanimations.util.Insertable
            if (r1 == 0) goto L30
            com.nhaarman.listviewanimations.itemmanipulation.animateaddition.AnimateAdditionAdapter r1 = new com.nhaarman.listviewanimations.itemmanipulation.animateaddition.AnimateAdditionAdapter
            r1.<init>(r0)
            r3.mAnimateAdditionAdapter = r1
            r1.setListView(r3)
            com.nhaarman.listviewanimations.itemmanipulation.animateaddition.AnimateAdditionAdapter<java.lang.Object> r0 = r3.mAnimateAdditionAdapter
            goto L31
        L30:
            r0 = r4
        L31:
            super.setAdapter(r0)
            com.nhaarman.listviewanimations.itemmanipulation.dragdrop.DragAndDropHandler r0 = r3.mDragAndDropHandler
            if (r0 == 0) goto L3b
            r0.setAdapter(r4)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nhaarman.listviewanimations.itemmanipulation.DynamicListView.setAdapter(android.widget.ListAdapter):void");
    }

    public DynamicListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MyOnScrollListener myOnScrollListener = new MyOnScrollListener();
        this.mMyOnScrollListener = myOnScrollListener;
        super.setOnScrollListener(myOnScrollListener);
    }

    public void insert(int i, Object... objArr) {
        AnimateAdditionAdapter<Object> animateAdditionAdapter = this.mAnimateAdditionAdapter;
        if (animateAdditionAdapter != null) {
            animateAdditionAdapter.insert(i, objArr);
            return;
        }
        throw new IllegalStateException("Adapter should implement Insertable!");
    }

    public <T> void insert(Pair<Integer, T>... pairArr) {
        AnimateAdditionAdapter<Object> animateAdditionAdapter = this.mAnimateAdditionAdapter;
        if (animateAdditionAdapter != null) {
            animateAdditionAdapter.insert(pairArr);
            return;
        }
        throw new IllegalStateException("Adapter should implement Insertable!");
    }

    public <T> void insert(Iterable<Pair<Integer, T>> iterable) {
        AnimateAdditionAdapter<Object> animateAdditionAdapter = this.mAnimateAdditionAdapter;
        if (animateAdditionAdapter != null) {
            animateAdditionAdapter.insert(iterable);
            return;
        }
        throw new IllegalStateException("Adapter should implement Insertable!");
    }
}
