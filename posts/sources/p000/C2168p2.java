package p000;

import java.util.Arrays;

/* renamed from: p2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2168p2 {

    /* renamed from: n */
    public static int f6176n = 1;

    /* renamed from: a */
    public boolean f6177a;

    /* renamed from: e */
    public float f6181e;

    /* renamed from: i */
    public EnumC2169a f6185i;

    /* renamed from: b */
    public int f6178b = -1;

    /* renamed from: c */
    public int f6179c = -1;

    /* renamed from: d */
    public int f6180d = 0;

    /* renamed from: f */
    public boolean f6182f = false;

    /* renamed from: g */
    public float[] f6183g = new float[9];

    /* renamed from: h */
    public float[] f6184h = new float[9];

    /* renamed from: j */
    public C1909j2[] f6186j = new C1909j2[16];

    /* renamed from: k */
    public int f6187k = 0;

    /* renamed from: l */
    public int f6188l = 0;

    /* renamed from: m */
    public int f6189m = -1;

    /* renamed from: p2$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public enum EnumC2169a {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public C2168p2(EnumC2169a enumC2169a) {
        this.f6185i = enumC2169a;
    }

    /* renamed from: a */
    public final void m457a(C1909j2 c1909j2) {
        int i = 0;
        while (true) {
            int i2 = this.f6187k;
            if (i < i2) {
                if (this.f6186j[i] == c1909j2) {
                    return;
                }
                i++;
            } else {
                C1909j2[] c1909j2Arr = this.f6186j;
                if (i2 >= c1909j2Arr.length) {
                    this.f6186j = (C1909j2[]) Arrays.copyOf(c1909j2Arr, c1909j2Arr.length * 2);
                }
                C1909j2[] c1909j2Arr2 = this.f6186j;
                int i3 = this.f6187k;
                c1909j2Arr2[i3] = c1909j2;
                this.f6187k = i3 + 1;
                return;
            }
        }
    }

    /* renamed from: b */
    public final void m456b(C1909j2 c1909j2) {
        int i = this.f6187k;
        int i2 = 0;
        while (i2 < i) {
            if (this.f6186j[i2] == c1909j2) {
                while (i2 < i - 1) {
                    C1909j2[] c1909j2Arr = this.f6186j;
                    int i3 = i2 + 1;
                    c1909j2Arr[i2] = c1909j2Arr[i3];
                    i2 = i3;
                }
                this.f6187k--;
                return;
            }
            i2++;
        }
    }

    /* renamed from: c */
    public void m455c() {
        this.f6185i = EnumC2169a.UNKNOWN;
        this.f6180d = 0;
        this.f6178b = -1;
        this.f6179c = -1;
        this.f6181e = 0.0f;
        this.f6182f = false;
        this.f6189m = -1;
        int i = this.f6187k;
        for (int i2 = 0; i2 < i; i2++) {
            this.f6186j[i2] = null;
        }
        this.f6187k = 0;
        this.f6188l = 0;
        this.f6177a = false;
        Arrays.fill(this.f6184h, 0.0f);
    }

    /* renamed from: d */
    public void m454d(C1953l2 c1953l2, float f) {
        this.f6181e = f;
        this.f6182f = true;
        this.f6189m = -1;
        int i = this.f6187k;
        this.f6179c = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.f6186j[i2].m713k(c1953l2, this, false);
        }
        this.f6187k = 0;
    }

    /* renamed from: e */
    public final void m453e(C1953l2 c1953l2, C1909j2 c1909j2) {
        int i = this.f6187k;
        for (int i2 = 0; i2 < i; i2++) {
            this.f6186j[i2].mo536l(c1953l2, c1909j2, false);
        }
        this.f6187k = 0;
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("");
        m253r.append(this.f6178b);
        return m253r.toString();
    }
}
