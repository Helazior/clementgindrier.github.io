package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.p019v1.XmlPullParser;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PatternPathMotion extends PathMotion {

    /* renamed from: a */
    public final Path f3454a;

    /* renamed from: b */
    public final Matrix f3455b;

    public PatternPathMotion() {
        Path path = new Path();
        this.f3454a = path;
        this.f3455b = new Matrix();
        path.lineTo(1.0f, 0.0f);
    }

    /* renamed from: a */
    public void m1271a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
        float f = fArr[0];
        float f2 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, null);
        float f3 = fArr[0];
        float f4 = fArr[1];
        if (f3 == f && f4 == f2) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f3455b.setTranslate(-f3, -f4);
        float f5 = f - f3;
        float f6 = f2 - f4;
        float sqrt = 1.0f / ((float) Math.sqrt((f6 * f6) + (f5 * f5)));
        this.f3455b.postScale(sqrt, sqrt);
        this.f3455b.postRotate((float) Math.toDegrees(-Math.atan2(f6, f5)));
        path.transform(this.f3455b, this.f3454a);
    }

    @Override // androidx.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float sqrt = (float) Math.sqrt((f6 * f6) + (f5 * f5));
        double atan2 = Math.atan2(f6, f5);
        this.f3455b.setScale(sqrt, sqrt);
        this.f3455b.postRotate((float) Math.toDegrees(atan2));
        this.f3455b.postTranslate(f, f2);
        Path path = new Path();
        this.f3454a.transform(this.f3455b, path);
        return path;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f3454a = new Path();
        this.f3455b = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0174H7.f576i);
        try {
            String m2667K = LayoutInflater$Factory2C0000A.C0010h.m2667K(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (m2667K != null) {
                m1271a(LayoutInflater$Factory2C0000A.C0010h.m2613t(m2667K));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
