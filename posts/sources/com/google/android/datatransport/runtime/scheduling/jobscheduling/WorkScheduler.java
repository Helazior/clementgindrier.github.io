package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public interface WorkScheduler {
    void schedule(TransportContext transportContext, int i);

    void schedule(TransportContext transportContext, int i, boolean z);
}
