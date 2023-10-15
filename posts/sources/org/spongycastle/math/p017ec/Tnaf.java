package org.spongycastle.math.p017ec;

import java.math.BigInteger;
import org.spongycastle.math.p017ec.ECCurve;
import org.spongycastle.math.p017ec.ECPoint;

/* renamed from: org.spongycastle.math.ec.Tnaf */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Tnaf {
    private static final BigInteger MINUS_ONE;
    private static final BigInteger MINUS_THREE;
    private static final BigInteger MINUS_TWO;
    public static final byte POW_2_WIDTH = 16;
    public static final byte WIDTH = 4;
    public static final ZTauElement[] alpha0;
    public static final byte[][] alpha0Tnaf;
    public static final ZTauElement[] alpha1;
    public static final byte[][] alpha1Tnaf;

    static {
        BigInteger bigInteger = ECConstants.ONE;
        BigInteger negate = bigInteger.negate();
        MINUS_ONE = negate;
        MINUS_TWO = ECConstants.TWO.negate();
        BigInteger negate2 = ECConstants.THREE.negate();
        MINUS_THREE = negate2;
        BigInteger bigInteger2 = ECConstants.ZERO;
        alpha0 = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger2), null, new ZTauElement(negate2, negate), null, new ZTauElement(negate, negate), null, new ZTauElement(bigInteger, negate), null};
        alpha0Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, 1}};
        alpha1 = new ZTauElement[]{null, new ZTauElement(bigInteger, bigInteger2), null, new ZTauElement(negate2, bigInteger), null, new ZTauElement(negate, bigInteger), null, new ZTauElement(bigInteger, bigInteger), null};
        alpha1Tnaf = new byte[][]{null, new byte[]{1}, null, new byte[]{-1, 0, 1}, null, new byte[]{1, 0, 1}, null, new byte[]{-1, 0, 0, -1}};
    }

    public static SimpleBigDecimal approximateDivisionByN(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, byte b, int i, int i2) {
        int i3 = ((i + 5) / 2) + i2;
        BigInteger multiply = bigInteger2.multiply(bigInteger.shiftRight(((i - i3) - 2) + b));
        BigInteger add = multiply.add(bigInteger3.multiply(multiply.shiftRight(i)));
        int i4 = i3 - i2;
        BigInteger shiftRight = add.shiftRight(i4);
        if (add.testBit(i4 - 1)) {
            shiftRight = shiftRight.add(ECConstants.ONE);
        }
        return new SimpleBigDecimal(shiftRight, i2);
    }

    public static BigInteger[] getLucas(byte b, int i, boolean z) {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        if (b == 1 || b == -1) {
            if (z) {
                bigInteger = ECConstants.TWO;
                bigInteger2 = BigInteger.valueOf(b);
            } else {
                bigInteger = ECConstants.ZERO;
                bigInteger2 = ECConstants.ONE;
            }
            int i2 = 1;
            while (i2 < i) {
                i2++;
                BigInteger bigInteger3 = bigInteger2;
                bigInteger2 = (b == 1 ? bigInteger2 : bigInteger2.negate()).subtract(bigInteger.shiftLeft(1));
                bigInteger = bigInteger3;
            }
            return new BigInteger[]{bigInteger, bigInteger2};
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static byte getMu(ECCurve.F2m f2m) {
        BigInteger bigInteger = f2m.getA().toBigInteger();
        if (bigInteger.equals(ECConstants.ZERO)) {
            return (byte) -1;
        }
        if (bigInteger.equals(ECConstants.ONE)) {
            return (byte) 1;
        }
        throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
    }

    public static ECPoint.F2m[] getPreComp(ECPoint.F2m f2m, byte b) {
        byte[][] bArr;
        ECPoint.F2m[] f2mArr = new ECPoint.F2m[16];
        f2mArr[1] = f2m;
        if (b == 0) {
            bArr = alpha0Tnaf;
        } else {
            bArr = alpha1Tnaf;
        }
        int length = bArr.length;
        for (int i = 3; i < length; i += 2) {
            f2mArr[i] = multiplyFromTnaf(f2m, bArr[i]);
        }
        return f2mArr;
    }

    public static BigInteger[] getSi(ECCurve.F2m f2m) {
        BigInteger add;
        BigInteger add2;
        if (f2m.isKoblitz()) {
            int m = f2m.getM();
            int intValue = f2m.getA().toBigInteger().intValue();
            byte mu = f2m.getMu();
            int intValue2 = f2m.getH().intValue();
            BigInteger[] lucas = getLucas(mu, (m + 3) - intValue, false);
            if (mu == 1) {
                BigInteger bigInteger = ECConstants.ONE;
                add = bigInteger.subtract(lucas[1]);
                add2 = bigInteger.subtract(lucas[0]);
            } else if (mu == -1) {
                BigInteger bigInteger2 = ECConstants.ONE;
                add = bigInteger2.add(lucas[1]);
                add2 = bigInteger2.add(lucas[0]);
            } else {
                throw new IllegalArgumentException("mu must be 1 or -1");
            }
            BigInteger[] bigIntegerArr = new BigInteger[2];
            if (intValue2 == 2) {
                bigIntegerArr[0] = add.shiftRight(1);
                bigIntegerArr[1] = add2.shiftRight(1).negate();
            } else if (intValue2 == 4) {
                bigIntegerArr[0] = add.shiftRight(2);
                bigIntegerArr[1] = add2.shiftRight(2).negate();
            } else {
                throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
            }
            return bigIntegerArr;
        }
        throw new IllegalArgumentException("si is defined for Koblitz curves only");
    }

    public static BigInteger getTw(byte b, int i) {
        if (i == 4) {
            if (b == 1) {
                return BigInteger.valueOf(6L);
            }
            return BigInteger.valueOf(10L);
        }
        BigInteger[] lucas = getLucas(b, i, false);
        BigInteger bit = ECConstants.ZERO.setBit(i);
        return ECConstants.TWO.multiply(lucas[0]).multiply(lucas[1].modInverse(bit)).mod(bit);
    }

    public static ECPoint.F2m multiplyFromTnaf(ECPoint.F2m f2m, byte[] bArr) {
        ECPoint.F2m f2m2 = (ECPoint.F2m) ((ECCurve.F2m) f2m.getCurve()).getInfinity();
        for (int length = bArr.length - 1; length >= 0; length--) {
            f2m2 = tau(f2m2);
            if (bArr[length] == 1) {
                f2m2 = f2m2.addSimple(f2m);
            } else if (bArr[length] == -1) {
                f2m2 = f2m2.subtractSimple(f2m);
            }
        }
        return f2m2;
    }

    public static ECPoint.F2m multiplyRTnaf(ECPoint.F2m f2m, BigInteger bigInteger) {
        ECCurve.F2m f2m2 = (ECCurve.F2m) f2m.getCurve();
        return multiplyTnaf(f2m, partModReduction(bigInteger, f2m2.getM(), (byte) f2m2.getA().toBigInteger().intValue(), f2m2.getSi(), f2m2.getMu(), (byte) 10));
    }

    public static ECPoint.F2m multiplyTnaf(ECPoint.F2m f2m, ZTauElement zTauElement) {
        return multiplyFromTnaf(f2m, tauAdicNaf(((ECCurve.F2m) f2m.getCurve()).getMu(), zTauElement));
    }

    public static BigInteger norm(byte b, ZTauElement zTauElement) {
        BigInteger bigInteger = zTauElement.f6157u;
        BigInteger multiply = bigInteger.multiply(bigInteger);
        BigInteger multiply2 = zTauElement.f6157u.multiply(zTauElement.f6158v);
        BigInteger bigInteger2 = zTauElement.f6158v;
        BigInteger shiftLeft = bigInteger2.multiply(bigInteger2).shiftLeft(1);
        if (b == 1) {
            return multiply.add(multiply2).add(shiftLeft);
        }
        if (b == -1) {
            return multiply.subtract(multiply2).add(shiftLeft);
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }

    public static ZTauElement partModReduction(BigInteger bigInteger, int i, byte b, BigInteger[] bigIntegerArr, byte b2, byte b3) {
        BigInteger subtract;
        if (b2 == 1) {
            subtract = bigIntegerArr[0].add(bigIntegerArr[1]);
        } else {
            subtract = bigIntegerArr[0].subtract(bigIntegerArr[1]);
        }
        BigInteger bigInteger2 = getLucas(b2, i, true)[1];
        ZTauElement round = round(approximateDivisionByN(bigInteger, bigIntegerArr[0], bigInteger2, b, i, b3), approximateDivisionByN(bigInteger, bigIntegerArr[1], bigInteger2, b, i, b3), b2);
        return new ZTauElement(bigInteger.subtract(subtract.multiply(round.f6157u)).subtract(BigInteger.valueOf(2L).multiply(bigIntegerArr[1]).multiply(round.f6158v)), bigIntegerArr[1].multiply(round.f6157u).subtract(bigIntegerArr[0].multiply(round.f6158v)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
        if (r5.compareTo(org.spongycastle.math.p017ec.Tnaf.MINUS_ONE) < 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006f, code lost:
        if (r8.compareTo(org.spongycastle.math.p017ec.ECConstants.TWO) >= 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007f, code lost:
        if (r5.compareTo(r9) >= 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
        if (r8.compareTo(org.spongycastle.math.p017ec.Tnaf.MINUS_TWO) < 0) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.spongycastle.math.p017ec.ZTauElement round(org.spongycastle.math.p017ec.SimpleBigDecimal r8, org.spongycastle.math.p017ec.SimpleBigDecimal r9, byte r10) {
        /*
            int r0 = r8.getScale()
            int r1 = r9.getScale()
            if (r1 != r0) goto La5
            r0 = -1
            r1 = 1
            if (r10 == r1) goto L19
            if (r10 != r0) goto L11
            goto L19
        L11:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "mu must be 1 or -1"
            r8.<init>(r9)
            throw r8
        L19:
            java.math.BigInteger r2 = r8.round()
            java.math.BigInteger r3 = r9.round()
            org.spongycastle.math.ec.SimpleBigDecimal r8 = r8.subtract(r2)
            org.spongycastle.math.ec.SimpleBigDecimal r9 = r9.subtract(r3)
            org.spongycastle.math.ec.SimpleBigDecimal r4 = r8.add(r8)
            if (r10 != r1) goto L34
            org.spongycastle.math.ec.SimpleBigDecimal r4 = r4.add(r9)
            goto L38
        L34:
            org.spongycastle.math.ec.SimpleBigDecimal r4 = r4.subtract(r9)
        L38:
            org.spongycastle.math.ec.SimpleBigDecimal r5 = r9.add(r9)
            org.spongycastle.math.ec.SimpleBigDecimal r5 = r5.add(r9)
            org.spongycastle.math.ec.SimpleBigDecimal r9 = r5.add(r9)
            if (r10 != r1) goto L4f
            org.spongycastle.math.ec.SimpleBigDecimal r5 = r8.subtract(r5)
            org.spongycastle.math.ec.SimpleBigDecimal r8 = r8.add(r9)
            goto L57
        L4f:
            org.spongycastle.math.ec.SimpleBigDecimal r5 = r8.add(r5)
            org.spongycastle.math.ec.SimpleBigDecimal r8 = r8.subtract(r9)
        L57:
            java.math.BigInteger r9 = org.spongycastle.math.p017ec.ECConstants.ONE
            int r6 = r4.compareTo(r9)
            r7 = 0
            if (r6 < 0) goto L69
            java.math.BigInteger r6 = org.spongycastle.math.p017ec.Tnaf.MINUS_ONE
            int r6 = r5.compareTo(r6)
            if (r6 >= 0) goto L73
            goto L71
        L69:
            java.math.BigInteger r1 = org.spongycastle.math.p017ec.ECConstants.TWO
            int r1 = r8.compareTo(r1)
            if (r1 < 0) goto L72
        L71:
            r7 = r10
        L72:
            r1 = 0
        L73:
            java.math.BigInteger r6 = org.spongycastle.math.p017ec.Tnaf.MINUS_ONE
            int r4 = r4.compareTo(r6)
            if (r4 >= 0) goto L82
            int r8 = r5.compareTo(r9)
            if (r8 < 0) goto L8d
            goto L8a
        L82:
            java.math.BigInteger r9 = org.spongycastle.math.p017ec.Tnaf.MINUS_TWO
            int r8 = r8.compareTo(r9)
            if (r8 >= 0) goto L8c
        L8a:
            int r8 = -r10
            byte r7 = (byte) r8
        L8c:
            r0 = r1
        L8d:
            long r8 = (long) r0
            java.math.BigInteger r8 = java.math.BigInteger.valueOf(r8)
            java.math.BigInteger r8 = r2.add(r8)
            long r9 = (long) r7
            java.math.BigInteger r9 = java.math.BigInteger.valueOf(r9)
            java.math.BigInteger r9 = r3.add(r9)
            org.spongycastle.math.ec.ZTauElement r10 = new org.spongycastle.math.ec.ZTauElement
            r10.<init>(r8, r9)
            return r10
        La5:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r9 = "lambda0 and lambda1 do not have same scale"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.math.p017ec.Tnaf.round(org.spongycastle.math.ec.SimpleBigDecimal, org.spongycastle.math.ec.SimpleBigDecimal, byte):org.spongycastle.math.ec.ZTauElement");
    }

    public static ECPoint.F2m tau(ECPoint.F2m f2m) {
        if (f2m.isInfinity()) {
            return f2m;
        }
        return new ECPoint.F2m(f2m.getCurve(), f2m.getX().square(), f2m.getY().square(), f2m.isCompressed());
    }

    public static byte[] tauAdicNaf(byte b, ZTauElement zTauElement) {
        BigInteger subtract;
        if (b != 1 && b != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        int bitLength = norm(b, zTauElement).bitLength();
        byte[] bArr = new byte[bitLength > 30 ? bitLength + 4 : 34];
        BigInteger bigInteger = zTauElement.f6157u;
        BigInteger bigInteger2 = zTauElement.f6158v;
        int i = 0;
        int i2 = 0;
        while (true) {
            BigInteger bigInteger3 = ECConstants.ZERO;
            if (bigInteger.equals(bigInteger3) && bigInteger2.equals(bigInteger3)) {
                int i3 = i + 1;
                byte[] bArr2 = new byte[i3];
                System.arraycopy(bArr, 0, bArr2, 0, i3);
                return bArr2;
            }
            if (bigInteger.testBit(0)) {
                bArr[i2] = (byte) ECConstants.TWO.subtract(bigInteger.subtract(bigInteger2.shiftLeft(1)).mod(ECConstants.FOUR)).intValue();
                if (bArr[i2] == 1) {
                    bigInteger = bigInteger.clearBit(0);
                } else {
                    bigInteger = bigInteger.add(ECConstants.ONE);
                }
                i = i2;
            } else {
                bArr[i2] = 0;
            }
            BigInteger shiftRight = bigInteger.shiftRight(1);
            if (b == 1) {
                subtract = bigInteger2.add(shiftRight);
            } else {
                subtract = bigInteger2.subtract(shiftRight);
            }
            BigInteger negate = bigInteger.shiftRight(1).negate();
            i2++;
            bigInteger = subtract;
            bigInteger2 = negate;
        }
    }

    public static byte[] tauAdicWNaf(byte b, ZTauElement zTauElement, byte b2, BigInteger bigInteger, BigInteger bigInteger2, ZTauElement[] zTauElementArr) {
        BigInteger subtract;
        int intValue;
        boolean z;
        if (b != 1 && b != -1) {
            throw new IllegalArgumentException("mu must be 1 or -1");
        }
        int bitLength = norm(b, zTauElement).bitLength();
        byte[] bArr = new byte[bitLength > 30 ? bitLength + 4 + b2 : b2 + 34];
        BigInteger shiftRight = bigInteger.shiftRight(1);
        BigInteger bigInteger3 = zTauElement.f6157u;
        BigInteger bigInteger4 = zTauElement.f6158v;
        int i = 0;
        while (true) {
            BigInteger bigInteger5 = ECConstants.ZERO;
            if (bigInteger3.equals(bigInteger5) && bigInteger4.equals(bigInteger5)) {
                return bArr;
            }
            if (bigInteger3.testBit(0)) {
                BigInteger mod = bigInteger3.add(bigInteger4.multiply(bigInteger2)).mod(bigInteger);
                if (mod.compareTo(shiftRight) >= 0) {
                    intValue = mod.subtract(bigInteger).intValue();
                } else {
                    intValue = mod.intValue();
                }
                byte b3 = (byte) intValue;
                bArr[i] = b3;
                if (b3 < 0) {
                    b3 = (byte) (-b3);
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    bigInteger3 = bigInteger3.subtract(zTauElementArr[b3].f6157u);
                    bigInteger4 = bigInteger4.subtract(zTauElementArr[b3].f6158v);
                } else {
                    bigInteger3 = bigInteger3.add(zTauElementArr[b3].f6157u);
                    bigInteger4 = bigInteger4.add(zTauElementArr[b3].f6158v);
                }
            } else {
                bArr[i] = 0;
            }
            if (b == 1) {
                subtract = bigInteger4.add(bigInteger3.shiftRight(1));
            } else {
                subtract = bigInteger4.subtract(bigInteger3.shiftRight(1));
            }
            BigInteger negate = bigInteger3.shiftRight(1).negate();
            i++;
            bigInteger3 = subtract;
            bigInteger4 = negate;
        }
    }

    public static SimpleBigDecimal norm(byte b, SimpleBigDecimal simpleBigDecimal, SimpleBigDecimal simpleBigDecimal2) {
        SimpleBigDecimal multiply = simpleBigDecimal.multiply(simpleBigDecimal);
        SimpleBigDecimal multiply2 = simpleBigDecimal.multiply(simpleBigDecimal2);
        SimpleBigDecimal shiftLeft = simpleBigDecimal2.multiply(simpleBigDecimal2).shiftLeft(1);
        if (b == 1) {
            return multiply.add(multiply2).add(shiftLeft);
        }
        if (b == -1) {
            return multiply.subtract(multiply2).add(shiftLeft);
        }
        throw new IllegalArgumentException("mu must be 1 or -1");
    }
}
