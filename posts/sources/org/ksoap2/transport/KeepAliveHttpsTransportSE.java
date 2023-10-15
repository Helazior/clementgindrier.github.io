package org.ksoap2.transport;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class KeepAliveHttpsTransportSE extends HttpsTransportSE {
    public KeepAliveHttpsTransportSE(String str, int i, String str2, int i2) {
        super(str, i, str2, i2);
    }

    @Override // org.ksoap2.transport.HttpsTransportSE, org.ksoap2.transport.HttpTransportSE, org.ksoap2.transport.Transport
    public ServiceConnection getServiceConnection() {
        HttpsServiceConnectionSEIgnoringConnectionClose httpsServiceConnectionSEIgnoringConnectionClose = new HttpsServiceConnectionSEIgnoringConnectionClose(this.host, this.port, this.file, this.timeout);
        httpsServiceConnectionSEIgnoringConnectionClose.setRequestProperty("Connection", "keep-alive");
        return httpsServiceConnectionSEIgnoringConnectionClose;
    }
}
