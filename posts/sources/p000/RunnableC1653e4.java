package p000;

import android.graphics.Typeface;
import p000.C0103E3;
import p000.C0213J3;

/* renamed from: e4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC1653e4 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C2191q4 f4136a;

    /* renamed from: b */
    public final /* synthetic */ Typeface f4137b;

    public RunnableC1653e4(C1835g4 c1835g4, C2191q4 c2191q4, Typeface typeface) {
        this.f4136a = c2191q4;
        this.f4137b = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2191q4 c2191q4 = this.f4136a;
        Typeface typeface = this.f4137b;
        C0103E3.AbstractC0106c abstractC0106c = ((C0213J3.C0214a) c2191q4).f680a;
        if (abstractC0106c != null) {
            abstractC0106c.onFontRetrieved(typeface);
        }
    }
}
