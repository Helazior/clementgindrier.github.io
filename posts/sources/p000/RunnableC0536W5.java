package p000;

import android.view.View;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: W5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC0536W5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f1891a;

    /* renamed from: b */
    public final /* synthetic */ ArrayList f1892b;

    /* renamed from: c */
    public final /* synthetic */ ArrayList f1893c;

    /* renamed from: d */
    public final /* synthetic */ ArrayList f1894d;

    /* renamed from: f */
    public final /* synthetic */ ArrayList f1895f;

    public RunnableC0536W5(AbstractC0589Z5 abstractC0589Z5, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f1891a = i;
        this.f1892b = arrayList;
        this.f1893c = arrayList2;
        this.f1894d = arrayList3;
        this.f1895f = arrayList4;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f1891a; i++) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0500h.m1879v((View) this.f1892b.get(i), (String) this.f1893c.get(i));
            C0492V4.C0500h.m1879v((View) this.f1894d.get(i), (String) this.f1895f.get(i));
        }
    }
}
