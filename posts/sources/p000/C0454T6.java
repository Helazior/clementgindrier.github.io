package p000;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: T6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0454T6 extends AbstractC1681f7 {

    /* renamed from: s */
    public static TimeInterpolator f1571s;

    /* renamed from: h */
    public ArrayList<RecyclerView.AbstractC0824B> f1572h = new ArrayList<>();

    /* renamed from: i */
    public ArrayList<RecyclerView.AbstractC0824B> f1573i = new ArrayList<>();

    /* renamed from: j */
    public ArrayList<C0456b> f1574j = new ArrayList<>();

    /* renamed from: k */
    public ArrayList<C0455a> f1575k = new ArrayList<>();

    /* renamed from: l */
    public ArrayList<ArrayList<RecyclerView.AbstractC0824B>> f1576l = new ArrayList<>();

    /* renamed from: m */
    public ArrayList<ArrayList<C0456b>> f1577m = new ArrayList<>();

    /* renamed from: n */
    public ArrayList<ArrayList<C0455a>> f1578n = new ArrayList<>();

    /* renamed from: o */
    public ArrayList<RecyclerView.AbstractC0824B> f1579o = new ArrayList<>();

    /* renamed from: p */
    public ArrayList<RecyclerView.AbstractC0824B> f1580p = new ArrayList<>();

    /* renamed from: q */
    public ArrayList<RecyclerView.AbstractC0824B> f1581q = new ArrayList<>();

    /* renamed from: r */
    public ArrayList<RecyclerView.AbstractC0824B> f1582r = new ArrayList<>();

    /* renamed from: T6$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0455a {

        /* renamed from: a */
        public RecyclerView.AbstractC0824B f1583a;

        /* renamed from: b */
        public RecyclerView.AbstractC0824B f1584b;

        /* renamed from: c */
        public int f1585c;

        /* renamed from: d */
        public int f1586d;

        /* renamed from: e */
        public int f1587e;

        /* renamed from: f */
        public int f1588f;

        public C0455a(RecyclerView.AbstractC0824B abstractC0824B, RecyclerView.AbstractC0824B abstractC0824B2, int i, int i2, int i3, int i4) {
            this.f1583a = abstractC0824B;
            this.f1584b = abstractC0824B2;
            this.f1585c = i;
            this.f1586d = i2;
            this.f1587e = i3;
            this.f1588f = i4;
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("ChangeInfo{oldHolder=");
            m253r.append(this.f1583a);
            m253r.append(", newHolder=");
            m253r.append(this.f1584b);
            m253r.append(", fromX=");
            m253r.append(this.f1585c);
            m253r.append(", fromY=");
            m253r.append(this.f1586d);
            m253r.append(", toX=");
            m253r.append(this.f1587e);
            m253r.append(", toY=");
            m253r.append(this.f1588f);
            m253r.append('}');
            return m253r.toString();
        }
    }

    /* renamed from: T6$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0456b {

        /* renamed from: a */
        public RecyclerView.AbstractC0824B f1589a;

        /* renamed from: b */
        public int f1590b;

        /* renamed from: c */
        public int f1591c;

        /* renamed from: d */
        public int f1592d;

        /* renamed from: e */
        public int f1593e;

        public C0456b(RecyclerView.AbstractC0824B abstractC0824B, int i, int i2, int i3, int i4) {
            this.f1589a = abstractC0824B;
            this.f1590b = i;
            this.f1591c = i2;
            this.f1592d = i3;
            this.f1593e = i4;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0837l
    /* renamed from: e */
    public void mo1369e(RecyclerView.AbstractC0824B abstractC0824B) {
        View view = abstractC0824B.itemView;
        view.animate().cancel();
        int size = this.f1574j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            } else if (this.f1574j.get(size).f1589a == abstractC0824B) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                m1371c(abstractC0824B);
                this.f1574j.remove(size);
            }
        }
        m2005l(this.f1575k, abstractC0824B);
        if (this.f1572h.remove(abstractC0824B)) {
            view.setAlpha(1.0f);
            m1371c(abstractC0824B);
        }
        if (this.f1573i.remove(abstractC0824B)) {
            view.setAlpha(1.0f);
            m1371c(abstractC0824B);
        }
        for (int size2 = this.f1578n.size() - 1; size2 >= 0; size2--) {
            ArrayList<C0455a> arrayList = this.f1578n.get(size2);
            m2005l(arrayList, abstractC0824B);
            if (arrayList.isEmpty()) {
                this.f1578n.remove(size2);
            }
        }
        for (int size3 = this.f1577m.size() - 1; size3 >= 0; size3--) {
            ArrayList<C0456b> arrayList2 = this.f1577m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                } else if (arrayList2.get(size4).f1589a == abstractC0824B) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    m1371c(abstractC0824B);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f1577m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f1576l.size() - 1; size5 >= 0; size5--) {
            ArrayList<RecyclerView.AbstractC0824B> arrayList3 = this.f1576l.get(size5);
            if (arrayList3.remove(abstractC0824B)) {
                view.setAlpha(1.0f);
                m1371c(abstractC0824B);
                if (arrayList3.isEmpty()) {
                    this.f1576l.remove(size5);
                }
            }
        }
        this.f1581q.remove(abstractC0824B);
        this.f1579o.remove(abstractC0824B);
        this.f1582r.remove(abstractC0824B);
        this.f1580p.remove(abstractC0824B);
        m2006k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0837l
    /* renamed from: f */
    public void mo1368f() {
        int size = this.f1574j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            C0456b c0456b = this.f1574j.get(size);
            View view = c0456b.f1589a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            m1371c(c0456b.f1589a);
            this.f1574j.remove(size);
        }
        int size2 = this.f1572h.size();
        while (true) {
            size2--;
            if (size2 < 0) {
                break;
            }
            m1371c(this.f1572h.get(size2));
            this.f1572h.remove(size2);
        }
        int size3 = this.f1573i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.AbstractC0824B abstractC0824B = this.f1573i.get(size3);
            abstractC0824B.itemView.setAlpha(1.0f);
            m1371c(abstractC0824B);
            this.f1573i.remove(size3);
        }
        int size4 = this.f1575k.size();
        while (true) {
            size4--;
            if (size4 < 0) {
                break;
            }
            C0455a c0455a = this.f1575k.get(size4);
            RecyclerView.AbstractC0824B abstractC0824B2 = c0455a.f1583a;
            if (abstractC0824B2 != null) {
                m2004m(c0455a, abstractC0824B2);
            }
            RecyclerView.AbstractC0824B abstractC0824B3 = c0455a.f1584b;
            if (abstractC0824B3 != null) {
                m2004m(c0455a, abstractC0824B3);
            }
        }
        this.f1575k.clear();
        if (!mo1367g()) {
            return;
        }
        int size5 = this.f1577m.size();
        while (true) {
            size5--;
            if (size5 < 0) {
                break;
            }
            ArrayList<C0456b> arrayList = this.f1577m.get(size5);
            int size6 = arrayList.size();
            while (true) {
                size6--;
                if (size6 >= 0) {
                    C0456b c0456b2 = arrayList.get(size6);
                    View view2 = c0456b2.f1589a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    m1371c(c0456b2.f1589a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f1577m.remove(arrayList);
                    }
                }
            }
        }
        int size7 = this.f1576l.size();
        while (true) {
            size7--;
            if (size7 < 0) {
                break;
            }
            ArrayList<RecyclerView.AbstractC0824B> arrayList2 = this.f1576l.get(size7);
            int size8 = arrayList2.size();
            while (true) {
                size8--;
                if (size8 >= 0) {
                    RecyclerView.AbstractC0824B abstractC0824B4 = arrayList2.get(size8);
                    abstractC0824B4.itemView.setAlpha(1.0f);
                    m1371c(abstractC0824B4);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f1576l.remove(arrayList2);
                    }
                }
            }
        }
        int size9 = this.f1578n.size();
        while (true) {
            size9--;
            if (size9 >= 0) {
                ArrayList<C0455a> arrayList3 = this.f1578n.get(size9);
                int size10 = arrayList3.size();
                while (true) {
                    size10--;
                    if (size10 >= 0) {
                        C0455a c0455a2 = arrayList3.get(size10);
                        RecyclerView.AbstractC0824B abstractC0824B5 = c0455a2.f1583a;
                        if (abstractC0824B5 != null) {
                            m2004m(c0455a2, abstractC0824B5);
                        }
                        RecyclerView.AbstractC0824B abstractC0824B6 = c0455a2.f1584b;
                        if (abstractC0824B6 != null) {
                            m2004m(c0455a2, abstractC0824B6);
                        }
                        if (arrayList3.isEmpty()) {
                            this.f1578n.remove(arrayList3);
                        }
                    }
                }
            } else {
                m2007j(this.f1581q);
                m2007j(this.f1580p);
                m2007j(this.f1579o);
                m2007j(this.f1582r);
                m1370d();
                return;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0837l
    /* renamed from: g */
    public boolean mo1367g() {
        return (this.f1573i.isEmpty() && this.f1575k.isEmpty() && this.f1574j.isEmpty() && this.f1572h.isEmpty() && this.f1580p.isEmpty() && this.f1581q.isEmpty() && this.f1579o.isEmpty() && this.f1582r.isEmpty() && this.f1577m.isEmpty() && this.f1576l.isEmpty() && this.f1578n.isEmpty()) ? false : true;
    }

    @Override // p000.AbstractC1681f7
    /* renamed from: i */
    public boolean mo985i(RecyclerView.AbstractC0824B abstractC0824B, int i, int i2, int i3, int i4) {
        View view = abstractC0824B.itemView;
        int translationX = i + ((int) view.getTranslationX());
        int translationY = i2 + ((int) abstractC0824B.itemView.getTranslationY());
        m2003n(abstractC0824B);
        int i5 = i3 - translationX;
        int i6 = i4 - translationY;
        if (i5 == 0 && i6 == 0) {
            m1371c(abstractC0824B);
            return false;
        }
        if (i5 != 0) {
            view.setTranslationX(-i5);
        }
        if (i6 != 0) {
            view.setTranslationY(-i6);
        }
        this.f1574j.add(new C0456b(abstractC0824B, translationX, translationY, i3, i4));
        return true;
    }

    /* renamed from: j */
    public void m2007j(List<RecyclerView.AbstractC0824B> list) {
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            list.get(size).itemView.animate().cancel();
        }
    }

    /* renamed from: k */
    public void m2006k() {
        if (mo1367g()) {
            return;
        }
        m1370d();
    }

    /* renamed from: l */
    public final void m2005l(List<C0455a> list, RecyclerView.AbstractC0824B abstractC0824B) {
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            C0455a c0455a = list.get(size);
            if (m2004m(c0455a, abstractC0824B) && c0455a.f1583a == null && c0455a.f1584b == null) {
                list.remove(c0455a);
            }
        }
    }

    /* renamed from: m */
    public final boolean m2004m(C0455a c0455a, RecyclerView.AbstractC0824B abstractC0824B) {
        if (c0455a.f1584b == abstractC0824B) {
            c0455a.f1584b = null;
        } else if (c0455a.f1583a != abstractC0824B) {
            return false;
        } else {
            c0455a.f1583a = null;
        }
        abstractC0824B.itemView.setAlpha(1.0f);
        abstractC0824B.itemView.setTranslationX(0.0f);
        abstractC0824B.itemView.setTranslationY(0.0f);
        m1371c(abstractC0824B);
        return true;
    }

    /* renamed from: n */
    public final void m2003n(RecyclerView.AbstractC0824B abstractC0824B) {
        if (f1571s == null) {
            f1571s = new ValueAnimator().getInterpolator();
        }
        abstractC0824B.itemView.animate().setInterpolator(f1571s);
        mo1369e(abstractC0824B);
    }
}
