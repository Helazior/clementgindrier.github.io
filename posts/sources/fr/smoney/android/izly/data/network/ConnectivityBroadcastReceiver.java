package fr.smoney.android.izly.data.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ConnectivityBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    public InterfaceC1899id f4680a;

    /* renamed from: b */
    public boolean f4681b = false;

    /* renamed from: c */
    public boolean f4682c;

    public ConnectivityBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (this.f4680a == null) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
        if (action.equals("fr.smoney.android.izly.notifications.NOTIFICATION_LOGON_STATE_CHANGE_ERROR_INTENT_URI")) {
            this.f4680a.mo725p(false, intent.getBooleanExtra("fr.smoney.android.izly.logonStateError", false));
        } else if (booleanExtra) {
            if (this.f4681b) {
                this.f4680a.mo725p(false, false);
                this.f4681b = false;
            }
            if (this.f4682c) {
                return;
            }
            this.f4680a.mo725p(false, false);
            this.f4682c = true;
        } else {
            if (!this.f4681b) {
                this.f4680a.mo724q(true, false);
                this.f4681b = true;
            }
            if (this.f4682c) {
                return;
            }
            this.f4680a.mo724q(true, false);
            this.f4682c = true;
        }
    }

    public ConnectivityBroadcastReceiver(InterfaceC1899id interfaceC1899id) {
        this.f4680a = interfaceC1899id;
    }
}
