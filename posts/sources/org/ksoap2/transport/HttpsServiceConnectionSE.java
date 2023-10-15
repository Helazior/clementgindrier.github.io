package org.ksoap2.transport;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Proxy;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.ksoap2.HeaderProperty;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HttpsServiceConnectionSE implements ServiceConnection {
    private HttpsURLConnection connection;

    public HttpsServiceConnectionSE(String str, int i, String str2, int i2) {
        this(null, str, i, str2, i2);
    }

    private void updateConnectionParameters(int i) {
        this.connection.setConnectTimeout(i);
        this.connection.setReadTimeout(i);
        this.connection.setUseCaches(false);
        this.connection.setDoOutput(true);
        this.connection.setDoInput(true);
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public void connect() {
        this.connection.connect();
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public void disconnect() {
        this.connection.disconnect();
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public InputStream getErrorStream() {
        return this.connection.getErrorStream();
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public String getHost() {
        return this.connection.getURL().getHost();
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public String getPath() {
        return this.connection.getURL().getPath();
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public int getPort() {
        return this.connection.getURL().getPort();
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public int getResponseCode() {
        return this.connection.getResponseCode();
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public List getResponseProperties() {
        Map headerFields = this.connection.getHeaderFields();
        Set<String> keySet = headerFields.keySet();
        LinkedList linkedList = new LinkedList();
        for (String str : keySet) {
            List list = (List) headerFields.get(str);
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(new HeaderProperty(str, (String) list.get(i)));
            }
        }
        return linkedList;
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public InputStream openInputStream() {
        return this.connection.getInputStream();
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public OutputStream openOutputStream() {
        return this.connection.getOutputStream();
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public void setFixedLengthStreamingMode(int i) {
        this.connection.setFixedLengthStreamingMode(i);
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public void setRequestMethod(String str) {
        this.connection.setRequestMethod(str);
    }

    @Override // org.ksoap2.transport.ServiceConnection
    public void setRequestProperty(String str, String str2) {
        this.connection.setRequestProperty(str, str2);
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.connection.setSSLSocketFactory(sSLSocketFactory);
    }

    public HttpsServiceConnectionSE(Proxy proxy, String str, int i, String str2, int i2) {
        if (proxy == null) {
            this.connection = (HttpsURLConnection) new URL(HttpsTransportSE.PROTOCOL, str, i, str2).openConnection();
        } else {
            this.connection = (HttpsURLConnection) new URL(HttpsTransportSE.PROTOCOL, str, i, str2).openConnection(proxy);
        }
        this.connection = (HttpsURLConnection) new URL(HttpsTransportSE.PROTOCOL, str, i, str2).openConnection();
        updateConnectionParameters(i2);
    }
}
