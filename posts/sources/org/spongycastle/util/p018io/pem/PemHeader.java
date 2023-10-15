package org.spongycastle.util.p018io.pem;

/* renamed from: org.spongycastle.util.io.pem.PemHeader */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PemHeader {
    private String name;
    private String value;

    public PemHeader(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    private int getHashCode(String str) {
        if (str == null) {
            return 1;
        }
        return str.hashCode();
    }

    private boolean isEqual(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof PemHeader) {
            PemHeader pemHeader = (PemHeader) obj;
            return pemHeader == this || (isEqual(this.name, pemHeader.name) && isEqual(this.value, pemHeader.value));
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (getHashCode(this.value) * 31) + getHashCode(this.name);
    }
}
