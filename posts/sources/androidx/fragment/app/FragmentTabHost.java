package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import java.util.ArrayList;
import java.util.Objects;

@Deprecated
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* renamed from: a */
    public final ArrayList<C0815a> f3145a;

    /* renamed from: b */
    public FrameLayout f3146b;

    /* renamed from: c */
    public Context f3147c;

    /* renamed from: d */
    public AbstractC0216J5 f3148d;

    /* renamed from: f */
    public int f3149f;

    /* renamed from: g */
    public TabHost.OnTabChangeListener f3150g;

    /* renamed from: h */
    public boolean f3151h;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0814a();

        /* renamed from: a */
        public String f3152a;

        /* renamed from: androidx.fragment.app.FragmentTabHost$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0814a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("FragmentTabHost.SavedState{");
            m253r.append(Integer.toHexString(System.identityHashCode(this)));
            m253r.append(" curTab=");
            return outline.m262i(m253r, this.f3152a, "}");
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f3152a);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f3152a = parcel.readString();
        }
    }

    /* renamed from: androidx.fragment.app.FragmentTabHost$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0815a {

        /* renamed from: a */
        public Fragment f3153a;
    }

    @Deprecated
    public FragmentTabHost(Context context) {
        super(context, null);
        this.f3145a = new ArrayList<>();
        m1424d(context, null);
    }

    /* renamed from: a */
    public final AbstractC0352P5 m1427a(String str, AbstractC0352P5 abstractC0352P5) {
        if (this.f3145a.size() <= 0) {
            return null;
        }
        Objects.requireNonNull(this.f3145a.get(0));
        throw null;
    }

    /* renamed from: b */
    public final void m1426b() {
        if (this.f3146b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f3149f);
            this.f3146b = frameLayout;
            if (frameLayout != null) {
                return;
            }
            StringBuilder m253r = outline.m253r("No tab content FrameLayout found for id ");
            m253r.append(this.f3149f);
            throw new IllegalStateException(m253r.toString());
        }
    }

    /* renamed from: c */
    public final void m1425c(Context context) {
        if (findViewById(16908307) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(16908307);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(16908305);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f3146b = frameLayout2;
            frameLayout2.setId(this.f3149f);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    /* renamed from: d */
    public final void m1424d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.f3149f = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f3145a.size();
        for (int i = 0; i < size; i++) {
            C0815a c0815a = this.f3145a.get(i);
            AbstractC0216J5 abstractC0216J5 = this.f3148d;
            Objects.requireNonNull(c0815a);
            Fragment mo2303d = abstractC0216J5.mo2303d(null);
            c0815a.f3153a = mo2303d;
            if (mo2303d != null && !mo2303d.isDetached()) {
                throw null;
            }
        }
        this.f3151h = true;
        AbstractC0352P5 m1427a = m1427a(currentTabTag, null);
        if (m1427a != null) {
            m1427a.mo2153c();
            this.f3148d.mo2307b();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f3151h = false;
    }

    @Override // android.view.View
    @Deprecated
    public void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f3152a);
    }

    @Override // android.view.View
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3152a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(String str) {
        AbstractC0352P5 m1427a;
        if (this.f3151h && (m1427a = m1427a(str, null)) != null) {
            m1427a.mo2153c();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f3150g;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.f3150g = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(Context context, AbstractC0216J5 abstractC0216J5) {
        m1425c(context);
        super.setup();
        this.f3147c = context;
        this.f3148d = abstractC0216J5;
        m1426b();
    }

    @Deprecated
    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3145a = new ArrayList<>();
        m1424d(context, attributeSet);
    }

    @Deprecated
    public void setup(Context context, AbstractC0216J5 abstractC0216J5, int i) {
        m1425c(context);
        super.setup();
        this.f3147c = context;
        this.f3148d = abstractC0216J5;
        this.f3149f = i;
        m1426b();
        this.f3146b.setId(i);
        if (getId() == -1) {
            setId(16908306);
        }
    }
}
