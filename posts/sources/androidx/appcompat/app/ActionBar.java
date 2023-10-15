package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import p000.AbstractC0485V;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ActionBar {

    /* renamed from: androidx.appcompat.app.ActionBar$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0629a {
        /* renamed from: a */
        void m1699a(boolean z);
    }

    @Deprecated
    /* renamed from: androidx.appcompat.app.ActionBar$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0630b {
        /* renamed from: a */
        public abstract CharSequence m1698a();

        /* renamed from: b */
        public abstract View m1697b();

        /* renamed from: c */
        public abstract Drawable m1696c();

        /* renamed from: d */
        public abstract CharSequence m1695d();

        /* renamed from: e */
        public abstract void m1694e();
    }

    /* renamed from: a */
    public boolean mo1720a() {
        return false;
    }

    /* renamed from: b */
    public abstract boolean mo1719b();

    /* renamed from: c */
    public abstract void mo1718c(boolean z);

    /* renamed from: d */
    public abstract int mo1717d();

    /* renamed from: e */
    public abstract Context mo1716e();

    /* renamed from: f */
    public boolean mo1715f() {
        return false;
    }

    /* renamed from: g */
    public abstract void mo1714g(Configuration configuration);

    /* renamed from: h */
    public void mo1713h() {
    }

    /* renamed from: i */
    public abstract boolean mo1712i(int i, KeyEvent keyEvent);

    /* renamed from: j */
    public boolean mo1711j(KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: k */
    public boolean mo1710k() {
        return false;
    }

    /* renamed from: l */
    public abstract void mo1709l(boolean z);

    /* renamed from: m */
    public abstract void mo1708m(boolean z);

    /* renamed from: n */
    public abstract void mo1707n(boolean z);

    /* renamed from: o */
    public abstract void mo1706o(boolean z);

    /* renamed from: p */
    public abstract void mo1705p(int i);

    /* renamed from: q */
    public abstract void mo1704q(boolean z);

    /* renamed from: r */
    public abstract void mo1703r(boolean z);

    /* renamed from: s */
    public abstract void mo1702s(int i);

    /* renamed from: t */
    public abstract void mo1701t(CharSequence charSequence);

    /* renamed from: u */
    public AbstractC0485V mo1700u(AbstractC0485V.InterfaceC0486a interfaceC0486a) {
        return null;
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a */
        public int f2214a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2214a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2012o.ActionBarLayout);
            this.f2214a = obtainStyledAttributes.getInt(C2012o.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2214a = 0;
            this.f2214a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f2214a = 0;
            this.f2214a = layoutParams.f2214a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2214a = 0;
        }
    }
}
