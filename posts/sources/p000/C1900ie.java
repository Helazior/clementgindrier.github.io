package p000;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* renamed from: ie */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1900ie extends C0097De {
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    @Nullable
    public static C1900ie head;
    private boolean inQueue;
    @Nullable
    private C1900ie next;
    private long timeoutAt;

    /* renamed from: ie$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1901a implements InterfaceC0050Be {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC0050Be f5306a;

        public C1901a(InterfaceC0050Be interfaceC0050Be) {
            this.f5306a = interfaceC0050Be;
        }

        @Override // p000.InterfaceC0050Be, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            C1900ie.this.enter();
            try {
                try {
                    this.f5306a.close();
                    C1900ie.this.exit(true);
                } catch (IOException e) {
                    throw C1900ie.this.exit(e);
                }
            } catch (Throwable th) {
                C1900ie.this.exit(false);
                throw th;
            }
        }

        @Override // p000.InterfaceC0050Be, java.io.Flushable
        public void flush() {
            C1900ie.this.enter();
            try {
                try {
                    this.f5306a.flush();
                    C1900ie.this.exit(true);
                } catch (IOException e) {
                    throw C1900ie.this.exit(e);
                }
            } catch (Throwable th) {
                C1900ie.this.exit(false);
                throw th;
            }
        }

        @Override // p000.InterfaceC0050Be
        public C0097De timeout() {
            return C1900ie.this;
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("AsyncTimeout.sink(");
            m253r.append(this.f5306a);
            m253r.append(")");
            return m253r.toString();
        }

        @Override // p000.InterfaceC0050Be
        public void write(C1946ke c1946ke, long j) {
            C0123Ee.m2457b(c1946ke.f5398b, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                C2393ye c2393ye = c1946ke.f5397a;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += c2393ye.f6890c - c2393ye.f6889b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    c2393ye = c2393ye.f6893f;
                }
                C1900ie.this.enter();
                try {
                    try {
                        this.f5306a.write(c1946ke, j2);
                        j -= j2;
                        C1900ie.this.exit(true);
                    } catch (IOException e) {
                        throw C1900ie.this.exit(e);
                    }
                } catch (Throwable th) {
                    C1900ie.this.exit(false);
                    throw th;
                }
            }
        }
    }

    /* renamed from: ie$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1902b implements InterfaceC0073Ce {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC0073Ce f5308a;

        public C1902b(InterfaceC0073Ce interfaceC0073Ce) {
            this.f5308a = interfaceC0073Ce;
        }

        @Override // p000.InterfaceC0073Ce, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                try {
                    this.f5308a.close();
                    C1900ie.this.exit(true);
                } catch (IOException e) {
                    throw C1900ie.this.exit(e);
                }
            } catch (Throwable th) {
                C1900ie.this.exit(false);
                throw th;
            }
        }

        @Override // p000.InterfaceC0073Ce
        public long read(C1946ke c1946ke, long j) {
            C1900ie.this.enter();
            try {
                try {
                    long read = this.f5308a.read(c1946ke, j);
                    C1900ie.this.exit(true);
                    return read;
                } catch (IOException e) {
                    throw C1900ie.this.exit(e);
                }
            } catch (Throwable th) {
                C1900ie.this.exit(false);
                throw th;
            }
        }

        @Override // p000.InterfaceC0073Ce
        public C0097De timeout() {
            return C1900ie.this;
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("AsyncTimeout.source(");
            m253r.append(this.f5308a);
            m253r.append(")");
            return m253r.toString();
        }
    }

    /* renamed from: ie$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C1903c extends Thread {
        public C1903c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.timedOut();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<ie> r0 = p000.C1900ie.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                ie r1 = p000.C1900ie.awaitTimeout()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                ie r2 = p000.C1900ie.head     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                p000.C1900ie.head = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.timedOut()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C1900ie.C1903c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    public static C1900ie awaitTimeout() {
        C1900ie c1900ie = head.next;
        if (c1900ie == null) {
            long nanoTime = System.nanoTime();
            C1900ie.class.wait(IDLE_TIMEOUT_MILLIS);
            if (head.next != null || System.nanoTime() - nanoTime < IDLE_TIMEOUT_NANOS) {
                return null;
            }
            return head;
        }
        long remainingNanos = c1900ie.remainingNanos(System.nanoTime());
        if (remainingNanos > 0) {
            long j = remainingNanos / 1000000;
            C1900ie.class.wait(j, (int) (remainingNanos - (1000000 * j)));
            return null;
        }
        head.next = c1900ie.next;
        c1900ie.next = null;
        return c1900ie;
    }

    private static synchronized boolean cancelScheduledTimeout(C1900ie c1900ie) {
        synchronized (C1900ie.class) {
            C1900ie c1900ie2 = head;
            while (c1900ie2 != null) {
                C1900ie c1900ie3 = c1900ie2.next;
                if (c1900ie3 == c1900ie) {
                    c1900ie2.next = c1900ie.next;
                    c1900ie.next = null;
                    return false;
                }
                c1900ie2 = c1900ie3;
            }
            return true;
        }
    }

    private long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    private static synchronized void scheduleTimeout(C1900ie c1900ie, long j, boolean z) {
        synchronized (C1900ie.class) {
            if (head == null) {
                head = new C1900ie();
                new C1903c().start();
            }
            long nanoTime = System.nanoTime();
            int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if (i != 0 && z) {
                c1900ie.timeoutAt = Math.min(j, c1900ie.deadlineNanoTime() - nanoTime) + nanoTime;
            } else if (i != 0) {
                c1900ie.timeoutAt = j + nanoTime;
            } else if (z) {
                c1900ie.timeoutAt = c1900ie.deadlineNanoTime();
            } else {
                throw new AssertionError();
            }
            long remainingNanos = c1900ie.remainingNanos(nanoTime);
            C1900ie c1900ie2 = head;
            while (true) {
                C1900ie c1900ie3 = c1900ie2.next;
                if (c1900ie3 == null || remainingNanos < c1900ie3.remainingNanos(nanoTime)) {
                    break;
                }
                c1900ie2 = c1900ie2.next;
            }
            c1900ie.next = c1900ie2.next;
            c1900ie2.next = c1900ie;
            if (c1900ie2 == head) {
                C1900ie.class.notify();
            }
        }
    }

    public final void enter() {
        if (!this.inQueue) {
            long timeoutNanos = timeoutNanos();
            boolean hasDeadline = hasDeadline();
            if (timeoutNanos != 0 || hasDeadline) {
                this.inQueue = true;
                scheduleTimeout(this, timeoutNanos, hasDeadline);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean exit() {
        if (this.inQueue) {
            this.inQueue = false;
            return cancelScheduledTimeout(this);
        }
        return false;
    }

    public IOException newTimeoutException(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final InterfaceC0050Be sink(InterfaceC0050Be interfaceC0050Be) {
        return new C1901a(interfaceC0050Be);
    }

    public final InterfaceC0073Ce source(InterfaceC0073Ce interfaceC0073Ce) {
        return new C1902b(interfaceC0073Ce);
    }

    public void timedOut() {
    }

    public final void exit(boolean z) {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    public final IOException exit(IOException iOException) {
        return !exit() ? iOException : newTimeoutException(iOException);
    }
}
