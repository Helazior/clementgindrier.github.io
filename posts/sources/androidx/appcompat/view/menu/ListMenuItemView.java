package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.InterfaceC2186q0;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ListMenuItemView extends LinearLayout implements InterfaceC2186q0.InterfaceC2187a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a */
    public C1950l0 f2317a;

    /* renamed from: b */
    public ImageView f2318b;

    /* renamed from: c */
    public RadioButton f2319c;

    /* renamed from: d */
    public TextView f2320d;

    /* renamed from: f */
    public CheckBox f2321f;

    /* renamed from: g */
    public TextView f2322g;

    /* renamed from: h */
    public ImageView f2323h;

    /* renamed from: i */
    public ImageView f2324i;

    /* renamed from: j */
    public LinearLayout f2325j;

    /* renamed from: k */
    public Drawable f2326k;

    /* renamed from: l */
    public int f2327l;

    /* renamed from: m */
    public Context f2328m;

    /* renamed from: n */
    public boolean f2329n;

    /* renamed from: o */
    public Drawable f2330o;

    /* renamed from: p */
    public boolean f2331p;

    /* renamed from: q */
    public LayoutInflater f2332q;

    /* renamed from: r */
    public boolean f2333r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1671f.listMenuViewStyle);
    }

    /* renamed from: a */
    public final LayoutInflater m1677a() {
        if (this.f2332q == null) {
            this.f2332q = LayoutInflater.from(getContext());
        }
        return this.f2332q;
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f2324i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2324i.getLayoutParams();
        rect.top = this.f2324i.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* renamed from: b */
    public final void m1676b() {
        CheckBox checkBox = (CheckBox) m1677a().inflate(C1949l.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f2321f = checkBox;
        LinearLayout linearLayout = this.f2325j;
        if (linearLayout != null) {
            linearLayout.addView(checkBox, -1);
        } else {
            addView(checkBox, -1);
        }
    }

    /* renamed from: c */
    public final void m1675c() {
        RadioButton radioButton = (RadioButton) m1677a().inflate(C1949l.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f2319c = radioButton;
        LinearLayout linearLayout = this.f2325j;
        if (linearLayout != null) {
            linearLayout.addView(radioButton, -1);
        } else {
            addView(radioButton, -1);
        }
    }

    @Override // p000.InterfaceC2186q0.InterfaceC2187a
    public C1950l0 getItemData() {
        return this.f2317a;
    }

    @Override // p000.InterfaceC2186q0.InterfaceC2187a
    public void initialize(C1950l0 c1950l0, int i) {
        this.f2317a = c1950l0;
        setVisibility(c1950l0.isVisible() ? 0 : 8);
        setTitle(c1950l0.f5415e);
        setCheckable(c1950l0.isCheckable());
        setShortcut(c1950l0.m636n(), c1950l0.m645e());
        setIcon(c1950l0.getIcon());
        setEnabled(c1950l0.isEnabled());
        boolean hasSubMenu = c1950l0.hasSubMenu();
        ImageView imageView = this.f2323h;
        if (imageView != null) {
            imageView.setVisibility(hasSubMenu ? 0 : 8);
        }
        setContentDescription(c1950l0.f5427q);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Drawable drawable = this.f2326k;
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1927q(this, drawable);
        TextView textView = (TextView) findViewById(C1930k.title);
        this.f2320d = textView;
        int i = this.f2327l;
        if (i != -1) {
            textView.setTextAppearance(this.f2328m, i);
        }
        this.f2322g = (TextView) findViewById(C1930k.shortcut);
        ImageView imageView = (ImageView) findViewById(C1930k.submenuarrow);
        this.f2323h = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f2330o);
        }
        this.f2324i = (ImageView) findViewById(C1930k.group_divider);
        this.f2325j = (LinearLayout) findViewById(C1930k.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (this.f2318b != null && this.f2329n) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2318b.getLayoutParams();
            int i3 = layoutParams.height;
            if (i3 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i3;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f2319c == null && this.f2321f == null) {
            return;
        }
        if (this.f2317a.m642h()) {
            if (this.f2319c == null) {
                m1675c();
            }
            compoundButton = this.f2319c;
            compoundButton2 = this.f2321f;
        } else {
            if (this.f2321f == null) {
                m1676b();
            }
            compoundButton = this.f2321f;
            compoundButton2 = this.f2319c;
        }
        if (z) {
            compoundButton.setChecked(this.f2317a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
                return;
            }
            compoundButton2.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f2321f;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f2319c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f2317a.m642h()) {
            if (this.f2319c == null) {
                m1675c();
            }
            compoundButton = this.f2319c;
        } else {
            if (this.f2321f == null) {
                m1676b();
            }
            compoundButton = this.f2321f;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f2333r = z;
        this.f2329n = z;
    }

    public void setGroupDividerEnabled(boolean z) {
        ImageView imageView = this.f2324i;
        if (imageView != null) {
            imageView.setVisibility((this.f2331p || !z) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f2317a.f5424n.getOptionalIconsVisible() || this.f2333r;
        if (z || this.f2329n) {
            ImageView imageView = this.f2318b;
            if (imageView == null && drawable == null && !this.f2329n) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) m1677a().inflate(C1949l.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f2318b = imageView2;
                LinearLayout linearLayout = this.f2325j;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f2329n) {
                this.f2318b.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f2318b;
            if (!z) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f2318b.getVisibility() != 0) {
                this.f2318b.setVisibility(0);
            }
        }
    }

    public void setShortcut(boolean z, char c) {
        String sb;
        int i = (z && this.f2317a.m636n()) ? 0 : 8;
        if (i == 0) {
            TextView textView = this.f2322g;
            C1950l0 c1950l0 = this.f2317a;
            char m645e = c1950l0.m645e();
            if (m645e == 0) {
                sb = "";
            } else {
                Resources resources = c1950l0.f5424n.getContext().getResources();
                StringBuilder sb2 = new StringBuilder();
                if (ViewConfiguration.get(c1950l0.f5424n.getContext()).hasPermanentMenuKey()) {
                    sb2.append(resources.getString(C1967m.abc_prepend_shortcut_label));
                }
                int i2 = c1950l0.f5424n.isQwertyMode() ? c1950l0.f5421k : c1950l0.f5419i;
                C1950l0.m647c(sb2, i2, 65536, resources.getString(C1967m.abc_menu_meta_shortcut_label));
                C1950l0.m647c(sb2, i2, 4096, resources.getString(C1967m.abc_menu_ctrl_shortcut_label));
                C1950l0.m647c(sb2, i2, 2, resources.getString(C1967m.abc_menu_alt_shortcut_label));
                C1950l0.m647c(sb2, i2, 1, resources.getString(C1967m.abc_menu_shift_shortcut_label));
                C1950l0.m647c(sb2, i2, 4, resources.getString(C1967m.abc_menu_sym_shortcut_label));
                C1950l0.m647c(sb2, i2, 8, resources.getString(C1967m.abc_menu_function_shortcut_label));
                if (m645e == '\b') {
                    sb2.append(resources.getString(C1967m.abc_menu_delete_shortcut_label));
                } else if (m645e == '\n') {
                    sb2.append(resources.getString(C1967m.abc_menu_enter_shortcut_label));
                } else if (m645e != ' ') {
                    sb2.append(m645e);
                } else {
                    sb2.append(resources.getString(C1967m.abc_menu_space_shortcut_label));
                }
                sb = sb2.toString();
            }
            textView.setText(sb);
        }
        if (this.f2322g.getVisibility() != i) {
            this.f2322g.setVisibility(i);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.f2320d.setText(charSequence);
            if (this.f2320d.getVisibility() != 0) {
                this.f2320d.setVisibility(0);
            }
        } else if (this.f2320d.getVisibility() != 8) {
            this.f2320d.setVisibility(8);
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C0954b1 m1196r = C0954b1.m1196r(getContext(), attributeSet, C2012o.MenuView, i, 0);
        this.f2326k = m1196r.m1207g(C2012o.MenuView_android_itemBackground);
        this.f2327l = m1196r.m1201m(C2012o.MenuView_android_itemTextAppearance, -1);
        this.f2329n = m1196r.m1213a(C2012o.MenuView_preserveIconSpacing, false);
        this.f2328m = context;
        this.f2330o = m1196r.m1207g(C2012o.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{16843049}, C1671f.dropDownListViewStyle, 0);
        this.f2331p = obtainStyledAttributes.hasValue(0);
        m1196r.f3660b.recycle();
        obtainStyledAttributes.recycle();
    }
}
