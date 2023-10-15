package p000;

import android.os.Handler;
import p000.C1999n4;

/* renamed from: g4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1835g4 {

    /* renamed from: a */
    public final C2191q4 f5072a;

    /* renamed from: b */
    public final Handler f5073b;

    public C1835g4(C2191q4 c2191q4, Handler handler) {
        this.f5072a = c2191q4;
        this.f5073b = handler;
    }

    /* renamed from: a */
    public void m800a(C1999n4.C2000a c2000a) {
        int i = c2000a.f5531b;
        if (i == 0) {
            this.f5073b.post(new RunnableC1653e4(this, this.f5072a, c2000a.f5530a));
            return;
        }
        this.f5073b.post(new RunnableC1676f4(this, this.f5072a, i));
    }
}
