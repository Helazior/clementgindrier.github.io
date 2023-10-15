package p000;

import android.view.Choreographer;
import java.util.ArrayList;

/* renamed from: x5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2344x5 {

    /* renamed from: g */
    public static final ThreadLocal<C2344x5> f6803g = new ThreadLocal<>();

    /* renamed from: d */
    public AbstractC2347c f6807d;

    /* renamed from: a */
    public final C0101E1<InterfaceC2346b, Long> f6804a = new C0101E1<>();

    /* renamed from: b */
    public final ArrayList<InterfaceC2346b> f6805b = new ArrayList<>();

    /* renamed from: c */
    public final C2345a f6806c = new C2345a();

    /* renamed from: e */
    public long f6808e = 0;

    /* renamed from: f */
    public boolean f6809f = false;

    /* renamed from: x5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2345a {
        public C2345a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0045 A[SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m132a() {
            /*
                r11 = this;
                x5 r0 = p000.C2344x5.this
                long r1 = android.os.SystemClock.uptimeMillis()
                r0.f6808e = r1
                x5 r0 = p000.C2344x5.this
                long r1 = r0.f6808e
                long r3 = android.os.SystemClock.uptimeMillis()
                r5 = 0
                r6 = 0
            L12:
                java.util.ArrayList<x5$b> r7 = r0.f6805b
                int r7 = r7.size()
                if (r6 >= r7) goto L48
                java.util.ArrayList<x5$b> r7 = r0.f6805b
                java.lang.Object r7 = r7.get(r6)
                x5$b r7 = (p000.C2344x5.InterfaceC2346b) r7
                if (r7 != 0) goto L25
                goto L45
            L25:
                E1<x5$b, java.lang.Long> r8 = r0.f6804a
                java.lang.Object r8 = r8.get(r7)
                java.lang.Long r8 = (java.lang.Long) r8
                if (r8 != 0) goto L30
                goto L3d
            L30:
                long r8 = r8.longValue()
                int r10 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r10 >= 0) goto L3f
                E1<x5$b, java.lang.Long> r8 = r0.f6804a
                r8.remove(r7)
            L3d:
                r8 = 1
                goto L40
            L3f:
                r8 = 0
            L40:
                if (r8 == 0) goto L45
                r7.mo58a(r1)
            L45:
                int r6 = r6 + 1
                goto L12
            L48:
                boolean r1 = r0.f6809f
                if (r1 == 0) goto L66
                java.util.ArrayList<x5$b> r1 = r0.f6805b
                int r1 = r1.size()
            L52:
                int r1 = r1 + (-1)
                if (r1 < 0) goto L64
                java.util.ArrayList<x5$b> r2 = r0.f6805b
                java.lang.Object r2 = r2.get(r1)
                if (r2 != 0) goto L52
                java.util.ArrayList<x5$b> r2 = r0.f6805b
                r2.remove(r1)
                goto L52
            L64:
                r0.f6809f = r5
            L66:
                x5 r0 = p000.C2344x5.this
                java.util.ArrayList<x5$b> r0 = r0.f6805b
                int r0 = r0.size()
                if (r0 <= 0) goto L8a
                x5 r0 = p000.C2344x5.this
                x5$c r1 = r0.f6807d
                if (r1 != 0) goto L7f
                x5$d r1 = new x5$d
                x5$a r2 = r0.f6806c
                r1.<init>(r2)
                r0.f6807d = r1
            L7f:
                x5$c r0 = r0.f6807d
                x5$d r0 = (p000.C2344x5.C2348d) r0
                android.view.Choreographer r1 = r0.f6812b
                android.view.Choreographer$FrameCallback r0 = r0.f6813c
                r1.postFrameCallback(r0)
            L8a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C2344x5.C2345a.m132a():void");
        }
    }

    /* renamed from: x5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC2346b {
        /* renamed from: a */
        boolean mo58a(long j);
    }

    /* renamed from: x5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC2347c {

        /* renamed from: a */
        public final C2345a f6811a;

        public AbstractC2347c(C2345a c2345a) {
            this.f6811a = c2345a;
        }
    }

    /* renamed from: x5$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2348d extends AbstractC2347c {

        /* renamed from: b */
        public final Choreographer f6812b;

        /* renamed from: c */
        public final Choreographer.FrameCallback f6813c;

        /* renamed from: x5$d$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class Choreographer$FrameCallbackC2349a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC2349a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j) {
                C2348d.this.f6811a.m132a();
            }
        }

        public C2348d(C2345a c2345a) {
            super(c2345a);
            this.f6812b = Choreographer.getInstance();
            this.f6813c = new Choreographer$FrameCallbackC2349a();
        }
    }

    /* renamed from: a */
    public static C2344x5 m133a() {
        ThreadLocal<C2344x5> threadLocal = f6803g;
        if (threadLocal.get() == null) {
            threadLocal.set(new C2344x5());
        }
        return threadLocal.get();
    }
}
