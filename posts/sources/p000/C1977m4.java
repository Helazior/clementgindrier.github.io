package p000;

import java.util.ArrayList;
import p000.C1999n4;

/* renamed from: m4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1977m4 implements InterfaceC2365y4<C1999n4.C2000a> {

    /* renamed from: a */
    public final /* synthetic */ String f5491a;

    public C1977m4(String str) {
        this.f5491a = str;
    }

    @Override // p000.InterfaceC2365y4
    /* renamed from: b */
    public void mo59a(C1999n4.C2000a c2000a) {
        synchronized (C1999n4.f5528c) {
            C0101E1<String, ArrayList<InterfaceC2365y4<C1999n4.C2000a>>> c0101e1 = C1999n4.f5529d;
            ArrayList<InterfaceC2365y4<C1999n4.C2000a>> arrayList = c0101e1.get(this.f5491a);
            if (arrayList == null) {
                return;
            }
            c0101e1.remove(this.f5491a);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList.get(i).mo59a(c2000a);
            }
        }
    }
}
