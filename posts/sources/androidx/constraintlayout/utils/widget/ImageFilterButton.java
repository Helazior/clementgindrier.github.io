package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: a */
    public ImageFilterView.C0718c f2781a;

    /* renamed from: b */
    public float f2782b;

    /* renamed from: c */
    public float f2783c;

    /* renamed from: d */
    public float f2784d;

    /* renamed from: f */
    public Path f2785f;

    /* renamed from: g */
    public ViewOutlineProvider f2786g;

    /* renamed from: h */
    public RectF f2787h;

    /* renamed from: i */
    public Drawable[] f2788i;

    /* renamed from: j */
    public LayerDrawable f2789j;

    /* renamed from: k */
    public boolean f2790k;

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterButton$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0714a extends ViewOutlineProvider {
        public C0714a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterButton.this.getWidth();
            int height = ImageFilterButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (Math.min(width, height) * ImageFilterButton.this.f2783c) / 2.0f);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterButton$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0715b extends ViewOutlineProvider {
        public C0715b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f2784d);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        this.f2781a = new ImageFilterView.C0718c();
        this.f2782b = 0.0f;
        this.f2783c = 0.0f;
        this.f2784d = Float.NaN;
        this.f2790k = true;
        m1546a(null);
    }

    /* renamed from: a */
    public final void m1546a(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(C0533W2.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.ImageFilterView_crossfade) {
                    this.f2782b = obtainStyledAttributes.getFloat(index, 0.0f);
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
                    this.f2790k = obtainStyledAttributes.getBoolean(index, this.f2790k);
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f2788i = drawableArr;
                drawableArr[0] = getDrawable();
                this.f2788i[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f2788i);
                this.f2789j = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f2782b * 255.0f));
                super.setImageDrawable(this.f2789j);
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
        ImageFilterView.C0718c c0718c = this.f2781a;
        c0718c.f2808d = f;
        c0718c.m1544a(this);
    }

    public void setContrast(float f) {
        ImageFilterView.C0718c c0718c = this.f2781a;
        c0718c.f2810f = f;
        c0718c.m1544a(this);
    }

    public void setCrossfade(float f) {
        this.f2782b = f;
        if (this.f2788i != null) {
            if (!this.f2790k) {
                this.f2789j.getDrawable(0).setAlpha((int) ((1.0f - this.f2782b) * 255.0f));
            }
            this.f2789j.getDrawable(1).setAlpha((int) (this.f2782b * 255.0f));
            super.setImageDrawable(this.f2789j);
        }
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.f2784d = f;
            float f2 = this.f2783c;
            this.f2783c = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.f2784d != f;
        this.f2784d = f;
        if (f != 0.0f) {
            if (this.f2785f == null) {
                this.f2785f = new Path();
            }
            if (this.f2787h == null) {
                this.f2787h = new RectF();
            }
            if (this.f2786g == null) {
                C0715b c0715b = new C0715b();
                this.f2786g = c0715b;
                setOutlineProvider(c0715b);
            }
            setClipToOutline(true);
            this.f2787h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2785f.reset();
            Path path = this.f2785f;
            RectF rectF = this.f2787h;
            float f3 = this.f2784d;
            path.addRoundRect(rectF, f3, f3, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.f2783c != f;
        this.f2783c = f;
        if (f != 0.0f) {
            if (this.f2785f == null) {
                this.f2785f = new Path();
            }
            if (this.f2787h == null) {
                this.f2787h = new RectF();
            }
            if (this.f2786g == null) {
                C0714a c0714a = new C0714a();
                this.f2786g = c0714a;
                setOutlineProvider(c0714a);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.f2783c) / 2.0f;
            this.f2787h.set(0.0f, 0.0f, width, height);
            this.f2785f.reset();
            this.f2785f.addRoundRect(this.f2787h, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        ImageFilterView.C0718c c0718c = this.f2781a;
        c0718c.f2809e = f;
        c0718c.m1544a(this);
    }

    public void setWarmth(float f) {
        ImageFilterView.C0718c c0718c = this.f2781a;
        c0718c.f2811g = f;
        c0718c.m1544a(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2781a = new ImageFilterView.C0718c();
        this.f2782b = 0.0f;
        this.f2783c = 0.0f;
        this.f2784d = Float.NaN;
        this.f2790k = true;
        m1546a(attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2781a = new ImageFilterView.C0718c();
        this.f2782b = 0.0f;
        this.f2783c = 0.0f;
        this.f2784d = Float.NaN;
        this.f2790k = true;
        m1546a(attributeSet);
    }
}
