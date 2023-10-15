package p000;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import p000.LayoutInflater$Factory2C0000A;

/* renamed from: K4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0235K4 {

    /* renamed from: a */
    public ViewParent f726a;

    /* renamed from: b */
    public ViewParent f727b;

    /* renamed from: c */
    public final View f728c;

    /* renamed from: d */
    public boolean f729d;

    /* renamed from: e */
    public int[] f730e;

    public C0235K4(View view) {
        this.f728c = view;
    }

    /* renamed from: a */
    public boolean m2344a(float f, float f2, boolean z) {
        ViewParent m2339f;
        if (!this.f729d || (m2339f = m2339f(0)) == null) {
            return false;
        }
        return LayoutInflater$Factory2C0000A.C0010h.m2650a0(m2339f, this.f728c, f, f2, z);
    }

    /* renamed from: b */
    public boolean m2343b(float f, float f2) {
        ViewParent m2339f;
        if (!this.f729d || (m2339f = m2339f(0)) == null) {
            return false;
        }
        return LayoutInflater$Factory2C0000A.C0010h.m2648b0(m2339f, this.f728c, f, f2);
    }

    /* renamed from: c */
    public boolean m2342c(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent m2339f;
        int i4;
        int i5;
        if (!this.f729d || (m2339f = m2339f(i3)) == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            if (iArr2 != null) {
                this.f728c.getLocationInWindow(iArr2);
                i4 = iArr2[0];
                i5 = iArr2[1];
            } else {
                i4 = 0;
                i5 = 0;
            }
            if (iArr == null) {
                if (this.f730e == null) {
                    this.f730e = new int[2];
                }
                iArr = this.f730e;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            LayoutInflater$Factory2C0000A.C0010h.m2646c0(m2339f, this.f728c, i, i2, iArr, i3);
            if (iArr2 != null) {
                this.f728c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i4;
                iArr2[1] = iArr2[1] - i5;
            }
            if (iArr[0] != 0 || iArr[1] != 0) {
                return true;
            }
        } else if (iArr2 != null) {
            iArr2[0] = 0;
            iArr2[1] = 0;
        }
        return false;
    }

    /* renamed from: d */
    public boolean m2341d(int i, int i2, int i3, int i4, int[] iArr) {
        return m2340e(i, i2, i3, i4, iArr, 0, null);
    }

    /* renamed from: e */
    public final boolean m2340e(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent m2339f;
        int i6;
        int i7;
        int[] iArr3;
        if (!this.f729d || (m2339f = m2339f(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f728c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            if (this.f730e == null) {
                this.f730e = new int[2];
            }
            int[] iArr4 = this.f730e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        LayoutInflater$Factory2C0000A.C0010h.m2644d0(m2339f, this.f728c, i, i2, i3, i4, i5, iArr3);
        if (iArr != null) {
            this.f728c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    /* renamed from: f */
    public final ViewParent m2339f(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.f727b;
        }
        return this.f726a;
    }

    /* renamed from: g */
    public boolean m2338g(int i) {
        return m2339f(i) != null;
    }

    /* renamed from: h */
    public boolean m2337h(int i, int i2) {
        boolean onStartNestedScroll;
        if (m2339f(i2) != null) {
            return true;
        }
        if (this.f729d) {
            View view = this.f728c;
            for (ViewParent parent = this.f728c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.f728c;
                boolean z = parent instanceof InterfaceC0267L4;
                if (z) {
                    onStartNestedScroll = ((InterfaceC0267L4) parent).onStartNestedScroll(view, view2, i, i2);
                } else {
                    if (i2 == 0) {
                        try {
                            onStartNestedScroll = parent.onStartNestedScroll(view, view2, i);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                        }
                    }
                    onStartNestedScroll = false;
                }
                if (onStartNestedScroll) {
                    if (i2 == 0) {
                        this.f726a = parent;
                    } else if (i2 == 1) {
                        this.f727b = parent;
                    }
                    View view3 = this.f728c;
                    if (z) {
                        ((InterfaceC0267L4) parent).onNestedScrollAccepted(view, view3, i, i2);
                    } else if (i2 == 0) {
                        try {
                            parent.onNestedScrollAccepted(view, view3, i);
                        } catch (AbstractMethodError e2) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = parent;
                }
            }
        }
        return false;
    }

    /* renamed from: i */
    public void m2336i(int i) {
        ViewParent m2339f = m2339f(i);
        if (m2339f != null) {
            View view = this.f728c;
            if (m2339f instanceof InterfaceC0267L4) {
                ((InterfaceC0267L4) m2339f).onStopNestedScroll(view, i);
            } else if (i == 0) {
                try {
                    m2339f.onStopNestedScroll(view);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + m2339f + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i == 0) {
                this.f726a = null;
            } else if (i != 1) {
            } else {
                this.f727b = null;
            }
        }
    }
}
