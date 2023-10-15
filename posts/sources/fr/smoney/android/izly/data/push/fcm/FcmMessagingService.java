package fr.smoney.android.izly.data.push.fcm;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import fr.smoney.android.izly.SmoneyApplication;
import fr.smoney.android.izly.data.push.NotificationsDispatcherReceiver;
import fr.smoney.android.izly.p005ui.privateview.HomeActivity;
import fr.smoney.android.izly.p005ui.publicview.login.LoginActivity;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FcmMessagingService extends FirebaseMessagingService {

    /* renamed from: b */
    public static final String f4684b = FcmMessagingService.class.getSimpleName();

    /* renamed from: a */
    public Handler f4685a = new HandlerC1777a(Looper.getMainLooper());

    /* renamed from: fr.smoney.android.izly.data.push.fcm.FcmMessagingService$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class HandlerC1777a extends Handler {
        public HandlerC1777a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            PendingIntent activity;
            Bundle data = message.getData();
            StringBuilder sb = new StringBuilder();
            String str2 = FcmMessagingService.f4684b;
            sb.append(FcmMessagingService.f4684b);
            sb.append(" handleMessage message.getData(): ");
            sb.append(data);
            sb.toString();
            data.toString();
            FcmMessagingService fcmMessagingService = FcmMessagingService.this;
            Objects.requireNonNull(fcmMessagingService);
            String string = data.getString("message_notif");
            String string2 = data.getString("type");
            String string3 = data.getString("a4surl");
            Notification notification = null;
            if (data.getString("a4stitle") != null) {
                string2 = String.valueOf(91);
                String string4 = data.getString("a4stitle");
                string = data.getString("a4scontent");
                str = string4;
            } else {
                str = null;
            }
            if (string2 != null) {
                if (Integer.parseInt(string2) != 91) {
                    Intent intent = new Intent(fcmMessagingService, NotificationsDispatcherReceiver.class);
                    intent.putExtra("fr.smoney.android.izly.intentExtra.notifMessage", string);
                    activity = PendingIntent.getBroadcast(fcmMessagingService, 0, intent, 134217728);
                } else {
                    Intent intent2 = new Intent(fcmMessagingService, SmoneyApplication.f4205d.f1712b != null ? HomeActivity.class : LoginActivity.class);
                    if (string3 != null && string3.trim().length() > 0) {
                        intent2.setData(Uri.parse(string3));
                    }
                    activity = PendingIntent.getActivity(fcmMessagingService, 0, intent2, 0);
                }
                if (str == null) {
                    str = fcmMessagingService.getString(2131689548);
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    NotificationChannel notificationChannel = new NotificationChannel("default_channel", "Alertes", 3);
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(-16776961);
                    notificationChannel.enableVibration(true);
                    notificationChannel.setShowBadge(true);
                    notificationChannel.setLockscreenVisibility(0);
                    ((NotificationManager) fcmMessagingService.getSystemService("notification")).createNotificationChannel(notificationChannel);
                }
                C2170p3 c2170p3 = new C2170p3(fcmMessagingService, "default_channel");
                c2170p3.m449d(string);
                c2170p3.m448e(str);
                c2170p3.f6202g = activity;
                c2170p3.f6214s.icon = 2131231030;
                C2019o3 c2019o3 = new C2019o3();
                c2019o3.f6262b = C2170p3.m451b(str);
                c2019o3.m533d(string);
                c2170p3.m446g(c2019o3);
                notification = c2170p3.m452a();
                notification.flags |= 16;
                int i = notification.defaults | 1;
                notification.defaults = i;
                notification.defaults = i | 4;
            }
            if (notification != null) {
                ((NotificationManager) FcmMessagingService.this.getApplicationContext().getSystemService("notification")).notify(1, notification);
            }
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str = f4684b;
        remoteMessage.getFrom();
        remoteMessage.getCollapseKey();
        remoteMessage.getMessageId();
        remoteMessage.getMessageType();
        remoteMessage.getTo();
        String str2 = str + " onMessageReceived getData: " + remoteMessage.getData();
        String str3 = str + " onMessageReceived getNotif: " + remoteMessage.getNotification();
        remoteMessage.getOriginalPriority();
        remoteMessage.getPriority();
        remoteMessage.getSentTime();
        remoteMessage.getTtl();
        if (!remoteMessage.getData().isEmpty()) {
            this.f4685a.obtainMessage().sendToTarget();
            return;
        }
        String body = remoteMessage.getNotification() != null ? remoteMessage.getNotification().getBody() : "null";
        Bundle bundle = new Bundle();
        bundle.putCharSequence("message_notif", body);
        bundle.putCharSequence("type", "-1");
        Message obtainMessage = this.f4685a.obtainMessage();
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }
}
