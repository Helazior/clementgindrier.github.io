package org.spongycastle.math.p017ec;

import java.math.BigInteger;

/* renamed from: org.spongycastle.math.ec.ECMultiplier */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ECMultiplier {
    ECPoint multiply(ECPoint eCPoint, BigInteger bigInteger, PreCompInfo preCompInfo);
}
