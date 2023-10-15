package androidx.activity;

import java.util.ArrayDeque;
import java.util.Iterator;
import p000.AbstractC1917j6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a */
    public final Runnable f2206a;

    /* renamed from: b */
    public final ArrayDeque<AbstractC1595d> f2207b = new ArrayDeque<>();

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class LifecycleOnBackPressedCancellable implements InterfaceC1938k6, InterfaceC0979c {

        /* renamed from: a */
        public final AbstractC1917j6 f2208a;

        /* renamed from: b */
        public final AbstractC1595d f2209b;

        /* renamed from: c */
        public InterfaceC0979c f2210c;

        public LifecycleOnBackPressedCancellable(AbstractC1917j6 abstractC1917j6, AbstractC1595d abstractC1595d) {
            this.f2208a = abstractC1917j6;
            this.f2209b = abstractC1595d;
            abstractC1917j6.mo575a(this);
        }

        @Override // p000.InterfaceC0979c
        public void cancel() {
            ((C2002n6) this.f2208a).f5538a.mo583e(this);
            this.f2209b.f3940b.remove(this);
            InterfaceC0979c interfaceC0979c = this.f2210c;
            if (interfaceC0979c != null) {
                interfaceC0979c.cancel();
                this.f2210c = null;
            }
        }

        @Override // p000.InterfaceC1938k6
        /* renamed from: d */
        public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
            if (enumC1918a == AbstractC1917j6.EnumC1918a.ON_START) {
                OnBackPressedDispatcher onBackPressedDispatcher = OnBackPressedDispatcher.this;
                AbstractC1595d abstractC1595d = this.f2209b;
                onBackPressedDispatcher.f2207b.add(abstractC1595d);
                C0628a c0628a = new C0628a(abstractC1595d);
                abstractC1595d.f3940b.add(c0628a);
                this.f2210c = c0628a;
            } else if (enumC1918a == AbstractC1917j6.EnumC1918a.ON_STOP) {
                InterfaceC0979c interfaceC0979c = this.f2210c;
                if (interfaceC0979c != null) {
                    interfaceC0979c.cancel();
                }
            } else if (enumC1918a == AbstractC1917j6.EnumC1918a.ON_DESTROY) {
                cancel();
            }
        }
    }

    /* renamed from: androidx.activity.OnBackPressedDispatcher$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0628a implements InterfaceC0979c {

        /* renamed from: a */
        public final AbstractC1595d f2212a;

        public C0628a(AbstractC1595d abstractC1595d) {
            this.f2212a = abstractC1595d;
        }

        @Override // p000.InterfaceC0979c
        public void cancel() {
            OnBackPressedDispatcher.this.f2207b.remove(this.f2212a);
            this.f2212a.f3940b.remove(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f2206a = runnable;
    }

    /* renamed from: a */
    public void m1721a() {
        Iterator<AbstractC1595d> descendingIterator = this.f2207b.descendingIterator();
        while (descendingIterator.hasNext()) {
            AbstractC1595d next = descendingIterator.next();
            if (next.f3939a) {
                next.mo1063a();
                return;
            }
        }
        Runnable runnable = this.f2206a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
