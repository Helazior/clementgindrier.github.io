package org.spongycastle.util.test;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface TestResult {
    Throwable getException();

    boolean isSuccessful();

    String toString();
}
