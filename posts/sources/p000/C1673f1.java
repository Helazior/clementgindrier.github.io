package p000;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* renamed from: f1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1673f1 {

    /* renamed from: a */
    public final Context f4169a;

    /* renamed from: b */
    public final View f4170b;

    /* renamed from: c */
    public final TextView f4171c;

    /* renamed from: d */
    public final WindowManager.LayoutParams f4172d;

    /* renamed from: e */
    public final Rect f4173e;

    /* renamed from: f */
    public final int[] f4174f;

    /* renamed from: g */
    public final int[] f4175g;

    public C1673f1(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f4172d = layoutParams;
        this.f4173e = new Rect();
        this.f4174f = new int[2];
        this.f4175g = new int[2];
        this.f4169a = context;
        View inflate = LayoutInflater.from(context).inflate(C1949l.abc_tooltip, (ViewGroup) null);
        this.f4170b = inflate;
        this.f4171c = (TextView) inflate.findViewById(C1930k.message);
        layoutParams.setTitle(C1673f1.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = C1988n.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    /* renamed from: a */
    public void m987a() {
        if (this.f4170b.getParent() != null) {
            ((WindowManager) this.f4169a.getSystemService("window")).removeView(this.f4170b);
        }
    }
}
