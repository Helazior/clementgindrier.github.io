package p000;

import android.os.Bundle;
import android.util.Base64;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.google.firebase.messaging.Constants;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.BalanceData;
import fr.smoney.android.izly.data.model.BlockAccountData;
import fr.smoney.android.izly.data.model.CardPaymentsData;
import fr.smoney.android.izly.data.model.CbChangeAliasData;
import fr.smoney.android.izly.data.model.CheckMoneyInBankAccountData;
import fr.smoney.android.izly.data.model.ChooseDefaultCbData;
import fr.smoney.android.izly.data.model.Contact;
import fr.smoney.android.izly.data.model.CounterFamily;
import fr.smoney.android.izly.data.model.CounterListData;
import fr.smoney.android.izly.data.model.GetActiveMandateData;
import fr.smoney.android.izly.data.model.GetBankAccountData;
import fr.smoney.android.izly.data.model.GetConfidentialitySettingsData;
import fr.smoney.android.izly.data.model.GetContactDetailsData;
import fr.smoney.android.izly.data.model.GetMyCbListData;
import fr.smoney.android.izly.data.model.GetMySupportListData;
import fr.smoney.android.izly.data.model.GetNewsFeedData;
import fr.smoney.android.izly.data.model.HomepageFeedItem;
import fr.smoney.android.izly.data.model.InitiatePasswordRecoveryData;
import fr.smoney.android.izly.data.model.IsEnrollmentOpenData;
import fr.smoney.android.izly.data.model.IsSessionValidData;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.model.MakeBankAccountUpdateData;
import fr.smoney.android.izly.data.model.MakeMoneyInBankAccountData;
import fr.smoney.android.izly.data.model.Mandate;
import fr.smoney.android.izly.data.model.MoneyInCbCb;
import fr.smoney.android.izly.data.model.MoneyInCbCbListData;
import fr.smoney.android.izly.data.model.MoneyInCbConfirmData;
import fr.smoney.android.izly.data.model.MoneyInCbData;
import fr.smoney.android.izly.data.model.MoneyOutTransferAccountData;
import fr.smoney.android.izly.data.model.MoneyOutTransferConfirmData;
import fr.smoney.android.izly.data.model.MoneyOutTransferData;
import fr.smoney.android.izly.data.model.NearPro$Tills;
import fr.smoney.android.izly.data.model.NewsFeedChatItem;
import fr.smoney.android.izly.data.model.NewsFeedCommissionOrPass;
import fr.smoney.android.izly.data.model.NewsFeedContactLight;
import fr.smoney.android.izly.data.model.NewsFeedEcommerce;
import fr.smoney.android.izly.data.model.NewsFeedItem;
import fr.smoney.android.izly.data.model.NewsFeedMoneyDemandFeedItem;
import fr.smoney.android.izly.data.model.NewsFeedMoneyOperationFeedItem;
import fr.smoney.android.izly.data.model.NewsFeedPaymentFeedItem;
import fr.smoney.android.izly.data.model.OAuthData;
import fr.smoney.android.izly.data.model.PreAuthorizationContainerData;
import fr.smoney.android.izly.data.model.ProInfos;
import fr.smoney.android.izly.data.model.ProProduct;
import fr.smoney.android.izly.data.model.PromotionalOffer;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.ServiceData;
import fr.smoney.android.izly.data.model.SetConfidentialitySettingsData;
import fr.smoney.android.izly.data.model.Support;
import fr.smoney.android.izly.data.model.Transaction;
import fr.smoney.android.izly.data.model.TransactionListData;
import fr.smoney.android.izly.data.model.UpdatePasswordData;
import fr.smoney.android.izly.data.model.UpdateUserProfileData;
import fr.smoney.android.izly.data.model.UserData;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.parsers.SAXParserFactory;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/* renamed from: Q7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0374Q7 {

    /* renamed from: a */
    public static int f1272a;

    /* renamed from: A */
    public static Bundle m2121A(String str, String str2, String str3, double d, long j) {
        HashMap hashMap = new HashMap();
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("userId", str);
        hashMap.put("sessionId", str2);
        hashMap.put("cardId", str3);
        hashMap.put("amount", String.valueOf(d));
        if (j != -1) {
            hashMap.put("engagementId", String.valueOf(j));
        }
        String m2083l = m2083l("https://soap.izly.fr/Service.asmx", "Service", "MoneyInCb", "Service/MoneyInCb", "2.0", hashMap);
        int i = f1272a;
        Bundle bundle = new Bundle();
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        C0251K8 c0251k8 = new C0251K8();
        xMLReader.setContentHandler(c0251k8);
        xMLReader.parse(new InputSource(new StringReader(m2083l)));
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            ServerError serverError = c0251k8.f786b;
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            MoneyInCbData moneyInCbData = c0251k8.f787c;
            if (moneyInCbData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.moneyInCbData", moneyInCbData);
            }
        }
        return bundle;
    }

    /* renamed from: B */
    public static Bundle m2120B(String str, String str2, String str3, double d, String str4, long j) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        String m2503f = SmoneyApplication.f4207g.m2503f(str, str4);
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("userId", str);
        hashMap.put("cardId", str3);
        hashMap.put("amount", String.valueOf(d));
        hashMap.put("passOTP", m2503f);
        sb.append(str);
        if (str2 != null) {
            hashMap.put("sessionId", str2);
            sb.append(",");
            sb.append(str2);
        }
        sb.append(",");
        sb.append(str3);
        sb.append(",");
        sb.append(d);
        sb.append(",");
        sb.append(m2503f);
        if (j != -1) {
            hashMap.put("engagementId", String.valueOf(j));
            sb.append(",");
            sb.append(j);
        }
        hashMap.put("print", SmoneyApplication.f4207g.m2502g(m2503f, sb.toString()));
        String m2083l = m2083l("https://soap.izly.fr/Service.asmx", "Service", "MoneyInCbConfirm", "Service/MoneyInCbConfirm", "3.0", hashMap);
        int i = f1272a;
        Bundle bundle = new Bundle();
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        C0223J8 c0223j8 = new C0223J8();
        xMLReader.setContentHandler(c0223j8);
        xMLReader.parse(new InputSource(new StringReader(m2083l)));
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            ServerError serverError = c0223j8.f701b;
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            MoneyInCbConfirmData moneyInCbConfirmData = c0223j8.f702c;
            if (moneyInCbConfirmData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.moneyInCbConfirmData", moneyInCbConfirmData);
            }
        }
        return bundle;
    }

    /* renamed from: C */
    public static Bundle m2119C(String str, String str2, String str3, String str4) {
        CardPaymentsData cardPaymentsData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/api/payins/cardpayments", "1");
        outline.m278C(DefaultSettingsSpiCall.HEADER_ACCEPT, "application/vnd.s-money.v1+json", m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("Content-Type", "application/vnd.s-money.v1+json"));
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("amount", Double.valueOf(str3));
        jSONObject.put("cards", str4);
        jSONObject.put("ismine", true);
        jSONObject.put("urlReturn", "http://80.11.255.231");
        m247x.f3728b = jSONObject.toString();
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                cardPaymentsData = null;
                serverError = serverError2;
            } else {
                cardPaymentsData = new CardPaymentsData();
                cardPaymentsData.f4234a = jSONObject2.getString("Href");
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (cardPaymentsData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.cardPayments", cardPaymentsData);
            }
        }
        return bundle;
    }

    /* renamed from: D */
    public static Bundle m2118D(String str, String str2, String str3, String str4, String str5) {
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/SendPayInRequest", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("amount", str5);
        jSONObject.put("message", str4);
        jSONObject.put("recipient", str3);
        m247x.m1143c(jSONObject.toString());
        return m2084k(m247x.f3732f, m247x.m1144b(1));
    }

    /* renamed from: E */
    public static Bundle m2117E(String str, String str2, String str3, String str4, String str5, String str6) {
        MakeBankAccountUpdateData makeBankAccountUpdateData;
        String m2503f = SmoneyApplication.f4207g.m2503f(str, str6);
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/MakeBankAccountUpdate", "2.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        outline.m278C("sessionId", str2, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("passOTP", m2503f));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("iban", str4);
        jSONObject.put("bic", str5);
        jSONObject.put("alias", str3);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                makeBankAccountUpdateData = null;
                serverError = serverError2;
            } else {
                JSONObject optJSONObject = jSONObject2.optJSONObject("MakeBankAccountUpdateResult");
                if (optJSONObject != null) {
                    makeBankAccountUpdateData = new MakeBankAccountUpdateData();
                    makeBankAccountUpdateData.f4391a = m2087h(optJSONObject, "Alias");
                    makeBankAccountUpdateData.f4392b = m2087h(optJSONObject, "BankName");
                    makeBankAccountUpdateData.f4394d = m2087h(optJSONObject, "Bic");
                    makeBankAccountUpdateData.f4396g = m2087h(optJSONObject, "BicHint");
                    makeBankAccountUpdateData.f4393c = m2087h(optJSONObject, "Iban");
                    makeBankAccountUpdateData.f4395f = m2087h(optJSONObject, "IbanHint");
                    makeBankAccountUpdateData.f4400k = m2087h(optJSONObject, "UpdateHelpMessage");
                    makeBankAccountUpdateData.f4398i = optJSONObject.optBoolean("IsActive");
                    makeBankAccountUpdateData.f4399j = optJSONObject.optBoolean("IsUpdateAuthorized");
                    makeBankAccountUpdateData.f4397h = optJSONObject.optLong("Id");
                    if (!optJSONObject.isNull("SessionId")) {
                        makeBankAccountUpdateData.f4401l = optJSONObject.getString("SessionId");
                    }
                } else {
                    makeBankAccountUpdateData = null;
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (makeBankAccountUpdateData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.changeTransferAccountData", makeBankAccountUpdateData);
            }
        }
        return bundle;
    }

    /* renamed from: F */
    public static Bundle m2116F(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        UpdateUserProfileData updateUserProfileData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/UpdateUserProfile", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("Email", str3);
        JSONObject jSONObject4 = new JSONObject();
        ServerError serverError = null;
        if (str4.length() == 0 && str5.length() == 0 && str6.length() == 0) {
            jSONObject3.put("Address", (Object) null);
        } else {
            jSONObject4.put("Name", str4);
            jSONObject4.put("ZipCode", str5);
            jSONObject4.put("City", str6);
            jSONObject4.put("Country", i);
            jSONObject3.put("Address", jSONObject4);
        }
        jSONObject2.put("Profile", jSONObject3);
        jSONObject.put("info", jSONObject2);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i2 = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i2)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i2));
        } else {
            JSONObject jSONObject5 = new JSONObject(m1144b);
            if (!jSONObject5.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject5.getInt("Code");
                serverError2.f4603d = jSONObject5.getString("ErrorMessage");
                serverError2.f4605g = jSONObject5.getInt("Priority");
                serverError2.f4604f = jSONObject5.getString("Title");
                updateUserProfileData = null;
                serverError = serverError2;
            } else {
                updateUserProfileData = new UpdateUserProfileData();
                JSONObject jSONObject6 = jSONObject5.getJSONObject("UpdateUserProfileResult");
                if (!jSONObject6.isNull("UP")) {
                    JSONObject jSONObject7 = jSONObject6.getJSONObject("UP");
                    updateUserProfileData.f4663a.f4230a = Double.parseDouble(jSONObject7.getString("BAL"));
                    updateUserProfileData.f4663a.f4232c = outline.m258m(jSONObject7, "LUD", C0091D8.f352a);
                }
                if (!jSONObject6.isNull("Result")) {
                    updateUserProfileData.f4664b = jSONObject6.getInt("Result");
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (updateUserProfileData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.updateUserProfileData", updateUserProfileData);
            }
        }
        return bundle;
    }

    /* renamed from: G */
    public static Bundle m2115G(String str, String str2, boolean z, boolean z2, String str3) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("language", Locale.getDefault().getLanguage());
        linkedHashMap.put("user", str);
        linkedHashMap.put("password", str2);
        linkedHashMap.put("smoneyClientType", "PART");
        linkedHashMap.put("rooted", z2 ? "1" : CrashlyticsReportDataCapture.SIGNAL_DEFAULT);
        if (str3 != null && str3.length() > 0) {
            linkedHashMap.put("actCode", str3);
        } else if (z) {
            linkedHashMap.put("passOTP", SmoneyApplication.f4207g.m2503f(str, str2));
        }
        String m2083l = m2083l("https://soap.izly.fr/Service.asmx", "Service", "Logon", "Service/Logon", "4.3", linkedHashMap);
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        C0356P8 c0356p8 = new C0356P8();
        xMLReader.setContentHandler(c0356p8);
        xMLReader.parse(new InputSource(new StringReader(m2083l)));
        Bundle bundle = new Bundle();
        ServerError serverError = c0356p8.f1220b;
        if (serverError != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
        }
        LoginData loginData = c0356p8.f1221c;
        if (loginData != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.loginData", loginData);
        }
        UserData userData = c0356p8.f1222d;
        if (userData != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.userData", userData);
        }
        OAuthData oAuthData = c0356p8.f1225g;
        if (oAuthData != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.oAuthData", oAuthData);
        }
        return bundle;
    }

    /* renamed from: H */
    public static Bundle m2114H(String str, boolean z) {
        InitiatePasswordRecoveryData initiatePasswordRecoveryData;
        ServerError serverError;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/InitiatePasswordRecovery", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("userId", str));
        m247x.f3731e.add(new BasicNameValuePair("unlockAccount", String.valueOf(z)));
        String m1144b = m247x.m1144b(0);
        ServerError serverError2 = null;
        if (m1144b.length() > 0) {
            JSONObject jSONObject = new JSONObject(m1144b);
            if (jSONObject.isNull("ErrorMessage")) {
                serverError = null;
            } else {
                serverError = new ServerError();
                serverError.f4601b = jSONObject.getInt("Code");
                serverError.f4603d = jSONObject.getString("ErrorMessage");
                serverError.f4605g = jSONObject.getInt("Priority");
                serverError.f4604f = jSONObject.getString("Title");
            }
            initiatePasswordRecoveryData = null;
            serverError2 = serverError;
        } else {
            initiatePasswordRecoveryData = new InitiatePasswordRecoveryData();
        }
        Bundle bundle = new Bundle();
        if (serverError2 != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError2);
        }
        if (initiatePasswordRecoveryData != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.initiatePasswordRecoveryData", initiatePasswordRecoveryData);
        }
        return bundle;
    }

    /* renamed from: I */
    public static void m2113I(String str, String str2) {
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/Logout", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("username", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        m247x.m1144b(0);
    }

    /* renamed from: J */
    public static Bundle m2112J(String str, String str2) {
        GetConfidentialitySettingsData getConfidentialitySettingsData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/GetConfidentialitySettings", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        String m1144b = m247x.m1144b(0);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject.getInt("Code");
                serverError2.f4603d = jSONObject.getString("ErrorMessage");
                serverError2.f4605g = jSONObject.getInt("Priority");
                serverError2.f4604f = jSONObject.getString("Title");
                getConfidentialitySettingsData = null;
                serverError = serverError2;
            } else {
                getConfidentialitySettingsData = new GetConfidentialitySettingsData();
                if (!jSONObject.isNull("UP")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("UP");
                    getConfidentialitySettingsData.f4294h.f4230a = Double.parseDouble(jSONObject2.getString("BAL"));
                    getConfidentialitySettingsData.f4294h.f4232c = outline.m258m(jSONObject2, "LUD", C0091D8.f352a);
                }
                if (!jSONObject.isNull("Result")) {
                    JSONObject jSONObject3 = jSONObject.getJSONObject("Result");
                    getConfidentialitySettingsData.f4288a = jSONObject3.getInt("Photo");
                    getConfidentialitySettingsData.f4289b = jSONObject3.getInt("Name");
                    getConfidentialitySettingsData.f4290c = jSONObject3.getInt("PhoneNumber");
                    getConfidentialitySettingsData.f4291d = jSONObject3.getInt("Alias");
                    getConfidentialitySettingsData.f4292f = jSONObject3.getInt("Address");
                    getConfidentialitySettingsData.f4293g = jSONObject3.getInt("Email");
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (getConfidentialitySettingsData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.getConfidentialitySettingsData", getConfidentialitySettingsData);
            }
        }
        return bundle;
    }

    /* renamed from: K */
    public static Bundle m2111K(String str, String str2, double d, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("userId", str);
        hashMap.put("sessionId", str2);
        hashMap.put("amount", String.valueOf(d));
        hashMap.put(Constants.ScionAnalytics.PARAM_LABEL, str3);
        String m2083l = m2083l("https://soap.izly.fr/Service.asmx", "Service", "MoneyOutTransfer", "Service/MoneyOutTransfer", "1.0", hashMap);
        int i = f1272a;
        Bundle bundle = new Bundle();
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        C0314N8 c0314n8 = new C0314N8();
        xMLReader.setContentHandler(c0314n8);
        xMLReader.parse(new InputSource(new StringReader(m2083l)));
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            ServerError serverError = c0314n8.f1035b;
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            MoneyOutTransferData moneyOutTransferData = c0314n8.f1036c;
            if (moneyOutTransferData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.moneyOutTransferData", moneyOutTransferData);
            }
        }
        return bundle;
    }

    /* renamed from: L */
    public static Bundle m2110L(String str, String str2, String str3) {
        ChooseDefaultCbData chooseDefaultCbData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/ChooseDefaultCB", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cardId", str3);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                chooseDefaultCbData = null;
                serverError = serverError2;
            } else {
                chooseDefaultCbData = new ChooseDefaultCbData();
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (chooseDefaultCbData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.chooseDefaultIdData", chooseDefaultCbData);
            }
        }
        return bundle;
    }

    /* renamed from: M */
    public static Bundle m2109M(String str, String str2, String str3, String str4) {
        CbChangeAliasData cbChangeAliasData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/CBChangeAlias", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cardId", str3);
        jSONObject.put("alias", str4);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                cbChangeAliasData = null;
                serverError = serverError2;
            } else {
                JSONObject optJSONObject = jSONObject2.optJSONObject("CBChangeAliasResult");
                if (optJSONObject != null) {
                    cbChangeAliasData = new CbChangeAliasData();
                    cbChangeAliasData.f4235a.f4419b = m2087h(optJSONObject, "Alias");
                    cbChangeAliasData.f4235a.f4421d = m2087h(optJSONObject, "Hint");
                    cbChangeAliasData.f4235a.f4418a = m2087h(optJSONObject, "SystemPayCardId");
                    cbChangeAliasData.f4235a.f4422f = optJSONObject.optBoolean("IsDefault");
                    MoneyInCbCb moneyInCbCb = cbChangeAliasData.f4235a;
                    optJSONObject.optBoolean("IsActive");
                    Objects.requireNonNull(moneyInCbCb);
                    cbChangeAliasData.f4235a.f4420c = optJSONObject.optInt("Network");
                } else {
                    cbChangeAliasData = null;
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (cbChangeAliasData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.cbChangeAliasData", cbChangeAliasData);
            }
        }
        return bundle;
    }

    /* renamed from: N */
    public static Bundle m2108N(String str, String str2, String str3, String str4, String str5) {
        GetContactDetailsData getContactDetailsData;
        ServerError serverError;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/GetContactDetails", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("Identifier", str3);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("Latitude", str4);
        jSONObject3.put("Longitude", str5);
        jSONObject.put("receiver", jSONObject2);
        if (str4 != null && str5 != null) {
            jSONObject.put("position", jSONObject3);
        }
        m247x.m1143c(jSONObject.toString());
        JSONObject jSONObject4 = new JSONObject(m247x.m1144b(1));
        if (!jSONObject4.isNull("ErrorMessage")) {
            serverError = new ServerError();
            serverError.f4601b = jSONObject4.getInt("Code");
            serverError.f4603d = jSONObject4.getString("ErrorMessage");
            serverError.f4605g = jSONObject4.getInt("Priority");
            serverError.f4604f = jSONObject4.getString("Title");
            getContactDetailsData = null;
        } else {
            if (jSONObject4.isNull("GetContactDetailsResult")) {
                getContactDetailsData = null;
            } else {
                JSONObject jSONObject5 = jSONObject4.getJSONObject("GetContactDetailsResult");
                GetContactDetailsData getContactDetailsData2 = new GetContactDetailsData();
                JSONObject optJSONObject = jSONObject5.optJSONObject("UP");
                if (optJSONObject != null) {
                    getContactDetailsData2.f4309c.f4230a = optJSONObject.optDouble("BAL");
                    getContactDetailsData2.f4309c.f4232c = outline.m258m(optJSONObject, "LUD", C0091D8.f352a);
                }
                JSONObject optJSONObject2 = jSONObject5.optJSONObject("Result");
                if (optJSONObject2 != null) {
                    if (!optJSONObject2.isNull("ActiveAlias")) {
                        getContactDetailsData2.f4310d = optJSONObject2.getString("ActiveAlias");
                    }
                    if (!optJSONObject2.isNull("Actions")) {
                        JSONObject jSONObject6 = optJSONObject2.getJSONObject("Actions");
                        getContactDetailsData2.f4319n = jSONObject6.getBoolean("IsBookmarkable");
                        getContactDetailsData2.f4317l = jSONObject6.getBoolean("IsBlockable");
                    }
                    if (!optJSONObject2.isNull("ActivePhone")) {
                        JSONObject jSONObject7 = optJSONObject2.getJSONObject("ActivePhone");
                        getContactDetailsData2.f4311f = jSONObject7.optString("PhoneDisplayNumber");
                        getContactDetailsData2.f4312g = jSONObject7.optString("PhoneInternationalNumber");
                    }
                    getContactDetailsData2.f4313h = optJSONObject2.optBoolean("CanDisplayPhoto");
                    getContactDetailsData2.f4307a = optJSONObject2.optString("DisplayName");
                    getContactDetailsData2.f4315j = optJSONObject2.optBoolean("HasPhoto");
                    getContactDetailsData2.f4308b = optJSONObject2.optString("Identifier");
                    getContactDetailsData2.f4316k = optJSONObject2.optBoolean("IsBlocked");
                    getContactDetailsData2.f4318m = optJSONObject2.optBoolean("IsBookmarked");
                    getContactDetailsData2.f4320o = optJSONObject2.optBoolean("IsMe");
                    getContactDetailsData2.f4321p = optJSONObject2.optBoolean("IsSmoneyPro");
                    getContactDetailsData2.f4322q = optJSONObject2.optBoolean("IsSmoneyUser");
                    getContactDetailsData2.f4301G = optJSONObject2.optBoolean("OptIn");
                    getContactDetailsData2.f4302H = optJSONObject2.optBoolean("OptInPartners");
                    getContactDetailsData2.f4314i = optJSONObject2.optString("SecondDisplayName");
                    JSONArray optJSONArray = optJSONObject2.optJSONArray("Operations");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i);
                            if (optJSONObject3 != null) {
                                Transaction transaction = new Transaction();
                                transaction.f4622a = optJSONObject3.optLong("Id");
                                transaction.f4634n = optJSONObject3.optInt("Type");
                                transaction.f4631k = C0278Ld.m2212f(optJSONObject3.getString("Date"));
                                transaction.f4627g = optJSONObject3.optDouble("Amount");
                                getContactDetailsData2.f4303I.add(transaction);
                            }
                        }
                    }
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("ProInfos");
                    if (optJSONObject4 != null) {
                        ProInfos proInfos = new ProInfos();
                        if (!optJSONObject4.isNull("Coordinates")) {
                            JSONObject jSONObject8 = optJSONObject4.getJSONObject("Coordinates");
                            proInfos.f4559d = jSONObject8.optDouble("Distance");
                            proInfos.f4560f = jSONObject8.optDouble("Latitude");
                            proInfos.f4561g = jSONObject8.optDouble("Longitude");
                        }
                        proInfos.f4556a = optJSONObject4.optBoolean("Accessibility");
                        proInfos.f4557b = m2087h(optJSONObject4, "Activity");
                        proInfos.f4558c = m2087h(optJSONObject4, "CommercialMessage");
                        proInfos.f4562h = optJSONObject4.optBoolean("IsPremium");
                        proInfos.f4563i = optJSONObject4.optBoolean("IsCaritative");
                        proInfos.f4568n = m2087h(optJSONObject4, "Siret");
                        proInfos.f4569o = m2087h(optJSONObject4, "WebSite");
                        proInfos.f4564j = optJSONObject4.optInt("ProActivity");
                        if (!optJSONObject4.isNull("PreAuthorization")) {
                            PreAuthorizationContainerData preAuthorizationContainerData = new PreAuthorizationContainerData();
                            Contact contact = new Contact();
                            preAuthorizationContainerData.f4543a = contact;
                            contact.f4244b = getContactDetailsData2.f4307a;
                            contact.f4243a = getContactDetailsData2.f4308b;
                            JSONObject jSONObject9 = optJSONObject4.getJSONObject("PreAuthorization");
                            PreAuthorizationContainerData.PreAuthorization preAuthorization = new PreAuthorizationContainerData.PreAuthorization();
                            preAuthorizationContainerData.f4546d = preAuthorization;
                            preAuthorization.f4548a = m2087h(jSONObject9, "Identifier");
                            preAuthorizationContainerData.f4546d.f4549b = jSONObject9.optInt("IdentifierType");
                            getContactDetailsData2.f4306L = preAuthorizationContainerData;
                        }
                        if (!optJSONObject4.isNull("Cashiers")) {
                            JSONArray jSONArray = optJSONObject4.getJSONArray("Cashiers");
                            int length2 = jSONArray.length();
                            int i2 = 0;
                            while (i2 < length2) {
                                JSONObject jSONObject10 = jSONArray.getJSONObject(i2);
                                NearPro$Tills nearPro$Tills = new NearPro$Tills();
                                nearPro$Tills.f4461b = m2087h(jSONObject10, "DisplayName");
                                nearPro$Tills.f4460a = m2087h(jSONObject10, "Identifier");
                                nearPro$Tills.f4462c = jSONObject10.optBoolean("IsSmoneyUser");
                                getContactDetailsData2.f4304J.add(nearPro$Tills);
                                i2++;
                                jSONArray = jSONArray;
                            }
                        }
                        JSONObject optJSONObject5 = optJSONObject4.optJSONObject("Schedule");
                        if (optJSONObject5 != null) {
                            proInfos.f4565k = optJSONObject5.optBoolean("IsOpen");
                            proInfos.f4567m = optJSONObject5.optInt("OpeningState");
                            proInfos.f4566l = optJSONObject5.optBoolean("ShowOpening");
                            JSONArray optJSONArray2 = optJSONObject5.optJSONArray("OpeningHoursText");
                            if (optJSONArray2 != null) {
                                int length3 = optJSONArray2.length();
                                for (int i3 = 0; i3 < length3; i3++) {
                                    proInfos.f4572r.add(optJSONArray2.getString(i3));
                                }
                            }
                        }
                        JSONArray optJSONArray3 = optJSONObject4.optJSONArray("Products");
                        if (optJSONArray3 != null) {
                            int length4 = optJSONArray3.length();
                            for (int i4 = 0; i4 < length4; i4++) {
                                JSONObject optJSONObject6 = optJSONArray3.optJSONObject(i4);
                                ProProduct proProduct = new ProProduct();
                                proProduct.f4573a = optJSONObject6.optInt("Id");
                                proProduct.f4577f = optJSONObject6.optString("Label");
                                JSONObject optJSONObject7 = optJSONObject6.optJSONObject("Price");
                                if (optJSONObject7 != null) {
                                    proProduct.f4574b = optJSONObject7.optString("AmountHT");
                                    proProduct.f4575c = optJSONObject7.optString("AmountTTC");
                                    proProduct.f4576d = optJSONObject7.optString("Tax");
                                }
                                JSONObject optJSONObject8 = optJSONObject6.optJSONObject("Photo");
                                if (optJSONObject8 != null) {
                                    proProduct.f4579h = optJSONObject8.optString("Id");
                                    proProduct.f4578g = optJSONObject8.optString("Name");
                                }
                                proInfos.f4571q.add(proProduct);
                            }
                        }
                        JSONArray optJSONArray4 = optJSONObject4.optJSONArray("PromotionalOffers");
                        if (optJSONArray4 != null) {
                            int length5 = optJSONArray4.length();
                            for (int i5 = 0; i5 < length5; i5++) {
                                JSONObject jSONObject11 = optJSONArray4.getJSONObject(i5);
                                PromotionalOffer promotionalOffer = new PromotionalOffer();
                                promotionalOffer.f4580a = jSONObject11.optInt("Id");
                                promotionalOffer.f4581b = jSONObject11.optBoolean("IsRead");
                                promotionalOffer.f4582c = m2087h(jSONObject11, "Title");
                                promotionalOffer.f4584f = m2087h(jSONObject11, "Description");
                                promotionalOffer.f4583d = m2087h(jSONObject11, "SubTitle");
                                promotionalOffer.f4585g = m2087h(jSONObject11, "Url");
                                promotionalOffer.f4586h = C0278Ld.m2212f(m2087h(jSONObject11, "PublicationStartDate"));
                                promotionalOffer.f4587i = C0278Ld.m2212f(m2087h(jSONObject11, "PublicationEndDate"));
                                promotionalOffer.f4590l = getContactDetailsData2.f4307a;
                                promotionalOffer.f4589k = getContactDetailsData2.f4308b;
                                promotionalOffer.f4591m = proInfos.f4559d;
                                promotionalOffer.f4592n = PromotionalOffer.EnumC1761b.GEOLOCALIZED;
                                promotionalOffer.f4588j = m2087h(jSONObject11, "Activity");
                                proInfos.f4570p.add(promotionalOffer);
                            }
                        }
                        getContactDetailsData2.f4305K = proInfos;
                    }
                    JSONObject optJSONObject9 = optJSONObject2.optJSONObject("IzlyProfile");
                    if (optJSONObject9 != null) {
                        if (!optJSONObject9.isNull("IzlyEmail")) {
                            getContactDetailsData2.f4329x = optJSONObject9.getString("IzlyEmail");
                        }
                        if (!optJSONObject9.isNull("CardNumber")) {
                            getContactDetailsData2.f4297C = optJSONObject9.getString("CardNumber");
                        }
                        if (!optJSONObject9.isNull("NumeroTarif")) {
                            getContactDetailsData2.f4300F = optJSONObject9.getString("NumeroTarif");
                        }
                        if (!optJSONObject9.isNull("CodeSociete")) {
                            getContactDetailsData2.f4298D = optJSONObject9.getInt("CodeSociete");
                        }
                        if (!optJSONObject9.isNull("DateValidity")) {
                            getContactDetailsData2.f4299E = C0278Ld.m2212f(optJSONObject9.getString("DateValidity"));
                        }
                        if (!optJSONObject9.isNull("DateValidityString")) {
                            optJSONObject9.getString("DateValidityString");
                        }
                    }
                    JSONObject optJSONObject10 = optJSONObject2.optJSONObject("Profile");
                    if (optJSONObject10 != null) {
                        if (!optJSONObject10.isNull("BirthDate")) {
                            getContactDetailsData2.f4327v = C0278Ld.m2212f(optJSONObject10.getString("BirthDate"));
                        }
                        getContactDetailsData2.f4328w = optJSONObject10.optInt("Civility");
                        if (!optJSONObject10.isNull("Email")) {
                            getContactDetailsData2.f4295A = optJSONObject10.getString("Email");
                        }
                        if (!optJSONObject10.isNull("BirthDateString")) {
                            optJSONObject10.getString("BirthDateString");
                        }
                        if (!optJSONObject10.isNull("FirstName")) {
                            getContactDetailsData2.f4330y = optJSONObject10.getString("FirstName");
                        }
                        if (!optJSONObject10.isNull("LastName")) {
                            getContactDetailsData2.f4331z = optJSONObject10.getString("LastName");
                        }
                        if (!optJSONObject10.isNull("TwitterEmail")) {
                            getContactDetailsData2.f4296B = optJSONObject10.getString("TwitterEmail");
                        }
                        if (!optJSONObject10.isNull("Address")) {
                            JSONObject optJSONObject11 = optJSONObject10.optJSONObject("Address");
                            getContactDetailsData2.f4325t = m2087h(optJSONObject11, "City");
                            getContactDetailsData2.f4323r = m2087h(optJSONObject11, "Name");
                            getContactDetailsData2.f4324s = m2087h(optJSONObject11, "ZipCode");
                            getContactDetailsData2.f4326u = optJSONObject11.getInt("Country");
                        }
                    }
                }
                getContactDetailsData = getContactDetailsData2;
            }
            serverError = null;
        }
        Bundle bundle = new Bundle();
        if (serverError != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
        }
        if (getContactDetailsData != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.GetContactDetails", getContactDetailsData);
        }
        return bundle;
    }

    /* renamed from: O */
    public static Bundle m2107O(String str, String str2) {
        OAuthData oAuthData;
        int i;
        String m2504e = SmoneyApplication.f4207g.m2504e(str);
        if (m2504e != null && m2504e.length() > 0) {
            String encodeToString = Base64.encodeToString(("S-money:" + m2504e).getBytes(), 8);
            m2504e = encodeToString.substring(0, encodeToString.length() + (-1));
        }
        C0973b9 c0973b9 = new C0973b9("https://rest.izly.fr/oauth/token");
        c0973b9.f3729c.add(new BasicNameValuePair("Authorization", "Basic " + m2504e));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("grant_type", "refresh_token");
        jSONObject.put("refresh_token", str2);
        c0973b9.m1143c(jSONObject.toString());
        String m1144b = c0973b9.m1144b(1);
        int i2 = c0973b9.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i2)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i2));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull(Constants.IPC_BUNDLE_KEY_SEND_ERROR)) {
                ServerError serverError2 = new ServerError();
                serverError2.f4605g = 1;
                String string = jSONObject2.getString(Constants.IPC_BUNDLE_KEY_SEND_ERROR);
                if (string.compareTo("invalid_request") == 0) {
                    i = 572;
                } else if (string.compareTo("invalid_client") == 0) {
                    i = 573;
                } else if (string.compareTo("unauthorized_client") == 0) {
                    i = 574;
                } else if (string.compareTo("access_denied") == 0) {
                    i = 575;
                } else if (string.compareTo("invalid_grant") == 0) {
                    i = 576;
                } else if (string.compareTo("unsupported_grant_type") == 0) {
                    i = 577;
                } else if (string.compareTo("unsupported_response_type") == 0) {
                    i = 578;
                } else if (string.compareTo("invalid_scope") == 0) {
                    i = 579;
                } else if (string.compareTo("server_error") == 0) {
                    i = 580;
                } else {
                    i = string.compareTo("temporarily_unavailable") == 0 ? 581 : 582;
                }
                serverError2.f4601b = i;
                serverError2.f4603d = jSONObject2.getString("error_description");
                oAuthData = null;
                serverError = serverError2;
            } else {
                String string2 = !jSONObject2.isNull("access_token") ? jSONObject2.getString("access_token") : null;
                String string3 = !jSONObject2.isNull("refresh_token") ? jSONObject2.getString("refresh_token") : null;
                long j = !jSONObject2.isNull("expires_in") ? jSONObject2.getLong("expires_in") : -1L;
                oAuthData = (string2 == null || string3 == null || j == -1) ? null : new OAuthData(string2, string3, j);
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (oAuthData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.RefreshToken", oAuthData);
            }
        }
        return bundle;
    }

    /* renamed from: P */
    public static Bundle m2106P(String str, String str2) {
        ServerError serverError;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/GetCounterList", "2.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        String m1144b = m247x.m1144b(0);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            if (!jSONObject.isNull("ErrorMessage")) {
                serverError = new ServerError();
                serverError.f4601b = jSONObject.getInt("Code");
                serverError.f4603d = jSONObject.getString("ErrorMessage");
                serverError.f4605g = jSONObject.getInt("Priority");
                serverError.f4604f = jSONObject.getString("Title");
            } else {
                if (!jSONObject.isNull("GetCounterListResult")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("GetCounterListResult");
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        arrayList.add(new CounterFamily(jSONObject2.getLong("CounterTypeId"), jSONObject2.getString("Label"), jSONObject2.getInt("Value")));
                    }
                }
                serverError = null;
            }
            CounterListData counterListData = arrayList.isEmpty() ? null : new CounterListData(arrayList);
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (counterListData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.GetMyCounterList", counterListData);
            }
        }
        return bundle;
    }

    /* renamed from: Q */
    public static Bundle m2105Q(String str, String str2, String str3) {
        GetNewsFeedData getNewsFeedData;
        C0973b9 c0973b9 = new C0973b9(outline.m263h(outline.m253r("https://rest.izly.fr/Service/PublicService.svc/rest/GetHomePageOperations?transactionGroup="), EnumC2029od.valueOf(str3).f5627a, "&top=15"));
        c0973b9.m1145a("1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), c0973b9.f3729c);
        outline.m278C("userId", str, c0973b9.f3729c);
        c0973b9.f3729c.add(new BasicNameValuePair("sessionId", str2));
        String m1144b = c0973b9.m1144b(0);
        int i = c0973b9.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject.getInt("Code");
                serverError2.f4603d = jSONObject.getString("ErrorMessage");
                serverError2.f4605g = jSONObject.getInt("Priority");
                serverError2.f4604f = jSONObject.getString("Title");
                getNewsFeedData = null;
                serverError = serverError2;
            } else {
                getNewsFeedData = new GetNewsFeedData();
                JSONObject optJSONObject = jSONObject.optJSONObject("GetHomePageOperationsResult");
                if (optJSONObject != null) {
                    if (!optJSONObject.isNull("UP")) {
                        getNewsFeedData.f4336a = new BalanceData();
                        JSONObject jSONObject2 = optJSONObject.getJSONObject("UP");
                        getNewsFeedData.f4336a.f4230a = Double.parseDouble(jSONObject2.getString("BAL"));
                        getNewsFeedData.f4336a.f4231b = Double.parseDouble(jSONObject2.getString("CASHBAL"));
                        getNewsFeedData.f4336a.f4232c = outline.m258m(jSONObject2, "LUD", C0091D8.f352a);
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("Result");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            NewsFeedItem.EnumC1744b enumC1744b = NewsFeedItem.f4471l.get(optJSONObject2.optInt("OperationType"));
                            if (enumC1744b != null) {
                                switch (enumC1744b.ordinal()) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                    case 4:
                                    case 5:
                                    case 6:
                                    case 7:
                                    case 8:
                                    case 9:
                                    case 10:
                                    case 11:
                                    case 12:
                                        HomepageFeedItem homepageFeedItem = new HomepageFeedItem();
                                        if (!optJSONObject2.isNull("Message")) {
                                            try {
                                                homepageFeedItem.f4343p = optJSONObject2.getString("Message");
                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        if (!optJSONObject2.isNull("Amount")) {
                                            try {
                                                homepageFeedItem.f4342o = optJSONObject2.getDouble("Amount");
                                            } catch (JSONException e2) {
                                                e2.printStackTrace();
                                            }
                                        }
                                        if (!optJSONObject2.isNull("IsCredit")) {
                                            try {
                                                if (optJSONObject2.getBoolean("IsCredit")) {
                                                    homepageFeedItem.f4482j = NewsFeedChatItem.m967g(1);
                                                } else {
                                                    homepageFeedItem.f4482j = NewsFeedChatItem.m967g(2);
                                                }
                                            } catch (JSONException e3) {
                                                e3.printStackTrace();
                                            }
                                        } else {
                                            homepageFeedItem.f4482j = NewsFeedItem.EnumC1745c.NoneDirection;
                                        }
                                        homepageFeedItem.f4475b = optJSONObject2.optLong("Id");
                                        homepageFeedItem.f4478f = NewsFeedItem.f4471l.get(optJSONObject2.optInt("OperationType"));
                                        homepageFeedItem.f4477d = NewsFeedItem.f4473n.get((int) optJSONObject2.optLong("Status"));
                                        homepageFeedItem.f4481i = Long.valueOf(C0278Ld.m2212f(optJSONObject2.optString("Date")));
                                        homepageFeedItem.f4344q = EnumC2029od.valueOf(str3);
                                        getNewsFeedData.f4341g.add(homepageFeedItem);
                                        continue;
                                }
                            }
                        }
                    }
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (getNewsFeedData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.GetNewsFeed", getNewsFeedData);
            }
        }
        return bundle;
    }

    /* renamed from: R */
    public static Bundle m2104R(String str, String str2, String str3, String str4) {
        UpdatePasswordData updatePasswordData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/UpdatePassword", "2.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("oldPassword", str4);
        jSONObject.put("newPassword", str3);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                updatePasswordData = null;
                serverError = serverError2;
            } else {
                updatePasswordData = new UpdatePasswordData();
                updatePasswordData.f4662a = jSONObject2.getJSONObject("UpdatePasswordResult").getString("SALT");
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (updatePasswordData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.updatePasswordData", updatePasswordData);
            }
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006e  */
    /* renamed from: S */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle m2103S(java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "https://rest.izly.fr/Service/PublicService.svc/rest/AcceptCGU"
            java.lang.String r1 = "1.0"
            b9 r0 = p000.outline.m247x(r0, r1)
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getLanguage()
            java.util.ArrayList<org.apache.http.NameValuePair> r2 = r0.f3729c
            java.lang.String r3 = "language"
            p000.outline.m278C(r3, r1, r2)
            java.util.ArrayList<org.apache.http.NameValuePair> r1 = r0.f3729c
            java.lang.String r2 = "userId"
            p000.outline.m278C(r2, r4, r1)
            java.util.ArrayList<org.apache.http.NameValuePair> r4 = r0.f3729c
            org.apache.http.message.BasicNameValuePair r1 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r2 = "sessionId"
            r1.<init>(r2, r5)
            r4.add(r1)
            r4 = 1
            java.lang.String r4 = r0.m1144b(r4)
            int r5 = r4.length()
            if (r5 <= 0) goto L66
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>(r4)
            java.lang.String r4 = "ErrorMessage"
            boolean r0 = r5.isNull(r4)
            if (r0 != 0) goto L66
            fr.smoney.android.izly.data.model.ServerError r0 = new fr.smoney.android.izly.data.model.ServerError
            r0.<init>()
            java.lang.String r1 = "Code"
            int r1 = r5.getInt(r1)
            r0.f4601b = r1
            java.lang.String r4 = r5.getString(r4)
            r0.f4603d = r4
            java.lang.String r4 = "Priority"
            int r4 = r5.getInt(r4)
            r0.f4605g = r4
            java.lang.String r4 = "Title"
            java.lang.String r4 = r5.getString(r4)
            r0.f4604f = r4
            goto L67
        L66:
            r0 = 0
        L67:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            if (r0 == 0) goto L73
            java.lang.String r5 = "fr.smoney.android.izly.extras.serverError"
            r4.putParcelable(r5, r0)
        L73:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0374Q7.m2103S(java.lang.String, java.lang.String):android.os.Bundle");
    }

    /* renamed from: T */
    public static Bundle m2102T(String str, String str2) {
        GetBankAccountData getBankAccountData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/GetMyBankAccount", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        String m1144b = m247x.m1144b(0);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else if (m1144b.length() == 0) {
            bundle.putParcelable("fr.smoney.android.izly.extras.getBankAccountData", new GetBankAccountData());
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            if (m1144b.length() == 0) {
                bundle.putParcelable("fr.smoney.android.izly.extras.getBankAccountData", new GetBankAccountData());
            } else {
                ServerError serverError = null;
                if (!jSONObject.isNull("ErrorMessage")) {
                    ServerError serverError2 = new ServerError();
                    serverError2.f4601b = jSONObject.getInt("Code");
                    serverError2.f4603d = jSONObject.getString("ErrorMessage");
                    serverError2.f4605g = jSONObject.getInt("Priority");
                    serverError2.f4604f = jSONObject.getString("Title");
                    getBankAccountData = null;
                    serverError = serverError2;
                } else {
                    getBankAccountData = new GetBankAccountData();
                    getBankAccountData.f4280b = m2087h(jSONObject, "Alias");
                    getBankAccountData.f4283f = m2087h(jSONObject, "Bic");
                    getBankAccountData.f4284g = m2087h(jSONObject, "BicHint");
                    getBankAccountData.f4281c = m2087h(jSONObject, "Iban");
                    getBankAccountData.f4282d = m2087h(jSONObject, "IbanHint");
                    getBankAccountData.f4279a = jSONObject.optLong("Id");
                    getBankAccountData.f4285h = jSONObject.optBoolean("IsActive");
                    getBankAccountData.f4286i = jSONObject.optBoolean("IsUpdateAuthorized");
                    getBankAccountData.f4287j = m2087h(jSONObject, "UpdateHelpMessage");
                }
                if (serverError != null) {
                    bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
                }
                if (getBankAccountData != null) {
                    bundle.putParcelable("fr.smoney.android.izly.extras.getBankAccountData", getBankAccountData);
                }
            }
        }
        return bundle;
    }

    /* renamed from: U */
    public static Bundle m2101U(String str, String str2) {
        GetMyCbListData getMyCbListData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/GetMyCardList", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        String m1144b = m247x.m1144b(0);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject.getInt("Code");
                serverError2.f4603d = jSONObject.getString("ErrorMessage");
                serverError2.f4605g = jSONObject.getInt("Priority");
                serverError2.f4604f = jSONObject.getString("Title");
                getMyCbListData = null;
                serverError = serverError2;
            } else if (jSONObject.isNull("GetMyCardListResult")) {
                getMyCbListData = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("GetMyCardListResult");
                int length = jSONArray.length();
                getMyCbListData = new GetMyCbListData();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    MoneyInCbCb moneyInCbCb = new MoneyInCbCb();
                    moneyInCbCb.f4419b = m2087h(jSONObject2, "Alias");
                    moneyInCbCb.f4421d = m2087h(jSONObject2, "Hint");
                    jSONObject2.optBoolean("IsActive");
                    moneyInCbCb.f4422f = jSONObject2.optBoolean("IsDefault");
                    moneyInCbCb.f4420c = jSONObject2.optInt("Network", -1);
                    moneyInCbCb.f4418a = m2087h(jSONObject2, "SystemPayCardId");
                    getMyCbListData.f4333a.add(moneyInCbCb);
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (getMyCbListData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.GetMyCbList", getMyCbListData);
            }
        }
        return bundle;
    }

    /* renamed from: V */
    public static Bundle m2100V(String str, String str2) {
        GetMySupportListData getMySupportListData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/GetSupports", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        String m1144b = m247x.m1144b(0);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject.getInt("Code");
                serverError2.f4603d = jSONObject.getString("ErrorMessage");
                serverError2.f4605g = jSONObject.getInt("Priority");
                serverError2.f4604f = jSONObject.getString("Title");
                getMySupportListData = null;
                serverError = serverError2;
            } else if (jSONObject.isNull("GetSupportsResult")) {
                getMySupportListData = null;
            } else {
                JSONArray jSONArray = jSONObject.getJSONArray("GetSupportsResult");
                int length = jSONArray.length();
                getMySupportListData = new GetMySupportListData();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    long j = jSONObject2.getLong("Id");
                    EnumC0576Y8 enumC0576Y8 = EnumC0576Y8.values()[jSONObject2.getInt("SupportType") - 1];
                    String m2087h = m2087h(jSONObject2, "OppositionType");
                    if (m2087h.length() == 0) {
                        m2087h = CrashlyticsReportDataCapture.SIGNAL_DEFAULT;
                    }
                    getMySupportListData.f4335a.add(new Support(j, enumC0576Y8, m2087h(jSONObject2, "CrousName"), m2087h(jSONObject2, "Label"), m2087h(jSONObject2, "ExpiryDate"), m2087h(jSONObject2, "OppositionDate"), Boolean.valueOf(jSONObject2.getString("IsOppositionPermanent")).booleanValue(), Integer.valueOf(m2087h).intValue()));
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (getMySupportListData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.GetMySupportList", getMySupportListData);
            }
        }
        return bundle;
    }

    /* renamed from: W */
    public static Bundle m2099W(String str, String str2) {
        IsSessionValidData isSessionValidData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/IsSessionValid", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sessionId", str2);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                serverError = serverError2;
                isSessionValidData = null;
            } else {
                if (!jSONObject2.isNull("IsSessionValidResult")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("IsSessionValidResult");
                    if (!jSONObject3.isNull("Result")) {
                        isSessionValidData = new IsSessionValidData();
                        isSessionValidData.f4346a = jSONObject3.getBoolean("Result");
                        if (!jSONObject3.isNull("UP")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("UP");
                            BalanceData balanceData = new BalanceData();
                            isSessionValidData.f4347b = balanceData;
                            balanceData.f4231b = Double.parseDouble(jSONObject4.getString("CASHBAL"));
                            isSessionValidData.f4347b.f4230a = Double.parseDouble(jSONObject4.getString("BAL"));
                            isSessionValidData.f4347b.f4232c = outline.m258m(jSONObject4, "LUD", C0091D8.f352a);
                        }
                    }
                }
                isSessionValidData = null;
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (isSessionValidData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.IsSessionValid", isSessionValidData);
            }
        }
        return bundle;
    }

    /* renamed from: X */
    public static Bundle m2098X(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("userId", str);
        hashMap.put("sessionId", str2);
        String m2083l = m2083l("https://soap.izly.fr/Service.asmx", "Service", "MoneyInCbCbList", "Service/MoneyInCbCbList", "1.0", hashMap);
        int i = f1272a;
        Bundle bundle = new Bundle();
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        C0200I8 c0200i8 = new C0200I8();
        xMLReader.setContentHandler(c0200i8);
        xMLReader.parse(new InputSource(new StringReader(m2083l)));
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            ServerError serverError = c0200i8.f644b;
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            MoneyInCbCbListData moneyInCbCbListData = c0200i8.f645c;
            if (moneyInCbCbListData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.moneyInCbCbListData", moneyInCbCbListData);
            }
        }
        return bundle;
    }

    /* renamed from: Y */
    public static Bundle m2097Y(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("userId", str);
        hashMap.put("sessionId", str2);
        String m2083l = m2083l("https://soap.izly.fr/Service.asmx", "Service", "MoneyOutTransferAccount", "Service/MoneyOutTransferAccount", "1.0", hashMap);
        int i = f1272a;
        Bundle bundle = new Bundle();
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        C0273L8 c0273l8 = new C0273L8();
        xMLReader.setContentHandler(c0273l8);
        xMLReader.parse(new InputSource(new StringReader(m2083l)));
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            ServerError serverError = c0273l8.f903b;
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            MoneyOutTransferAccountData moneyOutTransferAccountData = c0273l8.f904c;
            if (moneyOutTransferAccountData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.moneyOutTransferAccountData", moneyOutTransferAccountData);
            }
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00f2  */
    /* renamed from: Z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle m2096Z(java.lang.String r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0374Q7.m2096Z(java.lang.String, java.lang.String):android.os.Bundle");
    }

    /* renamed from: a */
    public static final int m2095a(byte[] bArr) {
        return (bArr[0] << 24) + ((bArr[1] & 255) << 16) + ((bArr[2] & 255) << 8) + (bArr[3] & 255);
    }

    /* renamed from: a0 */
    public static Bundle m2094a0(String str, String str2, String str3, String str4) {
        BlockAccountData blockAccountData;
        String m2503f = SmoneyApplication.f4207g.m2503f(str, str4);
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/MakeOpposition", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        outline.m278C("sessionId", str2, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("passOTP", m2503f));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("comment", str3);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                blockAccountData = null;
                serverError = serverError2;
            } else {
                blockAccountData = new BlockAccountData();
                if (!jSONObject2.isNull("UP")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("UP");
                    blockAccountData.f4233a.f4230a = Double.parseDouble(jSONObject3.getString("BAL"));
                    blockAccountData.f4233a.f4232c = outline.m258m(jSONObject3, "LUD", C0154G8.f499a);
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (blockAccountData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.blockAccountData", blockAccountData);
            }
        }
        return bundle;
    }

    /* renamed from: b */
    public static String m2093b(String str, String str2) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKeySpec);
        byte[] doFinal = mac.doFinal(str.getBytes());
        Formatter formatter = new Formatter();
        int length = doFinal.length;
        for (int i = 0; i < length; i++) {
            formatter.format("%02x", Byte.valueOf(doFinal[i]));
        }
        return formatter.toString();
    }

    /* renamed from: c */
    public static void m2092c(NewsFeedItem newsFeedItem, JSONObject jSONObject) {
        if (!jSONObject.isNull("Direction")) {
            newsFeedItem.f4482j = NewsFeedChatItem.m967g(jSONObject.optInt("Direction"));
        } else {
            newsFeedItem.f4482j = NewsFeedItem.EnumC1745c.NoneDirection;
        }
        newsFeedItem.f4475b = jSONObject.optLong("OperationId");
        newsFeedItem.f4479g = NewsFeedItem.m966a(jSONObject.optInt("OperationType"));
        newsFeedItem.f4481i = Long.valueOf(C0278Ld.m2212f(jSONObject.optString("OperationDate")));
    }

    /* renamed from: d */
    public static void m2091d(NewsFeedPaymentFeedItem newsFeedPaymentFeedItem, JSONObject jSONObject) {
        if (!jSONObject.isNull("Amount")) {
            newsFeedPaymentFeedItem.f4530o = jSONObject.optDouble("Amount");
        }
        newsFeedPaymentFeedItem.f4532q = jSONObject.optBoolean("HasMessages");
        newsFeedPaymentFeedItem.f4531p = jSONObject.optBoolean("HasAttachment");
        JSONObject optJSONObject = jSONObject.optJSONObject("Contact");
        if (optJSONObject != null) {
            NewsFeedContactLight newsFeedContactLight = new NewsFeedContactLight();
            newsFeedContactLight.f4466b = m2087h(optJSONObject, "DisplayName");
            newsFeedContactLight.f4465a = m2087h(optJSONObject, "Identifier");
            newsFeedContactLight.f4468d = optJSONObject.optBoolean("IsSmoneyPro");
            newsFeedContactLight.f4467c = optJSONObject.optBoolean("IsSmoneyUser");
            newsFeedPaymentFeedItem.f4480h = newsFeedContactLight;
        }
    }

    /* renamed from: e */
    public static final boolean m2090e(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c);
            char upperCase2 = Character.toUpperCase(c2);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }

    /* renamed from: f */
    public static String m2089f(double d) {
        return m2088g(String.valueOf(d));
    }

    /* renamed from: g */
    public static String m2088g(String str) {
        int length;
        String replace = str.replace(",", ".");
        int indexOf = str.indexOf(".");
        if (indexOf == -1 || (length = 3 - (replace.length() - indexOf)) <= 0) {
            return replace;
        }
        StringBuilder sb = new StringBuilder(replace);
        for (int i = 0; i < length; i++) {
            sb.append(CrashlyticsReportDataCapture.SIGNAL_DEFAULT);
        }
        return sb.toString();
    }

    /* renamed from: h */
    public static String m2087h(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return "";
        }
        String optString = jSONObject.optString(str);
        return optString.toLowerCase().equals("null") ? "" : optString;
    }

    /* renamed from: i */
    public static final byte[] m2086i(int i) {
        return new byte[]{(byte) (i >>> 24), (byte) (i >>> 16), (byte) (i >>> 8), (byte) i};
    }

    /* renamed from: j */
    public static final int m2085j(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    /* renamed from: k */
    public static Bundle m2084k(int i, String str) {
        ServerError serverError;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("ErrorMessage")) {
                serverError = null;
            } else {
                serverError = new ServerError();
                serverError.f4601b = jSONObject.getInt("Code");
                serverError.f4603d = jSONObject.getString("ErrorMessage");
                serverError.f4605g = jSONObject.getInt("Priority");
                serverError.f4604f = jSONObject.getString("Title");
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
        }
        return bundle;
    }

    /* renamed from: l */
    public static String m2083l(String str, String str2, String str3, String str4, String str5, HashMap<String, String> hashMap) {
        C0613a9 c0613a9 = new C0613a9(str2, str3, str4, str5);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new HeaderProperty("clientVersion", "4.3"));
        arrayList.add(new HeaderProperty("smoneyClientType", "PART"));
        OAuthData m2500i = SmoneyApplication.f4207g.m2500i();
        if (m2500i != null && m2500i.f4533a != null) {
            arrayList.add(new HeaderProperty("Authorization", "Bearer " + m2500i.f4533a));
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            HeaderProperty headerProperty = (HeaderProperty) arrayList.get(i);
            headerProperty.getKey();
            headerProperty.getValue();
        }
        if (!hashMap.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(hashMap.keySet());
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str6 = (String) arrayList2.get(i2);
                c0613a9.addProperty(str6, hashMap.get(str6));
                hashMap.get(str6);
            }
        }
        SoapSerializationEnvelope soapSerializationEnvelope = new SoapSerializationEnvelope(110);
        soapSerializationEnvelope.dotNet = true;
        soapSerializationEnvelope.encodingStyle = SoapEnvelope.XSD;
        soapSerializationEnvelope.bodyOut = c0613a9;
        soapSerializationEnvelope.setOutputSoapObject(c0613a9);
        HttpTransportSE httpTransportSE = new HttpTransportSE(str, 30000);
        System.setProperty("http.keepAlive", "false");
        httpTransportSE.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        httpTransportSE.call(c0613a9.f2173a, soapSerializationEnvelope, arrayList);
        f1272a = httpTransportSE.getServiceConnection().getResponseCode();
        ((SoapPrimitive) soapSerializationEnvelope.getResponse()).toString();
        return ((SoapPrimitive) soapSerializationEnvelope.getResponse()).toString();
    }

    /* renamed from: m */
    public static ServerError m2082m(int i) {
        ServerError serverError = new ServerError();
        serverError.f4602c = i;
        return serverError;
    }

    /* renamed from: n */
    public static Bundle m2081n() {
        IsEnrollmentOpenData isEnrollmentOpenData;
        JSONObject jSONObject = new JSONObject(new C0973b9("https://rest.izly.fr/Service/PublicService.svc/rest/isEnrollmentOpen").m1144b(0));
        ServerError serverError = null;
        if (!jSONObject.isNull("ErrorMessage")) {
            ServerError serverError2 = new ServerError();
            serverError2.f4601b = jSONObject.getInt("Code");
            serverError2.f4603d = jSONObject.getString("ErrorMessage");
            serverError2.f4605g = jSONObject.getInt("Priority");
            serverError2.f4604f = jSONObject.getString("Title");
            serverError = serverError2;
            isEnrollmentOpenData = null;
        } else if (jSONObject.isNull("IsEnrollmentOpenResult")) {
            isEnrollmentOpenData = null;
        } else {
            isEnrollmentOpenData = new IsEnrollmentOpenData();
            isEnrollmentOpenData.f4345a = jSONObject.getBoolean("IsEnrollmentOpenResult");
        }
        Bundle bundle = new Bundle();
        if (serverError != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
        }
        if (isEnrollmentOpenData != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.IsEnrollementOpen", isEnrollmentOpenData);
        }
        return bundle;
    }

    /* renamed from: o */
    public static Bundle m2080o(String str) {
        LoginData loginData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/GetLogonInfos", "2.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("userId", str));
        String m1144b = m247x.m1144b(0);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject.getInt("Code");
                serverError2.f4603d = jSONObject.getString("ErrorMessage");
                serverError2.f4605g = jSONObject.getInt("Priority");
                serverError2.f4604f = jSONObject.getString("Title");
                loginData = null;
                serverError = serverError2;
            } else {
                if (!jSONObject.isNull("GetLogonInfosResult")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("GetLogonInfosResult");
                    if (!jSONObject2.isNull("Result")) {
                        loginData = new LoginData();
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("Result");
                        loginData.f4363b = jSONObject3.optString("UserId");
                        loginData.f4385y = jSONObject3.optString("Alias");
                        loginData.f4371k = jSONObject3.optString("Currency");
                        loginData.f4379s = jSONObject3.optString("Email");
                        loginData.f4377q = jSONObject3.optString("FirstName");
                        loginData.f4378r = jSONObject3.optString("LastName");
                        loginData.f4380t = jSONObject3.optInt("Age");
                        loginData.f4381u = jSONObject3.optString("ZipCode");
                        loginData.f4382v = jSONObject3.optString("Crous");
                        loginData.f4383w = jSONObject3.optInt("CategoryUserId");
                        loginData.f4384x = jSONObject3.optInt("TarifUserId");
                        loginData.f4386z = jSONObject3.optString("CrousName");
                        loginData.f4348A = jSONObject3.optString("TermsConditionsAgreementDate");
                        loginData.f4349B = jSONObject3.optString("SubscriptionDate");
                        loginData.f4350C = jSONObject3.optString("Banks");
                        if (!jSONObject3.isNull("LimitMoneyIn")) {
                            JSONObject jSONObject4 = jSONObject3.getJSONObject("LimitMoneyIn");
                            loginData.f4368h = Double.parseDouble(m2088g(jSONObject4.optString("Max")));
                            loginData.f4367g = Double.parseDouble(m2088g(jSONObject4.optString("Min")));
                        }
                        if (!jSONObject3.isNull("LimitMoneyOut")) {
                            JSONObject jSONObject5 = jSONObject3.getJSONObject("LimitMoneyOut");
                            try {
                                loginData.f4370j = Double.parseDouble(m2088g(jSONObject5.optString("Max")));
                            } catch (NumberFormatException unused) {
                            }
                            try {
                                loginData.f4369i = Double.parseDouble(m2088g(jSONObject5.optString("Min")));
                            } catch (NumberFormatException unused2) {
                            }
                        }
                        if (!jSONObject3.isNull("LimitPayment")) {
                            JSONObject jSONObject6 = jSONObject3.getJSONObject("LimitPayment");
                            loginData.f4366f = Double.parseDouble(m2088g(jSONObject6.optString("Max")));
                            loginData.f4365d = Double.parseDouble(m2088g(jSONObject6.optString("Min")));
                        }
                        loginData.f4352E = jSONObject3.optBoolean("OptIn");
                        loginData.f4353F = jSONObject3.optBoolean("OptInPartners");
                        loginData.f4355H = jSONObject3.optInt("Role") == 2;
                        if (!jSONObject3.isNull("ServicesInfos")) {
                            JSONArray jSONArray = jSONObject3.getJSONArray("ServicesInfos");
                            int length = jSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject jSONObject7 = jSONArray.getJSONObject(i2);
                                ServiceData serviceData = new ServiceData();
                                serviceData.f4606a = jSONObject7.getInt("Id");
                                serviceData.f4607b = jSONObject7.getBoolean("CguExpired");
                                loginData.f4359L.add(serviceData);
                            }
                        }
                        loginData.f4358K = jSONObject3.optString("Token");
                        loginData.f4362a = jSONObject3.optString("UserIdentifier");
                        loginData.f4354G = jSONObject3.optInt("UserStatus");
                        if (!jSONObject2.isNull("UP")) {
                            JSONObject jSONObject8 = jSONObject2.getJSONObject("UP");
                            loginData.f4351D.f4230a = Double.parseDouble(jSONObject8.getString("BAL"));
                            loginData.f4351D.f4231b = Double.parseDouble(jSONObject8.getString("CASHBAL"));
                            loginData.f4351D.f4232c = outline.m258m(jSONObject8, "LUD", C0091D8.f352a);
                        }
                    }
                }
                loginData = null;
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
                bundle.toString();
            }
            if (loginData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.GetLogonInfos", loginData);
                bundle.toString();
            }
        }
        return bundle;
    }

    /* renamed from: p */
    public static Bundle m2079p(String str, String str2) {
        GetActiveMandateData getActiveMandateData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/GetActiveMandate", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        String m1144b = m247x.m1144b(0);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject.getInt("Code");
                serverError2.f4603d = jSONObject.getString("ErrorMessage");
                serverError2.f4605g = jSONObject.getInt("Priority");
                serverError2.f4604f = jSONObject.getString("Title");
                getActiveMandateData = null;
                serverError = serverError2;
            } else {
                getActiveMandateData = new GetActiveMandateData();
                if (!jSONObject.isNull("UP")) {
                    getActiveMandateData.f4274a = new BalanceData();
                    JSONObject jSONObject2 = jSONObject.getJSONObject("UP");
                    getActiveMandateData.f4274a.f4230a = Double.parseDouble(jSONObject2.getString("BAL"));
                    getActiveMandateData.f4274a.f4231b = Double.parseDouble(jSONObject2.getString("CASHBAL"));
                    getActiveMandateData.f4274a.f4232c = outline.m258m(jSONObject2, "LUD", C0091D8.f352a);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("Result");
                if (optJSONObject != null) {
                    if (!optJSONObject.isNull("Max")) {
                        getActiveMandateData.f4275b = optJSONObject.getDouble("Max");
                    }
                    if (!optJSONObject.isNull("Min")) {
                        getActiveMandateData.f4276c = optJSONObject.getDouble("Min");
                    }
                    if (!optJSONObject.isNull("Steps")) {
                        JSONArray jSONArray = optJSONObject.getJSONArray("Steps");
                        getActiveMandateData.f4277d = new int[jSONArray.length()];
                        for (int i2 = 0; i2 != jSONArray.length(); i2++) {
                            getActiveMandateData.f4277d[i2] = jSONArray.getInt(i2);
                        }
                    }
                    if (!optJSONObject.isNull("Mandate")) {
                        JSONObject optJSONObject2 = optJSONObject.optJSONObject("Mandate");
                        if (!optJSONObject2.isNull("BankAccount")) {
                            JSONObject optJSONObject3 = optJSONObject2.optJSONObject("BankAccount");
                            getActiveMandateData.f4278f = new Mandate(optJSONObject3.optString("Bic"), optJSONObject3.optString("BicHint"), optJSONObject3.optString("Iban"), optJSONObject3.optString("IbanHint"));
                        }
                    }
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (getActiveMandateData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.GetActiveMandate", getActiveMandateData);
            }
        }
        return bundle;
    }

    /* renamed from: q */
    public static Bundle m2078q(String str, String str2, double d) {
        CheckMoneyInBankAccountData checkMoneyInBankAccountData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/CheckMoneyInBankAccount", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("amount", d);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                checkMoneyInBankAccountData = null;
                serverError = serverError2;
            } else {
                if (!jSONObject2.isNull("CheckMoneyInBankAccountResult")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("CheckMoneyInBankAccountResult");
                    if (!jSONObject3.isNull("Result")) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("Result");
                        if (!jSONObject4.isNull("Amount") && !jSONObject4.isNull("Date")) {
                            checkMoneyInBankAccountData = new CheckMoneyInBankAccountData(jSONObject4.optString("Date"), jSONObject4.optDouble("Amount"));
                        }
                    }
                }
                checkMoneyInBankAccountData = null;
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (checkMoneyInBankAccountData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.CheckMoneyInBankAccount", checkMoneyInBankAccountData);
            }
        }
        return bundle;
    }

    /* renamed from: r */
    public static Bundle m2077r(String str, String str2, double d, String str3) {
        MakeMoneyInBankAccountData makeMoneyInBankAccountData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/MakeMoneyInBankAccount", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        outline.m278C("sessionId", str2, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("passOTP", SmoneyApplication.f4207g.m2503f(str, str3)));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("amount", d);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                makeMoneyInBankAccountData = null;
                serverError = serverError2;
            } else {
                if (!jSONObject2.isNull("MakeMoneyInBankAccountResult")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("MakeMoneyInBankAccountResult");
                    if (!jSONObject3.isNull("Result")) {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject("Result");
                        if (!jSONObject4.isNull("Amount") && !jSONObject4.isNull("Date")) {
                            makeMoneyInBankAccountData = new MakeMoneyInBankAccountData(jSONObject4.optString("Date"), jSONObject4.optDouble("Amount"));
                        }
                    }
                }
                makeMoneyInBankAccountData = null;
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (makeMoneyInBankAccountData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.MakeMoneyInBankAccountData", makeMoneyInBankAccountData);
            }
        }
        return bundle;
    }

    /* renamed from: s */
    public static Bundle m2076s(String str, String str2, double d, String str3, String str4) {
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        String m2503f = SmoneyApplication.f4207g.m2503f(str, str4);
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("userId", str);
        hashMap.put("amount", String.valueOf(d));
        hashMap.put(Constants.ScionAnalytics.PARAM_LABEL, str3);
        hashMap.put("passOTP", m2503f);
        sb.append(str);
        if (str2 != null) {
            hashMap.put("sessionId", str2);
            sb.append(",");
            sb.append(str2);
        }
        sb.append(",");
        sb.append(d);
        sb.append(",");
        sb.append(str3);
        sb.append(",");
        sb.append(m2503f);
        hashMap.put("print", SmoneyApplication.f4207g.m2502g(m2503f, sb.toString()));
        String m2083l = m2083l("https://soap.izly.fr/Service.asmx", "Service", "MoneyOutTransferConfirm", "Service/MoneyOutTransferConfirm", "2.0", hashMap);
        int i = f1272a;
        Bundle bundle = new Bundle();
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        C0291M8 c0291m8 = new C0291M8();
        xMLReader.setContentHandler(c0291m8);
        xMLReader.parse(new InputSource(new StringReader(m2083l)));
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            ServerError serverError = c0291m8.f974b;
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            MoneyOutTransferConfirmData moneyOutTransferConfirmData = c0291m8.f975c;
            if (moneyOutTransferConfirmData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.moneyOutTransferConfirmData", moneyOutTransferConfirmData);
            }
        }
        return bundle;
    }

    /* renamed from: t */
    public static Bundle m2075t(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6) {
        SetConfidentialitySettingsData setConfidentialitySettingsData;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/SetConfidentialitySettings", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("Photo", i);
        jSONObject2.put("Name", i2);
        jSONObject2.put("PhoneNumber", i3);
        jSONObject2.put("Alias", i4);
        jSONObject2.put("Address", i5);
        jSONObject2.put("Email", i6);
        jSONObject.put("settings", jSONObject2);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i7 = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i7)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i7));
        } else {
            JSONObject jSONObject3 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject3.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject3.getInt("Code");
                serverError2.f4603d = jSONObject3.getString("ErrorMessage");
                serverError2.f4605g = jSONObject3.getInt("Priority");
                serverError2.f4604f = jSONObject3.getString("Title");
                setConfidentialitySettingsData = null;
                serverError = serverError2;
            } else {
                setConfidentialitySettingsData = new SetConfidentialitySettingsData();
                if (!jSONObject3.isNull("UP")) {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject("UP");
                    setConfidentialitySettingsData.f4608a.f4230a = Double.parseDouble(jSONObject4.getString("BAL"));
                    setConfidentialitySettingsData.f4608a.f4232c = outline.m258m(jSONObject4, "LUD", C0091D8.f352a);
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (setConfidentialitySettingsData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.setConfidentialitySettingsData", setConfidentialitySettingsData);
            }
        }
        return bundle;
    }

    /* renamed from: u */
    public static Bundle m2074u(String str, String str2, int i, int i2, long j, long j2, boolean z, GetNewsFeedData getNewsFeedData) {
        GetNewsFeedData getNewsFeedData2;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/GetHomePageOperations?transactionGroup=", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        outline.m278C("sessionId", str2, m247x.f3729c);
        ServerError serverError = null;
        String m2217a = j != -1 ? C0278Ld.m2217a(j) : null;
        String m2217a2 = j2 != -1 ? C0278Ld.m2217a(j2) : null;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("currentPage", i);
        jSONObject.put("nbItemPerPage", i2);
        if (m2217a != null) {
            jSONObject.put(Constants.MessagePayloadKeys.FROM, m2217a);
        }
        if (m2217a2 != null) {
            jSONObject.put("to", m2217a2);
        }
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i3 = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i3)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i3));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                getNewsFeedData2 = null;
                serverError = serverError2;
            } else {
                getNewsFeedData2 = new GetNewsFeedData();
                JSONObject optJSONObject = jSONObject2.optJSONObject("GetNewsFeedResult");
                if (optJSONObject != null) {
                    if (!optJSONObject.isNull("UP")) {
                        getNewsFeedData2.f4336a = new BalanceData();
                        JSONObject jSONObject3 = optJSONObject.getJSONObject("UP");
                        getNewsFeedData2.f4336a.f4230a = Double.parseDouble(jSONObject3.getString("BAL"));
                        getNewsFeedData2.f4336a.f4231b = Double.parseDouble(jSONObject3.getString("CASHBAL"));
                        getNewsFeedData2.f4336a.f4232c = outline.m258m(jSONObject3, "LUD", C0091D8.f352a);
                    }
                    JSONArray optJSONArray = optJSONObject.optJSONArray("Result");
                    if (optJSONArray != null) {
                        int length = optJSONArray.length();
                        for (int i4 = 0; i4 < length; i4++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                            NewsFeedItem.EnumC1743a m966a = NewsFeedItem.m966a(optJSONObject2.optInt("OperationType"));
                            if (m966a != null) {
                                switch (m966a.ordinal()) {
                                    case 0:
                                    case 1:
                                    case 4:
                                    case 6:
                                    case 8:
                                        List<NewsFeedItem> list = getNewsFeedData2.f4341g;
                                        NewsFeedPaymentFeedItem newsFeedPaymentFeedItem = new NewsFeedPaymentFeedItem();
                                        m2092c(newsFeedPaymentFeedItem, optJSONObject2);
                                        m2091d(newsFeedPaymentFeedItem, optJSONObject2);
                                        list.add(newsFeedPaymentFeedItem);
                                        continue;
                                    case 2:
                                    case 3:
                                    case 10:
                                    case 11:
                                    case 14:
                                    case 15:
                                        List<NewsFeedItem> list2 = getNewsFeedData2.f4341g;
                                        NewsFeedMoneyOperationFeedItem newsFeedMoneyOperationFeedItem = new NewsFeedMoneyOperationFeedItem();
                                        m2092c(newsFeedMoneyOperationFeedItem, optJSONObject2);
                                        if (!optJSONObject2.isNull("Amount")) {
                                            newsFeedMoneyOperationFeedItem.f4529o = optJSONObject2.optDouble("Amount");
                                        }
                                        list2.add(newsFeedMoneyOperationFeedItem);
                                        continue;
                                    case 5:
                                        List<NewsFeedItem> list3 = getNewsFeedData2.f4341g;
                                        NewsFeedMoneyDemandFeedItem newsFeedMoneyDemandFeedItem = new NewsFeedMoneyDemandFeedItem();
                                        m2092c(newsFeedMoneyDemandFeedItem, optJSONObject2);
                                        m2091d(newsFeedMoneyDemandFeedItem, optJSONObject2);
                                        newsFeedMoneyDemandFeedItem.f4528r = optJSONObject2.optInt("NbRequests");
                                        list3.add(newsFeedMoneyDemandFeedItem);
                                        continue;
                                    case 7:
                                        List<NewsFeedItem> list4 = getNewsFeedData2.f4341g;
                                        NewsFeedEcommerce newsFeedEcommerce = new NewsFeedEcommerce();
                                        m2092c(newsFeedEcommerce, optJSONObject2);
                                        m2091d(newsFeedEcommerce, optJSONObject2);
                                        newsFeedEcommerce.f4469r = m2087h(optJSONObject2, "Reference");
                                        list4.add(newsFeedEcommerce);
                                        continue;
                                    case 9:
                                    case 12:
                                    case 13:
                                        List<NewsFeedItem> list5 = getNewsFeedData2.f4341g;
                                        NewsFeedCommissionOrPass newsFeedCommissionOrPass = new NewsFeedCommissionOrPass();
                                        m2092c(newsFeedCommissionOrPass, optJSONObject2);
                                        if (!optJSONObject2.isNull("Amount")) {
                                            newsFeedCommissionOrPass.f4464o = optJSONObject2.optDouble("Amount");
                                        }
                                        list5.add(newsFeedCommissionOrPass);
                                        continue;
                                }
                            }
                        }
                    }
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (getNewsFeedData2 != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.GetNewsFeed", getNewsFeedData2);
                bundle.putBoolean("fr.smoney.android.izly.extras.GetNewsFeedIsRefresh", z);
            }
        }
        return bundle;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00dc  */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle m2073v(java.lang.String r5, java.lang.String r6, int r7, java.lang.String r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, int r13, int r14, int r15) {
        /*
            java.lang.String r0 = "https://rest.izly.fr/Service/PublicService.svc/rest/ActivateUser"
            java.lang.String r1 = "1.0"
            b9 r0 = p000.outline.m247x(r0, r1)
            java.util.Locale r1 = java.util.Locale.getDefault()
            java.lang.String r1 = r1.getLanguage()
            java.util.ArrayList<org.apache.http.NameValuePair> r2 = r0.f3729c
            org.apache.http.message.BasicNameValuePair r3 = new org.apache.http.message.BasicNameValuePair
            java.lang.String r4 = "language"
            r3.<init>(r4, r1)
            r2.add(r3)
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "email"
            r1.put(r2, r5)
            java.lang.String r5 = "activationCode"
            r1.put(r5, r6)
            java.lang.String r5 = "civility"
            r1.put(r5, r7)
            java.lang.String r5 = "birthdate"
            r1.put(r5, r8)
            java.lang.String r5 = "country"
            r1.put(r5, r9)
            java.lang.String r5 = "password"
            r1.put(r5, r10)
            java.lang.String r5 = "secretQuestion"
            r1.put(r5, r11)
            java.lang.String r5 = "secretAnswer"
            r1.put(r5, r12)
            java.lang.String r5 = "cgu"
            r1.put(r5, r13)
            java.lang.String r5 = "optin"
            r1.put(r5, r14)
            java.lang.String r5 = "optinpartners"
            r1.put(r5, r15)
            java.lang.String r5 = r1.toString()
            r0.m1143c(r5)
            r5 = 1
            java.lang.String r5 = r0.m1144b(r5)
            r6 = 0
            int r7 = r5.length()
            if (r7 <= 0) goto Lcd
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>(r5)
            java.lang.String r5 = "ErrorMessage"
            boolean r8 = r7.isNull(r5)
            if (r8 != 0) goto L9e
            fr.smoney.android.izly.data.model.ServerError r8 = new fr.smoney.android.izly.data.model.ServerError
            r8.<init>()
            java.lang.String r9 = "Code"
            int r9 = r7.getInt(r9)
            r8.f4601b = r9
            java.lang.String r5 = r7.getString(r5)
            r8.f4603d = r5
            java.lang.String r5 = "Priority"
            int r5 = r7.getInt(r5)
            r8.f4605g = r5
            java.lang.String r5 = "Title"
            java.lang.String r5 = r7.getString(r5)
            r8.f4604f = r5
            r5 = r6
            r6 = r8
            goto Lce
        L9e:
            java.lang.String r5 = "ActivateUserResult"
            boolean r8 = r7.isNull(r5)
            if (r8 != 0) goto Lcd
            org.json.JSONObject r8 = new org.json.JSONObject
            java.lang.String r5 = r7.optString(r5)
            r8.<init>(r5)
            fr.smoney.android.izly.data.model.ActivateUserData r5 = new fr.smoney.android.izly.data.model.ActivateUserData
            r5.<init>()
            java.lang.String r7 = "Status"
            int r7 = r8.optInt(r7)
            r5.f4218a = r7
            java.lang.String r7 = "Token"
            java.lang.String r7 = r8.optString(r7)
            r5.f4219b = r7
            java.lang.String r7 = "Username"
            java.lang.String r7 = r8.optString(r7)
            r5.f4220c = r7
            goto Lce
        Lcd:
            r5 = r6
        Lce:
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            if (r6 == 0) goto Lda
            java.lang.String r8 = "fr.smoney.android.izly.extras.serverError"
            r7.putParcelable(r8, r6)
        Lda:
            if (r5 == 0) goto Le1
            java.lang.String r6 = "fr.smoney.android.izly.extras.ActivateUserData"
            r7.putParcelable(r6, r5)
        Le1:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0374Q7.m2073v(java.lang.String, java.lang.String, int, java.lang.String, int, java.lang.String, java.lang.String, java.lang.String, int, int, int):android.os.Bundle");
    }

    /* renamed from: w */
    public static Bundle m2072w(String str, String str2, long j, int i, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("userId", str);
        hashMap.put("sessionId", str2);
        hashMap.put("firstId", String.valueOf(j));
        hashMap.put("nbItems", String.valueOf(i));
        hashMap.put("filter", String.valueOf(i2));
        String m2083l = m2083l("https://soap.izly.fr/Service.asmx", "Service", "GetStatement", "Service/GetStatement", "6.0", hashMap);
        int i3 = f1272a;
        Bundle bundle = new Bundle();
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        C0337O8 c0337o8 = new C0337O8();
        xMLReader.setContentHandler(c0337o8);
        xMLReader.parse(new InputSource(new StringReader(m2083l)));
        if (SmoneyService.m946g(i3)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i3));
        } else {
            ServerError serverError = c0337o8.f1139b;
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            TransactionListData transactionListData = c0337o8.f1140c;
            if (transactionListData != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.transactionListData", transactionListData);
            }
        }
        return bundle;
    }

    /* renamed from: x */
    public static Bundle m2071x(String str, String str2, long j, int i, String str3) {
        C0973b9 c0973b9 = new C0973b9("https://rest.izly.fr/Service/PublicService.svc/rest/OpposeSupport");
        String m2503f = SmoneyApplication.f4207g.m2503f(str, str3);
        c0973b9.m1145a("1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), c0973b9.f3729c);
        outline.m278C("userId", str, c0973b9.f3729c);
        outline.m278C("sessionId", str2, c0973b9.f3729c);
        c0973b9.f3729c.add(new BasicNameValuePair("passOTP", m2503f));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("supportId", j);
        jSONObject.put("oppositionType", i);
        c0973b9.m1143c(jSONObject.toString());
        return m2084k(c0973b9.f3732f, c0973b9.m1144b(1));
    }

    /* renamed from: y */
    public static Bundle m2070y(String str, String str2, long j, String str3) {
        String m2503f = SmoneyApplication.f4207g.m2503f(str, str3);
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/LeveeSupport", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        outline.m278C("sessionId", str2, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("passOTP", m2503f));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("supportId", j);
        m247x.m1143c(jSONObject.toString());
        return m2084k(m247x.f3732f, m247x.m1144b(1));
    }

    /* renamed from: z */
    public static Bundle m2069z(String str, String str2, String str3) {
        ServerError serverError;
        C0973b9 m247x = outline.m247x("https://rest.izly.fr/Service/PublicService.svc/rest/CBDelete", "1.0");
        outline.m278C("language", Locale.getDefault().getLanguage(), m247x.f3729c);
        outline.m278C("userId", str, m247x.f3729c);
        m247x.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cbId", str3);
        m247x.m1143c(jSONObject.toString());
        String m1144b = m247x.m1144b(1);
        int i = m247x.f3732f;
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            if (jSONObject2.isNull("ErrorMessage")) {
                serverError = null;
            } else {
                serverError = new ServerError();
                serverError.f4601b = jSONObject2.getInt("Code");
                serverError.f4603d = jSONObject2.getString("ErrorMessage");
                serverError.f4605g = jSONObject2.getInt("Priority");
                serverError.f4604f = jSONObject2.getString("Title");
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
        }
        return bundle;
    }
}
