package p000;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.p019v1.XmlPullParser;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: d8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1623d8 extends AbstractC1842g8 implements Animatable {

    /* renamed from: b */
    public C1625b f4009b;

    /* renamed from: c */
    public Context f4010c;

    /* renamed from: d */
    public ArgbEvaluator f4011d;

    /* renamed from: f */
    public final Drawable.Callback f4012f;

    /* renamed from: d8$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1624a implements Drawable.Callback {
        public C1624a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            C1623d8.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            C1623d8.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            C1623d8.this.unscheduleSelf(runnable);
        }
    }

    /* renamed from: d8$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1625b extends Drawable.ConstantState {

        /* renamed from: a */
        public int f4014a;

        /* renamed from: b */
        public C1865h8 f4015b;

        /* renamed from: c */
        public AnimatorSet f4016c;

        /* renamed from: d */
        public ArrayList<Animator> f4017d;

        /* renamed from: e */
        public C2339x1<Animator, String> f4018e;

        public C1625b(C1625b c1625b, Drawable.Callback callback, Resources resources) {
            if (c1625b != null) {
                this.f4014a = c1625b.f4014a;
                C1865h8 c1865h8 = c1625b.f4015b;
                if (c1865h8 != null) {
                    Drawable.ConstantState constantState = c1865h8.getConstantState();
                    if (resources != null) {
                        this.f4015b = (C1865h8) constantState.newDrawable(resources);
                    } else {
                        this.f4015b = (C1865h8) constantState.newDrawable();
                    }
                    C1865h8 c1865h82 = this.f4015b;
                    c1865h82.mutate();
                    this.f4015b = c1865h82;
                    c1865h82.setCallback(callback);
                    this.f4015b.setBounds(c1625b.f4015b.getBounds());
                    this.f4015b.f5155g = false;
                }
                ArrayList<Animator> arrayList = c1625b.f4017d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f4017d = new ArrayList<>(size);
                    this.f4018e = new C2339x1<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = c1625b.f4017d.get(i);
                        Animator clone = animator.clone();
                        String str = c1625b.f4018e.get(animator);
                        clone.setTarget(this.f4015b.f5151b.f5206b.f5204p.get(str));
                        this.f4017d.add(clone);
                        this.f4018e.put(clone, str);
                    }
                    if (this.f4016c == null) {
                        this.f4016c = new AnimatorSet();
                    }
                    this.f4016c.playTogether(this.f4017d);
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4014a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public C1623d8() {
        this(null, null, null);
    }

    @Override // p000.AbstractC1842g8, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.applyTheme(theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f4009b.f4015b.draw(canvas);
        if (this.f4009b.f4016c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getAlpha();
        }
        return this.f4009b.f4015b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4009b.f4014a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getColorFilter();
        }
        return this.f4009b.f4015b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f5086a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C1626c(this.f5086a.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f4009b.f4015b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f4009b.f4015b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f4009b.f4015b.getOpacity();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00a2  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void inflate(android.content.res.Resources r21, org.xmlpull.p019v1.XmlPullParser r22, android.util.AttributeSet r23, android.content.res.Resources.Theme r24) {
        /*
            Method dump skipped, instructions count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1623d8.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):void");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.isAutoMirrored();
        }
        return this.f4009b.f4015b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f4009b.f4016c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f4009b.f4015b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f4009b.f4015b.setBounds(rect);
        }
    }

    @Override // p000.AbstractC1842g8, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return this.f4009b.f4015b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f4009b.f4015b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else {
            this.f4009b.f4015b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.setAutoMirrored(z);
            return;
        }
        C1865h8 c1865h8 = this.f4009b.f4015b;
        Drawable drawable2 = c1865h8.f5086a;
        if (drawable2 != null) {
            drawable2.setAutoMirrored(z);
        } else {
            c1865h8.f5151b.f5209e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        C1865h8 c1865h8 = this.f4009b.f4015b;
        Drawable drawable2 = c1865h8.f5086a;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
            return;
        }
        c1865h8.f5153d = colorFilter;
        c1865h8.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            LayoutInflater$Factory2C0000A.C0010h.m2622o0(drawable, i);
        } else {
            this.f4009b.f4015b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            LayoutInflater$Factory2C0000A.C0010h.m2620p0(drawable, colorStateList);
        } else {
            this.f4009b.f4015b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            LayoutInflater$Factory2C0000A.C0010h.m2618q0(drawable, mode);
        } else {
            this.f4009b.f4015b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        this.f4009b.f4015b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (this.f4009b.f4016c.isStarted()) {
        } else {
            this.f4009b.f4016c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f5086a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f4009b.f4016c.end();
        }
    }

    public C1623d8(Context context, C1625b c1625b, Resources resources) {
        this.f4011d = null;
        C1624a c1624a = new C1624a();
        this.f4012f = c1624a;
        this.f4010c = context;
        this.f4009b = new C1625b(null, c1624a, null);
    }

    /* renamed from: d8$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1626c extends Drawable.ConstantState {

        /* renamed from: a */
        public final Drawable.ConstantState f4019a;

        public C1626c(Drawable.ConstantState constantState) {
            this.f4019a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4019a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4019a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C1623d8 c1623d8 = new C1623d8(null, null, null);
            Drawable newDrawable = this.f4019a.newDrawable();
            c1623d8.f5086a = newDrawable;
            newDrawable.setCallback(c1623d8.f4012f);
            return c1623d8;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            C1623d8 c1623d8 = new C1623d8(null, null, null);
            Drawable newDrawable = this.f4019a.newDrawable(resources);
            c1623d8.f5086a = newDrawable;
            newDrawable.setCallback(c1623d8.f4012f);
            return c1623d8;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C1623d8 c1623d8 = new C1623d8(null, null, null);
            Drawable newDrawable = this.f4019a.newDrawable(resources, theme);
            c1623d8.f5086a = newDrawable;
            newDrawable.setCallback(c1623d8.f4012f);
            return c1623d8;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
