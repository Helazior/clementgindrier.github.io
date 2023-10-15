package p000;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: y6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2385y6 {

    /* renamed from: a */
    public final HashMap<String, AbstractC2292v6> f6876a = new HashMap<>();

    /* renamed from: a */
    public final void m51a() {
        for (AbstractC2292v6 abstractC2292v6 : this.f6876a.values()) {
            Map<String, Object> map = abstractC2292v6.f6698a;
            if (map != null) {
                synchronized (map) {
                    for (Object obj : abstractC2292v6.f6698a.values()) {
                        if (obj instanceof Closeable) {
                            try {
                                ((Closeable) obj).close();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
            abstractC2292v6.mo281a();
        }
        this.f6876a.clear();
    }
}
