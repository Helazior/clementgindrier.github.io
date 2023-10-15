package p000;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import fr.smoney.android.izly.data.model.LoginData;
import fr.smoney.android.izly.data.requestmanager.SmoneyRequestManager;
import fr.smoney.android.izly.data.service.SmoneyService;
import java.io.IOException;
import java.util.Objects;
import org.kxml2.wap.Wbxml;
import p000.C1663e9;

/* renamed from: d9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AsyncTaskC1627d9 extends AsyncTask<Void, Void, String> {

    /* renamed from: d */
    public static final String f4020d = AsyncTaskC1627d9.class.getSimpleName();

    /* renamed from: a */
    public Context f4021a;

    /* renamed from: b */
    public SmoneyRequestManager f4022b;

    /* renamed from: c */
    public C0479U8 f4023c;

    public AsyncTaskC1627d9(Context context, SmoneyRequestManager smoneyRequestManager, C0479U8 c0479u8) {
        this.f4021a = context;
        this.f4022b = smoneyRequestManager;
        this.f4023c = c0479u8;
    }

    @Override // android.os.AsyncTask
    public String doInBackground(Void[] voidArr) {
        try {
            String str = f4020d + " doInBackground context:" + this.f4021a;
            return FirebaseInstanceId.getInstance().getToken("1074937585998", FirebaseMessaging.INSTANCE_ID_SCOPE);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(String str) {
        String str2 = str;
        LoginData loginData = this.f4023c.f1712b;
        if (loginData != null) {
            String str3 = loginData.f4358K;
            Context context = this.f4021a;
            int i = 0;
            SharedPreferences sharedPreferences = context.getSharedPreferences("fr.smoney.android.izly.config.sp", 0);
            String string = sharedPreferences.getInt("sharedPrefElemDeviceAppVersion", Integer.MIN_VALUE) == C0228Jd.m2357a(context) ? sharedPreferences.getString("sharedPrefElemDeviceRegistrationId", null) : null;
            if (string == null) {
                string = str2;
            }
            if (string == null) {
                SmoneyRequestManager smoneyRequestManager = this.f4022b;
                LoginData loginData2 = this.f4023c.f1712b;
                String str4 = loginData2.f4362a;
                String str5 = loginData2.f4364c;
                int size = smoneyRequestManager.f4688a.size();
                while (i < size) {
                    Intent valueAt = smoneyRequestManager.f4688a.valueAt(i);
                    if (valueAt.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 132 && valueAt.getStringExtra("fr.smoney.android.izly.extras.removeDeviceTokenUserId").equals(str4) && valueAt.getStringExtra("fr.smoney.android.izly.extras.removeDeviceTokenSessionId").equals(str5)) {
                        smoneyRequestManager.f4688a.keyAt(i);
                        return;
                    }
                    i++;
                }
                int nextInt = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent = new Intent(smoneyRequestManager.f4689b, SmoneyService.class);
                intent.putExtra("com.foxykeep.datadroid.extras.workerType", Wbxml.LITERAL_A);
                intent.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager.f4692e);
                intent.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt);
                intent.putExtra("fr.smoney.android.izly.extras.removeDeviceTokenUserId", str4);
                intent.putExtra("fr.smoney.android.izly.extras.removeDeviceTokenSessionId", str5);
                smoneyRequestManager.m956b(intent);
                smoneyRequestManager.f4688a.append(nextInt, intent);
                Objects.requireNonNull(smoneyRequestManager.f4693f);
                Objects.requireNonNull(smoneyRequestManager.f4693f);
            } else if (str3.equals(string)) {
            } else {
                SmoneyRequestManager smoneyRequestManager2 = this.f4022b;
                LoginData loginData3 = this.f4023c.f1712b;
                String str6 = loginData3.f4362a;
                String str7 = loginData3.f4364c;
                C1663e9.EnumC1664a enumC1664a = C1663e9.EnumC1664a.GCM;
                int size2 = smoneyRequestManager2.f4688a.size();
                while (i < size2) {
                    Intent valueAt2 = smoneyRequestManager2.f4688a.valueAt(i);
                    int i2 = size2;
                    if (valueAt2.getIntExtra("com.foxykeep.datadroid.extras.workerType", -1) == 131 && valueAt2.getStringExtra("fr.smoney.android.izly.extras.setDeviceTokenUserId").equals(str6) && valueAt2.getStringExtra("fr.smoney.android.izly.extras.setDeviceTokenSessionId").equals(str7) && valueAt2.getSerializableExtra("fr.smoney.android.izly.extras.setDeviceTokenType").equals(enumC1664a) && valueAt2.getStringExtra("fr.smoney.android.izly.extras.setDeviceTokenToken").equals(str2)) {
                        smoneyRequestManager2.f4688a.keyAt(i);
                        return;
                    } else {
                        i++;
                        size2 = i2;
                    }
                }
                int nextInt2 = SmoneyRequestManager.f4687g.nextInt(1000000);
                Intent intent2 = new Intent(smoneyRequestManager2.f4689b, SmoneyService.class);
                intent2.putExtra("com.foxykeep.datadroid.extras.workerType", Wbxml.STR_T);
                intent2.putExtra("com.foxykeep.datadroid.extras.receiver", smoneyRequestManager2.f4692e);
                intent2.putExtra("com.foxykeep.datadroid.extras.requestId", nextInt2);
                intent2.putExtra("fr.smoney.android.izly.extras.setDeviceTokenUserId", str6);
                intent2.putExtra("fr.smoney.android.izly.extras.setDeviceTokenSessionId", str7);
                intent2.putExtra("fr.smoney.android.izly.extras.setDeviceTokenType", enumC1664a);
                intent2.putExtra("fr.smoney.android.izly.extras.setDeviceTokenToken", str2);
                smoneyRequestManager2.m956b(intent2);
                smoneyRequestManager2.f4688a.append(nextInt2, intent2);
                Objects.requireNonNull(smoneyRequestManager2.f4693f);
                Objects.requireNonNull(smoneyRequestManager2.f4693f);
            }
        }
    }
}
