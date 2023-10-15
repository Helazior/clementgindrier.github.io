package p000;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.model.ActivateUserData;
import fr.smoney.android.izly.data.model.OAuthData;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* renamed from: b9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0973b9 {

    /* renamed from: a */
    public String f3727a;

    /* renamed from: b */
    public String f3728b;

    /* renamed from: c */
    public ArrayList<NameValuePair> f3729c = new ArrayList<>();

    /* renamed from: d */
    public ArrayList<NameValuePair> f3730d = new ArrayList<>();

    /* renamed from: e */
    public ArrayList<NameValuePair> f3731e = new ArrayList<>();

    /* renamed from: f */
    public int f3732f;

    /* renamed from: g */
    public String f3733g;

    public C0973b9(String str) {
        this.f3727a = str;
    }

    /* renamed from: a */
    public void m1145a(String str) {
        outline.m278C("version", str, this.f3729c);
        outline.m278C("channel", "AIZ", this.f3729c);
        outline.m278C("format", "T", this.f3729c);
        outline.m278C("model", "A", this.f3729c);
        outline.m278C("clientVersion", "4.3", this.f3729c);
        outline.m278C("smoneyClientType", "PART", this.f3729c);
        OAuthData m2500i = SmoneyApplication.f4207g.m2500i();
        if (m2500i != null) {
            outline.m278C("Authorization", "Bearer " + m2500i.f4533a, this.f3730d);
            return;
        }
        ActivateUserData m2501h = SmoneyApplication.f4207g.m2501h();
        if (m2501h != null) {
            this.f3729c.add(new BasicNameValuePair("Username", m2501h.f4220c));
            outline.m278C("Authorization", "Bearer " + m2501h.f4219b, this.f3729c);
        }
    }

    /* renamed from: b */
    public String m1144b(int i) {
        HttpURLConnection httpURLConnection;
        StringBuilder sb;
        if (i == 0) {
            if (!this.f3731e.isEmpty()) {
                int size = this.f3731e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 == 0) {
                        this.f3727a += "?" + this.f3731e.get(i2);
                    } else {
                        this.f3727a += "&" + this.f3731e.get(i2);
                    }
                }
            }
            httpURLConnection = (HttpURLConnection) new URL(this.f3727a).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            Iterator<NameValuePair> it = this.f3729c.iterator();
            while (it.hasNext()) {
                NameValuePair next = it.next();
                next.getName();
                next.getValue();
                httpURLConnection.addRequestProperty(next.getName(), next.getValue());
            }
            Iterator<NameValuePair> it2 = this.f3730d.iterator();
            while (it2.hasNext()) {
                NameValuePair next2 = it2.next();
                next2.getName();
                next2.getValue();
                httpURLConnection.setRequestProperty(next2.getName(), next2.getValue());
            }
            httpURLConnection.connect();
        } else if (i != 1) {
            httpURLConnection = null;
        } else {
            httpURLConnection = (HttpURLConnection) new URL(this.f3727a).openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(30000);
            httpURLConnection.setReadTimeout(30000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            Iterator<NameValuePair> it3 = this.f3729c.iterator();
            while (it3.hasNext()) {
                NameValuePair next3 = it3.next();
                next3.getName();
                next3.getValue();
                httpURLConnection.addRequestProperty(next3.getName(), next3.getValue());
            }
            Iterator<NameValuePair> it4 = this.f3730d.iterator();
            while (it4.hasNext()) {
                NameValuePair next4 = it4.next();
                next4.getName();
                next4.getValue();
                httpURLConnection.setRequestProperty(next4.getName(), next4.getValue());
            }
            if (!TextUtils.isEmpty(this.f3728b)) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(this.f3728b.getBytes(Key.STRING_CHARSET_NAME));
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
            httpURLConnection.connect();
        }
        this.f3732f = httpURLConnection.getResponseCode();
        this.f3733g = httpURLConnection.getResponseMessage();
        InputStream inputStream = httpURLConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            break;
                        } catch (IOException e) {
                            e = e;
                            sb = new StringBuilder();
                            sb.append("IOException occurred :");
                            sb.append(e);
                            sb.toString();
                            String sb3 = sb2.toString();
                            sb3.length();
                            httpURLConnection.disconnect();
                            return sb3;
                        }
                    }
                    sb2.append(readLine + "\n");
                } catch (IOException e2) {
                    String str = "IOException occurred :" + e2;
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("IOException occurred :");
                        sb.append(e);
                        sb.toString();
                        String sb32 = sb2.toString();
                        sb32.length();
                        httpURLConnection.disconnect();
                        return sb32;
                    }
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                    String str2 = "IOException occurred :" + e4;
                }
                throw th;
            }
        }
        inputStream.close();
        String sb322 = sb2.toString();
        sb322.length();
        httpURLConnection.disconnect();
        return sb322;
    }

    /* renamed from: c */
    public void m1143c(String str) {
        outline.m278C("Content-Type", DefaultSettingsSpiCall.ACCEPT_JSON_VALUE, this.f3729c);
        this.f3728b = str;
    }
}
