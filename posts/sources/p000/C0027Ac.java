package p000;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Iterator;

/* renamed from: Ac */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0027Ac implements LocationListener {

    /* renamed from: e */
    public static final String f151e = C0027Ac.class.getSimpleName();

    /* renamed from: a */
    public ArrayList<InterfaceC0028a> f152a = new ArrayList<>();

    /* renamed from: b */
    public Location f153b;

    /* renamed from: c */
    public boolean f154c;

    /* renamed from: d */
    public LocationManager f155d;

    /* renamed from: Ac$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0028a extends EventListener {
        /* renamed from: f */
        void m2584f(Location location);

        /* renamed from: o */
        void m2583o(boolean z);
    }

    public C0027Ac(Context context) {
        this.f155d = (LocationManager) context.getSystemService("location");
    }

    /* renamed from: a */
    public boolean m2586a() {
        return this.f155d.isProviderEnabled("network") || this.f155d.isProviderEnabled("gps");
    }

    /* renamed from: b */
    public final void m2585b(ArrayList<InterfaceC0028a> arrayList, boolean z) {
        Iterator<InterfaceC0028a> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().m2583o(z);
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (location != null) {
            location.getProvider();
            String.valueOf(location.getLatitude());
            String.valueOf(location.getLongitude());
            String.valueOf(location.getAccuracy());
        }
        Location location2 = this.f153b;
        if (location2 == null || ((location2.getProvider().equals("network") || this.f153b.getProvider().equals("gps")) && this.f152a != null)) {
            this.f153b = location;
            Iterator<InterfaceC0028a> it = this.f152a.iterator();
            while (it.hasNext()) {
                it.next().m2584f(location);
            }
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        ArrayList<InterfaceC0028a> arrayList;
        boolean m2586a = m2586a();
        this.f154c = m2586a;
        if (m2586a || (arrayList = this.f152a) == null) {
            return;
        }
        this.f153b = null;
        m2585b(arrayList, m2586a);
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        ArrayList<InterfaceC0028a> arrayList;
        boolean m2586a = m2586a();
        this.f154c = m2586a;
        if (!m2586a || (arrayList = this.f152a) == null) {
            return;
        }
        m2585b(arrayList, m2586a);
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
