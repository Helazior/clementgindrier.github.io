package p000;

import android.os.Bundle;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* renamed from: m9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1982m9 {
    @Nullable
    /* renamed from: a */
    public static final Bundle m591a(@NotNull String str, @NotNull String str2) {
        String str3;
        C0581Yd.m1766e(str, "userId");
        C0581Yd.m1766e(str2, "sessionId");
        C0973b9 c0973b9 = new C0973b9("https://rest.izly.fr/Service/PublicService.svc/rest/SendConfirmationCode");
        c0973b9.m1145a("1.0");
        Locale locale = Locale.getDefault();
        C0581Yd.m1767d(locale, "Locale.getDefault()");
        outline.m278C("language", locale.getLanguage(), c0973b9.f3729c);
        outline.m278C("userId", str, c0973b9.f3729c);
        c0973b9.f3729c.add(new BasicNameValuePair("sessionId", str2));
        String m1144b = c0973b9.m1144b(1);
        int i = c0973b9.f3732f;
        C0581Yd.m1767d(m1144b, "wsResponse");
        C0581Yd.m1766e(m1144b, "wsResponse");
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", C0374Q7.m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            ServerError serverError = null;
            if (jSONObject.isNull("ErrorMessage")) {
                str3 = null;
            } else {
                serverError = new ServerError();
                serverError.f4601b = jSONObject.getInt("Code");
                serverError.f4603d = jSONObject.getString("ErrorMessage");
                serverError.f4605g = jSONObject.getInt("Priority");
                serverError.f4604f = jSONObject.getString("Title");
                str3 = "";
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (str3 == null) {
                bundle.putString("fr.smoney.android.izly.extras.CheckSendConfirmationCode", str3);
            }
        }
        return bundle;
    }
}
