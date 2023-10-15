package p000;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: Qd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0383Qd<A, B> implements Serializable {

    /* renamed from: a */
    public final A f1293a;

    /* renamed from: b */
    public final B f1294b;

    public C0383Qd(A a, B b) {
        this.f1293a = a;
        this.f1294b = b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof C0383Qd) {
                C0383Qd c0383Qd = (C0383Qd) obj;
                return C0581Yd.m1770a(this.f1293a, c0383Qd.f1293a) && C0581Yd.m1770a(this.f1294b, c0383Qd.f1294b);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a = this.f1293a;
        int hashCode = (a != null ? a.hashCode() : 0) * 31;
        B b = this.f1294b;
        return hashCode + (b != null ? b.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return '(' + this.f1293a + ", " + this.f1294b + ')';
    }
}
