package p000;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;

/* renamed from: p3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2170p3 {

    /* renamed from: a */
    public Context f6196a;

    /* renamed from: e */
    public CharSequence f6200e;

    /* renamed from: f */
    public CharSequence f6201f;

    /* renamed from: g */
    public PendingIntent f6202g;

    /* renamed from: h */
    public Bitmap f6203h;

    /* renamed from: i */
    public int f6204i;

    /* renamed from: j */
    public int f6205j;

    /* renamed from: l */
    public AbstractC2190q3 f6207l;

    /* renamed from: n */
    public Bundle f6209n;

    /* renamed from: q */
    public String f6212q;

    /* renamed from: r */
    public boolean f6213r;

    /* renamed from: s */
    public Notification f6214s;
    @Deprecated

    /* renamed from: t */
    public ArrayList<String> f6215t;

    /* renamed from: b */
    public ArrayList<C1976m3> f6197b = new ArrayList<>();

    /* renamed from: c */
    public ArrayList<C2250t3> f6198c = new ArrayList<>();

    /* renamed from: d */
    public ArrayList<C1976m3> f6199d = new ArrayList<>();

    /* renamed from: k */
    public boolean f6206k = true;

    /* renamed from: m */
    public boolean f6208m = false;

    /* renamed from: o */
    public int f6210o = 0;

    /* renamed from: p */
    public int f6211p = 0;

    public C2170p3(Context context, String str) {
        Notification notification = new Notification();
        this.f6214s = notification;
        this.f6196a = context;
        this.f6212q = str;
        notification.when = System.currentTimeMillis();
        this.f6214s.audioStreamType = -1;
        this.f6205j = 0;
        this.f6215t = new ArrayList<>();
        this.f6213r = true;
    }

    /* renamed from: b */
    public static CharSequence m451b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    /* renamed from: a */
    public Notification m452a() {
        Notification build;
        Bundle bundle;
        C2208r3 c2208r3 = new C2208r3(this);
        AbstractC2190q3 abstractC2190q3 = c2208r3.f6336c.f6207l;
        if (abstractC2190q3 != null) {
            abstractC2190q3.mo432b(c2208r3);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            build = c2208r3.f6335b.build();
        } else if (i >= 24) {
            build = c2208r3.f6335b.build();
        } else {
            c2208r3.f6335b.setExtras(c2208r3.f6338e);
            build = c2208r3.f6335b.build();
        }
        Objects.requireNonNull(c2208r3.f6336c);
        if (abstractC2190q3 != null) {
            Objects.requireNonNull(c2208r3.f6336c.f6207l);
        }
        if (abstractC2190q3 != null && (bundle = build.extras) != null) {
            abstractC2190q3.mo433a(bundle);
        }
        return build;
    }

    /* renamed from: c */
    public C2170p3 m450c(boolean z) {
        if (z) {
            this.f6214s.flags |= 16;
        } else {
            this.f6214s.flags &= -17;
        }
        return this;
    }

    /* renamed from: d */
    public C2170p3 m449d(CharSequence charSequence) {
        this.f6201f = m451b(charSequence);
        return this;
    }

    /* renamed from: e */
    public C2170p3 m448e(CharSequence charSequence) {
        this.f6200e = m451b(charSequence);
        return this;
    }

    /* renamed from: f */
    public C2170p3 m447f(Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 27) {
            Resources resources = this.f6196a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(C1652e3.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(C1652e3.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
            }
        }
        this.f6203h = bitmap;
        return this;
    }

    /* renamed from: g */
    public C2170p3 m446g(AbstractC2190q3 abstractC2190q3) {
        if (this.f6207l != abstractC2190q3) {
            this.f6207l = abstractC2190q3;
            if (abstractC2190q3.f6261a != this) {
                abstractC2190q3.f6261a = this;
                m446g(abstractC2190q3);
            }
        }
        return this;
    }
}
