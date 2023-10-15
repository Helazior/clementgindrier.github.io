package com.google.android.datatransport;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface TransportFactory {
    <T> Transport<T> getTransport(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer);

    @Deprecated
    <T> Transport<T> getTransport(String str, Class<T> cls, Transformer<T, byte[]> transformer);
}
