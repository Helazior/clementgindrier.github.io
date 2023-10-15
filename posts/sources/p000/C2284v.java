package p000;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* renamed from: v */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2284v implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ AlertController f6637a;

    /* renamed from: b */
    public final /* synthetic */ AlertController.C0632b f6638b;

    public C2284v(AlertController.C0632b c0632b, AlertController alertController) {
        this.f6638b = c0632b;
        this.f6637a = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f6638b.f2297w.onClick(this.f6637a.f2234b, i);
        if (this.f6638b.f2268G) {
            return;
        }
        this.f6637a.f2234b.dismiss();
    }
}
