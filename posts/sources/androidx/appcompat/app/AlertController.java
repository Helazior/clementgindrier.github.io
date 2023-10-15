package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class AlertController {

    /* renamed from: A */
    public NestedScrollView f2215A;

    /* renamed from: C */
    public Drawable f2217C;

    /* renamed from: D */
    public ImageView f2218D;

    /* renamed from: E */
    public TextView f2219E;

    /* renamed from: F */
    public TextView f2220F;

    /* renamed from: G */
    public View f2221G;

    /* renamed from: H */
    public ListAdapter f2222H;

    /* renamed from: J */
    public int f2224J;

    /* renamed from: K */
    public int f2225K;

    /* renamed from: L */
    public int f2226L;

    /* renamed from: M */
    public int f2227M;

    /* renamed from: N */
    public int f2228N;

    /* renamed from: O */
    public int f2229O;

    /* renamed from: P */
    public boolean f2230P;

    /* renamed from: Q */
    public Handler f2231Q;

    /* renamed from: a */
    public final Context f2233a;

    /* renamed from: b */
    public final DialogC0124F f2234b;

    /* renamed from: c */
    public final Window f2235c;

    /* renamed from: d */
    public final int f2236d;

    /* renamed from: e */
    public CharSequence f2237e;

    /* renamed from: f */
    public CharSequence f2238f;

    /* renamed from: g */
    public ListView f2239g;

    /* renamed from: h */
    public View f2240h;

    /* renamed from: i */
    public int f2241i;

    /* renamed from: j */
    public int f2242j;

    /* renamed from: k */
    public int f2243k;

    /* renamed from: l */
    public int f2244l;

    /* renamed from: m */
    public int f2245m;

    /* renamed from: o */
    public Button f2247o;

    /* renamed from: p */
    public CharSequence f2248p;

    /* renamed from: q */
    public Message f2249q;

    /* renamed from: r */
    public Drawable f2250r;

    /* renamed from: s */
    public Button f2251s;

    /* renamed from: t */
    public CharSequence f2252t;

    /* renamed from: u */
    public Message f2253u;

    /* renamed from: v */
    public Drawable f2254v;

    /* renamed from: w */
    public Button f2255w;

    /* renamed from: x */
    public CharSequence f2256x;

    /* renamed from: y */
    public Message f2257y;

    /* renamed from: z */
    public Drawable f2258z;

    /* renamed from: n */
    public boolean f2246n = false;

    /* renamed from: B */
    public int f2216B = 0;

    /* renamed from: I */
    public int f2223I = -1;

    /* renamed from: R */
    public final View.OnClickListener f2232R = new View$OnClickListenerC0631a();

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a */
        public final int f2259a;

        /* renamed from: b */
        public final int f2260b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f2259a, getPaddingRight(), z2 ? getPaddingBottom() : this.f2260b);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2012o.RecycleListView);
            this.f2260b = obtainStyledAttributes.getDimensionPixelOffset(C2012o.RecycleListView_paddingBottomNoButtons, -1);
            this.f2259a = obtainStyledAttributes.getDimensionPixelOffset(C2012o.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class View$OnClickListenerC0631a implements View.OnClickListener {
        public View$OnClickListenerC0631a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message obtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.f2247o && (message3 = alertController.f2249q) != null) {
                obtain = Message.obtain(message3);
            } else if (view == alertController.f2251s && (message2 = alertController.f2253u) != null) {
                obtain = Message.obtain(message2);
            } else {
                obtain = (view != alertController.f2255w || (message = alertController.f2257y) == null) ? null : Message.obtain(message);
            }
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.f2231Q.obtainMessage(1, alertController2.f2234b).sendToTarget();
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0632b {

        /* renamed from: A */
        public int f2262A;

        /* renamed from: B */
        public int f2263B;

        /* renamed from: C */
        public int f2264C;

        /* renamed from: E */
        public boolean[] f2266E;

        /* renamed from: F */
        public boolean f2267F;

        /* renamed from: G */
        public boolean f2268G;

        /* renamed from: I */
        public DialogInterface.OnMultiChoiceClickListener f2270I;

        /* renamed from: J */
        public Cursor f2271J;

        /* renamed from: K */
        public String f2272K;

        /* renamed from: L */
        public String f2273L;

        /* renamed from: M */
        public AdapterView.OnItemSelectedListener f2274M;

        /* renamed from: a */
        public final Context f2275a;

        /* renamed from: b */
        public final LayoutInflater f2276b;

        /* renamed from: d */
        public Drawable f2278d;

        /* renamed from: e */
        public CharSequence f2279e;

        /* renamed from: f */
        public View f2280f;

        /* renamed from: g */
        public CharSequence f2281g;

        /* renamed from: h */
        public CharSequence f2282h;

        /* renamed from: i */
        public Drawable f2283i;

        /* renamed from: j */
        public DialogInterface.OnClickListener f2284j;

        /* renamed from: k */
        public CharSequence f2285k;

        /* renamed from: l */
        public Drawable f2286l;

        /* renamed from: m */
        public DialogInterface.OnClickListener f2287m;

        /* renamed from: n */
        public CharSequence f2288n;

        /* renamed from: o */
        public Drawable f2289o;

        /* renamed from: p */
        public DialogInterface.OnClickListener f2290p;

        /* renamed from: r */
        public DialogInterface.OnCancelListener f2292r;

        /* renamed from: s */
        public DialogInterface.OnDismissListener f2293s;

        /* renamed from: t */
        public DialogInterface.OnKeyListener f2294t;

        /* renamed from: u */
        public CharSequence[] f2295u;

        /* renamed from: v */
        public ListAdapter f2296v;

        /* renamed from: w */
        public DialogInterface.OnClickListener f2297w;

        /* renamed from: x */
        public int f2298x;

        /* renamed from: y */
        public View f2299y;

        /* renamed from: z */
        public int f2300z;

        /* renamed from: c */
        public int f2277c = 0;

        /* renamed from: D */
        public boolean f2265D = false;

        /* renamed from: H */
        public int f2269H = -1;

        /* renamed from: q */
        public boolean f2291q = true;

        public C0632b(Context context) {
            this.f2275a = context;
            this.f2276b = (LayoutInflater) context.getSystemService("layout_inflater");
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class HandlerC0633c extends Handler {

        /* renamed from: a */
        public WeakReference<DialogInterface> f2301a;

        public HandlerC0633c(DialogInterface dialogInterface) {
            this.f2301a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f2301a.get(), message.what);
            } else if (i != 1) {
            } else {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* renamed from: androidx.appcompat.app.AlertController$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0634d extends ArrayAdapter<CharSequence> {
        public C0634d(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, DialogC0124F dialogC0124F, Window window) {
        this.f2233a = context;
        this.f2234b = dialogC0124F;
        this.f2235c = window;
        this.f2231Q = new HandlerC0633c(dialogC0124F);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C2012o.AlertDialog, C1671f.alertDialogStyle, 0);
        this.f2224J = obtainStyledAttributes.getResourceId(C2012o.AlertDialog_android_layout, 0);
        this.f2225K = obtainStyledAttributes.getResourceId(C2012o.AlertDialog_buttonPanelSideLayout, 0);
        this.f2226L = obtainStyledAttributes.getResourceId(C2012o.AlertDialog_listLayout, 0);
        this.f2227M = obtainStyledAttributes.getResourceId(C2012o.AlertDialog_multiChoiceItemLayout, 0);
        this.f2228N = obtainStyledAttributes.getResourceId(C2012o.AlertDialog_singleChoiceItemLayout, 0);
        this.f2229O = obtainStyledAttributes.getResourceId(C2012o.AlertDialog_listItemLayout, 0);
        this.f2230P = obtainStyledAttributes.getBoolean(C2012o.AlertDialog_showTitle, true);
        this.f2236d = obtainStyledAttributes.getDimensionPixelSize(C2012o.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        dialogC0124F.supportRequestWindowFeature(1);
    }

    /* renamed from: a */
    public static boolean m1693a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (childCount > 0) {
                childCount--;
                if (m1693a(viewGroup.getChildAt(childCount))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: c */
    public static void m1691c(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* renamed from: b */
    public final void m1692b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* renamed from: d */
    public final ViewGroup m1690d(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* renamed from: e */
    public void m1689e(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        Message obtainMessage = onClickListener != null ? this.f2231Q.obtainMessage(i, onClickListener) : null;
        if (i == -3) {
            this.f2256x = charSequence;
            this.f2257y = obtainMessage;
            this.f2258z = drawable;
        } else if (i == -2) {
            this.f2252t = charSequence;
            this.f2253u = obtainMessage;
            this.f2254v = drawable;
        } else if (i == -1) {
            this.f2248p = charSequence;
            this.f2249q = obtainMessage;
            this.f2250r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* renamed from: f */
    public void m1688f(int i) {
        this.f2217C = null;
        this.f2216B = i;
        ImageView imageView = this.f2218D;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                this.f2218D.setImageResource(this.f2216B);
                return;
            }
            imageView.setVisibility(8);
        }
    }
}
