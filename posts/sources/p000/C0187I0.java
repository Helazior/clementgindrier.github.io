package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: I0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0187I0 {

    /* renamed from: l */
    public static final RectF f610l = new RectF();

    /* renamed from: m */
    public static ConcurrentHashMap<String, Method> f611m = new ConcurrentHashMap<>();

    /* renamed from: n */
    public static ConcurrentHashMap<String, Field> f612n = new ConcurrentHashMap<>();

    /* renamed from: a */
    public int f613a = 0;

    /* renamed from: b */
    public boolean f614b = false;

    /* renamed from: c */
    public float f615c = -1.0f;

    /* renamed from: d */
    public float f616d = -1.0f;

    /* renamed from: e */
    public float f617e = -1.0f;

    /* renamed from: f */
    public int[] f618f = new int[0];

    /* renamed from: g */
    public boolean f619g = false;

    /* renamed from: h */
    public TextPaint f620h;

    /* renamed from: i */
    public final TextView f621i;

    /* renamed from: j */
    public final Context f622j;

    /* renamed from: k */
    public final C0190c f623k;

    /* renamed from: I0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0188a extends C0190c {
        @Override // p000.C0187I0.C0190c
        /* renamed from: a */
        public void mo2396a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) C0187I0.m2402e(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* renamed from: I0$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0189b extends C0188a {
        @Override // p000.C0187I0.C0188a, p000.C0187I0.C0190c
        /* renamed from: a */
        public void mo2396a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        @Override // p000.C0187I0.C0190c
        /* renamed from: b */
        public boolean mo2395b(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    /* renamed from: I0$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0190c {
        /* renamed from: a */
        public void mo2396a(StaticLayout.Builder builder, TextView textView) {
        }

        /* renamed from: b */
        public boolean mo2395b(TextView textView) {
            return ((Boolean) C0187I0.m2402e(textView, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public C0187I0(TextView textView) {
        this.f621i = textView;
        this.f622j = textView.getContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            this.f623k = new C0189b();
        } else if (i >= 23) {
            this.f623k = new C0188a();
        } else {
            this.f623k = new C0190c();
        }
    }

    /* renamed from: d */
    public static Method m2403d(String str) {
        try {
            Method method = f611m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f611m.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* renamed from: e */
    public static <T> T m2402e(Object obj, String str, T t) {
        try {
            return (T) m2403d(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    /* renamed from: a */
    public void m2406a() {
        if (m2398i() && this.f613a != 0) {
            if (this.f614b) {
                if (this.f621i.getMeasuredHeight() <= 0 || this.f621i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.f623k.mo2395b(this.f621i) ? 1048576 : (this.f621i.getMeasuredWidth() - this.f621i.getTotalPaddingLeft()) - this.f621i.getTotalPaddingRight();
                int height = (this.f621i.getHeight() - this.f621i.getCompoundPaddingBottom()) - this.f621i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f610l;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float m2404c = m2404c(rectF);
                    if (m2404c != this.f621i.getTextSize()) {
                        m2401f(0, m2404c);
                    }
                }
            }
            this.f614b = true;
        }
    }

    /* renamed from: b */
    public final int[] m2405b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0104, code lost:
        if (r7.getLineEnd(r7.getLineCount() - 1) != r8.length()) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x011a A[SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m2404c(android.graphics.RectF r21) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0187I0.m2404c(android.graphics.RectF):int");
    }

    /* renamed from: f */
    public void m2401f(int i, float f) {
        Resources resources;
        Context context = this.f622j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, resources.getDisplayMetrics());
        if (applyDimension != this.f621i.getPaint().getTextSize()) {
            this.f621i.getPaint().setTextSize(applyDimension);
            boolean isInLayout = this.f621i.isInLayout();
            if (this.f621i.getLayout() != null) {
                this.f614b = false;
                try {
                    Method m2403d = m2403d("nullLayouts");
                    if (m2403d != null) {
                        m2403d.invoke(this.f621i, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.f621i.requestLayout();
                } else {
                    this.f621i.forceLayout();
                }
                this.f621i.invalidate();
            }
        }
    }

    /* renamed from: g */
    public final boolean m2400g() {
        if (m2398i() && this.f613a == 1) {
            if (!this.f619g || this.f618f.length == 0) {
                int floor = ((int) Math.floor((this.f617e - this.f616d) / this.f615c)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round((i * this.f615c) + this.f616d);
                }
                this.f618f = m2405b(iArr);
            }
            this.f614b = true;
        } else {
            this.f614b = false;
        }
        return this.f614b;
    }

    /* renamed from: h */
    public final boolean m2399h() {
        int[] iArr = this.f618f;
        int length = iArr.length;
        boolean z = length > 0;
        this.f619g = z;
        if (z) {
            this.f613a = 1;
            this.f616d = iArr[0];
            this.f617e = iArr[length - 1];
            this.f615c = -1.0f;
        }
        return z;
    }

    /* renamed from: i */
    public final boolean m2398i() {
        return !(this.f621i instanceof AppCompatEditText);
    }

    /* renamed from: j */
    public final void m2397j(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        } else if (f3 > 0.0f) {
            this.f613a = 1;
            this.f616d = f;
            this.f617e = f2;
            this.f615c = f3;
            this.f619g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
    }
}
