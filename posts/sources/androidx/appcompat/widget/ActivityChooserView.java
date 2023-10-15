package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import java.util.Objects;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a */
    public final C0659f f2436a;

    /* renamed from: b */
    public final View$OnClickListenerC0660g f2437b;

    /* renamed from: c */
    public final View f2438c;

    /* renamed from: d */
    public final Drawable f2439d;

    /* renamed from: f */
    public final FrameLayout f2440f;

    /* renamed from: g */
    public final ImageView f2441g;

    /* renamed from: h */
    public final FrameLayout f2442h;

    /* renamed from: i */
    public final ImageView f2443i;

    /* renamed from: j */
    public final int f2444j;

    /* renamed from: k */
    public AbstractC0148G4 f2445k;

    /* renamed from: l */
    public final DataSetObserver f2446l;

    /* renamed from: m */
    public final ViewTreeObserver.OnGlobalLayoutListener f2447m;

    /* renamed from: n */
    public ListPopupWindow f2448n;

    /* renamed from: o */
    public PopupWindow.OnDismissListener f2449o;

    /* renamed from: p */
    public int f2450p;

    /* renamed from: q */
    public boolean f2451q;

    /* renamed from: r */
    public int f2452r;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a */
        public static final int[] f2453a = {16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Drawable drawable;
            int resourceId;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2453a);
            if (obtainStyledAttributes.hasValue(0) && (resourceId = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
                drawable = C0279M.m2210b(context, resourceId);
            } else {
                drawable = obtainStyledAttributes.getDrawable(0);
            }
            setBackgroundDrawable(drawable);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0654a extends DataSetObserver {
        public C0654a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f2436a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f2436a.notifyDataSetInvalidated();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0655b implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserver$OnGlobalLayoutListenerC0655b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.m1643c()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.m1644b().dismiss();
                    return;
                }
                ActivityChooserView.this.m1644b().show();
                AbstractC0148G4 abstractC0148G4 = ActivityChooserView.this.f2445k;
                if (abstractC0148G4 != null) {
                    abstractC0148G4.m2428i(true);
                }
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0656c extends View.AccessibilityDelegate {
        public C0656c(ActivityChooserView activityChooserView) {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setCanOpenPopup(true);
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0657d extends AbstractView$OnTouchListenerC0325O0 {
        public C0657d(View view) {
            super(view);
        }

        @Override // p000.AbstractView$OnTouchListenerC0325O0
        /* renamed from: b */
        public InterfaceC2222s0 mo1640b() {
            return ActivityChooserView.this.m1644b();
        }

        @Override // p000.AbstractView$OnTouchListenerC0325O0
        /* renamed from: c */
        public boolean mo1639c() {
            ActivityChooserView.this.m1642d();
            return true;
        }

        @Override // p000.AbstractView$OnTouchListenerC0325O0
        /* renamed from: d */
        public boolean mo1638d() {
            ActivityChooserView.this.m1645a();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0658e extends DataSetObserver {
        public C0658e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            Objects.requireNonNull(ActivityChooserView.this.f2436a);
            throw null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0659f extends BaseAdapter {

        /* renamed from: a */
        public int f2458a = 4;

        /* renamed from: b */
        public boolean f2459b;

        /* renamed from: c */
        public boolean f2460c;

        public C0659f() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            throw null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (!this.f2460c) {
                if (this.f2459b) {
                    throw null;
                }
                throw null;
            }
            throw null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            if (this.f2460c) {
                throw null;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (!this.f2460c) {
                if (view == null || view.getId() != C1930k.list_item) {
                    view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(C1949l.abc_activity_chooser_view_list_item, viewGroup, false);
                }
                ActivityChooserView.this.getContext().getPackageManager();
                ImageView imageView = (ImageView) view.findViewById(C1930k.icon);
                getItem(i);
                throw null;
            }
            throw null;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActivityChooserView$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnClickListenerC0660g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        public View$OnClickListenerC0660g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f2442h) {
                if (view == activityChooserView.f2440f) {
                    activityChooserView.m1641e(activityChooserView.f2450p);
                    throw null;
                }
                throw new IllegalArgumentException();
            }
            activityChooserView.m1645a();
            Objects.requireNonNull(ActivityChooserView.this.f2436a);
            throw null;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f2449o;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
            AbstractC0148G4 abstractC0148G4 = ActivityChooserView.this.f2445k;
            if (abstractC0148G4 != null) {
                abstractC0148G4.m2428i(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!((C0659f) adapterView.getAdapter()).f2460c) {
                ActivityChooserView.this.m1645a();
                ActivityChooserView activityChooserView = ActivityChooserView.this;
                Objects.requireNonNull(activityChooserView);
                boolean z = activityChooserView.f2436a.f2459b;
                throw null;
            }
            throw null;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f2442h) {
                Objects.requireNonNull(activityChooserView.f2436a);
                throw null;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public boolean m1645a() {
        if (m1643c()) {
            m1644b().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f2447m);
                return true;
            }
            return true;
        }
        return true;
    }

    /* renamed from: b */
    public ListPopupWindow m1644b() {
        if (this.f2448n == null) {
            ListPopupWindow listPopupWindow = new ListPopupWindow(getContext(), null, C1671f.listPopupWindowStyle);
            this.f2448n = listPopupWindow;
            listPopupWindow.mo1614m(this.f2436a);
            ListPopupWindow listPopupWindow2 = this.f2448n;
            listPopupWindow2.f2530q = this;
            listPopupWindow2.m1612p(true);
            ListPopupWindow listPopupWindow3 = this.f2448n;
            View$OnClickListenerC0660g view$OnClickListenerC0660g = this.f2437b;
            listPopupWindow3.f2531r = view$OnClickListenerC0660g;
            listPopupWindow3.f2514A.setOnDismissListener(view$OnClickListenerC0660g);
        }
        return this.f2448n;
    }

    /* renamed from: c */
    public boolean m1643c() {
        return m1644b().mo394a();
    }

    /* renamed from: d */
    public boolean m1642d() {
        if (m1643c() || !this.f2451q) {
            return false;
        }
        m1641e(this.f2450p);
        throw null;
    }

    /* renamed from: e */
    public void m1641e(int i) {
        Objects.requireNonNull(this.f2436a);
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Objects.requireNonNull(this.f2436a);
        this.f2451q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Objects.requireNonNull(this.f2436a);
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f2447m);
        }
        if (m1643c()) {
            m1645a();
        }
        this.f2451q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2438c.layout(0, 0, i3 - i, i4 - i2);
        if (m1643c()) {
            return;
        }
        m1645a();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        View view = this.f2438c;
        if (this.f2442h.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C2361y0 c2361y0) {
        C0659f c0659f = this.f2436a;
        Objects.requireNonNull(ActivityChooserView.this.f2436a);
        if (c2361y0 != null && ActivityChooserView.this.isShown()) {
            DataSetObserver dataSetObserver = ActivityChooserView.this.f2446l;
            throw null;
        }
        c0659f.notifyDataSetChanged();
        if (m1643c()) {
            m1645a();
            m1642d();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f2452r = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f2441g.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f2441g.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f2450p = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f2449o = onDismissListener;
    }

    public void setProvider(AbstractC0148G4 abstractC0148G4) {
        this.f2445k = abstractC0148G4;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2446l = new C0654a();
        this.f2447m = new ViewTreeObserver$OnGlobalLayoutListenerC0655b();
        this.f2450p = 4;
        int[] iArr = C2012o.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        C0492V4.m1951t(this, context, iArr, attributeSet, obtainStyledAttributes, i, 0);
        this.f2450p = obtainStyledAttributes.getInt(C2012o.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(C2012o.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(C1949l.abc_activity_chooser_view, (ViewGroup) this, true);
        View$OnClickListenerC0660g view$OnClickListenerC0660g = new View$OnClickListenerC0660g();
        this.f2437b = view$OnClickListenerC0660g;
        View findViewById = findViewById(C1930k.activity_chooser_view_content);
        this.f2438c = findViewById;
        this.f2439d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(C1930k.default_activity_button);
        this.f2442h = frameLayout;
        frameLayout.setOnClickListener(view$OnClickListenerC0660g);
        frameLayout.setOnLongClickListener(view$OnClickListenerC0660g);
        int i2 = C1930k.image;
        this.f2443i = (ImageView) frameLayout.findViewById(i2);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(C1930k.expand_activities_button);
        frameLayout2.setOnClickListener(view$OnClickListenerC0660g);
        frameLayout2.setAccessibilityDelegate(new C0656c(this));
        frameLayout2.setOnTouchListener(new C0657d(frameLayout2));
        this.f2440f = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i2);
        this.f2441g = imageView;
        imageView.setImageDrawable(drawable);
        C0659f c0659f = new C0659f();
        this.f2436a = c0659f;
        c0659f.registerDataSetObserver(new C0658e());
        Resources resources = context.getResources();
        this.f2444j = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C1881i.abc_config_prefDialogWidth));
    }
}
