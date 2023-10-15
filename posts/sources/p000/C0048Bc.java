package p000;

import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import com.google.zxing.BarcodeFormat;

/* renamed from: Bc */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0048Bc {

    /* renamed from: a */
    public int f214a;

    /* renamed from: b */
    public String f215b;

    /* renamed from: c */
    public BarcodeFormat f216c;

    /* renamed from: d */
    public boolean f217d;

    public C0048Bc(String str, Bundle bundle, String str2, String str3, int i) {
        this.f214a = Integer.MIN_VALUE;
        this.f215b = null;
        this.f216c = null;
        boolean z = false;
        this.f217d = false;
        this.f214a = i;
        this.f216c = null;
        if (str3 != null) {
            try {
                this.f216c = BarcodeFormat.valueOf(str3);
            } catch (IllegalArgumentException unused) {
            }
        }
        BarcodeFormat barcodeFormat = this.f216c;
        if (barcodeFormat != null && barcodeFormat != BarcodeFormat.QR_CODE) {
            if (str != null && str.length() > 0) {
                this.f215b = str;
            }
        } else {
            this.f216c = BarcodeFormat.QR_CODE;
            if (str2.equals("TEXT_TYPE")) {
                if (str != null && str.length() > 0) {
                    this.f215b = str;
                }
            } else if (str2.equals("EMAIL_TYPE")) {
                String m2552a = m2552a(str);
                if (m2552a != null) {
                    this.f215b = outline.m266e("mailto:", m2552a);
                }
            } else if (str2.equals("PHONE_TYPE")) {
                String m2552a2 = m2552a(str);
                if (m2552a2 != null) {
                    this.f215b = outline.m266e("tel:", m2552a2);
                    PhoneNumberUtils.formatNumber(m2552a2);
                }
            } else if (str2.equals("SMS_TYPE")) {
                String m2552a3 = m2552a(str);
                if (m2552a3 != null) {
                    this.f215b = outline.m266e("sms:", m2552a3);
                    PhoneNumberUtils.formatNumber(m2552a3);
                }
            } else if (!str2.equals("CONTACT_TYPE")) {
                str2.equals("LOCATION_TYPE");
            }
        }
        String str4 = this.f215b;
        if (str4 != null && str4.length() > 0) {
            z = true;
        }
        this.f217d = z;
    }

    /* renamed from: a */
    public static String m2552a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim;
    }
}
