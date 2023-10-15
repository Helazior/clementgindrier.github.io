package p000;

import android.view.animation.Interpolator;
import androidx.fragment.app.Fragment;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Objects;
import p000.AbstractC0352P5;
import p000.LayoutInflater$Factory2C0236K5;

/* renamed from: D5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0088D5 extends AbstractC0352P5 implements LayoutInflater$Factory2C0236K5.InterfaceC0244h {

    /* renamed from: q */
    public final LayoutInflater$Factory2C0236K5 f349q;

    /* renamed from: r */
    public boolean f350r;

    /* renamed from: s */
    public int f351s = -1;

    public C0088D5(LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5) {
        this.f349q = layoutInflater$Factory2C0236K5;
    }

    /* renamed from: o */
    public static boolean m2476o(AbstractC0352P5.C0353a c0353a) {
        Fragment fragment = c0353a.f1205b;
        return (fragment == null || !fragment.mAdded || fragment.mView == null || fragment.mDetached || fragment.mHidden || !fragment.isPostponed()) ? false : true;
    }

    @Override // p000.LayoutInflater$Factory2C0236K5.InterfaceC0244h
    /* renamed from: a */
    public boolean mo2257a(ArrayList<C0088D5> arrayList, ArrayList<Boolean> arrayList2) {
        Interpolator interpolator = LayoutInflater$Factory2C0236K5.f731H;
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (this.f1195h) {
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f349q;
            if (layoutInflater$Factory2C0236K5.f745i == null) {
                layoutInflater$Factory2C0236K5.f745i = new ArrayList<>();
            }
            layoutInflater$Factory2C0236K5.f745i.add(this);
            return true;
        }
        return true;
    }

    @Override // p000.AbstractC0352P5
    /* renamed from: c */
    public int mo2153c() {
        return m2482i(false);
    }

    @Override // p000.AbstractC0352P5
    /* renamed from: d */
    public int mo2152d() {
        return m2482i(true);
    }

    @Override // p000.AbstractC0352P5
    /* renamed from: e */
    public void mo2151e() {
        if (!this.f1195h) {
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f349q;
            layoutInflater$Factory2C0236K5.m2314V(false);
            mo2257a(layoutInflater$Factory2C0236K5.f762z, layoutInflater$Factory2C0236K5.f733A);
            layoutInflater$Factory2C0236K5.f741d = true;
            try {
                layoutInflater$Factory2C0236K5.m2280o0(layoutInflater$Factory2C0236K5.f762z, layoutInflater$Factory2C0236K5.f733A);
                layoutInflater$Factory2C0236K5.m2281o();
                layoutInflater$Factory2C0236K5.m2260y0();
                layoutInflater$Factory2C0236K5.m2317S();
                layoutInflater$Factory2C0236K5.m2285m();
                return;
            } catch (Throwable th) {
                layoutInflater$Factory2C0236K5.m2281o();
                throw th;
            }
        }
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    @Override // p000.AbstractC0352P5
    /* renamed from: f */
    public void mo2150f(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str2 = fragment.mTag;
                if (str2 != null && !str.equals(str2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Can't change tag of fragment ");
                    sb.append(fragment);
                    sb.append(": was ");
                    throw new IllegalStateException(outline.m261j(sb, fragment.mTag, " now ", str));
                }
                fragment.mTag = str;
            }
            if (i != 0) {
                if (i != -1) {
                    int i3 = fragment.mFragmentId;
                    if (i3 != 0 && i3 != i) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i);
                    }
                    fragment.mFragmentId = i;
                    fragment.mContainerId = i;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            m2154b(new AbstractC0352P5.C0353a(i2, fragment));
            fragment.mFragmentManager = this.f349q;
            return;
        }
        StringBuilder m253r = outline.m253r("Fragment ");
        m253r.append(cls.getCanonicalName());
        m253r.append(" must be a public static class to be  properly recreated from instance state.");
        throw new IllegalStateException(m253r.toString());
    }

    @Override // p000.AbstractC0352P5
    /* renamed from: g */
    public AbstractC0352P5 mo2149g(Fragment fragment) {
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = fragment.mFragmentManager;
        if (layoutInflater$Factory2C0236K5 != null && layoutInflater$Factory2C0236K5 != this.f349q) {
            StringBuilder m253r = outline.m253r("Cannot remove Fragment attached to a different FragmentManager. Fragment ");
            m253r.append(fragment.toString());
            m253r.append(" is already attached to a FragmentManager.");
            throw new IllegalStateException(m253r.toString());
        }
        m2154b(new AbstractC0352P5.C0353a(3, fragment));
        return this;
    }

    /* renamed from: h */
    public void m2483h(int i) {
        if (this.f1195h) {
            Interpolator interpolator = LayoutInflater$Factory2C0236K5.f731H;
            int size = this.f1188a.size();
            for (int i2 = 0; i2 < size; i2++) {
                Fragment fragment = this.f1188a.get(i2).f1205b;
                if (fragment != null) {
                    fragment.mBackStackNesting += i;
                    Interpolator interpolator2 = LayoutInflater$Factory2C0236K5.f731H;
                }
            }
        }
    }

    /* renamed from: i */
    public int m2482i(boolean z) {
        int size;
        if (!this.f350r) {
            Interpolator interpolator = LayoutInflater$Factory2C0236K5.f731H;
            this.f350r = true;
            if (this.f1195h) {
                LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f349q;
                synchronized (layoutInflater$Factory2C0236K5) {
                    ArrayList<Integer> arrayList = layoutInflater$Factory2C0236K5.f750n;
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList<Integer> arrayList2 = layoutInflater$Factory2C0236K5.f750n;
                        size = arrayList2.remove(arrayList2.size() - 1).intValue();
                        layoutInflater$Factory2C0236K5.f749m.set(size, this);
                    }
                    if (layoutInflater$Factory2C0236K5.f749m == null) {
                        layoutInflater$Factory2C0236K5.f749m = new ArrayList<>();
                    }
                    size = layoutInflater$Factory2C0236K5.f749m.size();
                    layoutInflater$Factory2C0236K5.f749m.add(this);
                }
                this.f351s = size;
            } else {
                this.f351s = -1;
            }
            this.f349q.m2315U(this, z);
            return this.f351s;
        }
        throw new IllegalStateException("commit already called");
    }

    /* renamed from: j */
    public void m2481j(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1196i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f351s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f350r);
            if (this.f1193f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1193f));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f1194g));
            }
            if (this.f1189b != 0 || this.f1190c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1189b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1190c));
            }
            if (this.f1191d != 0 || this.f1192e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1191d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1192e));
            }
            if (this.f1197j != 0 || this.f1198k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1197j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1198k);
            }
            if (this.f1199l != 0 || this.f1200m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1199l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1200m);
            }
        }
        if (this.f1188a.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1188a.size();
        for (int i = 0; i < size; i++) {
            AbstractC0352P5.C0353a c0353a = this.f1188a.get(i);
            switch (c0353a.f1204a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    StringBuilder m253r = outline.m253r("cmd=");
                    m253r.append(c0353a.f1204a);
                    str2 = m253r.toString();
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(c0353a.f1205b);
            if (z) {
                if (c0353a.f1206c != 0 || c0353a.f1207d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(c0353a.f1206c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(c0353a.f1207d));
                }
                if (c0353a.f1208e != 0 || c0353a.f1209f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(c0353a.f1208e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(c0353a.f1209f));
                }
            }
        }
    }

    /* renamed from: k */
    public void m2480k() {
        int size = this.f1188a.size();
        for (int i = 0; i < size; i++) {
            AbstractC0352P5.C0353a c0353a = this.f1188a.get(i);
            Fragment fragment = c0353a.f1205b;
            if (fragment != null) {
                fragment.setNextTransition(this.f1193f, this.f1194g);
            }
            switch (c0353a.f1204a) {
                case 1:
                    fragment.setNextAnim(c0353a.f1206c);
                    this.f349q.m2291j(fragment, false);
                    break;
                case 2:
                default:
                    StringBuilder m253r = outline.m253r("Unknown cmd: ");
                    m253r.append(c0353a.f1204a);
                    throw new IllegalArgumentException(m253r.toString());
                case 3:
                    fragment.setNextAnim(c0353a.f1207d);
                    this.f349q.m2282n0(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(c0353a.f1207d);
                    Objects.requireNonNull(this.f349q);
                    if (!fragment.mHidden) {
                        fragment.mHidden = true;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                        break;
                    }
                    break;
                case 5:
                    fragment.setNextAnim(c0353a.f1206c);
                    Objects.requireNonNull(this.f349q);
                    if (fragment.mHidden) {
                        fragment.mHidden = false;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                        break;
                    }
                    break;
                case 6:
                    fragment.setNextAnim(c0353a.f1207d);
                    this.f349q.m2277q(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(c0353a.f1206c);
                    this.f349q.m2287l(fragment);
                    break;
                case 8:
                    this.f349q.m2266v0(fragment);
                    break;
                case 9:
                    this.f349q.m2266v0(null);
                    break;
                case 10:
                    this.f349q.m2268u0(fragment, c0353a.f1211h);
                    break;
            }
            if (!this.f1203p && c0353a.f1204a != 1 && fragment != null) {
                this.f349q.m2294h0(fragment);
            }
        }
        if (this.f1203p) {
            return;
        }
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f349q;
        layoutInflater$Factory2C0236K5.m2292i0(layoutInflater$Factory2C0236K5.f752p, true);
    }

    /* renamed from: l */
    public void m2479l(boolean z) {
        for (int size = this.f1188a.size() - 1; size >= 0; size--) {
            AbstractC0352P5.C0353a c0353a = this.f1188a.get(size);
            Fragment fragment = c0353a.f1205b;
            if (fragment != null) {
                int i = this.f1193f;
                Interpolator interpolator = LayoutInflater$Factory2C0236K5.f731H;
                fragment.setNextTransition(i != 4097 ? i != 4099 ? i != 8194 ? 0 : 4097 : 4099 : 8194, this.f1194g);
            }
            switch (c0353a.f1204a) {
                case 1:
                    fragment.setNextAnim(c0353a.f1209f);
                    this.f349q.m2282n0(fragment);
                    break;
                case 2:
                default:
                    StringBuilder m253r = outline.m253r("Unknown cmd: ");
                    m253r.append(c0353a.f1204a);
                    throw new IllegalArgumentException(m253r.toString());
                case 3:
                    fragment.setNextAnim(c0353a.f1208e);
                    this.f349q.m2291j(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(c0353a.f1208e);
                    Objects.requireNonNull(this.f349q);
                    if (fragment.mHidden) {
                        fragment.mHidden = false;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                        break;
                    }
                    break;
                case 5:
                    fragment.setNextAnim(c0353a.f1209f);
                    Objects.requireNonNull(this.f349q);
                    if (!fragment.mHidden) {
                        fragment.mHidden = true;
                        fragment.mHiddenChanged = !fragment.mHiddenChanged;
                        break;
                    }
                    break;
                case 6:
                    fragment.setNextAnim(c0353a.f1208e);
                    this.f349q.m2287l(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(c0353a.f1209f);
                    this.f349q.m2277q(fragment);
                    break;
                case 8:
                    this.f349q.m2266v0(null);
                    break;
                case 9:
                    this.f349q.m2266v0(fragment);
                    break;
                case 10:
                    this.f349q.m2268u0(fragment, c0353a.f1210g);
                    break;
            }
            if (!this.f1203p && c0353a.f1204a != 3 && fragment != null) {
                this.f349q.m2294h0(fragment);
            }
        }
        if (this.f1203p || !z) {
            return;
        }
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.f349q;
        layoutInflater$Factory2C0236K5.m2292i0(layoutInflater$Factory2C0236K5.f752p, true);
    }

    /* renamed from: m */
    public boolean m2478m(int i) {
        int size = this.f1188a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f1188a.get(i2).f1205b;
            int i3 = fragment != null ? fragment.mContainerId : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: n */
    public boolean m2477n(ArrayList<C0088D5> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f1188a.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = this.f1188a.get(i4).f1205b;
            int i5 = fragment != null ? fragment.mContainerId : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    C0088D5 c0088d5 = arrayList.get(i6);
                    int size2 = c0088d5.f1188a.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = c0088d5.f1188a.get(i7).f1205b;
                        if ((fragment2 != null ? fragment2.mContainerId : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f351s >= 0) {
            sb.append(" #");
            sb.append(this.f351s);
        }
        if (this.f1196i != null) {
            sb.append(" ");
            sb.append(this.f1196i);
        }
        sb.append("}");
        return sb.toString();
    }
}
