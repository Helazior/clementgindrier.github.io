package fr.smoney.android.izly.p005ui.privateview.useraccount.allstatements;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.model.AccountStatement;
import fr.smoney.android.izly.data.model.GetAccountStatementMobileResult;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p000.C0158Gc;

/* renamed from: fr.smoney.android.izly.ui.privateview.useraccount.allstatements.AllStatementsActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AllStatementsActivity extends SmoneyABSActivity<AbstractC2388y9> implements SmoneyRequestManager.InterfaceC1778a, C0158Gc.InterfaceC0159a {

    /* renamed from: C */
    public int f4880C;

    /* renamed from: D */
    public C0158Gc f4881D;

    /* renamed from: E */
    public GetAccountStatementMobileResult f4882E;

    /* renamed from: x */
    public final int f4883x = 1;

    /* renamed from: y */
    public final int f4884y = 2;

    /* renamed from: z */
    public final String f4885z = "intentFilePathPDF";

    /* renamed from: A */
    public final int f4878A = 101;

    /* renamed from: B */
    public final int f4879B = 1000;

    public AllStatementsActivity() {
        C0581Yd.m1767d(Calendar.getInstance(), "Calendar.getInstance()");
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131492898;
    }

    /* renamed from: L */
    public final void m855L(GetAccountStatementMobileResult getAccountStatementMobileResult, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (getAccountStatementMobileResult == null) {
            this.f4197r.m126E(C0580Yc.m1772t(this, this));
        } else {
            this.f4882E = getAccountStatementMobileResult;
            int i = this.f4878A;
            if (C2307w3.m211a(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                m854M();
            } else {
                C1854h3.m783d(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0096  */
    /* renamed from: M */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m854M() {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.privateview.useraccount.allstatements.AllStatementsActivity.m854M():void");
    }

    @Override // p000.C0158Gc.InterfaceC0159a
    /* renamed from: c */
    public void mo853c(@Nullable AccountStatement accountStatement, @NotNull View view) {
        int i;
        AllStatementsActivity allStatementsActivity = this;
        C0581Yd.m1766e(view, "view");
        int i2 = 0;
        allStatementsActivity.f4880C = 0;
        int id = view.getId();
        C0158Gc c0158Gc = allStatementsActivity.f4881D;
        if (c0158Gc != null) {
            AbstractC0376Q9 abstractC0376Q9 = c0158Gc.f505a;
            if (abstractC0376Q9 != null) {
                ImageView imageView = abstractC0376Q9.f1277c;
                C0581Yd.m1767d(imageView, "mAdapter.mDataBinding.ivStatementView");
                if (id == imageView.getId()) {
                    allStatementsActivity.f4880C = allStatementsActivity.f4884y;
                } else {
                    int id2 = view.getId();
                    C0158Gc c0158Gc2 = allStatementsActivity.f4881D;
                    if (c0158Gc2 != null) {
                        AbstractC0376Q9 abstractC0376Q92 = c0158Gc2.f505a;
                        if (abstractC0376Q92 != null) {
                            ImageView imageView2 = abstractC0376Q92.f1276b;
                            C0581Yd.m1767d(imageView2, "mAdapter.mDataBinding.ivStatementDownload");
                            if (id2 == imageView2.getId()) {
                                allStatementsActivity.f4880C = allStatementsActivity.f4883x;
                            }
                        } else {
                            C0581Yd.m1761j("mDataBinding");
                            throw null;
                        }
                    } else {
                        C0581Yd.m1761j("mAdapter");
                        throw null;
                    }
                }
                if (accountStatement != null) {
                    String str = C0581Yd.m1770a(accountStatement.f4215a, CrashlyticsReportDataCapture.SIGNAL_DEFAULT) ? "12" : accountStatement.f4215a;
                    String str2 = accountStatement.f4216b;
                    C2329w8 c2329w8 = allStatementsActivity.f4197r;
                    SmoneyRequestManager smoneyRequestManager = c2329w8.f6817b;
                    LoginData loginData = c2329w8.f6816a.f1712b;
                    String str3 = loginData.f4362a;
                    String str4 = loginData.f4364c;
                    int size = smoneyRequestManager.f4688a.size();
                    while (true) {
                        if (i2 < size) {
                            Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                            int i3 = size;
                            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 24 && valueAt.getStringExtra("fr.smoney.android.izly.extras.accountStatementListUserId").equals(str3) && valueAt.getStringExtra("fr.smoney.android.izly.extras.accountStatementListSessionId").equals(str4) && !valueAt.getStringExtra("fr.smoney.android.izly.extras.accountStatementListMonth").equals(str) && !valueAt.getStringExtra("fr.smoney.android.izly.extras.accountStatementListYear").equals(str2) && !valueAt.getParcelableExtra("fr.smoney.android.izly.extras.accountStatementObject").equals(accountStatement)) {
                                i = smoneyRequestManager.f4688a.keyAt(i2);
                                break;
                            } else {
                                i2++;
                                size = i3;
                            }
                        } else {
                            int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                            Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                            intent.putExtra("com.foxykeep.datadroid.extras.workerType", 24);
                            intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                            intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                            intent.putExtra("fr.smoney.android.izly.extras.accountStatementListUserId", str3);
                            intent.putExtra("fr.smoney.android.izly.extras.accountStatementListSessionId", str4);
                            intent.putExtra("fr.smoney.android.izly.extras.accountStatementListMonth", str);
                            intent.putExtra("fr.smoney.android.izly.extras.accountStatementListYear", str2);
                            intent.putExtra("fr.smoney.android.izly.extras.accountStatementObject", accountStatement);
                            smoneyRequestManager.m956b(intent);
                            smoneyRequestManager.f4688a.append(nextInt, intent);
                            smoneyRequestManager.f4693f.f1726i = null;
                            allStatementsActivity = this;
                            i = nextInt;
                            break;
                        }
                    }
                    allStatementsActivity.f4197r.m120c(i, 24, true);
                    return;
                }
                return;
            }
            C0581Yd.m1761j("mDataBinding");
            throw null;
        }
        C0581Yd.m1761j("mAdapter");
        throw null;
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 24) {
                m855L((GetAccountStatementMobileResult) bundle.getParcelable("fr.smoney.android.izly.extras.AccountStatementList"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @Nullable Bundle bundle) {
        startActivityForResult(new Intent("android.settings.SETTINGS"), this.f4879B);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        if (i == 24) {
            C0479U8 c0479u8 = this.f4197r.f6816a;
            m855L(c0479u8.f1724h, c0479u8.f1726i);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        String valueOf;
        super.onCreate(bundle);
        C0296Md.f999a.m2194a(this, outline.m264g(getString(2131690193), "getString(R.string.statemts_title)", "Locale.getDefault()", "(this as java.lang.String).toUpperCase(locale)"), null, null, EnumC1687fd.LONG_APPBAR_ONLY_TEXT, EnumC0161Gd.COLOR_BLUE, true, (r19 & 128) != 0 ? false : false);
        this.f4881D = new C0158Gc(this, this);
        RecyclerView recyclerView = ((AbstractC2388y9) this.f4202w).f6882c;
        C0581Yd.m1767d(recyclerView, "this");
        C0158Gc c0158Gc = this.f4881D;
        if (c0158Gc != null) {
            recyclerView.setAdapter(c0158Gc);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
            String str = this.f4197r.f6816a.f1712b.f4349B;
            C0581Yd.m1767d(str, "memoryProvider.loginData.dateSubscription");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM", Locale.getDefault());
            Calendar calendar = Calendar.getInstance();
            C0581Yd.m1767d(calendar, "Calendar.getInstance()");
            Calendar calendar2 = Calendar.getInstance();
            C0581Yd.m1767d(calendar2, "Calendar.getInstance()");
            try {
                Date parse = simpleDateFormat.parse(str);
                C0581Yd.m1768c(parse);
                calendar.setTime(parse);
                calendar.add(2, 1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            for (int i = 12; calendar2.after(calendar) && i > 0; i--) {
                String valueOf2 = String.valueOf(calendar2.get(2));
                if (calendar2.get(1) > calendar.get(1) && calendar2.get(2) == 0) {
                    valueOf = String.valueOf(calendar2.get(1) - 1);
                } else {
                    valueOf = String.valueOf(calendar2.get(1));
                }
                calendar2.add(2, -1);
                AccountStatement accountStatement = new AccountStatement();
                C0581Yd.m1766e(valueOf2, "<set-?>");
                accountStatement.f4215a = valueOf2;
                C0581Yd.m1766e(valueOf, "<set-?>");
                accountStatement.f4216b = valueOf;
                C0158Gc c0158Gc2 = this.f4881D;
                if (c0158Gc2 != null) {
                    C0581Yd.m1766e(accountStatement, "item");
                    c0158Gc2.f507c.add(accountStatement);
                } else {
                    C0581Yd.m1761j("mAdapter");
                    throw null;
                }
            }
            C0158Gc c0158Gc3 = this.f4881D;
            if (c0158Gc3 == null) {
                C0581Yd.m1761j("mAdapter");
                throw null;
            } else if (c0158Gc3.getItemCount() == 0) {
                ((AbstractC2388y9) this.f4202w).f6881b.setVisibility(0);
                RecyclerView recyclerView2 = ((AbstractC2388y9) this.f4202w).f6882c;
                C0581Yd.m1767d(recyclerView2, "mDataBinding.rvAllStatements");
                recyclerView2.setVisibility(8);
                return;
            } else {
                return;
            }
        }
        C0581Yd.m1761j("mAdapter");
        throw null;
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, android.app.Activity
    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        C0581Yd.m1766e(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            this.f2196f.m1721a();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, p000.C1854h3.InterfaceC1856b
    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        boolean z;
        C0543Wc m1819s;
        C0581Yd.m1766e(strArr, "permissions");
        C0581Yd.m1766e(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            String str = strArr[i2];
            if (C1880he.m756a(str, "android.permission.WRITE_EXTERNAL_STORAGE", false, 2) && C2307w3.m211a(this, str) != 0) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            String string = getString(2131689791);
            C0581Yd.m1767d(string, "getString(R.string.dialog_warning_title)");
            int i3 = C1854h3.f5137c;
            if (Build.VERSION.SDK_INT >= 23 ? shouldShowRequestPermissionRationale("android.permission.WRITE_EXTERNAL_STORAGE") : false) {
                m1819s = C0543Wc.m1819s(string, getString(2131689778), getResources().getString(2131689765));
                C0581Yd.m1767d(m1819s, "AlertDialogFragment.newI…ing.dialog_button_close))");
            } else {
                m1819s = C0543Wc.m1819s(string, getString(2131689779), getResources().getString(2131689765));
                C0581Yd.m1767d(m1819s, "AlertDialogFragment.newI…ing.dialog_button_close))");
                m1819s.f4164b = this;
            }
            this.f4197r.m126E(m1819s);
        } else if (i == this.f4878A) {
            m854M();
        }
    }
}
