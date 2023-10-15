package org.ksoap2.transport;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.ksoap2.HeaderProperty;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ServiceConnectionSE implements ServiceConnection {
    private HttpURLConnection connection;

    public ServiceConnectionSE(String str) {
        this(null, str, 20000);
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
        LinkedList linkedList = new LinkedList();
        Map<String, List<String>> headerFields = this.connection.getHeaderFields();
        if (headerFields != null) {
            for (String str : headerFields.keySet()) {
                List<String> list = headerFields.get(str);
                for (int i = 0; i < list.size(); i++) {
                    linkedList.add(new HeaderProperty(str, list.get(i)));
                }
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

    public ServiceConnectionSE(Proxy proxy, String str) {
        this(proxy, str, 20000);
    }

    public ServiceConnectionSE(String str, int i) {
        this(null, str, i);
    }

    public ServiceConnectionSE(Proxy proxy, String str, int i) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) (proxy == null ? new URL(str).openConnection() : new URL(str).openConnection(proxy));
        this.connection = httpURLConnection;
        httpURLConnection.setUseCaches(false);
        this.connection.setDoOutput(true);
        this.connection.setDoInput(true);
        this.connection.setConnectTimeout(i);
        this.connection.setReadTimeout(i);
    }
}
