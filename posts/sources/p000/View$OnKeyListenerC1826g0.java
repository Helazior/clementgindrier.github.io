package p000;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.widget.MenuPopupWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.InterfaceC2165p0;

/* renamed from: g0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class View$OnKeyListenerC1826g0 extends AbstractC1989n0 implements InterfaceC2165p0, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: C */
    public static final int f5034C = C1949l.abc_cascading_menu_item_layout;

    /* renamed from: A */
    public PopupWindow.OnDismissListener f5035A;

    /* renamed from: B */
    public boolean f5036B;

    /* renamed from: b */
    public final Context f5037b;

    /* renamed from: c */
    public final int f5038c;

    /* renamed from: d */
    public final int f5039d;

    /* renamed from: f */
    public final int f5040f;

    /* renamed from: g */
    public final boolean f5041g;

    /* renamed from: h */
    public final Handler f5042h;

    /* renamed from: p */
    public View f5050p;

    /* renamed from: q */
    public View f5051q;

    /* renamed from: r */
    public int f5052r;

    /* renamed from: s */
    public boolean f5053s;

    /* renamed from: t */
    public boolean f5054t;

    /* renamed from: u */
    public int f5055u;

    /* renamed from: v */
    public int f5056v;

    /* renamed from: x */
    public boolean f5058x;

    /* renamed from: y */
    public InterfaceC2165p0.InterfaceC2166a f5059y;

    /* renamed from: z */
    public ViewTreeObserver f5060z;

    /* renamed from: i */
    public final List<C1905j0> f5043i = new ArrayList();

    /* renamed from: j */
    public final List<C1831d> f5044j = new ArrayList();

    /* renamed from: k */
    public final ViewTreeObserver.OnGlobalLayoutListener f5045k = new ViewTreeObserver$OnGlobalLayoutListenerC1827a();

    /* renamed from: l */
    public final View.OnAttachStateChangeListener f5046l = new View$OnAttachStateChangeListenerC1828b();

    /* renamed from: m */
    public final InterfaceC0365Q0 f5047m = new C1829c();

    /* renamed from: n */
    public int f5048n = 0;

    /* renamed from: o */
    public int f5049o = 0;

    /* renamed from: w */
    public boolean f5057w = false;

    /* renamed from: g0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC1827a implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserver$OnGlobalLayoutListenerC1827a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!View$OnKeyListenerC1826g0.this.mo394a() || View$OnKeyListenerC1826g0.this.f5044j.size() <= 0 || View$OnKeyListenerC1826g0.this.f5044j.get(0).f5068a.f2539z) {
                return;
            }
            View view = View$OnKeyListenerC1826g0.this.f5051q;
            if (view != null && view.isShown()) {
                for (C1831d c1831d : View$OnKeyListenerC1826g0.this.f5044j) {
                    c1831d.f5068a.show();
                }
                return;
            }
            View$OnKeyListenerC1826g0.this.dismiss();
        }
    }

    /* renamed from: g0$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnAttachStateChangeListenerC1828b implements View.OnAttachStateChangeListener {
        public View$OnAttachStateChangeListenerC1828b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = View$OnKeyListenerC1826g0.this.f5060z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    View$OnKeyListenerC1826g0.this.f5060z = view.getViewTreeObserver();
                }
                View$OnKeyListenerC1826g0 view$OnKeyListenerC1826g0 = View$OnKeyListenerC1826g0.this;
                view$OnKeyListenerC1826g0.f5060z.removeGlobalOnLayoutListener(view$OnKeyListenerC1826g0.f5045k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* renamed from: g0$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C1829c implements InterfaceC0365Q0 {

        /* renamed from: g0$c$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class RunnableC1830a implements Runnable {

            /* renamed from: a */
            public final /* synthetic */ C1831d f5064a;

            /* renamed from: b */
            public final /* synthetic */ MenuItem f5065b;

            /* renamed from: c */
            public final /* synthetic */ C1905j0 f5066c;

            public RunnableC1830a(C1831d c1831d, MenuItem menuItem, C1905j0 c1905j0) {
                this.f5064a = c1831d;
                this.f5065b = menuItem;
                this.f5066c = c1905j0;
            }

            @Override // java.lang.Runnable
            public void run() {
                C1831d c1831d = this.f5064a;
                if (c1831d != null) {
                    View$OnKeyListenerC1826g0.this.f5036B = true;
                    c1831d.f5069b.close(false);
                    View$OnKeyListenerC1826g0.this.f5036B = false;
                }
                if (this.f5065b.isEnabled() && this.f5065b.hasSubMenu()) {
                    this.f5066c.performItemAction(this.f5065b, 4);
                }
            }
        }

        public C1829c() {
        }

        @Override // p000.InterfaceC0365Q0
        /* renamed from: c */
        public void mo802c(C1905j0 c1905j0, MenuItem menuItem) {
            View$OnKeyListenerC1826g0.this.f5042h.removeCallbacksAndMessages(null);
            int size = View$OnKeyListenerC1826g0.this.f5044j.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (c1905j0 == View$OnKeyListenerC1826g0.this.f5044j.get(i).f5069b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            View$OnKeyListenerC1826g0.this.f5042h.postAtTime(new RunnableC1830a(i2 < View$OnKeyListenerC1826g0.this.f5044j.size() ? View$OnKeyListenerC1826g0.this.f5044j.get(i2) : null, menuItem, c1905j0), c1905j0, SystemClock.uptimeMillis() + 200);
        }

        @Override // p000.InterfaceC0365Q0
        /* renamed from: d */
        public void mo801d(C1905j0 c1905j0, MenuItem menuItem) {
            View$OnKeyListenerC1826g0.this.f5042h.removeCallbacksAndMessages(c1905j0);
        }
    }

    /* renamed from: g0$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1831d {

        /* renamed from: a */
        public final MenuPopupWindow f5068a;

        /* renamed from: b */
        public final C1905j0 f5069b;

        /* renamed from: c */
        public final int f5070c;

        public C1831d(MenuPopupWindow menuPopupWindow, C1905j0 c1905j0, int i) {
            this.f5068a = menuPopupWindow;
            this.f5069b = c1905j0;
            this.f5070c = i;
        }
    }

    public View$OnKeyListenerC1826g0(Context context, View view, int i, int i2, boolean z) {
        this.f5037b = context;
        this.f5050p = view;
        this.f5039d = i;
        this.f5040f = i2;
        this.f5041g = z;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        this.f5052r = C0492V4.C0496d.m1921d(view) != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f5038c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C1881i.abc_config_prefDialogWidth));
        this.f5042h = new Handler();
    }

    @Override // p000.InterfaceC2222s0
    /* renamed from: a */
    public boolean mo394a() {
        return this.f5044j.size() > 0 && this.f5044j.get(0).f5068a.mo394a();
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: b */
    public void mo393b(C1905j0 c1905j0) {
        c1905j0.addMenuPresenter(this, this.f5037b);
        if (mo394a()) {
            m803m(c1905j0);
        } else {
            this.f5043i.add(c1905j0);
        }
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: c */
    public boolean mo590c() {
        return false;
    }

    @Override // p000.InterfaceC2222s0
    public void dismiss() {
        int size = this.f5044j.size();
        if (size > 0) {
            C1831d[] c1831dArr = (C1831d[]) this.f5044j.toArray(new C1831d[size]);
            for (int i = size - 1; i >= 0; i--) {
                C1831d c1831d = c1831dArr[i];
                if (c1831d.f5068a.mo394a()) {
                    c1831d.f5068a.dismiss();
                }
            }
        }
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: e */
    public void mo392e(View view) {
        if (this.f5050p != view) {
            this.f5050p = view;
            int i = this.f5048n;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            this.f5049o = Gravity.getAbsoluteGravity(i, C0492V4.C0496d.m1921d(view));
        }
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: f */
    public void mo391f(boolean z) {
        this.f5057w = z;
    }

    @Override // p000.InterfaceC2165p0
    public boolean flagActionItems() {
        return false;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: g */
    public void mo390g(int i) {
        if (this.f5048n != i) {
            this.f5048n = i;
            View view = this.f5050p;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            this.f5049o = Gravity.getAbsoluteGravity(i, C0492V4.C0496d.m1921d(view));
        }
    }

    @Override // p000.InterfaceC2222s0
    public ListView getListView() {
        if (this.f5044j.isEmpty()) {
            return null;
        }
        List<C1831d> list = this.f5044j;
        return list.get(list.size() - 1).f5068a.f2517c;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: h */
    public void mo389h(int i) {
        this.f5053s = true;
        this.f5055u = i;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: i */
    public void mo388i(PopupWindow.OnDismissListener onDismissListener) {
        this.f5035A = onDismissListener;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: j */
    public void mo387j(boolean z) {
        this.f5058x = z;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: k */
    public void mo386k(int i) {
        this.f5054t = true;
        this.f5056v = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b4  */
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m803m(p000.C1905j0 r17) {
        /*
            Method dump skipped, instructions count: 533
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.View$OnKeyListenerC1826g0.m803m(j0):void");
    }

    @Override // p000.InterfaceC2165p0
    public void onCloseMenu(C1905j0 c1905j0, boolean z) {
        int size = this.f5044j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (c1905j0 == this.f5044j.get(i).f5069b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < this.f5044j.size()) {
            this.f5044j.get(i2).f5069b.close(false);
        }
        C1831d remove = this.f5044j.remove(i);
        remove.f5069b.removeMenuPresenter(this);
        if (this.f5036B) {
            MenuPopupWindow menuPopupWindow = remove.f5068a;
            Objects.requireNonNull(menuPopupWindow);
            if (Build.VERSION.SDK_INT >= 23) {
                menuPopupWindow.f2514A.setExitTransition(null);
            }
            remove.f5068a.f2514A.setAnimationStyle(0);
        }
        remove.f5068a.dismiss();
        int size2 = this.f5044j.size();
        if (size2 > 0) {
            this.f5052r = this.f5044j.get(size2 - 1).f5070c;
        } else {
            View view = this.f5050p;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            this.f5052r = C0492V4.C0496d.m1921d(view) == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                this.f5044j.get(0).f5069b.close(false);
                return;
            }
            return;
        }
        dismiss();
        InterfaceC2165p0.InterfaceC2166a interfaceC2166a = this.f5059y;
        if (interfaceC2166a != null) {
            interfaceC2166a.onCloseMenu(c1905j0, true);
        }
        ViewTreeObserver viewTreeObserver = this.f5060z;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f5060z.removeGlobalOnLayoutListener(this.f5045k);
            }
            this.f5060z = null;
        }
        this.f5051q.removeOnAttachStateChangeListener(this.f5046l);
        this.f5035A.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C1831d c1831d;
        int size = this.f5044j.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c1831d = null;
                break;
            }
            c1831d = this.f5044j.get(i);
            if (!c1831d.f5068a.mo394a()) {
                break;
            }
            i++;
        }
        if (c1831d != null) {
            c1831d.f5069b.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // p000.InterfaceC2165p0
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // p000.InterfaceC2165p0
    public boolean onSubMenuSelected(SubMenuC2267u0 subMenuC2267u0) {
        for (C1831d c1831d : this.f5044j) {
            if (subMenuC2267u0 == c1831d.f5069b) {
                c1831d.f5068a.f2517c.requestFocus();
                return true;
            }
        }
        if (subMenuC2267u0.hasVisibleItems()) {
            subMenuC2267u0.addMenuPresenter(this, this.f5037b);
            if (mo394a()) {
                m803m(subMenuC2267u0);
            } else {
                this.f5043i.add(subMenuC2267u0);
            }
            InterfaceC2165p0.InterfaceC2166a interfaceC2166a = this.f5059y;
            if (interfaceC2166a != null) {
                interfaceC2166a.mo458a(subMenuC2267u0);
            }
            return true;
        }
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public void setCallback(InterfaceC2165p0.InterfaceC2166a interfaceC2166a) {
        this.f5059y = interfaceC2166a;
    }

    @Override // p000.InterfaceC2222s0
    public void show() {
        if (mo394a()) {
            return;
        }
        for (C1905j0 c1905j0 : this.f5043i) {
            m803m(c1905j0);
        }
        this.f5043i.clear();
        View view = this.f5050p;
        this.f5051q = view;
        if (view != null) {
            boolean z = this.f5060z == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f5060z = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f5045k);
            }
            this.f5051q.addOnAttachStateChangeListener(this.f5046l);
        }
    }

    @Override // p000.InterfaceC2165p0
    public void updateMenuView(boolean z) {
        for (C1831d c1831d : this.f5044j) {
            ListAdapter adapter = c1831d.f5068a.f2517c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((C1882i0) adapter).notifyDataSetChanged();
        }
    }
}
