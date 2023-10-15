package p000;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: j3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C1911j3 {

    /* renamed from: a */
    public static final Class<?> f5318a;

    /* renamed from: b */
    public static final Field f5319b;

    /* renamed from: c */
    public static final Field f5320c;

    /* renamed from: d */
    public static final Method f5321d;

    /* renamed from: e */
    public static final Method f5322e;

    /* renamed from: f */
    public static final Method f5323f;

    /* renamed from: g */
    public static final Handler f5324g = new Handler(Looper.getMainLooper());

    /* renamed from: j3$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC1912a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ C1914c f5325a;

        /* renamed from: b */
        public final /* synthetic */ Object f5326b;

        public RunnableC1912a(C1914c c1914c, Object obj) {
            this.f5325a = c1914c;
            this.f5326b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5325a.f5329a = this.f5326b;
        }
    }

    /* renamed from: j3$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC1913b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Application f5327a;

        /* renamed from: b */
        public final /* synthetic */ C1914c f5328b;

        public RunnableC1913b(Application application, C1914c c1914c) {
            this.f5327a = application;
            this.f5328b = c1914c;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5327a.unregisterActivityLifecycleCallbacks(this.f5328b);
        }
    }

    /* renamed from: j3$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1914c implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        public Object f5329a;

        /* renamed from: b */
        public Activity f5330b;

        /* renamed from: c */
        public final int f5331c;

        /* renamed from: d */
        public boolean f5332d = false;

        /* renamed from: f */
        public boolean f5333f = false;

        /* renamed from: g */
        public boolean f5334g = false;

        public C1914c(Activity activity) {
            this.f5330b = activity;
            this.f5331c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f5330b == activity) {
                this.f5330b = null;
                this.f5333f = true;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x003d, code lost:
            r5.f5334g = true;
            r5.f5329a = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
            return;
         */
        @Override // android.app.Application.ActivityLifecycleCallbacks
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onActivityPaused(android.app.Activity r6) {
            /*
                r5 = this;
                boolean r0 = r5.f5333f
                if (r0 == 0) goto L42
                boolean r0 = r5.f5334g
                if (r0 != 0) goto L42
                boolean r0 = r5.f5332d
                if (r0 != 0) goto L42
                java.lang.Object r0 = r5.f5329a
                int r1 = r5.f5331c
                r2 = 0
                r3 = 1
                java.lang.reflect.Field r4 = p000.C1911j3.f5320c     // Catch: java.lang.Throwable -> L33
                java.lang.Object r4 = r4.get(r6)     // Catch: java.lang.Throwable -> L33
                if (r4 != r0) goto L3b
                int r0 = r6.hashCode()     // Catch: java.lang.Throwable -> L33
                if (r0 == r1) goto L21
                goto L3b
            L21:
                java.lang.reflect.Field r0 = p000.C1911j3.f5319b     // Catch: java.lang.Throwable -> L33
                java.lang.Object r6 = r0.get(r6)     // Catch: java.lang.Throwable -> L33
                android.os.Handler r0 = p000.C1911j3.f5324g     // Catch: java.lang.Throwable -> L33
                k3 r1 = new k3     // Catch: java.lang.Throwable -> L33
                r1.<init>(r6, r4)     // Catch: java.lang.Throwable -> L33
                r0.postAtFrontOfQueue(r1)     // Catch: java.lang.Throwable -> L33
                r2 = 1
                goto L3b
            L33:
                r6 = move-exception
                java.lang.String r0 = "ActivityRecreator"
                java.lang.String r1 = "Exception while fetching field values"
                android.util.Log.e(r0, r1, r6)
            L3b:
                if (r2 == 0) goto L42
                r5.f5334g = r3
                r6 = 0
                r5.f5329a = r6
            L42:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C1911j3.C1914c.onActivityPaused(android.app.Activity):void");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f5330b == activity) {
                this.f5332d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0078 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
            p000.C1911j3.f5324g = r0
            r0 = 0
            java.lang.String r1 = "android.app.ActivityThread"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L13
            goto L14
        L13:
            r1 = r0
        L14:
            p000.C1911j3.f5318a = r1
            r1 = 1
            java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
            java.lang.String r3 = "mMainThread"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.Throwable -> L23
            r2.setAccessible(r1)     // Catch: java.lang.Throwable -> L23
            goto L24
        L23:
            r2 = r0
        L24:
            p000.C1911j3.f5319b = r2
            java.lang.Class<android.app.Activity> r2 = android.app.Activity.class
            java.lang.String r3 = "mToken"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch: java.lang.Throwable -> L32
            r2.setAccessible(r1)     // Catch: java.lang.Throwable -> L32
            goto L33
        L32:
            r2 = r0
        L33:
            p000.C1911j3.f5320c = r2
            java.lang.Class<?> r2 = p000.C1911j3.f5318a
            r3 = 3
            java.lang.String r4 = "performStopActivity"
            r5 = 2
            r6 = 0
            if (r2 != 0) goto L40
        L3e:
            r2 = r0
            goto L55
        L40:
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L3e
            java.lang.Class<android.os.IBinder> r8 = android.os.IBinder.class
            r7[r6] = r8     // Catch: java.lang.Throwable -> L3e
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch: java.lang.Throwable -> L3e
            r7[r1] = r8     // Catch: java.lang.Throwable -> L3e
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r7[r5] = r8     // Catch: java.lang.Throwable -> L3e
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r7)     // Catch: java.lang.Throwable -> L3e
            r2.setAccessible(r1)     // Catch: java.lang.Throwable -> L3e
        L55:
            p000.C1911j3.f5321d = r2
            java.lang.Class<?> r2 = p000.C1911j3.f5318a
            if (r2 != 0) goto L5d
        L5b:
            r2 = r0
            goto L6e
        L5d:
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L5b
            java.lang.Class<android.os.IBinder> r8 = android.os.IBinder.class
            r7[r6] = r8     // Catch: java.lang.Throwable -> L5b
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch: java.lang.Throwable -> L5b
            r7[r1] = r8     // Catch: java.lang.Throwable -> L5b
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r7)     // Catch: java.lang.Throwable -> L5b
            r2.setAccessible(r1)     // Catch: java.lang.Throwable -> L5b
        L6e:
            p000.C1911j3.f5322e = r2
            java.lang.Class<?> r2 = p000.C1911j3.f5318a
            boolean r4 = m702a()
            if (r4 == 0) goto Laf
            if (r2 != 0) goto L7b
            goto Laf
        L7b:
            java.lang.String r4 = "requestRelaunchActivity"
            r7 = 9
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch: java.lang.Throwable -> Laf
            java.lang.Class<android.os.IBinder> r8 = android.os.IBinder.class
            r7[r6] = r8     // Catch: java.lang.Throwable -> Laf
            java.lang.Class<java.util.List> r6 = java.util.List.class
            r7[r1] = r6     // Catch: java.lang.Throwable -> Laf
            java.lang.Class<java.util.List> r6 = java.util.List.class
            r7[r5] = r6     // Catch: java.lang.Throwable -> Laf
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> Laf
            r7[r3] = r5     // Catch: java.lang.Throwable -> Laf
            r3 = 4
            java.lang.Class r5 = java.lang.Boolean.TYPE     // Catch: java.lang.Throwable -> Laf
            r7[r3] = r5     // Catch: java.lang.Throwable -> Laf
            r3 = 5
            java.lang.Class<android.content.res.Configuration> r6 = android.content.res.Configuration.class
            r7[r3] = r6     // Catch: java.lang.Throwable -> Laf
            r3 = 6
            java.lang.Class<android.content.res.Configuration> r6 = android.content.res.Configuration.class
            r7[r3] = r6     // Catch: java.lang.Throwable -> Laf
            r3 = 7
            r7[r3] = r5     // Catch: java.lang.Throwable -> Laf
            r3 = 8
            r7[r3] = r5     // Catch: java.lang.Throwable -> Laf
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r4, r7)     // Catch: java.lang.Throwable -> Laf
            r2.setAccessible(r1)     // Catch: java.lang.Throwable -> Laf
            r0 = r2
        Laf:
            p000.C1911j3.f5323f = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1911j3.<clinit>():void");
    }

    /* renamed from: a */
    public static boolean m702a() {
        int i = Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    /* renamed from: b */
    public static boolean m701b(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (m702a() && f5323f == null) {
            return false;
        } else {
            if (f5322e == null && f5321d == null) {
                return false;
            }
            try {
                Object obj2 = f5320c.get(activity);
                if (obj2 == null || (obj = f5319b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                C1914c c1914c = new C1914c(activity);
                application.registerActivityLifecycleCallbacks(c1914c);
                Handler handler = f5324g;
                handler.post(new RunnableC1912a(c1914c, obj2));
                if (m702a()) {
                    Method method = f5323f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new RunnableC1913b(application, c1914c));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
