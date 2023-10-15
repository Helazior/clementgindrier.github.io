package p000;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: P2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0348P2 {

    /* renamed from: f */
    public static int f1179f;

    /* renamed from: b */
    public int f1181b;

    /* renamed from: c */
    public int f1182c;

    /* renamed from: a */
    public ArrayList<C2248t2> f1180a = new ArrayList<>();

    /* renamed from: d */
    public ArrayList<C0349a> f1183d = null;

    /* renamed from: e */
    public int f1184e = -1;

    /* renamed from: P2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0349a {
        public C0349a(C0348P2 c0348p2, C2248t2 c2248t2, C1953l2 c1953l2, int i) {
            new WeakReference(c2248t2);
            c1953l2.m620o(c2248t2.f6460G);
            c1953l2.m620o(c2248t2.f6462H);
            c1953l2.m620o(c2248t2.f6464I);
            c1953l2.m620o(c2248t2.f6465J);
            c1953l2.m620o(c2248t2.f6466K);
        }
    }

    public C0348P2(int i) {
        this.f1181b = -1;
        this.f1182c = 0;
        int i2 = f1179f;
        f1179f = i2 + 1;
        this.f1181b = i2;
        this.f1182c = i;
    }

    /* renamed from: a */
    public boolean m2160a(C2248t2 c2248t2) {
        if (this.f1180a.contains(c2248t2)) {
            return false;
        }
        this.f1180a.add(c2248t2);
        return true;
    }

    /* renamed from: b */
    public void m2159b(ArrayList<C0348P2> arrayList) {
        int size = this.f1180a.size();
        if (this.f1184e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0348P2 c0348p2 = arrayList.get(i);
                if (this.f1184e == c0348p2.f1181b) {
                    m2157d(this.f1182c, c0348p2);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    /* renamed from: c */
    public int m2158c(C1953l2 c1953l2, int i) {
        int m620o;
        int m620o2;
        if (this.f1180a.size() == 0) {
            return 0;
        }
        ArrayList<C2248t2> arrayList = this.f1180a;
        C2269u2 c2269u2 = (C2269u2) arrayList.get(0).f6474S;
        c1953l2.m614u();
        c2269u2.mo214f(c1953l2, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).mo214f(c1953l2, false);
        }
        if (i == 0 && c2269u2.f6612Q0 > 0) {
            LayoutInflater$Factory2C0000A.C0010h.m2649b(c2269u2, c1953l2, arrayList, 0);
        }
        if (i == 1 && c2269u2.f6613R0 > 0) {
            LayoutInflater$Factory2C0000A.C0010h.m2649b(c2269u2, c1953l2, arrayList, 1);
        }
        try {
            c1953l2.m618q();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f1183d = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.f1183d.add(new C0349a(this, arrayList.get(i3), c1953l2, i));
        }
        if (i == 0) {
            m620o = c1953l2.m620o(c2269u2.f6460G);
            m620o2 = c1953l2.m620o(c2269u2.f6464I);
            c1953l2.m614u();
        } else {
            m620o = c1953l2.m620o(c2269u2.f6462H);
            m620o2 = c1953l2.m620o(c2269u2.f6465J);
            c1953l2.m614u();
        }
        return m620o2 - m620o;
    }

    /* renamed from: d */
    public void m2157d(int i, C0348P2 c0348p2) {
        Iterator<C2248t2> it = this.f1180a.iterator();
        while (it.hasNext()) {
            C2248t2 next = it.next();
            c0348p2.m2160a(next);
            if (i == 0) {
                next.f6461G0 = c0348p2.f1181b;
            } else {
                next.f6463H0 = c0348p2.f1181b;
            }
        }
        this.f1184e = c0348p2.f1181b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.f1182c;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String m263h = outline.m263h(sb, this.f1181b, "] <");
        Iterator<C2248t2> it = this.f1180a.iterator();
        while (it.hasNext()) {
            StringBuilder m252s = outline.m252s(m263h, " ");
            m252s.append(it.next().f6505l0);
            m263h = m252s.toString();
        }
        return outline.m266e(m263h, " >");
    }
}
