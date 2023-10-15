package p000;

/* renamed from: F8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0135F8 {

    /* renamed from: a */
    public static final String f443a;

    /* renamed from: b */
    public static final String f444b;

    static {
        StringBuilder m253r = outline.m253r("https://rest.izly.fr/");
        m253r.append("Service/PublicService.svc/rest/".toLowerCase());
        m253r.append("GetAccountStatementMobile");
        f443a = m253r.toString();
        StringBuilder m253r2 = outline.m253r("https://rest.izly.fr/");
        m253r2.append("Service/PublicService.svc/rest/".toLowerCase());
        m253r2.append("GetUserEventList");
        f444b = m253r2.toString();
    }
}
