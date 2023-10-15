package androidx.databinding;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.library.C0784R;
import androidx.lifecycle.LiveData;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import p000.AbstractC1917j6;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ViewDataBinding extends BaseObservable {
    private static final int BINDING_NUMBER_START = 8;
    public static final String BINDING_TAG_PREFIX = "binding_";
    private static final CreateWeakListener CREATE_LIST_LISTENER;
    private static final CreateWeakListener CREATE_LIVE_DATA_LISTENER;
    private static final CreateWeakListener CREATE_MAP_LISTENER;
    private static final CreateWeakListener CREATE_PROPERTY_LISTENER;
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void> REBIND_NOTIFIER;
    private static final int REBOUND = 3;
    private static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER;
    public static int SDK_INT;
    private static final boolean USE_CHOREOGRAPHER;
    private static final ReferenceQueue<ViewDataBinding> sReferenceQueue;
    public final DataBindingComponent mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private InterfaceC1979m6 mLifecycleOwner;
    private WeakListener[] mLocalFieldObservers;
    private OnStartListener mOnStartListener;
    private boolean mPendingRebind;
    private CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> mRebindCallbacks;
    private boolean mRebindHalted;
    private final Runnable mRebindRunnable;
    private final View mRoot;
    private Handler mUIThreadHandler;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface CreateWeakListener {
        WeakListener create(ViewDataBinding viewDataBinding, int i);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class IncludedLayouts {
        public final int[][] indexes;
        public final int[][] layoutIds;
        public final String[][] layouts;

        public IncludedLayouts(int i) {
            this.layouts = new String[i];
            this.indexes = new int[i];
            this.layoutIds = new int[i];
        }

        public void setIncludes(int i, String[] strArr, int[] iArr, int[] iArr2) {
            this.layouts[i] = strArr;
            this.indexes[i] = iArr;
            this.layoutIds[i] = iArr2;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LiveDataListener implements InterfaceC2233s6, ObservableReference<LiveData<?>> {
        public InterfaceC1979m6 mLifecycleOwner;
        public final WeakListener<LiveData<?>> mListener;

        public LiveDataListener(ViewDataBinding viewDataBinding, int i) {
            this.mListener = new WeakListener<>(viewDataBinding, i, this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public WeakListener<LiveData<?>> getListener() {
            return this.mListener;
        }

        @Override // p000.InterfaceC2233s6
        public void onChanged(Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null) {
                WeakListener<LiveData<?>> weakListener = this.mListener;
                binder.handleFieldChange(weakListener.mLocalFieldId, weakListener.getTarget(), 0);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(InterfaceC1979m6 interfaceC1979m6) {
            LiveData<?> target = this.mListener.getTarget();
            if (target != null) {
                if (this.mLifecycleOwner != null) {
                    target.mo1417g(this);
                }
                if (interfaceC1979m6 != null) {
                    target.m1420d(interfaceC1979m6, this);
                }
            }
            this.mLifecycleOwner = interfaceC1979m6;
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void addListener(LiveData<?> liveData) {
            InterfaceC1979m6 interfaceC1979m6 = this.mLifecycleOwner;
            if (interfaceC1979m6 != null) {
                liveData.m1420d(interfaceC1979m6, this);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void removeListener(LiveData<?> liveData) {
            liveData.mo1417g(this);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface ObservableReference<T> {
        void addListener(T t);

        WeakListener<T> getListener();

        void removeListener(T t);

        void setLifecycleOwner(InterfaceC1979m6 interfaceC1979m6);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class OnStartListener implements InterfaceC1958l6 {
        public final WeakReference<ViewDataBinding> mBinding;

        @InterfaceC2254t6(AbstractC1917j6.EnumC1918a.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = this.mBinding.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }

        private OnStartListener(ViewDataBinding viewDataBinding) {
            this.mBinding = new WeakReference<>(viewDataBinding);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class PropertyChangedInverseListener extends Observable.OnPropertyChangedCallback implements InverseBindingListener {
        public final int mPropertyId;

        public PropertyChangedInverseListener(int i) {
            this.mPropertyId = i;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            if (i == this.mPropertyId || i == 0) {
                onChange();
            }
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class WeakListListener extends ObservableList.OnListChangedCallback implements ObservableReference<ObservableList> {
        public final WeakListener<ObservableList> mListener;

        public WeakListListener(ViewDataBinding viewDataBinding, int i) {
            this.mListener = new WeakListener<>(viewDataBinding, i, this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public WeakListener<ObservableList> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onChanged(ObservableList observableList) {
            ObservableList target;
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && (target = this.mListener.getTarget()) == observableList) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, target, 0);
            }
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeChanged(ObservableList observableList, int i, int i2) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeInserted(ObservableList observableList, int i, int i2) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeMoved(ObservableList observableList, int i, int i2, int i3) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public void onItemRangeRemoved(ObservableList observableList, int i, int i2) {
            onChanged(observableList);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(InterfaceC1979m6 interfaceC1979m6) {
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void addListener(ObservableList observableList) {
            observableList.addOnListChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void removeListener(ObservableList observableList) {
            observableList.removeOnListChangedCallback(this);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class WeakListener<T> extends WeakReference<ViewDataBinding> {
        public final int mLocalFieldId;
        private final ObservableReference<T> mObservable;
        private T mTarget;

        public WeakListener(ViewDataBinding viewDataBinding, int i, ObservableReference<T> observableReference) {
            super(viewDataBinding, ViewDataBinding.sReferenceQueue);
            this.mLocalFieldId = i;
            this.mObservable = observableReference;
        }

        public ViewDataBinding getBinder() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) get();
            if (viewDataBinding == null) {
                unregister();
            }
            return viewDataBinding;
        }

        public T getTarget() {
            return this.mTarget;
        }

        public void setLifecycleOwner(InterfaceC1979m6 interfaceC1979m6) {
            this.mObservable.setLifecycleOwner(interfaceC1979m6);
        }

        public void setTarget(T t) {
            unregister();
            this.mTarget = t;
            if (t != null) {
                this.mObservable.addListener(t);
            }
        }

        public boolean unregister() {
            boolean z;
            T t = this.mTarget;
            if (t != null) {
                this.mObservable.removeListener(t);
                z = true;
            } else {
                z = false;
            }
            this.mTarget = null;
            return z;
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class WeakMapListener extends ObservableMap.OnMapChangedCallback implements ObservableReference<ObservableMap> {
        public final WeakListener<ObservableMap> mListener;

        public WeakMapListener(ViewDataBinding viewDataBinding, int i) {
            this.mListener = new WeakListener<>(viewDataBinding, i, this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public WeakListener<ObservableMap> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.ObservableMap.OnMapChangedCallback
        public void onMapChanged(ObservableMap observableMap, Object obj) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder == null || observableMap != this.mListener.getTarget()) {
                return;
            }
            binder.handleFieldChange(this.mListener.mLocalFieldId, observableMap, 0);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(InterfaceC1979m6 interfaceC1979m6) {
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void addListener(ObservableMap observableMap) {
            observableMap.addOnMapChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void removeListener(ObservableMap observableMap) {
            observableMap.removeOnMapChangedCallback(this);
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class WeakPropertyListener extends Observable.OnPropertyChangedCallback implements ObservableReference<Observable> {
        public final WeakListener<Observable> mListener;

        public WeakPropertyListener(ViewDataBinding viewDataBinding, int i) {
            this.mListener = new WeakListener<>(viewDataBinding, i, this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public WeakListener<Observable> getListener() {
            return this.mListener;
        }

        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public void onPropertyChanged(Observable observable, int i) {
            ViewDataBinding binder = this.mListener.getBinder();
            if (binder != null && this.mListener.getTarget() == observable) {
                binder.handleFieldChange(this.mListener.mLocalFieldId, observable, i);
            }
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void setLifecycleOwner(InterfaceC1979m6 interfaceC1979m6) {
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void addListener(Observable observable) {
            observable.addOnPropertyChangedCallback(this);
        }

        @Override // androidx.databinding.ViewDataBinding.ObservableReference
        public void removeListener(Observable observable) {
            observable.removeOnPropertyChangedCallback(this);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        SDK_INT = i;
        USE_CHOREOGRAPHER = i >= 16;
        CREATE_PROPERTY_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.1
            @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
            public WeakListener create(ViewDataBinding viewDataBinding, int i2) {
                return new WeakPropertyListener(viewDataBinding, i2).getListener();
            }
        };
        CREATE_LIST_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.2
            @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
            public WeakListener create(ViewDataBinding viewDataBinding, int i2) {
                return new WeakListListener(viewDataBinding, i2).getListener();
            }
        };
        CREATE_MAP_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.3
            @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
            public WeakListener create(ViewDataBinding viewDataBinding, int i2) {
                return new WeakMapListener(viewDataBinding, i2).getListener();
            }
        };
        CREATE_LIVE_DATA_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.ViewDataBinding.4
            @Override // androidx.databinding.ViewDataBinding.CreateWeakListener
            public WeakListener create(ViewDataBinding viewDataBinding, int i2) {
                return new LiveDataListener(viewDataBinding, i2).getListener();
            }
        };
        REBIND_NOTIFIER = new CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void>() { // from class: androidx.databinding.ViewDataBinding.5
            @Override // androidx.databinding.CallbackRegistry.NotifierCallback
            public void onNotifyCallback(OnRebindCallback onRebindCallback, ViewDataBinding viewDataBinding, int i2, Void r4) {
                if (i2 == 1) {
                    if (onRebindCallback.onPreBind(viewDataBinding)) {
                        return;
                    }
                    viewDataBinding.mRebindHalted = true;
                } else if (i2 == 2) {
                    onRebindCallback.onCanceled(viewDataBinding);
                } else if (i2 != 3) {
                } else {
                    onRebindCallback.onBound(viewDataBinding);
                }
            }
        };
        sReferenceQueue = new ReferenceQueue<>();
        ROOT_REATTACHED_LISTENER = new View.OnAttachStateChangeListener() { // from class: androidx.databinding.ViewDataBinding.6
            @Override // android.view.View.OnAttachStateChangeListener
            @TargetApi(19)
            public void onViewAttachedToWindow(View view) {
                ViewDataBinding.getBinding(view).mRebindRunnable.run();
                view.removeOnAttachStateChangeListener(this);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        };
    }

    public ViewDataBinding(DataBindingComponent dataBindingComponent, View view, int i) {
        this.mRebindRunnable = new Runnable() { // from class: androidx.databinding.ViewDataBinding.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    ViewDataBinding.this.mPendingRebind = false;
                }
                ViewDataBinding.processReferenceQueue();
                if (!ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                    ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                    ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                    return;
                }
                ViewDataBinding.this.executePendingBindings();
            }
        };
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mBindingComponent = dataBindingComponent;
        this.mLocalFieldObservers = new WeakListener[i];
        this.mRoot = view;
        if (Looper.myLooper() != null) {
            if (USE_CHOREOGRAPHER) {
                this.mChoreographer = Choreographer.getInstance();
                this.mFrameCallback = new Choreographer.FrameCallback() { // from class: androidx.databinding.ViewDataBinding.8
                    @Override // android.view.Choreographer.FrameCallback
                    public void doFrame(long j) {
                        ViewDataBinding.this.mRebindRunnable.run();
                    }
                };
                return;
            }
            this.mFrameCallback = null;
            this.mUIThreadHandler = new Handler(Looper.myLooper());
            return;
        }
        throw new IllegalStateException("DataBinding must be created in view's UI Thread");
    }

    public static ViewDataBinding bind(Object obj, View view, int i) {
        return DataBindingUtil.bind(checkAndCastToBindingComponent(obj), view, i);
    }

    private static DataBindingComponent checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof DataBindingComponent) {
            return (DataBindingComponent) obj;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
        } else if (hasPendingBindings()) {
            this.mIsExecutingPendingBindings = true;
            this.mRebindHalted = false;
            CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
            if (callbackRegistry != null) {
                callbackRegistry.notifyCallbacks(this, 1, null);
                if (this.mRebindHalted) {
                    this.mRebindCallbacks.notifyCallbacks(this, 2, null);
                }
            }
            if (!this.mRebindHalted) {
                executeBindings();
                CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry2 = this.mRebindCallbacks;
                if (callbackRegistry2 != null) {
                    callbackRegistry2.notifyCallbacks(this, 3, null);
                }
            }
            this.mIsExecutingPendingBindings = false;
        }
    }

    public static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    private static int findIncludeIndex(String str, int i, IncludedLayouts includedLayouts, int i2) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = includedLayouts.layouts[i2];
        int length = strArr.length;
        while (i < length) {
            if (TextUtils.equals(subSequence, strArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private static int findLastMatching(ViewGroup viewGroup, int i) {
        String str = (String) viewGroup.getChildAt(i).getTag();
        String substring = str.substring(0, str.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i2 = i + 1; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            String str2 = childAt.getTag() instanceof String ? (String) childAt.getTag() : null;
            if (str2 != null && str2.startsWith(substring)) {
                if (str2.length() == str.length() && str2.charAt(str2.length() - 1) == '0') {
                    return i;
                }
                if (isNumeric(str2, length)) {
                    i = i2;
                }
            }
        }
        return i;
    }

    public static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(C0784R.C0787id.dataBinding);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    public static int getColorFromResource(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColor(i);
        }
        return view.getResources().getColor(i);
    }

    public static ColorStateList getColorStateListFromResource(View view, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return view.getContext().getColorStateList(i);
        }
        return view.getResources().getColorStateList(i);
    }

    public static Drawable getDrawableFromResource(View view, int i) {
        return view.getContext().getDrawable(i);
    }

    public static <K, T> T getFrom(Map<K, T> map, K k) {
        if (map == null) {
            return null;
        }
        return map.get(k);
    }

    public static <T> T getFromArray(T[] tArr, int i) {
        if (tArr == null || i < 0 || i >= tArr.length) {
            return null;
        }
        return tArr[i];
    }

    public static <T> T getFromList(List<T> list, int i) {
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFieldChange(int i, Object obj, int i2) {
        if (!this.mInLiveDataRegisterObserver && onFieldChange(i, obj, i2)) {
            requestRebind();
        }
    }

    public static <T extends ViewDataBinding> T inflateInternal(LayoutInflater layoutInflater, int i, ViewGroup viewGroup, boolean z, Object obj) {
        return (T) DataBindingUtil.inflate(layoutInflater, i, viewGroup, z, checkAndCastToBindingComponent(obj));
    }

    private static boolean isNumeric(String str, int i) {
        int length = str.length();
        if (length == i) {
            return false;
        }
        while (i < length) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View view, int i, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i];
        mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        return objArr;
    }

    public static boolean parse(String str, boolean z) {
        return str == null ? z : Boolean.parseBoolean(str);
    }

    private static int parseTagInt(String str, int i) {
        int length = str.length();
        int i2 = 0;
        while (i < length) {
            i2 = (i2 * 10) + (str.charAt(i) - '0');
            i++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = sReferenceQueue.poll();
            if (poll == null) {
                return;
            }
            if (poll instanceof WeakListener) {
                ((WeakListener) poll).unregister();
            }
        }
    }

    public static int safeUnbox(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static void setBindingInverseListener(ViewDataBinding viewDataBinding, InverseBindingListener inverseBindingListener, PropertyChangedInverseListener propertyChangedInverseListener) {
        if (inverseBindingListener != propertyChangedInverseListener) {
            if (inverseBindingListener != null) {
                viewDataBinding.removeOnPropertyChangedCallback((PropertyChangedInverseListener) inverseBindingListener);
            }
            if (propertyChangedInverseListener != null) {
                viewDataBinding.addOnPropertyChangedCallback(propertyChangedInverseListener);
            }
        }
    }

    public static <T> void setTo(T[] tArr, int i, T t) {
        if (tArr == null || i < 0 || i >= tArr.length) {
            return;
        }
        tArr[i] = t;
    }

    private boolean updateRegistration(int i, Object obj, CreateWeakListener createWeakListener) {
        if (obj == null) {
            return unregisterFrom(i);
        }
        WeakListener weakListener = this.mLocalFieldObservers[i];
        if (weakListener == null) {
            registerTo(i, obj, createWeakListener);
            return true;
        } else if (weakListener.getTarget() == obj) {
            return false;
        } else {
            unregisterFrom(i);
            registerTo(i, obj, createWeakListener);
            return true;
        }
    }

    public void addOnRebindCallback(OnRebindCallback onRebindCallback) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new CallbackRegistry<>(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.add(onRebindCallback);
    }

    public void ensureBindingComponentIsNotNull(Class<?> cls) {
        if (this.mBindingComponent != null) {
            return;
        }
        StringBuilder m253r = outline.m253r("Required DataBindingComponent is null in class ");
        m253r.append(getClass().getSimpleName());
        m253r.append(". A BindingAdapter in ");
        m253r.append(cls.getCanonicalName());
        m253r.append(" is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
        throw new IllegalStateException(m253r.toString());
    }

    public abstract void executeBindings();

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    public void forceExecuteBindings() {
        executeBindings();
    }

    public InterfaceC1979m6 getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    public Object getObservedField(int i) {
        WeakListener weakListener = this.mLocalFieldObservers[i];
        if (weakListener == null) {
            return null;
        }
        return weakListener.getTarget();
    }

    public View getRoot() {
        return this.mRoot;
    }

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    public abstract boolean onFieldChange(int i, Object obj, int i2);

    public void registerTo(int i, Object obj, CreateWeakListener createWeakListener) {
        if (obj == null) {
            return;
        }
        WeakListener weakListener = this.mLocalFieldObservers[i];
        if (weakListener == null) {
            weakListener = createWeakListener.create(this, i);
            this.mLocalFieldObservers[i] = weakListener;
            InterfaceC1979m6 interfaceC1979m6 = this.mLifecycleOwner;
            if (interfaceC1979m6 != null) {
                weakListener.setLifecycleOwner(interfaceC1979m6);
            }
        }
        weakListener.setTarget(obj);
    }

    public void removeOnRebindCallback(OnRebindCallback onRebindCallback) {
        CallbackRegistry<OnRebindCallback, ViewDataBinding, Void> callbackRegistry = this.mRebindCallbacks;
        if (callbackRegistry != null) {
            callbackRegistry.remove(onRebindCallback);
        }
    }

    public void requestRebind() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding != null) {
            viewDataBinding.requestRebind();
            return;
        }
        InterfaceC1979m6 interfaceC1979m6 = this.mLifecycleOwner;
        if (interfaceC1979m6 != null) {
            if (!(((C2002n6) interfaceC1979m6.getLifecycle()).f5539b.compareTo(AbstractC1917j6.EnumC1919b.STARTED) >= 0)) {
                return;
            }
        }
        synchronized (this) {
            if (this.mPendingRebind) {
                return;
            }
            this.mPendingRebind = true;
            if (USE_CHOREOGRAPHER) {
                this.mChoreographer.postFrameCallback(this.mFrameCallback);
            } else {
                this.mUIThreadHandler.post(this.mRebindRunnable);
            }
        }
    }

    public void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    public void setLifecycleOwner(InterfaceC1979m6 interfaceC1979m6) {
        WeakListener[] weakListenerArr;
        InterfaceC1979m6 interfaceC1979m62 = this.mLifecycleOwner;
        if (interfaceC1979m62 == interfaceC1979m6) {
            return;
        }
        if (interfaceC1979m62 != null) {
            ((C2002n6) interfaceC1979m62.getLifecycle()).f5538a.mo583e(this.mOnStartListener);
        }
        this.mLifecycleOwner = interfaceC1979m6;
        if (interfaceC1979m6 != null) {
            if (this.mOnStartListener == null) {
                this.mOnStartListener = new OnStartListener();
            }
            interfaceC1979m6.getLifecycle().mo575a(this.mOnStartListener);
        }
        for (WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.setLifecycleOwner(interfaceC1979m6);
            }
        }
    }

    public void setRootTag(View view) {
        view.setTag(C0784R.C0787id.dataBinding, this);
    }

    public abstract boolean setVariable(int i, Object obj);

    public void unbind() {
        WeakListener[] weakListenerArr;
        for (WeakListener weakListener : this.mLocalFieldObservers) {
            if (weakListener != null) {
                weakListener.unregister();
            }
        }
    }

    public boolean unregisterFrom(int i) {
        WeakListener weakListener = this.mLocalFieldObservers[i];
        if (weakListener != null) {
            return weakListener.unregister();
        }
        return false;
    }

    public boolean updateLiveDataRegistration(int i, LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    public static byte parse(String str, byte b) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static long safeUnbox(Long l) {
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public void setRootTag(View[] viewArr) {
        for (View view : viewArr) {
            view.setTag(C0784R.C0787id.dataBinding, this);
        }
    }

    public static boolean getFromArray(boolean[] zArr, int i) {
        if (zArr == null || i < 0 || i >= zArr.length) {
            return false;
        }
        return zArr[i];
    }

    public static <T> T getFromList(SparseArray<T> sparseArray, int i) {
        if (sparseArray == null || i < 0) {
            return null;
        }
        return sparseArray.get(i);
    }

    public static Object[] mapBindings(DataBindingComponent dataBindingComponent, View[] viewArr, int i, IncludedLayouts includedLayouts, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i];
        for (View view : viewArr) {
            mapBindings(dataBindingComponent, view, objArr, includedLayouts, sparseIntArray, true);
        }
        return objArr;
    }

    public static short parse(String str, short s) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    public static short safeUnbox(Short sh) {
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    public static void setTo(boolean[] zArr, int i, boolean z) {
        if (zArr == null || i < 0 || i >= zArr.length) {
            return;
        }
        zArr[i] = z;
    }

    @TargetApi(16)
    public static <T> T getFromList(LongSparseArray<T> longSparseArray, int i) {
        if (longSparseArray == null || i < 0) {
            return null;
        }
        return longSparseArray.get(i);
    }

    public static int parse(String str, int i) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static byte safeUnbox(Byte b) {
        if (b == null) {
            return (byte) 0;
        }
        return b.byteValue();
    }

    public static byte getFromArray(byte[] bArr, int i) {
        if (bArr == null || i < 0 || i >= bArr.length) {
            return (byte) 0;
        }
        return bArr[i];
    }

    public static <T> T getFromList(C0034B1<T> c0034b1, int i) {
        if (c0034b1 == null || i < 0) {
            return null;
        }
        return c0034b1.m2566e(i);
    }

    public static long parse(String str, long j) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static char safeUnbox(Character ch) {
        if (ch == null) {
            return (char) 0;
        }
        return ch.charValue();
    }

    public static void setTo(byte[] bArr, int i, byte b) {
        if (bArr == null || i < 0 || i >= bArr.length) {
            return;
        }
        bArr[i] = b;
    }

    public static boolean getFromList(SparseBooleanArray sparseBooleanArray, int i) {
        if (sparseBooleanArray == null || i < 0) {
            return false;
        }
        return sparseBooleanArray.get(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x010b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void mapBindings(androidx.databinding.DataBindingComponent r16, android.view.View r17, java.lang.Object[] r18, androidx.databinding.ViewDataBinding.IncludedLayouts r19, android.util.SparseIntArray r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.mapBindings(androidx.databinding.DataBindingComponent, android.view.View, java.lang.Object[], androidx.databinding.ViewDataBinding$IncludedLayouts, android.util.SparseIntArray, boolean):void");
    }

    public static float parse(String str, float f) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static double safeUnbox(Double d) {
        return d == null ? ShadowDrawableWrapper.COS_45 : d.doubleValue();
    }

    public static short getFromArray(short[] sArr, int i) {
        if (sArr == null || i < 0 || i >= sArr.length) {
            return (short) 0;
        }
        return sArr[i];
    }

    public static int getFromList(SparseIntArray sparseIntArray, int i) {
        if (sparseIntArray == null || i < 0) {
            return 0;
        }
        return sparseIntArray.get(i);
    }

    public static double parse(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static float safeUnbox(Float f) {
        if (f == null) {
            return 0.0f;
        }
        return f.floatValue();
    }

    public static void setTo(short[] sArr, int i, short s) {
        if (sArr == null || i < 0 || i >= sArr.length) {
            return;
        }
        sArr[i] = s;
    }

    public boolean updateRegistration(int i, Observable observable) {
        return updateRegistration(i, observable, CREATE_PROPERTY_LISTENER);
    }

    @TargetApi(18)
    public static long getFromList(SparseLongArray sparseLongArray, int i) {
        if (sparseLongArray == null || i < 0) {
            return 0L;
        }
        return sparseLongArray.get(i);
    }

    public static char parse(String str, char c) {
        return (str == null || str.isEmpty()) ? c : str.charAt(0);
    }

    public static boolean safeUnbox(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public boolean updateRegistration(int i, ObservableList observableList) {
        return updateRegistration(i, observableList, CREATE_LIST_LISTENER);
    }

    public static char getFromArray(char[] cArr, int i) {
        if (cArr == null || i < 0 || i >= cArr.length) {
            return (char) 0;
        }
        return cArr[i];
    }

    public static void setTo(char[] cArr, int i, char c) {
        if (cArr == null || i < 0 || i >= cArr.length) {
            return;
        }
        cArr[i] = c;
    }

    public boolean updateRegistration(int i, ObservableMap observableMap) {
        return updateRegistration(i, observableMap, CREATE_MAP_LISTENER);
    }

    public static int getFromArray(int[] iArr, int i) {
        if (iArr == null || i < 0 || i >= iArr.length) {
            return 0;
        }
        return iArr[i];
    }

    public static void setTo(int[] iArr, int i, int i2) {
        if (iArr == null || i < 0 || i >= iArr.length) {
            return;
        }
        iArr[i] = i2;
    }

    public static long getFromArray(long[] jArr, int i) {
        if (jArr == null || i < 0 || i >= jArr.length) {
            return 0L;
        }
        return jArr[i];
    }

    public static void setTo(long[] jArr, int i, long j) {
        if (jArr == null || i < 0 || i >= jArr.length) {
            return;
        }
        jArr[i] = j;
    }

    public ViewDataBinding(Object obj, View view, int i) {
        this(checkAndCastToBindingComponent(obj), view, i);
    }

    public static float getFromArray(float[] fArr, int i) {
        if (fArr == null || i < 0 || i >= fArr.length) {
            return 0.0f;
        }
        return fArr[i];
    }

    public static void setTo(float[] fArr, int i, float f) {
        if (fArr == null || i < 0 || i >= fArr.length) {
            return;
        }
        fArr[i] = f;
    }

    public static double getFromArray(double[] dArr, int i) {
        return (dArr == null || i < 0 || i >= dArr.length) ? ShadowDrawableWrapper.COS_45 : dArr[i];
    }

    public static void setTo(double[] dArr, int i, double d) {
        if (dArr == null || i < 0 || i >= dArr.length) {
            return;
        }
        dArr[i] = d;
    }

    public static <T> void setTo(List<T> list, int i, T t) {
        if (list == null || i < 0 || i >= list.size()) {
            return;
        }
        list.set(i, t);
    }

    public static <T> void setTo(SparseArray<T> sparseArray, int i, T t) {
        if (sparseArray == null || i < 0 || i >= sparseArray.size()) {
            return;
        }
        sparseArray.put(i, t);
    }

    @TargetApi(16)
    public static <T> void setTo(LongSparseArray<T> longSparseArray, int i, T t) {
        if (longSparseArray == null || i < 0 || i >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i, t);
    }

    public static <T> void setTo(C0034B1<T> c0034b1, int i, T t) {
        if (c0034b1 == null || i < 0 || i >= c0034b1.m2563h()) {
            return;
        }
        c0034b1.m2564g(i, t);
    }

    public static void setTo(SparseBooleanArray sparseBooleanArray, int i, boolean z) {
        if (sparseBooleanArray == null || i < 0 || i >= sparseBooleanArray.size()) {
            return;
        }
        sparseBooleanArray.put(i, z);
    }

    public static void setTo(SparseIntArray sparseIntArray, int i, int i2) {
        if (sparseIntArray == null || i < 0 || i >= sparseIntArray.size()) {
            return;
        }
        sparseIntArray.put(i, i2);
    }

    @TargetApi(18)
    public static void setTo(SparseLongArray sparseLongArray, int i, long j) {
        if (sparseLongArray == null || i < 0 || i >= sparseLongArray.size()) {
            return;
        }
        sparseLongArray.put(i, j);
    }

    public static <K, T> void setTo(Map<K, T> map, K k, T t) {
        if (map == null) {
            return;
        }
        map.put(k, t);
    }
}
