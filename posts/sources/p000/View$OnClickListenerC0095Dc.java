package p000;

import android.view.View;
import fr.smoney.android.izly.data.model.ActuDetail;
import p000.C0069Cc;

/* renamed from: Dc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class View$OnClickListenerC0095Dc implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ C0069Cc.C0071b f363a;

    /* renamed from: b */
    public final /* synthetic */ ActuDetail f364b;

    public View$OnClickListenerC0095Dc(C0069Cc.C0071b c0071b, ActuDetail actuDetail) {
        this.f363a = c0071b;
        this.f364b = actuDetail;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f363a.f310b.f306b.mo438j(this.f364b);
    }
}
