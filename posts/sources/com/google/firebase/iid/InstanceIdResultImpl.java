package com.google.firebase.iid;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class InstanceIdResultImpl implements InstanceIdResult {

    /* renamed from: id */
    private final String f3888id;
    private final String token;

    public InstanceIdResultImpl(String str, String str2) {
        this.f3888id = str;
        this.token = str2;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getId() {
        return this.f3888id;
    }

    @Override // com.google.firebase.iid.InstanceIdResult
    public String getToken() {
        return this.token;
    }
}
