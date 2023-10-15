package org.ksoap2.transport;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HttpsServiceConnectionSEIgnoringConnectionClose extends HttpsServiceConnectionSE {
    public HttpsServiceConnectionSEIgnoringConnectionClose(String str, int i, String str2, int i2) {
        super(str, i, str2, i2);
    }

    @Override // org.ksoap2.transport.HttpsServiceConnectionSE, org.ksoap2.transport.ServiceConnection
    public void setRequestProperty(String str, String str2) {
        if ("Connection".equalsIgnoreCase(str) && "close".equalsIgnoreCase(str2)) {
            return;
        }
        super.setRequestProperty(str, str2);
    }
}
