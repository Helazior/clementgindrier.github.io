package com.google.firebase.crashlytics.internal.common;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public enum DeliveryMechanism {
    DEVELOPER(1),
    USER_SIDELOAD(2),
    TEST_DISTRIBUTION(3),
    APP_STORE(4);
    

    /* renamed from: id */
    private final int f3883id;

    DeliveryMechanism(int i) {
        this.f3883id = i;
    }

    public static DeliveryMechanism determineFrom(String str) {
        return str != null ? APP_STORE : DEVELOPER;
    }

    public int getId() {
        return this.f3883id;
    }

    @Override // java.lang.Enum
    public String toString() {
        return Integer.toString(this.f3883id);
    }
}
