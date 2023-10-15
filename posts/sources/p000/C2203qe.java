package p000;

import java.util.concurrent.TimeUnit;

/* renamed from: qe */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2203qe extends C0097De {

    /* renamed from: a */
    public C0097De f6310a;

    public C2203qe(C0097De c0097De) {
        if (c0097De != null) {
            this.f6310a = c0097De;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // p000.C0097De
    public C0097De clearDeadline() {
        return this.f6310a.clearDeadline();
    }

    @Override // p000.C0097De
    public C0097De clearTimeout() {
        return this.f6310a.clearTimeout();
    }

    @Override // p000.C0097De
    public long deadlineNanoTime() {
        return this.f6310a.deadlineNanoTime();
    }

    @Override // p000.C0097De
    public boolean hasDeadline() {
        return this.f6310a.hasDeadline();
    }

    @Override // p000.C0097De
    public void throwIfReached() {
        this.f6310a.throwIfReached();
    }

    @Override // p000.C0097De
    public C0097De timeout(long j, TimeUnit timeUnit) {
        return this.f6310a.timeout(j, timeUnit);
    }

    @Override // p000.C0097De
    public long timeoutNanos() {
        return this.f6310a.timeoutNanos();
    }

    @Override // p000.C0097De
    public C0097De deadlineNanoTime(long j) {
        return this.f6310a.deadlineNanoTime(j);
    }
}
