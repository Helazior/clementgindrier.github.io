package p000;

import android.view.View;
import androidx.appcompat.app.AlertController;
import androidx.core.widget.NestedScrollView;

/* renamed from: p */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2164p implements NestedScrollView.InterfaceC0742b {

    /* renamed from: a */
    public final /* synthetic */ View f6174a;

    /* renamed from: b */
    public final /* synthetic */ View f6175b;

    public C2164p(AlertController alertController, View view, View view2) {
        this.f6174a = view;
        this.f6175b = view2;
    }

    @Override // androidx.core.widget.NestedScrollView.InterfaceC0742b
    /* renamed from: a */
    public void mo459a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
        AlertController.m1691c(nestedScrollView, this.f6174a, this.f6175b);
    }
}
