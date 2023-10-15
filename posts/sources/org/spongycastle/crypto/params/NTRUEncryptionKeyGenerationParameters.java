package org.spongycastle.crypto.params;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Arrays;
import org.kxml2.wap.Wbxml;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.tls.CipherSuite;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUEncryptionKeyGenerationParameters extends KeyGenerationParameters implements Cloneable {

    /* renamed from: N */
    public int f6023N;
    public int bufferLenBits;
    public int bufferLenTrits;

    /* renamed from: c */
    public int f6024c;

    /* renamed from: db */
    public int f6025db;

    /* renamed from: df */
    public int f6026df;
    public int df1;
    public int df2;
    public int df3;

    /* renamed from: dg */
    public int f6027dg;
    public int dm0;

    /* renamed from: dr */
    public int f6028dr;
    public int dr1;
    public int dr2;
    public int dr3;
    public boolean fastFp;
    public Digest hashAlg;
    public boolean hashSeed;
    public int llen;
    public int maxMsgLenBytes;
    public int minCallsMask;
    public int minCallsR;
    public byte[] oid;
    public int pkLen;
    public int polyType;

    /* renamed from: q */
    public int f6029q;
    public boolean sparse;
    public static final NTRUEncryptionKeyGenerationParameters EES1087EP2 = new NTRUEncryptionKeyGenerationParameters(1087, 2048, 120, 120, 256, 13, 25, 14, true, new byte[]{0, 6, 3}, true, false, new SHA512Digest());
    public static final NTRUEncryptionKeyGenerationParameters EES1171EP1 = new NTRUEncryptionKeyGenerationParameters(1171, 2048, 106, 106, 256, 13, 20, 15, true, new byte[]{0, 6, 4}, true, false, new SHA512Digest());
    public static final NTRUEncryptionKeyGenerationParameters EES1499EP1 = new NTRUEncryptionKeyGenerationParameters(1499, 2048, 79, 79, 256, 13, 17, 19, true, new byte[]{0, 6, 5}, true, false, new SHA512Digest());
    public static final NTRUEncryptionKeyGenerationParameters APR2011_439 = new NTRUEncryptionKeyGenerationParameters(439, 2048, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, Wbxml.EXT_T_2, 128, 9, 32, 9, true, new byte[]{0, 7, 101}, true, false, new SHA256Digest());
    public static final NTRUEncryptionKeyGenerationParameters APR2011_439_FAST = new NTRUEncryptionKeyGenerationParameters(439, 2048, 9, 8, 5, Wbxml.EXT_T_2, 128, 9, 32, 9, true, new byte[]{0, 7, 101}, true, true, new SHA256Digest());
    public static final NTRUEncryptionKeyGenerationParameters APR2011_743 = new NTRUEncryptionKeyGenerationParameters(743, 2048, 248, 220, 256, 10, 27, 14, true, new byte[]{0, 7, 105}, false, false, new SHA512Digest());
    public static final NTRUEncryptionKeyGenerationParameters APR2011_743_FAST = new NTRUEncryptionKeyGenerationParameters(743, 2048, 11, 11, 15, 220, 256, 10, 27, 14, true, new byte[]{0, 7, 105}, false, true, new SHA512Digest());

    public NTRUEncryptionKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        super(new SecureRandom(), i5);
        this.f6023N = i;
        this.f6029q = i2;
        this.f6026df = i3;
        this.f6025db = i5;
        this.dm0 = i4;
        this.f6024c = i6;
        this.minCallsR = i7;
        this.minCallsMask = i8;
        this.hashSeed = z;
        this.oid = bArr;
        this.sparse = z2;
        this.fastFp = z3;
        this.polyType = 0;
        this.hashAlg = digest;
        init();
    }

    private void init() {
        this.f6028dr = this.f6026df;
        this.dr1 = this.df1;
        this.dr2 = this.df2;
        this.dr3 = this.df3;
        int i = this.f6023N;
        this.f6027dg = i / 3;
        this.llen = 1;
        int i2 = this.f6025db;
        this.maxMsgLenBytes = (((((i * 3) / 2) / 8) - 1) - (i2 / 8)) - 1;
        this.bufferLenBits = (((((i * 3) / 2) + 7) / 8) * 8) + 1;
        this.bufferLenTrits = i - 1;
        this.pkLen = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            NTRUEncryptionKeyGenerationParameters nTRUEncryptionKeyGenerationParameters = (NTRUEncryptionKeyGenerationParameters) obj;
            if (this.f6023N == nTRUEncryptionKeyGenerationParameters.f6023N && this.bufferLenBits == nTRUEncryptionKeyGenerationParameters.bufferLenBits && this.bufferLenTrits == nTRUEncryptionKeyGenerationParameters.bufferLenTrits && this.f6024c == nTRUEncryptionKeyGenerationParameters.f6024c && this.f6025db == nTRUEncryptionKeyGenerationParameters.f6025db && this.f6026df == nTRUEncryptionKeyGenerationParameters.f6026df && this.df1 == nTRUEncryptionKeyGenerationParameters.df1 && this.df2 == nTRUEncryptionKeyGenerationParameters.df2 && this.df3 == nTRUEncryptionKeyGenerationParameters.df3 && this.f6027dg == nTRUEncryptionKeyGenerationParameters.f6027dg && this.dm0 == nTRUEncryptionKeyGenerationParameters.dm0 && this.f6028dr == nTRUEncryptionKeyGenerationParameters.f6028dr && this.dr1 == nTRUEncryptionKeyGenerationParameters.dr1 && this.dr2 == nTRUEncryptionKeyGenerationParameters.dr2 && this.dr3 == nTRUEncryptionKeyGenerationParameters.dr3 && this.fastFp == nTRUEncryptionKeyGenerationParameters.fastFp) {
                Digest digest = this.hashAlg;
                if (digest == null) {
                    if (nTRUEncryptionKeyGenerationParameters.hashAlg != null) {
                        return false;
                    }
                } else if (!digest.getAlgorithmName().equals(nTRUEncryptionKeyGenerationParameters.hashAlg.getAlgorithmName())) {
                    return false;
                }
                return this.hashSeed == nTRUEncryptionKeyGenerationParameters.hashSeed && this.llen == nTRUEncryptionKeyGenerationParameters.llen && this.maxMsgLenBytes == nTRUEncryptionKeyGenerationParameters.maxMsgLenBytes && this.minCallsMask == nTRUEncryptionKeyGenerationParameters.minCallsMask && this.minCallsR == nTRUEncryptionKeyGenerationParameters.minCallsR && Arrays.equals(this.oid, nTRUEncryptionKeyGenerationParameters.oid) && this.pkLen == nTRUEncryptionKeyGenerationParameters.pkLen && this.polyType == nTRUEncryptionKeyGenerationParameters.polyType && this.f6029q == nTRUEncryptionKeyGenerationParameters.f6029q && this.sparse == nTRUEncryptionKeyGenerationParameters.sparse;
            }
            return false;
        }
        return false;
    }

    public NTRUEncryptionParameters getEncryptionParameters() {
        if (this.polyType == 0) {
            return new NTRUEncryptionParameters(this.f6023N, this.f6029q, this.f6026df, this.dm0, this.f6025db, this.f6024c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
        }
        return new NTRUEncryptionParameters(this.f6023N, this.f6029q, this.df1, this.df2, this.df3, this.dm0, this.f6025db, this.f6024c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
    }

    public int getMaxMessageLength() {
        return this.maxMsgLenBytes;
    }

    public int hashCode() {
        int i = (((((((((((((((((((((((((((((((this.f6023N + 31) * 31) + this.bufferLenBits) * 31) + this.bufferLenTrits) * 31) + this.f6024c) * 31) + this.f6025db) * 31) + this.f6026df) * 31) + this.df1) * 31) + this.df2) * 31) + this.df3) * 31) + this.f6027dg) * 31) + this.dm0) * 31) + this.f6028dr) * 31) + this.dr1) * 31) + this.dr2) * 31) + this.dr3) * 31) + (this.fastFp ? 1231 : 1237)) * 31;
        Digest digest = this.hashAlg;
        return ((((((((Arrays.hashCode(this.oid) + ((((((((((((i + (digest == null ? 0 : digest.getAlgorithmName().hashCode())) * 31) + (this.hashSeed ? 1231 : 1237)) * 31) + this.llen) * 31) + this.maxMsgLenBytes) * 31) + this.minCallsMask) * 31) + this.minCallsR) * 31)) * 31) + this.pkLen) * 31) + this.polyType) * 31) + this.f6029q) * 31) + (this.sparse ? 1231 : 1237);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("EncryptionParameters(N=");
        m253r.append(this.f6023N);
        m253r.append(" q=");
        m253r.append(this.f6029q);
        StringBuilder sb = new StringBuilder(m253r.toString());
        if (this.polyType == 0) {
            StringBuilder m253r2 = outline.m253r(" polyType=SIMPLE df=");
            m253r2.append(this.f6026df);
            sb.append(m253r2.toString());
        } else {
            StringBuilder m253r3 = outline.m253r(" polyType=PRODUCT df1=");
            m253r3.append(this.df1);
            m253r3.append(" df2=");
            m253r3.append(this.df2);
            m253r3.append(" df3=");
            m253r3.append(this.df3);
            sb.append(m253r3.toString());
        }
        StringBuilder m253r4 = outline.m253r(" dm0=");
        m253r4.append(this.dm0);
        m253r4.append(" db=");
        m253r4.append(this.f6025db);
        m253r4.append(" c=");
        m253r4.append(this.f6024c);
        m253r4.append(" minCallsR=");
        m253r4.append(this.minCallsR);
        m253r4.append(" minCallsMask=");
        m253r4.append(this.minCallsMask);
        m253r4.append(" hashSeed=");
        m253r4.append(this.hashSeed);
        m253r4.append(" hashAlg=");
        m253r4.append(this.hashAlg);
        m253r4.append(" oid=");
        m253r4.append(Arrays.toString(this.oid));
        m253r4.append(" sparse=");
        m253r4.append(this.sparse);
        m253r4.append(")");
        sb.append(m253r4.toString());
        return sb.toString();
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.f6023N);
        dataOutputStream.writeInt(this.f6029q);
        dataOutputStream.writeInt(this.f6026df);
        dataOutputStream.writeInt(this.df1);
        dataOutputStream.writeInt(this.df2);
        dataOutputStream.writeInt(this.df3);
        dataOutputStream.writeInt(this.f6025db);
        dataOutputStream.writeInt(this.dm0);
        dataOutputStream.writeInt(this.f6024c);
        dataOutputStream.writeInt(this.minCallsR);
        dataOutputStream.writeInt(this.minCallsMask);
        dataOutputStream.writeBoolean(this.hashSeed);
        dataOutputStream.write(this.oid);
        dataOutputStream.writeBoolean(this.sparse);
        dataOutputStream.writeBoolean(this.fastFp);
        dataOutputStream.write(this.polyType);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
    }

    public NTRUEncryptionKeyGenerationParameters clone() {
        if (this.polyType == 0) {
            return new NTRUEncryptionKeyGenerationParameters(this.f6023N, this.f6029q, this.f6026df, this.dm0, this.f6025db, this.f6024c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
        }
        return new NTRUEncryptionKeyGenerationParameters(this.f6023N, this.f6029q, this.df1, this.df2, this.df3, this.dm0, this.f6025db, this.f6024c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
    }

    public NTRUEncryptionKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        super(new SecureRandom(), i7);
        this.f6023N = i;
        this.f6029q = i2;
        this.df1 = i3;
        this.df2 = i4;
        this.df3 = i5;
        this.f6025db = i7;
        this.dm0 = i6;
        this.f6024c = i8;
        this.minCallsR = i9;
        this.minCallsMask = i10;
        this.hashSeed = z;
        this.oid = bArr;
        this.sparse = z2;
        this.fastFp = z3;
        this.polyType = 1;
        this.hashAlg = digest;
        init();
    }

    public NTRUEncryptionKeyGenerationParameters(InputStream inputStream) {
        super(new SecureRandom(), -1);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f6023N = dataInputStream.readInt();
        this.f6029q = dataInputStream.readInt();
        this.f6026df = dataInputStream.readInt();
        this.df1 = dataInputStream.readInt();
        this.df2 = dataInputStream.readInt();
        this.df3 = dataInputStream.readInt();
        this.f6025db = dataInputStream.readInt();
        this.dm0 = dataInputStream.readInt();
        this.f6024c = dataInputStream.readInt();
        this.minCallsR = dataInputStream.readInt();
        this.minCallsMask = dataInputStream.readInt();
        this.hashSeed = dataInputStream.readBoolean();
        byte[] bArr = new byte[3];
        this.oid = bArr;
        dataInputStream.read(bArr);
        this.sparse = dataInputStream.readBoolean();
        this.fastFp = dataInputStream.readBoolean();
        this.polyType = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        if ("SHA-512".equals(readUTF)) {
            this.hashAlg = new SHA512Digest();
        } else if ("SHA-256".equals(readUTF)) {
            this.hashAlg = new SHA256Digest();
        }
        init();
    }
}
