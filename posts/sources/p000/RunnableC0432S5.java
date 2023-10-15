package p000;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;

/* renamed from: S5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class RunnableC0432S5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Fragment f1403a;

    /* renamed from: b */
    public final /* synthetic */ Fragment f1404b;

    /* renamed from: c */
    public final /* synthetic */ boolean f1405c;

    /* renamed from: d */
    public final /* synthetic */ C2339x1 f1406d;

    /* renamed from: f */
    public final /* synthetic */ View f1407f;

    /* renamed from: g */
    public final /* synthetic */ AbstractC0589Z5 f1408g;

    /* renamed from: h */
    public final /* synthetic */ Rect f1409h;

    public RunnableC0432S5(Fragment fragment, Fragment fragment2, boolean z, C2339x1 c2339x1, View view, AbstractC0589Z5 abstractC0589Z5, Rect rect) {
        this.f1403a = fragment;
        this.f1404b = fragment2;
        this.f1405c = z;
        this.f1406d = c2339x1;
        this.f1407f = view;
        this.f1408g = abstractC0589Z5;
        this.f1409h = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        C0471U5.m1996c(this.f1403a, this.f1404b, this.f1405c, this.f1406d, false);
        View view = this.f1407f;
        if (view != null) {
            this.f1408g.m1744j(view, this.f1409h);
        }
    }
}
