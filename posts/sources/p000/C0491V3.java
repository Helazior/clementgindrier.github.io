package p000;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* renamed from: V3 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0491V3 extends Drawable.ConstantState {

    /* renamed from: a */
    public int f1794a;

    /* renamed from: b */
    public Drawable.ConstantState f1795b;

    /* renamed from: c */
    public ColorStateList f1796c;

    /* renamed from: d */
    public PorterDuff.Mode f1797d;

    public C0491V3(C0491V3 c0491v3) {
        this.f1796c = null;
        this.f1797d = C0451T3.f1552h;
        if (c0491v3 != null) {
            this.f1794a = c0491v3.f1794a;
            this.f1795b = c0491v3.f1795b;
            this.f1796c = c0491v3.f1796c;
            this.f1797d = c0491v3.f1797d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.f1794a;
        Drawable.ConstantState constantState = this.f1795b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return new C0469U3(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        return new C0469U3(this, resources);
    }
}
