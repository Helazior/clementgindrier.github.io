package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.WithinAppServiceConnection;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class WithinAppServiceBinder extends Binder {
    private final IntentHandler intentHandler;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface IntentHandler {
        Task<Void> handle(Intent intent);
    }

    public WithinAppServiceBinder(IntentHandler intentHandler) {
        this.intentHandler = intentHandler;
    }

    public void send(final WithinAppServiceConnection.BindRequest bindRequest) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                Log.d(Constants.TAG, "service received new intent via bind strategy");
            }
            this.intentHandler.handle(bindRequest.intent).addOnCompleteListener(WithinAppServiceBinder$$Lambda$0.$instance, new OnCompleteListener(bindRequest) { // from class: com.google.firebase.messaging.WithinAppServiceBinder$$Lambda$1
                private final WithinAppServiceConnection.BindRequest arg$1;

                {
                    this.arg$1 = bindRequest;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task task) {
                    this.arg$1.finish();
                }
            });
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
