package p000;

import android.app.Notification;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* renamed from: n3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1998n3 extends AbstractC2190q3 {

    /* renamed from: c */
    public Bitmap f5523c;

    /* renamed from: d */
    public IconCompat f5524d;

    /* renamed from: e */
    public boolean f5525e;

    @Override // p000.AbstractC2190q3
    /* renamed from: b */
    public void mo432b(InterfaceC1955l3 interfaceC1955l3) {
        int i = Build.VERSION.SDK_INT;
        C2208r3 c2208r3 = (C2208r3) interfaceC1955l3;
        Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle(c2208r3.f6335b).setBigContentTitle(this.f6262b).bigPicture(this.f5523c);
        if (this.f5525e) {
            IconCompat iconCompat = this.f5524d;
            Bitmap bitmap = null;
            if (iconCompat == null) {
                bigPicture.bigLargeIcon((Bitmap) null);
            } else if (i >= 23) {
                bigPicture.bigLargeIcon(iconCompat.m1494g(c2208r3.f6334a));
            } else if (iconCompat.m1497d() == 1) {
                IconCompat iconCompat2 = this.f5524d;
                int i2 = iconCompat2.f2987a;
                if (i2 == -1 && i >= 23) {
                    Object obj = iconCompat2.f2988b;
                    if (obj instanceof Bitmap) {
                        bitmap = (Bitmap) obj;
                    }
                } else if (i2 == 1) {
                    bitmap = (Bitmap) iconCompat2.f2988b;
                } else if (i2 == 5) {
                    bitmap = IconCompat.m1500a((Bitmap) iconCompat2.f2988b, true);
                } else {
                    throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                }
                bigPicture.bigLargeIcon(bitmap);
            } else {
                bigPicture.bigLargeIcon((Bitmap) null);
            }
        }
    }

    @Override // p000.AbstractC2190q3
    /* renamed from: c */
    public String mo431c() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }

    /* renamed from: d */
    public C1998n3 m577d(Bitmap bitmap) {
        this.f5524d = null;
        this.f5525e = true;
        return this;
    }
}
