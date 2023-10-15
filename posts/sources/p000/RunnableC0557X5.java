package p000;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: X5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC0557X5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ArrayList f1993a;

    /* renamed from: b */
    public final /* synthetic */ Map f1994b;

    public RunnableC0557X5(AbstractC0589Z5 abstractC0589Z5, ArrayList arrayList, Map map) {
        this.f1993a = arrayList;
        this.f1994b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int size = this.f1993a.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f1993a.get(i);
            AtomicInteger atomicInteger = C0492V4.f1798a;
            String m1890k = C0492V4.C0500h.m1890k(view);
            if (m1890k != null) {
                Iterator it = this.f1994b.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (m1890k.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                C0492V4.C0500h.m1879v(view, str);
            }
        }
    }
}
