package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p000.LayoutInflater$Factory2C0000A;

@ViewPager.InterfaceC0927e
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: p */
    public static final int[] f3515p = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: q */
    public static final int[] f3516q = {16843660};

    /* renamed from: a */
    public ViewPager f3517a;

    /* renamed from: b */
    public TextView f3518b;

    /* renamed from: c */
    public TextView f3519c;

    /* renamed from: d */
    public TextView f3520d;

    /* renamed from: f */
    public int f3521f;

    /* renamed from: g */
    public float f3522g;

    /* renamed from: h */
    public int f3523h;

    /* renamed from: i */
    public int f3524i;

    /* renamed from: j */
    public boolean f3525j;

    /* renamed from: k */
    public boolean f3526k;

    /* renamed from: l */
    public final C0920a f3527l;

    /* renamed from: m */
    public WeakReference<AbstractC1960l8> f3528m;

    /* renamed from: n */
    public int f3529n;

    /* renamed from: o */
    public int f3530o;

    /* renamed from: androidx.viewpager.widget.PagerTitleStrip$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0920a extends DataSetObserver implements ViewPager.InterfaceC0931i, ViewPager.InterfaceC0930h {

        /* renamed from: a */
        public int f3531a;

        public C0920a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0930h
        public void onAdapterChanged(ViewPager viewPager, AbstractC1960l8 abstractC1960l8, AbstractC1960l8 abstractC1960l82) {
            PagerTitleStrip.this.m1258c(abstractC1960l8, abstractC1960l82);
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            ViewPager viewPager = pagerTitleStrip.f3517a;
            pagerTitleStrip.m1257d(viewPager.f3571g, viewPager.f3570f);
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            float f = pagerTitleStrip2.f3522g;
            if (f < 0.0f) {
                f = 0.0f;
            }
            pagerTitleStrip2.mo1256e(pagerTitleStrip2.f3517a.f3571g, f, true);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0931i
        public void onPageScrollStateChanged(int i) {
            this.f3531a = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0931i
        public void onPageScrolled(int i, float f, int i2) {
            if (f > 0.5f) {
                i++;
            }
            PagerTitleStrip.this.mo1256e(i, f, false);
        }

        @Override // androidx.viewpager.widget.ViewPager.InterfaceC0931i
        public void onPageSelected(int i) {
            if (this.f3531a == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                ViewPager viewPager = pagerTitleStrip.f3517a;
                pagerTitleStrip.m1257d(viewPager.f3571g, viewPager.f3570f);
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                float f = pagerTitleStrip2.f3522g;
                if (f < 0.0f) {
                    f = 0.0f;
                }
                pagerTitleStrip2.mo1256e(pagerTitleStrip2.f3517a.f3571g, f, true);
            }
        }
    }

    /* renamed from: androidx.viewpager.widget.PagerTitleStrip$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0921b extends SingleLineTransformationMethod {

        /* renamed from: a */
        public Locale f3533a;

        public C0921b(Context context) {
            this.f3533a = context.getResources().getConfiguration().locale;
        }

        @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f3533a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    /* renamed from: b */
    public static void m1259b(TextView textView) {
        textView.setTransformationMethod(new C0921b(textView.getContext()));
    }

    /* renamed from: a */
    public int mo1260a() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    /* renamed from: c */
    public void m1258c(AbstractC1960l8 abstractC1960l8, AbstractC1960l8 abstractC1960l82) {
        if (abstractC1960l8 != null) {
            abstractC1960l8.f5460a.unregisterObserver(this.f3527l);
            this.f3528m = null;
        }
        if (abstractC1960l82 != null) {
            abstractC1960l82.f5460a.registerObserver(this.f3527l);
            this.f3528m = new WeakReference<>(abstractC1960l82);
        }
        ViewPager viewPager = this.f3517a;
        if (viewPager != null) {
            this.f3521f = -1;
            this.f3522g = -1.0f;
            m1257d(viewPager.f3571g, abstractC1960l82);
            requestLayout();
        }
    }

    /* renamed from: d */
    public void m1257d(int i, AbstractC1960l8 abstractC1960l8) {
        if (abstractC1960l8 != null) {
            abstractC1960l8.m611b();
        }
        this.f3525j = true;
        this.f3518b.setText((CharSequence) null);
        this.f3519c.setText((CharSequence) null);
        int i2 = i + 1;
        this.f3520d.setText((CharSequence) null);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f3518b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f3519c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f3520d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f3521f = i;
        if (!this.f3526k) {
            mo1256e(i, this.f3522g, false);
        }
        this.f3525j = false;
    }

    /* renamed from: e */
    public void mo1256e(int i, float f, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (i != this.f3521f) {
            m1257d(i, this.f3517a.f3570f);
        } else if (!z && f == this.f3522g) {
            return;
        }
        this.f3526k = true;
        int measuredWidth = this.f3518b.getMeasuredWidth();
        int measuredWidth2 = this.f3519c.getMeasuredWidth();
        int measuredWidth3 = this.f3520d.getMeasuredWidth();
        int i6 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i7 = paddingRight + i6;
        int i8 = (width - (paddingLeft + i6)) - i7;
        float f2 = 0.5f + f;
        if (f2 > 1.0f) {
            f2 -= 1.0f;
        }
        int i9 = ((width - i7) - ((int) (i8 * f2))) - i6;
        int i10 = measuredWidth2 + i9;
        int baseline = this.f3518b.getBaseline();
        int baseline2 = this.f3519c.getBaseline();
        int baseline3 = this.f3520d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i11 = max - baseline;
        int i12 = max - baseline2;
        int i13 = max - baseline3;
        int max2 = Math.max(Math.max(this.f3518b.getMeasuredHeight() + i11, this.f3519c.getMeasuredHeight() + i12), this.f3520d.getMeasuredHeight() + i13);
        int i14 = this.f3524i & 112;
        if (i14 == 16) {
            i2 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i14 != 80) {
            i3 = i11 + paddingTop;
            i4 = i12 + paddingTop;
            i5 = paddingTop + i13;
            TextView textView = this.f3519c;
            textView.layout(i9, i4, i10, textView.getMeasuredHeight() + i4);
            int min = Math.min(paddingLeft, (i9 - this.f3523h) - measuredWidth);
            TextView textView2 = this.f3518b;
            textView2.layout(min, i3, measuredWidth + min, textView2.getMeasuredHeight() + i3);
            int max3 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.f3523h);
            TextView textView3 = this.f3520d;
            textView3.layout(max3, i5, max3 + measuredWidth3, textView3.getMeasuredHeight() + i5);
            this.f3522g = f;
            this.f3526k = false;
        } else {
            i2 = (height - paddingBottom) - max2;
        }
        i3 = i11 + i2;
        i4 = i12 + i2;
        i5 = i2 + i13;
        TextView textView4 = this.f3519c;
        textView4.layout(i9, i4, i10, textView4.getMeasuredHeight() + i4);
        int min2 = Math.min(paddingLeft, (i9 - this.f3523h) - measuredWidth);
        TextView textView22 = this.f3518b;
        textView22.layout(min2, i3, measuredWidth + min2, textView22.getMeasuredHeight() + i3);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i10 + this.f3523h);
        TextView textView32 = this.f3520d;
        textView32.layout(max32, i5, max32 + measuredWidth3, textView32.getMeasuredHeight() + i5);
        this.f3522g = f;
        this.f3526k = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            AbstractC1960l8 abstractC1960l8 = viewPager.f3570f;
            C0920a c0920a = this.f3527l;
            viewPager.f3558U = c0920a;
            if (viewPager.f3559V == null) {
                viewPager.f3559V = new ArrayList();
            }
            viewPager.f3559V.add(c0920a);
            this.f3517a = viewPager;
            WeakReference<AbstractC1960l8> weakReference = this.f3528m;
            m1258c(weakReference != null ? weakReference.get() : null, abstractC1960l8);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f3517a;
        if (viewPager != null) {
            m1258c(viewPager.f3570f, null);
            ViewPager viewPager2 = this.f3517a;
            ViewPager.InterfaceC0931i interfaceC0931i = viewPager2.f3558U;
            viewPager2.f3558U = null;
            C0920a c0920a = this.f3527l;
            List<ViewPager.InterfaceC0930h> list = viewPager2.f3559V;
            if (list != null) {
                list.remove(c0920a);
            }
            this.f3517a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f3517a != null) {
            float f = this.f3522g;
            if (f < 0.0f) {
                f = 0.0f;
            }
            mo1256e(this.f3521f, f, true);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int max;
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            int paddingBottom = getPaddingBottom() + getPaddingTop();
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
            int size = View.MeasureSpec.getSize(i);
            int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i, (int) (size * 0.2f), -2);
            this.f3518b.measure(childMeasureSpec2, childMeasureSpec);
            this.f3519c.measure(childMeasureSpec2, childMeasureSpec);
            this.f3520d.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                max = View.MeasureSpec.getSize(i2);
            } else {
                max = Math.max(mo1260a(), this.f3519c.getMeasuredHeight() + paddingBottom);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(max, i2, this.f3519c.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.f3525j) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i) {
        this.f3524i = i;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f) {
        int i = ((int) (f * 255.0f)) & 255;
        this.f3529n = i;
        int i2 = (i << 24) | (this.f3530o & 16777215);
        this.f3518b.setTextColor(i2);
        this.f3520d.setTextColor(i2);
    }

    public void setTextColor(int i) {
        this.f3530o = i;
        this.f3519c.setTextColor(i);
        int i2 = (this.f3529n << 24) | (this.f3530o & 16777215);
        this.f3518b.setTextColor(i2);
        this.f3520d.setTextColor(i2);
    }

    public void setTextSize(int i, float f) {
        this.f3518b.setTextSize(i, f);
        this.f3519c.setTextSize(i, f);
        this.f3520d.setTextSize(i, f);
    }

    public void setTextSpacing(int i) {
        this.f3523h = i;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3521f = -1;
        this.f3522g = -1.0f;
        this.f3527l = new C0920a();
        TextView textView = new TextView(context);
        this.f3518b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f3519c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f3520d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3515p);
        boolean z = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            LayoutInflater$Factory2C0000A.C0010h.m2624n0(this.f3518b, resourceId);
            LayoutInflater$Factory2C0000A.C0010h.m2624n0(this.f3519c, resourceId);
            LayoutInflater$Factory2C0000A.C0010h.m2624n0(this.f3520d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            setTextSize(0, dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f3518b.setTextColor(color);
            this.f3519c.setTextColor(color);
            this.f3520d.setTextColor(color);
        }
        this.f3524i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f3530o = this.f3519c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f3518b.setEllipsize(TextUtils.TruncateAt.END);
        this.f3519c.setEllipsize(TextUtils.TruncateAt.END);
        this.f3520d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f3516q);
            z = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z) {
            m1259b(this.f3518b);
            m1259b(this.f3519c);
            m1259b(this.f3520d);
        } else {
            this.f3518b.setSingleLine();
            this.f3519c.setSingleLine();
            this.f3520d.setSingleLine();
        }
        this.f3523h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
