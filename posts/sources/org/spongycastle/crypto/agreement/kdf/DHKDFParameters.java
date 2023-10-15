package org.spongycastle.crypto.agreement.kdf;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.crypto.DerivationParameters;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DHKDFParameters implements DerivationParameters {
    private ASN1ObjectIdentifier algorithm;
    private byte[] extraInfo;
    private int keySize;

    /* renamed from: z */
    private byte[] f5720z;

    public DHKDFParameters(DERObjectIdentifier dERObjectIdentifier, int i, byte[] bArr) {
        this(dERObjectIdentifier, i, bArr, null);
    }

    public ASN1ObjectIdentifier getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getExtraInfo() {
        return this.extraInfo;
    }

    public int getKeySize() {
        return this.keySize;
    }

    public byte[] getZ() {
        return this.f5720z;
    }

    public DHKDFParameters(DERObjectIdentifier dERObjectIdentifier, int i, byte[] bArr, byte[] bArr2) {
        this.algorithm = new ASN1ObjectIdentifier(dERObjectIdentifier.getId());
        this.keySize = i;
        this.f5720z = bArr;
        this.extraInfo = bArr2;
    }
}
