package p000;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;

/* renamed from: t */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2243t extends ArrayAdapter<CharSequence> {

    /* renamed from: a */
    public final /* synthetic */ AlertController.RecycleListView f6423a;

    /* renamed from: b */
    public final /* synthetic */ AlertController.C0632b f6424b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2243t(AlertController.C0632b c0632b, Context context, int i, int i2, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i, i2, charSequenceArr);
        this.f6424b = c0632b;
        this.f6423a = recycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.f6424b.f2266E;
        if (zArr != null && zArr[i]) {
            this.f6423a.setItemChecked(i, true);
        }
        return view2;
    }
}
