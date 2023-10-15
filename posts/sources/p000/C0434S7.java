package p000;

import android.annotation.SuppressLint;
import android.view.View;

/* renamed from: S7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0434S7 extends C0559X7 {

    /* renamed from: c */
    public static boolean f1414c = true;

    @Override // p000.C0559X7
    /* renamed from: a */
    public void mo1802a(View view) {
    }

    @Override // p000.C0559X7
    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public float mo1801b(View view) {
        if (f1414c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f1414c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // p000.C0559X7
    /* renamed from: c */
    public void mo1800c(View view) {
    }

    @Override // p000.C0559X7
    @SuppressLint({"NewApi"})
    /* renamed from: f */
    public void mo1797f(View view, float f) {
        if (f1414c) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                f1414c = false;
            }
        }
        view.setAlpha(f);
    }
}
