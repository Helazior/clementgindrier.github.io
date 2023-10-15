package p000;

import androidx.recyclerview.widget.RecyclerView;

/* renamed from: i7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1891i7 {

    /* renamed from: a */
    public final C0101E1<RecyclerView.AbstractC0824B, C1892a> f5276a = new C0101E1<>();

    /* renamed from: b */
    public final C0034B1<RecyclerView.AbstractC0824B> f5277b = new C0034B1<>();

    /* renamed from: i7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1892a {

        /* renamed from: d */
        public static InterfaceC0037B4<C1892a> f5278d = new C0056C4(20);

        /* renamed from: a */
        public int f5279a;

        /* renamed from: b */
        public RecyclerView.AbstractC0837l.C0840c f5280b;

        /* renamed from: c */
        public RecyclerView.AbstractC0837l.C0840c f5281c;

        /* renamed from: a */
        public static C1892a m735a() {
            C1892a acquire = f5278d.acquire();
            return acquire == null ? new C1892a() : acquire;
        }

        /* renamed from: b */
        public static void m734b(C1892a c1892a) {
            c1892a.f5279a = 0;
            c1892a.f5280b = null;
            c1892a.f5281c = null;
            f5278d.release(c1892a);
        }
    }

    /* renamed from: i7$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1893b {
    }

    /* renamed from: a */
    public void m742a(RecyclerView.AbstractC0824B abstractC0824B) {
        C1892a c1892a = this.f5276a.get(abstractC0824B);
        if (c1892a == null) {
            c1892a = C1892a.m735a();
            this.f5276a.put(abstractC0824B, c1892a);
        }
        c1892a.f5279a |= 1;
    }

    /* renamed from: b */
    public void m741b(RecyclerView.AbstractC0824B abstractC0824B, RecyclerView.AbstractC0837l.C0840c c0840c) {
        C1892a c1892a = this.f5276a.get(abstractC0824B);
        if (c1892a == null) {
            c1892a = C1892a.m735a();
            this.f5276a.put(abstractC0824B, c1892a);
        }
        c1892a.f5281c = c0840c;
        c1892a.f5279a |= 8;
    }

    /* renamed from: c */
    public void m740c(RecyclerView.AbstractC0824B abstractC0824B, RecyclerView.AbstractC0837l.C0840c c0840c) {
        C1892a c1892a = this.f5276a.get(abstractC0824B);
        if (c1892a == null) {
            c1892a = C1892a.m735a();
            this.f5276a.put(abstractC0824B, c1892a);
        }
        c1892a.f5280b = c0840c;
        c1892a.f5279a |= 4;
    }

    /* renamed from: d */
    public boolean m739d(RecyclerView.AbstractC0824B abstractC0824B) {
        C1892a c1892a = this.f5276a.get(abstractC0824B);
        return (c1892a == null || (c1892a.f5279a & 1) == 0) ? false : true;
    }

    /* renamed from: e */
    public final RecyclerView.AbstractC0837l.C0840c m738e(RecyclerView.AbstractC0824B abstractC0824B, int i) {
        C1892a valueAt;
        RecyclerView.AbstractC0837l.C0840c c0840c;
        int indexOfKey = this.f5276a.indexOfKey(abstractC0824B);
        if (indexOfKey >= 0 && (valueAt = this.f5276a.valueAt(indexOfKey)) != null) {
            int i2 = valueAt.f5279a;
            if ((i2 & i) != 0) {
                int i3 = (~i) & i2;
                valueAt.f5279a = i3;
                if (i == 4) {
                    c0840c = valueAt.f5280b;
                } else if (i == 8) {
                    c0840c = valueAt.f5281c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i3 & 12) == 0) {
                    this.f5276a.removeAt(indexOfKey);
                    C1892a.m734b(valueAt);
                }
                return c0840c;
            }
        }
        return null;
    }

    /* renamed from: f */
    public void m737f(RecyclerView.AbstractC0824B abstractC0824B) {
        C1892a c1892a = this.f5276a.get(abstractC0824B);
        if (c1892a == null) {
            return;
        }
        c1892a.f5279a &= -2;
    }

    /* renamed from: g */
    public void m736g(RecyclerView.AbstractC0824B abstractC0824B) {
        int m2563h = this.f5277b.m2563h() - 1;
        while (true) {
            if (m2563h < 0) {
                break;
            } else if (abstractC0824B == this.f5277b.m2562i(m2563h)) {
                C0034B1<RecyclerView.AbstractC0824B> c0034b1 = this.f5277b;
                Object[] objArr = c0034b1.f172c;
                Object obj = objArr[m2563h];
                Object obj2 = C0034B1.f169f;
                if (obj != obj2) {
                    objArr[m2563h] = obj2;
                    c0034b1.f170a = true;
                }
            } else {
                m2563h--;
            }
        }
        C1892a remove = this.f5276a.remove(abstractC0824B);
        if (remove != null) {
            C1892a.m734b(remove);
        }
    }
}
