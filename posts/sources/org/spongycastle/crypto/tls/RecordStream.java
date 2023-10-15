package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.crypto.Digest;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RecordStream {
    private TlsProtocolHandler handler;

    /* renamed from: is */
    private InputStream f6069is;

    /* renamed from: os */
    private OutputStream f6070os;
    private TlsCipher readCipher;
    private TlsCompression readCompression;
    private TlsCipher writeCipher;
    private TlsCompression writeCompression;
    private ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    private TlsClientContext context = null;
    private CombinedHash hash = null;

    public RecordStream(TlsProtocolHandler tlsProtocolHandler, InputStream inputStream, OutputStream outputStream) {
        this.readCompression = null;
        this.writeCompression = null;
        this.readCipher = null;
        this.writeCipher = null;
        this.handler = tlsProtocolHandler;
        this.f6069is = inputStream;
        this.f6070os = outputStream;
        TlsNullCompression tlsNullCompression = new TlsNullCompression();
        this.readCompression = tlsNullCompression;
        this.writeCompression = tlsNullCompression;
        TlsNullCipher tlsNullCipher = new TlsNullCipher();
        this.readCipher = tlsNullCipher;
        this.writeCipher = tlsNullCipher;
    }

    private static byte[] doFinal(Digest digest) {
        byte[] bArr = new byte[digest.getDigestSize()];
        digest.doFinal(bArr, 0);
        return bArr;
    }

    private byte[] getBufferContents() {
        byte[] byteArray = this.buffer.toByteArray();
        this.buffer.reset();
        return byteArray;
    }

    public void clientCipherSpecDecided(TlsCompression tlsCompression, TlsCipher tlsCipher) {
        this.writeCompression = tlsCompression;
        this.writeCipher = tlsCipher;
    }

    public void close() {
        try {
            this.f6069is.close();
            e = null;
        } catch (IOException e) {
            e = e;
        }
        try {
            this.f6070os.close();
        } catch (IOException e2) {
            e = e2;
        }
        if (e != null) {
            throw e;
        }
    }

    public byte[] decodeAndVerify(short s, InputStream inputStream, int i) {
        byte[] bArr = new byte[i];
        TlsUtils.readFully(bArr, inputStream);
        byte[] decodeCiphertext = this.readCipher.decodeCiphertext(s, bArr, 0, i);
        OutputStream decompress = this.readCompression.decompress(this.buffer);
        if (decompress == this.buffer) {
            return decodeCiphertext;
        }
        decompress.write(decodeCiphertext, 0, decodeCiphertext.length);
        decompress.flush();
        return getBufferContents();
    }

    public void flush() {
        this.f6070os.flush();
    }

    public byte[] getCurrentHash(byte[] bArr) {
        CombinedHash combinedHash = new CombinedHash(this.hash);
        if (!(this.context.getServerVersion().getFullVersion() >= ProtocolVersion.TLSv10.getFullVersion()) && bArr != null) {
            combinedHash.update(bArr, 0, bArr.length);
        }
        return doFinal(combinedHash);
    }

    public void init(TlsClientContext tlsClientContext) {
        this.context = tlsClientContext;
        this.hash = new CombinedHash(tlsClientContext);
    }

    public void readData() {
        short readUint8 = TlsUtils.readUint8(this.f6069is);
        if (ProtocolVersion.TLSv10.equals(TlsUtils.readVersion(this.f6069is))) {
            byte[] decodeAndVerify = decodeAndVerify(readUint8, this.f6069is, TlsUtils.readUint16(this.f6069is));
            this.handler.processData(readUint8, decodeAndVerify, 0, decodeAndVerify.length);
            return;
        }
        throw new TlsFatalAlert((short) 47);
    }

    public void serverClientSpecReceived() {
        this.readCompression = this.writeCompression;
        this.readCipher = this.writeCipher;
    }

    public void updateHandshakeData(byte[] bArr, int i, int i2) {
        this.hash.update(bArr, i, i2);
    }

    public void writeMessage(short s, byte[] bArr, int i, int i2) {
        byte[] encodePlaintext;
        if (s == 22) {
            updateHandshakeData(bArr, i, i2);
        }
        OutputStream compress = this.writeCompression.compress(this.buffer);
        if (compress == this.buffer) {
            encodePlaintext = this.writeCipher.encodePlaintext(s, bArr, i, i2);
        } else {
            compress.write(bArr, i, i2);
            compress.flush();
            byte[] bufferContents = getBufferContents();
            encodePlaintext = this.writeCipher.encodePlaintext(s, bufferContents, 0, bufferContents.length);
        }
        byte[] bArr2 = new byte[encodePlaintext.length + 5];
        TlsUtils.writeUint8(s, bArr2, 0);
        TlsUtils.writeVersion(ProtocolVersion.TLSv10, bArr2, 1);
        TlsUtils.writeUint16(encodePlaintext.length, bArr2, 3);
        System.arraycopy(encodePlaintext, 0, bArr2, 5, encodePlaintext.length);
        this.f6070os.write(bArr2);
        this.f6070os.flush();
    }
}
