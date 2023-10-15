package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.C1103R;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.InterfaceC2186q0;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements InterfaceC2186q0.InterfaceC2187a {
    private static final int[] CHECKED_STATE_SET = {16842912};
    private final C0130F4 accessibilityDelegate;
    private FrameLayout actionArea;
    public boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private ColorStateList iconTintList;
    private C1950l0 itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void adjustAppearance() {
        if (shouldExpandActionArea()) {
            this.textView.setVisibility(8);
            FrameLayout frameLayout = this.actionArea;
            if (frameLayout != null) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) frameLayout.getLayoutParams();
                ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                this.actionArea.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        this.textView.setVisibility(0);
        FrameLayout frameLayout2 = this.actionArea;
        if (frameLayout2 != null) {
            LinearLayoutCompat.LayoutParams layoutParams2 = (LinearLayoutCompat.LayoutParams) frameLayout2.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) layoutParams2).width = -2;
            this.actionArea.setLayoutParams(layoutParams2);
        }
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue typedValue = new TypedValue();
        if (getContext().getTheme().resolveAttribute(C1671f.colorControlHighlight, typedValue, true)) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(CHECKED_STATE_SET, new ColorDrawable(typedValue.data));
            stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            return stateListDrawable;
        }
        return null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.actionArea == null) {
                this.actionArea = (FrameLayout) ((ViewStub) findViewById(C1103R.C1106id.design_menu_item_action_area_stub)).inflate();
            }
            this.actionArea.removeAllViews();
            this.actionArea.addView(view);
        }
    }

    private boolean shouldExpandActionArea() {
        C1950l0 c1950l0 = this.itemData;
        return c1950l0.f5415e == null && c1950l0.getIcon() == null && this.itemData.getActionView() != null;
    }

    @Override // p000.InterfaceC2186q0.InterfaceC2187a
    public C1950l0 getItemData() {
        return this.itemData;
    }

    @Override // p000.InterfaceC2186q0.InterfaceC2187a
    public void initialize(C1950l0 c1950l0, int i) {
        this.itemData = c1950l0;
        int i2 = c1950l0.f5411a;
        if (i2 > 0) {
            setId(i2);
        }
        setVisibility(c1950l0.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            StateListDrawable createDefaultBackground = createDefaultBackground();
            AtomicInteger atomicInteger = C0492V4.f1798a;
            C0492V4.C0495c.m1927q(this, createDefaultBackground);
        }
        setCheckable(c1950l0.isCheckable());
        setChecked(c1950l0.isChecked());
        setEnabled(c1950l0.isEnabled());
        setTitle(c1950l0.f5415e);
        setIcon(c1950l0.getIcon());
        setActionView(c1950l0.getActionView());
        setContentDescription(c1950l0.f5427q);
        LayoutInflater$Factory2C0000A.C0010h.m2616r0(this, c1950l0.f5428r);
        adjustAppearance();
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        C1950l0 c1950l0 = this.itemData;
        if (c1950l0 != null && c1950l0.isCheckable() && this.itemData.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void recycle() {
        FrameLayout frameLayout = this.actionArea;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
        if (this.checkable != z) {
            this.checkable = z;
            this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 2048);
        }
    }

    public void setChecked(boolean z) {
        refreshDrawableState();
        this.textView.setChecked(z);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.hasIconTintList) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = LayoutInflater$Factory2C0000A.C0010h.m2604x0(drawable).mutate();
                drawable.setTintList(this.iconTintList);
            }
            int i = this.iconSize;
            drawable.setBounds(0, 0, i, i);
        } else if (this.needsEmptyIcon) {
            if (this.emptyDrawable == null) {
                Resources resources = getResources();
                int i2 = C1103R.C1105drawable.navigation_empty_icon;
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal<TypedValue> threadLocal = C0103E3.f375a;
                Drawable drawable2 = resources.getDrawable(i2, theme);
                this.emptyDrawable = drawable2;
                if (drawable2 != null) {
                    int i3 = this.iconSize;
                    drawable2.setBounds(0, 0, i3, i3);
                }
            }
            drawable = this.emptyDrawable;
        }
        this.textView.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.textView.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.iconSize = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        this.hasIconTintList = colorStateList != null;
        C1950l0 c1950l0 = this.itemData;
        if (c1950l0 != null) {
            setIcon(c1950l0.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.textView.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z) {
        this.needsEmptyIcon = z;
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearance(int i) {
        LayoutInflater$Factory2C0000A.C0010h.m2624n0(this.textView, i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.textView.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0130F4 c0130f4 = new C0130F4() { // from class: com.google.android.material.internal.NavigationMenuItemView.1
            @Override // p000.C0130F4
            public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
                super.onInitializeAccessibilityNodeInfo(view, c1617d5);
                c1617d5.f3986a.setCheckable(NavigationMenuItemView.this.checkable);
            }
        };
        this.accessibilityDelegate = c0130f4;
        setOrientation(0);
        LayoutInflater.from(context).inflate(C1103R.layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(C1103R.dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(C1103R.C1106id.design_menu_item_text);
        this.textView = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        C0492V4.m1950u(checkedTextView, c0130f4);
    }
}
