package p000;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* renamed from: u8 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2276u8 implements RecyclerView.InterfaceC0848p {
    public C2276u8(ViewPager2 viewPager2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0848p
    /* renamed from: a */
    public void mo298a(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.InterfaceC0848p
    /* renamed from: b */
    public void mo297b(View view) {
    }
}
