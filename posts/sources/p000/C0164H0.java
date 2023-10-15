package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p000.C0103E3;

/* renamed from: H0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0164H0 {

    /* renamed from: a */
    public final TextView f521a;

    /* renamed from: b */
    public C0584Z0 f522b;

    /* renamed from: c */
    public C0584Z0 f523c;

    /* renamed from: d */
    public C0584Z0 f524d;

    /* renamed from: e */
    public C0584Z0 f525e;

    /* renamed from: f */
    public C0584Z0 f526f;

    /* renamed from: g */
    public C0584Z0 f527g;

    /* renamed from: h */
    public C0584Z0 f528h;

    /* renamed from: i */
    public final C0187I0 f529i;

    /* renamed from: j */
    public int f530j = 0;

    /* renamed from: k */
    public int f531k = -1;

    /* renamed from: l */
    public Typeface f532l;

    /* renamed from: m */
    public boolean f533m;

    /* renamed from: H0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0165a extends C0103E3.AbstractC0106c {

        /* renamed from: a */
        public final /* synthetic */ int f534a;

        /* renamed from: b */
        public final /* synthetic */ int f535b;

        /* renamed from: c */
        public final /* synthetic */ WeakReference f536c;

        public C0165a(int i, int i2, WeakReference weakReference) {
            this.f534a = i;
            this.f535b = i2;
            this.f536c = weakReference;
        }

        @Override // p000.C0103E3.AbstractC0106c
        public void onFontRetrievalFailed(int i) {
        }

        @Override // p000.C0103E3.AbstractC0106c
        public void onFontRetrieved(Typeface typeface) {
            int i;
            if (Build.VERSION.SDK_INT >= 28 && (i = this.f534a) != -1) {
                typeface = Typeface.create(typeface, i, (this.f535b & 2) != 0);
            }
            C0164H0 c0164h0 = C0164H0.this;
            WeakReference weakReference = this.f536c;
            if (c0164h0.f533m) {
                c0164h0.f532l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView != null) {
                    textView.setTypeface(typeface, c0164h0.f530j);
                }
            }
        }
    }

    public C0164H0(TextView textView) {
        this.f521a = textView;
        this.f529i = new C0187I0(textView);
    }

    /* renamed from: c */
    public static C0584Z0 m2424c(Context context, C0032B0 c0032b0, int i) {
        ColorStateList m2577d = c0032b0.m2577d(context, i);
        if (m2577d != null) {
            C0584Z0 c0584z0 = new C0584Z0();
            c0584z0.f2070d = true;
            c0584z0.f2067a = m2577d;
            return c0584z0;
        }
        return null;
    }

    /* renamed from: a */
    public final void m2426a(Drawable drawable, C0584Z0 c0584z0) {
        if (drawable == null || c0584z0 == null) {
            return;
        }
        C0032B0.m2575f(drawable, c0584z0, this.f521a.getDrawableState());
    }

    /* renamed from: b */
    public void m2425b() {
        if (this.f522b != null || this.f523c != null || this.f524d != null || this.f525e != null) {
            Drawable[] compoundDrawables = this.f521a.getCompoundDrawables();
            m2426a(compoundDrawables[0], this.f522b);
            m2426a(compoundDrawables[1], this.f523c);
            m2426a(compoundDrawables[2], this.f524d);
            m2426a(compoundDrawables[3], this.f525e);
        }
        if (this.f526f == null && this.f527g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f521a.getCompoundDrawablesRelative();
        m2426a(compoundDrawablesRelative[0], this.f526f);
        m2426a(compoundDrawablesRelative[2], this.f527g);
    }

    /* renamed from: d */
    public boolean m2423d() {
        C0187I0 c0187i0 = this.f529i;
        return c0187i0.m2398i() && c0187i0.f613a != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0389 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03ed  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:272:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01cc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d7  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2422e(android.util.AttributeSet r23, int r24) {
        /*
            Method dump skipped, instructions count: 1159
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0164H0.m2422e(android.util.AttributeSet, int):void");
    }

    /* renamed from: f */
    public void m2421f(Context context, int i) {
        String m1200n;
        ColorStateList m1211c;
        C0954b1 c0954b1 = new C0954b1(context, context.obtainStyledAttributes(i, C2012o.TextAppearance));
        int i2 = C2012o.TextAppearance_textAllCaps;
        if (c0954b1.m1198p(i2)) {
            this.f521a.setAllCaps(c0954b1.m1213a(i2, false));
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 23) {
            int i4 = C2012o.TextAppearance_android_textColor;
            if (c0954b1.m1198p(i4) && (m1211c = c0954b1.m1211c(i4)) != null) {
                this.f521a.setTextColor(m1211c);
            }
        }
        int i5 = C2012o.TextAppearance_android_textSize;
        if (c0954b1.m1198p(i5) && c0954b1.m1208f(i5, -1) == 0) {
            this.f521a.setTextSize(0, 0.0f);
        }
        m2415l(context, c0954b1);
        if (i3 >= 26) {
            int i6 = C2012o.TextAppearance_fontVariationSettings;
            if (c0954b1.m1198p(i6) && (m1200n = c0954b1.m1200n(i6)) != null) {
                this.f521a.setFontVariationSettings(m1200n);
            }
        }
        c0954b1.f3660b.recycle();
        Typeface typeface = this.f532l;
        if (typeface != null) {
            this.f521a.setTypeface(typeface, this.f530j);
        }
    }

    /* renamed from: g */
    public void m2420g(int i, int i2, int i3, int i4) {
        C0187I0 c0187i0 = this.f529i;
        if (c0187i0.m2398i()) {
            DisplayMetrics displayMetrics = c0187i0.f622j.getResources().getDisplayMetrics();
            c0187i0.m2397j(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (c0187i0.m2400g()) {
                c0187i0.m2406a();
            }
        }
    }

    /* renamed from: h */
    public void m2419h(int[] iArr, int i) {
        C0187I0 c0187i0 = this.f529i;
        if (c0187i0.m2398i()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = c0187i0.f622j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                c0187i0.f618f = c0187i0.m2405b(iArr2);
                if (!c0187i0.m2399h()) {
                    StringBuilder m253r = outline.m253r("None of the preset sizes is valid: ");
                    m253r.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(m253r.toString());
                }
            } else {
                c0187i0.f619g = false;
            }
            if (c0187i0.m2400g()) {
                c0187i0.m2406a();
            }
        }
    }

    /* renamed from: i */
    public void m2418i(int i) {
        C0187I0 c0187i0 = this.f529i;
        if (c0187i0.m2398i()) {
            if (i == 0) {
                c0187i0.f613a = 0;
                c0187i0.f616d = -1.0f;
                c0187i0.f617e = -1.0f;
                c0187i0.f615c = -1.0f;
                c0187i0.f618f = new int[0];
                c0187i0.f614b = false;
            } else if (i == 1) {
                DisplayMetrics displayMetrics = c0187i0.f622j.getResources().getDisplayMetrics();
                c0187i0.m2397j(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (c0187i0.m2400g()) {
                    c0187i0.m2406a();
                }
            } else {
                throw new IllegalArgumentException(outline.m273H("Unknown auto-size text type: ", i));
            }
        }
    }

    /* renamed from: j */
    public void m2417j(ColorStateList colorStateList) {
        if (this.f528h == null) {
            this.f528h = new C0584Z0();
        }
        C0584Z0 c0584z0 = this.f528h;
        c0584z0.f2067a = colorStateList;
        c0584z0.f2070d = colorStateList != null;
        this.f522b = c0584z0;
        this.f523c = c0584z0;
        this.f524d = c0584z0;
        this.f525e = c0584z0;
        this.f526f = c0584z0;
        this.f527g = c0584z0;
    }

    /* renamed from: k */
    public void m2416k(PorterDuff.Mode mode) {
        if (this.f528h == null) {
            this.f528h = new C0584Z0();
        }
        C0584Z0 c0584z0 = this.f528h;
        c0584z0.f2068b = mode;
        c0584z0.f2069c = mode != null;
        this.f522b = c0584z0;
        this.f523c = c0584z0;
        this.f524d = c0584z0;
        this.f525e = c0584z0;
        this.f526f = c0584z0;
        this.f527g = c0584z0;
    }

    /* renamed from: l */
    public final void m2415l(Context context, C0954b1 c0954b1) {
        String m1200n;
        this.f530j = c0954b1.m1204j(C2012o.TextAppearance_android_textStyle, this.f530j);
        int i = Build.VERSION.SDK_INT;
        if (i >= 28) {
            int m1204j = c0954b1.m1204j(C2012o.TextAppearance_android_textFontWeight, -1);
            this.f531k = m1204j;
            if (m1204j != -1) {
                this.f530j = (this.f530j & 2) | 0;
            }
        }
        int i2 = C2012o.TextAppearance_android_fontFamily;
        if (!c0954b1.m1198p(i2) && !c0954b1.m1198p(C2012o.TextAppearance_fontFamily)) {
            int i3 = C2012o.TextAppearance_android_typeface;
            if (c0954b1.m1198p(i3)) {
                this.f533m = false;
                int m1204j2 = c0954b1.m1204j(i3, 1);
                if (m1204j2 == 1) {
                    this.f532l = Typeface.SANS_SERIF;
                    return;
                } else if (m1204j2 == 2) {
                    this.f532l = Typeface.SERIF;
                    return;
                } else if (m1204j2 != 3) {
                    return;
                } else {
                    this.f532l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f532l = null;
        int i4 = C2012o.TextAppearance_fontFamily;
        if (c0954b1.m1198p(i4)) {
            i2 = i4;
        }
        int i5 = this.f531k;
        int i6 = this.f530j;
        if (!context.isRestricted()) {
            try {
                Typeface m1205i = c0954b1.m1205i(i2, this.f530j, new C0165a(i5, i6, new WeakReference(this.f521a)));
                if (m1205i != null) {
                    if (i >= 28 && this.f531k != -1) {
                        this.f532l = Typeface.create(Typeface.create(m1205i, 0), this.f531k, (this.f530j & 2) != 0);
                    } else {
                        this.f532l = m1205i;
                    }
                }
                this.f533m = this.f532l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f532l != null || (m1200n = c0954b1.m1200n(i2)) == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && this.f531k != -1) {
            this.f532l = Typeface.create(Typeface.create(m1200n, 0), this.f531k, (this.f530j & 2) != 0);
        } else {
            this.f532l = Typeface.create(m1200n, this.f530j);
        }
    }
}
