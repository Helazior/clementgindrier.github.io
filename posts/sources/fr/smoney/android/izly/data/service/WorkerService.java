package fr.smoney.android.izly.data.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class WorkerService extends MultiThreadService {
    public WorkerService(int i) {
        super(i);
    }

    /* renamed from: b */
    public void m944b(Intent intent, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("com.foxykeep.datadroid.extras.error", 1);
        mo941e(intent, bundle2, -1);
    }

    /* renamed from: c */
    public void m943c(Intent intent, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("com.foxykeep.datadroid.extras.error", 2);
        mo941e(intent, bundle, -1);
    }

    /* renamed from: d */
    public void m942d(Intent intent, Bundle bundle) {
        mo941e(intent, null, -1);
    }

    /* renamed from: e */
    public void mo941e(Intent intent, Bundle bundle, int i) {
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("com.foxykeep.datadroid.extras.receiver");
        if (resultReceiver != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("com.foxykeep.datadroid.extras.requestId", intent.getIntExtra("com.foxykeep.datadroid.extras.requestId", -1));
            resultReceiver.send(i, bundle);
        }
    }

    /* renamed from: f */
    public void m940f(Intent intent, Bundle bundle) {
        mo941e(intent, bundle, 0);
    }
}
