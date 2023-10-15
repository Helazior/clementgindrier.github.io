package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.google.firebase.crashlytics.internal.common.CrashlyticsReportDataCapture;
import fr.smoney.android.izly.data.model.ActivateUserData;
import fr.smoney.android.izly.data.model.OAuthData;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.util.encoders.Hex;

/* renamed from: C8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0065C8 {

    /* renamed from: a */
    public OAuthData f289a = null;

    /* renamed from: b */
    public boolean f290b = false;

    /* renamed from: c */
    public boolean f291c = false;

    /* renamed from: d */
    public String f292d = null;

    /* renamed from: e */
    public boolean f293e = false;

    /* renamed from: f */
    public ActivateUserData f294f = null;

    /* renamed from: g */
    public Context f295g;

    public C0065C8(Context context) {
        this.f295g = context;
    }

    /* renamed from: a */
    public void m2511a() {
        SharedPreferences.Editor edit = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).edit();
        edit.remove("sharedPrefHotpCounter");
        edit.remove("sharedPrefHotpActivationCode");
        edit.remove("sharedPrefNsse");
        edit.commit();
    }

    /* renamed from: b */
    public void m2510b() {
        SharedPreferences.Editor edit = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).edit();
        edit.remove("ActivationUserData.UserName");
        edit.remove("ActivationUserData.Token");
        edit.remove("ActivationUserData.Status");
        this.f294f = null;
        edit.commit();
    }

    /* renamed from: c */
    public void m2509c() {
        this.f292d = null;
        SharedPreferences.Editor edit = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).edit();
        edit.remove("sharedPrefHotpUserId");
        edit.remove("sharedPrefHotpCounter");
        edit.remove("sharedPrefHotpActivationCode");
        edit.remove("sharedPrefNsse");
        edit.commit();
    }

    /* renamed from: d */
    public void m2508d() {
        SharedPreferences.Editor edit = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).edit();
        edit.remove("OAuth.AccessToken");
        edit.remove("OAuth.Expiration");
        edit.remove("OAuth.RefreshToken");
        this.f289a = null;
        edit.commit();
    }

    /* renamed from: e */
    public final String m2507e(String str) {
        String str2 = "";
        if (!format_phonenumber(str)) {
            return null;
        }
        SharedPreferences sharedPreferences = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0);
        try {
            try {
                Mac mac = Mac.getInstance("HmacSHA1");
                String string = sharedPreferences.getString("sharedPrefHotpActivationCode", "");
                String string2 = sharedPreferences.getString("sharedPrefHotpCounter", "");
                if (string.length() != 0 && string2.length() != 0) {
                    mac.init(new SecretKeySpec(Base64.decode(string, 8), mac.getAlgorithm()));
                    byte[] decode = Base64.decode(string2, 8);
                    int m2098a = C0374Q7.m2098a(decode);
                    byte[] bArr = new byte[8];
                    for (int i = 7; i >= 0; i--) {
                        bArr[i] = (byte) (m2098a & 255);
                        m2098a >>= 8;
                    }
                    String encodeToString = Base64.encodeToString(mac.doFinal(bArr), 8);
                    try {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString("sharedPrefHotpCounter", Base64.encodeToString(C0374Q7.m2089i(C0374Q7.m2098a(decode) + 1), 8));
                        edit.commit();
                        return encodeToString;
                    } catch (IllegalStateException e) {
                        e = e;
                        str2 = encodeToString;
                        String str3 = "IllegalStateException occurred :" + e;
                        return str2;
                    } catch (InvalidKeyException e2) {
                        e = e2;
                        str2 = encodeToString;
                        String str4 = "InvalidKeyException occurred :" + e;
                        return str2;
                    } catch (NoSuchAlgorithmException e3) {
                        e = e3;
                        str2 = encodeToString;
                        String str5 = "NoSuchAlgorithmException occurred :" + e;
                        return str2;
                    } catch (DataLengthException e4) {
                        e = e4;
                        str2 = encodeToString;
                        String str6 = "DataLengthException occurred :" + e;
                        return str2;
                    }
                }
                throw new IllegalArgumentException("Activation code or Counter is empty");
            } catch (IllegalStateException e5) {
                e = e5;
            } catch (InvalidKeyException e6) {
                e = e6;
            } catch (NoSuchAlgorithmException e7) {
                e = e7;
            } catch (DataLengthException e8) {
                e = e8;
            }
        } catch (IllegalArgumentException e9) {
            String str7 = "IllegalArgumentException occurred :" + e9;
            return "";
        }
    }

    /* renamed from: f */
    public String m2506f(String str, String str2) {
        if (str2 == null) {
            str2 = "";
        }
        String m2507e = m2507e(str);
        if (m2507e != null && m2507e.length() > 0) {
            m2507e = m2507e.substring(0, m2507e.length() - 1);
        }
        return str2.concat(m2507e);
    }

    /* renamed from: g */
    public String m2505g(String str, String str2) {
        String.format("Signature en clair : %s", str2);
        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(new SecretKeySpec(str.getBytes(), mac.getAlgorithm()));
            byte[] doFinal = mac.doFinal(str2.getBytes(Key.STRING_CHARSET_NAME));
            String.format("Signature après SHA1 in Hex format: %s", new String(Hex.encode(doFinal), Key.STRING_CHARSET_NAME));
            String str3 = new String(Base64.encode(doFinal, 8));
            String.format("Signature finale créée: %s", str3);
            return str3;
        } catch (UnsupportedEncodingException e) {
            String str4 = "UnsupportedEncodingException occurred :" + e;
            return "";
        } catch (IllegalArgumentException e2) {
            String str5 = "IllegalArgumentException occurred :" + e2;
            return "";
        } catch (IllegalStateException e3) {
            String str6 = "IllegalStateException occurred :" + e3;
            return "";
        } catch (InvalidKeyException e4) {
            String str7 = "InvalidKeyException occurred :" + e4;
            return "";
        } catch (NoSuchAlgorithmException e5) {
            String str8 = "NoSuchAlgorithmException occurred :" + e5;
            return "";
        }
    }

    /* renamed from: h */
    public ActivateUserData m2504h() {
        if (this.f294f == null && !this.f291c) {
            SharedPreferences sharedPreferences = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0);
            ActivateUserData activateUserData = null;
            String string = sharedPreferences.getString("ActivationUserData.UserName", null);
            String string2 = sharedPreferences.getString("ActivationUserData.Token", null);
            int i = sharedPreferences.getInt("ActivationUserData.Status", -1);
            this.f291c = true;
            if (string != null && string2 != null && i != -1) {
                activateUserData = new ActivateUserData(string, string2, i);
            }
            this.f294f = activateUserData;
        }
        return this.f294f;
    }

    /* renamed from: i */
    public OAuthData m2503i() {
        if (this.f289a == null && !this.f290b) {
            SharedPreferences sharedPreferences = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0);
            OAuthData oAuthData = null;
            String string = sharedPreferences.getString("OAuth.AccessToken", null);
            long j = sharedPreferences.getLong("OAuth.Expiration", -1L);
            String string2 = sharedPreferences.getString("OAuth.RefreshToken", null);
            this.f290b = true;
            if (string != null && j != -1 && string2 != null) {
                oAuthData = new OAuthData(string, string2, j);
            }
            this.f289a = oAuthData;
        }
        return this.f289a;
    }

    /* renamed from: j */
    public String user_id() {
        if (this.f292d == null && !this.f293e) {
            String string = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).getString("sharedPrefHotpUserId", null);
            this.f293e = true;
            this.f292d = string;
        }
        return this.f292d;
    }

    /* renamed from: k */
    public boolean is_user_id_null() {
        return user_id() == null;
    }

    /* renamed from: l */
    public boolean format_phonenumber(String str) {
        String user_id = user_id();
        if (user_id != null) {
            if (str.substring(0, 1).equals(CrashlyticsReportDataCapture.SIGNAL_DEFAULT)) {
                str = "33" + str.substring(1);
            }
            if (user_id.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public void editSharedPrefNsse(String str) {
        SharedPreferences.Editor edit = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).edit();
        edit.putString("sharedPrefNsse", str);
        edit.commit();
    }

    /* renamed from: n */
    public void m2498n(OAuthData oAuthData) {
        this.f289a = oAuthData;
        SharedPreferences.Editor edit = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).edit();
        edit.putString("OAuth.AccessToken", oAuthData.f4533a);
        edit.putLong("OAuth.Expiration", oAuthData.f4535c);
        edit.putString("OAuth.RefreshToken", oAuthData.f4534b);
        edit.commit();
    }

    /* renamed from: o */
    public void m2497o(String str) {
        this.f292d = str;
        SharedPreferences.Editor edit = this.f295g.getSharedPreferences("fr.smoney.android.izly.config.sp", 0).edit();
        edit.putString("sharedPrefHotpUserId", str);
        edit.remove("sharedPrefHotpCounter");
        edit.remove("sharedPrefHotpActivationCode");
        edit.commit();
    }
}
