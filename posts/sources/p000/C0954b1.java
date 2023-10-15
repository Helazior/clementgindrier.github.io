package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import p000.C0103E3;

/* renamed from: b1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0954b1 {

    /* renamed from: a */
    public final Context f3659a;

    /* renamed from: b */
    public final TypedArray f3660b;

    /* renamed from: c */
    public TypedValue f3661c;

    public C0954b1(Context context, TypedArray typedArray) {
        this.f3659a = context;
        this.f3660b = typedArray;
    }

    /* renamed from: q */
    public static C0954b1 m1197q(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0954b1(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: r */
    public static C0954b1 m1196r(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C0954b1(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: a */
    public boolean m1213a(int i, boolean z) {
        return this.f3660b.getBoolean(i, z);
    }

    /* renamed from: b */
    public int m1212b(int i, int i2) {
        return this.f3660b.getColor(i, i2);
    }

    /* renamed from: c */
    public ColorStateList m1211c(int i) {
        int resourceId;
        ColorStateList m2211a;
        return (!this.f3660b.hasValue(i) || (resourceId = this.f3660b.getResourceId(i, 0)) == 0 || (m2211a = C0279M.m2211a(this.f3659a, resourceId)) == null) ? this.f3660b.getColorStateList(i) : m2211a;
    }

    /* renamed from: d */
    public float m1210d(int i, float f) {
        return this.f3660b.getDimension(i, f);
    }

    /* renamed from: e */
    public int m1209e(int i, int i2) {
        return this.f3660b.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: f */
    public int m1208f(int i, int i2) {
        return this.f3660b.getDimensionPixelSize(i, i2);
    }

    /* renamed from: g */
    public Drawable m1207g(int i) {
        int resourceId;
        if (this.f3660b.hasValue(i) && (resourceId = this.f3660b.getResourceId(i, 0)) != 0) {
            return C0279M.m2210b(this.f3659a, resourceId);
        }
        return this.f3660b.getDrawable(i);
    }

    /* renamed from: h */
    public Drawable m1206h(int i) {
        int resourceId;
        Drawable m2062g;
        if (!this.f3660b.hasValue(i) || (resourceId = this.f3660b.getResourceId(i, 0)) == 0) {
            return null;
        }
        C0032B0 m2580a = C0032B0.m2580a();
        Context context = this.f3659a;
        synchronized (m2580a) {
            m2062g = m2580a.f162a.m2062g(context, resourceId, true);
        }
        return m2062g;
    }

    /* renamed from: i */
    public Typeface m1205i(int i, int i2, C0103E3.AbstractC0106c abstractC0106c) {
        int resourceId = this.f3660b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f3661c == null) {
            this.f3661c = new TypedValue();
        }
        Context context = this.f3659a;
        TypedValue typedValue = this.f3661c;
        ThreadLocal<TypedValue> threadLocal = C0103E3.f375a;
        if (context.isRestricted()) {
            return null;
        }
        return C0103E3.m2467c(context, resourceId, typedValue, i2, abstractC0106c, null, true, false);
    }

    /* renamed from: j */
    public int m1204j(int i, int i2) {
        return this.f3660b.getInt(i, i2);
    }

    /* renamed from: k */
    public int m1203k(int i, int i2) {
        return this.f3660b.getInteger(i, i2);
    }

    /* renamed from: l */
    public int m1202l(int i, int i2) {
        return this.f3660b.getLayoutDimension(i, i2);
    }

    /* renamed from: m */
    public int m1201m(int i, int i2) {
        return this.f3660b.getResourceId(i, i2);
    }

    /* renamed from: n */
    public String m1200n(int i) {
        return this.f3660b.getString(i);
    }

    /* renamed from: o */
    public CharSequence m1199o(int i) {
        return this.f3660b.getText(i);
    }

    /* renamed from: p */
    public boolean m1198p(int i) {
        return this.f3660b.hasValue(i);
    }
}
