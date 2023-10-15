package p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: y2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2363y2 extends C2248t2 implements InterfaceC2341x2 {

    /* renamed from: I0 */
    public C2248t2[] f6852I0 = new C2248t2[4];

    /* renamed from: J0 */
    public int f6853J0 = 0;

    /* renamed from: V */
    public void m68V(ArrayList<C0348P2> arrayList, int i, C0348P2 c0348p2) {
        for (int i2 = 0; i2 < this.f6853J0; i2++) {
            c0348p2.m2160a(this.f6852I0[i2]);
        }
        for (int i3 = 0; i3 < this.f6853J0; i3++) {
            LayoutInflater$Factory2C0000A.C0010h.m2605x(this.f6852I0[i3], i, arrayList, c0348p2);
        }
    }

    @Override // p000.InterfaceC2341x2
    /* renamed from: a */
    public void mo67a(C2248t2 c2248t2) {
        if (c2248t2 == this || c2248t2 == null) {
            return;
        }
        int i = this.f6853J0 + 1;
        C2248t2[] c2248t2Arr = this.f6852I0;
        if (i > c2248t2Arr.length) {
            this.f6852I0 = (C2248t2[]) Arrays.copyOf(c2248t2Arr, c2248t2Arr.length * 2);
        }
        C2248t2[] c2248t2Arr2 = this.f6852I0;
        int i2 = this.f6853J0;
        c2248t2Arr2[i2] = c2248t2;
        this.f6853J0 = i2 + 1;
    }

    /* renamed from: b */
    public void mo66b(C2269u2 c2269u2) {
    }

    @Override // p000.InterfaceC2341x2
    /* renamed from: c */
    public void mo65c() {
        this.f6853J0 = 0;
        Arrays.fill(this.f6852I0, (Object) null);
    }

    @Override // p000.C2248t2
    /* renamed from: k */
    public void mo64k(C2248t2 c2248t2, HashMap<C2248t2, C2248t2> hashMap) {
        super.mo64k(c2248t2, hashMap);
        C2363y2 c2363y2 = (C2363y2) c2248t2;
        this.f6853J0 = 0;
        int i = c2363y2.f6853J0;
        for (int i2 = 0; i2 < i; i2++) {
            mo67a(hashMap.get(c2363y2.f6852I0[i2]));
        }
    }
}
