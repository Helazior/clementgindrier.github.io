package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RequestDeduplicator {
    private final Executor executor;
    @GuardedBy("this")
    private final Map<String, Task<String>> getTokenRequests = new C2339x1();

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface GetTokenRequest {
        Task<String> start();
    }

    public RequestDeduplicator(Executor executor) {
        this.executor = executor;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Task<String> getOrStartGetTokenRequest(String str, GetTokenRequest getTokenRequest) {
        Task<String> task = this.getTokenRequests.get(str);
        if (task != null) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                String valueOf = String.valueOf(str);
                Log.d(Constants.TAG, valueOf.length() != 0 ? "Joining ongoing request for: ".concat(valueOf) : new String("Joining ongoing request for: "));
            }
            return task;
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            String valueOf2 = String.valueOf(str);
            Log.d(Constants.TAG, valueOf2.length() != 0 ? "Making new request for: ".concat(valueOf2) : new String("Making new request for: "));
        }
        Task continueWithTask = getTokenRequest.start().continueWithTask(this.executor, new Continuation(this, str) { // from class: com.google.firebase.messaging.RequestDeduplicator$$Lambda$0
            private final RequestDeduplicator arg$1;
            private final String arg$2;

            {
                this.arg$1 = this;
                this.arg$2 = str;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                this.arg$1.lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(this.arg$2, task2);
                return task2;
            }
        });
        this.getTokenRequests.put(str, continueWithTask);
        return continueWithTask;
    }

    public final /* synthetic */ Task lambda$getOrStartGetTokenRequest$0$RequestDeduplicator(String str, Task task) {
        synchronized (this) {
            this.getTokenRequests.remove(str);
        }
        return task;
    }
}
