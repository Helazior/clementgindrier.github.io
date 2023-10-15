package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: a7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0611a7 extends AbstractC0971b7 {
    public C0611a7(RecyclerView.AbstractC0843o abstractC0843o) {
        super(abstractC0843o, null);
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: b */
    public int mo1160b(View view) {
        return this.f3712a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: c */
    public int mo1159c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f3712a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: d */
    public int mo1158d(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f3712a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: e */
    public int mo1157e(View view) {
        return this.f3712a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: f */
    public int mo1156f() {
        return this.f3712a.getHeight();
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: g */
    public int mo1155g() {
        return this.f3712a.getHeight() - this.f3712a.getPaddingBottom();
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: h */
    public int mo1154h() {
        return this.f3712a.getPaddingBottom();
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: i */
    public int mo1153i() {
        return this.f3712a.getHeightMode();
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: j */
    public int mo1152j() {
        return this.f3712a.getWidthMode();
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: k */
    public int mo1151k() {
        return this.f3712a.getPaddingTop();
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: l */
    public int mo1150l() {
        return (this.f3712a.getHeight() - this.f3712a.getPaddingTop()) - this.f3712a.getPaddingBottom();
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: n */
    public int mo1148n(View view) {
        this.f3712a.getTransformedBoundingBox(view, true, this.f3714c);
        return this.f3714c.bottom;
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: o */
    public int mo1147o(View view) {
        this.f3712a.getTransformedBoundingBox(view, true, this.f3714c);
        return this.f3714c.top;
    }

    @Override // p000.AbstractC0971b7
    /* renamed from: p */
    public void mo1146p(int i) {
        this.f3712a.offsetChildrenVertical(i);
    }
}
