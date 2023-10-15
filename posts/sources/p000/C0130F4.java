package p000;

import android.os.Build;
import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import p000.C1617d5;

/* renamed from: F4 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C0130F4 {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    /* renamed from: F4$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static final class C0131a extends View.AccessibilityDelegate {

        /* renamed from: a */
        public final C0130F4 f440a;

        public C0131a(C0130F4 c0130f4) {
            this.f440a = c0130f4;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f440a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            C1654e5 accessibilityNodeProvider = this.f440a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.f4138a;
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f440a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            int i;
            C1617d5 c1617d5 = new C1617d5(accessibilityNodeInfo);
            AtomicInteger atomicInteger = C0492V4.f1798a;
            Boolean m1945c = new C0396R4(C1675f3.tag_screen_reader_focusable, Boolean.class, 28).m1945c(view);
            boolean z = m1945c != null && m1945c.booleanValue();
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 28) {
                c1617d5.f3986a.setScreenReaderFocusable(z);
            } else {
                c1617d5.m1020m(1, z);
            }
            Boolean m1945c2 = new C0470U4(C1675f3.tag_accessibility_heading, Boolean.class, 28).m1945c(view);
            boolean z2 = m1945c2 != null && m1945c2.booleanValue();
            if (i2 >= 28) {
                c1617d5.f3986a.setHeading(z2);
            } else {
                c1617d5.m1020m(2, z2);
            }
            CharSequence m1962i = C0492V4.m1962i(view);
            if (i2 >= 28) {
                c1617d5.f3986a.setPaneTitle(m1962i);
            } else {
                c1617d5.f3986a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", m1962i);
            }
            CharSequence m1945c3 = new C0452T4(C1675f3.tag_state_description, CharSequence.class, 64, 30).m1945c(view);
            if (i2 >= 30) {
                c1617d5.f3986a.setStateDescription(m1945c3);
            } else {
                c1617d5.f3986a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", m1945c3);
            }
            this.f440a.onInitializeAccessibilityNodeInfo(view, c1617d5);
            CharSequence text = accessibilityNodeInfo.getText();
            if (i2 < 26) {
                c1617d5.f3986a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
                c1617d5.f3986a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
                c1617d5.f3986a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
                c1617d5.f3986a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
                SparseArray sparseArray = (SparseArray) view.getTag(C1675f3.tag_accessibility_clickable_spans);
                if (sparseArray != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                        if (((WeakReference) sparseArray.valueAt(i3)).get() == null) {
                            arrayList.add(Integer.valueOf(i3));
                        }
                    }
                    for (int i4 = 0; i4 < arrayList.size(); i4++) {
                        sparseArray.remove(((Integer) arrayList.get(i4)).intValue());
                    }
                }
                ClickableSpan[] m1027f = C1617d5.m1027f(text);
                if (m1027f != null && m1027f.length > 0) {
                    c1617d5.m1025h().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", C1675f3.accessibility_action_clickable_span);
                    int i5 = C1675f3.tag_accessibility_clickable_spans;
                    SparseArray sparseArray2 = (SparseArray) view.getTag(i5);
                    if (sparseArray2 == null) {
                        sparseArray2 = new SparseArray();
                        view.setTag(i5, sparseArray2);
                    }
                    for (int i6 = 0; i6 < m1027f.length; i6++) {
                        ClickableSpan clickableSpan = m1027f[i6];
                        int i7 = 0;
                        while (true) {
                            if (i7 < sparseArray2.size()) {
                                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray2.valueAt(i7)).get())) {
                                    i = sparseArray2.keyAt(i7);
                                    break;
                                }
                                i7++;
                            } else {
                                i = C1617d5.f3985d;
                                C1617d5.f3985d = i + 1;
                                break;
                            }
                        }
                        sparseArray2.put(i, new WeakReference(m1027f[i6]));
                        ClickableSpan clickableSpan2 = m1027f[i6];
                        Spanned spanned = (Spanned) text;
                        c1617d5.m1031b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan2)));
                        c1617d5.m1031b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan2)));
                        c1617d5.m1031b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan2)));
                        c1617d5.m1031b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i));
                    }
                }
            }
            List<C1617d5.C1618a> actionList = C0130F4.getActionList(view);
            for (int i8 = 0; i8 < actionList.size(); i8++) {
                c1617d5.m1032a(actionList.get(i8));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f440a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f440a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f440a.performAccessibilityAction(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f440a.sendAccessibilityEvent(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f440a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    public C0130F4() {
        this(DEFAULT_DELEGATE);
    }

    public static List<C1617d5.C1618a> getActionList(View view) {
        List<C1617d5.C1618a> list = (List) view.getTag(C1675f3.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] m1027f = C1617d5.m1027f(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; m1027f != null && i < m1027f.length; i++) {
                if (clickableSpan.equals(m1027f[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean performClickableSpanAction(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(C1675f3.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (isSpanStillValid(clickableSpan, view)) {
            clickableSpan.onClick(view);
            return true;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public C1654e5 getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.mOriginalDelegate.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new C1654e5(accessibilityNodeProvider);
        }
        return null;
    }

    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, C1617d5 c1617d5) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, c1617d5.f3986a);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performAccessibilityAction(android.view.View r8, int r9, android.os.Bundle r10) {
        /*
            r7 = this;
            java.util.List r0 = getActionList(r8)
            r1 = 0
            r2 = 0
        L6:
            int r3 = r0.size()
            if (r2 >= r3) goto L66
            java.lang.Object r3 = r0.get(r2)
            d5$a r3 = (p000.C1617d5.C1618a) r3
            int r4 = r3.m1015a()
            if (r4 != r9) goto L63
            f5 r0 = r3.f4003d
            if (r0 == 0) goto L66
            r0 = 0
            java.lang.Class<? extends f5$a> r2 = r3.f4002c
            if (r2 == 0) goto L5b
            java.lang.Class[] r4 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L35
            java.lang.reflect.Constructor r2 = r2.getDeclaredConstructor(r4)     // Catch: java.lang.Exception -> L35
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L35
            java.lang.Object r1 = r2.newInstance(r1)     // Catch: java.lang.Exception -> L35
            f5$a r1 = (p000.InterfaceC1677f5.AbstractC1678a) r1     // Catch: java.lang.Exception -> L35
            java.util.Objects.requireNonNull(r1)     // Catch: java.lang.Exception -> L33
            goto L5a
        L33:
            r0 = move-exception
            goto L39
        L35:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L39:
            java.lang.Class<? extends f5$a> r2 = r3.f4002c
            if (r2 != 0) goto L40
            java.lang.String r2 = "null"
            goto L44
        L40:
            java.lang.String r2 = r2.getName()
        L44:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Failed to execute command with argument class ViewCommandArgument: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = "A11yActionCompat"
            android.util.Log.e(r4, r2, r0)
        L5a:
            r0 = r1
        L5b:
            f5 r1 = r3.f4003d
            boolean r0 = r1.perform(r8, r0)
            r1 = r0
            goto L66
        L63:
            int r2 = r2 + 1
            goto L6
        L66:
            if (r1 != 0) goto L6e
            android.view.View$AccessibilityDelegate r0 = r7.mOriginalDelegate
            boolean r1 = r0.performAccessibilityAction(r8, r9, r10)
        L6e:
            if (r1 != 0) goto L7f
            int r0 = p000.C1675f3.accessibility_action_clickable_span
            if (r9 != r0) goto L7f
            r9 = -1
            java.lang.String r0 = "ACCESSIBILITY_CLICKABLE_SPAN_ID"
            int r9 = r10.getInt(r0, r9)
            boolean r1 = r7.performClickableSpanAction(r9, r8)
        L7f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0130F4.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
    }

    public void sendAccessibilityEvent(View view, int i) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0130F4(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new C0131a(this);
    }
}
