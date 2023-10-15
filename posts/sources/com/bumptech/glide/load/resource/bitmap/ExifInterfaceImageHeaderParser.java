package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ExifInterfaceImageHeaderParser implements ImageHeaderParser {
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[ORIG_RETURN, RETURN] */
    @Override // com.bumptech.glide.load.ImageHeaderParser
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int getOrientation(java.io.InputStream r1, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r2) {
        /*
            r0 = this;
            C5 r2 = new C5
            r2.<init>(r1)
            java.lang.String r1 = "Orientation"
            C5$b r1 = r2.m2542d(r1)
            if (r1 != 0) goto Le
            goto L15
        Le:
            java.nio.ByteOrder r2 = r2.f264f     // Catch: java.lang.NumberFormatException -> L15
            int r1 = r1.m2519f(r2)     // Catch: java.lang.NumberFormatException -> L15
            goto L16
        L15:
            r1 = 1
        L16:
            if (r1 != 0) goto L19
            r1 = -1
        L19:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser.getOrientation(java.io.InputStream, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool):int");
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(ByteBuffer byteBuffer, ArrayPool arrayPool) {
        return getOrientation(ByteBufferUtil.toStream(byteBuffer), arrayPool);
    }
}
