package p000;

import android.view.animation.Interpolator;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: O5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0332O5 extends AbstractC2292v6 {

    /* renamed from: g */
    public static final InterfaceC2323w6 f1119g = new C0333a();

    /* renamed from: e */
    public final boolean f1123e;

    /* renamed from: b */
    public final HashSet<Fragment> f1120b = new HashSet<>();

    /* renamed from: c */
    public final HashMap<String, C0332O5> f1121c = new HashMap<>();

    /* renamed from: d */
    public final HashMap<String, C2385y6> f1122d = new HashMap<>();

    /* renamed from: f */
    public boolean f1124f = false;

    /* renamed from: O5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0333a implements InterfaceC2323w6 {
        /* renamed from: a */
        public <T extends AbstractC2292v6> T m2162a(Class<T> cls) {
            return new C0332O5(true);
        }
    }

    public C0332O5(boolean z) {
        this.f1123e = z;
    }

    @Override // p000.AbstractC2292v6
    /* renamed from: a */
    public void mo281a() {
        Interpolator interpolator = LayoutInflater$Factory2C0236K5.f731H;
        this.f1124f = true;
    }

    /* renamed from: b */
    public boolean m2163b(Fragment fragment) {
        if (this.f1120b.contains(fragment) && this.f1123e) {
            return this.f1124f;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0332O5 c0332o5 = (C0332O5) obj;
        return this.f1120b.equals(c0332o5.f1120b) && this.f1121c.equals(c0332o5.f1121c) && this.f1122d.equals(c0332o5.f1122d);
    }

    public int hashCode() {
        int hashCode = this.f1121c.hashCode();
        return this.f1122d.hashCode() + ((hashCode + (this.f1120b.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.f1120b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.f1121c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.f1122d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
