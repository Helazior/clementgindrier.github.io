package p000;

import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.TransactionListData;
import fr.smoney.android.izly.p005ui.privateview.useraccount.history.HistoryActivity;
import org.jetbrains.annotations.NotNull;

/* renamed from: yd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2392yd extends RecyclerView.AbstractC0851s {

    /* renamed from: a */
    public final /* synthetic */ HistoryActivity f6887a;

    public C2392yd(HistoryActivity historyActivity) {
        this.f6887a = historyActivity;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0851s
    public void onScrolled(@NotNull RecyclerView recyclerView, int i, int i2) {
        C0479U8 c0479u8;
        TransactionListData transactionListData;
        C0581Yd.m1766e(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i, i2);
        if (recyclerView.canScrollVertically(1) || (c0479u8 = SmoneyApplication.f4205d) == null || (transactionListData = c0479u8.f1720f) == null) {
            return;
        }
        HistoryActivity historyActivity = this.f6887a;
        if (historyActivity.f4899C) {
            return;
        }
        historyActivity.f4898B = true;
        if (!transactionListData.f4655a) {
            if (historyActivity.f4197r.m112k(21)) {
                return;
            }
            HistoryActivity historyActivity2 = this.f6887a;
            if (historyActivity2.f4899C) {
                return;
            }
            historyActivity2.m850L(false, false);
        } else if (!historyActivity.f4897A || historyActivity.f4197r.m112k(21)) {
        } else {
            this.f6887a.f4897A = false;
        }
    }
}
