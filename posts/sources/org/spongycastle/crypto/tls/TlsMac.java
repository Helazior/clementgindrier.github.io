package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsMac {
    public TlsClientContext context;
    public Mac mac;
    public byte[] secret;
    public long seqNo = 0;

    public TlsMac(TlsClientContext tlsClientContext, Digest digest, byte[] bArr, int i, int i2) {
        this.context = tlsClientContext;
        KeyParameter keyParameter = new KeyParameter(bArr, i, i2);
        this.secret = Arrays.clone(keyParameter.getKey());
        if (tlsClientContext.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion()) {
            this.mac = new HMac(digest);
        } else {
            this.mac = new SSL3Mac(digest);
        }
        this.mac.init(keyParameter);
    }

    public byte[] calculateMac(short s, byte[] bArr, int i, int i2) {
        ProtocolVersion serverVersion = this.context.getServerVersion();
        boolean z = serverVersion.getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(z ? 13 : 11);
        try {
            long j = this.seqNo;
            this.seqNo = 1 + j;
            TlsUtils.writeUint64(j, byteArrayOutputStream);
            TlsUtils.writeUint8(s, byteArrayOutputStream);
            if (z) {
                TlsUtils.writeVersion(serverVersion, byteArrayOutputStream);
            }
            TlsUtils.writeUint16(i2, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.mac.update(byteArray, 0, byteArray.length);
            this.mac.update(bArr, i, i2);
            byte[] bArr2 = new byte[this.mac.getMacSize()];
            this.mac.doFinal(bArr2, 0);
            return bArr2;
        } catch (IOException unused) {
            throw new IllegalStateException("Internal error during mac calculation");
        }
    }

    public byte[] getMACSecret() {
        return this.secret;
    }

    public long getSequenceNumber() {
        return this.seqNo;
    }

    public int getSize() {
        return this.mac.getMacSize();
    }

    public void incSequenceNumber() {
        this.seqNo++;
    }
}
