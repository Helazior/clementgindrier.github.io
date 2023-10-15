package p000;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.Objects;
import org.xmlpull.p019v1.XmlPullParser;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: h8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1865h8 extends AbstractC1842g8 {

    /* renamed from: k */
    public static final PorterDuff.Mode f5150k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    public C1873h f5151b;

    /* renamed from: c */
    public PorterDuffColorFilter f5152c;

    /* renamed from: d */
    public ColorFilter f5153d;

    /* renamed from: f */
    public boolean f5154f;

    /* renamed from: g */
    public boolean f5155g;

    /* renamed from: h */
    public final float[] f5156h;

    /* renamed from: i */
    public final Matrix f5157i;

    /* renamed from: j */
    public final Rect f5158j;

    /* renamed from: h8$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1867b extends AbstractC1871f {
        public C1867b() {
        }

        @Override // p000.C1865h8.AbstractC1871f
        /* renamed from: c */
        public boolean mo761c() {
            return true;
        }

        public C1867b(C1867b c1867b) {
            super(c1867b);
        }
    }

    /* renamed from: h8$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC1870e {
        public AbstractC1870e() {
        }

        /* renamed from: a */
        public boolean mo763a() {
            return false;
        }

        /* renamed from: b */
        public boolean mo762b(int[] iArr) {
            return false;
        }

        public AbstractC1870e(C1866a c1866a) {
        }
    }

    /* renamed from: h8$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1873h extends Drawable.ConstantState {

        /* renamed from: a */
        public int f5205a;

        /* renamed from: b */
        public C1872g f5206b;

        /* renamed from: c */
        public ColorStateList f5207c;

        /* renamed from: d */
        public PorterDuff.Mode f5208d;

        /* renamed from: e */
        public boolean f5209e;

        /* renamed from: f */
        public Bitmap f5210f;

        /* renamed from: g */
        public ColorStateList f5211g;

        /* renamed from: h */
        public PorterDuff.Mode f5212h;

        /* renamed from: i */
        public int f5213i;

        /* renamed from: j */
        public boolean f5214j;

        /* renamed from: k */
        public boolean f5215k;

        /* renamed from: l */
        public Paint f5216l;

        public C1873h(C1873h c1873h) {
            this.f5207c = null;
            this.f5208d = C1865h8.f5150k;
            if (c1873h != null) {
                this.f5205a = c1873h.f5205a;
                C1872g c1872g = new C1872g(c1873h.f5206b);
                this.f5206b = c1872g;
                if (c1873h.f5206b.f5193e != null) {
                    c1872g.f5193e = new Paint(c1873h.f5206b.f5193e);
                }
                if (c1873h.f5206b.f5192d != null) {
                    this.f5206b.f5192d = new Paint(c1873h.f5206b.f5192d);
                }
                this.f5207c = c1873h.f5207c;
                this.f5208d = c1873h.f5208d;
                this.f5209e = c1873h.f5209e;
            }
        }

        /* renamed from: a */
        public boolean m759a() {
            C1872g c1872g = this.f5206b;
            if (c1872g.f5203o == null) {
                c1872g.f5203o = Boolean.valueOf(c1872g.f5196h.mo763a());
            }
            return c1872g.f5203o.booleanValue();
        }

        /* renamed from: b */
        public void m758b(int i, int i2) {
            this.f5210f.eraseColor(0);
            Canvas canvas = new Canvas(this.f5210f);
            C1872g c1872g = this.f5206b;
            c1872g.m760a(c1872g.f5196h, C1872g.f5188q, canvas, i, i2, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f5205a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C1865h8(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C1865h8(this);
        }

        public C1873h() {
            this.f5207c = null;
            this.f5208d = C1865h8.f5150k;
            this.f5206b = new C1872g();
        }
    }

    public C1865h8() {
        this.f5155g = true;
        this.f5156h = new float[9];
        this.f5157i = new Matrix();
        this.f5158j = new Rect();
        this.f5151b = new C1873h();
    }

    /* renamed from: a */
    public static C1865h8 m766a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C1865h8 c1865h8 = new C1865h8();
        c1865h8.inflate(resources, xmlPullParser, attributeSet, theme);
        return c1865h8;
    }

    /* renamed from: b */
    public PorterDuffColorFilter m765b(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.canApplyTheme();
            return false;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d3, code lost:
        if ((r1 == r7.getWidth() && r3 == r6.f5210f.getHeight()) == false) goto L66;
     */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1865h8.draw(android.graphics.Canvas):void");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.f5151b.f5206b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f5151b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.f5153d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f5086a != null && Build.VERSION.SDK_INT >= 24) {
            return new C1874i(this.f5086a.getConstantState());
        }
        this.f5151b.f5205a = getChangingConfigurations();
        return this.f5151b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f5151b.f5206b.f5198j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f5151b.f5206b.f5197i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.f5151b.f5209e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C1873h c1873h;
        ColorStateList colorStateList;
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((c1873h = this.f5151b) != null && (c1873h.m759a() || ((colorStateList = this.f5151b.f5207c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f5154f && super.mutate() == this) {
            this.f5151b = new C1873h(this.f5151b);
            this.f5154f = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C1873h c1873h = this.f5151b;
        ColorStateList colorStateList = c1873h.f5207c;
        if (colorStateList != null && (mode = c1873h.f5208d) != null) {
            this.f5152c = m765b(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (c1873h.m759a()) {
            boolean mo762b = c1873h.f5206b.f5196h.mo762b(iArr);
            c1873h.f5215k |= mo762b;
            if (mo762b) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f5151b.f5206b.getRootAlpha() != i) {
            this.f5151b.f5206b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
        } else {
            this.f5151b.f5209e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f5153d = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            LayoutInflater$Factory2C0000A.C0010h.m2622o0(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            LayoutInflater$Factory2C0000A.C0010h.m2620p0(drawable, colorStateList);
            return;
        }
        C1873h c1873h = this.f5151b;
        if (c1873h.f5207c != colorStateList) {
            c1873h.f5207c = colorStateList;
            this.f5152c = m765b(colorStateList, c1873h.f5208d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            LayoutInflater$Factory2C0000A.C0010h.m2618q0(drawable, mode);
            return;
        }
        C1873h c1873h = this.f5151b;
        if (c1873h.f5208d != mode) {
            c1873h.f5208d = mode;
            this.f5152c = m765b(c1873h.f5207c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* renamed from: h8$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1874i extends Drawable.ConstantState {

        /* renamed from: a */
        public final Drawable.ConstantState f5217a;

        public C1874i(Drawable.ConstantState constantState) {
            this.f5217a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f5217a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f5217a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C1865h8 c1865h8 = new C1865h8();
            c1865h8.f5086a = (VectorDrawable) this.f5217a.newDrawable();
            return c1865h8;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            C1865h8 c1865h8 = new C1865h8();
            c1865h8.f5086a = (VectorDrawable) this.f5217a.newDrawable(resources);
            return c1865h8;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C1865h8 c1865h8 = new C1865h8();
            c1865h8.f5086a = (VectorDrawable) this.f5217a.newDrawable(resources, theme);
            return c1865h8;
        }
    }

    /* renamed from: h8$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC1871f extends AbstractC1870e {

        /* renamed from: a */
        public C0194I3[] f5184a;

        /* renamed from: b */
        public String f5185b;

        /* renamed from: c */
        public int f5186c;

        /* renamed from: d */
        public int f5187d;

        public AbstractC1871f() {
            super(null);
            this.f5184a = null;
            this.f5186c = 0;
        }

        /* renamed from: c */
        public boolean mo761c() {
            return false;
        }

        public C0194I3[] getPathData() {
            return this.f5184a;
        }

        public String getPathName() {
            return this.f5185b;
        }

        public void setPathData(C0194I3[] c0194i3Arr) {
            if (!LayoutInflater$Factory2C0000A.C0010h.m2641f(this.f5184a, c0194i3Arr)) {
                this.f5184a = LayoutInflater$Factory2C0000A.C0010h.m2611u(c0194i3Arr);
                return;
            }
            C0194I3[] c0194i3Arr2 = this.f5184a;
            for (int i = 0; i < c0194i3Arr.length; i++) {
                c0194i3Arr2[i].f632a = c0194i3Arr[i].f632a;
                for (int i2 = 0; i2 < c0194i3Arr[i].f633b.length; i2++) {
                    c0194i3Arr2[i].f633b[i2] = c0194i3Arr[i].f633b[i2];
                }
            }
        }

        public AbstractC1871f(AbstractC1871f abstractC1871f) {
            super(null);
            this.f5184a = null;
            this.f5186c = 0;
            this.f5185b = abstractC1871f.f5185b;
            this.f5187d = abstractC1871f.f5187d;
            this.f5184a = LayoutInflater$Factory2C0000A.C0010h.m2611u(abstractC1871f.f5184a);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f9  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void inflate(android.content.res.Resources r28, org.xmlpull.p019v1.XmlPullParser r29, android.util.AttributeSet r30, android.content.res.Resources.Theme r31) {
        /*
            Method dump skipped, instructions count: 1282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1865h8.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    public C1865h8(C1873h c1873h) {
        this.f5155g = true;
        this.f5156h = new float[9];
        this.f5157i = new Matrix();
        this.f5158j = new Rect();
        this.f5151b = c1873h;
        this.f5152c = m765b(c1873h.f5207c, c1873h.f5208d);
    }

    /* renamed from: h8$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1868c extends AbstractC1871f {

        /* renamed from: e */
        public int[] f5159e;

        /* renamed from: f */
        public C2364y3 f5160f;

        /* renamed from: g */
        public float f5161g;

        /* renamed from: h */
        public C2364y3 f5162h;

        /* renamed from: i */
        public float f5163i;

        /* renamed from: j */
        public float f5164j;

        /* renamed from: k */
        public float f5165k;

        /* renamed from: l */
        public float f5166l;

        /* renamed from: m */
        public float f5167m;

        /* renamed from: n */
        public Paint.Cap f5168n;

        /* renamed from: o */
        public Paint.Join f5169o;

        /* renamed from: p */
        public float f5170p;

        public C1868c() {
            this.f5161g = 0.0f;
            this.f5163i = 1.0f;
            this.f5164j = 1.0f;
            this.f5165k = 0.0f;
            this.f5166l = 1.0f;
            this.f5167m = 0.0f;
            this.f5168n = Paint.Cap.BUTT;
            this.f5169o = Paint.Join.MITER;
            this.f5170p = 4.0f;
        }

        @Override // p000.C1865h8.AbstractC1870e
        /* renamed from: a */
        public boolean mo763a() {
            return this.f5162h.m61c() || this.f5160f.m61c();
        }

        @Override // p000.C1865h8.AbstractC1870e
        /* renamed from: b */
        public boolean mo762b(int[] iArr) {
            return this.f5160f.m60d(iArr) | this.f5162h.m60d(iArr);
        }

        public float getFillAlpha() {
            return this.f5164j;
        }

        public int getFillColor() {
            return this.f5162h.f6856c;
        }

        public float getStrokeAlpha() {
            return this.f5163i;
        }

        public int getStrokeColor() {
            return this.f5160f.f6856c;
        }

        public float getStrokeWidth() {
            return this.f5161g;
        }

        public float getTrimPathEnd() {
            return this.f5166l;
        }

        public float getTrimPathOffset() {
            return this.f5167m;
        }

        public float getTrimPathStart() {
            return this.f5165k;
        }

        public void setFillAlpha(float f) {
            this.f5164j = f;
        }

        public void setFillColor(int i) {
            this.f5162h.f6856c = i;
        }

        public void setStrokeAlpha(float f) {
            this.f5163i = f;
        }

        public void setStrokeColor(int i) {
            this.f5160f.f6856c = i;
        }

        public void setStrokeWidth(float f) {
            this.f5161g = f;
        }

        public void setTrimPathEnd(float f) {
            this.f5166l = f;
        }

        public void setTrimPathOffset(float f) {
            this.f5167m = f;
        }

        public void setTrimPathStart(float f) {
            this.f5165k = f;
        }

        public C1868c(C1868c c1868c) {
            super(c1868c);
            this.f5161g = 0.0f;
            this.f5163i = 1.0f;
            this.f5164j = 1.0f;
            this.f5165k = 0.0f;
            this.f5166l = 1.0f;
            this.f5167m = 0.0f;
            this.f5168n = Paint.Cap.BUTT;
            this.f5169o = Paint.Join.MITER;
            this.f5170p = 4.0f;
            this.f5159e = c1868c.f5159e;
            this.f5160f = c1868c.f5160f;
            this.f5161g = c1868c.f5161g;
            this.f5163i = c1868c.f5163i;
            this.f5162h = c1868c.f5162h;
            this.f5186c = c1868c.f5186c;
            this.f5164j = c1868c.f5164j;
            this.f5165k = c1868c.f5165k;
            this.f5166l = c1868c.f5166l;
            this.f5167m = c1868c.f5167m;
            this.f5168n = c1868c.f5168n;
            this.f5169o = c1868c.f5169o;
            this.f5170p = c1868c.f5170p;
        }
    }

    /* renamed from: h8$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1872g {

        /* renamed from: q */
        public static final Matrix f5188q = new Matrix();

        /* renamed from: a */
        public final Path f5189a;

        /* renamed from: b */
        public final Path f5190b;

        /* renamed from: c */
        public final Matrix f5191c;

        /* renamed from: d */
        public Paint f5192d;

        /* renamed from: e */
        public Paint f5193e;

        /* renamed from: f */
        public PathMeasure f5194f;

        /* renamed from: g */
        public int f5195g;

        /* renamed from: h */
        public final C1869d f5196h;

        /* renamed from: i */
        public float f5197i;

        /* renamed from: j */
        public float f5198j;

        /* renamed from: k */
        public float f5199k;

        /* renamed from: l */
        public float f5200l;

        /* renamed from: m */
        public int f5201m;

        /* renamed from: n */
        public String f5202n;

        /* renamed from: o */
        public Boolean f5203o;

        /* renamed from: p */
        public final C2339x1<String, Object> f5204p;

        public C1872g() {
            this.f5191c = new Matrix();
            this.f5197i = 0.0f;
            this.f5198j = 0.0f;
            this.f5199k = 0.0f;
            this.f5200l = 0.0f;
            this.f5201m = 255;
            this.f5202n = null;
            this.f5203o = null;
            this.f5204p = new C2339x1<>();
            this.f5196h = new C1869d();
            this.f5189a = new Path();
            this.f5190b = new Path();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r11v18 */
        /* renamed from: a */
        public final void m760a(C1869d c1869d, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            C1872g c1872g;
            C1872g c1872g2 = this;
            c1869d.f5171a.set(matrix);
            c1869d.f5171a.preConcat(c1869d.f5180j);
            canvas.save();
            ?? r11 = 0;
            int i3 = 0;
            while (i3 < c1869d.f5172b.size()) {
                AbstractC1870e abstractC1870e = c1869d.f5172b.get(i3);
                if (abstractC1870e instanceof C1869d) {
                    m760a((C1869d) abstractC1870e, c1869d.f5171a, canvas, i, i2, colorFilter);
                } else if (abstractC1870e instanceof AbstractC1871f) {
                    AbstractC1871f abstractC1871f = (AbstractC1871f) abstractC1870e;
                    float f = i / c1872g2.f5199k;
                    float f2 = i2 / c1872g2.f5200l;
                    float min = Math.min(f, f2);
                    Matrix matrix2 = c1869d.f5171a;
                    c1872g2.f5191c.set(matrix2);
                    c1872g2.f5191c.postScale(f, f2);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix2.mapVectors(fArr);
                    float f3 = (fArr[r11] * fArr[3]) - (fArr[1] * fArr[2]);
                    float max = Math.max((float) Math.hypot(fArr[r11], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
                    float abs = max > 0.0f ? Math.abs(f3) / max : 0.0f;
                    if (abs == 0.0f) {
                        c1872g = this;
                    } else {
                        c1872g = this;
                        Path path = c1872g.f5189a;
                        Objects.requireNonNull(abstractC1871f);
                        path.reset();
                        C0194I3[] c0194i3Arr = abstractC1871f.f5184a;
                        if (c0194i3Arr != null) {
                            C0194I3.m2387b(c0194i3Arr, path);
                        }
                        Path path2 = c1872g.f5189a;
                        c1872g.f5190b.reset();
                        if (abstractC1871f.mo761c()) {
                            c1872g.f5190b.setFillType(abstractC1871f.f5186c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            c1872g.f5190b.addPath(path2, c1872g.f5191c);
                            canvas.clipPath(c1872g.f5190b);
                        } else {
                            C1868c c1868c = (C1868c) abstractC1871f;
                            float f4 = c1868c.f5165k;
                            if (f4 != 0.0f || c1868c.f5166l != 1.0f) {
                                float f5 = c1868c.f5167m;
                                float f6 = (f4 + f5) % 1.0f;
                                float f7 = (c1868c.f5166l + f5) % 1.0f;
                                if (c1872g.f5194f == null) {
                                    c1872g.f5194f = new PathMeasure();
                                }
                                c1872g.f5194f.setPath(c1872g.f5189a, r11);
                                float length = c1872g.f5194f.getLength();
                                float f8 = f6 * length;
                                float f9 = f7 * length;
                                path2.reset();
                                if (f8 > f9) {
                                    c1872g.f5194f.getSegment(f8, length, path2, true);
                                    c1872g.f5194f.getSegment(0.0f, f9, path2, true);
                                } else {
                                    c1872g.f5194f.getSegment(f8, f9, path2, true);
                                }
                                path2.rLineTo(0.0f, 0.0f);
                            }
                            c1872g.f5190b.addPath(path2, c1872g.f5191c);
                            C2364y3 c2364y3 = c1868c.f5162h;
                            if (c2364y3.m62b() || c2364y3.f6856c != 0) {
                                C2364y3 c2364y32 = c1868c.f5162h;
                                if (c1872g.f5193e == null) {
                                    Paint paint = new Paint(1);
                                    c1872g.f5193e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                }
                                Paint paint2 = c1872g.f5193e;
                                if (c2364y32.m62b()) {
                                    Shader shader = c2364y32.f6854a;
                                    shader.setLocalMatrix(c1872g.f5191c);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(c1868c.f5164j * 255.0f));
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i4 = c2364y32.f6856c;
                                    float f10 = c1868c.f5164j;
                                    PorterDuff.Mode mode = C1865h8.f5150k;
                                    paint2.setColor((i4 & 16777215) | (((int) (Color.alpha(i4) * f10)) << 24));
                                }
                                paint2.setColorFilter(colorFilter);
                                c1872g.f5190b.setFillType(c1868c.f5186c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(c1872g.f5190b, paint2);
                            }
                            C2364y3 c2364y33 = c1868c.f5160f;
                            if (c2364y33.m62b() || c2364y33.f6856c != 0) {
                                C2364y3 c2364y34 = c1868c.f5160f;
                                if (c1872g.f5192d == null) {
                                    Paint paint3 = new Paint(1);
                                    c1872g.f5192d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = c1872g.f5192d;
                                Paint.Join join = c1868c.f5169o;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = c1868c.f5168n;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(c1868c.f5170p);
                                if (c2364y34.m62b()) {
                                    Shader shader2 = c2364y34.f6854a;
                                    shader2.setLocalMatrix(c1872g.f5191c);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(c1868c.f5163i * 255.0f));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i5 = c2364y34.f6856c;
                                    float f11 = c1868c.f5163i;
                                    PorterDuff.Mode mode2 = C1865h8.f5150k;
                                    paint4.setColor((i5 & 16777215) | (((int) (Color.alpha(i5) * f11)) << 24));
                                }
                                paint4.setColorFilter(colorFilter);
                                paint4.setStrokeWidth(c1868c.f5161g * abs * min);
                                canvas.drawPath(c1872g.f5190b, paint4);
                            }
                        }
                    }
                    i3++;
                    c1872g2 = c1872g;
                    r11 = 0;
                }
                c1872g = c1872g2;
                i3++;
                c1872g2 = c1872g;
                r11 = 0;
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f5201m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f5201m = i;
        }

        public C1872g(C1872g c1872g) {
            this.f5191c = new Matrix();
            this.f5197i = 0.0f;
            this.f5198j = 0.0f;
            this.f5199k = 0.0f;
            this.f5200l = 0.0f;
            this.f5201m = 255;
            this.f5202n = null;
            this.f5203o = null;
            C2339x1<String, Object> c2339x1 = new C2339x1<>();
            this.f5204p = c2339x1;
            this.f5196h = new C1869d(c1872g.f5196h, c2339x1);
            this.f5189a = new Path(c1872g.f5189a);
            this.f5190b = new Path(c1872g.f5190b);
            this.f5197i = c1872g.f5197i;
            this.f5198j = c1872g.f5198j;
            this.f5199k = c1872g.f5199k;
            this.f5200l = c1872g.f5200l;
            this.f5195g = c1872g.f5195g;
            this.f5201m = c1872g.f5201m;
            this.f5202n = c1872g.f5202n;
            String str = c1872g.f5202n;
            if (str != null) {
                c2339x1.put(str, this);
            }
            this.f5203o = c1872g.f5203o;
        }
    }

    /* renamed from: h8$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1869d extends AbstractC1870e {

        /* renamed from: a */
        public final Matrix f5171a;

        /* renamed from: b */
        public final ArrayList<AbstractC1870e> f5172b;

        /* renamed from: c */
        public float f5173c;

        /* renamed from: d */
        public float f5174d;

        /* renamed from: e */
        public float f5175e;

        /* renamed from: f */
        public float f5176f;

        /* renamed from: g */
        public float f5177g;

        /* renamed from: h */
        public float f5178h;

        /* renamed from: i */
        public float f5179i;

        /* renamed from: j */
        public final Matrix f5180j;

        /* renamed from: k */
        public int f5181k;

        /* renamed from: l */
        public int[] f5182l;

        /* renamed from: m */
        public String f5183m;

        public C1869d(C1869d c1869d, C2339x1<String, Object> c2339x1) {
            super(null);
            AbstractC1871f c1867b;
            this.f5171a = new Matrix();
            this.f5172b = new ArrayList<>();
            this.f5173c = 0.0f;
            this.f5174d = 0.0f;
            this.f5175e = 0.0f;
            this.f5176f = 1.0f;
            this.f5177g = 1.0f;
            this.f5178h = 0.0f;
            this.f5179i = 0.0f;
            Matrix matrix = new Matrix();
            this.f5180j = matrix;
            this.f5183m = null;
            this.f5173c = c1869d.f5173c;
            this.f5174d = c1869d.f5174d;
            this.f5175e = c1869d.f5175e;
            this.f5176f = c1869d.f5176f;
            this.f5177g = c1869d.f5177g;
            this.f5178h = c1869d.f5178h;
            this.f5179i = c1869d.f5179i;
            this.f5182l = c1869d.f5182l;
            String str = c1869d.f5183m;
            this.f5183m = str;
            this.f5181k = c1869d.f5181k;
            if (str != null) {
                c2339x1.put(str, this);
            }
            matrix.set(c1869d.f5180j);
            ArrayList<AbstractC1870e> arrayList = c1869d.f5172b;
            for (int i = 0; i < arrayList.size(); i++) {
                AbstractC1870e abstractC1870e = arrayList.get(i);
                if (abstractC1870e instanceof C1869d) {
                    this.f5172b.add(new C1869d((C1869d) abstractC1870e, c2339x1));
                } else {
                    if (abstractC1870e instanceof C1868c) {
                        c1867b = new C1868c((C1868c) abstractC1870e);
                    } else if (abstractC1870e instanceof C1867b) {
                        c1867b = new C1867b((C1867b) abstractC1870e);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f5172b.add(c1867b);
                    String str2 = c1867b.f5185b;
                    if (str2 != null) {
                        c2339x1.put(str2, c1867b);
                    }
                }
            }
        }

        @Override // p000.C1865h8.AbstractC1870e
        /* renamed from: a */
        public boolean mo763a() {
            for (int i = 0; i < this.f5172b.size(); i++) {
                if (this.f5172b.get(i).mo763a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // p000.C1865h8.AbstractC1870e
        /* renamed from: b */
        public boolean mo762b(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f5172b.size(); i++) {
                z |= this.f5172b.get(i).mo762b(iArr);
            }
            return z;
        }

        /* renamed from: c */
        public final void m764c() {
            this.f5180j.reset();
            this.f5180j.postTranslate(-this.f5174d, -this.f5175e);
            this.f5180j.postScale(this.f5176f, this.f5177g);
            this.f5180j.postRotate(this.f5173c, 0.0f, 0.0f);
            this.f5180j.postTranslate(this.f5178h + this.f5174d, this.f5179i + this.f5175e);
        }

        public String getGroupName() {
            return this.f5183m;
        }

        public Matrix getLocalMatrix() {
            return this.f5180j;
        }

        public float getPivotX() {
            return this.f5174d;
        }

        public float getPivotY() {
            return this.f5175e;
        }

        public float getRotation() {
            return this.f5173c;
        }

        public float getScaleX() {
            return this.f5176f;
        }

        public float getScaleY() {
            return this.f5177g;
        }

        public float getTranslateX() {
            return this.f5178h;
        }

        public float getTranslateY() {
            return this.f5179i;
        }

        public void setPivotX(float f) {
            if (f != this.f5174d) {
                this.f5174d = f;
                m764c();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f5175e) {
                this.f5175e = f;
                m764c();
            }
        }

        public void setRotation(float f) {
            if (f != this.f5173c) {
                this.f5173c = f;
                m764c();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f5176f) {
                this.f5176f = f;
                m764c();
            }
        }

        public void setScaleY(float f) {
            if (f != this.f5177g) {
                this.f5177g = f;
                m764c();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.f5178h) {
                this.f5178h = f;
                m764c();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.f5179i) {
                this.f5179i = f;
                m764c();
            }
        }

        public C1869d() {
            super(null);
            this.f5171a = new Matrix();
            this.f5172b = new ArrayList<>();
            this.f5173c = 0.0f;
            this.f5174d = 0.0f;
            this.f5175e = 0.0f;
            this.f5176f = 1.0f;
            this.f5177g = 1.0f;
            this.f5178h = 0.0f;
            this.f5179i = 0.0f;
            this.f5180j = new Matrix();
            this.f5183m = null;
        }
    }
}
