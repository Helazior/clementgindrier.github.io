package androidx.transition;

import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.Iterator;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class TransitionSet extends Transition {

    /* renamed from: a */
    public ArrayList<Transition> f3473a;

    /* renamed from: b */
    public boolean f3474b;

    /* renamed from: c */
    public int f3475c;

    /* renamed from: d */
    public boolean f3476d;

    /* renamed from: f */
    public int f3477f;

    /* renamed from: androidx.transition.TransitionSet$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0912a extends C0199I7 {

        /* renamed from: a */
        public final /* synthetic */ Transition f3478a;

        public C0912a(TransitionSet transitionSet, Transition transition) {
            this.f3478a = transition;
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            this.f3478a.runAnimators();
            transition.removeListener(this);
        }
    }

    /* renamed from: androidx.transition.TransitionSet$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0913b extends C0199I7 {

        /* renamed from: a */
        public TransitionSet f3479a;

        public C0913b(TransitionSet transitionSet) {
            this.f3479a = transitionSet;
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            TransitionSet transitionSet = this.f3479a;
            int i = transitionSet.f3475c - 1;
            transitionSet.f3475c = i;
            if (i == 0) {
                transitionSet.f3476d = false;
                transitionSet.end();
            }
            transition.removeListener(this);
        }

        @Override // p000.C0199I7, androidx.transition.Transition.InterfaceC0911f
        public void onTransitionStart(Transition transition) {
            TransitionSet transitionSet = this.f3479a;
            if (transitionSet.f3476d) {
                return;
            }
            transitionSet.start();
            this.f3479a.f3476d = true;
        }
    }

    public TransitionSet() {
        this.f3473a = new ArrayList<>();
        this.f3474b = true;
        this.f3476d = false;
        this.f3477f = 0;
    }

    /* renamed from: a */
    public TransitionSet m1267a(Transition transition) {
        this.f3473a.add(transition);
        transition.mParent = this;
        long j = this.mDuration;
        if (j >= 0) {
            transition.setDuration(j);
        }
        if ((this.f3477f & 1) != 0) {
            transition.setInterpolator(getInterpolator());
        }
        if ((this.f3477f & 2) != 0) {
            transition.setPropagation(getPropagation());
        }
        if ((this.f3477f & 4) != 0) {
            transition.setPathMotion(getPathMotion());
        }
        if ((this.f3477f & 8) != 0) {
            transition.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public Transition addListener(Transition.InterfaceC0911f interfaceC0911f) {
        return (TransitionSet) super.addListener(interfaceC0911f);
    }

    @Override // androidx.transition.Transition
    public Transition addTarget(View view) {
        for (int i = 0; i < this.f3473a.size(); i++) {
            this.f3473a.get(i).addTarget(view);
        }
        return (TransitionSet) super.addTarget(view);
    }

    /* renamed from: b */
    public Transition m1266b(int i) {
        if (i < 0 || i >= this.f3473a.size()) {
            return null;
        }
        return this.f3473a.get(i);
    }

    /* renamed from: c */
    public TransitionSet m1265c(long j) {
        ArrayList<Transition> arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.f3473a) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f3473a.get(i).setDuration(j);
            }
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public void cancel() {
        super.cancel();
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            this.f3473a.get(i).cancel();
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C0290M7 c0290m7) {
        if (isValidTarget(c0290m7.f971b)) {
            Iterator<Transition> it = this.f3473a.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(c0290m7.f971b)) {
                    next.captureEndValues(c0290m7);
                    c0290m7.f972c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void capturePropagationValues(C0290M7 c0290m7) {
        super.capturePropagationValues(c0290m7);
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            this.f3473a.get(i).capturePropagationValues(c0290m7);
        }
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C0290M7 c0290m7) {
        if (isValidTarget(c0290m7.f971b)) {
            Iterator<Transition> it = this.f3473a.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.isValidTarget(c0290m7.f971b)) {
                    next.captureStartValues(c0290m7);
                    c0290m7.f972c.add(next);
                }
            }
        }
    }

    @Override // androidx.transition.Transition
    public void createAnimators(ViewGroup viewGroup, C0313N7 c0313n7, C0313N7 c0313n72, ArrayList<C0290M7> arrayList, ArrayList<C0290M7> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            Transition transition = this.f3473a.get(i);
            if (startDelay > 0 && (this.f3474b || i == 0)) {
                long startDelay2 = transition.getStartDelay();
                if (startDelay2 > 0) {
                    transition.setStartDelay(startDelay2 + startDelay);
                } else {
                    transition.setStartDelay(startDelay);
                }
            }
            transition.createAnimators(viewGroup, c0313n7, c0313n72, arrayList, arrayList2);
        }
    }

    @Override // androidx.transition.Transition
    /* renamed from: d */
    public TransitionSet setInterpolator(TimeInterpolator timeInterpolator) {
        this.f3477f |= 1;
        ArrayList<Transition> arrayList = this.f3473a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f3473a.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (TransitionSet) super.setInterpolator(timeInterpolator);
    }

    /* renamed from: e */
    public TransitionSet m1263e(int i) {
        if (i == 0) {
            this.f3474b = true;
        } else if (i == 1) {
            this.f3474b = false;
        } else {
            throw new AndroidRuntimeException(outline.m273H("Invalid parameter for TransitionSet ordering: ", i));
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.f3473a.size(); i++) {
            this.f3473a.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    @Override // androidx.transition.Transition
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            this.f3473a.get(i).forceToEnd(viewGroup);
        }
    }

    @Override // androidx.transition.Transition
    public void pause(View view) {
        super.pause(view);
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            this.f3473a.get(i).pause(view);
        }
    }

    @Override // androidx.transition.Transition
    public Transition removeListener(Transition.InterfaceC0911f interfaceC0911f) {
        return (TransitionSet) super.removeListener(interfaceC0911f);
    }

    @Override // androidx.transition.Transition
    public Transition removeTarget(int i) {
        for (int i2 = 0; i2 < this.f3473a.size(); i2++) {
            this.f3473a.get(i2).removeTarget(i);
        }
        return (TransitionSet) super.removeTarget(i);
    }

    @Override // androidx.transition.Transition
    public void resume(View view) {
        super.resume(view);
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            this.f3473a.get(i).resume(view);
        }
    }

    @Override // androidx.transition.Transition
    public void runAnimators() {
        if (this.f3473a.isEmpty()) {
            start();
            end();
            return;
        }
        C0913b c0913b = new C0913b(this);
        Iterator<Transition> it = this.f3473a.iterator();
        while (it.hasNext()) {
            it.next().addListener(c0913b);
        }
        this.f3475c = this.f3473a.size();
        if (!this.f3474b) {
            for (int i = 1; i < this.f3473a.size(); i++) {
                this.f3473a.get(i - 1).addListener(new C0912a(this, this.f3473a.get(i)));
            }
            Transition transition = this.f3473a.get(0);
            if (transition != null) {
                transition.runAnimators();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.f3473a.iterator();
        while (it2.hasNext()) {
            it2.next().runAnimators();
        }
    }

    @Override // androidx.transition.Transition
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            this.f3473a.get(i).setCanRemoveViews(z);
        }
    }

    @Override // androidx.transition.Transition
    public /* bridge */ /* synthetic */ Transition setDuration(long j) {
        m1265c(j);
        return this;
    }

    @Override // androidx.transition.Transition
    public void setEpicenterCallback(Transition.AbstractC0910e abstractC0910e) {
        super.setEpicenterCallback(abstractC0910e);
        this.f3477f |= 8;
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            this.f3473a.get(i).setEpicenterCallback(abstractC0910e);
        }
    }

    @Override // androidx.transition.Transition
    public void setPathMotion(PathMotion pathMotion) {
        super.setPathMotion(pathMotion);
        this.f3477f |= 4;
        if (this.f3473a != null) {
            for (int i = 0; i < this.f3473a.size(); i++) {
                this.f3473a.get(i).setPathMotion(pathMotion);
            }
        }
    }

    @Override // androidx.transition.Transition
    public void setPropagation(AbstractC0250K7 abstractC0250K7) {
        super.setPropagation(abstractC0250K7);
        this.f3477f |= 2;
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            this.f3473a.get(i).setPropagation(abstractC0250K7);
        }
    }

    @Override // androidx.transition.Transition
    public Transition setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            this.f3473a.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.Transition
    public Transition setStartDelay(long j) {
        return (TransitionSet) super.setStartDelay(j);
    }

    @Override // androidx.transition.Transition
    public String toString(String str) {
        String transition = super.toString(str);
        for (int i = 0; i < this.f3473a.size(); i++) {
            StringBuilder m252s = outline.m252s(transition, "\n");
            m252s.append(this.f3473a.get(i).toString(str + "  "));
            transition = m252s.toString();
        }
        return transition;
    }

    @Override // androidx.transition.Transition
    /* renamed from: clone */
    public Transition mo2710clone() {
        TransitionSet transitionSet = (TransitionSet) super.mo2710clone();
        transitionSet.f3473a = new ArrayList<>();
        int size = this.f3473a.size();
        for (int i = 0; i < size; i++) {
            Transition mo2710clone = this.f3473a.get(i).mo2710clone();
            transitionSet.f3473a.add(mo2710clone);
            mo2710clone.mParent = transitionSet;
        }
        return transitionSet;
    }

    @Override // androidx.transition.Transition
    public Transition addTarget(int i) {
        for (int i2 = 0; i2 < this.f3473a.size(); i2++) {
            this.f3473a.get(i2).addTarget(i);
        }
        return (TransitionSet) super.addTarget(i);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.f3473a.size(); i++) {
            this.f3473a.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    @Override // androidx.transition.Transition
    public Transition removeTarget(View view) {
        for (int i = 0; i < this.f3473a.size(); i++) {
            this.f3473a.get(i).removeTarget(view);
        }
        return (TransitionSet) super.removeTarget(view);
    }

    @SuppressLint({"RestrictedApi"})
    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3473a = new ArrayList<>();
        this.f3474b = true;
        this.f3476d = false;
        this.f3477f = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0174H7.f574g);
        m1263e(LayoutInflater$Factory2C0000A.C0010h.m2669I(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.transition.Transition
    public Transition addTarget(String str) {
        for (int i = 0; i < this.f3473a.size(); i++) {
            this.f3473a.get(i).addTarget(str);
        }
        return (TransitionSet) super.addTarget(str);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.f3473a.size(); i2++) {
            this.f3473a.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    @Override // androidx.transition.Transition
    public Transition removeTarget(Class cls) {
        for (int i = 0; i < this.f3473a.size(); i++) {
            this.f3473a.get(i).removeTarget(cls);
        }
        return (TransitionSet) super.removeTarget(cls);
    }

    @Override // androidx.transition.Transition
    public Transition addTarget(Class cls) {
        for (int i = 0; i < this.f3473a.size(); i++) {
            this.f3473a.get(i).addTarget(cls);
        }
        return (TransitionSet) super.addTarget(cls);
    }

    @Override // androidx.transition.Transition
    public Transition excludeTarget(Class<?> cls, boolean z) {
        for (int i = 0; i < this.f3473a.size(); i++) {
            this.f3473a.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    @Override // androidx.transition.Transition
    public Transition removeTarget(String str) {
        for (int i = 0; i < this.f3473a.size(); i++) {
            this.f3473a.get(i).removeTarget(str);
        }
        return (TransitionSet) super.removeTarget(str);
    }
}
