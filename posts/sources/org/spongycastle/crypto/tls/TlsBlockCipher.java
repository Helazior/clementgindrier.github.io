package org.spongycastle.crypto.tls;

import java.security.SecureRandom;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsBlockCipher implements TlsCipher {
    public TlsClientContext context;
    public BlockCipher decryptCipher;
    public BlockCipher encryptCipher;
    public TlsMac readMac;
    public TlsMac writeMac;

    public TlsBlockCipher(TlsClientContext tlsClientContext, BlockCipher blockCipher, BlockCipher blockCipher2, Digest digest, Digest digest2, int i) {
        this.context = tlsClientContext;
        this.encryptCipher = blockCipher;
        this.decryptCipher = blockCipher2;
        int i2 = i * 2;
        byte[] calculateKeyBlock = TlsUtils.calculateKeyBlock(tlsClientContext, blockCipher2.getBlockSize() + blockCipher.getBlockSize() + digest2.getDigestSize() + digest.getDigestSize() + i2);
        this.writeMac = new TlsMac(tlsClientContext, digest, calculateKeyBlock, 0, digest.getDigestSize());
        int digestSize = digest.getDigestSize() + 0;
        this.readMac = new TlsMac(tlsClientContext, digest2, calculateKeyBlock, digestSize, digest2.getDigestSize());
        int digestSize2 = digestSize + digest2.getDigestSize();
        initCipher(true, blockCipher, calculateKeyBlock, i, digestSize2, digestSize2 + i2);
        int i3 = digestSize2 + i;
        initCipher(false, blockCipher2, calculateKeyBlock, i, i3, blockCipher.getBlockSize() + i3 + i);
    }

    public int chooseExtraPadBlocks(SecureRandom secureRandom, int i) {
        return Math.min(lowestBitSet(secureRandom.nextInt()), i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r2 != 0) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007e  */
    @Override // org.spongycastle.crypto.tls.TlsCipher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] decodeCiphertext(short r10, byte[] r11, int r12, int r13) {
        /*
            r9 = this;
            org.spongycastle.crypto.tls.TlsMac r0 = r9.readMac
            int r0 = r0.getSize()
            r1 = 1
            int r0 = r0 + r1
            org.spongycastle.crypto.BlockCipher r2 = r9.decryptCipher
            int r2 = r2.getBlockSize()
            if (r13 < r0) goto L8e
            int r3 = r13 % r2
            if (r3 != 0) goto L86
            r3 = 0
            r4 = 0
        L16:
            if (r4 >= r13) goto L21
            org.spongycastle.crypto.BlockCipher r5 = r9.decryptCipher
            int r6 = r4 + r12
            r5.processBlock(r11, r6, r11, r6)
            int r4 = r4 + r2
            goto L16
        L21:
            int r4 = r12 + r13
            int r4 = r4 - r1
            r5 = r11[r4]
            r6 = r5 & 255(0xff, float:3.57E-43)
            org.spongycastle.crypto.tls.TlsClientContext r7 = r9.context
            org.spongycastle.crypto.tls.ProtocolVersion r7 = r7.getServerVersion()
            int r7 = r7.getFullVersion()
            org.spongycastle.crypto.tls.ProtocolVersion r8 = org.spongycastle.crypto.tls.ProtocolVersion.TLSv10
            int r8 = r8.getFullVersion()
            if (r7 < r8) goto L3c
            r7 = 1
            goto L3d
        L3c:
            r7 = 0
        L3d:
            int r13 = r13 - r0
            if (r7 != 0) goto L45
            int r0 = java.lang.Math.min(r13, r2)
            goto L46
        L45:
            r0 = r13
        L46:
            if (r6 <= r0) goto L4b
        L48:
            r0 = 1
            r6 = 0
            goto L5e
        L4b:
            if (r7 == 0) goto L5d
            int r0 = r4 - r6
            r2 = 0
        L50:
            if (r0 >= r4) goto L5a
            r7 = r11[r0]
            r7 = r7 ^ r5
            r2 = r2 | r7
            byte r2 = (byte) r2
            int r0 = r0 + 1
            goto L50
        L5a:
            if (r2 == 0) goto L5d
            goto L48
        L5d:
            r0 = 0
        L5e:
            int r13 = r13 - r6
            org.spongycastle.crypto.tls.TlsMac r2 = r9.readMac
            byte[] r10 = r2.calculateMac(r10, r11, r12, r13)
            int r2 = r10.length
            byte[] r2 = new byte[r2]
            int r4 = r12 + r13
            int r5 = r10.length
            java.lang.System.arraycopy(r11, r4, r2, r3, r5)
            boolean r10 = org.spongycastle.util.Arrays.constantTimeAreEqual(r10, r2)
            if (r10 != 0) goto L75
            goto L76
        L75:
            r1 = r0
        L76:
            if (r1 != 0) goto L7e
            byte[] r10 = new byte[r13]
            java.lang.System.arraycopy(r11, r12, r10, r3, r13)
            return r10
        L7e:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r11 = 20
            r10.<init>(r11)
            throw r10
        L86:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r11 = 21
            r10.<init>(r11)
            throw r10
        L8e:
            org.spongycastle.crypto.tls.TlsFatalAlert r10 = new org.spongycastle.crypto.tls.TlsFatalAlert
            r11 = 50
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsBlockCipher.decodeCiphertext(short, byte[], int, int):byte[]");
    }

    @Override // org.spongycastle.crypto.tls.TlsCipher
    public byte[] encodePlaintext(short s, byte[] bArr, int i, int i2) {
        int blockSize = this.encryptCipher.getBlockSize();
        int size = blockSize - (((this.writeMac.getSize() + i2) + 1) % blockSize);
        if (this.context.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion()) {
            size += chooseExtraPadBlocks(this.context.getSecureRandom(), (255 - size) / blockSize) * blockSize;
        }
        int size2 = this.writeMac.getSize() + i2 + size + 1;
        byte[] bArr2 = new byte[size2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        byte[] calculateMac = this.writeMac.calculateMac(s, bArr, i, i2);
        System.arraycopy(calculateMac, 0, bArr2, i2, calculateMac.length);
        int length = i2 + calculateMac.length;
        for (int i3 = 0; i3 <= size; i3++) {
            bArr2[i3 + length] = (byte) size;
        }
        for (int i4 = 0; i4 < size2; i4 += blockSize) {
            this.encryptCipher.processBlock(bArr2, i4, bArr2, i4);
        }
        return bArr2;
    }

    public TlsMac getReadMac() {
        return this.readMac;
    }

    public TlsMac getWriteMac() {
        return this.writeMac;
    }

    public void initCipher(boolean z, BlockCipher blockCipher, byte[] bArr, int i, int i2, int i3) {
        blockCipher.init(z, new ParametersWithIV(new KeyParameter(bArr, i2, i), bArr, i3, blockCipher.getBlockSize()));
    }

    public int lowestBitSet(int i) {
        if (i == 0) {
            return 32;
        }
        int i2 = 0;
        while ((i & 1) == 0) {
            i2++;
            i >>= 1;
        }
        return i2;
    }
}
