package p000;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import p000.C0454T6;

/* renamed from: L6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC0270L6 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ ArrayList f894a;

    /* renamed from: b */
    public final /* synthetic */ C0454T6 f895b;

    public RunnableC0270L6(C0454T6 c0454t6, ArrayList arrayList) {
        this.f895b = c0454t6;
        this.f894a = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.f894a.iterator();
        while (it.hasNext()) {
            C0454T6.C0456b c0456b = (C0454T6.C0456b) it.next();
            C0454T6 c0454t6 = this.f895b;
            RecyclerView.AbstractC0824B abstractC0824B = c0456b.f1589a;
            int i = c0456b.f1590b;
            int i2 = c0456b.f1591c;
            int i3 = c0456b.f1592d;
            int i4 = c0456b.f1593e;
            Objects.requireNonNull(c0454t6);
            View view = abstractC0824B.itemView;
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (i5 != 0) {
                view.animate().translationX(0.0f);
            }
            if (i6 != 0) {
                view.animate().translationY(0.0f);
            }
            ViewPropertyAnimator animate = view.animate();
            c0454t6.f1580p.add(abstractC0824B);
            animate.setDuration(c0454t6.f3232e).setListener(new C0373Q6(c0454t6, abstractC0824B, i5, view, i6, animate)).start();
        }
        this.f894a.clear();
        this.f895b.f1577m.remove(this.f894a);
    }
}
