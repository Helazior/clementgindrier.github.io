package p000;

import android.view.View;
import androidx.appcompat.app.AlertController;

/* renamed from: q */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC2185q implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ View f6254a;

    /* renamed from: b */
    public final /* synthetic */ View f6255b;

    /* renamed from: c */
    public final /* synthetic */ AlertController f6256c;

    public RunnableC2185q(AlertController alertController, View view, View view2) {
        this.f6256c = alertController;
        this.f6254a = view;
        this.f6255b = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        AlertController.m1691c(this.f6256c.f2215A, this.f6254a, this.f6255b);
    }
}
