package p000;

import android.app.Activity;

/* renamed from: i3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC1885i3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Activity f5241a;

    public RunnableC1885i3(Activity activity) {
        this.f5241a = activity;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f5241a.isFinishing() || C1911j3.m701b(this.f5241a)) {
            return;
        }
        this.f5241a.recreate();
    }
}
