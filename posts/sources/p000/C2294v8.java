package p000;

import android.content.res.Resources;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.xmlpull.p019v1.XmlPullParser;

/* renamed from: v8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class outline {
    /* renamed from: A */
    public static void m280A(int i, Hashtable hashtable, String str) {
        hashtable.put(str, new Integer(i));
    }

    /* renamed from: B */
    public static void m279B(View$OnClickListenerC0599a view$OnClickListenerC0599a, int i, Resources.Theme theme, ImageView imageView) {
        imageView.setColorFilter(C0103E3.m2469a(view$OnClickListenerC0599a.getResources(), i, theme));
    }

    /* renamed from: C */
    public static void m278C(String str, String str2, ArrayList arrayList) {
        arrayList.add(new BasicNameValuePair(str, str2));
    }

    /* renamed from: D */
    public static void m277D(StringBuilder sb, String str, String str2, ConfigurableProvider configurableProvider, String str3) {
        sb.append(str);
        sb.append(str2);
        configurableProvider.addAlgorithm(str3, sb.toString());
    }

    /* renamed from: E */
    public static String m276E(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    /* renamed from: F */
    public static String m275F(Exception exc, StringBuilder sb) {
        sb.append(exc.toString());
        return sb.toString();
    }

    /* renamed from: G */
    public static String m274G(Object obj, StringBuilder sb) {
        sb.append(obj.getClass().getName());
        return sb.toString();
    }

    /* renamed from: H */
    public static String m273H(String str, int i) {
        return str + i;
    }

    /* renamed from: I */
    public static String m272I(String str, long j) {
        return str + j;
    }

    /* renamed from: J */
    public static String m271J(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    /* renamed from: a */
    public static float m270a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    /* renamed from: b */
    public static int m269b(int i, int i2, int i3, int i4) {
        return i + i2 + i3 + i4;
    }

    /* renamed from: c */
    public static String m268c(String str, IOException iOException) {
        return str + iOException;
    }

    /* renamed from: d */
    public static String m267d(String str, Object obj) {
        return str + obj;
    }

    /* renamed from: e */
    public static String m266e(String str, String str2) {
        return str + str2;
    }

    /* renamed from: f */
    public static String m265f(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* renamed from: g */
    public static String m264g(String str, String str2, String str3, String str4) {
        C0581Yd.m1767d(str, str2);
        Locale locale = Locale.getDefault();
        C0581Yd.m1767d(locale, str3);
        String upperCase = str.toUpperCase(locale);
        C0581Yd.m1767d(upperCase, str4);
        return upperCase;
    }

    /* renamed from: h */
    public static String m263h(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: i */
    public static String m262i(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: j */
    public static String m261j(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    /* renamed from: k */
    public static String m260k(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        return aSN1ObjectIdentifier + str;
    }

    /* renamed from: l */
    public static String m259l(ASN1Sequence aSN1Sequence, StringBuilder sb) {
        sb.append(aSN1Sequence.size());
        return sb.toString();
    }

    /* renamed from: m */
    public static long m258m(JSONObject jSONObject, String str, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.parse(jSONObject.getString(str)).getTime();
    }

    /* renamed from: n */
    public static String m257n(ASN1TaggedObject aSN1TaggedObject, StringBuilder sb) {
        sb.append(aSN1TaggedObject.getTagNo());
        return sb.toString();
    }

    /* renamed from: o */
    public static String m256o(CipherParameters cipherParameters, StringBuilder sb) {
        sb.append(cipherParameters.getClass().getName());
        return sb.toString();
    }

    /* renamed from: p */
    public static String m255p(XmlPullParser xmlPullParser, StringBuilder sb, String str) {
        sb.append(xmlPullParser.getPositionDescription());
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: q */
    public static String m254q(Object[] objArr, int i, String str, String str2) {
        String format = String.format(str, Arrays.copyOf(objArr, i));
        C0581Yd.m1767d(format, str2);
        return format;
    }

    /* renamed from: r */
    public static StringBuilder m253r(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    /* renamed from: s */
    public static StringBuilder m252s(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    /* renamed from: t */
    public static StringBuilder m251t(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* renamed from: u */
    public static StringBuilder m250u(String str, String str2, ConfigurableProvider configurableProvider, String str3, String str4) {
        configurableProvider.addAlgorithm(str3, str + str2);
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        return sb;
    }

    /* renamed from: v */
    public static StringBuilder m249v(StringBuilder sb, String str, String str2, ConfigurableProvider configurableProvider, String str3) {
        sb.append(str);
        sb.append(str2);
        configurableProvider.addAlgorithm(str3, sb.toString());
        return new StringBuilder();
    }

    /* renamed from: w */
    public static StringBuilder m248w(StringBuilder sb, String str, ConfigurableProvider configurableProvider, String str2, String str3) {
        sb.append(str);
        configurableProvider.addAlgorithm(str2, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str3);
        return sb2;
    }

    /* renamed from: x */
    public static C0973b9 m247x(String str, String str2) {
        C0973b9 c0973b9 = new C0973b9(str);
        c0973b9.m1145a(str2);
        return c0973b9;
    }

    /* renamed from: y */
    public static StringBuilder m246y(StringBuilder sb, ASN1ObjectIdentifier aSN1ObjectIdentifier, ConfigurableProvider configurableProvider, String str, String str2) {
        sb.append(aSN1ObjectIdentifier);
        configurableProvider.addAlgorithm(sb.toString(), str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        return sb2;
    }

    /* renamed from: z */
    public static void m245z(int i, HashMap hashMap, String str, int i2, String str2, int i3, String str3, int i4, String str4) {
        hashMap.put(str, Integer.valueOf(i));
        hashMap.put(str2, Integer.valueOf(i2));
        hashMap.put(str3, Integer.valueOf(i3));
        hashMap.put(str4, Integer.valueOf(i4));
    }
}
