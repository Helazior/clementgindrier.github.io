package p000;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: b7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0971b7 {

    /* renamed from: a */
    public final RecyclerView.AbstractC0843o f3712a;

    /* renamed from: b */
    public int f3713b = Integer.MIN_VALUE;

    /* renamed from: c */
    public final Rect f3714c = new Rect();

    public AbstractC0971b7(RecyclerView.AbstractC0843o abstractC0843o, C0590Z6 c0590z6) {
        this.f3712a = abstractC0843o;
    }

    /* renamed from: a */
    public static AbstractC0971b7 m1161a(RecyclerView.AbstractC0843o abstractC0843o, int i) {
        if (i != 0) {
            if (i == 1) {
                return new C0611a7(abstractC0843o);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return new C0590Z6(abstractC0843o);
    }

    /* renamed from: b */
    public abstract int mo1160b(View view);

    /* renamed from: c */
    public abstract int mo1159c(View view);

    /* renamed from: d */
    public abstract int mo1158d(View view);

    /* renamed from: e */
    public abstract int mo1157e(View view);

    /* renamed from: f */
    public abstract int mo1156f();

    /* renamed from: g */
    public abstract int mo1155g();

    /* renamed from: h */
    public abstract int mo1154h();

    /* renamed from: i */
    public abstract int mo1153i();

    /* renamed from: j */
    public abstract int mo1152j();

    /* renamed from: k */
    public abstract int mo1151k();

    /* renamed from: l */
    public abstract int mo1150l();

    /* renamed from: m */
    public int m1149m() {
        if (Integer.MIN_VALUE == this.f3713b) {
            return 0;
        }
        return mo1150l() - this.f3713b;
    }

    /* renamed from: n */
    public abstract int mo1148n(View view);

    /* renamed from: o */
    public abstract int mo1147o(View view);

    /* renamed from: p */
    public abstract void mo1146p(int i);
}
