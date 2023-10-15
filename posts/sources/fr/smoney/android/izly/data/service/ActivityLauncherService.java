package fr.smoney.android.izly.data.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import fr.smoney.android.izly.p005ui.publicview.login.LoginActivity;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActivityLauncherService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String stringExtra = intent.getStringExtra("fr.smoney.android.izly.extras.serviceActivityLauncher");
        if (stringExtra != null && stringExtra.equals("fr.smoney.android.izly.ui.publicview.activation.PhoneValidationActivity")) {
            Intent intent2 = new Intent(this, LoginActivity.class);
            intent2.setData(intent.getData());
            intent2.putExtra("fr.smoney.android.izly.extras.startByBrowser", false);
            intent2.setFlags(335544320);
            intent2.putExtra("fr.smoney.android.izly.extras.launchActivity", 5);
            startActivity(intent2);
        }
        stopSelf();
        return 2;
    }
}
