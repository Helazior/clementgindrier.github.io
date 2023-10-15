package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class Transition implements Cloneable {
    public static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<C0290M7> mEndValuesList;
    private AbstractC0910e mEpicenterCallback;
    private C2339x1<String, String> mNameOverrides;
    public AbstractC0250K7 mPropagation;
    private ArrayList<C0290M7> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new C0906a();
    private static ThreadLocal<C2339x1<Animator, C0909d>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    public long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    public ArrayList<Integer> mTargetIds = new ArrayList<>();
    public ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private C0313N7 mStartValues = new C0313N7();
    private C0313N7 mEndValues = new C0313N7();
    public TransitionSet mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private ViewGroup mSceneRoot = null;
    public boolean mCanRemoveViews = false;
    public ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<InterfaceC0911f> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;

    /* renamed from: androidx.transition.Transition$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0906a extends PathMotion {
        @Override // androidx.transition.PathMotion
        public Path getPath(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* renamed from: androidx.transition.Transition$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0907b extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ C2339x1 f3465a;

        public C0907b(C2339x1 c2339x1) {
            this.f3465a = c2339x1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3465a.remove(animator);
            Transition.this.mCurrentAnimators.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Transition.this.mCurrentAnimators.add(animator);
        }
    }

    /* renamed from: androidx.transition.Transition$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0908c extends AnimatorListenerAdapter {
        public C0908c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Transition.this.end();
            animator.removeListener(this);
        }
    }

    /* renamed from: androidx.transition.Transition$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0909d {

        /* renamed from: a */
        public View f3468a;

        /* renamed from: b */
        public String f3469b;

        /* renamed from: c */
        public C0290M7 f3470c;

        /* renamed from: d */
        public InterfaceC0612a8 f3471d;

        /* renamed from: e */
        public Transition f3472e;

        public C0909d(View view, String str, Transition transition, InterfaceC0612a8 interfaceC0612a8, C0290M7 c0290m7) {
            this.f3468a = view;
            this.f3469b = str;
            this.f3470c = c0290m7;
            this.f3471d = interfaceC0612a8;
            this.f3472e = transition;
        }
    }

    /* renamed from: androidx.transition.Transition$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0910e {
        /* renamed from: a */
        public abstract Rect mo149a(Transition transition);
    }

    /* renamed from: androidx.transition.Transition$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0911f {
        void onTransitionCancel(Transition transition);

        void onTransitionEnd(Transition transition);

        void onTransitionPause(Transition transition);

        void onTransitionResume(Transition transition);

        void onTransitionStart(Transition transition);
    }

    public Transition() {
    }

    private void addUnmatched(C2339x1<View, C0290M7> c2339x1, C2339x1<View, C0290M7> c2339x12) {
        for (int i = 0; i < c2339x1.size(); i++) {
            C0290M7 valueAt = c2339x1.valueAt(i);
            if (isValidTarget(valueAt.f971b)) {
                this.mStartValuesList.add(valueAt);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < c2339x12.size(); i2++) {
            C0290M7 valueAt2 = c2339x12.valueAt(i2);
            if (isValidTarget(valueAt2.f971b)) {
                this.mEndValuesList.add(valueAt2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private static void addViewValues(C0313N7 c0313n7, View view, C0290M7 c0290m7) {
        c0313n7.f1030a.put(view, c0290m7);
        int id = view.getId();
        if (id >= 0) {
            if (c0313n7.f1031b.indexOfKey(id) >= 0) {
                c0313n7.f1031b.put(id, null);
            } else {
                c0313n7.f1031b.put(id, view);
            }
        }
        AtomicInteger atomicInteger = C0492V4.f1798a;
        String m1890k = C0492V4.C0500h.m1890k(view);
        if (m1890k != null) {
            if (c0313n7.f1033d.containsKey(m1890k)) {
                c0313n7.f1033d.put(m1890k, null);
            } else {
                c0313n7.f1033d.put(m1890k, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                C0034B1<View> c0034b1 = c0313n7.f1032c;
                if (c0034b1.f170a) {
                    c0034b1.m2567d();
                }
                if (C0015A1.m2596b(c0034b1.f171b, c0034b1.f173d, itemIdAtPosition) >= 0) {
                    View m2566e = c0313n7.f1032c.m2566e(itemIdAtPosition);
                    if (m2566e != null) {
                        C0492V4.C0495c.m1926r(m2566e, false);
                        c0313n7.f1032c.m2564g(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                C0492V4.C0495c.m1926r(view, true);
                c0313n7.f1032c.m2564g(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    C0290M7 c0290m7 = new C0290M7(view);
                    if (z) {
                        captureStartValues(c0290m7);
                    } else {
                        captureEndValues(c0290m7);
                    }
                    c0290m7.f972c.add(this);
                    capturePropagationValues(c0290m7);
                    if (z) {
                        addViewValues(this.mStartValues, view, c0290m7);
                    } else {
                        addViewValues(this.mEndValues, view, c0290m7);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                captureHierarchy(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i > 0) {
            if (z) {
                return LayoutInflater$Factory2C0000A.C0010h.m2651a(arrayList, Integer.valueOf(i));
            }
            return LayoutInflater$Factory2C0000A.C0010h.m2638g0(arrayList, Integer.valueOf(i));
        }
        return arrayList;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t != null) {
            if (z) {
                return LayoutInflater$Factory2C0000A.C0010h.m2651a(arrayList, t);
            }
            return LayoutInflater$Factory2C0000A.C0010h.m2638g0(arrayList, t);
        }
        return arrayList;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls != null) {
            if (z) {
                return LayoutInflater$Factory2C0000A.C0010h.m2651a(arrayList, cls);
            }
            return LayoutInflater$Factory2C0000A.C0010h.m2638g0(arrayList, cls);
        }
        return arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view != null) {
            if (z) {
                return LayoutInflater$Factory2C0000A.C0010h.m2651a(arrayList, view);
            }
            return LayoutInflater$Factory2C0000A.C0010h.m2638g0(arrayList, view);
        }
        return arrayList;
    }

    private static C2339x1<Animator, C0909d> getRunningAnimators() {
        C2339x1<Animator, C0909d> c2339x1 = sRunningAnimators.get();
        if (c2339x1 == null) {
            C2339x1<Animator, C0909d> c2339x12 = new C2339x1<>();
            sRunningAnimators.set(c2339x12);
            return c2339x12;
        }
        return c2339x1;
    }

    private static boolean isValidMatch(int i) {
        return i >= 1 && i <= 4;
    }

    private static boolean isValueChanged(C0290M7 c0290m7, C0290M7 c0290m72, String str) {
        Object obj = c0290m7.f970a.get(str);
        Object obj2 = c0290m72.f970a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void matchIds(C2339x1<View, C0290M7> c2339x1, C2339x1<View, C0290M7> c2339x12, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View valueAt = sparseArray.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view)) {
                C0290M7 c0290m7 = c2339x1.get(valueAt);
                C0290M7 c0290m72 = c2339x12.get(view);
                if (c0290m7 != null && c0290m72 != null) {
                    this.mStartValuesList.add(c0290m7);
                    this.mEndValuesList.add(c0290m72);
                    c2339x1.remove(valueAt);
                    c2339x12.remove(view);
                }
            }
        }
    }

    private void matchInstances(C2339x1<View, C0290M7> c2339x1, C2339x1<View, C0290M7> c2339x12) {
        C0290M7 remove;
        for (int size = c2339x1.size() - 1; size >= 0; size--) {
            View keyAt = c2339x1.keyAt(size);
            if (keyAt != null && isValidTarget(keyAt) && (remove = c2339x12.remove(keyAt)) != null && isValidTarget(remove.f971b)) {
                this.mStartValuesList.add(c2339x1.removeAt(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(C2339x1<View, C0290M7> c2339x1, C2339x1<View, C0290M7> c2339x12, C0034B1<View> c0034b1, C0034B1<View> c0034b12) {
        int m2563h = c0034b1.m2563h();
        for (int i = 0; i < m2563h; i++) {
            View m2562i = c0034b1.m2562i(i);
            if (m2562i != null && isValidTarget(m2562i)) {
                if (c0034b1.f170a) {
                    c0034b1.m2567d();
                }
                View m2566e = c0034b12.m2566e(c0034b1.f171b[i]);
                if (m2566e != null && isValidTarget(m2566e)) {
                    C0290M7 c0290m7 = c2339x1.get(m2562i);
                    C0290M7 c0290m72 = c2339x12.get(m2566e);
                    if (c0290m7 != null && c0290m72 != null) {
                        this.mStartValuesList.add(c0290m7);
                        this.mEndValuesList.add(c0290m72);
                        c2339x1.remove(m2562i);
                        c2339x12.remove(m2566e);
                    }
                }
            }
        }
    }

    private void matchNames(C2339x1<View, C0290M7> c2339x1, C2339x1<View, C0290M7> c2339x12, C2339x1<String, View> c2339x13, C2339x1<String, View> c2339x14) {
        View view;
        int size = c2339x13.size();
        for (int i = 0; i < size; i++) {
            View valueAt = c2339x13.valueAt(i);
            if (valueAt != null && isValidTarget(valueAt) && (view = c2339x14.get(c2339x13.keyAt(i))) != null && isValidTarget(view)) {
                C0290M7 c0290m7 = c2339x1.get(valueAt);
                C0290M7 c0290m72 = c2339x12.get(view);
                if (c0290m7 != null && c0290m72 != null) {
                    this.mStartValuesList.add(c0290m7);
                    this.mEndValuesList.add(c0290m72);
                    c2339x1.remove(valueAt);
                    c2339x12.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(C0313N7 c0313n7, C0313N7 c0313n72) {
        C2339x1<View, C0290M7> c2339x1 = new C2339x1<>(c0313n7.f1030a);
        C2339x1<View, C0290M7> c2339x12 = new C2339x1<>(c0313n72.f1030a);
        int i = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 == 1) {
                    matchInstances(c2339x1, c2339x12);
                } else if (i2 == 2) {
                    matchNames(c2339x1, c2339x12, c0313n7.f1033d, c0313n72.f1033d);
                } else if (i2 == 3) {
                    matchIds(c2339x1, c2339x12, c0313n7.f1031b, c0313n72.f1031b);
                } else if (i2 == 4) {
                    matchItemIds(c2339x1, c2339x12, c0313n7.f1032c, c0313n72.f1032c);
                }
                i++;
            } else {
                addUnmatched(c2339x1, c2339x12);
                return;
            }
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (MATCH_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            } else {
                throw new InflateException(outline.m265f("Unknown match type in matchOrder: '", trim, "'"));
            }
            i++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, C2339x1<Animator, C0909d> c2339x1) {
        if (animator != null) {
            animator.addListener(new C0907b(c2339x1));
            animate(animator);
        }
    }

    public Transition addListener(InterfaceC0911f interfaceC0911f) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(interfaceC0911f);
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(animator.getStartDelay() + getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new C0908c());
        animator.start();
    }

    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<InterfaceC0911f> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((InterfaceC0911f) arrayList2.get(i)).onTransitionCancel(this);
        }
    }

    public abstract void captureEndValues(C0290M7 c0290m7);

    public void capturePropagationValues(C0290M7 c0290m7) {
        boolean z;
        if (this.mPropagation == null || c0290m7.f970a.isEmpty()) {
            return;
        }
        Objects.requireNonNull(this.mPropagation);
        String[] strArr = AbstractC0575Y7.f2043a;
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                z = true;
                break;
            } else if (!c0290m7.f970a.containsKey(strArr[i])) {
                z = false;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        Objects.requireNonNull((AbstractC0575Y7) this.mPropagation);
        View view = c0290m7.f971b;
        Integer num = (Integer) c0290m7.f970a.get(Visibility.PROPNAME_VISIBILITY);
        if (num == null) {
            num = Integer.valueOf(view.getVisibility());
        }
        c0290m7.f970a.put("android:visibilityPropagation:visibility", num);
        view.getLocationOnScreen(r3);
        int[] iArr = {Math.round(view.getTranslationX()) + iArr[0]};
        iArr[0] = (view.getWidth() / 2) + iArr[0];
        iArr[1] = Math.round(view.getTranslationY()) + iArr[1];
        iArr[1] = (view.getHeight() / 2) + iArr[1];
        c0290m7.f970a.put("android:visibilityPropagation:center", iArr);
    }

    public abstract void captureStartValues(C0290M7 c0290m7);

    public void captureValues(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        C2339x1<String, String> c2339x1;
        clearValues(z);
        if ((this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) || (((arrayList = this.mTargetNames) != null && !arrayList.isEmpty()) || ((arrayList2 = this.mTargetTypes) != null && !arrayList2.isEmpty()))) {
            captureHierarchy(viewGroup, z);
        } else {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                if (findViewById != null) {
                    C0290M7 c0290m7 = new C0290M7(findViewById);
                    if (z) {
                        captureStartValues(c0290m7);
                    } else {
                        captureEndValues(c0290m7);
                    }
                    c0290m7.f972c.add(this);
                    capturePropagationValues(c0290m7);
                    if (z) {
                        addViewValues(this.mStartValues, findViewById, c0290m7);
                    } else {
                        addViewValues(this.mEndValues, findViewById, c0290m7);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                C0290M7 c0290m72 = new C0290M7(view);
                if (z) {
                    captureStartValues(c0290m72);
                } else {
                    captureEndValues(c0290m72);
                }
                c0290m72.f972c.add(this);
                capturePropagationValues(c0290m72);
                if (z) {
                    addViewValues(this.mStartValues, view, c0290m72);
                } else {
                    addViewValues(this.mEndValues, view, c0290m72);
                }
            }
        }
        if (z || (c2339x1 = this.mNameOverrides) == null) {
            return;
        }
        int size = c2339x1.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.mStartValues.f1033d.remove(this.mNameOverrides.keyAt(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.mStartValues.f1033d.put(this.mNameOverrides.valueAt(i4), view2);
            }
        }
    }

    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.f1030a.clear();
            this.mStartValues.f1031b.clear();
            this.mStartValues.f1032c.m2569b();
            return;
        }
        this.mEndValues.f1030a.clear();
        this.mEndValues.f1031b.clear();
        this.mEndValues.f1032c.m2569b();
    }

    public Animator createAnimator(ViewGroup viewGroup, C0290M7 c0290m7, C0290M7 c0290m72) {
        return null;
    }

    public void createAnimators(ViewGroup viewGroup, C0313N7 c0313n7, C0313N7 c0313n72, ArrayList<C0290M7> arrayList, ArrayList<C0290M7> arrayList2) {
        Animator createAnimator;
        int i;
        int i2;
        View view;
        Animator animator;
        C0290M7 c0290m7;
        Animator animator2;
        C0290M7 c0290m72;
        C2339x1<Animator, C0909d> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j = RecyclerView.FOREVER_NS;
        int i3 = 0;
        while (i3 < size) {
            C0290M7 c0290m73 = arrayList.get(i3);
            C0290M7 c0290m74 = arrayList2.get(i3);
            if (c0290m73 != null && !c0290m73.f972c.contains(this)) {
                c0290m73 = null;
            }
            if (c0290m74 != null && !c0290m74.f972c.contains(this)) {
                c0290m74 = null;
            }
            if (c0290m73 != null || c0290m74 != null) {
                if ((c0290m73 == null || c0290m74 == null || isTransitionRequired(c0290m73, c0290m74)) && (createAnimator = createAnimator(viewGroup, c0290m73, c0290m74)) != null) {
                    if (c0290m74 != null) {
                        view = c0290m74.f971b;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            c0290m72 = new C0290M7(view);
                            i = size;
                            C0290M7 c0290m75 = c0313n72.f1030a.get(view);
                            if (c0290m75 != null) {
                                int i4 = 0;
                                while (i4 < transitionProperties.length) {
                                    c0290m72.f970a.put(transitionProperties[i4], c0290m75.f970a.get(transitionProperties[i4]));
                                    i4++;
                                    i3 = i3;
                                    c0290m75 = c0290m75;
                                }
                            }
                            i2 = i3;
                            int size2 = runningAnimators.size();
                            int i5 = 0;
                            while (true) {
                                if (i5 >= size2) {
                                    animator2 = createAnimator;
                                    break;
                                }
                                C0909d c0909d = runningAnimators.get(runningAnimators.keyAt(i5));
                                if (c0909d.f3470c != null && c0909d.f3468a == view && c0909d.f3469b.equals(getName()) && c0909d.f3470c.equals(c0290m72)) {
                                    animator2 = null;
                                    break;
                                }
                                i5++;
                            }
                        } else {
                            i = size;
                            i2 = i3;
                            animator2 = createAnimator;
                            c0290m72 = null;
                        }
                        animator = animator2;
                        c0290m7 = c0290m72;
                    } else {
                        i = size;
                        i2 = i3;
                        view = c0290m73.f971b;
                        animator = createAnimator;
                        c0290m7 = null;
                    }
                    if (animator != null) {
                        AbstractC0250K7 abstractC0250K7 = this.mPropagation;
                        if (abstractC0250K7 != null) {
                            long mo299a = abstractC0250K7.mo299a(viewGroup, this, c0290m73, c0290m74);
                            sparseIntArray.put(this.mAnimators.size(), (int) mo299a);
                            j = Math.min(mo299a, j);
                        }
                        long j2 = j;
                        String name = getName();
                        C0559X7 c0559x7 = C0399R7.f1350a;
                        runningAnimators.put(animator, new C0909d(view, name, this, new C0591Z7(viewGroup), c0290m7));
                        this.mAnimators.add(animator);
                        j = j2;
                    }
                    i3 = i2 + 1;
                    size = i;
                }
            }
            i = size;
            i2 = i3;
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.mAnimators.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay(animator3.getStartDelay() + (sparseIntArray.valueAt(i6) - j));
            }
        }
    }

    public void end() {
        int i = this.mNumInstances - 1;
        this.mNumInstances = i;
        if (i == 0) {
            ArrayList<InterfaceC0911f> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((InterfaceC0911f) arrayList2.get(i2)).onTransitionEnd(this);
                }
            }
            for (int i3 = 0; i3 < this.mStartValues.f1032c.m2563h(); i3++) {
                View m2562i = this.mStartValues.f1032c.m2562i(i3);
                if (m2562i != null) {
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    C0492V4.C0495c.m1926r(m2562i, false);
                }
            }
            for (int i4 = 0; i4 < this.mEndValues.f1032c.m2563h(); i4++) {
                View m2562i2 = this.mEndValues.f1032c.m2562i(i4);
                if (m2562i2 != null) {
                    AtomicInteger atomicInteger2 = C0492V4.f1798a;
                    C0492V4.C0495c.m1926r(m2562i2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public Transition excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public Transition excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    public void forceToEnd(ViewGroup viewGroup) {
        C2339x1<Animator, C0909d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        C0559X7 c0559x7 = C0399R7.f1350a;
        C0591Z7 c0591z7 = new C0591Z7(viewGroup);
        C2339x1 c2339x1 = new C2339x1(runningAnimators);
        runningAnimators.clear();
        for (int i = size - 1; i >= 0; i--) {
            C0909d c0909d = (C0909d) c2339x1.valueAt(i);
            if (c0909d.f3468a != null && c0591z7.equals(c0909d.f3471d)) {
                ((Animator) c2339x1.keyAt(i)).end();
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        AbstractC0910e abstractC0910e = this.mEpicenterCallback;
        if (abstractC0910e == null) {
            return null;
        }
        return abstractC0910e.mo149a(this);
    }

    public AbstractC0910e getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public C0290M7 getMatchedTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z);
        }
        ArrayList<C0290M7> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            C0290M7 c0290m7 = arrayList.get(i2);
            if (c0290m7 == null) {
                return null;
            }
            if (c0290m7.f971b == view) {
                i = i2;
                break;
            }
            i2++;
        }
        if (i >= 0) {
            return (z ? this.mEndValuesList : this.mStartValuesList).get(i);
        }
        return null;
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public AbstractC0250K7 getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public C0290M7 getTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).f1030a.get(view);
    }

    public boolean isTransitionRequired(C0290M7 c0290m7, C0290M7 c0290m72) {
        if (c0290m7 == null || c0290m72 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            for (String str : transitionProperties) {
                if (!isValueChanged(c0290m7, c0290m72, str)) {
                }
            }
            return false;
        }
        for (String str2 : c0290m7.f970a.keySet()) {
            if (isValueChanged(c0290m7, c0290m72, str2)) {
            }
        }
        return false;
        return true;
    }

    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 == null || !arrayList3.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList4 = this.mTargetExcludes;
            if (arrayList4 == null || !arrayList4.contains(view)) {
                ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                            return false;
                        }
                    }
                }
                if (this.mTargetNameExcludes != null) {
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    if (C0492V4.C0500h.m1890k(view) != null && this.mTargetNameExcludes.contains(C0492V4.C0500h.m1890k(view))) {
                        return false;
                    }
                }
                if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
                    return true;
                }
                ArrayList<String> arrayList6 = this.mTargetNames;
                if (arrayList6 != null) {
                    AtomicInteger atomicInteger2 = C0492V4.f1798a;
                    if (arrayList6.contains(C0492V4.C0500h.m1890k(view))) {
                        return true;
                    }
                }
                if (this.mTargetTypes != null) {
                    for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                        if (this.mTargetTypes.get(i2).isInstance(view)) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        C2339x1<Animator, C0909d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        C0559X7 c0559x7 = C0399R7.f1350a;
        C0591Z7 c0591z7 = new C0591Z7(view);
        for (int i = size - 1; i >= 0; i--) {
            C0909d valueAt = runningAnimators.valueAt(i);
            if (valueAt.f3468a != null && c0591z7.equals(valueAt.f3471d)) {
                runningAnimators.keyAt(i).pause();
            }
        }
        ArrayList<InterfaceC0911f> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((InterfaceC0911f) arrayList2.get(i2)).onTransitionPause(this);
            }
        }
        this.mPaused = true;
    }

    public void playTransition(ViewGroup viewGroup) {
        C0909d c0909d;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        C2339x1<Animator, C0909d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        C0559X7 c0559x7 = C0399R7.f1350a;
        C0591Z7 c0591z7 = new C0591Z7(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator keyAt = runningAnimators.keyAt(i);
            if (keyAt != null && (c0909d = runningAnimators.get(keyAt)) != null && c0909d.f3468a != null && c0591z7.equals(c0909d.f3471d)) {
                C0290M7 c0290m7 = c0909d.f3470c;
                View view = c0909d.f3468a;
                C0290M7 transitionValues = getTransitionValues(view, true);
                C0290M7 matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f1030a.get(view);
                }
                if (!(transitionValues == null && matchedTransitionValues == null) && c0909d.f3472e.isTransitionRequired(c0290m7, matchedTransitionValues)) {
                    if (!keyAt.isRunning() && !keyAt.isStarted()) {
                        runningAnimators.remove(keyAt);
                    } else {
                        keyAt.cancel();
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public Transition removeListener(InterfaceC0911f interfaceC0911f) {
        ArrayList<InterfaceC0911f> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(interfaceC0911f);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                C2339x1<Animator, C0909d> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                C0559X7 c0559x7 = C0399R7.f1350a;
                C0591Z7 c0591z7 = new C0591Z7(view);
                for (int i = size - 1; i >= 0; i--) {
                    C0909d valueAt = runningAnimators.valueAt(i);
                    if (valueAt.f3468a != null && c0591z7.equals(valueAt.f3471d)) {
                        runningAnimators.keyAt(i).resume();
                    }
                }
                ArrayList<InterfaceC0911f> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((InterfaceC0911f) arrayList2.get(i2)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        C2339x1<Animator, C0909d> runningAnimators = getRunningAnimators();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public Transition setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public void setEpicenterCallback(AbstractC0910e abstractC0910e) {
        this.mEpicenterCallback = abstractC0910e;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            for (int i = 0; i < iArr.length; i++) {
                if (isValidMatch(iArr[i])) {
                    if (alreadyContains(iArr, i)) {
                        throw new IllegalArgumentException("matches contains a duplicate value");
                    }
                } else {
                    throw new IllegalArgumentException("matches contains invalid value");
                }
            }
            this.mMatchOrder = (int[]) iArr.clone();
            return;
        }
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(AbstractC0250K7 abstractC0250K7) {
        this.mPropagation = abstractC0250K7;
    }

    public Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public Transition setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<InterfaceC0911f> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((InterfaceC0911f) arrayList2.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    public Transition addTarget(int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    @Override // 
    /* renamed from: clone */
    public Transition mo2710clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new C0313N7();
            transition.mEndValues = new C0313N7();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Transition excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    public Transition excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public Transition removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public String toString(String str) {
        StringBuilder m253r = outline.m253r(str);
        m253r.append(getClass().getSimpleName());
        m253r.append("@");
        m253r.append(Integer.toHexString(hashCode()));
        m253r.append(": ");
        String sb = m253r.toString();
        if (this.mDuration != -1) {
            StringBuilder m252s = outline.m252s(sb, "dur(");
            m252s.append(this.mDuration);
            m252s.append(") ");
            sb = m252s.toString();
        }
        if (this.mStartDelay != -1) {
            StringBuilder m252s2 = outline.m252s(sb, "dly(");
            m252s2.append(this.mStartDelay);
            m252s2.append(") ");
            sb = m252s2.toString();
        }
        if (this.mInterpolator != null) {
            StringBuilder m252s3 = outline.m252s(sb, "interp(");
            m252s3.append(this.mInterpolator);
            m252s3.append(") ");
            sb = m252s3.toString();
        }
        if (this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            String m266e = outline.m266e(sb, "tgts(");
            if (this.mTargetIds.size() > 0) {
                for (int i = 0; i < this.mTargetIds.size(); i++) {
                    if (i > 0) {
                        m266e = outline.m266e(m266e, ", ");
                    }
                    StringBuilder m253r2 = outline.m253r(m266e);
                    m253r2.append(this.mTargetIds.get(i));
                    m266e = m253r2.toString();
                }
            }
            if (this.mTargets.size() > 0) {
                for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                    if (i2 > 0) {
                        m266e = outline.m266e(m266e, ", ");
                    }
                    StringBuilder m253r3 = outline.m253r(m266e);
                    m253r3.append(this.mTargets.get(i2));
                    m266e = m253r3.toString();
                }
            }
            return outline.m266e(m266e, ")");
        }
        return sb;
    }

    public Transition addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public Transition excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    public Transition excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public Transition removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public Transition excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public Transition removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public Transition addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0174H7.f568a);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long m2669I = LayoutInflater$Factory2C0000A.C0010h.m2669I(obtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (m2669I >= 0) {
            setDuration(m2669I);
        }
        long m2669I2 = LayoutInflater$Factory2C0000A.C0010h.m2669I(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (m2669I2 > 0) {
            setStartDelay(m2669I2);
        }
        int m2668J = LayoutInflater$Factory2C0000A.C0010h.m2668J(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (m2668J > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, m2668J));
        }
        String m2667K = LayoutInflater$Factory2C0000A.C0010h.m2667K(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (m2667K != null) {
            setMatchOrder(parseMatchOrder(m2667K));
        }
        obtainStyledAttributes.recycle();
    }
}
