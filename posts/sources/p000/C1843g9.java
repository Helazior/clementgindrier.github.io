package p000;

import android.os.Bundle;
import fr.smoney.android.izly.data.model.Event;
import fr.smoney.android.izly.data.model.GetEventList;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: g9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1843g9 {
    @NotNull
    /* renamed from: a */
    public static final Bundle m791a(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        GetEventList getEventList;
        C0581Yd.m1766e(str, "userId");
        C0581Yd.m1766e(str2, "sessionId");
        C0581Yd.m1766e(str3, "page");
        C0581Yd.m1766e(str4, "itemPerPage");
        C0973b9 c0973b9 = new C0973b9(C0135F8.f444b);
        c0973b9.m1145a("1.0");
        Locale locale = Locale.getDefault();
        C0581Yd.m1767d(locale, "Locale.getDefault()");
        outline.m278C("language", locale.getLanguage(), c0973b9.f3729c);
        outline.m278C("userId", str, c0973b9.f3729c);
        c0973b9.f3729c.add(new BasicNameValuePair("sessionId", str2));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("page", str3);
        jSONObject.put("itemPerPage", str4);
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
            if (!jSONObject2.isNull("ErrorMessage")) {
                ServerError serverError2 = new ServerError();
                serverError2.f4601b = jSONObject2.getInt("Code");
                serverError2.f4603d = jSONObject2.getString("ErrorMessage");
                serverError2.f4605g = jSONObject2.getInt("Priority");
                serverError2.f4604f = jSONObject2.getString("Title");
                serverError = serverError2;
                getEventList = null;
            } else if (jSONObject2.isNull("GetUserEventListResult")) {
                getEventList = null;
            } else {
                JSONArray jSONArray = jSONObject2.getJSONArray("GetUserEventListResult");
                int length = jSONArray.length();
                getEventList = new GetEventList();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                    Event event = new Event();
                    String m2087h = C0374Q7.m2087h(jSONObject3, "EventFormattedDate");
                    C0581Yd.m1767d(m2087h, "JSONUtils.getString(cbObject, JSON_TAG_EVENT_DATE)");
                    C0581Yd.m1766e(m2087h, "<set-?>");
                    event.f4271a = m2087h;
                    String m2087h2 = C0374Q7.m2087h(jSONObject3, "EventMessage");
                    C0581Yd.m1767d(m2087h2, "JSONUtils.getString(cbOb…, JSON_TAG_EVENT_MESSAGE)");
                    C0581Yd.m1766e(m2087h2, "<set-?>");
                    event.f4272b = m2087h2;
                    ArrayList<Event> arrayList = getEventList.f4332a;
                    if (arrayList != null) {
                        arrayList.add(event);
                    } else {
                        C0581Yd.m1761j("eventList");
                        throw null;
                    }
                }
            }
            if (serverError != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
            }
            if (getEventList != null) {
                bundle.putParcelable("fr.smoney.android.izly.extras.EventListData", getEventList);
            }
        }
        return bundle;
    }
}
