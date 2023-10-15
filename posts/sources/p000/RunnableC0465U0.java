package p000;

import android.view.View;
import androidx.appcompat.widget.ScrollingTabContainerView;

/* renamed from: U0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class RunnableC0465U0 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ View f1620a;

    /* renamed from: b */
    public final /* synthetic */ ScrollingTabContainerView f1621b;

    public RunnableC0465U0(ScrollingTabContainerView scrollingTabContainerView, View view) {
        this.f1621b = scrollingTabContainerView;
        this.f1620a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1621b.smoothScrollTo(this.f1620a.getLeft() - ((this.f1621b.getWidth() - this.f1620a.getWidth()) / 2), 0);
        this.f1621b.f2551a = null;
    }
}
