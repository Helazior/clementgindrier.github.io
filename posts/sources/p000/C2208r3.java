package p000;

import android.app.Notification;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.spongycastle.i18n.MessageBundle;

/* renamed from: r3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2208r3 implements InterfaceC1955l3 {

    /* renamed from: a */
    public final Context f6334a;

    /* renamed from: b */
    public final Notification.Builder f6335b;

    /* renamed from: c */
    public final C2170p3 f6336c;

    /* renamed from: d */
    public final List<Bundle> f6337d = new ArrayList();

    /* renamed from: e */
    public final Bundle f6338e = new Bundle();

    public C2208r3(C2170p3 c2170p3) {
        List<String> list;
        Bundle bundle;
        Notification.Action.Builder builder;
        Bundle bundle2;
        this.f6336c = c2170p3;
        this.f6334a = c2170p3.f6196a;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6335b = new Notification.Builder(c2170p3.f6196a, c2170p3.f6212q);
        } else {
            this.f6335b = new Notification.Builder(c2170p3.f6196a);
        }
        Notification notification = c2170p3.f6214s;
        this.f6335b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(c2170p3.f6200e).setContentText(c2170p3.f6201f).setContentInfo(null).setContentIntent(c2170p3.f6202g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setLargeIcon(c2170p3.f6203h).setNumber(c2170p3.f6204i).setProgress(0, 0, false);
        this.f6335b.setSubText(null).setUsesChronometer(false).setPriority(c2170p3.f6205j);
        Iterator<C1976m3> it = c2170p3.f6197b.iterator();
        while (it.hasNext()) {
            C1976m3 next = it.next();
            int i = Build.VERSION.SDK_INT;
            IconCompat m597a = next.m597a();
            if (i >= 23) {
                builder = new Notification.Action.Builder(m597a != null ? m597a.m1495f() : null, next.f5489j, next.f5490k);
            } else {
                builder = new Notification.Action.Builder(m597a != null ? m597a.m1498c() : 0, next.f5489j, next.f5490k);
            }
            C2270u3[] c2270u3Arr = next.f5482c;
            if (c2270u3Arr != null) {
                int length = c2270u3Arr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                if (c2270u3Arr.length > 0) {
                    C2270u3 c2270u3 = c2270u3Arr[0];
                    throw null;
                }
                for (int i2 = 0; i2 < length; i2++) {
                    builder.addRemoteInput(remoteInputArr[i2]);
                }
            }
            if (next.f5480a != null) {
                bundle2 = new Bundle(next.f5480a);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android.support.allowGeneratedReplies", next.f5484e);
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 24) {
                builder.setAllowGeneratedReplies(next.f5484e);
            }
            bundle2.putInt("android.support.action.semanticAction", next.f5486g);
            if (i3 >= 28) {
                builder.setSemanticAction(next.f5486g);
            }
            if (i3 >= 29) {
                builder.setContextual(next.f5487h);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", next.f5485f);
            builder.addExtras(bundle2);
            this.f6335b.addAction(builder.build());
        }
        Bundle bundle3 = c2170p3.f6209n;
        if (bundle3 != null) {
            this.f6338e.putAll(bundle3);
        }
        int i4 = Build.VERSION.SDK_INT;
        this.f6335b.setShowWhen(c2170p3.f6206k);
        this.f6335b.setLocalOnly(c2170p3.f6208m).setGroup(null).setGroupSummary(false).setSortKey(null);
        this.f6335b.setCategory(null).setColor(c2170p3.f6210o).setVisibility(c2170p3.f6211p).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        if (i4 < 28) {
            list = m422a(m421b(c2170p3.f6198c), c2170p3.f6215t);
        } else {
            list = c2170p3.f6215t;
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                this.f6335b.addPerson(str);
            }
        }
        if (c2170p3.f6199d.size() > 0) {
            if (c2170p3.f6209n == null) {
                c2170p3.f6209n = new Bundle();
            }
            Bundle bundle4 = c2170p3.f6209n.getBundle("android.car.EXTENSIONS");
            bundle4 = bundle4 == null ? new Bundle() : bundle4;
            Bundle bundle5 = new Bundle(bundle4);
            Bundle bundle6 = new Bundle();
            for (int i5 = 0; i5 < c2170p3.f6199d.size(); i5++) {
                String num = Integer.toString(i5);
                C1976m3 c1976m3 = c2170p3.f6199d.get(i5);
                Object obj = C2226s3.f6387a;
                Bundle bundle7 = new Bundle();
                IconCompat m597a2 = c1976m3.m597a();
                bundle7.putInt("icon", m597a2 != null ? m597a2.m1498c() : 0);
                bundle7.putCharSequence(MessageBundle.TITLE_ENTRY, c1976m3.f5489j);
                bundle7.putParcelable("actionIntent", c1976m3.f5490k);
                if (c1976m3.f5480a != null) {
                    bundle = new Bundle(c1976m3.f5480a);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", c1976m3.f5484e);
                bundle7.putBundle("extras", bundle);
                bundle7.putParcelableArray("remoteInputs", C2226s3.m400a(c1976m3.f5482c));
                bundle7.putBoolean("showsUserInterface", c1976m3.f5485f);
                bundle7.putInt("semanticAction", c1976m3.f5486g);
                bundle6.putBundle(num, bundle7);
            }
            bundle4.putBundle("invisible_actions", bundle6);
            bundle5.putBundle("invisible_actions", bundle6);
            if (c2170p3.f6209n == null) {
                c2170p3.f6209n = new Bundle();
            }
            c2170p3.f6209n.putBundle("android.car.EXTENSIONS", bundle4);
            this.f6338e.putBundle("android.car.EXTENSIONS", bundle5);
        }
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 24) {
            this.f6335b.setExtras(c2170p3.f6209n).setRemoteInputHistory(null);
        }
        if (i6 >= 26) {
            this.f6335b.setBadgeIconType(0).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
            if (!TextUtils.isEmpty(c2170p3.f6212q)) {
                this.f6335b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i6 >= 28) {
            Iterator<C2250t3> it2 = c2170p3.f6198c.iterator();
            while (it2.hasNext()) {
                Notification.Builder builder2 = this.f6335b;
                Objects.requireNonNull(it2.next());
                builder2.addPerson(new Person.Builder().setName(null).setIcon(null).setUri(null).setKey(null).setBot(false).setImportant(false).build());
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6335b.setAllowSystemGeneratedContextualActions(c2170p3.f6213r);
            this.f6335b.setBubbleMetadata(null);
        }
    }

    /* renamed from: a */
    public static List<String> m422a(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        C2396z1 c2396z1 = new C2396z1(list2.size() + list.size());
        c2396z1.addAll(list);
        c2396z1.addAll(list2);
        return new ArrayList(c2396z1);
    }

    /* renamed from: b */
    public static List<String> m421b(List<C2250t3> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (C2250t3 c2250t3 : list) {
            Objects.requireNonNull(c2250t3);
            arrayList.add("");
        }
        return arrayList;
    }
}
