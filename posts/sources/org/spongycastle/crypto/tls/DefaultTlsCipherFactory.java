package org.spongycastle.crypto.tls;

import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.engines.AESFastEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.modes.CBCBlockCipher;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DefaultTlsCipherFactory implements TlsCipherFactory {
    public BlockCipher createAESBlockCipher() {
        return new CBCBlockCipher(new AESFastEngine());
    }

    public TlsCipher createAESCipher(TlsClientContext tlsClientContext, int i, int i2) {
        return new TlsBlockCipher(tlsClientContext, createAESBlockCipher(), createAESBlockCipher(), createDigest(i2), createDigest(i2), i);
    }

    @Override // org.spongycastle.crypto.tls.TlsCipherFactory
    public TlsCipher createCipher(TlsClientContext tlsClientContext, int i, int i2) {
        if (i != 7) {
            if (i != 8) {
                if (i == 9) {
                    return createAESCipher(tlsClientContext, 32, i2);
                }
                throw new TlsFatalAlert((short) 80);
            }
            return createAESCipher(tlsClientContext, 16, i2);
        }
        return createDESedeCipher(tlsClientContext, 24, i2);
    }

    public BlockCipher createDESedeBlockCipher() {
        return new CBCBlockCipher(new DESedeEngine());
    }

    public TlsCipher createDESedeCipher(TlsClientContext tlsClientContext, int i, int i2) {
        return new TlsBlockCipher(tlsClientContext, createDESedeBlockCipher(), createDESedeBlockCipher(), createDigest(i2), createDigest(i2), i);
    }

    public Digest createDigest(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return new SHA384Digest();
                    }
                    throw new TlsFatalAlert((short) 80);
                }
                return new SHA256Digest();
            }
            return new SHA1Digest();
        }
        return new MD5Digest();
    }
}
