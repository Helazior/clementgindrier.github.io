package p000;

import android.annotation.SuppressLint;
import android.os.Trace;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* renamed from: V6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class RunnableC0515V6 implements Runnable {

    /* renamed from: f */
    public static final ThreadLocal<RunnableC0515V6> f1826f = new ThreadLocal<>();

    /* renamed from: g */
    public static Comparator<C0518c> f1827g = new C0516a();

    /* renamed from: b */
    public long f1829b;

    /* renamed from: c */
    public long f1830c;

    /* renamed from: a */
    public ArrayList<RecyclerView> f1828a = new ArrayList<>();

    /* renamed from: d */
    public ArrayList<C0518c> f1831d = new ArrayList<>();

    /* renamed from: V6$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0516a implements Comparator<C0518c> {
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0020, code lost:
            if (r0 != false) goto L10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
            r1 = -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
            return r1;
         */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int compare(p000.RunnableC0515V6.C0518c r7, p000.RunnableC0515V6.C0518c r8) {
            /*
                r6 = this;
                V6$c r7 = (p000.RunnableC0515V6.C0518c) r7
                V6$c r8 = (p000.RunnableC0515V6.C0518c) r8
                androidx.recyclerview.widget.RecyclerView r0 = r7.f1839d
                r1 = 1
                r2 = 0
                if (r0 != 0) goto Lc
                r3 = 1
                goto Ld
            Lc:
                r3 = 0
            Ld:
                androidx.recyclerview.widget.RecyclerView r4 = r8.f1839d
                if (r4 != 0) goto L13
                r4 = 1
                goto L14
            L13:
                r4 = 0
            L14:
                r5 = -1
                if (r3 == r4) goto L1a
                if (r0 != 0) goto L22
                goto L23
            L1a:
                boolean r0 = r7.f1836a
                boolean r3 = r8.f1836a
                if (r0 == r3) goto L25
                if (r0 == 0) goto L23
            L22:
                r1 = -1
            L23:
                r2 = r1
                goto L36
            L25:
                int r0 = r8.f1837b
                int r1 = r7.f1837b
                int r0 = r0 - r1
                if (r0 == 0) goto L2e
                r2 = r0
                goto L36
            L2e:
                int r7 = r7.f1838c
                int r8 = r8.f1838c
                int r7 = r7 - r8
                if (r7 == 0) goto L36
                r2 = r7
            L36:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.RunnableC0515V6.C0516a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    @SuppressLint({"VisibleForTests"})
    /* renamed from: V6$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0517b implements RecyclerView.AbstractC0843o.InterfaceC0846c {

        /* renamed from: a */
        public int f1832a;

        /* renamed from: b */
        public int f1833b;

        /* renamed from: c */
        public int[] f1834c;

        /* renamed from: d */
        public int f1835d;

        /* renamed from: a */
        public void m1829a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 >= 0) {
                int i3 = this.f1835d * 2;
                int[] iArr = this.f1834c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.f1834c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[i3 * 2];
                    this.f1834c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.f1834c;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.f1835d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        /* renamed from: b */
        public void m1828b(RecyclerView recyclerView, boolean z) {
            this.f1835d = 0;
            int[] iArr = this.f1834c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.AbstractC0843o abstractC0843o = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || abstractC0843o == null || !abstractC0843o.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.m2366g()) {
                    abstractC0843o.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                abstractC0843o.collectAdjacentPrefetchPositions(this.f1832a, this.f1833b, recyclerView.mState, this);
            }
            int i = this.f1835d;
            if (i > abstractC0843o.mPrefetchMaxCountObserved) {
                abstractC0843o.mPrefetchMaxCountObserved = i;
                abstractC0843o.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.m1347m();
            }
        }

        /* renamed from: c */
        public boolean m1827c(int i) {
            if (this.f1834c != null) {
                int i2 = this.f1835d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f1834c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: V6$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0518c {

        /* renamed from: a */
        public boolean f1836a;

        /* renamed from: b */
        public int f1837b;

        /* renamed from: c */
        public int f1838c;

        /* renamed from: d */
        public RecyclerView f1839d;

        /* renamed from: e */
        public int f1840e;
    }

    /* renamed from: a */
    public void m1832a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f1829b == 0) {
            this.f1829b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        C0517b c0517b = recyclerView.mPrefetchRegistry;
        c0517b.f1832a = i;
        c0517b.f1833b = i2;
    }

    /* renamed from: b */
    public void m1831b(long j) {
        C0518c c0518c;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        C0518c c0518c2;
        int size = this.f1828a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView3 = this.f1828a.get(i2);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.mPrefetchRegistry.m1828b(recyclerView3, false);
                i += recyclerView3.mPrefetchRegistry.f1835d;
            }
        }
        this.f1831d.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView4 = this.f1828a.get(i4);
            if (recyclerView4.getWindowVisibility() == 0) {
                C0517b c0517b = recyclerView4.mPrefetchRegistry;
                int abs = Math.abs(c0517b.f1833b) + Math.abs(c0517b.f1832a);
                for (int i5 = 0; i5 < c0517b.f1835d * 2; i5 += 2) {
                    if (i3 >= this.f1831d.size()) {
                        c0518c2 = new C0518c();
                        this.f1831d.add(c0518c2);
                    } else {
                        c0518c2 = this.f1831d.get(i3);
                    }
                    int[] iArr = c0517b.f1834c;
                    int i6 = iArr[i5 + 1];
                    c0518c2.f1836a = i6 <= abs;
                    c0518c2.f1837b = abs;
                    c0518c2.f1838c = i6;
                    c0518c2.f1839d = recyclerView4;
                    c0518c2.f1840e = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.f1831d, f1827g);
        for (int i7 = 0; i7 < this.f1831d.size() && (recyclerView = (c0518c = this.f1831d.get(i7)).f1839d) != null; i7++) {
            RecyclerView.AbstractC0824B m1830c = m1830c(recyclerView, c0518c.f1840e, c0518c.f1836a ? RecyclerView.FOREVER_NS : j);
            if (m1830c != null && m1830c.mNestedRecyclerView != null && m1830c.isBound() && !m1830c.isInvalid() && (recyclerView2 = m1830c.mNestedRecyclerView.get()) != null) {
                if (recyclerView2.mDataSetHasChangedAfterLayout && recyclerView2.mChildHelper.m2248h() != 0) {
                    recyclerView2.removeAndRecycleViews();
                }
                C0517b c0517b2 = recyclerView2.mPrefetchRegistry;
                c0517b2.m1828b(recyclerView2, true);
                if (c0517b2.f1835d != 0) {
                    try {
                        int i8 = C1616d4.f3984a;
                        Trace.beginSection(RecyclerView.TRACE_NESTED_PREFETCH_TAG);
                        RecyclerView.C0860y c0860y = recyclerView2.mState;
                        RecyclerView.AbstractC0832g abstractC0832g = recyclerView2.mAdapter;
                        c0860y.f3268d = 1;
                        c0860y.f3269e = abstractC0832g.getItemCount();
                        c0860y.f3271g = false;
                        c0860y.f3272h = false;
                        c0860y.f3273i = false;
                        for (int i9 = 0; i9 < c0517b2.f1835d * 2; i9 += 2) {
                            m1830c(recyclerView2, c0517b2.f1834c[i9], j);
                        }
                        Trace.endSection();
                    } catch (Throwable th) {
                        int i10 = C1616d4.f3984a;
                        Trace.endSection();
                        throw th;
                    }
                } else {
                    continue;
                }
            }
            c0518c.f1836a = false;
            c0518c.f1837b = 0;
            c0518c.f1838c = 0;
            c0518c.f1839d = null;
            c0518c.f1840e = 0;
        }
    }

    /* renamed from: c */
    public final RecyclerView.AbstractC0824B m1830c(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int m2248h = recyclerView.mChildHelper.m2248h();
        int i2 = 0;
        while (true) {
            if (i2 >= m2248h) {
                z = false;
                break;
            }
            RecyclerView.AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.m2249g(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        RecyclerView.C0854u c0854u = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.AbstractC0824B m1349k = c0854u.m1349k(i, false, j);
            if (m1349k != null) {
                if (m1349k.isBound() && !m1349k.isInvalid()) {
                    c0854u.m1352h(m1349k.itemView);
                } else {
                    c0854u.m1359a(m1349k, false);
                }
            }
            return m1349k;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int i = C1616d4.f3984a;
            Trace.beginSection(RecyclerView.TRACE_PREFETCH_TAG);
            if (this.f1828a.isEmpty()) {
                this.f1829b = 0L;
                Trace.endSection();
                return;
            }
            int size = this.f1828a.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView recyclerView = this.f1828a.get(i2);
                if (recyclerView.getWindowVisibility() == 0) {
                    j = Math.max(recyclerView.getDrawingTime(), j);
                }
            }
            if (j == 0) {
                this.f1829b = 0L;
                Trace.endSection();
                return;
            }
            m1831b(TimeUnit.MILLISECONDS.toNanos(j) + this.f1830c);
            this.f1829b = 0L;
            Trace.endSection();
        } catch (Throwable th) {
            this.f1829b = 0L;
            int i3 = C1616d4.f3984a;
            Trace.endSection();
            throw th;
        }
    }
}
