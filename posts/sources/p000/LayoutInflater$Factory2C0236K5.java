package p000;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManagerState;
import androidx.fragment.app.FragmentState;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.AbstractC0352P5;
import p000.AbstractC1917j6;
import p000.C0332O5;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: K5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class LayoutInflater$Factory2C0236K5 extends AbstractC0216J5 implements LayoutInflater.Factory2 {

    /* renamed from: H */
    public static final Interpolator f731H = new DecelerateInterpolator(2.5f);

    /* renamed from: I */
    public static final Interpolator f732I = new DecelerateInterpolator(1.5f);

    /* renamed from: A */
    public ArrayList<Boolean> f733A;

    /* renamed from: B */
    public ArrayList<Fragment> f734B;

    /* renamed from: E */
    public ArrayList<C0246j> f737E;

    /* renamed from: F */
    public C0332O5 f738F;

    /* renamed from: c */
    public ArrayList<InterfaceC0244h> f740c;

    /* renamed from: d */
    public boolean f741d;

    /* renamed from: i */
    public ArrayList<C0088D5> f745i;

    /* renamed from: j */
    public ArrayList<Fragment> f746j;

    /* renamed from: k */
    public OnBackPressedDispatcher f747k;

    /* renamed from: m */
    public ArrayList<C0088D5> f749m;

    /* renamed from: n */
    public ArrayList<Integer> f750n;

    /* renamed from: q */
    public AbstractC0197I5 f753q;

    /* renamed from: r */
    public AbstractC0132F5 f754r;

    /* renamed from: s */
    public Fragment f755s;

    /* renamed from: t */
    public Fragment f756t;

    /* renamed from: u */
    public boolean f757u;

    /* renamed from: v */
    public boolean f758v;

    /* renamed from: w */
    public boolean f759w;

    /* renamed from: x */
    public boolean f760x;

    /* renamed from: y */
    public boolean f761y;

    /* renamed from: z */
    public ArrayList<C0088D5> f762z;

    /* renamed from: f */
    public int f742f = 0;

    /* renamed from: g */
    public final ArrayList<Fragment> f743g = new ArrayList<>();

    /* renamed from: h */
    public final HashMap<String, Fragment> f744h = new HashMap<>();

    /* renamed from: l */
    public final AbstractC1595d f748l = new C0237a(false);

    /* renamed from: o */
    public final CopyOnWriteArrayList<C0242f> f751o = new CopyOnWriteArrayList<>();

    /* renamed from: p */
    public int f752p = 0;

    /* renamed from: C */
    public Bundle f735C = null;

    /* renamed from: D */
    public SparseArray<Parcelable> f736D = null;

    /* renamed from: G */
    public Runnable f739G = new RunnableC0238b();

    /* renamed from: K5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0237a extends AbstractC1595d {
        public C0237a(boolean z) {
            super(z);
        }

        @Override // p000.AbstractC1595d
        /* renamed from: a */
        public void mo1063a() {
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = LayoutInflater$Factory2C0236K5.this;
            layoutInflater$Factory2C0236K5.m2313W();
            if (layoutInflater$Factory2C0236K5.f748l.f3939a) {
                layoutInflater$Factory2C0236K5.mo2295h();
            } else {
                layoutInflater$Factory2C0236K5.f747k.m1721a();
            }
        }
    }

    /* renamed from: K5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0238b implements Runnable {
        public RunnableC0238b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LayoutInflater$Factory2C0236K5.this.m2313W();
        }
    }

    /* renamed from: K5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0239c extends C0172H5 {
        public C0239c() {
        }

        @Override // p000.C0172H5
        /* renamed from: a */
        public Fragment mo2258a(ClassLoader classLoader, String str) {
            AbstractC0197I5 abstractC0197I5 = LayoutInflater$Factory2C0236K5.this.f753q;
            Context context = abstractC0197I5.f639b;
            Objects.requireNonNull(abstractC0197I5);
            return Fragment.instantiate(context, str, null);
        }
    }

    /* renamed from: K5$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0242f {
    }

    /* renamed from: K5$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0243g {

        /* renamed from: a */
        public static final int[] f773a = {16842755, 16842960, 16842961};
    }

    /* renamed from: K5$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0244h {
        /* renamed from: a */
        boolean mo2257a(ArrayList<C0088D5> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* renamed from: K5$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0245i implements InterfaceC0244h {

        /* renamed from: a */
        public final int f774a;

        /* renamed from: b */
        public final int f775b;

        public C0245i(String str, int i, int i2) {
            this.f774a = i;
            this.f775b = i2;
        }

        @Override // p000.LayoutInflater$Factory2C0236K5.InterfaceC0244h
        /* renamed from: a */
        public boolean mo2257a(ArrayList<C0088D5> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = LayoutInflater$Factory2C0236K5.this.f756t;
            if (fragment == null || this.f774a >= 0 || !fragment.getChildFragmentManager().mo2295h()) {
                return LayoutInflater$Factory2C0236K5.this.m2284m0(arrayList, arrayList2, null, this.f774a, this.f775b);
            }
            return false;
        }
    }

    /* renamed from: K5$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0246j implements Fragment.InterfaceC0810f {

        /* renamed from: a */
        public final boolean f777a;

        /* renamed from: b */
        public final C0088D5 f778b;

        /* renamed from: c */
        public int f779c;

        public C0246j(C0088D5 c0088d5, boolean z) {
            this.f777a = z;
            this.f778b = c0088d5;
        }

        /* renamed from: a */
        public void m2256a() {
            boolean z = this.f779c > 0;
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f778b.f349q;
            int size = layoutInflater$Factory2C0236K5.f743g.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = layoutInflater$Factory2C0236K5.f743g.get(i);
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            C0088D5 c0088d5 = this.f778b;
            c0088d5.f349q.m2279p(c0088d5, this.f777a, !z, true);
        }
    }

    /* renamed from: g0 */
    public static C0240d m2296g0(float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f731H);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f732I);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new C0240d(animationSet);
    }

    /* renamed from: A */
    public void m2335A(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2335A(fragment, bundle, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: B */
    public void m2334B(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2334B(fragment, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: C */
    public void m2333C(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2333C(fragment, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: D */
    public void m2332D(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2332D(fragment, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: E */
    public void m2331E(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2331E(fragment, context, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: F */
    public void m2330F(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2330F(fragment, bundle, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: G */
    public void m2329G(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2329G(fragment, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: H */
    public void m2328H(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2328H(fragment, bundle, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: I */
    public void m2327I(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2327I(fragment, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: J */
    public void m2326J(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2326J(fragment, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: K */
    public void m2325K(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2325K(fragment, view, bundle, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: L */
    public void m2324L(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2324L(fragment, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: M */
    public boolean m2323M(MenuItem menuItem) {
        if (this.f752p < 1) {
            return false;
        }
        for (int i = 0; i < this.f743g.size(); i++) {
            Fragment fragment = this.f743g.get(i);
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: N */
    public void m2322N(Menu menu) {
        if (this.f752p < 1) {
            return;
        }
        for (int i = 0; i < this.f743g.size(); i++) {
            Fragment fragment = this.f743g.get(i);
            if (fragment != null) {
                fragment.performOptionsMenuClosed(menu);
            }
        }
    }

    /* renamed from: O */
    public final void m2321O(Fragment fragment) {
        if (fragment == null || this.f744h.get(fragment.mWho) != fragment) {
            return;
        }
        fragment.performPrimaryNavigationFragmentChanged();
    }

    /* renamed from: P */
    public void m2320P(boolean z) {
        for (int size = this.f743g.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f743g.get(size);
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z);
            }
        }
    }

    /* renamed from: Q */
    public boolean m2319Q(Menu menu) {
        if (this.f752p < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f743g.size(); i++) {
            Fragment fragment = this.f743g.get(i);
            if (fragment != null && fragment.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: R */
    public final void m2318R(int i) {
        try {
            this.f741d = true;
            m2292i0(i, false);
            this.f741d = false;
            m2313W();
        } catch (Throwable th) {
            this.f741d = false;
            throw th;
        }
    }

    /* renamed from: S */
    public void m2317S() {
        if (this.f761y) {
            this.f761y = false;
            m2264w0();
        }
    }

    /* renamed from: T */
    public void m2316T(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        String m266e = outline.m266e(str, "    ");
        if (!this.f744h.isEmpty()) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (Fragment fragment : this.f744h.values()) {
                printWriter.print(str);
                printWriter.println(fragment);
                if (fragment != null) {
                    fragment.dump(m266e, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size5 = this.f743g.size();
        if (size5 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size5; i++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(this.f743g.get(i).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f746j;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size4; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f746j.get(i2).toString());
            }
        }
        ArrayList<C0088D5> arrayList2 = this.f745i;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size3; i3++) {
                C0088D5 c0088d5 = this.f745i.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(c0088d5.toString());
                c0088d5.m2481j(m266e, printWriter, true);
            }
        }
        synchronized (this) {
            ArrayList<C0088D5> arrayList3 = this.f749m;
            if (arrayList3 != null && (size2 = arrayList3.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i4 = 0; i4 < size2; i4++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i4);
                    printWriter.print(": ");
                    printWriter.println((C0088D5) this.f749m.get(i4));
                }
            }
            ArrayList<Integer> arrayList4 = this.f750n;
            if (arrayList4 != null && arrayList4.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f750n.toArray()));
            }
        }
        ArrayList<InterfaceC0244h> arrayList5 = this.f740c;
        if (arrayList5 != null && (size = arrayList5.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i5 = 0; i5 < size; i5++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i5);
                printWriter.print(": ");
                printWriter.println((InterfaceC0244h) this.f740c.get(i5));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f753q);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f754r);
        if (this.f755s != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f755s);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f752p);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f758v);
        printWriter.print(" mStopped=");
        printWriter.print(this.f759w);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f760x);
        if (this.f757u) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f757u);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        return;
     */
    /* renamed from: U */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2315U(p000.LayoutInflater$Factory2C0236K5.InterfaceC0244h r2, boolean r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L5
            r1.m2283n()
        L5:
            monitor-enter(r1)
            boolean r0 = r1.f760x     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L24
            I5 r0 = r1.f753q     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lf
            goto L24
        Lf:
            java.util.ArrayList<K5$h> r3 = r1.f740c     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            r1.f740c = r3     // Catch: java.lang.Throwable -> L30
        L1a:
            java.util.ArrayList<K5$h> r3 = r1.f740c     // Catch: java.lang.Throwable -> L30
            r3.add(r2)     // Catch: java.lang.Throwable -> L30
            r1.m2270t0()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L24:
            if (r3 == 0) goto L28
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L28:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Activity has been destroyed"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L30:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0236K5.m2315U(K5$h, boolean):void");
    }

    /* renamed from: V */
    public final void m2314V(boolean z) {
        if (!this.f741d) {
            if (this.f753q != null) {
                if (Looper.myLooper() == this.f753q.f640c.getLooper()) {
                    if (!z) {
                        m2283n();
                    }
                    if (this.f762z == null) {
                        this.f762z = new ArrayList<>();
                        this.f733A = new ArrayList<>();
                    }
                    this.f741d = true;
                    try {
                        m2311Y(null, null);
                        return;
                    } finally {
                        this.f741d = false;
                    }
                }
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    /* renamed from: W */
    public boolean m2313W() {
        boolean z;
        m2314V(true);
        boolean z2 = false;
        while (true) {
            ArrayList<C0088D5> arrayList = this.f762z;
            ArrayList<Boolean> arrayList2 = this.f733A;
            synchronized (this) {
                ArrayList<InterfaceC0244h> arrayList3 = this.f740c;
                if (arrayList3 != null && arrayList3.size() != 0) {
                    int size = this.f740c.size();
                    z = false;
                    for (int i = 0; i < size; i++) {
                        z |= this.f740c.get(i).mo2257a(arrayList, arrayList2);
                    }
                    this.f740c.clear();
                    this.f753q.f640c.removeCallbacks(this.f739G);
                }
                z = false;
            }
            if (z) {
                this.f741d = true;
                try {
                    m2280o0(this.f762z, this.f733A);
                    m2281o();
                    z2 = true;
                } catch (Throwable th) {
                    m2281o();
                    throw th;
                }
            } else {
                m2260y0();
                m2317S();
                m2285m();
                return z2;
            }
        }
    }

    /* renamed from: X */
    public final void m2312X(ArrayList<C0088D5> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5;
        boolean z;
        int i6;
        int i7;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z2 = arrayList.get(i).f1203p;
        ArrayList<Fragment> arrayList4 = this.f734B;
        if (arrayList4 == null) {
            this.f734B = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.f734B.addAll(this.f743g);
        Fragment fragment = this.f756t;
        int i8 = i;
        boolean z3 = false;
        while (true) {
            int i9 = 1;
            if (i8 < i2) {
                C0088D5 c0088d5 = arrayList.get(i8);
                int i10 = 3;
                if (!arrayList3.get(i8).booleanValue()) {
                    ArrayList<Fragment> arrayList5 = this.f734B;
                    int i11 = 0;
                    while (i11 < c0088d5.f1188a.size()) {
                        AbstractC0352P5.C0353a c0353a = c0088d5.f1188a.get(i11);
                        int i12 = c0353a.f1204a;
                        if (i12 != i9) {
                            if (i12 == 2) {
                                Fragment fragment2 = c0353a.f1205b;
                                int i13 = fragment2.mContainerId;
                                int size = arrayList5.size() - 1;
                                boolean z4 = false;
                                while (size >= 0) {
                                    Fragment fragment3 = arrayList5.get(size);
                                    if (fragment3.mContainerId != i13) {
                                        i7 = i13;
                                    } else if (fragment3 == fragment2) {
                                        i7 = i13;
                                        z4 = true;
                                    } else {
                                        if (fragment3 == fragment) {
                                            i7 = i13;
                                            c0088d5.f1188a.add(i11, new AbstractC0352P5.C0353a(9, fragment3));
                                            i11++;
                                            fragment = null;
                                        } else {
                                            i7 = i13;
                                        }
                                        AbstractC0352P5.C0353a c0353a2 = new AbstractC0352P5.C0353a(3, fragment3);
                                        c0353a2.f1206c = c0353a.f1206c;
                                        c0353a2.f1208e = c0353a.f1208e;
                                        c0353a2.f1207d = c0353a.f1207d;
                                        c0353a2.f1209f = c0353a.f1209f;
                                        c0088d5.f1188a.add(i11, c0353a2);
                                        arrayList5.remove(fragment3);
                                        i11++;
                                    }
                                    size--;
                                    i13 = i7;
                                }
                                if (z4) {
                                    c0088d5.f1188a.remove(i11);
                                    i11--;
                                } else {
                                    i6 = 1;
                                    c0353a.f1204a = 1;
                                    arrayList5.add(fragment2);
                                    i11 += i6;
                                    i10 = 3;
                                    i9 = 1;
                                }
                            } else if (i12 == i10 || i12 == 6) {
                                arrayList5.remove(c0353a.f1205b);
                                Fragment fragment4 = c0353a.f1205b;
                                if (fragment4 == fragment) {
                                    c0088d5.f1188a.add(i11, new AbstractC0352P5.C0353a(9, fragment4));
                                    i11++;
                                    fragment = null;
                                }
                            } else if (i12 != 7) {
                                if (i12 == 8) {
                                    c0088d5.f1188a.add(i11, new AbstractC0352P5.C0353a(9, fragment));
                                    i11++;
                                    fragment = c0353a.f1205b;
                                }
                            }
                            i6 = 1;
                            i11 += i6;
                            i10 = 3;
                            i9 = 1;
                        }
                        i6 = 1;
                        arrayList5.add(c0353a.f1205b);
                        i11 += i6;
                        i10 = 3;
                        i9 = 1;
                    }
                } else {
                    int i14 = 1;
                    ArrayList<Fragment> arrayList6 = this.f734B;
                    int size2 = c0088d5.f1188a.size() - 1;
                    while (size2 >= 0) {
                        AbstractC0352P5.C0353a c0353a3 = c0088d5.f1188a.get(size2);
                        int i15 = c0353a3.f1204a;
                        if (i15 != i14) {
                            if (i15 != 3) {
                                switch (i15) {
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = c0353a3.f1205b;
                                        break;
                                    case 10:
                                        c0353a3.f1211h = c0353a3.f1210g;
                                        break;
                                }
                                size2--;
                                i14 = 1;
                            }
                            arrayList6.add(c0353a3.f1205b);
                            size2--;
                            i14 = 1;
                        }
                        arrayList6.remove(c0353a3.f1205b);
                        size2--;
                        i14 = 1;
                    }
                }
                z3 = z3 || c0088d5.f1195h;
                i8++;
                arrayList3 = arrayList2;
            } else {
                this.f734B.clear();
                if (!z2) {
                    C0471U5.m1983p(this, arrayList, arrayList2, i, i2, false);
                }
                int i16 = i;
                while (i16 < i2) {
                    C0088D5 c0088d52 = arrayList.get(i16);
                    if (arrayList2.get(i16).booleanValue()) {
                        c0088d52.m2483h(-1);
                        c0088d52.m2479l(i16 == i2 + (-1));
                    } else {
                        c0088d52.m2483h(1);
                        c0088d52.m2480k();
                    }
                    i16++;
                }
                if (z2) {
                    C2396z1<Fragment> c2396z1 = new C2396z1<>(0);
                    m2293i(c2396z1);
                    i3 = i;
                    int i17 = i2;
                    for (int i18 = i2 - 1; i18 >= i3; i18--) {
                        C0088D5 c0088d53 = arrayList.get(i18);
                        boolean booleanValue = arrayList2.get(i18).booleanValue();
                        int i19 = 0;
                        while (true) {
                            if (i19 >= c0088d53.f1188a.size()) {
                                z = false;
                            } else if (C0088D5.m2476o(c0088d53.f1188a.get(i19))) {
                                z = true;
                            } else {
                                i19++;
                            }
                        }
                        if (z && !c0088d53.m2477n(arrayList, i18 + 1, i2)) {
                            if (this.f737E == null) {
                                this.f737E = new ArrayList<>();
                            }
                            C0246j c0246j = new C0246j(c0088d53, booleanValue);
                            this.f737E.add(c0246j);
                            for (int i20 = 0; i20 < c0088d53.f1188a.size(); i20++) {
                                AbstractC0352P5.C0353a c0353a4 = c0088d53.f1188a.get(i20);
                                if (C0088D5.m2476o(c0353a4)) {
                                    c0353a4.f1205b.setOnStartEnterTransitionListener(c0246j);
                                }
                            }
                            if (booleanValue) {
                                c0088d53.m2480k();
                            } else {
                                c0088d53.m2479l(false);
                            }
                            i17--;
                            if (i18 != i17) {
                                arrayList.remove(i18);
                                arrayList.add(i17, c0088d53);
                            }
                            m2293i(c2396z1);
                        }
                    }
                    int i21 = c2396z1.f6911c;
                    for (int i22 = 0; i22 < i21; i22++) {
                        Fragment fragment5 = (Fragment) c2396z1.f6910b[i22];
                        if (!fragment5.mAdded) {
                            View requireView = fragment5.requireView();
                            fragment5.mPostponedAlpha = requireView.getAlpha();
                            requireView.setAlpha(0.0f);
                        }
                    }
                    i4 = i17;
                } else {
                    i3 = i;
                    i4 = i2;
                }
                if (i4 != i3 && z2) {
                    C0471U5.m1983p(this, arrayList, arrayList2, i, i4, true);
                    m2292i0(this.f752p, true);
                }
                while (i3 < i2) {
                    C0088D5 c0088d54 = arrayList.get(i3);
                    if (arrayList2.get(i3).booleanValue() && (i5 = c0088d54.f351s) >= 0) {
                        synchronized (this) {
                            this.f749m.set(i5, null);
                            if (this.f750n == null) {
                                this.f750n = new ArrayList<>();
                            }
                            this.f750n.add(Integer.valueOf(i5));
                        }
                        c0088d54.f351s = -1;
                    }
                    Objects.requireNonNull(c0088d54);
                    i3++;
                }
                return;
            }
        }
    }

    /* renamed from: Y */
    public final void m2311Y(ArrayList<C0088D5> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<C0246j> arrayList3 = this.f737E;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            C0246j c0246j = this.f737E.get(i);
            if (arrayList != null && !c0246j.f777a && (indexOf2 = arrayList.indexOf(c0246j.f778b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                this.f737E.remove(i);
                i--;
                size--;
                C0088D5 c0088d5 = c0246j.f778b;
                c0088d5.f349q.m2279p(c0088d5, c0246j.f777a, false, false);
            } else {
                if ((c0246j.f779c == 0) || (arrayList != null && c0246j.f778b.m2477n(arrayList, 0, arrayList.size()))) {
                    this.f737E.remove(i);
                    i--;
                    size--;
                    if (arrayList != null && !c0246j.f777a && (indexOf = arrayList.indexOf(c0246j.f778b)) != -1 && arrayList2.get(indexOf).booleanValue()) {
                        C0088D5 c0088d52 = c0246j.f778b;
                        c0088d52.f349q.m2279p(c0088d52, c0246j.f777a, false, false);
                    } else {
                        c0246j.m2256a();
                    }
                }
            }
            i++;
        }
    }

    /* renamed from: Z */
    public Fragment m2310Z(String str) {
        Fragment findFragmentByWho;
        for (Fragment fragment : this.f744h.values()) {
            if (fragment != null && (findFragmentByWho = fragment.findFragmentByWho(str)) != null) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    @Override // p000.AbstractC0216J5
    /* renamed from: a */
    public AbstractC0352P5 mo2309a() {
        return new C0088D5(this);
    }

    /* renamed from: a0 */
    public final void m2308a0() {
        if (this.f737E != null) {
            while (!this.f737E.isEmpty()) {
                this.f737E.remove(0).m2256a();
            }
        }
    }

    @Override // p000.AbstractC0216J5
    /* renamed from: b */
    public boolean mo2307b() {
        boolean m2313W = m2313W();
        m2308a0();
        return m2313W;
    }

    /* renamed from: b0 */
    public final boolean m2306b0(Fragment fragment) {
        boolean z;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = fragment.mChildFragmentManager;
        Iterator<Fragment> it = layoutInflater$Factory2C0236K5.f744h.values().iterator();
        boolean z2 = false;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            Fragment next = it.next();
            if (next != null) {
                z2 = layoutInflater$Factory2C0236K5.m2306b0(next);
                continue;
            }
            if (z2) {
                z = true;
                break;
            }
        }
        return z;
    }

    @Override // p000.AbstractC0216J5
    /* renamed from: c */
    public Fragment mo2305c(int i) {
        for (int size = this.f743g.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f743g.get(size);
            if (fragment != null && fragment.mFragmentId == i) {
                return fragment;
            }
        }
        for (Fragment fragment2 : this.f744h.values()) {
            if (fragment2 != null && fragment2.mFragmentId == i) {
                return fragment2;
            }
        }
        return null;
    }

    /* renamed from: c0 */
    public boolean m2304c0(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = fragment.mFragmentManager;
        return fragment == layoutInflater$Factory2C0236K5.f756t && m2304c0(layoutInflater$Factory2C0236K5.f755s);
    }

    @Override // p000.AbstractC0216J5
    /* renamed from: d */
    public Fragment mo2303d(String str) {
        if (str != null) {
            for (int size = this.f743g.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f743g.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (Fragment fragment2 : this.f744h.values()) {
                if (fragment2 != null && str.equals(fragment2.mTag)) {
                    return fragment2;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: d0 */
    public boolean m2302d0() {
        return this.f758v || this.f759w;
    }

    @Override // p000.AbstractC0216J5
    /* renamed from: e */
    public C0172H5 mo2301e() {
        if (super.mo2301e() == AbstractC0216J5.f681b) {
            Fragment fragment = this.f755s;
            if (fragment != null) {
                return fragment.mFragmentManager.mo2301e();
            }
            this.f682a = new C0239c();
        }
        return super.mo2301e();
    }

    /* renamed from: e0 */
    public C0240d m2300e0(Fragment fragment, int i, boolean z, int i2) {
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null || viewGroup.getLayoutTransition() == null) {
            Animation onCreateAnimation = fragment.onCreateAnimation(i, z, nextAnim);
            if (onCreateAnimation != null) {
                return new C0240d(onCreateAnimation);
            }
            Animator onCreateAnimator = fragment.onCreateAnimator(i, z, nextAnim);
            if (onCreateAnimator != null) {
                return new C0240d(onCreateAnimator);
            }
            char c = 1;
            if (nextAnim != 0) {
                boolean equals = "anim".equals(this.f753q.f639b.getResources().getResourceTypeName(nextAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.f753q.f639b, nextAnim);
                        if (loadAnimation != null) {
                            return new C0240d(loadAnimation);
                        }
                        z2 = true;
                    } catch (Resources.NotFoundException e) {
                        throw e;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z2) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(this.f753q.f639b, nextAnim);
                        if (loadAnimator != null) {
                            return new C0240d(loadAnimator);
                        }
                    } catch (RuntimeException e2) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f753q.f639b, nextAnim);
                            if (loadAnimation2 != null) {
                                return new C0240d(loadAnimation2);
                            }
                        } else {
                            throw e2;
                        }
                    }
                }
            }
            if (i == 0) {
                return null;
            }
            if (i != 4097) {
                c = i != 4099 ? i != 8194 ? (char) 65535 : z ? (char) 3 : (char) 4 : z ? (char) 5 : (char) 6;
            } else if (!z) {
                c = 2;
            }
            if (c < 0) {
                return null;
            }
            switch (c) {
                case 1:
                    return m2296g0(1.125f, 1.0f, 0.0f, 1.0f);
                case 2:
                    return m2296g0(1.0f, 0.975f, 1.0f, 0.0f);
                case 3:
                    return m2296g0(0.975f, 1.0f, 0.0f, 1.0f);
                case 4:
                    return m2296g0(1.0f, 1.075f, 1.0f, 0.0f);
                case 5:
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setInterpolator(f732I);
                    alphaAnimation.setDuration(220L);
                    return new C0240d(alphaAnimation);
                case 6:
                    AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation2.setInterpolator(f732I);
                    alphaAnimation2.setDuration(220L);
                    return new C0240d(alphaAnimation2);
                default:
                    if (i2 == 0 && this.f753q.mo1434i()) {
                        this.f753q.mo1435h();
                    }
                    return null;
            }
        }
        return null;
    }

    @Override // p000.AbstractC0216J5
    /* renamed from: f */
    public List<Fragment> mo2299f() {
        List<Fragment> list;
        if (this.f743g.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f743g) {
            list = (List) this.f743g.clone();
        }
        return list;
    }

    /* renamed from: f0 */
    public void m2298f0(Fragment fragment) {
        if (this.f744h.get(fragment.mWho) != null) {
            return;
        }
        this.f744h.put(fragment.mWho, fragment);
        if (fragment.mRetainInstanceChangedWhileDetached) {
            if (fragment.mRetainInstance) {
                if (!m2302d0()) {
                    this.f738F.f1120b.add(fragment);
                }
            } else {
                m2278p0(fragment);
            }
            fragment.mRetainInstanceChangedWhileDetached = false;
        }
    }

    @Override // p000.AbstractC0216J5
    /* renamed from: g */
    public void mo2297g(int i, int i2) {
        if (i >= 0) {
            m2315U(new C0245i(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException(outline.m273H("Bad id: ", i));
    }

    @Override // p000.AbstractC0216J5
    /* renamed from: h */
    public boolean mo2295h() {
        m2283n();
        m2313W();
        m2314V(true);
        Fragment fragment = this.f756t;
        if (fragment == null || !fragment.getChildFragmentManager().mo2295h()) {
            boolean m2284m0 = m2284m0(this.f762z, this.f733A, null, -1, 0);
            if (m2284m0) {
                this.f741d = true;
                try {
                    m2280o0(this.f762z, this.f733A);
                } finally {
                    m2281o();
                }
            }
            m2260y0();
            m2317S();
            m2285m();
            return m2284m0;
        }
        return true;
    }

    /* renamed from: h0 */
    public void m2294h0(Fragment fragment) {
        Animator animator;
        if (fragment != null && this.f744h.containsKey(fragment.mWho)) {
            int i = this.f752p;
            if (fragment.mRemoving) {
                if (fragment.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, 0);
                }
            }
            m2290j0(fragment, i, fragment.getNextTransition(), fragment.getNextTransitionStyle(), false);
            View view = fragment.mView;
            if (view != null) {
                ViewGroup viewGroup = fragment.mContainer;
                Fragment fragment2 = null;
                if (viewGroup != null && view != null) {
                    int indexOf = this.f743g.indexOf(fragment);
                    while (true) {
                        indexOf--;
                        if (indexOf < 0) {
                            break;
                        }
                        Fragment fragment3 = this.f743g.get(indexOf);
                        if (fragment3.mContainer == viewGroup && fragment3.mView != null) {
                            fragment2 = fragment3;
                            break;
                        }
                    }
                }
                if (fragment2 != null) {
                    View view2 = fragment2.mView;
                    ViewGroup viewGroup2 = fragment.mContainer;
                    int indexOfChild = viewGroup2.indexOfChild(view2);
                    int indexOfChild2 = viewGroup2.indexOfChild(fragment.mView);
                    if (indexOfChild2 < indexOfChild) {
                        viewGroup2.removeViewAt(indexOfChild2);
                        viewGroup2.addView(fragment.mView, indexOfChild);
                    }
                }
                if (fragment.mIsNewlyAdded && fragment.mContainer != null) {
                    float f = fragment.mPostponedAlpha;
                    if (f > 0.0f) {
                        fragment.mView.setAlpha(f);
                    }
                    fragment.mPostponedAlpha = 0.0f;
                    fragment.mIsNewlyAdded = false;
                    C0240d m2300e0 = m2300e0(fragment, fragment.getNextTransition(), true, fragment.getNextTransitionStyle());
                    if (m2300e0 != null) {
                        Animation animation = m2300e0.f766a;
                        if (animation != null) {
                            fragment.mView.startAnimation(animation);
                        } else {
                            m2300e0.f767b.setTarget(fragment.mView);
                            m2300e0.f767b.start();
                        }
                    }
                }
            }
            if (fragment.mHiddenChanged) {
                if (fragment.mView != null) {
                    C0240d m2300e02 = m2300e0(fragment, fragment.getNextTransition(), !fragment.mHidden, fragment.getNextTransitionStyle());
                    if (m2300e02 != null && (animator = m2300e02.f767b) != null) {
                        animator.setTarget(fragment.mView);
                        if (fragment.mHidden) {
                            if (fragment.isHideReplaced()) {
                                fragment.setHideReplaced(false);
                            } else {
                                ViewGroup viewGroup3 = fragment.mContainer;
                                View view3 = fragment.mView;
                                viewGroup3.startViewTransition(view3);
                                m2300e02.f767b.addListener(new C0311N5(this, viewGroup3, view3, fragment));
                            }
                        } else {
                            fragment.mView.setVisibility(0);
                        }
                        m2300e02.f767b.start();
                    } else {
                        if (m2300e02 != null) {
                            fragment.mView.startAnimation(m2300e02.f766a);
                            m2300e02.f766a.start();
                        }
                        fragment.mView.setVisibility((!fragment.mHidden || fragment.isHideReplaced()) ? 0 : 8);
                        if (fragment.isHideReplaced()) {
                            fragment.setHideReplaced(false);
                        }
                    }
                }
                if (fragment.mAdded && m2306b0(fragment)) {
                    this.f757u = true;
                }
                fragment.mHiddenChanged = false;
                fragment.onHiddenChanged(fragment.mHidden);
            }
        }
    }

    /* renamed from: i */
    public final void m2293i(C2396z1<Fragment> c2396z1) {
        int i = this.f752p;
        if (i < 1) {
            return;
        }
        int min = Math.min(i, 3);
        int size = this.f743g.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f743g.get(i2);
            if (fragment.mState < min) {
                m2290j0(fragment, min, fragment.getNextAnim(), fragment.getNextTransition(), false);
                if (fragment.mView != null && !fragment.mHidden && fragment.mIsNewlyAdded) {
                    c2396z1.add(fragment);
                }
            }
        }
    }

    /* renamed from: i0 */
    public void m2292i0(int i, boolean z) {
        AbstractC0197I5 abstractC0197I5;
        if (this.f753q == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f752p) {
            this.f752p = i;
            int size = this.f743g.size();
            for (int i2 = 0; i2 < size; i2++) {
                m2294h0(this.f743g.get(i2));
            }
            for (Fragment fragment : this.f744h.values()) {
                if (fragment != null && (fragment.mRemoving || fragment.mDetached)) {
                    if (!fragment.mIsNewlyAdded) {
                        m2294h0(fragment);
                    }
                }
            }
            m2264w0();
            if (this.f757u && (abstractC0197I5 = this.f753q) != null && this.f752p == 4) {
                abstractC0197I5.mo1428o();
                this.f757u = false;
            }
        }
    }

    /* renamed from: j */
    public void m2291j(Fragment fragment, boolean z) {
        m2298f0(fragment);
        if (fragment.mDetached) {
            return;
        }
        if (!this.f743g.contains(fragment)) {
            synchronized (this.f743g) {
                this.f743g.add(fragment);
            }
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (m2306b0(fragment)) {
                this.f757u = true;
            }
            if (z) {
                m2290j0(fragment, this.f752p, 0, 0, false);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0082, code lost:
        if (r0 != 3) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:292:? A[RETURN, SYNTHETIC] */
    /* renamed from: j0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m2290j0(androidx.fragment.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 1301
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0236K5.m2290j0(androidx.fragment.app.Fragment, int, int, int, boolean):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: k */
    public void m2289k(AbstractC0197I5 abstractC0197I5, AbstractC0132F5 abstractC0132F5, Fragment fragment) {
        if (this.f753q == null) {
            this.f753q = abstractC0197I5;
            this.f754r = abstractC0132F5;
            this.f755s = fragment;
            if (fragment != null) {
                m2260y0();
            }
            if (abstractC0197I5 instanceof InterfaceC1633e) {
                InterfaceC1633e interfaceC1633e = (InterfaceC1633e) abstractC0197I5;
                OnBackPressedDispatcher mo1007b = interfaceC1633e.mo1007b();
                this.f747k = mo1007b;
                Fragment fragment2 = interfaceC1633e;
                if (fragment != null) {
                    fragment2 = fragment;
                }
                AbstractC1595d abstractC1595d = this.f748l;
                Objects.requireNonNull(mo1007b);
                AbstractC1917j6 lifecycle = fragment2.getLifecycle();
                if (((C2002n6) lifecycle).f5539b != AbstractC1917j6.EnumC1919b.DESTROYED) {
                    abstractC1595d.f3940b.add(new OnBackPressedDispatcher.LifecycleOnBackPressedCancellable(lifecycle, abstractC1595d));
                }
            }
            if (fragment != null) {
                C0332O5 c0332o5 = fragment.mFragmentManager.f738F;
                C0332O5 c0332o52 = c0332o5.f1121c.get(fragment.mWho);
                if (c0332o52 == null) {
                    c0332o52 = new C0332O5(c0332o5.f1123e);
                    c0332o5.f1121c.put(fragment.mWho, c0332o52);
                }
                this.f738F = c0332o52;
                return;
            } else if (abstractC0197I5 instanceof InterfaceC2402z6) {
                C2385y6 viewModelStore = ((InterfaceC2402z6) abstractC0197I5).getViewModelStore();
                InterfaceC2323w6 interfaceC2323w6 = C0332O5.f1119g;
                String canonicalName = C0332O5.class.getCanonicalName();
                if (canonicalName != null) {
                    String m266e = outline.m266e("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    AbstractC2292v6 abstractC2292v6 = viewModelStore.f6876a.get(m266e);
                    if (!C0332O5.class.isInstance(abstractC2292v6)) {
                        abstractC2292v6 = interfaceC2323w6 instanceof AbstractC2350x6 ? ((AbstractC2350x6) interfaceC2323w6).m131a(m266e, C0332O5.class) : ((C0332O5.C0333a) interfaceC2323w6).m2162a(C0332O5.class);
                        AbstractC2292v6 put = viewModelStore.f6876a.put(m266e, abstractC2292v6);
                        if (put != null) {
                            put.mo281a();
                        }
                    }
                    this.f738F = (C0332O5) abstractC2292v6;
                    return;
                }
                throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
            } else {
                this.f738F = new C0332O5(false);
                return;
            }
        }
        throw new IllegalStateException("Already attached");
    }

    /* renamed from: k0 */
    public void m2288k0() {
        this.f758v = false;
        this.f759w = false;
        int size = this.f743g.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.f743g.get(i);
            if (fragment != null) {
                fragment.noteStateNotSaved();
            }
        }
    }

    /* renamed from: l */
    public void m2287l(Fragment fragment) {
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (fragment.mAdded) {
                return;
            }
            if (!this.f743g.contains(fragment)) {
                synchronized (this.f743g) {
                    this.f743g.add(fragment);
                }
                fragment.mAdded = true;
                if (m2306b0(fragment)) {
                    this.f757u = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    /* renamed from: l0 */
    public void m2286l0(Fragment fragment) {
        if (fragment.mDeferStart) {
            if (this.f741d) {
                this.f761y = true;
                return;
            }
            fragment.mDeferStart = false;
            m2290j0(fragment, this.f752p, 0, 0, false);
        }
    }

    /* renamed from: m */
    public final void m2285m() {
        this.f744h.values().removeAll(Collections.singleton(null));
    }

    /* renamed from: m0 */
    public boolean m2284m0(ArrayList<C0088D5> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        ArrayList<C0088D5> arrayList3 = this.f745i;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f745i.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            int i3 = -1;
            if (str != null || i >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    C0088D5 c0088d5 = this.f745i.get(size2);
                    if ((str != null && str.equals(c0088d5.f1196i)) || (i >= 0 && i == c0088d5.f351s)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        C0088D5 c0088d52 = this.f745i.get(size2);
                        if (str == null || !str.equals(c0088d52.f1196i)) {
                            if (i < 0 || i != c0088d52.f351s) {
                                break;
                            }
                        }
                    }
                }
                i3 = size2;
            }
            if (i3 == this.f745i.size() - 1) {
                return false;
            }
            for (int size3 = this.f745i.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f745i.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* renamed from: n */
    public final void m2283n() {
        if (m2302d0()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* renamed from: n0 */
    public void m2282n0(Fragment fragment) {
        boolean z = !fragment.isInBackStack();
        if (!fragment.mDetached || z) {
            synchronized (this.f743g) {
                this.f743g.remove(fragment);
            }
            if (m2306b0(fragment)) {
                this.f757u = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
        }
    }

    /* renamed from: o */
    public final void m2281o() {
        this.f741d = false;
        this.f733A.clear();
        this.f762z.clear();
    }

    /* renamed from: o0 */
    public final void m2280o0(ArrayList<C0088D5> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 != null && arrayList.size() == arrayList2.size()) {
            m2311Y(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).f1203p) {
                    if (i2 != i) {
                        m2312X(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).f1203p) {
                            i2++;
                        }
                    }
                    m2312X(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                m2312X(arrayList, arrayList2, i2, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0243g.f773a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            String str2 = attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (str2 != null) {
                ClassLoader classLoader = context.getClassLoader();
                C0101E1<String, Class<?>> c0101e1 = C0172H5.f567a;
                try {
                    C0101E1<String, Class<?>> c0101e12 = C0172H5.f567a;
                    Class<?> cls = c0101e12.get(str2);
                    if (cls == null) {
                        cls = Class.forName(str2, false, classLoader);
                        c0101e12.put(str2, cls);
                    }
                    z = Fragment.class.isAssignableFrom(cls);
                } catch (ClassNotFoundException unused) {
                    z = false;
                }
                if (z) {
                    int id = view != null ? view.getId() : 0;
                    if (id == -1 && resourceId == -1 && string == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
                    }
                    Fragment mo2305c = resourceId != -1 ? mo2305c(resourceId) : null;
                    if (mo2305c == null && string != null) {
                        mo2305c = mo2303d(string);
                    }
                    if (mo2305c == null && id != -1) {
                        mo2305c = mo2305c(id);
                    }
                    if (mo2305c == null) {
                        mo2305c = mo2301e().mo2258a(context.getClassLoader(), str2);
                        mo2305c.mFromLayout = true;
                        mo2305c.mFragmentId = resourceId != 0 ? resourceId : id;
                        mo2305c.mContainerId = id;
                        mo2305c.mTag = string;
                        mo2305c.mInLayout = true;
                        mo2305c.mFragmentManager = this;
                        AbstractC0197I5 abstractC0197I5 = this.f753q;
                        mo2305c.mHost = abstractC0197I5;
                        mo2305c.onInflate(abstractC0197I5.f639b, attributeSet, mo2305c.mSavedFragmentState);
                        m2291j(mo2305c, true);
                    } else if (!mo2305c.mInLayout) {
                        mo2305c.mInLayout = true;
                        AbstractC0197I5 abstractC0197I52 = this.f753q;
                        mo2305c.mHost = abstractC0197I52;
                        mo2305c.onInflate(abstractC0197I52.f639b, attributeSet, mo2305c.mSavedFragmentState);
                    } else {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
                    }
                    Fragment fragment = mo2305c;
                    int i = this.f752p;
                    if (i < 1 && fragment.mFromLayout) {
                        m2290j0(fragment, 1, 0, 0, false);
                    } else {
                        m2290j0(fragment, i, 0, 0, false);
                    }
                    View view2 = fragment.mView;
                    if (view2 != null) {
                        if (resourceId != 0) {
                            view2.setId(resourceId);
                        }
                        if (fragment.mView.getTag() == null) {
                            fragment.mView.setTag(string);
                        }
                        return fragment.mView;
                    }
                    throw new IllegalStateException(outline.m265f("Fragment ", str2, " did not create a view."));
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: p */
    public void m2279p(C0088D5 c0088d5, boolean z, boolean z2, boolean z3) {
        if (z) {
            c0088d5.m2479l(z3);
        } else {
            c0088d5.m2480k();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0088d5);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            C0471U5.m1983p(this, arrayList, arrayList2, 0, 1, true);
        }
        if (z3) {
            m2292i0(this.f752p, true);
        }
        for (Fragment fragment : this.f744h.values()) {
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && c0088d5.m2478m(fragment.mContainerId)) {
                float f = fragment.mPostponedAlpha;
                if (f > 0.0f) {
                    fragment.mView.setAlpha(f);
                }
                if (z3) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    /* renamed from: p0 */
    public void m2278p0(Fragment fragment) {
        if (m2302d0()) {
            return;
        }
        this.f738F.f1120b.remove(fragment);
    }

    /* renamed from: q */
    public void m2277q(Fragment fragment) {
        if (fragment.mDetached) {
            return;
        }
        fragment.mDetached = true;
        if (fragment.mAdded) {
            synchronized (this.f743g) {
                this.f743g.remove(fragment);
            }
            if (m2306b0(fragment)) {
                this.f757u = true;
            }
            fragment.mAdded = false;
        }
    }

    /* renamed from: q0 */
    public void m2276q0(Parcelable parcelable) {
        FragmentState fragmentState;
        if (parcelable == null) {
            return;
        }
        FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
        if (fragmentManagerState.f3126a == null) {
            return;
        }
        for (Fragment fragment : this.f738F.f1120b) {
            Iterator<FragmentState> it = fragmentManagerState.f3126a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    fragmentState = null;
                    break;
                }
                fragmentState = it.next();
                if (fragmentState.f3132b.equals(fragment.mWho)) {
                    break;
                }
            }
            if (fragmentState == null) {
                m2290j0(fragment, 1, 0, 0, false);
                fragment.mRemoving = true;
                m2290j0(fragment, 0, 0, 0, false);
            } else {
                fragmentState.f3144o = fragment;
                fragment.mSavedViewState = null;
                fragment.mBackStackNesting = 0;
                fragment.mInLayout = false;
                fragment.mAdded = false;
                Fragment fragment2 = fragment.mTarget;
                fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
                fragment.mTarget = null;
                Bundle bundle = fragmentState.f3143n;
                if (bundle != null) {
                    bundle.setClassLoader(this.f753q.f639b.getClassLoader());
                    fragment.mSavedViewState = fragmentState.f3143n.getSparseParcelableArray("android:view_state");
                    fragment.mSavedFragmentState = fragmentState.f3143n;
                }
            }
        }
        this.f744h.clear();
        Iterator<FragmentState> it2 = fragmentManagerState.f3126a.iterator();
        while (it2.hasNext()) {
            FragmentState next = it2.next();
            if (next != null) {
                ClassLoader classLoader = this.f753q.f639b.getClassLoader();
                C0172H5 mo2301e = mo2301e();
                if (next.f3144o == null) {
                    Bundle bundle2 = next.f3140k;
                    if (bundle2 != null) {
                        bundle2.setClassLoader(classLoader);
                    }
                    Fragment mo2258a = mo2301e.mo2258a(classLoader, next.f3131a);
                    next.f3144o = mo2258a;
                    mo2258a.setArguments(next.f3140k);
                    Bundle bundle3 = next.f3143n;
                    if (bundle3 != null) {
                        bundle3.setClassLoader(classLoader);
                        next.f3144o.mSavedFragmentState = next.f3143n;
                    } else {
                        next.f3144o.mSavedFragmentState = new Bundle();
                    }
                    Fragment fragment3 = next.f3144o;
                    fragment3.mWho = next.f3132b;
                    fragment3.mFromLayout = next.f3133c;
                    fragment3.mRestored = true;
                    fragment3.mFragmentId = next.f3134d;
                    fragment3.mContainerId = next.f3135f;
                    fragment3.mTag = next.f3136g;
                    fragment3.mRetainInstance = next.f3137h;
                    fragment3.mRemoving = next.f3138i;
                    fragment3.mDetached = next.f3139j;
                    fragment3.mHidden = next.f3141l;
                    fragment3.mMaxState = AbstractC1917j6.EnumC1919b.values()[next.f3142m];
                }
                Fragment fragment4 = next.f3144o;
                fragment4.mFragmentManager = this;
                this.f744h.put(fragment4.mWho, fragment4);
                next.f3144o = null;
            }
        }
        this.f743g.clear();
        ArrayList<String> arrayList = fragmentManagerState.f3127b;
        if (arrayList != null) {
            Iterator<String> it3 = arrayList.iterator();
            while (it3.hasNext()) {
                String next2 = it3.next();
                Fragment fragment5 = this.f744h.get(next2);
                if (fragment5 != null) {
                    fragment5.mAdded = true;
                    if (!this.f743g.contains(fragment5)) {
                        synchronized (this.f743g) {
                            this.f743g.add(fragment5);
                        }
                    } else {
                        throw new IllegalStateException("Already added " + fragment5);
                    }
                } else {
                    m2262x0(new IllegalStateException(outline.m265f("No instantiated fragment for (", next2, ")")));
                    throw null;
                }
            }
        }
        if (fragmentManagerState.f3128c != null) {
            this.f745i = new ArrayList<>(fragmentManagerState.f3128c.length);
            int i = 0;
            while (true) {
                BackStackState[] backStackStateArr = fragmentManagerState.f3128c;
                if (i >= backStackStateArr.length) {
                    break;
                }
                BackStackState backStackState = backStackStateArr[i];
                Objects.requireNonNull(backStackState);
                C0088D5 c0088d5 = new C0088D5(this);
                int i2 = 0;
                int i3 = 0;
                while (true) {
                    int[] iArr = backStackState.f3078a;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    AbstractC0352P5.C0353a c0353a = new AbstractC0352P5.C0353a();
                    int i4 = i2 + 1;
                    c0353a.f1204a = iArr[i2];
                    String str = backStackState.f3079b.get(i3);
                    if (str != null) {
                        c0353a.f1205b = this.f744h.get(str);
                    } else {
                        c0353a.f1205b = null;
                    }
                    c0353a.f1210g = AbstractC1917j6.EnumC1919b.values()[backStackState.f3080c[i3]];
                    c0353a.f1211h = AbstractC1917j6.EnumC1919b.values()[backStackState.f3081d[i3]];
                    int[] iArr2 = backStackState.f3078a;
                    int i5 = i4 + 1;
                    int i6 = iArr2[i4];
                    c0353a.f1206c = i6;
                    int i7 = i5 + 1;
                    int i8 = iArr2[i5];
                    c0353a.f1207d = i8;
                    int i9 = i7 + 1;
                    int i10 = iArr2[i7];
                    c0353a.f1208e = i10;
                    int i11 = iArr2[i9];
                    c0353a.f1209f = i11;
                    c0088d5.f1189b = i6;
                    c0088d5.f1190c = i8;
                    c0088d5.f1191d = i10;
                    c0088d5.f1192e = i11;
                    c0088d5.m2154b(c0353a);
                    i3++;
                    i2 = i9 + 1;
                }
                c0088d5.f1193f = backStackState.f3082f;
                c0088d5.f1194g = backStackState.f3083g;
                c0088d5.f1196i = backStackState.f3084h;
                c0088d5.f351s = backStackState.f3085i;
                c0088d5.f1195h = true;
                c0088d5.f1197j = backStackState.f3086j;
                c0088d5.f1198k = backStackState.f3087k;
                c0088d5.f1199l = backStackState.f3088l;
                c0088d5.f1200m = backStackState.f3089m;
                c0088d5.f1201n = backStackState.f3090n;
                c0088d5.f1202o = backStackState.f3091o;
                c0088d5.f1203p = backStackState.f3092p;
                c0088d5.m2483h(1);
                this.f745i.add(c0088d5);
                int i12 = c0088d5.f351s;
                if (i12 >= 0) {
                    synchronized (this) {
                        if (this.f749m == null) {
                            this.f749m = new ArrayList<>();
                        }
                        int size = this.f749m.size();
                        if (i12 < size) {
                            this.f749m.set(i12, c0088d5);
                        } else {
                            while (size < i12) {
                                this.f749m.add(null);
                                if (this.f750n == null) {
                                    this.f750n = new ArrayList<>();
                                }
                                this.f750n.add(Integer.valueOf(size));
                                size++;
                            }
                            this.f749m.add(c0088d5);
                        }
                    }
                }
                i++;
            }
        } else {
            this.f745i = null;
        }
        String str2 = fragmentManagerState.f3129d;
        if (str2 != null) {
            Fragment fragment6 = this.f744h.get(str2);
            this.f756t = fragment6;
            m2321O(fragment6);
        }
        this.f742f = fragmentManagerState.f3130f;
    }

    /* renamed from: r */
    public void m2275r(Configuration configuration) {
        for (int i = 0; i < this.f743g.size(); i++) {
            Fragment fragment = this.f743g.get(i);
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    /* renamed from: r0 */
    public Parcelable m2274r0() {
        BackStackState[] backStackStateArr;
        ArrayList<String> arrayList;
        int size;
        Bundle bundle;
        m2308a0();
        Iterator<Fragment> it = this.f744h.values().iterator();
        while (true) {
            backStackStateArr = null;
            if (!it.hasNext()) {
                break;
            }
            Fragment next = it.next();
            if (next != null) {
                if (next.getAnimatingAway() != null) {
                    int stateAfterAnimating = next.getStateAfterAnimating();
                    View animatingAway = next.getAnimatingAway();
                    Animation animation = animatingAway.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        animatingAway.clearAnimation();
                    }
                    next.setAnimatingAway(null);
                    m2290j0(next, stateAfterAnimating, 0, 0, false);
                } else if (next.getAnimator() != null) {
                    next.getAnimator().end();
                }
            }
        }
        m2313W();
        this.f758v = true;
        if (this.f744h.isEmpty()) {
            return null;
        }
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(this.f744h.size());
        boolean z = false;
        for (Fragment fragment : this.f744h.values()) {
            if (fragment != null) {
                if (fragment.mFragmentManager == this) {
                    FragmentState fragmentState = new FragmentState(fragment);
                    arrayList2.add(fragmentState);
                    if (fragment.mState > 0 && fragmentState.f3143n == null) {
                        if (this.f735C == null) {
                            this.f735C = new Bundle();
                        }
                        fragment.performSaveInstanceState(this.f735C);
                        m2328H(fragment, this.f735C, false);
                        if (this.f735C.isEmpty()) {
                            bundle = null;
                        } else {
                            bundle = this.f735C;
                            this.f735C = null;
                        }
                        if (fragment.mView != null) {
                            m2272s0(fragment);
                        }
                        if (fragment.mSavedViewState != null) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putSparseParcelableArray("android:view_state", fragment.mSavedViewState);
                        }
                        if (!fragment.mUserVisibleHint) {
                            if (bundle == null) {
                                bundle = new Bundle();
                            }
                            bundle.putBoolean("android:user_visible_hint", fragment.mUserVisibleHint);
                        }
                        fragmentState.f3143n = bundle;
                        String str = fragment.mTargetWho;
                        if (str != null) {
                            Fragment fragment2 = this.f744h.get(str);
                            if (fragment2 != null) {
                                if (fragmentState.f3143n == null) {
                                    fragmentState.f3143n = new Bundle();
                                }
                                Bundle bundle2 = fragmentState.f3143n;
                                if (fragment2.mFragmentManager == this) {
                                    bundle2.putString("android:target_state", fragment2.mWho);
                                    int i = fragment.mTargetRequestCode;
                                    if (i != 0) {
                                        fragmentState.f3143n.putInt("android:target_req_state", i);
                                    }
                                } else {
                                    m2262x0(new IllegalStateException(outline.m271J("Fragment ", fragment2, " is not currently in the FragmentManager")));
                                    throw null;
                                }
                            } else {
                                m2262x0(new IllegalStateException("Failure saving state: " + fragment + " has target not in fragment manager: " + fragment.mTargetWho));
                                throw null;
                            }
                        }
                    } else {
                        fragmentState.f3143n = fragment.mSavedFragmentState;
                    }
                    z = true;
                } else {
                    m2262x0(new IllegalStateException(outline.m271J("Failure saving state: active ", fragment, " was removed from the FragmentManager")));
                    throw null;
                }
            }
        }
        if (z) {
            int size2 = this.f743g.size();
            if (size2 > 0) {
                arrayList = new ArrayList<>(size2);
                Iterator<Fragment> it2 = this.f743g.iterator();
                while (it2.hasNext()) {
                    Fragment next2 = it2.next();
                    arrayList.add(next2.mWho);
                    if (next2.mFragmentManager != this) {
                        m2262x0(new IllegalStateException(outline.m271J("Failure saving state: active ", next2, " was removed from the FragmentManager")));
                        throw null;
                    }
                }
            } else {
                arrayList = null;
            }
            ArrayList<C0088D5> arrayList3 = this.f745i;
            if (arrayList3 != null && (size = arrayList3.size()) > 0) {
                backStackStateArr = new BackStackState[size];
                for (int i2 = 0; i2 < size; i2++) {
                    backStackStateArr[i2] = new BackStackState(this.f745i.get(i2));
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f3126a = arrayList2;
            fragmentManagerState.f3127b = arrayList;
            fragmentManagerState.f3128c = backStackStateArr;
            Fragment fragment3 = this.f756t;
            if (fragment3 != null) {
                fragmentManagerState.f3129d = fragment3.mWho;
            }
            fragmentManagerState.f3130f = this.f742f;
            return fragmentManagerState;
        }
        return null;
    }

    /* renamed from: s */
    public boolean m2273s(MenuItem menuItem) {
        if (this.f752p < 1) {
            return false;
        }
        for (int i = 0; i < this.f743g.size(); i++) {
            Fragment fragment = this.f743g.get(i);
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: s0 */
    public void m2272s0(Fragment fragment) {
        if (fragment.mInnerView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.f736D;
        if (sparseArray == null) {
            this.f736D = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.mInnerView.saveHierarchyState(this.f736D);
        if (this.f736D.size() > 0) {
            fragment.mSavedViewState = this.f736D;
            this.f736D = null;
        }
    }

    /* renamed from: t */
    public void m2271t() {
        this.f758v = false;
        this.f759w = false;
        m2318R(1);
    }

    /* renamed from: t0 */
    public void m2270t0() {
        synchronized (this) {
            ArrayList<C0246j> arrayList = this.f737E;
            boolean z = false;
            boolean z2 = (arrayList == null || arrayList.isEmpty()) ? false : true;
            ArrayList<InterfaceC0244h> arrayList2 = this.f740c;
            if (arrayList2 != null && arrayList2.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f753q.f640c.removeCallbacks(this.f739G);
                this.f753q.f640c.post(this.f739G);
                m2260y0();
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f755s;
        if (fragment != null) {
            LayoutInflater$Factory2C0000A.C0010h.m2643e(fragment, sb);
        } else {
            LayoutInflater$Factory2C0000A.C0010h.m2643e(this.f753q, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: u */
    public boolean m2269u(Menu menu, MenuInflater menuInflater) {
        if (this.f752p < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f743g.size(); i++) {
            Fragment fragment = this.f743g.get(i);
            if (fragment != null && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f746j != null) {
            for (int i2 = 0; i2 < this.f746j.size(); i2++) {
                Fragment fragment2 = this.f746j.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.f746j = arrayList;
        return z;
    }

    /* renamed from: u0 */
    public void m2268u0(Fragment fragment, AbstractC1917j6.EnumC1919b enumC1919b) {
        if (this.f744h.get(fragment.mWho) == fragment && (fragment.mHost == null || fragment.getFragmentManager() == this)) {
            fragment.mMaxState = enumC1919b;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: v */
    public void m2267v() {
        this.f760x = true;
        m2313W();
        m2318R(0);
        this.f753q = null;
        this.f754r = null;
        this.f755s = null;
        if (this.f747k != null) {
            Iterator<InterfaceC0979c> it = this.f748l.f3940b.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
            this.f747k = null;
        }
    }

    /* renamed from: v0 */
    public void m2266v0(Fragment fragment) {
        if (fragment != null && (this.f744h.get(fragment.mWho) != fragment || (fragment.mHost != null && fragment.getFragmentManager() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        Fragment fragment2 = this.f756t;
        this.f756t = fragment;
        m2321O(fragment2);
        m2321O(this.f756t);
    }

    /* renamed from: w */
    public void m2265w() {
        for (int i = 0; i < this.f743g.size(); i++) {
            Fragment fragment = this.f743g.get(i);
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    /* renamed from: w0 */
    public void m2264w0() {
        for (Fragment fragment : this.f744h.values()) {
            if (fragment != null) {
                m2286l0(fragment);
            }
        }
    }

    /* renamed from: x */
    public void m2263x(boolean z) {
        for (int size = this.f743g.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f743g.get(size);
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z);
            }
        }
    }

    /* renamed from: x0 */
    public final void m2262x0(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C2399z4("FragmentManager"));
        AbstractC0197I5 abstractC0197I5 = this.f753q;
        if (abstractC0197I5 != null) {
            try {
                abstractC0197I5.mo1438e("  ", null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m2316T("  ", null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    /* renamed from: y */
    public void m2261y(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2261y(fragment, bundle, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: y0 */
    public final void m2260y0() {
        ArrayList<InterfaceC0244h> arrayList = this.f740c;
        boolean z = true;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.f748l.f3939a = true;
            return;
        }
        AbstractC1595d abstractC1595d = this.f748l;
        ArrayList<C0088D5> arrayList2 = this.f745i;
        abstractC1595d.f3939a = ((arrayList2 != null ? arrayList2.size() : 0) <= 0 || !m2304c0(this.f755s)) ? false : false;
    }

    /* renamed from: z */
    public void m2259z(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f755s;
        if (fragment2 != null) {
            AbstractC0216J5 fragmentManager = fragment2.getFragmentManager();
            if (fragmentManager instanceof LayoutInflater$Factory2C0236K5) {
                ((LayoutInflater$Factory2C0236K5) fragmentManager).m2259z(fragment, context, true);
            }
        }
        Iterator<C0242f> it = this.f751o.iterator();
        while (it.hasNext()) {
            C0242f next = it.next();
            if (z) {
                Objects.requireNonNull(next);
            } else {
                Objects.requireNonNull(next);
                throw null;
            }
        }
    }

    /* renamed from: K5$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0240d {

        /* renamed from: a */
        public final Animation f766a;

        /* renamed from: b */
        public final Animator f767b;

        public C0240d(Animation animation) {
            this.f766a = animation;
            this.f767b = null;
        }

        public C0240d(Animator animator) {
            this.f766a = null;
            this.f767b = animator;
        }
    }

    /* renamed from: K5$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class RunnableC0241e extends AnimationSet implements Runnable {

        /* renamed from: a */
        public final ViewGroup f768a;

        /* renamed from: b */
        public final View f769b;

        /* renamed from: c */
        public boolean f770c;

        /* renamed from: d */
        public boolean f771d;

        /* renamed from: f */
        public boolean f772f;

        public RunnableC0241e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f772f = true;
            this.f768a = viewGroup;
            this.f769b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f772f = true;
            if (this.f770c) {
                return !this.f771d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f770c = true;
                ViewTreeObserver$OnPreDrawListenerC0351P4.m2156a(this.f768a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f770c && this.f772f) {
                this.f772f = false;
                this.f768a.post(this);
                return;
            }
            this.f768a.endViewTransition(this.f769b);
            this.f771d = true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f772f = true;
            if (this.f770c) {
                return !this.f771d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f770c = true;
                ViewTreeObserver$OnPreDrawListenerC0351P4.m2156a(this.f768a, this);
            }
            return true;
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
