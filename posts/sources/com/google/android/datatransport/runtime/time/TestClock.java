package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TestClock implements Clock {
    private final AtomicLong timestamp;

    public TestClock(long j) {
        this.timestamp = new AtomicLong(j);
    }

    public void advance(long j) {
        if (j >= 0) {
            this.timestamp.addAndGet(j);
            return;
        }
        throw new IllegalArgumentException("cannot advance time backwards.");
    }

    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return this.timestamp.get();
    }

    public void tick() {
        advance(1L);
    }
}
