package androidx.appcompat.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.DialogInterfaceC2336x;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AppCompatSpinner extends Spinner {

    /* renamed from: j */
    public static final int[] f2470j = {16843505};

    /* renamed from: a */
    public final C2395z0 f2471a;

    /* renamed from: b */
    public final Context f2472b;

    /* renamed from: c */
    public AbstractView$OnTouchListenerC0325O0 f2473c;

    /* renamed from: d */
    public SpinnerAdapter f2474d;

    /* renamed from: f */
    public final boolean f2475f;

    /* renamed from: g */
    public InterfaceC0669e f2476g;

    /* renamed from: h */
    public int f2477h;

    /* renamed from: i */
    public final Rect f2478i;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0661a();

        /* renamed from: a */
        public boolean f2479a;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0661a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.f2479a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f2479a = parcel.readByte() != 0;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class ViewTreeObserver$OnGlobalLayoutListenerC0662a implements ViewTreeObserver.OnGlobalLayoutListener {
        public ViewTreeObserver$OnGlobalLayoutListenerC0662a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.f2476g.mo1632a()) {
                AppCompatSpinner.this.m1634b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class DialogInterface$OnClickListenerC0663b implements InterfaceC0669e, DialogInterface.OnClickListener {

        /* renamed from: a */
        public DialogInterfaceC2336x f2481a;

        /* renamed from: b */
        public ListAdapter f2482b;

        /* renamed from: c */
        public CharSequence f2483c;

        public DialogInterface$OnClickListenerC0663b() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: a */
        public boolean mo1632a() {
            DialogInterfaceC2336x dialogInterfaceC2336x = this.f2481a;
            if (dialogInterfaceC2336x != null) {
                return dialogInterfaceC2336x.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: b */
        public int mo1631b() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        public void dismiss() {
            DialogInterfaceC2336x dialogInterfaceC2336x = this.f2481a;
            if (dialogInterfaceC2336x != null) {
                dialogInterfaceC2336x.dismiss();
                this.f2481a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: e */
        public Drawable mo1630e() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: f */
        public void mo1629f(CharSequence charSequence) {
            this.f2483c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: g */
        public void mo1628g(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: h */
        public void mo1627h(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: i */
        public void mo1626i(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: j */
        public void mo1625j(int i, int i2) {
            if (this.f2482b == null) {
                return;
            }
            DialogInterfaceC2336x.C2337a c2337a = new DialogInterfaceC2336x.C2337a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f2483c;
            if (charSequence != null) {
                c2337a.setTitle(charSequence);
            }
            DialogInterfaceC2336x create = c2337a.setSingleChoiceItems(this.f2482b, AppCompatSpinner.this.getSelectedItemPosition(), this).create();
            this.f2481a = create;
            ListView listView = create.f6797a.f2239g;
            listView.setTextDirection(i);
            listView.setTextAlignment(i2);
            this.f2481a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: k */
        public int mo1624k() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: l */
        public CharSequence mo1623l() {
            return this.f2483c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: m */
        public void mo1614m(ListAdapter listAdapter) {
            this.f2482b = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            AppCompatSpinner.this.setSelection(i);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i, this.f2482b.getItemId(i));
            }
            DialogInterfaceC2336x dialogInterfaceC2336x = this.f2481a;
            if (dialogInterfaceC2336x != null) {
                dialogInterfaceC2336x.dismiss();
                this.f2481a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        public void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0664c implements ListAdapter, SpinnerAdapter {

        /* renamed from: a */
        public SpinnerAdapter f2485a;

        /* renamed from: b */
        public ListAdapter f2486b;

        public C0664c(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f2485a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f2486b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof InterfaceC0547X0) {
                    InterfaceC0547X0 interfaceC0547X0 = (InterfaceC0547X0) spinnerAdapter;
                    if (interfaceC0547X0.getDropDownViewTheme() == null) {
                        interfaceC0547X0.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f2486b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f2485a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f2485a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.f2485a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.f2485a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f2485a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f2485a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f2486b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2485a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f2485a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0665d extends ListPopupWindow implements InterfaceC0669e {

        /* renamed from: E */
        public CharSequence f2487E;

        /* renamed from: F */
        public ListAdapter f2488F;

        /* renamed from: G */
        public final Rect f2489G;

        /* renamed from: H */
        public int f2490H;

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$d$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0666a implements AdapterView.OnItemClickListener {
            public C0666a(AppCompatSpinner appCompatSpinner) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppCompatSpinner.this.setSelection(i);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    C0665d c0665d = C0665d.this;
                    AppCompatSpinner.this.performItemClick(view, i, c0665d.f2488F.getItemId(i));
                }
                C0665d.this.dismiss();
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$d$b */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class ViewTreeObserver$OnGlobalLayoutListenerC0667b implements ViewTreeObserver.OnGlobalLayoutListener {
            public ViewTreeObserver$OnGlobalLayoutListenerC0667b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                C0665d c0665d = C0665d.this;
                AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
                Objects.requireNonNull(c0665d);
                AtomicInteger atomicInteger = C0492V4.f1798a;
                if (!(C0492V4.C0498f.m1909b(appCompatSpinner) && appCompatSpinner.getGlobalVisibleRect(c0665d.f2489G))) {
                    C0665d.this.dismiss();
                    return;
                }
                C0665d.this.m1633q();
                C0665d.this.show();
            }
        }

        /* renamed from: androidx.appcompat.widget.AppCompatSpinner$d$c */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0668c implements PopupWindow.OnDismissListener {

            /* renamed from: a */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f2494a;

            public C0668c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f2494a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f2494a);
                }
            }
        }

        public C0665d(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f2489G = new Rect();
            this.f2530q = AppCompatSpinner.this;
            m1612p(true);
            this.f2528o = 0;
            this.f2531r = new C0666a(AppCompatSpinner.this);
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: f */
        public void mo1629f(CharSequence charSequence) {
            this.f2487E = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: h */
        public void mo1627h(int i) {
            this.f2490H = i;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: j */
        public void mo1625j(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean mo394a = mo394a();
            m1633q();
            this.f2514A.setInputMethodMode(2);
            show();
            C0281M0 c0281m0 = this.f2517c;
            c0281m0.setChoiceMode(1);
            c0281m0.setTextDirection(i);
            c0281m0.setTextAlignment(i2);
            int selectedItemPosition = AppCompatSpinner.this.getSelectedItemPosition();
            C0281M0 c0281m02 = this.f2517c;
            if (mo394a() && c0281m02 != null) {
                c0281m02.f936j = false;
                c0281m02.setSelection(selectedItemPosition);
                if (c0281m02.getChoiceMode() != 0) {
                    c0281m02.setItemChecked(selectedItemPosition, true);
                }
            }
            if (mo394a || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            ViewTreeObserver$OnGlobalLayoutListenerC0667b viewTreeObserver$OnGlobalLayoutListenerC0667b = new ViewTreeObserver$OnGlobalLayoutListenerC0667b();
            viewTreeObserver.addOnGlobalLayoutListener(viewTreeObserver$OnGlobalLayoutListenerC0667b);
            this.f2514A.setOnDismissListener(new C0668c(viewTreeObserver$OnGlobalLayoutListenerC0667b));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: l */
        public CharSequence mo1623l() {
            return this.f2487E;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.InterfaceC0669e
        /* renamed from: m */
        public void mo1614m(ListAdapter listAdapter) {
            super.mo1614m(listAdapter);
            this.f2488F = listAdapter;
        }

        /* renamed from: q */
        public void m1633q() {
            int i;
            Drawable m1618e = m1618e();
            int i2 = 0;
            if (m1618e != null) {
                m1618e.getPadding(AppCompatSpinner.this.f2478i);
                i2 = C1852h1.m786b(AppCompatSpinner.this) ? AppCompatSpinner.this.f2478i.right : -AppCompatSpinner.this.f2478i.left;
            } else {
                Rect rect = AppCompatSpinner.this.f2478i;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i3 = appCompatSpinner.f2477h;
            if (i3 == -2) {
                int m1635a = appCompatSpinner.m1635a((SpinnerAdapter) this.f2488F, m1618e());
                int i4 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f2478i;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (m1635a > i5) {
                    m1635a = i5;
                }
                m1613o(Math.max(m1635a, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                m1613o((width - paddingLeft) - paddingRight);
            } else {
                m1613o(i3);
            }
            if (C1852h1.m786b(AppCompatSpinner.this)) {
                i = (((width - paddingRight) - this.f2519f) - this.f2490H) + i2;
            } else {
                i = paddingLeft + this.f2490H + i2;
            }
            this.f2520g = i;
        }
    }

    /* renamed from: androidx.appcompat.widget.AppCompatSpinner$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0669e {
        /* renamed from: a */
        boolean mo1632a();

        /* renamed from: b */
        int mo1631b();

        void dismiss();

        /* renamed from: e */
        Drawable mo1630e();

        /* renamed from: f */
        void mo1629f(CharSequence charSequence);

        /* renamed from: g */
        void mo1628g(int i);

        /* renamed from: h */
        void mo1627h(int i);

        /* renamed from: i */
        void mo1626i(int i);

        /* renamed from: j */
        void mo1625j(int i, int i2);

        /* renamed from: k */
        int mo1624k();

        /* renamed from: l */
        CharSequence mo1623l();

        /* renamed from: m */
        void mo1614m(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public int m1635a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i2 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.f2478i);
            Rect rect = this.f2478i;
            return i2 + rect.left + rect.right;
        }
        return i2;
    }

    /* renamed from: b */
    public void m1634b() {
        this.f2476g.mo1625j(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2395z0 c2395z0 = this.f2471a;
        if (c2395z0 != null) {
            c2395z0.m21a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        InterfaceC0669e interfaceC0669e = this.f2476g;
        if (interfaceC0669e != null) {
            return interfaceC0669e.mo1631b();
        }
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        InterfaceC0669e interfaceC0669e = this.f2476g;
        if (interfaceC0669e != null) {
            return interfaceC0669e.mo1624k();
        }
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f2476g != null) {
            return this.f2477h;
        }
        return super.getDropDownWidth();
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        InterfaceC0669e interfaceC0669e = this.f2476g;
        if (interfaceC0669e != null) {
            return interfaceC0669e.mo1630e();
        }
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f2472b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        InterfaceC0669e interfaceC0669e = this.f2476g;
        return interfaceC0669e != null ? interfaceC0669e.mo1623l() : super.getPrompt();
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InterfaceC0669e interfaceC0669e = this.f2476g;
        if (interfaceC0669e == null || !interfaceC0669e.mo1632a()) {
            return;
        }
        this.f2476g.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2476g == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m1635a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f2479a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver$OnGlobalLayoutListenerC0662a());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        InterfaceC0669e interfaceC0669e = this.f2476g;
        savedState.f2479a = interfaceC0669e != null && interfaceC0669e.mo1632a();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AbstractView$OnTouchListenerC0325O0 abstractView$OnTouchListenerC0325O0 = this.f2473c;
        if (abstractView$OnTouchListenerC0325O0 == null || !abstractView$OnTouchListenerC0325O0.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        InterfaceC0669e interfaceC0669e = this.f2476g;
        if (interfaceC0669e != null) {
            if (interfaceC0669e.mo1632a()) {
                return true;
            }
            m1634b();
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2395z0 c2395z0 = this.f2471a;
        if (c2395z0 != null) {
            c2395z0.m17e();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C2395z0 c2395z0 = this.f2471a;
        if (c2395z0 != null) {
            c2395z0.m16f(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        InterfaceC0669e interfaceC0669e = this.f2476g;
        if (interfaceC0669e != null) {
            interfaceC0669e.mo1627h(i);
            this.f2476g.mo1626i(i);
            return;
        }
        super.setDropDownHorizontalOffset(i);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        InterfaceC0669e interfaceC0669e = this.f2476g;
        if (interfaceC0669e != null) {
            interfaceC0669e.mo1628g(i);
        } else {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f2476g != null) {
            this.f2477h = i;
        } else {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        InterfaceC0669e interfaceC0669e = this.f2476g;
        if (interfaceC0669e != null) {
            interfaceC0669e.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0279M.m2210b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        InterfaceC0669e interfaceC0669e = this.f2476g;
        if (interfaceC0669e != null) {
            interfaceC0669e.mo1629f(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2395z0 c2395z0 = this.f2471a;
        if (c2395z0 != null) {
            c2395z0.m14h(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2395z0 c2395z0 = this.f2471a;
        if (c2395z0 != null) {
            c2395z0.m13i(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1671f.spinnerStyle);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f2475f) {
            this.f2474d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f2476g != null) {
            Context context = this.f2472b;
            if (context == null) {
                context = getContext();
            }
            this.f2476g.mo1614m(new C0664c(spinnerAdapter, context.getTheme()));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r4 == null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AppCompatSpinner(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r8.f2478i = r0
            android.content.Context r0 = r8.getContext()
            p000.C0530W0.m1825a(r8, r0)
            int[] r0 = p000.C2012o.Spinner
            r1 = 0
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r10, r0, r11, r1)
            z0 r2 = new z0
            r2.<init>(r8)
            r8.f2471a = r2
            int r2 = p000.C2012o.Spinner_popupTheme
            int r2 = r0.getResourceId(r2, r1)
            if (r2 == 0) goto L2f
            X r3 = new X
            r3.<init>(r9, r2)
            r8.f2472b = r3
            goto L31
        L2f:
            r8.f2472b = r9
        L31:
            r2 = 0
            r3 = -1
            int[] r4 = androidx.appcompat.widget.AppCompatSpinner.f2470j     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            android.content.res.TypedArray r4 = r9.obtainStyledAttributes(r10, r4, r11, r1)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            boolean r5 = r4.hasValue(r1)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            if (r5 == 0) goto L59
            int r3 = r4.getInt(r1, r1)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            goto L59
        L44:
            r9 = move-exception
            r2 = r4
            goto Ld8
        L48:
            r5 = move-exception
            goto L50
        L4a:
            r9 = move-exception
            goto Ld8
        L4d:
            r4 = move-exception
            r5 = r4
            r4 = r2
        L50:
            java.lang.String r6 = "AppCompatSpinner"
            java.lang.String r7 = "Could not read android:spinnerMode"
            android.util.Log.i(r6, r7, r5)     // Catch: java.lang.Throwable -> L44
            if (r4 == 0) goto L5c
        L59:
            r4.recycle()
        L5c:
            r4 = 1
            if (r3 == 0) goto L9c
            if (r3 == r4) goto L62
            goto Lac
        L62:
            androidx.appcompat.widget.AppCompatSpinner$d r3 = new androidx.appcompat.widget.AppCompatSpinner$d
            android.content.Context r5 = r8.f2472b
            r3.<init>(r5, r10, r11)
            android.content.Context r5 = r8.f2472b
            int[] r6 = p000.C2012o.Spinner
            b1 r1 = p000.C0954b1.m1196r(r5, r10, r6, r11, r1)
            int r5 = p000.C2012o.Spinner_android_dropDownWidth
            r6 = -2
            int r5 = r1.m1202l(r5, r6)
            r8.f2477h = r5
            int r5 = p000.C2012o.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r5 = r1.m1207g(r5)
            android.widget.PopupWindow r6 = r3.f2514A
            r6.setBackgroundDrawable(r5)
            int r5 = p000.C2012o.Spinner_android_prompt
            java.lang.String r5 = r0.getString(r5)
            r3.f2487E = r5
            android.content.res.TypedArray r1 = r1.f3660b
            r1.recycle()
            r8.f2476g = r3
            F0 r1 = new F0
            r1.<init>(r8, r8, r3)
            r8.f2473c = r1
            goto Lac
        L9c:
            androidx.appcompat.widget.AppCompatSpinner$b r1 = new androidx.appcompat.widget.AppCompatSpinner$b
            r1.<init>()
            r8.f2476g = r1
            int r3 = p000.C2012o.Spinner_android_prompt
            java.lang.String r3 = r0.getString(r3)
            r1.mo1629f(r3)
        Lac:
            int r1 = p000.C2012o.Spinner_android_entries
            java.lang.CharSequence[] r1 = r0.getTextArray(r1)
            if (r1 == 0) goto Lc4
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r5 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r9, r5, r1)
            int r9 = p000.C1949l.support_simple_spinner_dropdown_item
            r3.setDropDownViewResource(r9)
            r8.setAdapter(r3)
        Lc4:
            r0.recycle()
            r8.f2475f = r4
            android.widget.SpinnerAdapter r9 = r8.f2474d
            if (r9 == 0) goto Ld2
            r8.setAdapter(r9)
            r8.f2474d = r2
        Ld2:
            z0 r9 = r8.f2471a
            r9.m18d(r10, r11)
            return
        Ld8:
            if (r2 == 0) goto Ldd
            r2.recycle()
        Ldd:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
