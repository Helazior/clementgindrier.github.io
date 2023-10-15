package p000;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.google.firebase.crashlytics.internal.settings.network.DefaultSettingsSpiCall;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.undo.TimedUndoAdapter;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: e1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class View$OnLongClickListenerC1635e1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: k */
    public static View$OnLongClickListenerC1635e1 f4107k;

    /* renamed from: l */
    public static View$OnLongClickListenerC1635e1 f4108l;

    /* renamed from: a */
    public final View f4109a;

    /* renamed from: b */
    public final CharSequence f4110b;

    /* renamed from: c */
    public final int f4111c;

    /* renamed from: d */
    public final Runnable f4112d = new RunnableC1636a();

    /* renamed from: f */
    public final Runnable f4113f = new RunnableC1637b();

    /* renamed from: g */
    public int f4114g;

    /* renamed from: h */
    public int f4115h;

    /* renamed from: i */
    public C1673f1 f4116i;

    /* renamed from: j */
    public boolean f4117j;

    /* renamed from: e1$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC1636a implements Runnable {
        public RunnableC1636a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View$OnLongClickListenerC1635e1.this.m1003d(false);
        }
    }

    /* renamed from: e1$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC1637b implements Runnable {
        public RunnableC1637b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View$OnLongClickListenerC1635e1.this.m1005b();
        }
    }

    public View$OnLongClickListenerC1635e1(View view, CharSequence charSequence) {
        int scaledTouchSlop;
        this.f4109a = view;
        this.f4110b = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = C0535W4.f1890a;
        if (Build.VERSION.SDK_INT >= 28) {
            scaledTouchSlop = viewConfiguration.getScaledHoverSlop();
        } else {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop() / 2;
        }
        this.f4111c = scaledTouchSlop;
        m1006a();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    /* renamed from: c */
    public static void m1004c(View$OnLongClickListenerC1635e1 view$OnLongClickListenerC1635e1) {
        View$OnLongClickListenerC1635e1 view$OnLongClickListenerC1635e12 = f4107k;
        if (view$OnLongClickListenerC1635e12 != null) {
            view$OnLongClickListenerC1635e12.f4109a.removeCallbacks(view$OnLongClickListenerC1635e12.f4112d);
        }
        f4107k = view$OnLongClickListenerC1635e1;
        if (view$OnLongClickListenerC1635e1 != null) {
            view$OnLongClickListenerC1635e1.f4109a.postDelayed(view$OnLongClickListenerC1635e1.f4112d, ViewConfiguration.getLongPressTimeout());
        }
    }

    /* renamed from: a */
    public final void m1006a() {
        this.f4114g = Integer.MAX_VALUE;
        this.f4115h = Integer.MAX_VALUE;
    }

    /* renamed from: b */
    public void m1005b() {
        if (f4108l == this) {
            f4108l = null;
            C1673f1 c1673f1 = this.f4116i;
            if (c1673f1 != null) {
                c1673f1.m987a();
                this.f4116i = null;
                m1006a();
                this.f4109a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f4107k == this) {
            m1004c(null);
        }
        this.f4109a.removeCallbacks(this.f4113f);
    }

    /* renamed from: d */
    public void m1003d(boolean z) {
        int height;
        int i;
        long j;
        int longPressTimeout;
        long j2;
        View view = this.f4109a;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        if (C0492V4.C0498f.m1909b(view)) {
            m1004c(null);
            View$OnLongClickListenerC1635e1 view$OnLongClickListenerC1635e1 = f4108l;
            if (view$OnLongClickListenerC1635e1 != null) {
                view$OnLongClickListenerC1635e1.m1005b();
            }
            f4108l = this;
            this.f4117j = z;
            C1673f1 c1673f1 = new C1673f1(this.f4109a.getContext());
            this.f4116i = c1673f1;
            View view2 = this.f4109a;
            int i2 = this.f4114g;
            int i3 = this.f4115h;
            boolean z2 = this.f4117j;
            CharSequence charSequence = this.f4110b;
            if (c1673f1.f4170b.getParent() != null) {
                c1673f1.m987a();
            }
            c1673f1.f4171c.setText(charSequence);
            WindowManager.LayoutParams layoutParams = c1673f1.f4172d;
            layoutParams.token = view2.getApplicationWindowToken();
            int dimensionPixelOffset = c1673f1.f4169a.getResources().getDimensionPixelOffset(C1881i.tooltip_precise_anchor_threshold);
            if (view2.getWidth() < dimensionPixelOffset) {
                i2 = view2.getWidth() / 2;
            }
            if (view2.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = c1673f1.f4169a.getResources().getDimensionPixelOffset(C1881i.tooltip_precise_anchor_extra_offset);
                height = i3 + dimensionPixelOffset2;
                i = i3 - dimensionPixelOffset2;
            } else {
                height = view2.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = c1673f1.f4169a.getResources().getDimensionPixelOffset(z2 ? C1881i.tooltip_y_offset_touch : C1881i.tooltip_y_offset_non_touch);
            View rootView = view2.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context = view2.getContext();
                while (true) {
                    if (!(context instanceof ContextWrapper)) {
                        break;
                    } else if (context instanceof Activity) {
                        rootView = ((Activity) context).getWindow().getDecorView();
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
            } else {
                rootView.getWindowVisibleDisplayFrame(c1673f1.f4173e);
                Rect rect = c1673f1.f4173e;
                if (rect.left < 0 && rect.top < 0) {
                    Resources resources = c1673f1.f4169a.getResources();
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", DefaultSettingsSpiCall.ANDROID_CLIENT_TYPE);
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    c1673f1.f4173e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(c1673f1.f4175g);
                view2.getLocationOnScreen(c1673f1.f4174f);
                int[] iArr = c1673f1.f4174f;
                int i4 = iArr[0];
                int[] iArr2 = c1673f1.f4175g;
                iArr[0] = i4 - iArr2[0];
                iArr[1] = iArr[1] - iArr2[1];
                layoutParams.x = (iArr[0] + i2) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                c1673f1.f4170b.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = c1673f1.f4170b.getMeasuredHeight();
                int[] iArr3 = c1673f1.f4174f;
                int i5 = ((iArr3[1] + i) - dimensionPixelOffset3) - measuredHeight;
                int i6 = iArr3[1] + height + dimensionPixelOffset3;
                if (z2) {
                    if (i5 >= 0) {
                        layoutParams.y = i5;
                    } else {
                        layoutParams.y = i6;
                    }
                } else if (measuredHeight + i6 <= c1673f1.f4173e.height()) {
                    layoutParams.y = i6;
                } else {
                    layoutParams.y = i5;
                }
            }
            ((WindowManager) c1673f1.f4169a.getSystemService("window")).addView(c1673f1.f4170b, c1673f1.f4172d);
            this.f4109a.addOnAttachStateChangeListener(this);
            if (this.f4117j) {
                j2 = 2500;
            } else {
                if ((C0492V4.C0495c.m1937g(this.f4109a) & 1) == 1) {
                    j = TimedUndoAdapter.DEFAULT_TIMEOUT_MS;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                } else {
                    j = 15000;
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                }
                j2 = j - longPressTimeout;
            }
            this.f4109a.removeCallbacks(this.f4113f);
            this.f4109a.postDelayed(this.f4113f, j2);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        boolean z;
        if (this.f4116i == null || !this.f4117j) {
            AccessibilityManager accessibilityManager = (AccessibilityManager) this.f4109a.getContext().getSystemService("accessibility");
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 7) {
                if (action == 10) {
                    m1006a();
                    m1005b();
                }
            } else if (this.f4109a.isEnabled() && this.f4116i == null) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (Math.abs(x - this.f4114g) > this.f4111c || Math.abs(y - this.f4115h) > this.f4111c) {
                    this.f4114g = x;
                    this.f4115h = y;
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    m1004c(this);
                }
            }
            return false;
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f4114g = view.getWidth() / 2;
        this.f4115h = view.getHeight() / 2;
        m1003d(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m1005b();
    }
}
