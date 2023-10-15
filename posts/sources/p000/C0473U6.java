package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;

/* renamed from: U6 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0473U6 extends RecyclerView.AbstractC0842n implements RecyclerView.InterfaceC0850r {

    /* renamed from: D */
    public static final int[] f1641D = {16842919};

    /* renamed from: E */
    public static final int[] f1642E = new int[0];

    /* renamed from: A */
    public int f1643A;

    /* renamed from: B */
    public final Runnable f1644B;

    /* renamed from: C */
    public final RecyclerView.AbstractC0851s f1645C;

    /* renamed from: a */
    public final int f1646a;

    /* renamed from: b */
    public final int f1647b;

    /* renamed from: c */
    public final StateListDrawable f1648c;

    /* renamed from: d */
    public final Drawable f1649d;

    /* renamed from: e */
    public final int f1650e;

    /* renamed from: f */
    public final int f1651f;

    /* renamed from: g */
    public final StateListDrawable f1652g;

    /* renamed from: h */
    public final Drawable f1653h;

    /* renamed from: i */
    public final int f1654i;

    /* renamed from: j */
    public final int f1655j;

    /* renamed from: k */
    public int f1656k;

    /* renamed from: l */
    public int f1657l;

    /* renamed from: m */
    public float f1658m;

    /* renamed from: n */
    public int f1659n;

    /* renamed from: o */
    public int f1660o;

    /* renamed from: p */
    public float f1661p;

    /* renamed from: s */
    public RecyclerView f1664s;

    /* renamed from: z */
    public final ValueAnimator f1671z;

    /* renamed from: q */
    public int f1662q = 0;

    /* renamed from: r */
    public int f1663r = 0;

    /* renamed from: t */
    public boolean f1665t = false;

    /* renamed from: u */
    public boolean f1666u = false;

    /* renamed from: v */
    public int f1667v = 0;

    /* renamed from: w */
    public int f1668w = 0;

    /* renamed from: x */
    public final int[] f1669x = new int[2];

    /* renamed from: y */
    public final int[] f1670y = new int[2];

    /* renamed from: U6$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0474a implements Runnable {
        public RunnableC0474a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0473U6 c0473u6 = C0473U6.this;
            int i = c0473u6.f1643A;
            if (i == 1) {
                c0473u6.f1671z.cancel();
            } else if (i != 2) {
                return;
            }
            c0473u6.f1643A = 3;
            ValueAnimator valueAnimator = c0473u6.f1671z;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            c0473u6.f1671z.setDuration(500);
            c0473u6.f1671z.start();
        }
    }

    /* renamed from: U6$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0475b extends RecyclerView.AbstractC0851s {
        public C0475b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0851s
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            C0473U6 c0473u6 = C0473U6.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = c0473u6.f1664s.computeVerticalScrollRange();
            int i3 = c0473u6.f1663r;
            c0473u6.f1665t = computeVerticalScrollRange - i3 > 0 && i3 >= c0473u6.f1646a;
            int computeHorizontalScrollRange = c0473u6.f1664s.computeHorizontalScrollRange();
            int i4 = c0473u6.f1662q;
            boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= c0473u6.f1646a;
            c0473u6.f1666u = z;
            boolean z2 = c0473u6.f1665t;
            if (!z2 && !z) {
                if (c0473u6.f1667v != 0) {
                    c0473u6.m1978h(0);
                    return;
                }
                return;
            }
            if (z2) {
                float f = i3;
                c0473u6.f1657l = (int) ((((f / 2.0f) + computeVerticalScrollOffset) * f) / computeVerticalScrollRange);
                c0473u6.f1656k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
            }
            if (c0473u6.f1666u) {
                float f2 = computeHorizontalScrollOffset;
                float f3 = i4;
                c0473u6.f1660o = (int) ((((f3 / 2.0f) + f2) * f3) / computeHorizontalScrollRange);
                c0473u6.f1659n = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
            }
            int i5 = c0473u6.f1667v;
            if (i5 == 0 || i5 == 1) {
                c0473u6.m1978h(1);
            }
        }
    }

    /* renamed from: U6$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0476c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f1674a = false;

        public C0476c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1674a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1674a) {
                this.f1674a = false;
            } else if (((Float) C0473U6.this.f1671z.getAnimatedValue()).floatValue() == 0.0f) {
                C0473U6 c0473u6 = C0473U6.this;
                c0473u6.f1643A = 0;
                c0473u6.m1978h(0);
            } else {
                C0473U6 c0473u62 = C0473U6.this;
                c0473u62.f1643A = 2;
                c0473u62.f1664s.invalidate();
            }
        }
    }

    /* renamed from: U6$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0477d implements ValueAnimator.AnimatorUpdateListener {
        public C0477d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C0473U6.this.f1648c.setAlpha(floatValue);
            C0473U6.this.f1649d.setAlpha(floatValue);
            C0473U6.this.f1664s.invalidate();
        }
    }

    public C0473U6(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f1671z = ofFloat;
        this.f1643A = 0;
        this.f1644B = new RunnableC0474a();
        C0475b c0475b = new C0475b();
        this.f1645C = c0475b;
        this.f1648c = stateListDrawable;
        this.f1649d = drawable;
        this.f1652g = stateListDrawable2;
        this.f1653h = drawable2;
        this.f1650e = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f1651f = Math.max(i, drawable.getIntrinsicWidth());
        this.f1654i = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f1655j = Math.max(i, drawable2.getIntrinsicWidth());
        this.f1646a = i2;
        this.f1647b = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new C0476c());
        ofFloat.addUpdateListener(new C0477d());
        RecyclerView recyclerView2 = this.f1664s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            recyclerView2.removeItemDecoration(this);
            this.f1664s.removeOnItemTouchListener(this);
            this.f1664s.removeOnScrollListener(c0475b);
            m1982d();
        }
        this.f1664s = recyclerView;
        recyclerView.addItemDecoration(this);
        this.f1664s.addOnItemTouchListener(this);
        this.f1664s.addOnScrollListener(c0475b);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0850r
    /* renamed from: a */
    public boolean mo1364a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.f1667v;
        if (i == 1) {
            boolean m1980f = m1980f(motionEvent.getX(), motionEvent.getY());
            boolean m1981e = m1981e(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (m1980f || m1981e)) {
                if (m1981e) {
                    this.f1668w = 1;
                    this.f1661p = (int) motionEvent.getX();
                } else if (m1980f) {
                    this.f1668w = 2;
                    this.f1658m = (int) motionEvent.getY();
                }
                m1978h(2);
                return true;
            }
        } else if (i == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0850r
    /* renamed from: b */
    public void mo1363b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f1667v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean m1980f = m1980f(motionEvent.getX(), motionEvent.getY());
            boolean m1981e = m1981e(motionEvent.getX(), motionEvent.getY());
            if (m1980f || m1981e) {
                if (m1981e) {
                    this.f1668w = 1;
                    this.f1661p = (int) motionEvent.getX();
                } else if (m1980f) {
                    this.f1668w = 2;
                    this.f1658m = (int) motionEvent.getY();
                }
                m1978h(2);
            }
        } else if (motionEvent.getAction() == 1 && this.f1667v == 2) {
            this.f1658m = 0.0f;
            this.f1661p = 0.0f;
            m1978h(1);
            this.f1668w = 0;
        } else if (motionEvent.getAction() == 2 && this.f1667v == 2) {
            m1977i();
            if (this.f1668w == 1) {
                float x = motionEvent.getX();
                int[] iArr = this.f1670y;
                int i = this.f1647b;
                iArr[0] = i;
                iArr[1] = this.f1662q - i;
                float max = Math.max(iArr[0], Math.min(iArr[1], x));
                if (Math.abs(this.f1660o - max) >= 2.0f) {
                    int m1979g = m1979g(this.f1661p, max, iArr, this.f1664s.computeHorizontalScrollRange(), this.f1664s.computeHorizontalScrollOffset(), this.f1662q);
                    if (m1979g != 0) {
                        this.f1664s.scrollBy(m1979g, 0);
                    }
                    this.f1661p = max;
                }
            }
            if (this.f1668w == 2) {
                float y = motionEvent.getY();
                int[] iArr2 = this.f1669x;
                int i2 = this.f1647b;
                iArr2[0] = i2;
                iArr2[1] = this.f1663r - i2;
                float max2 = Math.max(iArr2[0], Math.min(iArr2[1], y));
                if (Math.abs(this.f1657l - max2) < 2.0f) {
                    return;
                }
                int m1979g2 = m1979g(this.f1658m, max2, iArr2, this.f1664s.computeVerticalScrollRange(), this.f1664s.computeVerticalScrollOffset(), this.f1663r);
                if (m1979g2 != 0) {
                    this.f1664s.scrollBy(0, m1979g2);
                }
                this.f1658m = max2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0850r
    /* renamed from: c */
    public void mo1362c(boolean z) {
    }

    /* renamed from: d */
    public final void m1982d() {
        this.f1664s.removeCallbacks(this.f1644B);
    }

    /* renamed from: e */
    public boolean m1981e(float f, float f2) {
        if (f2 >= this.f1663r - this.f1654i) {
            int i = this.f1660o;
            int i2 = this.f1659n;
            if (f >= i - (i2 / 2) && f <= (i2 / 2) + i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public boolean m1980f(float f, float f2) {
        RecyclerView recyclerView = this.f1664s;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        if (C0492V4.C0496d.m1921d(recyclerView) == 1) {
            if (f > this.f1650e / 2) {
                return false;
            }
        } else if (f < this.f1662q - this.f1650e) {
            return false;
        }
        int i = this.f1657l;
        int i2 = this.f1656k / 2;
        return f2 >= ((float) (i - i2)) && f2 <= ((float) (i2 + i));
    }

    /* renamed from: g */
    public final int m1979g(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* renamed from: h */
    public void m1978h(int i) {
        if (i == 2 && this.f1667v != 2) {
            this.f1648c.setState(f1641D);
            m1982d();
        }
        if (i == 0) {
            this.f1664s.invalidate();
        } else {
            m1977i();
        }
        if (this.f1667v == 2 && i != 2) {
            this.f1648c.setState(f1642E);
            m1982d();
            this.f1664s.postDelayed(this.f1644B, 1200);
        } else if (i == 1) {
            m1982d();
            this.f1664s.postDelayed(this.f1644B, (long) ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.f1667v = i;
    }

    /* renamed from: i */
    public void m1977i() {
        int i = this.f1643A;
        if (i != 0) {
            if (i != 3) {
                return;
            }
            this.f1671z.cancel();
        }
        this.f1643A = 1;
        ValueAnimator valueAnimator = this.f1671z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f1671z.setDuration(500L);
        this.f1671z.setStartDelay(0L);
        this.f1671z.start();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0842n
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0860y c0860y) {
        if (this.f1662q == this.f1664s.getWidth() && this.f1663r == this.f1664s.getHeight()) {
            if (this.f1643A != 0) {
                if (this.f1665t) {
                    int i = this.f1662q;
                    int i2 = this.f1650e;
                    int i3 = i - i2;
                    int i4 = this.f1657l;
                    int i5 = this.f1656k;
                    int i6 = i4 - (i5 / 2);
                    this.f1648c.setBounds(0, 0, i2, i5);
                    this.f1649d.setBounds(0, 0, this.f1651f, this.f1663r);
                    RecyclerView recyclerView2 = this.f1664s;
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    if (C0492V4.C0496d.m1921d(recyclerView2) == 1) {
                        this.f1649d.draw(canvas);
                        canvas.translate(this.f1650e, i6);
                        canvas.scale(-1.0f, 1.0f);
                        this.f1648c.draw(canvas);
                        canvas.scale(1.0f, 1.0f);
                        canvas.translate(-this.f1650e, -i6);
                    } else {
                        canvas.translate(i3, 0.0f);
                        this.f1649d.draw(canvas);
                        canvas.translate(0.0f, i6);
                        this.f1648c.draw(canvas);
                        canvas.translate(-i3, -i6);
                    }
                }
                if (this.f1666u) {
                    int i7 = this.f1663r;
                    int i8 = this.f1654i;
                    int i9 = i7 - i8;
                    int i10 = this.f1660o;
                    int i11 = this.f1659n;
                    int i12 = i10 - (i11 / 2);
                    this.f1652g.setBounds(0, 0, i11, i8);
                    this.f1653h.setBounds(0, 0, this.f1662q, this.f1655j);
                    canvas.translate(0.0f, i9);
                    this.f1653h.draw(canvas);
                    canvas.translate(i12, 0.0f);
                    this.f1652g.draw(canvas);
                    canvas.translate(-i12, -i9);
                    return;
                }
                return;
            }
            return;
        }
        this.f1662q = this.f1664s.getWidth();
        this.f1663r = this.f1664s.getHeight();
        m1978h(0);
    }
}
