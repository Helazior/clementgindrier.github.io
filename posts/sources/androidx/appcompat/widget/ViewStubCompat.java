package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ViewStubCompat extends View {

    /* renamed from: a */
    public int f2653a;

    /* renamed from: b */
    public int f2654b;

    /* renamed from: c */
    public WeakReference<View> f2655c;

    /* renamed from: d */
    public LayoutInflater f2656d;

    /* renamed from: f */
    public InterfaceC0703a f2657f;

    /* renamed from: androidx.appcompat.widget.ViewStubCompat$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0703a {
        /* renamed from: a */
        void m1585a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* renamed from: a */
    public View m1586a() {
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            if (this.f2653a != 0) {
                ViewGroup viewGroup = (ViewGroup) parent;
                LayoutInflater layoutInflater = this.f2656d;
                if (layoutInflater == null) {
                    layoutInflater = LayoutInflater.from(getContext());
                }
                View inflate = layoutInflater.inflate(this.f2653a, viewGroup, false);
                int i = this.f2654b;
                if (i != -1) {
                    inflate.setId(i);
                }
                int indexOfChild = viewGroup.indexOfChild(this);
                viewGroup.removeViewInLayout(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams != null) {
                    viewGroup.addView(inflate, indexOfChild, layoutParams);
                } else {
                    viewGroup.addView(inflate, indexOfChild);
                }
                this.f2655c = new WeakReference<>(inflate);
                InterfaceC0703a interfaceC0703a = this.f2657f;
                if (interfaceC0703a != null) {
                    interfaceC0703a.m1585a(this, inflate);
                }
                return inflate;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f2654b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2656d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f2653a = i;
    }

    public void setOnInflateListener(InterfaceC0703a interfaceC0703a) {
        this.f2657f = interfaceC0703a;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.f2655c;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m1586a();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2653a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2012o.ViewStubCompat, i, 0);
        this.f2654b = obtainStyledAttributes.getResourceId(C2012o.ViewStubCompat_android_inflatedId, -1);
        this.f2653a = obtainStyledAttributes.getResourceId(C2012o.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C2012o.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
