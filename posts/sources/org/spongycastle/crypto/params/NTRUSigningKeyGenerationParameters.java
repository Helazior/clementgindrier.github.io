package org.spongycastle.crypto.params;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.tls.CipherSuite;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NTRUSigningKeyGenerationParameters extends KeyGenerationParameters implements Cloneable {
    public static final int BASIS_TYPE_STANDARD = 0;
    public static final int BASIS_TYPE_TRANSPOSE = 1;
    public static final int KEY_GEN_ALG_FLOAT = 1;
    public static final int KEY_GEN_ALG_RESULTANT = 0;

    /* renamed from: B */
    public int f6041B;

    /* renamed from: N */
    public int f6042N;
    public int basisType;
    public double beta;
    public double betaSq;
    public int bitsF;

    /* renamed from: d */
    public int f6043d;

    /* renamed from: d1 */
    public int f6044d1;

    /* renamed from: d2 */
    public int f6045d2;

    /* renamed from: d3 */
    public int f6046d3;
    public Digest hashAlg;
    public int keyGenAlg;
    public double keyNormBound;
    public double keyNormBoundSq;
    public double normBound;
    public double normBoundSq;
    public int polyType;
    public boolean primeCheck;

    /* renamed from: q */
    public int f6047q;
    public int signFailTolerance;
    public boolean sparse;
    public static final NTRUSigningKeyGenerationParameters APR2011_439 = new NTRUSigningKeyGenerationParameters(439, 2048, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA, 1, 1, 0.165d, 400.0d, 280.0d, false, true, 0, new SHA256Digest());
    public static final NTRUSigningKeyGenerationParameters APR2011_439_PROD = new NTRUSigningKeyGenerationParameters(439, 2048, 9, 8, 5, 1, 1, 0.165d, 400.0d, 280.0d, false, true, 0, new SHA256Digest());
    public static final NTRUSigningKeyGenerationParameters APR2011_743 = new NTRUSigningKeyGenerationParameters(743, 2048, 248, 1, 1, 0.127d, 405.0d, 360.0d, true, false, 0, new SHA512Digest());
    public static final NTRUSigningKeyGenerationParameters APR2011_743_PROD = new NTRUSigningKeyGenerationParameters(743, 2048, 11, 11, 15, 1, 1, 0.127d, 405.0d, 360.0d, true, false, 0, new SHA512Digest());
    public static final NTRUSigningKeyGenerationParameters TEST157 = new NTRUSigningKeyGenerationParameters(157, 256, 29, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, new SHA256Digest());
    public static final NTRUSigningKeyGenerationParameters TEST157_PROD = new NTRUSigningKeyGenerationParameters(157, 256, 5, 5, 8, 1, 1, 0.38d, 200.0d, 80.0d, false, false, 0, new SHA256Digest());

    public NTRUSigningKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, double d, double d2, double d3, boolean z, boolean z2, int i6, Digest digest) {
        super(new SecureRandom(), i);
        this.signFailTolerance = 100;
        this.bitsF = 6;
        this.f6042N = i;
        this.f6047q = i2;
        this.f6043d = i3;
        this.f6041B = i4;
        this.basisType = i5;
        this.beta = d;
        this.normBound = d2;
        this.keyNormBound = d3;
        this.primeCheck = z;
        this.sparse = z2;
        this.keyGenAlg = i6;
        this.hashAlg = digest;
        this.polyType = 0;
        init();
    }

    private void init() {
        double d = this.beta;
        this.betaSq = d * d;
        double d2 = this.normBound;
        this.normBoundSq = d2 * d2;
        double d3 = this.keyNormBound;
        this.keyNormBoundSq = d3 * d3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NTRUSigningKeyGenerationParameters)) {
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = (NTRUSigningKeyGenerationParameters) obj;
            if (this.f6041B == nTRUSigningKeyGenerationParameters.f6041B && this.f6042N == nTRUSigningKeyGenerationParameters.f6042N && this.basisType == nTRUSigningKeyGenerationParameters.basisType && Double.doubleToLongBits(this.beta) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.beta) && Double.doubleToLongBits(this.betaSq) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.betaSq) && this.bitsF == nTRUSigningKeyGenerationParameters.bitsF && this.f6043d == nTRUSigningKeyGenerationParameters.f6043d && this.f6044d1 == nTRUSigningKeyGenerationParameters.f6044d1 && this.f6045d2 == nTRUSigningKeyGenerationParameters.f6045d2 && this.f6046d3 == nTRUSigningKeyGenerationParameters.f6046d3) {
                Digest digest = this.hashAlg;
                if (digest == null) {
                    if (nTRUSigningKeyGenerationParameters.hashAlg != null) {
                        return false;
                    }
                } else if (!digest.getAlgorithmName().equals(nTRUSigningKeyGenerationParameters.hashAlg.getAlgorithmName())) {
                    return false;
                }
                return this.keyGenAlg == nTRUSigningKeyGenerationParameters.keyGenAlg && Double.doubleToLongBits(this.keyNormBound) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.keyNormBound) && Double.doubleToLongBits(this.keyNormBoundSq) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.keyNormBoundSq) && Double.doubleToLongBits(this.normBound) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.normBound) && Double.doubleToLongBits(this.normBoundSq) == Double.doubleToLongBits(nTRUSigningKeyGenerationParameters.normBoundSq) && this.polyType == nTRUSigningKeyGenerationParameters.polyType && this.primeCheck == nTRUSigningKeyGenerationParameters.primeCheck && this.f6047q == nTRUSigningKeyGenerationParameters.f6047q && this.signFailTolerance == nTRUSigningKeyGenerationParameters.signFailTolerance && this.sparse == nTRUSigningKeyGenerationParameters.sparse;
            }
            return false;
        }
        return false;
    }

    public NTRUSigningParameters getSigningParameters() {
        return new NTRUSigningParameters(this.f6042N, this.f6047q, this.f6043d, this.f6041B, this.beta, this.normBound, this.hashAlg);
    }

    public int hashCode() {
        int i = ((((this.f6041B + 31) * 31) + this.f6042N) * 31) + this.basisType;
        long doubleToLongBits = Double.doubleToLongBits(this.beta);
        long doubleToLongBits2 = Double.doubleToLongBits(this.betaSq);
        int i2 = ((((((((((((((i * 31) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + this.bitsF) * 31) + this.f6043d) * 31) + this.f6044d1) * 31) + this.f6045d2) * 31) + this.f6046d3) * 31;
        Digest digest = this.hashAlg;
        int hashCode = ((i2 + (digest == null ? 0 : digest.getAlgorithmName().hashCode())) * 31) + this.keyGenAlg;
        long doubleToLongBits3 = Double.doubleToLongBits(this.keyNormBound);
        long doubleToLongBits4 = Double.doubleToLongBits(this.keyNormBoundSq);
        long doubleToLongBits5 = Double.doubleToLongBits(this.normBound);
        long doubleToLongBits6 = Double.doubleToLongBits(this.normBoundSq);
        return (((((((((((((((((hashCode * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + this.polyType) * 31) + (this.primeCheck ? 1231 : 1237)) * 31) + this.f6047q) * 31) + this.signFailTolerance) * 31) + (this.sparse ? 1231 : 1237);
    }

    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        StringBuilder m253r = outline.m253r("SignatureParameters(N=");
        m253r.append(this.f6042N);
        m253r.append(" q=");
        m253r.append(this.f6047q);
        StringBuilder sb = new StringBuilder(m253r.toString());
        if (this.polyType == 0) {
            StringBuilder m253r2 = outline.m253r(" polyType=SIMPLE d=");
            m253r2.append(this.f6043d);
            sb.append(m253r2.toString());
        } else {
            StringBuilder m253r3 = outline.m253r(" polyType=PRODUCT d1=");
            m253r3.append(this.f6044d1);
            m253r3.append(" d2=");
            m253r3.append(this.f6045d2);
            m253r3.append(" d3=");
            m253r3.append(this.f6046d3);
            sb.append(m253r3.toString());
        }
        StringBuilder m253r4 = outline.m253r(" B=");
        m253r4.append(this.f6041B);
        m253r4.append(" basisType=");
        m253r4.append(this.basisType);
        m253r4.append(" beta=");
        m253r4.append(decimalFormat.format(this.beta));
        m253r4.append(" normBound=");
        m253r4.append(decimalFormat.format(this.normBound));
        m253r4.append(" keyNormBound=");
        m253r4.append(decimalFormat.format(this.keyNormBound));
        m253r4.append(" prime=");
        m253r4.append(this.primeCheck);
        m253r4.append(" sparse=");
        m253r4.append(this.sparse);
        m253r4.append(" keyGenAlg=");
        m253r4.append(this.keyGenAlg);
        m253r4.append(" hashAlg=");
        m253r4.append(this.hashAlg);
        m253r4.append(")");
        sb.append(m253r4.toString());
        return sb.toString();
    }

    public void writeTo(OutputStream outputStream) {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(this.f6042N);
        dataOutputStream.writeInt(this.f6047q);
        dataOutputStream.writeInt(this.f6043d);
        dataOutputStream.writeInt(this.f6044d1);
        dataOutputStream.writeInt(this.f6045d2);
        dataOutputStream.writeInt(this.f6046d3);
        dataOutputStream.writeInt(this.f6041B);
        dataOutputStream.writeInt(this.basisType);
        dataOutputStream.writeDouble(this.beta);
        dataOutputStream.writeDouble(this.normBound);
        dataOutputStream.writeDouble(this.keyNormBound);
        dataOutputStream.writeInt(this.signFailTolerance);
        dataOutputStream.writeBoolean(this.primeCheck);
        dataOutputStream.writeBoolean(this.sparse);
        dataOutputStream.writeInt(this.bitsF);
        dataOutputStream.write(this.keyGenAlg);
        dataOutputStream.writeUTF(this.hashAlg.getAlgorithmName());
        dataOutputStream.write(this.polyType);
    }

    public NTRUSigningKeyGenerationParameters clone() {
        if (this.polyType == 0) {
            return new NTRUSigningKeyGenerationParameters(this.f6042N, this.f6047q, this.f6043d, this.f6041B, this.basisType, this.beta, this.normBound, this.keyNormBound, this.primeCheck, this.sparse, this.keyGenAlg, this.hashAlg);
        }
        return new NTRUSigningKeyGenerationParameters(this.f6042N, this.f6047q, this.f6044d1, this.f6045d2, this.f6046d3, this.f6041B, this.basisType, this.beta, this.normBound, this.keyNormBound, this.primeCheck, this.sparse, this.keyGenAlg, this.hashAlg);
    }

    public NTRUSigningKeyGenerationParameters(int i, int i2, int i3, int i4, int i5, int i6, int i7, double d, double d2, double d3, boolean z, boolean z2, int i8, Digest digest) {
        super(new SecureRandom(), i);
        this.signFailTolerance = 100;
        this.bitsF = 6;
        this.f6042N = i;
        this.f6047q = i2;
        this.f6044d1 = i3;
        this.f6045d2 = i4;
        this.f6046d3 = i5;
        this.f6041B = i6;
        this.basisType = i7;
        this.beta = d;
        this.normBound = d2;
        this.keyNormBound = d3;
        this.primeCheck = z;
        this.sparse = z2;
        this.keyGenAlg = i8;
        this.hashAlg = digest;
        this.polyType = 1;
        init();
    }

    public NTRUSigningKeyGenerationParameters(InputStream inputStream) {
        super(new SecureRandom(), 0);
        this.signFailTolerance = 100;
        this.bitsF = 6;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f6042N = dataInputStream.readInt();
        this.f6047q = dataInputStream.readInt();
        this.f6043d = dataInputStream.readInt();
        this.f6044d1 = dataInputStream.readInt();
        this.f6045d2 = dataInputStream.readInt();
        this.f6046d3 = dataInputStream.readInt();
        this.f6041B = dataInputStream.readInt();
        this.basisType = dataInputStream.readInt();
        this.beta = dataInputStream.readDouble();
        this.normBound = dataInputStream.readDouble();
        this.keyNormBound = dataInputStream.readDouble();
        this.signFailTolerance = dataInputStream.readInt();
        this.primeCheck = dataInputStream.readBoolean();
        this.sparse = dataInputStream.readBoolean();
        this.bitsF = dataInputStream.readInt();
        this.keyGenAlg = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        if ("SHA-512".equals(readUTF)) {
            this.hashAlg = new SHA512Digest();
        } else if ("SHA-256".equals(readUTF)) {
            this.hashAlg = new SHA256Digest();
        }
        this.polyType = dataInputStream.read();
        init();
    }
}
