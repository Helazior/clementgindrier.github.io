package org.spongycastle.asn1.p012x9;

/* renamed from: org.spongycastle.asn1.x9.X9ECParametersHolder */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class X9ECParametersHolder {
    private X9ECParameters params;

    public abstract X9ECParameters createParameters();

    public X9ECParameters getParameters() {
        if (this.params == null) {
            this.params = createParameters();
        }
        return this.params;
    }
}
