package fr.smoney.android.izly.p005ui.privateview.plus.settings.account.mysupports;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.GetMySupportListData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.LoginLightData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.Support;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0296Md;

/* renamed from: fr.smoney.android.izly.ui.privateview.plus.settings.account.mysupports.ListSupportActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ListSupportActivity extends SmoneyABSActivity<AbstractC2332wb> implements SmoneyRequestManager.InterfaceC1778a {

    /* renamed from: x */
    public C0439Sc f4850x;

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492978;
    }

    /* renamed from: L */
    public final void m873L() {
        int i;
        C2329w8 c2329w8 = this.f4197r;
        C0479U8 c0479u8 = c2329w8.f6816a;
        SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 251 && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetMySupportListUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetMySupportListSessionId").equals(str2)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 251);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.GetMySupportListUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.GetMySupportListSessionId", str2);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1725h0 = null;
                c0479u82.f1727i0 = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 251, true);
    }

    /* renamed from: M */
    public final void m872M(GetMySupportListData getMySupportListData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (getMySupportListData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            ArrayList<Support> arrayList = getMySupportListData.f4335a;
            if (arrayList == null || arrayList.isEmpty()) {
                return;
            }
            RecyclerView recyclerView = ((AbstractC2332wb) this.f4202w).f6789b;
            C0581Yd.m1767d(recyclerView, "mDataBinding.listView");
            recyclerView.setVisibility(0);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
            this.f4850x = new C0439Sc(this, arrayList, this);
            RecyclerView recyclerView2 = ((AbstractC2332wb) this.f4202w).f6789b;
            C0581Yd.m1767d(recyclerView2, "mDataBinding.listView");
            recyclerView2.setLayoutManager(linearLayoutManager);
            RecyclerView recyclerView3 = ((AbstractC2332wb) this.f4202w).f6789b;
            C0581Yd.m1767d(recyclerView3, "mDataBinding.listView");
            recyclerView3.setAdapter(this.f4850x);
            LinearLayout linearLayout = ((AbstractC2332wb) this.f4202w).f6790c;
            C0581Yd.m1767d(linearLayout, "mDataBinding.noSupportsView");
            linearLayout.setVisibility(8);
        }
    }

    /* renamed from: N */
    public final void m871N(LoginLightData loginLightData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (loginLightData == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            m873L();
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        this.f4197r.m108o(i, i2, i3, bundle);
        C0479U8 c0479u8 = this.f4197r.f6816a;
        ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
        if (i2 == 232) {
            m871N(c0479u8.f1733l0, c0479u8.f1735m0);
        } else if (i2 != 251) {
        } else {
            m872M((GetMySupportListData) bundle.getParcelable("fr.smoney.android.izly.extras.GetMySupportList"), serverError);
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        if (i == 232) {
            m871N(c0479u8.f1733l0, c0479u8.f1735m0);
        } else if (i != 251) {
        } else {
            m872M(c0479u8.f1725h0, c0479u8.f1727i0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == 10 && i2 == -1) {
            m873L();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        C0296Md.C0297a c0297a = C0296Md.f999a;
        String string = getString(2131689692);
        C0581Yd.m1767d(string, "getString(R.string.consult_modify_supports)");
        String upperCase = string.toUpperCase();
        C0581Yd.m1767d(upperCase, "(this as java.lang.String).toUpperCase()");
        c0297a.m2194a(this, upperCase, null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_GREY, true, false);
        m873L();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(@Nullable Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        finish();
        return true;
    }
}
