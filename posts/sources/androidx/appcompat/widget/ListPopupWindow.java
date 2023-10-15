package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ListPopupWindow implements InterfaceC2222s0 {

    /* renamed from: B */
    public static Method f2511B;

    /* renamed from: C */
    public static Method f2512C;

    /* renamed from: D */
    public static Method f2513D;

    /* renamed from: A */
    public PopupWindow f2514A;

    /* renamed from: a */
    public Context f2515a;

    /* renamed from: b */
    public ListAdapter f2516b;

    /* renamed from: c */
    public C0281M0 f2517c;

    /* renamed from: d */
    public int f2518d;

    /* renamed from: f */
    public int f2519f;

    /* renamed from: g */
    public int f2520g;

    /* renamed from: h */
    public int f2521h;

    /* renamed from: i */
    public int f2522i;

    /* renamed from: j */
    public boolean f2523j;

    /* renamed from: k */
    public boolean f2524k;

    /* renamed from: l */
    public boolean f2525l;

    /* renamed from: m */
    public int f2526m;

    /* renamed from: n */
    public int f2527n;

    /* renamed from: o */
    public int f2528o;

    /* renamed from: p */
    public DataSetObserver f2529p;

    /* renamed from: q */
    public View f2530q;

    /* renamed from: r */
    public AdapterView.OnItemClickListener f2531r;

    /* renamed from: s */
    public final RunnableC0675e f2532s;

    /* renamed from: t */
    public final View$OnTouchListenerC0674d f2533t;

    /* renamed from: u */
    public final C0673c f2534u;

    /* renamed from: v */
    public final RunnableC0671a f2535v;

    /* renamed from: w */
    public final Handler f2536w;

    /* renamed from: x */
    public final Rect f2537x;

    /* renamed from: y */
    public Rect f2538y;

    /* renamed from: z */
    public boolean f2539z;

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0671a implements Runnable {
        public RunnableC0671a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0281M0 c0281m0 = ListPopupWindow.this.f2517c;
            if (c0281m0 != null) {
                c0281m0.f936j = true;
                c0281m0.requestLayout();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0672b extends DataSetObserver {
        public C0672b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.mo394a()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0673c implements AbsListView.OnScrollListener {
        public C0673c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1) {
                if ((ListPopupWindow.this.f2514A.getInputMethodMode() == 2) || ListPopupWindow.this.f2514A.getContentView() == null) {
                    return;
                }
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f2536w.removeCallbacks(listPopupWindow.f2532s);
                ListPopupWindow.this.f2532s.run();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnTouchListenerC0674d implements View.OnTouchListener {
        public View$OnTouchListenerC0674d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.f2514A) != null && popupWindow.isShowing() && x >= 0 && x < ListPopupWindow.this.f2514A.getWidth() && y >= 0 && y < ListPopupWindow.this.f2514A.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.f2536w.postDelayed(listPopupWindow.f2532s, 250L);
                return false;
            } else if (action == 1) {
                ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
                listPopupWindow2.f2536w.removeCallbacks(listPopupWindow2.f2532s);
                return false;
            } else {
                return false;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ListPopupWindow$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0675e implements Runnable {
        public RunnableC0675e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0281M0 c0281m0 = ListPopupWindow.this.f2517c;
            if (c0281m0 != null) {
                AtomicInteger atomicInteger = C0492V4.f1798a;
                if (!C0492V4.C0498f.m1909b(c0281m0) || ListPopupWindow.this.f2517c.getCount() <= ListPopupWindow.this.f2517c.getChildCount()) {
                    return;
                }
                int childCount = ListPopupWindow.this.f2517c.getChildCount();
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                if (childCount <= listPopupWindow.f2527n) {
                    listPopupWindow.f2514A.setInputMethodMode(2);
                    ListPopupWindow.this.show();
                }
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                f2511B = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f2513D = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                f2512C = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1671f.listPopupWindowStyle);
    }

    @Override // p000.InterfaceC2222s0
    /* renamed from: a */
    public boolean mo394a() {
        return this.f2514A.isShowing();
    }

    /* renamed from: b */
    public int m1619b() {
        return this.f2520g;
    }

    @Override // p000.InterfaceC2222s0
    public void dismiss() {
        this.f2514A.dismiss();
        this.f2514A.setContentView(null);
        this.f2517c = null;
        this.f2536w.removeCallbacks(this.f2532s);
    }

    /* renamed from: e */
    public Drawable m1618e() {
        return this.f2514A.getBackground();
    }

    /* renamed from: g */
    public void m1617g(int i) {
        this.f2521h = i;
        this.f2523j = true;
    }

    @Override // p000.InterfaceC2222s0
    public ListView getListView() {
        return this.f2517c;
    }

    /* renamed from: i */
    public void m1616i(int i) {
        this.f2520g = i;
    }

    /* renamed from: k */
    public int m1615k() {
        if (this.f2523j) {
            return this.f2521h;
        }
        return 0;
    }

    /* renamed from: m */
    public void mo1614m(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f2529p;
        if (dataSetObserver == null) {
            this.f2529p = new C0672b();
        } else {
            ListAdapter listAdapter2 = this.f2516b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2516b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2529p);
        }
        C0281M0 c0281m0 = this.f2517c;
        if (c0281m0 != null) {
            c0281m0.setAdapter(this.f2516b);
        }
    }

    /* renamed from: n */
    public C0281M0 mo1611n(Context context, boolean z) {
        return new C0281M0(context, z);
    }

    /* renamed from: o */
    public void m1613o(int i) {
        Drawable background = this.f2514A.getBackground();
        if (background != null) {
            background.getPadding(this.f2537x);
            Rect rect = this.f2537x;
            this.f2519f = rect.left + rect.right + i;
            return;
        }
        this.f2519f = i;
    }

    /* renamed from: p */
    public void m1612p(boolean z) {
        this.f2539z = z;
        this.f2514A.setFocusable(z);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.f2514A.setBackgroundDrawable(drawable);
    }

    @Override // p000.InterfaceC2222s0
    public void show() {
        int i;
        int maxAvailableHeight;
        int makeMeasureSpec;
        int paddingBottom;
        C0281M0 c0281m0;
        if (this.f2517c == null) {
            C0281M0 mo1611n = mo1611n(this.f2515a, !this.f2539z);
            this.f2517c = mo1611n;
            mo1611n.setAdapter(this.f2516b);
            this.f2517c.setOnItemClickListener(this.f2531r);
            this.f2517c.setFocusable(true);
            this.f2517c.setFocusableInTouchMode(true);
            this.f2517c.setOnItemSelectedListener(new C0345P0(this));
            this.f2517c.setOnScrollListener(this.f2534u);
            this.f2514A.setContentView(this.f2517c);
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f2514A.getContentView();
        }
        Drawable background = this.f2514A.getBackground();
        if (background != null) {
            background.getPadding(this.f2537x);
            Rect rect = this.f2537x;
            int i2 = rect.top;
            i = rect.bottom + i2;
            if (!this.f2523j) {
                this.f2521h = -i2;
            }
        } else {
            this.f2537x.setEmpty();
            i = 0;
        }
        boolean z = this.f2514A.getInputMethodMode() == 2;
        View view = this.f2530q;
        int i3 = this.f2521h;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = f2512C;
            if (method != null) {
                try {
                    maxAvailableHeight = ((Integer) method.invoke(this.f2514A, view, Integer.valueOf(i3), Boolean.valueOf(z))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                }
            }
            maxAvailableHeight = this.f2514A.getMaxAvailableHeight(view, i3);
        } else {
            maxAvailableHeight = this.f2514A.getMaxAvailableHeight(view, i3, z);
        }
        if (this.f2518d == -1) {
            paddingBottom = maxAvailableHeight + i;
        } else {
            int i4 = this.f2519f;
            if (i4 == -2) {
                int i5 = this.f2515a.getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = this.f2537x;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5 - (rect2.left + rect2.right), Integer.MIN_VALUE);
            } else if (i4 != -1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else {
                int i6 = this.f2515a.getResources().getDisplayMetrics().widthPixels;
                Rect rect3 = this.f2537x;
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i6 - (rect3.left + rect3.right), 1073741824);
            }
            int m2209a = this.f2517c.m2209a(makeMeasureSpec, maxAvailableHeight - 0, -1);
            paddingBottom = m2209a + (m2209a > 0 ? this.f2517c.getPaddingBottom() + this.f2517c.getPaddingTop() + i + 0 : 0);
        }
        boolean z2 = this.f2514A.getInputMethodMode() == 2;
        LayoutInflater$Factory2C0000A.C0010h.m2614s0(this.f2514A, this.f2522i);
        if (this.f2514A.isShowing()) {
            View view2 = this.f2530q;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if (C0492V4.C0498f.m1909b(view2)) {
                int i7 = this.f2519f;
                if (i7 == -1) {
                    i7 = -1;
                } else if (i7 == -2) {
                    i7 = this.f2530q.getWidth();
                }
                int i8 = this.f2518d;
                if (i8 == -1) {
                    if (!z2) {
                        paddingBottom = -1;
                    }
                    if (z2) {
                        this.f2514A.setWidth(this.f2519f == -1 ? -1 : 0);
                        this.f2514A.setHeight(0);
                    } else {
                        this.f2514A.setWidth(this.f2519f == -1 ? -1 : 0);
                        this.f2514A.setHeight(-1);
                    }
                } else if (i8 != -2) {
                    paddingBottom = i8;
                }
                this.f2514A.setOutsideTouchable(true);
                this.f2514A.update(this.f2530q, this.f2520g, this.f2521h, i7 < 0 ? -1 : i7, paddingBottom < 0 ? -1 : paddingBottom);
                return;
            }
            return;
        }
        int i9 = this.f2519f;
        if (i9 == -1) {
            i9 = -1;
        } else if (i9 == -2) {
            i9 = this.f2530q.getWidth();
        }
        int i10 = this.f2518d;
        if (i10 == -1) {
            paddingBottom = -1;
        } else if (i10 != -2) {
            paddingBottom = i10;
        }
        this.f2514A.setWidth(i9);
        this.f2514A.setHeight(paddingBottom);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = f2511B;
            if (method2 != null) {
                try {
                    method2.invoke(this.f2514A, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.f2514A.setIsClippedToScreen(true);
        }
        this.f2514A.setOutsideTouchable(true);
        this.f2514A.setTouchInterceptor(this.f2533t);
        if (this.f2525l) {
            LayoutInflater$Factory2C0000A.C0010h.m2628l0(this.f2514A, this.f2524k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = f2513D;
            if (method3 != null) {
                try {
                    method3.invoke(this.f2514A, this.f2538y);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            this.f2514A.setEpicenterBounds(this.f2538y);
        }
        C1957l5.m613a(this.f2514A, this.f2530q, this.f2520g, this.f2521h, this.f2526m);
        this.f2517c.setSelection(-1);
        if ((!this.f2539z || this.f2517c.isInTouchMode()) && (c0281m0 = this.f2517c) != null) {
            c0281m0.f936j = true;
            c0281m0.requestLayout();
        }
        if (this.f2539z) {
            return;
        }
        this.f2536w.post(this.f2535v);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2518d = -2;
        this.f2519f = -2;
        this.f2522i = 1002;
        this.f2526m = 0;
        this.f2527n = Integer.MAX_VALUE;
        this.f2528o = 0;
        this.f2532s = new RunnableC0675e();
        this.f2533t = new View$OnTouchListenerC0674d();
        this.f2534u = new C0673c();
        this.f2535v = new RunnableC0671a();
        this.f2537x = new Rect();
        this.f2515a = context;
        this.f2536w = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2012o.ListPopupWindow, i, i2);
        this.f2520g = obtainStyledAttributes.getDimensionPixelOffset(C2012o.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(C2012o.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.f2521h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2523j = true;
        }
        obtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i, i2);
        this.f2514A = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }
}
