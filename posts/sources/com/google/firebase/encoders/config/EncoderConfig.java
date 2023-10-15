package com.google.firebase.encoders.config;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.config.EncoderConfig;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface EncoderConfig<T extends EncoderConfig<T>> {
    <U> T registerEncoder(Class<U> cls, ObjectEncoder<? super U> objectEncoder);

    <U> T registerEncoder(Class<U> cls, ValueEncoder<? super U> valueEncoder);
}
