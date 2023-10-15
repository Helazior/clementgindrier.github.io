package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* renamed from: W0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0530W0 {

    /* renamed from: a */
    public static final ThreadLocal<TypedValue> f1866a = new ThreadLocal<>();

    /* renamed from: b */
    public static final int[] f1867b = {-16842910};

    /* renamed from: c */
    public static final int[] f1868c = {16842908};

    /* renamed from: d */
    public static final int[] f1869d = {16842919};

    /* renamed from: e */
    public static final int[] f1870e = {16842912};

    /* renamed from: f */
    public static final int[] f1871f = new int[0];

    /* renamed from: g */
    public static final int[] f1872g = new int[1];

    /* renamed from: a */
    public static void m1825a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C2012o.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(C2012o.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: b */
    public static int m1824b(Context context, int i) {
        ColorStateList m1822d = m1822d(context, i);
        if (m1822d != null && m1822d.isStateful()) {
            return m1822d.getColorForState(f1867b, m1822d.getDefaultColor());
        }
        ThreadLocal<TypedValue> threadLocal = f1866a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f = typedValue.getFloat();
        int m1823c = m1823c(context, i);
        return C0147G3.m2429c(m1823c, Math.round(Color.alpha(m1823c) * f));
    }

    /* renamed from: c */
    public static int m1823c(Context context, int i) {
        int[] iArr = f1872g;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: d */
    public static ColorStateList m1822d(Context context, int i) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = f1872g;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = C0279M.m2211a(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
