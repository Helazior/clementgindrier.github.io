package p000;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.ListPopupWindow;

/* renamed from: P0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0345P0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    public final /* synthetic */ ListPopupWindow f1162a;

    public C0345P0(ListPopupWindow listPopupWindow) {
        this.f1162a = listPopupWindow;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        C0281M0 c0281m0;
        if (i == -1 || (c0281m0 = this.f1162a.f2517c) == null) {
            return;
        }
        c0281m0.f936j = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
