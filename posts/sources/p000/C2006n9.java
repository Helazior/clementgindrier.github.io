package p000;

import android.os.Bundle;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* renamed from: n9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2006n9 {
    @Nullable
    /* renamed from: a */
    public static final Bundle m563a(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        String str4;
        C0581Yd.m1766e(str, "userId");
        C0581Yd.m1766e(str2, "sessionId");
        C0581Yd.m1766e(str3, "otp");
        C0973b9 c0973b9 = new C0973b9("https://rest.izly.fr/Service/PublicService.svc/rest/ConfirmTerminateContractIzlyMobile");
        c0973b9.m1145a("1.0");
        Locale locale = Locale.getDefault();
        C0581Yd.m1767d(locale, "Locale.getDefault()");
        outline.m278C("language", locale.getLanguage(), c0973b9.f3729c);
        outline.m278C("userId", str, c0973b9.f3729c);
        c0973b9.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("otp", str3);
        c0973b9.m1143c(jSONObject.toString());
        String m1144b = c0973b9.m1144b(1);
        int i = c0973b9.f3732f;
        C0581Yd.m1767d(m1144b, "wsResponse");
        C0581Yd.m1766e(m1144b, "wsResponse");
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", C0374Q7.m2082m(i));
        } else {
            JSONObject jSONObject2 = new JSONObject(m1144b);
            ServerError serverError = null;
            if (jSONObject2.isNull("ErrorMessage")) {
                str4 = null;
            } else {
                serverError = new ServerError();
                serverError.f4601b = jSONObject2.getInt("Code");
                serverError.f4603d = jSONObject2.getString("ErrorMessage");
                serverError.f4605g = jSONObject2.getInt("Priority");
                serverError.f4604f = jSONObject2.getString("Title");
                str4 = "";
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (str4 == null) {
                bundle.putString("fr.smoney.android.izly.extras.CheckSendConfirmationCode", str4);
            }
        }
        return bundle;
    }
}
