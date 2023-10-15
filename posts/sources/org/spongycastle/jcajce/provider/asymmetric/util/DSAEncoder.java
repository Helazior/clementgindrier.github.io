package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface DSAEncoder {
    BigInteger[] decode(byte[] bArr);

    byte[] encode(BigInteger bigInteger, BigInteger bigInteger2);
}
