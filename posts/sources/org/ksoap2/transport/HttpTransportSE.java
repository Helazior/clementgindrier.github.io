package org.ksoap2.transport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.util.List;
import java.util.zip.GZIPInputStream;
import org.ksoap2.SoapEnvelope;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HttpTransportSE extends Transport {
    public HttpTransportSE(String str) {
        super((Proxy) null, str);
    }

    private InputStream getUnZippedInputStream(InputStream inputStream) {
        try {
            return (GZIPInputStream) inputStream;
        } catch (ClassCastException unused) {
            return new GZIPInputStream(inputStream);
        }
    }

    private InputStream readDebug(InputStream inputStream, int i, File file) {
        OutputStream byteArrayOutputStream;
        if (file != null) {
            byteArrayOutputStream = new FileOutputStream(file);
        } else {
            if (i <= 0) {
                i = 262144;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i);
        }
        byte[] bArr = new byte[256];
        while (true) {
            int read = inputStream.read(bArr, 0, 256);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
        byteArrayOutputStream.flush();
        if (byteArrayOutputStream instanceof ByteArrayOutputStream) {
            bArr = ((ByteArrayOutputStream) byteArrayOutputStream).toByteArray();
        }
        this.responseDump = new String(bArr);
        inputStream.close();
        if (file != null) {
            return new FileInputStream(file);
        }
        return new ByteArrayInputStream(bArr);
    }

    @Override // org.ksoap2.transport.Transport
    public void call(String str, SoapEnvelope soapEnvelope) {
        call(str, soapEnvelope, null);
    }

    @Override // org.ksoap2.transport.Transport
    public ServiceConnection getServiceConnection() {
        return new ServiceConnectionSE(this.proxy, this.url, this.timeout);
    }

    public HttpTransportSE(Proxy proxy, String str) {
        super(proxy, str);
    }

    @Override // org.ksoap2.transport.Transport
    public List call(String str, SoapEnvelope soapEnvelope, List list) {
        return call(str, soapEnvelope, list, null);
    }

    public HttpTransportSE(String str, int i) {
        super(str, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x017c  */
    @Override // org.ksoap2.transport.Transport
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List call(java.lang.String r17, org.ksoap2.SoapEnvelope r18, java.util.List r19, java.io.File r20) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.ksoap2.transport.HttpTransportSE.call(java.lang.String, org.ksoap2.SoapEnvelope, java.util.List, java.io.File):java.util.List");
    }

    public HttpTransportSE(Proxy proxy, String str, int i) {
        super(proxy, str, i);
    }

    public HttpTransportSE(String str, int i, int i2) {
        super(str, i);
    }

    public HttpTransportSE(Proxy proxy, String str, int i, int i2) {
        super(proxy, str, i);
    }
}
