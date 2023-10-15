package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.C1103R;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C0492V4;
import p000.C1617d5;
import p000.C2307w3;
import p000.InterfaceC2186q0;
import p000.LayoutInflater$Factory2C0000A;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class BottomNavigationItemView extends FrameLayout implements InterfaceC2186q0.InterfaceC2187a {
    private static final int[] CHECKED_STATE_SET = {16842912};
    public static final int INVALID_ITEM_POSITION = -1;
    private BadgeDrawable badgeDrawable;
    private final int defaultMargin;
    private ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private C1950l0 itemData;
    private int itemPosition;
    private final ViewGroup labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;
    private Drawable wrappedIconDrawable;

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    private void calculateTextScaleFactors(float f, float f2) {
        this.shiftAmount = f - f2;
        this.scaleUpFactor = (f2 * 1.0f) / f;
        this.scaleDownFactor = (f * 1.0f) / f2;
    }

    private FrameLayout getCustomParentForBadge(View view) {
        ImageView imageView = this.icon;
        if (view == imageView && BadgeUtils.USE_COMPAT_PARENT) {
            return (FrameLayout) imageView.getParent();
        }
        return null;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < indexOfChild; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof BottomNavigationItemView) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private boolean hasBadge() {
        return this.badgeDrawable != null;
    }

    private static void setViewLayoutParams(View view, int i, int i2) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.gravity = i2;
        view.setLayoutParams(layoutParams);
    }

    private static void setViewScaleValues(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    private void tryAttachBadgeToAnchor(View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private void tryRemoveBadgeFromAnchor(View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
            }
            this.badgeDrawable = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateBadgeBounds(View view) {
        if (hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, getCustomParentForBadge(view));
        }
    }

    private static void updateViewPaddingBottom(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    @Override // p000.InterfaceC2186q0.InterfaceC2187a
    public C1950l0 getItemData() {
        return this.itemData;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    @Override // p000.InterfaceC2186q0.InterfaceC2187a
    public void initialize(C1950l0 c1950l0, int i) {
        CharSequence charSequence;
        this.itemData = c1950l0;
        setCheckable(c1950l0.isCheckable());
        setChecked(c1950l0.isChecked());
        setEnabled(c1950l0.isEnabled());
        setIcon(c1950l0.getIcon());
        setTitle(c1950l0.f5415e);
        setId(c1950l0.f5411a);
        if (!TextUtils.isEmpty(c1950l0.f5427q)) {
            setContentDescription(c1950l0.f5427q);
        }
        if (!TextUtils.isEmpty(c1950l0.f5428r)) {
            charSequence = c1950l0.f5428r;
        } else {
            charSequence = c1950l0.f5415e;
        }
        LayoutInflater$Factory2C0000A.C0010h.m2616r0(this, charSequence);
        setVisibility(c1950l0.isVisible() ? 0 : 8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        C1950l0 c1950l0 = this.itemData;
        if (c1950l0 != null && c1950l0.isCheckable() && this.itemData.isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.badgeDrawable;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            C1950l0 c1950l0 = this.itemData;
            CharSequence charSequence = c1950l0.f5415e;
            if (!TextUtils.isEmpty(c1950l0.f5427q)) {
                charSequence = this.itemData.f5427q;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.badgeDrawable.getContentDescription()));
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) C1617d5.C1620c.m1012a(0, 1, getItemVisiblePosition(), 1, false, isSelected()).f4005a);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) C1617d5.C1618a.f3991g.f4000a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(C1103R.string.item_view_role_description));
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setBadge(BadgeDrawable badgeDrawable) {
        this.badgeDrawable = badgeDrawable;
        ImageView imageView = this.icon;
        if (imageView != null) {
            tryAttachBadgeToAnchor(imageView);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    public void setChecked(boolean z) {
        TextView textView = this.largeLabel;
        textView.setPivotX(textView.getWidth() / 2);
        TextView textView2 = this.largeLabel;
        textView2.setPivotY(textView2.getBaseline());
        TextView textView3 = this.smallLabel;
        textView3.setPivotX(textView3.getWidth() / 2);
        TextView textView4 = this.smallLabel;
        textView4.setPivotY(textView4.getBaseline());
        int i = this.labelVisibilityMode;
        if (i != -1) {
            if (i == 0) {
                if (z) {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    ViewGroup viewGroup = this.labelGroup;
                    updateViewPaddingBottom(viewGroup, ((Integer) viewGroup.getTag(C1103R.C1106id.mtrl_view_tag_bottom_padding)).intValue());
                    this.largeLabel.setVisibility(0);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 17);
                    updateViewPaddingBottom(this.labelGroup, 0);
                    this.largeLabel.setVisibility(4);
                }
                this.smallLabel.setVisibility(4);
            } else if (i == 1) {
                ViewGroup viewGroup2 = this.labelGroup;
                updateViewPaddingBottom(viewGroup2, ((Integer) viewGroup2.getTag(C1103R.C1106id.mtrl_view_tag_bottom_padding)).intValue());
                if (z) {
                    setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                    setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                    TextView textView5 = this.smallLabel;
                    float f = this.scaleUpFactor;
                    setViewScaleValues(textView5, f, f, 4);
                } else {
                    setViewLayoutParams(this.icon, this.defaultMargin, 49);
                    TextView textView6 = this.largeLabel;
                    float f2 = this.scaleDownFactor;
                    setViewScaleValues(textView6, f2, f2, 4);
                    setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
                }
            } else if (i == 2) {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                this.largeLabel.setVisibility(8);
                this.smallLabel.setVisibility(8);
            }
        } else if (this.isShifting) {
            if (z) {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                ViewGroup viewGroup3 = this.labelGroup;
                updateViewPaddingBottom(viewGroup3, ((Integer) viewGroup3.getTag(C1103R.C1106id.mtrl_view_tag_bottom_padding)).intValue());
                this.largeLabel.setVisibility(0);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 17);
                updateViewPaddingBottom(this.labelGroup, 0);
                this.largeLabel.setVisibility(4);
            }
            this.smallLabel.setVisibility(4);
        } else {
            ViewGroup viewGroup4 = this.labelGroup;
            updateViewPaddingBottom(viewGroup4, ((Integer) viewGroup4.getTag(C1103R.C1106id.mtrl_view_tag_bottom_padding)).intValue());
            if (z) {
                setViewLayoutParams(this.icon, (int) (this.defaultMargin + this.shiftAmount), 49);
                setViewScaleValues(this.largeLabel, 1.0f, 1.0f, 0);
                TextView textView7 = this.smallLabel;
                float f3 = this.scaleUpFactor;
                setViewScaleValues(textView7, f3, f3, 4);
            } else {
                setViewLayoutParams(this.icon, this.defaultMargin, 49);
                TextView textView8 = this.largeLabel;
                float f4 = this.scaleDownFactor;
                setViewScaleValues(textView8, f4, f4, 4);
                setViewScaleValues(this.smallLabel, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.smallLabel.setEnabled(z);
        this.largeLabel.setEnabled(z);
        this.icon.setEnabled(z);
        if (z) {
            C0492V4.m1949v(this, C0371Q4.m2122a(getContext(), 1002));
        } else {
            C0492V4.m1949v(this, null);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.originalIconDrawable) {
            return;
        }
        this.originalIconDrawable = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = LayoutInflater$Factory2C0000A.C0010h.m2604x0(drawable).mutate();
            this.wrappedIconDrawable = drawable;
            ColorStateList colorStateList = this.iconTint;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconSize(int i) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.icon.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.iconTint = colorStateList;
        if (this.itemData == null || (drawable = this.wrappedIconDrawable) == null) {
            return;
        }
        drawable.setTintList(colorStateList);
        this.wrappedIconDrawable.invalidateSelf();
    }

    public void setItemBackground(int i) {
        Drawable m202b;
        if (i == 0) {
            m202b = null;
        } else {
            Context context = getContext();
            Object obj = C2307w3.f6741a;
            m202b = C2307w3.C2310c.m202b(context, i);
        }
        setItemBackground(m202b);
    }

    public void setItemPosition(int i) {
        this.itemPosition = i;
    }

    public void setLabelVisibilityMode(int i) {
        if (this.labelVisibilityMode != i) {
            this.labelVisibilityMode = i;
            C1950l0 c1950l0 = this.itemData;
            if (c1950l0 != null) {
                setChecked(c1950l0.isChecked());
            }
        }
    }

    public void setShifting(boolean z) {
        if (this.isShifting != z) {
            this.isShifting = z;
            C1950l0 c1950l0 = this.itemData;
            if (c1950l0 != null) {
                setChecked(c1950l0.isChecked());
            }
        }
    }

    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearanceActive(int i) {
        LayoutInflater$Factory2C0000A.C0010h.m2624n0(this.largeLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextAppearanceInactive(int i) {
        LayoutInflater$Factory2C0000A.C0010h.m2624n0(this.smallLabel, i);
        calculateTextScaleFactors(this.smallLabel.getTextSize(), this.largeLabel.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        C1950l0 c1950l0 = this.itemData;
        if (c1950l0 == null || TextUtils.isEmpty(c1950l0.f5427q)) {
            setContentDescription(charSequence);
        }
        C1950l0 c1950l02 = this.itemData;
        if (c1950l02 != null && !TextUtils.isEmpty(c1950l02.f5428r)) {
            charSequence = this.itemData.f5428r;
        }
        LayoutInflater$Factory2C0000A.C0010h.m2616r0(this, charSequence);
    }

    public boolean showsIcon() {
        return true;
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.itemPosition = -1;
        Resources resources = getResources();
        LayoutInflater.from(context).inflate(C1103R.layout.design_bottom_navigation_item, (ViewGroup) this, true);
        setBackgroundResource(C1103R.C1105drawable.design_bottom_navigation_item_background);
        this.defaultMargin = resources.getDimensionPixelSize(C1103R.dimen.design_bottom_navigation_margin);
        this.icon = (ImageView) findViewById(C1103R.C1106id.icon);
        ViewGroup viewGroup = (ViewGroup) findViewById(C1103R.C1106id.labelGroup);
        this.labelGroup = viewGroup;
        TextView textView = (TextView) findViewById(C1103R.C1106id.smallLabel);
        this.smallLabel = textView;
        TextView textView2 = (TextView) findViewById(C1103R.C1106id.largeLabel);
        this.largeLabel = textView2;
        viewGroup.setTag(C1103R.C1106id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1925s(textView, 2);
        C0492V4.C0495c.m1925s(textView2, 2);
        setFocusable(true);
        calculateTextScaleFactors(textView.getTextSize(), textView2.getTextSize());
        ImageView imageView = this.icon;
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.bottomnavigation.BottomNavigationItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    if (BottomNavigationItemView.this.icon.getVisibility() == 0) {
                        BottomNavigationItemView bottomNavigationItemView = BottomNavigationItemView.this;
                        bottomNavigationItemView.tryUpdateBadgeBounds(bottomNavigationItemView.icon);
                    }
                }
            });
        }
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        AtomicInteger atomicInteger = C0492V4.f1798a;
        C0492V4.C0495c.m1927q(this, drawable);
    }
}
