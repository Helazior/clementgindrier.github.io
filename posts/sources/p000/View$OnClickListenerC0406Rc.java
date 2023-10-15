package p000;

import android.content.Intent;
import android.view.View;
import fr.smoney.android.izly.data.model.Support;
import fr.smoney.android.izly.p005ui.privateview.plus.settings.account.mysupports.DetailSupportActivity;
import p000.C0439Sc;

/* renamed from: Rc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class View$OnClickListenerC0406Rc implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ C0439Sc.C0440a f1366a;

    /* renamed from: b */
    public final /* synthetic */ Support f1367b;

    public View$OnClickListenerC0406Rc(C0439Sc.C0440a c0440a, Support support) {
        this.f1366a = c0440a;
        this.f1367b = support;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f1366a.f1440b.f1436c, DetailSupportActivity.class);
        intent.putExtra("support_extra", this.f1367b);
        this.f1366a.f1440b.f1438e.startActivityForResult(intent, 10);
        this.f1366a.f1440b.notifyDataSetChanged();
    }
}
