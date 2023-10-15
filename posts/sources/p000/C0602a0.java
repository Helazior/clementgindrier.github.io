package p000;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import okhttp3.internal.http2.Settings;
import org.xmlpull.p019v1.XmlPullParser;
import org.xmlpull.p019v1.XmlPullParserException;

/* renamed from: a0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0602a0 extends MenuInflater {

    /* renamed from: e */
    public static final Class<?>[] f2129e;

    /* renamed from: f */
    public static final Class<?>[] f2130f;

    /* renamed from: a */
    public final Object[] f2131a;

    /* renamed from: b */
    public final Object[] f2132b;

    /* renamed from: c */
    public Context f2133c;

    /* renamed from: d */
    public Object f2134d;

    /* renamed from: a0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class MenuItem$OnMenuItemClickListenerC0603a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c */
        public static final Class<?>[] f2135c = {MenuItem.class};

        /* renamed from: a */
        public Object f2136a;

        /* renamed from: b */
        public Method f2137b;

        public MenuItem$OnMenuItemClickListenerC0603a(Object obj, String str) {
            this.f2136a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f2137b = cls.getMethod(str, f2135c);
            } catch (Exception e) {
                StringBuilder m251t = outline.m251t("Couldn't resolve menu item onClick handler ", str, " in class ");
                m251t.append(cls.getName());
                InflateException inflateException = new InflateException(m251t.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f2137b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f2137b.invoke(this.f2136a, menuItem)).booleanValue();
                }
                this.f2137b.invoke(this.f2136a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: a0$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0604b {

        /* renamed from: A */
        public AbstractC0148G4 f2138A;

        /* renamed from: B */
        public CharSequence f2139B;

        /* renamed from: C */
        public CharSequence f2140C;

        /* renamed from: a */
        public Menu f2144a;

        /* renamed from: h */
        public boolean f2151h;

        /* renamed from: i */
        public int f2152i;

        /* renamed from: j */
        public int f2153j;

        /* renamed from: k */
        public CharSequence f2154k;

        /* renamed from: l */
        public CharSequence f2155l;

        /* renamed from: m */
        public int f2156m;

        /* renamed from: n */
        public char f2157n;

        /* renamed from: o */
        public int f2158o;

        /* renamed from: p */
        public char f2159p;

        /* renamed from: q */
        public int f2160q;

        /* renamed from: r */
        public int f2161r;

        /* renamed from: s */
        public boolean f2162s;

        /* renamed from: t */
        public boolean f2163t;

        /* renamed from: u */
        public boolean f2164u;

        /* renamed from: v */
        public int f2165v;

        /* renamed from: w */
        public int f2166w;

        /* renamed from: x */
        public String f2167x;

        /* renamed from: y */
        public String f2168y;

        /* renamed from: z */
        public String f2169z;

        /* renamed from: D */
        public ColorStateList f2141D = null;

        /* renamed from: E */
        public PorterDuff.Mode f2142E = null;

        /* renamed from: b */
        public int f2145b = 0;

        /* renamed from: c */
        public int f2146c = 0;

        /* renamed from: d */
        public int f2147d = 0;

        /* renamed from: e */
        public int f2148e = 0;

        /* renamed from: f */
        public boolean f2149f = true;

        /* renamed from: g */
        public boolean f2150g = true;

        public C0604b(Menu menu) {
            this.f2144a = menu;
        }

        /* renamed from: a */
        public SubMenu m1728a() {
            this.f2151h = true;
            SubMenu addSubMenu = this.f2144a.addSubMenu(this.f2145b, this.f2152i, this.f2153j, this.f2154k);
            m1726c(addSubMenu.getItem());
            return addSubMenu;
        }

        /* renamed from: b */
        public final <T> T m1727b(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, C0602a0.this.f2133c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        /* renamed from: c */
        public final void m1726c(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f2162s).setVisible(this.f2163t).setEnabled(this.f2164u).setCheckable(this.f2161r >= 1).setTitleCondensed(this.f2155l).setIcon(this.f2156m);
            int i = this.f2165v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.f2169z != null) {
                if (!C0602a0.this.f2133c.isRestricted()) {
                    C0602a0 c0602a0 = C0602a0.this;
                    if (c0602a0.f2134d == null) {
                        c0602a0.f2134d = c0602a0.m1730a(c0602a0.f2133c);
                    }
                    menuItem.setOnMenuItemClickListener(new MenuItem$OnMenuItemClickListenerC0603a(c0602a0.f2134d, this.f2169z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f2161r >= 2) {
                if (menuItem instanceof C1950l0) {
                    ((C1950l0) menuItem).m639k(true);
                } else if (menuItem instanceof MenuItemC1968m0) {
                    MenuItemC1968m0 menuItemC1968m0 = (MenuItemC1968m0) menuItem;
                    try {
                        if (menuItemC1968m0.f5470e == null) {
                            menuItemC1968m0.f5470e = menuItemC1968m0.f5469d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        menuItemC1968m0.f5470e.invoke(menuItemC1968m0.f5469d, Boolean.TRUE);
                    } catch (Exception e) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                    }
                }
            }
            String str = this.f2167x;
            if (str != null) {
                menuItem.setActionView((View) m1727b(str, C0602a0.f2129e, C0602a0.this.f2131a));
                z = true;
            }
            int i2 = this.f2166w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            AbstractC0148G4 abstractC0148G4 = this.f2138A;
            if (abstractC0148G4 != null) {
                if (menuItem instanceof InterfaceMenuItemC0553X3) {
                    ((InterfaceMenuItemC0553X3) menuItem).mo649a(abstractC0148G4);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.f2139B;
            boolean z2 = menuItem instanceof InterfaceMenuItemC0553X3;
            if (z2) {
                ((InterfaceMenuItemC0553X3) menuItem).setContentDescription(charSequence);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.f2140C;
            if (z2) {
                ((InterfaceMenuItemC0553X3) menuItem).setTooltipText(charSequence2);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setTooltipText(charSequence2);
            }
            char c = this.f2157n;
            int i3 = this.f2158o;
            if (z2) {
                ((InterfaceMenuItemC0553X3) menuItem).setAlphabeticShortcut(c, i3);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setAlphabeticShortcut(c, i3);
            }
            char c2 = this.f2159p;
            int i4 = this.f2160q;
            if (z2) {
                ((InterfaceMenuItemC0553X3) menuItem).setNumericShortcut(c2, i4);
            } else if (Build.VERSION.SDK_INT >= 26) {
                menuItem.setNumericShortcut(c2, i4);
            }
            PorterDuff.Mode mode = this.f2142E;
            if (mode != null) {
                if (z2) {
                    ((InterfaceMenuItemC0553X3) menuItem).setIconTintMode(mode);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.f2141D;
            if (colorStateList != null) {
                if (z2) {
                    ((InterfaceMenuItemC0553X3) menuItem).setIconTintList(colorStateList);
                } else if (Build.VERSION.SDK_INT >= 26) {
                    menuItem.setIconTintList(colorStateList);
                }
            }
        }
    }

    static {
        Class<?>[] clsArr = {Context.class};
        f2129e = clsArr;
        f2130f = clsArr;
    }

    public C0602a0(Context context) {
        super(context);
        this.f2133c = context;
        Object[] objArr = {context};
        this.f2131a = objArr;
        this.f2132b = objArr;
    }

    /* renamed from: a */
    public final Object m1730a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m1730a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* renamed from: b */
    public final void m1729b(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        C0604b c0604b = new C0604b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException(outline.m266e("Expecting menu, got ", name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z = false;
        boolean z2 = false;
        String str = null;
        while (!z) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            c0604b.f2145b = 0;
                            c0604b.f2146c = 0;
                            c0604b.f2147d = 0;
                            c0604b.f2148e = 0;
                            c0604b.f2149f = true;
                            c0604b.f2150g = true;
                        } else if (name2.equals("item")) {
                            if (!c0604b.f2151h) {
                                AbstractC0148G4 abstractC0148G4 = c0604b.f2138A;
                                if (abstractC0148G4 != null && abstractC0148G4.mo607a()) {
                                    c0604b.m1728a();
                                } else {
                                    c0604b.f2151h = true;
                                    c0604b.m1726c(c0604b.f2144a.add(c0604b.f2145b, c0604b.f2152i, c0604b.f2153j, c0604b.f2154k));
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        TypedArray obtainStyledAttributes = C0602a0.this.f2133c.obtainStyledAttributes(attributeSet, C2012o.MenuGroup);
                        c0604b.f2145b = obtainStyledAttributes.getResourceId(C2012o.MenuGroup_android_id, 0);
                        c0604b.f2146c = obtainStyledAttributes.getInt(C2012o.MenuGroup_android_menuCategory, 0);
                        c0604b.f2147d = obtainStyledAttributes.getInt(C2012o.MenuGroup_android_orderInCategory, 0);
                        c0604b.f2148e = obtainStyledAttributes.getInt(C2012o.MenuGroup_android_checkableBehavior, 0);
                        c0604b.f2149f = obtainStyledAttributes.getBoolean(C2012o.MenuGroup_android_visible, true);
                        c0604b.f2150g = obtainStyledAttributes.getBoolean(C2012o.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        C0954b1 m1197q = C0954b1.m1197q(C0602a0.this.f2133c, attributeSet, C2012o.MenuItem);
                        c0604b.f2152i = m1197q.m1201m(C2012o.MenuItem_android_id, 0);
                        c0604b.f2153j = (m1197q.m1204j(C2012o.MenuItem_android_menuCategory, c0604b.f2146c) & (-65536)) | (m1197q.m1204j(C2012o.MenuItem_android_orderInCategory, c0604b.f2147d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                        c0604b.f2154k = m1197q.m1199o(C2012o.MenuItem_android_title);
                        c0604b.f2155l = m1197q.m1199o(C2012o.MenuItem_android_titleCondensed);
                        c0604b.f2156m = m1197q.m1201m(C2012o.MenuItem_android_icon, 0);
                        String m1200n = m1197q.m1200n(C2012o.MenuItem_android_alphabeticShortcut);
                        c0604b.f2157n = m1200n == null ? (char) 0 : m1200n.charAt(0);
                        c0604b.f2158o = m1197q.m1204j(C2012o.MenuItem_alphabeticModifiers, 4096);
                        String m1200n2 = m1197q.m1200n(C2012o.MenuItem_android_numericShortcut);
                        c0604b.f2159p = m1200n2 == null ? (char) 0 : m1200n2.charAt(0);
                        c0604b.f2160q = m1197q.m1204j(C2012o.MenuItem_numericModifiers, 4096);
                        int i = C2012o.MenuItem_android_checkable;
                        if (m1197q.m1198p(i)) {
                            c0604b.f2161r = m1197q.m1213a(i, false) ? 1 : 0;
                        } else {
                            c0604b.f2161r = c0604b.f2148e;
                        }
                        c0604b.f2162s = m1197q.m1213a(C2012o.MenuItem_android_checked, false);
                        c0604b.f2163t = m1197q.m1213a(C2012o.MenuItem_android_visible, c0604b.f2149f);
                        c0604b.f2164u = m1197q.m1213a(C2012o.MenuItem_android_enabled, c0604b.f2150g);
                        c0604b.f2165v = m1197q.m1204j(C2012o.MenuItem_showAsAction, -1);
                        c0604b.f2169z = m1197q.m1200n(C2012o.MenuItem_android_onClick);
                        c0604b.f2166w = m1197q.m1201m(C2012o.MenuItem_actionLayout, 0);
                        c0604b.f2167x = m1197q.m1200n(C2012o.MenuItem_actionViewClass);
                        String m1200n3 = m1197q.m1200n(C2012o.MenuItem_actionProviderClass);
                        c0604b.f2168y = m1200n3;
                        boolean z3 = m1200n3 != null;
                        if (z3 && c0604b.f2166w == 0 && c0604b.f2167x == null) {
                            c0604b.f2138A = (AbstractC0148G4) c0604b.m1727b(m1200n3, f2130f, C0602a0.this.f2132b);
                        } else {
                            if (z3) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            c0604b.f2138A = null;
                        }
                        c0604b.f2139B = m1197q.m1199o(C2012o.MenuItem_contentDescription);
                        c0604b.f2140C = m1197q.m1199o(C2012o.MenuItem_tooltipText);
                        int i2 = C2012o.MenuItem_iconTintMode;
                        if (m1197q.m1198p(i2)) {
                            c0604b.f2142E = C0263L0.m2226c(m1197q.m1204j(i2, -1), c0604b.f2142E);
                        } else {
                            c0604b.f2142E = null;
                        }
                        int i3 = C2012o.MenuItem_iconTint;
                        if (m1197q.m1198p(i3)) {
                            c0604b.f2141D = m1197q.m1211c(i3);
                        } else {
                            c0604b.f2141D = null;
                        }
                        m1197q.f3660b.recycle();
                        c0604b.f2151h = false;
                    } else if (name3.equals("menu")) {
                        m1729b(xmlPullParser, attributeSet, c0604b.m1728a());
                    } else {
                        z2 = true;
                        str = name3;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof InterfaceMenuC0534W3)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.f2133c.getResources().getLayout(i);
                    m1729b(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (IOException e) {
                    throw new InflateException("Error inflating menu XML", e);
                }
            } catch (XmlPullParserException e2) {
                throw new InflateException("Error inflating menu XML", e2);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
