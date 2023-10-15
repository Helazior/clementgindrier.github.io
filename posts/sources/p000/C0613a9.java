package p000;

import org.ksoap2.serialization.SoapObject;

/* renamed from: a9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0613a9 extends SoapObject {

    /* renamed from: a */
    public String f2173a;

    public C0613a9(String str, String str2, String str3, String str4) {
        super(str, str2);
        this.f2173a = str3;
        addProperty("version", str4);
        addProperty("channel", "AIZ");
        addProperty("format", "T");
        addProperty("model", "A");
    }
}
