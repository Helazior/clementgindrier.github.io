package p000;

import android.util.Base64;
import java.util.List;
import java.util.Objects;

/* renamed from: i4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1886i4 {

    /* renamed from: a */
    public final String f5242a;

    /* renamed from: b */
    public final String f5243b;

    /* renamed from: c */
    public final String f5244c;

    /* renamed from: d */
    public final List<List<byte[]>> f5245d;

    /* renamed from: e */
    public final String f5246e;

    public C1886i4(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f5242a = str;
        this.f5243b = str2;
        this.f5244c = str3;
        Objects.requireNonNull(list);
        this.f5245d = list;
        this.f5246e = str + "-" + str2 + "-" + str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder m253r = outline.m253r("FontRequest {mProviderAuthority: ");
        m253r.append(this.f5242a);
        m253r.append(", mProviderPackage: ");
        m253r.append(this.f5243b);
        m253r.append(", mQuery: ");
        m253r.append(this.f5244c);
        m253r.append(", mCertificates:");
        sb.append(m253r.toString());
        for (int i = 0; i < this.f5245d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f5245d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        return outline.m262i(sb, "}", "mCertificatesArray: 0");
    }
}
