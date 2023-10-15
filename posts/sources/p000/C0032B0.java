package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import p000.C0384R0;

/* renamed from: B0 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0032B0 {

    /* renamed from: b */
    public static final PorterDuff.Mode f160b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c */
    public static C0032B0 f161c;

    /* renamed from: a */
    public C0384R0 f162a;

    /* renamed from: B0$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0033a implements C0384R0.InterfaceC0389e {

        /* renamed from: a */
        public final int[] f163a = {C1904j.abc_textfield_search_default_mtrl_alpha, C1904j.abc_textfield_default_mtrl_alpha, C1904j.abc_ab_share_pack_mtrl_alpha};

        /* renamed from: b */
        public final int[] f164b = {C1904j.abc_ic_commit_search_api_mtrl_alpha, C1904j.abc_seekbar_tick_mark_material, C1904j.abc_ic_menu_share_mtrl_alpha, C1904j.abc_ic_menu_copy_mtrl_am_alpha, C1904j.abc_ic_menu_cut_mtrl_alpha, C1904j.abc_ic_menu_selectall_mtrl_alpha, C1904j.abc_ic_menu_paste_mtrl_am_alpha};

        /* renamed from: c */
        public final int[] f165c = {C1904j.abc_textfield_activated_mtrl_alpha, C1904j.abc_textfield_search_activated_mtrl_alpha, C1904j.abc_cab_background_top_mtrl_alpha, C1904j.abc_text_cursor_material, C1904j.abc_text_select_handle_left_mtrl_dark, C1904j.abc_text_select_handle_middle_mtrl_dark, C1904j.abc_text_select_handle_right_mtrl_dark, C1904j.abc_text_select_handle_left_mtrl_light, C1904j.abc_text_select_handle_middle_mtrl_light, C1904j.abc_text_select_handle_right_mtrl_light};

        /* renamed from: d */
        public final int[] f166d = {C1904j.abc_popup_background_mtrl_mult, C1904j.abc_cab_background_internal_bg, C1904j.abc_menu_hardkey_panel_mtrl_mult};

        /* renamed from: e */
        public final int[] f167e = {C1904j.abc_tab_indicator_material, C1904j.abc_textfield_search_material};

        /* renamed from: f */
        public final int[] f168f = {C1904j.abc_btn_check_material, C1904j.abc_btn_radio_material, C1904j.abc_btn_check_material_anim, C1904j.abc_btn_radio_material_anim};

        /* renamed from: a */
        public final boolean m2574a(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        /* renamed from: b */
        public final ColorStateList m2573b(Context context, int i) {
            int m1823c = C0530W0.m1823c(context, C1671f.colorControlHighlight);
            return new ColorStateList(new int[][]{C0530W0.f1867b, C0530W0.f1869d, C0530W0.f1868c, C0530W0.f1871f}, new int[]{C0530W0.m1824b(context, C1671f.colorButtonNormal), C0147G3.m2431a(m1823c, i), C0147G3.m2431a(m1823c, i), i});
        }

        /* renamed from: c */
        public ColorStateList m2572c(Context context, int i) {
            if (i == C1904j.abc_edit_text_material) {
                return C0279M.m2211a(context, C1849h.abc_tint_edittext);
            }
            if (i == C1904j.abc_switch_track_mtrl_alpha) {
                return C0279M.m2211a(context, C1849h.abc_tint_switch_track);
            }
            if (i == C1904j.abc_switch_thumb_material) {
                int[][] iArr = new int[3];
                int[] iArr2 = new int[3];
                int i2 = C1671f.colorSwitchThumbNormal;
                ColorStateList m1822d = C0530W0.m1822d(context, i2);
                if (m1822d != null && m1822d.isStateful()) {
                    iArr[0] = C0530W0.f1867b;
                    iArr2[0] = m1822d.getColorForState(iArr[0], 0);
                    iArr[1] = C0530W0.f1870e;
                    iArr2[1] = C0530W0.m1823c(context, C1671f.colorControlActivated);
                    iArr[2] = C0530W0.f1871f;
                    iArr2[2] = m1822d.getDefaultColor();
                } else {
                    iArr[0] = C0530W0.f1867b;
                    iArr2[0] = C0530W0.m1824b(context, i2);
                    iArr[1] = C0530W0.f1870e;
                    iArr2[1] = C0530W0.m1823c(context, C1671f.colorControlActivated);
                    iArr[2] = C0530W0.f1871f;
                    iArr2[2] = C0530W0.m1823c(context, i2);
                }
                return new ColorStateList(iArr, iArr2);
            } else if (i == C1904j.abc_btn_default_mtrl_shape) {
                return m2573b(context, C0530W0.m1823c(context, C1671f.colorButtonNormal));
            } else {
                if (i == C1904j.abc_btn_borderless_material) {
                    return m2573b(context, 0);
                }
                if (i == C1904j.abc_btn_colored_material) {
                    return m2573b(context, C0530W0.m1823c(context, C1671f.colorAccent));
                }
                if (i != C1904j.abc_spinner_mtrl_am_alpha && i != C1904j.abc_spinner_textfield_background_material) {
                    if (m2574a(this.f164b, i)) {
                        return C0530W0.m1822d(context, C1671f.colorControlNormal);
                    }
                    if (m2574a(this.f167e, i)) {
                        return C0279M.m2211a(context, C1849h.abc_tint_default);
                    }
                    if (m2574a(this.f168f, i)) {
                        return C0279M.m2211a(context, C1849h.abc_tint_btn_checkable);
                    }
                    if (i == C1904j.abc_seekbar_thumb_material) {
                        return C0279M.m2211a(context, C1849h.abc_tint_seek_thumb);
                    }
                    return null;
                }
                return C0279M.m2211a(context, C1849h.abc_tint_spinner);
            }
        }

        /* renamed from: d */
        public final void m2571d(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (C0263L0.m2228a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = C0032B0.f160b;
            }
            drawable.setColorFilter(C0032B0.m2578c(i, mode));
        }
    }

    /* renamed from: a */
    public static synchronized C0032B0 m2580a() {
        C0032B0 c0032b0;
        synchronized (C0032B0.class) {
            if (f161c == null) {
                m2576e();
            }
            c0032b0 = f161c;
        }
        return c0032b0;
    }

    /* renamed from: c */
    public static synchronized PorterDuffColorFilter m2578c(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter m2061h;
        synchronized (C0032B0.class) {
            m2061h = C0384R0.m2061h(i, mode);
        }
        return m2061h;
    }

    /* renamed from: e */
    public static synchronized void m2576e() {
        synchronized (C0032B0.class) {
            if (f161c == null) {
                C0032B0 c0032b0 = new C0032B0();
                f161c = c0032b0;
                c0032b0.f162a = C0384R0.m2065d();
                C0384R0 c0384r0 = f161c.f162a;
                C0033a c0033a = new C0033a();
                synchronized (c0384r0) {
                    c0384r0.f1304g = c0033a;
                }
            }
        }
    }

    /* renamed from: f */
    public static void m2575f(Drawable drawable, C0584Z0 c0584z0, int[] iArr) {
        PorterDuff.Mode mode = C0384R0.f1295h;
        if (C0263L0.m2228a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z = c0584z0.f2070d;
        if (!z && !c0584z0.f2069c) {
            drawable.clearColorFilter();
        } else {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = z ? c0584z0.f2067a : null;
            PorterDuff.Mode mode2 = c0584z0.f2069c ? c0584z0.f2068b : C0384R0.f1295h;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilter = C0384R0.m2061h(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    /* renamed from: b */
    public synchronized Drawable m2579b(Context context, int i) {
        return this.f162a.m2063f(context, i);
    }

    /* renamed from: d */
    public synchronized ColorStateList m2577d(Context context, int i) {
        return this.f162a.m2060i(context, i);
    }
}
