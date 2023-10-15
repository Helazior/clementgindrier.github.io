package p000;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* renamed from: M */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0279M {

    /* renamed from: a */
    public static final ThreadLocal<TypedValue> f923a = new ThreadLocal<>();

    /* renamed from: b */
    public static final WeakHashMap<Context, SparseArray<C0280a>> f924b = new WeakHashMap<>(0);

    /* renamed from: c */
    public static final Object f925c = new Object();

    /* renamed from: M$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0280a {

        /* renamed from: a */
        public final ColorStateList f926a;

        /* renamed from: b */
        public final Configuration f927b;

        public C0280a(ColorStateList colorStateList, Configuration configuration) {
            this.f926a = colorStateList;
            this.f927b = configuration;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b5  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.res.ColorStateList m2211a(android.content.Context r12, int r13) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0279M.m2211a(android.content.Context, int):android.content.res.ColorStateList");
    }

    /* renamed from: b */
    public static Drawable m2210b(Context context, int i) {
        return C0384R0.m2065d().m2063f(context, i);
    }
}
