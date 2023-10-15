package p000;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* renamed from: Q4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0371Q4 {

    /* renamed from: a */
    public Object f1264a;

    public C0371Q4(Object obj) {
        this.f1264a = obj;
    }

    /* renamed from: a */
    public static C0371Q4 m2122a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new C0371Q4(PointerIcon.getSystemIcon(context, i));
        }
        return new C0371Q4(null);
    }
}
