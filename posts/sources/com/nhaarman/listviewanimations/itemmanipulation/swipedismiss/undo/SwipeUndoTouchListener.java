package com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo;

import android.view.View;
import android.view.ViewGroup;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissTouchListener;
import com.nhaarman.listviewanimations.util.AdapterViewUtil;
import com.nhaarman.listviewanimations.util.ListViewWrapper;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SwipeUndoTouchListener extends SwipeDismissTouchListener {
    private static final String ALPHA = "alpha";
    private static final String TRANSLATION_X = "translationX";
    private final UndoCallback mCallback;
    private final List<Integer> mDismissedPositions;
    private final Collection<View> mDismissedViews;
    private final Collection<Integer> mUndoPositions;
    private final Map<Integer, View> mUndoViews;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class UndoAnimatorListener extends AnimatorListenerAdapter {
        private final View mUndoView;

        public UndoAnimatorListener(View view) {
            this.mUndoView = view;
        }

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.mUndoView.setVisibility(8);
            SwipeUndoTouchListener.this.finalizeDismiss();
        }
    }

    public SwipeUndoTouchListener(ListViewWrapper listViewWrapper, UndoCallback undoCallback) {
        super(listViewWrapper, undoCallback);
        this.mUndoPositions = new LinkedList();
        this.mUndoViews = new HashMap();
        this.mDismissedPositions = new LinkedList();
        this.mDismissedViews = new LinkedList();
        this.mCallback = undoCallback;
    }

    private void hideUndoView(View view) {
        this.mCallback.getPrimaryView(view).setVisibility(0);
        this.mCallback.getUndoView(view).setVisibility(8);
    }

    private void showUndoView(View view) {
        this.mCallback.getPrimaryView(view).setVisibility(8);
        View undoView = this.mCallback.getUndoView(view);
        undoView.setVisibility(0);
        ObjectAnimator.ofFloat(undoView, ALPHA, 0.0f, 1.0f).start();
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissTouchListener, com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeTouchListener
    public void afterCancelSwipe(View view, int i) {
        finalizeDismiss();
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissTouchListener, com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeTouchListener
    public void afterViewFling(View view, int i) {
        if (this.mUndoPositions.contains(Integer.valueOf(i))) {
            this.mUndoPositions.remove(Integer.valueOf(i));
            this.mUndoViews.remove(Integer.valueOf(i));
            performDismiss(view, i);
            hideUndoView(view);
            return;
        }
        this.mUndoPositions.add(Integer.valueOf(i));
        this.mUndoViews.put(Integer.valueOf(i), view);
        this.mCallback.onUndoShown(view, i);
        showUndoView(view);
        restoreViewPresentation(view);
    }

    public void dimissPending() {
        for (Integer num : this.mUndoPositions) {
            int intValue = num.intValue();
            performDismiss(this.mUndoViews.get(Integer.valueOf(intValue)), intValue);
        }
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissTouchListener
    public void directDismiss(int i) {
        this.mDismissedPositions.add(Integer.valueOf(i));
        finalizeDismiss();
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissTouchListener
    public void finalizeDismiss() {
        if (getActiveDismissCount() == 0 && getActiveSwipeCount() == 0) {
            restoreViewPresentations(this.mDismissedViews);
            notifyCallback(this.mDismissedPositions);
            Collection<Integer> processDeletions = Util.processDeletions(this.mUndoPositions, this.mDismissedPositions);
            this.mUndoPositions.clear();
            this.mUndoPositions.addAll(processDeletions);
            this.mDismissedViews.clear();
            this.mDismissedPositions.clear();
        }
    }

    public boolean hasPendingItems() {
        return !this.mUndoPositions.isEmpty();
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissTouchListener
    public void performDismiss(View view, int i) {
        super.performDismiss(view, i);
        this.mDismissedViews.add(view);
        this.mDismissedPositions.add(Integer.valueOf(i));
        this.mCallback.onDismiss(view, i);
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissTouchListener, com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeTouchListener
    public void restoreViewPresentation(View view) {
        super.restoreViewPresentation(view);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = 0;
        view.setLayoutParams(layoutParams);
    }

    public void undo(View view) {
        int positionForView = AdapterViewUtil.getPositionForView(getListViewWrapper(), view);
        this.mUndoPositions.remove(Integer.valueOf(positionForView));
        View primaryView = this.mCallback.getPrimaryView(view);
        View undoView = this.mCallback.getUndoView(view);
        primaryView.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(undoView, ALPHA, 1.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(primaryView, ALPHA, 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(primaryView, TRANSLATION_X, primaryView.getWidth(), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.addListener(new UndoAnimatorListener(undoView));
        animatorSet.start();
        this.mCallback.onUndo(view, positionForView);
    }

    @Override // com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeDismissTouchListener, com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.SwipeTouchListener
    public boolean willLeaveDataSetOnFling(View view, int i) {
        return this.mUndoPositions.contains(Integer.valueOf(i));
    }
}
