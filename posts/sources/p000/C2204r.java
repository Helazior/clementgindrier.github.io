package p000;

import android.view.View;
import android.widget.AbsListView;
import androidx.appcompat.app.AlertController;

/* renamed from: r */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2204r implements AbsListView.OnScrollListener {

    /* renamed from: a */
    public final /* synthetic */ View f6311a;

    /* renamed from: b */
    public final /* synthetic */ View f6312b;

    public C2204r(AlertController alertController, View view, View view2) {
        this.f6311a = view;
        this.f6312b = view2;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AlertController.m1691c(absListView, this.f6311a, this.f6312b);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
