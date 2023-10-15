package p000;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* renamed from: y7 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C2386y7 extends FrameLayout {

    /* renamed from: c */
    public static final /* synthetic */ int f6877c = 0;

    /* renamed from: a */
    public ViewGroup f6878a;

    /* renamed from: b */
    public boolean f6879b;

    public C2386y7(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f6878a = viewGroup;
        viewGroup.setTag(C0090D7.ghost_view_holder, this);
        this.f6878a.getOverlay().add(this);
        this.f6879b = true;
    }

    /* renamed from: a */
    public static void m50a(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            m50a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (this.f6879b) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f6878a.setTag(C0090D7.ghost_view_holder, null);
            this.f6878a.getOverlay().remove(this);
            this.f6879b = false;
        }
    }
}
