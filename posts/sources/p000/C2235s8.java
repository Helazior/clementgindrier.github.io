package p000;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* renamed from: s8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C2235s8 extends ViewPager2.AbstractC0942g {

    /* renamed from: a */
    public final LinearLayoutManager f6395a;

    /* renamed from: b */
    public ViewPager2.InterfaceC0947i f6396b;

    public C2235s8(LinearLayoutManager linearLayoutManager) {
        this.f6395a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0942g
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0942g
    public void onPageScrolled(int i, float f, int i2) {
        if (this.f6396b == null) {
            return;
        }
        float f2 = -f;
        for (int i3 = 0; i3 < this.f6395a.getChildCount(); i3++) {
            View childAt = this.f6395a.getChildAt(i3);
            if (childAt != null) {
                this.f6396b.m1216a(childAt, (this.f6395a.getPosition(childAt) - i) + f2);
            } else {
                throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.f6395a.getChildCount())));
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.AbstractC0942g
    public void onPageSelected(int i) {
    }
}
