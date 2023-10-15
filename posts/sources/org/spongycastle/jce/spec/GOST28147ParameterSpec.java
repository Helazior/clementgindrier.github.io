package org.spongycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.crypto.engines.GOST28147Engine;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class GOST28147ParameterSpec implements AlgorithmParameterSpec {

    /* renamed from: iv */
    private byte[] f6124iv;
    private byte[] sBox;

    public GOST28147ParameterSpec(byte[] bArr) {
        this.f6124iv = null;
        this.sBox = null;
        byte[] bArr2 = new byte[bArr.length];
        this.sBox = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public byte[] getIV() {
        byte[] bArr = this.f6124iv;
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public byte[] getSbox() {
        return this.sBox;
    }

    public GOST28147ParameterSpec(byte[] bArr, byte[] bArr2) {
        this(bArr);
        byte[] bArr3 = new byte[bArr2.length];
        this.f6124iv = bArr3;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
    }

    public GOST28147ParameterSpec(String str) {
        this.f6124iv = null;
        this.sBox = null;
        this.sBox = GOST28147Engine.getSBox(str);
    }

    public GOST28147ParameterSpec(String str, byte[] bArr) {
        this(str);
        byte[] bArr2 = new byte[bArr.length];
        this.f6124iv = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }
}
