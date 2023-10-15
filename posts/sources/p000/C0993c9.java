package p000;

import android.content.Context;
import android.content.Intent;

/* renamed from: c9 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0993c9 {

    /* renamed from: a */
    public static final String f3798a = "c9";

    /* renamed from: a */
    public static void m1122a(Context context) {
        String str = f3798a + " sendUpdateBagdesIntent context:" + context;
        Intent intent = new Intent("fr.smoney.android.izly.notifications.NOTIFICATION_UPDATER");
        intent.putExtra("fr.smoney.android.izly.extra.callGetBadges", true);
        context.sendBroadcast(intent);
    }
}
