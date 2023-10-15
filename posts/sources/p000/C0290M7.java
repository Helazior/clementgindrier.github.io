package p000;

import android.view.View;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: M7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0290M7 {

    /* renamed from: b */
    public View f971b;

    /* renamed from: a */
    public final Map<String, Object> f970a = new HashMap();

    /* renamed from: c */
    public final ArrayList<Transition> f972c = new ArrayList<>();

    @Deprecated
    public C0290M7() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0290M7) {
            C0290M7 c0290m7 = (C0290M7) obj;
            return this.f971b == c0290m7.f971b && this.f970a.equals(c0290m7.f970a);
        }
        return false;
    }

    public int hashCode() {
        return this.f970a.hashCode() + (this.f971b.hashCode() * 31);
    }

    public String toString() {
        StringBuilder m253r = outline.m253r("TransitionValues@");
        m253r.append(Integer.toHexString(hashCode()));
        m253r.append(":\n");
        StringBuilder m252s = outline.m252s(m253r.toString(), "    view = ");
        m252s.append(this.f971b);
        m252s.append("\n");
        String m266e = outline.m266e(m252s.toString(), "    values:");
        for (String str : this.f970a.keySet()) {
            m266e = m266e + "    " + str + ": " + this.f970a.get(str) + "\n";
        }
        return m266e;
    }

    public C0290M7(View view) {
        this.f971b = view;
    }
}
