package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.base.C1095R;
import com.google.android.gms.common.util.DeviceProperties;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class zaaa extends Button {
    public zaaa(Context context, AttributeSet attributeSet) {
        super(context, null, 16842824);
    }

    private static final int zab(int i, int i2, int i3, int i4) {
        if (i != 0) {
            if (i != 1) {
                if (i == 2) {
                    return i4;
                }
                StringBuilder sb = new StringBuilder(33);
                sb.append("Unknown color scheme: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
            }
            return i3;
        }
        return i2;
    }

    public final void zaa(Resources resources, int i, int i2) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        int i3 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
        setMinHeight(i3);
        setMinWidth(i3);
        int i4 = C1095R.C1097drawable.common_google_signin_btn_icon_dark;
        int i5 = C1095R.C1097drawable.common_google_signin_btn_icon_light;
        int zab = zab(i2, i4, i5, i5);
        int i6 = C1095R.C1097drawable.common_google_signin_btn_text_dark;
        int i7 = C1095R.C1097drawable.common_google_signin_btn_text_light;
        int zab2 = zab(i2, i6, i7, i7);
        if (i == 0 || i == 1) {
            zab = zab2;
        } else if (i != 2) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Unknown button size: ");
            sb.append(i);
            throw new IllegalStateException(sb.toString());
        }
        Drawable m2604x0 = LayoutInflater$Factory2C0000A.C0010h.m2604x0(resources.getDrawable(zab));
        m2604x0.setTintList(resources.getColorStateList(C1095R.C1096color.common_google_signin_btn_tint));
        m2604x0.setTintMode(PorterDuff.Mode.SRC_ATOP);
        setBackgroundDrawable(m2604x0);
        int i8 = C1095R.C1096color.common_google_signin_btn_text_dark;
        int i9 = C1095R.C1096color.common_google_signin_btn_text_light;
        setTextColor((ColorStateList) Preconditions.checkNotNull(resources.getColorStateList(zab(i2, i8, i9, i9))));
        if (i == 0) {
            setText(resources.getString(C1095R.string.common_signin_button_text));
        } else if (i == 1) {
            setText(resources.getString(C1095R.string.common_signin_button_text_long));
        } else if (i == 2) {
            setText((CharSequence) null);
        } else {
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append("Unknown button size: ");
            sb2.append(i);
            throw new IllegalStateException(sb2.toString());
        }
        setTransformationMethod(null);
        if (DeviceProperties.isWearable(getContext())) {
            setGravity(19);
        }
    }
}
