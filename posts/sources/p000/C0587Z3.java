package p000;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;

/* renamed from: Z3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0587Z3 {

    /* renamed from: b */
    public static final /* synthetic */ int f2098b = 0;

    /* renamed from: a */
    public InterfaceC0957b4 f2099a;

    static {
        m1749a(new Locale[0]);
    }

    public C0587Z3(InterfaceC0957b4 interfaceC0957b4) {
        this.f2099a = interfaceC0957b4;
    }

    /* renamed from: a */
    public static C0587Z3 m1749a(Locale... localeArr) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new C0587Z3(new C0987c4(new LocaleList(localeArr)));
        }
        return new C0587Z3(new C0608a4(localeArr));
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0587Z3) && this.f2099a.equals(((C0587Z3) obj).f2099a);
    }

    public int hashCode() {
        return this.f2099a.hashCode();
    }

    public String toString() {
        return this.f2099a.toString();
    }
}
