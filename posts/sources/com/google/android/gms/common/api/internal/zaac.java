package com.google.android.gms.common.api.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Map;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zaac implements OnCompleteListener {
    public final /* synthetic */ TaskCompletionSource zaa;
    public final /* synthetic */ zaad zab;

    public zaac(zaad zaadVar, TaskCompletionSource taskCompletionSource) {
        this.zab = zaadVar;
        this.zaa = taskCompletionSource;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        Map map;
        map = this.zab.zab;
        map.remove(this.zaa);
    }
}
