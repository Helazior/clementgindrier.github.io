package com.google.firebase.platforminfo;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class KotlinDetector {
    private KotlinDetector() {
    }

    public static String detectVersion() {
        try {
            return C0343Od.f1157f.toString();
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }
}
