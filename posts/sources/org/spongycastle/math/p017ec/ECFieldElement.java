package org.spongycastle.math.p017ec;

import java.math.BigInteger;
import java.util.Random;

/* renamed from: org.spongycastle.math.ec.ECFieldElement */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ECFieldElement implements ECConstants {

    /* renamed from: org.spongycastle.math.ec.ECFieldElement$Fp */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2161Fp extends ECFieldElement {

        /* renamed from: q */
        public BigInteger f6153q;

        /* renamed from: x */
        public BigInteger f6154x;

        public C2161Fp(BigInteger bigInteger, BigInteger bigInteger2) {
            this.f6154x = bigInteger2;
            if (bigInteger2.compareTo(bigInteger) < 0) {
                this.f6153q = bigInteger;
                return;
            }
            throw new IllegalArgumentException("x value too large in field element");
        }

        private static BigInteger[] lucasSequence(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            int bitLength = bigInteger4.bitLength();
            int lowestSetBit = bigInteger4.getLowestSetBit();
            BigInteger bigInteger5 = ECConstants.ONE;
            BigInteger bigInteger6 = bigInteger2;
            BigInteger bigInteger7 = bigInteger5;
            BigInteger bigInteger8 = ECConstants.TWO;
            BigInteger bigInteger9 = bigInteger7;
            for (int i = bitLength - 1; i >= lowestSetBit + 1; i--) {
                bigInteger5 = bigInteger5.multiply(bigInteger9).mod(bigInteger);
                if (bigInteger4.testBit(i)) {
                    bigInteger9 = bigInteger5.multiply(bigInteger3).mod(bigInteger);
                    bigInteger7 = bigInteger7.multiply(bigInteger6).mod(bigInteger);
                    bigInteger8 = bigInteger6.multiply(bigInteger8).subtract(bigInteger2.multiply(bigInteger5)).mod(bigInteger);
                    bigInteger6 = bigInteger6.multiply(bigInteger6).subtract(bigInteger9.shiftLeft(1)).mod(bigInteger);
                } else {
                    BigInteger mod = bigInteger7.multiply(bigInteger8).subtract(bigInteger5).mod(bigInteger);
                    BigInteger mod2 = bigInteger6.multiply(bigInteger8).subtract(bigInteger2.multiply(bigInteger5)).mod(bigInteger);
                    bigInteger8 = bigInteger8.multiply(bigInteger8).subtract(bigInteger5.shiftLeft(1)).mod(bigInteger);
                    bigInteger6 = mod2;
                    bigInteger7 = mod;
                    bigInteger9 = bigInteger5;
                }
            }
            BigInteger mod3 = bigInteger5.multiply(bigInteger9).mod(bigInteger);
            BigInteger mod4 = mod3.multiply(bigInteger3).mod(bigInteger);
            BigInteger mod5 = bigInteger7.multiply(bigInteger8).subtract(mod3).mod(bigInteger);
            BigInteger mod6 = bigInteger6.multiply(bigInteger8).subtract(bigInteger2.multiply(mod3)).mod(bigInteger);
            BigInteger mod7 = mod3.multiply(mod4).mod(bigInteger);
            for (int i2 = 1; i2 <= lowestSetBit; i2++) {
                mod5 = mod5.multiply(mod6).mod(bigInteger);
                mod6 = mod6.multiply(mod6).subtract(mod7.shiftLeft(1)).mod(bigInteger);
                mod7 = mod7.multiply(mod7).mod(bigInteger);
            }
            return new BigInteger[]{mod5, mod6};
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            return new C2161Fp(this.f6153q, this.f6154x.add(eCFieldElement.toBigInteger()).mod(this.f6153q));
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return new C2161Fp(this.f6153q, this.f6154x.multiply(eCFieldElement.toBigInteger().modInverse(this.f6153q)).mod(this.f6153q));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C2161Fp) {
                C2161Fp c2161Fp = (C2161Fp) obj;
                return this.f6153q.equals(c2161Fp.f6153q) && this.f6154x.equals(c2161Fp.f6154x);
            }
            return false;
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public String getFieldName() {
            return "Fp";
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public int getFieldSize() {
            return this.f6153q.bitLength();
        }

        public BigInteger getQ() {
            return this.f6153q;
        }

        public int hashCode() {
            return this.f6153q.hashCode() ^ this.f6154x.hashCode();
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement invert() {
            BigInteger bigInteger = this.f6153q;
            return new C2161Fp(bigInteger, this.f6154x.modInverse(bigInteger));
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            return new C2161Fp(this.f6153q, this.f6154x.multiply(eCFieldElement.toBigInteger()).mod(this.f6153q));
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement negate() {
            return new C2161Fp(this.f6153q, this.f6154x.negate().mod(this.f6153q));
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement sqrt() {
            if (this.f6153q.testBit(0)) {
                if (this.f6153q.testBit(1)) {
                    BigInteger bigInteger = this.f6153q;
                    C2161Fp c2161Fp = new C2161Fp(bigInteger, this.f6154x.modPow(bigInteger.shiftRight(2).add(ECConstants.ONE), this.f6153q));
                    if (c2161Fp.square().equals(this)) {
                        return c2161Fp;
                    }
                    return null;
                }
                BigInteger bigInteger2 = this.f6153q;
                BigInteger bigInteger3 = ECConstants.ONE;
                BigInteger subtract = bigInteger2.subtract(bigInteger3);
                BigInteger shiftRight = subtract.shiftRight(1);
                if (!this.f6154x.modPow(shiftRight, this.f6153q).equals(bigInteger3)) {
                    return null;
                }
                BigInteger add = subtract.shiftRight(2).shiftLeft(1).add(bigInteger3);
                BigInteger bigInteger4 = this.f6154x;
                BigInteger mod = bigInteger4.shiftLeft(2).mod(this.f6153q);
                Random random = new Random();
                while (true) {
                    BigInteger bigInteger5 = new BigInteger(this.f6153q.bitLength(), random);
                    if (bigInteger5.compareTo(this.f6153q) < 0 && bigInteger5.multiply(bigInteger5).subtract(mod).modPow(shiftRight, this.f6153q).equals(subtract)) {
                        BigInteger[] lucasSequence = lucasSequence(this.f6153q, bigInteger5, bigInteger4, add);
                        BigInteger bigInteger6 = lucasSequence[0];
                        BigInteger bigInteger7 = lucasSequence[1];
                        if (bigInteger7.multiply(bigInteger7).mod(this.f6153q).equals(mod)) {
                            if (bigInteger7.testBit(0)) {
                                bigInteger7 = bigInteger7.add(this.f6153q);
                            }
                            return new C2161Fp(this.f6153q, bigInteger7.shiftRight(1));
                        } else if (!bigInteger6.equals(ECConstants.ONE) && !bigInteger6.equals(subtract)) {
                            return null;
                        }
                    }
                }
            } else {
                throw new RuntimeException("not done yet");
            }
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement square() {
            BigInteger bigInteger = this.f6153q;
            BigInteger bigInteger2 = this.f6154x;
            return new C2161Fp(bigInteger, bigInteger2.multiply(bigInteger2).mod(this.f6153q));
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return new C2161Fp(this.f6153q, this.f6154x.subtract(eCFieldElement.toBigInteger()).mod(this.f6153q));
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f6154x;
        }
    }

    public abstract ECFieldElement add(ECFieldElement eCFieldElement);

    public abstract ECFieldElement divide(ECFieldElement eCFieldElement);

    public abstract String getFieldName();

    public abstract int getFieldSize();

    public abstract ECFieldElement invert();

    public abstract ECFieldElement multiply(ECFieldElement eCFieldElement);

    public abstract ECFieldElement negate();

    public abstract ECFieldElement sqrt();

    public abstract ECFieldElement square();

    public abstract ECFieldElement subtract(ECFieldElement eCFieldElement);

    public abstract BigInteger toBigInteger();

    public String toString() {
        return toBigInteger().toString(2);
    }

    /* renamed from: org.spongycastle.math.ec.ECFieldElement$F2m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class F2m extends ECFieldElement {
        public static final int GNB = 1;
        public static final int PPB = 3;
        public static final int TPB = 2;

        /* renamed from: k1 */
        private int f6147k1;

        /* renamed from: k2 */
        private int f6148k2;

        /* renamed from: k3 */
        private int f6149k3;

        /* renamed from: m */
        private int f6150m;
        private int representation;

        /* renamed from: t */
        private int f6151t;

        /* renamed from: x */
        private IntArray f6152x;

        public F2m(int i, int i2, int i3, int i4, BigInteger bigInteger) {
            int i5 = (i + 31) >> 5;
            this.f6151t = i5;
            this.f6152x = new IntArray(bigInteger, i5);
            if (i3 == 0 && i4 == 0) {
                this.representation = 2;
            } else if (i3 >= i4) {
                throw new IllegalArgumentException("k2 must be smaller than k3");
            } else {
                if (i3 > 0) {
                    this.representation = 3;
                } else {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
            }
            if (bigInteger.signum() >= 0) {
                this.f6150m = i;
                this.f6147k1 = i2;
                this.f6148k2 = i3;
                this.f6149k3 = i4;
                return;
            }
            throw new IllegalArgumentException("x value cannot be negative");
        }

        public static void checkFieldElements(ECFieldElement eCFieldElement, ECFieldElement eCFieldElement2) {
            if ((eCFieldElement instanceof F2m) && (eCFieldElement2 instanceof F2m)) {
                F2m f2m = (F2m) eCFieldElement;
                F2m f2m2 = (F2m) eCFieldElement2;
                if (f2m.f6150m == f2m2.f6150m && f2m.f6147k1 == f2m2.f6147k1 && f2m.f6148k2 == f2m2.f6148k2 && f2m.f6149k3 == f2m2.f6149k3) {
                    if (f2m.representation != f2m2.representation) {
                        throw new IllegalArgumentException("One of the field elements are not elements has incorrect representation");
                    }
                    return;
                }
                throw new IllegalArgumentException("Field elements are not elements of the same field F2m");
            }
            throw new IllegalArgumentException("Field elements are not both instances of ECFieldElement.F2m");
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement add(ECFieldElement eCFieldElement) {
            IntArray intArray = (IntArray) this.f6152x.clone();
            intArray.addShifted(((F2m) eCFieldElement).f6152x, 0);
            return new F2m(this.f6150m, this.f6147k1, this.f6148k2, this.f6149k3, intArray);
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement divide(ECFieldElement eCFieldElement) {
            return multiply(eCFieldElement.invert());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof F2m) {
                F2m f2m = (F2m) obj;
                return this.f6150m == f2m.f6150m && this.f6147k1 == f2m.f6147k1 && this.f6148k2 == f2m.f6148k2 && this.f6149k3 == f2m.f6149k3 && this.representation == f2m.representation && this.f6152x.equals(f2m.f6152x);
            }
            return false;
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public String getFieldName() {
            return "F2m";
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public int getFieldSize() {
            return this.f6150m;
        }

        public int getK1() {
            return this.f6147k1;
        }

        public int getK2() {
            return this.f6148k2;
        }

        public int getK3() {
            return this.f6149k3;
        }

        public int getM() {
            return this.f6150m;
        }

        public int getRepresentation() {
            return this.representation;
        }

        public int hashCode() {
            return (((this.f6152x.hashCode() ^ this.f6150m) ^ this.f6147k1) ^ this.f6148k2) ^ this.f6149k3;
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement invert() {
            IntArray intArray = (IntArray) this.f6152x.clone();
            IntArray intArray2 = new IntArray(this.f6151t);
            intArray2.setBit(this.f6150m);
            intArray2.setBit(0);
            intArray2.setBit(this.f6147k1);
            if (this.representation == 3) {
                intArray2.setBit(this.f6148k2);
                intArray2.setBit(this.f6149k3);
            }
            IntArray intArray3 = new IntArray(this.f6151t);
            intArray3.setBit(0);
            IntArray intArray4 = new IntArray(this.f6151t);
            while (!intArray.isZero()) {
                int bitLength = intArray.bitLength() - intArray2.bitLength();
                if (bitLength < 0) {
                    bitLength = -bitLength;
                    IntArray intArray5 = intArray2;
                    intArray2 = intArray;
                    intArray = intArray5;
                    IntArray intArray6 = intArray4;
                    intArray4 = intArray3;
                    intArray3 = intArray6;
                }
                int i = bitLength >> 5;
                int i2 = bitLength & 31;
                intArray.addShifted(intArray2.shiftLeft(i2), i);
                intArray3.addShifted(intArray4.shiftLeft(i2), i);
            }
            return new F2m(this.f6150m, this.f6147k1, this.f6148k2, this.f6149k3, intArray4);
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement multiply(ECFieldElement eCFieldElement) {
            IntArray multiply = this.f6152x.multiply(((F2m) eCFieldElement).f6152x, this.f6150m);
            multiply.reduce(this.f6150m, new int[]{this.f6147k1, this.f6148k2, this.f6149k3});
            return new F2m(this.f6150m, this.f6147k1, this.f6148k2, this.f6149k3, multiply);
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement negate() {
            return this;
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement sqrt() {
            throw new RuntimeException("Not implemented");
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement square() {
            IntArray square = this.f6152x.square(this.f6150m);
            square.reduce(this.f6150m, new int[]{this.f6147k1, this.f6148k2, this.f6149k3});
            return new F2m(this.f6150m, this.f6147k1, this.f6148k2, this.f6149k3, square);
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public ECFieldElement subtract(ECFieldElement eCFieldElement) {
            return add(eCFieldElement);
        }

        @Override // org.spongycastle.math.p017ec.ECFieldElement
        public BigInteger toBigInteger() {
            return this.f6152x.toBigInteger();
        }

        public F2m(int i, int i2, BigInteger bigInteger) {
            this(i, i2, 0, 0, bigInteger);
        }

        private F2m(int i, int i2, int i3, int i4, IntArray intArray) {
            this.f6151t = (i + 31) >> 5;
            this.f6152x = intArray;
            this.f6150m = i;
            this.f6147k1 = i2;
            this.f6148k2 = i3;
            this.f6149k3 = i4;
            if (i3 == 0 && i4 == 0) {
                this.representation = 2;
            } else {
                this.representation = 3;
            }
        }
    }
}
