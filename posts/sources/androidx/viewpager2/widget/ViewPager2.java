package androidx.viewpager2.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import p000.C0492V4;
import p000.C1617d5;
import p000.C2256t8;
import p000.InterfaceC1677f5;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ViewPager2 extends ViewGroup {

    /* renamed from: a */
    public final Rect f3609a;

    /* renamed from: b */
    public final Rect f3610b;

    /* renamed from: c */
    public C2197q8 f3611c;

    /* renamed from: d */
    public int f3612d;

    /* renamed from: f */
    public boolean f3613f;

    /* renamed from: g */
    public RecyclerView.AbstractC0834i f3614g;

    /* renamed from: h */
    public LinearLayoutManager f3615h;

    /* renamed from: i */
    public int f3616i;

    /* renamed from: j */
    public Parcelable f3617j;

    /* renamed from: k */
    public RecyclerView f3618k;

    /* renamed from: l */
    public C1622d7 f3619l;

    /* renamed from: m */
    public C2256t8 f3620m;

    /* renamed from: n */
    public C2197q8 f3621n;

    /* renamed from: o */
    public C2214r8 f3622o;

    /* renamed from: p */
    public C2235s8 f3623p;

    /* renamed from: q */
    public RecyclerView.AbstractC0837l f3624q;

    /* renamed from: r */
    public boolean f3625r;

    /* renamed from: s */
    public boolean f3626s;

    /* renamed from: t */
    public int f3627t;

    /* renamed from: u */
    public AbstractC0939d f3628u;

    /* renamed from: androidx.viewpager2.widget.ViewPager2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0936a extends AbstractC0940e {
        public C0936a() {
            super(null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public void onChanged() {
            ViewPager2 viewPager2 = ViewPager2.this;
            viewPager2.f3613f = true;
            viewPager2.f3620m.f6571l = true;
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0937b extends AbstractC0942g {
        public C0937b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0942g
        public void onPageScrollStateChanged(int i) {
            if (i == 0) {
                ViewPager2.this.m1220h();
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0942g
        public void onPageSelected(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f3612d != i) {
                viewPager2.f3612d = i;
                ((C0943h) viewPager2.f3628u).m1217c();
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0938c extends AbstractC0942g {
        public C0938c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0942g
        public void onPageSelected(int i) {
            ViewPager2.this.clearFocus();
            if (ViewPager2.this.hasFocus()) {
                ViewPager2.this.f3618k.requestFocus(2);
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public abstract class AbstractC0939d {
        public AbstractC0939d(ViewPager2 viewPager2, C0936a c0936a) {
        }

        /* renamed from: a */
        public abstract void mo1219a(C2197q8 c2197q8, RecyclerView recyclerView);
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0940e extends RecyclerView.AbstractC0834i {
        public AbstractC0940e(C0936a c0936a) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public final void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public final void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public final void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public final void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
        public final void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0941f extends LinearLayoutManager {
        public C0941f(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.C0860y c0860y, int[] iArr) {
            ViewPager2 viewPager2 = ViewPager2.this;
            int i = viewPager2.f3627t;
            if (i == -1) {
                super.calculateExtraLayoutSpace(c0860y, iArr);
                return;
            }
            int m1225c = viewPager2.m1225c() * i;
            iArr[0] = m1225c;
            iArr[1] = m1225c;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
        public void onInitializeAccessibilityNodeInfo(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, C1617d5 c1617d5) {
            super.onInitializeAccessibilityNodeInfo(c0854u, c0860y, c1617d5);
            Objects.requireNonNull(ViewPager2.this.f3628u);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
        public boolean performAccessibilityAction(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, int i, Bundle bundle) {
            Objects.requireNonNull(ViewPager2.this.f3628u);
            return super.performAccessibilityAction(c0854u, c0860y, i, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
        public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0942g {
        public void onPageScrollStateChanged(int i) {
        }

        public void onPageScrolled(int i, float f, int i2) {
        }

        public void onPageSelected(int i) {
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0943h extends AbstractC0939d {

        /* renamed from: a */
        public final InterfaceC1677f5 f3636a;

        /* renamed from: b */
        public final InterfaceC1677f5 f3637b;

        /* renamed from: c */
        public RecyclerView.AbstractC0834i f3638c;

        /* renamed from: androidx.viewpager2.widget.ViewPager2$h$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0944a implements InterfaceC1677f5 {
            public C0944a() {
            }

            @Override // p000.InterfaceC1677f5
            public boolean perform(View view, InterfaceC1677f5.AbstractC1678a abstractC1678a) {
                C0943h.this.m1218b(((ViewPager2) view).f3612d + 1);
                return true;
            }
        }

        /* renamed from: androidx.viewpager2.widget.ViewPager2$h$b */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0945b implements InterfaceC1677f5 {
            public C0945b() {
            }

            @Override // p000.InterfaceC1677f5
            public boolean perform(View view, InterfaceC1677f5.AbstractC1678a abstractC1678a) {
                C0943h.this.m1218b(((ViewPager2) view).f3612d - 1);
                return true;
            }
        }

        /* renamed from: androidx.viewpager2.widget.ViewPager2$h$c */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0946c extends AbstractC0940e {
            public C0946c() {
                super(null);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0834i
            public void onChanged() {
                C0943h.this.m1217c();
            }
        }

        public C0943h() {
            super(ViewPager2.this, null);
            this.f3636a = new C0944a();
            this.f3637b = new C0945b();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0939d
        /* renamed from: a */
        public void mo1219a(C2197q8 c2197q8, RecyclerView recyclerView) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1925s(recyclerView, 2);
            this.f3638c = new C0946c();
            if (C0492V4.C0495c.m1941c(ViewPager2.this) == 0) {
                C0492V4.C0495c.m1925s(ViewPager2.this, 1);
            }
        }

        /* renamed from: b */
        public void m1218b(int i) {
            ViewPager2 viewPager2 = ViewPager2.this;
            if (viewPager2.f3626s) {
                viewPager2.m1221g(i, true);
            }
        }

        /* renamed from: c */
        public void m1217c() {
            int itemCount;
            ViewPager2 viewPager2 = ViewPager2.this;
            C0492V4.m1954q(viewPager2, 16908360);
            C0492V4.m1954q(viewPager2, 16908361);
            C0492V4.m1954q(viewPager2, 16908358);
            C0492V4.m1954q(viewPager2, 16908359);
            if (ViewPager2.this.m1227a() == null || (itemCount = ViewPager2.this.m1227a().getItemCount()) == 0) {
                return;
            }
            ViewPager2 viewPager22 = ViewPager2.this;
            if (viewPager22.f3626s) {
                if (viewPager22.m1226b() == 0) {
                    boolean m1223e = ViewPager2.this.m1223e();
                    int i = m1223e ? 16908360 : 16908361;
                    int i2 = m1223e ? 16908361 : 16908360;
                    if (ViewPager2.this.f3612d < itemCount - 1) {
                        C0492V4.m1952s(viewPager2, new C1617d5.C1618a(i, null), null, this.f3636a);
                    }
                    if (ViewPager2.this.f3612d > 0) {
                        C0492V4.m1952s(viewPager2, new C1617d5.C1618a(i2, null), null, this.f3637b);
                        return;
                    }
                    return;
                }
                if (ViewPager2.this.f3612d < itemCount - 1) {
                    C0492V4.m1952s(viewPager2, new C1617d5.C1618a(16908359, null), null, this.f3636a);
                }
                if (ViewPager2.this.f3612d > 0) {
                    C0492V4.m1952s(viewPager2, new C1617d5.C1618a(16908358, null), null, this.f3637b);
                }
            }
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0947i {
        /* renamed from: a */
        void m1216a(View view, float f);
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0948j extends C1622d7 {
        public C0948j() {
        }

        @Override // p000.C1622d7, p000.AbstractC1840g7
        /* renamed from: c */
        public View mo793c(RecyclerView.AbstractC0843o abstractC0843o) {
            if (ViewPager2.this.f3622o.f6346a.f6572m) {
                return null;
            }
            return super.mo793c(abstractC0843o);
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0949k extends RecyclerView {
        public C0949k(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        public CharSequence getAccessibilityClassName() {
            Objects.requireNonNull(ViewPager2.this.f3628u);
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f3612d);
            accessibilityEvent.setToIndex(ViewPager2.this.f3612d);
            accessibilityEvent.setSource(ViewPager2.this);
            accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.f3626s && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.f3626s && super.onTouchEvent(motionEvent);
        }
    }

    /* renamed from: androidx.viewpager2.widget.ViewPager2$l */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class RunnableC0950l implements Runnable {

        /* renamed from: a */
        public final int f3645a;

        /* renamed from: b */
        public final RecyclerView f3646b;

        public RunnableC0950l(int i, RecyclerView recyclerView) {
            this.f3645a = i;
            this.f3646b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3646b.smoothScrollToPosition(this.f3645a);
        }
    }

    public ViewPager2(Context context) {
        super(context);
        this.f3609a = new Rect();
        this.f3610b = new Rect();
        this.f3611c = new C2197q8(3);
        this.f3613f = false;
        this.f3614g = new C0936a();
        this.f3616i = -1;
        this.f3624q = null;
        this.f3625r = false;
        this.f3626s = true;
        this.f3627t = -1;
        m1224d(context, null);
    }

    /* renamed from: a */
    public RecyclerView.AbstractC0832g m1227a() {
        return this.f3618k.getAdapter();
    }

    /* renamed from: b */
    public int m1226b() {
        return this.f3615h.getOrientation();
    }

    /* renamed from: c */
    public int m1225c() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f3618k;
        if (m1226b() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return this.f3618k.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        return this.f3618k.canScrollVertically(i);
    }

    /* renamed from: d */
    public final void m1224d(Context context, AttributeSet attributeSet) {
        this.f3628u = new C0943h();
        C0949k c0949k = new C0949k(context);
        this.f3618k = c0949k;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        c0949k.setId(C0492V4.C0496d.m1924a());
        this.f3618k.setDescendantFocusability(PKIFailureInfo.unsupportedVersion);
        C0941f c0941f = new C0941f(context);
        this.f3615h = c0941f;
        this.f3618k.setLayoutManager(c0941f);
        this.f3618k.setScrollingTouchSlop(1);
        int[] iArr = C1981m8.ViewPager2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        }
        try {
            setOrientation(obtainStyledAttributes.getInt(C1981m8.ViewPager2_android_orientation, 0));
            obtainStyledAttributes.recycle();
            this.f3618k.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this.f3618k.addOnChildAttachStateChangeListener(new C2276u8(this));
            C2256t8 c2256t8 = new C2256t8(this);
            this.f3620m = c2256t8;
            this.f3622o = new C2214r8(this, c2256t8, this.f3618k);
            C0948j c0948j = new C0948j();
            this.f3619l = c0948j;
            c0948j.m795a(this.f3618k);
            this.f3618k.addOnScrollListener(this.f3620m);
            C2197q8 c2197q8 = new C2197q8(3);
            this.f3621n = c2197q8;
            this.f3620m.f6560a = c2197q8;
            C0937b c0937b = new C0937b();
            C0938c c0938c = new C0938c();
            this.f3621n.f6294a.add(c0937b);
            this.f3621n.f6294a.add(c0938c);
            this.f3628u.mo1219a(this.f3621n, this.f3618k);
            C2197q8 c2197q82 = this.f3621n;
            c2197q82.f6294a.add(this.f3611c);
            C2235s8 c2235s8 = new C2235s8(this.f3615h);
            this.f3623p = c2235s8;
            this.f3621n.f6294a.add(c2235s8);
            RecyclerView recyclerView = this.f3618k;
            attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i = ((SavedState) parcelable).f3629a;
            sparseArray.put(this.f3618k.getId(), sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        m1222f();
    }

    /* renamed from: e */
    public boolean m1223e() {
        return this.f3615h.getLayoutDirection() == 1;
    }

    /* renamed from: f */
    public final void m1222f() {
        RecyclerView.AbstractC0832g m1227a;
        if (this.f3616i == -1 || (m1227a = m1227a()) == null) {
            return;
        }
        Parcelable parcelable = this.f3617j;
        if (parcelable != null) {
            if (m1227a instanceof InterfaceC2005n8) {
                ((InterfaceC2005n8) m1227a).m564b(parcelable);
            }
            this.f3617j = null;
        }
        int max = Math.max(0, Math.min(this.f3616i, m1227a.getItemCount() - 1));
        this.f3612d = max;
        this.f3616i = -1;
        this.f3618k.scrollToPosition(max);
        ((C0943h) this.f3628u).m1217c();
    }

    /* renamed from: g */
    public void m1221g(int i, boolean z) {
        AbstractC0942g abstractC0942g;
        RecyclerView.AbstractC0832g m1227a = m1227a();
        if (m1227a == null) {
            if (this.f3616i != -1) {
                this.f3616i = Math.max(i, 0);
            }
        } else if (m1227a.getItemCount() <= 0) {
        } else {
            int min = Math.min(Math.max(i, 0), m1227a.getItemCount() - 1);
            int i2 = this.f3612d;
            if (min == i2) {
                if (this.f3620m.f6565f == 0) {
                    return;
                }
            }
            if (min == i2 && z) {
                return;
            }
            double d = i2;
            this.f3612d = min;
            ((C0943h) this.f3628u).m1217c();
            C2256t8 c2256t8 = this.f3620m;
            if (!(c2256t8.f6565f == 0)) {
                c2256t8.m342d();
                C2256t8.C2257a c2257a = c2256t8.f6566g;
                d = c2257a.f6573a + c2257a.f6574b;
            }
            C2256t8 c2256t82 = this.f3620m;
            c2256t82.f6564e = z ? 2 : 3;
            c2256t82.f6572m = false;
            boolean z2 = c2256t82.f6568i != min;
            c2256t82.f6568i = min;
            c2256t82.m344b(2);
            if (z2 && (abstractC0942g = c2256t82.f6560a) != null) {
                abstractC0942g.onPageSelected(min);
            }
            if (!z) {
                this.f3618k.scrollToPosition(min);
                return;
            }
            double d2 = min;
            if (Math.abs(d2 - d) > 3.0d) {
                this.f3618k.scrollToPosition(d2 > d ? min - 3 : min + 3);
                RecyclerView recyclerView = this.f3618k;
                recyclerView.post(new RunnableC0950l(min, recyclerView));
                return;
            }
            this.f3618k.smoothScrollToPosition(min);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        Objects.requireNonNull(this.f3628u);
        Objects.requireNonNull(this.f3628u);
        return "androidx.viewpager.widget.ViewPager";
    }

    /* renamed from: h */
    public void m1220h() {
        C1622d7 c1622d7 = this.f3619l;
        if (c1622d7 != null) {
            View mo793c = c1622d7.mo793c(this.f3615h);
            if (mo793c == null) {
                return;
            }
            int position = this.f3615h.getPosition(mo793c);
            if (position != this.f3612d && this.f3620m.f6565f == 0) {
                this.f3621n.onPageSelected(position);
            }
            this.f3613f = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo r6) {
        /*
            r5 = this;
            super.onInitializeAccessibilityNodeInfo(r6)
            androidx.viewpager2.widget.ViewPager2$d r0 = r5.f3628u
            androidx.viewpager2.widget.ViewPager2$h r0 = (androidx.viewpager2.widget.ViewPager2.C0943h) r0
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            androidx.recyclerview.widget.RecyclerView$g r1 = r1.m1227a()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L31
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            int r1 = r1.m1226b()
            if (r1 != r2) goto L24
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            androidx.recyclerview.widget.RecyclerView$g r1 = r1.m1227a()
            int r1 = r1.getItemCount()
            goto L32
        L24:
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            androidx.recyclerview.widget.RecyclerView$g r1 = r1.m1227a()
            int r1 = r1.getItemCount()
            r4 = r1
            r1 = 0
            goto L33
        L31:
            r1 = 0
        L32:
            r4 = 0
        L33:
            d5$b r1 = p000.C1617d5.C1619b.m1013a(r1, r4, r3, r3)
            java.lang.Object r1 = r1.f4004a
            android.view.accessibility.AccessibilityNodeInfo$CollectionInfo r1 = (android.view.accessibility.AccessibilityNodeInfo.CollectionInfo) r1
            r6.setCollectionInfo(r1)
            androidx.viewpager2.widget.ViewPager2 r1 = androidx.viewpager2.widget.ViewPager2.this
            androidx.recyclerview.widget.RecyclerView$g r1 = r1.m1227a()
            if (r1 != 0) goto L47
            goto L6c
        L47:
            int r1 = r1.getItemCount()
            if (r1 == 0) goto L6c
            androidx.viewpager2.widget.ViewPager2 r3 = androidx.viewpager2.widget.ViewPager2.this
            boolean r4 = r3.f3626s
            if (r4 != 0) goto L54
            goto L6c
        L54:
            int r3 = r3.f3612d
            if (r3 <= 0) goto L5d
            r3 = 8192(0x2000, float:1.14794E-41)
            r6.addAction(r3)
        L5d:
            androidx.viewpager2.widget.ViewPager2 r0 = androidx.viewpager2.widget.ViewPager2.this
            int r0 = r0.f3612d
            int r1 = r1 - r2
            if (r0 >= r1) goto L69
            r0 = 4096(0x1000, float:5.74E-42)
            r6.addAction(r0)
        L69:
            r6.setScrollable(r2)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.ViewPager2.onInitializeAccessibilityNodeInfo(android.view.accessibility.AccessibilityNodeInfo):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.f3618k.getMeasuredWidth();
        int measuredHeight = this.f3618k.getMeasuredHeight();
        this.f3609a.left = getPaddingLeft();
        this.f3609a.right = (i3 - i) - getPaddingRight();
        this.f3609a.top = getPaddingTop();
        this.f3609a.bottom = (i4 - i2) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.TOP_START, measuredWidth, measuredHeight, this.f3609a, this.f3610b);
        RecyclerView recyclerView = this.f3618k;
        Rect rect = this.f3610b;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f3613f) {
            m1220h();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        measureChild(this.f3618k, i, i2);
        int measuredWidth = this.f3618k.getMeasuredWidth();
        int measuredHeight = this.f3618k.getMeasuredHeight();
        int measuredState = this.f3618k.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingTop = getPaddingTop();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, measuredState), ViewGroup.resolveSizeAndState(Math.max(getPaddingBottom() + paddingTop + measuredHeight, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3616i = savedState.f3630b;
        this.f3617j = savedState.f3631c;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3629a = this.f3618k.getId();
        int i = this.f3616i;
        if (i == -1) {
            i = this.f3612d;
        }
        savedState.f3630b = i;
        Parcelable parcelable = this.f3617j;
        if (parcelable != null) {
            savedState.f3631c = parcelable;
        } else {
            RecyclerView.AbstractC0832g adapter = this.f3618k.getAdapter();
            if (adapter instanceof InterfaceC2005n8) {
                savedState.f3631c = ((InterfaceC2005n8) adapter).m565a();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(ViewPager2.class.getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        int i2;
        Objects.requireNonNull((C0943h) this.f3628u);
        boolean z = false;
        if (i == 8192 || i == 4096) {
            C0943h c0943h = (C0943h) this.f3628u;
            Objects.requireNonNull(c0943h);
            if ((i == 8192 || i == 4096) ? true : true) {
                if (i == 8192) {
                    i2 = ViewPager2.this.f3612d - 1;
                } else {
                    i2 = ViewPager2.this.f3612d + 1;
                }
                c0943h.m1218b(i2);
                return true;
            }
            throw new IllegalStateException();
        }
        return super.performAccessibilityAction(i, bundle);
    }

    public void setAdapter(RecyclerView.AbstractC0832g abstractC0832g) {
        RecyclerView.AbstractC0832g adapter = this.f3618k.getAdapter();
        C0943h c0943h = (C0943h) this.f3628u;
        Objects.requireNonNull(c0943h);
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(c0943h.f3638c);
        }
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.f3614g);
        }
        this.f3618k.setAdapter(abstractC0832g);
        this.f3612d = 0;
        m1222f();
        C0943h c0943h2 = (C0943h) this.f3628u;
        c0943h2.m1217c();
        if (abstractC0832g != null) {
            abstractC0832g.registerAdapterDataObserver(c0943h2.f3638c);
        }
        if (abstractC0832g != null) {
            abstractC0832g.registerAdapterDataObserver(this.f3614g);
        }
    }

    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        ((C0943h) this.f3628u).m1217c();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.f3627t = i;
        this.f3618k.requestLayout();
    }

    public void setOrientation(int i) {
        this.f3615h.setOrientation(i);
        ((C0943h) this.f3628u).m1217c();
    }

    public void setPageTransformer(InterfaceC0947i interfaceC0947i) {
        if (interfaceC0947i != null) {
            if (!this.f3625r) {
                this.f3624q = this.f3618k.getItemAnimator();
                this.f3625r = true;
            }
            this.f3618k.setItemAnimator(null);
        } else if (this.f3625r) {
            this.f3618k.setItemAnimator(this.f3624q);
            this.f3624q = null;
            this.f3625r = false;
        }
        C2235s8 c2235s8 = this.f3623p;
        if (interfaceC0947i == c2235s8.f6396b) {
            return;
        }
        c2235s8.f6396b = interfaceC0947i;
        if (interfaceC0947i == null) {
            return;
        }
        C2256t8 c2256t8 = this.f3620m;
        c2256t8.m342d();
        C2256t8.C2257a c2257a = c2256t8.f6566g;
        double d = c2257a.f6573a + c2257a.f6574b;
        int i = (int) d;
        float f = (float) (d - i);
        this.f3623p.onPageScrolled(i, f, Math.round(m1225c() * f));
    }

    public void setUserInputEnabled(boolean z) {
        this.f3626s = z;
        ((C0943h) this.f3628u).m1217c();
    }

    public void setCurrentItem(int i, boolean z) {
        if (!this.f3622o.f6346a.f6572m) {
            m1221g(i, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0935a();

        /* renamed from: a */
        public int f3629a;

        /* renamed from: b */
        public int f3630b;

        /* renamed from: c */
        public Parcelable f3631c;

        /* renamed from: androidx.viewpager2.widget.ViewPager2$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0935a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, null) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3629a = parcel.readInt();
            this.f3630b = parcel.readInt();
            this.f3631c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3629a);
            parcel.writeInt(this.f3630b);
            parcel.writeParcelable(this.f3631c, i);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3629a = parcel.readInt();
            this.f3630b = parcel.readInt();
            this.f3631c = parcel.readParcelable(null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3609a = new Rect();
        this.f3610b = new Rect();
        this.f3611c = new C2197q8(3);
        this.f3613f = false;
        this.f3614g = new C0936a();
        this.f3616i = -1;
        this.f3624q = null;
        this.f3625r = false;
        this.f3626s = true;
        this.f3627t = -1;
        m1224d(context, attributeSet);
    }

    public ViewPager2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3609a = new Rect();
        this.f3610b = new Rect();
        this.f3611c = new C2197q8(3);
        this.f3613f = false;
        this.f3614g = new C0936a();
        this.f3616i = -1;
        this.f3624q = null;
        this.f3625r = false;
        this.f3626s = true;
        this.f3627t = -1;
        m1224d(context, attributeSet);
    }
}
