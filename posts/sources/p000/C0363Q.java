package p000;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import p000.C0321O;

@SuppressLint({"RestrictedAPI"})
/* renamed from: Q */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0363Q extends C0321O {

    /* renamed from: o */
    public C0364a f1244o;

    /* renamed from: p */
    public boolean f1245p;

    /* renamed from: Q$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0364a extends C0321O.AbstractC0324c {

        /* renamed from: J */
        public int[][] f1246J;

        public C0364a(C0364a c0364a, C0363Q c0363q, Resources resources) {
            super(c0364a, c0363q, resources);
            if (c0364a != null) {
                this.f1246J = c0364a.f1246J;
            } else {
                this.f1246J = new int[this.f1082g.length];
            }
        }

        @Override // p000.C0321O.AbstractC0324c
        /* renamed from: e */
        public void mo2144e() {
            int[][] iArr = this.f1246J;
            int[][] iArr2 = new int[iArr.length];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.f1246J;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.f1246J = iArr2;
        }

        /* renamed from: g */
        public int m2143g(int[] iArr) {
            int[][] iArr2 = this.f1246J;
            int i = this.f1083h;
            for (int i2 = 0; i2 < i; i2++) {
                if (StateSet.stateSetMatches(iArr2[i2], iArr)) {
                    return i2;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C0363Q(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0363Q(this, resources);
        }
    }

    public C0363Q(C0364a c0364a, Resources resources) {
        mo2146e(new C0364a(c0364a, this, resources));
        onStateChange(getState());
    }

    @Override // p000.C0321O, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // p000.C0321O
    /* renamed from: e */
    public void mo2146e(C0321O.AbstractC0324c abstractC0324c) {
        this.f1053a = abstractC0324c;
        int i = this.f1059h;
        if (i >= 0) {
            Drawable m2167d = abstractC0324c.m2167d(i);
            this.f1055c = m2167d;
            if (m2167d != null) {
                m2172c(m2167d);
            }
        }
        this.f1056d = null;
        if (abstractC0324c instanceof C0364a) {
            this.f1244o = (C0364a) abstractC0324c;
        }
    }

    @Override // p000.C0321O
    /* renamed from: f */
    public C0364a mo2147b() {
        return new C0364a(this.f1244o, this, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // p000.C0321O, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1245p) {
            super.mutate();
            if (this == this) {
                this.f1244o.mo2144e();
                this.f1245p = true;
            }
        }
        return this;
    }

    @Override // p000.C0321O, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int m2143g = this.f1244o.m2143g(iArr);
        if (m2143g < 0) {
            m2143g = this.f1244o.m2143g(StateSet.WILD_CARD);
        }
        return m2171d(m2143g) || onStateChange;
    }

    public C0363Q(C0364a c0364a) {
    }
}
