package com.squareup.picasso;

import okhttp3.Response;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Downloader {
    Response load(okhttp3.Request request);

    void shutdown();
}
