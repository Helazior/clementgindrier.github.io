package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import p000.C1617d5;
import p000.RunnableC0515V6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* renamed from: a */
    public boolean f3175a;

    /* renamed from: b */
    public int f3176b;

    /* renamed from: c */
    public int[] f3177c;

    /* renamed from: d */
    public View[] f3178d;

    /* renamed from: e */
    public final SparseIntArray f3179e;

    /* renamed from: f */
    public final SparseIntArray f3180f;

    /* renamed from: g */
    public AbstractC0818b f3181g;

    /* renamed from: h */
    public final Rect f3182h;

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0817a extends AbstractC0818b {
    }

    /* renamed from: androidx.recyclerview.widget.GridLayoutManager$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0818b {

        /* renamed from: a */
        public final SparseIntArray f3185a = new SparseIntArray();

        /* renamed from: b */
        public final SparseIntArray f3186b = new SparseIntArray();

        /* renamed from: a */
        public int m1401a(int i, int i2) {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i3++;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = 1;
                }
            }
            return i3 + 1 > i2 ? i4 + 1 : i4;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3175a = false;
        this.f3176b = -1;
        this.f3179e = new SparseIntArray();
        this.f3180f = new SparseIntArray();
        this.f3181g = new C0817a();
        this.f3182h = new Rect();
        m1403i(RecyclerView.AbstractC0843o.getProperties(context, attributeSet, i, i2).f3240b);
    }

    /* renamed from: a */
    public final void m1411a(int i) {
        int i2;
        int[] iArr = this.f3177c;
        int i3 = this.f3176b;
        if (iArr == null || iArr.length != i3 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i3 + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.f3177c = iArr;
    }

    /* renamed from: b */
    public final void m1410b() {
        View[] viewArr = this.f3178d;
        if (viewArr == null || viewArr.length != this.f3176b) {
            this.f3178d = new View[this.f3176b];
        }
    }

    /* renamed from: c */
    public int m1409c(int i, int i2) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.f3177c;
            int i3 = this.f3176b;
            return iArr[i3 - i] - iArr[(i3 - i) - i2];
        }
        int[] iArr2 = this.f3177c;
        return iArr2[i2 + i] - iArr2[i];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.C0860y c0860y, LinearLayoutManager.C0822c c0822c, RecyclerView.AbstractC0843o.InterfaceC0846c interfaceC0846c) {
        int i = this.f3176b;
        for (int i2 = 0; i2 < this.f3176b && c0822c.m1394b(c0860y) && i > 0; i2++) {
            ((RunnableC0515V6.C0517b) interfaceC0846c).m1829a(c0822c.f3202d, Math.max(0, c0822c.f3205g));
            Objects.requireNonNull(this.f3181g);
            i--;
            c0822c.f3202d += c0822c.f3203e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeHorizontalScrollOffset(RecyclerView.C0860y c0860y) {
        return super.computeHorizontalScrollOffset(c0860y);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeHorizontalScrollRange(RecyclerView.C0860y c0860y) {
        return super.computeHorizontalScrollRange(c0860y);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeVerticalScrollOffset(RecyclerView.C0860y c0860y) {
        return super.computeVerticalScrollOffset(c0860y);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int computeVerticalScrollRange(RecyclerView.C0860y c0860y) {
        return super.computeVerticalScrollRange(c0860y);
    }

    /* renamed from: d */
    public final int m1408d(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, int i) {
        if (!c0860y.f3271g) {
            return this.f3181g.m1401a(i, this.f3176b);
        }
        int m1357c = c0854u.m1357c(i);
        if (m1357c == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.f3181g.m1401a(m1357c, this.f3176b);
    }

    /* renamed from: e */
    public final int m1407e(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, int i) {
        if (!c0860y.f3271g) {
            AbstractC0818b abstractC0818b = this.f3181g;
            int i2 = this.f3176b;
            Objects.requireNonNull(abstractC0818b);
            return i % i2;
        }
        int i3 = this.f3180f.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        int m1357c = c0854u.m1357c(i);
        if (m1357c == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        AbstractC0818b abstractC0818b2 = this.f3181g;
        int i4 = this.f3176b;
        Objects.requireNonNull(abstractC0818b2);
        return m1357c % i4;
    }

    /* renamed from: f */
    public final int m1406f(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, int i) {
        if (!c0860y.f3271g) {
            Objects.requireNonNull(this.f3181g);
            return 1;
        }
        int i2 = this.f3179e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (c0854u.m1357c(i) == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        Objects.requireNonNull(this.f3181g);
        return 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (position >= 0 && position < i3 && m1407e(c0854u, c0860y, position) == 0) {
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

    /* renamed from: g */
    public final void m1405g(View view, int i, boolean z) {
        int i2;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f3219b;
        int i4 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
        int i5 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
        int m1409c = m1409c(layoutParams.f3183e, layoutParams.f3184f);
        if (this.mOrientation == 1) {
            i3 = RecyclerView.AbstractC0843o.getChildMeasureSpec(m1409c, i, i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, false);
            i2 = RecyclerView.AbstractC0843o.getChildMeasureSpec(this.mOrientationHelper.mo1150l(), getHeightMode(), i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, true);
        } else {
            int childMeasureSpec = RecyclerView.AbstractC0843o.getChildMeasureSpec(m1409c, i, i4, ((ViewGroup.MarginLayoutParams) layoutParams).height, false);
            int childMeasureSpec2 = RecyclerView.AbstractC0843o.getChildMeasureSpec(this.mOrientationHelper.mo1150l(), getWidthMode(), i5, ((ViewGroup.MarginLayoutParams) layoutParams).width, true);
            i2 = childMeasureSpec;
            i3 = childMeasureSpec2;
        }
        m1404h(view, i3, i2, z);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int getColumnCountForAccessibility(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        if (this.mOrientation == 1) {
            return this.f3176b;
        }
        if (c0860y.m1341b() < 1) {
            return 0;
        }
        return m1408d(c0854u, c0860y, c0860y.m1341b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int getRowCountForAccessibility(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        if (this.mOrientation == 0) {
            return this.f3176b;
        }
        if (c0860y.m1341b() < 1) {
            return 0;
        }
        return m1408d(c0854u, c0860y, c0860y.m1341b() - 1) + 1;
    }

    /* renamed from: h */
    public final void m1404h(View view, int i, int i2, boolean z) {
        boolean shouldMeasureChild;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            shouldMeasureChild = shouldReMeasureChild(view, i, i2, layoutParams);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, i, i2, layoutParams);
        }
        if (shouldMeasureChild) {
            view.measure(i, i2);
        }
    }

    /* renamed from: i */
    public void m1403i(int i) {
        if (i == this.f3176b) {
            return;
        }
        this.f3175a = true;
        if (i >= 1) {
            this.f3176b = i;
            this.f3181g.f3185a.clear();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException(outline.m273H("Span count should be at least 1. Provided ", i));
    }

    /* renamed from: j */
    public final void m1402j() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        m1411a(height - paddingTop);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0096, code lost:
        r21.f3196b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0098, code lost:
        return;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void layoutChunk(androidx.recyclerview.widget.RecyclerView.C0854u r18, androidx.recyclerview.widget.RecyclerView.C0860y r19, androidx.recyclerview.widget.LinearLayoutManager.C0822c r20, androidx.recyclerview.widget.LinearLayoutManager.C0821b r21) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.layoutChunk(androidx.recyclerview.widget.RecyclerView$u, androidx.recyclerview.widget.RecyclerView$y, androidx.recyclerview.widget.LinearLayoutManager$c, androidx.recyclerview.widget.LinearLayoutManager$b):void");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, LinearLayoutManager.C0820a c0820a, int i) {
        super.onAnchorReady(c0854u, c0860y, c0820a, i);
        m1402j();
        if (c0860y.m1341b() > 0 && !c0860y.f3271g) {
            boolean z = i == 1;
            int m1407e = m1407e(c0854u, c0860y, c0820a.f3191b);
            if (z) {
                while (m1407e > 0) {
                    int i2 = c0820a.f3191b;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    c0820a.f3191b = i3;
                    m1407e = m1407e(c0854u, c0860y, i3);
                }
            } else {
                int m1341b = c0860y.m1341b() - 1;
                int i4 = c0820a.f3191b;
                while (i4 < m1341b) {
                    int i5 = i4 + 1;
                    int m1407e2 = m1407e(c0854u, c0860y, i5);
                    if (m1407e2 <= m1407e) {
                        break;
                    }
                    i4 = i5;
                    m1407e = m1407e2;
                }
                c0820a.f3191b = i4;
            }
        }
        m1410b();
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
        if (r13 == (r2 > r15)) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00f6, code lost:
        if (r13 == (r2 > r7)) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.C0854u r26, androidx.recyclerview.widget.RecyclerView.C0860y r27) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$u, androidx.recyclerview.widget.RecyclerView$y):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, View view, C1617d5 c1617d5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, c1617d5);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int m1408d = m1408d(c0854u, c0860y, layoutParams2.m1389a());
        if (this.mOrientation == 0) {
            c1617d5.m1018o(C1617d5.C1620c.m1012a(layoutParams2.f3183e, layoutParams2.f3184f, m1408d, 1, false, false));
        } else {
            c1617d5.m1018o(C1617d5.C1620c.m1012a(m1408d, 1, layoutParams2.f3183e, layoutParams2.f3184f, false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.f3181g.f3185a.clear();
        this.f3181g.f3186b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f3181g.f3185a.clear();
        this.f3181g.f3186b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f3181g.f3185a.clear();
        this.f3181g.f3186b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.f3181g.f3185a.clear();
        this.f3181g.f3186b.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f3181g.f3185a.clear();
        this.f3181g.f3186b.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onLayoutChildren(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        if (c0860y.f3271g) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int m1389a = layoutParams.m1389a();
                this.f3179e.put(m1389a, layoutParams.f3184f);
                this.f3180f.put(m1389a, layoutParams.f3183e);
            }
        }
        super.onLayoutChildren(c0854u, c0860y);
        this.f3179e.clear();
        this.f3180f.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onLayoutCompleted(RecyclerView.C0860y c0860y) {
        super.onLayoutCompleted(c0860y);
        this.f3175a = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int scrollHorizontallyBy(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        m1402j();
        m1410b();
        return super.scrollHorizontallyBy(i, c0854u, c0860y);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int scrollVerticallyBy(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        m1402j();
        m1410b();
        return super.scrollVerticallyBy(i, c0854u, c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        if (this.f3177c == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.AbstractC0843o.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.f3177c;
            chooseSize = RecyclerView.AbstractC0843o.chooseSize(i, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.AbstractC0843o.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.f3177c;
            chooseSize2 = RecyclerView.AbstractC0843o.chooseSize(i2, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.f3175a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e */
        public int f3183e;

        /* renamed from: f */
        public int f3184f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3183e = -1;
            this.f3184f = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3183e = -1;
            this.f3184f = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3183e = -1;
            this.f3184f = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3183e = -1;
            this.f3184f = 0;
        }
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.f3175a = false;
        this.f3176b = -1;
        this.f3179e = new SparseIntArray();
        this.f3180f = new SparseIntArray();
        this.f3181g = new C0817a();
        this.f3182h = new Rect();
        m1403i(i);
    }
}
