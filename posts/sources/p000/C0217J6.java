package p000;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import p000.C0573Y6;

/* renamed from: J6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0217J6 implements C0573Y6.InterfaceC0574a {

    /* renamed from: d */
    public final InterfaceC0218a f686d;

    /* renamed from: a */
    public InterfaceC0037B4<C0219b> f683a = new C0056C4(30);

    /* renamed from: b */
    public final ArrayList<C0219b> f684b = new ArrayList<>();

    /* renamed from: c */
    public final ArrayList<C0219b> f685c = new ArrayList<>();

    /* renamed from: f */
    public int f688f = 0;

    /* renamed from: e */
    public final C0573Y6 f687e = new C0573Y6(this);

    /* renamed from: J6$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0218a {
    }

    /* renamed from: J6$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0219b {

        /* renamed from: a */
        public int f689a;

        /* renamed from: b */
        public int f690b;

        /* renamed from: c */
        public Object f691c;

        /* renamed from: d */
        public int f692d;

        public C0219b(int i, int i2, int i3, Object obj) {
            this.f689a = i;
            this.f690b = i2;
            this.f692d = i3;
            this.f691c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0219b.class != obj.getClass()) {
                return false;
            }
            C0219b c0219b = (C0219b) obj;
            int i = this.f689a;
            if (i != c0219b.f689a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f692d - this.f690b) == 1 && this.f692d == c0219b.f690b && this.f690b == c0219b.f692d) {
                return true;
            }
            if (this.f692d == c0219b.f692d && this.f690b == c0219b.f690b) {
                Object obj2 = this.f691c;
                if (obj2 != null) {
                    if (!obj2.equals(c0219b.f691c)) {
                        return false;
                    }
                } else if (c0219b.f691c != null) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.f689a * 31) + this.f690b) * 31) + this.f692d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.f689a;
            sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.f690b);
            sb.append("c:");
            sb.append(this.f692d);
            sb.append(",p:");
            sb.append(this.f691c);
            sb.append("]");
            return sb.toString();
        }
    }

    public C0217J6(InterfaceC0218a interfaceC0218a) {
        this.f686d = interfaceC0218a;
    }

    /* renamed from: a */
    public final boolean m2372a(int i) {
        int size = this.f685c.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0219b c0219b = this.f685c.get(i2);
            int i3 = c0219b.f689a;
            if (i3 == 8) {
                if (m2367f(c0219b.f692d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = c0219b.f690b;
                int i5 = c0219b.f692d + i4;
                while (i4 < i5) {
                    if (m2367f(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m2371b() {
        int size = this.f685c.size();
        for (int i = 0; i < size; i++) {
            ((RecyclerView.C0831f) this.f686d).m1383a(this.f685c.get(i));
        }
        m2361l(this.f685c);
        this.f688f = 0;
    }

    /* renamed from: c */
    public void m2370c() {
        m2371b();
        int size = this.f684b.size();
        for (int i = 0; i < size; i++) {
            C0219b c0219b = this.f684b.get(i);
            int i2 = c0219b.f689a;
            if (i2 == 1) {
                ((RecyclerView.C0831f) this.f686d).m1383a(c0219b);
                RecyclerView.C0831f c0831f = (RecyclerView.C0831f) this.f686d;
                RecyclerView.this.offsetPositionRecordsForInsert(c0219b.f690b, c0219b.f692d);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            } else if (i2 == 2) {
                ((RecyclerView.C0831f) this.f686d).m1383a(c0219b);
                InterfaceC0218a interfaceC0218a = this.f686d;
                int i3 = c0219b.f690b;
                int i4 = c0219b.f692d;
                RecyclerView.C0831f c0831f2 = (RecyclerView.C0831f) interfaceC0218a;
                RecyclerView.this.offsetPositionRecordsForRemove(i3, i4, true);
                RecyclerView recyclerView = RecyclerView.this;
                recyclerView.mItemsAddedOrRemoved = true;
                recyclerView.mState.f3267c += i4;
            } else if (i2 == 4) {
                ((RecyclerView.C0831f) this.f686d).m1383a(c0219b);
                ((RecyclerView.C0831f) this.f686d).m1381c(c0219b.f690b, c0219b.f692d, c0219b.f691c);
            } else if (i2 == 8) {
                ((RecyclerView.C0831f) this.f686d).m1383a(c0219b);
                RecyclerView.C0831f c0831f3 = (RecyclerView.C0831f) this.f686d;
                RecyclerView.this.offsetPositionRecordsForMove(c0219b.f690b, c0219b.f692d);
                RecyclerView.this.mItemsAddedOrRemoved = true;
            }
        }
        m2361l(this.f684b);
        this.f688f = 0;
    }

    /* renamed from: d */
    public final void m2369d(C0219b c0219b) {
        int i;
        int i2 = c0219b.f689a;
        if (i2 != 1 && i2 != 8) {
            int m2360m = m2360m(c0219b.f690b, i2);
            int i3 = c0219b.f690b;
            int i4 = c0219b.f689a;
            if (i4 == 2) {
                i = 0;
            } else if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + c0219b);
            } else {
                i = 1;
            }
            int i5 = 1;
            for (int i6 = 1; i6 < c0219b.f692d; i6++) {
                int m2360m2 = m2360m((i * i6) + c0219b.f690b, c0219b.f689a);
                int i7 = c0219b.f689a;
                if (i7 == 2 ? m2360m2 == m2360m : i7 == 4 && m2360m2 == m2360m + 1) {
                    i5++;
                } else {
                    C0219b m2365h = m2365h(i7, m2360m, i5, c0219b.f691c);
                    m2368e(m2365h, i3);
                    m2362k(m2365h);
                    if (c0219b.f689a == 4) {
                        i3 += i5;
                    }
                    m2360m = m2360m2;
                    i5 = 1;
                }
            }
            Object obj = c0219b.f691c;
            m2362k(c0219b);
            if (i5 > 0) {
                C0219b m2365h2 = m2365h(c0219b.f689a, m2360m, i5, obj);
                m2368e(m2365h2, i3);
                m2362k(m2365h2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    /* renamed from: e */
    public void m2368e(C0219b c0219b, int i) {
        ((RecyclerView.C0831f) this.f686d).m1383a(c0219b);
        int i2 = c0219b.f689a;
        if (i2 != 2) {
            if (i2 == 4) {
                RecyclerView.C0831f c0831f = (RecyclerView.C0831f) this.f686d;
                RecyclerView.this.viewRangeUpdate(i, c0219b.f692d, c0219b.f691c);
                RecyclerView.this.mItemsChanged = true;
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        InterfaceC0218a interfaceC0218a = this.f686d;
        int i3 = c0219b.f692d;
        RecyclerView.C0831f c0831f2 = (RecyclerView.C0831f) interfaceC0218a;
        RecyclerView.this.offsetPositionRecordsForRemove(i, i3, true);
        RecyclerView recyclerView = RecyclerView.this;
        recyclerView.mItemsAddedOrRemoved = true;
        recyclerView.mState.f3267c += i3;
    }

    /* renamed from: f */
    public int m2367f(int i, int i2) {
        int size = this.f685c.size();
        while (i2 < size) {
            C0219b c0219b = this.f685c.get(i2);
            int i3 = c0219b.f689a;
            if (i3 == 8) {
                int i4 = c0219b.f690b;
                if (i4 == i) {
                    i = c0219b.f692d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (c0219b.f692d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = c0219b.f690b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = c0219b.f692d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += c0219b.f692d;
                }
            }
            i2++;
        }
        return i;
    }

    /* renamed from: g */
    public boolean m2366g() {
        return this.f684b.size() > 0;
    }

    /* renamed from: h */
    public C0219b m2365h(int i, int i2, int i3, Object obj) {
        C0219b acquire = this.f683a.acquire();
        if (acquire == null) {
            return new C0219b(i, i2, i3, obj);
        }
        acquire.f689a = i;
        acquire.f690b = i2;
        acquire.f692d = i3;
        acquire.f691c = obj;
        return acquire;
    }

    /* renamed from: i */
    public final void m2364i(C0219b c0219b) {
        this.f685c.add(c0219b);
        int i = c0219b.f689a;
        if (i == 1) {
            InterfaceC0218a interfaceC0218a = this.f686d;
            RecyclerView.C0831f c0831f = (RecyclerView.C0831f) interfaceC0218a;
            RecyclerView.this.offsetPositionRecordsForInsert(c0219b.f690b, c0219b.f692d);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else if (i == 2) {
            InterfaceC0218a interfaceC0218a2 = this.f686d;
            RecyclerView.C0831f c0831f2 = (RecyclerView.C0831f) interfaceC0218a2;
            RecyclerView.this.offsetPositionRecordsForRemove(c0219b.f690b, c0219b.f692d, false);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else if (i == 4) {
            ((RecyclerView.C0831f) this.f686d).m1381c(c0219b.f690b, c0219b.f692d, c0219b.f691c);
        } else if (i == 8) {
            InterfaceC0218a interfaceC0218a3 = this.f686d;
            RecyclerView.C0831f c0831f3 = (RecyclerView.C0831f) interfaceC0218a3;
            RecyclerView.this.offsetPositionRecordsForMove(c0219b.f690b, c0219b.f692d);
            RecyclerView.this.mItemsAddedOrRemoved = true;
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + c0219b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x00a3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0127 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0118 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00d2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ff  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2363j() {
        /*
            Method dump skipped, instructions count: 671
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0217J6.m2363j():void");
    }

    /* renamed from: k */
    public void m2362k(C0219b c0219b) {
        c0219b.f691c = null;
        this.f683a.release(c0219b);
    }

    /* renamed from: l */
    public void m2361l(List<C0219b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            m2362k(list.get(i));
        }
        list.clear();
    }

    /* renamed from: m */
    public final int m2360m(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f685c.size() - 1; size >= 0; size--) {
            C0219b c0219b = this.f685c.get(size);
            int i5 = c0219b.f689a;
            if (i5 == 8) {
                int i6 = c0219b.f690b;
                int i7 = c0219b.f692d;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            c0219b.f690b = i6 + 1;
                            c0219b.f692d = i7 + 1;
                        } else if (i2 == 2) {
                            c0219b.f690b = i6 - 1;
                            c0219b.f692d = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        c0219b.f692d = i7 + 1;
                    } else if (i2 == 2) {
                        c0219b.f692d = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        c0219b.f690b = i6 + 1;
                    } else if (i2 == 2) {
                        c0219b.f690b = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = c0219b.f690b;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= c0219b.f692d;
                    } else if (i5 == 2) {
                        i += c0219b.f692d;
                    }
                } else if (i2 == 1) {
                    c0219b.f690b = i8 + 1;
                } else if (i2 == 2) {
                    c0219b.f690b = i8 - 1;
                }
            }
        }
        for (int size2 = this.f685c.size() - 1; size2 >= 0; size2--) {
            C0219b c0219b2 = this.f685c.get(size2);
            if (c0219b2.f689a == 8) {
                int i9 = c0219b2.f692d;
                if (i9 == c0219b2.f690b || i9 < 0) {
                    this.f685c.remove(size2);
                    m2362k(c0219b2);
                }
            } else if (c0219b2.f692d <= 0) {
                this.f685c.remove(size2);
                m2362k(c0219b2);
            }
        }
        return i;
    }
}
