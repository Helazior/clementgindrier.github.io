package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ImageHeaderParserRegistry {
    private final List<ImageHeaderParser> parsers = new ArrayList();

    public synchronized void add(ImageHeaderParser imageHeaderParser) {
        this.parsers.add(imageHeaderParser);
    }

    public synchronized List<ImageHeaderParser> getParsers() {
        return this.parsers;
    }
}
