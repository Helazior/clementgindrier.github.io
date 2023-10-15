package org.spongycastle.crypto.p013io;

import java.io.OutputStream;
import org.spongycastle.crypto.Mac;

/* renamed from: org.spongycastle.crypto.io.MacOutputStream */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MacOutputStream extends OutputStream {
    public Mac mac;

    public MacOutputStream(Mac mac) {
        this.mac = mac;
    }

    public byte[] getMac() {
        byte[] bArr = new byte[this.mac.getMacSize()];
        this.mac.doFinal(bArr, 0);
        return bArr;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.mac.update((byte) i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.mac.update(bArr, i, i2);
    }
}
