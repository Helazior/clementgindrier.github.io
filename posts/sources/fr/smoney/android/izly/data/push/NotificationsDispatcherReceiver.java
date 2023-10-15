package fr.smoney.android.izly.data.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import fr.smoney.android.izly.SmoneyApplication;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NotificationsDispatcherReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public static final String f4683a = NotificationsDispatcherReceiver.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        StringBuilder sb = new StringBuilder();
        String str = f4683a;
        sb.append(str);
        sb.append(" onReceive() context:");
        sb.append(context);
        sb.toString();
        String str2 = str + " onReceive() intent:" + intent;
        intent.getStringExtra("fr.smoney.android.izly.intentExtra.notifMessage");
        C0479U8 c0479u8 = SmoneyApplication.f4205d;
        if (c0479u8 != null) {
            c0479u8.f1681B0 = true;
            c0479u8.f1685D0 = true;
            c0479u8.f1683C0 = true;
            c0479u8.f1687E0 = true;
            Objects.requireNonNull(c0479u8);
        }
    }
}
