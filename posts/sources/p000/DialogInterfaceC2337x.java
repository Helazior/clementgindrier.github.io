package p000;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.widget.NestedScrollView;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import p000.C0492V4;

/* renamed from: x */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class DialogInterfaceC2336x extends DialogC0124F implements DialogInterface {

    /* renamed from: a */
    public final AlertController f6797a;

    /* renamed from: x$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C2337a {

        /* renamed from: P */
        private final AlertController.C0632b f6798P;
        private final int mTheme;

        public C2337a(Context context) {
            this(context, DialogInterfaceC2336x.m136a(context, 0));
        }

        public DialogInterfaceC2336x create() {
            int i;
            ListAdapter listAdapter;
            DialogInterfaceC2336x dialogInterfaceC2336x = new DialogInterfaceC2336x(this.f6798P.f2275a, this.mTheme);
            AlertController.C0632b c0632b = this.f6798P;
            AlertController alertController = dialogInterfaceC2336x.f6797a;
            View view = c0632b.f2280f;
            if (view != null) {
                alertController.f2221G = view;
            } else {
                CharSequence charSequence = c0632b.f2279e;
                if (charSequence != null) {
                    alertController.f2237e = charSequence;
                    TextView textView = alertController.f2219E;
                    if (textView != null) {
                        textView.setText(charSequence);
                    }
                }
                Drawable drawable = c0632b.f2278d;
                if (drawable != null) {
                    alertController.f2217C = drawable;
                    alertController.f2216B = 0;
                    ImageView imageView = alertController.f2218D;
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        alertController.f2218D.setImageDrawable(drawable);
                    }
                }
                int i2 = c0632b.f2277c;
                if (i2 != 0) {
                    alertController.m1688f(i2);
                }
            }
            CharSequence charSequence2 = c0632b.f2281g;
            if (charSequence2 != null) {
                alertController.f2238f = charSequence2;
                TextView textView2 = alertController.f2220F;
                if (textView2 != null) {
                    textView2.setText(charSequence2);
                }
            }
            CharSequence charSequence3 = c0632b.f2282h;
            if (charSequence3 != null || c0632b.f2283i != null) {
                alertController.m1689e(-1, charSequence3, c0632b.f2284j, null, c0632b.f2283i);
            }
            CharSequence charSequence4 = c0632b.f2285k;
            if (charSequence4 != null || c0632b.f2286l != null) {
                alertController.m1689e(-2, charSequence4, c0632b.f2287m, null, c0632b.f2286l);
            }
            CharSequence charSequence5 = c0632b.f2288n;
            if (charSequence5 != null || c0632b.f2289o != null) {
                alertController.m1689e(-3, charSequence5, c0632b.f2290p, null, c0632b.f2289o);
            }
            if (c0632b.f2295u != null || c0632b.f2271J != null || c0632b.f2296v != null) {
                AlertController.RecycleListView recycleListView = (AlertController.RecycleListView) c0632b.f2276b.inflate(alertController.f2226L, (ViewGroup) null);
                if (c0632b.f2267F) {
                    if (c0632b.f2271J == null) {
                        listAdapter = new C2243t(c0632b, c0632b.f2275a, alertController.f2227M, 16908308, c0632b.f2295u, recycleListView);
                    } else {
                        listAdapter = new C2266u(c0632b, c0632b.f2275a, c0632b.f2271J, false, recycleListView, alertController);
                    }
                } else {
                    if (c0632b.f2268G) {
                        i = alertController.f2228N;
                    } else {
                        i = alertController.f2229O;
                    }
                    int i3 = i;
                    if (c0632b.f2271J != null) {
                        listAdapter = new SimpleCursorAdapter(c0632b.f2275a, i3, c0632b.f2271J, new String[]{c0632b.f2272K}, new int[]{16908308});
                    } else {
                        listAdapter = c0632b.f2296v;
                        if (listAdapter == null) {
                            listAdapter = new AlertController.C0634d(c0632b.f2275a, i3, 16908308, c0632b.f2295u);
                        }
                    }
                }
                alertController.f2222H = listAdapter;
                alertController.f2223I = c0632b.f2269H;
                if (c0632b.f2297w != null) {
                    recycleListView.setOnItemClickListener(new C2284v(c0632b, alertController));
                } else if (c0632b.f2270I != null) {
                    recycleListView.setOnItemClickListener(new C2302w(c0632b, recycleListView, alertController));
                }
                AdapterView.OnItemSelectedListener onItemSelectedListener = c0632b.f2274M;
                if (onItemSelectedListener != null) {
                    recycleListView.setOnItemSelectedListener(onItemSelectedListener);
                }
                if (c0632b.f2268G) {
                    recycleListView.setChoiceMode(1);
                } else if (c0632b.f2267F) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.f2239g = recycleListView;
            }
            View view2 = c0632b.f2299y;
            if (view2 != null) {
                if (c0632b.f2265D) {
                    int i4 = c0632b.f2300z;
                    int i5 = c0632b.f2262A;
                    int i6 = c0632b.f2263B;
                    int i7 = c0632b.f2264C;
                    alertController.f2240h = view2;
                    alertController.f2241i = 0;
                    alertController.f2246n = true;
                    alertController.f2242j = i4;
                    alertController.f2243k = i5;
                    alertController.f2244l = i6;
                    alertController.f2245m = i7;
                } else {
                    alertController.f2240h = view2;
                    alertController.f2241i = 0;
                    alertController.f2246n = false;
                }
            } else {
                int i8 = c0632b.f2298x;
                if (i8 != 0) {
                    alertController.f2240h = null;
                    alertController.f2241i = i8;
                    alertController.f2246n = false;
                }
            }
            dialogInterfaceC2336x.setCancelable(this.f6798P.f2291q);
            if (this.f6798P.f2291q) {
                dialogInterfaceC2336x.setCanceledOnTouchOutside(true);
            }
            dialogInterfaceC2336x.setOnCancelListener(this.f6798P.f2292r);
            dialogInterfaceC2336x.setOnDismissListener(this.f6798P.f2293s);
            DialogInterface.OnKeyListener onKeyListener = this.f6798P.f2294t;
            if (onKeyListener != null) {
                dialogInterfaceC2336x.setOnKeyListener(onKeyListener);
            }
            return dialogInterfaceC2336x;
        }

        public Context getContext() {
            return this.f6798P.f2275a;
        }

        public C2337a setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2296v = listAdapter;
            c0632b.f2297w = onClickListener;
            return this;
        }

        public C2337a setCancelable(boolean z) {
            this.f6798P.f2291q = z;
            return this;
        }

        public C2337a setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2271J = cursor;
            c0632b.f2272K = str;
            c0632b.f2297w = onClickListener;
            return this;
        }

        public C2337a setCustomTitle(View view) {
            this.f6798P.f2280f = view;
            return this;
        }

        public C2337a setIcon(int i) {
            this.f6798P.f2277c = i;
            return this;
        }

        public C2337a setIconAttribute(int i) {
            TypedValue typedValue = new TypedValue();
            this.f6798P.f2275a.getTheme().resolveAttribute(i, typedValue, true);
            this.f6798P.f2277c = typedValue.resourceId;
            return this;
        }

        @Deprecated
        public C2337a setInverseBackgroundForced(boolean z) {
            Objects.requireNonNull(this.f6798P);
            return this;
        }

        public C2337a setItems(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2295u = c0632b.f2275a.getResources().getTextArray(i);
            this.f6798P.f2297w = onClickListener;
            return this;
        }

        public C2337a setMessage(int i) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2281g = c0632b.f2275a.getText(i);
            return this;
        }

        public C2337a setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2295u = c0632b.f2275a.getResources().getTextArray(i);
            AlertController.C0632b c0632b2 = this.f6798P;
            c0632b2.f2270I = onMultiChoiceClickListener;
            c0632b2.f2266E = zArr;
            c0632b2.f2267F = true;
            return this;
        }

        public C2337a setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2285k = c0632b.f2275a.getText(i);
            this.f6798P.f2287m = onClickListener;
            return this;
        }

        public C2337a setNegativeButtonIcon(Drawable drawable) {
            this.f6798P.f2286l = drawable;
            return this;
        }

        public C2337a setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2288n = c0632b.f2275a.getText(i);
            this.f6798P.f2290p = onClickListener;
            return this;
        }

        public C2337a setNeutralButtonIcon(Drawable drawable) {
            this.f6798P.f2289o = drawable;
            return this;
        }

        public C2337a setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.f6798P.f2292r = onCancelListener;
            return this;
        }

        public C2337a setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.f6798P.f2293s = onDismissListener;
            return this;
        }

        public C2337a setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
            this.f6798P.f2274M = onItemSelectedListener;
            return this;
        }

        public C2337a setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.f6798P.f2294t = onKeyListener;
            return this;
        }

        public C2337a setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2282h = c0632b.f2275a.getText(i);
            this.f6798P.f2284j = onClickListener;
            return this;
        }

        public C2337a setPositiveButtonIcon(Drawable drawable) {
            this.f6798P.f2283i = drawable;
            return this;
        }

        public C2337a setRecycleOnMeasureEnabled(boolean z) {
            Objects.requireNonNull(this.f6798P);
            return this;
        }

        public C2337a setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2295u = c0632b.f2275a.getResources().getTextArray(i);
            AlertController.C0632b c0632b2 = this.f6798P;
            c0632b2.f2297w = onClickListener;
            c0632b2.f2269H = i2;
            c0632b2.f2268G = true;
            return this;
        }

        public C2337a setTitle(int i) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2279e = c0632b.f2275a.getText(i);
            return this;
        }

        public C2337a setView(int i) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2299y = null;
            c0632b.f2298x = i;
            c0632b.f2265D = false;
            return this;
        }

        public DialogInterfaceC2336x show() {
            DialogInterfaceC2336x create = create();
            create.show();
            return create;
        }

        public C2337a(Context context, int i) {
            this.f6798P = new AlertController.C0632b(new ContextThemeWrapper(context, DialogInterfaceC2336x.m136a(context, i)));
            this.mTheme = i;
        }

        public C2337a setIcon(Drawable drawable) {
            this.f6798P.f2278d = drawable;
            return this;
        }

        public C2337a setMessage(CharSequence charSequence) {
            this.f6798P.f2281g = charSequence;
            return this;
        }

        public C2337a setTitle(CharSequence charSequence) {
            this.f6798P.f2279e = charSequence;
            return this;
        }

        public C2337a setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2295u = charSequenceArr;
            c0632b.f2297w = onClickListener;
            return this;
        }

        public C2337a setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2285k = charSequence;
            c0632b.f2287m = onClickListener;
            return this;
        }

        public C2337a setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2288n = charSequence;
            c0632b.f2290p = onClickListener;
            return this;
        }

        public C2337a setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2282h = charSequence;
            c0632b.f2284j = onClickListener;
            return this;
        }

        public C2337a setView(View view) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2299y = view;
            c0632b.f2298x = 0;
            c0632b.f2265D = false;
            return this;
        }

        public C2337a setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2295u = charSequenceArr;
            c0632b.f2270I = onMultiChoiceClickListener;
            c0632b.f2266E = zArr;
            c0632b.f2267F = true;
            return this;
        }

        public C2337a setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2271J = cursor;
            c0632b.f2297w = onClickListener;
            c0632b.f2269H = i;
            c0632b.f2272K = str;
            c0632b.f2268G = true;
            return this;
        }

        @Deprecated
        public C2337a setView(View view, int i, int i2, int i3, int i4) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2299y = view;
            c0632b.f2298x = 0;
            c0632b.f2265D = true;
            c0632b.f2300z = i;
            c0632b.f2262A = i2;
            c0632b.f2263B = i3;
            c0632b.f2264C = i4;
            return this;
        }

        public C2337a setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2271J = cursor;
            c0632b.f2270I = onMultiChoiceClickListener;
            c0632b.f2273L = str;
            c0632b.f2272K = str2;
            c0632b.f2267F = true;
            return this;
        }

        public C2337a setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2295u = charSequenceArr;
            c0632b.f2297w = onClickListener;
            c0632b.f2269H = i;
            c0632b.f2268G = true;
            return this;
        }

        public C2337a setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.C0632b c0632b = this.f6798P;
            c0632b.f2296v = listAdapter;
            c0632b.f2297w = onClickListener;
            c0632b.f2269H = i;
            c0632b.f2268G = true;
            return this;
        }
    }

    public DialogInterfaceC2336x(Context context, int i) {
        super(context, m136a(context, i));
        this.f6797a = new AlertController(getContext(), this, getWindow());
    }

    /* renamed from: a */
    public static int m136a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C1671f.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p000.DialogC0124F, android.app.Dialog
    public void onCreate(Bundle bundle) {
        int i;
        boolean z;
        View view;
        ListAdapter listAdapter;
        View view2;
        View findViewById;
        super.onCreate(bundle);
        AlertController alertController = this.f6797a;
        if (alertController.f2225K == 0) {
            i = alertController.f2224J;
        } else {
            i = alertController.f2224J;
        }
        alertController.f2234b.setContentView(i);
        View findViewById2 = alertController.f2235c.findViewById(C1930k.parentPanel);
        int i2 = C1930k.topPanel;
        View findViewById3 = findViewById2.findViewById(i2);
        int i3 = C1930k.contentPanel;
        View findViewById4 = findViewById2.findViewById(i3);
        int i4 = C1930k.buttonPanel;
        View findViewById5 = findViewById2.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(C1930k.customPanel);
        View view3 = alertController.f2240h;
        if (view3 == null) {
            view3 = alertController.f2241i != 0 ? LayoutInflater.from(alertController.f2233a).inflate(alertController.f2241i, viewGroup, false) : null;
        }
        boolean z2 = view3 != null;
        if (!z2 || !AlertController.m1693a(view3)) {
            alertController.f2235c.setFlags(PKIFailureInfo.unsupportedVersion, PKIFailureInfo.unsupportedVersion);
        }
        if (z2) {
            FrameLayout frameLayout = (FrameLayout) alertController.f2235c.findViewById(C1930k.custom);
            frameLayout.addView(view3, new ViewGroup.LayoutParams(-1, -1));
            if (alertController.f2246n) {
                frameLayout.setPadding(alertController.f2242j, alertController.f2243k, alertController.f2244l, alertController.f2245m);
            }
            if (alertController.f2239g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).f2509a = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(i2);
        View findViewById7 = viewGroup.findViewById(i3);
        View findViewById8 = viewGroup.findViewById(i4);
        ViewGroup m1690d = alertController.m1690d(findViewById6, findViewById3);
        ViewGroup m1690d2 = alertController.m1690d(findViewById7, findViewById4);
        ViewGroup m1690d3 = alertController.m1690d(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) alertController.f2235c.findViewById(C1930k.scrollView);
        alertController.f2215A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        alertController.f2215A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) m1690d2.findViewById(16908299);
        alertController.f2220F = textView;
        if (textView != null) {
            CharSequence charSequence = alertController.f2238f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                alertController.f2215A.removeView(alertController.f2220F);
                if (alertController.f2239g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) alertController.f2215A.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(alertController.f2215A);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(alertController.f2239g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    m1690d2.setVisibility(8);
                }
            }
        }
        Button button = (Button) m1690d3.findViewById(16908313);
        alertController.f2247o = button;
        button.setOnClickListener(alertController.f2232R);
        if (TextUtils.isEmpty(alertController.f2248p) && alertController.f2250r == null) {
            alertController.f2247o.setVisibility(8);
            z = false;
        } else {
            alertController.f2247o.setText(alertController.f2248p);
            Drawable drawable = alertController.f2250r;
            if (drawable != null) {
                int i5 = alertController.f2236d;
                drawable.setBounds(0, 0, i5, i5);
                alertController.f2247o.setCompoundDrawables(alertController.f2250r, null, null, null);
            }
            alertController.f2247o.setVisibility(0);
            z = true;
        }
        Button button2 = (Button) m1690d3.findViewById(16908314);
        alertController.f2251s = button2;
        button2.setOnClickListener(alertController.f2232R);
        if (TextUtils.isEmpty(alertController.f2252t) && alertController.f2254v == null) {
            alertController.f2251s.setVisibility(8);
        } else {
            alertController.f2251s.setText(alertController.f2252t);
            Drawable drawable2 = alertController.f2254v;
            if (drawable2 != null) {
                int i6 = alertController.f2236d;
                drawable2.setBounds(0, 0, i6, i6);
                alertController.f2251s.setCompoundDrawables(alertController.f2254v, null, null, null);
            }
            alertController.f2251s.setVisibility(0);
            z |= true;
        }
        Button button3 = (Button) m1690d3.findViewById(16908315);
        alertController.f2255w = button3;
        button3.setOnClickListener(alertController.f2232R);
        if (TextUtils.isEmpty(alertController.f2256x) && alertController.f2258z == null) {
            alertController.f2255w.setVisibility(8);
            view = null;
        } else {
            alertController.f2255w.setText(alertController.f2256x);
            Drawable drawable3 = alertController.f2258z;
            if (drawable3 != null) {
                int i7 = alertController.f2236d;
                drawable3.setBounds(0, 0, i7, i7);
                view = null;
                alertController.f2255w.setCompoundDrawables(alertController.f2258z, null, null, null);
            } else {
                view = null;
            }
            alertController.f2255w.setVisibility(0);
            z |= true;
        }
        Context context = alertController.f2233a;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C1671f.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (z) {
                alertController.m1692b(alertController.f2247o);
            } else if (z) {
                alertController.m1692b(alertController.f2251s);
            } else if (z) {
                alertController.m1692b(alertController.f2255w);
            }
        }
        if (!(z)) {
            m1690d3.setVisibility(8);
        }
        if (alertController.f2221G != null) {
            m1690d.addView(alertController.f2221G, 0, new ViewGroup.LayoutParams(-1, -2));
            alertController.f2235c.findViewById(C1930k.title_template).setVisibility(8);
        } else {
            alertController.f2218D = (ImageView) alertController.f2235c.findViewById(16908294);
            if ((!TextUtils.isEmpty(alertController.f2237e)) && alertController.f2230P) {
                TextView textView2 = (TextView) alertController.f2235c.findViewById(C1930k.alertTitle);
                alertController.f2219E = textView2;
                textView2.setText(alertController.f2237e);
                int i8 = alertController.f2216B;
                if (i8 != 0) {
                    alertController.f2218D.setImageResource(i8);
                } else {
                    Drawable drawable4 = alertController.f2217C;
                    if (drawable4 != null) {
                        alertController.f2218D.setImageDrawable(drawable4);
                    } else {
                        alertController.f2219E.setPadding(alertController.f2218D.getPaddingLeft(), alertController.f2218D.getPaddingTop(), alertController.f2218D.getPaddingRight(), alertController.f2218D.getPaddingBottom());
                        alertController.f2218D.setVisibility(8);
                    }
                }
            } else {
                alertController.f2235c.findViewById(C1930k.title_template).setVisibility(8);
                alertController.f2218D.setVisibility(8);
                m1690d.setVisibility(8);
            }
        }
        boolean z3 = viewGroup.getVisibility() != 8;
        boolean z4 = (m1690d == null || m1690d.getVisibility() == 8) ? 0 : 1;
        boolean z5 = m1690d3.getVisibility() != 8;
        if (!z5 && (findViewById = m1690d2.findViewById(C1930k.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (z4) {
            NestedScrollView nestedScrollView2 = alertController.f2215A;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View findViewById9 = (alertController.f2238f == null && alertController.f2239g == null) ? view : m1690d.findViewById(C1930k.titleDividerNoCustom);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        } else {
            View findViewById10 = m1690d2.findViewById(C1930k.textSpacerNoTitle);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        }
        ListView listView = alertController.f2239g;
        if (listView instanceof AlertController.RecycleListView) {
            ((AlertController.RecycleListView) listView).setHasDecor(z4, z5);
        }
        if (!z3) {
            View view4 = alertController.f2239g;
            if (view4 == null) {
                view4 = alertController.f2215A;
            }
            if (view4 != null) {
                int i9 = z4 | (z5 ? 2 : 0);
                View findViewById11 = alertController.f2235c.findViewById(C1930k.scrollIndicatorUp);
                View findViewById12 = alertController.f2235c.findViewById(C1930k.scrollIndicatorDown);
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 23) {
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    if (i10 >= 23) {
                        C0492V4.C0502i.m1872c(view4, i9, 3);
                    }
                    if (findViewById11 != null) {
                        m1690d2.removeView(findViewById11);
                    }
                    if (findViewById12 != null) {
                        m1690d2.removeView(findViewById12);
                    }
                } else {
                    if (findViewById11 != null && (i9 & 1) == 0) {
                        m1690d2.removeView(findViewById11);
                        findViewById11 = view;
                    }
                    if (findViewById12 == null || (i9 & 2) != 0) {
                        view2 = findViewById12;
                    } else {
                        m1690d2.removeView(findViewById12);
                        view2 = view;
                    }
                    if (findViewById11 != null || view2 != null) {
                        if (alertController.f2238f != null) {
                            alertController.f2215A.setOnScrollChangeListener(new C2164p(alertController, findViewById11, view2));
                            alertController.f2215A.post(new RunnableC2185q(alertController, findViewById11, view2));
                        } else {
                            ListView listView2 = alertController.f2239g;
                            if (listView2 != null) {
                                listView2.setOnScrollListener(new C2204r(alertController, findViewById11, view2));
                                alertController.f2239g.post(new RunnableC2221s(alertController, findViewById11, view2));
                            } else {
                                if (findViewById11 != null) {
                                    m1690d2.removeView(findViewById11);
                                }
                                if (view2 != null) {
                                    m1690d2.removeView(view2);
                                }
                            }
                        }
                    }
                }
            }
        }
        ListView listView3 = alertController.f2239g;
        if (listView3 == null || (listAdapter = alertController.f2222H) == null) {
            return;
        }
        listView3.setAdapter(listAdapter);
        int i11 = alertController.f2223I;
        if (i11 > -1) {
            listView3.setItemChecked(i11, true);
            listView3.setSelection(i11);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f6797a.f2215A;
        if (nestedScrollView != null && nestedScrollView.m1485i(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f6797a.f2215A;
        if (nestedScrollView != null && nestedScrollView.m1485i(keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // p000.DialogC0124F, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        AlertController alertController = this.f6797a;
        alertController.f2237e = charSequence;
        TextView textView = alertController.f2219E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
