package com.pdfview;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.jetbrains.annotations.NotNull;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class FileUtils {
    public static final FileUtils INSTANCE = new FileUtils();

    private FileUtils() {
    }

    @NotNull
    public final File fileFromAsset(@NotNull Context context, @NotNull String str) {
        C0581Yd.m1765f(context, "context");
        C0581Yd.m1765f(str, "assetFileName");
        File file = new File(context.getCacheDir(), outline.m266e(str, "-pdfview.pdf"));
        if (C1880he.m756a(str, "/", false, 2)) {
            file.getParentFile().mkdirs();
        }
        InputStream open = context.getAssets().open(str);
        C0581Yd.m1769b(open, "context.assets.open(assetFileName)");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        C0581Yd.m1766e(open, "$this$copyTo");
        C0581Yd.m1766e(fileOutputStream, "out");
        byte[] bArr = new byte[8192];
        for (int read = open.read(bArr); read >= 0; read = open.read(bArr)) {
            fileOutputStream.write(bArr, 0, read);
        }
        return file;
    }
}
