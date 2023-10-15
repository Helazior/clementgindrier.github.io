package com.nostra13.universalimageloader.core.download;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BaseImageDownloader implements ImageDownloader {
    public static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    public static final int BUFFER_SIZE = 32768;
    public static final String CONTENT_CONTACTS_URI_PREFIX = "content://com.android.contacts/";
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    public static final int MAX_REDIRECT_COUNT = 5;
    public final int connectTimeout;
    public final Context context;
    public final int readTimeout;

    /* renamed from: com.nostra13.universalimageloader.core.download.BaseImageDownloader$1 */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static /* synthetic */ class C15621 {

        /* renamed from: $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme */
        public static final /* synthetic */ int[] f3933x4730d1a3;

        static {
            ImageDownloader.Scheme.values();
            int[] iArr = new int[7];
            f3933x4730d1a3 = iArr;
            try {
                ImageDownloader.Scheme scheme = ImageDownloader.Scheme.HTTP;
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                int[] iArr2 = f3933x4730d1a3;
                ImageDownloader.Scheme scheme2 = ImageDownloader.Scheme.HTTPS;
                iArr2[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                int[] iArr3 = f3933x4730d1a3;
                ImageDownloader.Scheme scheme3 = ImageDownloader.Scheme.FILE;
                iArr3[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                int[] iArr4 = f3933x4730d1a3;
                ImageDownloader.Scheme scheme4 = ImageDownloader.Scheme.CONTENT;
                iArr4[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                int[] iArr5 = f3933x4730d1a3;
                ImageDownloader.Scheme scheme5 = ImageDownloader.Scheme.ASSETS;
                iArr5[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                int[] iArr6 = f3933x4730d1a3;
                ImageDownloader.Scheme scheme6 = ImageDownloader.Scheme.DRAWABLE;
                iArr6[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                int[] iArr7 = f3933x4730d1a3;
                ImageDownloader.Scheme scheme7 = ImageDownloader.Scheme.UNKNOWN;
                iArr7[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BaseImageDownloader(Context context) {
        this(context, DEFAULT_HTTP_CONNECT_TIMEOUT, 20000);
    }

    @TargetApi(8)
    private InputStream getVideoThumbnailStream(String str) {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
        if (createVideoThumbnail != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        return null;
    }

    private boolean isVideoContentUri(Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        return type != null && type.startsWith("video/");
    }

    private boolean isVideoFileUri(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/");
    }

    public HttpURLConnection createConnection(String str, Object obj) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, ALLOWED_URI_CHARS)).openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return httpURLConnection;
    }

    @TargetApi(14)
    public InputStream getContactPhotoStream(Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(this.context.getContentResolver(), uri, true);
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) {
        int ordinal = ImageDownloader.Scheme.ofUri(str).ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return getStreamFromNetwork(str, obj);
        }
        if (ordinal != 2) {
            if (ordinal != 3) {
                if (ordinal != 4) {
                    if (ordinal != 5) {
                        return getStreamFromOtherSource(str, obj);
                    }
                    return getStreamFromDrawable(str, obj);
                }
                return getStreamFromAssets(str, obj);
            }
            return getStreamFromContent(str, obj);
        }
        return getStreamFromFile(str, obj);
    }

    public InputStream getStreamFromAssets(String str, Object obj) {
        return this.context.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    public InputStream getStreamFromContent(String str, Object obj) {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri parse = Uri.parse(str);
        if (isVideoContentUri(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith(CONTENT_CONTACTS_URI_PREFIX)) {
            return getContactPhotoStream(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    public InputStream getStreamFromDrawable(String str, Object obj) {
        return this.context.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    public InputStream getStreamFromFile(String str, Object obj) {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        if (isVideoFileUri(str)) {
            return getVideoThumbnailStream(crop);
        }
        return new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    public InputStream getStreamFromNetwork(String str, Object obj) {
        HttpURLConnection createConnection = createConnection(str, obj);
        for (int i = 0; createConnection.getResponseCode() / 100 == 3 && i < 5; i++) {
            createConnection = createConnection(createConnection.getHeaderField("Location"), obj);
        }
        try {
            InputStream inputStream = createConnection.getInputStream();
            if (shouldBeProcessed(createConnection)) {
                return new ContentLengthInputStream(new BufferedInputStream(inputStream, 32768), createConnection.getContentLength());
            }
            IoUtils.closeSilently(inputStream);
            StringBuilder m253r = outline.m253r("Image request failed with response code ");
            m253r.append(createConnection.getResponseCode());
            throw new IOException(m253r.toString());
        } catch (IOException e) {
            IoUtils.readAndCloseStream(createConnection.getErrorStream());
            throw e;
        }
    }

    public InputStream getStreamFromOtherSource(String str, Object obj) {
        throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, str));
    }

    public boolean shouldBeProcessed(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getResponseCode() == 200;
    }

    public BaseImageDownloader(Context context, int i, int i2) {
        this.context = context.getApplicationContext();
        this.connectTimeout = i;
        this.readTimeout = i2;
    }
}
