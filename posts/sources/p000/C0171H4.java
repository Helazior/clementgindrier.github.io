package p000;

import java.util.Objects;

/* renamed from: H4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0171H4 {

    /* renamed from: a */
    public final Object f566a;

    public C0171H4(Object obj) {
        this.f566a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0171H4.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f566a, ((C0171H4) obj).f566a);
    }

    public int hashCode() {
        Object obj = this.f566a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("DisplayCutoutCompat{");
        m253r.append(this.f566a);
        m253r.append("}");
        return m253r.toString();
    }
}
