package p000;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;

/* renamed from: w */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2302w implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    public final /* synthetic */ AlertController.RecycleListView f6720a;

    /* renamed from: b */
    public final /* synthetic */ AlertController f6721b;

    /* renamed from: c */
    public final /* synthetic */ AlertController.C0632b f6722c;

    public C2302w(AlertController.C0632b c0632b, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.f6722c = c0632b;
        this.f6720a = recycleListView;
        this.f6721b = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean[] zArr = this.f6722c.f2266E;
        if (zArr != null) {
            zArr[i] = this.f6720a.isItemChecked(i);
        }
        this.f6722c.f2270I.onClick(this.f6721b.f2234b, i, this.f6720a.isItemChecked(i));
    }
}
