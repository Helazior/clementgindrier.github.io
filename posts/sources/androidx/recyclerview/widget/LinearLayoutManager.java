package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Objects;
import p000.LayoutInflater$Factory2C0000A;
import p000.RunnableC0515V6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LinearLayoutManager extends RecyclerView.AbstractC0843o implements RecyclerView.AbstractC0857x.InterfaceC0859b {
    public static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    public final C0820a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final C0821b mLayoutChunkResult;
    private C0822c mLayoutState;
    public int mOrientation;
    public AbstractC0971b7 mOrientationHelper;
    public SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    public boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0819a();

        /* renamed from: a */
        public int f3187a;

        /* renamed from: b */
        public int f3188b;

        /* renamed from: c */
        public boolean f3189c;

        /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0819a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        /* renamed from: a */
        public boolean m1400a() {
            return this.f3187a >= 0;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3187a);
            parcel.writeInt(this.f3188b);
            parcel.writeInt(this.f3189c ? 1 : 0);
        }

        public SavedState(Parcel parcel) {
            this.f3187a = parcel.readInt();
            this.f3188b = parcel.readInt();
            this.f3189c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f3187a = savedState.f3187a;
            this.f3188b = savedState.f3188b;
            this.f3189c = savedState.f3189c;
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0820a {

        /* renamed from: a */
        public AbstractC0971b7 f3190a;

        /* renamed from: b */
        public int f3191b;

        /* renamed from: c */
        public int f3192c;

        /* renamed from: d */
        public boolean f3193d;

        /* renamed from: e */
        public boolean f3194e;

        public C0820a() {
            m1396d();
        }

        /* renamed from: a */
        public void m1399a() {
            int mo1151k;
            if (this.f3193d) {
                mo1151k = this.f3190a.mo1155g();
            } else {
                mo1151k = this.f3190a.mo1151k();
            }
            this.f3192c = mo1151k;
        }

        /* renamed from: b */
        public void m1398b(View view, int i) {
            if (this.f3193d) {
                this.f3192c = this.f3190a.m1149m() + this.f3190a.mo1160b(view);
            } else {
                this.f3192c = this.f3190a.mo1157e(view);
            }
            this.f3191b = i;
        }

        /* renamed from: c */
        public void m1397c(View view, int i) {
            int m1149m = this.f3190a.m1149m();
            if (m1149m >= 0) {
                m1398b(view, i);
                return;
            }
            this.f3191b = i;
            if (this.f3193d) {
                int mo1155g = (this.f3190a.mo1155g() - m1149m) - this.f3190a.mo1160b(view);
                this.f3192c = this.f3190a.mo1155g() - mo1155g;
                if (mo1155g > 0) {
                    int mo1159c = this.f3192c - this.f3190a.mo1159c(view);
                    int mo1151k = this.f3190a.mo1151k();
                    int min = mo1159c - (Math.min(this.f3190a.mo1157e(view) - mo1151k, 0) + mo1151k);
                    if (min < 0) {
                        this.f3192c = Math.min(mo1155g, -min) + this.f3192c;
                        return;
                    }
                    return;
                }
                return;
            }
            int mo1157e = this.f3190a.mo1157e(view);
            int mo1151k2 = mo1157e - this.f3190a.mo1151k();
            this.f3192c = mo1157e;
            if (mo1151k2 > 0) {
                int mo1155g2 = (this.f3190a.mo1155g() - Math.min(0, (this.f3190a.mo1155g() - m1149m) - this.f3190a.mo1160b(view))) - (this.f3190a.mo1159c(view) + mo1157e);
                if (mo1155g2 < 0) {
                    this.f3192c -= Math.min(mo1151k2, -mo1155g2);
                }
            }
        }

        /* renamed from: d */
        public void m1396d() {
            this.f3191b = -1;
            this.f3192c = Integer.MIN_VALUE;
            this.f3193d = false;
            this.f3194e = false;
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("AnchorInfo{mPosition=");
            m253r.append(this.f3191b);
            m253r.append(", mCoordinate=");
            m253r.append(this.f3192c);
            m253r.append(", mLayoutFromEnd=");
            m253r.append(this.f3193d);
            m253r.append(", mValid=");
            m253r.append(this.f3194e);
            m253r.append('}');
            return m253r.toString();
        }
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0821b {

        /* renamed from: a */
        public int f3195a;

        /* renamed from: b */
        public boolean f3196b;

        /* renamed from: c */
        public boolean f3197c;

        /* renamed from: d */
        public boolean f3198d;
    }

    /* renamed from: androidx.recyclerview.widget.LinearLayoutManager$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0822c {

        /* renamed from: b */
        public int f3200b;

        /* renamed from: c */
        public int f3201c;

        /* renamed from: d */
        public int f3202d;

        /* renamed from: e */
        public int f3203e;

        /* renamed from: f */
        public int f3204f;

        /* renamed from: g */
        public int f3205g;

        /* renamed from: j */
        public int f3208j;

        /* renamed from: l */
        public boolean f3210l;

        /* renamed from: a */
        public boolean f3199a = true;

        /* renamed from: h */
        public int f3206h = 0;

        /* renamed from: i */
        public int f3207i = 0;

        /* renamed from: k */
        public List<RecyclerView.AbstractC0824B> f3209k = null;

        /* renamed from: a */
        public void m1395a(View view) {
            int m1389a;
            int size = this.f3209k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f3209k.get(i2).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.m1387c() && (m1389a = (layoutParams.m1389a() - this.f3202d) * this.f3203e) >= 0 && m1389a < i) {
                    view2 = view3;
                    if (m1389a == 0) {
                        break;
                    }
                    i = m1389a;
                }
            }
            if (view2 == null) {
                this.f3202d = -1;
            } else {
                this.f3202d = ((RecyclerView.LayoutParams) view2.getLayoutParams()).m1389a();
            }
        }

        /* renamed from: b */
        public boolean m1394b(RecyclerView.C0860y c0860y) {
            int i = this.f3202d;
            return i >= 0 && i < c0860y.m1341b();
        }

        /* renamed from: c */
        public View m1393c(RecyclerView.C0854u c0854u) {
            List<RecyclerView.AbstractC0824B> list = this.f3209k;
            if (list != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    View view = this.f3209k.get(i).itemView;
                    RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                    if (!layoutParams.m1387c() && this.f3202d == layoutParams.m1389a()) {
                        m1395a(view);
                        return view;
                    }
                }
                return null;
            }
            View view2 = c0854u.m1349k(this.f3202d, false, RecyclerView.FOREVER_NS).itemView;
            this.f3202d += this.f3203e;
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.C0860y c0860y) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return LayoutInflater$Factory2C0000A.C0010h.m2627m(c0860y, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.C0860y c0860y) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return LayoutInflater$Factory2C0000A.C0010h.m2625n(c0860y, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.C0860y c0860y) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return LayoutInflater$Factory2C0000A.C0010h.m2623o(c0860y, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        return findReferenceChild(c0854u, c0860y, 0, getChildCount(), c0860y.m1341b());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        return findReferenceChild(c0854u, c0860y, getChildCount() - 1, -1, c0860y.m1341b());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(c0854u, c0860y) : findLastReferenceChild(c0854u, c0860y);
    }

    private View findReferenceChildClosestToStart(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        return this.mShouldReverseLayout ? findLastReferenceChild(c0854u, c0860y) : findFirstReferenceChild(c0854u, c0860y);
    }

    private int fixLayoutEndGap(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, boolean z) {
        int mo1155g;
        int mo1155g2 = this.mOrientationHelper.mo1155g() - i;
        if (mo1155g2 > 0) {
            int i2 = -scrollBy(-mo1155g2, c0854u, c0860y);
            int i3 = i + i2;
            if (!z || (mo1155g = this.mOrientationHelper.mo1155g() - i3) <= 0) {
                return i2;
            }
            this.mOrientationHelper.mo1146p(mo1155g);
            return mo1155g + i2;
        }
        return 0;
    }

    private int fixLayoutStartGap(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, boolean z) {
        int mo1151k;
        int mo1151k2 = i - this.mOrientationHelper.mo1151k();
        if (mo1151k2 > 0) {
            int i2 = -scrollBy(mo1151k2, c0854u, c0860y);
            int i3 = i + i2;
            if (!z || (mo1151k = i3 - this.mOrientationHelper.mo1151k()) <= 0) {
                return i2;
            }
            this.mOrientationHelper.mo1146p(-mo1151k);
            return i2 - mo1151k;
        }
        return 0;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, int i, int i2) {
        if (!c0860y.f3275k || getChildCount() == 0 || c0860y.f3271g || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.AbstractC0824B> list = c0854u.f3252d;
        int size = list.size();
        int position = getPosition(getChildAt(0));
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView.AbstractC0824B abstractC0824B = list.get(i5);
            if (!abstractC0824B.isRemoved()) {
                if (((abstractC0824B.getLayoutPosition() < position) != this.mShouldReverseLayout ? (char) 65535 : (char) 1) == 65535) {
                    i3 += this.mOrientationHelper.mo1159c(abstractC0824B.itemView);
                } else {
                    i4 += this.mOrientationHelper.mo1159c(abstractC0824B.itemView);
                }
            }
        }
        this.mLayoutState.f3209k = list;
        if (i3 > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
            C0822c c0822c = this.mLayoutState;
            c0822c.f3206h = i3;
            c0822c.f3201c = 0;
            c0822c.m1395a(null);
            fill(c0854u, this.mLayoutState, c0860y, false);
        }
        if (i4 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            C0822c c0822c2 = this.mLayoutState;
            c0822c2.f3206h = i4;
            c0822c2.f3201c = 0;
            c0822c2.m1395a(null);
            fill(c0854u, this.mLayoutState, c0860y, false);
        }
        this.mLayoutState.f3209k = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            StringBuilder m253r = outline.m253r("item ");
            m253r.append(getPosition(childAt));
            m253r.append(", coord:");
            m253r.append(this.mOrientationHelper.mo1157e(childAt));
            Log.d(TAG, m253r.toString());
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.C0854u c0854u, C0822c c0822c) {
        if (!c0822c.f3199a || c0822c.f3210l) {
            return;
        }
        int i = c0822c.f3205g;
        int i2 = c0822c.f3207i;
        if (c0822c.f3204f == -1) {
            recycleViewsFromEnd(c0854u, i, i2);
        } else {
            recycleViewsFromStart(c0854u, i, i2);
        }
    }

    private void recycleChildren(RecyclerView.C0854u c0854u, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, c0854u);
                i--;
            }
            return;
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            removeAndRecycleViewAt(i3, c0854u);
        }
    }

    private void recycleViewsFromEnd(RecyclerView.C0854u c0854u, int i, int i2) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int mo1156f = (this.mOrientationHelper.mo1156f() - i) + i2;
        if (this.mShouldReverseLayout) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (this.mOrientationHelper.mo1157e(childAt) < mo1156f || this.mOrientationHelper.mo1147o(childAt) < mo1156f) {
                    recycleChildren(c0854u, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            if (this.mOrientationHelper.mo1157e(childAt2) < mo1156f || this.mOrientationHelper.mo1147o(childAt2) < mo1156f) {
                recycleChildren(c0854u, i4, i5);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.C0854u c0854u, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.mo1160b(childAt) > i3 || this.mOrientationHelper.mo1148n(childAt) > i3) {
                    recycleChildren(c0854u, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.mo1160b(childAt2) > i3 || this.mOrientationHelper.mo1148n(childAt2) > i3) {
                recycleChildren(c0854u, i5, i6);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1 && isLayoutRTL()) {
            this.mShouldReverseLayout = !this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, C0820a c0820a) {
        View findReferenceChildClosestToStart;
        int mo1151k;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null) {
            Objects.requireNonNull(c0820a);
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) focusedChild.getLayoutParams();
            if (!layoutParams.m1387c() && layoutParams.m1389a() >= 0 && layoutParams.m1389a() < c0860y.m1341b()) {
                c0820a.m1397c(focusedChild, getPosition(focusedChild));
                return true;
            }
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        if (c0820a.f3193d) {
            findReferenceChildClosestToStart = findReferenceChildClosestToEnd(c0854u, c0860y);
        } else {
            findReferenceChildClosestToStart = findReferenceChildClosestToStart(c0854u, c0860y);
        }
        if (findReferenceChildClosestToStart != null) {
            c0820a.m1398b(findReferenceChildClosestToStart, getPosition(findReferenceChildClosestToStart));
            if (!c0860y.f3271g && supportsPredictiveItemAnimations()) {
                if ((this.mOrientationHelper.mo1157e(findReferenceChildClosestToStart) >= this.mOrientationHelper.mo1155g() || this.mOrientationHelper.mo1160b(findReferenceChildClosestToStart) < this.mOrientationHelper.mo1151k()) ? true : true) {
                    if (c0820a.f3193d) {
                        mo1151k = this.mOrientationHelper.mo1155g();
                    } else {
                        mo1151k = this.mOrientationHelper.mo1151k();
                    }
                    c0820a.f3192c = mo1151k;
                }
            }
            return true;
        }
        return false;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.C0860y c0860y, C0820a c0820a) {
        int i;
        int mo1157e;
        if (!c0860y.f3271g && (i = this.mPendingScrollPosition) != -1) {
            if (i >= 0 && i < c0860y.m1341b()) {
                c0820a.f3191b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.m1400a()) {
                    boolean z = this.mPendingSavedState.f3189c;
                    c0820a.f3193d = z;
                    if (z) {
                        c0820a.f3192c = this.mOrientationHelper.mo1155g() - this.mPendingSavedState.f3188b;
                    } else {
                        c0820a.f3192c = this.mOrientationHelper.mo1151k() + this.mPendingSavedState.f3188b;
                    }
                    return true;
                } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mOrientationHelper.mo1159c(findViewByPosition) > this.mOrientationHelper.mo1150l()) {
                            c0820a.m1399a();
                            return true;
                        } else if (this.mOrientationHelper.mo1157e(findViewByPosition) - this.mOrientationHelper.mo1151k() < 0) {
                            c0820a.f3192c = this.mOrientationHelper.mo1151k();
                            c0820a.f3193d = false;
                            return true;
                        } else if (this.mOrientationHelper.mo1155g() - this.mOrientationHelper.mo1160b(findViewByPosition) < 0) {
                            c0820a.f3192c = this.mOrientationHelper.mo1155g();
                            c0820a.f3193d = true;
                            return true;
                        } else {
                            if (c0820a.f3193d) {
                                mo1157e = this.mOrientationHelper.m1149m() + this.mOrientationHelper.mo1160b(findViewByPosition);
                            } else {
                                mo1157e = this.mOrientationHelper.mo1157e(findViewByPosition);
                            }
                            c0820a.f3192c = mo1157e;
                        }
                    } else {
                        if (getChildCount() > 0) {
                            c0820a.f3193d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                        }
                        c0820a.m1399a();
                    }
                    return true;
                } else {
                    boolean z2 = this.mShouldReverseLayout;
                    c0820a.f3193d = z2;
                    if (z2) {
                        c0820a.f3192c = this.mOrientationHelper.mo1155g() - this.mPendingScrollPositionOffset;
                    } else {
                        c0820a.f3192c = this.mOrientationHelper.mo1151k() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, C0820a c0820a) {
        if (updateAnchorFromPendingData(c0860y, c0820a) || updateAnchorFromChildren(c0854u, c0860y, c0820a)) {
            return;
        }
        c0820a.m1399a();
        c0820a.f3191b = this.mStackFromEnd ? c0860y.m1341b() - 1 : 0;
    }

    private void updateLayoutState(int i, int i2, boolean z, RecyclerView.C0860y c0860y) {
        int mo1151k;
        this.mLayoutState.f3210l = resolveIsInfinite();
        this.mLayoutState.f3204f = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c0860y, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i == 1;
        C0822c c0822c = this.mLayoutState;
        int i3 = z2 ? max2 : max;
        c0822c.f3206h = i3;
        if (!z2) {
            max = max2;
        }
        c0822c.f3207i = max;
        if (z2) {
            c0822c.f3206h = this.mOrientationHelper.mo1154h() + i3;
            View childClosestToEnd = getChildClosestToEnd();
            C0822c c0822c2 = this.mLayoutState;
            c0822c2.f3203e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(childClosestToEnd);
            C0822c c0822c3 = this.mLayoutState;
            c0822c2.f3202d = position + c0822c3.f3203e;
            c0822c3.f3200b = this.mOrientationHelper.mo1160b(childClosestToEnd);
            mo1151k = this.mOrientationHelper.mo1160b(childClosestToEnd) - this.mOrientationHelper.mo1155g();
        } else {
            View childClosestToStart = getChildClosestToStart();
            C0822c c0822c4 = this.mLayoutState;
            c0822c4.f3206h = this.mOrientationHelper.mo1151k() + c0822c4.f3206h;
            C0822c c0822c5 = this.mLayoutState;
            c0822c5.f3203e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(childClosestToStart);
            C0822c c0822c6 = this.mLayoutState;
            c0822c5.f3202d = position2 + c0822c6.f3203e;
            c0822c6.f3200b = this.mOrientationHelper.mo1157e(childClosestToStart);
            mo1151k = (-this.mOrientationHelper.mo1157e(childClosestToStart)) + this.mOrientationHelper.mo1151k();
        }
        C0822c c0822c7 = this.mLayoutState;
        c0822c7.f3201c = i2;
        if (z) {
            c0822c7.f3201c = i2 - mo1151k;
        }
        c0822c7.f3205g = mo1151k;
    }

    private void updateLayoutStateToFillEnd(C0820a c0820a) {
        updateLayoutStateToFillEnd(c0820a.f3191b, c0820a.f3192c);
    }

    private void updateLayoutStateToFillStart(C0820a c0820a) {
        updateLayoutStateToFillStart(c0820a.f3191b, c0820a.f3192c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView.C0860y c0860y, int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(c0860y);
        if (this.mLayoutState.f3204f == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.C0860y c0860y, RecyclerView.AbstractC0843o.InterfaceC0846c interfaceC0846c) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, c0860y);
        collectPrefetchPositionsForLayoutState(c0860y, this.mLayoutState, interfaceC0846c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void collectInitialPrefetchPositions(int i, RecyclerView.AbstractC0843o.InterfaceC0846c interfaceC0846c) {
        boolean z;
        int i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.m1400a()) {
            SavedState savedState2 = this.mPendingSavedState;
            z = savedState2.f3189c;
            i2 = savedState2.f3187a;
        } else {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z ? i - 1 : 0;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            ((RunnableC0515V6.C0517b) interfaceC0846c).m1829a(i2, 0);
            i2 += i3;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.C0860y c0860y, C0822c c0822c, RecyclerView.AbstractC0843o.InterfaceC0846c interfaceC0846c) {
        int i = c0822c.f3202d;
        if (i < 0 || i >= c0860y.m1341b()) {
            return;
        }
        ((RunnableC0515V6.C0517b) interfaceC0846c).m1829a(i, Math.max(0, c0822c.f3205g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeHorizontalScrollExtent(RecyclerView.C0860y c0860y) {
        return computeScrollExtent(c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeHorizontalScrollOffset(RecyclerView.C0860y c0860y) {
        return computeScrollOffset(c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeHorizontalScrollRange(RecyclerView.C0860y c0860y) {
        return computeScrollRange(c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0857x.InterfaceC0859b
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        if (this.mOrientation == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeVerticalScrollExtent(RecyclerView.C0860y c0860y) {
        return computeScrollExtent(c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeVerticalScrollOffset(RecyclerView.C0860y c0860y) {
        return computeScrollOffset(c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeVerticalScrollRange(RecyclerView.C0860y c0860y) {
        return computeScrollRange(c0860y);
    }

    public int convertFocusDirectionToLayoutDirection(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    public C0822c createLayoutState() {
        return new C0822c();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView.C0854u c0854u, C0822c c0822c, RecyclerView.C0860y c0860y, boolean z) {
        int i = c0822c.f3201c;
        int i2 = c0822c.f3205g;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                c0822c.f3205g = i2 + i;
            }
            recycleByLayoutState(c0854u, c0822c);
        }
        int i3 = c0822c.f3201c + c0822c.f3206h;
        C0821b c0821b = this.mLayoutChunkResult;
        while (true) {
            if ((!c0822c.f3210l && i3 <= 0) || !c0822c.m1394b(c0860y)) {
                break;
            }
            c0821b.f3195a = 0;
            c0821b.f3196b = false;
            c0821b.f3197c = false;
            c0821b.f3198d = false;
            layoutChunk(c0854u, c0860y, c0822c, c0821b);
            if (!c0821b.f3196b) {
                int i4 = c0822c.f3200b;
                int i5 = c0821b.f3195a;
                c0822c.f3200b = (c0822c.f3204f * i5) + i4;
                if (!c0821b.f3197c || c0822c.f3209k != null || !c0860y.f3271g) {
                    c0822c.f3201c -= i5;
                    i3 -= i5;
                }
                int i6 = c0822c.f3205g;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + i5;
                    c0822c.f3205g = i7;
                    int i8 = c0822c.f3201c;
                    if (i8 < 0) {
                        c0822c.f3205g = i7 + i8;
                    }
                    recycleByLayoutState(c0854u, c0822c);
                }
                if (z && c0821b.f3198d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0822c.f3201c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        int i3;
        int i4;
        ensureLayoutState();
        if ((i2 > i ? (char) 1 : i2 < i ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.mo1157e(getChildAt(i)) < this.mOrientationHelper.mo1151k()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.m774a(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.m774a(i, i2, i3, i4);
    }

    public View findOneVisibleChild(int i, int i2, boolean z, boolean z2) {
        ensureLayoutState();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.m774a(i, i2, i3, i4);
        }
        return this.mVerticalBoundCheck.m774a(i, i2, i3, i4);
    }

    public View findReferenceChild(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, int i, int i2, int i3) {
        ensureLayoutState();
        int mo1151k = this.mOrientationHelper.mo1151k();
        int mo1155g = this.mOrientationHelper.mo1155g();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).m1387c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.mo1157e(childAt) < mo1155g && this.mOrientationHelper.mo1160b(childAt) >= mo1151k) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView.C0860y c0860y) {
        if (c0860y.f3265a != -1) {
            return this.mOrientationHelper.mo1150l();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, C0822c c0822c, C0821b c0821b) {
        int i;
        int i2;
        int i3;
        int i4;
        int mo1158d;
        View m1393c = c0822c.m1393c(c0854u);
        if (m1393c == null) {
            c0821b.f3196b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) m1393c.getLayoutParams();
        if (c0822c.f3209k == null) {
            if (this.mShouldReverseLayout == (c0822c.f3204f == -1)) {
                addView(m1393c);
            } else {
                addView(m1393c, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (c0822c.f3204f == -1)) {
                addDisappearingView(m1393c);
            } else {
                addDisappearingView(m1393c, 0);
            }
        }
        measureChildWithMargins(m1393c, 0, 0);
        c0821b.f3195a = this.mOrientationHelper.mo1159c(m1393c);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                mo1158d = getWidth() - getPaddingRight();
                i4 = mo1158d - this.mOrientationHelper.mo1158d(m1393c);
            } else {
                i4 = getPaddingLeft();
                mo1158d = this.mOrientationHelper.mo1158d(m1393c) + i4;
            }
            if (c0822c.f3204f == -1) {
                int i5 = c0822c.f3200b;
                i3 = i5;
                i2 = mo1158d;
                i = i5 - c0821b.f3195a;
            } else {
                int i6 = c0822c.f3200b;
                i = i6;
                i2 = mo1158d;
                i3 = c0821b.f3195a + i6;
            }
        } else {
            int paddingTop = getPaddingTop();
            int mo1158d2 = this.mOrientationHelper.mo1158d(m1393c) + paddingTop;
            if (c0822c.f3204f == -1) {
                int i7 = c0822c.f3200b;
                i2 = i7;
                i = paddingTop;
                i3 = mo1158d2;
                i4 = i7 - c0821b.f3195a;
            } else {
                int i8 = c0822c.f3200b;
                i = paddingTop;
                i2 = c0821b.f3195a + i8;
                i3 = mo1158d2;
                i4 = i8;
            }
        }
        layoutDecoratedWithMargins(m1393c, i4, i, i2, i3);
        if (layoutParams.m1387c() || layoutParams.m1388b()) {
            c0821b.f3197c = true;
        }
        c0821b.f3198d = m1393c.hasFocusable();
    }

    public void onAnchorReady(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, C0820a c0820a, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C0854u c0854u) {
        super.onDetachedFromWindow(recyclerView, c0854u);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(c0854u);
            c0854u.m1358b();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public View onFocusSearchFailed(View view, int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        int convertFocusDirectionToLayoutDirection;
        View findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.mo1150l() * MAX_SCROLL_FACTOR), false, c0860y);
        C0822c c0822c = this.mLayoutState;
        c0822c.f3205g = Integer.MIN_VALUE;
        c0822c.f3199a = false;
        fill(c0854u, c0822c, c0860y, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (childClosestToEnd.hasFocusable()) {
            if (findPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
                return null;
            }
            return childClosestToEnd;
        }
        return findPartiallyOrCompletelyInvisibleChildClosestToEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onLayoutChildren(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        int i;
        int i2;
        int i3;
        int i4;
        int fixLayoutEndGap;
        int i5;
        View findViewByPosition;
        int mo1157e;
        int i6;
        int i7 = -1;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && c0860y.m1341b() == 0) {
            removeAndRecycleAllViews(c0854u);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.m1400a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f3187a;
        }
        ensureLayoutState();
        this.mLayoutState.f3199a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        C0820a c0820a = this.mAnchorInfo;
        if (c0820a.f3194e && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) {
            if (focusedChild != null && (this.mOrientationHelper.mo1157e(focusedChild) >= this.mOrientationHelper.mo1155g() || this.mOrientationHelper.mo1160b(focusedChild) <= this.mOrientationHelper.mo1151k())) {
                this.mAnchorInfo.m1397c(focusedChild, getPosition(focusedChild));
            }
        } else {
            c0820a.m1396d();
            C0820a c0820a2 = this.mAnchorInfo;
            c0820a2.f3193d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(c0854u, c0860y, c0820a2);
            this.mAnchorInfo.f3194e = true;
        }
        C0822c c0822c = this.mLayoutState;
        c0822c.f3204f = c0822c.f3208j >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(c0860y, iArr);
        int mo1151k = this.mOrientationHelper.mo1151k() + Math.max(0, this.mReusableIntPair[0]);
        int mo1154h = this.mOrientationHelper.mo1154h() + Math.max(0, this.mReusableIntPair[1]);
        if (c0860y.f3271g && (i5 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i5)) != null) {
            if (this.mShouldReverseLayout) {
                i6 = this.mOrientationHelper.mo1155g() - this.mOrientationHelper.mo1160b(findViewByPosition);
                mo1157e = this.mPendingScrollPositionOffset;
            } else {
                mo1157e = this.mOrientationHelper.mo1157e(findViewByPosition) - this.mOrientationHelper.mo1151k();
                i6 = this.mPendingScrollPositionOffset;
            }
            int i8 = i6 - mo1157e;
            if (i8 > 0) {
                mo1151k += i8;
            } else {
                mo1154h -= i8;
            }
        }
        C0820a c0820a3 = this.mAnchorInfo;
        if (!c0820a3.f3193d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i7 = 1;
        }
        onAnchorReady(c0854u, c0860y, c0820a3, i7);
        detachAndScrapAttachedViews(c0854u);
        this.mLayoutState.f3210l = resolveIsInfinite();
        Objects.requireNonNull(this.mLayoutState);
        this.mLayoutState.f3207i = 0;
        C0820a c0820a4 = this.mAnchorInfo;
        if (c0820a4.f3193d) {
            updateLayoutStateToFillStart(c0820a4);
            C0822c c0822c2 = this.mLayoutState;
            c0822c2.f3206h = mo1151k;
            fill(c0854u, c0822c2, c0860y, false);
            C0822c c0822c3 = this.mLayoutState;
            i2 = c0822c3.f3200b;
            int i9 = c0822c3.f3202d;
            int i10 = c0822c3.f3201c;
            if (i10 > 0) {
                mo1154h += i10;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            C0822c c0822c4 = this.mLayoutState;
            c0822c4.f3206h = mo1154h;
            c0822c4.f3202d += c0822c4.f3203e;
            fill(c0854u, c0822c4, c0860y, false);
            C0822c c0822c5 = this.mLayoutState;
            i = c0822c5.f3200b;
            int i11 = c0822c5.f3201c;
            if (i11 > 0) {
                updateLayoutStateToFillStart(i9, i2);
                C0822c c0822c6 = this.mLayoutState;
                c0822c6.f3206h = i11;
                fill(c0854u, c0822c6, c0860y, false);
                i2 = this.mLayoutState.f3200b;
            }
        } else {
            updateLayoutStateToFillEnd(c0820a4);
            C0822c c0822c7 = this.mLayoutState;
            c0822c7.f3206h = mo1154h;
            fill(c0854u, c0822c7, c0860y, false);
            C0822c c0822c8 = this.mLayoutState;
            i = c0822c8.f3200b;
            int i12 = c0822c8.f3202d;
            int i13 = c0822c8.f3201c;
            if (i13 > 0) {
                mo1151k += i13;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            C0822c c0822c9 = this.mLayoutState;
            c0822c9.f3206h = mo1151k;
            c0822c9.f3202d += c0822c9.f3203e;
            fill(c0854u, c0822c9, c0860y, false);
            C0822c c0822c10 = this.mLayoutState;
            int i14 = c0822c10.f3200b;
            int i15 = c0822c10.f3201c;
            if (i15 > 0) {
                updateLayoutStateToFillEnd(i12, i);
                C0822c c0822c11 = this.mLayoutState;
                c0822c11.f3206h = i15;
                fill(c0854u, c0822c11, c0860y, false);
                i = this.mLayoutState.f3200b;
            }
            i2 = i14;
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i, c0854u, c0860y, true);
                i3 = i2 + fixLayoutEndGap2;
                i4 = i + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i3, c0854u, c0860y, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i2, c0854u, c0860y, true);
                i3 = i2 + fixLayoutStartGap;
                i4 = i + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i4, c0854u, c0860y, false);
            }
            i2 = i3 + fixLayoutEndGap;
            i = i4 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(c0854u, c0860y, i2, i);
        if (!c0860y.f3271g) {
            AbstractC0971b7 abstractC0971b7 = this.mOrientationHelper;
            abstractC0971b7.f3713b = abstractC0971b7.mo1150l();
        } else {
            this.mAnchorInfo.m1396d();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onLayoutCompleted(RecyclerView.C0860y c0860y) {
        super.onLayoutCompleted(c0860y);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.m1396d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState2.f3189c = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState2.f3188b = this.mOrientationHelper.mo1155g() - this.mOrientationHelper.mo1160b(childClosestToEnd);
                savedState2.f3187a = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState2.f3187a = getPosition(childClosestToStart);
                savedState2.f3188b = this.mOrientationHelper.mo1157e(childClosestToStart) - this.mOrientationHelper.mo1151k();
            }
        } else {
            savedState2.f3187a = -1;
        }
        return savedState2;
    }

    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo1155g() - (this.mOrientationHelper.mo1159c(view) + this.mOrientationHelper.mo1157e(view2)));
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.mo1155g() - this.mOrientationHelper.mo1160b(view2));
            }
        } else if (c == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo1157e(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.mo1160b(view2) - this.mOrientationHelper.mo1159c(view));
        }
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.mo1153i() == 0 && this.mOrientationHelper.mo1156f() == 0;
    }

    public int scrollBy(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.f3199a = true;
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        updateLayoutState(i2, abs, true, c0860y);
        C0822c c0822c = this.mLayoutState;
        int fill = fill(c0854u, c0822c, c0860y, false) + c0822c.f3205g;
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i = i2 * fill;
        }
        this.mOrientationHelper.mo1146p(-i);
        this.mLayoutState.f3208j = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int scrollHorizontallyBy(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, c0854u, c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.f3187a = -1;
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.f3187a = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int scrollVerticallyBy(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, c0854u, c0860y);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(outline.m273H("invalid orientation:", i));
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            AbstractC0971b7 m1161a = AbstractC0971b7.m1161a(this, i);
            this.mOrientationHelper = m1161a;
            this.mAnchorInfo.f3190a = m1161a;
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0860y c0860y, int i) {
        C0558X6 c0558x6 = new C0558X6(recyclerView.getContext());
        c0558x6.setTargetPosition(i);
        startSmoothScroll(c0558x6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        StringBuilder m253r = outline.m253r("validating child count ");
        m253r.append(getChildCount());
        Log.d(TAG, m253r.toString());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int mo1157e = this.mOrientationHelper.mo1157e(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int mo1157e2 = this.mOrientationHelper.mo1157e(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder m253r2 = outline.m253r("detected invalid position. loc invalid? ");
                    m253r2.append(mo1157e2 < mo1157e);
                    throw new RuntimeException(m253r2.toString());
                } else if (mo1157e2 > mo1157e) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int mo1157e3 = this.mOrientationHelper.mo1157e(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder m253r3 = outline.m253r("detected invalid position. loc invalid? ");
                m253r3.append(mo1157e3 < mo1157e);
                throw new RuntimeException(m253r3.toString());
            } else if (mo1157e3 < mo1157e) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0820a();
        this.mLayoutChunkResult = new C0821b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.f3201c = this.mOrientationHelper.mo1155g() - i2;
        C0822c c0822c = this.mLayoutState;
        c0822c.f3203e = this.mShouldReverseLayout ? -1 : 1;
        c0822c.f3202d = i;
        c0822c.f3204f = 1;
        c0822c.f3200b = i2;
        c0822c.f3205g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.f3201c = i2 - this.mOrientationHelper.mo1151k();
        C0822c c0822c = this.mLayoutState;
        c0822c.f3202d = i;
        c0822c.f3203e = this.mShouldReverseLayout ? 1 : -1;
        c0822c.f3204f = -1;
        c0822c.f3200b = i2;
        c0822c.f3205g = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new C0820a();
        this.mLayoutChunkResult = new C0821b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.AbstractC0843o.C0847d properties = RecyclerView.AbstractC0843o.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.f3239a);
        setReverseLayout(properties.f3241c);
        setStackFromEnd(properties.f3242d);
    }
}
