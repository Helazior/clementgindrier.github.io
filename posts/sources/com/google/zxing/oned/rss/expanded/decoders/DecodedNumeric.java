package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class DecodedNumeric extends DecodedObject {
    public static final int FNC1 = 10;
    private final int firstDigit;
    private final int secondDigit;

    public DecodedNumeric(int i, int i2, int i3) {
        super(i);
        this.firstDigit = i2;
        this.secondDigit = i3;
        if (i2 < 0 || i2 > 10) {
            throw new IllegalArgumentException(outline.m273H("Invalid firstDigit: ", i2));
        }
        if (i3 < 0 || i3 > 10) {
            throw new IllegalArgumentException(outline.m273H("Invalid secondDigit: ", i3));
        }
    }

    public int getFirstDigit() {
        return this.firstDigit;
    }

    public int getSecondDigit() {
        return this.secondDigit;
    }

    public int getValue() {
        return (this.firstDigit * 10) + this.secondDigit;
    }

    public boolean isAnyFNC1() {
        return this.firstDigit == 10 || this.secondDigit == 10;
    }

    public boolean isFirstDigitFNC1() {
        return this.firstDigit == 10;
    }

    public boolean isSecondDigitFNC1() {
        return this.secondDigit == 10;
    }
}
