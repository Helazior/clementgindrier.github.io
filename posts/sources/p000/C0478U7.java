package p000;

import android.annotation.SuppressLint;
import android.view.View;

/* renamed from: U7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0478U7 extends C0457T7 {

    /* renamed from: g */
    public static boolean f1677g = true;

    @Override // p000.C0559X7
    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public void mo1798e(View view, int i, int i2, int i3, int i4) {
        if (f1677g) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                f1677g = false;
            }
        }
    }
}
