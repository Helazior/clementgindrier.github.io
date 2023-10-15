package p000;

import p000.C0103E3;
import p000.C0213J3;

/* renamed from: f4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC1676f4 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2191q4 f4176a;

    /* renamed from: b */
    public final /* synthetic */ int f4177b;

    public RunnableC1676f4(C1835g4 c1835g4, C2191q4 c2191q4, int i) {
        this.f4176a = c2191q4;
        this.f4177b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2191q4 c2191q4 = this.f4176a;
        int i = this.f4177b;
        C0103E3.AbstractC0106c abstractC0106c = ((C0213J3.C0214a) c2191q4).f680a;
        if (abstractC0106c != null) {
            abstractC0106c.onFontRetrievalFailed(i);
        }
    }
}
