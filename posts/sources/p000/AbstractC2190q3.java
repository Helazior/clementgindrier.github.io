package p000;

import android.os.Bundle;

/* renamed from: q3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2190q3 {

    /* renamed from: a */
    public C2170p3 f6261a;

    /* renamed from: b */
    public CharSequence f6262b;

    /* renamed from: a */
    public void mo433a(Bundle bundle) {
        CharSequence charSequence = this.f6262b;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        String mo431c = mo431c();
        if (mo431c != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", mo431c);
        }
    }

    /* renamed from: b */
    public abstract void mo432b(InterfaceC1955l3 interfaceC1955l3);

    /* renamed from: c */
    public abstract String mo431c();
}
