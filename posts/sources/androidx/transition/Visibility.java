package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    private int mMode;
    public static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};

    /* renamed from: androidx.transition.Visibility$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0914a extends C0199I7 {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f3480a;

        /* renamed from: b */
        public final /* synthetic */ View f3481b;

        /* renamed from: c */
        public final /* synthetic */ View f3482c;

        public C0914a(ViewGroup viewGroup, View view, View view2) {
            this.f3480a = viewGroup;
            this.f3481b = view;
            this.f3482c = view2;
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            this.f3482c.setTag(C0090D7.save_overlay_view, null);
            this.f3480a.getOverlay().remove(this.f3481b);
            transition.removeListener(this);
        }

        @Override // p000.C0199I7, androidx.transition.Transition.InterfaceC0911f
        public void onTransitionPause(Transition transition) {
            this.f3480a.getOverlay().remove(this.f3481b);
        }

        @Override // p000.C0199I7, androidx.transition.Transition.InterfaceC0911f
        public void onTransitionResume(Transition transition) {
            if (this.f3481b.getParent() == null) {
                this.f3480a.getOverlay().add(this.f3481b);
            } else {
                Visibility.this.cancel();
            }
        }
    }

    /* renamed from: androidx.transition.Visibility$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0915b extends AnimatorListenerAdapter implements Transition.InterfaceC0911f {

        /* renamed from: a */
        public final View f3484a;

        /* renamed from: b */
        public final int f3485b;

        /* renamed from: c */
        public final ViewGroup f3486c;

        /* renamed from: d */
        public final boolean f3487d;

        /* renamed from: e */
        public boolean f3488e;

        /* renamed from: f */
        public boolean f3489f = false;

        public C0915b(View view, int i, boolean z) {
            this.f3484a = view;
            this.f3485b = i;
            this.f3486c = (ViewGroup) view.getParent();
            this.f3487d = z;
            m1261b(true);
        }

        /* renamed from: a */
        public final void m1262a() {
            if (!this.f3489f) {
                C0399R7.f1350a.mo1796g(this.f3484a, this.f3485b);
                ViewGroup viewGroup = this.f3486c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            m1261b(false);
        }

        /* renamed from: b */
        public final void m1261b(boolean z) {
            ViewGroup viewGroup;
            if (!this.f3487d || this.f3488e == z || (viewGroup = this.f3486c) == null) {
                return;
            }
            this.f3488e = z;
            C0355P7.m2148a(viewGroup, z);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3489f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m1262a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f3489f) {
                return;
            }
            C0399R7.f1350a.mo1796g(this.f3484a, this.f3485b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f3489f) {
                return;
            }
            C0399R7.f1350a.mo1796g(this.f3484a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionEnd(Transition transition) {
            m1262a();
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionPause(Transition transition) {
            m1261b(false);
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionResume(Transition transition) {
            m1261b(true);
        }

        @Override // androidx.transition.Transition.InterfaceC0911f
        public void onTransitionStart(Transition transition) {
        }
    }

    /* renamed from: androidx.transition.Visibility$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0916c {

        /* renamed from: a */
        public boolean f3490a;

        /* renamed from: b */
        public boolean f3491b;

        /* renamed from: c */
        public int f3492c;

        /* renamed from: d */
        public int f3493d;

        /* renamed from: e */
        public ViewGroup f3494e;

        /* renamed from: f */
        public ViewGroup f3495f;
    }

    public Visibility() {
        this.mMode = 3;
    }

    private void captureValues(C0290M7 c0290m7) {
        c0290m7.f970a.put(PROPNAME_VISIBILITY, Integer.valueOf(c0290m7.f971b.getVisibility()));
        c0290m7.f970a.put(PROPNAME_PARENT, c0290m7.f971b.getParent());
        int[] iArr = new int[2];
        c0290m7.f971b.getLocationOnScreen(iArr);
        c0290m7.f970a.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    private C0916c getVisibilityChangeInfo(C0290M7 c0290m7, C0290M7 c0290m72) {
        C0916c c0916c = new C0916c();
        c0916c.f3490a = false;
        c0916c.f3491b = false;
        if (c0290m7 != null && c0290m7.f970a.containsKey(PROPNAME_VISIBILITY)) {
            c0916c.f3492c = ((Integer) c0290m7.f970a.get(PROPNAME_VISIBILITY)).intValue();
            c0916c.f3494e = (ViewGroup) c0290m7.f970a.get(PROPNAME_PARENT);
        } else {
            c0916c.f3492c = -1;
            c0916c.f3494e = null;
        }
        if (c0290m72 != null && c0290m72.f970a.containsKey(PROPNAME_VISIBILITY)) {
            c0916c.f3493d = ((Integer) c0290m72.f970a.get(PROPNAME_VISIBILITY)).intValue();
            c0916c.f3495f = (ViewGroup) c0290m72.f970a.get(PROPNAME_PARENT);
        } else {
            c0916c.f3493d = -1;
            c0916c.f3495f = null;
        }
        if (c0290m7 != null && c0290m72 != null) {
            int i = c0916c.f3492c;
            int i2 = c0916c.f3493d;
            if (i == i2 && c0916c.f3494e == c0916c.f3495f) {
                return c0916c;
            }
            if (i != i2) {
                if (i == 0) {
                    c0916c.f3491b = false;
                    c0916c.f3490a = true;
                } else if (i2 == 0) {
                    c0916c.f3491b = true;
                    c0916c.f3490a = true;
                }
            } else if (c0916c.f3495f == null) {
                c0916c.f3491b = false;
                c0916c.f3490a = true;
            } else if (c0916c.f3494e == null) {
                c0916c.f3491b = true;
                c0916c.f3490a = true;
            }
        } else if (c0290m7 == null && c0916c.f3493d == 0) {
            c0916c.f3491b = true;
            c0916c.f3490a = true;
        } else if (c0290m72 == null && c0916c.f3492c == 0) {
            c0916c.f3491b = false;
            c0916c.f3490a = true;
        }
        return c0916c;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(C0290M7 c0290m7) {
        captureValues(c0290m7);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, C0290M7 c0290m7, C0290M7 c0290m72) {
        C0916c visibilityChangeInfo = getVisibilityChangeInfo(c0290m7, c0290m72);
        if (visibilityChangeInfo.f3490a) {
            if (visibilityChangeInfo.f3494e == null && visibilityChangeInfo.f3495f == null) {
                return null;
            }
            if (visibilityChangeInfo.f3491b) {
                return onAppear(viewGroup, c0290m7, visibilityChangeInfo.f3492c, c0290m72, visibilityChangeInfo.f3493d);
            }
            return onDisappear(viewGroup, c0290m7, visibilityChangeInfo.f3492c, c0290m72, visibilityChangeInfo.f3493d);
        }
        return null;
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    @Override // androidx.transition.Transition
    public boolean isTransitionRequired(C0290M7 c0290m7, C0290M7 c0290m72) {
        if (c0290m7 == null && c0290m72 == null) {
            return false;
        }
        if (c0290m7 == null || c0290m72 == null || c0290m72.f970a.containsKey(PROPNAME_VISIBILITY) == c0290m7.f970a.containsKey(PROPNAME_VISIBILITY)) {
            C0916c visibilityChangeInfo = getVisibilityChangeInfo(c0290m7, c0290m72);
            if (visibilityChangeInfo.f3490a) {
                return visibilityChangeInfo.f3492c == 0 || visibilityChangeInfo.f3493d == 0;
            }
            return false;
        }
        return false;
    }

    public boolean isVisible(C0290M7 c0290m7) {
        if (c0290m7 == null) {
            return false;
        }
        return ((Integer) c0290m7.f970a.get(PROPNAME_VISIBILITY)).intValue() == 0 && ((View) c0290m7.f970a.get(PROPNAME_PARENT)) != null;
    }

    public Animator onAppear(ViewGroup viewGroup, C0290M7 c0290m7, int i, C0290M7 c0290m72, int i2) {
        if ((this.mMode & 1) != 1 || c0290m72 == null) {
            return null;
        }
        if (c0290m7 == null) {
            View view = (View) c0290m72.f971b.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f3490a) {
                return null;
            }
        }
        return onAppear(viewGroup, c0290m72.f971b, c0290m7, c0290m72);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x01c1, code lost:
        if (r0.mCanRemoveViews != false) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator onDisappear(android.view.ViewGroup r22, p000.C0290M7 r23, int r24, p000.C0290M7 r25, int r26) {
        /*
            Method dump skipped, instructions count: 599
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, M7, int, M7, int):android.animation.Animator");
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, C0290M7 c0290m7, C0290M7 c0290m72) {
        return null;
    }

    public void setMode(int i) {
        if ((i & (-4)) == 0) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0174H7.f570c);
        int m2669I = LayoutInflater$Factory2C0000A.C0010h.m2669I(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (m2669I != 0) {
            setMode(m2669I);
        }
    }
}
