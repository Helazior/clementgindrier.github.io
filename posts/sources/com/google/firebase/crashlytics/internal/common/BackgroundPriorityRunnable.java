package com.google.firebase.crashlytics.internal.common;

import android.os.Process;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class BackgroundPriorityRunnable implements Runnable {
    public abstract void onRun();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        onRun();
    }
}
