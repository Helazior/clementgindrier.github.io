package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class MenuPopupWindow extends ListPopupWindow implements InterfaceC0365Q0 {

    /* renamed from: F */
    public static Method f2545F;

    /* renamed from: E */
    public InterfaceC0365Q0 f2546E;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class MenuDropDownListView extends C0281M0 {

        /* renamed from: o */
        public final int f2547o;

        /* renamed from: p */
        public final int f2548p;

        /* renamed from: q */
        public InterfaceC0365Q0 f2549q;

        /* renamed from: r */
        public MenuItem f2550r;

        public MenuDropDownListView(Context context, boolean z) {
            super(context, z);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f2547o = 21;
                this.f2548p = 22;
                return;
            }
            this.f2547o = 22;
            this.f2548p = 21;
        }

        @Override // p000.C0281M0, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            C1882i0 c1882i0;
            int pointToPosition;
            int i2;
            if (this.f2549q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    c1882i0 = (C1882i0) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    c1882i0 = (C1882i0) adapter;
                }
                C1950l0 c1950l0 = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < c1882i0.getCount()) {
                    c1950l0 = c1882i0.getItem(i2);
                }
                MenuItem menuItem = this.f2550r;
                if (menuItem != c1950l0) {
                    C1905j0 c1905j0 = c1882i0.f5225a;
                    if (menuItem != null) {
                        this.f2549q.mo801d(c1905j0, menuItem);
                    }
                    this.f2550r = c1950l0;
                    if (c1950l0 != null) {
                        this.f2549q.mo802c(c1905j0, c1950l0);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f2547o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.f2317a.hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i == this.f2548p) {
                setSelection(-1);
                ((C1882i0) getAdapter()).f5225a.close(false);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }

        public void setHoverListener(InterfaceC0365Q0 interfaceC0365Q0) {
            this.f2549q = interfaceC0365Q0;
        }

        @Override // p000.C0281M0, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                f2545F = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public MenuPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, null, i, i2);
    }

    @Override // p000.InterfaceC0365Q0
    /* renamed from: c */
    public void mo802c(C1905j0 c1905j0, MenuItem menuItem) {
        InterfaceC0365Q0 interfaceC0365Q0 = this.f2546E;
        if (interfaceC0365Q0 != null) {
            interfaceC0365Q0.mo802c(c1905j0, menuItem);
        }
    }

    @Override // p000.InterfaceC0365Q0
    /* renamed from: d */
    public void mo801d(C1905j0 c1905j0, MenuItem menuItem) {
        InterfaceC0365Q0 interfaceC0365Q0 = this.f2546E;
        if (interfaceC0365Q0 != null) {
            interfaceC0365Q0.mo801d(c1905j0, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    /* renamed from: n */
    public C0281M0 mo1611n(Context context, boolean z) {
        MenuDropDownListView menuDropDownListView = new MenuDropDownListView(context, z);
        menuDropDownListView.setHoverListener(this);
        return menuDropDownListView;
    }
}
