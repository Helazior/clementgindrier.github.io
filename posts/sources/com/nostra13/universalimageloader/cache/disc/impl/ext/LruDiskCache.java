package com.nostra13.universalimageloader.cache.disc.impl.ext;

import android.graphics.Bitmap;
import androidx.recyclerview.widget.RecyclerView;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache;
import com.nostra13.universalimageloader.cache.disc.naming.FileNameGenerator;
import com.nostra13.universalimageloader.utils.C1564L;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LruDiskCache implements DiskCache {
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final Bitmap.CompressFormat DEFAULT_COMPRESS_FORMAT = Bitmap.CompressFormat.PNG;
    public static final int DEFAULT_COMPRESS_QUALITY = 100;
    private static final String ERROR_ARG_NEGATIVE = " argument must be positive number";
    private static final String ERROR_ARG_NULL = " argument must be not null";
    public int bufferSize;
    public DiskLruCache cache;
    public Bitmap.CompressFormat compressFormat;
    public int compressQuality;
    public final FileNameGenerator fileNameGenerator;
    private File reserveCacheDir;

    public LruDiskCache(File file, FileNameGenerator fileNameGenerator, long j) {
        this(file, null, fileNameGenerator, j, 0);
    }

    private String getKey(String str) {
        return this.fileNameGenerator.generate(str);
    }

    private void initCache(File file, File file2, long j, int i) {
        try {
            this.cache = DiskLruCache.open(file, 1, 1, j, i);
        } catch (IOException e) {
            C1564L.m1068e(e);
            if (file2 != null) {
                initCache(file2, null, j, i);
            }
            if (this.cache == null) {
                throw e;
            }
        }
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public void clear() {
        try {
            this.cache.delete();
        } catch (IOException e) {
            C1564L.m1068e(e);
        }
        try {
            initCache(this.cache.getDirectory(), this.reserveCacheDir, this.cache.getMaxSize(), this.cache.getMaxFileCount());
        } catch (IOException e2) {
            C1564L.m1068e(e2);
        }
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public void close() {
        try {
            this.cache.close();
        } catch (IOException e) {
            C1564L.m1068e(e);
        }
        this.cache = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002e  */
    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.io.File get(java.lang.String r4) {
        /*
            r3 = this;
            r0 = 0
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache r1 = r3.cache     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            java.lang.String r4 = r3.getKey(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache$Snapshot r4 = r1.get(r4)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            if (r4 != 0) goto Le
            goto L13
        Le:
            r1 = 0
            java.io.File r0 = r4.getFile(r1)     // Catch: java.io.IOException -> L19 java.lang.Throwable -> L2b
        L13:
            if (r4 == 0) goto L18
            r4.close()
        L18:
            return r0
        L19:
            r1 = move-exception
            goto L22
        L1b:
            r4 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
            goto L2c
        L20:
            r1 = move-exception
            r4 = r0
        L22:
            com.nostra13.universalimageloader.utils.C1564L.m1068e(r1)     // Catch: java.lang.Throwable -> L2b
            if (r4 == 0) goto L2a
            r4.close()
        L2a:
            return r0
        L2b:
            r0 = move-exception
        L2c:
            if (r4 == 0) goto L31
            r4.close()
        L31:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache.get(java.lang.String):java.io.File");
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public File getDirectory() {
        return this.cache.getDirectory();
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean remove(String str) {
        try {
            return this.cache.remove(getKey(str));
        } catch (IOException e) {
            C1564L.m1068e(e);
            return false;
        }
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(String str, InputStream inputStream, IoUtils.CopyListener copyListener) {
        DiskLruCache.Editor edit = this.cache.edit(getKey(str));
        if (edit == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
        try {
            boolean copyStream = IoUtils.copyStream(inputStream, bufferedOutputStream, copyListener, this.bufferSize);
            IoUtils.closeSilently(bufferedOutputStream);
            if (copyStream) {
                edit.commit();
            } else {
                edit.abort();
            }
            return copyStream;
        } catch (Throwable th) {
            IoUtils.closeSilently(bufferedOutputStream);
            edit.abort();
            throw th;
        }
    }

    public void setBufferSize(int i) {
        this.bufferSize = i;
    }

    public void setCompressFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
    }

    public void setCompressQuality(int i) {
        this.compressQuality = i;
    }

    public LruDiskCache(File file, File file2, FileNameGenerator fileNameGenerator, long j, int i) {
        this.bufferSize = 32768;
        this.compressFormat = DEFAULT_COMPRESS_FORMAT;
        this.compressQuality = 100;
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        int i2 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (fileNameGenerator != null) {
            long j2 = i2 == 0 ? RecyclerView.FOREVER_NS : j;
            int i3 = i == 0 ? Integer.MAX_VALUE : i;
            this.reserveCacheDir = file2;
            this.fileNameGenerator = fileNameGenerator;
            initCache(file, file2, j2, i3);
            return;
        }
        throw new IllegalArgumentException("fileNameGenerator argument must be not null");
    }

    @Override // com.nostra13.universalimageloader.cache.disc.DiskCache
    public boolean save(String str, Bitmap bitmap) {
        DiskLruCache.Editor edit = this.cache.edit(getKey(str));
        if (edit == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(edit.newOutputStream(0), this.bufferSize);
        try {
            boolean compress = bitmap.compress(this.compressFormat, this.compressQuality, bufferedOutputStream);
            if (compress) {
                edit.commit();
            } else {
                edit.abort();
            }
            return compress;
        } finally {
            IoUtils.closeSilently(bufferedOutputStream);
        }
    }
}
