package com.google.firebase.crashlytics.internal.network;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class HttpResponse {
    private final String body;
    private final int code;

    public HttpResponse(int i, String str) {
        this.code = i;
        this.body = str;
    }

    public String body() {
        return this.body;
    }

    public int code() {
        return this.code;
    }
}
