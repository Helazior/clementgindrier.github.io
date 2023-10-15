package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: K6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0247K6 {

    /* renamed from: a */
    public final InterfaceC0249b f780a;

    /* renamed from: b */
    public final C0248a f781b = new C0248a();

    /* renamed from: c */
    public final List<View> f782c = new ArrayList();

    /* renamed from: K6$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0248a {

        /* renamed from: a */
        public long f783a = 0;

        /* renamed from: b */
        public C0248a f784b;

        /* renamed from: a */
        public void m2242a(int i) {
            if (i >= 64) {
                C0248a c0248a = this.f784b;
                if (c0248a != null) {
                    c0248a.m2242a(i - 64);
                    return;
                }
                return;
            }
            this.f783a &= ~(1 << i);
        }

        /* renamed from: b */
        public int m2241b(int i) {
            C0248a c0248a = this.f784b;
            if (c0248a == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f783a);
                }
                return Long.bitCount(this.f783a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.f783a & ((1 << i) - 1));
            } else {
                return Long.bitCount(this.f783a) + c0248a.m2241b(i - 64);
            }
        }

        /* renamed from: c */
        public final void m2240c() {
            if (this.f784b == null) {
                this.f784b = new C0248a();
            }
        }

        /* renamed from: d */
        public boolean m2239d(int i) {
            if (i < 64) {
                return (this.f783a & (1 << i)) != 0;
            }
            m2240c();
            return this.f784b.m2239d(i - 64);
        }

        /* renamed from: e */
        public void m2238e(int i, boolean z) {
            if (i >= 64) {
                m2240c();
                this.f784b.m2238e(i - 64, z);
                return;
            }
            long j = this.f783a;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.f783a = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                m2235h(i);
            } else {
                m2242a(i);
            }
            if (z2 || this.f784b != null) {
                m2240c();
                this.f784b.m2238e(0, z2);
            }
        }

        /* renamed from: f */
        public boolean m2237f(int i) {
            if (i >= 64) {
                m2240c();
                return this.f784b.m2237f(i - 64);
            }
            long j = 1 << i;
            long j2 = this.f783a;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.f783a = j3;
            long j4 = j - 1;
            this.f783a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            C0248a c0248a = this.f784b;
            if (c0248a != null) {
                if (c0248a.m2239d(0)) {
                    m2235h(63);
                }
                this.f784b.m2237f(0);
            }
            return z;
        }

        /* renamed from: g */
        public void m2236g() {
            this.f783a = 0L;
            C0248a c0248a = this.f784b;
            if (c0248a != null) {
                c0248a.m2236g();
            }
        }

        /* renamed from: h */
        public void m2235h(int i) {
            if (i >= 64) {
                m2240c();
                this.f784b.m2235h(i - 64);
                return;
            }
            this.f783a |= 1 << i;
        }

        public String toString() {
            if (this.f784b == null) {
                return Long.toBinaryString(this.f783a);
            }
            return this.f784b.toString() + "xx" + Long.toBinaryString(this.f783a);
        }
    }

    /* renamed from: K6$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0249b {
    }

    public C0247K6(InterfaceC0249b interfaceC0249b) {
        this.f780a = interfaceC0249b;
    }

    /* renamed from: a */
    public void m2255a(View view, int i, boolean z) {
        int m2250f;
        if (i < 0) {
            m2250f = ((RecyclerView.C0830e) this.f780a).m1385b();
        } else {
            m2250f = m2250f(i);
        }
        this.f781b.m2238e(m2250f, z);
        if (z) {
            m2247i(view);
        }
        RecyclerView.C0830e c0830e = (RecyclerView.C0830e) this.f780a;
        RecyclerView.this.addView(view, m2250f);
        RecyclerView.this.dispatchChildAttached(view);
    }

    /* renamed from: b */
    public void m2254b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int m2250f;
        if (i < 0) {
            m2250f = ((RecyclerView.C0830e) this.f780a).m1385b();
        } else {
            m2250f = m2250f(i);
        }
        this.f781b.m2238e(m2250f, z);
        if (z) {
            m2247i(view);
        }
        RecyclerView.C0830e c0830e = (RecyclerView.C0830e) this.f780a;
        Objects.requireNonNull(c0830e);
        RecyclerView.AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            if (!childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(outline.m276E(RecyclerView.this, sb));
            }
            childViewHolderInt.clearTmpDetachFlag();
        }
        RecyclerView.this.attachViewToParent(view, m2250f, layoutParams);
    }

    /* renamed from: c */
    public void m2253c(int i) {
        RecyclerView.AbstractC0824B childViewHolderInt;
        int m2250f = m2250f(i);
        this.f781b.m2237f(m2250f);
        RecyclerView.C0830e c0830e = (RecyclerView.C0830e) this.f780a;
        View childAt = RecyclerView.this.getChildAt(m2250f);
        if (childAt != null && (childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt)) != null) {
            if (childViewHolderInt.isTmpDetached() && !childViewHolderInt.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("called detach on an already detached child ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(outline.m276E(RecyclerView.this, sb));
            }
            childViewHolderInt.addFlags(256);
        }
        RecyclerView.this.detachViewFromParent(m2250f);
    }

    /* renamed from: d */
    public View m2252d(int i) {
        return ((RecyclerView.C0830e) this.f780a).m1386a(m2250f(i));
    }

    /* renamed from: e */
    public int m2251e() {
        return ((RecyclerView.C0830e) this.f780a).m1385b() - this.f782c.size();
    }

    /* renamed from: f */
    public final int m2250f(int i) {
        if (i < 0) {
            return -1;
        }
        int m1385b = ((RecyclerView.C0830e) this.f780a).m1385b();
        int i2 = i;
        while (i2 < m1385b) {
            int m2241b = i - (i2 - this.f781b.m2241b(i2));
            if (m2241b == 0) {
                while (this.f781b.m2239d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += m2241b;
        }
        return -1;
    }

    /* renamed from: g */
    public View m2249g(int i) {
        return RecyclerView.this.getChildAt(i);
    }

    /* renamed from: h */
    public int m2248h() {
        return ((RecyclerView.C0830e) this.f780a).m1385b();
    }

    /* renamed from: i */
    public final void m2247i(View view) {
        this.f782c.add(view);
        RecyclerView.C0830e c0830e = (RecyclerView.C0830e) this.f780a;
        Objects.requireNonNull(c0830e);
        RecyclerView.AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
        }
    }

    /* renamed from: j */
    public int m2246j(View view) {
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        if (indexOfChild == -1 || this.f781b.m2239d(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.f781b.m2241b(indexOfChild);
    }

    /* renamed from: k */
    public boolean m2245k(View view) {
        return this.f782c.contains(view);
    }

    /* renamed from: l */
    public void m2244l(int i) {
        int m2250f = m2250f(i);
        View m1386a = ((RecyclerView.C0830e) this.f780a).m1386a(m2250f);
        if (m1386a == null) {
            return;
        }
        if (this.f781b.m2237f(m2250f)) {
            m2243m(m1386a);
        }
        ((RecyclerView.C0830e) this.f780a).m1384c(m2250f);
    }

    /* renamed from: m */
    public final boolean m2243m(View view) {
        if (this.f782c.remove(view)) {
            RecyclerView.C0830e c0830e = (RecyclerView.C0830e) this.f780a;
            Objects.requireNonNull(c0830e);
            RecyclerView.AbstractC0824B childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
                return true;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return this.f781b.toString() + ", hidden list:" + this.f782c.size();
    }
}
