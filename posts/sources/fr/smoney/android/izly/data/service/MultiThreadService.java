package fr.smoney.android.izly.data.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class MultiThreadService extends Service {

    /* renamed from: a */
    public ExecutorService f4695a;

    /* renamed from: b */
    public int f4696b;

    /* renamed from: c */
    public ArrayList<Future> f4697c;

    /* renamed from: d */
    public Handler f4698d;

    /* renamed from: f */
    public final Runnable f4699f = new RunnableC1779a();

    /* renamed from: fr.smoney.android.izly.data.service.MultiThreadService$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC1779a implements Runnable {
        public RunnableC1779a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<Future> arrayList = MultiThreadService.this.f4697c;
            int i = 0;
            while (i < arrayList.size()) {
                if (arrayList.get(i).isDone()) {
                    arrayList.remove(i);
                    i--;
                }
                i++;
            }
            if (arrayList.isEmpty()) {
                MultiThreadService.this.stopSelf();
            }
        }
    }

    /* renamed from: fr.smoney.android.izly.data.service.MultiThreadService$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC1780b implements Runnable {

        /* renamed from: a */
        public Intent f4701a;

        public RunnableC1780b(Intent intent) {
            this.f4701a = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiThreadService.this.mo947a(this.f4701a);
            MultiThreadService multiThreadService = MultiThreadService.this;
            multiThreadService.f4698d.post(multiThreadService.f4699f);
        }
    }

    public MultiThreadService(int i) {
        this.f4696b = i;
    }

    /* renamed from: a */
    public abstract void mo947a(Intent intent);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f4695a = Executors.newFixedThreadPool(this.f4696b);
        this.f4698d = new Handler();
        this.f4697c = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("my_channel_01", "Connectivité", 0));
            startForeground(1, new C2170p3(this, "my_channel_01").m452a());
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.f4697c.add(this.f4695a.submit(new RunnableC1780b(intent)));
        return 1;
    }
}
