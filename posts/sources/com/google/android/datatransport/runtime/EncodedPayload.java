package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class EncodedPayload {
    private final byte[] bytes;
    private final Encoding encoding;

    public EncodedPayload(Encoding encoding, byte[] bArr) {
        Objects.requireNonNull(encoding, "encoding is null");
        Objects.requireNonNull(bArr, "bytes is null");
        this.encoding = encoding;
        this.bytes = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EncodedPayload) {
            EncodedPayload encodedPayload = (EncodedPayload) obj;
            if (this.encoding.equals(encodedPayload.encoding)) {
                return Arrays.equals(this.bytes, encodedPayload.bytes);
            }
            return false;
        }
        return false;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public Encoding getEncoding() {
        return this.encoding;
    }

    public int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("EncodedPayload{encoding=");
        m253r.append(this.encoding);
        m253r.append(", bytes=[...]}");
        return m253r.toString();
    }
}
