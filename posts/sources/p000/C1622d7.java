package p000;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: d7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1622d7 extends AbstractC1840g7 {

    /* renamed from: c */
    public AbstractC0971b7 f4007c;

    /* renamed from: d */
    public AbstractC0971b7 f4008d;

    @Override // p000.AbstractC1840g7
    /* renamed from: b */
    public int[] mo794b(RecyclerView.AbstractC0843o abstractC0843o, View view) {
        int[] iArr = new int[2];
        if (abstractC0843o.canScrollHorizontally()) {
            iArr[0] = m1011e(view, m1009g(abstractC0843o));
        } else {
            iArr[0] = 0;
        }
        if (abstractC0843o.canScrollVertically()) {
            iArr[1] = m1011e(view, m1008h(abstractC0843o));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // p000.AbstractC1840g7
    /* renamed from: c */
    public View mo793c(RecyclerView.AbstractC0843o abstractC0843o) {
        if (abstractC0843o.canScrollVertically()) {
            return m1010f(abstractC0843o, m1008h(abstractC0843o));
        }
        if (abstractC0843o.canScrollHorizontally()) {
            return m1010f(abstractC0843o, m1009g(abstractC0843o));
        }
        return null;
    }

    /* renamed from: e */
    public final int m1011e(View view, AbstractC0971b7 abstractC0971b7) {
        return ((abstractC0971b7.mo1159c(view) / 2) + abstractC0971b7.mo1157e(view)) - ((abstractC0971b7.mo1150l() / 2) + abstractC0971b7.mo1151k());
    }

    /* renamed from: f */
    public final View m1010f(RecyclerView.AbstractC0843o abstractC0843o, AbstractC0971b7 abstractC0971b7) {
        int childCount = abstractC0843o.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int mo1150l = (abstractC0971b7.mo1150l() / 2) + abstractC0971b7.mo1151k();
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = abstractC0843o.getChildAt(i2);
            int abs = Math.abs(((abstractC0971b7.mo1159c(childAt) / 2) + abstractC0971b7.mo1157e(childAt)) - mo1150l);
            if (abs < i) {
                view = childAt;
                i = abs;
            }
        }
        return view;
    }

    /* renamed from: g */
    public final AbstractC0971b7 m1009g(RecyclerView.AbstractC0843o abstractC0843o) {
        AbstractC0971b7 abstractC0971b7 = this.f4008d;
        if (abstractC0971b7 == null || abstractC0971b7.f3712a != abstractC0843o) {
            this.f4008d = new C0590Z6(abstractC0843o);
        }
        return this.f4008d;
    }

    /* renamed from: h */
    public final AbstractC0971b7 m1008h(RecyclerView.AbstractC0843o abstractC0843o) {
        AbstractC0971b7 abstractC0971b7 = this.f4007c;
        if (abstractC0971b7 == null || abstractC0971b7.f3712a != abstractC0843o) {
            this.f4007c = new C0611a7(abstractC0843o);
        }
        return this.f4007c;
    }
}
