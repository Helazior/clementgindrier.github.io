package com.bumptech.glide.load.engine;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class CallbackException extends RuntimeException {
    private static final long serialVersionUID = -7530898992688511851L;

    public CallbackException(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
