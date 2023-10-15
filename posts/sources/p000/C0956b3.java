package p000;

import java.util.ArrayList;
import java.util.HashSet;

/* renamed from: b3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0956b3<T> {

    /* renamed from: a */
    public final InterfaceC0037B4<ArrayList<T>> f3677a = new C0056C4(10);

    /* renamed from: b */
    public final C0101E1<T, ArrayList<T>> f3678b = new C0101E1<>();

    /* renamed from: c */
    public final ArrayList<T> f3679c = new ArrayList<>();

    /* renamed from: d */
    public final HashSet<T> f3680d = new HashSet<>();

    /* renamed from: a */
    public final void m1190a(T t, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t)) {
            return;
        }
        if (!hashSet.contains(t)) {
            hashSet.add(t);
            ArrayList<T> arrayList2 = this.f3678b.get(t);
            if (arrayList2 != null) {
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    m1190a(arrayList2.get(i), arrayList, hashSet);
                }
            }
            hashSet.remove(t);
            arrayList.add(t);
            return;
        }
        throw new RuntimeException("This graph contains cyclic dependencies");
    }
}
