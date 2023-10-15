package p000;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* renamed from: s */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC2221s implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ View f6365a;

    /* renamed from: b */
    public final /* synthetic */ View f6366b;

    /* renamed from: c */
    public final /* synthetic */ AlertController f6367c;

    public RunnableC2221s(AlertController alertController, View view, View view2) {
        this.f6367c = alertController;
        this.f6365a = view;
        this.f6366b = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.m1691c(this.f6367c.f2239g, this.f6365a, this.f6366b);
    }
}
