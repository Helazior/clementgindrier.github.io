package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Constraints;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import p000.C0083D2;
import p000.C0445T2;

/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.2";
    public SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    public C0427S2 mConstraintLayoutSpec;
    private C0445T2 mConstraintSet;
    private int mConstraintSetId;
    private AbstractC0468U2 mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    public boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    public int mLastMeasureHeightMode;
    public int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    public int mLastMeasureWidthMode;
    public int mLastMeasureWidthSize;
    public C2269u2 mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    public C0720a mMeasurer;
    private C1975m2 mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<C2248t2> mTempMapIdToWidget;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public class C0720a implements C0083D2.InterfaceC0085b {

        /* renamed from: a */
        public ConstraintLayout f2905a;

        /* renamed from: b */
        public int f2906b;

        /* renamed from: c */
        public int f2907c;

        /* renamed from: d */
        public int f2908d;

        /* renamed from: e */
        public int f2909e;

        /* renamed from: f */
        public int f2910f;

        /* renamed from: g */
        public int f2911g;

        public C0720a(ConstraintLayout constraintLayout) {
            this.f2905a = constraintLayout;
        }

        /* renamed from: a */
        public final boolean m1525a(int i, int i2, int i3) {
            if (i == i2) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i);
            View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i3 == size;
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:109:0x01b0  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x01c5  */
        /* JADX WARN: Removed duplicated region for block: B:114:0x01c7  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x01ca  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x01d1 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:125:0x01d9 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:131:0x01e2  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x01ed  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x0200 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:152:0x0217  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x023e  */
        /* JADX WARN: Removed duplicated region for block: B:159:0x0247  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0251  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x025b  */
        /* JADX WARN: Removed duplicated region for block: B:165:0x0268  */
        /* JADX WARN: Removed duplicated region for block: B:166:0x026d  */
        /* JADX WARN: Removed duplicated region for block: B:169:0x0272  */
        /* JADX WARN: Removed duplicated region for block: B:172:0x027a  */
        /* JADX WARN: Removed duplicated region for block: B:173:0x027f  */
        /* JADX WARN: Removed duplicated region for block: B:176:0x0284  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x0295  */
        /* JADX WARN: Removed duplicated region for block: B:187:0x02b1 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:192:0x02be  */
        /* JADX WARN: Removed duplicated region for block: B:194:0x02c4  */
        /* JADX WARN: Removed duplicated region for block: B:197:0x02e3  */
        /* JADX WARN: Removed duplicated region for block: B:198:0x02e5  */
        /* JADX WARN: Removed duplicated region for block: B:201:0x02ea  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x02f5  */
        /* JADX WARN: Removed duplicated region for block: B:207:0x02f7  */
        /* JADX WARN: Removed duplicated region for block: B:209:0x02fa  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00be  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x013b  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x014f  */
        @android.annotation.SuppressLint({"WrongCall"})
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m1524b(p000.C2248t2 r21, p000.C0083D2.C0084a r22) {
            /*
                Method dump skipped, instructions count: 781
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.C0720a.m1524b(t2, D2$a):void");
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new C2269u2();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new C0720a(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    private final C2248t2 getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f2889l0;
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        C2269u2 c2269u2 = this.mLayoutWidget;
        c2269u2.f6499i0 = this;
        c2269u2.m305f0(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0533W2.ConstraintLayout_Layout, i, i2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == C0533W2.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == C0533W2.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == C0533W2.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == C0533W2.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == C0533W2.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == C0533W2.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == C0533W2.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        C0445T2 c0445t2 = new C0445T2();
                        this.mConstraintSet = c0445t2;
                        c0445t2.m2024i(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.m304g0(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        String str;
        int m1537h;
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C2248t2 viewWidget = getViewWidget(getChildAt(i));
            if (viewWidget != null) {
                viewWidget.mo317G();
            }
        }
        if (isInEditMode) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).f6505l0 = resourceName;
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    Constraints constraints = (Constraints) childAt2;
                    if (constraints.f2913a == null) {
                        constraints.f2913a = new C0445T2();
                    }
                    C0445T2 c0445t2 = constraints.f2913a;
                    Objects.requireNonNull(c0445t2);
                    int childCount2 = constraints.getChildCount();
                    c0445t2.f1455c.clear();
                    for (int i4 = 0; i4 < childCount2; i4++) {
                        View childAt3 = constraints.getChildAt(i4);
                        Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt3.getLayoutParams();
                        int id = childAt3.getId();
                        if (c0445t2.f1454b && id == -1) {
                            throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                        }
                        if (!c0445t2.f1455c.containsKey(Integer.valueOf(id))) {
                            c0445t2.f1455c.put(Integer.valueOf(id), new C0445T2.C0446a());
                        }
                        C0445T2.C0446a c0446a = c0445t2.f1455c.get(Integer.valueOf(id));
                        if (childAt3 instanceof ConstraintHelper) {
                            ConstraintHelper constraintHelper = (ConstraintHelper) childAt3;
                            c0446a.m2019c(id, layoutParams);
                            if (constraintHelper instanceof Barrier) {
                                C0445T2.C0447b c0447b = c0446a.f1459d;
                                c0447b.f1496d0 = 1;
                                Barrier barrier = (Barrier) constraintHelper;
                                c0447b.f1492b0 = barrier.f2830i;
                                c0447b.f1498e0 = barrier.m1535j();
                                c0446a.f1459d.f1494c0 = barrier.f2832k.f6259M0;
                            }
                        }
                        c0446a.m2019c(id, layoutParams);
                    }
                    this.mConstraintSet = constraints.f2913a;
                }
            }
        }
        C0445T2 c0445t22 = this.mConstraintSet;
        if (c0445t22 != null) {
            c0445t22.m2030c(this, true);
        }
        this.mLayoutWidget.f174I0.clear();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                ConstraintHelper constraintHelper2 = this.mConstraintHelpers.get(i5);
                if (constraintHelper2.isInEditMode()) {
                    constraintHelper2.m1531o(constraintHelper2.f2837f);
                }
                InterfaceC2341x2 interfaceC2341x2 = constraintHelper2.f2836d;
                if (interfaceC2341x2 != null) {
                    interfaceC2341x2.mo65c();
                    for (int i6 = 0; i6 < constraintHelper2.f2834b; i6++) {
                        int i7 = constraintHelper2.f2833a[i6];
                        View viewById = getViewById(i7);
                        if (viewById == null && (m1537h = constraintHelper2.m1537h(this, (str = constraintHelper2.f2839h.get(Integer.valueOf(i7))))) != 0) {
                            constraintHelper2.f2833a[i6] = m1537h;
                            constraintHelper2.f2839h.put(Integer.valueOf(m1537h), str);
                            viewById = getViewById(m1537h);
                        }
                        if (viewById != null) {
                            constraintHelper2.f2836d.mo67a(getViewWidget(viewById));
                        }
                    }
                    constraintHelper2.f2836d.mo66b(this.mLayoutWidget);
                }
            }
        }
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt4 = getChildAt(i8);
            if (childAt4 instanceof Placeholder) {
                Placeholder placeholder = (Placeholder) childAt4;
                if (placeholder.f2927a == -1 && !placeholder.isInEditMode()) {
                    placeholder.setVisibility(placeholder.f2929c);
                }
                View findViewById = findViewById(placeholder.f2927a);
                placeholder.f2928b = findViewById;
                if (findViewById != null) {
                    ((LayoutParams) findViewById.getLayoutParams()).f2867a0 = true;
                    placeholder.f2928b.setVisibility(0);
                    placeholder.setVisibility(0);
                }
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt5 = getChildAt(i9);
            this.mTempMapIdToWidget.put(childAt5.getId(), getViewWidget(childAt5));
        }
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt6 = getChildAt(i10);
            C2248t2 viewWidget2 = getViewWidget(childAt6);
            if (viewWidget2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) childAt6.getLayoutParams();
                this.mLayoutWidget.m2561a(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt6, viewWidget2, layoutParams2, this.mTempMapIdToWidget);
            }
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            setChildrenConstraints();
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01e6  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:150:0x0311 -> B:151:0x0312). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void applyConstraintsFromLayoutParams(boolean r22, android.view.View r23, p000.C2248t2 r24, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r25, android.util.SparseArray<p000.C2248t2> r26) {
        /*
            Method dump skipped, instructions count: 891
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, android.view.View, t2, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mConstraintHelpers.get(i).mo1529r(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((parseInt / 1080.0f) * width);
                        int i4 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = i3;
                        float f2 = i4;
                        float f3 = i3 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f, f2, f3, f2, paint);
                        float parseInt4 = i4 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f3, f2, f3, parseInt4, paint);
                        canvas.drawLine(f3, parseInt4, f, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f, f2, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f, f2, f3, parseInt4, paint);
                        canvas.drawLine(f, parseInt4, f3, f2, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(C1975m2 c1975m2) {
        Objects.requireNonNull(this.mLayoutWidget.f6609N0);
    }

    @Override // android.view.View
    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i == 0 && (obj instanceof String)) {
            String str = (String) obj;
            HashMap<String, Integer> hashMap = this.mDesignIds;
            if (hashMap == null || !hashMap.containsKey(str)) {
                return null;
            }
            return this.mDesignIds.get(str);
        }
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.f6616U0;
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final C2248t2 getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f2889l0;
    }

    public boolean isRtl() {
        return ((getContext().getApplicationInfo().flags & 4194304) != 0) && 1 == getLayoutDirection();
    }

    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.mConstraintLayoutSpec = new C0427S2(getContext(), this, i);
                return;
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
                return;
            }
        }
        this.mConstraintLayoutSpec = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View view;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            C2248t2 c2248t2 = layoutParams.f2889l0;
            if ((childAt.getVisibility() != 8 || layoutParams.f2864Y || layoutParams.f2865Z || isInEditMode) && !layoutParams.f2867a0) {
                int m353x = c2248t2.m353x();
                int m352y = c2248t2.m352y();
                int m354w = c2248t2.m354w() + m353x;
                int m360q = c2248t2.m360q() + m352y;
                childAt.layout(m353x, m352y, m354w, m360q);
                if ((childAt instanceof Placeholder) && (view = ((Placeholder) childAt).f2928b) != null) {
                    view.setVisibility(0);
                    view.layout(m353x, m352y, m354w, m360q);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).mo1522p(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.mDirtyHierarchy) {
            int i3 = this.mOnMeasureWidthMeasureSpec;
            if (i3 == i && this.mOnMeasureHeightMeasureSpec == i2) {
                int m354w = this.mLayoutWidget.m354w();
                int m360q = this.mLayoutWidget.m360q();
                C2269u2 c2269u2 = this.mLayoutWidget;
                resolveMeasuredDimension(i, i2, m354w, m360q, c2269u2.f6617V0, c2269u2.f6618W0);
                return;
            } else if (i3 == i && View.MeasureSpec.getMode(i) == 1073741824 && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.mOnMeasureHeightMeasureSpec) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i2) >= this.mLayoutWidget.m360q()) {
                this.mOnMeasureWidthMeasureSpec = i;
                this.mOnMeasureHeightMeasureSpec = i2;
                int m354w2 = this.mLayoutWidget.m354w();
                int m360q2 = this.mLayoutWidget.m360q();
                C2269u2 c2269u22 = this.mLayoutWidget;
                resolveMeasuredDimension(i, i2, m354w2, m360q2, c2269u22.f6617V0, c2269u22.f6618W0);
                return;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i;
        this.mOnMeasureHeightMeasureSpec = i2;
        this.mLayoutWidget.f6608M0 = isRtl();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.m303h0();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
        int m354w3 = this.mLayoutWidget.m354w();
        int m360q3 = this.mLayoutWidget.m360q();
        C2269u2 c2269u23 = this.mLayoutWidget;
        resolveMeasuredDimension(i, i2, m354w3, m360q3, c2269u23.f6617V0, c2269u23.f6618W0);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        C2248t2 viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof C2306w2)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            C2306w2 c2306w2 = new C2306w2();
            layoutParams.f2889l0 = c2306w2;
            layoutParams.f2864Y = true;
            c2306w2.m215W(layoutParams.f2857R);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.m1527t();
            ((LayoutParams) view.getLayoutParams()).f2865Z = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        C2248t2 viewWidget = getViewWidget(view);
        this.mLayoutWidget.f174I0.remove(viewWidget);
        viewWidget.f6474S = null;
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new C0427S2(getContext(), this, i);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        C0720a c0720a = this.mMeasurer;
        int i5 = c0720a.f2909e;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i3 + c0720a.f2908d, i, 0);
        int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.mMaxHeight, ViewGroup.resolveSizeAndState(i4 + i5, i2, 0) & 16777215);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    /* JADX WARN: Removed duplicated region for block: B:175:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03e7  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x04c2  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void resolveSystem(p000.C2269u2 r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 1700
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.resolveSystem(u2, int, int, int):void");
    }

    public void setConstraintSet(C0445T2 c0445t2) {
        this.mConstraintSet = c0445t2;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    @Override // android.view.View
    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i;
        requestLayout();
    }

    public void setMaxWidth(int i) {
        if (i == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i;
        requestLayout();
    }

    public void setMinHeight(int i) {
        if (i == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i;
        requestLayout();
    }

    public void setMinWidth(int i) {
        if (i == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i;
        requestLayout();
    }

    public void setOnConstraintsChanged(AbstractC0468U2 abstractC0468U2) {
        C0427S2 c0427s2 = this.mConstraintLayoutSpec;
        if (c0427s2 != null) {
            Objects.requireNonNull(c0427s2);
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        C2269u2 c2269u2 = this.mLayoutWidget;
        c2269u2.f6616U0 = i;
        C1953l2.f5438p = c2269u2.m306e0(512);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setSelfDimensionBehaviour(p000.C2269u2 r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            t2$a r0 = p000.C2248t2.EnumC2249a.WRAP_CONTENT
            androidx.constraintlayout.widget.ConstraintLayout$a r1 = r8.mMeasurer
            int r2 = r1.f2909e
            int r1 = r1.f2908d
            t2$a r3 = p000.C2248t2.EnumC2249a.FIXED
            int r4 = r8.getChildCount()
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 0
            if (r10 == r6) goto L30
            if (r10 == 0) goto L25
            if (r10 == r5) goto L1c
            r10 = r3
        L1a:
            r11 = 0
            goto L39
        L1c:
            int r10 = r8.mMaxWidth
            int r10 = r10 - r1
            int r11 = java.lang.Math.min(r10, r11)
            r10 = r3
            goto L39
        L25:
            if (r4 != 0) goto L2e
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r7, r10)
            goto L38
        L2e:
            r10 = r0
            goto L1a
        L30:
            if (r4 != 0) goto L38
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r7, r10)
        L38:
            r10 = r0
        L39:
            if (r12 == r6) goto L54
            if (r12 == 0) goto L4b
            if (r12 == r5) goto L42
            r0 = r3
        L40:
            r13 = 0
            goto L5c
        L42:
            int r12 = r8.mMaxHeight
            int r12 = r12 - r2
            int r13 = java.lang.Math.min(r12, r13)
            r0 = r3
            goto L5c
        L4b:
            if (r4 != 0) goto L40
            int r12 = r8.mMinHeight
            int r13 = java.lang.Math.max(r7, r12)
            goto L5c
        L54:
            if (r4 != 0) goto L5c
            int r12 = r8.mMinHeight
            int r13 = java.lang.Math.max(r7, r12)
        L5c:
            int r12 = r9.m354w()
            r3 = 1
            if (r11 != r12) goto L69
            int r12 = r9.m360q()
            if (r13 == r12) goto L6d
        L69:
            G2 r12 = r9.f6606K0
            r12.f489c = r3
        L6d:
            r9.f6479X = r7
            r9.f6480Y = r7
            int r12 = r8.mMaxWidth
            int r12 = r12 - r1
            int[] r4 = r9.f6532z
            r4[r7] = r12
            int r12 = r8.mMaxHeight
            int r12 = r12 - r2
            r4[r3] = r12
            r9.m372Q(r7)
            r9.m373P(r7)
            t2$a[] r12 = r9.f6473R
            r12[r7] = r10
            r9.m370S(r11)
            t2$a[] r10 = r9.f6473R
            r10[r3] = r0
            r9.m375N(r13)
            int r10 = r8.mMinWidth
            int r10 = r10 - r1
            r9.m372Q(r10)
            int r10 = r8.mMinHeight
            int r10 = r10 - r2
            r9.m373P(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setSelfDimensionBehaviour(u2, int, int, int, int):void");
    }

    public void setState(int i, int i2, int i3) {
        C0427S2 c0427s2 = this.mConstraintLayoutSpec;
        if (c0427s2 != null) {
            c0427s2.m2039b(i, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new C2269u2();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new C0720a(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new C2269u2();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new C0720a(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new C2269u2();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Integer.MAX_VALUE;
        this.mMaxHeight = Integer.MAX_VALUE;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new C0720a(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        init(attributeSet, i, i2);
    }

    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: A */
        public float f2840A;

        /* renamed from: B */
        public String f2841B;

        /* renamed from: C */
        public int f2842C;

        /* renamed from: D */
        public float f2843D;

        /* renamed from: E */
        public float f2844E;

        /* renamed from: F */
        public int f2845F;

        /* renamed from: G */
        public int f2846G;

        /* renamed from: H */
        public int f2847H;

        /* renamed from: I */
        public int f2848I;

        /* renamed from: J */
        public int f2849J;

        /* renamed from: K */
        public int f2850K;

        /* renamed from: L */
        public int f2851L;

        /* renamed from: M */
        public int f2852M;

        /* renamed from: N */
        public float f2853N;

        /* renamed from: O */
        public float f2854O;

        /* renamed from: P */
        public int f2855P;

        /* renamed from: Q */
        public int f2856Q;

        /* renamed from: R */
        public int f2857R;

        /* renamed from: S */
        public boolean f2858S;

        /* renamed from: T */
        public boolean f2859T;

        /* renamed from: U */
        public String f2860U;

        /* renamed from: V */
        public boolean f2861V;

        /* renamed from: W */
        public boolean f2862W;

        /* renamed from: X */
        public boolean f2863X;

        /* renamed from: Y */
        public boolean f2864Y;

        /* renamed from: Z */
        public boolean f2865Z;

        /* renamed from: a */
        public int f2866a;

        /* renamed from: a0 */
        public boolean f2867a0;

        /* renamed from: b */
        public int f2868b;

        /* renamed from: b0 */
        public int f2869b0;

        /* renamed from: c */
        public float f2870c;

        /* renamed from: c0 */
        public int f2871c0;

        /* renamed from: d */
        public int f2872d;

        /* renamed from: d0 */
        public int f2873d0;

        /* renamed from: e */
        public int f2874e;

        /* renamed from: e0 */
        public int f2875e0;

        /* renamed from: f */
        public int f2876f;

        /* renamed from: f0 */
        public int f2877f0;

        /* renamed from: g */
        public int f2878g;

        /* renamed from: g0 */
        public int f2879g0;

        /* renamed from: h */
        public int f2880h;

        /* renamed from: h0 */
        public float f2881h0;

        /* renamed from: i */
        public int f2882i;

        /* renamed from: i0 */
        public int f2883i0;

        /* renamed from: j */
        public int f2884j;

        /* renamed from: j0 */
        public int f2885j0;

        /* renamed from: k */
        public int f2886k;

        /* renamed from: k0 */
        public float f2887k0;

        /* renamed from: l */
        public int f2888l;

        /* renamed from: l0 */
        public C2248t2 f2889l0;

        /* renamed from: m */
        public int f2890m;

        /* renamed from: n */
        public int f2891n;

        /* renamed from: o */
        public float f2892o;

        /* renamed from: p */
        public int f2893p;

        /* renamed from: q */
        public int f2894q;

        /* renamed from: r */
        public int f2895r;

        /* renamed from: s */
        public int f2896s;

        /* renamed from: t */
        public int f2897t;

        /* renamed from: u */
        public int f2898u;

        /* renamed from: v */
        public int f2899v;

        /* renamed from: w */
        public int f2900w;

        /* renamed from: x */
        public int f2901x;

        /* renamed from: y */
        public int f2902y;

        /* renamed from: z */
        public float f2903z;

        /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$LayoutParams$a */
        /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
        public static class C0719a {

            /* renamed from: a */
            public static final SparseIntArray f2904a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f2904a = sparseIntArray;
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(C0533W2.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                f2904a.append(C0533W2.ConstraintLayout_Layout_layout_constraintTag, 51);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            int i;
            this.f2866a = -1;
            this.f2868b = -1;
            this.f2870c = -1.0f;
            this.f2872d = -1;
            this.f2874e = -1;
            this.f2876f = -1;
            this.f2878g = -1;
            this.f2880h = -1;
            this.f2882i = -1;
            this.f2884j = -1;
            this.f2886k = -1;
            this.f2888l = -1;
            this.f2890m = -1;
            this.f2891n = 0;
            this.f2892o = 0.0f;
            this.f2893p = -1;
            this.f2894q = -1;
            this.f2895r = -1;
            this.f2896s = -1;
            this.f2897t = -1;
            this.f2898u = -1;
            this.f2899v = -1;
            this.f2900w = -1;
            this.f2901x = -1;
            this.f2902y = -1;
            this.f2903z = 0.5f;
            this.f2840A = 0.5f;
            this.f2841B = null;
            this.f2842C = 1;
            this.f2843D = -1.0f;
            this.f2844E = -1.0f;
            this.f2845F = 0;
            this.f2846G = 0;
            this.f2847H = 0;
            this.f2848I = 0;
            this.f2849J = 0;
            this.f2850K = 0;
            this.f2851L = 0;
            this.f2852M = 0;
            this.f2853N = 1.0f;
            this.f2854O = 1.0f;
            this.f2855P = -1;
            this.f2856Q = -1;
            this.f2857R = -1;
            this.f2858S = false;
            this.f2859T = false;
            this.f2860U = null;
            this.f2861V = true;
            this.f2862W = true;
            this.f2863X = false;
            this.f2864Y = false;
            this.f2865Z = false;
            this.f2867a0 = false;
            this.f2869b0 = -1;
            this.f2871c0 = -1;
            this.f2873d0 = -1;
            this.f2875e0 = -1;
            this.f2877f0 = -1;
            this.f2879g0 = -1;
            this.f2881h0 = 0.5f;
            this.f2889l0 = new C2248t2();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0533W2.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = C0719a.f2904a.get(index);
                switch (i3) {
                    case 1:
                        this.f2857R = obtainStyledAttributes.getInt(index, this.f2857R);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f2890m);
                        this.f2890m = resourceId;
                        if (resourceId == -1) {
                            this.f2890m = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.f2891n = obtainStyledAttributes.getDimensionPixelSize(index, this.f2891n);
                        break;
                    case 4:
                        float f = obtainStyledAttributes.getFloat(index, this.f2892o) % 360.0f;
                        this.f2892o = f;
                        if (f < 0.0f) {
                            this.f2892o = (360.0f - f) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f2866a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2866a);
                        break;
                    case 6:
                        this.f2868b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2868b);
                        break;
                    case 7:
                        this.f2870c = obtainStyledAttributes.getFloat(index, this.f2870c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f2872d);
                        this.f2872d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f2872d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f2874e);
                        this.f2874e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f2874e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f2876f);
                        this.f2876f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f2876f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f2878g);
                        this.f2878g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f2878g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f2880h);
                        this.f2880h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f2880h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f2882i);
                        this.f2882i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f2882i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f2884j);
                        this.f2884j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f2884j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f2886k);
                        this.f2886k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f2886k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f2888l);
                        this.f2888l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f2888l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f2893p);
                        this.f2893p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f2893p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f2894q);
                        this.f2894q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f2894q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f2895r);
                        this.f2895r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f2895r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f2896s);
                        this.f2896s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f2896s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.f2897t = obtainStyledAttributes.getDimensionPixelSize(index, this.f2897t);
                        break;
                    case 22:
                        this.f2898u = obtainStyledAttributes.getDimensionPixelSize(index, this.f2898u);
                        break;
                    case 23:
                        this.f2899v = obtainStyledAttributes.getDimensionPixelSize(index, this.f2899v);
                        break;
                    case 24:
                        this.f2900w = obtainStyledAttributes.getDimensionPixelSize(index, this.f2900w);
                        break;
                    case 25:
                        this.f2901x = obtainStyledAttributes.getDimensionPixelSize(index, this.f2901x);
                        break;
                    case 26:
                        this.f2902y = obtainStyledAttributes.getDimensionPixelSize(index, this.f2902y);
                        break;
                    case 27:
                        this.f2858S = obtainStyledAttributes.getBoolean(index, this.f2858S);
                        break;
                    case 28:
                        this.f2859T = obtainStyledAttributes.getBoolean(index, this.f2859T);
                        break;
                    case 29:
                        this.f2903z = obtainStyledAttributes.getFloat(index, this.f2903z);
                        break;
                    case 30:
                        this.f2840A = obtainStyledAttributes.getFloat(index, this.f2840A);
                        break;
                    case 31:
                        int i4 = obtainStyledAttributes.getInt(index, 0);
                        this.f2847H = i4;
                        if (i4 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i5 = obtainStyledAttributes.getInt(index, 0);
                        this.f2848I = i5;
                        if (i5 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.f2849J = obtainStyledAttributes.getDimensionPixelSize(index, this.f2849J);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.f2849J) == -2) {
                                this.f2849J = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.f2851L = obtainStyledAttributes.getDimensionPixelSize(index, this.f2851L);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.f2851L) == -2) {
                                this.f2851L = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.f2853N = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f2853N));
                        this.f2847H = 2;
                        break;
                    case 36:
                        try {
                            this.f2850K = obtainStyledAttributes.getDimensionPixelSize(index, this.f2850K);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.f2850K) == -2) {
                                this.f2850K = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.f2852M = obtainStyledAttributes.getDimensionPixelSize(index, this.f2852M);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.f2852M) == -2) {
                                this.f2852M = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 38:
                        this.f2854O = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.f2854O));
                        this.f2848I = 2;
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                String string = obtainStyledAttributes.getString(index);
                                this.f2841B = string;
                                this.f2842C = -1;
                                if (string == null) {
                                    break;
                                } else {
                                    int length = string.length();
                                    int indexOf = this.f2841B.indexOf(44);
                                    if (indexOf <= 0 || indexOf >= length - 1) {
                                        i = 0;
                                    } else {
                                        String substring = this.f2841B.substring(0, indexOf);
                                        if (substring.equalsIgnoreCase("W")) {
                                            this.f2842C = 0;
                                        } else if (substring.equalsIgnoreCase("H")) {
                                            this.f2842C = 1;
                                        }
                                        i = indexOf + 1;
                                    }
                                    int indexOf2 = this.f2841B.indexOf(58);
                                    if (indexOf2 >= 0 && indexOf2 < length - 1) {
                                        String substring2 = this.f2841B.substring(i, indexOf2);
                                        String substring3 = this.f2841B.substring(indexOf2 + 1);
                                        if (substring2.length() > 0 && substring3.length() > 0) {
                                            try {
                                                float parseFloat = Float.parseFloat(substring2);
                                                float parseFloat2 = Float.parseFloat(substring3);
                                                if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                                                    if (this.f2842C == 1) {
                                                        Math.abs(parseFloat2 / parseFloat);
                                                        break;
                                                    } else {
                                                        Math.abs(parseFloat / parseFloat2);
                                                        break;
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                                break;
                                            }
                                        }
                                    } else {
                                        String substring4 = this.f2841B.substring(i);
                                        if (substring4.length() <= 0) {
                                            break;
                                        } else {
                                            Float.parseFloat(substring4);
                                            continue;
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.f2843D = obtainStyledAttributes.getFloat(index, this.f2843D);
                                continue;
                            case 46:
                                this.f2844E = obtainStyledAttributes.getFloat(index, this.f2844E);
                                continue;
                            case 47:
                                this.f2845F = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 48:
                                this.f2846G = obtainStyledAttributes.getInt(index, 0);
                                continue;
                            case 49:
                                this.f2855P = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2855P);
                                continue;
                            case 50:
                                this.f2856Q = obtainStyledAttributes.getDimensionPixelOffset(index, this.f2856Q);
                                continue;
                            case 51:
                                this.f2860U = obtainStyledAttributes.getString(index);
                                continue;
                        }
                }
            }
            obtainStyledAttributes.recycle();
            m1526a();
        }

        /* renamed from: a */
        public void m1526a() {
            this.f2864Y = false;
            this.f2861V = true;
            this.f2862W = true;
            int i = ((ViewGroup.MarginLayoutParams) this).width;
            if (i == -2 && this.f2858S) {
                this.f2861V = false;
                if (this.f2847H == 0) {
                    this.f2847H = 1;
                }
            }
            int i2 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i2 == -2 && this.f2859T) {
                this.f2862W = false;
                if (this.f2848I == 0) {
                    this.f2848I = 1;
                }
            }
            if (i == 0 || i == -1) {
                this.f2861V = false;
                if (i == 0 && this.f2847H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f2858S = true;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.f2862W = false;
                if (i2 == 0 && this.f2848I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f2859T = true;
                }
            }
            if (this.f2870c == -1.0f && this.f2866a == -1 && this.f2868b == -1) {
                return;
            }
            this.f2864Y = true;
            this.f2861V = true;
            this.f2862W = true;
            if (!(this.f2889l0 instanceof C2306w2)) {
                this.f2889l0 = new C2306w2();
            }
            ((C2306w2) this.f2889l0).m215W(this.f2857R);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @android.annotation.TargetApi(17)
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r10) {
            /*
                Method dump skipped, instructions count: 257
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2866a = -1;
            this.f2868b = -1;
            this.f2870c = -1.0f;
            this.f2872d = -1;
            this.f2874e = -1;
            this.f2876f = -1;
            this.f2878g = -1;
            this.f2880h = -1;
            this.f2882i = -1;
            this.f2884j = -1;
            this.f2886k = -1;
            this.f2888l = -1;
            this.f2890m = -1;
            this.f2891n = 0;
            this.f2892o = 0.0f;
            this.f2893p = -1;
            this.f2894q = -1;
            this.f2895r = -1;
            this.f2896s = -1;
            this.f2897t = -1;
            this.f2898u = -1;
            this.f2899v = -1;
            this.f2900w = -1;
            this.f2901x = -1;
            this.f2902y = -1;
            this.f2903z = 0.5f;
            this.f2840A = 0.5f;
            this.f2841B = null;
            this.f2842C = 1;
            this.f2843D = -1.0f;
            this.f2844E = -1.0f;
            this.f2845F = 0;
            this.f2846G = 0;
            this.f2847H = 0;
            this.f2848I = 0;
            this.f2849J = 0;
            this.f2850K = 0;
            this.f2851L = 0;
            this.f2852M = 0;
            this.f2853N = 1.0f;
            this.f2854O = 1.0f;
            this.f2855P = -1;
            this.f2856Q = -1;
            this.f2857R = -1;
            this.f2858S = false;
            this.f2859T = false;
            this.f2860U = null;
            this.f2861V = true;
            this.f2862W = true;
            this.f2863X = false;
            this.f2864Y = false;
            this.f2865Z = false;
            this.f2867a0 = false;
            this.f2869b0 = -1;
            this.f2871c0 = -1;
            this.f2873d0 = -1;
            this.f2875e0 = -1;
            this.f2877f0 = -1;
            this.f2879g0 = -1;
            this.f2881h0 = 0.5f;
            this.f2889l0 = new C2248t2();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2866a = -1;
            this.f2868b = -1;
            this.f2870c = -1.0f;
            this.f2872d = -1;
            this.f2874e = -1;
            this.f2876f = -1;
            this.f2878g = -1;
            this.f2880h = -1;
            this.f2882i = -1;
            this.f2884j = -1;
            this.f2886k = -1;
            this.f2888l = -1;
            this.f2890m = -1;
            this.f2891n = 0;
            this.f2892o = 0.0f;
            this.f2893p = -1;
            this.f2894q = -1;
            this.f2895r = -1;
            this.f2896s = -1;
            this.f2897t = -1;
            this.f2898u = -1;
            this.f2899v = -1;
            this.f2900w = -1;
            this.f2901x = -1;
            this.f2902y = -1;
            this.f2903z = 0.5f;
            this.f2840A = 0.5f;
            this.f2841B = null;
            this.f2842C = 1;
            this.f2843D = -1.0f;
            this.f2844E = -1.0f;
            this.f2845F = 0;
            this.f2846G = 0;
            this.f2847H = 0;
            this.f2848I = 0;
            this.f2849J = 0;
            this.f2850K = 0;
            this.f2851L = 0;
            this.f2852M = 0;
            this.f2853N = 1.0f;
            this.f2854O = 1.0f;
            this.f2855P = -1;
            this.f2856Q = -1;
            this.f2857R = -1;
            this.f2858S = false;
            this.f2859T = false;
            this.f2860U = null;
            this.f2861V = true;
            this.f2862W = true;
            this.f2863X = false;
            this.f2864Y = false;
            this.f2865Z = false;
            this.f2867a0 = false;
            this.f2869b0 = -1;
            this.f2871c0 = -1;
            this.f2873d0 = -1;
            this.f2875e0 = -1;
            this.f2877f0 = -1;
            this.f2879g0 = -1;
            this.f2881h0 = 0.5f;
            this.f2889l0 = new C2248t2();
        }
    }
}
