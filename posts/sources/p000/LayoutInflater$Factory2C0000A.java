package p000;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.icu.text.DecimalFormatSymbols;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Property;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.ZipException;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlPullParserException;
import p000.AbstractC0485V;
import p000.C0229K;
import p000.C0492V4;
import p000.C1905j0;
import p000.C2248t2;
import p000.C2271u4;
import p000.InterfaceC2165p0;

/* renamed from: A */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class LayoutInflater$Factory2C0000A extends AbstractC2394z implements C1905j0.InterfaceC1906a, LayoutInflater.Factory2 {

    /* renamed from: Z */
    public static final C0101E1<String, Integer> f0Z = new C0101E1<>();

    /* renamed from: a0 */
    public static final int[] f1a0 = {16842836};

    /* renamed from: b0 */
    public static final boolean f2b0 = !"robolectric".equals(Build.FINGERPRINT);

    /* renamed from: c0 */
    public static final boolean f3c0 = true;

    /* renamed from: A */
    public boolean f4A;

    /* renamed from: B */
    public boolean f5B;

    /* renamed from: C */
    public boolean f6C;

    /* renamed from: D */
    public boolean f7D;

    /* renamed from: E */
    public boolean f8E;

    /* renamed from: F */
    public C0012j[] f9F;

    /* renamed from: G */
    public C0012j f10G;

    /* renamed from: H */
    public boolean f11H;

    /* renamed from: I */
    public boolean f12I;

    /* renamed from: J */
    public boolean f13J;

    /* renamed from: K */
    public boolean f14K;

    /* renamed from: L */
    public boolean f15L;

    /* renamed from: M */
    public int f16M;

    /* renamed from: N */
    public int f17N;

    /* renamed from: O */
    public boolean f18O;

    /* renamed from: P */
    public boolean f19P;

    /* renamed from: Q */
    public AbstractC0007f f20Q;

    /* renamed from: R */
    public AbstractC0007f f21R;

    /* renamed from: S */
    public boolean f22S;

    /* renamed from: T */
    public int f23T;

    /* renamed from: V */
    public boolean f25V;

    /* renamed from: W */
    public Rect f26W;

    /* renamed from: X */
    public Rect f27X;

    /* renamed from: Y */
    public C0162H f28Y;

    /* renamed from: c */
    public final Object f29c;

    /* renamed from: d */
    public final Context f30d;

    /* renamed from: f */
    public Window f31f;

    /* renamed from: g */
    public C0005d f32g;

    /* renamed from: h */
    public final InterfaceC2360y f33h;

    /* renamed from: i */
    public ActionBar f34i;

    /* renamed from: j */
    public MenuInflater f35j;

    /* renamed from: k */
    public CharSequence f36k;

    /* renamed from: l */
    public InterfaceC0210J0 f37l;

    /* renamed from: m */
    public C0002b f38m;

    /* renamed from: n */
    public C0013k f39n;

    /* renamed from: o */
    public AbstractC0485V f40o;

    /* renamed from: p */
    public ActionBarContextView f41p;

    /* renamed from: q */
    public PopupWindow f42q;

    /* renamed from: r */
    public Runnable f43r;

    /* renamed from: t */
    public boolean f45t;

    /* renamed from: u */
    public ViewGroup f46u;

    /* renamed from: v */
    public TextView f47v;

    /* renamed from: w */
    public View f48w;

    /* renamed from: x */
    public boolean f49x;

    /* renamed from: y */
    public boolean f50y;

    /* renamed from: z */
    public boolean f51z;

    /* renamed from: s */
    public C0554X4 f44s = null;

    /* renamed from: U */
    public final Runnable f24U = new RunnableC0001a();

    /* renamed from: A$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class RunnableC0001a implements Runnable {
        public RunnableC0001a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = LayoutInflater$Factory2C0000A.this;
            if ((layoutInflater$Factory2C0000A.f23T & 1) != 0) {
                layoutInflater$Factory2C0000A.m2702G(0);
            }
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A2 = LayoutInflater$Factory2C0000A.this;
            if ((layoutInflater$Factory2C0000A2.f23T & 4096) != 0) {
                layoutInflater$Factory2C0000A2.m2702G(108);
            }
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A3 = LayoutInflater$Factory2C0000A.this;
            layoutInflater$Factory2C0000A3.f22S = false;
            layoutInflater$Factory2C0000A3.f23T = 0;
        }
    }

    /* renamed from: A$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0002b implements InterfaceC2165p0.InterfaceC2166a {
        public C0002b() {
        }

        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        /* renamed from: a */
        public boolean mo458a(C1905j0 c1905j0) {
            Window.Callback m2695N = LayoutInflater$Factory2C0000A.this.m2695N();
            if (m2695N != null) {
                m2695N.onMenuOpened(108, c1905j0);
                return true;
            }
            return true;
        }

        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        public void onCloseMenu(C1905j0 c1905j0, boolean z) {
            LayoutInflater$Factory2C0000A.this.m2706C(c1905j0);
        }
    }

    /* renamed from: A$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0003c implements AbstractC0485V.InterfaceC0486a {

        /* renamed from: a */
        public AbstractC0485V.InterfaceC0486a f54a;

        /* renamed from: A$c$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0004a extends C0588Z4 {
            public C0004a() {
            }

            @Override // p000.InterfaceC0571Y4
            /* renamed from: b */
            public void mo223b(View view) {
                LayoutInflater$Factory2C0000A.this.f41p.setVisibility(8);
                LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = LayoutInflater$Factory2C0000A.this;
                PopupWindow popupWindow = layoutInflater$Factory2C0000A.f42q;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (layoutInflater$Factory2C0000A.f41p.getParent() instanceof View) {
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    C0492V4.C0499g.m1901c((View) LayoutInflater$Factory2C0000A.this.f41p.getParent());
                }
                LayoutInflater$Factory2C0000A.this.f41p.removeAllViews();
                LayoutInflater$Factory2C0000A.this.f44s.m1806d(null);
                LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A2 = LayoutInflater$Factory2C0000A.this;
                layoutInflater$Factory2C0000A2.f44s = null;
                ViewGroup viewGroup = layoutInflater$Factory2C0000A2.f46u;
                AtomicInteger atomicInteger2 = C0492V4.f1798a;
                C0492V4.C0499g.m1901c(viewGroup);
            }
        }

        public C0003c(AbstractC0485V.InterfaceC0486a interfaceC0486a) {
            this.f54a = interfaceC0486a;
        }

        @Override // p000.AbstractC0485V.InterfaceC0486a
        /* renamed from: a */
        public boolean mo1760a(AbstractC0485V abstractC0485V, Menu menu) {
            ViewGroup viewGroup = LayoutInflater$Factory2C0000A.this.f46u;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0499g.m1901c(viewGroup);
            return this.f54a.mo1760a(abstractC0485V, menu);
        }

        @Override // p000.AbstractC0485V.InterfaceC0486a
        /* renamed from: b */
        public void mo1759b(AbstractC0485V abstractC0485V) {
            this.f54a.mo1759b(abstractC0485V);
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = LayoutInflater$Factory2C0000A.this;
            if (layoutInflater$Factory2C0000A.f42q != null) {
                layoutInflater$Factory2C0000A.f31f.getDecorView().removeCallbacks(LayoutInflater$Factory2C0000A.this.f43r);
            }
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A2 = LayoutInflater$Factory2C0000A.this;
            if (layoutInflater$Factory2C0000A2.f41p != null) {
                layoutInflater$Factory2C0000A2.m2701H();
                LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A3 = LayoutInflater$Factory2C0000A.this;
                C0554X4 m1969b = C0492V4.m1969b(layoutInflater$Factory2C0000A3.f41p);
                m1969b.m1809a(0.0f);
                layoutInflater$Factory2C0000A3.f44s = m1969b;
                C0554X4 c0554x4 = LayoutInflater$Factory2C0000A.this.f44s;
                C0004a c0004a = new C0004a();
                View view = c0554x4.f1987a.get();
                if (view != null) {
                    c0554x4.m1805e(view, c0004a);
                }
            }
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A4 = LayoutInflater$Factory2C0000A.this;
            InterfaceC2360y interfaceC2360y = layoutInflater$Factory2C0000A4.f33h;
            if (interfaceC2360y != null) {
                interfaceC2360y.onSupportActionModeFinished(layoutInflater$Factory2C0000A4.f40o);
            }
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A5 = LayoutInflater$Factory2C0000A.this;
            layoutInflater$Factory2C0000A5.f40o = null;
            ViewGroup viewGroup = layoutInflater$Factory2C0000A5.f46u;
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0499g.m1901c(viewGroup);
        }

        @Override // p000.AbstractC0485V.InterfaceC0486a
        /* renamed from: c */
        public boolean mo1758c(AbstractC0485V abstractC0485V, MenuItem menuItem) {
            return this.f54a.mo1758c(abstractC0485V, menuItem);
        }

        @Override // p000.AbstractC0485V.InterfaceC0486a
        /* renamed from: d */
        public boolean mo1757d(AbstractC0485V abstractC0485V, Menu menu) {
            return this.f54a.mo1757d(abstractC0485V, menu);
        }
    }

    /* renamed from: A$e */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0006e extends AbstractC0007f {

        /* renamed from: c */
        public final PowerManager f58c;

        public C0006e(Context context) {
            super();
            this.f58c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // p000.LayoutInflater$Factory2C0000A.AbstractC0007f
        /* renamed from: b */
        public IntentFilter mo2680b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // p000.LayoutInflater$Factory2C0000A.AbstractC0007f
        /* renamed from: c */
        public int mo2679c() {
            return this.f58c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // p000.LayoutInflater$Factory2C0000A.AbstractC0007f
        /* renamed from: d */
        public void mo2678d() {
            LayoutInflater$Factory2C0000A.this.m2685y();
        }
    }

    /* renamed from: A$f */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public abstract class AbstractC0007f {

        /* renamed from: a */
        public BroadcastReceiver f60a;

        /* renamed from: A$f$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public class C0008a extends BroadcastReceiver {
            public C0008a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                AbstractC0007f.this.mo2678d();
            }
        }

        public AbstractC0007f() {
        }

        /* renamed from: a */
        public void m2682a() {
            BroadcastReceiver broadcastReceiver = this.f60a;
            if (broadcastReceiver != null) {
                try {
                    LayoutInflater$Factory2C0000A.this.f30d.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f60a = null;
            }
        }

        /* renamed from: b */
        public abstract IntentFilter mo2680b();

        /* renamed from: c */
        public abstract int mo2679c();

        /* renamed from: d */
        public abstract void mo2678d();

        /* renamed from: e */
        public void m2681e() {
            m2682a();
            IntentFilter mo2680b = mo2680b();
            if (mo2680b == null || mo2680b.countActions() == 0) {
                return;
            }
            if (this.f60a == null) {
                this.f60a = new C0008a();
            }
            LayoutInflater$Factory2C0000A.this.f30d.registerReceiver(this.f60a, mo2680b);
        }
    }

    /* renamed from: A$g */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0009g extends AbstractC0007f {

        /* renamed from: c */
        public final C0229K f63c;

        public C0009g(C0229K c0229k) {
            super();
            this.f63c = c0229k;
        }

        @Override // p000.LayoutInflater$Factory2C0000A.AbstractC0007f
        /* renamed from: b */
        public IntentFilter mo2680b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // p000.LayoutInflater$Factory2C0000A.AbstractC0007f
        /* renamed from: c */
        public int mo2679c() {
            boolean z;
            long j;
            C0229K c0229k = this.f63c;
            C0229K.C0230a c0230a = c0229k.f715c;
            if (c0230a.f717b > System.currentTimeMillis()) {
                z = c0230a.f716a;
            } else {
                Location m2356a = C0010h.m2635i(c0229k.f713a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? c0229k.m2356a("network") : null;
                Location m2356a2 = C0010h.m2635i(c0229k.f713a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? c0229k.m2356a("gps") : null;
                if (m2356a2 == null || m2356a == null ? m2356a2 != null : m2356a2.getTime() > m2356a.getTime()) {
                    m2356a = m2356a2;
                }
                if (m2356a != null) {
                    C0229K.C0230a c0230a2 = c0229k.f715c;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (C0209J.f671d == null) {
                        C0209J.f671d = new C0209J();
                    }
                    C0209J c0209j = C0209J.f671d;
                    c0209j.m2383a(currentTimeMillis - 86400000, m2356a.getLatitude(), m2356a.getLongitude());
                    c0209j.m2383a(currentTimeMillis, m2356a.getLatitude(), m2356a.getLongitude());
                    r7 = c0209j.f674c == 1;
                    long j2 = c0209j.f673b;
                    long j3 = c0209j.f672a;
                    c0209j.m2383a(currentTimeMillis + 86400000, m2356a.getLatitude(), m2356a.getLongitude());
                    long j4 = c0209j.f673b;
                    if (j2 == -1 || j3 == -1) {
                        j = 43200000 + currentTimeMillis;
                    } else {
                        j = (currentTimeMillis > j3 ? j4 + 0 : currentTimeMillis > j2 ? j3 + 0 : j2 + 0) + 60000;
                    }
                    c0230a2.f716a = r7;
                    c0230a2.f717b = j;
                    z = c0230a.f716a;
                } else {
                    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                    int i = Calendar.getInstance().get(11);
                    z = (i < 6 || i >= 22) ? true : true;
                }
            }
            return z ? 2 : 1;
        }

        @Override // p000.LayoutInflater$Factory2C0000A.AbstractC0007f
        /* renamed from: d */
        public void mo2678d() {
            LayoutInflater$Factory2C0000A.this.m2685y();
        }
    }

    /* renamed from: A$h */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C0010h {

        /* renamed from: a */
        public static Field f65a;

        /* renamed from: b */
        public static boolean f66b;

        /* renamed from: c */
        public static Class<?> f67c;

        /* renamed from: d */
        public static boolean f68d;

        /* renamed from: e */
        public static Field f69e;

        /* renamed from: f */
        public static boolean f70f;

        /* renamed from: g */
        public static Field f71g;

        /* renamed from: h */
        public static boolean f72h;

        /* renamed from: i */
        public static Method f73i;

        /* renamed from: j */
        public static boolean f74j;

        /* renamed from: k */
        public static Method f75k;

        /* renamed from: l */
        public static boolean f76l;

        /* renamed from: m */
        public static Field f77m;

        /* renamed from: n */
        public static boolean f78n;

        /* renamed from: o */
        public static Method f79o;

        /* renamed from: p */
        public static boolean f80p;

        /* renamed from: q */
        public static Field f81q;

        /* renamed from: r */
        public static boolean f82r;

        /* renamed from: s */
        public static Method f83s;

        /* renamed from: t */
        public static Method f84t;

        /* renamed from: u */
        public static boolean f85u;

        /* renamed from: A */
        public static Drawable m2677A(CompoundButton compoundButton) {
            if (Build.VERSION.SDK_INT >= 23) {
                return compoundButton.getButtonDrawable();
            }
            if (!f78n) {
                try {
                    Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    f77m = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                f78n = true;
            }
            Field field = f77m;
            if (field != null) {
                try {
                    return (Drawable) field.get(compoundButton);
                } catch (IllegalAccessException e2) {
                    Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                    f77m = null;
                }
            }
            return null;
        }

        /* renamed from: B */
        public static int m2676B(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                return drawable.getLayoutDirection();
            }
            if (!f76l) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f75k = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
                }
                f76l = true;
            }
            Method method = f75k;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                    f75k = null;
                }
            }
            return 0;
        }

        /* renamed from: C */
        public static String m2675C() {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
            StringBuilder m253r = outline.m253r(".(");
            m253r.append(stackTraceElement.getFileName());
            m253r.append(":");
            m253r.append(stackTraceElement.getLineNumber());
            m253r.append(")");
            return m253r.toString();
        }

        /* renamed from: D */
        public static String m2674D(Context context, int i) {
            if (i != -1) {
                try {
                    return context.getResources().getResourceEntryName(i);
                } catch (Exception unused) {
                    return outline.m273H("?", i);
                }
            }
            return "UNKNOWN";
        }

        /* renamed from: E */
        public static String m2673E(View view) {
            try {
                return view.getContext().getResources().getResourceEntryName(view.getId());
            } catch (Exception unused) {
                return "UNKNOWN";
            }
        }

        /* renamed from: F */
        public static boolean m2672F(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
            return !m2660R(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
        }

        /* renamed from: G */
        public static C2364y3 m2671G(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
            C2364y3 c2364y3;
            if (m2660R(xmlPullParser, str)) {
                TypedValue typedValue = new TypedValue();
                typedArray.getValue(i, typedValue);
                int i3 = typedValue.type;
                if (i3 >= 28 && i3 <= 31) {
                    return new C2364y3(null, null, typedValue.data);
                }
                try {
                    c2364y3 = C2364y3.m63a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
                } catch (Exception e) {
                    Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
                    c2364y3 = null;
                }
                if (c2364y3 != null) {
                    return c2364y3;
                }
            }
            return new C2364y3(null, null, i2);
        }

        /* renamed from: H */
        public static float m2670H(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
            return !m2660R(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
        }

        /* renamed from: I */
        public static int m2669I(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
            return !m2660R(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
        }

        /* renamed from: J */
        public static int m2668J(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
            return !m2660R(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
        }

        /* renamed from: K */
        public static String m2667K(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
            if (m2660R(xmlPullParser, str)) {
                return typedArray.getString(i);
            }
            return null;
        }

        /* renamed from: L */
        public static Intent m2666L(Activity activity) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent != null) {
                return parentActivityIntent;
            }
            try {
                String m2664N = m2664N(activity, activity.getComponentName());
                if (m2664N == null) {
                    return null;
                }
                ComponentName componentName = new ComponentName(activity, m2664N);
                try {
                    if (m2664N(activity, componentName) == null) {
                        return Intent.makeMainActivity(componentName);
                    }
                    return new Intent().setComponent(componentName);
                } catch (PackageManager.NameNotFoundException unused) {
                    Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + m2664N + "' in manifest");
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e) {
                throw new IllegalArgumentException(e);
            }
        }

        /* renamed from: M */
        public static Intent m2665M(Context context, ComponentName componentName) {
            String m2664N = m2664N(context, componentName);
            if (m2664N == null) {
                return null;
            }
            ComponentName componentName2 = new ComponentName(componentName.getPackageName(), m2664N);
            if (m2664N(context, componentName2) == null) {
                return Intent.makeMainActivity(componentName2);
            }
            return new Intent().setComponent(componentName2);
        }

        /* renamed from: N */
        public static String m2664N(Context context, ComponentName componentName) {
            String string;
            PackageManager packageManager = context.getPackageManager();
            int i = Build.VERSION.SDK_INT;
            int i2 = 640;
            if (i >= 29) {
                i2 = 269222528;
            } else if (i >= 24) {
                i2 = 787072;
            }
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2);
            String str = activityInfo.parentActivityName;
            if (str != null) {
                return str;
            }
            Bundle bundle = activityInfo.metaData;
            if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }

        /* renamed from: O */
        public static String m2663O(MotionLayout motionLayout, int i) {
            return i == -1 ? "UNDEFINED" : motionLayout.getContext().getResources().getResourceEntryName(i);
        }

        /* renamed from: P */
        public static File m2662P(Context context) {
            File cacheDir = context.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            StringBuilder m253r = outline.m253r(".font");
            m253r.append(Process.myPid());
            m253r.append("-");
            m253r.append(Process.myTid());
            m253r.append("-");
            String sb = m253r.toString();
            for (int i = 0; i < 100; i++) {
                File file = new File(cacheDir, outline.m273H(sb, i));
                if (file.createNewFile()) {
                    return file;
                }
            }
            return null;
        }

        /* renamed from: Q */
        public static C2271u4.C2272a m2661Q(TextView textView) {
            int i;
            int i2;
            TextDirectionHeuristic textDirectionHeuristic;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 28) {
                return new C2271u4.C2272a(textView.getTextMetricsParams());
            }
            TextPaint textPaint = new TextPaint(textView.getPaint());
            if (Build.VERSION.SDK_INT >= 23) {
                i = 1;
                i2 = 1;
            } else {
                i = 0;
                i2 = 0;
            }
            TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            if (i3 >= 23) {
                i = textView.getBreakStrategy();
                i2 = textView.getHyphenationFrequency();
            }
            if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            } else if (i3 >= 28 && (textView.getInputType() & 15) == 3) {
                byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
                if (directionality != 1 && directionality != 2) {
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                } else {
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                }
            } else {
                boolean z = textView.getLayoutDirection() == 1;
                switch (textView.getTextDirection()) {
                    case 2:
                        textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                        break;
                    case 3:
                        textDirectionHeuristic = TextDirectionHeuristics.LTR;
                        break;
                    case 4:
                        textDirectionHeuristic = TextDirectionHeuristics.RTL;
                        break;
                    case 5:
                        textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                        break;
                    case 6:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    case 7:
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    default:
                        if (z) {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                            break;
                        } else {
                            textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                            break;
                        }
                }
            }
            return new C2271u4.C2272a(textPaint, textDirectionHeuristic, i, i2);
        }

        /* renamed from: R */
        public static boolean m2660R(XmlPullParser xmlPullParser, String str) {
            return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
        }

        /* renamed from: S */
        public static boolean m2659S(Rect rect, Rect rect2, int i) {
            if (i == 17) {
                int i2 = rect.right;
                int i3 = rect2.right;
                return (i2 > i3 || rect.left >= i3) && rect.left > rect2.left;
            } else if (i == 33) {
                int i4 = rect.bottom;
                int i5 = rect2.bottom;
                return (i4 > i5 || rect.top >= i5) && rect.top > rect2.top;
            } else if (i == 66) {
                int i6 = rect.left;
                int i7 = rect2.left;
                return (i6 < i7 || rect.right <= i7) && rect.right < rect2.right;
            } else if (i == 130) {
                int i8 = rect.top;
                int i9 = rect2.top;
                return (i8 < i9 || rect.bottom <= i9) && rect.bottom < rect2.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
        }

        /* renamed from: T */
        public static int m2658T(int i, Rect rect, Rect rect2) {
            int i2;
            int i3;
            if (i == 17) {
                i2 = rect.left;
                i3 = rect2.right;
            } else if (i == 33) {
                i2 = rect.top;
                i3 = rect2.bottom;
            } else if (i == 66) {
                i2 = rect2.left;
                i3 = rect.right;
            } else if (i == 130) {
                i2 = rect2.top;
                i3 = rect.bottom;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            return Math.max(0, i2 - i3);
        }

        /* renamed from: U */
        public static void m2657U(Intent intent, ArrayList<Uri> arrayList) {
            ClipData clipData = new ClipData(null, new String[]{intent.getType()}, new ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra("android.intent.extra.HTML_TEXT"), null, arrayList.get(0)));
            int size = arrayList.size();
            for (int i = 1; i < size; i++) {
                clipData.addItem(new ClipData.Item(arrayList.get(i)));
            }
            intent.setClipData(clipData);
            intent.addFlags(1);
        }

        /* renamed from: V */
        public static int m2656V(int i, Rect rect, Rect rect2) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
            }
            return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
        }

        /* renamed from: W */
        public static ByteBuffer m2655W(Context context, CancellationSignal cancellationSignal, Uri uri) {
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    openFileDescriptor.close();
                    return map;
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }

        /* renamed from: X */
        public static TypedArray m2654X(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
            if (theme == null) {
                return resources.obtainAttributes(attributeSet, iArr);
            }
            return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        }

        /* renamed from: Y */
        public static <T> ObjectAnimator m2653Y(T t, Property<T, PointF> property, Path path) {
            return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
        }

        /* renamed from: Z */
        public static InputConnection m2652Z(InputConnection inputConnection, EditorInfo editorInfo, View view) {
            if (inputConnection != null && editorInfo.hintText == null) {
                ViewParent parent = view.getParent();
                while (true) {
                    if (!(parent instanceof View)) {
                        break;
                    } else if (parent instanceof InterfaceC1883i1) {
                        editorInfo.hintText = ((InterfaceC1883i1) parent).m750a();
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            return inputConnection;
        }

        /* renamed from: a */
        public static <T> ArrayList<T> m2651a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        /* renamed from: a0 */
        public static boolean m2650a0(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:180:0x02d7, code lost:
            if (r3[r17].f6373f.f6371d == r9) goto L161;
         */
        /* JADX WARN: Code restructure failed: missing block: B:75:0x0149, code lost:
            if (r4[r2].f6373f.f6371d == r5) goto L42;
         */
        /* JADX WARN: Removed duplicated region for block: B:209:0x0356  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0373  */
        /* JADX WARN: Removed duplicated region for block: B:222:0x038e  */
        /* JADX WARN: Removed duplicated region for block: B:254:0x0498 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:275:0x0504 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:335:0x0602  */
        /* JADX WARN: Removed duplicated region for block: B:336:0x0604  */
        /* JADX WARN: Removed duplicated region for block: B:340:0x0614 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:349:0x0627  */
        /* JADX WARN: Removed duplicated region for block: B:393:0x06eb  */
        /* JADX WARN: Removed duplicated region for block: B:401:0x0727 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:406:0x073b  */
        /* JADX WARN: Removed duplicated region for block: B:407:0x073e  */
        /* JADX WARN: Removed duplicated region for block: B:410:0x0744  */
        /* JADX WARN: Removed duplicated region for block: B:411:0x0747  */
        /* JADX WARN: Removed duplicated region for block: B:413:0x074b  */
        /* JADX WARN: Removed duplicated region for block: B:417:0x075a  */
        /* JADX WARN: Removed duplicated region for block: B:419:0x075d  */
        /* JADX WARN: Removed duplicated region for block: B:421:0x0763 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:431:0x0780 A[ADDED_TO_REGION, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0139  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x014f  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x0152  */
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void m2649b(p000.C2269u2 r38, p000.C1953l2 r39, java.util.ArrayList<p000.C2248t2> r40, int r41) {
            /*
                Method dump skipped, instructions count: 1934
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.C0010h.m2649b(u2, l2, java.util.ArrayList, int):void");
        }

        /* renamed from: b0 */
        public static boolean m2648b0(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
            if (r10.bottom <= r12.top) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
            if (r10.right <= r12.left) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
            if (r10.top >= r12.bottom) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
            if (r10.left >= r12.right) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
            r7 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
            r7 = false;
         */
        /* renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static boolean m2647c(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
            /*
                boolean r0 = m2645d(r9, r10, r11)
                boolean r1 = m2645d(r9, r10, r12)
                r2 = 0
                if (r1 != 0) goto L7d
                if (r0 != 0) goto Lf
                goto L7d
            Lf:
                java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
                r1 = 130(0x82, float:1.82E-43)
                r3 = 33
                r4 = 66
                r5 = 17
                r6 = 1
                if (r9 == r5) goto L3d
                if (r9 == r3) goto L36
                if (r9 == r4) goto L2f
                if (r9 != r1) goto L29
                int r7 = r10.bottom
                int r8 = r12.top
                if (r7 > r8) goto L45
                goto L43
            L29:
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r0)
                throw r9
            L2f:
                int r7 = r10.right
                int r8 = r12.left
                if (r7 > r8) goto L45
                goto L43
            L36:
                int r7 = r10.top
                int r8 = r12.bottom
                if (r7 < r8) goto L45
                goto L43
            L3d:
                int r7 = r10.left
                int r8 = r12.right
                if (r7 < r8) goto L45
            L43:
                r7 = 1
                goto L46
            L45:
                r7 = 0
            L46:
                if (r7 != 0) goto L49
                return r6
            L49:
                if (r9 == r5) goto L7c
                if (r9 != r4) goto L4e
                goto L7c
            L4e:
                int r11 = m2658T(r9, r10, r11)
                if (r9 == r5) goto L6f
                if (r9 == r3) goto L6a
                if (r9 == r4) goto L65
                if (r9 != r1) goto L5f
                int r9 = r12.bottom
                int r10 = r10.bottom
                goto L73
            L5f:
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                r9.<init>(r0)
                throw r9
            L65:
                int r9 = r12.right
                int r10 = r10.right
                goto L73
            L6a:
                int r9 = r10.top
                int r10 = r12.top
                goto L73
            L6f:
                int r9 = r10.left
                int r10 = r12.left
            L73:
                int r9 = r9 - r10
                int r9 = java.lang.Math.max(r6, r9)
                if (r11 >= r9) goto L7b
                r2 = 1
            L7b:
                return r2
            L7c:
                return r6
            L7d:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.C0010h.m2647c(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
        }

        /* renamed from: c0 */
        public static void m2646c0(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
            if (viewParent instanceof InterfaceC0267L4) {
                ((InterfaceC0267L4) viewParent).onNestedPreScroll(view, i, i2, iArr, i3);
            } else if (i3 == 0) {
                try {
                    viewParent.onNestedPreScroll(view, i, i2, iArr);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
                }
            }
        }

        /* renamed from: d */
        public static boolean m2645d(int i, Rect rect, Rect rect2) {
            if (i != 17) {
                if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                        }
                    }
                }
                return rect2.right >= rect.left && rect2.left <= rect.right;
            }
            return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
        }

        /* renamed from: d0 */
        public static void m2644d0(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
            if (viewParent instanceof InterfaceC0287M4) {
                ((InterfaceC0287M4) viewParent).onNestedScroll(view, i, i2, i3, i4, i5, iArr);
                return;
            }
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
            if (viewParent instanceof InterfaceC0267L4) {
                ((InterfaceC0267L4) viewParent).onNestedScroll(view, i, i2, i3, i4, i5);
            } else if (i5 == 0) {
                try {
                    viewParent.onNestedScroll(view, i, i2, i3, i4);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
                }
            }
        }

        /* renamed from: e */
        public static void m2643e(Object obj, StringBuilder sb) {
            int lastIndexOf;
            if (obj == null) {
                sb.append("null");
                return;
            }
            String simpleName = obj.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(lastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(obj)));
        }

        /* renamed from: e0 */
        public static InterfaceC2398z3 m2642e0(XmlPullParser xmlPullParser, Resources resources) {
            int next;
            do {
                next = xmlPullParser.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                xmlPullParser.require(2, null, "font-family");
                if (xmlPullParser.getName().equals("font-family")) {
                    TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C1834g3.FontFamily);
                    String string = obtainAttributes.getString(C1834g3.FontFamily_fontProviderAuthority);
                    String string2 = obtainAttributes.getString(C1834g3.FontFamily_fontProviderPackage);
                    String string3 = obtainAttributes.getString(C1834g3.FontFamily_fontProviderQuery);
                    int resourceId = obtainAttributes.getResourceId(C1834g3.FontFamily_fontProviderCerts, 0);
                    int integer = obtainAttributes.getInteger(C1834g3.FontFamily_fontProviderFetchStrategy, 1);
                    int integer2 = obtainAttributes.getInteger(C1834g3.FontFamily_fontProviderFetchTimeout, 500);
                    String string4 = obtainAttributes.getString(C1834g3.FontFamily_fontProviderSystemFontFamily);
                    obtainAttributes.recycle();
                    if (string != null && string2 != null && string3 != null) {
                        while (xmlPullParser.next() != 3) {
                            m2612t0(xmlPullParser);
                        }
                        return new C0055C3(new C1886i4(string, string2, string3, m2640f0(resources, resourceId)), integer, integer2, string4);
                    }
                    ArrayList arrayList = new ArrayList();
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("font")) {
                                TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C1834g3.FontFamilyFont);
                                int i = C1834g3.FontFamilyFont_fontWeight;
                                if (!obtainAttributes2.hasValue(i)) {
                                    i = C1834g3.FontFamilyFont_android_fontWeight;
                                }
                                int i2 = obtainAttributes2.getInt(i, 400);
                                int i3 = C1834g3.FontFamilyFont_fontStyle;
                                if (!obtainAttributes2.hasValue(i3)) {
                                    i3 = C1834g3.FontFamilyFont_android_fontStyle;
                                }
                                boolean z = 1 == obtainAttributes2.getInt(i3, 0);
                                int i4 = C1834g3.FontFamilyFont_ttcIndex;
                                if (!obtainAttributes2.hasValue(i4)) {
                                    i4 = C1834g3.FontFamilyFont_android_ttcIndex;
                                }
                                int i5 = C1834g3.FontFamilyFont_fontVariationSettings;
                                if (!obtainAttributes2.hasValue(i5)) {
                                    i5 = C1834g3.FontFamilyFont_android_fontVariationSettings;
                                }
                                String string5 = obtainAttributes2.getString(i5);
                                int i6 = obtainAttributes2.getInt(i4, 0);
                                int i7 = C1834g3.FontFamilyFont_font;
                                if (!obtainAttributes2.hasValue(i7)) {
                                    i7 = C1834g3.FontFamilyFont_android_font;
                                }
                                int resourceId2 = obtainAttributes2.getResourceId(i7, 0);
                                String string6 = obtainAttributes2.getString(i7);
                                obtainAttributes2.recycle();
                                while (xmlPullParser.next() != 3) {
                                    m2612t0(xmlPullParser);
                                }
                                arrayList.add(new C0036B3(string6, i2, z, string5, i6, resourceId2));
                            } else {
                                m2612t0(xmlPullParser);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    return new C0017A3((C0036B3[]) arrayList.toArray(new C0036B3[arrayList.size()]));
                }
                m2612t0(xmlPullParser);
                return null;
            }
            throw new XmlPullParserException("No start tag found");
        }

        /* renamed from: f */
        public static boolean m2641f(C0194I3[] c0194i3Arr, C0194I3[] c0194i3Arr2) {
            if (c0194i3Arr == null || c0194i3Arr2 == null || c0194i3Arr.length != c0194i3Arr2.length) {
                return false;
            }
            for (int i = 0; i < c0194i3Arr.length; i++) {
                if (c0194i3Arr[i].f632a != c0194i3Arr2[i].f632a || c0194i3Arr[i].f633b.length != c0194i3Arr2[i].f633b.length) {
                    return false;
                }
            }
            return true;
        }

        /* renamed from: f0 */
        public static List<List<byte[]>> m2640f0(Resources resources, int i) {
            if (i == 0) {
                return Collections.emptyList();
            }
            TypedArray obtainTypedArray = resources.obtainTypedArray(i);
            try {
                if (obtainTypedArray.length() == 0) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                if (obtainTypedArray.getType(0) == 1) {
                    for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                        int resourceId = obtainTypedArray.getResourceId(i2, 0);
                        if (resourceId != 0) {
                            arrayList.add(m2610u0(resources.getStringArray(resourceId)));
                        }
                    }
                } else {
                    arrayList.add(m2610u0(resources.getStringArray(i)));
                }
                return arrayList;
            } finally {
                obtainTypedArray.recycle();
            }
        }

        /* renamed from: g */
        public static int m2639g(int i) {
            if (i >= 0) {
                return i;
            }
            throw new IllegalArgumentException();
        }

        /* renamed from: g0 */
        public static <T> ArrayList<T> m2638g0(ArrayList<T> arrayList, T t) {
            if (arrayList != null) {
                arrayList.remove(t);
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            }
            return arrayList;
        }

        /* renamed from: h */
        public static <T> T m2637h(T t, Object obj) {
            if (t != null) {
                return t;
            }
            throw new NullPointerException(String.valueOf(obj));
        }

        /* renamed from: h0 */
        public static void m2636h0(TextView textView, int i) {
            int i2;
            m2639g(i);
            if (Build.VERSION.SDK_INT >= 28) {
                textView.setFirstBaselineToTopHeight(i);
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i2 = fontMetricsInt.top;
            } else {
                i2 = fontMetricsInt.ascent;
            }
            if (i > Math.abs(i2)) {
                textView.setPadding(textView.getPaddingLeft(), i + i2, textView.getPaddingRight(), textView.getPaddingBottom());
            }
        }

        /* renamed from: i */
        public static int m2635i(Context context, String str) {
            int myPid = Process.myPid();
            int myUid = Process.myUid();
            String packageName = context.getPackageName();
            if (context.checkPermission(str, myPid, myUid) != -1) {
                int i = Build.VERSION.SDK_INT;
                String permissionToOp = i >= 23 ? AppOpsManager.permissionToOp(str) : null;
                if (permissionToOp == null) {
                    return 0;
                }
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                return (i >= 23 ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, packageName) : 1) != 0 ? -2 : 0;
            }
            return -1;
        }

        /* renamed from: i0 */
        public static void m2634i0(TextView textView, int i) {
            int i2;
            m2639g(i);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            if (textView.getIncludeFontPadding()) {
                i2 = fontMetricsInt.bottom;
            } else {
                i2 = fontMetricsInt.descent;
            }
            if (i > Math.abs(i2)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
            }
        }

        /* renamed from: j */
        public static float m2633j(float f, float f2, float f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }

        /* renamed from: j0 */
        public static boolean m2632j0(Drawable drawable, int i) {
            if (Build.VERSION.SDK_INT >= 23) {
                return drawable.setLayoutDirection(i);
            }
            if (!f74j) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f73i = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                f74j = true;
            }
            Method method = f73i;
            if (method != null) {
                try {
                    method.invoke(drawable, Integer.valueOf(i));
                    return true;
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    f73i = null;
                }
            }
            return false;
        }

        /* renamed from: k */
        public static int m2631k(int i, int i2, int i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }

        /* renamed from: k0 */
        public static void m2630k0(TextView textView, int i) {
            m2639g(i);
            int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
            if (i != fontMetricsInt) {
                textView.setLineSpacing(i - fontMetricsInt, 1.0f);
            }
        }

        /* renamed from: l */
        public static void m2629l(Drawable drawable) {
            DrawableContainer.DrawableContainerState drawableContainerState;
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.clearColorFilter();
                return;
            }
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                m2629l(((InsetDrawable) drawable).getDrawable());
            } else if (drawable instanceof InterfaceC0430S3) {
                m2629l(((InterfaceC0430S3) drawable).mo2009b());
            } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    Drawable child = drawableContainerState.getChild(i);
                    if (child != null) {
                        m2629l(child);
                    }
                }
            }
        }

        /* renamed from: l0 */
        public static void m2628l0(PopupWindow popupWindow, boolean z) {
            if (Build.VERSION.SDK_INT >= 23) {
                C1978m5.m593c(popupWindow, z);
                return;
            }
            if (!f82r) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f81q = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
                }
                f82r = true;
            }
            Field field = f81q;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e2) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e2);
                }
            }
        }

        /* renamed from: m */
        public static int m2627m(RecyclerView.C0860y c0860y, AbstractC0971b7 abstractC0971b7, View view, View view2, RecyclerView.AbstractC0843o abstractC0843o, boolean z) {
            if (abstractC0843o.getChildCount() == 0 || c0860y.m1341b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return Math.abs(abstractC0843o.getPosition(view) - abstractC0843o.getPosition(view2)) + 1;
            }
            return Math.min(abstractC0971b7.mo1150l(), abstractC0971b7.mo1160b(view2) - abstractC0971b7.mo1157e(view));
        }

        /* renamed from: m0 */
        public static void m2626m0(TextView textView, C2271u4 c2271u4) {
            if (Build.VERSION.SDK_INT >= 29) {
                Objects.requireNonNull(c2271u4);
                textView.setText((CharSequence) null);
                return;
            }
            C2271u4.C2272a m2661Q = m2661Q(textView);
            Objects.requireNonNull(c2271u4);
            if (m2661Q.m302a(null)) {
                textView.setText(c2271u4);
                return;
            }
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }

        /* renamed from: n */
        public static int m2625n(RecyclerView.C0860y c0860y, AbstractC0971b7 abstractC0971b7, View view, View view2, RecyclerView.AbstractC0843o abstractC0843o, boolean z, boolean z2) {
            int max;
            if (abstractC0843o.getChildCount() == 0 || c0860y.m1341b() == 0 || view == null || view2 == null) {
                return 0;
            }
            int min = Math.min(abstractC0843o.getPosition(view), abstractC0843o.getPosition(view2));
            int max2 = Math.max(abstractC0843o.getPosition(view), abstractC0843o.getPosition(view2));
            if (z2) {
                max = Math.max(0, (c0860y.m1341b() - max2) - 1);
            } else {
                max = Math.max(0, min);
            }
            if (z) {
                return Math.round((max * (Math.abs(abstractC0971b7.mo1160b(view2) - abstractC0971b7.mo1157e(view)) / (Math.abs(abstractC0843o.getPosition(view) - abstractC0843o.getPosition(view2)) + 1))) + (abstractC0971b7.mo1151k() - abstractC0971b7.mo1157e(view)));
            }
            return max;
        }

        /* renamed from: n0 */
        public static void m2624n0(TextView textView, int i) {
            if (Build.VERSION.SDK_INT >= 23) {
                textView.setTextAppearance(i);
            } else {
                textView.setTextAppearance(textView.getContext(), i);
            }
        }

        /* renamed from: o */
        public static int m2623o(RecyclerView.C0860y c0860y, AbstractC0971b7 abstractC0971b7, View view, View view2, RecyclerView.AbstractC0843o abstractC0843o, boolean z) {
            if (abstractC0843o.getChildCount() == 0 || c0860y.m1341b() == 0 || view == null || view2 == null) {
                return 0;
            }
            if (!z) {
                return c0860y.m1341b();
            }
            return (int) (((abstractC0971b7.mo1160b(view2) - abstractC0971b7.mo1157e(view)) / (Math.abs(abstractC0843o.getPosition(view) - abstractC0843o.getPosition(view2)) + 1)) * c0860y.m1341b());
        }

        /* renamed from: o0 */
        public static void m2622o0(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        /* renamed from: p */
        public static float[] m2621p(float[] fArr, int i, int i2) {
            if (i <= i2) {
                int length = fArr.length;
                if (i >= 0 && i <= length) {
                    int i3 = i2 - i;
                    int min = Math.min(i3, length - i);
                    float[] fArr2 = new float[i3];
                    System.arraycopy(fArr, i, fArr2, 0, min);
                    return fArr2;
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            throw new IllegalArgumentException();
        }

        /* renamed from: p0 */
        public static void m2620p0(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        /* renamed from: q */
        public static boolean m2619q(File file, Resources resources, int i) {
            InputStream inputStream;
            try {
                inputStream = resources.openRawResource(i);
                try {
                    boolean m2617r = m2617r(file, inputStream);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    return m2617r;
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = null;
            }
        }

        /* renamed from: q0 */
        public static void m2618q0(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        /* renamed from: r */
        public static boolean m2617r(File file, InputStream inputStream) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file, false);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        }
                        try {
                            fileOutputStream2.close();
                        } catch (IOException unused) {
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        return true;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        StrictMode.setThreadPolicy(allowThreadDiskWrites);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e2) {
                e = e2;
            }
        }

        /* renamed from: r0 */
        public static void m2616r0(View view, CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 26) {
                view.setTooltipText(charSequence);
                return;
            }
            View$OnLongClickListenerC1635e1 view$OnLongClickListenerC1635e1 = View$OnLongClickListenerC1635e1.f4107k;
            if (view$OnLongClickListenerC1635e1 != null && view$OnLongClickListenerC1635e1.f4109a == view) {
                View$OnLongClickListenerC1635e1.m1004c(null);
            }
            if (TextUtils.isEmpty(charSequence)) {
                View$OnLongClickListenerC1635e1 view$OnLongClickListenerC1635e12 = View$OnLongClickListenerC1635e1.f4108l;
                if (view$OnLongClickListenerC1635e12 != null && view$OnLongClickListenerC1635e12.f4109a == view) {
                    view$OnLongClickListenerC1635e12.m1005b();
                }
                view.setOnLongClickListener(null);
                view.setLongClickable(false);
                view.setOnHoverListener(null);
                return;
            }
            new View$OnLongClickListenerC1635e1(view, charSequence);
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x008b, code lost:
            if (r13 == false) goto L53;
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0098 A[Catch: NumberFormatException -> 0x00ba, LOOP:3: B:29:0x006d->B:49:0x0098, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00ba, blocks: (B:26:0x005a, B:29:0x006d, B:31:0x0073, B:36:0x0081, B:49:0x0098, B:51:0x009d, B:54:0x00ad, B:56:0x00b2), top: B:71:0x005a }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x009d A[Catch: NumberFormatException -> 0x00ba, TryCatch #0 {NumberFormatException -> 0x00ba, blocks: (B:26:0x005a, B:29:0x006d, B:31:0x0073, B:36:0x0081, B:49:0x0098, B:51:0x009d, B:54:0x00ad, B:56:0x00b2), top: B:71:0x005a }] */
        /* JADX WARN: Removed duplicated region for block: B:53:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00ad A[Catch: NumberFormatException -> 0x00ba, TryCatch #0 {NumberFormatException -> 0x00ba, blocks: (B:26:0x005a, B:29:0x006d, B:31:0x0073, B:36:0x0081, B:49:0x0098, B:51:0x009d, B:54:0x00ad, B:56:0x00b2), top: B:71:0x005a }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00d7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0097 A[SYNTHETIC] */
        /* renamed from: s */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static p000.C0194I3[] m2615s(java.lang.String r16) {
            /*
                Method dump skipped, instructions count: 272
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.C0010h.m2615s(java.lang.String):I3[]");
        }

        /* renamed from: s0 */
        public static void m2614s0(PopupWindow popupWindow, int i) {
            if (Build.VERSION.SDK_INT >= 23) {
                C1978m5.m592d(popupWindow, i);
                return;
            }
            if (!f80p) {
                try {
                    Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    f79o = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Exception unused) {
                }
                f80p = true;
            }
            Method method = f79o;
            if (method != null) {
                try {
                    method.invoke(popupWindow, Integer.valueOf(i));
                } catch (Exception unused2) {
                }
            }
        }

        /* renamed from: t */
        public static Path m2613t(String str) {
            Path path = new Path();
            C0194I3[] m2615s = m2615s(str);
            if (m2615s != null) {
                try {
                    C0194I3.m2387b(m2615s, path);
                    return path;
                } catch (RuntimeException e) {
                    throw new RuntimeException(outline.m266e("Error in parsing ", str), e);
                }
            }
            return null;
        }

        /* renamed from: t0 */
        public static void m2612t0(XmlPullParser xmlPullParser) {
            int i = 1;
            while (i > 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i++;
                } else if (next == 3) {
                    i--;
                }
            }
        }

        /* renamed from: u */
        public static C0194I3[] m2611u(C0194I3[] c0194i3Arr) {
            if (c0194i3Arr == null) {
                return null;
            }
            C0194I3[] c0194i3Arr2 = new C0194I3[c0194i3Arr.length];
            for (int i = 0; i < c0194i3Arr.length; i++) {
                c0194i3Arr2[i] = new C0194I3(c0194i3Arr[i]);
            }
            return c0194i3Arr2;
        }

        /* renamed from: u0 */
        public static List<byte[]> m2610u0(String[] strArr) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                arrayList.add(Base64.decode(str, 0));
            }
            return arrayList;
        }

        @SuppressLint({"SoonBlockedPrivateApi"})
        /* renamed from: v */
        public static void m2609v(Canvas canvas, boolean z) {
            Method method;
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                if (z) {
                    canvas.enableZ();
                } else {
                    canvas.disableZ();
                }
            } else if (i != 28) {
                if (!f85u) {
                    try {
                        Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                        f83s = declaredMethod;
                        declaredMethod.setAccessible(true);
                        Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                        f84t = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                    }
                    f85u = true;
                }
                if (z) {
                    try {
                        Method method2 = f83s;
                        if (method2 != null) {
                            method2.invoke(canvas, new Object[0]);
                        }
                    } catch (IllegalAccessException unused2) {
                        return;
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e.getCause());
                    }
                }
                if (z || (method = f84t) == null) {
                    return;
                }
                method.invoke(canvas, new Object[0]);
            } else {
                throw new IllegalStateException("This method doesn't work on Pie!");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: v0 */
        public static <T extends Drawable> T m2608v0(Drawable drawable) {
            return drawable instanceof InterfaceC0430S3 ? (T) ((InterfaceC0430S3) drawable).mo2009b() : drawable;
        }

        /* renamed from: w */
        public static C0133F6 m2607w(RandomAccessFile randomAccessFile) {
            long length = randomAccessFile.length() - 22;
            if (length >= 0) {
                long j = length - 65536;
                long j2 = j >= 0 ? j : 0L;
                int reverseBytes = Integer.reverseBytes(101010256);
                do {
                    randomAccessFile.seek(length);
                    if (randomAccessFile.readInt() == reverseBytes) {
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        randomAccessFile.skipBytes(2);
                        C0133F6 c0133f6 = new C0133F6();
                        c0133f6.f442b = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                        c0133f6.f441a = Integer.reverseBytes(randomAccessFile.readInt()) & 4294967295L;
                        return c0133f6;
                    }
                    length--;
                } while (length >= j2);
                throw new ZipException("End Of Central Directory signature not found");
            }
            StringBuilder m253r = outline.m253r("File too short to be a zip file: ");
            m253r.append(randomAccessFile.length());
            throw new ZipException(m253r.toString());
        }

        /* renamed from: w0 */
        public static boolean m2606w0(C2248t2.EnumC2249a enumC2249a, C2248t2.EnumC2249a enumC2249a2, C2248t2.EnumC2249a enumC2249a3, C2248t2.EnumC2249a enumC2249a4) {
            C2248t2.EnumC2249a enumC2249a5 = C2248t2.EnumC2249a.MATCH_PARENT;
            C2248t2.EnumC2249a enumC2249a6 = C2248t2.EnumC2249a.WRAP_CONTENT;
            C2248t2.EnumC2249a enumC2249a7 = C2248t2.EnumC2249a.FIXED;
            return (enumC2249a3 == enumC2249a7 || enumC2249a3 == enumC2249a6 || (enumC2249a3 == enumC2249a5 && enumC2249a != enumC2249a6)) || (enumC2249a4 == enumC2249a7 || enumC2249a4 == enumC2249a6 || (enumC2249a4 == enumC2249a5 && enumC2249a2 != enumC2249a6));
        }

        /* renamed from: x */
        public static C0348P2 m2605x(C2248t2 c2248t2, int i, ArrayList<C0348P2> arrayList, C0348P2 c0348p2) {
            int i2;
            int i3;
            if (i == 0) {
                i2 = c2248t2.f6461G0;
            } else {
                i2 = c2248t2.f6463H0;
            }
            if (i2 != -1 && (c0348p2 == null || i2 != c0348p2.f1181b)) {
                int i4 = 0;
                while (true) {
                    if (i4 >= arrayList.size()) {
                        break;
                    }
                    C0348P2 c0348p22 = arrayList.get(i4);
                    if (c0348p22.f1181b == i2) {
                        if (c0348p2 != null) {
                            c0348p2.m2157d(i, c0348p22);
                            arrayList.remove(c0348p2);
                        }
                        c0348p2 = c0348p22;
                    } else {
                        i4++;
                    }
                }
            } else if (i2 != -1) {
                return c0348p2;
            }
            if (c0348p2 == null) {
                if (c2248t2 instanceof C2363y2) {
                    C2363y2 c2363y2 = (C2363y2) c2248t2;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= c2363y2.f6853J0) {
                            i3 = -1;
                            break;
                        }
                        C2248t2 c2248t22 = c2363y2.f6852I0[i5];
                        if ((i == 0 && (i3 = c2248t22.f6461G0) != -1) || (i == 1 && (i3 = c2248t22.f6463H0) != -1)) {
                            break;
                        }
                        i5++;
                    }
                    if (i3 != -1) {
                        int i6 = 0;
                        while (true) {
                            if (i6 >= arrayList.size()) {
                                break;
                            }
                            C0348P2 c0348p23 = arrayList.get(i6);
                            if (c0348p23.f1181b == i3) {
                                c0348p2 = c0348p23;
                                break;
                            }
                            i6++;
                        }
                    }
                }
                if (c0348p2 == null) {
                    c0348p2 = new C0348P2(i);
                }
                arrayList.add(c0348p2);
            }
            if (c0348p2.m2160a(c2248t2)) {
                if (c2248t2 instanceof C2306w2) {
                    C2306w2 c2306w2 = (C2306w2) c2248t2;
                    c2306w2.f6738L0.m412c(c2306w2.f6739M0 == 0 ? 1 : 0, arrayList, c0348p2);
                }
                if (i == 0) {
                    c2248t2.f6461G0 = c0348p2.f1181b;
                    c2248t2.f6460G.m412c(i, arrayList, c0348p2);
                    c2248t2.f6464I.m412c(i, arrayList, c0348p2);
                } else {
                    c2248t2.f6463H0 = c0348p2.f1181b;
                    c2248t2.f6462H.m412c(i, arrayList, c0348p2);
                    c2248t2.f6466K.m412c(i, arrayList, c0348p2);
                    c2248t2.f6465J.m412c(i, arrayList, c0348p2);
                }
                c2248t2.f6469N.m412c(i, arrayList, c0348p2);
            }
            return c0348p2;
        }

        /* renamed from: x0 */
        public static Drawable m2604x0(Drawable drawable) {
            return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof InterfaceC0395R3)) ? new C0469U3(drawable) : drawable;
        }

        /* renamed from: y */
        public static C0348P2 m2603y(ArrayList<C0348P2> arrayList, int i) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0348P2 c0348p2 = arrayList.get(i2);
                if (i == c0348p2.f1181b) {
                    return c0348p2;
                }
            }
            return null;
        }

        /* renamed from: y0 */
        public static ActionMode.Callback m2602y0(TextView textView, ActionMode.Callback callback) {
            int i = Build.VERSION.SDK_INT;
            return (i < 26 || i > 27 || (callback instanceof ActionMode$CallbackC2001n5) || callback == null) ? callback : new ActionMode$CallbackC2001n5(callback, textView);
        }

        /* renamed from: z */
        public static void m2601z(Object obj) {
            if (!f68d) {
                try {
                    f67c = Class.forName("android.content.res.ThemedResourceCache");
                } catch (ClassNotFoundException e) {
                    Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
                }
                f68d = true;
            }
            Class<?> cls = f67c;
            if (cls == null) {
                return;
            }
            if (!f70f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    f69e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e2) {
                    Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
                }
                f70f = true;
            }
            Field field = f69e;
            if (field == null) {
                return;
            }
            LongSparseArray longSparseArray = null;
            try {
                longSparseArray = (LongSparseArray) field.get(obj);
            } catch (IllegalAccessException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            }
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
        }
    }

    /* renamed from: A$i */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0011i extends ContentFrameLayout {
        public C0011i(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return LayoutInflater$Factory2C0000A.this.m2703F(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = LayoutInflater$Factory2C0000A.this;
                    layoutInflater$Factory2C0000A.m2705D(layoutInflater$Factory2C0000A.m2696M(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0279M.m2210b(getContext(), i));
        }
    }

    /* renamed from: A$j */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0012j {

        /* renamed from: a */
        public int f87a;

        /* renamed from: b */
        public int f88b;

        /* renamed from: c */
        public int f89c;

        /* renamed from: d */
        public int f90d;

        /* renamed from: e */
        public ViewGroup f91e;

        /* renamed from: f */
        public View f92f;

        /* renamed from: g */
        public View f93g;

        /* renamed from: h */
        public C1905j0 f94h;

        /* renamed from: i */
        public C1850h0 f95i;

        /* renamed from: j */
        public Context f96j;

        /* renamed from: k */
        public boolean f97k;

        /* renamed from: l */
        public boolean f98l;

        /* renamed from: m */
        public boolean f99m;

        /* renamed from: n */
        public boolean f100n;

        /* renamed from: o */
        public boolean f101o = false;

        /* renamed from: p */
        public boolean f102p;

        /* renamed from: q */
        public Bundle f103q;

        public C0012j(int i) {
            this.f87a = i;
        }

        /* renamed from: a */
        public void m2600a(C1905j0 c1905j0) {
            C1850h0 c1850h0;
            C1905j0 c1905j02 = this.f94h;
            if (c1905j0 == c1905j02) {
                return;
            }
            if (c1905j02 != null) {
                c1905j02.removeMenuPresenter(this.f95i);
            }
            this.f94h = c1905j0;
            if (c1905j0 == null || (c1850h0 = this.f95i) == null) {
                return;
            }
            c1905j0.addMenuPresenter(c1850h0);
        }
    }

    /* renamed from: A$k */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public final class C0013k implements InterfaceC2165p0.InterfaceC2166a {
        public C0013k() {
        }

        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        /* renamed from: a */
        public boolean mo458a(C1905j0 c1905j0) {
            Window.Callback m2695N;
            if (c1905j0 == c1905j0.getRootMenu()) {
                LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = LayoutInflater$Factory2C0000A.this;
                if (!layoutInflater$Factory2C0000A.f51z || (m2695N = layoutInflater$Factory2C0000A.m2695N()) == null || LayoutInflater$Factory2C0000A.this.f15L) {
                    return true;
                }
                m2695N.onMenuOpened(108, c1905j0);
                return true;
            }
            return true;
        }

        @Override // p000.InterfaceC2165p0.InterfaceC2166a
        public void onCloseMenu(C1905j0 c1905j0, boolean z) {
            C1905j0 rootMenu = c1905j0.getRootMenu();
            boolean z2 = rootMenu != c1905j0;
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = LayoutInflater$Factory2C0000A.this;
            if (z2) {
                c1905j0 = rootMenu;
            }
            C0012j m2698K = layoutInflater$Factory2C0000A.m2698K(c1905j0);
            if (m2698K != null) {
                if (z2) {
                    LayoutInflater$Factory2C0000A.this.m2707B(m2698K.f87a, m2698K, rootMenu);
                    LayoutInflater$Factory2C0000A.this.m2705D(m2698K, true);
                    return;
                }
                LayoutInflater$Factory2C0000A.this.m2705D(m2698K, z);
            }
        }
    }

    public LayoutInflater$Factory2C0000A(Context context, Window window, InterfaceC2360y interfaceC2360y, Object obj) {
        C0101E1<String, Integer> c0101e1;
        Integer num;
        AppCompatActivity appCompatActivity = null;
        this.f16M = -100;
        this.f30d = context;
        this.f33h = interfaceC2360y;
        this.f29c = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (context instanceof AppCompatActivity) {
                        appCompatActivity = (AppCompatActivity) context;
                        break;
                    } else if (!(context instanceof ContextWrapper)) {
                        break;
                    } else {
                        context = ((ContextWrapper) context).getBaseContext();
                    }
                } else {
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.f16M = appCompatActivity.m1682y().mo42d();
            }
        }
        if (this.f16M == -100 && (num = (c0101e1 = f0Z).get(this.f29c.getClass().getName())) != null) {
            this.f16M = num.intValue();
            c0101e1.remove(this.f29c.getClass().getName());
        }
        if (window != null) {
            m2708A(window);
        }
        C0032B0.m2576e();
    }

    /* renamed from: A */
    public final void m2708A(Window window) {
        if (this.f31f == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof C0005d)) {
                C0005d c0005d = new C0005d(callback);
                this.f32g = c0005d;
                window.setCallback(c0005d);
                C0954b1 m1197q = C0954b1.m1197q(this.f30d, null, f1a0);
                Drawable m1206h = m1197q.m1206h(0);
                if (m1206h != null) {
                    window.setBackgroundDrawable(m1206h);
                }
                m1197q.f3660b.recycle();
                this.f31f = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    /* renamed from: B */
    public void m2707B(int i, C0012j c0012j, Menu menu) {
        if (menu == null && c0012j != null) {
            menu = c0012j.f94h;
        }
        if ((c0012j == null || c0012j.f99m) && !this.f15L) {
            this.f32g.f3746a.onPanelClosed(i, menu);
        }
    }

    /* renamed from: C */
    public void m2706C(C1905j0 c1905j0) {
        if (this.f8E) {
            return;
        }
        this.f8E = true;
        this.f37l.mo1663g();
        Window.Callback m2695N = m2695N();
        if (m2695N != null && !this.f15L) {
            m2695N.onPanelClosed(108, c1905j0);
        }
        this.f8E = false;
    }

    /* renamed from: D */
    public void m2705D(C0012j c0012j, boolean z) {
        ViewGroup viewGroup;
        InterfaceC0210J0 interfaceC0210J0;
        if (z && c0012j.f87a == 0 && (interfaceC0210J0 = this.f37l) != null && interfaceC0210J0.mo1669a()) {
            m2706C(c0012j.f94h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f30d.getSystemService("window");
        if (windowManager != null && c0012j.f99m && (viewGroup = c0012j.f91e) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                m2707B(c0012j.f87a, c0012j, null);
            }
        }
        c0012j.f97k = false;
        c0012j.f98l = false;
        c0012j.f99m = false;
        c0012j.f92f = null;
        c0012j.f101o = true;
        if (this.f10G == c0012j) {
            this.f10G = null;
        }
    }

    /* renamed from: E */
    public final Configuration m2704E(Context context, int i, Configuration configuration) {
        int i2;
        if (i != 1) {
            i2 = i != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i2 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* renamed from: F */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m2703F(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.m2703F(android.view.KeyEvent):boolean");
    }

    /* renamed from: G */
    public void m2702G(int i) {
        C0012j m2696M = m2696M(i);
        if (m2696M.f94h != null) {
            Bundle bundle = new Bundle();
            m2696M.f94h.saveActionViewStates(bundle);
            if (bundle.size() > 0) {
                m2696M.f103q = bundle;
            }
            m2696M.f94h.stopDispatchingItemsChanged();
            m2696M.f94h.clear();
        }
        m2696M.f102p = true;
        m2696M.f101o = true;
        if ((i == 108 || i == 0) && this.f37l != null) {
            C0012j m2696M2 = m2696M(0);
            m2696M2.f97k = false;
            m2689T(m2696M2, null);
        }
    }

    /* renamed from: H */
    public void m2701H() {
        C0554X4 c0554x4 = this.f44s;
        if (c0554x4 != null) {
            c0554x4.m1808b();
        }
    }

    /* renamed from: I */
    public final void m2700I() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (this.f45t) {
            return;
        }
        TypedArray obtainStyledAttributes = this.f30d.obtainStyledAttributes(C2012o.AppCompatTheme);
        int i = C2012o.AppCompatTheme_windowActionBar;
        if (obtainStyledAttributes.hasValue(i)) {
            if (obtainStyledAttributes.getBoolean(C2012o.AppCompatTheme_windowNoTitle, false)) {
                mo28r(1);
            } else if (obtainStyledAttributes.getBoolean(i, false)) {
                mo28r(108);
            }
            if (obtainStyledAttributes.getBoolean(C2012o.AppCompatTheme_windowActionBarOverlay, false)) {
                mo28r(109);
            }
            if (obtainStyledAttributes.getBoolean(C2012o.AppCompatTheme_windowActionModeOverlay, false)) {
                mo28r(10);
            }
            this.f6C = obtainStyledAttributes.getBoolean(C2012o.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            m2699J();
            this.f31f.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f30d);
            if (!this.f7D) {
                if (this.f6C) {
                    viewGroup = (ViewGroup) from.inflate(C1949l.abc_dialog_title_material, (ViewGroup) null);
                    this.f4A = false;
                    this.f51z = false;
                } else if (this.f51z) {
                    TypedValue typedValue = new TypedValue();
                    this.f30d.getTheme().resolveAttribute(C1671f.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        context = new C0546X(this.f30d, typedValue.resourceId);
                    } else {
                        context = this.f30d;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(C1949l.abc_screen_toolbar, (ViewGroup) null);
                    InterfaceC0210J0 interfaceC0210J0 = (InterfaceC0210J0) viewGroup.findViewById(C1930k.decor_content_parent);
                    this.f37l = interfaceC0210J0;
                    interfaceC0210J0.setWindowCallback(m2695N());
                    if (this.f4A) {
                        this.f37l.mo1664f(109);
                    }
                    if (this.f49x) {
                        this.f37l.mo1664f(2);
                    }
                    if (this.f50y) {
                        this.f37l.mo1664f(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                viewGroup = this.f5B ? (ViewGroup) from.inflate(C1949l.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(C1949l.abc_screen_simple, (ViewGroup) null);
            }
            if (viewGroup != null) {
                C0031B c0031b = new C0031B(this);
                AtomicInteger atomicInteger = C0492V4.f1798a;
                C0492V4.C0500h.m1880u(viewGroup, c0031b);
                if (this.f37l == null) {
                    this.f47v = (TextView) viewGroup.findViewById(C1930k.title);
                }
                Method method = C1852h1.f5113a;
                try {
                    Method method2 = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                    if (!method2.isAccessible()) {
                        method2.setAccessible(true);
                    }
                    method2.invoke(viewGroup, new Object[0]);
                } catch (IllegalAccessException e) {
                    Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
                } catch (NoSuchMethodException unused) {
                    Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
                } catch (InvocationTargetException e2) {
                    Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
                }
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(C1930k.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f31f.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.f31f.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new C0051C(this));
                this.f46u = viewGroup;
                Object obj = this.f29c;
                if (obj instanceof Activity) {
                    charSequence = ((Activity) obj).getTitle();
                } else {
                    charSequence = this.f36k;
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    InterfaceC0210J0 interfaceC0210J02 = this.f37l;
                    if (interfaceC0210J02 != null) {
                        interfaceC0210J02.setWindowTitle(charSequence);
                    } else {
                        ActionBar actionBar = this.f34i;
                        if (actionBar != null) {
                            actionBar.mo1701t(charSequence);
                        } else {
                            TextView textView = this.f47v;
                            if (textView != null) {
                                textView.setText(charSequence);
                            }
                        }
                    }
                }
                ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.f46u.findViewById(16908290);
                View decorView = this.f31f.getDecorView();
                contentFrameLayout2.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                TypedArray obtainStyledAttributes2 = this.f30d.obtainStyledAttributes(C2012o.AppCompatTheme);
                int i2 = C2012o.AppCompatTheme_windowMinWidthMajor;
                if (contentFrameLayout2.f2499a == null) {
                    contentFrameLayout2.f2499a = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i2, contentFrameLayout2.f2499a);
                int i3 = C2012o.AppCompatTheme_windowMinWidthMinor;
                if (contentFrameLayout2.f2500b == null) {
                    contentFrameLayout2.f2500b = new TypedValue();
                }
                obtainStyledAttributes2.getValue(i3, contentFrameLayout2.f2500b);
                int i4 = C2012o.AppCompatTheme_windowFixedWidthMajor;
                if (obtainStyledAttributes2.hasValue(i4)) {
                    if (contentFrameLayout2.f2501c == null) {
                        contentFrameLayout2.f2501c = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i4, contentFrameLayout2.f2501c);
                }
                int i5 = C2012o.AppCompatTheme_windowFixedWidthMinor;
                if (obtainStyledAttributes2.hasValue(i5)) {
                    if (contentFrameLayout2.f2502d == null) {
                        contentFrameLayout2.f2502d = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i5, contentFrameLayout2.f2502d);
                }
                int i6 = C2012o.AppCompatTheme_windowFixedHeightMajor;
                if (obtainStyledAttributes2.hasValue(i6)) {
                    if (contentFrameLayout2.f2503f == null) {
                        contentFrameLayout2.f2503f = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i6, contentFrameLayout2.f2503f);
                }
                int i7 = C2012o.AppCompatTheme_windowFixedHeightMinor;
                if (obtainStyledAttributes2.hasValue(i7)) {
                    if (contentFrameLayout2.f2504g == null) {
                        contentFrameLayout2.f2504g = new TypedValue();
                    }
                    obtainStyledAttributes2.getValue(i7, contentFrameLayout2.f2504g);
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout2.requestLayout();
                this.f45t = true;
                C0012j m2696M = m2696M(0);
                if (this.f15L || m2696M.f94h != null) {
                    return;
                }
                m2693P(108);
                return;
            }
            StringBuilder m253r = outline.m253r("AppCompat does not support the current theme features: { windowActionBar: ");
            m253r.append(this.f51z);
            m253r.append(", windowActionBarOverlay: ");
            m253r.append(this.f4A);
            m253r.append(", android:windowIsFloating: ");
            m253r.append(this.f6C);
            m253r.append(", windowActionModeOverlay: ");
            m253r.append(this.f5B);
            m253r.append(", windowNoTitle: ");
            m253r.append(this.f7D);
            m253r.append(" }");
            throw new IllegalArgumentException(m253r.toString());
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* renamed from: J */
    public final void m2699J() {
        if (this.f31f == null) {
            Object obj = this.f29c;
            if (obj instanceof Activity) {
                m2708A(((Activity) obj).getWindow());
            }
        }
        if (this.f31f == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    /* renamed from: K */
    public C0012j m2698K(Menu menu) {
        C0012j[] c0012jArr = this.f9F;
        int length = c0012jArr != null ? c0012jArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0012j c0012j = c0012jArr[i];
            if (c0012j != null && c0012j.f94h == menu) {
                return c0012j;
            }
        }
        return null;
    }

    /* renamed from: L */
    public final AbstractC0007f m2697L(Context context) {
        if (this.f20Q == null) {
            if (C0229K.f712d == null) {
                Context applicationContext = context.getApplicationContext();
                C0229K.f712d = new C0229K(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.f20Q = new C0009g(C0229K.f712d);
        }
        return this.f20Q;
    }

    /* renamed from: M */
    public C0012j m2696M(int i) {
        C0012j[] c0012jArr = this.f9F;
        if (c0012jArr == null || c0012jArr.length <= i) {
            C0012j[] c0012jArr2 = new C0012j[i + 1];
            if (c0012jArr != null) {
                System.arraycopy(c0012jArr, 0, c0012jArr2, 0, c0012jArr.length);
            }
            this.f9F = c0012jArr2;
            c0012jArr = c0012jArr2;
        }
        C0012j c0012j = c0012jArr[i];
        if (c0012j == null) {
            C0012j c0012j2 = new C0012j(i);
            c0012jArr[i] = c0012j2;
            return c0012j2;
        }
        return c0012j;
    }

    /* renamed from: N */
    public final Window.Callback m2695N() {
        return this.f31f.getCallback();
    }

    /* renamed from: O */
    public final void m2694O() {
        m2700I();
        if (this.f51z && this.f34i == null) {
            Object obj = this.f29c;
            if (obj instanceof Activity) {
                this.f34i = new C0258L((Activity) this.f29c, this.f4A);
            } else if (obj instanceof Dialog) {
                this.f34i = new C0258L((Dialog) this.f29c);
            }
            ActionBar actionBar = this.f34i;
            if (actionBar != null) {
                actionBar.mo1709l(this.f25V);
            }
        }
    }

    /* renamed from: P */
    public final void m2693P(int i) {
        this.f23T = (1 << i) | this.f23T;
        if (this.f22S) {
            return;
        }
        View decorView = this.f31f.getDecorView();
        Runnable runnable = this.f24U;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1931m(decorView, runnable);
        this.f22S = true;
    }

    /* renamed from: Q */
    public int m2692Q(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i == 0) {
                    if (Build.VERSION.SDK_INT < 23 || ((UiModeManager) context.getApplicationContext().getSystemService(UiModeManager.class)).getNightMode() != 0) {
                        return m2697L(context).mo2679c();
                    }
                    return -1;
                } else if (i != 1 && i != 2) {
                    if (i == 3) {
                        if (this.f21R == null) {
                            this.f21R = new C0006e(context);
                        }
                        return this.f21R.mo2679c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            }
            return i;
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x0152, code lost:
        if (r14 != null) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0159  */
    /* renamed from: R */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2691R(p000.LayoutInflater$Factory2C0000A.C0012j r13, android.view.KeyEvent r14) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.m2691R(A$j, android.view.KeyEvent):void");
    }

    /* renamed from: S */
    public final boolean m2690S(C0012j c0012j, int i, KeyEvent keyEvent, int i2) {
        C1905j0 c1905j0;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c0012j.f97k || m2689T(c0012j, keyEvent)) && (c1905j0 = c0012j.f94h) != null) {
            z = c1905j0.performShortcut(i, keyEvent, i2);
        }
        if (z && (i2 & 1) == 0 && this.f37l == null) {
            m2705D(c0012j, true);
        }
        return z;
    }

    /* renamed from: T */
    public final boolean m2689T(C0012j c0012j, KeyEvent keyEvent) {
        InterfaceC0210J0 interfaceC0210J0;
        InterfaceC0210J0 interfaceC0210J02;
        Resources.Theme theme;
        InterfaceC0210J0 interfaceC0210J03;
        InterfaceC0210J0 interfaceC0210J04;
        if (this.f15L) {
            return false;
        }
        if (c0012j.f97k) {
            return true;
        }
        C0012j c0012j2 = this.f10G;
        if (c0012j2 != null && c0012j2 != c0012j) {
            m2705D(c0012j2, false);
        }
        Window.Callback m2695N = m2695N();
        if (m2695N != null) {
            c0012j.f93g = m2695N.onCreatePanelView(c0012j.f87a);
        }
        int i = c0012j.f87a;
        boolean z = i == 0 || i == 108;
        if (z && (interfaceC0210J04 = this.f37l) != null) {
            interfaceC0210J04.setMenuPrepared();
        }
        if (c0012j.f93g == null && (!z || !(this.f34i instanceof C0181I))) {
            C1905j0 c1905j0 = c0012j.f94h;
            if (c1905j0 == null || c0012j.f102p) {
                if (c1905j0 == null) {
                    Context context = this.f30d;
                    int i2 = c0012j.f87a;
                    if ((i2 == 0 || i2 == 108) && this.f37l != null) {
                        TypedValue typedValue = new TypedValue();
                        Resources.Theme theme2 = context.getTheme();
                        theme2.resolveAttribute(C1671f.actionBarTheme, typedValue, true);
                        if (typedValue.resourceId != 0) {
                            theme = context.getResources().newTheme();
                            theme.setTo(theme2);
                            theme.applyStyle(typedValue.resourceId, true);
                            theme.resolveAttribute(C1671f.actionBarWidgetTheme, typedValue, true);
                        } else {
                            theme2.resolveAttribute(C1671f.actionBarWidgetTheme, typedValue, true);
                            theme = null;
                        }
                        if (typedValue.resourceId != 0) {
                            if (theme == null) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                            }
                            theme.applyStyle(typedValue.resourceId, true);
                        }
                        if (theme != null) {
                            C0546X c0546x = new C0546X(context, 0);
                            c0546x.getTheme().setTo(theme);
                            context = c0546x;
                        }
                    }
                    C1905j0 c1905j02 = new C1905j0(context);
                    c1905j02.setCallback(this);
                    c0012j.m2600a(c1905j02);
                    if (c0012j.f94h == null) {
                        return false;
                    }
                }
                if (z && (interfaceC0210J02 = this.f37l) != null) {
                    if (this.f38m == null) {
                        this.f38m = new C0002b();
                    }
                    interfaceC0210J02.setMenu(c0012j.f94h, this.f38m);
                }
                c0012j.f94h.stopDispatchingItemsChanged();
                if (!m2695N.onCreatePanelMenu(c0012j.f87a, c0012j.f94h)) {
                    c0012j.m2600a(null);
                    if (z && (interfaceC0210J0 = this.f37l) != null) {
                        interfaceC0210J0.setMenu(null, this.f38m);
                    }
                    return false;
                }
                c0012j.f102p = false;
            }
            c0012j.f94h.stopDispatchingItemsChanged();
            Bundle bundle = c0012j.f103q;
            if (bundle != null) {
                c0012j.f94h.restoreActionViewStates(bundle);
                c0012j.f103q = null;
            }
            if (!m2695N.onPreparePanel(0, c0012j.f93g, c0012j.f94h)) {
                if (z && (interfaceC0210J03 = this.f37l) != null) {
                    interfaceC0210J03.setMenu(null, this.f38m);
                }
                c0012j.f94h.startDispatchingItemsChanged();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            c0012j.f100n = z2;
            c0012j.f94h.setQwertyMode(z2);
            c0012j.f94h.startDispatchingItemsChanged();
        }
        c0012j.f97k = true;
        c0012j.f98l = false;
        this.f10G = c0012j;
        return true;
    }

    /* renamed from: U */
    public final boolean m2688U() {
        ViewGroup viewGroup;
        if (this.f45t && (viewGroup = this.f46u) != null) {
            AtomicInteger atomicInteger = C0492V4.f1798a;
            if (C0492V4.C0498f.m1908c(viewGroup)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: V */
    public final void m2687V() {
        if (this.f45t) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* renamed from: W */
    public final int m2686W(C0958b5 c0958b5, Rect rect) {
        boolean z;
        boolean z2;
        int m210b;
        int m1185e = c0958b5.m1185e();
        ActionBarContextView actionBarContextView = this.f41p;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f41p.getLayoutParams();
            if (this.f41p.isShown()) {
                if (this.f26W == null) {
                    this.f26W = new Rect();
                    this.f27X = new Rect();
                }
                Rect rect2 = this.f26W;
                Rect rect3 = this.f27X;
                rect2.set(c0958b5.m1187c(), c0958b5.m1185e(), c0958b5.m1186d(), c0958b5.m1188b());
                C1852h1.m787a(this.f46u, rect2, rect3);
                int i = rect2.top;
                int i2 = rect2.left;
                int i3 = rect2.right;
                C0958b5 m1959l = C0492V4.m1959l(this.f46u);
                int m1187c = m1959l == null ? 0 : m1959l.m1187c();
                int m1186d = m1959l == null ? 0 : m1959l.m1186d();
                if (marginLayoutParams.topMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i;
                    marginLayoutParams.leftMargin = i2;
                    marginLayoutParams.rightMargin = i3;
                    z2 = true;
                }
                if (i > 0 && this.f48w == null) {
                    View view = new View(this.f30d);
                    this.f48w = view;
                    view.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = m1187c;
                    layoutParams.rightMargin = m1186d;
                    this.f46u.addView(this.f48w, -1, layoutParams);
                } else {
                    View view2 = this.f48w;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i4 = marginLayoutParams2.height;
                        int i5 = marginLayoutParams.topMargin;
                        if (i4 != i5 || marginLayoutParams2.leftMargin != m1187c || marginLayoutParams2.rightMargin != m1186d) {
                            marginLayoutParams2.height = i5;
                            marginLayoutParams2.leftMargin = m1187c;
                            marginLayoutParams2.rightMargin = m1186d;
                            this.f48w.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view3 = this.f48w;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    View view4 = this.f48w;
                    AtomicInteger atomicInteger = C0492V4.f1798a;
                    if ((C0492V4.C0495c.m1937g(view4) & 8192) != 0) {
                        m210b = C2307w3.m210b(this.f30d, C1849h.abc_decor_view_status_guard_light);
                    } else {
                        m210b = C2307w3.m210b(this.f30d, C1849h.abc_decor_view_status_guard);
                    }
                    view4.setBackgroundColor(m210b);
                }
                if (!this.f5B && z) {
                    m1185e = 0;
                }
                r4 = z2;
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                } else {
                    r4 = false;
                }
                z = false;
            }
            if (r4) {
                this.f41p.setLayoutParams(marginLayoutParams);
            }
        }
        View view5 = this.f48w;
        if (view5 != null) {
            view5.setVisibility(z ? 0 : 8);
        }
        return m1185e;
    }

    @Override // p000.AbstractC2394z
    /* renamed from: a */
    public void mo45a(View view, ViewGroup.LayoutParams layoutParams) {
        m2700I();
        ((ViewGroup) this.f46u.findViewById(16908290)).addView(view, layoutParams);
        this.f32g.f3746a.onContentChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0196  */
    @Override // p000.AbstractC2394z
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.content.Context mo44b(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.mo44b(android.content.Context):android.content.Context");
    }

    @Override // p000.AbstractC2394z
    /* renamed from: c */
    public <T extends View> T mo43c(int i) {
        m2700I();
        return (T) this.f31f.findViewById(i);
    }

    @Override // p000.AbstractC2394z
    /* renamed from: d */
    public int mo42d() {
        return this.f16M;
    }

    @Override // p000.AbstractC2394z
    /* renamed from: e */
    public MenuInflater mo41e() {
        if (this.f35j == null) {
            m2694O();
            ActionBar actionBar = this.f34i;
            this.f35j = new C0602a0(actionBar != null ? actionBar.mo1716e() : this.f30d);
        }
        return this.f35j;
    }

    @Override // p000.AbstractC2394z
    /* renamed from: f */
    public ActionBar mo40f() {
        m2694O();
        return this.f34i;
    }

    @Override // p000.AbstractC2394z
    /* renamed from: g */
    public void mo39g() {
        LayoutInflater from = LayoutInflater.from(this.f30d);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else if (from.getFactory2() instanceof LayoutInflater$Factory2C0000A) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // p000.AbstractC2394z
    /* renamed from: h */
    public void mo38h() {
        m2694O();
        ActionBar actionBar = this.f34i;
        if (actionBar == null || !actionBar.mo1715f()) {
            m2693P(0);
        }
    }

    @Override // p000.AbstractC2394z
    /* renamed from: i */
    public void mo37i(Configuration configuration) {
        if (this.f51z && this.f45t) {
            m2694O();
            ActionBar actionBar = this.f34i;
            if (actionBar != null) {
                actionBar.mo1714g(configuration);
            }
        }
        C0032B0 m2580a = C0032B0.m2580a();
        Context context = this.f30d;
        synchronized (m2580a) {
            C0384R0 c0384r0 = m2580a.f162a;
            synchronized (c0384r0) {
                C0034B1<WeakReference<Drawable.ConstantState>> c0034b1 = c0384r0.f1301d.get(context);
                if (c0034b1 != null) {
                    c0034b1.m2569b();
                }
            }
        }
        m2684z(false);
    }

    @Override // p000.AbstractC2394z
    /* renamed from: j */
    public void mo36j(Bundle bundle) {
        this.f12I = true;
        m2684z(false);
        m2699J();
        Object obj = this.f29c;
        if (obj instanceof Activity) {
            String str = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    str = C0010h.m2664N(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar actionBar = this.f34i;
                if (actionBar == null) {
                    this.f25V = true;
                } else {
                    actionBar.mo1709l(true);
                }
            }
            synchronized (AbstractC2394z.f6896b) {
                AbstractC2394z.m29q(this);
                AbstractC2394z.f6895a.add(new WeakReference<>(this));
            }
        }
        this.f13J = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // p000.AbstractC2394z
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo35k() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f29c
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = p000.AbstractC2394z.f6896b
            monitor-enter(r0)
            p000.AbstractC2394z.m29q(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.f22S
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f31f
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.f24U
            r0.removeCallbacks(r1)
        L20:
            r0 = 0
            r3.f14K = r0
            r0 = 1
            r3.f15L = r0
            int r0 = r3.f16M
            r1 = -100
            if (r0 == r1) goto L50
            java.lang.Object r0 = r3.f29c
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L50
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L50
            E1<java.lang.String, java.lang.Integer> r0 = p000.LayoutInflater$Factory2C0000A.f0Z
            java.lang.Object r1 = r3.f29c
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.f16M
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5f
        L50:
            E1<java.lang.String, java.lang.Integer> r0 = p000.LayoutInflater$Factory2C0000A.f0Z
            java.lang.Object r1 = r3.f29c
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5f:
            androidx.appcompat.app.ActionBar r0 = r3.f34i
            if (r0 == 0) goto L66
            r0.mo1713h()
        L66:
            A$f r0 = r3.f20Q
            if (r0 == 0) goto L6d
            r0.m2682a()
        L6d:
            A$f r0 = r3.f21R
            if (r0 == 0) goto L74
            r0.m2682a()
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.mo35k():void");
    }

    @Override // p000.AbstractC2394z
    /* renamed from: l */
    public void mo34l(Bundle bundle) {
        m2700I();
    }

    @Override // p000.AbstractC2394z
    /* renamed from: m */
    public void mo33m() {
        m2694O();
        ActionBar actionBar = this.f34i;
        if (actionBar != null) {
            actionBar.mo1703r(true);
        }
    }

    @Override // p000.AbstractC2394z
    /* renamed from: n */
    public void mo32n(Bundle bundle) {
    }

    @Override // p000.AbstractC2394z
    /* renamed from: o */
    public void mo31o() {
        this.f14K = true;
        m2685y();
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.f28Y == null) {
            String string = this.f30d.obtainStyledAttributes(C2012o.AppCompatTheme).getString(C2012o.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.f28Y = new C0162H();
            } else {
                try {
                    this.f28Y = (C0162H) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.f28Y = new C0162H();
                }
            }
        }
        C0162H c0162h = this.f28Y;
        int i = C1832g1.f5071a;
        return c0162h.createView(view, str, context, attributeSet, false, false, true, false);
    }

    @Override // p000.C1905j0.InterfaceC1906a
    public boolean onMenuItemSelected(C1905j0 c1905j0, MenuItem menuItem) {
        C0012j m2698K;
        Window.Callback m2695N = m2695N();
        if (m2695N == null || this.f15L || (m2698K = m2698K(c1905j0.getRootMenu())) == null) {
            return false;
        }
        return m2695N.onMenuItemSelected(m2698K.f87a, menuItem);
    }

    @Override // p000.C1905j0.InterfaceC1906a
    public void onMenuModeChange(C1905j0 c1905j0) {
        InterfaceC0210J0 interfaceC0210J0 = this.f37l;
        if (interfaceC0210J0 != null && interfaceC0210J0.mo1665e() && (!ViewConfiguration.get(this.f30d).hasPermanentMenuKey() || this.f37l.mo1668b())) {
            Window.Callback m2695N = m2695N();
            if (this.f37l.mo1669a()) {
                this.f37l.mo1667c();
                if (this.f15L) {
                    return;
                }
                m2695N.onPanelClosed(108, m2696M(0).f94h);
                return;
            } else if (m2695N == null || this.f15L) {
                return;
            } else {
                if (this.f22S && (1 & this.f23T) != 0) {
                    this.f31f.getDecorView().removeCallbacks(this.f24U);
                    this.f24U.run();
                }
                C0012j m2696M = m2696M(0);
                C1905j0 c1905j02 = m2696M.f94h;
                if (c1905j02 == null || m2696M.f102p || !m2695N.onPreparePanel(0, m2696M.f93g, c1905j02)) {
                    return;
                }
                m2695N.onMenuOpened(108, m2696M.f94h);
                this.f37l.mo1666d();
                return;
            }
        }
        C0012j m2696M2 = m2696M(0);
        m2696M2.f101o = true;
        m2705D(m2696M2, false);
        m2691R(m2696M2, null);
    }

    @Override // p000.AbstractC2394z
    /* renamed from: p */
    public void mo30p() {
        this.f14K = false;
        m2694O();
        ActionBar actionBar = this.f34i;
        if (actionBar != null) {
            actionBar.mo1703r(false);
        }
    }

    @Override // p000.AbstractC2394z
    /* renamed from: r */
    public boolean mo28r(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.f7D && i == 108) {
            return false;
        }
        if (this.f51z && i == 1) {
            this.f51z = false;
        }
        if (i == 1) {
            m2687V();
            this.f7D = true;
            return true;
        } else if (i == 2) {
            m2687V();
            this.f49x = true;
            return true;
        } else if (i == 5) {
            m2687V();
            this.f50y = true;
            return true;
        } else if (i == 10) {
            m2687V();
            this.f5B = true;
            return true;
        } else if (i == 108) {
            m2687V();
            this.f51z = true;
            return true;
        } else if (i != 109) {
            return this.f31f.requestFeature(i);
        } else {
            m2687V();
            this.f4A = true;
            return true;
        }
    }

    @Override // p000.AbstractC2394z
    /* renamed from: s */
    public void mo27s(int i) {
        m2700I();
        ViewGroup viewGroup = (ViewGroup) this.f46u.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f30d).inflate(i, viewGroup);
        this.f32g.f3746a.onContentChanged();
    }

    @Override // p000.AbstractC2394z
    /* renamed from: t */
    public void mo26t(View view) {
        m2700I();
        ViewGroup viewGroup = (ViewGroup) this.f46u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f32g.f3746a.onContentChanged();
    }

    @Override // p000.AbstractC2394z
    /* renamed from: u */
    public void mo25u(View view, ViewGroup.LayoutParams layoutParams) {
        m2700I();
        ViewGroup viewGroup = (ViewGroup) this.f46u.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f32g.f3746a.onContentChanged();
    }

    @Override // p000.AbstractC2394z
    /* renamed from: v */
    public void mo24v(Toolbar toolbar) {
        CharSequence charSequence;
        if (this.f29c instanceof Activity) {
            m2694O();
            ActionBar actionBar = this.f34i;
            if (!(actionBar instanceof C0258L)) {
                this.f35j = null;
                if (actionBar != null) {
                    actionBar.mo1713h();
                }
                if (toolbar != null) {
                    Object obj = this.f29c;
                    if (obj instanceof Activity) {
                        charSequence = ((Activity) obj).getTitle();
                    } else {
                        charSequence = this.f36k;
                    }
                    C0181I c0181i = new C0181I(toolbar, charSequence, this.f32g);
                    this.f34i = c0181i;
                    this.f31f.setCallback(c0181i.f598c);
                } else {
                    this.f34i = null;
                    this.f31f.setCallback(this.f32g);
                }
                mo38h();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    @Override // p000.AbstractC2394z
    /* renamed from: w */
    public void mo23w(int i) {
        this.f17N = i;
    }

    @Override // p000.AbstractC2394z
    /* renamed from: x */
    public final void mo22x(CharSequence charSequence) {
        this.f36k = charSequence;
        InterfaceC0210J0 interfaceC0210J0 = this.f37l;
        if (interfaceC0210J0 != null) {
            interfaceC0210J0.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.f34i;
        if (actionBar != null) {
            actionBar.mo1701t(charSequence);
            return;
        }
        TextView textView = this.f47v;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* renamed from: y */
    public boolean m2685y() {
        return m2684z(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:149:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5 A[ADDED_TO_REGION] */
    /* renamed from: z */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m2684z(boolean r13) {
        /*
            Method dump skipped, instructions count: 581
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.m2684z(boolean):boolean");
    }

    /* renamed from: A$d */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0005d extends Window$CallbackC0980c0 {
        public C0005d(Window.Callback callback) {
            super(callback);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final android.view.ActionMode m2683a(android.view.ActionMode.Callback r10) {
            /*
                Method dump skipped, instructions count: 443
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.C0005d.m2683a(android.view.ActionMode$Callback):android.view.ActionMode");
        }

        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return LayoutInflater$Factory2C0000A.this.m2703F(keyEvent) || this.f3746a.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
            if (r6 != false) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) {
            /*
                r5 = this;
                android.view.Window$Callback r0 = r5.f3746a
                boolean r0 = r0.dispatchKeyShortcutEvent(r6)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L4f
                A r0 = p000.LayoutInflater$Factory2C0000A.this
                int r3 = r6.getKeyCode()
                r0.m2694O()
                androidx.appcompat.app.ActionBar r4 = r0.f34i
                if (r4 == 0) goto L1f
                boolean r3 = r4.mo1712i(r3, r6)
                if (r3 == 0) goto L1f
            L1d:
                r6 = 1
                goto L4d
            L1f:
                A$j r3 = r0.f10G
                if (r3 == 0) goto L34
                int r4 = r6.getKeyCode()
                boolean r3 = r0.m2690S(r3, r4, r6, r2)
                if (r3 == 0) goto L34
                A$j r6 = r0.f10G
                if (r6 == 0) goto L1d
                r6.f98l = r2
                goto L1d
            L34:
                A$j r3 = r0.f10G
                if (r3 != 0) goto L4c
                A$j r3 = r0.m2696M(r1)
                r0.m2689T(r3, r6)
                int r4 = r6.getKeyCode()
                boolean r6 = r0.m2690S(r3, r4, r6, r2)
                r3.f97k = r1
                if (r6 == 0) goto L4c
                goto L1d
            L4c:
                r6 = 0
            L4d:
                if (r6 == 0) goto L50
            L4f:
                r1 = 1
            L50:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.LayoutInflater$Factory2C0000A.C0005d.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C1905j0)) {
                return this.f3746a.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            this.f3746a.onMenuOpened(i, menu);
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = LayoutInflater$Factory2C0000A.this;
            Objects.requireNonNull(layoutInflater$Factory2C0000A);
            if (i == 108) {
                layoutInflater$Factory2C0000A.m2694O();
                ActionBar actionBar = layoutInflater$Factory2C0000A.f34i;
                if (actionBar != null) {
                    actionBar.mo1718c(true);
                }
            }
            return true;
        }

        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            this.f3746a.onPanelClosed(i, menu);
            LayoutInflater$Factory2C0000A layoutInflater$Factory2C0000A = LayoutInflater$Factory2C0000A.this;
            Objects.requireNonNull(layoutInflater$Factory2C0000A);
            if (i == 108) {
                layoutInflater$Factory2C0000A.m2694O();
                ActionBar actionBar = layoutInflater$Factory2C0000A.f34i;
                if (actionBar != null) {
                    actionBar.mo1718c(false);
                }
            } else if (i == 0) {
                C0012j m2696M = layoutInflater$Factory2C0000A.m2696M(i);
                if (m2696M.f99m) {
                    layoutInflater$Factory2C0000A.m2705D(m2696M, false);
                }
            }
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            C1905j0 c1905j0 = menu instanceof C1905j0 ? (C1905j0) menu : null;
            if (i == 0 && c1905j0 == null) {
                return false;
            }
            if (c1905j0 != null) {
                c1905j0.setOverrideVisibleItems(true);
            }
            boolean onPreparePanel = this.f3746a.onPreparePanel(i, view, menu);
            if (c1905j0 != null) {
                c1905j0.setOverrideVisibleItems(false);
            }
            return onPreparePanel;
        }

        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            C1905j0 c1905j0 = LayoutInflater$Factory2C0000A.this.m2696M(0).f94h;
            if (c1905j0 != null) {
                this.f3746a.onProvideKeyboardShortcuts(list, c1905j0, i);
            } else {
                this.f3746a.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            Objects.requireNonNull(LayoutInflater$Factory2C0000A.this);
            return m2683a(callback);
        }

        @Override // p000.Window$CallbackC0980c0, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            Objects.requireNonNull(LayoutInflater$Factory2C0000A.this);
            if (i != 0) {
                return this.f3746a.onWindowStartingActionMode(callback, i);
            }
            return m2683a(callback);
        }
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
