package p000;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* renamed from: T7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0457T7 extends C0434S7 {

    /* renamed from: d */
    public static boolean f1594d = true;

    /* renamed from: e */
    public static boolean f1595e = true;

    /* renamed from: f */
    public static boolean f1596f = true;

    @Override // p000.C0559X7
    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public void mo1799d(View view, Matrix matrix) {
        if (f1594d) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f1594d = false;
            }
        }
    }

    @Override // p000.C0559X7
    @SuppressLint({"NewApi"})
    /* renamed from: h */
    public void mo1795h(View view, Matrix matrix) {
        if (f1595e) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f1595e = false;
            }
        }
    }

    @Override // p000.C0559X7
    @SuppressLint({"NewApi"})
    /* renamed from: i */
    public void mo1794i(View view, Matrix matrix) {
        if (f1596f) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f1596f = false;
            }
        }
    }
}
