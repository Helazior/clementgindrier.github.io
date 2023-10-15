package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.Objects;
import java.util.WeakHashMap;

/* renamed from: E3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0103E3 {

    /* renamed from: a */
    public static final ThreadLocal<TypedValue> f375a = new ThreadLocal<>();

    /* renamed from: b */
    public static final WeakHashMap<C0105b, SparseArray<C0104a>> f376b = new WeakHashMap<>(0);

    /* renamed from: c */
    public static final Object f377c = new Object();

    /* renamed from: E3$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0104a {

        /* renamed from: a */
        public final ColorStateList f378a;

        /* renamed from: b */
        public final Configuration f379b;

        public C0104a(ColorStateList colorStateList, Configuration configuration) {
            this.f378a = colorStateList;
            this.f379b = configuration;
        }
    }

    /* renamed from: E3$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0105b {

        /* renamed from: a */
        public final Resources f380a;

        /* renamed from: b */
        public final Resources.Theme f381b;

        public C0105b(Resources resources, Resources.Theme theme) {
            this.f380a = resources;
            this.f381b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || C0105b.class != obj.getClass()) {
                return false;
            }
            C0105b c0105b = (C0105b) obj;
            return this.f380a.equals(c0105b.f380a) && Objects.equals(this.f381b, c0105b.f381b);
        }

        public int hashCode() {
            return Objects.hash(this.f380a, this.f381b);
        }
    }

    /* renamed from: E3$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0106c {

        /* renamed from: E3$c$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class RunnableC0107a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ Typeface f382a;

            public RunnableC0107a(Typeface typeface) {
                this.f382a = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC0106c.this.onFontRetrieved(this.f382a);
            }
        }

        /* renamed from: E3$c$b */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class RunnableC0108b implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ int f384a;

            public RunnableC0108b(int i) {
                this.f384a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                AbstractC0106c.this.onFontRetrievalFailed(this.f384a);
            }
        }

        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void callbackFailAsync(int i, Handler handler) {
            getHandler(handler).post(new RunnableC0108b(i));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            getHandler(handler).post(new RunnableC0107a(typeface));
        }

        public abstract void onFontRetrievalFailed(int i);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    /* renamed from: a */
    public static int m2469a(Resources resources, int i, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColor(i, null);
        }
        return resources.getColor(i);
    }

    /* renamed from: b */
    public static Typeface m2468b(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return m2467c(context, i, new TypedValue(), 0, null, null, false, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd A[ADDED_TO_REGION] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Typeface m2467c(android.content.Context r16, int r17, android.util.TypedValue r18, int r19, p000.C0103E3.AbstractC0106c r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0103E3.m2467c(android.content.Context, int, android.util.TypedValue, int, E3$c, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
