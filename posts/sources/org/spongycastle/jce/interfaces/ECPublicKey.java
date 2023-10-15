package org.spongycastle.jce.interfaces;

import java.security.PublicKey;
import org.spongycastle.math.p017ec.ECPoint;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ECPublicKey extends ECKey, PublicKey {
    ECPoint getQ();
}
