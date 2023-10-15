package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC1894i8 abstractC1894i8) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        Object obj = remoteActionCompat.f2974a;
        if (abstractC1894i8.mo693i(1)) {
            obj = abstractC1894i8.m728o();
        }
        remoteActionCompat.f2974a = (IconCompat) obj;
        CharSequence charSequence = remoteActionCompat.f2975b;
        if (abstractC1894i8.mo693i(2)) {
            charSequence = abstractC1894i8.mo694h();
        }
        remoteActionCompat.f2975b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f2976c;
        if (abstractC1894i8.mo693i(3)) {
            charSequence2 = abstractC1894i8.mo694h();
        }
        remoteActionCompat.f2976c = charSequence2;
        remoteActionCompat.f2977d = (PendingIntent) abstractC1894i8.m729m(remoteActionCompat.f2977d, 4);
        boolean z = remoteActionCompat.f2978e;
        if (abstractC1894i8.mo693i(5)) {
            z = abstractC1894i8.mo696f();
        }
        remoteActionCompat.f2978e = z;
        boolean z2 = remoteActionCompat.f2979f;
        if (abstractC1894i8.mo693i(6)) {
            z2 = abstractC1894i8.mo696f();
        }
        remoteActionCompat.f2979f = z2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC1894i8 abstractC1894i8) {
        Objects.requireNonNull(abstractC1894i8);
        IconCompat iconCompat = remoteActionCompat.f2974a;
        abstractC1894i8.mo689p(1);
        abstractC1894i8.m727w(iconCompat);
        CharSequence charSequence = remoteActionCompat.f2975b;
        abstractC1894i8.mo689p(2);
        abstractC1894i8.mo686s(charSequence);
        CharSequence charSequence2 = remoteActionCompat.f2976c;
        abstractC1894i8.mo689p(3);
        abstractC1894i8.mo686s(charSequence2);
        PendingIntent pendingIntent = remoteActionCompat.f2977d;
        abstractC1894i8.mo689p(4);
        abstractC1894i8.mo684u(pendingIntent);
        boolean z = remoteActionCompat.f2978e;
        abstractC1894i8.mo689p(5);
        abstractC1894i8.mo688q(z);
        boolean z2 = remoteActionCompat.f2979f;
        abstractC1894i8.mo689p(6);
        abstractC1894i8.mo688q(z2);
    }
}
