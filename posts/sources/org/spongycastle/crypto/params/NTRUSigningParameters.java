package org.spongycastle.crypto.params;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUSigningParameters implements Cloneable {

    /* renamed from: B */
    public int f6048B;

    /* renamed from: N */
    public int f6049N;
    public double beta;
    public double betaSq;
    public int bitsF;

    /* renamed from: d */
    public int f6050d;

    /* renamed from: d1 */
    public int f6051d1;

    /* renamed from: d2 */
    public int f6052d2;

    /* renamed from: d3 */
    public int f6053d3;
    public Digest hashAlg;
    public double normBound;
    public double normBoundSq;

    /* renamed from: q */
    public int f6054q;
    public int signFailTolerance;

    public NTRUSigningParameters(int i, int i2, int i3, int i4, double d, double d2, Digest digest) {
        this.signFailTolerance = 100;
        this.bitsF = 6;
        this.f6049N = i;
        this.f6054q = i2;
        this.f6050d = i3;
        this.f6048B = i4;
        this.beta = d;
        this.normBound = d2;
        this.hashAlg = digest;
        init();
    }

    private void init() {
        double d = this.beta;
        this.betaSq = d * d;
        double d2 = this.normBound;
        this.normBoundSq = d2 * d2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NTRUSigningParameters)) {
            NTRUSigningParameters nTRUSigningParameters = (NTRUSigningParameters) obj;
            if (this.f6048B == nTRUSigningParameters.f6048B && this.f6049N == nTRUSigningParameters.f6049N && Double.doubleToLongBits(this.beta) == Double.doubleToLongBits(nTRUSigningParameters.beta) && Double.doubleToLongBits(this.betaSq) == Double.doubleToLongBits(nTRUSigningParameters.betaSq) && this.bitsF == nTRUSigningParameters.bitsF && this.f6050d == nTRUSigningParameters.f6050d && this.f6051d1 == nTRUSigningParameters.f6051d1 && this.f6052d2 == nTRUSigningParameters.f6052d2 && this.f6053d3 == nTRUSigningParameters.f6053d3) {
                Digest digest = this.hashAlg;
                if (digest == null) {
                    if (nTRUSigningParameters.hashAlg != null) {
                        return false;
                    }
                } else if (!digest.getAlgorithmName().equals(nTRUSigningParameters.hashAlg.getAlgorithmName())) {
                    return false;
                }
                return Double.doubleToLongBits(this.normBound) == Double.doubleToLongBits(nTRUSigningParameters.normBound) && Double.doubleToLongBits(this.normBoundSq) == Double.doubleToLongBits(nTRUSigningParameters.normBoundSq) && this.f6054q == nTRUSigningParameters.f6054q && this.signFailTolerance == nTRUSigningParameters.signFailTolerance;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        int i = ((this.f6048B + 31) * 31) + this.f6049N;
        long doubleToLongBits = Double.doubleToLongBits(this.beta);
        long doubleToLongBits2 = Double.doubleToLongBits(this.betaSq);
        int i2 = ((((((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.bitsF) * 31) + this.f6050d) * 31) + this.f6051d1) * 31) + this.f6052d2) * 31) + this.f6053d3) * 31;
        Digest digest = this.hashAlg;
        int hashCode = i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode());
        long doubleToLongBits3 = Double.doubleToLongBits(this.normBound);
        long doubleToLongBits4 = Double.doubleToLongBits(this.normBoundSq);
        return (((((((hashCode * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + this.f6054q) * 31) + this.signFailTolerance;
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder m253r = outline.m253r("SignatureParameters(N=");
        m253r.append(this.f6049N);
        m253r.append(" q=");
        m253r.append(this.f6054q);
        StringBuilder sb = new StringBuilder(m253r.toString());
        StringBuilder m253r2 = outline.m253r(" B=");
        m253r2.append(this.f6048B);
        m253r2.append(" beta=");
        m253r2.append(decimalFormat.format(this.beta));
        m253r2.append(" normBound=");
        m253r2.append(decimalFormat.format(this.normBound));
        m253r2.append(" hashAlg=");
        m253r2.append(this.hashAlg);
        m253r2.append(")");
        sb.append(m253r2.toString());
        return sb.toString();
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.f6049N);
        dataOutputStream.writeInt(this.f6054q);
        dataOutputStream.writeInt(this.f6050d);
        dataOutputStream.writeInt(this.f6051d1);
        dataOutputStream.writeInt(this.f6052d2);
        dataOutputStream.writeInt(this.f6053d3);
        dataOutputStream.writeInt(this.f6048B);
        dataOutputStream.writeDouble(this.beta);
        dataOutputStream.writeDouble(this.normBound);
        dataOutputStream.writeInt(this.signFailTolerance);
        dataOutputStream.writeInt(this.bitsF);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
    }

    public NTRUSigningParameters clone() {
        return new NTRUSigningParameters(this.f6049N, this.f6054q, this.f6050d, this.f6048B, this.beta, this.normBound, this.hashAlg);
    }

    public NTRUSigningParameters(int i, int i2, int i3, int i4, int i5, int i6, double d, double d2, double d3, Digest digest) {
        this.signFailTolerance = 100;
        this.bitsF = 6;
        this.f6049N = i;
        this.f6054q = i2;
        this.f6051d1 = i3;
        this.f6052d2 = i4;
        this.f6053d3 = i5;
        this.f6048B = i6;
        this.beta = d;
        this.normBound = d2;
        this.hashAlg = digest;
        init();
    }

    public NTRUSigningParameters(InputStream inputStream) {
        this.signFailTolerance = 100;
        this.bitsF = 6;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f6049N = dataInputStream.readInt();
        this.f6054q = dataInputStream.readInt();
        this.f6050d = dataInputStream.readInt();
        this.f6051d1 = dataInputStream.readInt();
        this.f6052d2 = dataInputStream.readInt();
        this.f6053d3 = dataInputStream.readInt();
        this.f6048B = dataInputStream.readInt();
        this.beta = dataInputStream.readDouble();
        this.normBound = dataInputStream.readDouble();
        this.signFailTolerance = dataInputStream.readInt();
        this.bitsF = dataInputStream.readInt();
        String readUTF = dataInputStream.readUTF();
        if ("SHA-512".equals(readUTF)) {
            this.hashAlg = new SHA512Digest();
        } else if ("SHA-256".equals(readUTF)) {
            this.hashAlg = new SHA256Digest();
        }
        init();
    }
}
