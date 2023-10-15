package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Objects;
import p000.C1617d5;
import p000.LayoutInflater$Factory2C0000A;
import p000.RunnableC0515V6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.AbstractC0843o implements RecyclerView.AbstractC0857x.InterfaceC0859b {

    /* renamed from: a */
    public int f3279a;

    /* renamed from: b */
    public C0866c[] f3280b;

    /* renamed from: c */
    public AbstractC0971b7 f3281c;

    /* renamed from: d */
    public AbstractC0971b7 f3282d;

    /* renamed from: e */
    public int f3283e;

    /* renamed from: f */
    public int f3284f;

    /* renamed from: g */
    public final C0537W6 f3285g;

    /* renamed from: h */
    public boolean f3286h;

    /* renamed from: j */
    public BitSet f3288j;

    /* renamed from: o */
    public boolean f3293o;

    /* renamed from: p */
    public boolean f3294p;

    /* renamed from: q */
    public SavedState f3295q;

    /* renamed from: r */
    public int f3296r;

    /* renamed from: v */
    public int[] f3300v;

    /* renamed from: i */
    public boolean f3287i = false;

    /* renamed from: k */
    public int f3289k = -1;

    /* renamed from: l */
    public int f3290l = Integer.MIN_VALUE;

    /* renamed from: m */
    public LazySpanLookup f3291m = new LazySpanLookup();

    /* renamed from: n */
    public int f3292n = 2;

    /* renamed from: s */
    public final Rect f3297s = new Rect();

    /* renamed from: t */
    public final C0865b f3298t = new C0865b();

    /* renamed from: u */
    public boolean f3299u = true;

    /* renamed from: w */
    public final Runnable f3301w = new RunnableC0864a();

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* renamed from: e */
        public C0866c f3302e;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0863a();

        /* renamed from: a */
        public int f3309a;

        /* renamed from: b */
        public int f3310b;

        /* renamed from: c */
        public int f3311c;

        /* renamed from: d */
        public int[] f3312d;

        /* renamed from: f */
        public int f3313f;

        /* renamed from: g */
        public int[] f3314g;

        /* renamed from: h */
        public List<LazySpanLookup.FullSpanItem> f3315h;

        /* renamed from: i */
        public boolean f3316i;

        /* renamed from: j */
        public boolean f3317j;

        /* renamed from: k */
        public boolean f3318k;

        /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0863a implements Parcelable.Creator<SavedState> {
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

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3309a);
            parcel.writeInt(this.f3310b);
            parcel.writeInt(this.f3311c);
            if (this.f3311c > 0) {
                parcel.writeIntArray(this.f3312d);
            }
            parcel.writeInt(this.f3313f);
            if (this.f3313f > 0) {
                parcel.writeIntArray(this.f3314g);
            }
            parcel.writeInt(this.f3316i ? 1 : 0);
            parcel.writeInt(this.f3317j ? 1 : 0);
            parcel.writeInt(this.f3318k ? 1 : 0);
            parcel.writeList(this.f3315h);
        }

        public SavedState(Parcel parcel) {
            this.f3309a = parcel.readInt();
            this.f3310b = parcel.readInt();
            int readInt = parcel.readInt();
            this.f3311c = readInt;
            if (readInt > 0) {
                int[] iArr = new int[readInt];
                this.f3312d = iArr;
                parcel.readIntArray(iArr);
            }
            int readInt2 = parcel.readInt();
            this.f3313f = readInt2;
            if (readInt2 > 0) {
                int[] iArr2 = new int[readInt2];
                this.f3314g = iArr2;
                parcel.readIntArray(iArr2);
            }
            this.f3316i = parcel.readInt() == 1;
            this.f3317j = parcel.readInt() == 1;
            this.f3318k = parcel.readInt() == 1;
            this.f3315h = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3311c = savedState.f3311c;
            this.f3309a = savedState.f3309a;
            this.f3310b = savedState.f3310b;
            this.f3312d = savedState.f3312d;
            this.f3313f = savedState.f3313f;
            this.f3314g = savedState.f3314g;
            this.f3316i = savedState.f3316i;
            this.f3317j = savedState.f3317j;
            this.f3318k = savedState.f3318k;
            this.f3315h = savedState.f3315h;
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0864a implements Runnable {
        public RunnableC0864a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.m1339b();
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0865b {

        /* renamed from: a */
        public int f3320a;

        /* renamed from: b */
        public int f3321b;

        /* renamed from: c */
        public boolean f3322c;

        /* renamed from: d */
        public boolean f3323d;

        /* renamed from: e */
        public boolean f3324e;

        /* renamed from: f */
        public int[] f3325f;

        public C0865b() {
            m1308b();
        }

        /* renamed from: a */
        public void m1309a() {
            this.f3321b = this.f3322c ? StaggeredGridLayoutManager.this.f3281c.mo1155g() : StaggeredGridLayoutManager.this.f3281c.mo1151k();
        }

        /* renamed from: b */
        public void m1308b() {
            this.f3320a = -1;
            this.f3321b = Integer.MIN_VALUE;
            this.f3322c = false;
            this.f3323d = false;
            this.f3324e = false;
            int[] iArr = this.f3325f;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
        }
    }

    /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0866c {

        /* renamed from: a */
        public ArrayList<View> f3327a = new ArrayList<>();

        /* renamed from: b */
        public int f3328b = Integer.MIN_VALUE;

        /* renamed from: c */
        public int f3329c = Integer.MIN_VALUE;

        /* renamed from: d */
        public int f3330d = 0;

        /* renamed from: e */
        public final int f3331e;

        public C0866c(int i) {
            this.f3331e = i;
        }

        /* renamed from: a */
        public void m1307a(View view) {
            LayoutParams m1298j = m1298j(view);
            m1298j.f3302e = this;
            this.f3327a.add(view);
            this.f3329c = Integer.MIN_VALUE;
            if (this.f3327a.size() == 1) {
                this.f3328b = Integer.MIN_VALUE;
            }
            if (m1298j.m1387c() || m1298j.m1388b()) {
                this.f3330d = StaggeredGridLayoutManager.this.f3281c.mo1159c(view) + this.f3330d;
            }
        }

        /* renamed from: b */
        public void m1306b() {
            ArrayList<View> arrayList = this.f3327a;
            View view = arrayList.get(arrayList.size() - 1);
            LayoutParams m1298j = m1298j(view);
            this.f3329c = StaggeredGridLayoutManager.this.f3281c.mo1160b(view);
            Objects.requireNonNull(m1298j);
        }

        /* renamed from: c */
        public void m1305c() {
            View view = this.f3327a.get(0);
            LayoutParams m1298j = m1298j(view);
            this.f3328b = StaggeredGridLayoutManager.this.f3281c.mo1157e(view);
            Objects.requireNonNull(m1298j);
        }

        /* renamed from: d */
        public void m1304d() {
            this.f3327a.clear();
            this.f3328b = Integer.MIN_VALUE;
            this.f3329c = Integer.MIN_VALUE;
            this.f3330d = 0;
        }

        /* renamed from: e */
        public int m1303e() {
            if (StaggeredGridLayoutManager.this.f3286h) {
                return m1301g(this.f3327a.size() - 1, -1, true);
            }
            return m1301g(0, this.f3327a.size(), true);
        }

        /* renamed from: f */
        public int m1302f() {
            if (StaggeredGridLayoutManager.this.f3286h) {
                return m1301g(0, this.f3327a.size(), true);
            }
            return m1301g(this.f3327a.size() - 1, -1, true);
        }

        /* renamed from: g */
        public int m1301g(int i, int i2, boolean z) {
            int mo1151k = StaggeredGridLayoutManager.this.f3281c.mo1151k();
            int mo1155g = StaggeredGridLayoutManager.this.f3281c.mo1155g();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f3327a.get(i);
                int mo1157e = StaggeredGridLayoutManager.this.f3281c.mo1157e(view);
                int mo1160b = StaggeredGridLayoutManager.this.f3281c.mo1160b(view);
                boolean z2 = false;
                boolean z3 = !z ? mo1157e >= mo1155g : mo1157e > mo1155g;
                if (!z ? mo1160b > mo1151k : mo1160b >= mo1151k) {
                    z2 = true;
                }
                if (z3 && z2 && (mo1157e < mo1151k || mo1160b > mo1155g)) {
                    return StaggeredGridLayoutManager.this.getPosition(view);
                }
                i += i3;
            }
            return -1;
        }

        /* renamed from: h */
        public int m1300h(int i) {
            int i2 = this.f3329c;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f3327a.size() == 0) {
                return i;
            }
            m1306b();
            return this.f3329c;
        }

        /* renamed from: i */
        public View m1299i(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f3327a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f3327a.get(i3);
                    StaggeredGridLayoutManager staggeredGridLayoutManager = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager.f3286h && staggeredGridLayoutManager.getPosition(view2) <= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager2 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager2.f3286h && staggeredGridLayoutManager2.getPosition(view2) >= i) || !view2.hasFocusable()) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f3327a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f3327a.get(size2);
                    StaggeredGridLayoutManager staggeredGridLayoutManager3 = StaggeredGridLayoutManager.this;
                    if (staggeredGridLayoutManager3.f3286h && staggeredGridLayoutManager3.getPosition(view3) >= i) {
                        break;
                    }
                    StaggeredGridLayoutManager staggeredGridLayoutManager4 = StaggeredGridLayoutManager.this;
                    if ((!staggeredGridLayoutManager4.f3286h && staggeredGridLayoutManager4.getPosition(view3) <= i) || !view3.hasFocusable()) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }

        /* renamed from: j */
        public LayoutParams m1298j(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* renamed from: k */
        public int m1297k(int i) {
            int i2 = this.f3328b;
            if (i2 != Integer.MIN_VALUE) {
                return i2;
            }
            if (this.f3327a.size() == 0) {
                return i;
            }
            m1305c();
            return this.f3328b;
        }

        /* renamed from: l */
        public void m1296l() {
            int size = this.f3327a.size();
            View remove = this.f3327a.remove(size - 1);
            LayoutParams m1298j = m1298j(remove);
            m1298j.f3302e = null;
            if (m1298j.m1387c() || m1298j.m1388b()) {
                this.f3330d -= StaggeredGridLayoutManager.this.f3281c.mo1159c(remove);
            }
            if (size == 1) {
                this.f3328b = Integer.MIN_VALUE;
            }
            this.f3329c = Integer.MIN_VALUE;
        }

        /* renamed from: m */
        public void m1295m() {
            View remove = this.f3327a.remove(0);
            LayoutParams m1298j = m1298j(remove);
            m1298j.f3302e = null;
            if (this.f3327a.size() == 0) {
                this.f3329c = Integer.MIN_VALUE;
            }
            if (m1298j.m1387c() || m1298j.m1388b()) {
                this.f3330d -= StaggeredGridLayoutManager.this.f3281c.mo1159c(remove);
            }
            this.f3328b = Integer.MIN_VALUE;
        }

        /* renamed from: n */
        public void m1294n(View view) {
            LayoutParams m1298j = m1298j(view);
            m1298j.f3302e = this;
            this.f3327a.add(0, view);
            this.f3328b = Integer.MIN_VALUE;
            if (this.f3327a.size() == 1) {
                this.f3329c = Integer.MIN_VALUE;
            }
            if (m1298j.m1387c() || m1298j.m1388b()) {
                this.f3330d = StaggeredGridLayoutManager.this.f3281c.mo1159c(view) + this.f3330d;
            }
        }
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f3279a = -1;
        this.f3286h = false;
        RecyclerView.AbstractC0843o.C0847d properties = RecyclerView.AbstractC0843o.getProperties(context, attributeSet, i, i2);
        int i3 = properties.f3239a;
        if (i3 != 0 && i3 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i3 != this.f3283e) {
            this.f3283e = i3;
            AbstractC0971b7 abstractC0971b7 = this.f3281c;
            this.f3281c = this.f3282d;
            this.f3282d = abstractC0971b7;
            requestLayout();
        }
        int i4 = properties.f3240b;
        assertNotInLayoutOrScroll(null);
        if (i4 != this.f3279a) {
            this.f3291m.m1315a();
            requestLayout();
            this.f3279a = i4;
            this.f3288j = new BitSet(this.f3279a);
            this.f3280b = new C0866c[this.f3279a];
            for (int i5 = 0; i5 < this.f3279a; i5++) {
                this.f3280b[i5] = new C0866c(i5);
            }
            requestLayout();
        }
        boolean z = properties.f3241c;
        assertNotInLayoutOrScroll(null);
        SavedState savedState = this.f3295q;
        if (savedState != null && savedState.f3316i != z) {
            savedState.f3316i = z;
        }
        this.f3286h = z;
        requestLayout();
        this.f3285g = new C0537W6();
        this.f3281c = AbstractC0971b7.m1161a(this, this.f3283e);
        this.f3282d = AbstractC0971b7.m1161a(this, 1 - this.f3283e);
    }

    /* renamed from: a */
    public final int m1340a(int i) {
        if (getChildCount() == 0) {
            return this.f3287i ? 1 : -1;
        }
        return (i < m1333h()) != this.f3287i ? -1 : 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.f3295q == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    /* renamed from: b */
    public boolean m1339b() {
        int m1333h;
        if (getChildCount() != 0 && this.f3292n != 0 && isAttachedToWindow()) {
            if (this.f3287i) {
                m1333h = m1332i();
                m1333h();
            } else {
                m1333h = m1333h();
                m1332i();
            }
            if (m1333h == 0 && m1328m() != null) {
                this.f3291m.m1315a();
                requestSimpleAnimationsInNextLayout();
                requestLayout();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* renamed from: c */
    public final int m1338c(RecyclerView.C0854u c0854u, C0537W6 c0537w6, RecyclerView.C0860y c0860y) {
        int i;
        int i2;
        int mo1151k;
        int m1331j;
        C0866c c0866c;
        ?? r1;
        int i3;
        int mo1159c;
        int mo1151k2;
        int mo1159c2;
        int i4;
        int i5;
        boolean z = false;
        this.f3288j.set(0, this.f3279a, true);
        if (this.f3285g.f1904i) {
            i2 = c0537w6.f1900e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            if (c0537w6.f1900e == 1) {
                i = c0537w6.f1902g + c0537w6.f1897b;
            } else {
                i = c0537w6.f1901f - c0537w6.f1897b;
            }
            i2 = i;
        }
        m1319v(c0537w6.f1900e, i2);
        if (this.f3287i) {
            mo1151k = this.f3281c.mo1155g();
        } else {
            mo1151k = this.f3281c.mo1151k();
        }
        int i6 = mo1151k;
        boolean z2 = false;
        while (true) {
            int i7 = c0537w6.f1898c;
            int i8 = -1;
            if (!(i7 >= 0 && i7 < c0860y.m1341b()) || (!this.f3285g.f1904i && this.f3288j.isEmpty())) {
                break;
            }
            View view = c0854u.m1349k(c0537w6.f1898c, z, RecyclerView.FOREVER_NS).itemView;
            c0537w6.f1898c += c0537w6.f1899d;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int m1389a = layoutParams.m1389a();
            int[] iArr = this.f3291m.f3303a;
            int i9 = (iArr == null || m1389a >= iArr.length) ? -1 : iArr[m1389a];
            if (i9 == -1) {
                if (m1325p(c0537w6.f1900e)) {
                    i5 = this.f3279a - 1;
                    i4 = -1;
                } else {
                    i8 = this.f3279a;
                    i4 = 1;
                    i5 = 0;
                }
                C0866c c0866c2 = null;
                if (c0537w6.f1900e == 1) {
                    int mo1151k3 = this.f3281c.mo1151k();
                    int i10 = Integer.MAX_VALUE;
                    while (i5 != i8) {
                        C0866c c0866c3 = this.f3280b[i5];
                        int m1300h = c0866c3.m1300h(mo1151k3);
                        if (m1300h < i10) {
                            i10 = m1300h;
                            c0866c2 = c0866c3;
                        }
                        i5 += i4;
                    }
                } else {
                    int mo1155g = this.f3281c.mo1155g();
                    int i11 = Integer.MIN_VALUE;
                    while (i5 != i8) {
                        C0866c c0866c4 = this.f3280b[i5];
                        int m1297k = c0866c4.m1297k(mo1155g);
                        if (m1297k > i11) {
                            c0866c2 = c0866c4;
                            i11 = m1297k;
                        }
                        i5 += i4;
                    }
                }
                c0866c = c0866c2;
                LazySpanLookup lazySpanLookup = this.f3291m;
                lazySpanLookup.m1314b(m1389a);
                lazySpanLookup.f3303a[m1389a] = c0866c.f3331e;
            } else {
                c0866c = this.f3280b[i9];
            }
            C0866c c0866c5 = c0866c;
            layoutParams.f3302e = c0866c5;
            if (c0537w6.f1900e == 1) {
                addView(view);
                r1 = 0;
            } else {
                r1 = 0;
                addView(view, 0);
            }
            if (this.f3283e == 1) {
                m1327n(view, RecyclerView.AbstractC0843o.getChildMeasureSpec(this.f3284f, getWidthMode(), r1, ((ViewGroup.MarginLayoutParams) layoutParams).width, r1), RecyclerView.AbstractC0843o.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup.MarginLayoutParams) layoutParams).height, true), r1);
            } else {
                m1327n(view, RecyclerView.AbstractC0843o.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup.MarginLayoutParams) layoutParams).width, true), RecyclerView.AbstractC0843o.getChildMeasureSpec(this.f3284f, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) layoutParams).height, false), false);
            }
            if (c0537w6.f1900e == 1) {
                int m1300h2 = c0866c5.m1300h(i6);
                mo1159c = m1300h2;
                i3 = this.f3281c.mo1159c(view) + m1300h2;
            } else {
                int m1297k2 = c0866c5.m1297k(i6);
                i3 = m1297k2;
                mo1159c = m1297k2 - this.f3281c.mo1159c(view);
            }
            if (c0537w6.f1900e == 1) {
                layoutParams.f3302e.m1307a(view);
            } else {
                layoutParams.f3302e.m1294n(view);
            }
            if (isLayoutRTL() && this.f3283e == 1) {
                mo1159c2 = this.f3282d.mo1155g() - (((this.f3279a - 1) - c0866c5.f3331e) * this.f3284f);
                mo1151k2 = mo1159c2 - this.f3282d.mo1159c(view);
            } else {
                mo1151k2 = this.f3282d.mo1151k() + (c0866c5.f3331e * this.f3284f);
                mo1159c2 = this.f3282d.mo1159c(view) + mo1151k2;
            }
            int i12 = mo1159c2;
            int i13 = mo1151k2;
            if (this.f3283e == 1) {
                layoutDecoratedWithMargins(view, i13, mo1159c, i12, i3);
            } else {
                layoutDecoratedWithMargins(view, mo1159c, i13, i3, i12);
            }
            m1317x(c0866c5, this.f3285g.f1900e, i2);
            m1323r(c0854u, this.f3285g);
            if (this.f3285g.f1903h && view.hasFocusable()) {
                this.f3288j.set(c0866c5.f3331e, false);
            }
            z2 = true;
            z = false;
        }
        if (!z2) {
            m1323r(c0854u, this.f3285g);
        }
        if (this.f3285g.f1900e == -1) {
            m1331j = this.f3281c.mo1151k() - m1330k(this.f3281c.mo1151k());
        } else {
            m1331j = m1331j(this.f3281c.mo1155g()) - this.f3281c.mo1155g();
        }
        if (m1331j > 0) {
            return Math.min(c0537w6.f1897b, m1331j);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean canScrollHorizontally() {
        return this.f3283e == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean canScrollVertically() {
        return this.f3283e == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView.C0860y c0860y, RecyclerView.AbstractC0843o.InterfaceC0846c interfaceC0846c) {
        int m1300h;
        int i3;
        if (this.f3283e != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        m1324q(i, c0860y);
        int[] iArr = this.f3300v;
        if (iArr == null || iArr.length < this.f3279a) {
            this.f3300v = new int[this.f3279a];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.f3279a; i5++) {
            C0537W6 c0537w6 = this.f3285g;
            if (c0537w6.f1899d == -1) {
                m1300h = c0537w6.f1901f;
                i3 = this.f3280b[i5].m1297k(m1300h);
            } else {
                m1300h = this.f3280b[i5].m1300h(c0537w6.f1902g);
                i3 = this.f3285g.f1902g;
            }
            int i6 = m1300h - i3;
            if (i6 >= 0) {
                this.f3300v[i4] = i6;
                i4++;
            }
        }
        Arrays.sort(this.f3300v, 0, i4);
        for (int i7 = 0; i7 < i4; i7++) {
            int i8 = this.f3285g.f1898c;
            if (!(i8 >= 0 && i8 < c0860y.m1341b())) {
                return;
            }
            ((RunnableC0515V6.C0517b) interfaceC0846c).m1829a(this.f3285g.f1898c, this.f3300v[i7]);
            C0537W6 c0537w62 = this.f3285g;
            c0537w62.f1898c += c0537w62.f1899d;
        }
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

    public final int computeScrollExtent(RecyclerView.C0860y c0860y) {
        if (getChildCount() == 0) {
            return 0;
        }
        return LayoutInflater$Factory2C0000A.C0010h.m2627m(c0860y, this.f3281c, m1336e(!this.f3299u), m1337d(!this.f3299u), this, this.f3299u);
    }

    public final int computeScrollOffset(RecyclerView.C0860y c0860y) {
        if (getChildCount() == 0) {
            return 0;
        }
        return LayoutInflater$Factory2C0000A.C0010h.m2625n(c0860y, this.f3281c, m1336e(!this.f3299u), m1337d(!this.f3299u), this, this.f3299u, this.f3287i);
    }

    public final int computeScrollRange(RecyclerView.C0860y c0860y) {
        if (getChildCount() == 0) {
            return 0;
        }
        return LayoutInflater$Factory2C0000A.C0010h.m2623o(c0860y, this.f3281c, m1336e(!this.f3299u), m1337d(!this.f3299u), this, this.f3299u);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0857x.InterfaceC0859b
    public PointF computeScrollVectorForPosition(int i) {
        int m1340a = m1340a(i);
        PointF pointF = new PointF();
        if (m1340a == 0) {
            return null;
        }
        if (this.f3283e == 0) {
            pointF.x = m1340a;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = m1340a;
        }
        return pointF;
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

    /* renamed from: d */
    public View m1337d(boolean z) {
        int mo1151k = this.f3281c.mo1151k();
        int mo1155g = this.f3281c.mo1155g();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int mo1157e = this.f3281c.mo1157e(childAt);
            int mo1160b = this.f3281c.mo1160b(childAt);
            if (mo1160b > mo1151k && mo1157e < mo1155g) {
                if (mo1160b <= mo1155g || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: e */
    public View m1336e(boolean z) {
        int mo1151k = this.f3281c.mo1151k();
        int mo1155g = this.f3281c.mo1155g();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int mo1157e = this.f3281c.mo1157e(childAt);
            if (this.f3281c.mo1160b(childAt) > mo1151k && mo1157e < mo1155g) {
                if (mo1157e >= mo1151k || !z) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    /* renamed from: f */
    public final void m1335f(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, boolean z) {
        int mo1155g;
        int m1331j = m1331j(Integer.MIN_VALUE);
        if (m1331j != Integer.MIN_VALUE && (mo1155g = this.f3281c.mo1155g() - m1331j) > 0) {
            int i = mo1155g - (-scrollBy(-mo1155g, c0854u, c0860y));
            if (!z || i <= 0) {
                return;
            }
            this.f3281c.mo1146p(i);
        }
    }

    /* renamed from: g */
    public final void m1334g(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, boolean z) {
        int mo1151k;
        int m1330k = m1330k(Integer.MAX_VALUE);
        if (m1330k != Integer.MAX_VALUE && (mo1151k = m1330k - this.f3281c.mo1151k()) > 0) {
            int scrollBy = mo1151k - scrollBy(mo1151k, c0854u, c0860y);
            if (!z || scrollBy <= 0) {
                return;
            }
            this.f3281c.mo1146p(-scrollBy);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.f3283e == 0) {
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
        if (this.f3283e == 1) {
            return this.f3279a;
        }
        return super.getColumnCountForAccessibility(c0854u, c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int getRowCountForAccessibility(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        if (this.f3283e == 0) {
            return this.f3279a;
        }
        return super.getRowCountForAccessibility(c0854u, c0860y);
    }

    /* renamed from: h */
    public int m1333h() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    /* renamed from: i */
    public int m1332i() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean isAutoMeasureEnabled() {
        return this.f3292n != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* renamed from: j */
    public final int m1331j(int i) {
        int m1300h = this.f3280b[0].m1300h(i);
        for (int i2 = 1; i2 < this.f3279a; i2++) {
            int m1300h2 = this.f3280b[i2].m1300h(i);
            if (m1300h2 > m1300h) {
                m1300h = m1300h2;
            }
        }
        return m1300h;
    }

    /* renamed from: k */
    public final int m1330k(int i) {
        int m1297k = this.f3280b[0].m1297k(i);
        for (int i2 = 1; i2 < this.f3279a; i2++) {
            int m1297k2 = this.f3280b[i2].m1297k(i);
            if (m1297k2 < m1297k) {
                m1297k = m1297k2;
            }
        }
        return m1297k;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1329l(int r7, int r8, int r9) {
        /*
            r6 = this;
            boolean r0 = r6.f3287i
            if (r0 == 0) goto L9
            int r0 = r6.m1332i()
            goto Ld
        L9:
            int r0 = r6.m1333h()
        Ld:
            r1 = 8
            if (r9 != r1) goto L1a
            if (r7 >= r8) goto L16
            int r2 = r8 + 1
            goto L1c
        L16:
            int r2 = r7 + 1
            r3 = r8
            goto L1d
        L1a:
            int r2 = r7 + r8
        L1c:
            r3 = r7
        L1d:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r6.f3291m
            r4.m1312d(r3)
            r4 = 1
            if (r9 == r4) goto L3c
            r5 = 2
            if (r9 == r5) goto L36
            if (r9 == r1) goto L2b
            goto L41
        L2b:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f3291m
            r9.m1310f(r7, r4)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r7 = r6.f3291m
            r7.m1311e(r8, r4)
            goto L41
        L36:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f3291m
            r9.m1310f(r7, r8)
            goto L41
        L3c:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup r9 = r6.f3291m
            r9.m1311e(r7, r8)
        L41:
            if (r2 > r0) goto L44
            return
        L44:
            boolean r7 = r6.f3287i
            if (r7 == 0) goto L4d
            int r7 = r6.m1333h()
            goto L51
        L4d:
            int r7 = r6.m1332i()
        L51:
            if (r3 > r7) goto L56
            r6.requestLayout()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m1329l(int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bc, code lost:
        if (r10 == r11) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ce, code lost:
        if (r10 == r11) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d0, code lost:
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00d2, code lost:
        r10 = false;
     */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View m1328m() {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m1328m():android.view.View");
    }

    /* renamed from: n */
    public final void m1327n(View view, int i, int i2, boolean z) {
        boolean shouldMeasureChild;
        calculateItemDecorationsForChild(view, this.f3297s);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
        Rect rect = this.f3297s;
        int m1316y = m1316y(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        Rect rect2 = this.f3297s;
        int m1316y2 = m1316y(i2, i4 + rect2.top, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + rect2.bottom);
        if (z) {
            shouldMeasureChild = shouldReMeasureChild(view, m1316y, m1316y2, layoutParams);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, m1316y, m1316y2, layoutParams);
        }
        if (shouldMeasureChild) {
            view.measure(m1316y, m1316y2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:243:0x0413, code lost:
        if (m1339b() != false) goto L254;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01b9  */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1326o(androidx.recyclerview.widget.RecyclerView.C0854u r12, androidx.recyclerview.widget.RecyclerView.C0860y r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 1077
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m1326o(androidx.recyclerview.widget.RecyclerView$u, androidx.recyclerview.widget.RecyclerView$y, boolean):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.f3279a; i2++) {
            C0866c c0866c = this.f3280b[i2];
            int i3 = c0866c.f3328b;
            if (i3 != Integer.MIN_VALUE) {
                c0866c.f3328b = i3 + i;
            }
            int i4 = c0866c.f3329c;
            if (i4 != Integer.MIN_VALUE) {
                c0866c.f3329c = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.f3279a; i2++) {
            C0866c c0866c = this.f3280b[i2];
            int i3 = c0866c.f3328b;
            if (i3 != Integer.MIN_VALUE) {
                c0866c.f3328b = i3 + i;
            }
            int i4 = c0866c.f3329c;
            if (i4 != Integer.MIN_VALUE) {
                c0866c.f3329c = i4 + i;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.C0854u c0854u) {
        super.onDetachedFromWindow(recyclerView, c0854u);
        removeCallbacks(this.f3301w);
        for (int i = 0; i < this.f3279a; i++) {
            this.f3280b[i].m1304d();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x003c, code lost:
        if (r8.f3283e == 1) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0042, code lost:
        if (r8.f3283e == 0) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x004e, code lost:
        if (isLayoutRTL() == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005a, code lost:
        if (isLayoutRTL() == false) goto L111;
     */
    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View onFocusSearchFailed(android.view.View r9, int r10, androidx.recyclerview.widget.RecyclerView.C0854u r11, androidx.recyclerview.widget.RecyclerView.C0860y r12) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$u, androidx.recyclerview.widget.RecyclerView$y):android.view.View");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View m1336e = m1336e(false);
            View m1337d = m1337d(false);
            if (m1336e == null || m1337d == null) {
                return;
            }
            int position = getPosition(m1336e);
            int position2 = getPosition(m1337d);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
                return;
            }
            accessibilityEvent.setFromIndex(position2);
            accessibilityEvent.setToIndex(position);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y, View view, C1617d5 c1617d5) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, c1617d5);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f3283e == 0) {
            C0866c c0866c = layoutParams2.f3302e;
            c1617d5.m1018o(C1617d5.C1620c.m1012a(c0866c == null ? -1 : c0866c.f3331e, 1, -1, -1, false, false));
            return;
        }
        C0866c c0866c2 = layoutParams2.f3302e;
        c1617d5.m1018o(C1617d5.C1620c.m1012a(-1, -1, c0866c2 == null ? -1 : c0866c2.f3331e, 1, false, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        m1329l(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.f3291m.m1315a();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        m1329l(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        m1329l(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        m1329l(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onLayoutChildren(RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        m1326o(c0854u, c0860y, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onLayoutCompleted(RecyclerView.C0860y c0860y) {
        super.onLayoutCompleted(c0860y);
        this.f3289k = -1;
        this.f3290l = Integer.MIN_VALUE;
        this.f3295q = null;
        this.f3298t.m1308b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f3295q = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public Parcelable onSaveInstanceState() {
        int m1297k;
        int mo1151k;
        int[] iArr;
        SavedState savedState = this.f3295q;
        if (savedState != null) {
            return new SavedState(savedState);
        }
        SavedState savedState2 = new SavedState();
        savedState2.f3316i = this.f3286h;
        savedState2.f3317j = this.f3293o;
        savedState2.f3318k = this.f3294p;
        LazySpanLookup lazySpanLookup = this.f3291m;
        if (lazySpanLookup != null && (iArr = lazySpanLookup.f3303a) != null) {
            savedState2.f3314g = iArr;
            savedState2.f3313f = iArr.length;
            savedState2.f3315h = lazySpanLookup.f3304b;
        } else {
            savedState2.f3313f = 0;
        }
        if (getChildCount() > 0) {
            savedState2.f3309a = this.f3293o ? m1332i() : m1333h();
            View m1337d = this.f3287i ? m1337d(true) : m1336e(true);
            savedState2.f3310b = m1337d != null ? getPosition(m1337d) : -1;
            int i = this.f3279a;
            savedState2.f3311c = i;
            savedState2.f3312d = new int[i];
            for (int i2 = 0; i2 < this.f3279a; i2++) {
                if (this.f3293o) {
                    m1297k = this.f3280b[i2].m1300h(Integer.MIN_VALUE);
                    if (m1297k != Integer.MIN_VALUE) {
                        mo1151k = this.f3281c.mo1155g();
                        m1297k -= mo1151k;
                        savedState2.f3312d[i2] = m1297k;
                    } else {
                        savedState2.f3312d[i2] = m1297k;
                    }
                } else {
                    m1297k = this.f3280b[i2].m1297k(Integer.MIN_VALUE);
                    if (m1297k != Integer.MIN_VALUE) {
                        mo1151k = this.f3281c.mo1151k();
                        m1297k -= mo1151k;
                        savedState2.f3312d[i2] = m1297k;
                    } else {
                        savedState2.f3312d[i2] = m1297k;
                    }
                }
            }
        } else {
            savedState2.f3309a = -1;
            savedState2.f3310b = -1;
            savedState2.f3311c = 0;
        }
        return savedState2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            m1339b();
        }
    }

    /* renamed from: p */
    public final boolean m1325p(int i) {
        if (this.f3283e == 0) {
            return (i == -1) != this.f3287i;
        }
        return ((i == -1) == this.f3287i) == isLayoutRTL();
    }

    /* renamed from: q */
    public void m1324q(int i, RecyclerView.C0860y c0860y) {
        int m1333h;
        int i2;
        if (i > 0) {
            m1333h = m1332i();
            i2 = 1;
        } else {
            m1333h = m1333h();
            i2 = -1;
        }
        this.f3285g.f1896a = true;
        m1318w(m1333h, c0860y);
        m1320u(i2);
        C0537W6 c0537w6 = this.f3285g;
        c0537w6.f1898c = m1333h + c0537w6.f1899d;
        c0537w6.f1897b = Math.abs(i);
    }

    /* renamed from: r */
    public final void m1323r(RecyclerView.C0854u c0854u, C0537W6 c0537w6) {
        int min;
        int min2;
        if (!c0537w6.f1896a || c0537w6.f1904i) {
            return;
        }
        if (c0537w6.f1897b == 0) {
            if (c0537w6.f1900e == -1) {
                m1322s(c0854u, c0537w6.f1902g);
                return;
            } else {
                m1321t(c0854u, c0537w6.f1901f);
                return;
            }
        }
        int i = 1;
        if (c0537w6.f1900e == -1) {
            int i2 = c0537w6.f1901f;
            int m1297k = this.f3280b[0].m1297k(i2);
            while (i < this.f3279a) {
                int m1297k2 = this.f3280b[i].m1297k(i2);
                if (m1297k2 > m1297k) {
                    m1297k = m1297k2;
                }
                i++;
            }
            int i3 = i2 - m1297k;
            if (i3 < 0) {
                min2 = c0537w6.f1902g;
            } else {
                min2 = c0537w6.f1902g - Math.min(i3, c0537w6.f1897b);
            }
            m1322s(c0854u, min2);
            return;
        }
        int i4 = c0537w6.f1902g;
        int m1300h = this.f3280b[0].m1300h(i4);
        while (i < this.f3279a) {
            int m1300h2 = this.f3280b[i].m1300h(i4);
            if (m1300h2 < m1300h) {
                m1300h = m1300h2;
            }
            i++;
        }
        int i5 = m1300h - c0537w6.f1902g;
        if (i5 < 0) {
            min = c0537w6.f1901f;
        } else {
            min = Math.min(i5, c0537w6.f1897b) + c0537w6.f1901f;
        }
        m1321t(c0854u, min);
    }

    public final void resolveShouldLayoutReverse() {
        if (this.f3283e != 1 && isLayoutRTL()) {
            this.f3287i = !this.f3286h;
        } else {
            this.f3287i = this.f3286h;
        }
    }

    /* renamed from: s */
    public final void m1322s(RecyclerView.C0854u c0854u, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.f3281c.mo1157e(childAt) < i || this.f3281c.mo1147o(childAt) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams);
            if (layoutParams.f3302e.f3327a.size() == 1) {
                return;
            }
            layoutParams.f3302e.m1296l();
            removeAndRecycleView(childAt, c0854u);
        }
    }

    public int scrollBy(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        m1324q(i, c0860y);
        int m1338c = m1338c(c0854u, this.f3285g, c0860y);
        if (this.f3285g.f1897b >= m1338c) {
            i = i < 0 ? -m1338c : m1338c;
        }
        this.f3281c.mo1146p(-i);
        this.f3293o = this.f3287i;
        C0537W6 c0537w6 = this.f3285g;
        c0537w6.f1897b = 0;
        m1323r(c0854u, c0537w6);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int scrollHorizontallyBy(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        return scrollBy(i, c0854u, c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void scrollToPosition(int i) {
        SavedState savedState = this.f3295q;
        if (savedState != null && savedState.f3309a != i) {
            savedState.f3312d = null;
            savedState.f3311c = 0;
            savedState.f3309a = -1;
            savedState.f3310b = -1;
        }
        this.f3289k = i;
        this.f3290l = Integer.MIN_VALUE;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public int scrollVerticallyBy(int i, RecyclerView.C0854u c0854u, RecyclerView.C0860y c0860y) {
        return scrollBy(i, c0854u, c0860y);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.f3283e == 1) {
            chooseSize2 = RecyclerView.AbstractC0843o.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            chooseSize = RecyclerView.AbstractC0843o.chooseSize(i, (this.f3284f * this.f3279a) + paddingRight, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.AbstractC0843o.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            chooseSize2 = RecyclerView.AbstractC0843o.chooseSize(i2, (this.f3284f * this.f3279a) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.C0860y c0860y, int i) {
        C0558X6 c0558x6 = new C0558X6(recyclerView.getContext());
        c0558x6.setTargetPosition(i);
        startSmoothScroll(c0558x6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public boolean supportsPredictiveItemAnimations() {
        return this.f3295q == null;
    }

    /* renamed from: t */
    public final void m1321t(RecyclerView.C0854u c0854u, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.f3281c.mo1160b(childAt) > i || this.f3281c.mo1148n(childAt) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            Objects.requireNonNull(layoutParams);
            if (layoutParams.f3302e.f3327a.size() == 1) {
                return;
            }
            layoutParams.f3302e.m1295m();
            removeAndRecycleView(childAt, c0854u);
        }
    }

    /* renamed from: u */
    public final void m1320u(int i) {
        C0537W6 c0537w6 = this.f3285g;
        c0537w6.f1900e = i;
        c0537w6.f1899d = this.f3287i != (i == -1) ? -1 : 1;
    }

    /* renamed from: v */
    public final void m1319v(int i, int i2) {
        for (int i3 = 0; i3 < this.f3279a; i3++) {
            if (!this.f3280b[i3].f3327a.isEmpty()) {
                m1317x(this.f3280b[i3], i, i2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004b  */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1318w(int r5, androidx.recyclerview.widget.RecyclerView.C0860y r6) {
        /*
            r4 = this;
            W6 r0 = r4.f3285g
            r1 = 0
            r0.f1897b = r1
            r0.f1898c = r5
            boolean r0 = r4.isSmoothScrolling()
            r2 = 1
            if (r0 == 0) goto L2c
            int r6 = r6.f3265a
            r0 = -1
            if (r6 == r0) goto L2c
            boolean r0 = r4.f3287i
            if (r6 >= r5) goto L19
            r5 = 1
            goto L1a
        L19:
            r5 = 0
        L1a:
            if (r0 != r5) goto L23
            b7 r5 = r4.f3281c
            int r5 = r5.mo1150l()
            goto L2d
        L23:
            b7 r5 = r4.f3281c
            int r5 = r5.mo1150l()
            r6 = r5
            r5 = 0
            goto L2e
        L2c:
            r5 = 0
        L2d:
            r6 = 0
        L2e:
            boolean r0 = r4.getClipToPadding()
            if (r0 == 0) goto L4b
            W6 r0 = r4.f3285g
            b7 r3 = r4.f3281c
            int r3 = r3.mo1151k()
            int r3 = r3 - r6
            r0.f1901f = r3
            W6 r6 = r4.f3285g
            b7 r0 = r4.f3281c
            int r0 = r0.mo1155g()
            int r0 = r0 + r5
            r6.f1902g = r0
            goto L5b
        L4b:
            W6 r0 = r4.f3285g
            b7 r3 = r4.f3281c
            int r3 = r3.mo1156f()
            int r3 = r3 + r5
            r0.f1902g = r3
            W6 r5 = r4.f3285g
            int r6 = -r6
            r5.f1901f = r6
        L5b:
            W6 r5 = r4.f3285g
            r5.f1903h = r1
            r5.f1896a = r2
            b7 r6 = r4.f3281c
            int r6 = r6.mo1153i()
            if (r6 != 0) goto L72
            b7 r6 = r4.f3281c
            int r6 = r6.mo1156f()
            if (r6 != 0) goto L72
            r1 = 1
        L72:
            r5.f1904i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.m1318w(int, androidx.recyclerview.widget.RecyclerView$y):void");
    }

    /* renamed from: x */
    public final void m1317x(C0866c c0866c, int i, int i2) {
        int i3 = c0866c.f3330d;
        if (i == -1) {
            int i4 = c0866c.f3328b;
            if (i4 == Integer.MIN_VALUE) {
                c0866c.m1305c();
                i4 = c0866c.f3328b;
            }
            if (i4 + i3 <= i2) {
                this.f3288j.set(c0866c.f3331e, false);
                return;
            }
            return;
        }
        int i5 = c0866c.f3329c;
        if (i5 == Integer.MIN_VALUE) {
            c0866c.m1306b();
            i5 = c0866c.f3329c;
        }
        if (i5 - i3 >= i2) {
            this.f3288j.set(c0866c.f3331e, false);
        }
    }

    /* renamed from: y */
    public final int m1316y(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0843o
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LazySpanLookup {

        /* renamed from: a */
        public int[] f3303a;

        /* renamed from: b */
        public List<FullSpanItem> f3304b;

        /* renamed from: a */
        public void m1315a() {
            int[] iArr = this.f3303a;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f3304b = null;
        }

        /* renamed from: b */
        public void m1314b(int i) {
            int[] iArr = this.f3303a;
            if (iArr == null) {
                int[] iArr2 = new int[Math.max(i, 10) + 1];
                this.f3303a = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i >= iArr.length) {
                int length = iArr.length;
                while (length <= i) {
                    length *= 2;
                }
                int[] iArr3 = new int[length];
                this.f3303a = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                int[] iArr4 = this.f3303a;
                Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
            }
        }

        /* renamed from: c */
        public FullSpanItem m1313c(int i) {
            List<FullSpanItem> list = this.f3304b;
            if (list == null) {
                return null;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3304b.get(size);
                if (fullSpanItem.f3305a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
        /* renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public int m1312d(int r5) {
            /*
                r4 = this;
                int[] r0 = r4.f3303a
                r1 = -1
                if (r0 != 0) goto L6
                return r1
            L6:
                int r0 = r0.length
                if (r5 < r0) goto La
                return r1
            La:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r4.f3304b
                if (r0 != 0) goto L10
            Le:
                r0 = -1
                goto L46
            L10:
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = r4.m1313c(r5)
                if (r0 == 0) goto L1b
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r2 = r4.f3304b
                r2.remove(r0)
            L1b:
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r4.f3304b
                int r0 = r0.size()
                r2 = 0
            L22:
                if (r2 >= r0) goto L34
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r4.f3304b
                java.lang.Object r3 = r3.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r3
                int r3 = r3.f3305a
                if (r3 < r5) goto L31
                goto L35
            L31:
                int r2 = r2 + 1
                goto L22
            L34:
                r2 = -1
            L35:
                if (r2 == r1) goto Le
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r0 = r4.f3304b
                java.lang.Object r0 = r0.get(r2)
                androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem) r0
                java.util.List<androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem> r3 = r4.f3304b
                r3.remove(r2)
                int r0 = r0.f3305a
            L46:
                if (r0 != r1) goto L52
                int[] r0 = r4.f3303a
                int r2 = r0.length
                java.util.Arrays.fill(r0, r5, r2, r1)
                int[] r5 = r4.f3303a
                int r5 = r5.length
                return r5
            L52:
                int[] r2 = r4.f3303a
                int r0 = r0 + 1
                java.util.Arrays.fill(r2, r5, r0, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.LazySpanLookup.m1312d(int):int");
        }

        /* renamed from: e */
        public void m1311e(int i, int i2) {
            int[] iArr = this.f3303a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            m1314b(i3);
            int[] iArr2 = this.f3303a;
            System.arraycopy(iArr2, i, iArr2, i3, (iArr2.length - i) - i2);
            Arrays.fill(this.f3303a, i, i3, -1);
            List<FullSpanItem> list = this.f3304b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3304b.get(size);
                int i4 = fullSpanItem.f3305a;
                if (i4 >= i) {
                    fullSpanItem.f3305a = i4 + i2;
                }
            }
        }

        /* renamed from: f */
        public void m1310f(int i, int i2) {
            int[] iArr = this.f3303a;
            if (iArr == null || i >= iArr.length) {
                return;
            }
            int i3 = i + i2;
            m1314b(i3);
            int[] iArr2 = this.f3303a;
            System.arraycopy(iArr2, i3, iArr2, i, (iArr2.length - i) - i2);
            int[] iArr3 = this.f3303a;
            Arrays.fill(iArr3, iArr3.length - i2, iArr3.length, -1);
            List<FullSpanItem> list = this.f3304b;
            if (list == null) {
                return;
            }
            for (int size = list.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3304b.get(size);
                int i4 = fullSpanItem.f3305a;
                if (i4 >= i) {
                    if (i4 < i3) {
                        this.f3304b.remove(size);
                    } else {
                        fullSpanItem.f3305a = i4 - i2;
                    }
                }
            }
        }

        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new C0862a();

            /* renamed from: a */
            public int f3305a;

            /* renamed from: b */
            public int f3306b;

            /* renamed from: c */
            public int[] f3307c;

            /* renamed from: d */
            public boolean f3308d;

            /* renamed from: androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem$a */
            /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
            public static class C0862a implements Parcelable.Creator<FullSpanItem> {
                @Override // android.os.Parcelable.Creator
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }

            public FullSpanItem(Parcel parcel) {
                this.f3305a = parcel.readInt();
                this.f3306b = parcel.readInt();
                this.f3308d = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    this.f3307c = iArr;
                    parcel.readIntArray(iArr);
                }
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            public String toString() {
                StringBuilder m253r = outline.m253r("FullSpanItem{mPosition=");
                m253r.append(this.f3305a);
                m253r.append(", mGapDir=");
                m253r.append(this.f3306b);
                m253r.append(", mHasUnwantedGapAfter=");
                m253r.append(this.f3308d);
                m253r.append(", mGapPerSpan=");
                m253r.append(Arrays.toString(this.f3307c));
                m253r.append('}');
                return m253r.toString();
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3305a);
                parcel.writeInt(this.f3306b);
                parcel.writeInt(this.f3308d ? 1 : 0);
                int[] iArr = this.f3307c;
                if (iArr != null && iArr.length > 0) {
                    parcel.writeInt(iArr.length);
                    parcel.writeIntArray(this.f3307c);
                    return;
                }
                parcel.writeInt(0);
            }

            public FullSpanItem() {
            }
        }
    }
}
