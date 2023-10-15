package p000;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* renamed from: V5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0510V5 extends AbstractC0589Z5 {

    /* renamed from: V5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0511a extends Transition.EpicenterCallback {

        /* renamed from: a */
        public final /* synthetic */ Rect f1815a;

        public C0511a(C0510V5 c0510v5, Rect rect) {
            this.f1815a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            return this.f1815a;
        }
    }

    /* renamed from: V5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0512b implements Transition.TransitionListener {

        /* renamed from: a */
        public final /* synthetic */ View f1816a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f1817b;

        public C0512b(C0510V5 c0510v5, View view, ArrayList arrayList) {
            this.f1816a = view;
            this.f1817b = arrayList;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f1816a.setVisibility(8);
            int size = this.f1817b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f1817b.get(i)).setVisibility(0);
            }
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    /* renamed from: V5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0513c implements Transition.TransitionListener {

        /* renamed from: a */
        public final /* synthetic */ Object f1818a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f1819b;

        /* renamed from: c */
        public final /* synthetic */ Object f1820c;

        /* renamed from: d */
        public final /* synthetic */ ArrayList f1821d;

        /* renamed from: e */
        public final /* synthetic */ Object f1822e;

        /* renamed from: f */
        public final /* synthetic */ ArrayList f1823f;

        public C0513c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f1818a = obj;
            this.f1819b = arrayList;
            this.f1820c = obj2;
            this.f1821d = arrayList2;
            this.f1822e = obj3;
            this.f1823f = arrayList3;
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
            Object obj = this.f1818a;
            if (obj != null) {
                C0510V5.this.mo158o(obj, this.f1819b, null);
            }
            Object obj2 = this.f1820c;
            if (obj2 != null) {
                C0510V5.this.mo158o(obj2, this.f1821d, null);
            }
            Object obj3 = this.f1822e;
            if (obj3 != null) {
                C0510V5.this.mo158o(obj3, this.f1823f, null);
            }
        }
    }

    /* renamed from: V5$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0514d extends Transition.EpicenterCallback {

        /* renamed from: a */
        public final /* synthetic */ Rect f1825a;

        public C0514d(C0510V5 c0510v5, Rect rect) {
            this.f1825a = rect;
        }

        @Override // android.transition.Transition.EpicenterCallback
        public Rect onGetEpicenter(Transition transition) {
            Rect rect = this.f1825a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f1825a;
        }
    }

    /* renamed from: w */
    public static boolean m1833w(Transition transition) {
        return (AbstractC0589Z5.m1743k(transition.getTargetIds()) && AbstractC0589Z5.m1743k(transition.getTargetNames()) && AbstractC0589Z5.m1743k(transition.getTargetTypes())) ? false : true;
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: a */
    public void mo166a(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: b */
    public void mo165b(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition == null) {
            return;
        }
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                mo165b(transitionSet.getTransitionAt(i), arrayList);
                i++;
            }
        } else if (m1833w(transition) || !AbstractC0589Z5.m1743k(transition.getTargets())) {
        } else {
            int size = arrayList.size();
            while (i < size) {
                transition.addTarget(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: c */
    public void mo164c(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: e */
    public boolean mo163e(Object obj) {
        return obj instanceof Transition;
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: g */
    public Object mo162g(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: l */
    public Object mo161l(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 != null) {
            TransitionSet transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        return transition;
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: m */
    public Object mo160m(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: n */
    public void mo159n(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: o */
    public void mo158o(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        List<View> targets;
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                mo158o(transitionSet.getTransitionAt(i), arrayList, arrayList2);
                i++;
            }
        } else if (!m1833w(transition) && (targets = transition.getTargets()) != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                transition.addTarget(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                transition.removeTarget(arrayList.get(size2));
            }
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: p */
    public void mo157p(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new C0512b(this, view, arrayList));
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: q */
    public void mo156q(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new C0513c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: r */
    public void mo155r(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new C0514d(this, rect));
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: s */
    public void mo154s(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            m1744j(view, rect);
            ((Transition) obj).setEpicenterCallback(new C0511a(this, rect));
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: t */
    public void mo153t(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            AbstractC0589Z5.m1748d(targets, arrayList.get(i));
        }
        targets.add(view);
        arrayList.add(view);
        mo165b(transitionSet, arrayList);
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: u */
    public void mo152u(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            mo158o(transitionSet, arrayList, arrayList2);
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: v */
    public Object mo151v(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }
}
