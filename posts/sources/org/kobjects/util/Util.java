package org.kobjects.util;

import com.pdfview.subsamplincscaleimageview.ImageSource;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class Util {
    public static String buildUrl(String str, String str2) {
        int indexOf = str2.indexOf(58);
        boolean startsWith = str2.startsWith("/");
        String str3 = ImageSource.FILE_SCHEME;
        if (startsWith || indexOf == 1) {
            return outline.m266e(ImageSource.FILE_SCHEME, str2);
        }
        if (indexOf <= 2 || indexOf >= 6) {
            if (str != null) {
                if (str.indexOf(58) == -1) {
                    str = outline.m266e(ImageSource.FILE_SCHEME, str);
                }
                str3 = !str.endsWith("/") ? outline.m266e(str, "/") : str;
            }
            return outline.m266e(str3, str2);
        }
        return str2;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (objArr[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    public static void sort(Object[] objArr, int i, int i2) {
        int i3;
        int i4 = i2 - i;
        if (i4 <= 2) {
            if (i4 == 2) {
                int i5 = i + 1;
                if (objArr[i].toString().compareTo(objArr[i5].toString()) > 0) {
                    Object obj = objArr[i];
                    objArr[i] = objArr[i5];
                    objArr[i5] = obj;
                }
            }
        } else if (i4 == 3) {
            int i6 = i + 2;
            sort(objArr, i, i6);
            sort(objArr, i + 1, i + 3);
            sort(objArr, i, i6);
        } else {
            int i7 = (i + i2) / 2;
            sort(objArr, i, i7);
            sort(objArr, i7, i2);
            Object[] objArr2 = new Object[i4];
            int i8 = i;
            int i9 = i7;
            for (int i10 = 0; i10 < i4; i10++) {
                if (i8 == i7) {
                    i3 = i9 + 1;
                    objArr2[i10] = objArr[i9];
                } else if (i9 != i2 && objArr[i8].toString().compareTo(objArr[i9].toString()) >= 0) {
                    i3 = i9 + 1;
                    objArr2[i10] = objArr[i9];
                } else {
                    objArr2[i10] = objArr[i8];
                    i8++;
                }
                i9 = i3;
            }
            System.arraycopy(objArr2, 0, objArr, i, i4);
        }
    }

    public static OutputStream streamcopy(InputStream inputStream, OutputStream outputStream) {
        int i = Runtime.getRuntime().freeMemory() >= 1048576 ? 16384 : 128;
        byte[] bArr = new byte[i];
        while (true) {
            int read = inputStream.read(bArr, 0, i);
            if (read == -1) {
                inputStream.close();
                return outputStream;
            }
            outputStream.write(bArr, 0, read);
        }
    }
}
