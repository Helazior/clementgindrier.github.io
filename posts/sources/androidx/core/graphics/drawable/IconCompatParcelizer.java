package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(AbstractC1894i8 abstractC1894i8) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2987a = abstractC1894i8.m730k(iconCompat.f2987a, 1);
        byte[] bArr = iconCompat.f2989c;
        if (abstractC1894i8.mo693i(2)) {
            bArr = abstractC1894i8.mo695g();
        }
        iconCompat.f2989c = bArr;
        iconCompat.f2990d = abstractC1894i8.m729m(iconCompat.f2990d, 3);
        iconCompat.f2991e = abstractC1894i8.m730k(iconCompat.f2991e, 4);
        iconCompat.f2992f = abstractC1894i8.m730k(iconCompat.f2992f, 5);
        iconCompat.f2993g = (ColorStateList) abstractC1894i8.m729m(iconCompat.f2993g, 6);
        String str = iconCompat.f2995i;
        if (abstractC1894i8.mo693i(7)) {
            str = abstractC1894i8.mo690n();
        }
        iconCompat.f2995i = str;
        String str2 = iconCompat.f2996j;
        if (abstractC1894i8.mo693i(8)) {
            str2 = abstractC1894i8.mo690n();
        }
        iconCompat.f2996j = str2;
        iconCompat.f2994h = PorterDuff.Mode.valueOf(iconCompat.f2995i);
        switch (iconCompat.f2987a) {
            case -1:
                Parcelable parcelable = iconCompat.f2990d;
                if (parcelable != null) {
                    iconCompat.f2988b = parcelable;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid icon");
                }
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f2990d;
                if (parcelable2 != null) {
                    iconCompat.f2988b = parcelable2;
                    break;
                } else {
                    byte[] bArr2 = iconCompat.f2989c;
                    iconCompat.f2988b = bArr2;
                    iconCompat.f2987a = 3;
                    iconCompat.f2991e = 0;
                    iconCompat.f2992f = bArr2.length;
                    break;
                }
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f2989c, Charset.forName("UTF-16"));
                iconCompat.f2988b = str3;
                if (iconCompat.f2987a == 2 && iconCompat.f2996j == null) {
                    iconCompat.f2996j = str3.split(":", -1)[0];
                    break;
                }
                break;
            case 3:
                iconCompat.f2988b = iconCompat.f2989c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, AbstractC1894i8 abstractC1894i8) {
        Objects.requireNonNull(abstractC1894i8);
        iconCompat.f2995i = iconCompat.f2994h.name();
        switch (iconCompat.f2987a) {
            case -1:
                iconCompat.f2990d = (Parcelable) iconCompat.f2988b;
                break;
            case 1:
            case 5:
                iconCompat.f2990d = (Parcelable) iconCompat.f2988b;
                break;
            case 2:
                iconCompat.f2989c = ((String) iconCompat.f2988b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f2989c = (byte[]) iconCompat.f2988b;
                break;
            case 4:
            case 6:
                iconCompat.f2989c = iconCompat.f2988b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.f2987a;
        if (-1 != i) {
            abstractC1894i8.mo689p(1);
            abstractC1894i8.mo685t(i);
        }
        byte[] bArr = iconCompat.f2989c;
        if (bArr != null) {
            abstractC1894i8.mo689p(2);
            abstractC1894i8.mo687r(bArr);
        }
        Parcelable parcelable = iconCompat.f2990d;
        if (parcelable != null) {
            abstractC1894i8.mo689p(3);
            abstractC1894i8.mo684u(parcelable);
        }
        int i2 = iconCompat.f2991e;
        if (i2 != 0) {
            abstractC1894i8.mo689p(4);
            abstractC1894i8.mo685t(i2);
        }
        int i3 = iconCompat.f2992f;
        if (i3 != 0) {
            abstractC1894i8.mo689p(5);
            abstractC1894i8.mo685t(i3);
        }
        ColorStateList colorStateList = iconCompat.f2993g;
        if (colorStateList != null) {
            abstractC1894i8.mo689p(6);
            abstractC1894i8.mo684u(colorStateList);
        }
        String str = iconCompat.f2995i;
        if (str != null) {
            abstractC1894i8.mo689p(7);
            abstractC1894i8.mo683v(str);
        }
        String str2 = iconCompat.f2996j;
        if (str2 != null) {
            abstractC1894i8.mo689p(8);
            abstractC1894i8.mo683v(str2);
        }
    }
}
