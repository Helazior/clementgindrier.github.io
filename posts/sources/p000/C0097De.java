package p000;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* renamed from: De */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0097De {
    public static final C0097De NONE = new C0098a();
    private long deadlineNanoTime;
    private boolean hasDeadline;
    private long timeoutNanos;

    /* renamed from: De$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0098a extends C0097De {
        @Override // p000.C0097De
        public C0097De deadlineNanoTime(long j) {
            return this;
        }

        @Override // p000.C0097De
        public void throwIfReached() {
        }

        @Override // p000.C0097De
        public C0097De timeout(long j, TimeUnit timeUnit) {
            return this;
        }
    }

    public C0097De clearDeadline() {
        this.hasDeadline = false;
        return this;
    }

    public C0097De clearTimeout() {
        this.timeoutNanos = 0L;
        return this;
    }

    public final C0097De deadline(long j, TimeUnit timeUnit) {
        if (j > 0) {
            if (timeUnit != null) {
                return deadlineNanoTime(timeUnit.toNanos(j) + System.nanoTime());
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException(outline.m272I("duration <= 0: ", j));
    }

    public long deadlineNanoTime() {
        if (this.hasDeadline) {
            return this.deadlineNanoTime;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean hasDeadline() {
        return this.hasDeadline;
    }

    public void throwIfReached() {
        if (!Thread.interrupted()) {
            if (this.hasDeadline && this.deadlineNanoTime - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        throw new InterruptedIOException("thread interrupted");
    }

    public C0097De timeout(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.timeoutNanos = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException(outline.m272I("timeout < 0: ", j));
    }

    public long timeoutNanos() {
        return this.timeoutNanos;
    }

    public final void waitUntilNotified(Object obj) {
        try {
            boolean hasDeadline = hasDeadline();
            long timeoutNanos = timeoutNanos();
            long j = 0;
            if (!hasDeadline && timeoutNanos == 0) {
                obj.wait();
                return;
            }
            long nanoTime = System.nanoTime();
            if (hasDeadline && timeoutNanos != 0) {
                timeoutNanos = Math.min(timeoutNanos, deadlineNanoTime() - nanoTime);
            } else if (hasDeadline) {
                timeoutNanos = deadlineNanoTime() - nanoTime;
            }
            if (timeoutNanos > 0) {
                long j2 = timeoutNanos / 1000000;
                Long.signum(j2);
                obj.wait(j2, (int) (timeoutNanos - (1000000 * j2)));
                j = System.nanoTime() - nanoTime;
            }
            if (j >= timeoutNanos) {
                throw new InterruptedIOException("timeout");
            }
        } catch (InterruptedException unused) {
            throw new InterruptedIOException("interrupted");
        }
    }

    public C0097De deadlineNanoTime(long j) {
        this.hasDeadline = true;
        this.deadlineNanoTime = j;
        return this;
    }
}
