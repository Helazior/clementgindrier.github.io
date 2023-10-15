package com.joanzapata.android.iconify;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import com.joanzapata.android.iconify.Iconify;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Utils {
    public static final String ICON_FONT_FOLDER = "icon_tmp";

    private Utils() {
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static int convertDpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    private static void copy(InputStream inputStream, File file) {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            byte[] bArr = new byte[inputStream.available()];
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read > 0) {
                        bufferedOutputStream2.write(bArr, 0, read);
                    } else {
                        closeQuietly(bufferedOutputStream2);
                        closeQuietly(inputStream);
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedOutputStream = bufferedOutputStream2;
                    closeQuietly(bufferedOutputStream);
                    closeQuietly(inputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isEnabled(int[] iArr) {
        for (int i : iArr) {
            if (i == 16842910) {
                return true;
            }
        }
        return false;
    }

    public static StringBuilder replaceIcons(StringBuilder sb) {
        return replaceIcons(Iconify.IconValue.fa_500px, sb);
    }

    public static File resourceToFile(Context context, String str) {
        File file;
        if (context.getFilesDir() == null) {
            file = new File(context.getCacheDir(), ICON_FONT_FOLDER);
        } else {
            file = new File(context.getFilesDir(), ICON_FONT_FOLDER);
        }
        if (!file.exists() && !file.mkdirs()) {
            Log.e(Iconify.TAG, "Font folder creation failed");
            throw new IllegalStateException("Cannot create Iconify font destination folder");
        }
        int indexOf = str.indexOf(58);
        String substring = indexOf != -1 ? str.substring(indexOf + 1) : str;
        File file2 = new File(file, substring);
        if (file2.exists()) {
            return file2;
        }
        try {
            if (str.startsWith("asset:")) {
                InputStream open = context.getAssets().open(substring);
                copy(open, file2);
                closeQuietly(open);
                return file2;
            }
            InputStream resourceAsStream = Iconify.class.getClassLoader().getResourceAsStream(substring);
            copy(resourceAsStream, file2);
            closeQuietly(resourceAsStream);
            return file2;
        } catch (Throwable th) {
            closeQuietly(null);
            throw th;
        }
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lcom/joanzapata/android/iconify/BaseIconValue;>(TT;Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder; */
    public static StringBuilder replaceIcons(Enum r6, StringBuilder sb) {
        StringBuilder m253r = outline.m253r("{");
        m253r.append(((BaseIconValue) r6).getPrefix());
        int indexOf = sb.indexOf(m253r.toString());
        if (indexOf == -1) {
            return sb;
        }
        int indexOf2 = sb.indexOf("}", indexOf) + 1;
        String substring = sb.substring(indexOf + 1, indexOf2 - 1);
        try {
            sb = sb.replace(indexOf, indexOf2, String.valueOf(((BaseIconValue) r6).iconFrom(substring.replaceAll("-", "_")).character()));
            return replaceIcons(r6, sb);
        } catch (IllegalArgumentException unused) {
            String str = Iconify.TAG;
            Log.w(str, "Wrong icon name: " + substring);
            return sb;
        }
    }
}
