package p000;

import android.graphics.Matrix;
import android.view.View;

/* renamed from: W7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0538W7 extends C0519V7 {
    @Override // p000.C0434S7, p000.C0559X7
    /* renamed from: b */
    public float mo1801b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // p000.C0457T7, p000.C0559X7
    /* renamed from: d */
    public void mo1799d(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // p000.C0478U7, p000.C0559X7
    /* renamed from: e */
    public void mo1798e(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // p000.C0434S7, p000.C0559X7
    /* renamed from: f */
    public void mo1797f(View view, float f) {
        view.setTransitionAlpha(f);
    }

    @Override // p000.C0519V7, p000.C0559X7
    /* renamed from: g */
    public void mo1796g(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // p000.C0457T7, p000.C0559X7
    /* renamed from: h */
    public void mo1795h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // p000.C0457T7, p000.C0559X7
    /* renamed from: i */
    public void mo1794i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
