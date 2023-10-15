package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.stats.CodePackage;
import fr.smoney.android.izly.data.model.ServerError;
import fr.smoney.android.izly.data.model.SetDeviceTokenData;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Locale;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

/* renamed from: e9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1663e9 {

    /* renamed from: a */
    public static final String f4144a = "e9";

    /* renamed from: e9$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC1664a {
        GCM(CodePackage.GCM),
        C2DM("C2DM");
        

        /* renamed from: a */
        public String f4148a;

        EnumC1664a(String str) {
            this.f4148a = str;
        }
    }

    /* renamed from: a */
    public static Bundle m992a(Context context, String str, String str2, EnumC1664a enumC1664a, String str3) {
        StringBuilder sb = new StringBuilder();
        String str4 = f4144a;
        sb.append(str4);
        sb.append(" start context:");
        sb.append(context);
        Log.d("+++++", sb.toString());
        Log.d("+++++", str4 + " start userId:" + str);
        Log.d("+++++", str4 + " start sessionId:" + str2);
        Log.d("+++++", str4 + " start type:" + enumC1664a);
        Log.d("+++++", str4 + " start fcm registrationId:" + str3);
        HashMap hashMap = new HashMap();
        hashMap.put("language", Locale.getDefault().getLanguage());
        hashMap.put("userId", str);
        hashMap.put("sessionId", str2);
        hashMap.put("token", str3);
        hashMap.put("tokentype", enumC1664a.f4148a);
        String m2083l = C0374Q7.m2083l("https://soap.izly.fr/Service.asmx", "Service", "SetDeviceToken", "Service/SetDeviceToken", "1.0", hashMap);
        XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
        C0175H8 c0175h8 = new C0175H8();
        xMLReader.setContentHandler(c0175h8);
        xMLReader.parse(new InputSource(new StringReader(m2083l)));
        Bundle bundle = new Bundle();
        ServerError serverError = c0175h8.f578b;
        if (serverError != null) {
            bundle.putParcelable("fr.smoney.android.izly.extras.serverError", serverError);
        }
        SetDeviceTokenData setDeviceTokenData = c0175h8.f579c;
        if (setDeviceTokenData != null) {
            setDeviceTokenData.f4609a = str3;
            bundle.putParcelable("fr.smoney.android.izly.extras.setDeviceTokenData", setDeviceTokenData);
        }
        if (((ServerError) bundle.getParcelable("fr.smoney.android.izly.extras.serverError")) == null) {
            int m2357a = C0228Jd.m2357a(context);
            SharedPreferences.Editor edit = context.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).edit();
            edit.putString("sharedPrefElemDeviceRegistrationId", str3);
            edit.putInt("sharedPrefElemDeviceAppVersion", m2357a);
            edit.commit();
        }
        return bundle;
    }
}
