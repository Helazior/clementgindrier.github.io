package com.google.firebase.encoders;

import java.io.Writer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface DataEncoder {
    String encode(Object obj);

    void encode(Object obj, Writer writer);
}
