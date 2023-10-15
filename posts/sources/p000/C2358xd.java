package p000;

import android.content.Context;
import android.content.Intent;
import fr.smoney.android.izly.p005ui.privateview.useraccount.eventlist.EventListActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: xd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2357xd implements InterfaceC1879hd {

    /* renamed from: a */
    public final /* synthetic */ EventListActivity f6846a;

    public C2357xd(EventListActivity eventListActivity) {
        this.f6846a = eventListActivity;
    }

    @Override // p000.InterfaceC1879hd
    /* renamed from: a */
    public void mo2a(@NotNull Context context, @Nullable Intent intent) {
        C0581Yd.m1766e(context, "context");
        C0581Yd.m1768c(intent);
        if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
            EventListActivity eventListActivity = this.f6846a;
            if (eventListActivity.f4889B) {
                return;
            }
            EventListActivity.m852L(eventListActivity, 0, 0, true, true, 3);
        }
    }
}
