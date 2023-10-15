package org.spongycastle.math.p017ec;

import java.math.BigInteger;
import org.spongycastle.asn1.p012x9.X9IntegerConverter;
import org.spongycastle.math.p017ec.ECCurve;
import org.spongycastle.math.p017ec.ECFieldElement;

/* renamed from: org.spongycastle.math.ec.ECPoint */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ECPoint {
    private static X9IntegerConverter converter = new X9IntegerConverter();
    public ECCurve curve;
    public ECMultiplier multiplier = null;
    public PreCompInfo preCompInfo = null;
    public boolean withCompression;

    /* renamed from: x */
    public ECFieldElement f6155x;

    /* renamed from: y */
    public ECFieldElement f6156y;

    /* renamed from: org.spongycastle.math.ec.ECPoint$F2m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class F2m extends ECPoint {
        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        private static void checkPoints(ECPoint eCPoint, ECPoint eCPoint2) {
            if (!eCPoint.curve.equals(eCPoint2.curve)) {
                throw new IllegalArgumentException("Only points on the same curve can be added or subtracted");
            }
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public ECPoint add(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return addSimple((F2m) eCPoint);
        }

        public F2m addSimple(F2m f2m) {
            if (isInfinity()) {
                return f2m;
            }
            if (f2m.isInfinity()) {
                return this;
            }
            ECFieldElement.F2m f2m2 = (ECFieldElement.F2m) f2m.getX();
            ECFieldElement.F2m f2m3 = (ECFieldElement.F2m) f2m.getY();
            if (this.f6155x.equals(f2m2)) {
                if (this.f6156y.equals(f2m3)) {
                    return (F2m) twice();
                }
                return (F2m) this.curve.getInfinity();
            }
            ECFieldElement eCFieldElement = (ECFieldElement.F2m) this.f6156y.add(f2m3).divide(this.f6155x.add(f2m2));
            ECFieldElement.F2m f2m4 = (ECFieldElement.F2m) eCFieldElement.square().add(eCFieldElement).add(this.f6155x).add(f2m2).add(this.curve.getA());
            return new F2m(this.curve, f2m4, (ECFieldElement.F2m) eCFieldElement.multiply(this.f6155x.add(f2m4)).add(f2m4).add(this.f6156y), this.withCompression);
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public synchronized void assertECMultiplier() {
            if (this.multiplier == null) {
                if (((ECCurve.F2m) this.curve).isKoblitz()) {
                    this.multiplier = new WTauNafMultiplier();
                } else {
                    this.multiplier = new WNafMultiplier();
                }
            }
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public byte[] getEncoded() {
            if (isInfinity()) {
                return new byte[1];
            }
            int byteLength = ECPoint.converter.getByteLength(this.f6155x);
            byte[] integerToBytes = ECPoint.converter.integerToBytes(getX().toBigInteger(), byteLength);
            if (!this.withCompression) {
                byte[] integerToBytes2 = ECPoint.converter.integerToBytes(getY().toBigInteger(), byteLength);
                byte[] bArr = new byte[byteLength + byteLength + 1];
                bArr[0] = 4;
                System.arraycopy(integerToBytes, 0, bArr, 1, byteLength);
                System.arraycopy(integerToBytes2, 0, bArr, byteLength + 1, byteLength);
                return bArr;
            }
            byte[] bArr2 = new byte[byteLength + 1];
            bArr2[0] = 2;
            if (!getX().toBigInteger().equals(ECConstants.ZERO) && getY().multiply(getX().invert()).toBigInteger().testBit(0)) {
                bArr2[0] = 3;
            }
            System.arraycopy(integerToBytes, 0, bArr2, 1, byteLength);
            return bArr2;
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public ECPoint negate() {
            return new F2m(this.curve, getX(), getY().add(getX()), this.withCompression);
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public ECPoint subtract(ECPoint eCPoint) {
            checkPoints(this, eCPoint);
            return subtractSimple((F2m) eCPoint);
        }

        public F2m subtractSimple(F2m f2m) {
            return f2m.isInfinity() ? this : addSimple((F2m) f2m.negate());
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public ECPoint twice() {
            if (isInfinity()) {
                return this;
            }
            if (this.f6155x.toBigInteger().signum() == 0) {
                return this.curve.getInfinity();
            }
            ECFieldElement eCFieldElement = this.f6155x;
            ECFieldElement eCFieldElement2 = (ECFieldElement.F2m) eCFieldElement.add(this.f6156y.divide(eCFieldElement));
            ECFieldElement.F2m f2m = (ECFieldElement.F2m) eCFieldElement2.square().add(eCFieldElement2).add(this.curve.getA());
            ECFieldElement fromBigInteger = this.curve.fromBigInteger(ECConstants.ONE);
            return new F2m(this.curve, f2m, (ECFieldElement.F2m) this.f6155x.square().add(f2m.multiply(eCFieldElement2.add(fromBigInteger))), this.withCompression);
        }

        public F2m(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement != null && eCFieldElement2 == null) || (eCFieldElement == null && eCFieldElement2 != null)) {
                throw new IllegalArgumentException("Exactly one of the field elements is null");
            }
            if (eCFieldElement != null) {
                ECFieldElement.F2m.checkFieldElements(this.f6155x, this.f6156y);
                if (eCCurve != null) {
                    ECFieldElement.F2m.checkFieldElements(this.f6155x, this.curve.getA());
                }
            }
            this.withCompression = z;
        }
    }

    /* renamed from: org.spongycastle.math.ec.ECPoint$Fp */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2162Fp extends ECPoint {
        public C2162Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            this(eCCurve, eCFieldElement, eCFieldElement2, false);
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public ECPoint add(ECPoint eCPoint) {
            if (isInfinity()) {
                return eCPoint;
            }
            if (eCPoint.isInfinity()) {
                return this;
            }
            if (this.f6155x.equals(eCPoint.f6155x)) {
                if (this.f6156y.equals(eCPoint.f6156y)) {
                    return twice();
                }
                return this.curve.getInfinity();
            }
            ECFieldElement divide = eCPoint.f6156y.subtract(this.f6156y).divide(eCPoint.f6155x.subtract(this.f6155x));
            ECFieldElement subtract = divide.square().subtract(this.f6155x).subtract(eCPoint.f6155x);
            return new C2162Fp(this.curve, subtract, divide.multiply(this.f6155x.subtract(subtract)).subtract(this.f6156y));
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public synchronized void assertECMultiplier() {
            if (this.multiplier == null) {
                this.multiplier = new WNafMultiplier();
            }
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public byte[] getEncoded() {
            if (isInfinity()) {
                return new byte[1];
            }
            int byteLength = ECPoint.converter.getByteLength(this.f6155x);
            if (!this.withCompression) {
                byte[] integerToBytes = ECPoint.converter.integerToBytes(getX().toBigInteger(), byteLength);
                byte[] integerToBytes2 = ECPoint.converter.integerToBytes(getY().toBigInteger(), byteLength);
                byte[] bArr = new byte[integerToBytes.length + integerToBytes2.length + 1];
                bArr[0] = 4;
                System.arraycopy(integerToBytes, 0, bArr, 1, integerToBytes.length);
                System.arraycopy(integerToBytes2, 0, bArr, integerToBytes.length + 1, integerToBytes2.length);
                return bArr;
            }
            byte b = getY().toBigInteger().testBit(0) ? (byte) 3 : (byte) 2;
            byte[] integerToBytes3 = ECPoint.converter.integerToBytes(getX().toBigInteger(), byteLength);
            byte[] bArr2 = new byte[integerToBytes3.length + 1];
            bArr2[0] = b;
            System.arraycopy(integerToBytes3, 0, bArr2, 1, integerToBytes3.length);
            return bArr2;
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public ECPoint negate() {
            return new C2162Fp(this.curve, this.f6155x, this.f6156y.negate(), this.withCompression);
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public ECPoint subtract(ECPoint eCPoint) {
            return eCPoint.isInfinity() ? this : add(eCPoint.negate());
        }

        @Override // org.spongycastle.math.p017ec.ECPoint
        public ECPoint twice() {
            if (isInfinity()) {
                return this;
            }
            if (this.f6156y.toBigInteger().signum() == 0) {
                return this.curve.getInfinity();
            }
            ECFieldElement fromBigInteger = this.curve.fromBigInteger(BigInteger.valueOf(2L));
            ECFieldElement divide = this.f6155x.square().multiply(this.curve.fromBigInteger(BigInteger.valueOf(3L))).add(this.curve.f6136a).divide(this.f6156y.multiply(fromBigInteger));
            ECFieldElement subtract = divide.square().subtract(this.f6155x.multiply(fromBigInteger));
            return new C2162Fp(this.curve, subtract, divide.multiply(this.f6155x.subtract(subtract)).subtract(this.f6156y), this.withCompression);
        }

        public C2162Fp(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2, boolean z) {
            super(eCCurve, eCFieldElement, eCFieldElement2);
            if ((eCFieldElement != null && eCFieldElement2 == null) || (eCFieldElement == null && eCFieldElement2 != null)) {
                throw new IllegalArgumentException("Exactly one of the field elements is null");
            }
            this.withCompression = z;
        }
    }

    public ECPoint(ECCurve eCCurve, ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
        this.curve = eCCurve;
        this.f6155x = eCFieldElement;
        this.f6156y = eCFieldElement2;
    }

    public abstract ECPoint add(ECPoint eCPoint);

    public synchronized void assertECMultiplier() {
        if (this.multiplier == null) {
            this.multiplier = new FpNafMultiplier();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ECPoint) {
            ECPoint eCPoint = (ECPoint) obj;
            if (isInfinity()) {
                return eCPoint.isInfinity();
            }
            return this.f6155x.equals(eCPoint.f6155x) && this.f6156y.equals(eCPoint.f6156y);
        }
        return false;
    }

    public ECCurve getCurve() {
        return this.curve;
    }

    public abstract byte[] getEncoded();

    public ECFieldElement getX() {
        return this.f6155x;
    }

    public ECFieldElement getY() {
        return this.f6156y;
    }

    public int hashCode() {
        if (isInfinity()) {
            return 0;
        }
        return this.f6155x.hashCode() ^ this.f6156y.hashCode();
    }

    public boolean isCompressed() {
        return this.withCompression;
    }

    public boolean isInfinity() {
        return this.f6155x == null && this.f6156y == null;
    }

    public ECPoint multiply(BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            if (isInfinity()) {
                return this;
            }
            if (bigInteger.signum() == 0) {
                return this.curve.getInfinity();
            }
            assertECMultiplier();
            return this.multiplier.multiply(this, bigInteger, this.preCompInfo);
        }
        throw new IllegalArgumentException("The multiplicator cannot be negative");
    }

    public abstract ECPoint negate();

    public void setPreCompInfo(PreCompInfo preCompInfo) {
        this.preCompInfo = preCompInfo;
    }

    public abstract ECPoint subtract(ECPoint eCPoint);

    public abstract ECPoint twice();
}
