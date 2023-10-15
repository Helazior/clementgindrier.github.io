package p000;

/* renamed from: T0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0443T0 {

    /* renamed from: a */
    public int f1441a = 0;

    /* renamed from: b */
    public int f1442b = 0;

    /* renamed from: c */
    public int f1443c = Integer.MIN_VALUE;

    /* renamed from: d */
    public int f1444d = Integer.MIN_VALUE;

    /* renamed from: e */
    public int f1445e = 0;

    /* renamed from: f */
    public int f1446f = 0;

    /* renamed from: g */
    public boolean f1447g = false;

    /* renamed from: h */
    public boolean f1448h = false;

    /* renamed from: a */
    public void m2035a(int i, int i2) {
        this.f1443c = i;
        this.f1444d = i2;
        this.f1448h = true;
        if (this.f1447g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1441a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1442b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1441a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1442b = i2;
        }
    }
}
