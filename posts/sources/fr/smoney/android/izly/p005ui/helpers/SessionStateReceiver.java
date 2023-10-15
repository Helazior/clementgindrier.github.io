package fr.smoney.android.izly.p005ui.helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: fr.smoney.android.izly.ui.helpers.SessionStateReceiver */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class SessionStateReceiver extends BroadcastReceiver {
    @Nullable

    /* renamed from: a */
    public SessionStateReceiver f4704a;
    @NotNull

    /* renamed from: b */
    public final Context f4705b;
    @Nullable

    /* renamed from: c */
    public final InterfaceC1879hd f4706c;

    public SessionStateReceiver(@NotNull Context context, @Nullable InterfaceC1879hd interfaceC1879hd) {
        C0581Yd.m1766e(context, "context");
        this.f4705b = context;
        this.f4706c = interfaceC1879hd;
        this.f4704a = this;
    }

    /* renamed from: a */
    public final void m939a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("fr.smoney.android.izly.notifications.NOTIFICATION_SESSION_STATE_CHANGE_INTENT_URI");
        if (this.f4704a == null) {
            this.f4704a = new SessionStateReceiver(this.f4705b, this.f4706c);
        }
        this.f4705b.registerReceiver(this.f4704a, intentFilter);
    }

    /* renamed from: b */
    public final void m938b() {
        this.f4705b.unregisterReceiver(this.f4704a);
        this.f4704a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @Nullable Intent intent) {
        C0581Yd.m1766e(context, "context");
        InterfaceC1879hd interfaceC1879hd = this.f4706c;
        if (interfaceC1879hd != null) {
            interfaceC1879hd.mo2a(context, intent);
        }
    }
}
