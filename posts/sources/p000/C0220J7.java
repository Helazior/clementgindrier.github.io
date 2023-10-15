package p000;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: J7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0220J7 {

    /* renamed from: a */
    public static Transition f693a = new AutoTransition();

    /* renamed from: b */
    public static ThreadLocal<WeakReference<C2339x1<ViewGroup, ArrayList<Transition>>>> f694b = new ThreadLocal<>();

    /* renamed from: c */
    public static ArrayList<ViewGroup> f695c = new ArrayList<>();

    /* renamed from: J7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class ViewTreeObserver$OnPreDrawListenerC0221a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a */
        public Transition f696a;

        /* renamed from: b */
        public ViewGroup f697b;

        /* renamed from: J7$a$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0222a extends C0199I7 {

            /* renamed from: a */
            public final /* synthetic */ C2339x1 f698a;

            public C0222a(C2339x1 c2339x1) {
                this.f698a = c2339x1;
            }

            @Override // androidx.transition.Transition.InterfaceC0911f
            public void onTransitionEnd(Transition transition) {
                ((ArrayList) this.f698a.get(ViewTreeObserver$OnPreDrawListenerC0221a.this.f697b)).remove(transition);
                transition.removeListener(this);
            }
        }

        public ViewTreeObserver$OnPreDrawListenerC0221a(Transition transition, ViewGroup viewGroup) {
            this.f696a = transition;
            this.f697b = viewGroup;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f697b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f697b.removeOnAttachStateChangeListener(this);
            if (C0220J7.f695c.remove(this.f697b)) {
                C2339x1<ViewGroup, ArrayList<Transition>> m2358b = C0220J7.m2358b();
                ArrayList<Transition> arrayList = m2358b.get(this.f697b);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    m2358b.put(this.f697b, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.f696a);
                this.f696a.addListener(new C0222a(m2358b));
                this.f696a.captureValues(this.f697b, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).resume(this.f697b);
                    }
                }
                this.f696a.playTransition(this.f697b);
                return true;
            }
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f697b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f697b.removeOnAttachStateChangeListener(this);
            C0220J7.f695c.remove(this.f697b);
            ArrayList<Transition> arrayList = C0220J7.m2358b().get(this.f697b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().resume(this.f697b);
                }
            }
            this.f696a.clearValues(true);
        }
    }

    /* renamed from: a */
    public static void m2359a(ViewGroup viewGroup, Transition transition) {
        if (f695c.contains(viewGroup)) {
            return;
        }
        AtomicInteger atomicInteger = C0492V4.f1798a;
        if (C0492V4.C0498f.m1908c(viewGroup)) {
            f695c.add(viewGroup);
            if (transition == null) {
                transition = f693a;
            }
            Transition mo2710clone = transition.mo2710clone();
            ArrayList<Transition> arrayList = m2358b().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().pause(viewGroup);
                }
            }
            if (mo2710clone != null) {
                mo2710clone.captureValues(viewGroup, true);
            }
            int i = C0090D7.transition_current_scene;
            if (((C0134F7) viewGroup.getTag(i)) == null) {
                viewGroup.setTag(i, null);
                if (mo2710clone != null) {
                    ViewTreeObserver$OnPreDrawListenerC0221a viewTreeObserver$OnPreDrawListenerC0221a = new ViewTreeObserver$OnPreDrawListenerC0221a(mo2710clone, viewGroup);
                    viewGroup.addOnAttachStateChangeListener(viewTreeObserver$OnPreDrawListenerC0221a);
                    viewGroup.getViewTreeObserver().addOnPreDrawListener(viewTreeObserver$OnPreDrawListenerC0221a);
                    return;
                }
                return;
            }
            throw null;
        }
    }

    /* renamed from: b */
    public static C2339x1<ViewGroup, ArrayList<Transition>> m2358b() {
        C2339x1<ViewGroup, ArrayList<Transition>> c2339x1;
        WeakReference<C2339x1<ViewGroup, ArrayList<Transition>>> weakReference = f694b.get();
        if (weakReference == null || (c2339x1 = weakReference.get()) == null) {
            C2339x1<ViewGroup, ArrayList<Transition>> c2339x12 = new C2339x1<>();
            f694b.set(new WeakReference<>(c2339x12));
            return c2339x12;
        }
        return c2339x1;
    }
}
