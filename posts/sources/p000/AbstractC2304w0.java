package p000;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;

/* renamed from: w0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC2303w0 extends ViewGroup {

    /* renamed from: a */
    public final C2304a f6723a;

    /* renamed from: b */
    public final Context f6724b;

    /* renamed from: c */
    public ActionMenuView f6725c;

    /* renamed from: d */
    public ActionMenuPresenter f6726d;

    /* renamed from: f */
    public int f6727f;

    /* renamed from: g */
    public C0554X4 f6728g;

    /* renamed from: h */
    public boolean f6729h;

    /* renamed from: i */
    public boolean f6730i;

    /* renamed from: w0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C2304a implements InterfaceC0571Y4 {

        /* renamed from: a */
        public boolean f6731a = false;

        /* renamed from: b */
        public int f6732b;

        public C2304a() {
        }

        @Override // p000.InterfaceC0571Y4
        /* renamed from: a */
        public void mo224a(View view) {
            this.f6731a = true;
        }

        @Override // p000.InterfaceC0571Y4
        /* renamed from: b */
        public void mo223b(View view) {
            if (this.f6731a) {
                return;
            }
            AbstractC2303w0 abstractC2303w0 = AbstractC2303w0.this;
            abstractC2303w0.f6728g = null;
            AbstractC2303w0.super.setVisibility(this.f6732b);
        }

        @Override // p000.InterfaceC0571Y4
        /* renamed from: c */
        public void mo222c(View view) {
            AbstractC2303w0.super.setVisibility(0);
            this.f6731a = false;
        }
    }

    public AbstractC2303w0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: c */
    public int m227c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* renamed from: d */
    public int m226d(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* renamed from: e */
    public C0554X4 m225e(int i, long j) {
        C0554X4 c0554x4 = this.f6728g;
        if (c0554x4 != null) {
            c0554x4.m1808b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            C0554X4 m1969b = C0492V4.m1969b(this);
            m1969b.m1809a(1.0f);
            m1969b.m1807c(j);
            C2304a c2304a = this.f6723a;
            AbstractC2303w0.this.f6728g = m1969b;
            c2304a.f6732b = i;
            View view = m1969b.f1987a.get();
            if (view != null) {
                m1969b.m1805e(view, c2304a);
            }
            return m1969b;
        }
        C0554X4 m1969b2 = C0492V4.m1969b(this);
        m1969b2.m1809a(0.0f);
        m1969b2.m1807c(j);
        C2304a c2304a2 = this.f6723a;
        AbstractC2303w0.this.f6728g = m1969b2;
        c2304a2.f6732b = i;
        View view2 = m1969b2.f1987a.get();
        if (view2 != null) {
            m1969b2.m1805e(view2, c2304a2);
        }
        return m1969b2;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C2012o.ActionBar, C1671f.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C2012o.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.f6726d;
        if (actionMenuPresenter != null) {
            Configuration configuration2 = actionMenuPresenter.f4099b.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i2 = configuration2.screenHeightDp;
            actionMenuPresenter.f2399r = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
            C1905j0 c1905j0 = actionMenuPresenter.f4100c;
            if (c1905j0 != null) {
                c1905j0.onItemsChanged(true);
            }
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f6730i = false;
        }
        if (!this.f6730i) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.f6730i = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f6730i = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f6729h = false;
        }
        if (!this.f6729h) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.f6729h = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f6729h = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            C0554X4 c0554x4 = this.f6728g;
            if (c0554x4 != null) {
                c0554x4.m1808b();
            }
            super.setVisibility(i);
        }
    }

    public AbstractC2303w0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6723a = new C2304a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(C1671f.actionBarPopupTheme, typedValue, true) && typedValue.resourceId != 0) {
            this.f6724b = new ContextThemeWrapper(context, typedValue.resourceId);
        } else {
            this.f6724b = context;
        }
    }
}
