package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import p000.C1905j0;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public final class ExpandedMenuView extends ListView implements C1905j0.InterfaceC1907b, InterfaceC2186q0, AdapterView.OnItemClickListener {

    /* renamed from: b */
    public static final int[] f2315b = {16842964, 16843049};

    /* renamed from: a */
    public C1905j0 f2316a;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    @Override // p000.C1905j0.InterfaceC1907b
    /* renamed from: a */
    public boolean mo723a(C1950l0 c1950l0) {
        return this.f2316a.performItemAction(c1950l0, 0);
    }

    @Override // p000.InterfaceC2186q0
    public void initialize(C1905j0 c1905j0) {
        this.f2316a = c1905j0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo723a((C1950l0) getAdapter().getItem(i));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        Drawable drawable;
        int resourceId;
        Drawable drawable2;
        int resourceId2;
        setOnItemClickListener(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2315b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            if (obtainStyledAttributes.hasValue(0) && (resourceId2 = obtainStyledAttributes.getResourceId(0, 0)) != 0) {
                drawable2 = C0279M.m2210b(context, resourceId2);
            } else {
                drawable2 = obtainStyledAttributes.getDrawable(0);
            }
            setBackgroundDrawable(drawable2);
        }
        if (obtainStyledAttributes.hasValue(1)) {
            if (obtainStyledAttributes.hasValue(1) && (resourceId = obtainStyledAttributes.getResourceId(1, 0)) != 0) {
                drawable = C0279M.m2210b(context, resourceId);
            } else {
                drawable = obtainStyledAttributes.getDrawable(1);
            }
            setDivider(drawable);
        }
        obtainStyledAttributes.recycle();
    }
}
