package p000;

import android.os.Bundle;
import fr.smoney.android.izly.data.model.ActuDetail;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* renamed from: i9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1895i9 {
    @NotNull
    /* renamed from: a */
    public static final Bundle m726a(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        String str4;
        ServerError serverError;
        EnumC0520V8 enumC0520V8;
        C0581Yd.m1766e(str, "userId");
        C0581Yd.m1766e(str2, "sessionId");
        C0581Yd.m1766e(str3, "actuId");
        C0973b9 c0973b9 = new C0973b9(outline.m266e("https://rest.izly.fr/Service/PublicService.svc/rest/GetNewsById?id=", str3));
        c0973b9.m1145a("1.0");
        Locale locale = Locale.getDefault();
        C0581Yd.m1767d(locale, "Locale.getDefault()");
        outline.m278C("language", locale.getLanguage(), c0973b9.f3729c);
        outline.m278C("userId", str, c0973b9.f3729c);
        c0973b9.f3729c.add(new BasicNameValuePair("sessionId", str2));
        int i = 0;
        String m1144b = c0973b9.m1144b(0);
        int i2 = c0973b9.f3732f;
        C0581Yd.m1767d(m1144b, "wsResponse");
        C0581Yd.m1766e(m1144b, "wsResponse");
        Bundle bundle = new Bundle();
        ActuDetail actuDetail = new ActuDetail();
        if (SmoneyService.m946g(i2)) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", C0374Q7.m2082m(i2));
        } else {
            JSONObject jSONObject = new JSONObject(m1144b);
            if (!jSONObject.isNull("ErrorMessage")) {
                serverError = new ServerError();
                serverError.f4601b = jSONObject.getInt("Code");
                serverError.f4603d = jSONObject.getString("ErrorMessage");
                serverError.f4605g = jSONObject.getInt("Priority");
                serverError.f4604f = jSONObject.getString("Title");
            } else {
                JSONObject jSONObject2 = jSONObject.getJSONObject("Result");
                if (!jSONObject2.isNull("Id")) {
                    actuDetail.f4221a = jSONObject2.getLong("Id");
                }
                if (!jSONObject2.isNull("Title")) {
                    String string = jSONObject2.getString("Title");
                    C0581Yd.m1767d(string, "cbObject.getString(JSON_GET_ACTUS_DETAIL_TITLE)");
                    C0581Yd.m1766e(string, "<set-?>");
                    actuDetail.f4222b = string;
                }
                if (!jSONObject2.isNull("Subtitle")) {
                    String string2 = jSONObject2.getString("Subtitle");
                    C0581Yd.m1767d(string2, "cbObject.getString(JSON_GET_ACTUS_DETAIL_SUBTITLE)");
                    C0581Yd.m1766e(string2, "<set-?>");
                    actuDetail.f4223c = string2;
                }
                if (!jSONObject2.isNull("ShortDescription")) {
                    String string3 = jSONObject2.getString("ShortDescription");
                    C0581Yd.m1767d(string3, "cbObject.getString(JSON_…T_ACTUS_DETAIL_SHORTDESC)");
                    C0581Yd.m1766e(string3, "<set-?>");
                    actuDetail.f4224d = string3;
                }
                if (!jSONObject2.isNull("LongDescription")) {
                    String string4 = jSONObject2.getString("LongDescription");
                    C0581Yd.m1767d(string4, "cbObject.getString(JSON_GET_ACTUS_DETAIL_LONGDESC)");
                    C0581Yd.m1766e(string4, "<set-?>");
                    actuDetail.f4225f = string4;
                }
                if (jSONObject2.isNull("TargetURL")) {
                    str4 = "None";
                } else {
                    str4 = jSONObject2.getString("TargetURL");
                    C0581Yd.m1767d(str4, "cbObject.getString(JSON_GET_ACTUS_DETAIL_URL)");
                }
                actuDetail.m975a(str4);
                if (!jSONObject2.isNull("Base64Image")) {
                    String string5 = jSONObject2.getString("Base64Image");
                    C0581Yd.m1767d(string5, "cbObject.getString(JSON_GET_ACTUS_DETAIL_IMAGE)");
                    C0581Yd.m1766e(string5, "<set-?>");
                    actuDetail.f4227h = string5;
                }
                if (!jSONObject2.isNull("Theme")) {
                    Integer valueOf = Integer.valueOf(jSONObject2.getInt("Theme"));
                    EnumC0520V8[] values = EnumC0520V8.values();
                    while (true) {
                        if (i < 6) {
                            enumC0520V8 = values[i];
                            int i3 = enumC0520V8.f1850a;
                            if (valueOf != null && i3 == valueOf.intValue()) {
                                break;
                            }
                            i++;
                        } else {
                            enumC0520V8 = EnumC0520V8.ERROR;
                            break;
                        }
                    }
                    C0581Yd.m1766e(enumC0520V8, "<set-?>");
                    actuDetail.f4226g = enumC0520V8;
                }
                serverError = null;
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            bundle.putParcelable("fr.smoney.android.izly.extras.ActuDetailData", actuDetail);
        }
        return bundle;
    }
}
