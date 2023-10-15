package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

/* renamed from: Fd */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0140Fd implements BitmapDisplayer {

    /* renamed from: a */
    public final int f457a;

    /* renamed from: Fd$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0141a extends Drawable {

        /* renamed from: a */
        public final float f458a;

        /* renamed from: b */
        public final int f459b;

        /* renamed from: c */
        public final RectF f460c = new RectF();

        /* renamed from: d */
        public final RectF f461d;

        /* renamed from: e */
        public final BitmapShader f462e;

        /* renamed from: f */
        public final Paint f463f;

        public C0141a(Bitmap bitmap, int i, int i2) {
            this.f458a = i;
            this.f459b = i2;
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            this.f462e = bitmapShader;
            float f = i2;
            this.f461d = new RectF(f, f, bitmap.getWidth() - i2, bitmap.getHeight() - i2);
            Paint paint = new Paint();
            this.f463f = paint;
            paint.setAntiAlias(true);
            paint.setShader(bitmapShader);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            RectF rectF = this.f460c;
            float f = this.f458a;
            canvas.drawRoundRect(rectF, f, f, this.f463f);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            RectF rectF = this.f460c;
            int i = this.f459b;
            rectF.set(i, i, rect.width() - this.f459b, rect.height() - this.f459b);
            Matrix matrix = new Matrix();
            matrix.setRectToRect(this.f461d, this.f460c, Matrix.ScaleToFit.FILL);
            this.f462e.setLocalMatrix(matrix);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.f463f.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.f463f.setColorFilter(colorFilter);
        }
    }

    public C0140Fd(int i) {
        this.f457a = i;
    }

    @Override // com.nostra13.universalimageloader.core.display.BitmapDisplayer
    public void display(Bitmap bitmap, ImageAware imageAware, LoadedFrom loadedFrom) {
        if (imageAware instanceof ImageViewAware) {
            imageAware.setImageDrawable(new C0141a(bitmap, this.f457a, 0));
            return;
        }
        throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    }
}
