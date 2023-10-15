package fr.smoney.android.izly.p005ui.privateview.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import com.google.firebase.messaging.Constants;
import fr.smoney.android.izly.SmoneyABSActivity;
import fr.smoney.android.izly.data.items.KeyValueObject;
import fr.smoney.android.izly.data.model.CheckMoneyInBankAccountData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.MakeMoneyInBankAccountData;
import fr.smoney.android.izly.data.model.MakeMoneyInTiersData;
import fr.smoney.android.izly.data.model.MoneyInCb;
import fr.smoney.android.izly.data.model.MoneyInCbConfirmData;
import fr.smoney.android.izly.data.model.MoneyInCbData;
import fr.smoney.android.izly.data.model.MoneyOutTransferConfirmData;
import fr.smoney.android.izly.data.model.MoneyOutTransferData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import fr.smoney.android.izly.p005ui.privateview.addfunds.cards.CardReloadOldCardStep3Web3DSActivity;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.privateview.home.AllTrxStep2ConfirmActivity */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class AllTrxStep2ConfirmActivity extends SmoneyABSActivity<AbstractC2201qc> implements SmoneyRequestManager.InterfaceC1778a, View.OnClickListener {

    /* renamed from: B */
    public String f4787B;

    /* renamed from: C */
    public AllTrxWorkFlowObject f4788C;

    /* renamed from: D */
    public Object f4789D;

    /* renamed from: E */
    public ArrayList<KeyValueObject> f4790E;

    /* renamed from: x */
    public final String f4791x = "savedStateCurrentPassword";
    @NotNull

    /* renamed from: y */
    public final String f4792y = "fr.smoney.android.izly.extras.trxWorkflowObject";
    @NotNull

    /* renamed from: z */
    public final String f4793z = "fr.smoney.android.izly.extras.trxWorkflowExtraObject";

    /* renamed from: A */
    public int f4786A = 55;

    @Override // fr.smoney.android.izly.SmoneyABSActivity
    /* renamed from: G */
    public int mo836G() {
        return 2131493077;
    }

    /* renamed from: L */
    public final void m904L() {
        int i;
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        CheckMoneyInBankAccountData checkMoneyInBankAccountData = (CheckMoneyInBankAccountData) this.f4789D;
        SmoneyRequestManager smoneyRequestManager = this.f4197r.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        C0581Yd.m1768c(checkMoneyInBankAccountData);
        double d = checkMoneyInBankAccountData.f4242b;
        String str3 = this.f4787B;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 266 && valueAt.getStringExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountAmount").equals(Double.valueOf(d)) && valueAt.getStringExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountAmount").equals(str3)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 266);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountAmount", d);
                intent.putExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountPassword", str3);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                smoneyRequestManager.f4693f.f1741p0 = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 266, true);
    }

    /* renamed from: M */
    public final void m903M() {
        int nextInt;
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        MoneyInCbData moneyInCbData = (MoneyInCbData) this.f4789D;
        SmoneyRequestManager smoneyRequestManager = this.f4197r.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        C0581Yd.m1768c(moneyInCbData);
        MoneyInCb moneyInCb = moneyInCbData.f4434a;
        String str3 = moneyInCb.f4414c.f4418a;
        double d = moneyInCb.f4416f;
        String str4 = this.f4787B;
        int size = smoneyRequestManager.f4688a.size();
        int i = 0;
        while (true) {
            if (i < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i);
                int i2 = size;
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 33 && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmCardId").equals(str3) && valueAt.getDoubleExtra("fr.smoney.android.izly.extras.moneyInCbConfirmAmount", -1.0d) == d && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmPassword").equals(str4)) {
                    nextInt = smoneyRequestManager.f4688a.keyAt(i);
                    break;
                } else {
                    i++;
                    size = i2;
                }
            } else {
                nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 33);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmCardId", str3);
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmAmount", d);
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmPassword", str4);
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmEngagementId", -1L);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1746s = null;
                c0479u82.f1748t = null;
                break;
            }
        }
        this.f4197r.m120c(nextInt, 33, true);
    }

    /* renamed from: N */
    public final void m902N() {
        int i;
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        MakeMoneyInTiersData makeMoneyInTiersData = (MakeMoneyInTiersData) this.f4789D;
        SmoneyRequestManager smoneyRequestManager = this.f4197r.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        C0581Yd.m1768c(makeMoneyInTiersData);
        String str3 = makeMoneyInTiersData.f4407d;
        String valueOf = String.valueOf(makeMoneyInTiersData.f4405b);
        String str4 = makeMoneyInTiersData.f4406c;
        int size = smoneyRequestManager.f4688a.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i2);
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 241 && valueAt.getStringExtra("fr.smoney.android.izly.extras.MoneyInTiersUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.MoneyInTiersSessionId").equals(str2)) {
                    i = smoneyRequestManager.f4688a.keyAt(i2);
                    break;
                }
                i2++;
            } else {
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 241);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.MoneyInTiersUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.MoneyInTiersSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.MoneyInTiersEmail", str3);
                intent.putExtra("fr.smoney.android.izly.extras.MoneyInTiersAmount", valueOf);
                intent.putExtra("fr.smoney.android.izly.extras.MoneyInTiersMessage", str4);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                smoneyRequestManager.f4693f.f1744r = null;
                i = nextInt;
                break;
            }
        }
        this.f4197r.m120c(i, 241, true);
    }

    /* renamed from: O */
    public final void m901O() {
        int nextInt;
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        MoneyOutTransferData moneyOutTransferData = (MoneyOutTransferData) this.f4789D;
        SmoneyRequestManager smoneyRequestManager = this.f4197r.f6817b;
        LoginData loginData = c0479u8.f1712b;
        String str = loginData.f4362a;
        String str2 = loginData.f4364c;
        C0581Yd.m1768c(moneyOutTransferData);
        double d = moneyOutTransferData.f4455d;
        String str3 = this.f4787B;
        int size = smoneyRequestManager.f4688a.size();
        int i = 0;
        while (true) {
            if (i < size) {
                Intent valueAt = smoneyRequestManager.f4688a.valueAt(i);
                int i2 = size;
                if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 53 && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmSessionId").equals(str2) && valueAt.getDoubleExtra("fr.smoney.android.izly.extras.moneyInCbConfirmAmount", -1.0d) == d && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferLabel").equals("") && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmPassword").equals(str3)) {
                    nextInt = smoneyRequestManager.f4688a.keyAt(i);
                    break;
                } else {
                    i++;
                    size = i2;
                }
            } else {
                nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", 53);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmUserId", str);
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmSessionId", str2);
                intent.putExtra("fr.smoney.android.izly.extras.moneyOutTransferLabel", "");
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmAmount", d);
                intent.putExtra("fr.smoney.android.izly.extras.moneyInCbConfirmPassword", str3);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                c0479u82.f1758y = null;
                c0479u82.f1760z = null;
                break;
            }
        }
        this.f4197r.m120c(nextInt, 53, true);
    }

    /* renamed from: P */
    public final void m900P(MakeMoneyInBankAccountData makeMoneyInBankAccountData, ServerError serverError) {
        if (serverError != null) {
            if (serverError.f4601b == 120) {
                this.f4197r.m126E(C0543Wc.m1819s(serverError.f4604f, serverError.f4603d, getString(17039370)));
                return;
            }
            this.f4197r.m124G(serverError);
        } else if (makeMoneyInBankAccountData != null) {
            Intent intent = new Intent(this, AllTrxStep3ResultActivity.class);
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowExtraObject", makeMoneyInBankAccountData);
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowObject", this.f4788C);
            startActivity(intent);
        } else {
            this.f4197r.m126E(C0543Wc.m1819s(getString(2131689771), getString(2131689770), getString(17039370)));
        }
    }

    /* renamed from: Q */
    public final void m899Q(MoneyInCbConfirmData moneyInCbConfirmData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (moneyInCbConfirmData == null) {
            m980J(33);
        } else if (!TextUtils.isEmpty(moneyInCbConfirmData.f4431g) && !TextUtils.isEmpty(moneyInCbConfirmData.f4430f)) {
            Intent intent = new Intent(this, CardReloadOldCardStep3Web3DSActivity.class);
            intent.putExtra("fr.smoney.android.izly.rdParams", moneyInCbConfirmData.f4431g);
            intent.putExtra("fr.smoney.android.izly.rdUrl", moneyInCbConfirmData.f4430f);
            startActivityForResult(intent, this.f4786A);
        } else {
            this.f4197r.f6816a.f1712b.f4351D = moneyInCbConfirmData.f4432h;
            Intent intent2 = new Intent(this, AllTrxStep3ResultActivity.class);
            intent2.putExtra("fr.smoney.android.izly.extras.trxWorkflowExtraObject", moneyInCbConfirmData);
            intent2.putExtra("fr.smoney.android.izly.extras.trxWorkflowObject", this.f4788C);
            startActivity(intent2);
        }
    }

    /* renamed from: R */
    public final void m898R(ServerError serverError) {
        if (serverError != null) {
            if (serverError.f4601b == 120) {
                this.f4197r.m126E(C0543Wc.m1819s(serverError.f4604f, serverError.f4603d, getString(17039370)));
                return;
            }
            this.f4197r.m124G(serverError);
            return;
        }
        Intent intent = new Intent(this, AllTrxStep3ResultActivity.class);
        MakeMoneyInTiersData makeMoneyInTiersData = (MakeMoneyInTiersData) this.f4789D;
        C0581Yd.m1768c(makeMoneyInTiersData);
        makeMoneyInTiersData.f4404a = null;
        intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowExtraObject", makeMoneyInTiersData);
        AllTrxWorkFlowObject allTrxWorkFlowObject = this.f4788C;
        C0581Yd.m1768c(allTrxWorkFlowObject);
        allTrxWorkFlowObject.f4798a = this.f4790E;
        intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowObject", this.f4788C);
        startActivity(intent);
        finish();
    }

    /* renamed from: S */
    public final void m897S(MoneyOutTransferConfirmData moneyOutTransferConfirmData, ServerError serverError) {
        if (serverError != null) {
            this.f4197r.m124G(serverError);
        } else if (moneyOutTransferConfirmData == null) {
            m980J(53);
        } else {
            this.f4197r.f6816a.f1712b.f4351D = moneyOutTransferConfirmData.f4450j;
            Intent intent = new Intent(this, AllTrxStep3ResultActivity.class);
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowExtraObject", moneyOutTransferConfirmData);
            intent.putExtra("fr.smoney.android.izly.extras.trxWorkflowObject", this.f4788C);
            startActivity(intent);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: d */
    public void mo241d(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd == EnumC1631dd.AlertType) {
            AllTrxWorkFlowObject allTrxWorkFlowObject = this.f4788C;
            C0581Yd.m1768c(allTrxWorkFlowObject);
            if (allTrxWorkFlowObject.f4799b == EnumC0115E8.RELOAD_SEPA) {
                this.f4197r.m129B();
            }
        }
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: g */
    public void mo240g(int i, int i2, int i3, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "payload");
        if (this.f4197r.m108o(i, i2, i3, bundle)) {
            ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i2 == 33) {
                m899Q((MoneyInCbConfirmData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyInCbConfirmData"), serverError);
            } else if (i2 == 53) {
                m897S((MoneyOutTransferConfirmData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyOutTransferConfirmData"), serverError);
            } else if (i2 == 232) {
                m904L();
            } else if (i2 == 241) {
                m898R(serverError);
            } else if (i2 != 266) {
            } else {
                m900P((MakeMoneyInBankAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.MakeMoneyInBankAccountData"), serverError);
            }
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: h */
    public void mo239h(@NotNull EnumC1631dd enumC1631dd) {
        C0581Yd.m1766e(enumC1631dd, "dfType");
        if (enumC1631dd != EnumC1631dd.InputPasswordType) {
            this.f4197r.m106q(enumC1631dd);
        }
    }

    @Override // fr.smoney.android.izly.SmoneyABSActivity, p000.AbstractC1668ed.InterfaceC1669a
    /* renamed from: k */
    public void mo238k(@Nullable EnumC1631dd enumC1631dd, @NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        if (enumC1631dd != null) {
            int ordinal = enumC1631dd.ordinal();
            if (ordinal == 7) {
                this.f4787B = bundle.getString("Data.Password");
                AllTrxWorkFlowObject allTrxWorkFlowObject = this.f4788C;
                C0581Yd.m1768c(allTrxWorkFlowObject);
                EnumC0115E8 enumC0115E8 = allTrxWorkFlowObject.f4799b;
                if (enumC0115E8 == null) {
                    return;
                }
                int ordinal2 = enumC0115E8.ordinal();
                if (ordinal2 == 0) {
                    m903M();
                    return;
                } else if (ordinal2 == 1) {
                    m904L();
                    return;
                } else if (ordinal2 != 3) {
                    return;
                } else {
                    m901O();
                    return;
                }
            } else if (ordinal == 9) {
                int m982H = m982H();
                if (m982H == 33) {
                    m903M();
                    return;
                } else if (m982H == 53) {
                    m901O();
                    return;
                } else if (m982H == 241) {
                    m902N();
                    return;
                } else if (m982H != 266) {
                    this.f4197r.m100w(enumC1631dd, bundle);
                    return;
                } else {
                    m904L();
                    return;
                }
            }
        }
        this.f4197r.m100w(enumC1631dd, bundle);
    }

    @Override // fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager.InterfaceC1778a
    /* renamed from: n */
    public void mo235n(int i) {
        C0479U8 c0479u8 = this.f4197r.f6816a;
        C0581Yd.m1767d(c0479u8, "memoryProvider");
        if (i == 33) {
            m899Q(c0479u8.f1746s, c0479u8.f1748t);
        } else if (i == 53) {
            m897S(c0479u8.f1758y, c0479u8.f1760z);
        } else if (i == 232) {
            AllTrxWorkFlowObject allTrxWorkFlowObject = this.f4788C;
            C0581Yd.m1768c(allTrxWorkFlowObject);
            if (allTrxWorkFlowObject.f4799b == EnumC0115E8.RELOAD_SEPA) {
                m904L();
            }
        } else if (i == 241) {
            m898R(c0479u8.f1744r);
        } else if (i != 266) {
        } else {
            m900P(c0479u8.f1745r0, c0479u8.f1747s0);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i == this.f4786A) {
            setResult(-1);
            finish();
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View view) {
        C0581Yd.m1766e(view, "v");
        Object obj = this.f4202w;
        if (view == ((AbstractC2201qc) obj).f6302b) {
            AllTrxWorkFlowObject allTrxWorkFlowObject = this.f4788C;
            C0581Yd.m1768c(allTrxWorkFlowObject);
            if (allTrxWorkFlowObject.f4799b == EnumC0115E8.RELOAD_TIERS) {
                m902N();
                return;
            }
            this.f4197r.m126E(C0617ad.m1725s(this, this));
        } else if (view == ((AbstractC2201qc) obj).f6301a) {
            finish();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x04de  */
    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r24) {
        /*
            Method dump skipped, instructions count: 1285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: fr.smoney.android.izly.p005ui.privateview.home.AllTrxStep2ConfirmActivity.onCreate(android.os.Bundle):void");
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

    @Override // fr.smoney.android.izly.SmoneyABSActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        C0581Yd.m1766e(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putString(this.f4791x, this.f4787B);
    }
}
