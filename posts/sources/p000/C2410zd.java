package p000;

import android.content.Context;
import android.content.Intent;
import fr.smoney.android.izly.p005ui.privateview.useraccount.history.HistoryActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: zd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2409zd implements InterfaceC1879hd {

    /* renamed from: a */
    public final /* synthetic */ HistoryActivity f6935a;

    public C2409zd(HistoryActivity historyActivity) {
        this.f6935a = historyActivity;
    }

    @Override // p000.InterfaceC1879hd
    /* renamed from: a */
    public void mo2a(@NotNull Context context, @Nullable Intent intent) {
        C0581Yd.m1766e(context, "context");
        C0581Yd.m1768c(intent);
        if (intent.getIntExtra("fr.smoney.android.izly.sessionState", -1) == 1) {
            HistoryActivity historyActivity = this.f6935a;
            if (historyActivity.f4899C) {
                return;
            }
            historyActivity.m850L(true, true);
        }
    }
}
