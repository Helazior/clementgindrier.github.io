package p000;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import p000.C0454T6;

/* renamed from: M6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC0289M6 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ArrayList f968a;

    /* renamed from: b */
    public final /* synthetic */ C0454T6 f969b;

    public RunnableC0289M6(C0454T6 c0454t6, ArrayList arrayList) {
        this.f969b = c0454t6;
        this.f968a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f968a.iterator();
        while (it.hasNext()) {
            C0454T6.C0455a c0455a = (C0454T6.C0455a) it.next();
            C0454T6 c0454t6 = this.f969b;
            Objects.requireNonNull(c0454t6);
            RecyclerView.AbstractC0824B abstractC0824B = c0455a.f1583a;
            View view = abstractC0824B == null ? null : abstractC0824B.itemView;
            RecyclerView.AbstractC0824B abstractC0824B2 = c0455a.f1584b;
            View view2 = abstractC0824B2 != null ? abstractC0824B2.itemView : null;
            if (view != null) {
                ViewPropertyAnimator duration = view.animate().setDuration(c0454t6.f3233f);
                c0454t6.f1582r.add(c0455a.f1583a);
                duration.translationX(c0455a.f1587e - c0455a.f1585c);
                duration.translationY(c0455a.f1588f - c0455a.f1586d);
                duration.alpha(0.0f).setListener(new C0398R6(c0454t6, c0455a, duration, view)).start();
            }
            if (view2 != null) {
                ViewPropertyAnimator animate = view2.animate();
                c0454t6.f1582r.add(c0455a.f1584b);
                animate.translationX(0.0f).translationY(0.0f).setDuration(c0454t6.f3233f).alpha(1.0f).setListener(new C0433S6(c0454t6, c0455a, animate, view2)).start();
            }
        }
        this.f968a.clear();
        this.f969b.f1578n.remove(this.f968a);
    }
}
