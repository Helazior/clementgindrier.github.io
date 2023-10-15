package org.spongycastle.crypto.signers;

import java.nio.ByteBuffer;
import org.spongycastle.crypto.Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUSignerPrng {
    private int counter = 0;
    private Digest hashAlg;
    private byte[] seed;

    public NTRUSignerPrng(byte[] bArr, Digest digest) {
        this.seed = bArr;
        this.hashAlg = digest;
    }

    public byte[] nextBytes(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        while (allocate.hasRemaining()) {
            ByteBuffer allocate2 = ByteBuffer.allocate(this.seed.length + 4);
            allocate2.put(this.seed);
            allocate2.putInt(this.counter);
            byte[] array = allocate2.array();
            int digestSize = this.hashAlg.getDigestSize();
            byte[] bArr = new byte[digestSize];
            this.hashAlg.update(array, 0, array.length);
            this.hashAlg.doFinal(bArr, 0);
            if (allocate.remaining() < digestSize) {
                allocate.put(bArr, 0, allocate.remaining());
            } else {
                allocate.put(bArr);
            }
            this.counter++;
        }
        return allocate.array();
    }
}
