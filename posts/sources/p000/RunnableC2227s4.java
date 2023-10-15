package p000;

import android.os.Handler;
import java.util.concurrent.Callable;

/* renamed from: s4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC2227s4<T> implements Runnable {

    /* renamed from: a */
    public Callable<T> f6388a;

    /* renamed from: b */
    public InterfaceC2365y4<T> f6389b;

    /* renamed from: c */
    public Handler f6390c;

    /* renamed from: s4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC2228a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ InterfaceC2365y4 f6391a;

        /* renamed from: b */
        public final /* synthetic */ Object f6392b;

        public RunnableC2228a(RunnableC2227s4 runnableC2227s4, InterfaceC2365y4 interfaceC2365y4, Object obj) {
            this.f6391a = interfaceC2365y4;
            this.f6392b = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.f6391a.mo59a(this.f6392b);
        }
    }

    public RunnableC2227s4(Handler handler, Callable<T> callable, InterfaceC2365y4<T> interfaceC2365y4) {
        this.f6388a = callable;
        this.f6389b = interfaceC2365y4;
        this.f6390c = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        T t;
        try {
            t = this.f6388a.call();
        } catch (Exception unused) {
            t = null;
        }
        this.f6390c.post(new RunnableC2228a(this, this.f6389b, t));
    }
}
