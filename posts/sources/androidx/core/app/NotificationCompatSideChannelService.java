package androidx.core.app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL")) {
        }
        return null;
    }
}
