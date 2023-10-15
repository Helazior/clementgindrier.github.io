package p000;

import android.view.View;
import android.view.WindowId;

/* renamed from: Z7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0591Z7 implements InterfaceC0612a8 {

    /* renamed from: a */
    public final WindowId f2100a;

    public C0591Z7(View view) {
        this.f2100a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0591Z7) && ((C0591Z7) obj).f2100a.equals(this.f2100a);
    }

    public int hashCode() {
        return this.f2100a.hashCode();
    }
}
