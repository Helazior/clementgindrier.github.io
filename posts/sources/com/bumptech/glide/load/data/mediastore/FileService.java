package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FileService {
    public boolean exists(File file) {
        return file.exists();
    }

    public File get(String str) {
        return new File(str);
    }

    public long length(File file) {
        return file.length();
    }
}
