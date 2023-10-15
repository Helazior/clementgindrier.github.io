package p000;

import android.view.View;
import fr.smoney.android.izly.data.model.AccountStatement;
import p000.C0158Gc;

/* compiled from: java-style lambda group */
/* renamed from: b */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class View$OnClickListenerC0951b implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ int f3647a;

    /* renamed from: b */
    public final /* synthetic */ Object f3648b;

    /* renamed from: c */
    public final /* synthetic */ Object f3649c;

    public View$OnClickListenerC0951b(int i, Object obj, Object obj2) {
        this.f3647a = i;
        this.f3648b = obj;
        this.f3649c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f3647a;
        if (i == 0) {
            C0581Yd.m1767d(view, "it");
            ((C0158Gc.C0160b) this.f3648b).f510b.f506b.mo853c((AccountStatement) this.f3649c, view);
        } else if (i == 1) {
            C0581Yd.m1767d(view, "it");
            ((C0158Gc.C0160b) this.f3648b).f510b.f506b.mo853c((AccountStatement) this.f3649c, view);
        } else {
            throw null;
        }
    }
}
