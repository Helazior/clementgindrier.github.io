package org.spongycastle.util.encoders;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        byte[] bArr = this.encodingTable;
        bArr[bArr.length - 2] = 45;
        bArr[bArr.length - 1] = 95;
        this.padding = (byte) 46;
        initialiseDecodingTable();
    }
}
