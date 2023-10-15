package p000;

import android.util.Log;
import java.lang.reflect.Method;

/* renamed from: k3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC1935k3 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ Object f5380a;

    /* renamed from: b */
    public final /* synthetic */ Object f5381b;

    public RunnableC1935k3(Object obj, Object obj2) {
        this.f5380a = obj;
        this.f5381b = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Method method = C1911j3.f5321d;
            if (method != null) {
                method.invoke(this.f5380a, this.f5381b, Boolean.FALSE, "AppCompat recreation");
            } else {
                C1911j3.f5322e.invoke(this.f5380a, this.f5381b, Boolean.FALSE);
            }
        } catch (RuntimeException e) {
            if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                throw e;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }
}
