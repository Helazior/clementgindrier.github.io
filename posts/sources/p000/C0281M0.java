package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* renamed from: M0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0281M0 extends ListView {

    /* renamed from: a */
    public final Rect f928a;

    /* renamed from: b */
    public int f929b;

    /* renamed from: c */
    public int f930c;

    /* renamed from: d */
    public int f931d;

    /* renamed from: f */
    public int f932f;

    /* renamed from: g */
    public int f933g;

    /* renamed from: h */
    public Field f934h;

    /* renamed from: i */
    public C0282a f935i;

    /* renamed from: j */
    public boolean f936j;

    /* renamed from: k */
    public boolean f937k;

    /* renamed from: l */
    public boolean f938l;

    /* renamed from: m */
    public C1937k5 f939m;

    /* renamed from: n */
    public RunnableC0283b f940n;

    /* renamed from: M0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0282a extends C0344P {

        /* renamed from: a */
        public boolean f941a;

        public C0282a(Drawable drawable) {
            super(drawable);
            this.f941a = true;
        }

        @Override // p000.C0344P, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f941a) {
                super.draw(canvas);
            }
        }

        @Override // p000.C0344P, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.f941a) {
                super.setHotspot(f, f2);
            }
        }

        @Override // p000.C0344P, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f941a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // p000.C0344P, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f941a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // p000.C0344P, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f941a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* renamed from: M0$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0283b implements Runnable {
        public RunnableC0283b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0281M0 c0281m0 = C0281M0.this;
            c0281m0.f940n = null;
            c0281m0.drawableStateChanged();
        }
    }

    public C0281M0(Context context, boolean z) {
        super(context, null, C1671f.dropDownListViewStyle);
        this.f928a = new Rect();
        this.f929b = 0;
        this.f930c = 0;
        this.f931d = 0;
        this.f932f = 0;
        this.f937k = z;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f934h = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public int m2209a(int i, int i2, int i3) {
        int makeMeasureSpec;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i4 = listPaddingTop + listPaddingBottom;
        dividerHeight = (dividerHeight <= 0 || divider == null) ? 0 : 0;
        int count = adapter.getCount();
        View view = null;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < count) {
            int itemViewType = adapter.getItemViewType(i5);
            if (itemViewType != i6) {
                view = null;
                i6 = itemViewType;
            }
            view = adapter.getView(i5, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i8 = layoutParams.height;
            if (i8 > 0) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i, makeMeasureSpec);
            view.forceLayout();
            if (i5 > 0) {
                i4 += dividerHeight;
            }
            i4 += view.getMeasuredHeight();
            if (i4 >= i2) {
                return (i3 < 0 || i5 <= i3 || i7 <= 0 || i4 == i2) ? i2 : i7;
            }
            if (i3 >= 0 && i5 >= i3) {
                i7 = i4;
            }
            i5++;
        }
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r3 != 3) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:73:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015a  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m2208b(android.view.MotionEvent r17, int r18) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0281M0.m2208b(android.view.MotionEvent, int):boolean");
    }

    /* renamed from: c */
    public final void m2207c() {
        Drawable selector = getSelector();
        if (selector != null && this.f938l && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Drawable selector;
        if (!this.f928a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f928a);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        if (this.f940n != null) {
            return;
        }
        super.drawableStateChanged();
        C0282a c0282a = this.f935i;
        if (c0282a != null) {
            c0282a.f941a = true;
        }
        m2207c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f937k || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f937k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f937k || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f937k && this.f936j) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.f940n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f940n == null) {
            RunnableC0283b runnableC0283b = new RunnableC0283b();
            this.f940n = runnableC0283b;
            post(runnableC0283b);
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
        } else {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (pointToPosition != -1 && pointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                m2207c();
            }
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f933g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        RunnableC0283b runnableC0283b = this.f940n;
        if (runnableC0283b != null) {
            C0281M0 c0281m0 = C0281M0.this;
            c0281m0.f940n = null;
            c0281m0.removeCallbacks(runnableC0283b);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        C0282a c0282a = drawable != null ? new C0282a(drawable) : null;
        this.f935i = c0282a;
        super.setSelector(c0282a);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f929b = rect.left;
        this.f930c = rect.top;
        this.f931d = rect.right;
        this.f932f = rect.bottom;
    }
}
