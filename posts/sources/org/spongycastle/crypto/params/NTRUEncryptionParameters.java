package org.spongycastle.crypto.params;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUEncryptionParameters implements Cloneable {

    /* renamed from: N */
    public int f6030N;
    public int bufferLenBits;
    public int bufferLenTrits;

    /* renamed from: c */
    public int f6031c;

    /* renamed from: db */
    public int f6032db;

    /* renamed from: df */
    public int f6033df;
    public int df1;
    public int df2;
    public int df3;

    /* renamed from: dg */
    public int f6034dg;
    public int dm0;

    /* renamed from: dr */
    public int f6035dr;
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
    public int f6036q;
    public boolean sparse;

    public NTRUEncryptionParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.f6030N = i;
        this.f6036q = i2;
        this.f6033df = i3;
        this.f6032db = i5;
        this.dm0 = i4;
        this.f6031c = i6;
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
        this.f6035dr = this.f6033df;
        this.dr1 = this.df1;
        this.dr2 = this.df2;
        this.dr3 = this.df3;
        int i = this.f6030N;
        this.f6034dg = i / 3;
        this.llen = 1;
        int i2 = this.f6032db;
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
            NTRUEncryptionParameters nTRUEncryptionParameters = (NTRUEncryptionParameters) obj;
            if (this.f6030N == nTRUEncryptionParameters.f6030N && this.bufferLenBits == nTRUEncryptionParameters.bufferLenBits && this.bufferLenTrits == nTRUEncryptionParameters.bufferLenTrits && this.f6031c == nTRUEncryptionParameters.f6031c && this.f6032db == nTRUEncryptionParameters.f6032db && this.f6033df == nTRUEncryptionParameters.f6033df && this.df1 == nTRUEncryptionParameters.df1 && this.df2 == nTRUEncryptionParameters.df2 && this.df3 == nTRUEncryptionParameters.df3 && this.f6034dg == nTRUEncryptionParameters.f6034dg && this.dm0 == nTRUEncryptionParameters.dm0 && this.f6035dr == nTRUEncryptionParameters.f6035dr && this.dr1 == nTRUEncryptionParameters.dr1 && this.dr2 == nTRUEncryptionParameters.dr2 && this.dr3 == nTRUEncryptionParameters.dr3 && this.fastFp == nTRUEncryptionParameters.fastFp) {
                Digest digest = this.hashAlg;
                if (digest == null) {
                    if (nTRUEncryptionParameters.hashAlg != null) {
                        return false;
                    }
                } else if (!digest.getAlgorithmName().equals(nTRUEncryptionParameters.hashAlg.getAlgorithmName())) {
                    return false;
                }
                return this.hashSeed == nTRUEncryptionParameters.hashSeed && this.llen == nTRUEncryptionParameters.llen && this.maxMsgLenBytes == nTRUEncryptionParameters.maxMsgLenBytes && this.minCallsMask == nTRUEncryptionParameters.minCallsMask && this.minCallsR == nTRUEncryptionParameters.minCallsR && Arrays.equals(this.oid, nTRUEncryptionParameters.oid) && this.pkLen == nTRUEncryptionParameters.pkLen && this.polyType == nTRUEncryptionParameters.polyType && this.f6036q == nTRUEncryptionParameters.f6036q && this.sparse == nTRUEncryptionParameters.sparse;
            }
            return false;
        }
        return false;
    }

    public int getMaxMessageLength() {
        return this.maxMsgLenBytes;
    }

    public int hashCode() {
        int i = (((((((((((((((((((((((((((((((this.f6030N + 31) * 31) + this.bufferLenBits) * 31) + this.bufferLenTrits) * 31) + this.f6031c) * 31) + this.f6032db) * 31) + this.f6033df) * 31) + this.df1) * 31) + this.df2) * 31) + this.df3) * 31) + this.f6034dg) * 31) + this.dm0) * 31) + this.f6035dr) * 31) + this.dr1) * 31) + this.dr2) * 31) + this.dr3) * 31) + (this.fastFp ? 1231 : 1237)) * 31;
        Digest digest = this.hashAlg;
        return ((((((((Arrays.hashCode(this.oid) + ((((((((((((i + (digest == null ? 0 : digest.getAlgorithmName().hashCode())) * 31) + (this.hashSeed ? 1231 : 1237)) * 31) + this.llen) * 31) + this.maxMsgLenBytes) * 31) + this.minCallsMask) * 31) + this.minCallsR) * 31)) * 31) + this.pkLen) * 31) + this.polyType) * 31) + this.f6036q) * 31) + (this.sparse ? 1231 : 1237);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("EncryptionParameters(N=");
        m253r.append(this.f6030N);
        m253r.append(" q=");
        m253r.append(this.f6036q);
        StringBuilder sb = new StringBuilder(m253r.toString());
        if (this.polyType == 0) {
            StringBuilder m253r2 = outline.m253r(" polyType=SIMPLE df=");
            m253r2.append(this.f6033df);
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
        m253r4.append(this.f6032db);
        m253r4.append(" c=");
        m253r4.append(this.f6031c);
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
        dataOutputStream.writeInt(this.f6030N);
        dataOutputStream.writeInt(this.f6036q);
        dataOutputStream.writeInt(this.f6033df);
        dataOutputStream.writeInt(this.df1);
        dataOutputStream.writeInt(this.df2);
        dataOutputStream.writeInt(this.df3);
        dataOutputStream.writeInt(this.f6032db);
        dataOutputStream.writeInt(this.dm0);
        dataOutputStream.writeInt(this.f6031c);
        dataOutputStream.writeInt(this.minCallsR);
        dataOutputStream.writeInt(this.minCallsMask);
        dataOutputStream.writeBoolean(this.hashSeed);
        dataOutputStream.write(this.oid);
        dataOutputStream.writeBoolean(this.sparse);
        dataOutputStream.writeBoolean(this.fastFp);
        dataOutputStream.write(this.polyType);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
    }

    public NTRUEncryptionParameters clone() {
        if (this.polyType == 0) {
            return new NTRUEncryptionParameters(this.f6030N, this.f6036q, this.f6033df, this.dm0, this.f6032db, this.f6031c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
        }
        return new NTRUEncryptionParameters(this.f6030N, this.f6036q, this.df1, this.df2, this.df3, this.dm0, this.f6032db, this.f6031c, this.minCallsR, this.minCallsMask, this.hashSeed, this.oid, this.sparse, this.fastFp, this.hashAlg);
    }

    public NTRUEncryptionParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, byte[] bArr, boolean z2, boolean z3, Digest digest) {
        this.f6030N = i;
        this.f6036q = i2;
        this.df1 = i3;
        this.df2 = i4;
        this.df3 = i5;
        this.f6032db = i7;
        this.dm0 = i6;
        this.f6031c = i8;
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

    public NTRUEncryptionParameters(InputStream inputStream) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f6030N = dataInputStream.readInt();
        this.f6036q = dataInputStream.readInt();
        this.f6033df = dataInputStream.readInt();
        this.df1 = dataInputStream.readInt();
        this.df2 = dataInputStream.readInt();
        this.df3 = dataInputStream.readInt();
        this.f6032db = dataInputStream.readInt();
        this.dm0 = dataInputStream.readInt();
        this.f6031c = dataInputStream.readInt();
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
