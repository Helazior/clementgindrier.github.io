package p000;

import android.view.View;
import android.view.Window;

/* renamed from: c1 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class View$OnClickListenerC0981c1 implements View.OnClickListener {

    /* renamed from: a */
    public final C1596d0 f3747a;

    /* renamed from: b */
    public final /* synthetic */ C1597d1 f3748b;

    public View$OnClickListenerC0981c1(C1597d1 c1597d1) {
        this.f3748b = c1597d1;
        this.f3747a = new C1596d0(c1597d1.f3957a.getContext(), 0, 16908332, 0, c1597d1.f3965i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C1597d1 c1597d1 = this.f3748b;
        Window.Callback callback = c1597d1.f3968l;
        if (callback == null || !c1597d1.f3969m) {
            return;
        }
        callback.onMenuItemSelected(0, this.f3747a);
    }
}
