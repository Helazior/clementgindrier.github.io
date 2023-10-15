package p000;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import java.util.Objects;
import p000.C0363Q;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: O */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0321O extends Drawable implements Drawable.Callback {

    /* renamed from: n */
    public static final /* synthetic */ int f1052n = 0;

    /* renamed from: a */
    public AbstractC0324c f1053a;

    /* renamed from: b */
    public Rect f1054b;

    /* renamed from: c */
    public Drawable f1055c;

    /* renamed from: d */
    public Drawable f1056d;

    /* renamed from: g */
    public boolean f1058g;

    /* renamed from: i */
    public boolean f1060i;

    /* renamed from: j */
    public Runnable f1061j;

    /* renamed from: k */
    public long f1062k;

    /* renamed from: l */
    public long f1063l;

    /* renamed from: m */
    public C0323b f1064m;

    /* renamed from: f */
    public int f1057f = 255;

    /* renamed from: h */
    public int f1059h = -1;

    /* renamed from: O$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0322a implements Runnable {
        public RunnableC0322a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0321O.this.m2173a(true);
            C0321O.this.invalidateSelf();
        }
    }

    /* renamed from: O$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0323b implements Drawable.Callback {

        /* renamed from: a */
        public Drawable.Callback f1066a;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f1066a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f1066a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* renamed from: O$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0324c extends Drawable.ConstantState {

        /* renamed from: A */
        public int f1067A;

        /* renamed from: B */
        public int f1068B;

        /* renamed from: C */
        public boolean f1069C;

        /* renamed from: D */
        public ColorFilter f1070D;

        /* renamed from: E */
        public boolean f1071E;

        /* renamed from: F */
        public ColorStateList f1072F;

        /* renamed from: G */
        public PorterDuff.Mode f1073G;

        /* renamed from: H */
        public boolean f1074H;

        /* renamed from: I */
        public boolean f1075I;

        /* renamed from: a */
        public final C0321O f1076a;

        /* renamed from: b */
        public Resources f1077b;

        /* renamed from: c */
        public int f1078c;

        /* renamed from: d */
        public int f1079d;

        /* renamed from: e */
        public int f1080e;

        /* renamed from: f */
        public SparseArray<Drawable.ConstantState> f1081f;

        /* renamed from: g */
        public Drawable[] f1082g;

        /* renamed from: h */
        public int f1083h;

        /* renamed from: i */
        public boolean f1084i;

        /* renamed from: j */
        public boolean f1085j;

        /* renamed from: k */
        public Rect f1086k;

        /* renamed from: l */
        public boolean f1087l;

        /* renamed from: m */
        public boolean f1088m;

        /* renamed from: n */
        public int f1089n;

        /* renamed from: o */
        public int f1090o;

        /* renamed from: p */
        public int f1091p;

        /* renamed from: q */
        public int f1092q;

        /* renamed from: r */
        public boolean f1093r;

        /* renamed from: s */
        public int f1094s;

        /* renamed from: t */
        public boolean f1095t;

        /* renamed from: u */
        public boolean f1096u;

        /* renamed from: v */
        public boolean f1097v;

        /* renamed from: w */
        public boolean f1098w;

        /* renamed from: x */
        public boolean f1099x;

        /* renamed from: y */
        public boolean f1100y;

        /* renamed from: z */
        public int f1101z;

        public AbstractC0324c(AbstractC0324c abstractC0324c, C0321O c0321o, Resources resources) {
            Resources resources2;
            this.f1078c = 160;
            this.f1084i = false;
            this.f1087l = false;
            this.f1099x = true;
            this.f1067A = 0;
            this.f1068B = 0;
            this.f1076a = c0321o;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = abstractC0324c != null ? abstractC0324c.f1077b : null;
            }
            this.f1077b = resources2;
            int i = abstractC0324c != null ? abstractC0324c.f1078c : 0;
            int i2 = C0321O.f1052n;
            i = resources != null ? resources.getDisplayMetrics().densityDpi : i;
            int i3 = i != 0 ? i : 160;
            this.f1078c = i3;
            if (abstractC0324c != null) {
                this.f1079d = abstractC0324c.f1079d;
                this.f1080e = abstractC0324c.f1080e;
                this.f1097v = true;
                this.f1098w = true;
                this.f1084i = abstractC0324c.f1084i;
                this.f1087l = abstractC0324c.f1087l;
                this.f1099x = abstractC0324c.f1099x;
                this.f1100y = abstractC0324c.f1100y;
                this.f1101z = abstractC0324c.f1101z;
                this.f1067A = abstractC0324c.f1067A;
                this.f1068B = abstractC0324c.f1068B;
                this.f1069C = abstractC0324c.f1069C;
                this.f1070D = abstractC0324c.f1070D;
                this.f1071E = abstractC0324c.f1071E;
                this.f1072F = abstractC0324c.f1072F;
                this.f1073G = abstractC0324c.f1073G;
                this.f1074H = abstractC0324c.f1074H;
                this.f1075I = abstractC0324c.f1075I;
                if (abstractC0324c.f1078c == i3) {
                    if (abstractC0324c.f1085j) {
                        this.f1086k = new Rect(abstractC0324c.f1086k);
                        this.f1085j = true;
                    }
                    if (abstractC0324c.f1088m) {
                        this.f1089n = abstractC0324c.f1089n;
                        this.f1090o = abstractC0324c.f1090o;
                        this.f1091p = abstractC0324c.f1091p;
                        this.f1092q = abstractC0324c.f1092q;
                        this.f1088m = true;
                    }
                }
                if (abstractC0324c.f1093r) {
                    this.f1094s = abstractC0324c.f1094s;
                    this.f1093r = true;
                }
                if (abstractC0324c.f1095t) {
                    this.f1096u = abstractC0324c.f1096u;
                    this.f1095t = true;
                }
                Drawable[] drawableArr = abstractC0324c.f1082g;
                this.f1082g = new Drawable[drawableArr.length];
                this.f1083h = abstractC0324c.f1083h;
                SparseArray<Drawable.ConstantState> sparseArray = abstractC0324c.f1081f;
                if (sparseArray != null) {
                    this.f1081f = sparseArray.clone();
                } else {
                    this.f1081f = new SparseArray<>(this.f1083h);
                }
                int i4 = this.f1083h;
                for (int i5 = 0; i5 < i4; i5++) {
                    if (drawableArr[i5] != null) {
                        Drawable.ConstantState constantState = drawableArr[i5].getConstantState();
                        if (constantState != null) {
                            this.f1081f.put(i5, constantState);
                        } else {
                            this.f1082g[i5] = drawableArr[i5];
                        }
                    }
                }
                return;
            }
            this.f1082g = new Drawable[10];
            this.f1083h = 0;
        }

        /* renamed from: a */
        public final int m2170a(Drawable drawable) {
            int i = this.f1083h;
            if (i >= this.f1082g.length) {
                int i2 = i + 10;
                C0363Q.C0364a c0364a = (C0363Q.C0364a) this;
                Drawable[] drawableArr = new Drawable[i2];
                System.arraycopy(c0364a.f1082g, 0, drawableArr, 0, i);
                c0364a.f1082g = drawableArr;
                int[][] iArr = new int[i2];
                System.arraycopy(c0364a.f1246J, 0, iArr, 0, i);
                c0364a.f1246J = iArr;
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1076a);
            this.f1082g[i] = drawable;
            this.f1083h++;
            this.f1080e = drawable.getChangingConfigurations() | this.f1080e;
            this.f1093r = false;
            this.f1095t = false;
            this.f1086k = null;
            this.f1085j = false;
            this.f1088m = false;
            this.f1097v = false;
            return i;
        }

        /* renamed from: b */
        public void m2169b() {
            this.f1088m = true;
            m2168c();
            int i = this.f1083h;
            Drawable[] drawableArr = this.f1082g;
            this.f1090o = -1;
            this.f1089n = -1;
            this.f1092q = 0;
            this.f1091p = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f1089n) {
                    this.f1089n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f1090o) {
                    this.f1090o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f1091p) {
                    this.f1091p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f1092q) {
                    this.f1092q = minimumHeight;
                }
            }
        }

        /* renamed from: c */
        public final void m2168c() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f1081f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    int keyAt = this.f1081f.keyAt(i);
                    Drawable[] drawableArr = this.f1082g;
                    Drawable newDrawable = this.f1081f.valueAt(i).newDrawable(this.f1077b);
                    if (Build.VERSION.SDK_INT >= 23) {
                        newDrawable.setLayoutDirection(this.f1101z);
                    }
                    Drawable mutate = newDrawable.mutate();
                    mutate.setCallback(this.f1076a);
                    drawableArr[keyAt] = mutate;
                }
                this.f1081f = null;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.f1083h;
            Drawable[] drawableArr = this.f1082g;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f1081f.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: d */
        public final Drawable m2167d(int i) {
            int indexOfKey;
            Drawable drawable = this.f1082g[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f1081f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable newDrawable = this.f1081f.valueAt(indexOfKey).newDrawable(this.f1077b);
            if (Build.VERSION.SDK_INT >= 23) {
                newDrawable.setLayoutDirection(this.f1101z);
            }
            Drawable mutate = newDrawable.mutate();
            mutate.setCallback(this.f1076a);
            this.f1082g[i] = mutate;
            this.f1081f.removeAt(indexOfKey);
            if (this.f1081f.size() == 0) {
                this.f1081f = null;
            }
            return mutate;
        }

        /* renamed from: e */
        public abstract void mo2144e();

        /* renamed from: f */
        public final void m2166f(Resources resources) {
            if (resources != null) {
                this.f1077b = resources;
                int i = C0321O.f1052n;
                int i2 = resources.getDisplayMetrics().densityDpi;
                if (i2 == 0) {
                    i2 = 160;
                }
                int i3 = this.f1078c;
                this.f1078c = i2;
                if (i3 != i2) {
                    this.f1088m = false;
                    this.f1085j = false;
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1079d | this.f1080e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2173a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f1058g = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f1055c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f1062k
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f1057f
            r3.setAlpha(r9)
            r13.f1062k = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            O$c r9 = r13.f1053a
            int r9 = r9.f1067A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f1057f
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f1062k = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f1056d
            if (r9 == 0) goto L65
            long r10 = r13.f1063l
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f1056d = r0
            r13.f1063l = r7
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            O$c r4 = r13.f1053a
            int r4 = r4.f1068B
            int r3 = r3 / r4
            int r4 = r13.f1057f
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f1063l = r7
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.f1061j
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0321O.m2173a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        AbstractC0324c abstractC0324c = this.f1053a;
        Objects.requireNonNull(abstractC0324c);
        if (theme != null) {
            abstractC0324c.m2168c();
            int i = abstractC0324c.f1083h;
            Drawable[] drawableArr = abstractC0324c.f1082g;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                    drawableArr[i2].applyTheme(theme);
                    abstractC0324c.f1080e |= drawableArr[i2].getChangingConfigurations();
                }
            }
            abstractC0324c.m2166f(theme.getResources());
        }
    }

    /* renamed from: b */
    public AbstractC0324c mo2147b() {
        throw null;
    }

    /* renamed from: c */
    public final void m2172c(Drawable drawable) {
        if (this.f1064m == null) {
            this.f1064m = new C0323b();
        }
        C0323b c0323b = this.f1064m;
        c0323b.f1066a = drawable.getCallback();
        drawable.setCallback(c0323b);
        try {
            if (this.f1053a.f1067A <= 0 && this.f1058g) {
                drawable.setAlpha(this.f1057f);
            }
            AbstractC0324c abstractC0324c = this.f1053a;
            if (abstractC0324c.f1071E) {
                drawable.setColorFilter(abstractC0324c.f1070D);
            } else {
                if (abstractC0324c.f1074H) {
                    drawable.setTintList(abstractC0324c.f1072F);
                }
                AbstractC0324c abstractC0324c2 = this.f1053a;
                if (abstractC0324c2.f1075I) {
                    drawable.setTintMode(abstractC0324c2.f1073G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1053a.f1099x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            drawable.setAutoMirrored(this.f1053a.f1069C);
            Rect rect = this.f1054b;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            C0323b c0323b2 = this.f1064m;
            Drawable.Callback callback = c0323b2.f1066a;
            c0323b2.f1066a = null;
            drawable.setCallback(callback);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f1053a.canApplyTheme();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m2171d(int r10) {
        /*
            r9 = this;
            int r0 = r9.f1059h
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            O$c r0 = r9.f1053a
            int r0 = r0.f1068B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f1056d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f1055c
            if (r0 == 0) goto L29
            r9.f1056d = r0
            O$c r0 = r9.f1053a
            int r0 = r0.f1068B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f1063l = r0
            goto L35
        L29:
            r9.f1056d = r4
            r9.f1063l = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f1055c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            O$c r0 = r9.f1053a
            int r1 = r0.f1083h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.m2167d(r10)
            r9.f1055c = r0
            r9.f1059h = r10
            if (r0 == 0) goto L5a
            O$c r10 = r9.f1053a
            int r10 = r10.f1067A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f1062k = r2
        L51:
            r9.m2172c(r0)
            goto L5a
        L55:
            r9.f1055c = r4
            r10 = -1
            r9.f1059h = r10
        L5a:
            long r0 = r9.f1062k
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f1063l
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f1061j
            if (r0 != 0) goto L73
            O$a r0 = new O$a
            r0.<init>()
            r9.f1061j = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.m2173a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0321O.m2171d(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1055c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f1056d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* renamed from: e */
    public void mo2146e(AbstractC0324c abstractC0324c) {
        throw null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1057f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1053a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z;
        AbstractC0324c abstractC0324c = this.f1053a;
        synchronized (abstractC0324c) {
            z = false;
            if (abstractC0324c.f1097v) {
                z = abstractC0324c.f1098w;
            } else {
                abstractC0324c.m2168c();
                abstractC0324c.f1097v = true;
                int i = abstractC0324c.f1083h;
                Drawable[] drawableArr = abstractC0324c.f1082g;
                int i2 = 0;
                while (true) {
                    if (i2 < i) {
                        if (drawableArr[i2].getConstantState() == null) {
                            abstractC0324c.f1098w = false;
                            break;
                        }
                        i2++;
                    } else {
                        abstractC0324c.f1098w = true;
                        z = true;
                        break;
                    }
                }
            }
        }
        if (z) {
            this.f1053a.f1079d = getChangingConfigurations();
            return this.f1053a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1055c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f1054b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        AbstractC0324c abstractC0324c = this.f1053a;
        if (abstractC0324c.f1087l) {
            if (!abstractC0324c.f1088m) {
                abstractC0324c.m2169b();
            }
            return abstractC0324c.f1090o;
        }
        Drawable drawable = this.f1055c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        AbstractC0324c abstractC0324c = this.f1053a;
        if (abstractC0324c.f1087l) {
            if (!abstractC0324c.f1088m) {
                abstractC0324c.m2169b();
            }
            return abstractC0324c.f1089n;
        }
        Drawable drawable = this.f1055c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        AbstractC0324c abstractC0324c = this.f1053a;
        if (abstractC0324c.f1087l) {
            if (!abstractC0324c.f1088m) {
                abstractC0324c.m2169b();
            }
            return abstractC0324c.f1092q;
        }
        Drawable drawable = this.f1055c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        AbstractC0324c abstractC0324c = this.f1053a;
        if (abstractC0324c.f1087l) {
            if (!abstractC0324c.f1088m) {
                abstractC0324c.m2169b();
            }
            return abstractC0324c.f1091p;
        }
        Drawable drawable = this.f1055c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1055c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        AbstractC0324c abstractC0324c = this.f1053a;
        if (abstractC0324c.f1093r) {
            return abstractC0324c.f1094s;
        }
        abstractC0324c.m2168c();
        int i = abstractC0324c.f1083h;
        Drawable[] drawableArr = abstractC0324c.f1082g;
        int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
        for (int i2 = 1; i2 < i; i2++) {
            opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
        }
        abstractC0324c.f1094s = opacity;
        abstractC0324c.f1093r = true;
        return opacity;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f1055c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        AbstractC0324c abstractC0324c = this.f1053a;
        Rect rect2 = null;
        boolean z = true;
        if (!abstractC0324c.f1084i) {
            Rect rect3 = abstractC0324c.f1086k;
            if (rect3 != null || abstractC0324c.f1085j) {
                rect2 = rect3;
            } else {
                abstractC0324c.m2168c();
                Rect rect4 = new Rect();
                int i = abstractC0324c.f1083h;
                Drawable[] drawableArr = abstractC0324c.f1082g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect4.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect4.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect4.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect4.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                abstractC0324c.f1085j = true;
                abstractC0324c.f1086k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            padding = (((rect2.left | rect2.top) | rect2.bottom) | rect2.right) != 0;
        } else {
            Drawable drawable = this.f1055c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if ((this.f1053a.f1069C && LayoutInflater$Factory2C0000A.C0010h.m2676B(this) == 1) ? false : false) {
            int i7 = rect.left;
            rect.left = rect.right;
            rect.right = i7;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        AbstractC0324c abstractC0324c = this.f1053a;
        if (abstractC0324c != null) {
            abstractC0324c.f1093r = false;
            abstractC0324c.f1095t = false;
        }
        if (drawable != this.f1055c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1053a.f1069C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f1056d;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f1056d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f1055c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1058g) {
                this.f1055c.setAlpha(this.f1057f);
            }
        }
        if (this.f1063l != 0) {
            this.f1063l = 0L;
            z = true;
        }
        if (this.f1062k != 0) {
            this.f1062k = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1060i && super.mutate() == this) {
            AbstractC0324c mo2147b = mo2147b();
            mo2147b.mo2144e();
            mo2146e(mo2147b);
            this.f1060i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1056d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1055c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        AbstractC0324c abstractC0324c = this.f1053a;
        int i2 = this.f1059h;
        int i3 = abstractC0324c.f1083h;
        Drawable[] drawableArr = abstractC0324c.f1082g;
        boolean z = false;
        for (int i4 = 0; i4 < i3; i4++) {
            if (drawableArr[i4] != null) {
                boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                if (i4 == i2) {
                    z = layoutDirection;
                }
            }
        }
        abstractC0324c.f1101z = i;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f1056d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f1055c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1056d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1055c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f1055c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f1058g && this.f1057f == i) {
            return;
        }
        this.f1058g = true;
        this.f1057f = i;
        Drawable drawable = this.f1055c;
        if (drawable != null) {
            if (this.f1062k == 0) {
                drawable.setAlpha(i);
            } else {
                m2173a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        AbstractC0324c abstractC0324c = this.f1053a;
        if (abstractC0324c.f1069C != z) {
            abstractC0324c.f1069C = z;
            Drawable drawable = this.f1055c;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        AbstractC0324c abstractC0324c = this.f1053a;
        abstractC0324c.f1071E = true;
        if (abstractC0324c.f1070D != colorFilter) {
            abstractC0324c.f1070D = colorFilter;
            Drawable drawable = this.f1055c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        AbstractC0324c abstractC0324c = this.f1053a;
        if (abstractC0324c.f1099x != z) {
            abstractC0324c.f1099x = z;
            Drawable drawable = this.f1055c;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f1055c;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f1054b;
        if (rect == null) {
            this.f1054b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f1055c;
        if (drawable != null) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        AbstractC0324c abstractC0324c = this.f1053a;
        abstractC0324c.f1074H = true;
        if (abstractC0324c.f1072F != colorStateList) {
            abstractC0324c.f1072F = colorStateList;
            LayoutInflater$Factory2C0000A.C0010h.m2620p0(this.f1055c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        AbstractC0324c abstractC0324c = this.f1053a;
        abstractC0324c.f1075I = true;
        if (abstractC0324c.f1073G != mode) {
            abstractC0324c.f1073G = mode;
            LayoutInflater$Factory2C0000A.C0010h.m2618q0(this.f1055c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f1056d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f1055c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f1055c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
