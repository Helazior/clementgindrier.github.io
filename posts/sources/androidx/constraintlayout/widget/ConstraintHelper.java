package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;
import java.util.HashMap;
import p000.C0445T2;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a */
    public int[] f2833a;

    /* renamed from: b */
    public int f2834b;

    /* renamed from: c */
    public Context f2835c;

    /* renamed from: d */
    public InterfaceC2341x2 f2836d;

    /* renamed from: f */
    public String f2837f;

    /* renamed from: g */
    public View[] f2838g;

    /* renamed from: h */
    public HashMap<Integer, String> f2839h;

    public ConstraintHelper(Context context) {
        super(context);
        this.f2833a = new int[32];
        this.f2838g = null;
        this.f2839h = new HashMap<>();
        this.f2835c = context;
        mo1519l(null);
    }

    /* renamed from: e */
    public final void m1540e(String str) {
        if (str == null || str.length() == 0 || this.f2835c == null) {
            return;
        }
        String trim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        int m1536i = m1536i(trim);
        if (m1536i != 0) {
            this.f2839h.put(Integer.valueOf(m1536i), trim);
            m1539f(m1536i);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    /* renamed from: f */
    public final void m1539f(int i) {
        if (i == getId()) {
            return;
        }
        int i2 = this.f2834b + 1;
        int[] iArr = this.f2833a;
        if (i2 > iArr.length) {
            this.f2833a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f2833a;
        int i3 = this.f2834b;
        iArr2[i3] = i;
        this.f2834b = i3 + 1;
    }

    /* renamed from: g */
    public void m1538g() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) parent;
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i = 0; i < this.f2834b; i++) {
            View viewById = constraintLayout.getViewById(this.f2833a[i]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    /* renamed from: h */
    public final int m1537h(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        if (str == null || constraintLayout == null || (resources = this.f2835c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            if (childAt.getId() != -1) {
                String str2 = null;
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    /* renamed from: i */
    public final int m1536i(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i = ((Integer) designInformation).intValue();
            }
        }
        if (i == 0 && constraintLayout != null) {
            i = m1537h(constraintLayout, str);
        }
        if (i == 0) {
            try {
                i = C0490V2.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return i == 0 ? this.f2835c.getResources().getIdentifier(str, "id", this.f2835c.getPackageName()) : i;
    }

    /* renamed from: j */
    public int[] m1535j() {
        return Arrays.copyOf(this.f2833a, this.f2834b);
    }

    /* renamed from: k */
    public View[] m1534k(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f2838g;
        if (viewArr == null || viewArr.length != this.f2834b) {
            this.f2838g = new View[this.f2834b];
        }
        for (int i = 0; i < this.f2834b; i++) {
            this.f2838g[i] = constraintLayout.getViewById(this.f2833a[i]);
        }
        return this.f2838g;
    }

    /* renamed from: l */
    public void mo1519l(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0533W2.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f2837f = string;
                    m1531o(string);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: m */
    public void mo1533m(C0445T2.C0446a c0446a, C2363y2 c2363y2, ConstraintLayout.LayoutParams layoutParams, SparseArray<C2248t2> sparseArray) {
        C0445T2.C0447b c0447b = c0446a.f1459d;
        int[] iArr = c0447b.f1498e0;
        int i = 0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = c0447b.f1500f0;
            if (str != null && str.length() > 0) {
                C0445T2.C0447b c0447b2 = c0446a.f1459d;
                String[] split = c0447b2.f1500f0.split(",");
                getContext();
                int[] iArr2 = new int[split.length];
                int i2 = 0;
                for (String str2 : split) {
                    int m1536i = m1536i(str2.trim());
                    if (m1536i != 0) {
                        iArr2[i2] = m1536i;
                        i2++;
                    }
                }
                if (i2 != split.length) {
                    iArr2 = Arrays.copyOf(iArr2, i2);
                }
                c0447b2.f1498e0 = iArr2;
            }
        }
        c2363y2.mo65c();
        if (c0446a.f1459d.f1498e0 == null) {
            return;
        }
        while (true) {
            int[] iArr3 = c0446a.f1459d.f1498e0;
            if (i >= iArr3.length) {
                return;
            }
            C2248t2 c2248t2 = sparseArray.get(iArr3[i]);
            if (c2248t2 != null) {
                c2363y2.mo67a(c2248t2);
            }
            i++;
        }
    }

    /* renamed from: n */
    public void mo1532n(C2248t2 c2248t2, boolean z) {
    }

    /* renamed from: o */
    public void m1531o(String str) {
        this.f2837f = str;
        if (str == null) {
            return;
        }
        int i = 0;
        this.f2834b = 0;
        while (true) {
            int indexOf = str.indexOf(44, i);
            if (indexOf == -1) {
                m1540e(str.substring(i));
                return;
            } else {
                m1540e(str.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f2837f;
        if (str != null) {
            m1531o(str);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    /* renamed from: p */
    public void mo1522p(ConstraintLayout constraintLayout) {
    }

    /* renamed from: q */
    public void m1530q() {
    }

    /* renamed from: r */
    public void mo1529r(ConstraintLayout constraintLayout) {
    }

    /* renamed from: s */
    public void m1528s(InterfaceC2341x2 interfaceC2341x2, SparseArray sparseArray) {
        interfaceC2341x2.mo65c();
        for (int i = 0; i < this.f2834b; i++) {
            interfaceC2341x2.mo67a((C2248t2) sparseArray.get(this.f2833a[i]));
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f2837f = null;
        this.f2834b = 0;
        for (int i : iArr) {
            m1539f(i);
        }
    }

    /* renamed from: t */
    public void m1527t() {
        if (this.f2836d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).f2889l0 = (C2248t2) this.f2836d;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2833a = new int[32];
        this.f2838g = null;
        this.f2839h = new HashMap<>();
        this.f2835c = context;
        mo1519l(attributeSet);
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2833a = new int[32];
        this.f2838g = null;
        this.f2839h = new HashMap<>();
        this.f2835c = context;
        mo1519l(attributeSet);
    }
}
