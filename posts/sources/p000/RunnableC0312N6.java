package p000;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* renamed from: N6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC0312N6 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ArrayList f1028a;

    /* renamed from: b */
    public final /* synthetic */ C0454T6 f1029b;

    public RunnableC0312N6(C0454T6 c0454t6, ArrayList arrayList) {
        this.f1029b = c0454t6;
        this.f1028a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f1028a.iterator();
        while (it.hasNext()) {
            RecyclerView.AbstractC0824B abstractC0824B = (RecyclerView.AbstractC0824B) it.next();
            C0454T6 c0454t6 = this.f1029b;
            Objects.requireNonNull(c0454t6);
            View view = abstractC0824B.itemView;
            ViewPropertyAnimator animate = view.animate();
            c0454t6.f1579o.add(abstractC0824B);
            animate.alpha(1.0f).setDuration(c0454t6.f3230c).setListener(new C0354P6(c0454t6, abstractC0824B, view, animate)).start();
        }
        this.f1028a.clear();
        this.f1029b.f1576l.remove(this.f1028a);
    }
}
