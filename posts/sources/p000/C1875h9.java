package p000;

import android.os.Bundle;
import fr.smoney.android.izly.data.model.AccountStatement;
import fr.smoney.android.izly.data.model.GetAccountStatementMobileResult;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.util.Locale;
import java.util.Objects;
import org.apache.http.message.BasicNameValuePair;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* renamed from: h9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1875h9 {
    @NotNull
    /* renamed from: a */
    public static final Bundle m757a(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull AccountStatement accountStatement) {
        GetAccountStatementMobileResult getAccountStatementMobileResult;
        C0581Yd.m1766e(str, "userId");
        C0581Yd.m1766e(str2, "sessionId");
        C0581Yd.m1766e(str3, "month");
        C0581Yd.m1766e(str4, "year");
        C0581Yd.m1766e(accountStatement, "accountStatement");
        C0973b9 c0973b9 = new C0973b9(C0135F8.f443a);
        c0973b9.m1145a("1.0");
        Locale locale = Locale.getDefault();
        C0581Yd.m1767d(locale, "Locale.getDefault()");
        outline.m278C("language", locale.getLanguage(), c0973b9.f3729c);
        outline.m278C("userId", str, c0973b9.f3729c);
        c0973b9.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("month", str3);
        jSONObject.put("year", str4);
        c0973b9.m1143c(jSONObject.toString());
        String m1144b = c0973b9.m1144b(1);
        int i = c0973b9.f3732f;
        C0581Yd.m1767d(m1144b, "wsResponse");
        C0581Yd.m1766e(m1144b, "wsResponse");
        C0581Yd.m1766e(accountStatement, "accountStatement");
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", C0374Q7.m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                getAccountStatementMobileResult = null;
                serverError = serverError2;
            } else if (jSONObject2.isNull("GetAccountStatementMobileResult")) {
                getAccountStatementMobileResult = null;
            } else {
                String string = jSONObject2.getString("GetAccountStatementMobileResult");
                C0581Yd.m1767d(string, "jObject.getString(JSON_TAG_STATEMENT)");
                getAccountStatementMobileResult = new GetAccountStatementMobileResult();
                C0581Yd.m1766e(accountStatement, "<set-?>");
                getAccountStatementMobileResult.f4273a = accountStatement;
                AccountStatement m972a = getAccountStatementMobileResult.m972a();
                Objects.requireNonNull(m972a);
                C0581Yd.m1766e(string, "<set-?>");
                m972a.f4217c = string;
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (getAccountStatementMobileResult != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.AccountStatementList", getAccountStatementMobileResult);
            }
        }
        return bundle;
    }
}
