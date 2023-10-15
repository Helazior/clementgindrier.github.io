package p000;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.widget.ActionMenuPresenter;
import p000.InterfaceC2165p0;

/* renamed from: G4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class AbstractC0148G4 {

    /* renamed from: a */
    public InterfaceC0149a f495a;

    /* renamed from: b */
    public InterfaceC0150b f496b;

    /* renamed from: G4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0149a {
    }

    /* renamed from: G4$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0150b {
    }

    public AbstractC0148G4(Context context) {
    }

    /* renamed from: a */
    public boolean mo607a() {
        return false;
    }

    /* renamed from: b */
    public boolean mo603b() {
        return true;
    }

    /* renamed from: c */
    public abstract View mo606c();

    /* renamed from: d */
    public View mo602d(MenuItem menuItem) {
        return mo606c();
    }

    /* renamed from: e */
    public boolean mo605e() {
        return false;
    }

    /* renamed from: f */
    public void mo604f(SubMenu subMenu) {
    }

    /* renamed from: g */
    public boolean mo601g() {
        return false;
    }

    /* renamed from: h */
    public void mo600h(InterfaceC0150b interfaceC0150b) {
        if (this.f496b != null) {
            StringBuilder m253r = outline.m253r("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            m253r.append(getClass().getSimpleName());
            m253r.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", m253r.toString());
        }
        this.f496b = interfaceC0150b;
    }

    /* renamed from: i */
    public void m2428i(boolean z) {
        InterfaceC0149a interfaceC0149a = this.f495a;
        if (interfaceC0149a != null) {
            ActionMenuPresenter actionMenuPresenter = (ActionMenuPresenter) interfaceC0149a;
            if (z) {
                InterfaceC2165p0.InterfaceC2166a interfaceC2166a = actionMenuPresenter.f4102f;
                if (interfaceC2166a != null) {
                    interfaceC2166a.mo458a(actionMenuPresenter.f4100c);
                    return;
                }
                return;
            }
            C1905j0 c1905j0 = actionMenuPresenter.f4100c;
            if (c1905j0 != null) {
                c1905j0.close(false);
            }
        }
    }
}
