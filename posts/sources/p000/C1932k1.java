package p000;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: k1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1932k1 extends AbstractC1952l1 {

    /* renamed from: a */
    public final Object f5373a = new Object();

    /* renamed from: b */
    public final ExecutorService f5374b = Executors.newFixedThreadPool(2, new ThreadFactoryC1933a(this));

    /* renamed from: k1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ThreadFactoryC1933a implements ThreadFactory {

        /* renamed from: a */
        public final AtomicInteger f5375a = new AtomicInteger(0);

        public ThreadFactoryC1933a(C1932k1 c1932k1) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f5375a.getAndIncrement())));
            return thread;
        }
    }

    @Override // p000.AbstractC1952l1
    /* renamed from: a */
    public boolean mo635a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
