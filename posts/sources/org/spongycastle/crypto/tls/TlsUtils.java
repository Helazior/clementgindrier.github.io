package org.spongycastle.crypto.tls;

import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.asn1.x509.KeyUsage;
import org.spongycastle.asn1.x509.X509CertificateStructure;
import org.spongycastle.asn1.x509.X509Extension;
import org.spongycastle.asn1.x509.X509Extensions;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.digests.MD5Digest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;
import org.spongycastle.util.p018io.Streams;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsUtils {
    public static final byte[] SSL_CLIENT = {67, 76, 78, 84};
    public static final byte[] SSL_SERVER = {83, 82, 86, 82};
    public static final byte[][] SSL3_CONST = genConst();

    public static byte[] PRF(byte[] bArr, String str, byte[] bArr2, int i) {
        byte[] byteArray = Strings.toByteArray(str);
        int length = (bArr.length + 1) / 2;
        byte[] bArr3 = new byte[length];
        byte[] bArr4 = new byte[length];
        System.arraycopy(bArr, 0, bArr3, 0, length);
        System.arraycopy(bArr, bArr.length - length, bArr4, 0, length);
        byte[] concat = concat(byteArray, bArr2);
        byte[] bArr5 = new byte[i];
        byte[] bArr6 = new byte[i];
        hmac_hash(new MD5Digest(), bArr3, concat, bArr6);
        hmac_hash(new SHA1Digest(), bArr4, concat, bArr5);
        for (int i2 = 0; i2 < i; i2++) {
            bArr5[i2] = (byte) (bArr5[i2] ^ bArr6[i2]);
        }
        return bArr5;
    }

    public static byte[] PRF_1_2(Digest digest, byte[] bArr, String str, byte[] bArr2, int i) {
        byte[] concat = concat(Strings.toByteArray(str), bArr2);
        byte[] bArr3 = new byte[i];
        hmac_hash(digest, bArr, concat, bArr3);
        return bArr3;
    }

    public static byte[] calculateKeyBlock(TlsClientContext tlsClientContext, int i) {
        ProtocolVersion serverVersion = tlsClientContext.getServerVersion();
        SecurityParameters securityParameters = tlsClientContext.getSecurityParameters();
        byte[] concat = concat(securityParameters.serverRandom, securityParameters.clientRandom);
        if (serverVersion.getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion()) {
            return PRF(securityParameters.masterSecret, "key expansion", concat, i);
        }
        MD5Digest mD5Digest = new MD5Digest();
        SHA1Digest sHA1Digest = new SHA1Digest();
        int digestSize = mD5Digest.getDigestSize();
        int digestSize2 = sHA1Digest.getDigestSize();
        byte[] bArr = new byte[digestSize2];
        byte[] bArr2 = new byte[i + digestSize];
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            byte[] bArr3 = SSL3_CONST[i3];
            sHA1Digest.update(bArr3, 0, bArr3.length);
            byte[] bArr4 = securityParameters.masterSecret;
            sHA1Digest.update(bArr4, 0, bArr4.length);
            sHA1Digest.update(concat, 0, concat.length);
            sHA1Digest.doFinal(bArr, 0);
            byte[] bArr5 = securityParameters.masterSecret;
            mD5Digest.update(bArr5, 0, bArr5.length);
            mD5Digest.update(bArr, 0, digestSize2);
            mD5Digest.doFinal(bArr2, i2);
            i2 += digestSize;
            i3++;
        }
        byte[] bArr6 = new byte[i];
        System.arraycopy(bArr2, 0, bArr6, 0, i);
        return bArr6;
    }

    public static byte[] calculateMasterSecret(TlsClientContext tlsClientContext, byte[] bArr) {
        ProtocolVersion serverVersion = tlsClientContext.getServerVersion();
        SecurityParameters securityParameters = tlsClientContext.getSecurityParameters();
        byte[] concat = concat(securityParameters.clientRandom, securityParameters.serverRandom);
        if (serverVersion.getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion()) {
            return PRF(bArr, "master secret", concat, 48);
        }
        MD5Digest mD5Digest = new MD5Digest();
        SHA1Digest sHA1Digest = new SHA1Digest();
        int digestSize = mD5Digest.getDigestSize();
        int digestSize2 = sHA1Digest.getDigestSize();
        byte[] bArr2 = new byte[digestSize2];
        byte[] bArr3 = new byte[digestSize * 3];
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            byte[] bArr4 = SSL3_CONST[i2];
            sHA1Digest.update(bArr4, 0, bArr4.length);
            sHA1Digest.update(bArr, 0, bArr.length);
            sHA1Digest.update(concat, 0, concat.length);
            sHA1Digest.doFinal(bArr2, 0);
            mD5Digest.update(bArr, 0, bArr.length);
            mD5Digest.update(bArr2, 0, digestSize2);
            mD5Digest.doFinal(bArr3, i);
            i += digestSize;
        }
        return bArr3;
    }

    public static byte[] calculateVerifyData(TlsClientContext tlsClientContext, String str, byte[] bArr) {
        return tlsClientContext.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion() ? PRF(tlsClientContext.getSecurityParameters().masterSecret, str, bArr, 12) : bArr;
    }

    public static byte[] concat(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static byte[][] genConst() {
        byte[][] bArr = new byte[10];
        int i = 0;
        while (i < 10) {
            int i2 = i + 1;
            byte[] bArr2 = new byte[i2];
            Arrays.fill(bArr2, (byte) (i + 65));
            bArr[i] = bArr2;
            i = i2;
        }
        return bArr;
    }

    private static void hmac_hash(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        HMac hMac = new HMac(digest);
        KeyParameter keyParameter = new KeyParameter(bArr);
        int digestSize = digest.getDigestSize();
        int length = ((bArr3.length + digestSize) - 1) / digestSize;
        int macSize = hMac.getMacSize();
        byte[] bArr4 = new byte[macSize];
        byte[] bArr5 = new byte[hMac.getMacSize()];
        byte[] bArr6 = bArr2;
        int i = 0;
        while (i < length) {
            hMac.init(keyParameter);
            hMac.update(bArr6, 0, bArr6.length);
            hMac.doFinal(bArr4, 0);
            hMac.init(keyParameter);
            hMac.update(bArr4, 0, macSize);
            hMac.update(bArr2, 0, bArr2.length);
            hMac.doFinal(bArr5, 0);
            int i2 = digestSize * i;
            System.arraycopy(bArr5, 0, bArr3, i2, Math.min(digestSize, bArr3.length - i2));
            i++;
            bArr6 = bArr4;
        }
    }

    public static void readFully(byte[] bArr, InputStream inputStream) {
        if (Streams.readFully(inputStream, bArr) != bArr.length) {
            throw new EOFException();
        }
    }

    public static byte[] readOpaque16(InputStream inputStream) {
        byte[] bArr = new byte[readUint16(inputStream)];
        readFully(bArr, inputStream);
        return bArr;
    }

    public static byte[] readOpaque8(InputStream inputStream) {
        byte[] bArr = new byte[readUint8(inputStream)];
        readFully(bArr, inputStream);
        return bArr;
    }

    public static int readUint16(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        if ((read | read2) >= 0) {
            return read2 | (read << 8);
        }
        throw new EOFException();
    }

    public static int readUint24(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        if ((read | read2 | read3) >= 0) {
            return read3 | (read << 16) | (read2 << 8);
        }
        throw new EOFException();
    }

    public static long readUint32(InputStream inputStream) {
        int read = inputStream.read();
        int read2 = inputStream.read();
        int read3 = inputStream.read();
        int read4 = inputStream.read();
        if ((read | read2 | read3 | read4) >= 0) {
            return (read2 << 16) | (read << 24) | (read3 << 8) | read4;
        }
        throw new EOFException();
    }

    public static short readUint8(InputStream inputStream) {
        int read = inputStream.read();
        if (read != -1) {
            return (short) read;
        }
        throw new EOFException();
    }

    public static ProtocolVersion readVersion(byte[] bArr) {
        return ProtocolVersion.get(bArr[0], bArr[1]);
    }

    public static void validateKeyUsage(X509CertificateStructure x509CertificateStructure, int i) {
        X509Extension extension;
        X509Extensions extensions = x509CertificateStructure.getTBSCertificate().getExtensions();
        if (extensions != null && (extension = extensions.getExtension(X509Extension.keyUsage)) != null && (KeyUsage.getInstance(extension).getBytes()[0] & 255 & i) != i) {
            throw new TlsFatalAlert((short) 46);
        }
    }

    public static void writeGMTUnixTime(byte[] bArr, int i) {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        bArr[i] = (byte) (currentTimeMillis >> 24);
        bArr[i + 1] = (byte) (currentTimeMillis >> 16);
        bArr[i + 2] = (byte) (currentTimeMillis >> 8);
        bArr[i + 3] = (byte) currentTimeMillis;
    }

    public static void writeOpaque16(byte[] bArr, OutputStream outputStream) {
        writeUint16(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void writeOpaque24(byte[] bArr, OutputStream outputStream) {
        writeUint24(bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void writeOpaque8(byte[] bArr, OutputStream outputStream) {
        writeUint8((short) bArr.length, outputStream);
        outputStream.write(bArr);
    }

    public static void writeUint16(int i, OutputStream outputStream) {
        outputStream.write(i >> 8);
        outputStream.write(i);
    }

    public static void writeUint16Array(int[] iArr, OutputStream outputStream) {
        for (int i : iArr) {
            writeUint16(i, outputStream);
        }
    }

    public static void writeUint24(int i, OutputStream outputStream) {
        outputStream.write(i >> 16);
        outputStream.write(i >> 8);
        outputStream.write(i);
    }

    public static void writeUint32(long j, OutputStream outputStream) {
        outputStream.write((int) (j >> 24));
        outputStream.write((int) (j >> 16));
        outputStream.write((int) (j >> 8));
        outputStream.write((int) j);
    }

    public static void writeUint64(long j, OutputStream outputStream) {
        outputStream.write((int) (j >> 56));
        outputStream.write((int) (j >> 48));
        outputStream.write((int) (j >> 40));
        outputStream.write((int) (j >> 32));
        outputStream.write((int) (j >> 24));
        outputStream.write((int) (j >> 16));
        outputStream.write((int) (j >> 8));
        outputStream.write((int) j);
    }

    public static void writeUint8(short s, OutputStream outputStream) {
        outputStream.write(s);
    }

    public static void writeUint8Array(short[] sArr, OutputStream outputStream) {
        for (short s : sArr) {
            writeUint8(s, outputStream);
        }
    }

    public static void writeVersion(ProtocolVersion protocolVersion, OutputStream outputStream) {
        outputStream.write(protocolVersion.getMajorVersion());
        outputStream.write(protocolVersion.getMinorVersion());
    }

    public static ProtocolVersion readVersion(InputStream inputStream) {
        return ProtocolVersion.get(inputStream.read(), inputStream.read());
    }

    public static void writeUint8(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
    }

    public static void writeUint16(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 8);
        bArr[i2 + 1] = (byte) i;
    }

    public static void writeVersion(ProtocolVersion protocolVersion, byte[] bArr, int i) {
        bArr[i] = (byte) protocolVersion.getMajorVersion();
        bArr[i + 1] = (byte) protocolVersion.getMinorVersion();
    }

    public static void writeUint24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >> 16);
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) i;
    }

    public static void writeUint32(long j, byte[] bArr, int i) {
        bArr[i] = (byte) (j >> 24);
        bArr[i + 1] = (byte) (j >> 16);
        bArr[i + 2] = (byte) (j >> 8);
        bArr[i + 3] = (byte) j;
    }

    public static void writeUint64(long j, byte[] bArr, int i) {
        bArr[i] = (byte) (j >> 56);
        bArr[i + 1] = (byte) (j >> 48);
        bArr[i + 2] = (byte) (j >> 40);
        bArr[i + 3] = (byte) (j >> 32);
        bArr[i + 4] = (byte) (j >> 24);
        bArr[i + 5] = (byte) (j >> 16);
        bArr[i + 6] = (byte) (j >> 8);
        bArr[i + 7] = (byte) j;
    }
}
