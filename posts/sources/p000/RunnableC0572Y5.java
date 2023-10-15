package p000;

import android.view.View;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: Y5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC0572Y5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ArrayList f2040a;

    /* renamed from: b */
    public final /* synthetic */ Map f2041b;

    public RunnableC0572Y5(AbstractC0589Z5 abstractC0589Z5, ArrayList arrayList, Map map) {
        this.f2040a = arrayList;
        this.f2041b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.f2040a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f2040a.get(i);
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0500h.m1879v(view, (String) this.f2041b.get(C0492V4.C0500h.m1890k(view)));
        }
    }
}
