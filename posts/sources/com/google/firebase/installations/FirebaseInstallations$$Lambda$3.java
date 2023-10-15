package com.google.firebase.installations;

import java.util.concurrent.Callable;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final /* synthetic */ class FirebaseInstallations$$Lambda$3 implements Callable {
    private final FirebaseInstallations arg$1;

    private FirebaseInstallations$$Lambda$3(FirebaseInstallations firebaseInstallations) {
        this.arg$1 = firebaseInstallations;
    }

    public static Callable lambdaFactory$(FirebaseInstallations firebaseInstallations) {
        return new FirebaseInstallations$$Lambda$3(firebaseInstallations);
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        return FirebaseInstallations.access$lambda$0(this.arg$1);
    }
}
