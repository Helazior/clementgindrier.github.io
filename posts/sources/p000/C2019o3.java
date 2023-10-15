package p000;

import android.app.Notification;
import android.os.Bundle;

/* renamed from: o3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2019o3 extends AbstractC2190q3 {

    /* renamed from: c */
    public CharSequence f5585c;

    @Override // p000.AbstractC2190q3
    /* renamed from: a */
    public void mo433a(Bundle bundle) {
        CharSequence charSequence = this.f6262b;
        if (charSequence != null) {
            bundle.putCharSequence("android.title.big", charSequence);
        }
        bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", "androidx.core.app.NotificationCompat$BigTextStyle");
    }

    @Override // p000.AbstractC2190q3
    /* renamed from: b */
    public void mo432b(InterfaceC1955l3 interfaceC1955l3) {
        new Notification.BigTextStyle(((C2208r3) interfaceC1955l3).f6335b).setBigContentTitle(this.f6262b).bigText(this.f5585c);
    }

    @Override // p000.AbstractC2190q3
    /* renamed from: c */
    public String mo431c() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }

    /* renamed from: d */
    public C2019o3 m533d(CharSequence charSequence) {
        this.f5585c = C2170p3.m451b(charSequence);
        return this;
    }
}
