package p000;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/* renamed from: q8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2197q8 extends ViewPager2.AbstractC0942g {

    /* renamed from: a */
    public final List<ViewPager2.AbstractC0942g> f6294a;

    public C2197q8(int i) {
        this.f6294a = new ArrayList(i);
    }

    /* renamed from: a */
    public final void m424a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0942g
    public void onPageScrollStateChanged(int i) {
        try {
            for (ViewPager2.AbstractC0942g abstractC0942g : this.f6294a) {
                abstractC0942g.onPageScrollStateChanged(i);
            }
        } catch (ConcurrentModificationException e) {
            m424a(e);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0942g
    public void onPageScrolled(int i, float f, int i2) {
        try {
            for (ViewPager2.AbstractC0942g abstractC0942g : this.f6294a) {
                abstractC0942g.onPageScrolled(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            m424a(e);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0942g
    public void onPageSelected(int i) {
        try {
            for (ViewPager2.AbstractC0942g abstractC0942g : this.f6294a) {
                abstractC0942g.onPageSelected(i);
            }
        } catch (ConcurrentModificationException e) {
            m424a(e);
            throw null;
        }
    }
}
