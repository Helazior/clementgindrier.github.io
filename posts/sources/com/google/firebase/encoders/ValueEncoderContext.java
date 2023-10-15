package com.google.firebase.encoders;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface ValueEncoderContext {
    ValueEncoderContext add(double d);

    ValueEncoderContext add(float f);

    ValueEncoderContext add(int i);

    ValueEncoderContext add(long j);

    ValueEncoderContext add(String str);

    ValueEncoderContext add(boolean z);

    ValueEncoderContext add(byte[] bArr);
}
