package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.xmlpull.p019v1.XmlPullParser;
import p000.C0492V4;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ChangeTransform extends Transition {

    /* renamed from: d */
    public static final String[] f3426d = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* renamed from: f */
    public static final Property<C0893d, float[]> f3427f = new C0890a(float[].class, "nonTranslations");

    /* renamed from: g */
    public static final Property<C0893d, PointF> f3428g = new C0891b(PointF.class, "translations");

    /* renamed from: h */
    public static final boolean f3429h = true;

    /* renamed from: a */
    public boolean f3430a;

    /* renamed from: b */
    public boolean f3431b;

    /* renamed from: c */
    public Matrix f3432c;

    /* renamed from: androidx.transition.ChangeTransform$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0890a extends Property<C0893d, float[]> {
        public C0890a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ float[] get(C0893d c0893d) {
            return null;
        }

        @Override // android.util.Property
        public void set(C0893d c0893d, float[] fArr) {
            C0893d c0893d2 = c0893d;
            float[] fArr2 = fArr;
            System.arraycopy(fArr2, 0, c0893d2.f3437c, 0, fArr2.length);
            c0893d2.m1275a();
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0891b extends Property<C0893d, PointF> {
        public C0891b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ PointF get(C0893d c0893d) {
            return null;
        }

        @Override // android.util.Property
        public void set(C0893d c0893d, PointF pointF) {
            C0893d c0893d2 = c0893d;
            PointF pointF2 = pointF;
            Objects.requireNonNull(c0893d2);
            c0893d2.f3438d = pointF2.x;
            c0893d2.f3439e = pointF2.y;
            c0893d2.m1275a();
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0892c extends C0199I7 {

        /* renamed from: a */
        public View f3433a;

        /* renamed from: b */
        public InterfaceC2351x7 f3434b;

        public C0892c(View view, InterfaceC2351x7 interfaceC2351x7) {
            this.f3433a = view;
            this.f3434b = interfaceC2351x7;
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            View view = this.f3433a;
            if (Build.VERSION.SDK_INT == 28) {
                if (!C2403z7.f6922h) {
                    try {
                        C2403z7.m3b();
                        Method declaredMethod = C2403z7.f6917b.getDeclaredMethod("removeGhost", View.class);
                        C2403z7.f6921g = declaredMethod;
                        declaredMethod.setAccessible(true);
                    } catch (NoSuchMethodException e) {
                        Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e);
                    }
                    C2403z7.f6922h = true;
                }
                Method method = C2403z7.f6921g;
                if (method != null) {
                    try {
                        method.invoke(null, view);
                    } catch (IllegalAccessException unused) {
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException(e2.getCause());
                    }
                }
            } else {
                int i = C0021A7.f130h;
                C0021A7 c0021a7 = (C0021A7) view.getTag(C0090D7.ghost_view);
                if (c0021a7 != null) {
                    int i2 = c0021a7.f134d - 1;
                    c0021a7.f134d = i2;
                    if (i2 <= 0) {
                        ((C2386y7) c0021a7.getParent()).removeView(c0021a7);
                    }
                }
            }
            this.f3433a.setTag(C0090D7.transition_transform, null);
            this.f3433a.setTag(C0090D7.parent_matrix, null);
        }

        @Override // p000.C0199I7, androidx.transition.Transition.InterfaceC0911f
        public void onTransitionPause(Transition transition) {
            this.f3434b.setVisibility(4);
        }

        @Override // p000.C0199I7, androidx.transition.Transition.InterfaceC0911f
        public void onTransitionResume(Transition transition) {
            this.f3434b.setVisibility(0);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0893d {

        /* renamed from: a */
        public final Matrix f3435a = new Matrix();

        /* renamed from: b */
        public final View f3436b;

        /* renamed from: c */
        public final float[] f3437c;

        /* renamed from: d */
        public float f3438d;

        /* renamed from: e */
        public float f3439e;

        public C0893d(View view, float[] fArr) {
            this.f3436b = view;
            float[] fArr2 = (float[]) fArr.clone();
            this.f3437c = fArr2;
            this.f3438d = fArr2[2];
            this.f3439e = fArr2[5];
            m1275a();
        }

        /* renamed from: a */
        public final void m1275a() {
            float[] fArr = this.f3437c;
            fArr[2] = this.f3438d;
            fArr[5] = this.f3439e;
            this.f3435a.setValues(fArr);
            C0399R7.f1350a.mo1799d(this.f3436b, this.f3435a);
        }
    }

    /* renamed from: androidx.transition.ChangeTransform$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0894e {

        /* renamed from: a */
        public final float f3440a;

        /* renamed from: b */
        public final float f3441b;

        /* renamed from: c */
        public final float f3442c;

        /* renamed from: d */
        public final float f3443d;

        /* renamed from: e */
        public final float f3444e;

        /* renamed from: f */
        public final float f3445f;

        /* renamed from: g */
        public final float f3446g;

        /* renamed from: h */
        public final float f3447h;

        public C0894e(View view) {
            this.f3440a = view.getTranslationX();
            this.f3441b = view.getTranslationY();
            AtomicInteger atomicInteger = C0492V4.f1798a;
            this.f3442c = C0492V4.C0500h.m1889l(view);
            this.f3443d = view.getScaleX();
            this.f3444e = view.getScaleY();
            this.f3445f = view.getRotationX();
            this.f3446g = view.getRotationY();
            this.f3447h = view.getRotation();
        }

        /* renamed from: a */
        public void m1274a(View view) {
            float f = this.f3440a;
            float f2 = this.f3441b;
            float f3 = this.f3442c;
            float f4 = this.f3443d;
            float f5 = this.f3444e;
            float f6 = this.f3445f;
            float f7 = this.f3446g;
            float f8 = this.f3447h;
            String[] strArr = ChangeTransform.f3426d;
            view.setTranslationX(f);
            view.setTranslationY(f2);
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0500h.m1878w(view, f3);
            view.setScaleX(f4);
            view.setScaleY(f5);
            view.setRotationX(f6);
            view.setRotationY(f7);
            view.setRotation(f8);
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0894e) {
                C0894e c0894e = (C0894e) obj;
                return c0894e.f3440a == this.f3440a && c0894e.f3441b == this.f3441b && c0894e.f3442c == this.f3442c && c0894e.f3443d == this.f3443d && c0894e.f3444e == this.f3444e && c0894e.f3445f == this.f3445f && c0894e.f3446g == this.f3446g && c0894e.f3447h == this.f3447h;
            }
            return false;
        }

        public int hashCode() {
            float f = this.f3440a;
            int floatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
            float f2 = this.f3441b;
            int floatToIntBits2 = (floatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
            float f3 = this.f3442c;
            int floatToIntBits3 = (floatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
            float f4 = this.f3443d;
            int floatToIntBits4 = (floatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
            float f5 = this.f3444e;
            int floatToIntBits5 = (floatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
            float f6 = this.f3445f;
            int floatToIntBits6 = (floatToIntBits5 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f3446g;
            int floatToIntBits7 = (floatToIntBits6 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
            float f8 = this.f3447h;
            return floatToIntBits7 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0);
        }
    }

    public ChangeTransform() {
        this.f3430a = true;
        this.f3431b = true;
        this.f3432c = new Matrix();
    }

    /* renamed from: a */
    public static void m1276a(View view) {
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0500h.m1878w(view, 0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
        if (f3429h) {
            return;
        }
        ((ViewGroup) c0290m7.f971b.getParent()).startViewTransition(c0290m7.f971b);
    }

    public final void captureValues(C0290M7 c0290m7) {
        View view = c0290m7.f971b;
        if (view.getVisibility() == 8) {
            return;
        }
        c0290m7.f970a.put("android:changeTransform:parent", view.getParent());
        c0290m7.f970a.put("android:changeTransform:transforms", new C0894e(view));
        Matrix matrix = view.getMatrix();
        c0290m7.f970a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.f3431b) {
            Matrix matrix2 = new Matrix();
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            C0399R7.f1350a.mo1795h(viewGroup, matrix2);
            matrix2.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
            c0290m7.f970a.put("android:changeTransform:parentMatrix", matrix2);
            c0290m7.f970a.put("android:changeTransform:intermediateMatrix", view.getTag(C0090D7.transition_transform));
            c0290m7.f970a.put("android:changeTransform:intermediateParentMatrix", view.getTag(C0090D7.parent_matrix));
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:118:0x0308
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    @Override // androidx.transition.Transition
    public android.animation.Animator createAnimator(android.view.ViewGroup r25, p000.C0290M7 r26, p000.C0290M7 r27) {
        /*
            Method dump skipped, instructions count: 1066
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.ChangeTransform.createAnimator(android.view.ViewGroup, M7, M7):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return f3426d;
    }

    @SuppressLint({"RestrictedApi"})
    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3430a = true;
        this.f3431b = true;
        this.f3432c = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0174H7.f572e);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f3430a = LayoutInflater$Factory2C0000A.C0010h.m2672F(obtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.f3431b = LayoutInflater$Factory2C0000A.C0010h.m2672F(obtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        obtainStyledAttributes.recycle();
    }
}
