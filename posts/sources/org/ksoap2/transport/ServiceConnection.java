package org.ksoap2.transport;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ServiceConnection {
    public static final int DEFAULT_BUFFER_SIZE = 262144;
    public static final int DEFAULT_TIMEOUT = 20000;

    void connect();

    void disconnect();

    InputStream getErrorStream();

    String getHost();

    String getPath();

    int getPort();

    int getResponseCode();

    List getResponseProperties();

    InputStream openInputStream();

    OutputStream openOutputStream();

    void setFixedLengthStreamingMode(int i);

    void setRequestMethod(String str);

    void setRequestProperty(String str, String str2);
}
