package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import p000.C2307w3;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, Context context2, int i) {
        return getDrawable(context, context2, i, null);
    }

    private static Drawable loadDrawableV4(Context context, int i, Resources.Theme theme) {
        Resources resources = context.getResources();
        ThreadLocal<TypedValue> threadLocal = C0103E3.f375a;
        return resources.getDrawable(i, theme);
    }

    private static Drawable loadDrawableV7(Context context, int i, Resources.Theme theme) {
        if (theme != null) {
            context = new C0546X(context, theme);
        }
        return C0279M.m2210b(context, i);
    }

    public static Drawable getDrawable(Context context, int i, Resources.Theme theme) {
        return getDrawable(context, context, i, theme);
    }

    private static Drawable getDrawable(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                Object obj = C2307w3.f6741a;
                return C2307w3.C2310c.m202b(context2, i);
            }
            throw e;
        } catch (NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i, theme);
    }
}
