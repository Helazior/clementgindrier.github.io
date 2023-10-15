package org.spongycastle.crypto.params;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GOST3410ValidationParameters {

    /* renamed from: c */
    private int f6019c;

    /* renamed from: cL */
    private long f6020cL;

    /* renamed from: x0 */
    private int f6021x0;
    private long x0L;

    public GOST3410ValidationParameters(int i, int i2) {
        this.f6021x0 = i;
        this.f6019c = i2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GOST3410ValidationParameters) {
            GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
            return gOST3410ValidationParameters.f6019c == this.f6019c && gOST3410ValidationParameters.f6021x0 == this.f6021x0 && gOST3410ValidationParameters.f6020cL == this.f6020cL && gOST3410ValidationParameters.x0L == this.x0L;
        }
        return false;
    }

    public int getC() {
        return this.f6019c;
    }

    public long getCL() {
        return this.f6020cL;
    }

    public int getX0() {
        return this.f6021x0;
    }

    public long getX0L() {
        return this.x0L;
    }

    public int hashCode() {
        int i = this.f6021x0 ^ this.f6019c;
        long j = this.x0L;
        long j2 = this.f6020cL;
        return (((i ^ ((int) j)) ^ ((int) (j >> 32))) ^ ((int) j2)) ^ ((int) (j2 >> 32));
    }

    public GOST3410ValidationParameters(long j, long j2) {
        this.x0L = j;
        this.f6020cL = j2;
    }
}
