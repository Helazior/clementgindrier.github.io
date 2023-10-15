package org.spongycastle.math.p017ec;

import java.math.BigInteger;
import java.util.Random;
import org.spongycastle.math.p017ec.ECFieldElement;
import org.spongycastle.math.p017ec.ECPoint;

/* renamed from: org.spongycastle.math.ec.ECCurve */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ECCurve {

    /* renamed from: a */
    public ECFieldElement f6136a;

    /* renamed from: b */
    public ECFieldElement f6137b;

    /* renamed from: org.spongycastle.math.ec.ECCurve$F2m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class F2m extends ECCurve {

        /* renamed from: h */
        private BigInteger f6138h;
        private ECPoint.F2m infinity;

        /* renamed from: k1 */
        private int f6139k1;

        /* renamed from: k2 */
        private int f6140k2;

        /* renamed from: k3 */
        private int f6141k3;

        /* renamed from: m */
        private int f6142m;

        /* renamed from: mu */
        private byte f6143mu;

        /* renamed from: n */
        private BigInteger f6144n;

        /* renamed from: si */
        private BigInteger[] f6145si;

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, null, null);
        }

        private ECPoint decompressPoint(byte[] bArr, int i) {
            ECFieldElement multiply;
            ECFieldElement.F2m f2m = new ECFieldElement.F2m(this.f6142m, this.f6139k1, this.f6140k2, this.f6141k3, new BigInteger(1, bArr));
            if (f2m.toBigInteger().equals(ECConstants.ZERO)) {
                multiply = (ECFieldElement.F2m) this.f6137b;
                for (int i2 = 0; i2 < this.f6142m - 1; i2++) {
                    multiply = multiply.square();
                }
            } else {
                ECFieldElement solveQuadradicEquation = solveQuadradicEquation(f2m.add(this.f6136a).add(this.f6137b.multiply(f2m.square().invert())));
                if (solveQuadradicEquation != null) {
                    if (solveQuadradicEquation.toBigInteger().testBit(0) != i) {
                        solveQuadradicEquation = solveQuadradicEquation.add(new ECFieldElement.F2m(this.f6142m, this.f6139k1, this.f6140k2, this.f6141k3, ECConstants.ONE));
                    }
                    multiply = f2m.multiply(solveQuadradicEquation);
                } else {
                    throw new RuntimeException("Invalid point compression");
                }
            }
            return new ECPoint.F2m(this, f2m, multiply);
        }

        private ECFieldElement solveQuadradicEquation(ECFieldElement eCFieldElement) {
            ECFieldElement eCFieldElement2;
            BigInteger bigInteger;
            int i = this.f6142m;
            int i2 = this.f6139k1;
            int i3 = this.f6140k2;
            int i4 = this.f6141k3;
            BigInteger bigInteger2 = ECConstants.ZERO;
            ECFieldElement.F2m f2m = new ECFieldElement.F2m(i, i2, i3, i4, bigInteger2);
            if (eCFieldElement.toBigInteger().equals(bigInteger2)) {
                return f2m;
            }
            Random random = new Random();
            do {
                ECFieldElement.F2m f2m2 = new ECFieldElement.F2m(this.f6142m, this.f6139k1, this.f6140k2, this.f6141k3, new BigInteger(this.f6142m, random));
                ECFieldElement eCFieldElement3 = eCFieldElement;
                eCFieldElement2 = f2m;
                for (int i5 = 1; i5 <= this.f6142m - 1; i5++) {
                    ECFieldElement square = eCFieldElement3.square();
                    eCFieldElement2 = eCFieldElement2.square().add(square.multiply(f2m2));
                    eCFieldElement3 = square.add(eCFieldElement);
                }
                BigInteger bigInteger3 = eCFieldElement3.toBigInteger();
                bigInteger = ECConstants.ZERO;
                if (!bigInteger3.equals(bigInteger)) {
                    return null;
                }
            } while (eCFieldElement2.square().add(eCFieldElement2).toBigInteger().equals(bigInteger));
            return eCFieldElement2;
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            return new ECPoint.F2m(this, fromBigInteger(bigInteger), fromBigInteger(bigInteger2), z);
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public ECPoint decodePoint(byte[] bArr) {
            byte b = bArr[0];
            if (b == 0) {
                if (bArr.length <= 1) {
                    return getInfinity();
                }
                throw new RuntimeException("Invalid point encoding");
            } else if (b == 2 || b == 3) {
                int length = bArr.length - 1;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 1, bArr2, 0, length);
                if (bArr[0] == 2) {
                    return decompressPoint(bArr2, 0);
                }
                return decompressPoint(bArr2, 1);
            } else if (b != 4 && b != 6 && b != 7) {
                StringBuilder m253r = outline.m253r("Invalid point encoding 0x");
                m253r.append(Integer.toString(bArr[0], 16));
                throw new RuntimeException(m253r.toString());
            } else {
                int length2 = (bArr.length - 1) / 2;
                byte[] bArr3 = new byte[length2];
                int length3 = (bArr.length - 1) / 2;
                byte[] bArr4 = new byte[length3];
                System.arraycopy(bArr, 1, bArr3, 0, length2);
                System.arraycopy(bArr, length2 + 1, bArr4, 0, length3);
                return new ECPoint.F2m(this, new ECFieldElement.F2m(this.f6142m, this.f6139k1, this.f6140k2, this.f6141k3, new BigInteger(1, bArr3)), new ECFieldElement.F2m(this.f6142m, this.f6139k1, this.f6140k2, this.f6141k3, new BigInteger(1, bArr4)), false);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof F2m) {
                F2m f2m = (F2m) obj;
                return this.f6142m == f2m.f6142m && this.f6139k1 == f2m.f6139k1 && this.f6140k2 == f2m.f6140k2 && this.f6141k3 == f2m.f6141k3 && this.f6136a.equals(f2m.f6136a) && this.f6137b.equals(f2m.f6137b);
            }
            return false;
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.F2m(this.f6142m, this.f6139k1, this.f6140k2, this.f6141k3, bigInteger);
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public int getFieldSize() {
            return this.f6142m;
        }

        public BigInteger getH() {
            return this.f6138h;
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public int getK1() {
            return this.f6139k1;
        }

        public int getK2() {
            return this.f6140k2;
        }

        public int getK3() {
            return this.f6141k3;
        }

        public int getM() {
            return this.f6142m;
        }

        public synchronized byte getMu() {
            if (this.f6143mu == 0) {
                this.f6143mu = Tnaf.getMu(this);
            }
            return this.f6143mu;
        }

        public BigInteger getN() {
            return this.f6144n;
        }

        public synchronized BigInteger[] getSi() {
            if (this.f6145si == null) {
                this.f6145si = Tnaf.getSi(this);
            }
            return this.f6145si;
        }

        public int hashCode() {
            return ((((this.f6136a.hashCode() ^ this.f6137b.hashCode()) ^ this.f6142m) ^ this.f6139k1) ^ this.f6140k2) ^ this.f6141k3;
        }

        public boolean isKoblitz() {
            return (this.f6144n == null || this.f6138h == null || (!this.f6136a.toBigInteger().equals(ECConstants.ZERO) && !this.f6136a.toBigInteger().equals(ECConstants.ONE)) || !this.f6137b.toBigInteger().equals(ECConstants.ONE)) ? false : true;
        }

        public boolean isTrinomial() {
            return this.f6140k2 == 0 && this.f6141k3 == 0;
        }

        public F2m(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, null, null);
        }

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this.f6143mu = (byte) 0;
            this.f6145si = null;
            this.f6142m = i;
            this.f6139k1 = i2;
            this.f6140k2 = i3;
            this.f6141k3 = i4;
            this.f6144n = bigInteger3;
            this.f6138h = bigInteger4;
            if (i2 != 0) {
                if (i3 == 0) {
                    if (i4 != 0) {
                        throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
                    }
                } else if (i3 <= i2) {
                    throw new IllegalArgumentException("k2 must be > k1");
                } else {
                    if (i4 <= i3) {
                        throw new IllegalArgumentException("k3 must be > k2");
                    }
                }
                this.f6136a = fromBigInteger(bigInteger);
                this.f6137b = fromBigInteger(bigInteger2);
                this.infinity = new ECPoint.F2m(this, null, null);
                return;
            }
            throw new IllegalArgumentException("k1 must be > 0");
        }
    }

    /* renamed from: org.spongycastle.math.ec.ECCurve$Fp */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2160Fp extends ECCurve {
        public ECPoint.C2162Fp infinity;

        /* renamed from: q */
        public BigInteger f6146q;

        public C2160Fp(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this.f6146q = bigInteger;
            this.f6136a = fromBigInteger(bigInteger2);
            this.f6137b = fromBigInteger(bigInteger3);
            this.infinity = new ECPoint.C2162Fp(this, null, null);
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z) {
            return new ECPoint.C2162Fp(this, fromBigInteger(bigInteger), fromBigInteger(bigInteger2), z);
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public ECPoint decodePoint(byte[] bArr) {
            ECPoint.C2162Fp c2162Fp;
            byte b = bArr[0];
            if (b == 0) {
                if (bArr.length <= 1) {
                    return getInfinity();
                }
                throw new RuntimeException("Invalid point encoding");
            } else if (b == 2 || b == 3) {
                int i = bArr[0] & 1;
                int length = bArr.length - 1;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 1, bArr2, 0, length);
                ECFieldElement.C2161Fp c2161Fp = new ECFieldElement.C2161Fp(this.f6146q, new BigInteger(1, bArr2));
                ECFieldElement sqrt = c2161Fp.multiply(c2161Fp.square().add(this.f6136a)).add(this.f6137b).sqrt();
                if (sqrt != null) {
                    if (sqrt.toBigInteger().testBit(0) == i) {
                        c2162Fp = new ECPoint.C2162Fp(this, c2161Fp, sqrt, true);
                    } else {
                        BigInteger bigInteger = this.f6146q;
                        c2162Fp = new ECPoint.C2162Fp(this, c2161Fp, new ECFieldElement.C2161Fp(bigInteger, bigInteger.subtract(sqrt.toBigInteger())), true);
                    }
                    return c2162Fp;
                }
                throw new RuntimeException("Invalid point compression");
            } else if (b != 4 && b != 6 && b != 7) {
                StringBuilder m253r = outline.m253r("Invalid point encoding 0x");
                m253r.append(Integer.toString(bArr[0], 16));
                throw new RuntimeException(m253r.toString());
            } else {
                int length2 = (bArr.length - 1) / 2;
                byte[] bArr3 = new byte[length2];
                int length3 = (bArr.length - 1) / 2;
                byte[] bArr4 = new byte[length3];
                System.arraycopy(bArr, 1, bArr3, 0, length2);
                System.arraycopy(bArr, length2 + 1, bArr4, 0, length3);
                return new ECPoint.C2162Fp(this, new ECFieldElement.C2161Fp(this.f6146q, new BigInteger(1, bArr3)), new ECFieldElement.C2161Fp(this.f6146q, new BigInteger(1, bArr4)));
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C2160Fp) {
                C2160Fp c2160Fp = (C2160Fp) obj;
                return this.f6146q.equals(c2160Fp.f6146q) && this.f6136a.equals(c2160Fp.f6136a) && this.f6137b.equals(c2160Fp.f6137b);
            }
            return false;
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public ECFieldElement fromBigInteger(BigInteger bigInteger) {
            return new ECFieldElement.C2161Fp(this.f6146q, bigInteger);
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public int getFieldSize() {
            return this.f6146q.bitLength();
        }

        @Override // org.spongycastle.math.p017ec.ECCurve
        public ECPoint getInfinity() {
            return this.infinity;
        }

        public BigInteger getQ() {
            return this.f6146q;
        }

        public int hashCode() {
            return (this.f6136a.hashCode() ^ this.f6137b.hashCode()) ^ this.f6146q.hashCode();
        }
    }

    public abstract ECPoint createPoint(BigInteger bigInteger, BigInteger bigInteger2, boolean z);

    public abstract ECPoint decodePoint(byte[] bArr);

    public abstract ECFieldElement fromBigInteger(BigInteger bigInteger);

    public ECFieldElement getA() {
        return this.f6136a;
    }

    public ECFieldElement getB() {
        return this.f6137b;
    }

    public abstract int getFieldSize();

    public abstract ECPoint getInfinity();
}
