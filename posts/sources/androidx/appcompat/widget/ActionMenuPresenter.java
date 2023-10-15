package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import java.util.ArrayList;
import p000.AbstractC0148G4;
import p000.InterfaceC2165p0;
import p000.InterfaceC2186q0;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ActionMenuPresenter extends AbstractC1634e0 implements AbstractC0148G4.InterfaceC0149a {

    /* renamed from: A */
    public int f2391A;

    /* renamed from: k */
    public C0646d f2392k;

    /* renamed from: l */
    public Drawable f2393l;

    /* renamed from: m */
    public boolean f2394m;

    /* renamed from: n */
    public boolean f2395n;

    /* renamed from: o */
    public boolean f2396o;

    /* renamed from: p */
    public int f2397p;

    /* renamed from: q */
    public int f2398q;

    /* renamed from: r */
    public int f2399r;

    /* renamed from: s */
    public boolean f2400s;

    /* renamed from: t */
    public int f2401t;

    /* renamed from: u */
    public final SparseBooleanArray f2402u;

    /* renamed from: v */
    public C0648e f2403v;

    /* renamed from: w */
    public C0643a f2404w;

    /* renamed from: x */
    public RunnableC0645c f2405x;

    /* renamed from: y */
    public C0644b f2406y;

    /* renamed from: z */
    public final C0649f f2407z;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0642a();

        /* renamed from: a */
        public int f2408a;

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0642a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f2408a);
        }

        public SavedState(Parcel parcel) {
            this.f2408a = parcel.readInt();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0643a extends C2013o0 {
        public C0643a(Context context, SubMenuC2267u0 subMenuC2267u0, View view) {
            super(context, subMenuC2267u0, view, false, C1671f.actionOverflowMenuStyle, 0);
            if (!((C1950l0) subMenuC2267u0.getItem()).m643g()) {
                View view2 = ActionMenuPresenter.this.f2392k;
                this.f5570f = view2 == null ? (View) ActionMenuPresenter.this.f4105i : view2;
            }
            m541d(ActionMenuPresenter.this.f2407z);
        }

        @Override // p000.C2013o0
        /* renamed from: c */
        public void mo542c() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f2404w = null;
            actionMenuPresenter.f2391A = 0;
            super.mo542c();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0644b extends ActionMenuItemView.AbstractC0636b {
        public C0644b() {
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0645c implements Runnable {

        /* renamed from: a */
        public C0648e f2411a;

        public RunnableC0645c(C0648e c0648e) {
            this.f2411a = c0648e;
        }

        @Override // java.lang.Runnable
        public void run() {
            C1905j0 c1905j0 = ActionMenuPresenter.this.f4100c;
            if (c1905j0 != null) {
                c1905j0.changeMenuMode();
            }
            View view = (View) ActionMenuPresenter.this.f4105i;
            if (view != null && view.getWindowToken() != null && this.f2411a.m539f()) {
                ActionMenuPresenter.this.f2403v = this.f2411a;
            }
            ActionMenuPresenter.this.f2405x = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0646d extends AppCompatImageView implements ActionMenuView.InterfaceC0650a {

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$d$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0647a extends AbstractView$OnTouchListenerC0325O0 {
            public C0647a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
            }

            @Override // p000.AbstractView$OnTouchListenerC0325O0
            /* renamed from: b */
            public InterfaceC2222s0 mo1640b() {
                C0648e c0648e = ActionMenuPresenter.this.f2403v;
                if (c0648e == null) {
                    return null;
                }
                return c0648e.m544a();
            }

            @Override // p000.AbstractView$OnTouchListenerC0325O0
            /* renamed from: c */
            public boolean mo1639c() {
                ActionMenuPresenter.this.m1653f();
                return true;
            }

            @Override // p000.AbstractView$OnTouchListenerC0325O0
            /* renamed from: d */
            public boolean mo1638d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f2405x != null) {
                    return false;
                }
                actionMenuPresenter.m1656c();
                return true;
            }
        }

        public C0646d(Context context) {
            super(context, null, C1671f.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            LayoutInflater$Factory2C0000A.C0010h.m2616r0(this, getContentDescription());
            setOnTouchListener(new C0647a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0650a
        /* renamed from: a */
        public boolean mo1647a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.InterfaceC0650a
        /* renamed from: b */
        public boolean mo1646b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.m1653f();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0648e extends C2013o0 {
        public C0648e(Context context, C1905j0 c1905j0, View view, boolean z) {
            super(context, c1905j0, view, z, C1671f.actionOverflowMenuStyle, 0);
            this.f5571g = 8388613;
            m541d(ActionMenuPresenter.this.f2407z);
        }

        @Override // p000.C2013o0
        /* renamed from: c */
        public void mo542c() {
            C1905j0 c1905j0 = ActionMenuPresenter.this.f4100c;
            if (c1905j0 != null) {
                c1905j0.close();
            }
            ActionMenuPresenter.this.f2403v = null;
            super.mo542c();
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0649f implements InterfaceC2165p0.InterfaceC2166a {
        public C0649f() {
        }

        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        /* renamed from: a */
        public boolean mo458a(C1905j0 c1905j0) {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            if (c1905j0 == actionMenuPresenter.f4100c) {
                return false;
            }
            actionMenuPresenter.f2391A = ((SubMenuC2267u0) c1905j0).getItem().getItemId();
            InterfaceC2165p0.InterfaceC2166a interfaceC2166a = ActionMenuPresenter.this.f4102f;
            if (interfaceC2166a != null) {
                return interfaceC2166a.mo458a(c1905j0);
            }
            return false;
        }

        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        public void onCloseMenu(C1905j0 c1905j0, boolean z) {
            if (c1905j0 instanceof SubMenuC2267u0) {
                c1905j0.getRootMenu().close(false);
            }
            InterfaceC2165p0.InterfaceC2166a interfaceC2166a = ActionMenuPresenter.this.f4102f;
            if (interfaceC2166a != null) {
                interfaceC2166a.onCloseMenu(c1905j0, z);
            }
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C1949l.abc_action_menu_layout, C1949l.abc_action_menu_item_layout);
        this.f2402u = new SparseBooleanArray();
        this.f2407z = new C0649f();
    }

    /* renamed from: a */
    public boolean m1658a() {
        return m1656c() | m1655d();
    }

    /* renamed from: b */
    public View m1657b(C1950l0 c1950l0, View view, ViewGroup viewGroup) {
        InterfaceC2186q0.InterfaceC2187a interfaceC2187a;
        View actionView = c1950l0.getActionView();
        if (actionView == null || c1950l0.m644f()) {
            if (view instanceof InterfaceC2186q0.InterfaceC2187a) {
                interfaceC2187a = (InterfaceC2186q0.InterfaceC2187a) view;
            } else {
                interfaceC2187a = (InterfaceC2186q0.InterfaceC2187a) this.f4101d.inflate(this.f4104h, viewGroup, false);
            }
            interfaceC2187a.initialize(c1950l0, 0);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) interfaceC2187a;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.f4105i);
            if (this.f2406y == null) {
                this.f2406y = new C0644b();
            }
            actionMenuItemView.setPopupCallback(this.f2406y);
            actionView = (View) interfaceC2187a;
        }
        actionView.setVisibility(c1950l0.f5409C ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    /* renamed from: c */
    public boolean m1656c() {
        InterfaceC2186q0 interfaceC2186q0;
        RunnableC0645c runnableC0645c = this.f2405x;
        if (runnableC0645c != null && (interfaceC2186q0 = this.f4105i) != null) {
            ((View) interfaceC2186q0).removeCallbacks(runnableC0645c);
            this.f2405x = null;
            return true;
        }
        C0648e c0648e = this.f2403v;
        if (c0648e != null) {
            if (c0648e.m543b()) {
                c0648e.f5574j.dismiss();
            }
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public boolean m1655d() {
        C0643a c0643a = this.f2404w;
        if (c0643a != null) {
            if (c0643a.m543b()) {
                c0643a.f5574j.dismiss();
                return true;
            }
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public boolean m1654e() {
        C0648e c0648e = this.f2403v;
        return c0648e != null && c0648e.m543b();
    }

    /* renamed from: f */
    public boolean m1653f() {
        C1905j0 c1905j0;
        if (!this.f2395n || m1654e() || (c1905j0 = this.f4100c) == null || this.f4105i == null || this.f2405x != null || c1905j0.getNonActionItems().isEmpty()) {
            return false;
        }
        RunnableC0645c runnableC0645c = new RunnableC0645c(new C0648e(this.f4099b, this.f4100c, this.f2392k, true));
        this.f2405x = runnableC0645c;
        ((View) this.f4105i).post(runnableC0645c);
        return true;
    }

    @Override // p000.InterfaceC2165p0
    public boolean flagActionItems() {
        ArrayList<C1950l0> arrayList;
        int i;
        int i2;
        boolean z;
        C1905j0 c1905j0 = this.f4100c;
        if (c1905j0 != null) {
            arrayList = c1905j0.getVisibleItems();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i3 = this.f2399r;
        int i4 = this.f2398q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f4105i;
        int i5 = 0;
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 2;
            z = true;
            if (i5 >= i) {
                break;
            }
            C1950l0 c1950l0 = arrayList.get(i5);
            int i8 = c1950l0.f5435y;
            if ((i8 & 2) == 2) {
                i7++;
            } else if ((i8 & 1) == 1) {
                i6++;
            } else {
                z2 = true;
            }
            if (this.f2400s && c1950l0.f5409C) {
                i3 = 0;
            }
            i5++;
        }
        if (this.f2395n && (z2 || i6 + i7 > i3)) {
            i3--;
        }
        int i9 = i3 - i7;
        SparseBooleanArray sparseBooleanArray = this.f2402u;
        sparseBooleanArray.clear();
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            C1950l0 c1950l02 = arrayList.get(i10);
            int i12 = c1950l02.f5435y;
            if ((i12 & 2) == i2) {
                View m1657b = m1657b(c1950l02, null, viewGroup);
                m1657b.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = m1657b.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                int i13 = c1950l02.f5412b;
                if (i13 != 0) {
                    sparseBooleanArray.put(i13, z);
                }
                c1950l02.m638l(z);
            } else if ((i12 & 1) == z) {
                int i14 = c1950l02.f5412b;
                boolean z3 = sparseBooleanArray.get(i14);
                boolean z4 = (i9 > 0 || z3) && i4 > 0;
                if (z4) {
                    View m1657b2 = m1657b(c1950l02, null, viewGroup);
                    m1657b2.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = m1657b2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z4 &= i4 + i11 > 0;
                }
                if (z4 && i14 != 0) {
                    sparseBooleanArray.put(i14, true);
                } else if (z3) {
                    sparseBooleanArray.put(i14, false);
                    for (int i15 = 0; i15 < i10; i15++) {
                        C1950l0 c1950l03 = arrayList.get(i15);
                        if (c1950l03.f5412b == i14) {
                            if (c1950l03.m643g()) {
                                i9++;
                            }
                            c1950l03.m638l(false);
                        }
                    }
                }
                if (z4) {
                    i9--;
                }
                c1950l02.m638l(z4);
            } else {
                c1950l02.m638l(false);
                i10++;
                i2 = 2;
                z = true;
            }
            i10++;
            i2 = 2;
            z = true;
        }
        return true;
    }

    @Override // p000.InterfaceC2165p0
    public void initForMenu(Context context, C1905j0 c1905j0) {
        this.f4099b = context;
        LayoutInflater.from(context);
        this.f4100c = c1905j0;
        Resources resources = context.getResources();
        if (!this.f2396o) {
            this.f2395n = true;
        }
        int i = 2;
        this.f2397p = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.f2399r = i;
        int i4 = this.f2397p;
        if (this.f2395n) {
            if (this.f2392k == null) {
                C0646d c0646d = new C0646d(this.f4098a);
                this.f2392k = c0646d;
                if (this.f2394m) {
                    c0646d.setImageDrawable(this.f2393l);
                    this.f2393l = null;
                    this.f2394m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f2392k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i4 -= this.f2392k.getMeasuredWidth();
        } else {
            this.f2392k = null;
        }
        this.f2398q = i4;
        this.f2401t = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // p000.InterfaceC2165p0
    public void onCloseMenu(C1905j0 c1905j0, boolean z) {
        m1658a();
        InterfaceC2165p0.InterfaceC2166a interfaceC2166a = this.f4102f;
        if (interfaceC2166a != null) {
            interfaceC2166a.onCloseMenu(c1905j0, z);
        }
    }

    @Override // p000.InterfaceC2165p0
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i = ((SavedState) parcelable).f2408a) > 0 && (findItem = this.f4100c.findItem(i)) != null) {
            onSubMenuSelected((SubMenuC2267u0) findItem.getSubMenu());
        }
    }

    @Override // p000.InterfaceC2165p0
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.f2408a = this.f2391A;
        return savedState;
    }

    @Override // p000.InterfaceC2165p0
    public boolean onSubMenuSelected(SubMenuC2267u0 subMenuC2267u0) {
        boolean z = false;
        if (subMenuC2267u0.hasVisibleItems()) {
            SubMenuC2267u0 subMenuC2267u02 = subMenuC2267u0;
            while (subMenuC2267u02.getParentMenu() != this.f4100c) {
                subMenuC2267u02 = (SubMenuC2267u0) subMenuC2267u02.getParentMenu();
            }
            MenuItem item = subMenuC2267u02.getItem();
            ViewGroup viewGroup = (ViewGroup) this.f4105i;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof InterfaceC2186q0.InterfaceC2187a) && ((InterfaceC2186q0.InterfaceC2187a) childAt).getItemData() == item) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view == null) {
                return false;
            }
            this.f2391A = subMenuC2267u0.getItem().getItemId();
            int size = subMenuC2267u0.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                MenuItem item2 = subMenuC2267u0.getItem(i2);
                if (item2.isVisible() && item2.getIcon() != null) {
                    z = true;
                    break;
                }
                i2++;
            }
            C0643a c0643a = new C0643a(this.f4099b, subMenuC2267u0, view);
            this.f2404w = c0643a;
            c0643a.f5572h = z;
            AbstractC1989n0 abstractC1989n0 = c0643a.f5574j;
            if (abstractC1989n0 != null) {
                abstractC1989n0.mo391f(z);
            }
            if (this.f2404w.m539f()) {
                InterfaceC2165p0.InterfaceC2166a interfaceC2166a = this.f4102f;
                if (interfaceC2166a != null) {
                    interfaceC2166a.mo458a(subMenuC2267u0);
                }
                return true;
            }
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
        return false;
    }

    @Override // p000.InterfaceC2165p0
    public void updateMenuView(boolean z) {
        int i;
        boolean z2;
        ViewGroup viewGroup = (ViewGroup) this.f4105i;
        boolean z3 = false;
        if (viewGroup != null) {
            C1905j0 c1905j0 = this.f4100c;
            if (c1905j0 != null) {
                c1905j0.flagActionItems();
                ArrayList<C1950l0> visibleItems = this.f4100c.getVisibleItems();
                int size = visibleItems.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    C1950l0 c1950l0 = visibleItems.get(i2);
                    if (c1950l0.m643g()) {
                        View childAt = viewGroup.getChildAt(i);
                        C1950l0 itemData = childAt instanceof InterfaceC2186q0.InterfaceC2187a ? ((InterfaceC2186q0.InterfaceC2187a) childAt).getItemData() : null;
                        View m1657b = m1657b(c1950l0, childAt, viewGroup);
                        if (c1950l0 != itemData) {
                            m1657b.setPressed(false);
                            m1657b.jumpDrawablesToCurrentState();
                        }
                        if (m1657b != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) m1657b.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(m1657b);
                            }
                            ((ViewGroup) this.f4105i).addView(m1657b, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.f2392k) {
                    z2 = false;
                } else {
                    viewGroup.removeViewAt(i);
                    z2 = true;
                }
                if (!z2) {
                    i++;
                }
            }
        }
        ((View) this.f4105i).requestLayout();
        C1905j0 c1905j02 = this.f4100c;
        if (c1905j02 != null) {
            ArrayList<C1950l0> actionItems = c1905j02.getActionItems();
            int size2 = actionItems.size();
            for (int i3 = 0; i3 < size2; i3++) {
                AbstractC0148G4 abstractC0148G4 = actionItems.get(i3).f5407A;
                if (abstractC0148G4 != null) {
                    abstractC0148G4.f495a = this;
                }
            }
        }
        C1905j0 c1905j03 = this.f4100c;
        ArrayList<C1950l0> nonActionItems = c1905j03 != null ? c1905j03.getNonActionItems() : null;
        if (this.f2395n && nonActionItems != null) {
            int size3 = nonActionItems.size();
            if (size3 == 1) {
                z3 = !nonActionItems.get(0).f5409C;
            } else if (size3 > 0) {
                z3 = true;
            }
        }
        if (z3) {
            if (this.f2392k == null) {
                this.f2392k = new C0646d(this.f4098a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f2392k.getParent();
            if (viewGroup3 != this.f4105i) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f2392k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f4105i;
                C0646d c0646d = this.f2392k;
                ActionMenuView.LayoutParams generateDefaultLayoutParams = actionMenuView.generateDefaultLayoutParams();
                generateDefaultLayoutParams.f2429c = true;
                actionMenuView.addView(c0646d, generateDefaultLayoutParams);
            }
        } else {
            C0646d c0646d2 = this.f2392k;
            if (c0646d2 != null) {
                ViewParent parent = c0646d2.getParent();
                InterfaceC2186q0 interfaceC2186q0 = this.f4105i;
                if (parent == interfaceC2186q0) {
                    ((ViewGroup) interfaceC2186q0).removeView(this.f2392k);
                }
            }
        }
        ((ActionMenuView) this.f4105i).setOverflowReserved(this.f2395n);
    }
}
