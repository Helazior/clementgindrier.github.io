package org.spongycastle.crypto.params;

import java.math.BigInteger;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DHPublicKeyParameters extends DHKeyParameters {

    /* renamed from: y */
    private BigInteger f5998y;

    public DHPublicKeyParameters(BigInteger bigInteger, DHParameters dHParameters) {
        super(false, dHParameters);
        this.f5998y = bigInteger;
    }

    @Override // org.spongycastle.crypto.params.DHKeyParameters
    public boolean equals(Object obj) {
        return (obj instanceof DHPublicKeyParameters) && ((DHPublicKeyParameters) obj).getY().equals(this.f5998y) && super.equals(obj);
    }

    public BigInteger getY() {
        return this.f5998y;
    }

    @Override // org.spongycastle.crypto.params.DHKeyParameters
    public int hashCode() {
        return this.f5998y.hashCode() ^ super.hashCode();
    }
}
