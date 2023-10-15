package p000;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import java.util.Locale;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.TextBundle;

/* renamed from: Md */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class C0296Md {
    @NotNull

    /* renamed from: a */
    public static final C0297a f999a = new C0297a(null);

    /* renamed from: Md$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0297a {
        public C0297a(C0565Xd c0565Xd) {
        }

        /* renamed from: b */
        public static /* synthetic */ void m2193b(C0297a c0297a, AppCompatActivity appCompatActivity, String str, Integer num, String str2, EnumC1687fd enumC1687fd, EnumC0161Gd enumC0161Gd, boolean z, boolean z2, int i) {
            c0297a.m2194a(appCompatActivity, str, num, str2, enumC1687fd, enumC0161Gd, z, (i & 128) != 0 ? false : z2);
        }

        /* renamed from: a */
        public final void m2194a(@NotNull AppCompatActivity appCompatActivity, @NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable EnumC1687fd enumC1687fd, @NotNull EnumC0161Gd enumC0161Gd, boolean z, boolean z2) {
            ActionBar m1681z;
            boolean z3;
            EnumC0161Gd enumC0161Gd2 = EnumC0161Gd.COLOR_GREY;
            C0581Yd.m1766e(appCompatActivity, "mActivity");
            C0581Yd.m1766e(str, TextBundle.TEXT_ENTRY);
            C0581Yd.m1766e(enumC0161Gd, "color");
            View findViewById = appCompatActivity.findViewById(2131297017);
            C0581Yd.m1767d(findViewById, "mActivity.findViewById(R.id.tv_title_appBar)");
            TextView textView = (TextView) findViewById;
            View findViewById2 = appCompatActivity.findViewById(2131296616);
            C0581Yd.m1767d(findViewById2, "mActivity.findViewById(R.id.iv_circle)");
            ShapeableImageView shapeableImageView = (ShapeableImageView) findViewById2;
            if (enumC1687fd != null) {
                int ordinal = enumC1687fd.ordinal();
                if (ordinal == 0) {
                    Locale locale = Locale.getDefault();
                    C0581Yd.m1767d(locale, "Locale.getDefault()");
                    String upperCase = str.toUpperCase(locale);
                    C0581Yd.m1767d(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                    View findViewById3 = appCompatActivity.findViewById(2131296919);
                    C0581Yd.m1767d(findViewById3, "mActivity.findViewById(R.id.toolbar_background)");
                    ((ConstraintLayout) findViewById3).setBackground(appCompatActivity.getDrawable(enumC0161Gd.f516a));
                    View findViewById4 = appCompatActivity.findViewById(2131296355);
                    Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
                    appCompatActivity.m1682y().mo24v((Toolbar) findViewById4);
                    ActionBar m1681z2 = appCompatActivity.m1681z();
                    if (m1681z2 != null) {
                        m1681z2.mo1706o(false);
                        m1681z2.mo1708m(z);
                        m1681z2.mo1707n(z);
                        if (enumC0161Gd.f516a == 2131231117) {
                            m1681z2.mo1705p(2131230930);
                        } else {
                            m1681z2.mo1705p(2131230931);
                        }
                    }
                    if (num != null) {
                        shapeableImageView.setImageResource(num.intValue());
                    } else {
                        shapeableImageView.setVisibility(8);
                    }
                    textView.setText(upperCase);
                    View findViewById5 = appCompatActivity.findViewById(2131296944);
                    C0581Yd.m1767d(findViewById5, "mActivity.findViewById(R.id.tv_appBar_desc)");
                    TextView textView2 = (TextView) findViewById5;
                    textView2.setVisibility(0);
                    textView2.setText(str2);
                    if (enumC0161Gd == enumC0161Gd2) {
                        textView2.setTextColor(appCompatActivity.getResources().getColor(2131099678));
                        textView.setTextColor(appCompatActivity.getResources().getColor(2131099678));
                    }
                } else if (ordinal == 1) {
                    Locale locale2 = Locale.getDefault();
                    C0581Yd.m1767d(locale2, "Locale.getDefault()");
                    String upperCase2 = str.toUpperCase(locale2);
                    C0581Yd.m1767d(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
                    View findViewById6 = appCompatActivity.findViewById(2131296919);
                    C0581Yd.m1767d(findViewById6, "mActivity.findViewById(R.id.toolbar_background)");
                    ((ConstraintLayout) findViewById6).setBackground(appCompatActivity.getDrawable(enumC0161Gd.f516a));
                    appCompatActivity.m1684D((Toolbar) appCompatActivity.findViewById(2131296355));
                    if (z2) {
                        View findViewById7 = appCompatActivity.findViewById(2131296564);
                        C0581Yd.m1767d(findViewById7, "mActivity.findViewById(R.id.force_margin)");
                        View findViewById8 = appCompatActivity.findViewById(2131297017);
                        C0581Yd.m1767d(findViewById8, "mActivity.findViewById(R.id.tv_title_appBar)");
                        ViewGroup.LayoutParams layoutParams = findViewById7.getLayoutParams();
                        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) appCompatActivity.getResources().getDimension(2131165340);
                        findViewById7.setLayoutParams(layoutParams2);
                        z3 = false;
                        ((TextView) findViewById8).setTextSize(0, appCompatActivity.getResources().getDimension(2131165267));
                    } else {
                        z3 = false;
                    }
                    ActionBar m1681z3 = appCompatActivity.m1681z();
                    if (m1681z3 != null) {
                        m1681z3.mo1706o(z3);
                        m1681z3.mo1708m(z);
                        m1681z3.mo1707n(z);
                        if (enumC0161Gd.f516a == 2131231117) {
                            m1681z3.mo1705p(2131230930);
                        } else {
                            m1681z3.mo1705p(2131230931);
                        }
                    }
                    if (num != null) {
                        shapeableImageView.setImageDrawable(appCompatActivity.getResources().getDrawable(num.intValue()));
                    }
                    textView.setText(upperCase2);
                    if (enumC0161Gd == enumC0161Gd2) {
                        textView.setTextColor(appCompatActivity.getResources().getColor(2131099678));
                    }
                } else if (ordinal == 2) {
                    Locale locale3 = Locale.getDefault();
                    C0581Yd.m1767d(locale3, "Locale.getDefault()");
                    String upperCase3 = str.toUpperCase(locale3);
                    C0581Yd.m1767d(upperCase3, "(this as java.lang.String).toUpperCase(locale)");
                    View findViewById9 = appCompatActivity.findViewById(2131296919);
                    C0581Yd.m1767d(findViewById9, "mActivity.findViewById(R.id.toolbar_background)");
                    ((ConstraintLayout) findViewById9).setBackground(appCompatActivity.getDrawable(enumC0161Gd.f516a));
                    View findViewById10 = appCompatActivity.findViewById(2131296355);
                    C0581Yd.m1767d(findViewById10, "mActivity.findViewById(R.id.app_bar_toolbar)");
                    Toolbar toolbar = (Toolbar) findViewById10;
                    if (enumC0161Gd.f516a == 2131231117) {
                        toolbar.setTitleTextColor(appCompatActivity.getResources().getColor(2131099678));
                    } else {
                        toolbar.setTitleTextColor(appCompatActivity.getResources().getColor(2131099938));
                    }
                    toolbar.setTitle(upperCase3);
                    appCompatActivity.m1682y().mo24v(toolbar);
                    ActionBar m1681z4 = appCompatActivity.m1681z();
                    if (m1681z4 != null) {
                        m1681z4.mo1706o(true);
                        m1681z4.mo1708m(z);
                        m1681z4.mo1707n(z);
                        if (enumC0161Gd.f516a == 2131231117) {
                            m1681z4.mo1705p(2131230930);
                        } else {
                            m1681z4.mo1705p(2131230931);
                        }
                    }
                } else if (ordinal == 3) {
                    Locale locale4 = Locale.getDefault();
                    C0581Yd.m1767d(locale4, "Locale.getDefault()");
                    String upperCase4 = str.toUpperCase(locale4);
                    C0581Yd.m1767d(upperCase4, "(this as java.lang.String).toUpperCase(locale)");
                    View findViewById11 = appCompatActivity.findViewById(2131296919);
                    C0581Yd.m1767d(findViewById11, "mActivity.findViewById(R.id.toolbar_background)");
                    ((ConstraintLayout) findViewById11).setBackground(appCompatActivity.getDrawable(enumC0161Gd.f516a));
                    appCompatActivity.m1684D((Toolbar) appCompatActivity.findViewById(2131296355));
                    ActionBar m1681z5 = appCompatActivity.m1681z();
                    if (m1681z5 != null) {
                        m1681z5.mo1706o(false);
                        m1681z5.mo1708m(z);
                        m1681z5.mo1707n(z);
                        if (enumC0161Gd.f516a == 2131231117) {
                            m1681z5.mo1705p(2131230930);
                        } else {
                            m1681z5.mo1705p(2131230931);
                        }
                    }
                    View findViewById12 = appCompatActivity.findViewById(2131296616);
                    C0581Yd.m1767d(findViewById12, "mActivity.findViewById(R.id.iv_circle)");
                    ((ShapeableImageView) findViewById12).setVisibility(8);
                    View findViewById13 = appCompatActivity.findViewById(2131297017);
                    C0581Yd.m1767d(findViewById13, "mActivity.findViewById(R.id.tv_title_appBar)");
                    TextView textView3 = (TextView) findViewById13;
                    textView3.setText(upperCase4);
                    if (enumC0161Gd == enumC0161Gd2) {
                        textView3.setTextColor(appCompatActivity.getResources().getColor(2131099678));
                    }
                }
                if (!z || (m1681z = appCompatActivity.m1681z()) == null) {
                    return;
                }
                m1681z.mo1707n(true);
                return;
            }
            throw new IllegalArgumentException();
        }
    }
}
