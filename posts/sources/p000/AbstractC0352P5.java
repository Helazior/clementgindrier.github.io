package p000;

import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import p000.AbstractC1917j6;

/* renamed from: P5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0352P5 {

    /* renamed from: b */
    public int f1189b;

    /* renamed from: c */
    public int f1190c;

    /* renamed from: d */
    public int f1191d;

    /* renamed from: e */
    public int f1192e;

    /* renamed from: f */
    public int f1193f;

    /* renamed from: g */
    public int f1194g;

    /* renamed from: h */
    public boolean f1195h;

    /* renamed from: i */
    public String f1196i;

    /* renamed from: j */
    public int f1197j;

    /* renamed from: k */
    public CharSequence f1198k;

    /* renamed from: l */
    public int f1199l;

    /* renamed from: m */
    public CharSequence f1200m;

    /* renamed from: n */
    public ArrayList<String> f1201n;

    /* renamed from: o */
    public ArrayList<String> f1202o;

    /* renamed from: a */
    public ArrayList<C0353a> f1188a = new ArrayList<>();

    /* renamed from: p */
    public boolean f1203p = false;

    /* renamed from: P5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0353a {

        /* renamed from: a */
        public int f1204a;

        /* renamed from: b */
        public Fragment f1205b;

        /* renamed from: c */
        public int f1206c;

        /* renamed from: d */
        public int f1207d;

        /* renamed from: e */
        public int f1208e;

        /* renamed from: f */
        public int f1209f;

        /* renamed from: g */
        public AbstractC1917j6.EnumC1919b f1210g;

        /* renamed from: h */
        public AbstractC1917j6.EnumC1919b f1211h;

        public C0353a() {
        }

        public C0353a(int i, Fragment fragment) {
            this.f1204a = i;
            this.f1205b = fragment;
            AbstractC1917j6.EnumC1919b enumC1919b = AbstractC1917j6.EnumC1919b.RESUMED;
            this.f1210g = enumC1919b;
            this.f1211h = enumC1919b;
        }
    }

    /* renamed from: b */
    public void m2154b(C0353a c0353a) {
        this.f1188a.add(c0353a);
        c0353a.f1206c = this.f1189b;
        c0353a.f1207d = this.f1190c;
        c0353a.f1208e = this.f1191d;
        c0353a.f1209f = this.f1192e;
    }

    /* renamed from: c */
    public abstract int mo2153c();

    /* renamed from: d */
    public abstract int mo2152d();

    /* renamed from: e */
    public abstract void mo2151e();

    /* renamed from: f */
    public abstract void mo2150f(int i, Fragment fragment, String str, int i2);

    /* renamed from: g */
    public abstract AbstractC0352P5 mo2149g(Fragment fragment);
}
