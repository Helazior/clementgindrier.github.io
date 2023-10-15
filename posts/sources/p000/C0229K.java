package p000;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

/* renamed from: K */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0229K {

    /* renamed from: d */
    public static C0229K f712d;

    /* renamed from: a */
    public final Context f713a;

    /* renamed from: b */
    public final LocationManager f714b;

    /* renamed from: c */
    public final C0230a f715c = new C0230a();

    /* renamed from: K$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0230a {

        /* renamed from: a */
        public boolean f716a;

        /* renamed from: b */
        public long f717b;
    }

    public C0229K(Context context, LocationManager locationManager) {
        this.f713a = context;
        this.f714b = locationManager;
    }

    /* renamed from: a */
    public final Location m2356a(String str) {
        try {
            if (this.f714b.isProviderEnabled(str)) {
                return this.f714b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }
}
