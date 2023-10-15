package org.spongycastle.math.p017ec;

import org.spongycastle.math.p017ec.ECPoint;

/* renamed from: org.spongycastle.math.ec.WTauNafPreCompInfo */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class WTauNafPreCompInfo implements PreCompInfo {
    private ECPoint.F2m[] preComp;

    public WTauNafPreCompInfo(ECPoint.F2m[] f2mArr) {
        this.preComp = null;
        this.preComp = f2mArr;
    }

    public ECPoint.F2m[] getPreComp() {
        return this.preComp;
    }
}
