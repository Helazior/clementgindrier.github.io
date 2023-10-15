package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class DecodedChar extends DecodedObject {
    public static final char FNC1 = '$';
    private final char value;

    public DecodedChar(int i, char c) {
        super(i);
        this.value = c;
    }

    public char getValue() {
        return this.value;
    }

    public boolean isFNC1() {
        return this.value == '$';
    }
}
