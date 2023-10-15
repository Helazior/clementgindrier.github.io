package p000;

import java.util.Arrays;

/* renamed from: Ae */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0030Ae extends C2011ne {

    /* renamed from: g */
    public final transient byte[][] f157g;

    /* renamed from: h */
    public final transient int[] f158h;

    public C0030Ae(C1946ke c1946ke, int i) {
        super(null);
        C0123Ee.m2457b(c1946ke.f5398b, 0L, i);
        C2393ye c2393ye = c1946ke.f5397a;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = c2393ye.f6890c;
            int i6 = c2393ye.f6889b;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                c2393ye = c2393ye.f6893f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f157g = new byte[i4];
        this.f158h = new int[i4 * 2];
        C2393ye c2393ye2 = c1946ke.f5397a;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.f157g;
            bArr[i7] = c2393ye2.f6888a;
            int i8 = c2393ye2.f6890c;
            int i9 = c2393ye2.f6889b;
            int i10 = (i8 - i9) + i2;
            i2 = i10 > i ? i : i10;
            int[] iArr = this.f158h;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            c2393ye2.f6891d = true;
            i7++;
            c2393ye2 = c2393ye2.f6893f;
        }
    }

    private Object writeReplace() {
        return m2581t();
    }

    @Override // p000.C2011ne
    /* renamed from: a */
    public String mo562a() {
        return m2581t().mo562a();
    }

    @Override // p000.C2011ne
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2011ne) {
            C2011ne c2011ne = (C2011ne) obj;
            if (c2011ne.mo550m() == mo550m() && mo553j(0, c2011ne, 0, mo550m())) {
                return true;
            }
        }
        return false;
    }

    @Override // p000.C2011ne
    /* renamed from: g */
    public byte mo556g(int i) {
        C0123Ee.m2457b(this.f158h[this.f157g.length - 1], i, 1L);
        int m2582s = m2582s(i);
        int i2 = m2582s == 0 ? 0 : this.f158h[m2582s - 1];
        int[] iArr = this.f158h;
        byte[][] bArr = this.f157g;
        return bArr[m2582s][(i - i2) + iArr[bArr.length + m2582s]];
    }

    @Override // p000.C2011ne
    /* renamed from: h */
    public String mo555h() {
        return m2581t().mo555h();
    }

    @Override // p000.C2011ne
    public int hashCode() {
        int i = this.f5563b;
        if (i != 0) {
            return i;
        }
        int length = this.f157g.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.f157g[i2];
            int[] iArr = this.f158h;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.f5563b = i4;
        return i4;
    }

    @Override // p000.C2011ne
    /* renamed from: j */
    public boolean mo553j(int i, C2011ne c2011ne, int i2, int i3) {
        if (i < 0 || i > mo550m() - i3) {
            return false;
        }
        int m2582s = m2582s(i);
        while (i3 > 0) {
            int i4 = m2582s == 0 ? 0 : this.f158h[m2582s - 1];
            int min = Math.min(i3, ((this.f158h[m2582s] - i4) + i4) - i);
            int[] iArr = this.f158h;
            byte[][] bArr = this.f157g;
            if (!c2011ne.mo552k(i2, bArr[m2582s], (i - i4) + iArr[bArr.length + m2582s], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m2582s++;
        }
        return true;
    }

    @Override // p000.C2011ne
    /* renamed from: k */
    public boolean mo552k(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > mo550m() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int m2582s = m2582s(i);
        while (i3 > 0) {
            int i4 = m2582s == 0 ? 0 : this.f158h[m2582s - 1];
            int min = Math.min(i3, ((this.f158h[m2582s] - i4) + i4) - i);
            int[] iArr = this.f158h;
            byte[][] bArr2 = this.f157g;
            if (!C0123Ee.m2458a(bArr2[m2582s], (i - i4) + iArr[bArr2.length + m2582s], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            m2582s++;
        }
        return true;
    }

    @Override // p000.C2011ne
    /* renamed from: l */
    public C2011ne mo551l() {
        return m2581t().mo551l();
    }

    @Override // p000.C2011ne
    /* renamed from: m */
    public int mo550m() {
        return this.f158h[this.f157g.length - 1];
    }

    @Override // p000.C2011ne
    /* renamed from: n */
    public C2011ne mo549n(int i, int i2) {
        return m2581t().mo549n(i, i2);
    }

    @Override // p000.C2011ne
    /* renamed from: o */
    public C2011ne mo548o() {
        return m2581t().mo548o();
    }

    @Override // p000.C2011ne
    /* renamed from: p */
    public byte[] mo547p() {
        int[] iArr = this.f158h;
        byte[][] bArr = this.f157g;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.f158h;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.f157g[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // p000.C2011ne
    /* renamed from: q */
    public String mo546q() {
        return m2581t().mo546q();
    }

    @Override // p000.C2011ne
    /* renamed from: r */
    public void mo545r(C1946ke c1946ke) {
        int length = this.f157g.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.f158h;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            C2393ye c2393ye = new C2393ye(this.f157g[i], i3, (i3 + i4) - i2, true, false);
            C2393ye c2393ye2 = c1946ke.f5397a;
            if (c2393ye2 == null) {
                c2393ye.f6894g = c2393ye;
                c2393ye.f6893f = c2393ye;
                c1946ke.f5397a = c2393ye;
            } else {
                c2393ye2.f6894g.m48b(c2393ye);
            }
            i++;
            i2 = i4;
        }
        c1946ke.f5398b += i2;
    }

    /* renamed from: s */
    public final int m2582s(int i) {
        int binarySearch = Arrays.binarySearch(this.f158h, 0, this.f157g.length, i + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    /* renamed from: t */
    public final C2011ne m2581t() {
        return new C2011ne(mo547p());
    }

    @Override // p000.C2011ne
    public String toString() {
        return m2581t().toString();
    }
}
