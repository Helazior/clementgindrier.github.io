package p000;

import java.util.Objects;

/* renamed from: A4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0018A4<F, S> {

    /* renamed from: a */
    public final F f126a;

    /* renamed from: b */
    public final S f127b;

    public C0018A4(F f, S s) {
        this.f126a = f;
        this.f127b = s;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0018A4) {
            C0018A4 c0018a4 = (C0018A4) obj;
            return Objects.equals(c0018a4.f126a, this.f126a) && Objects.equals(c0018a4.f127b, this.f127b);
        }
        return false;
    }

    public int hashCode() {
        F f = this.f126a;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.f127b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("Pair{");
        m253r.append(this.f126a);
        m253r.append(" ");
        m253r.append(this.f127b);
        m253r.append("}");
        return m253r.toString();
    }
}
