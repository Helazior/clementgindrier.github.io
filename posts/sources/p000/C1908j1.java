package p000;

/* renamed from: j1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1908j1 extends AbstractC1952l1 {

    /* renamed from: c */
    public static volatile C1908j1 f5310c;

    /* renamed from: a */
    public AbstractC1952l1 f5311a;

    /* renamed from: b */
    public AbstractC1952l1 f5312b;

    public C1908j1() {
        C1932k1 c1932k1 = new C1932k1();
        this.f5312b = c1932k1;
        this.f5311a = c1932k1;
    }

    /* renamed from: b */
    public static C1908j1 m722b() {
        if (f5310c != null) {
            return f5310c;
        }
        synchronized (C1908j1.class) {
            if (f5310c == null) {
                f5310c = new C1908j1();
            }
        }
        return f5310c;
    }

    @Override // p000.AbstractC1952l1
    /* renamed from: a */
    public boolean mo635a() {
        return this.f5311a.mo635a();
    }
}
