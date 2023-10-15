package com.google.android.datatransport.runtime.retries;

import java.lang.Throwable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface Function<TInput, TResult, TException extends Throwable> {
    TResult apply(TInput tinput);
}
