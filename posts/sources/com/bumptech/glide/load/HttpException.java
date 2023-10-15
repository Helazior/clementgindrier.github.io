package com.bumptech.glide.load;

import java.io.IOException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class HttpException extends IOException {
    public static final int UNKNOWN = -1;
    private static final long serialVersionUID = 1;
    private final int statusCode;

    public HttpException(int i) {
        this(outline.m273H("Http request failed with status code: ", i), i);
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public HttpException(String str) {
        this(str, -1);
    }

    public HttpException(String str, int i) {
        this(str, i, null);
    }

    public HttpException(String str, int i, Throwable th) {
        super(str, th);
        this.statusCode = i;
    }
}
