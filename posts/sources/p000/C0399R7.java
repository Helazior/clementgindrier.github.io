package p000;

import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: R7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0399R7 {

    /* renamed from: a */
    public static final C0559X7 f1350a;

    /* renamed from: b */
    public static final Property<View, Float> f1351b;

    /* renamed from: c */
    public static final Property<View, Rect> f1352c;

    /* renamed from: R7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0400a extends Property<View, Float> {
        public C0400a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(C0399R7.m2046a(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f) {
            float floatValue = f.floatValue();
            C0399R7.f1350a.mo1797f(view, floatValue);
        }
    }

    /* renamed from: R7$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0401b extends Property<View, Rect> {
        public C0401b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Rect get(View view) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            return C0492V4.C0497e.m1913a(view);
        }

        @Override // android.util.Property
        public void set(View view, Rect rect) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0497e.m1911c(view, rect);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            f1350a = new C0538W7();
        } else if (i >= 23) {
            f1350a = new C0519V7();
        } else {
            f1350a = new C0478U7();
        }
        f1351b = new C0400a(Float.class, "translationAlpha");
        f1352c = new C0401b(Rect.class, "clipBounds");
    }

    /* renamed from: a */
    public static float m2046a(View view) {
        return f1350a.mo1801b(view);
    }

    /* renamed from: b */
    public static void m2045b(View view, int i, int i2, int i3, int i4) {
        f1350a.mo1798e(view, i, i2, i3, i4);
    }
}
