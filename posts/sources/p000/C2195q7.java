package p000;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.Objects;

/* renamed from: q7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2195q7 extends Drawable implements Animatable {

    /* renamed from: h */
    public static final Interpolator f6264h = new LinearInterpolator();

    /* renamed from: i */
    public static final Interpolator f6265i = new C1621d6();

    /* renamed from: j */
    public static final int[] f6266j = {-16777216};

    /* renamed from: a */
    public final C2196a f6267a;

    /* renamed from: b */
    public float f6268b;

    /* renamed from: c */
    public Resources f6269c;

    /* renamed from: d */
    public Animator f6270d;

    /* renamed from: f */
    public float f6271f;

    /* renamed from: g */
    public boolean f6272g;

    /* renamed from: q7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2196a {

        /* renamed from: a */
        public final RectF f6273a = new RectF();

        /* renamed from: b */
        public final Paint f6274b;

        /* renamed from: c */
        public final Paint f6275c;

        /* renamed from: d */
        public final Paint f6276d;

        /* renamed from: e */
        public float f6277e;

        /* renamed from: f */
        public float f6278f;

        /* renamed from: g */
        public float f6279g;

        /* renamed from: h */
        public float f6280h;

        /* renamed from: i */
        public int[] f6281i;

        /* renamed from: j */
        public int f6282j;

        /* renamed from: k */
        public float f6283k;

        /* renamed from: l */
        public float f6284l;

        /* renamed from: m */
        public float f6285m;

        /* renamed from: n */
        public boolean f6286n;

        /* renamed from: o */
        public Path f6287o;

        /* renamed from: p */
        public float f6288p;

        /* renamed from: q */
        public float f6289q;

        /* renamed from: r */
        public int f6290r;

        /* renamed from: s */
        public int f6291s;

        /* renamed from: t */
        public int f6292t;

        /* renamed from: u */
        public int f6293u;

        public C2196a() {
            Paint paint = new Paint();
            this.f6274b = paint;
            Paint paint2 = new Paint();
            this.f6275c = paint2;
            Paint paint3 = new Paint();
            this.f6276d = paint3;
            this.f6277e = 0.0f;
            this.f6278f = 0.0f;
            this.f6279g = 0.0f;
            this.f6280h = 5.0f;
            this.f6288p = 1.0f;
            this.f6292t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        /* renamed from: a */
        public void m426a(int i) {
            this.f6282j = i;
            this.f6293u = this.f6281i[i];
        }

        /* renamed from: b */
        public void m425b(boolean z) {
            if (this.f6286n != z) {
                this.f6286n = z;
            }
        }
    }

    public C2195q7(Context context) {
        Objects.requireNonNull(context);
        this.f6269c = context.getResources();
        C2196a c2196a = new C2196a();
        this.f6267a = c2196a;
        c2196a.f6281i = f6266j;
        c2196a.m426a(0);
        c2196a.f6280h = 2.5f;
        c2196a.f6274b.setStrokeWidth(2.5f);
        invalidateSelf();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new C2023o7(this, c2196a));
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f6264h);
        ofFloat.addListener(new C2176p7(this, c2196a));
        this.f6270d = ofFloat;
    }

    /* renamed from: a */
    public void m430a(float f, C2196a c2196a, boolean z) {
        float interpolation;
        float f2;
        if (this.f6272g) {
            m427d(f, c2196a);
            float floor = (float) (Math.floor(c2196a.f6285m / 0.8f) + 1.0d);
            float f3 = c2196a.f6283k;
            float f4 = c2196a.f6284l;
            c2196a.f6277e = (((f4 - 0.01f) - f3) * f) + f3;
            c2196a.f6278f = f4;
            float f5 = c2196a.f6285m;
            c2196a.f6279g = outline.m270a(floor, f5, f, f5);
        } else if (f != 1.0f || z) {
            float f6 = c2196a.f6285m;
            if (f < 0.5f) {
                interpolation = c2196a.f6283k;
                f2 = (f6265i.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float f7 = c2196a.f6283k + 0.79f;
                interpolation = f7 - (((1.0f - f6265i.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f2 = f7;
            }
            c2196a.f6277e = interpolation;
            c2196a.f6278f = f2;
            c2196a.f6279g = (0.20999998f * f) + f6;
            this.f6268b = (f + this.f6271f) * 216.0f;
        }
    }

    /* renamed from: b */
    public final void m429b(float f, float f2, float f3, float f4) {
        C2196a c2196a = this.f6267a;
        float f5 = this.f6269c.getDisplayMetrics().density;
        float f6 = f2 * f5;
        c2196a.f6280h = f6;
        c2196a.f6274b.setStrokeWidth(f6);
        c2196a.f6289q = f * f5;
        c2196a.m426a(0);
        c2196a.f6290r = (int) (f3 * f5);
        c2196a.f6291s = (int) (f4 * f5);
    }

    /* renamed from: c */
    public void m428c(int i) {
        if (i == 0) {
            m429b(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            m429b(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* renamed from: d */
    public void m427d(float f, C2196a c2196a) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int[] iArr = c2196a.f6281i;
            int i = c2196a.f6282j;
            int i2 = iArr[i];
            int i3 = iArr[(i + 1) % iArr.length];
            int i4 = (i2 >> 24) & 255;
            int i5 = (i2 >> 16) & 255;
            int i6 = (i2 >> 8) & 255;
            int i7 = i2 & 255;
            c2196a.f6293u = ((i4 + ((int) ((((i3 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((i3 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((i3 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((i3 & 255) - i7))));
            return;
        }
        c2196a.f6293u = c2196a.f6281i[c2196a.f6282j];
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f6268b, bounds.exactCenterX(), bounds.exactCenterY());
        C2196a c2196a = this.f6267a;
        RectF rectF = c2196a.f6273a;
        float f = c2196a.f6289q;
        float f2 = (c2196a.f6280h / 2.0f) + f;
        if (f <= 0.0f) {
            f2 = (Math.min(bounds.width(), bounds.height()) / 2.0f) - Math.max((c2196a.f6290r * c2196a.f6288p) / 2.0f, c2196a.f6280h / 2.0f);
        }
        rectF.set(bounds.centerX() - f2, bounds.centerY() - f2, bounds.centerX() + f2, bounds.centerY() + f2);
        float f3 = c2196a.f6277e;
        float f4 = c2196a.f6279g;
        float f5 = (f3 + f4) * 360.0f;
        float f6 = ((c2196a.f6278f + f4) * 360.0f) - f5;
        c2196a.f6274b.setColor(c2196a.f6293u);
        c2196a.f6274b.setAlpha(c2196a.f6292t);
        float f7 = c2196a.f6280h / 2.0f;
        rectF.inset(f7, f7);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, c2196a.f6276d);
        float f8 = -f7;
        rectF.inset(f8, f8);
        canvas.drawArc(rectF, f5, f6, false, c2196a.f6274b);
        if (c2196a.f6286n) {
            Path path = c2196a.f6287o;
            if (path == null) {
                Path path2 = new Path();
                c2196a.f6287o = path2;
                path2.setFillType(Path.FillType.EVEN_ODD);
            } else {
                path.reset();
            }
            c2196a.f6287o.moveTo(0.0f, 0.0f);
            c2196a.f6287o.lineTo(c2196a.f6290r * c2196a.f6288p, 0.0f);
            Path path3 = c2196a.f6287o;
            float f9 = c2196a.f6288p;
            path3.lineTo((c2196a.f6290r * f9) / 2.0f, c2196a.f6291s * f9);
            c2196a.f6287o.offset((rectF.centerX() + (Math.min(rectF.width(), rectF.height()) / 2.0f)) - ((c2196a.f6290r * c2196a.f6288p) / 2.0f), (c2196a.f6280h / 2.0f) + rectF.centerY());
            c2196a.f6287o.close();
            c2196a.f6275c.setColor(c2196a.f6293u);
            c2196a.f6275c.setAlpha(c2196a.f6292t);
            canvas.save();
            canvas.rotate(f5 + f6, rectF.centerX(), rectF.centerY());
            canvas.drawPath(c2196a.f6287o, c2196a.f6275c);
            canvas.restore();
        }
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f6267a.f6292t;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f6270d.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f6267a.f6292t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f6267a.f6274b.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f6270d.cancel();
        C2196a c2196a = this.f6267a;
        float f = c2196a.f6277e;
        c2196a.f6283k = f;
        float f2 = c2196a.f6278f;
        c2196a.f6284l = f2;
        c2196a.f6285m = c2196a.f6279g;
        if (f2 != f) {
            this.f6272g = true;
            this.f6270d.setDuration(666L);
            this.f6270d.start();
            return;
        }
        c2196a.m426a(0);
        C2196a c2196a2 = this.f6267a;
        c2196a2.f6283k = 0.0f;
        c2196a2.f6284l = 0.0f;
        c2196a2.f6285m = 0.0f;
        c2196a2.f6277e = 0.0f;
        c2196a2.f6278f = 0.0f;
        c2196a2.f6279g = 0.0f;
        this.f6270d.setDuration(1332L);
        this.f6270d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f6270d.cancel();
        this.f6268b = 0.0f;
        this.f6267a.m425b(false);
        this.f6267a.m426a(0);
        C2196a c2196a = this.f6267a;
        c2196a.f6283k = 0.0f;
        c2196a.f6284l = 0.0f;
        c2196a.f6285m = 0.0f;
        c2196a.f6277e = 0.0f;
        c2196a.f6278f = 0.0f;
        c2196a.f6279g = 0.0f;
        invalidateSelf();
    }
}
