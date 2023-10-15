package com.nhaarman.listviewanimations.itemmanipulation.animateaddition;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.nhaarman.listviewanimations.BaseAdapterDecorator;
import com.nhaarman.listviewanimations.util.AbsListViewWrapper;
import com.nhaarman.listviewanimations.util.Insertable;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AnimateAdditionAdapter<T> extends BaseAdapterDecorator {
    private static final String ALPHA = "alpha";
    private static final long DEFAULT_INSERTION_ANIMATION_MS = 300;
    private static final long DEFAULT_SCROLLDOWN_ANIMATION_MS = 300;
    private final InsertQueue<T> mInsertQueue;
    private final Insertable<T> mInsertable;
    private long mInsertionAnimationDurationMs;
    private long mScrolldownAnimationDurationMs;
    private boolean mShouldAnimateDown;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ExpandAnimationListener extends AnimatorListenerAdapter {
        private final int mPosition;

        public ExpandAnimationListener(int i) {
            this.mPosition = i;
        }

        @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimateAdditionAdapter.this.mInsertQueue.removeActiveIndex(this.mPosition);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class HeightUpdater implements ValueAnimator.AnimatorUpdateListener {
        private final View mView;

        public HeightUpdater(View view) {
            this.mView = view;
        }

        @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewGroup.LayoutParams layoutParams = this.mView.getLayoutParams();
            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            this.mView.setLayoutParams(layoutParams);
        }
    }

    public AnimateAdditionAdapter(BaseAdapter baseAdapter) {
        super(baseAdapter);
        this.mScrolldownAnimationDurationMs = 300L;
        this.mInsertionAnimationDurationMs = 300L;
        this.mShouldAnimateDown = true;
        BaseAdapter rootAdapter = getRootAdapter();
        if (rootAdapter instanceof Insertable) {
            Insertable<T> insertable = (Insertable) rootAdapter;
            this.mInsertable = insertable;
            this.mInsertQueue = new InsertQueue<>(insertable);
            return;
        }
        throw new IllegalArgumentException("BaseAdapter should implement Insertable!");
    }

    private boolean childrenFillAbsListView() {
        if (getListViewWrapper() != null) {
            int i = 0;
            for (int i2 = 0; i2 < getListViewWrapper().getCount(); i2++) {
                View childAt = getListViewWrapper().getChildAt(i2);
                if (childAt != null) {
                    i += childAt.getHeight();
                }
            }
            return getListViewWrapper().getListView().getHeight() <= i;
        }
        throw new IllegalStateException("Call setListView on this AnimateAdditionAdapter first!");
    }

    public Animator[] getAdditionalAnimators(View view, ViewGroup viewGroup) {
        return new Animator[0];
    }

    @Override // com.nhaarman.listviewanimations.BaseAdapterDecorator, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.mInsertQueue.getActiveIndexes().contains(Integer.valueOf(i))) {
            view2.measure(View.MeasureSpec.makeMeasureSpec(-1, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(-2, 0));
            ValueAnimator ofInt = ValueAnimator.ofInt(1, view2.getMeasuredHeight());
            ofInt.addUpdateListener(new HeightUpdater(view2));
            Animator[] additionalAnimators = getAdditionalAnimators(view2, viewGroup);
            Animator[] animatorArr = new Animator[additionalAnimators.length + 1];
            animatorArr[0] = ofInt;
            System.arraycopy(additionalAnimators, 0, animatorArr, 1, additionalAnimators.length);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animatorArr);
            ViewHelper.setAlpha(view2, 0.0f);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, ALPHA, 0.0f, 1.0f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playSequentially(animatorSet, ofFloat);
            animatorSet2.setDuration(this.mInsertionAnimationDurationMs);
            animatorSet2.addListener(new ExpandAnimationListener(i));
            animatorSet2.start();
        }
        return view2;
    }

    public void insert(int i, T t) {
        insert(new Pair<>(Integer.valueOf(i), t));
    }

    @Override // com.nhaarman.listviewanimations.BaseAdapterDecorator
    @Deprecated
    public void setAbsListView(AbsListView absListView) {
        if (absListView instanceof ListView) {
            setListView((ListView) absListView);
            return;
        }
        throw new IllegalArgumentException("AnimateAdditionAdapter requires a ListView!");
    }

    public void setInsertionAnimationDuration(long j) {
        this.mInsertionAnimationDurationMs = j;
    }

    public void setListView(ListView listView) {
        setListViewWrapper(new AbsListViewWrapper(listView));
    }

    public void setScrolldownAnimationDuration(long j) {
        this.mScrolldownAnimationDurationMs = j;
    }

    public void setShouldAnimateDown(boolean z) {
        this.mShouldAnimateDown = z;
    }

    public void insert(int i, T... tArr) {
        Pair<Integer, T>[] pairArr = new Pair[tArr.length];
        for (int i2 = 0; i2 < tArr.length; i2++) {
            pairArr[i2] = new Pair<>(Integer.valueOf(i + i2), tArr[i2]);
        }
        insert(pairArr);
    }

    public void insert(Pair<Integer, T>... pairArr) {
        insert(Arrays.asList(pairArr));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void insert(Iterable<Pair<Integer, T>> iterable) {
        if (getListViewWrapper() != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i = 0;
            int i2 = 0;
            for (Pair<Integer, T> pair : iterable) {
                if (getListViewWrapper().getFirstVisiblePosition() > ((Integer) pair.first).intValue()) {
                    int intValue = ((Integer) pair.first).intValue();
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        if (intValue >= ((Integer) it.next()).intValue()) {
                            intValue++;
                        }
                    }
                    this.mInsertable.add(intValue, pair.second);
                    arrayList2.add(Integer.valueOf(intValue));
                    i2++;
                    if (this.mShouldAnimateDown) {
                        View view = getView(((Integer) pair.first).intValue(), null, getListViewWrapper().getListView());
                        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                        i -= view.getMeasuredHeight();
                    }
                } else if (getListViewWrapper().getLastVisiblePosition() < ((Integer) pair.first).intValue() && getListViewWrapper().getLastVisiblePosition() != -1 && childrenFillAbsListView()) {
                    int intValue2 = ((Integer) pair.first).intValue();
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        if (intValue2 >= ((Integer) it2.next()).intValue()) {
                            intValue2++;
                        }
                    }
                    Iterator it3 = arrayList3.iterator();
                    while (it3.hasNext()) {
                        if (intValue2 >= ((Integer) it3.next()).intValue()) {
                            intValue2++;
                        }
                    }
                    arrayList3.add(Integer.valueOf(intValue2));
                    this.mInsertable.add(intValue2, pair.second);
                } else {
                    int intValue3 = ((Integer) pair.first).intValue();
                    Iterator it4 = arrayList2.iterator();
                    while (it4.hasNext()) {
                        if (intValue3 >= ((Integer) it4.next()).intValue()) {
                            intValue3++;
                        }
                    }
                    arrayList.add(new Pair(Integer.valueOf(intValue3), pair.second));
                }
            }
            if (this.mShouldAnimateDown) {
                ((AbsListView) getListViewWrapper().getListView()).smoothScrollBy(i, (int) (this.mScrolldownAnimationDurationMs * i2));
            }
            this.mInsertQueue.insert(arrayList);
            int firstVisiblePosition = getListViewWrapper().getFirstVisiblePosition();
            View childAt = getListViewWrapper().getChildAt(0);
            ((ListView) getListViewWrapper().getListView()).setSelectionFromTop(firstVisiblePosition + i2, childAt != null ? childAt.getTop() : 0);
            return;
        }
        throw new IllegalStateException("Call setListView on this AnimateAdditionAdapter!");
    }
}
