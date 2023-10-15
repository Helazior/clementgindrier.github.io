package com.nostra13.universalimageloader.cache.disc;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.File;
import java.io.InputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface DiskCache {
    void clear();

    void close();

    File get(String str);

    File getDirectory();

    boolean remove(String str);

    boolean save(String str, Bitmap bitmap);

    boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener);
}
