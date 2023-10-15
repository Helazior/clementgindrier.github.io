package androidx.core.app;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class JobIntentService extends Service {

    /* renamed from: g */
    public static final HashMap<ComponentName, AbstractC0737g> f2955g = new HashMap<>();

    /* renamed from: a */
    public InterfaceC0731b f2956a;

    /* renamed from: b */
    public AbstractC0737g f2957b;

    /* renamed from: c */
    public AsyncTaskC0730a f2958c;

    /* renamed from: d */
    public boolean f2959d = false;

    /* renamed from: f */
    public final ArrayList<C0733d> f2960f;

    /* renamed from: androidx.core.app.JobIntentService$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class AsyncTaskC0730a extends AsyncTask<Void, Void, Void> {
        public AsyncTaskC0730a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x004c A[LOOP:0: B:3:0x0002->B:28:0x004c, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0059 A[SYNTHETIC] */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Void[] r5) {
            /*
                r4 = this;
                java.lang.Void[] r5 = (java.lang.Void[]) r5
            L2:
                androidx.core.app.JobIntentService r5 = androidx.core.app.JobIntentService.this
                androidx.core.app.JobIntentService$b r0 = r5.f2956a
                r1 = 0
                if (r0 == 0) goto L31
                androidx.core.app.JobIntentService$f r0 = (androidx.core.app.JobIntentService.jobJobServiceEngineC0735f) r0
                java.lang.Object r2 = r0.f2969b
                monitor-enter(r2)
                android.app.job.JobParameters r5 = r0.f2970c     // Catch: java.lang.Throwable -> L2e
                if (r5 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2e
                goto L49
            L14:
                android.app.job.JobWorkItem r5 = r5.dequeueWork()     // Catch: java.lang.Throwable -> L2e
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2e
                if (r5 == 0) goto L49
                android.content.Intent r2 = r5.getIntent()
                androidx.core.app.JobIntentService r3 = r0.f2968a
                java.lang.ClassLoader r3 = r3.getClassLoader()
                r2.setExtrasClassLoader(r3)
                androidx.core.app.JobIntentService$f$a r2 = new androidx.core.app.JobIntentService$f$a
                r2.<init>(r5)
                goto L4a
            L2e:
                r5 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2e
                throw r5
            L31:
                java.util.ArrayList<androidx.core.app.JobIntentService$d> r0 = r5.f2960f
                monitor-enter(r0)
                java.util.ArrayList<androidx.core.app.JobIntentService$d> r2 = r5.f2960f     // Catch: java.lang.Throwable -> L5a
                int r2 = r2.size()     // Catch: java.lang.Throwable -> L5a
                if (r2 <= 0) goto L48
                java.util.ArrayList<androidx.core.app.JobIntentService$d> r5 = r5.f2960f     // Catch: java.lang.Throwable -> L5a
                r2 = 0
                java.lang.Object r5 = r5.remove(r2)     // Catch: java.lang.Throwable -> L5a
                r2 = r5
                androidx.core.app.JobIntentService$e r2 = (androidx.core.app.JobIntentService.InterfaceC0734e) r2     // Catch: java.lang.Throwable -> L5a
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
                goto L4a
            L48:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
            L49:
                r2 = r1
            L4a:
                if (r2 == 0) goto L59
                androidx.core.app.JobIntentService r5 = androidx.core.app.JobIntentService.this
                android.content.Intent r0 = r2.getIntent()
                r5.m1510b(r0)
                r2.mo1508a()
                goto L2
            L59:
                return r1
            L5a:
                r5 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L5a
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.JobIntentService.AsyncTaskC0730a.doInBackground(java.lang.Object[]):java.lang.Object");
        }

        @Override // android.os.AsyncTask
        public void onCancelled(Void r1) {
            JobIntentService.this.m1509c();
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Void r1) {
            JobIntentService.this.m1509c();
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0731b {
    }

    /* renamed from: androidx.core.app.JobIntentService$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0732c extends AbstractC0737g {

        /* renamed from: b */
        public final PowerManager.WakeLock f2962b;

        /* renamed from: c */
        public final PowerManager.WakeLock f2963c;

        /* renamed from: d */
        public boolean f2964d;

        public C0732c(Context context, ComponentName componentName) {
            super(componentName);
            context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.f2962b = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f2963c = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // androidx.core.app.JobIntentService.AbstractC0737g
        /* renamed from: a */
        public void mo1507a() {
            synchronized (this) {
                if (this.f2964d) {
                    this.f2964d = false;
                    this.f2963c.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.AbstractC0737g
        /* renamed from: b */
        public void mo1506b() {
            synchronized (this) {
                if (!this.f2964d) {
                    this.f2964d = true;
                    this.f2963c.acquire(600000L);
                    this.f2962b.release();
                }
            }
        }

        @Override // androidx.core.app.JobIntentService.AbstractC0737g
        /* renamed from: c */
        public void mo1505c() {
            synchronized (this) {
            }
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0733d implements InterfaceC0734e {

        /* renamed from: a */
        public final Intent f2965a;

        /* renamed from: b */
        public final int f2966b;

        public C0733d(Intent intent, int i) {
            this.f2965a = intent;
            this.f2966b = i;
        }

        @Override // androidx.core.app.JobIntentService.InterfaceC0734e
        /* renamed from: a */
        public void mo1508a() {
            JobIntentService.this.stopSelf(this.f2966b);
        }

        @Override // androidx.core.app.JobIntentService.InterfaceC0734e
        public Intent getIntent() {
            return this.f2965a;
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0734e {
        /* renamed from: a */
        void mo1508a();

        Intent getIntent();
    }

    /* renamed from: androidx.core.app.JobIntentService$f  reason: invalid class name */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class jobJobServiceEngineC0735f extends JobServiceEngine implements InterfaceC0731b {

        /* renamed from: a */
        public final JobIntentService f2968a;

        /* renamed from: b */
        public final Object f2969b;

        /* renamed from: c */
        public JobParameters f2970c;

        /* renamed from: androidx.core.app.JobIntentService$f$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public final class C0736a implements InterfaceC0734e {

            /* renamed from: a */
            public final JobWorkItem f2971a;

            public C0736a(JobWorkItem jobWorkItem) {
                this.f2971a = jobWorkItem;
            }

            @Override // androidx.core.app.JobIntentService.InterfaceC0734e
            /* renamed from: a */
            public void mo1508a() {
                synchronized (jobJobServiceEngineC0735f.this.f2969b) {
                    JobParameters jobParameters = jobJobServiceEngineC0735f.this.f2970c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f2971a);
                    }
                }
            }

            @Override // androidx.core.app.JobIntentService.InterfaceC0734e
            public Intent getIntent() {
                return this.f2971a.getIntent();
            }
        }

        public jobJobServiceEngineC0735f(JobIntentService jobIntentService) {
            super(jobIntentService);
            this.f2969b = new Object();
            this.f2968a = jobIntentService;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStartJob(JobParameters jobParameters) {
            this.f2970c = jobParameters;
            this.f2968a.m1511a(false);
            return true;
        }

        @Override // android.app.job.JobServiceEngine
        public boolean onStopJob(JobParameters jobParameters) {
            AsyncTaskC0730a asyncTaskC0730a = this.f2968a.f2958c;
            if (asyncTaskC0730a != null) {
                asyncTaskC0730a.cancel(false);
            }
            synchronized (this.f2969b) {
                this.f2970c = null;
            }
            return true;
        }
    }

    /* renamed from: androidx.core.app.JobIntentService$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0737g {

        /* renamed from: a */
        public final ComponentName f2973a;

        public AbstractC0737g(ComponentName componentName) {
            this.f2973a = componentName;
        }

        /* renamed from: a */
        public void mo1507a() {
        }

        /* renamed from: b */
        public void mo1506b() {
        }

        /* renamed from: c */
        public void mo1505c() {
        }
    }

    public JobIntentService() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2960f = null;
        } else {
            this.f2960f = new ArrayList<>();
        }
    }

    /* renamed from: a */
    public void m1511a(boolean z) {
        if (this.f2958c == null) {
            this.f2958c = new AsyncTaskC0730a();
            AbstractC0737g abstractC0737g = this.f2957b;
            if (abstractC0737g != null && z) {
                abstractC0737g.mo1506b();
            }
            this.f2958c.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    /* renamed from: b */
    public abstract void m1510b(Intent intent);

    /* renamed from: c */
    public void m1509c() {
        ArrayList<C0733d> arrayList = this.f2960f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2958c = null;
                ArrayList<C0733d> arrayList2 = this.f2960f;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    m1511a(false);
                } else if (!this.f2959d) {
                    this.f2957b.mo1507a();
                }
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterfaceC0731b interfaceC0731b = this.f2956a;
        if (interfaceC0731b != null) {
            return ((jobJobServiceEngineC0735f) interfaceC0731b).getBinder();
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f2956a = new jobJobServiceEngineC0735f(this);
            this.f2957b = null;
            return;
        }
        this.f2956a = null;
        ComponentName componentName = new ComponentName(this, getClass());
        HashMap<ComponentName, AbstractC0737g> hashMap = f2955g;
        AbstractC0737g abstractC0737g = hashMap.get(componentName);
        if (abstractC0737g == null) {
            if (i < 26) {
                abstractC0737g = new C0732c(this, componentName);
                hashMap.put(componentName, abstractC0737g);
            } else {
                throw new IllegalArgumentException("Can't be here without a job id");
            }
        }
        this.f2957b = abstractC0737g;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        ArrayList<C0733d> arrayList = this.f2960f;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.f2959d = true;
                this.f2957b.mo1507a();
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (this.f2960f != null) {
            this.f2957b.mo1505c();
            synchronized (this.f2960f) {
                ArrayList<C0733d> arrayList = this.f2960f;
                if (intent == null) {
                    intent = new Intent();
                }
                arrayList.add(new C0733d(intent, i2));
                m1511a(true);
            }
            return 3;
        }
        return 2;
    }
}
