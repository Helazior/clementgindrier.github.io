package fr.smoney.android.izly.data.requestmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.util.SparseArray;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.BalanceData;
import fr.smoney.android.izly.data.model.CardPaymentsData;
import fr.smoney.android.izly.data.model.CbChangeAliasData;
import fr.smoney.android.izly.data.model.CbDeleteData;
import fr.smoney.android.izly.data.model.CheckMoneyInBankAccountData;
import fr.smoney.android.izly.data.model.ChooseDefaultCbData;
import fr.smoney.android.izly.data.model.CounterListData;
import fr.smoney.android.izly.data.model.Event;
import fr.smoney.android.izly.data.model.GetAccountStatementMobileResult;
import fr.smoney.android.izly.data.model.GetActiveMandateData;
import fr.smoney.android.izly.data.model.GetBankAccountData;
import fr.smoney.android.izly.data.model.GetConfidentialitySettingsData;
import fr.smoney.android.izly.data.model.GetContactDetailsData;
import fr.smoney.android.izly.data.model.GetEventList;
import fr.smoney.android.izly.data.model.GetMyCbListData;
import fr.smoney.android.izly.data.model.GetMySupportListData;
import fr.smoney.android.izly.data.model.GetNewsFeedData;
import fr.smoney.android.izly.data.model.HomepageFeedItem;
import fr.smoney.android.izly.data.model.InitiatePasswordRecoveryData;
import fr.smoney.android.izly.data.model.IsEnrollmentOpenData;
import fr.smoney.android.izly.data.model.IsSessionValidData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.LoginLightData;
import fr.smoney.android.izly.data.model.MakeBankAccountUpdateData;
import fr.smoney.android.izly.data.model.MakeMoneyInBankAccountData;
import fr.smoney.android.izly.data.model.MoneyInCbCbListData;
import fr.smoney.android.izly.data.model.MoneyInCbConfirmData;
import fr.smoney.android.izly.data.model.MoneyInCbData;
import fr.smoney.android.izly.data.model.MoneyOutTransferAccountData;
import fr.smoney.android.izly.data.model.MoneyOutTransferConfirmData;
import fr.smoney.android.izly.data.model.MoneyOutTransferData;
import fr.smoney.android.izly.data.model.OAuthData;
import fr.smoney.android.izly.data.model.PaymentInitiationLimits;
import fr.smoney.android.izly.data.model.RemoveDeviceTokenData;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.SetConfidentialitySettingsData;
import fr.smoney.android.izly.data.model.SetDeviceTokenData;
import fr.smoney.android.izly.data.model.Transaction;
import fr.smoney.android.izly.data.model.TransactionListData;
import fr.smoney.android.izly.data.model.UpdatePasswordData;
import fr.smoney.android.izly.data.model.UpdateUserProfileData;
import fr.smoney.android.izly.data.model.UserData;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Objects;
import java.util.Random;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SmoneyRequestManager {

    /* renamed from: g */
    public static final Random f4687g = new Random();

    /* renamed from: a */
    public final SparseArray<Intent> f4688a;

    /* renamed from: b */
    public final Context f4689b;

    /* renamed from: c */
    public final ArrayList<InterfaceC1778a> f4690c;

    /* renamed from: d */
    public final Handler f4691d;

    /* renamed from: e */
    public final EvalReceiver f4692e;

    /* renamed from: f */
    public final C0479U8 f4693f;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class EvalReceiver extends ResultReceiver {
        public EvalReceiver(Handler handler) {
            super(handler);
        }

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            MakeBankAccountUpdateData makeBankAccountUpdateData;
            String str;
            BalanceData balanceData;
            MoneyInCbConfirmData moneyInCbConfirmData;
            MoneyOutTransferConfirmData moneyOutTransferConfirmData;
            SmoneyRequestManager smoneyRequestManager = SmoneyRequestManager.this;
            Objects.requireNonNull(smoneyRequestManager);
            int i2 = bundle.getInt("com.foxykeep.datadroid.extras.requestId");
            Intent intent = smoneyRequestManager.f4688a.get(i2);
            if (intent != null) {
                int intExtra = intent.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1);
                if (i == 0) {
                    if (intExtra == 23) {
                        GetEventList getEventList = (GetEventList) bundle.getParcelable("fr.smoney.android.izly.extras.EventListData");
                        smoneyRequestManager.f4693f.f1730k = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                        if (smoneyRequestManager.f4693f.f1730k == null && getEventList != null) {
                            ArrayList<Event> arrayList = new ArrayList<>();
                            C0479U8 c0479u8 = smoneyRequestManager.f4693f;
                            GetEventList getEventList2 = c0479u8.f1728j;
                            if (getEventList2 != null) {
                                arrayList.addAll(getEventList2.f4332a);
                            } else if (c0479u8.f1712b.f4376p > 0) {
                                C0993c9.m1122a(smoneyRequestManager.f4689b);
                            }
                            arrayList.addAll(getEventList.f4332a);
                            getEventList.f4332a = arrayList;
                            smoneyRequestManager.f4693f.f1728j = getEventList;
                        }
                    } else if (intExtra == 24) {
                        GetAccountStatementMobileResult getAccountStatementMobileResult = (GetAccountStatementMobileResult) bundle.getParcelable("fr.smoney.android.izly.extras.AccountStatementList");
                        smoneyRequestManager.f4693f.f1726i = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                        C0479U8 c0479u82 = smoneyRequestManager.f4693f;
                        if (c0479u82.f1726i == null && getAccountStatementMobileResult != null) {
                            c0479u82.f1724h = getAccountStatementMobileResult;
                        }
                    } else if (intExtra == 81) {
                        smoneyRequestManager.f4693f.f1678A = (CbChangeAliasData) bundle.getParcelable("fr.smoney.android.izly.extras.cbChangeAliasData");
                        smoneyRequestManager.f4693f.f1680B = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                    } else if (intExtra == 82) {
                        smoneyRequestManager.f4693f.f1682C = (CbDeleteData) bundle.getParcelable("fr.smoney.android.izly.extras.cbDeleteData");
                        smoneyRequestManager.f4693f.f1684D = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                    } else if (intExtra == 131) {
                        C0479U8 c0479u83 = smoneyRequestManager.f4693f;
                        SetDeviceTokenData setDeviceTokenData = (SetDeviceTokenData) bundle.getParcelable("fr.smoney.android.izly.extras.setDeviceTokenData");
                        Objects.requireNonNull(c0479u83);
                        C0479U8 c0479u84 = smoneyRequestManager.f4693f;
                        ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                        Objects.requireNonNull(c0479u84);
                    } else if (intExtra != 132) {
                        switch (intExtra) {
                            case 1:
                                smoneyRequestManager.f4693f.f1712b = (LoginData) bundle.getParcelable("fr.smoney.android.izly.extras.loginData");
                                smoneyRequestManager.f4693f.f1714c = (UserData) bundle.getParcelable("fr.smoney.android.izly.extras.userData");
                                smoneyRequestManager.f4693f.f1716d = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                OAuthData oAuthData = (OAuthData) bundle.getParcelable("fr.smoney.android.izly.extras.oAuthData");
                                if (oAuthData != null) {
                                    SmoneyApplication.f4207g.m2495n(oAuthData);
                                    break;
                                }
                                break;
                            case 21:
                                TransactionListData transactionListData = (TransactionListData) bundle.getParcelable("fr.smoney.android.izly.extras.transactionListData");
                                smoneyRequestManager.f4693f.f1722g = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                if (smoneyRequestManager.f4693f.f1722g == null && transactionListData != null) {
                                    ArrayList<Transaction> arrayList2 = new ArrayList<>();
                                    C0479U8 c0479u85 = smoneyRequestManager.f4693f;
                                    TransactionListData transactionListData2 = c0479u85.f1720f;
                                    if (transactionListData2 != null) {
                                        arrayList2.addAll(transactionListData2.f4656b);
                                    } else if (c0479u85.f1712b.f4376p > 0) {
                                        C0993c9.m1122a(smoneyRequestManager.f4689b);
                                    }
                                    arrayList2.addAll(transactionListData.f4656b);
                                    transactionListData.f4656b = arrayList2;
                                    smoneyRequestManager.f4693f.f1720f = transactionListData;
                                    break;
                                }
                                break;
                            case 91:
                                smoneyRequestManager.f4693f.f1686E = (MakeBankAccountUpdateData) bundle.getParcelable("fr.smoney.android.izly.extras.changeTransferAccountData");
                                smoneyRequestManager.f4693f.f1688F = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                C0479U8 c0479u86 = smoneyRequestManager.f4693f;
                                if (c0479u86.f1688F == null && (makeBankAccountUpdateData = c0479u86.f1686E) != null && (str = makeBankAccountUpdateData.f4401l) != null) {
                                    c0479u86.f1712b.f4364c = str;
                                    break;
                                }
                                break;
                            case 161:
                                smoneyRequestManager.f4693f.f1690G = (UpdatePasswordData) bundle.getParcelable("fr.smoney.android.izly.extras.updatePasswordData");
                                smoneyRequestManager.f4693f.f1691H = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                break;
                            case 191:
                                C0479U8 c0479u87 = smoneyRequestManager.f4693f;
                                InitiatePasswordRecoveryData initiatePasswordRecoveryData = (InitiatePasswordRecoveryData) bundle.getParcelable("fr.smoney.android.izly.extras.initiatePasswordRecoveryData");
                                Objects.requireNonNull(c0479u87);
                                smoneyRequestManager.f4693f.f1698O = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                break;
                            case 211:
                                smoneyRequestManager.f4693f.f1699P = (ChooseDefaultCbData) bundle.getParcelable("fr.smoney.android.izly.extras.chooseDefaultIdData");
                                smoneyRequestManager.f4693f.f1700Q = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                break;
                            case 218:
                                smoneyRequestManager.f4693f.f1701R = (IsEnrollmentOpenData) bundle.getParcelable("fr.smoney.android.izly.extras.IsEnrollementOpen");
                                smoneyRequestManager.f4693f.f1702S = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                break;
                            case 232:
                                smoneyRequestManager.f4693f.f1733l0 = (LoginLightData) bundle.getParcelable("fr.smoney.android.izly.extras.LoginLight");
                                smoneyRequestManager.f4693f.f1735m0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                OAuthData oAuthData2 = (OAuthData) bundle.getParcelable("fr.smoney.android.izly.extras.oAuthData");
                                C0479U8 c0479u88 = smoneyRequestManager.f4693f;
                                if (c0479u88.f1735m0 == null) {
                                    if (c0479u88.f1733l0 != null) {
                                        if (c0479u88.f1712b == null) {
                                            c0479u88.f1712b = new LoginData();
                                        }
                                        C0479U8 c0479u89 = smoneyRequestManager.f4693f;
                                        LoginData loginData = c0479u89.f1712b;
                                        LoginLightData loginLightData = c0479u89.f1733l0;
                                        Objects.requireNonNull(loginData);
                                        loginData.f4364c = loginLightData.f4387a;
                                        loginData.f4354G = loginLightData.f4388b;
                                        BalanceData balanceData2 = loginLightData.f4390d;
                                        if (balanceData2 != null) {
                                            loginData.f4351D = balanceData2;
                                        }
                                    }
                                    if (oAuthData2 != null) {
                                        SmoneyApplication.f4207g.m2495n(oAuthData2);
                                        break;
                                    }
                                }
                                break;
                            case 241:
                                smoneyRequestManager.f4693f.f1744r = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                break;
                            case 261:
                                smoneyRequestManager.f4693f.f1721f0 = (CounterListData) bundle.getParcelable("fr.smoney.android.izly.extras.GetMyCounterList");
                                smoneyRequestManager.f4693f.f1723g0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                break;
                            case 269:
                                C0479U8 c0479u810 = smoneyRequestManager.f4693f;
                                ServerError serverError2 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                Objects.requireNonNull(c0479u810);
                                break;
                            default:
                                switch (intExtra) {
                                    case 224:
                                        smoneyRequestManager.f4693f.f1703T = (GetContactDetailsData) bundle.getParcelable("fr.smoney.android.izly.extras.GetContactDetails");
                                        smoneyRequestManager.f4693f.f1704U = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                        break;
                                    case 225:
                                        smoneyRequestManager.f4693f.f1705V = (GetBankAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.getBankAccountData");
                                        smoneyRequestManager.f4693f.f1706W = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                        break;
                                    case 226:
                                        GetNewsFeedData getNewsFeedData = (GetNewsFeedData) bundle.getParcelable("fr.smoney.android.izly.extras.GetNewsFeed");
                                        C0479U8 c0479u811 = smoneyRequestManager.f4693f;
                                        ServerError serverError3 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                        Objects.requireNonNull(c0479u811);
                                        Objects.requireNonNull(smoneyRequestManager.f4693f);
                                        break;
                                    case 227:
                                        GetNewsFeedData getNewsFeedData2 = (GetNewsFeedData) bundle.getParcelable("fr.smoney.android.izly.extras.GetNewsFeed");
                                        ServerError serverError4 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                        if (serverError4 == null && !getNewsFeedData2.f4341g.isEmpty()) {
                                            int ordinal = ((HomepageFeedItem) getNewsFeedData2.f4341g.get(0)).f4344q.ordinal();
                                            if (ordinal != 0) {
                                                if (ordinal != 1) {
                                                    if (ordinal == 2) {
                                                        C0479U8 c0479u812 = smoneyRequestManager.f4693f;
                                                        c0479u812.f1709Z = getNewsFeedData2;
                                                        c0479u812.f1711a0 = serverError4;
                                                        break;
                                                    }
                                                } else {
                                                    C0479U8 c0479u813 = smoneyRequestManager.f4693f;
                                                    c0479u813.f1707X = getNewsFeedData2;
                                                    c0479u813.f1708Y = serverError4;
                                                    break;
                                                }
                                            } else {
                                                C0479U8 c0479u814 = smoneyRequestManager.f4693f;
                                                c0479u814.f1713b0 = getNewsFeedData2;
                                                c0479u814.f1715c0 = serverError4;
                                                break;
                                            }
                                        }
                                        break;
                                    case 228:
                                        smoneyRequestManager.f4693f.f1712b = (LoginData) bundle.getParcelable("fr.smoney.android.izly.extras.GetLogonInfos");
                                        smoneyRequestManager.f4693f.f1716d = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                        break;
                                    case 229:
                                        IsSessionValidData isSessionValidData = (IsSessionValidData) bundle.getParcelable("fr.smoney.android.izly.extras.IsSessionValid");
                                        ServerError serverError5 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                        C0479U8 c0479u815 = smoneyRequestManager.f4693f;
                                        LoginData loginData2 = c0479u815.f1712b;
                                        if (loginData2 != null && serverError5 == null && isSessionValidData != null && (balanceData = isSessionValidData.f4347b) != null) {
                                            loginData2.f4351D = balanceData;
                                        }
                                        if (serverError5 != null || (isSessionValidData != null && !isSessionValidData.f4346a)) {
                                            c0479u815.m1976a();
                                            Intent intent2 = new Intent("fr.smoney.android.izly.notifications.NOTIFICATION_SESSION_STATE_CHANGE_INTENT_URI");
                                            intent2.putExtra("fr.smoney.android.izly.sessionState", 0);
                                            smoneyRequestManager.f4689b.sendBroadcast(intent2);
                                            break;
                                        }
                                    case 230:
                                        smoneyRequestManager.f4693f.f1717d0 = (GetMyCbListData) bundle.getParcelable("fr.smoney.android.izly.extras.GetMyCbList");
                                        smoneyRequestManager.f4693f.f1719e0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                        break;
                                    default:
                                        switch (intExtra) {
                                            case 31:
                                                smoneyRequestManager.f4693f.f1732l = (MoneyInCbCbListData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyInCbCbListData");
                                                smoneyRequestManager.f4693f.f1734m = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                break;
                                            case 32:
                                                smoneyRequestManager.f4693f.f1740p = (MoneyInCbData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyInCbData");
                                                smoneyRequestManager.f4693f.f1742q = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                break;
                                            case 33:
                                                smoneyRequestManager.f4693f.f1746s = (MoneyInCbConfirmData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyInCbConfirmData");
                                                smoneyRequestManager.f4693f.f1748t = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                C0479U8 c0479u816 = smoneyRequestManager.f4693f;
                                                if (c0479u816.f1748t == null && (moneyInCbConfirmData = c0479u816.f1746s) != null) {
                                                    String str2 = moneyInCbConfirmData.f4433i;
                                                    if (str2 != null) {
                                                        c0479u816.f1712b.f4364c = str2;
                                                    }
                                                    C0993c9.m1122a(smoneyRequestManager.f4689b);
                                                    break;
                                                }
                                                break;
                                            case 34:
                                                smoneyRequestManager.f4693f.f1736n = (PaymentInitiationLimits) bundle.getParcelable("fr.smoney.android.izly.extras.PaymentInititationLimits");
                                                smoneyRequestManager.f4693f.f1738o = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                break;
                                            default:
                                                switch (intExtra) {
                                                    case 51:
                                                        smoneyRequestManager.f4693f.f1750u = (MoneyOutTransferAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyOutTransferAccountData");
                                                        smoneyRequestManager.f4693f.f1752v = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                        break;
                                                    case 52:
                                                        smoneyRequestManager.f4693f.f1754w = (MoneyOutTransferData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyOutTransferData");
                                                        smoneyRequestManager.f4693f.f1756x = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                        break;
                                                    case 53:
                                                        smoneyRequestManager.f4693f.f1758y = (MoneyOutTransferConfirmData) bundle.getParcelable("fr.smoney.android.izly.extras.moneyOutTransferConfirmData");
                                                        smoneyRequestManager.f4693f.f1760z = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                        C0479U8 c0479u817 = smoneyRequestManager.f4693f;
                                                        if (c0479u817.f1760z == null && (moneyOutTransferConfirmData = c0479u817.f1758y) != null) {
                                                            String str3 = moneyOutTransferConfirmData.f4451k;
                                                            if (str3 != null) {
                                                                c0479u817.f1712b.f4364c = str3;
                                                            }
                                                            C0993c9.m1122a(smoneyRequestManager.f4689b);
                                                            break;
                                                        }
                                                        break;
                                                    default:
                                                        switch (intExtra) {
                                                            case 171:
                                                                smoneyRequestManager.f4693f.f1692I = (GetConfidentialitySettingsData) bundle.getParcelable("fr.smoney.android.izly.extras.getConfidentialitySettingsData");
                                                                smoneyRequestManager.f4693f.f1693J = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                break;
                                                            case 172:
                                                                smoneyRequestManager.f4693f.f1694K = (SetConfidentialitySettingsData) bundle.getParcelable("fr.smoney.android.izly.extras.setConfidentialitySettingsData");
                                                                smoneyRequestManager.f4693f.f1695L = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                break;
                                                            case 173:
                                                                smoneyRequestManager.f4693f.f1696M = (UpdateUserProfileData) bundle.getParcelable("fr.smoney.android.izly.extras.updateUserProfileData");
                                                                smoneyRequestManager.f4693f.f1697N = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                C0479U8 c0479u818 = smoneyRequestManager.f4693f;
                                                                UpdateUserProfileData updateUserProfileData = c0479u818.f1696M;
                                                                if (updateUserProfileData != null) {
                                                                    c0479u818.f1712b.f4354G = updateUserProfileData.f4664b;
                                                                    break;
                                                                }
                                                                break;
                                                            default:
                                                                switch (intExtra) {
                                                                    case 251:
                                                                        smoneyRequestManager.f4693f.f1725h0 = (GetMySupportListData) bundle.getParcelable("fr.smoney.android.izly.extras.GetMySupportList");
                                                                        smoneyRequestManager.f4693f.f1727i0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                        break;
                                                                    case 252:
                                                                        smoneyRequestManager.f4693f.f1731k0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                        break;
                                                                    case 253:
                                                                        smoneyRequestManager.f4693f.f1729j0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                        break;
                                                                    default:
                                                                        switch (intExtra) {
                                                                            case 263:
                                                                                C0479U8 c0479u819 = smoneyRequestManager.f4693f;
                                                                                CardPaymentsData cardPaymentsData = (CardPaymentsData) bundle.getParcelable("fr.smoney.android.izly.extras.cardPayments");
                                                                                Objects.requireNonNull(c0479u819);
                                                                                C0479U8 c0479u820 = smoneyRequestManager.f4693f;
                                                                                ServerError serverError6 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                                Objects.requireNonNull(c0479u820);
                                                                                break;
                                                                            case 264:
                                                                                smoneyRequestManager.f4693f.f1737n0 = (GetActiveMandateData) bundle.getParcelable("fr.smoney.android.izly.extras.GetActiveMandate");
                                                                                smoneyRequestManager.f4693f.f1739o0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                                break;
                                                                            case 265:
                                                                                smoneyRequestManager.f4693f.f1741p0 = (CheckMoneyInBankAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.CheckMoneyInBankAccount");
                                                                                smoneyRequestManager.f4693f.f1743q0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                                break;
                                                                            case 266:
                                                                                smoneyRequestManager.f4693f.f1745r0 = (MakeMoneyInBankAccountData) bundle.getParcelable("fr.smoney.android.izly.extras.MakeMoneyInBankAccountData");
                                                                                smoneyRequestManager.f4693f.f1747s0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                                break;
                                                                            case 267:
                                                                                smoneyRequestManager.f4693f.f1718e = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                                break;
                                                                            default:
                                                                                switch (intExtra) {
                                                                                    case 278:
                                                                                        smoneyRequestManager.f4693f.f1749t0 = bundle.getString("fr.smoney.android.izly.extras.CheckTerminateContract");
                                                                                        smoneyRequestManager.f4693f.f1751u0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                                        break;
                                                                                    case 279:
                                                                                        smoneyRequestManager.f4693f.f1753v0 = bundle.getString("fr.smoney.android.izly.extras.CheckSendConfirmationCode");
                                                                                        smoneyRequestManager.f4693f.f1755w0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                                        break;
                                                                                    case 280:
                                                                                        smoneyRequestManager.f4693f.f1757x0 = bundle.getString("fr.smoney.android.izly.extras.CheckResendConfirmationCode");
                                                                                        smoneyRequestManager.f4693f.f1759y0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                                        break;
                                                                                    case 281:
                                                                                        smoneyRequestManager.f4693f.f1761z0 = bundle.getString("fr.smoney.android.izly.extras.TerminateContract");
                                                                                        smoneyRequestManager.f4693f.f1679A0 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                                                                                        break;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                                break;
                        }
                    } else {
                        C0479U8 c0479u821 = smoneyRequestManager.f4693f;
                        RemoveDeviceTokenData removeDeviceTokenData = (RemoveDeviceTokenData) bundle.getParcelable("fr.smoney.android.izly.extras.removeDeviceTokenData");
                        Objects.requireNonNull(c0479u821);
                        C0479U8 c0479u822 = smoneyRequestManager.f4693f;
                        ServerError serverError7 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
                        Objects.requireNonNull(c0479u822);
                    }
                } else if (i == -1) {
                    if (bundle.getInt("com.foxykeep.datadroid.extras.error") == 1) {
                        Intent intent3 = new Intent("fr.smoney.android.izly.notifications.NOTIFICATION_SESSION_STATE_CHANGE_INTENT_URI");
                        intent3.putExtra("fr.smoney.android.izly.sessionState", 2);
                        smoneyRequestManager.f4689b.sendBroadcast(intent3);
                    }
                }
                smoneyRequestManager.f4688a.remove(i2);
                synchronized (smoneyRequestManager.f4690c) {
                    for (int i3 = 0; i3 < smoneyRequestManager.f4690c.size(); i3++) {
                        smoneyRequestManager.f4690c.get(i3).mo240g(i2, intExtra, i, bundle);
                    }
                }
            }
        }
    }

    /* renamed from: fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC1778a extends EventListener {
        /* renamed from: g */
        void mo240g(int i, int i2, int i3, Bundle bundle);

        /* renamed from: n */
        void mo235n(int i);
    }

    public SmoneyRequestManager(Context context, C0479U8 c0479u8) {
        this.f4689b = context;
        this.f4693f = c0479u8;
        Handler handler = new Handler();
        this.f4691d = handler;
        this.f4692e = new EvalReceiver(handler);
        this.f4688a = new SparseArray<>();
        this.f4690c = new ArrayList<>();
    }

    /* renamed from: a */
    public void m957a(InterfaceC1778a interfaceC1778a) {
        synchronized (this.f4690c) {
            if (!this.f4690c.contains(interfaceC1778a)) {
                this.f4690c.add(interfaceC1778a);
            }
        }
    }

    /* renamed from: b */
    public final void m956b(Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4689b.startForegroundService(intent);
        } else {
            this.f4689b.startService(intent);
        }
    }

    /* renamed from: c */
    public int m955c(String str, String str2, String str3, String str4, boolean z) {
        int size = this.f4688a.size();
        for (int i = 0; i < size; i++) {
            Intent valueAt = this.f4688a.valueAt(i);
            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 23 && valueAt.getStringExtra("fr.smoney.android.izly.extras.eventListUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.eventListSessionId").equals(str2) && valueAt.getStringExtra("fr.smoney.android.izly.extras.pageNumber") == str3 && valueAt.getStringExtra("fr.smoney.android.izly.extras.itemPerPage") == str4) {
                return this.f4688a.keyAt(i);
            }
        }
        int nextInt = f4687g.nextInt(1000000);
        Intent intent = new Intent(this.f4689b, SmoneyService.class);
        intent.putExtra("com.foxykeep.datadroid.extras.workerType", 23);
        intent.putExtra("com.foxykeep.datadroid.extras.receiver", this.f4692e);
        intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
        intent.putExtra("fr.smoney.android.izly.extras.eventListUserId", str);
        intent.putExtra("fr.smoney.android.izly.extras.eventListSessionId", str2);
        intent.putExtra("fr.smoney.android.izly.extras.pageNumber", str3);
        intent.putExtra("fr.smoney.android.izly.extras.itemPerPage", str4);
        m956b(intent);
        this.f4688a.append(nextInt, intent);
        C0479U8 c0479u8 = this.f4693f;
        c0479u8.f1730k = null;
        if (z) {
            c0479u8.f1728j = null;
        }
        return nextInt;
    }

    /* renamed from: d */
    public int m954d(String str) {
        int size = this.f4688a.size();
        for (int i = 0; i < size; i++) {
            Intent valueAt = this.f4688a.valueAt(i);
            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 228 && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetLogonInfosUserId").equals(str)) {
                return this.f4688a.keyAt(i);
            }
        }
        int nextInt = f4687g.nextInt(1000000);
        Intent intent = new Intent(this.f4689b, SmoneyService.class);
        intent.putExtra("com.foxykeep.datadroid.extras.workerType", 228);
        intent.putExtra("com.foxykeep.datadroid.extras.receiver", this.f4692e);
        intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
        intent.putExtra("fr.smoney.android.izly.extras.GetLogonInfosUserId", str);
        m956b(intent);
        this.f4688a.append(nextInt, intent);
        C0479U8 c0479u8 = this.f4693f;
        c0479u8.f1712b = null;
        c0479u8.f1716d = null;
        return nextInt;
    }

    /* renamed from: e */
    public int m953e(String str, String str2) {
        int size = this.f4688a.size();
        for (int i = 0; i < size; i++) {
            Intent valueAt = this.f4688a.valueAt(i);
            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 230 && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetMyCbListUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.GetMyCbListSessionId").equals(str2)) {
                return this.f4688a.keyAt(i);
            }
        }
        int nextInt = f4687g.nextInt(1000000);
        Intent intent = new Intent(this.f4689b, SmoneyService.class);
        intent.putExtra("com.foxykeep.datadroid.extras.workerType", 230);
        intent.putExtra("com.foxykeep.datadroid.extras.receiver", this.f4692e);
        intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
        intent.putExtra("fr.smoney.android.izly.extras.GetMyCbListUserId", str);
        intent.putExtra("fr.smoney.android.izly.extras.GetMyCbListSessionId", str2);
        m956b(intent);
        this.f4688a.append(nextInt, intent);
        C0479U8 c0479u8 = this.f4693f;
        c0479u8.f1717d0 = null;
        c0479u8.f1719e0 = null;
        return nextInt;
    }

    /* renamed from: f */
    public int m952f(String str, String str2) {
        int size = this.f4688a.size();
        for (int i = 0; i < size; i++) {
            Intent valueAt = this.f4688a.valueAt(i);
            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 229 && valueAt.getStringExtra("fr.smoney.android.izly.extras.IsSessionValidUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.IsSessionValidSessionId").equals(str2)) {
                return this.f4688a.keyAt(i);
            }
        }
        int nextInt = f4687g.nextInt(1000000);
        Intent intent = new Intent(this.f4689b, SmoneyService.class);
        intent.putExtra("com.foxykeep.datadroid.extras.workerType", 229);
        intent.putExtra("com.foxykeep.datadroid.extras.receiver", this.f4692e);
        intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
        intent.putExtra("fr.smoney.android.izly.extras.IsSessionValidUserId", str);
        intent.putExtra("fr.smoney.android.izly.extras.IsSessionValidSessionId", str2);
        m956b(intent);
        this.f4688a.append(nextInt, intent);
        return nextInt;
    }

    /* renamed from: g */
    public int m951g(String str, String str2, boolean z, boolean z2, String str3) {
        int size = this.f4688a.size();
        int i = 0;
        while (i < size) {
            Intent valueAt = this.f4688a.valueAt(i);
            int i2 = size;
            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 1 && valueAt.getStringExtra("fr.smoney.android.izly.extras.loginUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.loginPassword").equals(str2) && valueAt.getIntExtra("fr.smoney.android.izly.extras.loginWithHotp", -1) != z) {
                if (valueAt.getBooleanExtra("fr.smoney.android.izly.extras.loginRooted", false) != z2 && valueAt.getStringExtra("fr.smoney.android.izly.extras.loginActivationCode").equals(str3)) {
                    return this.f4688a.keyAt(i);
                }
            }
            i++;
            size = i2;
        }
        int nextInt = f4687g.nextInt(1000000);
        Intent intent = new Intent(this.f4689b, SmoneyService.class);
        intent.putExtra("com.foxykeep.datadroid.extras.workerType", 1);
        intent.putExtra("com.foxykeep.datadroid.extras.receiver", this.f4692e);
        intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
        intent.putExtra("fr.smoney.android.izly.extras.loginUserId", str);
        intent.putExtra("fr.smoney.android.izly.extras.loginPassword", str2);
        intent.putExtra("fr.smoney.android.izly.extras.loginWithHotp", z ? 1 : 0);
        intent.putExtra("fr.smoney.android.izly.extras.loginRooted", z2);
        intent.putExtra("fr.smoney.android.izly.extras.loginActivationCode", str3);
        m956b(intent);
        this.f4688a.append(nextInt, intent);
        C0479U8 c0479u8 = this.f4693f;
        c0479u8.f1712b = null;
        c0479u8.f1716d = null;
        return nextInt;
    }

    /* renamed from: h */
    public int m950h(String str, String str2) {
        int size = this.f4688a.size();
        for (int i = 0; i < size; i++) {
            Intent valueAt = this.f4688a.valueAt(i);
            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 31 && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyInCbCbListUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.moneyInCbCbListSessionId").equals(str2)) {
                return this.f4688a.keyAt(i);
            }
        }
        int nextInt = f4687g.nextInt(1000000);
        Intent intent = new Intent(this.f4689b, SmoneyService.class);
        intent.putExtra("com.foxykeep.datadroid.extras.workerType", 31);
        intent.putExtra("com.foxykeep.datadroid.extras.receiver", this.f4692e);
        intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
        intent.putExtra("fr.smoney.android.izly.extras.moneyInCbCbListUserId", str);
        intent.putExtra("fr.smoney.android.izly.extras.moneyInCbCbListSessionId", str2);
        m956b(intent);
        this.f4688a.append(nextInt, intent);
        C0479U8 c0479u8 = this.f4693f;
        c0479u8.f1732l = null;
        c0479u8.f1734m = null;
        return nextInt;
    }

    /* renamed from: i */
    public void m949i(InterfaceC1778a interfaceC1778a) {
        synchronized (this.f4690c) {
            this.f4690c.remove(interfaceC1778a);
        }
    }

    /* renamed from: j */
    public int m948j(String str, String str2, long j, int i, int i2, boolean z) {
        int size = this.f4688a.size();
        int i3 = 0;
        while (i3 < size) {
            Intent valueAt = this.f4688a.valueAt(i3);
            int i4 = size;
            if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 21 && valueAt.getStringExtra("fr.smoney.android.izly.extras.transactionListUserId").equals(str) && valueAt.getStringExtra("fr.smoney.android.izly.extras.transactionListSessionId").equals(str2) && valueAt.getLongExtra("fr.smoney.android.izly.extras.transactionListFirstId", -1L) == j && valueAt.getIntExtra("fr.smoney.android.izly.extras.transactionListNbItems", -1) == i && valueAt.getIntExtra("fr.smoney.android.izly.extras.transactionListFilter", -1) == i2) {
                return this.f4688a.keyAt(i3);
            }
            i3++;
            size = i4;
        }
        int nextInt = f4687g.nextInt(1000000);
        Intent intent = new Intent(this.f4689b, SmoneyService.class);
        intent.putExtra("com.foxykeep.datadroid.extras.workerType", 21);
        intent.putExtra("com.foxykeep.datadroid.extras.receiver", this.f4692e);
        intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
        intent.putExtra("fr.smoney.android.izly.extras.transactionListUserId", str);
        intent.putExtra("fr.smoney.android.izly.extras.transactionListSessionId", str2);
        intent.putExtra("fr.smoney.android.izly.extras.transactionListFirstId", j);
        intent.putExtra("fr.smoney.android.izly.extras.transactionListNbItems", i);
        intent.putExtra("fr.smoney.android.izly.extras.transactionListFilter", i2);
        m956b(intent);
        this.f4688a.append(nextInt, intent);
        if (z) {
            this.f4693f.f1720f = null;
        }
        this.f4693f.f1722g = null;
        return nextInt;
    }
}
