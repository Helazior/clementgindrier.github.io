package p000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* renamed from: a4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0608a4 implements InterfaceC0957b4 {

    /* renamed from: b */
    public static final Locale[] f2170b = new Locale[0];

    /* renamed from: a */
    public final Locale[] f2171a;

    static {
        new Locale("en", "XA");
        new Locale("ar", "XB");
        int i = C0587Z3.f2098b;
        String[] split = "en-Latn".split("-", -1);
        if (split.length > 2) {
            new Locale(split[0], split[1], split[2]);
        } else if (split.length > 1) {
            new Locale(split[0], split[1]);
        } else if (split.length == 1) {
            new Locale(split[0]);
        } else {
            throw new IllegalArgumentException("Can not parse language tag: [en-Latn]");
        }
    }

    public C0608a4(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f2171a = f2170b;
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale != null) {
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    locale2.getLanguage();
                    String country = locale2.getCountry();
                    if (country != null && !country.isEmpty()) {
                        locale2.getCountry();
                    }
                    int length = localeArr.length - 1;
                    hashSet.add(locale2);
                }
            } else {
                throw new NullPointerException("list[" + i + "] is null");
            }
        }
        this.f2171a = (Locale[]) arrayList.toArray(new Locale[arrayList.size()]);
    }

    @Override // p000.InterfaceC0957b4
    /* renamed from: a */
    public Object mo1123a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0608a4)) {
            return false;
        }
        Locale[] localeArr = ((C0608a4) obj).f2171a;
        if (this.f2171a.length != localeArr.length) {
            return false;
        }
        int i = 0;
        while (true) {
            Locale[] localeArr2 = this.f2171a;
            if (i >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i].equals(localeArr[i])) {
                return false;
            }
            i++;
        }
    }

    @Override // p000.InterfaceC0957b4
    public Locale get(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.f2171a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    public int hashCode() {
        int i = 1;
        int i2 = 0;
        while (true) {
            Locale[] localeArr = this.f2171a;
            if (i2 >= localeArr.length) {
                return i;
            }
            i = (i * 31) + localeArr[i2].hashCode();
            i2++;
        }
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("[");
        int i = 0;
        while (true) {
            Locale[] localeArr = this.f2171a;
            if (i < localeArr.length) {
                m253r.append(localeArr[i]);
                if (i < this.f2171a.length - 1) {
                    m253r.append(',');
                }
                i++;
            } else {
                m253r.append("]");
                return m253r.toString();
            }
        }
    }
}
