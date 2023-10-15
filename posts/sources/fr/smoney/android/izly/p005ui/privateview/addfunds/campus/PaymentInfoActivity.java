package fr.smoney.android.izly.p005ui.privateview.addfunds.campus;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.SmoneyABSActivity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.addfunds.campus.PaymentInfoActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class PaymentInfoActivity extends SmoneyABSActivity<AbstractC0294Mb> {

    /* renamed from: x */
    public C0255Kc f4722x;

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131493037;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("info_extra", -1);
        int intExtra2 = getIntent().getIntExtra("title_extra", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            finish();
        }
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131689582), "getString(R.string.campus_title)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), 2131230939, getString(2131689577), EnumC1687fd.LONG_APPBAR_WITH_DESCRIPTION, EnumC0161Gd.COLOR_BLUE, true, true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f4722x = new C0255Kc(this, EnumC0402R8.values());
        RecyclerView recyclerView = ((AbstractC0294Mb) this.f4202w).f993a;
        C0581Yd.m1767d(recyclerView, "mDataBinding.rvItemsCampus");
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = ((AbstractC0294Mb) this.f4202w).f993a;
        C0581Yd.m1767d(recyclerView2, "mDataBinding.rvItemsCampus");
        recyclerView2.setAdapter(this.f4722x);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return true;
    }
}
