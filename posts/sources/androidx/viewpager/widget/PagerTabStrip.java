package androidx.viewpager.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PagerTabStrip extends PagerTitleStrip {

    /* renamed from: A */
    public boolean f3497A;

    /* renamed from: B */
    public boolean f3498B;

    /* renamed from: C */
    public int f3499C;

    /* renamed from: D */
    public boolean f3500D;

    /* renamed from: E */
    public float f3501E;

    /* renamed from: F */
    public float f3502F;

    /* renamed from: G */
    public int f3503G;

    /* renamed from: r */
    public int f3504r;

    /* renamed from: s */
    public int f3505s;

    /* renamed from: t */
    public int f3506t;

    /* renamed from: u */
    public int f3507u;

    /* renamed from: v */
    public int f3508v;

    /* renamed from: w */
    public int f3509w;

    /* renamed from: x */
    public final Paint f3510x;

    /* renamed from: y */
    public final Rect f3511y;

    /* renamed from: z */
    public int f3512z;

    /* renamed from: androidx.viewpager.widget.PagerTabStrip$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnClickListenerC0918a implements View.OnClickListener {
        public View$OnClickListenerC0918a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f3517a;
            viewPager.setCurrentItem(viewPager.f3571g - 1);
        }
    }

    /* renamed from: androidx.viewpager.widget.PagerTabStrip$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnClickListenerC0919b implements View.OnClickListener {
        public View$OnClickListenerC0919b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = PagerTabStrip.this.f3517a;
            viewPager.setCurrentItem(viewPager.f3571g + 1);
        }
    }

    public PagerTabStrip(Context context) {
        this(context, null);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    /* renamed from: a */
    public int mo1260a() {
        Drawable background = getBackground();
        return Math.max(background != null ? background.getIntrinsicHeight() : 0, this.f3508v);
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    /* renamed from: e */
    public void mo1256e(int i, float f, boolean z) {
        Rect rect = this.f3511y;
        int height = getHeight();
        int left = this.f3519c.getLeft() - this.f3509w;
        int right = this.f3519c.getRight() + this.f3509w;
        int i2 = height - this.f3505s;
        rect.set(left, i2, right, height);
        super.mo1256e(i, f, z);
        this.f3512z = (int) (Math.abs(f - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f3519c.getLeft() - this.f3509w, i2, this.f3519c.getRight() + this.f3509w, height);
        invalidate(rect);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f3519c.getLeft() - this.f3509w;
        int right = this.f3519c.getRight() + this.f3509w;
        this.f3510x.setColor((this.f3512z << 24) | (this.f3504r & 16777215));
        float f = height;
        canvas.drawRect(left, height - this.f3505s, right, f, this.f3510x);
        if (this.f3497A) {
            this.f3510x.setColor((-16777216) | (this.f3504r & 16777215));
            canvas.drawRect(getPaddingLeft(), height - this.f3499C, getWidth() - getPaddingRight(), f, this.f3510x);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0 || !this.f3500D) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (action == 0) {
                this.f3501E = x;
                this.f3502F = y;
                this.f3500D = false;
            } else if (action != 1) {
                if (action == 2 && (Math.abs(x - this.f3501E) > this.f3503G || Math.abs(y - this.f3502F) > this.f3503G)) {
                    this.f3500D = true;
                }
            } else if (x < this.f3519c.getLeft() - this.f3509w) {
                ViewPager viewPager = this.f3517a;
                viewPager.setCurrentItem(viewPager.f3571g - 1);
            } else if (x > this.f3519c.getRight() + this.f3509w) {
                ViewPager viewPager2 = this.f3517a;
                viewPager2.setCurrentItem(viewPager2.f3571g + 1);
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        super.setBackgroundColor(i);
        if (this.f3498B) {
            return;
        }
        this.f3497A = (i & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3498B) {
            return;
        }
        this.f3497A = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3498B) {
            return;
        }
        this.f3497A = i == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.f3497A = z;
        this.f3498B = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        int i5 = this.f3506t;
        if (i4 < i5) {
            i4 = i5;
        }
        super.setPadding(i, i2, i3, i4);
    }

    public void setTabIndicatorColor(int i) {
        this.f3504r = i;
        this.f3510x.setColor(i);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i) {
        setTabIndicatorColor(C2307w3.m210b(getContext(), i));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i) {
        int i2 = this.f3507u;
        if (i < i2) {
            i = i2;
        }
        super.setTextSpacing(i);
    }

    public PagerTabStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f3510x = paint;
        this.f3511y = new Rect();
        this.f3512z = 255;
        this.f3497A = false;
        this.f3498B = false;
        int i = this.f3530o;
        this.f3504r = i;
        paint.setColor(i);
        float f = context.getResources().getDisplayMetrics().density;
        this.f3505s = (int) ((3.0f * f) + 0.5f);
        this.f3506t = (int) ((6.0f * f) + 0.5f);
        this.f3507u = (int) (64.0f * f);
        this.f3509w = (int) ((16.0f * f) + 0.5f);
        this.f3499C = (int) ((1.0f * f) + 0.5f);
        this.f3508v = (int) ((f * 32.0f) + 0.5f);
        this.f3503G = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(this.f3523h);
        setWillNotDraw(false);
        this.f3518b.setFocusable(true);
        this.f3518b.setOnClickListener(new View$OnClickListenerC0918a());
        this.f3520d.setFocusable(true);
        this.f3520d.setOnClickListener(new View$OnClickListenerC0919b());
        if (getBackground() == null) {
            this.f3497A = true;
        }
    }
}
