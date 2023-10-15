package p000;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import p000.C0321O;
import p000.C0363Q;

@SuppressLint({"RestrictedAPI"})
/* renamed from: N */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0298N extends C0363Q implements InterfaceC0395R3 {

    /* renamed from: q */
    public C0301c f1000q;

    /* renamed from: r */
    public AbstractC0305g f1001r;

    /* renamed from: s */
    public int f1002s;

    /* renamed from: t */
    public int f1003t;

    /* renamed from: u */
    public boolean f1004u;

    /* renamed from: N$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0300b extends AbstractC0305g {

        /* renamed from: a */
        public final Animatable f1005a;

        public C0300b(Animatable animatable) {
            super(null);
            this.f1005a = animatable;
        }

        @Override // p000.C0298N.AbstractC0305g
        /* renamed from: c */
        public void mo2187c() {
            this.f1005a.start();
        }

        @Override // p000.C0298N.AbstractC0305g
        /* renamed from: d */
        public void mo2186d() {
            this.f1005a.stop();
        }
    }

    /* renamed from: N$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0301c extends C0363Q.C0364a {

        /* renamed from: K */
        public C0034B1<Long> f1006K;

        /* renamed from: L */
        public C0127F1<Integer> f1007L;

        public C0301c(C0301c c0301c, C0298N c0298n, Resources resources) {
            super(c0301c, c0298n, resources);
            if (c0301c != null) {
                this.f1006K = c0301c.f1006K;
                this.f1007L = c0301c.f1007L;
                return;
            }
            this.f1006K = new C0034B1<>();
            this.f1007L = new C0127F1<>(10);
        }

        /* renamed from: h */
        public static long m2191h(int i, int i2) {
            return i2 | (i << 32);
        }

        @Override // p000.C0363Q.C0364a, p000.C0321O.AbstractC0324c
        /* renamed from: e */
        public void mo2144e() {
            this.f1006K = this.f1006K.clone();
            this.f1007L = this.f1007L.clone();
        }

        /* renamed from: i */
        public int m2190i(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f1007L.m2452e(i, 0).intValue();
        }

        @Override // p000.C0363Q.C0364a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C0298N(this, null);
        }

        @Override // p000.C0363Q.C0364a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0298N(this, resources);
        }
    }

    /* renamed from: N$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0302d extends AbstractC0305g {

        /* renamed from: a */
        public final C1623d8 f1008a;

        public C0302d(C1623d8 c1623d8) {
            super(null);
            this.f1008a = c1623d8;
        }

        @Override // p000.C0298N.AbstractC0305g
        /* renamed from: c */
        public void mo2187c() {
            this.f1008a.start();
        }

        @Override // p000.C0298N.AbstractC0305g
        /* renamed from: d */
        public void mo2186d() {
            this.f1008a.stop();
        }
    }

    /* renamed from: N$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0303e extends AbstractC0305g {

        /* renamed from: a */
        public final ObjectAnimator f1009a;

        /* renamed from: b */
        public final boolean f1010b;

        public C0303e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super(null);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            C0304f c0304f = new C0304f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            ofInt.setAutoCancel(true);
            ofInt.setDuration(c0304f.f1013c);
            ofInt.setInterpolator(c0304f);
            this.f1010b = z2;
            this.f1009a = ofInt;
        }

        @Override // p000.C0298N.AbstractC0305g
        /* renamed from: a */
        public boolean mo2189a() {
            return this.f1010b;
        }

        @Override // p000.C0298N.AbstractC0305g
        /* renamed from: b */
        public void mo2188b() {
            this.f1009a.reverse();
        }

        @Override // p000.C0298N.AbstractC0305g
        /* renamed from: c */
        public void mo2187c() {
            this.f1009a.start();
        }

        @Override // p000.C0298N.AbstractC0305g
        /* renamed from: d */
        public void mo2186d() {
            this.f1009a.cancel();
        }
    }

    /* renamed from: N$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0304f implements TimeInterpolator {

        /* renamed from: a */
        public int[] f1011a;

        /* renamed from: b */
        public int f1012b;

        /* renamed from: c */
        public int f1013c;

        public C0304f(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f1012b = numberOfFrames;
            int[] iArr = this.f1011a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f1011a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f1011a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f1013c = i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.f1013c) + 0.5f);
            int i2 = this.f1012b;
            int[] iArr = this.f1011a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.f1013c : 0.0f);
        }
    }

    /* renamed from: N$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static abstract class AbstractC0305g {
        public AbstractC0305g(C0299a c0299a) {
        }

        /* renamed from: a */
        public boolean mo2189a() {
            return false;
        }

        /* renamed from: b */
        public void mo2188b() {
        }

        /* renamed from: c */
        public abstract void mo2187c();

        /* renamed from: d */
        public abstract void mo2186d();
    }

    public C0298N() {
        this(null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0207, code lost:
        throw new org.xmlpull.p019v1.XmlPullParserException(p000.outline.m255p(r20, new java.lang.StringBuilder(), ": <transition> tag requires 'fromId' & 'toId' attributes"));
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static p000.C0298N m2192g(android.content.Context r18, android.content.res.Resources r19, org.xmlpull.p019v1.XmlPullParser r20, android.util.AttributeSet r21, android.content.res.Resources.Theme r22) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0298N.m2192g(android.content.Context, android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):N");
    }

    @Override // p000.C0363Q, p000.C0321O
    /* renamed from: b */
    public C0321O.AbstractC0324c mo2147b() {
        return new C0301c(this.f1000q, this, null);
    }

    @Override // p000.C0363Q, p000.C0321O
    /* renamed from: e */
    public void mo2146e(C0321O.AbstractC0324c abstractC0324c) {
        super.mo2146e(abstractC0324c);
        if (abstractC0324c instanceof C0301c) {
            this.f1000q = (C0301c) abstractC0324c;
        }
    }

    @Override // p000.C0363Q
    /* renamed from: f */
    public C0363Q.C0364a mo2145f() {
        return new C0301c(this.f1000q, this, null);
    }

    @Override // p000.C0363Q, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // p000.C0321O, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        AbstractC0305g abstractC0305g = this.f1001r;
        if (abstractC0305g != null) {
            abstractC0305g.mo2186d();
            this.f1001r = null;
            m2171d(this.f1002s);
            this.f1002s = -1;
            this.f1003t = -1;
        }
    }

    @Override // p000.C0363Q, p000.C0321O, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1004u) {
            super.mutate();
            if (this == this) {
                this.f1000q.mo2144e();
                this.f1004u = true;
            }
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00eb  */
    @Override // p000.C0363Q, p000.C0321O, android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onStateChange(int[] r19) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0298N.onStateChange(int[]):boolean");
    }

    @Override // p000.C0321O, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        AbstractC0305g abstractC0305g = this.f1001r;
        if (abstractC0305g != null && (visible || z2)) {
            if (z) {
                abstractC0305g.mo2187c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public C0298N(C0301c c0301c, Resources resources) {
        super(null);
        this.f1002s = -1;
        this.f1003t = -1;
        C0301c c0301c2 = new C0301c(c0301c, this, resources);
        super.mo2146e(c0301c2);
        this.f1000q = c0301c2;
        onStateChange(getState());
        jumpToCurrentState();
    }
}
