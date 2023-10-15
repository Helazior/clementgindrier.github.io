package p000;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
/* renamed from: w7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2324w7 extends AbstractC0589Z5 {

    /* renamed from: w7$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2325a extends Transition.AbstractC0910e {

        /* renamed from: a */
        public final /* synthetic */ Rect f6775a;

        public C2325a(C2324w7 c2324w7, Rect rect) {
            this.f6775a = rect;
        }

        @Override // androidx.transition.Transition.AbstractC0910e
        /* renamed from: a */
        public Rect mo149a(Transition transition) {
            return this.f6775a;
        }
    }

    /* renamed from: w7$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2326b implements Transition.InterfaceC0911f {

        /* renamed from: a */
        public final /* synthetic */ View f6776a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f6777b;

        public C2326b(C2324w7 c2324w7, View view, ArrayList arrayList) {
            this.f6776a = view;
            this.f6777b = arrayList;
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
            this.f6776a.setVisibility(8);
            int size = this.f6777b.size();
            for (int i = 0; i < size; i++) {
                ((View) this.f6777b.get(i)).setVisibility(0);
            }
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionPause(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionResume(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionStart(Transition transition) {
        }
    }

    /* renamed from: w7$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2327c extends C0199I7 {

        /* renamed from: a */
        public final /* synthetic */ Object f6778a;

        /* renamed from: b */
        public final /* synthetic */ ArrayList f6779b;

        /* renamed from: c */
        public final /* synthetic */ Object f6780c;

        /* renamed from: d */
        public final /* synthetic */ ArrayList f6781d;

        /* renamed from: e */
        public final /* synthetic */ Object f6782e;

        /* renamed from: f */
        public final /* synthetic */ ArrayList f6783f;

        public C2327c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f6778a = obj;
            this.f6779b = arrayList;
            this.f6780c = obj2;
            this.f6781d = arrayList2;
            this.f6782e = obj3;
            this.f6783f = arrayList3;
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        @Override // p000.C0199I7, androidx.transition.Transition.InterfaceC0911f
        public void onTransitionStart(Transition transition) {
            Object obj = this.f6778a;
            if (obj != null) {
                C2324w7.this.mo158o(obj, this.f6779b, null);
            }
            Object obj2 = this.f6780c;
            if (obj2 != null) {
                C2324w7.this.mo158o(obj2, this.f6781d, null);
            }
            Object obj3 = this.f6782e;
            if (obj3 != null) {
                C2324w7.this.mo158o(obj3, this.f6783f, null);
            }
        }
    }

    /* renamed from: w7$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2328d extends Transition.AbstractC0910e {

        /* renamed from: a */
        public final /* synthetic */ Rect f6785a;

        public C2328d(C2324w7 c2324w7, Rect rect) {
            this.f6785a = rect;
        }

        @Override // androidx.transition.Transition.AbstractC0910e
        /* renamed from: a */
        public Rect mo149a(Transition transition) {
            Rect rect = this.f6785a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f6785a;
        }
    }

    /* renamed from: w */
    public static boolean m150w(Transition transition) {
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
            int size = transitionSet.f3473a.size();
            while (i < size) {
                mo165b(transitionSet.m1266b(i), arrayList);
                i++;
            }
        } else if (m150w(transition) || !AbstractC0589Z5.m1743k(transition.getTargets())) {
        } else {
            int size2 = arrayList.size();
            while (i < size2) {
                transition.addTarget(arrayList.get(i));
                i++;
            }
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: c */
    public void mo164c(ViewGroup viewGroup, Object obj) {
        C0220J7.m2359a(viewGroup, (Transition) obj);
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
            return ((Transition) obj).mo2710clone();
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
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.m1267a(transition);
            transitionSet.m1267a(transition2);
            transitionSet.m1263e(1);
            transition = transitionSet;
        } else if (transition == null) {
            transition = transition2 != null ? transition2 : null;
        }
        if (transition3 != null) {
            TransitionSet transitionSet2 = new TransitionSet();
            if (transition != null) {
                transitionSet2.m1267a(transition);
            }
            transitionSet2.m1267a(transition3);
            return transitionSet2;
        }
        return transition;
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: m */
    public Object mo160m(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.m1267a((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.m1267a((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.m1267a((Transition) obj3);
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
        Transition transition = (Transition) obj;
        int i = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int size = transitionSet.f3473a.size();
            while (i < size) {
                mo158o(transitionSet.m1266b(i), arrayList, arrayList2);
                i++;
            }
        } else if (m150w(transition)) {
        } else {
            List<View> targets = transition.getTargets();
            if (targets.size() != arrayList.size() || !targets.containsAll(arrayList)) {
                return;
            }
            int size2 = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size2) {
                transition.addTarget(arrayList2.get(i));
                i++;
            }
            int size3 = arrayList.size();
            while (true) {
                size3--;
                if (size3 < 0) {
                    return;
                }
                transition.removeTarget(arrayList.get(size3));
            }
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: p */
    public void mo157p(Object obj, View view, ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new C2326b(this, view, arrayList));
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: q */
    public void mo156q(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((Transition) obj).addListener(new C2327c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: r */
    public void mo155r(Object obj, Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new C2328d(this, rect));
        }
    }

    @Override // p000.AbstractC0589Z5
    /* renamed from: s */
    public void mo154s(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            m1744j(view, rect);
            ((Transition) obj).setEpicenterCallback(new C2325a(this, rect));
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
        transitionSet.m1267a((Transition) obj);
        return transitionSet;
    }
}
