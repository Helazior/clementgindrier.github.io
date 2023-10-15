package p000;

import android.os.Bundle;
import fr.smoney.android.izly.data.model.PaymentInitiationLimits;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: k9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1941k9 {
    @Nullable
    /* renamed from: a */
    public static final Bundle m677a(@NotNull String str, @NotNull String str2) {
        PaymentInitiationLimits paymentInitiationLimits;
        C0581Yd.m1766e(str, "userId");
        C0581Yd.m1766e(str2, "sessionId");
        C0973b9 c0973b9 = new C0973b9("https://rest.izly.fr/Service/PublicService.svc/rest/GetPaymentInitiationLimits");
        c0973b9.m1145a("1.0");
        Locale locale = Locale.getDefault();
        C0581Yd.m1767d(locale, "Locale.getDefault()");
        outline.m278C("language", locale.getLanguage(), c0973b9.f3729c);
        outline.m278C("userId", str, c0973b9.f3729c);
        c0973b9.f3729c.add(new BasicNameValuePair("sessionId", str2));
        String m1144b = c0973b9.m1144b(0);
        int i = c0973b9.f3732f;
        C0581Yd.m1767d(m1144b, "wsResponse");
        C0581Yd.m1766e(m1144b, "wsResponse");
        Bundle bundle = new Bundle();
        if (SmoneyService.m946g(i)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", C0374Q7.m2082m(i));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            ServerError serverError = null;
            if (!jSONObject.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject.getInt("Code");
                serverError2.f4603d = jSONObject.getString("ErrorMessage");
                serverError2.f4605g = jSONObject.getInt("Priority");
                serverError2.f4604f = jSONObject.getString("Title");
                paymentInitiationLimits = null;
                serverError = serverError2;
            } else {
                paymentInitiationLimits = new PaymentInitiationLimits();
                JSONObject optJSONObject = jSONObject.optJSONObject("Result");
                if (optJSONObject != null) {
                    if (!optJSONObject.isNull("Min")) {
                        paymentInitiationLimits.f4537b = optJSONObject.getDouble("Min");
                    }
                    if (!optJSONObject.isNull("Max")) {
                        paymentInitiationLimits.f4536a = optJSONObject.getDouble("Max");
                    }
                    if (!optJSONObject.isNull("Steps")) {
                        JSONArray jSONArray = optJSONObject.getJSONArray("Steps");
                        int[] iArr = new int[jSONArray.length()];
                        C0581Yd.m1766e(iArr, "<set-?>");
                        paymentInitiationLimits.f4538c = iArr;
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            int[] iArr2 = paymentInitiationLimits.f4538c;
                            if (iArr2 != null) {
                                iArr2[i2] = jSONArray.getInt(i2);
                            } else {
                                C0581Yd.m1761j("stepsArray");
                                throw null;
                            }
                        }
                    }
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (paymentInitiationLimits != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.PaymentInititationLimits", paymentInitiationLimits);
            }
        }
        return bundle;
    }
}
