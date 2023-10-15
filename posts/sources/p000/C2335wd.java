package p000;

import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.p005ui.privateview.useraccount.eventlist.EventListActivity;
import org.jetbrains.annotations.NotNull;

/* renamed from: wd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2334wd extends RecyclerView.AbstractC0851s {

    /* renamed from: a */
    public final /* synthetic */ EventListActivity f6793a;

    public C2334wd(EventListActivity eventListActivity) {
        this.f6793a = eventListActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0851s
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        C0479U8 c0479u8;
        C0581Yd.m1766e(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (recyclerView.canScrollVertically(1) || (c0479u8 = SmoneyApplication.f4205d) == null || c0479u8.f1728j == null) {
            return;
        }
        EventListActivity eventListActivity = this.f6793a;
        if (eventListActivity.f4889B) {
            return;
        }
        eventListActivity.f4890C = true;
        if (!eventListActivity.f4197r.m112k(23)) {
            EventListActivity eventListActivity2 = this.f6793a;
            if (!eventListActivity2.f4889B) {
                EventListActivity.m852L(eventListActivity2, 0, 0, false, false, 3);
                return;
            }
        }
        EventListActivity eventListActivity3 = this.f6793a;
        if (!eventListActivity3.f4891D || eventListActivity3.f4197r.m112k(23)) {
            return;
        }
        this.f6793a.f4891D = false;
    }
}
