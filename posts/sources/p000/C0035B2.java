package p000;

import java.util.ArrayList;

/* renamed from: B2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0035B2 extends C2248t2 {

    /* renamed from: I0 */
    public ArrayList<C2248t2> f174I0 = new ArrayList<>();

    @Override // p000.C2248t2
    /* renamed from: G */
    public void mo317G() {
        this.f174I0.clear();
        super.mo317G();
    }

    @Override // p000.C2248t2
    /* renamed from: J */
    public void mo379J(C1934k2 c1934k2) {
        super.mo379J(c1934k2);
        int size = this.f174I0.size();
        for (int i = 0; i < size; i++) {
            this.f174I0.get(i).mo379J(c1934k2);
        }
    }

    /* renamed from: V */
    public void mo315V() {
        ArrayList<C2248t2> arrayList = this.f174I0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            C2248t2 c2248t2 = this.f174I0.get(i);
            if (c2248t2 instanceof C0035B2) {
                ((C0035B2) c2248t2).mo315V();
            }
        }
    }

    /* renamed from: a */
    public void m2561a(C2248t2 c2248t2) {
        this.f174I0.add(c2248t2);
        C2248t2 c2248t22 = c2248t2.f6474S;
        if (c2248t22 != null) {
            ((C0035B2) c2248t22).f174I0.remove(c2248t2);
            c2248t2.f6474S = null;
        }
        c2248t2.f6474S = this;
    }
}
