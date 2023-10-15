package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.LiveData;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import p000.AbstractC1917j6;
import p000.C0039B6;
import p000.LayoutInflater$Factory2C0000A;
import p000.LayoutInflater$Factory2C0236K5;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC1979m6, InterfaceC2402z6, InterfaceC1959l7 {
    public static final int ACTIVITY_CREATED = 2;
    public static final int CREATED = 1;
    public static final int INITIALIZING = 0;
    public static final int RESUMED = 4;
    public static final int STARTED = 3;
    public static final Object USE_DEFAULT_TRANSITION = new Object();
    public boolean mAdded;
    public C0808d mAnimationInfo;
    public Bundle mArguments;
    public int mBackStackNesting;
    private boolean mCalled;
    public LayoutInflater$Factory2C0236K5 mChildFragmentManager;
    public ViewGroup mContainer;
    public int mContainerId;
    private int mContentLayoutId;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public LayoutInflater$Factory2C0236K5 mFragmentManager;
    public boolean mFromLayout;
    public boolean mHasMenu;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public AbstractC0197I5 mHost;
    public boolean mInLayout;
    public View mInnerView;
    public boolean mIsCreated;
    public boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    public LayoutInflater mLayoutInflater;
    public C2002n6 mLifecycleRegistry;
    public AbstractC1917j6.EnumC1919b mMaxState;
    public boolean mMenuVisible;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public float mPostponedAlpha;
    public Runnable mPostponedDurationRunnable;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetainInstanceChangedWhileDetached;
    public Bundle mSavedFragmentState;
    public C1939k7 mSavedStateRegistryController;
    public Boolean mSavedUserVisibleHint;
    public SparseArray<Parcelable> mSavedViewState;
    public int mState;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public String mTargetWho;
    public boolean mUserVisibleHint;
    public View mView;
    public C0610a6 mViewLifecycleOwner;
    public C2212r6<InterfaceC1979m6> mViewLifecycleOwnerLiveData;
    public String mWho;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0804a();

        /* renamed from: a */
        public final Bundle f3094a;

        /* renamed from: androidx.fragment.app.Fragment$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0804a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f3094a = readBundle;
            if (classLoader == null || readBundle == null) {
                return;
            }
            readBundle.setClassLoader(classLoader);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f3094a);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0805a implements Runnable {
        public RunnableC0805a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0806b implements Runnable {
        public RunnableC0806b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.callStartTransitionListener();
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0807c extends AbstractC0132F5 {
        public C0807c() {
        }

        @Override // p000.AbstractC0132F5
        /* renamed from: a */
        public View mo1441a(int i) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException("Fragment " + this + " does not have a view");
        }

        @Override // p000.AbstractC0132F5
        /* renamed from: c */
        public boolean mo1440c() {
            return Fragment.this.mView != null;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0808d {

        /* renamed from: a */
        public View f3098a;

        /* renamed from: b */
        public Animator f3099b;

        /* renamed from: c */
        public int f3100c;

        /* renamed from: d */
        public int f3101d;

        /* renamed from: e */
        public int f3102e;

        /* renamed from: f */
        public int f3103f;

        /* renamed from: g */
        public Object f3104g = null;

        /* renamed from: h */
        public Object f3105h;

        /* renamed from: i */
        public Object f3106i;

        /* renamed from: j */
        public Object f3107j;

        /* renamed from: k */
        public Object f3108k;

        /* renamed from: l */
        public Object f3109l;

        /* renamed from: m */
        public Boolean f3110m;

        /* renamed from: n */
        public Boolean f3111n;

        /* renamed from: o */
        public boolean f3112o;

        /* renamed from: p */
        public InterfaceC0810f f3113p;

        /* renamed from: q */
        public boolean f3114q;

        public C0808d() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f3105h = obj;
            this.f3106i = null;
            this.f3107j = obj;
            this.f3108k = null;
            this.f3109l = obj;
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0809e extends RuntimeException {
        public C0809e(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* renamed from: androidx.fragment.app.Fragment$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0810f {
    }

    public Fragment() {
        this.mState = 0;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new LayoutInflater$Factory2C0236K5();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new RunnableC0805a();
        this.mMaxState = AbstractC1917j6.EnumC1919b.RESUMED;
        this.mViewLifecycleOwnerLiveData = new C2212r6<>();
        initLifecycle();
    }

    private C0808d ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new C0808d();
        }
        return this.mAnimationInfo;
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new C2002n6(this);
        this.mSavedStateRegistryController = new C1939k7(this);
        this.mLifecycleRegistry.mo575a(new InterfaceC1938k6() { // from class: androidx.fragment.app.Fragment.2
            @Override // p000.InterfaceC1938k6
            /* renamed from: d */
            public void mo680d(InterfaceC1979m6 interfaceC1979m6, AbstractC1917j6.EnumC1918a enumC1918a) {
                View view;
                if (enumC1918a != AbstractC1917j6.EnumC1918a.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public void callStartTransitionListener() {
        C0808d c0808d = this.mAnimationInfo;
        Object obj = null;
        if (c0808d != null) {
            c0808d.f3112o = false;
            Object obj2 = c0808d.f3113p;
            c0808d.f3113p = null;
            obj = obj2;
        }
        if (obj != null) {
            LayoutInflater$Factory2C0236K5.C0246j c0246j = (LayoutInflater$Factory2C0236K5.C0246j) obj;
            int i = c0246j.f779c - 1;
            c0246j.f779c = i;
            if (i != 0) {
                return;
            }
            c0246j.f778b.f349q.m2270t0();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (getNextAnim() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(getNextAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(getStateAfterAnimating());
        }
        if (getContext() != null) {
            AbstractC0020A6.m2589b(this).mo2558a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.m2316T(outline.m266e(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.m2310Z(str);
    }

    public final FragmentActivity getActivity() {
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        if (abstractC0197I5 == null) {
            return null;
        }
        return (FragmentActivity) abstractC0197I5.f638a;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null || (bool = c0808d.f3111n) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null || (bool = c0808d.f3110m) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        return c0808d.f3098a;
    }

    public Animator getAnimator() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        return c0808d.f3099b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final AbstractC0216J5 getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        if (abstractC0197I5 == null) {
            return null;
        }
        return abstractC0197I5.f639b;
    }

    public Object getEnterTransition() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        return c0808d.f3104g;
    }

    public AbstractC2289v3 getEnterTransitionCallback() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        Objects.requireNonNull(c0808d);
        return null;
    }

    public Object getExitTransition() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        return c0808d.f3106i;
    }

    public AbstractC2289v3 getExitTransitionCallback() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        Objects.requireNonNull(c0808d);
        return null;
    }

    public final AbstractC0216J5 getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        if (abstractC0197I5 == null) {
            return null;
        }
        return abstractC0197I5.mo1437f();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // p000.InterfaceC1979m6
    public AbstractC1917j6 getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public AbstractC0020A6 getLoaderManager() {
        return AbstractC0020A6.m2589b(this);
    }

    public int getNextAnim() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return 0;
        }
        return c0808d.f3101d;
    }

    public int getNextTransition() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return 0;
        }
        return c0808d.f3102e;
    }

    public int getNextTransitionStyle() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return 0;
        }
        return c0808d.f3103f;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public Object getReenterTransition() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        Object obj = c0808d.f3107j;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        Object obj = c0808d.f3105h;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // p000.InterfaceC1959l7
    public final C1920j7 getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f5385b;
    }

    public Object getSharedElementEnterTransition() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        return c0808d.f3108k;
    }

    public Object getSharedElementReturnTransition() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return null;
        }
        Object obj = c0808d.f3109l;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public int getStateAfterAnimating() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return 0;
        }
        return c0808d.f3100c;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mFragmentManager;
        if (layoutInflater$Factory2C0236K5 == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return layoutInflater$Factory2C0236K5.f744h.get(str);
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public InterfaceC1979m6 getViewLifecycleOwner() {
        C0610a6 c0610a6 = this.mViewLifecycleOwner;
        if (c0610a6 != null) {
            return c0610a6;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<InterfaceC1979m6> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // p000.InterfaceC2402z6
    public C2385y6 getViewModelStore() {
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mFragmentManager;
        if (layoutInflater$Factory2C0236K5 != null) {
            C0332O5 c0332o5 = layoutInflater$Factory2C0236K5.f738F;
            C2385y6 c2385y6 = c0332o5.f1122d.get(this.mWho);
            if (c2385y6 == null) {
                C2385y6 c2385y62 = new C2385y6();
                c0332o5.f1122d.put(this.mWho, c2385y62);
                return c2385y62;
            }
            return c2385y6;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new LayoutInflater$Factory2C0236K5();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return false;
        }
        return c0808d.f3114q;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public boolean isPostponed() {
        C0808d c0808d = this.mAnimationInfo;
        if (c0808d == null) {
            return false;
        }
        return c0808d.f3112o;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 4;
    }

    public final boolean isStateSaved() {
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mFragmentManager;
        if (layoutInflater$Factory2C0236K5 == null) {
            return false;
        }
        return layoutInflater$Factory2C0236K5.m2302d0();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.m2288k0();
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        Activity activity = abstractC0197I5 == null ? null : abstractC0197I5.f638a;
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mChildFragmentManager;
        if (layoutInflater$Factory2C0236K5.f752p >= 1) {
            return;
        }
        layoutInflater$Factory2C0236K5.m2271t();
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        Activity activity = abstractC0197I5 == null ? null : abstractC0197I5.f638a;
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.m2288k0();
        this.mState = 2;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mChildFragmentManager;
            layoutInflater$Factory2C0236K5.f758v = false;
            layoutInflater$Factory2C0236K5.f759w = false;
            layoutInflater$Factory2C0236K5.m2318R(2);
            return;
        }
        throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onActivityCreated()"));
    }

    public void performAttach() {
        this.mChildFragmentManager.m2289k(this.mHost, new C0807c(), this);
        this.mCalled = false;
        onAttach(this.mHost.f639b);
        if (!this.mCalled) {
            throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onAttach()"));
        }
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.m2275r(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return onContextItemSelected(menuItem) || this.mChildFragmentManager.m2273s(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.m2288k0();
        this.mState = 1;
        this.mCalled = false;
        this.mSavedStateRegistryController.m679a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.m572d(AbstractC1917j6.EnumC1918a.ON_CREATE);
            return;
        }
        throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onCreate()"));
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.m2269u(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.m2288k0();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new C0610a6();
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            C0610a6 c0610a6 = this.mViewLifecycleOwner;
            if (c0610a6.f2172a == null) {
                c0610a6.f2172a = new C2002n6(c0610a6);
            }
            this.mViewLifecycleOwnerLiveData.mo419h(this.mViewLifecycleOwner);
            return;
        }
        if (!(this.mViewLifecycleOwner.f2172a != null)) {
            this.mViewLifecycleOwner = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performDestroy() {
        this.mChildFragmentManager.m2267v();
        this.mLifecycleRegistry.m572d(AbstractC1917j6.EnumC1918a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.m2318R(1);
        if (this.mView != null) {
            C0610a6 c0610a6 = this.mViewLifecycleOwner;
            c0610a6.f2172a.m572d(AbstractC1917j6.EnumC1918a.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            C0039B6.C0041b c0041b = ((C0039B6) AbstractC0020A6.m2589b(this)).f192b;
            int m2448i = c0041b.f194b.m2448i();
            for (int i = 0; i < m2448i; i++) {
                Objects.requireNonNull(c0041b.f194b.m2447j(i));
            }
            this.mPerformedCreateView = false;
            return;
        }
        throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public void performDetach() {
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mChildFragmentManager;
            if (layoutInflater$Factory2C0236K5.f760x) {
                return;
            }
            layoutInflater$Factory2C0236K5.m2267v();
            this.mChildFragmentManager = new LayoutInflater$Factory2C0236K5();
            return;
        }
        throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onDetach()"));
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.m2265w();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.m2263x(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        return (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) || this.mChildFragmentManager.m2323M(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.m2322N(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.m2318R(3);
        if (this.mView != null) {
            C0610a6 c0610a6 = this.mViewLifecycleOwner;
            c0610a6.f2172a.m572d(AbstractC1917j6.EnumC1918a.ON_PAUSE);
        }
        this.mLifecycleRegistry.m572d(AbstractC1917j6.EnumC1918a.ON_PAUSE);
        this.mState = 3;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.m2320P(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.m2319Q(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean m2304c0 = this.mFragmentManager.m2304c0(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != m2304c0) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(m2304c0);
            onPrimaryNavigationFragmentChanged(m2304c0);
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mChildFragmentManager;
            layoutInflater$Factory2C0236K5.m2260y0();
            layoutInflater$Factory2C0236K5.m2321O(layoutInflater$Factory2C0236K5.f756t);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.m2288k0();
        this.mChildFragmentManager.m2313W();
        this.mState = 4;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            C2002n6 c2002n6 = this.mLifecycleRegistry;
            AbstractC1917j6.EnumC1918a enumC1918a = AbstractC1917j6.EnumC1918a.ON_RESUME;
            c2002n6.m572d(enumC1918a);
            if (this.mView != null) {
                this.mViewLifecycleOwner.f2172a.m572d(enumC1918a);
            }
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mChildFragmentManager;
            layoutInflater$Factory2C0236K5.f758v = false;
            layoutInflater$Factory2C0236K5.f759w = false;
            layoutInflater$Factory2C0236K5.m2318R(4);
            this.mChildFragmentManager.m2313W();
            return;
        }
        throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onResume()"));
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.m678b(bundle);
        Parcelable m2274r0 = this.mChildFragmentManager.m2274r0();
        if (m2274r0 != null) {
            bundle.putParcelable("android:support:fragments", m2274r0);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.m2288k0();
        this.mChildFragmentManager.m2313W();
        this.mState = 3;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            C2002n6 c2002n6 = this.mLifecycleRegistry;
            AbstractC1917j6.EnumC1918a enumC1918a = AbstractC1917j6.EnumC1918a.ON_START;
            c2002n6.m572d(enumC1918a);
            if (this.mView != null) {
                this.mViewLifecycleOwner.f2172a.m572d(enumC1918a);
            }
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mChildFragmentManager;
            layoutInflater$Factory2C0236K5.f758v = false;
            layoutInflater$Factory2C0236K5.f759w = false;
            layoutInflater$Factory2C0236K5.m2318R(3);
            return;
        }
        throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onStart()"));
    }

    public void performStop() {
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mChildFragmentManager;
        layoutInflater$Factory2C0236K5.f759w = true;
        layoutInflater$Factory2C0236K5.m2318R(2);
        if (this.mView != null) {
            C0610a6 c0610a6 = this.mViewLifecycleOwner;
            c0610a6.f2172a.m572d(AbstractC1917j6.EnumC1918a.ON_STOP);
        }
        this.mLifecycleRegistry.m572d(AbstractC1917j6.EnumC1918a.ON_STOP);
        this.mState = 2;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().f3112o = true;
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String[] strArr, int i) {
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        if (abstractC0197I5 != null) {
            abstractC0197I5.mo1433j(this, strArr, i);
            return;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " not attached to Activity"));
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " not attached to a context."));
    }

    public final AbstractC0216J5 requireFragmentManager() {
        AbstractC0216J5 fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " not associated with a fragment manager."));
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment == null) {
            if (getContext() == null) {
                throw new IllegalStateException(outline.m271J("Fragment ", this, " is not attached to any Fragment or host"));
            }
            throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
        }
        return parentFragment;
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.m2276q0(parcelable);
        this.mChildFragmentManager.m2271t();
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mInnerView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                C0610a6 c0610a6 = this.mViewLifecycleOwner;
                c0610a6.f2172a.m572d(AbstractC1917j6.EnumC1918a.ON_CREATE);
                return;
            }
            return;
        }
        throw new C0970b6(outline.m271J("Fragment ", this, " did not call through to super.onViewStateRestored()"));
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().f3111n = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().f3110m = Boolean.valueOf(z);
    }

    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f3098a = view;
    }

    public void setAnimator(Animator animator) {
        ensureAnimationInfo().f3099b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(AbstractC2289v3 abstractC2289v3) {
        Objects.requireNonNull(ensureAnimationInfo());
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().f3104g = obj;
    }

    public void setExitSharedElementCallback(AbstractC2289v3 abstractC2289v3) {
        Objects.requireNonNull(ensureAnimationInfo());
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().f3106i = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.mo1428o();
        }
    }

    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().f3114q = z;
    }

    public void setInitialSavedState(SavedState savedState) {
        if (this.mFragmentManager == null) {
            this.mSavedFragmentState = (savedState == null || (r2 = savedState.f3094a) == null) ? null : null;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.mo1428o();
            }
        }
    }

    public void setNextAnim(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        ensureAnimationInfo().f3101d = i;
    }

    public void setNextTransition(int i, int i2) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0) {
            return;
        }
        ensureAnimationInfo();
        C0808d c0808d = this.mAnimationInfo;
        c0808d.f3102e = i;
        c0808d.f3103f = i2;
    }

    public void setOnStartEnterTransitionListener(InterfaceC0810f interfaceC0810f) {
        ensureAnimationInfo();
        C0808d c0808d = this.mAnimationInfo;
        InterfaceC0810f interfaceC0810f2 = c0808d.f3113p;
        if (interfaceC0810f == interfaceC0810f2) {
            return;
        }
        if (interfaceC0810f != null && interfaceC0810f2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (c0808d.f3112o) {
            c0808d.f3113p = interfaceC0810f;
        }
        if (interfaceC0810f != null) {
            ((LayoutInflater$Factory2C0236K5.C0246j) interfaceC0810f).f779c++;
        }
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().f3107j = obj;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mFragmentManager;
        if (layoutInflater$Factory2C0236K5 == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            if (layoutInflater$Factory2C0236K5.m2302d0()) {
                return;
            }
            layoutInflater$Factory2C0236K5.f738F.f1120b.add(this);
        } else {
            layoutInflater$Factory2C0236K5.m2278p0(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().f3105h = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().f3108k = obj;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().f3109l = obj;
    }

    public void setStateAfterAnimating(int i) {
        ensureAnimationInfo().f3100c = i;
    }

    public void setTargetFragment(Fragment fragment, int i) {
        AbstractC0216J5 fragmentManager = getFragmentManager();
        AbstractC0216J5 fragmentManager2 = fragment != null ? fragment.getFragmentManager() : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException(outline.m271J("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
            if (fragment2 == this) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager != null && fragment.mFragmentManager != null) {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        } else {
            this.mTargetWho = null;
            this.mTarget = fragment;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 3 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            this.mFragmentManager.m2286l0(this);
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 3 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        if (abstractC0197I5 != null) {
            return abstractC0197I5.mo1431l(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        if (abstractC0197I5 != null) {
            abstractC0197I5.mo1429n(this, intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " not attached to Activity"));
    }

    public void startPostponedEnterTransition() {
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mFragmentManager;
        if (layoutInflater$Factory2C0236K5 != null && layoutInflater$Factory2C0236K5.f753q != null) {
            if (Looper.myLooper() != this.mFragmentManager.f753q.f640c.getLooper()) {
                this.mFragmentManager.f753q.f640c.postAtFrontOfQueue(new RunnableC0806b());
                return;
            } else {
                callStartTransitionListener();
                return;
            }
        }
        ensureAnimationInfo().f3112o = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        LayoutInflater$Factory2C0000A.C0010h.m2643e(this, sb);
        sb.append(" (");
        sb.append(this.mWho);
        sb.append(")");
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" ");
            sb.append(this.mTag);
        }
        sb.append('}');
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = C0172H5.m2409b(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.setArguments(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e) {
            throw new C0809e(outline.m265f("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new C0809e(outline.m265f("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new C0809e(outline.m265f("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new C0809e(outline.m265f("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().f3112o = true;
        LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mFragmentManager;
        if (layoutInflater$Factory2C0236K5 != null) {
            handler = layoutInflater$Factory2C0236K5.f753q.f640c;
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        if (abstractC0197I5 != null) {
            abstractC0197I5.mo1430m(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " not attached to Activity"));
    }

    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        if (abstractC0197I5 != null) {
            abstractC0197I5.mo1430m(this, intent, i, bundle);
            return;
        }
        throw new IllegalStateException(outline.m271J("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        AbstractC0197I5 abstractC0197I5 = this.mHost;
        if (abstractC0197I5 != null) {
            LayoutInflater mo1436g = abstractC0197I5.mo1436g();
            LayoutInflater$Factory2C0236K5 layoutInflater$Factory2C0236K5 = this.mChildFragmentManager;
            Objects.requireNonNull(layoutInflater$Factory2C0236K5);
            mo1436g.setFactory2(layoutInflater$Factory2C0236K5);
            return mo1436g;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public Fragment(int i) {
        this();
        this.mContentLayoutId = i;
    }
}
