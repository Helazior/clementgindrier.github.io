package org.spongycastle.math.p017ec;

/* renamed from: org.spongycastle.math.ec.WNafPreCompInfo */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class WNafPreCompInfo implements PreCompInfo {
    private ECPoint[] preComp = null;
    private ECPoint twiceP = null;

    public ECPoint[] getPreComp() {
        return this.preComp;
    }

    public ECPoint getTwiceP() {
        return this.twiceP;
    }

    public void setPreComp(ECPoint[] eCPointArr) {
        this.preComp = eCPointArr;
    }

    public void setTwiceP(ECPoint eCPoint) {
        this.twiceP = eCPoint;
    }
}
