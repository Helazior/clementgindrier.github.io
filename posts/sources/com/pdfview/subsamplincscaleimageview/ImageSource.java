package com.pdfview.subsamplincscaleimageview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import com.bumptech.glide.load.Key;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ImageSource {
    public static final String ASSET_SCHEME = "file:///android_asset/";
    public static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private ImageSource(Bitmap bitmap, boolean z) {
        this.bitmap = bitmap;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap.getWidth();
        this.sHeight = bitmap.getHeight();
        this.cached = z;
    }

    public static ImageSource asset(String str) {
        Objects.requireNonNull(str, "Asset name must not be null");
        return uri(ASSET_SCHEME + str);
    }

    public static ImageSource bitmap(Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        return new ImageSource(bitmap, false);
    }

    public static ImageSource cachedBitmap(Bitmap bitmap) {
        Objects.requireNonNull(bitmap, "Bitmap must not be null");
        return new ImageSource(bitmap, true);
    }

    public static ImageSource resource(int i) {
        return new ImageSource(i);
    }

    private void setInvariants() {
        Rect rect = this.sRegion;
        if (rect != null) {
            this.tile = true;
            this.sWidth = rect.width();
            this.sHeight = this.sRegion.height();
        }
    }

    public static ImageSource uri(String str) {
        Objects.requireNonNull(str, "Uri must not be null");
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = outline.m266e(FILE_SCHEME, str);
        }
        return new ImageSource(Uri.parse(str));
    }

    public ImageSource dimensions(int i, int i2) {
        if (this.bitmap == null) {
            this.sWidth = i;
            this.sHeight = i2;
        }
        setInvariants();
        return this;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Integer getResource() {
        return this.resource;
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final Rect getSRegion() {
        return this.sRegion;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final boolean getTile() {
        return this.tile;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final boolean isCached() {
        return this.cached;
    }

    public ImageSource region(Rect rect) {
        this.sRegion = rect;
        setInvariants();
        return this;
    }

    public ImageSource tiling(boolean z) {
        this.tile = z;
        return this;
    }

    public ImageSource tilingDisabled() {
        return tiling(false);
    }

    public ImageSource tilingEnabled() {
        return tiling(true);
    }

    public static ImageSource uri(Uri uri) {
        Objects.requireNonNull(uri, "Uri must not be null");
        return new ImageSource(uri);
    }

    private ImageSource(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith(FILE_SCHEME) && !new File(uri2.substring(7)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, Key.STRING_CHARSET_NAME));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.bitmap = null;
        this.uri = uri;
        this.resource = null;
        this.tile = true;
    }

    private ImageSource(int i) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(i);
        this.tile = true;
    }
}
