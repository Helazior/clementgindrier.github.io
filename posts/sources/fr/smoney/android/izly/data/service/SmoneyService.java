package fr.smoney.android.izly.data.service;

import android.content.Intent;
import android.os.Bundle;
import com.pdfview.subsamplincscaleimageview.SubsamplingScaleImageView;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.AccountStatement;
import fr.smoney.android.izly.data.model.GetNewsFeedData;
import fr.smoney.android.izly.data.model.OAuthData;
import fr.smoney.android.izly.data.model.ServerError;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.kxml2.wap.Wbxml;
import org.xml.sax.SAXException;
import org.xmlpull.p019v1.XmlPullParserException;
import p000.C1663e9;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SmoneyService extends WorkerService {

    /* renamed from: g */
    public static final String f4703g = SmoneyService.class.getSimpleName();

    public SmoneyService() {
        super(1);
    }

    /* renamed from: g */
    public static boolean m946g(int i) {
        return i == 408 || i == 504 || i == 999 || i == 998;
    }

    @Override // fr.smoney.android.izly.data.service.MultiThreadService
    /* renamed from: a */
    public void mo947a(Intent intent) {
        XmlPullParserException xmlPullParserException;
        Bundle bundle;
        SAXException sAXException;
        JSONException jSONException;
        ParserConfigurationException parserConfigurationException;
        RuntimeException runtimeException;
        IOException iOException;
        try {
            try {
                switch (intent.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1)) {
                    case 1:
                        String stringExtra = intent.getStringExtra("fr.smoney.android.izly.extras.loginUserId");
                        String stringExtra2 = intent.getStringExtra("fr.smoney.android.izly.extras.loginPassword");
                        boolean z = true;
                        if (intent.getIntExtra("fr.smoney.android.izly.extras.loginWithHotp", 0) != 1) {
                            z = false;
                        }
                        m940f(intent, C0374Q7.m2115G(stringExtra, stringExtra2, z, intent.getBooleanExtra("fr.smoney.android.izly.extras.loginRooted", false), intent.getStringExtra("fr.smoney.android.izly.extras.loginActivationCode")));
                        return;
                    case 2:
                        C0374Q7.m2113I(intent.getStringExtra("fr.smoney.android.izly.extras.logoutUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.logoutSessionId"));
                        return;
                    case 21:
                        m945h(C0374Q7.m2072w(intent.getStringExtra("fr.smoney.android.izly.extras.transactionListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.transactionListSessionId"), intent.getLongExtra("fr.smoney.android.izly.extras.transactionListFirstId", -1L), intent.getIntExtra("fr.smoney.android.izly.extras.transactionListNbItems", -1), intent.getIntExtra("fr.smoney.android.izly.extras.transactionListFilter", -1)), intent);
                        return;
                    case 23:
                        m945h(C1843g9.m791a(intent.getStringExtra("fr.smoney.android.izly.extras.eventListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.eventListSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.pageNumber"), intent.getStringExtra("fr.smoney.android.izly.extras.itemPerPage")), intent);
                        return;
                    case 24:
                        m945h(C1875h9.m757a(intent.getStringExtra("fr.smoney.android.izly.extras.accountStatementListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.accountStatementListSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.accountStatementListMonth"), intent.getStringExtra("fr.smoney.android.izly.extras.accountStatementListYear"), (AccountStatement) intent.getParcelableExtra("fr.smoney.android.izly.extras.accountStatementObject")), intent);
                        return;
                    case 31:
                        m945h(C0374Q7.m2098X(intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbCbListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbCbListSessionId")), intent);
                        return;
                    case 32:
                        m945h(C0374Q7.m2121A(intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbCardId"), intent.getDoubleExtra("fr.smoney.android.izly.extras.moneyInCbAmount", -1.0d), intent.getLongExtra("fr.smoney.android.izly.extras.moneyInCbEgagementId", -1L)), intent);
                        return;
                    case 33:
                        m945h(C0374Q7.m2120B(intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmCardId"), intent.getDoubleExtra("fr.smoney.android.izly.extras.moneyInCbConfirmAmount", -1.0d), intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmPassword"), intent.getLongExtra("fr.smoney.android.izly.extras.moneyInCbConfirmEngagementId", -1L)), intent);
                        return;
                    case 34:
                        m945h(C1941k9.m677a(intent.getStringExtra("fr.smoney.android.izly.extras.paymentInitiationLimitsUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.paymentInitiationLimitsSessionId")), intent);
                        return;
                    case 51:
                        m945h(C0374Q7.m2097Y(intent.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferAccountUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferAccountSessionId")), intent);
                        return;
                    case 52:
                        m945h(C0374Q7.m2111K(intent.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferSessionId"), intent.getDoubleExtra("fr.smoney.android.izly.extras.moneyOutTransferAmount", -1.0d), intent.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferLabel")), intent);
                        return;
                    case 53:
                        m945h(C0374Q7.m2076s(intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmSessionId"), intent.getDoubleExtra("fr.smoney.android.izly.extras.moneyInCbConfirmAmount", -1.0d), intent.getStringExtra("fr.smoney.android.izly.extras.moneyOutTransferLabel"), intent.getStringExtra("fr.smoney.android.izly.extras.moneyInCbConfirmPassword")), intent);
                        return;
                    case 81:
                        m945h(C0374Q7.m2109M(intent.getStringExtra("fr.smoney.android.izly.extras.cbChangeAliasUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.cbChangeAliasSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.cbChangeAliasCardId"), intent.getStringExtra("fr.smoney.android.izly.extras.cbChangeAliasNewAlias")), intent);
                        return;
                    case 82:
                        m945h(C0374Q7.m2069z(intent.getStringExtra("fr.smoney.android.izly.extras.cbDeleteUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.cbDeleteSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.cbDeletCardId")), intent);
                        return;
                    case 91:
                        m945h(C0374Q7.m2117E(intent.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateAlias"), intent.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateIban"), intent.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdateBic"), intent.getStringExtra("fr.smoney.android.izly.extras.makeBankAccountUpdatePassword")), intent);
                        return;
                    case Wbxml.STR_T /* 131 */:
                        m940f(intent, C1663e9.m992a(this, intent.getStringExtra("fr.smoney.android.izly.extras.setDeviceTokenUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.setDeviceTokenSessionId"), (C1663e9.EnumC1664a) intent.getSerializableExtra("fr.smoney.android.izly.extras.setDeviceTokenType"), intent.getStringExtra("fr.smoney.android.izly.extras.setDeviceTokenToken")));
                        return;
                    case 161:
                        m945h(C0374Q7.m2104R(intent.getStringExtra("fr.smoney.android.izly.extras.updatePasswordUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.updatePasswordSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.updatePasswordNewPassword"), intent.getStringExtra("fr.smoney.android.izly.extras.updatePasswordPassword")), intent);
                        return;
                    case 171:
                        m945h(C0374Q7.m2112J(intent.getStringExtra("fr.smoney.android.izly.extras.getConfidentialitySettingsUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.getConfidentialitySettingsSessionId")), intent);
                        return;
                    case 172:
                        m945h(C0374Q7.m2075t(intent.getStringExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsSessionId"), intent.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsPhoto", -1), intent.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsName", -1), intent.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsPhoneNumber", -1), intent.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsNickname", -1), intent.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsAddress", -1), intent.getIntExtra("fr.smoney.android.izly.extras.setConfidentialitySettingsEmail", -1)), intent);
                        return;
                    case 173:
                        m945h(C0374Q7.m2116F(intent.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileEmail"), intent.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileAddress"), intent.getStringExtra("fr.smoney.android.izly.extras.updateUserProfilePostCode"), intent.getStringExtra("fr.smoney.android.izly.extras.updateUserProfileCity"), intent.getIntExtra("fr.smoney.android.izly.extras.updateUserProfileCountry", 0)), intent);
                        return;
                    case 181:
                        m945h(C0374Q7.m2094a0(intent.getStringExtra("fr.smoney.android.izly.extras.blockAccountUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.blockAccountSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.blockAccountMessage"), intent.getStringExtra("fr.smoney.android.izly.extras.blockAccountPassword")), intent);
                        return;
                    case 191:
                        m940f(intent, C0374Q7.m2114H(intent.getStringExtra("fr.smoney.android.izly.extras.initiatePasswordRecoveryUserId"), intent.getBooleanExtra("fr.smoney.android.izly.extras.initiatePasswordRecoveryUnlockAccount", false)));
                        return;
                    case 211:
                        m945h(C0374Q7.m2110L(intent.getStringExtra("fr.smoney.android.izly.extras.chooseDefaultCbUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.chooseDefaultCbSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.chooseDefaultCbCardId")), intent);
                        return;
                    case 218:
                        m940f(intent, C0374Q7.m2081n());
                        return;
                    case 224:
                        m940f(intent, C0374Q7.m2108N(intent.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsContactId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsLatitude"), intent.getStringExtra("fr.smoney.android.izly.extras.GetContactDetailsLongitude")));
                        return;
                    case 225:
                        m945h(C0374Q7.m2102T(intent.getStringExtra("fr.smoney.android.izly.extras.GetBankAccountUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetBankAccountSessionId")), intent);
                        return;
                    case 226:
                        m945h(C0374Q7.m2074u(intent.getStringExtra("fr.smoney.android.izly.extras.GetNewsFeedUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetNewsFeedSessionId"), intent.getIntExtra("fr.smoney.android.izly.extras.GetNewsFeedCurrentPage", 0), intent.getIntExtra("fr.smoney.android.izly.extras.GetNewsFeedItemPerPage", 0), intent.getLongExtra("fr.smoney.android.izly.extras.GetNewsFeedFromDate", -1L), intent.getLongExtra("fr.smoney.android.izly.extras.GetNewsFeedToDate", -1L), intent.getBooleanExtra("fr.smoney.android.izly.extras.GetNewsFeedIsRefresh", false), (GetNewsFeedData) intent.getParcelableExtra("fr.smoney.android.izly.extras.GetNewsFeedOldData")), intent);
                        return;
                    case 227:
                        m945h(C0374Q7.m2105Q(intent.getStringExtra("fr.smoney.android.izly.extras.GetHomescrrenTransactionListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetHomescrrenTransactionListSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetHomescrrenTransactionListItem")), intent);
                        return;
                    case 228:
                        m945h(C0374Q7.m2080o(intent.getStringExtra("fr.smoney.android.izly.extras.GetLogonInfosUserId")), intent);
                        return;
                    case 229:
                        m945h(C0374Q7.m2099W(intent.getStringExtra("fr.smoney.android.izly.extras.IsSessionValidUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.IsSessionValidSessionId")), intent);
                        return;
                    case 230:
                        m945h(C0374Q7.m2101U(intent.getStringExtra("fr.smoney.android.izly.extras.GetMyCbListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetMyCbListSessionId")), intent);
                        return;
                    case 231:
                        m945h(C0374Q7.m2107O(intent.getStringExtra("fr.smoney.android.izly.extras.refreshOAuthTokenUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.refreshOAuthTokenRefreshToken")), intent);
                        return;
                    case 232:
                        m945h(C0374Q7.m2096Z(intent.getStringExtra("fr.smoney.android.izly.extras.loginLightUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.loginLightPassword")), intent);
                        return;
                    case 233:
                        m940f(intent, C0374Q7.m2103S(intent.getStringExtra("fr.smoney.android.izly.extras.acceptCGUUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.acceptCGUSessionId")));
                        return;
                    case 241:
                        m945h(C0374Q7.m2118D(intent.getStringExtra("fr.smoney.android.izly.extras.MoneyInTiersUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.MoneyInTiersSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.MoneyInTiersEmail"), intent.getStringExtra("fr.smoney.android.izly.extras.MoneyInTiersMessage"), intent.getStringExtra("fr.smoney.android.izly.extras.MoneyInTiersAmount")), intent);
                        return;
                    case 251:
                        m945h(C0374Q7.m2100V(intent.getStringExtra("fr.smoney.android.izly.extras.GetMySupportListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetMySupportListSessionId")), intent);
                        return;
                    case 252:
                        m945h(C0374Q7.m2071x(intent.getStringExtra("fr.smoney.android.izly.extras.PutOppositionUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.PutOppositionSessionId"), intent.getLongExtra("fr.smoney.android.izly.extras.PutOppositionSupportId", -1L), intent.getIntExtra("fr.smoney.android.izly.extras.PutOppositionMotif", 0), intent.getStringExtra("fr.smoney.android.izly.extras.PutOppositionPassword")), intent);
                        return;
                    case 253:
                        m945h(C0374Q7.m2070y(intent.getStringExtra("fr.smoney.android.izly.extras.RiseOppositionUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.RiseOppositionSessionId"), intent.getLongExtra("fr.smoney.android.izly.extras.RiseOppositionSupportId", -1L), intent.getStringExtra("fr.smoney.android.izly.extras.RiseOppositionPassword")), intent);
                        return;
                    case 261:
                        m945h(C0374Q7.m2106P(intent.getStringExtra("fr.smoney.android.izly.extras.GetMyCounterListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.GetMyCounterListSessionId")), intent);
                        return;
                    case 263:
                        m945h(C0374Q7.m2119C(intent.getStringExtra("fr.smoney.android.izly.extras.cardPaymentsUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.cardPaymentsSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.cardPaymentsAmount"), intent.getStringExtra("fr.smoney.android.izly.extras.cardPaymentsAvailableCards")), intent);
                        return;
                    case 264:
                        m945h(C0374Q7.m2079p(intent.getStringExtra("fr.smoney.android.izly.extras.getMandatesUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.getMandatesSessionId")), intent);
                        return;
                    case 265:
                        m945h(C0374Q7.m2078q(intent.getStringExtra("fr.smoney.android.izly.extras.checkMoneyInBankAccountUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.checkMoneyInBankAccountSessionId"), intent.getDoubleExtra("fr.smoney.android.izly.extras.checkMoneyInBankAccountAmount", -1.0d)), intent);
                        return;
                    case 266:
                        m945h(C0374Q7.m2077r(intent.getStringExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountSessionId"), intent.getDoubleExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountAmount", -1.0d), intent.getStringExtra("fr.smoney.android.izly.extras.makeMoneyInBankAccountPassword")), intent);
                        return;
                    case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                        m945h(C1924j9.m682a(intent.getStringExtra("fr.smoney.android.izly.extras.actuListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.actuListSessionId")), intent);
                        return;
                    case 271:
                        m945h(C1895i9.m726a(intent.getStringExtra("fr.smoney.android.izly.extras.actuListUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.actuListSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.actuDetailId")), intent);
                        return;
                    case 276:
                        m940f(intent, C0374Q7.m2073v(intent.getStringExtra("fr.smoney.android.izly.extras.activateUserEmail"), intent.getStringExtra("fr.smoney.android.izly.extras.activateUserActivationCode"), intent.getIntExtra("fr.smoney.android.izly.extras.activateUserCivility", -1), intent.getStringExtra("fr.smoney.android.izly.extras.activateUserBirthdate"), intent.getIntExtra("fr.smoney.android.izly.extras.activateUserCountry", -1), intent.getStringExtra("fr.smoney.android.izly.extras.activateUserPassword"), intent.getStringExtra("fr.smoney.android.izly.extras.activateUserSecretQuestion"), intent.getStringExtra("fr.smoney.android.izly.extras.activateUserSecretAnswer"), intent.getIntExtra("fr.smoney.android.izly.extras.activateUserCgu", -1), intent.getIntExtra("fr.smoney.android.izly.extras.activateUserOptin", -1), intent.getIntExtra("fr.smoney.android.izly.extras.activateUserOptinPartners", -1)));
                        return;
                    case 278:
                        m945h(C1683f9.m984a(intent.getStringExtra("fr.smoney.android.izly.extras.terminateContractUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.terminateContractSessionId")), intent);
                        return;
                    case 279:
                        m945h(C1982m9.m591a(intent.getStringExtra("fr.smoney.android.izly.extras.sendConfirmationCodeUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.sendConfirmationCodeSessionId")), intent);
                        return;
                    case 280:
                        m945h(C1961l9.m609a(intent.getStringExtra("fr.smoney.android.izly.extras.resendConfirmationCodeUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.resendConfirmationCodeSessionId")), intent);
                        return;
                    case 281:
                        m945h(C2006n9.m563a(intent.getStringExtra("fr.smoney.android.izly.extras.confirmTerminateContractUserId"), intent.getStringExtra("fr.smoney.android.izly.extras.confirmTerminateContractSessionId"), intent.getStringExtra("fr.smoney.android.izly.extras.confirmTerminateContractOtpCode")), intent);
                        return;
                    default:
                        bundle = null;
                        try {
                            m942d(intent, null);
                            return;
                        } catch (IOException e) {
                            iOException = e;
                            String str = "IOException occurred :" + iOException;
                            m944b(intent, bundle);
                            return;
                        } catch (RuntimeException e2) {
                            runtimeException = e2;
                            String str2 = "RuntimeException occurred :" + runtimeException;
                            m943c(intent, bundle);
                            return;
                        } catch (ParserConfigurationException e3) {
                            parserConfigurationException = e3;
                            String str3 = "ParserConfigurationException occurred :" + parserConfigurationException;
                            m943c(intent, bundle);
                            return;
                        } catch (JSONException e4) {
                            jSONException = e4;
                            String str4 = "JSONException occurred :" + jSONException;
                            m943c(intent, bundle);
                            return;
                        } catch (SAXException e5) {
                            sAXException = e5;
                            String str5 = "SAXException occurred :" + sAXException;
                            m943c(intent, bundle);
                            return;
                        } catch (XmlPullParserException e6) {
                            xmlPullParserException = e6;
                            String str6 = "XmlPullParserException occurred :" + xmlPullParserException;
                            m943c(intent, bundle);
                            return;
                        }
                }
            } catch (IOException e7) {
                iOException = e7;
                bundle = null;
            } catch (RuntimeException e8) {
                runtimeException = e8;
                bundle = null;
            } catch (ParserConfigurationException e9) {
                parserConfigurationException = e9;
                bundle = null;
            } catch (JSONException e10) {
                jSONException = e10;
                bundle = null;
            } catch (SAXException e11) {
                sAXException = e11;
                bundle = null;
            } catch (XmlPullParserException e12) {
                xmlPullParserException = e12;
                bundle = null;
            }
        } catch (SocketTimeoutException e13) {
            String str7 = "SocketTimeoutException occurred :" + e13;
            ServerError serverError = new ServerError();
            serverError.f4602c = 998;
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            m943c(intent, bundle2);
        } catch (ParseException e14) {
            String str8 = "ParseException occurred :" + e14;
            m943c(intent, null);
        } catch (ConnectTimeoutException e15) {
            String str9 = "ConnectTimeoutException occurred :" + e15;
            ServerError serverError2 = new ServerError();
            serverError2.f4602c = 999;
            Bundle bundle3 = new Bundle();
            bundle3.putParcelable("fr.smoney.android.izly.extras.serverError", serverError2);
            m943c(intent, bundle3);
        }
    }

    @Override // fr.smoney.android.izly.data.service.WorkerService
    /* renamed from: e */
    public void mo941e(Intent intent, Bundle bundle, int i) {
        ServerError serverError;
        if (intent.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 231) {
            Intent intent2 = (Intent) intent.getParcelableExtra("fr.smoney.android.izly.extras.refreshOAuthTokenWsToRecallIntent");
            ServerError serverError2 = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
            if (i == 0) {
                OAuthData oAuthData = (OAuthData) bundle.getParcelable("fr.smoney.android.izly.extras.RefreshToken");
                if (serverError2 == null && oAuthData != null) {
                    SmoneyApplication.f4207g.m2495n(oAuthData);
                    mo947a(intent2);
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("fr.smoney.android.izly.extras.serverError", serverError2);
                super.mo941e(intent2, bundle2, i);
                return;
            }
            Bundle bundle3 = new Bundle();
            bundle3.putParcelable("fr.smoney.android.izly.extras.serverError", serverError2);
            super.mo941e(intent2, bundle3, i);
            return;
        }
        if (i == 0 && bundle != null && (serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError")) != null && serverError.f4601b == 569) {
            Intent intent3 = new Intent(this, SmoneyService.class);
            String user_id = SmoneyApplication.f4207g.user_id();
            OAuthData m2500i = SmoneyApplication.f4207g.m2500i();
            if (user_id != null && m2500i != null) {
                intent3.putExtra("com.foxykeep.datadroid.extras.workerType", 231);
                intent3.putExtra("fr.smoney.android.izly.extras.refreshOAuthTokenWsToRecallIntent", intent);
                intent3.putExtra("fr.smoney.android.izly.extras.refreshOAuthTokenUserId", user_id);
                intent3.putExtra("fr.smoney.android.izly.extras.refreshOAuthTokenRefreshToken", m2500i.f4534b);
                mo947a(intent3);
                return;
            }
        }
        super.mo941e(intent, bundle, i);
    }

    /* renamed from: h */
    public final void m945h(Bundle bundle, Intent intent) {
        ServerError serverError = (ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError");
        if (serverError != null && serverError.f4602c > 0) {
            m943c(intent, bundle);
        } else {
            mo941e(intent, bundle, 0);
        }
    }
}
