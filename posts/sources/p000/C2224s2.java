package p000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import p000.C2168p2;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: s2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2224s2 {

    /* renamed from: b */
    public int f6369b;

    /* renamed from: c */
    public boolean f6370c;

    /* renamed from: d */
    public final C2248t2 f6371d;

    /* renamed from: e */
    public final EnumC2225a f6372e;

    /* renamed from: f */
    public C2224s2 f6373f;

    /* renamed from: i */
    public C2168p2 f6376i;

    /* renamed from: a */
    public HashSet<C2224s2> f6368a = null;

    /* renamed from: g */
    public int f6374g = 0;

    /* renamed from: h */
    public int f6375h = -1;

    /* renamed from: s2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC2225a {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public C2224s2(C2248t2 c2248t2, EnumC2225a enumC2225a) {
        this.f6371d = c2248t2;
        this.f6372e = enumC2225a;
    }

    /* renamed from: a */
    public boolean m414a(C2224s2 c2224s2, int i) {
        return m413b(c2224s2, i, -1, false);
    }

    /* renamed from: b */
    public boolean m413b(C2224s2 c2224s2, int i, int i2, boolean z) {
        if (c2224s2 == null) {
            m404k();
            return true;
        } else if (z || m405j(c2224s2)) {
            this.f6373f = c2224s2;
            if (c2224s2.f6368a == null) {
                c2224s2.f6368a = new HashSet<>();
            }
            HashSet<C2224s2> hashSet = this.f6373f.f6368a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            if (i > 0) {
                this.f6374g = i;
            } else {
                this.f6374g = 0;
            }
            this.f6375h = i2;
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: c */
    public void m412c(int i, ArrayList<C0348P2> arrayList, C0348P2 c0348p2) {
        HashSet<C2224s2> hashSet = this.f6368a;
        if (hashSet != null) {
            Iterator<C2224s2> it = hashSet.iterator();
            while (it.hasNext()) {
                LayoutInflater$Factory2C0000A.C0010h.m2605x(it.next().f6371d, i, arrayList, c0348p2);
            }
        }
    }

    /* renamed from: d */
    public int m411d() {
        if (this.f6370c) {
            return this.f6369b;
        }
        return 0;
    }

    /* renamed from: e */
    public int m410e() {
        C2224s2 c2224s2;
        if (this.f6371d.f6503k0 == 8) {
            return 0;
        }
        int i = this.f6375h;
        return (i <= -1 || (c2224s2 = this.f6373f) == null || c2224s2.f6371d.f6503k0 != 8) ? this.f6374g : i;
    }

    /* renamed from: f */
    public final C2224s2 m409f() {
        switch (this.f6372e.ordinal()) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return this.f6371d.f6464I;
            case 2:
                return this.f6371d.f6465J;
            case 3:
                return this.f6371d.f6460G;
            case 4:
                return this.f6371d.f6462H;
            default:
                throw new AssertionError(this.f6372e.name());
        }
    }

    /* renamed from: g */
    public boolean m408g() {
        HashSet<C2224s2> hashSet = this.f6368a;
        if (hashSet == null) {
            return false;
        }
        Iterator<C2224s2> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().m409f().m406i()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    public boolean m407h() {
        HashSet<C2224s2> hashSet = this.f6368a;
        return hashSet != null && hashSet.size() > 0;
    }

    /* renamed from: i */
    public boolean m406i() {
        return this.f6373f != null;
    }

    /* renamed from: j */
    public boolean m405j(C2224s2 c2224s2) {
        EnumC2225a enumC2225a = EnumC2225a.CENTER_Y;
        EnumC2225a enumC2225a2 = EnumC2225a.CENTER_X;
        EnumC2225a enumC2225a3 = EnumC2225a.BASELINE;
        boolean z = false;
        if (c2224s2 == null) {
            return false;
        }
        EnumC2225a enumC2225a4 = c2224s2.f6372e;
        EnumC2225a enumC2225a5 = this.f6372e;
        if (enumC2225a4 == enumC2225a5) {
            return enumC2225a5 != enumC2225a3 || (c2224s2.f6371d.f6450B && this.f6371d.f6450B);
        }
        switch (enumC2225a5.ordinal()) {
            case 0:
            case 5:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z2 = enumC2225a4 == EnumC2225a.LEFT || enumC2225a4 == EnumC2225a.RIGHT;
                if (c2224s2.f6371d instanceof C2306w2) {
                    return (z2 || enumC2225a4 == enumC2225a2) ? true : true;
                }
                return z2;
            case 2:
            case 4:
                boolean z3 = enumC2225a4 == EnumC2225a.TOP || enumC2225a4 == EnumC2225a.BOTTOM;
                if (c2224s2.f6371d instanceof C2306w2) {
                    return (z3 || enumC2225a4 == enumC2225a) ? true : true;
                }
                return z3;
            case 6:
                return (enumC2225a4 == enumC2225a3 || enumC2225a4 == enumC2225a2 || enumC2225a4 == enumC2225a) ? false : true;
            default:
                throw new AssertionError(this.f6372e.name());
        }
    }

    /* renamed from: k */
    public void m404k() {
        HashSet<C2224s2> hashSet;
        C2224s2 c2224s2 = this.f6373f;
        if (c2224s2 != null && (hashSet = c2224s2.f6368a) != null) {
            hashSet.remove(this);
            if (this.f6373f.f6368a.size() == 0) {
                this.f6373f.f6368a = null;
            }
        }
        this.f6368a = null;
        this.f6373f = null;
        this.f6374g = 0;
        this.f6375h = -1;
        this.f6370c = false;
        this.f6369b = 0;
    }

    /* renamed from: l */
    public void m403l() {
        C2168p2 c2168p2 = this.f6376i;
        if (c2168p2 == null) {
            this.f6376i = new C2168p2(C2168p2.EnumC2169a.UNRESTRICTED);
        } else {
            c2168p2.m455c();
        }
    }

    /* renamed from: m */
    public void m402m(int i) {
        this.f6369b = i;
        this.f6370c = true;
    }

    /* renamed from: n */
    public void m401n(int i) {
        if (m406i()) {
            this.f6375h = i;
        }
    }

    public String toString() {
        return this.f6371d.f6505l0 + ":" + this.f6372e.toString();
    }
}
