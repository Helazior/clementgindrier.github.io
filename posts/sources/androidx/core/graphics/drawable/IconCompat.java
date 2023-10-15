package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k */
    public static final PorterDuff.Mode f2986k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a */
    public int f2987a;

    /* renamed from: b */
    public Object f2988b;

    /* renamed from: c */
    public byte[] f2989c;

    /* renamed from: d */
    public Parcelable f2990d;

    /* renamed from: e */
    public int f2991e;

    /* renamed from: f */
    public int f2992f;

    /* renamed from: g */
    public ColorStateList f2993g;

    /* renamed from: h */
    public PorterDuff.Mode f2994h;

    /* renamed from: i */
    public String f2995i;

    /* renamed from: j */
    public String f2996j;

    public IconCompat() {
        this.f2987a = -1;
        this.f2989c = null;
        this.f2990d = null;
        this.f2991e = 0;
        this.f2992f = 0;
        this.f2993g = null;
        this.f2994h = f2986k;
        this.f2995i = null;
    }

    /* renamed from: a */
    public static Bitmap m1500a(Bitmap bitmap, boolean z) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f = min;
        float f2 = 0.5f * f;
        float f3 = 0.9166667f * f2;
        if (z) {
            float f4 = 0.010416667f * f;
            paint.setColor(0);
            paint.setShadowLayer(f4, 0.0f, f * 0.020833334f, 1023410176);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.setShadowLayer(f4, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f2, f2, f3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f2, f2, f3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    /* renamed from: b */
    public static IconCompat m1499b(Resources resources, String str, int i) {
        if (i != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f2991e = i;
            iconCompat.f2988b = str;
            iconCompat.f2996j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    /* renamed from: c */
    public int m1498c() {
        int i;
        int i2 = this.f2987a;
        if (i2 != -1 || (i = Build.VERSION.SDK_INT) < 23) {
            if (i2 == 2) {
                return this.f2991e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        Icon icon = (Icon) this.f2988b;
        if (i >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon resource", e);
            return 0;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon resource", e2);
            return 0;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon resource", e3);
            return 0;
        }
    }

    /* renamed from: d */
    public int m1497d() {
        int i;
        int i2 = this.f2987a;
        if (i2 != -1 || (i = Build.VERSION.SDK_INT) < 23) {
            return i2;
        }
        Icon icon = (Icon) this.f2988b;
        if (i >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e);
            return -1;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e2);
            return -1;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e3);
            return -1;
        }
    }

    /* renamed from: e */
    public Uri m1496e() {
        int i;
        int i2 = this.f2987a;
        if (i2 != -1 || (i = Build.VERSION.SDK_INT) < 23) {
            if (i2 != 4 && i2 != 6) {
                throw new IllegalStateException("called getUri() on " + this);
            }
            return Uri.parse((String) this.f2988b);
        }
        Icon icon = (Icon) this.f2988b;
        if (i >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.e("IconCompat", "Unable to get icon uri", e);
            return null;
        } catch (NoSuchMethodException e2) {
            Log.e("IconCompat", "Unable to get icon uri", e2);
            return null;
        } catch (InvocationTargetException e3) {
            Log.e("IconCompat", "Unable to get icon uri", e3);
            return null;
        }
    }

    @Deprecated
    /* renamed from: f */
    public Icon m1495f() {
        return m1494g(null);
    }

    /* renamed from: g */
    public Icon m1494g(Context context) {
        Icon createWithBitmap;
        int i;
        int i2 = this.f2987a;
        String str = null;
        r2 = null;
        InputStream openInputStream = null;
        str = null;
        str = null;
        switch (i2) {
            case -1:
                return (Icon) this.f2988b;
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.f2988b);
                break;
            case 2:
                if (i2 == -1 && (i = Build.VERSION.SDK_INT) >= 23) {
                    Icon icon = (Icon) this.f2988b;
                    if (i >= 28) {
                        str = icon.getResPackage();
                    } else {
                        try {
                            str = (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
                        } catch (IllegalAccessException e) {
                            Log.e("IconCompat", "Unable to get icon package", e);
                        } catch (NoSuchMethodException e2) {
                            Log.e("IconCompat", "Unable to get icon package", e2);
                        } catch (InvocationTargetException e3) {
                            Log.e("IconCompat", "Unable to get icon package", e3);
                        }
                    }
                } else if (i2 == 2) {
                    if (TextUtils.isEmpty(this.f2996j)) {
                        str = ((String) this.f2988b).split(":", -1)[0];
                    } else {
                        str = this.f2996j;
                    }
                } else {
                    throw new IllegalStateException("called getResPackage() on " + this);
                }
                createWithBitmap = Icon.createWithResource(str, this.f2991e);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.f2988b, this.f2991e, this.f2992f);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.f2988b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT >= 26) {
                    createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f2988b);
                    break;
                } else {
                    createWithBitmap = Icon.createWithBitmap(m1500a((Bitmap) this.f2988b, false));
                    break;
                }
            case 6:
                if (Build.VERSION.SDK_INT >= 30) {
                    createWithBitmap = Icon.createWithAdaptiveBitmapContentUri(m1496e());
                    break;
                } else if (context != null) {
                    Uri m1496e = m1496e();
                    String scheme = m1496e.getScheme();
                    if (!"content".equals(scheme) && !"file".equals(scheme)) {
                        try {
                            openInputStream = new FileInputStream(new File((String) this.f2988b));
                        } catch (FileNotFoundException e4) {
                            Log.w("IconCompat", "Unable to load image from path: " + m1496e, e4);
                        }
                    } else {
                        try {
                            openInputStream = context.getContentResolver().openInputStream(m1496e);
                        } catch (Exception e5) {
                            Log.w("IconCompat", "Unable to load image from URI: " + m1496e, e5);
                        }
                    }
                    if (openInputStream != null) {
                        if (Build.VERSION.SDK_INT >= 26) {
                            createWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(openInputStream));
                            break;
                        } else {
                            createWithBitmap = Icon.createWithBitmap(m1500a(BitmapFactory.decodeStream(openInputStream), false));
                            break;
                        }
                    } else {
                        StringBuilder m253r = outline.m253r("Cannot load adaptive icon from uri: ");
                        m253r.append(m1496e());
                        throw new IllegalStateException(m253r.toString());
                    }
                } else {
                    StringBuilder m253r2 = outline.m253r("Context is required to resolve the file uri of the icon: ");
                    m253r2.append(m1496e());
                    throw new IllegalArgumentException(m253r2.toString());
                }
        }
        ColorStateList colorStateList = this.f2993g;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f2994h;
        if (mode != f2986k) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    public String toString() {
        String str;
        if (this.f2987a == -1) {
            return String.valueOf(this.f2988b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f2987a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f2987a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2988b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2988b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f2996j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(m1498c())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2991e);
                if (this.f2992f != 0) {
                    sb.append(" off=");
                    sb.append(this.f2992f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2988b);
                break;
        }
        if (this.f2993g != null) {
            sb.append(" tint=");
            sb.append(this.f2993g);
        }
        if (this.f2994h != f2986k) {
            sb.append(" mode=");
            sb.append(this.f2994h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i) {
        this.f2987a = -1;
        this.f2989c = null;
        this.f2990d = null;
        this.f2991e = 0;
        this.f2992f = 0;
        this.f2993g = null;
        this.f2994h = f2986k;
        this.f2995i = null;
        this.f2987a = i;
    }
}
