package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import org.spongycastle.crypto.prng.ThreadedSeedGenerator;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TlsProtocolHandler {
    private static final short CS_CERTIFICATE_REQUEST_RECEIVED = 5;
    private static final short CS_CERTIFICATE_VERIFY_SEND = 8;
    private static final short CS_CLIENT_CHANGE_CIPHER_SPEC_SEND = 9;
    private static final short CS_CLIENT_FINISHED_SEND = 10;
    private static final short CS_CLIENT_HELLO_SEND = 1;
    private static final short CS_CLIENT_KEY_EXCHANGE_SEND = 7;
    private static final short CS_DONE = 12;
    private static final short CS_SERVER_CERTIFICATE_RECEIVED = 3;
    private static final short CS_SERVER_CHANGE_CIPHER_SPEC_RECEIVED = 11;
    private static final short CS_SERVER_HELLO_DONE_RECEIVED = 6;
    private static final short CS_SERVER_HELLO_RECEIVED = 2;
    private static final short CS_SERVER_KEY_EXCHANGE_RECEIVED = 4;
    private static final String TLS_ERROR_MESSAGE = "Internal TLS error, this could be an attack";
    private ByteQueue alertQueue;
    private boolean appDataReady;
    private ByteQueue applicationDataQueue;
    private TlsAuthentication authentication;
    private CertificateRequest certificateRequest;
    private ByteQueue changeCipherSpecQueue;
    private Hashtable clientExtensions;
    private boolean closed;
    private short connection_state;
    private boolean failedWithError;
    private ByteQueue handshakeQueue;
    private TlsKeyExchange keyExchange;
    private int[] offeredCipherSuites;
    private short[] offeredCompressionMethods;
    private SecureRandom random;

    /* renamed from: rs */
    private RecordStream f6071rs;
    private SecurityParameters securityParameters;
    private TlsClient tlsClient;
    private TlsClientContextImpl tlsClientContext;
    private TlsInputStream tlsInputStream;
    private TlsOutputStream tlsOutputStream;
    private static final Integer EXT_RenegotiationInfo = new Integer(65281);
    private static final byte[] emptybuf = new byte[0];

    public TlsProtocolHandler(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, createSecureRandom());
    }

    private static boolean arrayContains(short[] sArr, short s) {
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    private static byte[] createRenegotiationInfo(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeOpaque8(bArr, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    private static SecureRandom createSecureRandom() {
        ThreadedSeedGenerator threadedSeedGenerator = new ThreadedSeedGenerator();
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.setSeed(threadedSeedGenerator.generateSeed(20, true));
        return secureRandom;
    }

    private void failWithError(short s, short s2) {
        if (!this.closed) {
            this.closed = true;
            if (s == 2) {
                this.failedWithError = true;
            }
            sendAlert(s, s2);
            this.f6071rs.close();
            if (s == 2) {
                throw new IOException(TLS_ERROR_MESSAGE);
            }
            return;
        }
        throw new IOException(TLS_ERROR_MESSAGE);
    }

    private void processAlert() {
        while (this.alertQueue.size() >= 2) {
            byte[] bArr = new byte[2];
            this.alertQueue.read(bArr, 0, 2, 0);
            this.alertQueue.removeData(2);
            short s = bArr[0];
            short s2 = bArr[1];
            if (s == 2) {
                this.failedWithError = true;
                this.closed = true;
                try {
                    this.f6071rs.close();
                } catch (Exception unused) {
                }
                throw new IOException(TLS_ERROR_MESSAGE);
            } else if (s2 == 0) {
                failWithError((short) 1, (short) 0);
            }
        }
    }

    private void processApplicationData() {
    }

    private void processChangeCipherSpec() {
        while (this.changeCipherSpecQueue.size() > 0) {
            byte[] bArr = new byte[1];
            this.changeCipherSpecQueue.read(bArr, 0, 1, 0);
            this.changeCipherSpecQueue.removeData(1);
            if (bArr[0] != 1) {
                failWithError((short) 2, (short) 10);
            }
            if (this.connection_state != 10) {
                failWithError((short) 2, (short) 40);
            }
            this.f6071rs.serverClientSpecReceived();
            this.connection_state = (short) 11;
        }
    }

    private void processHandshake() {
        boolean z;
        do {
            z = false;
            if (this.handshakeQueue.size() >= 4) {
                byte[] bArr = new byte[4];
                this.handshakeQueue.read(bArr, 0, 4, 0);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                int readUint24 = TlsUtils.readUint24(byteArrayInputStream);
                int i = readUint24 + 4;
                if (this.handshakeQueue.size() >= i) {
                    byte[] bArr2 = new byte[readUint24];
                    this.handshakeQueue.read(bArr2, 0, readUint24, 4);
                    this.handshakeQueue.removeData(i);
                    if (readUint8 != 0 && readUint8 != 20) {
                        this.f6071rs.updateHandshakeData(bArr, 0, 4);
                        this.f6071rs.updateHandshakeData(bArr2, 0, readUint24);
                    }
                    processHandshakeMessage(readUint8, bArr2);
                    z = true;
                    continue;
                } else {
                    continue;
                }
            }
        } while (z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void processHandshakeMessage(short r11, byte[] r12) {
        /*
            Method dump skipped, instructions count: 762
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsProtocolHandler.processHandshakeMessage(short, byte[]):void");
    }

    private void safeReadData() {
        try {
            this.f6071rs.readData();
        } catch (IOException e) {
            if (!this.closed) {
                failWithError((short) 2, (short) 80);
            }
            throw e;
        } catch (RuntimeException e2) {
            if (!this.closed) {
                failWithError((short) 2, (short) 80);
            }
            throw e2;
        } catch (TlsFatalAlert e3) {
            if (!this.closed) {
                failWithError((short) 2, e3.getAlertDescription());
            }
            throw e3;
        }
    }

    private void safeWriteMessage(short s, byte[] bArr, int i, int i2) {
        try {
            this.f6071rs.writeMessage(s, bArr, i, i2);
        } catch (IOException e) {
            if (!this.closed) {
                failWithError((short) 2, (short) 80);
            }
            throw e;
        } catch (RuntimeException e2) {
            if (!this.closed) {
                failWithError((short) 2, (short) 80);
            }
            throw e2;
        } catch (TlsFatalAlert e3) {
            if (!this.closed) {
                failWithError((short) 2, e3.getAlertDescription());
            }
            throw e3;
        }
    }

    private void sendAlert(short s, short s2) {
        this.f6071rs.writeMessage((short) 21, new byte[]{(byte) s, (byte) s2}, 0, 2);
    }

    private void sendCertificateVerify(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeUint8((short) 15, byteArrayOutputStream);
        TlsUtils.writeUint24(bArr.length + 2, byteArrayOutputStream);
        TlsUtils.writeOpaque16(bArr, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this.f6071rs.writeMessage((short) 22, byteArray, 0, byteArray.length);
    }

    private void sendClientCertificate(Certificate certificate) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeUint8((short) 11, byteArrayOutputStream);
        TlsUtils.writeUint24(0, byteArrayOutputStream);
        certificate.encode(byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        TlsUtils.writeUint24(byteArray.length - 4, byteArray, 1);
        this.f6071rs.writeMessage((short) 22, byteArray, 0, byteArray.length);
    }

    private void sendClientKeyExchange() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        TlsUtils.writeUint8((short) 16, byteArrayOutputStream);
        TlsUtils.writeUint24(0, byteArrayOutputStream);
        this.keyExchange.generateClientKeyExchange(byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        TlsUtils.writeUint24(byteArray.length - 4, byteArray, 1);
        this.f6071rs.writeMessage((short) 22, byteArray, 0, byteArray.length);
    }

    private static void writeExtension(OutputStream outputStream, Integer num, byte[] bArr) {
        TlsUtils.writeUint16(num.intValue(), outputStream);
        TlsUtils.writeOpaque16(bArr, outputStream);
    }

    public void assertEmpty(ByteArrayInputStream byteArrayInputStream) {
        if (byteArrayInputStream.available() > 0) {
            throw new TlsFatalAlert((short) 50);
        }
    }

    public void close() {
        if (this.closed) {
            return;
        }
        failWithError((short) 1, (short) 0);
    }

    public void connect(CertificateVerifyer certificateVerifyer) {
        connect(new LegacyTlsClient(certificateVerifyer));
    }

    public void flush() {
        this.f6071rs.flush();
    }

    public InputStream getInputStream() {
        return this.tlsInputStream;
    }

    public OutputStream getOutputStream() {
        return this.tlsOutputStream;
    }

    public void processData(short s, byte[] bArr, int i, int i2) {
        switch (s) {
            case 20:
                this.changeCipherSpecQueue.addData(bArr, i, i2);
                processChangeCipherSpec();
                return;
            case 21:
                this.alertQueue.addData(bArr, i, i2);
                processAlert();
                return;
            case 22:
                this.handshakeQueue.addData(bArr, i, i2);
                processHandshake();
                return;
            case 23:
                if (!this.appDataReady) {
                    failWithError((short) 2, (short) 10);
                }
                this.applicationDataQueue.addData(bArr, i, i2);
                processApplicationData();
                return;
            default:
                return;
        }
    }

    public int readApplicationData(byte[] bArr, int i, int i2) {
        while (this.applicationDataQueue.size() == 0) {
            if (this.closed) {
                if (this.failedWithError) {
                    throw new IOException(TLS_ERROR_MESSAGE);
                }
                return -1;
            }
            safeReadData();
        }
        int min = Math.min(i2, this.applicationDataQueue.size());
        this.applicationDataQueue.read(bArr, i, min, 0);
        this.applicationDataQueue.removeData(min);
        return min;
    }

    public void writeData(byte[] bArr, int i, int i2) {
        if (this.closed) {
            if (this.failedWithError) {
                throw new IOException(TLS_ERROR_MESSAGE);
            }
            throw new IOException("Sorry, connection has been closed, you cannot write more data");
        }
        safeWriteMessage((short) 23, emptybuf, 0, 0);
        do {
            int min = Math.min(i2, 16384);
            safeWriteMessage((short) 23, bArr, i, min);
            i += min;
            i2 -= min;
        } while (i2 > 0);
    }

    public TlsProtocolHandler(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        this.applicationDataQueue = new ByteQueue();
        this.changeCipherSpecQueue = new ByteQueue();
        this.alertQueue = new ByteQueue();
        this.handshakeQueue = new ByteQueue();
        this.tlsInputStream = null;
        this.tlsOutputStream = null;
        this.closed = false;
        this.failedWithError = false;
        this.appDataReady = false;
        this.securityParameters = null;
        this.tlsClientContext = null;
        this.tlsClient = null;
        this.offeredCipherSuites = null;
        this.offeredCompressionMethods = null;
        this.keyExchange = null;
        this.authentication = null;
        this.certificateRequest = null;
        this.connection_state = (short) 0;
        this.f6071rs = new RecordStream(this, inputStream, outputStream);
        this.random = secureRandom;
    }

    public void connect(TlsClient tlsClient) {
        if (tlsClient != null) {
            if (this.tlsClient == null) {
                SecurityParameters securityParameters = new SecurityParameters();
                this.securityParameters = securityParameters;
                byte[] bArr = new byte[32];
                securityParameters.clientRandom = bArr;
                this.random.nextBytes(bArr);
                TlsUtils.writeGMTUnixTime(this.securityParameters.clientRandom, 0);
                TlsClientContextImpl tlsClientContextImpl = new TlsClientContextImpl(this.random, this.securityParameters);
                this.tlsClientContext = tlsClientContextImpl;
                this.f6071rs.init(tlsClientContextImpl);
                this.tlsClient = tlsClient;
                tlsClient.init(this.tlsClientContext);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ProtocolVersion clientVersion = this.tlsClient.getClientVersion();
                this.tlsClientContext.setClientVersion(clientVersion);
                this.tlsClientContext.setServerVersion(clientVersion);
                TlsUtils.writeVersion(clientVersion, byteArrayOutputStream);
                byteArrayOutputStream.write(this.securityParameters.clientRandom);
                TlsUtils.writeUint8((short) 0, byteArrayOutputStream);
                this.offeredCipherSuites = this.tlsClient.getCipherSuites();
                Hashtable clientExtensions = this.tlsClient.getClientExtensions();
                this.clientExtensions = clientExtensions;
                boolean z = clientExtensions == null || clientExtensions.get(EXT_RenegotiationInfo) == null;
                int length = this.offeredCipherSuites.length;
                if (z) {
                    length++;
                }
                TlsUtils.writeUint16(length * 2, byteArrayOutputStream);
                TlsUtils.writeUint16Array(this.offeredCipherSuites, byteArrayOutputStream);
                if (z) {
                    TlsUtils.writeUint16(255, byteArrayOutputStream);
                }
                short[] compressionMethods = this.tlsClient.getCompressionMethods();
                this.offeredCompressionMethods = compressionMethods;
                TlsUtils.writeUint8((short) compressionMethods.length, byteArrayOutputStream);
                TlsUtils.writeUint8Array(this.offeredCompressionMethods, byteArrayOutputStream);
                if (this.clientExtensions != null) {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    Enumeration keys = this.clientExtensions.keys();
                    while (keys.hasMoreElements()) {
                        Integer num = (Integer) keys.nextElement();
                        writeExtension(byteArrayOutputStream2, num, (byte[]) this.clientExtensions.get(num));
                    }
                    TlsUtils.writeOpaque16(byteArrayOutputStream2.toByteArray(), byteArrayOutputStream);
                }
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                TlsUtils.writeUint8((short) 1, byteArrayOutputStream3);
                TlsUtils.writeUint24(byteArrayOutputStream.size(), byteArrayOutputStream3);
                byteArrayOutputStream3.write(byteArrayOutputStream.toByteArray());
                byte[] byteArray = byteArrayOutputStream3.toByteArray();
                safeWriteMessage((short) 22, byteArray, 0, byteArray.length);
                this.connection_state = (short) 1;
                while (this.connection_state != 12) {
                    safeReadData();
                }
                this.tlsInputStream = new TlsInputStream(this);
                this.tlsOutputStream = new TlsOutputStream(this);
                return;
            }
            throw new IllegalStateException("connect can only be called once");
        }
        throw new IllegalArgumentException("'tlsClient' cannot be null");
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
