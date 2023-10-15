package p000;

import javax.annotation.Nullable;

/* renamed from: ye */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2393ye {

    /* renamed from: a */
    public final byte[] f6888a;

    /* renamed from: b */
    public int f6889b;

    /* renamed from: c */
    public int f6890c;

    /* renamed from: d */
    public boolean f6891d;

    /* renamed from: e */
    public boolean f6892e;

    /* renamed from: f */
    public C2393ye f6893f;

    /* renamed from: g */
    public C2393ye f6894g;

    public C2393ye() {
        this.f6888a = new byte[8192];
        this.f6892e = true;
        this.f6891d = false;
    }

    @Nullable
    /* renamed from: a */
    public C2393ye m49a() {
        C2393ye c2393ye = this.f6893f;
        C2393ye c2393ye2 = c2393ye != this ? c2393ye : null;
        C2393ye c2393ye3 = this.f6894g;
        c2393ye3.f6893f = c2393ye;
        this.f6893f.f6894g = c2393ye3;
        this.f6893f = null;
        this.f6894g = null;
        return c2393ye2;
    }

    /* renamed from: b */
    public C2393ye m48b(C2393ye c2393ye) {
        c2393ye.f6894g = this;
        c2393ye.f6893f = this.f6893f;
        this.f6893f.f6894g = c2393ye;
        this.f6893f = c2393ye;
        return c2393ye;
    }

    /* renamed from: c */
    public C2393ye m47c() {
        this.f6891d = true;
        return new C2393ye(this.f6888a, this.f6889b, this.f6890c, true, false);
    }

    /* renamed from: d */
    public void m46d(C2393ye c2393ye, int i) {
        if (c2393ye.f6892e) {
            int i2 = c2393ye.f6890c;
            if (i2 + i > 8192) {
                if (!c2393ye.f6891d) {
                    int i3 = c2393ye.f6889b;
                    if ((i2 + i) - i3 <= 8192) {
                        byte[] bArr = c2393ye.f6888a;
                        System.arraycopy(bArr, i3, bArr, 0, i2 - i3);
                        c2393ye.f6890c -= c2393ye.f6889b;
                        c2393ye.f6889b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.f6888a, this.f6889b, c2393ye.f6888a, c2393ye.f6890c, i);
            c2393ye.f6890c += i;
            this.f6889b += i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public C2393ye(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.f6888a = bArr;
        this.f6889b = i;
        this.f6890c = i2;
        this.f6891d = z;
        this.f6892e = z2;
    }
}
