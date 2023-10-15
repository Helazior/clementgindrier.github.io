package com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.nhaarman.listviewanimations.ArrayAdapter;
import com.nhaarman.listviewanimations.util.AdapterViewUtil;
import com.nhaarman.listviewanimations.util.ListViewWrapper;
import com.nhaarman.listviewanimations.util.ListViewWrapperSetter;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.ValueAnimator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ExpandableListItemAdapter<T> extends ArrayAdapter<T> implements ListViewWrapperSetter {
    private static final int DEFAULTCONTENTPARENTRESID = 10001;
    private static final int DEFAULTTITLEPARENTRESID = 10000;
    private int mActionViewResId;
    private final int mContentParentResId;
    private final Context mContext;
    private ExpandCollapseListener mExpandCollapseListener;
    private final List<Long> mExpandedIds;
    private int mLimit;
    private ListViewWrapper mListViewWrapper;
    private final int mTitleParentResId;
    private int mViewLayoutResId;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ExpandCollapseHelper {
        private ExpandCollapseHelper() {
        }

        public static void animateCollapsing(final View view) {
            ValueAnimator createHeightAnimator = createHeightAnimator(view, view.getHeight(), 0);
            createHeightAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem.ExpandableListItemAdapter.ExpandCollapseHelper.1
                @Override // com.nineoldandroids.animation.AnimatorListenerAdapter, com.nineoldandroids.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    view.setVisibility(8);
                }
            });
            createHeightAnimator.start();
        }

        public static void animateExpanding(View view, ListViewWrapper listViewWrapper) {
            view.setVisibility(0);
            View view2 = (View) view.getParent();
            view.measure(View.MeasureSpec.makeMeasureSpec((view2.getMeasuredWidth() - view2.getPaddingLeft()) - view2.getPaddingRight(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
            ValueAnimator createHeightAnimator = createHeightAnimator(view, 0, view.getMeasuredHeight());
            createHeightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(view) { // from class: com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem.ExpandableListItemAdapter.ExpandCollapseHelper.2
                public final int listViewBottomPadding;
                public final int listViewHeight;

                /* renamed from: v */
                public final View f3922v;
                public final /* synthetic */ View val$view;

                {
                    this.val$view = view;
                    this.listViewHeight = ListViewWrapper.this.getListView().getHeight();
                    this.listViewBottomPadding = ListViewWrapper.this.getListView().getPaddingBottom();
                    this.f3922v = ExpandCollapseHelper.findDirectChild(view, ListViewWrapper.this.getListView());
                }

                @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int top;
                    int bottom = this.f3922v.getBottom();
                    if (bottom <= this.listViewHeight || (top = this.f3922v.getTop()) <= 0) {
                        return;
                    }
                    ListViewWrapper.this.smoothScrollBy(Math.min((bottom - this.listViewHeight) + this.listViewBottomPadding, top), 0);
                }
            });
            createHeightAnimator.start();
        }

        public static ValueAnimator createHeightAnimator(final View view, int i, int i2) {
            ValueAnimator ofInt = ValueAnimator.ofInt(i, i2);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.nhaarman.listviewanimations.itemmanipulation.expandablelistitem.ExpandableListItemAdapter.ExpandCollapseHelper.3
                @Override // com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    layoutParams.height = intValue;
                    view.setLayoutParams(layoutParams);
                }
            });
            return ofInt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static View findDirectChild(View view, ViewGroup viewGroup) {
            ViewParent parent = view.getParent();
            while (true) {
                View view2 = (View) parent;
                View view3 = view;
                view = view2;
                if (view.equals(viewGroup)) {
                    return view3;
                }
                parent = view.getParent();
            }
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface ExpandCollapseListener {
        void onItemCollapsed(int i);

        void onItemExpanded(int i);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class RootView extends LinearLayout {
        private ViewGroup mContentViewGroup;
        private ViewGroup mTitleViewGroup;

        private void init() {
            setOrientation(1);
            FrameLayout frameLayout = new FrameLayout(getContext());
            this.mTitleViewGroup = frameLayout;
            frameLayout.setId(ExpandableListItemAdapter.DEFAULTTITLEPARENTRESID);
            addView(this.mTitleViewGroup);
            FrameLayout frameLayout2 = new FrameLayout(getContext());
            this.mContentViewGroup = frameLayout2;
            frameLayout2.setId(ExpandableListItemAdapter.DEFAULTCONTENTPARENTRESID);
            addView(this.mContentViewGroup);
        }

        private RootView(Context context) {
            super(context);
            init();
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class TitleViewOnClickListener implements View.OnClickListener {
        private final View mContentParent;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ExpandableListItemAdapter.this.toggle(this.mContentParent);
        }

        private TitleViewOnClickListener(View view) {
            this.mContentParent = view;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ViewHolder {
        public ViewGroup contentParent;
        public View contentView;
        public ViewGroup titleParent;
        public View titleView;

        private ViewHolder() {
        }
    }

    public ExpandableListItemAdapter(Context context) {
        this(context, null);
    }

    private ViewGroup createView(ViewGroup viewGroup) {
        if (this.mViewLayoutResId == 0) {
            return new RootView(this.mContext);
        }
        return (ViewGroup) LayoutInflater.from(this.mContext).inflate(this.mViewLayoutResId, viewGroup, false);
    }

    private int findPositionForId(long j) {
        for (int i = 0; i < getCount(); i++) {
            if (getItemId(i) == j) {
                return i;
            }
        }
        return -1;
    }

    private View findViewForPosition(int i) {
        if (this.mListViewWrapper != null) {
            View view = null;
            for (int i2 = 0; i2 < this.mListViewWrapper.getChildCount() && view == null; i2++) {
                View childAt = this.mListViewWrapper.getChildAt(i2);
                if (childAt != null && AdapterViewUtil.getPositionForView(this.mListViewWrapper, childAt) == i) {
                    view = childAt;
                }
            }
            return view;
        }
        throw new IllegalStateException("Call setAbsListView on this ExpanableListItemAdapter!");
    }

    private View getContentParent(int i) {
        View findViewForPosition = findViewForPosition(i);
        if (findViewForPosition != null) {
            Object tag = findViewForPosition.getTag();
            if (tag instanceof ViewHolder) {
                return ((ViewHolder) tag).contentParent;
            }
        }
        return null;
    }

    public void collapse(int i) {
        if (this.mExpandedIds.contains(Long.valueOf(getItemId(i)))) {
            toggle(i);
        }
    }

    public void expand(int i) {
        if (this.mExpandedIds.contains(Long.valueOf(getItemId(i)))) {
            return;
        }
        toggle(i);
    }

    public View getContentView(int i) {
        View findViewForPosition = findViewForPosition(i);
        if (findViewForPosition != null) {
            Object tag = findViewForPosition.getTag();
            if (tag instanceof ViewHolder) {
                return ((ViewHolder) tag).contentView;
            }
        }
        return null;
    }

    public abstract View getContentView(int i, View view, ViewGroup viewGroup);

    public View getTitleView(int i) {
        View findViewForPosition = findViewForPosition(i);
        if (findViewForPosition != null) {
            Object tag = findViewForPosition.getTag();
            if (tag instanceof ViewHolder) {
                return ((ViewHolder) tag).titleView;
            }
        }
        return null;
    }

    public abstract View getTitleView(int i, View view, ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        ViewGroup viewGroup2 = (ViewGroup) view;
        if (viewGroup2 == null) {
            viewGroup2 = createView(viewGroup);
            viewHolder = new ViewHolder();
            viewHolder.titleParent = (ViewGroup) viewGroup2.findViewById(this.mTitleParentResId);
            viewHolder.contentParent = (ViewGroup) viewGroup2.findViewById(this.mContentParentResId);
            viewGroup2.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) viewGroup2.getTag();
        }
        View titleView = getTitleView(i, viewHolder.titleView, viewHolder.titleParent);
        if (!titleView.equals(viewHolder.titleView)) {
            viewHolder.titleParent.removeAllViews();
            viewHolder.titleParent.addView(titleView);
            int i2 = this.mActionViewResId;
            if (i2 == 0) {
                viewGroup2.setOnClickListener(new TitleViewOnClickListener(viewHolder.contentParent));
            } else {
                viewGroup2.findViewById(i2).setOnClickListener(new TitleViewOnClickListener(viewHolder.contentParent));
            }
        }
        viewHolder.titleView = titleView;
        View contentView = getContentView(i, viewHolder.contentView, viewHolder.contentParent);
        if (!contentView.equals(viewHolder.contentView)) {
            viewHolder.contentParent.removeAllViews();
            viewHolder.contentParent.addView(contentView);
        }
        viewHolder.contentView = contentView;
        viewHolder.contentParent.setVisibility(this.mExpandedIds.contains(Long.valueOf(getItemId(i))) ? 0 : 8);
        viewHolder.contentParent.setTag(Long.valueOf(getItemId(i)));
        ViewGroup.LayoutParams layoutParams = viewHolder.contentParent.getLayoutParams();
        layoutParams.height = -2;
        viewHolder.contentParent.setLayoutParams(layoutParams);
        return viewGroup2;
    }

    public boolean isExpanded(int i) {
        return this.mExpandedIds.contains(Long.valueOf(getItemId(i)));
    }

    @Override // com.nhaarman.listviewanimations.ArrayAdapter, android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        HashSet hashSet = new HashSet(this.mExpandedIds);
        for (int i = 0; i < getCount(); i++) {
            hashSet.remove(Long.valueOf(getItemId(i)));
        }
        this.mExpandedIds.removeAll(hashSet);
    }

    public void setActionViewResId(int i) {
        this.mActionViewResId = i;
    }

    public void setExpandCollapseListener(ExpandCollapseListener expandCollapseListener) {
        this.mExpandCollapseListener = expandCollapseListener;
    }

    public void setLimit(int i) {
        this.mLimit = i;
        this.mExpandedIds.clear();
        notifyDataSetChanged();
    }

    @Override // com.nhaarman.listviewanimations.util.ListViewWrapperSetter
    public void setListViewWrapper(ListViewWrapper listViewWrapper) {
        this.mListViewWrapper = listViewWrapper;
    }

    public void toggle(int i) {
        long itemId = getItemId(i);
        boolean contains = this.mExpandedIds.contains(Long.valueOf(itemId));
        View contentParent = getContentParent(i);
        if (contentParent != null) {
            toggle(contentParent);
        }
        if (contentParent == null && contains) {
            this.mExpandedIds.remove(Long.valueOf(itemId));
        } else if (contentParent == null) {
            this.mExpandedIds.add(Long.valueOf(itemId));
        }
    }

    public ExpandableListItemAdapter(Context context, List<T> list) {
        super(list);
        this.mContext = context;
        this.mTitleParentResId = DEFAULTTITLEPARENTRESID;
        this.mContentParentResId = DEFAULTCONTENTPARENTRESID;
        this.mExpandedIds = new ArrayList();
    }

    public ExpandableListItemAdapter(Context context, int i, int i2, int i3) {
        this(context, i, i2, i3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggle(View view) {
        if (this.mListViewWrapper != null) {
            boolean z = true;
            boolean z2 = view.getVisibility() == 0;
            if ((z2 || this.mLimit <= 0 || this.mExpandedIds.size() < this.mLimit) ? false : false) {
                Long l = this.mExpandedIds.get(0);
                int findPositionForId = findPositionForId(l.longValue());
                View contentParent = getContentParent(findPositionForId);
                if (contentParent != null) {
                    ExpandCollapseHelper.animateCollapsing(contentParent);
                }
                this.mExpandedIds.remove(l);
                ExpandCollapseListener expandCollapseListener = this.mExpandCollapseListener;
                if (expandCollapseListener != null) {
                    expandCollapseListener.onItemCollapsed(findPositionForId);
                }
            }
            Long l2 = (Long) view.getTag();
            int findPositionForId2 = findPositionForId(l2.longValue());
            if (z2) {
                ExpandCollapseHelper.animateCollapsing(view);
                this.mExpandedIds.remove(l2);
                ExpandCollapseListener expandCollapseListener2 = this.mExpandCollapseListener;
                if (expandCollapseListener2 != null) {
                    expandCollapseListener2.onItemCollapsed(findPositionForId2);
                    return;
                }
                return;
            }
            ExpandCollapseHelper.animateExpanding(view, this.mListViewWrapper);
            this.mExpandedIds.add(l2);
            ExpandCollapseListener expandCollapseListener3 = this.mExpandCollapseListener;
            if (expandCollapseListener3 != null) {
                expandCollapseListener3.onItemExpanded(findPositionForId2);
                return;
            }
            return;
        }
        throw new IllegalStateException("No ListView set!");
    }

    public ExpandableListItemAdapter(Context context, int i, int i2, int i3, List<T> list) {
        super(list);
        this.mContext = context;
        this.mViewLayoutResId = i;
        this.mTitleParentResId = i2;
        this.mContentParentResId = i3;
        this.mExpandedIds = new ArrayList();
    }
}
