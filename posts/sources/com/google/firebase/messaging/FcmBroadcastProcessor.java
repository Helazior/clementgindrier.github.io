package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FcmBroadcastProcessor {
    @GuardedBy("lock")
    private static WithinAppServiceConnection fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor;

    public FcmBroadcastProcessor(Context context) {
        this.context = context;
        this.executor = FcmBroadcastProcessor$$Lambda$0.$instance;
    }

    public FcmBroadcastProcessor(Context context, ExecutorService executorService) {
        this.context = context;
        this.executor = executorService;
    }

    private static Task<Integer> bindToMessagingService(Context context, Intent intent) {
        if (Log.isLoggable(Constants.TAG, 3)) {
            Log.d(Constants.TAG, "Binding to service");
        }
        return getServiceConnection(context, com.google.firebase.iid.ServiceStarter.ACTION_MESSAGING_EVENT).sendIntent(intent).continueWith(FcmBroadcastProcessor$$Lambda$3.$instance, FcmBroadcastProcessor$$Lambda$4.$instance);
    }

    private static WithinAppServiceConnection getServiceConnection(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            if (fcmServiceConn == null) {
                fcmServiceConn = new WithinAppServiceConnection(context, com.google.firebase.iid.ServiceStarter.ACTION_MESSAGING_EVENT);
            }
            withinAppServiceConnection = fcmServiceConn;
        }
        return withinAppServiceConnection;
    }

    public static final /* synthetic */ Integer lambda$bindToMessagingService$3$FcmBroadcastProcessor(Task task) {
        return -1;
    }

    public static final /* synthetic */ Integer lambda$startMessagingService$0$FcmBroadcastProcessor(Context context, Intent intent) {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(context, intent));
    }

    public static final /* synthetic */ Integer lambda$startMessagingService$1$FcmBroadcastProcessor(Task task) {
        return 403;
    }

    public static final /* synthetic */ Task lambda$startMessagingService$2$FcmBroadcastProcessor(Context context, Intent intent, Task task) {
        return (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) ? bindToMessagingService(context, intent).continueWith(FcmBroadcastProcessor$$Lambda$5.$instance, FcmBroadcastProcessor$$Lambda$6.$instance) : task;
    }

    @VisibleForTesting
    public static void reset() {
        synchronized (lock) {
            fcmServiceConn = null;
        }
    }

    @KeepForSdk
    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra(Constants.MessagePayloadKeys.RAW_DATA, Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        return startMessagingService(this.context, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> startMessagingService(Context context, Intent intent) {
        boolean z = false;
        if (PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26) {
            z = true;
        }
        int flags = intent.getFlags() & 268435456;
        if (z && flags == 0) {
            return bindToMessagingService(context, intent);
        }
        return Tasks.call(this.executor, new Callable(context, intent) { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$Lambda$1
            private final Context arg$1;
            private final Intent arg$2;

            {
                this.arg$1 = context;
                this.arg$2 = intent;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return FcmBroadcastProcessor.lambda$startMessagingService$0$FcmBroadcastProcessor(this.arg$1, this.arg$2);
            }
        }).continueWithTask(this.executor, new Continuation(context, intent) { // from class: com.google.firebase.messaging.FcmBroadcastProcessor$$Lambda$2
            private final Context arg$1;
            private final Intent arg$2;

            {
                this.arg$1 = context;
                this.arg$2 = intent;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task) {
                return FcmBroadcastProcessor.lambda$startMessagingService$2$FcmBroadcastProcessor(this.arg$1, this.arg$2, task);
            }
        });
    }
}
