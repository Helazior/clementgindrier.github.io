package p000;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* renamed from: r4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ThreadFactoryC2209r4 implements ThreadFactory {

    /* renamed from: a */
    public String f6339a;

    /* renamed from: b */
    public int f6340b;

    /* renamed from: r4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2210a extends Thread {

        /* renamed from: a */
        public final int f6341a;

        public C2210a(Runnable runnable, String str, int i) {
            super(runnable, str);
            this.f6341a = i;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Process.setThreadPriority(this.f6341a);
            super.run();
        }
    }

    public ThreadFactoryC2209r4(String str, int i) {
        this.f6339a = str;
        this.f6340b = i;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new C2210a(runnable, this.f6339a, this.f6340b);
    }
}
