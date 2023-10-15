package p000;

import android.view.View;
import p000.C0119Ec;

/* renamed from: Fc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class View$OnClickListenerC0139Fc implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ C0119Ec.C0121b f455a;

    /* renamed from: b */
    public final /* synthetic */ EnumC0435S8 f456b;

    public View$OnClickListenerC0139Fc(C0119Ec.C0121b c0121b, EnumC0435S8 enumC0435S8) {
        this.f455a = c0121b;
        this.f456b = enumC0435S8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C0119Ec.InterfaceC0120a interfaceC0120a = this.f455a.f424b.f422a;
        if (interfaceC0120a != null) {
            interfaceC0120a.mo608a(this.f456b);
        }
    }
}
