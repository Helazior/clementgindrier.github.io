package p000;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

/* renamed from: R5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class RunnableC0397R5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Object f1338a;

    /* renamed from: b */
    public final /* synthetic */ AbstractC0589Z5 f1339b;

    /* renamed from: c */
    public final /* synthetic */ View f1340c;

    /* renamed from: d */
    public final /* synthetic */ Fragment f1341d;

    /* renamed from: f */
    public final /* synthetic */ ArrayList f1342f;

    /* renamed from: g */
    public final /* synthetic */ ArrayList f1343g;

    /* renamed from: h */
    public final /* synthetic */ ArrayList f1344h;

    /* renamed from: i */
    public final /* synthetic */ Object f1345i;

    public RunnableC0397R5(Object obj, AbstractC0589Z5 abstractC0589Z5, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f1338a = obj;
        this.f1339b = abstractC0589Z5;
        this.f1340c = view;
        this.f1341d = fragment;
        this.f1342f = arrayList;
        this.f1343g = arrayList2;
        this.f1344h = arrayList3;
        this.f1345i = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.f1338a;
        if (obj != null) {
            this.f1339b.mo159n(obj, this.f1340c);
            this.f1343g.addAll(C0471U5.m1991h(this.f1339b, this.f1338a, this.f1341d, this.f1342f, this.f1340c));
        }
        if (this.f1344h != null) {
            if (this.f1345i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1340c);
                this.f1339b.mo158o(this.f1345i, this.f1344h, arrayList);
            }
            this.f1344h.clear();
            this.f1344h.add(this.f1340c);
        }
    }
}
