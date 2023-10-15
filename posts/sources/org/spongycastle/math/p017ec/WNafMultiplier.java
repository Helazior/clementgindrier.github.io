package org.spongycastle.math.p017ec;

import java.math.BigInteger;

/* renamed from: org.spongycastle.math.ec.WNafMultiplier */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class WNafMultiplier implements ECMultiplier {
    @Override // org.spongycastle.math.p017ec.ECMultiplier
    public ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo) {
        WNafPreCompInfo wNafPreCompInfo;
        byte b;
        int length;
        if (preCompInfo != null && (preCompInfo instanceof WNafPreCompInfo)) {
            wNafPreCompInfo = (WNafPreCompInfo) preCompInfo;
        } else {
            wNafPreCompInfo = new WNafPreCompInfo();
        }
        int bitLength = bigInteger.bitLength();
        int i = 8;
        if (bitLength < 13) {
            b = 2;
            i = 1;
        } else if (bitLength < 41) {
            b = 3;
            i = 2;
        } else if (bitLength < 121) {
            b = 4;
            i = 4;
        } else if (bitLength < 337) {
            b = 5;
        } else if (bitLength < 897) {
            b = 6;
            i = 16;
        } else if (bitLength < 2305) {
            b = 7;
            i = 32;
        } else {
            b = 8;
            i = 127;
        }
        ECPoint[] preComp = wNafPreCompInfo.getPreComp();
        ECPoint twiceP = wNafPreCompInfo.getTwiceP();
        if (preComp == null) {
            preComp = new ECPoint[]{eCPoint};
            length = 1;
        } else {
            length = preComp.length;
        }
        if (twiceP == null) {
            twiceP = eCPoint.twice();
        }
        if (length < i) {
            ECPoint[] eCPointArr = new ECPoint[i];
            System.arraycopy(preComp, 0, eCPointArr, 0, length);
            while (length < i) {
                eCPointArr[length] = twiceP.add(eCPointArr[length - 1]);
                length++;
            }
            preComp = eCPointArr;
        }
        byte[] windowNaf = windowNaf(b, bigInteger);
        int length2 = windowNaf.length;
        ECPoint infinity = eCPoint.getCurve().getInfinity();
        for (int i2 = length2 - 1; i2 >= 0; i2--) {
            infinity = infinity.twice();
            if (windowNaf[i2] != 0) {
                if (windowNaf[i2] > 0) {
                    infinity = infinity.add(preComp[(windowNaf[i2] - 1) / 2]);
                } else {
                    infinity = infinity.subtract(preComp[((-windowNaf[i2]) - 1) / 2]);
                }
            }
        }
        wNafPreCompInfo.setPreComp(preComp);
        wNafPreCompInfo.setTwiceP(twiceP);
        eCPoint.setPreCompInfo(wNafPreCompInfo);
        return infinity;
    }

    public byte[] windowNaf(byte b, BigInteger bigInteger) {
        byte[] bArr = new byte[bigInteger.bitLength() + 1];
        short s = (short) (1 << b);
        BigInteger valueOf = BigInteger.valueOf(s);
        int i = 0;
        int i2 = 0;
        while (bigInteger.signum() > 0) {
            if (bigInteger.testBit(0)) {
                BigInteger mod = bigInteger.mod(valueOf);
                if (mod.testBit(b - 1)) {
                    bArr[i2] = (byte) (mod.intValue() - s);
                } else {
                    bArr[i2] = (byte) mod.intValue();
                }
                bigInteger = bigInteger.subtract(BigInteger.valueOf(bArr[i2]));
                i = i2;
            } else {
                bArr[i2] = 0;
            }
            bigInteger = bigInteger.shiftRight(1);
            i2++;
        }
        int i3 = i + 1;
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        return bArr2;
    }
}
