package p000;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* renamed from: w5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2319w5 {

    /* renamed from: w */
    public static final Interpolator f6751w = new animationInterpolatorC2320a();

    /* renamed from: a */
    public int f6752a;

    /* renamed from: b */
    public int f6753b;

    /* renamed from: d */
    public float[] f6755d;

    /* renamed from: e */
    public float[] f6756e;

    /* renamed from: f */
    public float[] f6757f;

    /* renamed from: g */
    public float[] f6758g;

    /* renamed from: h */
    public int[] f6759h;

    /* renamed from: i */
    public int[] f6760i;

    /* renamed from: j */
    public int[] f6761j;

    /* renamed from: k */
    public int f6762k;

    /* renamed from: l */
    public VelocityTracker f6763l;

    /* renamed from: m */
    public float f6764m;

    /* renamed from: n */
    public float f6765n;

    /* renamed from: o */
    public int f6766o;

    /* renamed from: p */
    public int f6767p;

    /* renamed from: q */
    public OverScroller f6768q;

    /* renamed from: r */
    public final AbstractC2322c f6769r;

    /* renamed from: s */
    public View f6770s;

    /* renamed from: t */
    public boolean f6771t;

    /* renamed from: u */
    public final ViewGroup f6772u;

    /* renamed from: c */
    public int f6754c = -1;

    /* renamed from: v */
    public final Runnable f6773v = new RunnableC2321b();

    /* renamed from: w5$a  reason: invalid class name */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class animationInterpolatorC2320a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: w5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC2321b implements Runnable {
        public RunnableC2321b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C2319w5.this.m171u(0);
        }
    }

    /* renamed from: w5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC2322c {
        public abstract int clampViewPositionHorizontal(View view, int i, int i2);

        public abstract int clampViewPositionVertical(View view, int i, int i2);

        public int getOrderedChildIndex(int i) {
            return i;
        }

        public int getViewHorizontalDragRange(View view) {
            return 0;
        }

        public int getViewVerticalDragRange(View view) {
            return 0;
        }

        public void onEdgeDragStarted(int i, int i2) {
        }

        public boolean onEdgeLock(int i) {
            return false;
        }

        public void onEdgeTouched(int i, int i2) {
        }

        public void onViewCaptured(View view, int i) {
        }

        public abstract void onViewDragStateChanged(int i);

        public abstract void onViewPositionChanged(View view, int i, int i2, int i3, int i4);

        public abstract void onViewReleased(View view, float f, float f2);

        public abstract boolean tryCaptureView(View view, int i);
    }

    public C2319w5(Context context, ViewGroup viewGroup, AbstractC2322c abstractC2322c) {
        if (abstractC2322c != null) {
            this.f6772u = viewGroup;
            this.f6769r = abstractC2322c;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f6766o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f6753b = viewConfiguration.getScaledTouchSlop();
            this.f6764m = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f6765n = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f6768q = new OverScroller(context, f6751w);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    /* renamed from: j */
    public static C2319w5 m182j(ViewGroup viewGroup, float f, AbstractC2322c abstractC2322c) {
        C2319w5 c2319w5 = new C2319w5(viewGroup.getContext(), viewGroup, abstractC2322c);
        c2319w5.f6753b = (int) ((1.0f / f) * c2319w5.f6753b);
        return c2319w5;
    }

    /* renamed from: a */
    public void m191a() {
        this.f6754c = -1;
        float[] fArr = this.f6755d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f6756e, 0.0f);
            Arrays.fill(this.f6757f, 0.0f);
            Arrays.fill(this.f6758g, 0.0f);
            Arrays.fill(this.f6759h, 0);
            Arrays.fill(this.f6760i, 0);
            Arrays.fill(this.f6761j, 0);
            this.f6762k = 0;
        }
        VelocityTracker velocityTracker = this.f6763l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f6763l = null;
        }
    }

    /* renamed from: b */
    public void m190b(View view, int i) {
        if (view.getParent() == this.f6772u) {
            this.f6770s = view;
            this.f6754c = i;
            this.f6769r.onViewCaptured(view, i);
            m171u(1);
            return;
        }
        StringBuilder m253r = outline.m253r("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
        m253r.append(this.f6772u);
        m253r.append(")");
        throw new IllegalArgumentException(m253r.toString());
    }

    /* renamed from: c */
    public final boolean m189c(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f6759h[i] & i2) != i2 || (this.f6767p & i2) == 0 || (this.f6761j[i] & i2) == i2 || (this.f6760i[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f6753b;
        if (abs > i3 || abs2 > i3) {
            if (abs >= abs2 * 0.5f || !this.f6769r.onEdgeLock(i2)) {
                return (this.f6760i[i] & i2) == 0 && abs > ((float) this.f6753b);
            }
            int[] iArr = this.f6761j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
        return false;
    }

    /* renamed from: d */
    public final boolean m188d(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f6769r.getViewHorizontalDragRange(view) > 0;
        boolean z2 = this.f6769r.getViewVerticalDragRange(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f6753b) : z2 && Math.abs(f2) > ((float) this.f6753b);
        }
        float f3 = f2 * f2;
        int i = this.f6753b;
        return f3 + (f * f) > ((float) (i * i));
    }

    /* renamed from: e */
    public final float m187e(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        return abs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    /* renamed from: f */
    public final int m186f(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        return abs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    /* renamed from: g */
    public final void m185g(int i) {
        if (this.f6755d == null || !m178n(i)) {
            return;
        }
        this.f6755d[i] = 0.0f;
        this.f6756e[i] = 0.0f;
        this.f6757f[i] = 0.0f;
        this.f6758g[i] = 0.0f;
        this.f6759h[i] = 0;
        this.f6760i[i] = 0;
        this.f6761j[i] = 0;
        this.f6762k = (~(1 << i)) & this.f6762k;
    }

    /* renamed from: h */
    public final int m184h(int i, int i2, int i3) {
        int width;
        int abs;
        if (i == 0) {
            return 0;
        }
        float width2 = this.f6772u.getWidth() / 2;
        float sin = (((float) Math.sin((Math.min(1.0f, Math.abs(i) / width) - 0.5f) * 0.47123894f)) * width2) + width2;
        int abs2 = Math.abs(i2);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(sin / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(abs, 600);
    }

    /* renamed from: i */
    public boolean m183i(boolean z) {
        if (this.f6752a == 2) {
            boolean computeScrollOffset = this.f6768q.computeScrollOffset();
            int currX = this.f6768q.getCurrX();
            int currY = this.f6768q.getCurrY();
            int left = currX - this.f6770s.getLeft();
            int top = currY - this.f6770s.getTop();
            if (left != 0) {
                C0492V4.m1957n(this.f6770s, left);
            }
            if (top != 0) {
                C0492V4.m1956o(this.f6770s, top);
            }
            if (left != 0 || top != 0) {
                this.f6769r.onViewPositionChanged(this.f6770s, currX, currY, left, top);
            }
            if (computeScrollOffset && currX == this.f6768q.getFinalX() && currY == this.f6768q.getFinalY()) {
                this.f6768q.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                if (z) {
                    this.f6772u.post(this.f6773v);
                } else {
                    m171u(0);
                }
            }
        }
        return this.f6752a == 2;
    }

    /* renamed from: k */
    public final void m181k(float f, float f2) {
        this.f6771t = true;
        this.f6769r.onViewReleased(this.f6770s, f, f2);
        this.f6771t = false;
        if (this.f6752a == 1) {
            m171u(0);
        }
    }

    /* renamed from: l */
    public View m180l(int i, int i2) {
        for (int childCount = this.f6772u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f6772u.getChildAt(this.f6769r.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: m */
    public final boolean m179m(int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int left = this.f6770s.getLeft();
        int top = this.f6770s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f6768q.abortAnimation();
            m171u(0);
            return false;
        }
        View view = this.f6770s;
        int m186f = m186f(i3, (int) this.f6765n, (int) this.f6764m);
        int m186f2 = m186f(i4, (int) this.f6765n, (int) this.f6764m);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(m186f);
        int abs4 = Math.abs(m186f2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        if (m186f != 0) {
            f = abs3;
            f2 = i7;
        } else {
            f = abs;
            f2 = i8;
        }
        float f5 = f / f2;
        if (m186f2 != 0) {
            f3 = abs4;
            f4 = i7;
        } else {
            f3 = abs2;
            f4 = i8;
        }
        int m184h = m184h(i5, m186f, this.f6769r.getViewHorizontalDragRange(view));
        this.f6768q.startScroll(left, top, i5, i6, (int) ((m184h(i6, m186f2, this.f6769r.getViewVerticalDragRange(view)) * (f3 / f4)) + (m184h * f5)));
        m171u(2);
        return true;
    }

    /* renamed from: n */
    public boolean m178n(int i) {
        return ((1 << i) & this.f6762k) != 0;
    }

    /* renamed from: o */
    public final boolean m177o(int i) {
        if (m178n(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* renamed from: p */
    public void m176p(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m191a();
        }
        if (this.f6763l == null) {
            this.f6763l = VelocityTracker.obtain();
        }
        this.f6763l.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View m180l = m180l((int) x, (int) y);
            m173s(x, y, pointerId);
            m167y(m180l, pointerId);
            int i3 = this.f6759h[pointerId];
            int i4 = this.f6767p;
            if ((i3 & i4) != 0) {
                this.f6769r.onEdgeTouched(i3 & i4, pointerId);
            }
        } else if (actionMasked == 1) {
            if (this.f6752a == 1) {
                m175q();
            }
            m191a();
        } else if (actionMasked == 2) {
            if (this.f6752a == 1) {
                if (m177o(this.f6754c)) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f6754c);
                    float x2 = motionEvent.getX(findPointerIndex);
                    float y2 = motionEvent.getY(findPointerIndex);
                    float[] fArr = this.f6757f;
                    int i5 = this.f6754c;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.f6758g[i5]);
                    int left = this.f6770s.getLeft() + i6;
                    int top = this.f6770s.getTop() + i7;
                    int left2 = this.f6770s.getLeft();
                    int top2 = this.f6770s.getTop();
                    if (i6 != 0) {
                        left = this.f6769r.clampViewPositionHorizontal(this.f6770s, left, i6);
                        C0492V4.m1957n(this.f6770s, left - left2);
                    }
                    int i8 = left;
                    if (i7 != 0) {
                        top = this.f6769r.clampViewPositionVertical(this.f6770s, top, i7);
                        C0492V4.m1956o(this.f6770s, top - top2);
                    }
                    int i9 = top;
                    if (i6 != 0 || i7 != 0) {
                        this.f6769r.onViewPositionChanged(this.f6770s, i8, i9, i8 - left2, i9 - top2);
                    }
                    m172t(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (m177o(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.f6755d[pointerId2];
                    float f2 = y3 - this.f6756e[pointerId2];
                    m174r(f, f2, pointerId2);
                    if (this.f6752a != 1) {
                        View m180l2 = m180l((int) x3, (int) y3);
                        if (m188d(m180l2, f, f2) && m167y(m180l2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            m172t(motionEvent);
        } else if (actionMasked == 3) {
            if (this.f6752a == 1) {
                m181k(0.0f, 0.0f);
            }
            m191a();
        } else if (actionMasked != 5) {
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f6752a == 1 && pointerId3 == this.f6754c) {
                int pointerCount2 = motionEvent.getPointerCount();
                while (true) {
                    if (i2 >= pointerCount2) {
                        i = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i2);
                    if (pointerId4 != this.f6754c) {
                        View m180l3 = m180l((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                        View view = this.f6770s;
                        if (m180l3 == view && m167y(view, pointerId4)) {
                            i = this.f6754c;
                            break;
                        }
                    }
                    i2++;
                }
                if (i == -1) {
                    m175q();
                }
            }
            m185g(pointerId3);
        } else {
            int pointerId5 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            m173s(x4, y4, pointerId5);
            if (this.f6752a == 0) {
                m167y(m180l((int) x4, (int) y4), pointerId5);
                int i10 = this.f6759h[pointerId5];
                int i11 = this.f6767p;
                if ((i10 & i11) != 0) {
                    this.f6769r.onEdgeTouched(i10 & i11, pointerId5);
                    return;
                }
                return;
            }
            int i12 = (int) x4;
            int i13 = (int) y4;
            View view2 = this.f6770s;
            if (view2 != null && i12 >= view2.getLeft() && i12 < view2.getRight() && i13 >= view2.getTop() && i13 < view2.getBottom()) {
                i2 = 1;
            }
            if (i2 != 0) {
                m167y(this.f6770s, pointerId5);
            }
        }
    }

    /* renamed from: q */
    public final void m175q() {
        this.f6763l.computeCurrentVelocity(1000, this.f6764m);
        m181k(m187e(this.f6763l.getXVelocity(this.f6754c), this.f6765n, this.f6764m), m187e(this.f6763l.getYVelocity(this.f6754c), this.f6765n, this.f6764m));
    }

    /* renamed from: r */
    public final void m174r(float f, float f2, int i) {
        int i2 = m189c(f, f2, i, 1) ? 1 : 0;
        if (m189c(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m189c(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m189c(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f6760i;
            iArr[i] = iArr[i] | i2;
            this.f6769r.onEdgeDragStarted(i2, i);
        }
    }

    /* renamed from: s */
    public final void m173s(float f, float f2, int i) {
        float[] fArr = this.f6755d;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f6756e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f6757f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f6758g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f6759h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f6760i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f6761j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f6755d = fArr2;
            this.f6756e = fArr3;
            this.f6757f = fArr4;
            this.f6758g = fArr5;
            this.f6759h = iArr;
            this.f6760i = iArr2;
            this.f6761j = iArr3;
        }
        float[] fArr9 = this.f6755d;
        this.f6757f[i] = f;
        fArr9[i] = f;
        float[] fArr10 = this.f6756e;
        this.f6758g[i] = f2;
        fArr10[i] = f2;
        int[] iArr7 = this.f6759h;
        int i3 = (int) f;
        int i4 = (int) f2;
        int i5 = i3 < this.f6772u.getLeft() + this.f6766o ? 1 : 0;
        if (i4 < this.f6772u.getTop() + this.f6766o) {
            i5 |= 4;
        }
        if (i3 > this.f6772u.getRight() - this.f6766o) {
            i5 |= 2;
        }
        if (i4 > this.f6772u.getBottom() - this.f6766o) {
            i5 |= 8;
        }
        iArr7[i] = i5;
        this.f6762k |= 1 << i;
    }

    /* renamed from: t */
    public final void m172t(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m177o(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f6757f[pointerId] = x;
                this.f6758g[pointerId] = y;
            }
        }
    }

    /* renamed from: u */
    public void m171u(int i) {
        this.f6772u.removeCallbacks(this.f6773v);
        if (this.f6752a != i) {
            this.f6752a = i;
            this.f6769r.onViewDragStateChanged(i);
            if (this.f6752a == 0) {
                this.f6770s = null;
            }
        }
    }

    /* renamed from: v */
    public boolean m170v(int i, int i2) {
        if (this.f6771t) {
            return m179m(i, i2, (int) this.f6763l.getXVelocity(this.f6754c), (int) this.f6763l.getYVelocity(this.f6754c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00de, code lost:
        if (r12 != r11) goto L57;
     */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m169w(android.view.MotionEvent r17) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2319w5.m169w(android.view.MotionEvent):boolean");
    }

    /* renamed from: x */
    public boolean m168x(View view, int i, int i2) {
        this.f6770s = view;
        this.f6754c = -1;
        boolean m179m = m179m(i, i2, 0, 0);
        if (!m179m && this.f6752a == 0 && this.f6770s != null) {
            this.f6770s = null;
        }
        return m179m;
    }

    /* renamed from: y */
    public boolean m167y(View view, int i) {
        if (view == this.f6770s && this.f6754c == i) {
            return true;
        }
        if (view == null || !this.f6769r.tryCaptureView(view, i)) {
            return false;
        }
        this.f6754c = i;
        m190b(view, i);
        return true;
    }
}
