package p000;

import android.os.LocaleList;
import java.util.Locale;

/* renamed from: c4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0987c4 implements InterfaceC0957b4 {

    /* renamed from: a */
    public final LocaleList f3791a;

    public C0987c4(LocaleList localeList) {
        this.f3791a = localeList;
    }

    @Override // p000.InterfaceC0957b4
    /* renamed from: a */
    public Object mo1123a() {
        return this.f3791a;
    }

    public boolean equals(Object obj) {
        return this.f3791a.equals(((InterfaceC0957b4) obj).mo1123a());
    }

    @Override // p000.InterfaceC0957b4
    public Locale get(int i) {
        return this.f3791a.get(i);
    }

    public int hashCode() {
        return this.f3791a.hashCode();
    }

    public String toString() {
        return this.f3791a.toString();
    }
}
