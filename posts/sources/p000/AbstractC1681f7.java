package p000;

import androidx.recyclerview.widget.RecyclerView;
import p000.C0454T6;

/* renamed from: f7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC1681f7 extends RecyclerView.AbstractC0837l {

    /* renamed from: g */
    public boolean f4180g = true;

    @Override // androidx.recyclerview.widget.RecyclerView.AbstractC0837l
    /* renamed from: a */
    public boolean mo986a(RecyclerView.AbstractC0824B abstractC0824B, RecyclerView.AbstractC0824B abstractC0824B2, RecyclerView.AbstractC0837l.C0840c c0840c, RecyclerView.AbstractC0837l.C0840c c0840c2) {
        int i;
        int i2;
        int i3 = c0840c.f3234a;
        int i4 = c0840c.f3235b;
        if (abstractC0824B2.shouldIgnore()) {
            int i5 = c0840c.f3234a;
            i2 = c0840c.f3235b;
            i = i5;
        } else {
            i = c0840c2.f3234a;
            i2 = c0840c2.f3235b;
        }
        C0454T6 c0454t6 = (C0454T6) this;
        if (abstractC0824B == abstractC0824B2) {
            return c0454t6.mo985i(abstractC0824B, i3, i4, i, i2);
        }
        float translationX = abstractC0824B.itemView.getTranslationX();
        float translationY = abstractC0824B.itemView.getTranslationY();
        float alpha = abstractC0824B.itemView.getAlpha();
        c0454t6.m2003n(abstractC0824B);
        abstractC0824B.itemView.setTranslationX(translationX);
        abstractC0824B.itemView.setTranslationY(translationY);
        abstractC0824B.itemView.setAlpha(alpha);
        c0454t6.m2003n(abstractC0824B2);
        abstractC0824B2.itemView.setTranslationX(-((int) ((i - i3) - translationX)));
        abstractC0824B2.itemView.setTranslationY(-((int) ((i2 - i4) - translationY)));
        abstractC0824B2.itemView.setAlpha(0.0f);
        c0454t6.f1575k.add(new C0454T6.C0455a(abstractC0824B, abstractC0824B2, i3, i4, i, i2));
        return true;
    }

    /* renamed from: i */
    public abstract boolean mo985i(RecyclerView.AbstractC0824B abstractC0824B, int i, int i2, int i3, int i4);
}
