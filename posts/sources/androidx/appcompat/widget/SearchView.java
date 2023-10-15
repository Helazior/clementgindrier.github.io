package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.actions.SearchIntents;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class SearchView extends LinearLayoutCompat implements InterfaceC0529W {

    /* renamed from: c0 */
    public static final C0694n f2568c0;

    /* renamed from: A */
    public View.OnClickListener f2569A;

    /* renamed from: B */
    public boolean f2570B;

    /* renamed from: C */
    public boolean f2571C;

    /* renamed from: D */
    public AbstractC2172p5 f2572D;

    /* renamed from: E */
    public boolean f2573E;

    /* renamed from: F */
    public CharSequence f2574F;

    /* renamed from: G */
    public boolean f2575G;

    /* renamed from: H */
    public boolean f2576H;

    /* renamed from: I */
    public int f2577I;

    /* renamed from: J */
    public boolean f2578J;

    /* renamed from: K */
    public CharSequence f2579K;

    /* renamed from: L */
    public CharSequence f2580L;

    /* renamed from: M */
    public boolean f2581M;

    /* renamed from: N */
    public int f2582N;

    /* renamed from: O */
    public SearchableInfo f2583O;

    /* renamed from: P */
    public Bundle f2584P;

    /* renamed from: Q */
    public final Runnable f2585Q;

    /* renamed from: R */
    public Runnable f2586R;

    /* renamed from: S */
    public final WeakHashMap<String, Drawable.ConstantState> f2587S;

    /* renamed from: T */
    public final View.OnClickListener f2588T;

    /* renamed from: U */
    public View.OnKeyListener f2589U;

    /* renamed from: V */
    public final TextView.OnEditorActionListener f2590V;

    /* renamed from: W */
    public final AdapterView.OnItemClickListener f2591W;

    /* renamed from: a */
    public final SearchAutoComplete f2592a;

    /* renamed from: a0 */
    public final AdapterView.OnItemSelectedListener f2593a0;

    /* renamed from: b */
    public final View f2594b;

    /* renamed from: b0 */
    public TextWatcher f2595b0;

    /* renamed from: c */
    public final View f2596c;

    /* renamed from: d */
    public final View f2597d;

    /* renamed from: f */
    public final ImageView f2598f;

    /* renamed from: g */
    public final ImageView f2599g;

    /* renamed from: h */
    public final ImageView f2600h;

    /* renamed from: i */
    public final ImageView f2601i;

    /* renamed from: j */
    public final View f2602j;

    /* renamed from: k */
    public C0695o f2603k;

    /* renamed from: l */
    public Rect f2604l;

    /* renamed from: m */
    public Rect f2605m;

    /* renamed from: n */
    public int[] f2606n;

    /* renamed from: o */
    public int[] f2607o;

    /* renamed from: p */
    public final ImageView f2608p;

    /* renamed from: q */
    public final Drawable f2609q;

    /* renamed from: r */
    public final int f2610r;

    /* renamed from: s */
    public final int f2611s;

    /* renamed from: t */
    public final Intent f2612t;

    /* renamed from: u */
    public final Intent f2613u;

    /* renamed from: v */
    public final CharSequence f2614v;

    /* renamed from: w */
    public InterfaceC0692l f2615w;

    /* renamed from: x */
    public InterfaceC0691k f2616x;

    /* renamed from: y */
    public View.OnFocusChangeListener f2617y;

    /* renamed from: z */
    public InterfaceC0693m f2618z;

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new C0679a();

        /* renamed from: a */
        public boolean f2619a;

        /* renamed from: androidx.appcompat.widget.SearchView$SavedState$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0679a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder m253r = outline.m253r("SearchView.SavedState{");
            m253r.append(Integer.toHexString(System.identityHashCode(this)));
            m253r.append(" isIconified=");
            m253r.append(this.f2619a);
            m253r.append("}");
            return m253r.toString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f2619a));
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2619a = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {

        /* renamed from: a */
        public int f2620a;

        /* renamed from: b */
        public SearchView f2621b;

        /* renamed from: c */
        public boolean f2622c;

        /* renamed from: d */
        public final Runnable f2623d;

        /* renamed from: androidx.appcompat.widget.SearchView$SearchAutoComplete$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class RunnableC0680a implements Runnable {
            public RunnableC0680a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete searchAutoComplete = SearchAutoComplete.this;
                if (searchAutoComplete.f2622c) {
                    ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
                    searchAutoComplete.f2622c = false;
                }
            }
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        /* renamed from: a */
        public void m1591a() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            C0694n c0694n = SearchView.f2568c0;
            Objects.requireNonNull(c0694n);
            C0694n.m1588a();
            Method method = c0694n.f2637c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        /* renamed from: b */
        public void m1590b(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f2622c = false;
                removeCallbacks(this.f2623d);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.f2622c = false;
                removeCallbacks(this.f2623d);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.f2622c = true;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f2620a <= 0 || super.enoughToFilter();
        }

        @Override // androidx.appcompat.widget.AppCompatAutoCompleteTextView, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f2622c) {
                removeCallbacks(this.f2623d);
                post(this.f2623d);
            }
            return onCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            setMinWidth((int) TypedValue.applyDimension(1, (i < 960 || i2 < 720 || configuration.orientation != 2) ? (i >= 600 || (i >= 640 && i2 >= 480)) ? 192 : 160 : 256, displayMetrics));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            SearchView searchView = this.f2621b;
            searchView.m1593s(searchView.f2571C);
            searchView.post(searchView.f2585Q);
            if (searchView.f2592a.hasFocus()) {
                searchView.m1606f();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f2621b.clearFocus();
                        m1590b(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f2621b.hasFocus() && getVisibility() == 0) {
                this.f2622c = true;
                Context context = getContext();
                C0694n c0694n = SearchView.f2568c0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    m1591a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f2620a = i;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C1671f.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f2623d = new RunnableC0680a();
            this.f2620a = getThreshold();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0681a implements TextWatcher {
        public C0681a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SearchView searchView = SearchView.this;
            Editable text = searchView.f2592a.getText();
            searchView.f2580L = text;
            boolean z = !TextUtils.isEmpty(text);
            searchView.m1594r(z);
            searchView.m1592t(!z);
            searchView.m1598n();
            searchView.m1595q();
            if (searchView.f2615w != null && !TextUtils.equals(charSequence, searchView.f2579K)) {
                searchView.f2615w.onQueryTextChange(charSequence.toString());
            }
            searchView.f2579K = charSequence.toString();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0682b implements Runnable {
        public RunnableC0682b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.m1597o();
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0683c implements Runnable {
        public RunnableC0683c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC2172p5 abstractC2172p5 = SearchView.this.f2572D;
            if (abstractC2172p5 instanceof View$OnClickListenerC0487V0) {
                abstractC2172p5.mo444b(null);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnFocusChangeListenerC0684d implements View.OnFocusChangeListener {
        public View$OnFocusChangeListenerC0684d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f2617y;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnLayoutChangeListenerC0685e implements View.OnLayoutChangeListener {
        public View$OnLayoutChangeListenerC0685e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            int i9;
            int i10;
            SearchView searchView = SearchView.this;
            if (searchView.f2602j.getWidth() > 1) {
                Resources resources = searchView.getContext().getResources();
                int paddingLeft = searchView.f2596c.getPaddingLeft();
                Rect rect = new Rect();
                boolean m786b = C1852h1.m786b(searchView);
                if (searchView.f2570B) {
                    i9 = resources.getDimensionPixelSize(C1881i.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(C1881i.abc_dropdownitem_icon_width);
                } else {
                    i9 = 0;
                }
                searchView.f2592a.getDropDownBackground().getPadding(rect);
                if (m786b) {
                    i10 = -rect.left;
                } else {
                    i10 = paddingLeft - (rect.left + i9);
                }
                searchView.f2592a.setDropDownHorizontalOffset(i10);
                searchView.f2592a.setDropDownWidth((((searchView.f2602j.getWidth() + rect.left) + rect.right) + i9) - paddingLeft);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnClickListenerC0686f implements View.OnClickListener {
        public View$OnClickListenerC0686f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f2598f) {
                searchView.m1602j();
            } else if (view == searchView.f2600h) {
                searchView.m1604h();
            } else if (view == searchView.f2599g) {
                searchView.m1601k();
            } else if (view == searchView.f2601i) {
                SearchableInfo searchableInfo = searchView.f2583O;
                if (searchableInfo == null) {
                    return;
                }
                try {
                    if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                        Intent intent = new Intent(searchView.f2612t);
                        ComponentName searchActivity = searchableInfo.getSearchActivity();
                        intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                        searchView.getContext().startActivity(intent);
                    } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                        searchView.getContext().startActivity(searchView.m1607e(searchView.f2613u, searchableInfo));
                    }
                } catch (ActivityNotFoundException unused) {
                    Log.w("SearchView", "Could not find voice search activity");
                }
            } else if (view == searchView.f2592a) {
                searchView.m1606f();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnKeyListenerC0687g implements View.OnKeyListener {
        public View$OnKeyListenerC0687g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f2583O == null) {
                return false;
            }
            if (searchView.f2592a.isPopupShowing() && SearchView.this.f2592a.getListSelection() != -1) {
                return SearchView.this.m1600l(i, keyEvent);
            }
            if (!(TextUtils.getTrimmedLength(SearchView.this.f2592a.getText()) == 0) && keyEvent.hasNoModifiers() && keyEvent.getAction() == 1 && i == 66) {
                view.cancelLongPress();
                SearchView searchView2 = SearchView.this;
                searchView2.m1605g(0, null, searchView2.f2592a.getText().toString());
                return true;
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0688h implements TextView.OnEditorActionListener {
        public C0688h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            SearchView.this.m1601k();
            return true;
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0689i implements AdapterView.OnItemClickListener {
        public C0689i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView.this.m1603i(i);
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0690j implements AdapterView.OnItemSelectedListener {
        public C0690j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            SearchView searchView = SearchView.this;
            InterfaceC0693m interfaceC0693m = searchView.f2618z;
            if (interfaceC0693m == null || !interfaceC0693m.onSuggestionSelect(i)) {
                Editable text = searchView.f2592a.getText();
                Cursor cursor = searchView.f2572D.f6223c;
                if (cursor == null) {
                    return;
                }
                if (cursor.moveToPosition(i)) {
                    CharSequence mo443c = searchView.f2572D.mo443c(cursor);
                    if (mo443c != null) {
                        searchView.m1599m(mo443c);
                        return;
                    } else {
                        searchView.m1599m(text);
                        return;
                    }
                }
                searchView.m1599m(text);
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0691k {
        /* renamed from: a */
        boolean m1589a();
    }

    /* renamed from: androidx.appcompat.widget.SearchView$l */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0692l {
        boolean onQueryTextChange(String str);

        boolean onQueryTextSubmit(String str);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$m */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public interface InterfaceC0693m {
        boolean onSuggestionClick(int i);

        boolean onSuggestionSelect(int i);
    }

    /* renamed from: androidx.appcompat.widget.SearchView$n */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0694n {

        /* renamed from: a */
        public Method f2635a;

        /* renamed from: b */
        public Method f2636b;

        /* renamed from: c */
        public Method f2637c;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        public C0694n() {
            this.f2635a = null;
            this.f2636b = null;
            this.f2637c = null;
            m1588a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f2635a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f2636b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f2637c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* renamed from: a */
        public static void m1588a() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.SearchView$o */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0695o extends TouchDelegate {

        /* renamed from: a */
        public final View f2638a;

        /* renamed from: b */
        public final Rect f2639b;

        /* renamed from: c */
        public final Rect f2640c;

        /* renamed from: d */
        public final Rect f2641d;

        /* renamed from: e */
        public final int f2642e;

        /* renamed from: f */
        public boolean f2643f;

        public C0695o(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f2642e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f2639b = new Rect();
            this.f2641d = new Rect();
            this.f2640c = new Rect();
            m1587a(rect, rect2);
            this.f2638a = view;
        }

        /* renamed from: a */
        public void m1587a(Rect rect, Rect rect2) {
            this.f2639b.set(rect);
            this.f2641d.set(rect);
            Rect rect3 = this.f2641d;
            int i = this.f2642e;
            rect3.inset(-i, -i);
            this.f2640c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            boolean z2;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z3 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z2 = this.f2643f;
                    if (z2 && !this.f2641d.contains(x, y)) {
                        z3 = z2;
                        z = false;
                    }
                } else {
                    if (action == 3) {
                        z2 = this.f2643f;
                        this.f2643f = false;
                    }
                    z = true;
                    z3 = false;
                }
                z3 = z2;
                z = true;
            } else {
                if (this.f2639b.contains(x, y)) {
                    this.f2643f = true;
                    z = true;
                }
                z = true;
                z3 = false;
            }
            if (z3) {
                if (z && !this.f2640c.contains(x, y)) {
                    motionEvent.setLocation(this.f2638a.getWidth() / 2, this.f2638a.getHeight() / 2);
                } else {
                    Rect rect = this.f2640c;
                    motionEvent.setLocation(x - rect.left, y - rect.top);
                }
                return this.f2638a.dispatchTouchEvent(motionEvent);
            }
            return false;
        }
    }

    static {
        f2568c0 = Build.VERSION.SDK_INT < 29 ? new C0694n() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    @Override // p000.InterfaceC0529W
    /* renamed from: b */
    public void mo599b() {
        if (this.f2581M) {
            return;
        }
        this.f2581M = true;
        int imeOptions = this.f2592a.getImeOptions();
        this.f2582N = imeOptions;
        this.f2592a.setImeOptions(imeOptions | 33554432);
        this.f2592a.setText("");
        setIconified(false);
    }

    @Override // p000.InterfaceC0529W
    /* renamed from: c */
    public void mo598c() {
        setQuery("", false);
        clearFocus();
        m1593s(true);
        this.f2592a.setImeOptions(this.f2582N);
        this.f2581M = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f2576H = true;
        super.clearFocus();
        this.f2592a.clearFocus();
        this.f2592a.m1590b(false);
        this.f2576H = false;
    }

    /* renamed from: d */
    public final Intent m1608d(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f2580L);
        if (str3 != null) {
            intent.putExtra(SearchIntents.EXTRA_QUERY, str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f2584P;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f2583O.getSearchActivity());
        return intent;
    }

    /* renamed from: e */
    public final Intent m1607e(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f2584P;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    /* renamed from: f */
    public void m1606f() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2592a.refreshAutoCompleteResults();
            return;
        }
        C0694n c0694n = f2568c0;
        SearchAutoComplete searchAutoComplete = this.f2592a;
        Objects.requireNonNull(c0694n);
        C0694n.m1588a();
        Method method = c0694n.f2635a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused) {
            }
        }
        C0694n c0694n2 = f2568c0;
        SearchAutoComplete searchAutoComplete2 = this.f2592a;
        Objects.requireNonNull(c0694n2);
        C0694n.m1588a();
        Method method2 = c0694n2.f2636b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete2, new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    /* renamed from: g */
    public void m1605g(int i, String str, String str2) {
        getContext().startActivity(m1608d("android.intent.action.SEARCH", null, null, str2, i, null));
    }

    /* renamed from: h */
    public void m1604h() {
        if (TextUtils.isEmpty(this.f2592a.getText())) {
            if (this.f2570B) {
                InterfaceC0691k interfaceC0691k = this.f2616x;
                if (interfaceC0691k == null || !interfaceC0691k.m1589a()) {
                    clearFocus();
                    m1593s(true);
                    return;
                }
                return;
            }
            return;
        }
        this.f2592a.setText("");
        this.f2592a.requestFocus();
        this.f2592a.m1590b(true);
    }

    /* renamed from: i */
    public boolean m1603i(int i) {
        int i2;
        String m1972h;
        InterfaceC0693m interfaceC0693m = this.f2618z;
        if (interfaceC0693m == null || !interfaceC0693m.onSuggestionClick(i)) {
            Cursor cursor = this.f2572D.f6223c;
            if (cursor != null && cursor.moveToPosition(i)) {
                Intent intent = null;
                try {
                    int i3 = View$OnClickListenerC0487V0.f1772z;
                    String m1972h2 = View$OnClickListenerC0487V0.m1972h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                    if (m1972h2 == null) {
                        m1972h2 = this.f2583O.getSuggestIntentAction();
                    }
                    if (m1972h2 == null) {
                        m1972h2 = "android.intent.action.SEARCH";
                    }
                    String str = m1972h2;
                    String m1972h3 = View$OnClickListenerC0487V0.m1972h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                    if (m1972h3 == null) {
                        m1972h3 = this.f2583O.getSuggestIntentData();
                    }
                    if (m1972h3 != null && (m1972h = View$OnClickListenerC0487V0.m1972h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                        m1972h3 = m1972h3 + "/" + Uri.encode(m1972h);
                    }
                    intent = m1608d(str, m1972h3 == null ? null : Uri.parse(m1972h3), View$OnClickListenerC0487V0.m1972h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), View$OnClickListenerC0487V0.m1972h(cursor, cursor.getColumnIndex("suggest_intent_query")), 0, null);
                } catch (RuntimeException e) {
                    try {
                        i2 = cursor.getPosition();
                    } catch (RuntimeException unused) {
                        i2 = -1;
                    }
                    Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e);
                }
                if (intent != null) {
                    try {
                        getContext().startActivity(intent);
                    } catch (RuntimeException e2) {
                        Log.e("SearchView", "Failed launch activity: " + intent, e2);
                    }
                }
            }
            this.f2592a.m1590b(false);
            this.f2592a.dismissDropDown();
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public void m1602j() {
        m1593s(false);
        this.f2592a.requestFocus();
        this.f2592a.m1590b(true);
        View.OnClickListener onClickListener = this.f2569A;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    /* renamed from: k */
    public void m1601k() {
        Editable text = this.f2592a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        InterfaceC0692l interfaceC0692l = this.f2615w;
        if (interfaceC0692l == null || !interfaceC0692l.onQueryTextSubmit(text.toString())) {
            if (this.f2583O != null) {
                m1605g(0, null, text.toString());
            }
            this.f2592a.m1590b(false);
            this.f2592a.dismissDropDown();
        }
    }

    /* renamed from: l */
    public boolean m1600l(int i, KeyEvent keyEvent) {
        if (this.f2583O != null && this.f2572D != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return m1603i(this.f2592a.getListSelection());
            }
            if (i != 21 && i != 22) {
                if (i != 19 || this.f2592a.getListSelection() == 0) {
                    return false;
                }
            } else {
                this.f2592a.setSelection(i == 21 ? 0 : this.f2592a.length());
                this.f2592a.setListSelection(0);
                this.f2592a.clearListSelection();
                this.f2592a.m1591a();
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public final void m1599m(CharSequence charSequence) {
        this.f2592a.setText(charSequence);
        this.f2592a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* renamed from: n */
    public final void m1598n() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f2592a.getText());
        if (!z2 && (!this.f2570B || this.f2581M)) {
            z = false;
        }
        this.f2600h.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f2600h.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    /* renamed from: o */
    public void m1597o() {
        int[] iArr = this.f2592a.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f2596c.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f2597d.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f2585Q);
        post(this.f2586R);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.f2592a;
            Rect rect = this.f2604l;
            searchAutoComplete.getLocationInWindow(this.f2606n);
            getLocationInWindow(this.f2607o);
            int[] iArr = this.f2606n;
            int i5 = iArr[1];
            int[] iArr2 = this.f2607o;
            int i6 = i5 - iArr2[1];
            int i7 = iArr[0] - iArr2[0];
            rect.set(i7, i6, searchAutoComplete.getWidth() + i7, searchAutoComplete.getHeight() + i6);
            Rect rect2 = this.f2605m;
            Rect rect3 = this.f2604l;
            rect2.set(rect3.left, 0, rect3.right, i4 - i2);
            C0695o c0695o = this.f2603k;
            if (c0695o == null) {
                C0695o c0695o2 = new C0695o(this.f2605m, this.f2604l, this.f2592a);
                this.f2603k = c0695o2;
                setTouchDelegate(c0695o2);
                return;
            }
            c0695o.m1587a(this.f2605m, this.f2604l);
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (this.f2571C) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.f2577I;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getContext().getResources().getDimensionPixelSize(C1881i.abc_search_view_preferred_width), size);
        } else if (mode == 0) {
            size = this.f2577I;
            if (size <= 0) {
                size = getContext().getResources().getDimensionPixelSize(C1881i.abc_search_view_preferred_width);
            }
        } else if (mode == 1073741824 && (i3 = this.f2577I) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getContext().getResources().getDimensionPixelSize(C1881i.abc_search_view_preferred_height), size2);
        } else if (mode2 == 0) {
            size2 = getContext().getResources().getDimensionPixelSize(C1881i.abc_search_view_preferred_height);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        m1593s(savedState.f2619a);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2619a = this.f2571C;
        return savedState;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        post(this.f2585Q);
    }

    /* renamed from: p */
    public final void m1596p() {
        SpannableStringBuilder spannableStringBuilder = this.f2574F;
        if (spannableStringBuilder == null) {
            SearchableInfo searchableInfo = this.f2583O;
            if (searchableInfo != null && searchableInfo.getHintId() != 0) {
                spannableStringBuilder = getContext().getText(this.f2583O.getHintId());
            } else {
                spannableStringBuilder = this.f2614v;
            }
        }
        SearchAutoComplete searchAutoComplete = this.f2592a;
        if (spannableStringBuilder == null) {
            spannableStringBuilder = "";
        }
        if (this.f2570B && this.f2609q != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            this.f2609q.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("   ");
            spannableStringBuilder2.setSpan(new ImageSpan(this.f2609q), 1, 2, 33);
            spannableStringBuilder2.append(spannableStringBuilder);
            spannableStringBuilder = spannableStringBuilder2;
        }
        searchAutoComplete.setHint(spannableStringBuilder);
    }

    /* renamed from: q */
    public final void m1595q() {
        int i = 0;
        if (!((this.f2573E || this.f2578J) && !this.f2571C) || (this.f2599g.getVisibility() != 0 && this.f2601i.getVisibility() != 0)) {
            i = 8;
        }
        this.f2597d.setVisibility(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:
        if (r2.f2578J == false) goto L13;
     */
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m1594r(boolean r3) {
        /*
            r2 = this;
            boolean r0 = r2.f2573E
            r1 = 0
            if (r0 == 0) goto L21
            if (r0 != 0) goto Lb
            boolean r0 = r2.f2578J
            if (r0 == 0) goto L11
        Lb:
            boolean r0 = r2.f2571C
            if (r0 != 0) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L21
            boolean r0 = r2.hasFocus()
            if (r0 == 0) goto L21
            if (r3 != 0) goto L23
            boolean r3 = r2.f2578J
            if (r3 != 0) goto L21
            goto L23
        L21:
            r1 = 8
        L23:
            android.widget.ImageView r3 = r2.f2599g
            r3.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.m1594r(boolean):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (!this.f2576H && isFocusable()) {
            if (!this.f2571C) {
                boolean requestFocus = this.f2592a.requestFocus(i, rect);
                if (requestFocus) {
                    m1593s(false);
                }
                return requestFocus;
            }
            return super.requestFocus(i, rect);
        }
        return false;
    }

    /* renamed from: s */
    public final void m1593s(boolean z) {
        this.f2571C = z;
        int i = 0;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f2592a.getText());
        this.f2598f.setVisibility(i2);
        m1594r(z2);
        this.f2594b.setVisibility(z ? 8 : 0);
        this.f2608p.setVisibility((this.f2608p.getDrawable() == null || this.f2570B) ? 8 : 8);
        m1598n();
        m1592t(!z2);
        m1595q();
    }

    public void setAppSearchData(Bundle bundle) {
        this.f2584P = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m1604h();
        } else {
            m1602j();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f2570B == z) {
            return;
        }
        this.f2570B = z;
        m1593s(z);
        m1596p();
    }

    public void setImeOptions(int i) {
        this.f2592a.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f2592a.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f2577I = i;
        requestLayout();
    }

    public void setOnCloseListener(InterfaceC0691k interfaceC0691k) {
        this.f2616x = interfaceC0691k;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f2617y = onFocusChangeListener;
    }

    public void setOnQueryTextListener(InterfaceC0692l interfaceC0692l) {
        this.f2615w = interfaceC0692l;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f2569A = onClickListener;
    }

    public void setOnSuggestionListener(InterfaceC0693m interfaceC0693m) {
        this.f2618z = interfaceC0693m;
    }

    public void setQuery(CharSequence charSequence, boolean z) {
        this.f2592a.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f2592a;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f2580L = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        m1601k();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f2574F = charSequence;
        m1596p();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f2575G = z;
        AbstractC2172p5 abstractC2172p5 = this.f2572D;
        if (abstractC2172p5 instanceof View$OnClickListenerC0487V0) {
            ((View$OnClickListenerC0487V0) abstractC2172p5).f1778r = z ? 2 : 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009c, code lost:
        if (getContext().getPackageManager().resolveActivity(r2, 65536) != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.f2583O = r7
            r0 = 1
            r1 = 65536(0x10000, float:9.18355E-41)
            r2 = 0
            if (r7 == 0) goto L6e
            androidx.appcompat.widget.SearchView$SearchAutoComplete r3 = r6.f2592a
            int r7 = r7.getSuggestThreshold()
            r3.setThreshold(r7)
            androidx.appcompat.widget.SearchView$SearchAutoComplete r7 = r6.f2592a
            android.app.SearchableInfo r3 = r6.f2583O
            int r3 = r3.getImeOptions()
            r7.setImeOptions(r3)
            android.app.SearchableInfo r7 = r6.f2583O
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r0) goto L36
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f2583O
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L36
            r7 = r7 | r1
            r3 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 | r3
        L36:
            androidx.appcompat.widget.SearchView$SearchAutoComplete r3 = r6.f2592a
            r3.setInputType(r7)
            p5 r7 = r6.f2572D
            if (r7 == 0) goto L42
            r7.mo444b(r2)
        L42:
            android.app.SearchableInfo r7 = r6.f2583O
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L6b
            V0 r7 = new V0
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f2583O
            java.util.WeakHashMap<java.lang.String, android.graphics.drawable.Drawable$ConstantState> r5 = r6.f2587S
            r7.<init>(r3, r6, r4, r5)
            r6.f2572D = r7
            androidx.appcompat.widget.SearchView$SearchAutoComplete r3 = r6.f2592a
            r3.setAdapter(r7)
            p5 r7 = r6.f2572D
            V0 r7 = (p000.View$OnClickListenerC0487V0) r7
            boolean r3 = r6.f2575G
            if (r3 == 0) goto L68
            r3 = 2
            goto L69
        L68:
            r3 = 1
        L69:
            r7.f1778r = r3
        L6b:
            r6.m1596p()
        L6e:
            android.app.SearchableInfo r7 = r6.f2583O
            r3 = 0
            if (r7 == 0) goto L9f
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L9f
            android.app.SearchableInfo r7 = r6.f2583O
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L84
            android.content.Intent r2 = r6.f2612t
            goto L8e
        L84:
            android.app.SearchableInfo r7 = r6.f2583O
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L8e
            android.content.Intent r2 = r6.f2613u
        L8e:
            if (r2 == 0) goto L9f
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r2, r1)
            if (r7 == 0) goto L9f
            goto La0
        L9f:
            r0 = 0
        La0:
            r6.f2578J = r0
            if (r0 == 0) goto Lab
            androidx.appcompat.widget.SearchView$SearchAutoComplete r7 = r6.f2592a
            java.lang.String r0 = "nm"
            r7.setPrivateImeOptions(r0)
        Lab:
            boolean r7 = r6.f2571C
            r6.m1593s(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f2573E = z;
        m1593s(this.f2571C);
    }

    public void setSuggestionsAdapter(AbstractC2172p5 abstractC2172p5) {
        this.f2572D = abstractC2172p5;
        this.f2592a.setAdapter(abstractC2172p5);
    }

    /* renamed from: t */
    public final void m1592t(boolean z) {
        int i = 8;
        if (this.f2578J && !this.f2571C && z) {
            this.f2599g.setVisibility(8);
            i = 0;
        }
        this.f2601i.setVisibility(i);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1671f.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2604l = new Rect();
        this.f2605m = new Rect();
        this.f2606n = new int[2];
        this.f2607o = new int[2];
        this.f2585Q = new RunnableC0682b();
        this.f2586R = new RunnableC0683c();
        this.f2587S = new WeakHashMap<>();
        View$OnClickListenerC0686f view$OnClickListenerC0686f = new View$OnClickListenerC0686f();
        this.f2588T = view$OnClickListenerC0686f;
        this.f2589U = new View$OnKeyListenerC0687g();
        C0688h c0688h = new C0688h();
        this.f2590V = c0688h;
        C0689i c0689i = new C0689i();
        this.f2591W = c0689i;
        C0690j c0690j = new C0690j();
        this.f2593a0 = c0690j;
        this.f2595b0 = new C0681a();
        C0954b1 c0954b1 = new C0954b1(context, context.obtainStyledAttributes(attributeSet, C2012o.SearchView, i, 0));
        LayoutInflater.from(context).inflate(c0954b1.m1201m(C2012o.SearchView_layout, C1949l.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(C1930k.search_src_text);
        this.f2592a = searchAutoComplete;
        searchAutoComplete.f2621b = this;
        this.f2594b = findViewById(C1930k.search_edit_frame);
        View findViewById = findViewById(C1930k.search_plate);
        this.f2596c = findViewById;
        View findViewById2 = findViewById(C1930k.submit_area);
        this.f2597d = findViewById2;
        ImageView imageView = (ImageView) findViewById(C1930k.search_button);
        this.f2598f = imageView;
        ImageView imageView2 = (ImageView) findViewById(C1930k.search_go_btn);
        this.f2599g = imageView2;
        ImageView imageView3 = (ImageView) findViewById(C1930k.search_close_btn);
        this.f2600h = imageView3;
        ImageView imageView4 = (ImageView) findViewById(C1930k.search_voice_btn);
        this.f2601i = imageView4;
        ImageView imageView5 = (ImageView) findViewById(C1930k.search_mag_icon);
        this.f2608p = imageView5;
        Drawable m1207g = c0954b1.m1207g(C2012o.SearchView_queryBackground);
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1927q(findViewById, m1207g);
        C0492V4.C0495c.m1927q(findViewById2, c0954b1.m1207g(C2012o.SearchView_submitBackground));
        int i2 = C2012o.SearchView_searchIcon;
        imageView.setImageDrawable(c0954b1.m1207g(i2));
        imageView2.setImageDrawable(c0954b1.m1207g(C2012o.SearchView_goIcon));
        imageView3.setImageDrawable(c0954b1.m1207g(C2012o.SearchView_closeIcon));
        imageView4.setImageDrawable(c0954b1.m1207g(C2012o.SearchView_voiceIcon));
        imageView5.setImageDrawable(c0954b1.m1207g(i2));
        this.f2609q = c0954b1.m1207g(C2012o.SearchView_searchHintIcon);
        LayoutInflater$Factory2C0000A.C0010h.m2616r0(imageView, getResources().getString(C1967m.abc_searchview_description_search));
        this.f2610r = c0954b1.m1201m(C2012o.SearchView_suggestionRowLayout, C1949l.abc_search_dropdown_item_icons_2line);
        this.f2611s = c0954b1.m1201m(C2012o.SearchView_commitIcon, 0);
        imageView.setOnClickListener(view$OnClickListenerC0686f);
        imageView3.setOnClickListener(view$OnClickListenerC0686f);
        imageView2.setOnClickListener(view$OnClickListenerC0686f);
        imageView4.setOnClickListener(view$OnClickListenerC0686f);
        searchAutoComplete.setOnClickListener(view$OnClickListenerC0686f);
        searchAutoComplete.addTextChangedListener(this.f2595b0);
        searchAutoComplete.setOnEditorActionListener(c0688h);
        searchAutoComplete.setOnItemClickListener(c0689i);
        searchAutoComplete.setOnItemSelectedListener(c0690j);
        searchAutoComplete.setOnKeyListener(this.f2589U);
        searchAutoComplete.setOnFocusChangeListener(new View$OnFocusChangeListenerC0684d());
        setIconifiedByDefault(c0954b1.m1213a(C2012o.SearchView_iconifiedByDefault, true));
        int m1208f = c0954b1.m1208f(C2012o.SearchView_android_maxWidth, -1);
        if (m1208f != -1) {
            setMaxWidth(m1208f);
        }
        this.f2614v = c0954b1.m1199o(C2012o.SearchView_defaultQueryHint);
        this.f2574F = c0954b1.m1199o(C2012o.SearchView_queryHint);
        int m1204j = c0954b1.m1204j(C2012o.SearchView_android_imeOptions, -1);
        if (m1204j != -1) {
            setImeOptions(m1204j);
        }
        int m1204j2 = c0954b1.m1204j(C2012o.SearchView_android_inputType, -1);
        if (m1204j2 != -1) {
            setInputType(m1204j2);
        }
        setFocusable(c0954b1.m1213a(C2012o.SearchView_android_focusable, true));
        c0954b1.f3660b.recycle();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f2612t = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f2613u = intent2;
        intent2.addFlags(268435456);
        View findViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f2602j = findViewById3;
        if (findViewById3 != null) {
            findViewById3.addOnLayoutChangeListener(new View$OnLayoutChangeListenerC0685e());
        }
        m1593s(this.f2570B);
        m1596p();
    }
}
