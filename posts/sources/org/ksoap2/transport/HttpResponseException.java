package org.ksoap2.transport;

import java.io.IOException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HttpResponseException extends IOException {
    private int statusCode;

    public HttpResponseException(int i) {
        this.statusCode = i;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpResponseException(String str, int i) {
        super(str);
        this.statusCode = i;
    }

    public HttpResponseException(String str, Throwable th, int i) {
        super(str, th);
        this.statusCode = i;
    }

    public HttpResponseException(Throwable th, int i) {
        super(th);
        this.statusCode = i;
    }
}
