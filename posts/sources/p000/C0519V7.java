package p000;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* renamed from: V7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0519V7 extends C0478U7 {

    /* renamed from: h */
    public static boolean f1841h = true;

    @Override // p000.C0559X7
    @SuppressLint({"NewApi"})
    /* renamed from: g */
    public void mo1796g(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.mo1796g(view, i);
        } else if (f1841h) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError unused) {
                f1841h = false;
            }
        }
    }
}
