package p000;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: O3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0330O3 extends C0369Q3 {
    @Override // p000.C0369Q3
    /* renamed from: a */
    public Typeface mo2129a(Context context, C0017A3 c0017a3, Resources resources, int i) {
        try {
            C0036B3[] c0036b3Arr = c0017a3.f125a;
            int length = c0036b3Arr.length;
            FontFamily.Builder builder = null;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i2 >= length) {
                    break;
                }
                C0036B3 c0036b3 = c0036b3Arr[i2];
                try {
                    Font.Builder weight = new Font.Builder(resources, c0036b3.f180f).setWeight(c0036b3.f176b);
                    if (!c0036b3.f177c) {
                        i3 = 0;
                    }
                    Font build = weight.setSlant(i3).setTtcIndex(c0036b3.f179e).setFontVariationSettings(c0036b3.f178d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i2++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // p000.C0369Q3
    /* renamed from: b */
    public Typeface mo2128b(Context context, CancellationSignal cancellationSignal, C2171p4[] c2171p4Arr, int i) {
        int i2;
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = c2171p4Arr.length;
            FontFamily.Builder builder = null;
            while (true) {
                int i3 = 1;
                if (i2 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
                }
                C2171p4 c2171p4 = c2171p4Arr[i2];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(c2171p4.f6216a, "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor != null) {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(c2171p4.f6218c);
                        if (!c2171p4.f6219d) {
                            i3 = 0;
                        }
                        Font build = weight.setSlant(i3).setTtcIndex(c2171p4.f6217b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                } else {
                    i2 = openFileDescriptor == null ? i2 + 1 : 0;
                }
                openFileDescriptor.close();
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // p000.C0369Q3
    /* renamed from: c */
    public Typeface mo2127c(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // p000.C0369Q3
    /* renamed from: d */
    public Typeface mo2126d(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }
}
