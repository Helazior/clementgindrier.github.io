package p000;

import java.util.Arrays;
import p000.C1909j2;

/* renamed from: i2 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1884i2 implements C1909j2.InterfaceC1910a {

    /* renamed from: b */
    public final C1909j2 f5232b;

    /* renamed from: c */
    public final C1934k2 f5233c;

    /* renamed from: a */
    public int f5231a = 0;

    /* renamed from: d */
    public int f5234d = 8;

    /* renamed from: e */
    public int[] f5235e = new int[8];

    /* renamed from: f */
    public int[] f5236f = new int[8];

    /* renamed from: g */
    public float[] f5237g = new float[8];

    /* renamed from: h */
    public int f5238h = -1;

    /* renamed from: i */
    public int f5239i = -1;

    /* renamed from: j */
    public boolean f5240j = false;

    public C1884i2(C1909j2 c1909j2, C1934k2 c1934k2) {
        this.f5232b = c1909j2;
        this.f5233c = c1934k2;
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: a */
    public float mo712a(int i) {
        int i2 = this.f5238h;
        for (int i3 = 0; i2 != -1 && i3 < this.f5231a; i3++) {
            if (i3 == i) {
                return this.f5237g[i2];
            }
            i2 = this.f5236f[i2];
        }
        return 0.0f;
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: b */
    public void mo711b(C2168p2 c2168p2, float f, boolean z) {
        if (f <= -0.001f || f >= 0.001f) {
            int i = this.f5238h;
            if (i == -1) {
                this.f5238h = 0;
                this.f5237g[0] = f;
                this.f5235e[0] = c2168p2.f6178b;
                this.f5236f[0] = -1;
                c2168p2.f6188l++;
                c2168p2.m457a(this.f5232b);
                this.f5231a++;
                if (this.f5240j) {
                    return;
                }
                int i2 = this.f5239i + 1;
                this.f5239i = i2;
                int[] iArr = this.f5235e;
                if (i2 >= iArr.length) {
                    this.f5240j = true;
                    this.f5239i = iArr.length - 1;
                    return;
                }
                return;
            }
            int i3 = -1;
            for (int i4 = 0; i != -1 && i4 < this.f5231a; i4++) {
                int[] iArr2 = this.f5235e;
                int i5 = iArr2[i];
                int i6 = c2168p2.f6178b;
                if (i5 == i6) {
                    float[] fArr = this.f5237g;
                    float f2 = fArr[i] + f;
                    if (f2 > -0.001f && f2 < 0.001f) {
                        f2 = 0.0f;
                    }
                    fArr[i] = f2;
                    if (f2 == 0.0f) {
                        if (i == this.f5238h) {
                            this.f5238h = this.f5236f[i];
                        } else {
                            int[] iArr3 = this.f5236f;
                            iArr3[i3] = iArr3[i];
                        }
                        if (z) {
                            c2168p2.m456b(this.f5232b);
                        }
                        if (this.f5240j) {
                            this.f5239i = i;
                        }
                        c2168p2.f6188l--;
                        this.f5231a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i] < i6) {
                    i3 = i;
                }
                i = this.f5236f[i];
            }
            int i7 = this.f5239i;
            int i8 = i7 + 1;
            if (this.f5240j) {
                int[] iArr4 = this.f5235e;
                if (iArr4[i7] != -1) {
                    i7 = iArr4.length;
                }
            } else {
                i7 = i8;
            }
            int[] iArr5 = this.f5235e;
            if (i7 >= iArr5.length && this.f5231a < iArr5.length) {
                int i9 = 0;
                while (true) {
                    int[] iArr6 = this.f5235e;
                    if (i9 >= iArr6.length) {
                        break;
                    } else if (iArr6[i9] == -1) {
                        i7 = i9;
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            int[] iArr7 = this.f5235e;
            if (i7 >= iArr7.length) {
                i7 = iArr7.length;
                int i10 = this.f5234d * 2;
                this.f5234d = i10;
                this.f5240j = false;
                this.f5239i = i7 - 1;
                this.f5237g = Arrays.copyOf(this.f5237g, i10);
                this.f5235e = Arrays.copyOf(this.f5235e, this.f5234d);
                this.f5236f = Arrays.copyOf(this.f5236f, this.f5234d);
            }
            this.f5235e[i7] = c2168p2.f6178b;
            this.f5237g[i7] = f;
            if (i3 != -1) {
                int[] iArr8 = this.f5236f;
                iArr8[i7] = iArr8[i3];
                iArr8[i3] = i7;
            } else {
                this.f5236f[i7] = this.f5238h;
                this.f5238h = i7;
            }
            c2168p2.f6188l++;
            c2168p2.m457a(this.f5232b);
            this.f5231a++;
            if (!this.f5240j) {
                this.f5239i++;
            }
            int i11 = this.f5239i;
            int[] iArr9 = this.f5235e;
            if (i11 >= iArr9.length) {
                this.f5240j = true;
                this.f5239i = iArr9.length - 1;
            }
        }
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: c */
    public final float mo710c(C2168p2 c2168p2) {
        int i = this.f5238h;
        for (int i2 = 0; i != -1 && i2 < this.f5231a; i2++) {
            if (this.f5235e[i] == c2168p2.f6178b) {
                return this.f5237g[i];
            }
            i = this.f5236f[i];
        }
        return 0.0f;
    }

    @Override // p000.C1909j2.InterfaceC1910a
    public final void clear() {
        int i = this.f5238h;
        for (int i2 = 0; i != -1 && i2 < this.f5231a; i2++) {
            C2168p2 c2168p2 = this.f5233c.f5379d[this.f5235e[i]];
            if (c2168p2 != null) {
                c2168p2.m456b(this.f5232b);
            }
            i = this.f5236f[i];
        }
        this.f5238h = -1;
        this.f5239i = -1;
        this.f5240j = false;
        this.f5231a = 0;
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: d */
    public boolean mo709d(C2168p2 c2168p2) {
        int i = this.f5238h;
        if (i == -1) {
            return false;
        }
        for (int i2 = 0; i != -1 && i2 < this.f5231a; i2++) {
            if (this.f5235e[i] == c2168p2.f6178b) {
                return true;
            }
            i = this.f5236f[i];
        }
        return false;
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: e */
    public float mo708e(C1909j2 c1909j2, boolean z) {
        float mo710c = mo710c(c1909j2.f5313a);
        mo706g(c1909j2.f5313a, z);
        C1909j2.InterfaceC1910a interfaceC1910a = c1909j2.f5316d;
        int currentSize = interfaceC1910a.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            C2168p2 mo705h = interfaceC1910a.mo705h(i);
            mo711b(mo705h, interfaceC1910a.mo710c(mo705h) * mo710c, z);
        }
        return mo710c;
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: f */
    public final void mo707f(C2168p2 c2168p2, float f) {
        if (f == 0.0f) {
            mo706g(c2168p2, true);
            return;
        }
        int i = this.f5238h;
        if (i == -1) {
            this.f5238h = 0;
            this.f5237g[0] = f;
            this.f5235e[0] = c2168p2.f6178b;
            this.f5236f[0] = -1;
            c2168p2.f6188l++;
            c2168p2.m457a(this.f5232b);
            this.f5231a++;
            if (this.f5240j) {
                return;
            }
            int i2 = this.f5239i + 1;
            this.f5239i = i2;
            int[] iArr = this.f5235e;
            if (i2 >= iArr.length) {
                this.f5240j = true;
                this.f5239i = iArr.length - 1;
                return;
            }
            return;
        }
        int i3 = -1;
        for (int i4 = 0; i != -1 && i4 < this.f5231a; i4++) {
            int[] iArr2 = this.f5235e;
            int i5 = iArr2[i];
            int i6 = c2168p2.f6178b;
            if (i5 == i6) {
                this.f5237g[i] = f;
                return;
            }
            if (iArr2[i] < i6) {
                i3 = i;
            }
            i = this.f5236f[i];
        }
        int i7 = this.f5239i;
        int i8 = i7 + 1;
        if (this.f5240j) {
            int[] iArr3 = this.f5235e;
            if (iArr3[i7] != -1) {
                i7 = iArr3.length;
            }
        } else {
            i7 = i8;
        }
        int[] iArr4 = this.f5235e;
        if (i7 >= iArr4.length && this.f5231a < iArr4.length) {
            int i9 = 0;
            while (true) {
                int[] iArr5 = this.f5235e;
                if (i9 >= iArr5.length) {
                    break;
                } else if (iArr5[i9] == -1) {
                    i7 = i9;
                    break;
                } else {
                    i9++;
                }
            }
        }
        int[] iArr6 = this.f5235e;
        if (i7 >= iArr6.length) {
            i7 = iArr6.length;
            int i10 = this.f5234d * 2;
            this.f5234d = i10;
            this.f5240j = false;
            this.f5239i = i7 - 1;
            this.f5237g = Arrays.copyOf(this.f5237g, i10);
            this.f5235e = Arrays.copyOf(this.f5235e, this.f5234d);
            this.f5236f = Arrays.copyOf(this.f5236f, this.f5234d);
        }
        this.f5235e[i7] = c2168p2.f6178b;
        this.f5237g[i7] = f;
        if (i3 != -1) {
            int[] iArr7 = this.f5236f;
            iArr7[i7] = iArr7[i3];
            iArr7[i3] = i7;
        } else {
            this.f5236f[i7] = this.f5238h;
            this.f5238h = i7;
        }
        c2168p2.f6188l++;
        c2168p2.m457a(this.f5232b);
        int i11 = this.f5231a + 1;
        this.f5231a = i11;
        if (!this.f5240j) {
            this.f5239i++;
        }
        int[] iArr8 = this.f5235e;
        if (i11 >= iArr8.length) {
            this.f5240j = true;
        }
        if (this.f5239i >= iArr8.length) {
            this.f5240j = true;
            this.f5239i = iArr8.length - 1;
        }
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: g */
    public final float mo706g(C2168p2 c2168p2, boolean z) {
        int i = this.f5238h;
        if (i == -1) {
            return 0.0f;
        }
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f5231a) {
            if (this.f5235e[i] == c2168p2.f6178b) {
                if (i == this.f5238h) {
                    this.f5238h = this.f5236f[i];
                } else {
                    int[] iArr = this.f5236f;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    c2168p2.m456b(this.f5232b);
                }
                c2168p2.f6188l--;
                this.f5231a--;
                this.f5235e[i] = -1;
                if (this.f5240j) {
                    this.f5239i = i;
                }
                return this.f5237g[i];
            }
            i2++;
            i3 = i;
            i = this.f5236f[i];
        }
        return 0.0f;
    }

    @Override // p000.C1909j2.InterfaceC1910a
    public int getCurrentSize() {
        return this.f5231a;
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: h */
    public C2168p2 mo705h(int i) {
        int i2 = this.f5238h;
        for (int i3 = 0; i2 != -1 && i3 < this.f5231a; i3++) {
            if (i3 == i) {
                return this.f5233c.f5379d[this.f5235e[i2]];
            }
            i2 = this.f5236f[i2];
        }
        return null;
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: i */
    public void mo704i(float f) {
        int i = this.f5238h;
        for (int i2 = 0; i != -1 && i2 < this.f5231a; i2++) {
            float[] fArr = this.f5237g;
            fArr[i] = fArr[i] / f;
            i = this.f5236f[i];
        }
    }

    @Override // p000.C1909j2.InterfaceC1910a
    /* renamed from: j */
    public void mo703j() {
        int i = this.f5238h;
        for (int i2 = 0; i != -1 && i2 < this.f5231a; i2++) {
            float[] fArr = this.f5237g;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.f5236f[i];
        }
    }

    public String toString() {
        int i = this.f5238h;
        String str = "";
        for (int i2 = 0; i != -1 && i2 < this.f5231a; i2++) {
            StringBuilder m253r = outline.m253r(outline.m266e(str, " -> "));
            m253r.append(this.f5237g[i]);
            m253r.append(" : ");
            StringBuilder m253r2 = outline.m253r(m253r.toString());
            m253r2.append(this.f5233c.f5379d[this.f5235e[i]]);
            str = m253r2.toString();
            i = this.f5236f[i];
        }
        return str;
    }
}
