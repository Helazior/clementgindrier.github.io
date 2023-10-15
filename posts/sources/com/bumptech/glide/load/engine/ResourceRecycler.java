package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ResourceRecycler {
    private final Handler handler = new Handler(Looper.getMainLooper(), new ResourceRecyclerCallback());
    private boolean isRecycling;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class ResourceRecyclerCallback implements Handler.Callback {
        public static final int RECYCLE_RESOURCE = 1;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((Resource) message.obj).recycle();
                return true;
            }
            return false;
        }
    }

    public synchronized void recycle(Resource<?> resource, boolean z) {
        if (!this.isRecycling && !z) {
            this.isRecycling = true;
            resource.recycle();
            this.isRecycling = false;
        }
        this.handler.obtainMessage(1, resource).sendToTarget();
    }
}
