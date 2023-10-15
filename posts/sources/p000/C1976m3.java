package p000;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* renamed from: m3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1976m3 {

    /* renamed from: a */
    public final Bundle f5480a;

    /* renamed from: b */
    public IconCompat f5481b;

    /* renamed from: c */
    public final C2270u3[] f5482c;

    /* renamed from: d */
    public final C2270u3[] f5483d;

    /* renamed from: e */
    public boolean f5484e;

    /* renamed from: f */
    public boolean f5485f;

    /* renamed from: g */
    public final int f5486g;

    /* renamed from: h */
    public final boolean f5487h;
    @Deprecated

    /* renamed from: i */
    public int f5488i;

    /* renamed from: j */
    public CharSequence f5489j;

    /* renamed from: k */
    public PendingIntent f5490k;

    public C1976m3(int i, CharSequence charSequence, PendingIntent pendingIntent) {
        IconCompat m1499b = i == 0 ? null : IconCompat.m1499b(null, "", i);
        Bundle bundle = new Bundle();
        this.f5485f = true;
        this.f5481b = m1499b;
        if (m1499b != null && m1499b.m1497d() == 2) {
            this.f5488i = m1499b.m1498c();
        }
        this.f5489j = C2170p3.m451b(charSequence);
        this.f5490k = pendingIntent;
        this.f5480a = bundle;
        this.f5482c = null;
        this.f5483d = null;
        this.f5484e = true;
        this.f5486g = 0;
        this.f5485f = true;
        this.f5487h = false;
    }

    /* renamed from: a */
    public IconCompat m597a() {
        int i;
        if (this.f5481b == null && (i = this.f5488i) != 0) {
            this.f5481b = IconCompat.m1499b(null, "", i);
        }
        return this.f5481b;
    }
}
