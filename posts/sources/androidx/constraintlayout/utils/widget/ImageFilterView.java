package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a */
    public C0718c f2793a;

    /* renamed from: b */
    public boolean f2794b;

    /* renamed from: c */
    public float f2795c;

    /* renamed from: d */
    public float f2796d;

    /* renamed from: f */
    public float f2797f;

    /* renamed from: g */
    public Path f2798g;

    /* renamed from: h */
    public ViewOutlineProvider f2799h;

    /* renamed from: i */
    public RectF f2800i;

    /* renamed from: j */
    public Drawable[] f2801j;

    /* renamed from: k */
    public LayerDrawable f2802k;

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0716a extends ViewOutlineProvider {
        public C0716a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterView.this.getWidth();
            int height = ImageFilterView.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterView.this.f2796d) / 2.0f);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0717b extends ViewOutlineProvider {
        public C0717b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f2797f);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0718c {

        /* renamed from: a */
        public float[] f2805a = new float[20];

        /* renamed from: b */
        public ColorMatrix f2806b = new ColorMatrix();

        /* renamed from: c */
        public ColorMatrix f2807c = new ColorMatrix();

        /* renamed from: d */
        public float f2808d = 1.0f;

        /* renamed from: e */
        public float f2809e = 1.0f;

        /* renamed from: f */
        public float f2810f = 1.0f;

        /* renamed from: g */
        public float f2811g = 1.0f;

        /* renamed from: a */
        public void m1544a(ImageView imageView) {
            float f;
            boolean z;
            float f2;
            float log;
            float f3;
            float f4;
            this.f2806b.reset();
            float f5 = this.f2809e;
            boolean z2 = true;
            if (f5 != 1.0f) {
                float f6 = 1.0f - f5;
                float f7 = 0.2999f * f6;
                float f8 = 0.587f * f6;
                float f9 = f6 * 0.114f;
                float[] fArr = this.f2805a;
                fArr[0] = f7 + f5;
                fArr[1] = f8;
                fArr[2] = f9;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = f7;
                fArr[6] = f8 + f5;
                fArr[7] = f9;
                fArr[8] = 0.0f;
                fArr[9] = 0.0f;
                fArr[10] = f7;
                fArr[11] = f8;
                fArr[12] = f9 + f5;
                fArr[13] = 0.0f;
                fArr[14] = 0.0f;
                fArr[15] = 0.0f;
                fArr[16] = 0.0f;
                fArr[17] = 0.0f;
                f = 1.0f;
                fArr[18] = 1.0f;
                fArr[19] = 0.0f;
                this.f2806b.set(fArr);
                z = true;
            } else {
                f = 1.0f;
                z = false;
            }
            float f10 = this.f2810f;
            if (f10 != f) {
                this.f2807c.setScale(f10, f10, f10, f);
                this.f2806b.postConcat(this.f2807c);
                z = true;
            }
            float f11 = this.f2811g;
            if (f11 != f) {
                if (f11 <= 0.0f) {
                    f11 = 0.01f;
                }
                float f12 = (5000.0f / f11) / 100.0f;
                if (f12 > 66.0f) {
                    double d = f12 - 60.0f;
                    log = ((float) Math.pow(d, 0.07551484555006027d)) * 288.12216f;
                    f3 = ((float) Math.pow(d, -0.13320475816726685d)) * 329.69873f;
                } else {
                    log = (((float) Math.log(f12)) * 99.4708f) - 161.11957f;
                    f3 = 255.0f;
                }
                if (f12 < 66.0f) {
                    f4 = f12 > 19.0f ? (((float) Math.log(f12 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f;
                } else {
                    f4 = 255.0f;
                }
                float min = Math.min(255.0f, Math.max(f3, 0.0f));
                float min2 = Math.min(255.0f, Math.max(log, 0.0f));
                float min3 = Math.min(255.0f, Math.max(f4, 0.0f));
                float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
                float min5 = Math.min(255.0f, Math.max((((float) Math.log(50.0f)) * 99.4708f) - 161.11957f, 0.0f));
                float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log(40.0f)) * 138.51773f) - 305.0448f, 0.0f));
                float[] fArr2 = this.f2805a;
                fArr2[0] = min / min4;
                fArr2[1] = 0.0f;
                fArr2[2] = 0.0f;
                fArr2[3] = 0.0f;
                fArr2[4] = 0.0f;
                fArr2[5] = 0.0f;
                fArr2[6] = min2 / min5;
                fArr2[7] = 0.0f;
                fArr2[8] = 0.0f;
                fArr2[9] = 0.0f;
                fArr2[10] = 0.0f;
                fArr2[11] = 0.0f;
                fArr2[12] = min6;
                fArr2[13] = 0.0f;
                fArr2[14] = 0.0f;
                fArr2[15] = 0.0f;
                fArr2[16] = 0.0f;
                fArr2[17] = 0.0f;
                f2 = 1.0f;
                fArr2[18] = 1.0f;
                fArr2[19] = 0.0f;
                this.f2807c.set(fArr2);
                this.f2806b.postConcat(this.f2807c);
                z = true;
            } else {
                f2 = 1.0f;
            }
            float f13 = this.f2808d;
            if (f13 != f2) {
                float[] fArr3 = this.f2805a;
                fArr3[0] = f13;
                fArr3[1] = 0.0f;
                fArr3[2] = 0.0f;
                fArr3[3] = 0.0f;
                fArr3[4] = 0.0f;
                fArr3[5] = 0.0f;
                fArr3[6] = f13;
                fArr3[7] = 0.0f;
                fArr3[8] = 0.0f;
                fArr3[9] = 0.0f;
                fArr3[10] = 0.0f;
                fArr3[11] = 0.0f;
                fArr3[12] = f13;
                fArr3[13] = 0.0f;
                fArr3[14] = 0.0f;
                fArr3[15] = 0.0f;
                fArr3[16] = 0.0f;
                fArr3[17] = 0.0f;
                fArr3[18] = 1.0f;
                fArr3[19] = 0.0f;
                this.f2807c.set(fArr3);
                this.f2806b.postConcat(this.f2807c);
            } else {
                z2 = z;
            }
            if (z2) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f2806b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.f2793a = new C0718c();
        this.f2794b = true;
        this.f2795c = 0.0f;
        this.f2796d = 0.0f;
        this.f2797f = Float.NaN;
        m1545c(null);
    }

    /* renamed from: c */
    public final void m1545c(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(C0533W2.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.ImageFilterView_crossfade) {
                    this.f2795c = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == C0533W2.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0533W2.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0533W2.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0533W2.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == C0533W2.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == C0533W2.ImageFilterView_overlay) {
                    this.f2794b = obtainStyledAttributes.getBoolean(index, this.f2794b);
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f2801j = drawableArr;
                drawableArr[0] = getDrawable();
                this.f2801j[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f2801j);
                this.f2802k = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f2795c * 255.0f));
                super.setImageDrawable(this.f2802k);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (0 != 0) {
            canvas.restore();
        }
    }

    public void setBrightness(float f) {
        C0718c c0718c = this.f2793a;
        c0718c.f2808d = f;
        c0718c.m1544a(this);
    }

    public void setContrast(float f) {
        C0718c c0718c = this.f2793a;
        c0718c.f2810f = f;
        c0718c.m1544a(this);
    }

    public void setCrossfade(float f) {
        this.f2795c = f;
        if (this.f2801j != null) {
            if (!this.f2794b) {
                this.f2802k.getDrawable(0).setAlpha((int) ((1.0f - this.f2795c) * 255.0f));
            }
            this.f2802k.getDrawable(1).setAlpha((int) (this.f2795c * 255.0f));
            super.setImageDrawable(this.f2802k);
        }
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.f2797f = f;
            float f2 = this.f2796d;
            this.f2796d = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.f2797f != f;
        this.f2797f = f;
        if (f != 0.0f) {
            if (this.f2798g == null) {
                this.f2798g = new Path();
            }
            if (this.f2800i == null) {
                this.f2800i = new RectF();
            }
            if (this.f2799h == null) {
                C0717b c0717b = new C0717b();
                this.f2799h = c0717b;
                setOutlineProvider(c0717b);
            }
            setClipToOutline(true);
            this.f2800i.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2798g.reset();
            Path path = this.f2798g;
            RectF rectF = this.f2800i;
            float f3 = this.f2797f;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.f2796d != f;
        this.f2796d = f;
        if (f != 0.0f) {
            if (this.f2798g == null) {
                this.f2798g = new Path();
            }
            if (this.f2800i == null) {
                this.f2800i = new RectF();
            }
            if (this.f2799h == null) {
                C0716a c0716a = new C0716a();
                this.f2799h = c0716a;
                setOutlineProvider(c0716a);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f2796d) / 2.0f;
            this.f2800i.set(0.0f, 0.0f, width, height);
            this.f2798g.reset();
            this.f2798g.addRoundRect(this.f2800i, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        C0718c c0718c = this.f2793a;
        c0718c.f2809e = f;
        c0718c.m1544a(this);
    }

    public void setWarmth(float f) {
        C0718c c0718c = this.f2793a;
        c0718c.f2811g = f;
        c0718c.m1544a(this);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2793a = new C0718c();
        this.f2794b = true;
        this.f2795c = 0.0f;
        this.f2796d = 0.0f;
        this.f2797f = Float.NaN;
        m1545c(attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2793a = new C0718c();
        this.f2794b = true;
        this.f2795c = 0.0f;
        this.f2796d = 0.0f;
        this.f2797f = Float.NaN;
        m1545c(attributeSet);
    }
}
