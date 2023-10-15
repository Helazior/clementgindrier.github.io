package p000;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.widget.MenuPopupWindow;
import p000.InterfaceC2165p0;

/* renamed from: t0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class View$OnKeyListenerC2244t0 extends AbstractC1989n0 implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, InterfaceC2165p0, View.OnKeyListener {

    /* renamed from: w */
    public static final int f6425w = C1949l.abc_popup_menu_item_layout;

    /* renamed from: b */
    public final Context f6426b;

    /* renamed from: c */
    public final C1905j0 f6427c;

    /* renamed from: d */
    public final C1882i0 f6428d;

    /* renamed from: f */
    public final boolean f6429f;

    /* renamed from: g */
    public final int f6430g;

    /* renamed from: h */
    public final int f6431h;

    /* renamed from: i */
    public final int f6432i;

    /* renamed from: j */
    public final MenuPopupWindow f6433j;

    /* renamed from: m */
    public PopupWindow.OnDismissListener f6436m;

    /* renamed from: n */
    public View f6437n;

    /* renamed from: o */
    public View f6438o;

    /* renamed from: p */
    public InterfaceC2165p0.InterfaceC2166a f6439p;

    /* renamed from: q */
    public ViewTreeObserver f6440q;

    /* renamed from: r */
    public boolean f6441r;

    /* renamed from: s */
    public boolean f6442s;

    /* renamed from: t */
    public int f6443t;

    /* renamed from: v */
    public boolean f6445v;

    /* renamed from: k */
    public final ViewTreeObserver.OnGlobalLayoutListener f6434k = new ViewTreeObserver$OnGlobalLayoutListenerC2245a();

    /* renamed from: l */
    public final View.OnAttachStateChangeListener f6435l = new View$OnAttachStateChangeListenerC2246b();

    /* renamed from: u */
    public int f6444u = 0;

    /* renamed from: t0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC2245a implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserver$OnGlobalLayoutListenerC2245a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (View$OnKeyListenerC2244t0.this.mo394a()) {
                View$OnKeyListenerC2244t0 view$OnKeyListenerC2244t0 = View$OnKeyListenerC2244t0.this;
                if (view$OnKeyListenerC2244t0.f6433j.f2539z) {
                    return;
                }
                View view = view$OnKeyListenerC2244t0.f6438o;
                if (view != null && view.isShown()) {
                    View$OnKeyListenerC2244t0.this.f6433j.show();
                } else {
                    View$OnKeyListenerC2244t0.this.dismiss();
                }
            }
        }
    }

    /* renamed from: t0$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnAttachStateChangeListenerC2246b implements View.OnAttachStateChangeListener {
        public View$OnAttachStateChangeListenerC2246b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = View$OnKeyListenerC2244t0.this.f6440q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    View$OnKeyListenerC2244t0.this.f6440q = view.getViewTreeObserver();
                }
                View$OnKeyListenerC2244t0 view$OnKeyListenerC2244t0 = View$OnKeyListenerC2244t0.this;
                view$OnKeyListenerC2244t0.f6440q.removeGlobalOnLayoutListener(view$OnKeyListenerC2244t0.f6434k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public View$OnKeyListenerC2244t0(Context context, C1905j0 c1905j0, View view, int i, int i2, boolean z) {
        this.f6426b = context;
        this.f6427c = c1905j0;
        this.f6429f = z;
        this.f6428d = new C1882i0(c1905j0, LayoutInflater.from(context), z, f6425w);
        this.f6431h = i;
        this.f6432i = i2;
        Resources resources = context.getResources();
        this.f6430g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C1881i.abc_config_prefDialogWidth));
        this.f6437n = view;
        this.f6433j = new MenuPopupWindow(context, null, i, i2);
        c1905j0.addMenuPresenter(this, context);
    }

    @Override // p000.InterfaceC2222s0
    /* renamed from: a */
    public boolean mo394a() {
        return !this.f6441r && this.f6433j.mo394a();
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: b */
    public void mo393b(C1905j0 c1905j0) {
    }

    @Override // p000.InterfaceC2222s0
    public void dismiss() {
        if (mo394a()) {
            this.f6433j.dismiss();
        }
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: e */
    public void mo392e(View view) {
        this.f6437n = view;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: f */
    public void mo391f(boolean z) {
        this.f6428d.f5227c = z;
    }

    @Override // p000.InterfaceC2165p0
    public boolean flagActionItems() {
        return false;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: g */
    public void mo390g(int i) {
        this.f6444u = i;
    }

    @Override // p000.InterfaceC2222s0
    public ListView getListView() {
        return this.f6433j.f2517c;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: h */
    public void mo389h(int i) {
        this.f6433j.f2520g = i;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: i */
    public void mo388i(PopupWindow.OnDismissListener onDismissListener) {
        this.f6436m = onDismissListener;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: j */
    public void mo387j(boolean z) {
        this.f6445v = z;
    }

    @Override // p000.AbstractC1989n0
    /* renamed from: k */
    public void mo386k(int i) {
        MenuPopupWindow menuPopupWindow = this.f6433j;
        menuPopupWindow.f2521h = i;
        menuPopupWindow.f2523j = true;
    }

    @Override // p000.InterfaceC2165p0
    public void onCloseMenu(C1905j0 c1905j0, boolean z) {
        if (c1905j0 != this.f6427c) {
            return;
        }
        dismiss();
        InterfaceC2165p0.InterfaceC2166a interfaceC2166a = this.f6439p;
        if (interfaceC2166a != null) {
            interfaceC2166a.onCloseMenu(c1905j0, z);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f6441r = true;
        this.f6427c.close();
        ViewTreeObserver viewTreeObserver = this.f6440q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f6440q = this.f6438o.getViewTreeObserver();
            }
            this.f6440q.removeGlobalOnLayoutListener(this.f6434k);
            this.f6440q = null;
        }
        this.f6438o.removeOnAttachStateChangeListener(this.f6435l);
        PopupWindow.OnDismissListener onDismissListener = this.f6436m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    @Override // p000.InterfaceC2165p0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onSubMenuSelected(p000.SubMenuC2267u0 r10) {
        /*
            r9 = this;
            boolean r0 = r10.hasVisibleItems()
            r1 = 0
            if (r0 == 0) goto L78
            o0 r0 = new o0
            android.content.Context r3 = r9.f6426b
            android.view.View r5 = r9.f6438o
            boolean r6 = r9.f6429f
            int r7 = r9.f6431h
            int r8 = r9.f6432i
            r2 = r0
            r4 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            p0$a r2 = r9.f6439p
            r0.m541d(r2)
            boolean r2 = p000.AbstractC1989n0.m588l(r10)
            r0.f5572h = r2
            n0 r3 = r0.f5574j
            if (r3 == 0) goto L2a
            r3.mo391f(r2)
        L2a:
            android.widget.PopupWindow$OnDismissListener r2 = r9.f6436m
            r0.f5575k = r2
            r2 = 0
            r9.f6436m = r2
            j0 r2 = r9.f6427c
            r2.close(r1)
            androidx.appcompat.widget.MenuPopupWindow r2 = r9.f6433j
            int r3 = r2.f2520g
            boolean r4 = r2.f2523j
            if (r4 != 0) goto L40
            r2 = 0
            goto L42
        L40:
            int r2 = r2.f2521h
        L42:
            int r4 = r9.f6444u
            android.view.View r5 = r9.f6437n
            java.util.concurrent.atomic.AtomicInteger r6 = p000.C0492V4.f1798a
            int r5 = p000.C0492V4.C0496d.m1921d(r5)
            int r4 = android.view.Gravity.getAbsoluteGravity(r4, r5)
            r4 = r4 & 7
            r5 = 5
            if (r4 != r5) goto L5c
            android.view.View r4 = r9.f6437n
            int r4 = r4.getWidth()
            int r3 = r3 + r4
        L5c:
            boolean r4 = r0.m543b()
            r5 = 1
            if (r4 == 0) goto L64
            goto L6d
        L64:
            android.view.View r4 = r0.f5570f
            if (r4 != 0) goto L6a
            r0 = 0
            goto L6e
        L6a:
            r0.m540e(r3, r2, r5, r5)
        L6d:
            r0 = 1
        L6e:
            if (r0 == 0) goto L78
            p0$a r0 = r9.f6439p
            if (r0 == 0) goto L77
            r0.mo458a(r10)
        L77:
            return r5
        L78:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.View$OnKeyListenerC2244t0.onSubMenuSelected(u0):boolean");
    }

    @Override // p000.InterfaceC2165p0
    public void setCallback(InterfaceC2165p0.InterfaceC2166a interfaceC2166a) {
        this.f6439p = interfaceC2166a;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00cc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
    @Override // p000.InterfaceC2222s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void show() {
        /*
            r7 = this;
            boolean r0 = r7.mo394a()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lb
        L8:
            r1 = 1
            goto Lca
        Lb:
            boolean r0 = r7.f6441r
            if (r0 != 0) goto Lca
            android.view.View r0 = r7.f6437n
            if (r0 != 0) goto L15
            goto Lca
        L15:
            r7.f6438o = r0
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.f6433j
            android.widget.PopupWindow r0 = r0.f2514A
            r0.setOnDismissListener(r7)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.f6433j
            r0.f2531r = r7
            r0.m1612p(r2)
            android.view.View r0 = r7.f6438o
            android.view.ViewTreeObserver r3 = r7.f6440q
            if (r3 != 0) goto L2d
            r3 = 1
            goto L2e
        L2d:
            r3 = 0
        L2e:
            android.view.ViewTreeObserver r4 = r0.getViewTreeObserver()
            r7.f6440q = r4
            if (r3 == 0) goto L3b
            android.view.ViewTreeObserver$OnGlobalLayoutListener r3 = r7.f6434k
            r4.addOnGlobalLayoutListener(r3)
        L3b:
            android.view.View$OnAttachStateChangeListener r3 = r7.f6435l
            r0.addOnAttachStateChangeListener(r3)
            androidx.appcompat.widget.MenuPopupWindow r3 = r7.f6433j
            r3.f2530q = r0
            int r0 = r7.f6444u
            r3.f2526m = r0
            boolean r0 = r7.f6442s
            r3 = 0
            if (r0 != 0) goto L5b
            i0 r0 = r7.f6428d
            android.content.Context r4 = r7.f6426b
            int r5 = r7.f6430g
            int r0 = p000.AbstractC1989n0.m589d(r0, r3, r4, r5)
            r7.f6443t = r0
            r7.f6442s = r2
        L5b:
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.f6433j
            int r4 = r7.f6443t
            r0.m1613o(r4)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.f6433j
            r4 = 2
            android.widget.PopupWindow r0 = r0.f2514A
            r0.setInputMethodMode(r4)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.f6433j
            android.graphics.Rect r4 = r7.f5507a
            java.util.Objects.requireNonNull(r0)
            if (r4 == 0) goto L79
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>(r4)
            goto L7a
        L79:
            r5 = r3
        L7a:
            r0.f2538y = r5
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.f6433j
            r0.show()
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.f6433j
            M0 r0 = r0.f2517c
            r0.setOnKeyListener(r7)
            boolean r4 = r7.f6445v
            if (r4 == 0) goto Lbc
            j0 r4 = r7.f6427c
            java.lang.CharSequence r4 = r4.getHeaderTitle()
            if (r4 == 0) goto Lbc
            android.content.Context r4 = r7.f6426b
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            int r5 = p000.C1949l.abc_popup_menu_header_item_layout
            android.view.View r4 = r4.inflate(r5, r0, r1)
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r5 = 16908310(0x1020016, float:2.387729E-38)
            android.view.View r5 = r4.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            if (r5 == 0) goto Lb6
            j0 r6 = r7.f6427c
            java.lang.CharSequence r6 = r6.getHeaderTitle()
            r5.setText(r6)
        Lb6:
            r4.setEnabled(r1)
            r0.addHeaderView(r4, r3, r1)
        Lbc:
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.f6433j
            i0 r1 = r7.f6428d
            r0.mo1614m(r1)
            androidx.appcompat.widget.MenuPopupWindow r0 = r7.f6433j
            r0.show()
            goto L8
        Lca:
            if (r1 == 0) goto Lcd
            return
        Lcd:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "StandardMenuPopup cannot be used without an anchor"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.View$OnKeyListenerC2244t0.show():void");
    }

    @Override // p000.InterfaceC2165p0
    public void updateMenuView(boolean z) {
        this.f6442s = false;
        C1882i0 c1882i0 = this.f6428d;
        if (c1882i0 != null) {
            c1882i0.notifyDataSetChanged();
        }
    }
}
