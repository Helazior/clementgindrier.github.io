package p000;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import p000.C0471U5;

/* renamed from: T5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class RunnableC0453T5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ AbstractC0589Z5 f1559a;

    /* renamed from: b */
    public final /* synthetic */ C2339x1 f1560b;

    /* renamed from: c */
    public final /* synthetic */ Object f1561c;

    /* renamed from: d */
    public final /* synthetic */ C0471U5.C0472a f1562d;

    /* renamed from: f */
    public final /* synthetic */ ArrayList f1563f;

    /* renamed from: g */
    public final /* synthetic */ View f1564g;

    /* renamed from: h */
    public final /* synthetic */ Fragment f1565h;

    /* renamed from: i */
    public final /* synthetic */ Fragment f1566i;

    /* renamed from: j */
    public final /* synthetic */ boolean f1567j;

    /* renamed from: k */
    public final /* synthetic */ ArrayList f1568k;

    /* renamed from: l */
    public final /* synthetic */ Object f1569l;

    /* renamed from: m */
    public final /* synthetic */ Rect f1570m;

    public RunnableC0453T5(AbstractC0589Z5 abstractC0589Z5, C2339x1 c2339x1, Object obj, C0471U5.C0472a c0472a, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f1559a = abstractC0589Z5;
        this.f1560b = c2339x1;
        this.f1561c = obj;
        this.f1562d = c0472a;
        this.f1563f = arrayList;
        this.f1564g = view;
        this.f1565h = fragment;
        this.f1566i = fragment2;
        this.f1567j = z;
        this.f1568k = arrayList2;
        this.f1569l = obj2;
        this.f1570m = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2339x1<String, View> m1994e = C0471U5.m1994e(this.f1559a, this.f1560b, this.f1561c, this.f1562d);
        if (m1994e != null) {
            this.f1563f.addAll(m1994e.values());
            this.f1563f.add(this.f1564g);
        }
        C0471U5.m1996c(this.f1565h, this.f1566i, this.f1567j, m1994e, false);
        Object obj = this.f1561c;
        if (obj != null) {
            this.f1559a.mo152u(obj, this.f1568k, this.f1563f);
            View m1988k = C0471U5.m1988k(m1994e, this.f1562d, this.f1569l, this.f1567j);
            if (m1988k != null) {
                this.f1559a.m1744j(m1988k, this.f1570m);
            }
        }
    }
}
