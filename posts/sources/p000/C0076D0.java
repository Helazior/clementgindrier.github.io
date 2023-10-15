package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* renamed from: D0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0076D0 {

    /* renamed from: c */
    public static final int[] f315c = {16843067, 16843068};

    /* renamed from: a */
    public final ProgressBar f316a;

    /* renamed from: b */
    public Bitmap f317b;

    public C0076D0(ProgressBar progressBar) {
        this.f316a = progressBar;
    }

    /* renamed from: a */
    public void mo2474a(AttributeSet attributeSet, int i) {
        C0954b1 m1196r = C0954b1.m1196r(this.f316a.getContext(), attributeSet, f315c, i, 0);
        Drawable m1206h = m1196r.m1206h(0);
        if (m1206h != null) {
            ProgressBar progressBar = this.f316a;
            if (m1206h instanceof AnimationDrawable) {
                AnimationDrawable animationDrawable = (AnimationDrawable) m1206h;
                int numberOfFrames = animationDrawable.getNumberOfFrames();
                AnimationDrawable animationDrawable2 = new AnimationDrawable();
                animationDrawable2.setOneShot(animationDrawable.isOneShot());
                for (int i2 = 0; i2 < numberOfFrames; i2++) {
                    Drawable m2492b = m2492b(animationDrawable.getFrame(i2), true);
                    m2492b.setLevel(10000);
                    animationDrawable2.addFrame(m2492b, animationDrawable.getDuration(i2));
                }
                animationDrawable2.setLevel(10000);
                m1206h = animationDrawable2;
            }
            progressBar.setIndeterminateDrawable(m1206h);
        }
        Drawable m1206h2 = m1196r.m1206h(1);
        if (m1206h2 != null) {
            this.f316a.setProgressDrawable(m2492b(m1206h2, false));
        }
        m1196r.f3660b.recycle();
    }

    /* renamed from: b */
    public final Drawable m2492b(Drawable drawable, boolean z) {
        if (drawable instanceof InterfaceC0430S3) {
            InterfaceC0430S3 interfaceC0430S3 = (InterfaceC0430S3) drawable;
            Drawable mo2009b = interfaceC0430S3.mo2009b();
            if (mo2009b != null) {
                interfaceC0430S3.mo2010a(m2492b(mo2009b, z));
            }
        } else if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            Drawable[] drawableArr = new Drawable[numberOfLayers];
            for (int i = 0; i < numberOfLayers; i++) {
                int id = layerDrawable.getId(i);
                drawableArr[i] = m2492b(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
            }
            LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable2.setId(i2, layerDrawable.getId(i2));
            }
            return layerDrawable2;
        } else if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f317b == null) {
                this.f317b = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        return drawable;
    }
}
