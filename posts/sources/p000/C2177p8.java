package p000;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;

/* renamed from: p8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2177p8 {

    /* renamed from: b */
    public static final ViewGroup.MarginLayoutParams f6235b;

    /* renamed from: a */
    public LinearLayoutManager f6236a;

    static {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -1);
        f6235b = marginLayoutParams;
        marginLayoutParams.setMargins(0, 0, 0, 0);
    }

    public C2177p8(LinearLayoutManager linearLayoutManager) {
        this.f6236a = linearLayoutManager;
    }

    /* renamed from: a */
    public static boolean m439a(View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LayoutTransition layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null && layoutTransition.isChangingLayout()) {
                return true;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (m439a(viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }
}
