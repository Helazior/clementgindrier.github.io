package p000;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import p000.InterfaceC1677f5;

/* renamed from: d5 */
/* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
public class C1617d5 {

    /* renamed from: d */
    public static int f3985d;

    /* renamed from: a */
    public final AccessibilityNodeInfo f3986a;

    /* renamed from: b */
    public int f3987b = -1;

    /* renamed from: c */
    public int f3988c = -1;

    /* renamed from: d5$a */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1618a {

        /* renamed from: e */
        public static final C1618a f3989e = new C1618a(1, null);

        /* renamed from: f */
        public static final C1618a f3990f = new C1618a(2, null);

        /* renamed from: g */
        public static final C1618a f3991g;

        /* renamed from: h */
        public static final C1618a f3992h;

        /* renamed from: i */
        public static final C1618a f3993i;

        /* renamed from: j */
        public static final C1618a f3994j;

        /* renamed from: k */
        public static final C1618a f3995k;

        /* renamed from: l */
        public static final C1618a f3996l;

        /* renamed from: m */
        public static final C1618a f3997m;

        /* renamed from: n */
        public static final C1618a f3998n;

        /* renamed from: o */
        public static final C1618a f3999o;

        /* renamed from: a */
        public final Object f4000a;

        /* renamed from: b */
        public final int f4001b;

        /* renamed from: c */
        public final Class<? extends InterfaceC1677f5.AbstractC1678a> f4002c;

        /* renamed from: d */
        public final InterfaceC1677f5 f4003d;

        static {
            new AccessibilityNodeInfo.AccessibilityAction(4, null);
            new AccessibilityNodeInfo.AccessibilityAction(8, null);
            f3991g = new C1618a(16, null);
            new AccessibilityNodeInfo.AccessibilityAction(32, null);
            new AccessibilityNodeInfo.AccessibilityAction(64, null);
            new AccessibilityNodeInfo.AccessibilityAction(128, null);
            new AccessibilityNodeInfo.AccessibilityAction(256, null);
            new AccessibilityNodeInfo.AccessibilityAction(512, null);
            new AccessibilityNodeInfo.AccessibilityAction(1024, null);
            new AccessibilityNodeInfo.AccessibilityAction(2048, null);
            f3992h = new C1618a(4096, null);
            f3993i = new C1618a(8192, null);
            new AccessibilityNodeInfo.AccessibilityAction(16384, null);
            new AccessibilityNodeInfo.AccessibilityAction(32768, null);
            new AccessibilityNodeInfo.AccessibilityAction(65536, null);
            new AccessibilityNodeInfo.AccessibilityAction(PKIFailureInfo.unsupportedVersion, null);
            f3994j = new C1618a(262144, null);
            f3995k = new C1618a(PKIFailureInfo.signerNotTrusted, null);
            f3996l = new C1618a(1048576, null);
            new AccessibilityNodeInfo.AccessibilityAction(PKIFailureInfo.badSenderNonce, null);
            int i = Build.VERSION.SDK_INT;
            if ((i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908342, null);
            }
            if ((i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908343, null);
            }
            f3997m = new C1618a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP : null, 16908344, null, null, null);
            if ((i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908345, null);
            }
            f3998n = new C1618a(i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN : null, 16908346, null, null, null);
            if ((i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908347, null);
            }
            if ((i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908358, null);
            }
            if ((i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908359, null);
            }
            if ((i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908360, null);
            }
            if ((i >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908361, null);
            }
            if ((i >= 23 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908348, null);
            }
            f3999o = new C1618a(i >= 24 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS : null, 16908349, null, null, InterfaceC1677f5.C1679b.class);
            if ((i >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908354, null);
            }
            if ((i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908356, null);
            }
            if ((i >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908357, null);
            }
            if ((i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908362, null);
            }
            if ((i >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null) == null) {
                new AccessibilityNodeInfo.AccessibilityAction(16908372, null);
            }
        }

        public C1618a(int i, CharSequence charSequence) {
            this(null, i, charSequence, null, null);
        }

        /* renamed from: a */
        public int m1015a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f4000a).getId();
        }

        /* renamed from: b */
        public CharSequence m1014b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f4000a).getLabel();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof C1618a)) {
                C1618a c1618a = (C1618a) obj;
                Object obj2 = this.f4000a;
                return obj2 == null ? c1618a.f4000a == null : obj2.equals(c1618a.f4000a);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f4000a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public C1618a(Object obj, int i, CharSequence charSequence, InterfaceC1677f5 interfaceC1677f5, Class<? extends InterfaceC1677f5.AbstractC1678a> cls) {
            this.f4001b = i;
            this.f4003d = interfaceC1677f5;
            if (obj == null) {
                this.f4000a = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.f4000a = obj;
            }
            this.f4002c = cls;
        }
    }

    /* renamed from: d5$b */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1619b {

        /* renamed from: a */
        public final Object f4004a;

        public C1619b(Object obj) {
            this.f4004a = obj;
        }

        /* renamed from: a */
        public static C1619b m1013a(int i, int i2, boolean z, int i3) {
            return new C1619b(AccessibilityNodeInfo.CollectionInfo.obtain(i, i2, z, i3));
        }
    }

    /* renamed from: d5$c */
    /* loaded from: /home/clement/Documents/site/ma_vie/content/posts/vulnerabilite-izly/resources/classes.dex */
    public static class C1620c {

        /* renamed from: a */
        public final Object f4005a;

        public C1620c(Object obj) {
            this.f4005a = obj;
        }

        /* renamed from: a */
        public static C1620c m1012a(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new C1620c(AccessibilityNodeInfo.CollectionItemInfo.obtain(i, i2, i3, i4, z, z2));
        }
    }

    public C1617d5(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f3986a = accessibilityNodeInfo;
    }

    /* renamed from: c */
    public static String m1030c(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case PKIFailureInfo.unsupportedVersion /* 131072 */:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case PKIFailureInfo.signerNotTrusted /* 524288 */:
                        return "ACTION_COLLAPSE";
                    case PKIFailureInfo.badSenderNonce /* 2097152 */:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    case 16908372:
                        return "ACTION_IME_ENTER";
                    default:
                        switch (i) {
                            case 16908342:
                                return "ACTION_SHOW_ON_SCREEN";
                            case 16908343:
                                return "ACTION_SCROLL_TO_POSITION";
                            case 16908344:
                                return "ACTION_SCROLL_UP";
                            case 16908345:
                                return "ACTION_SCROLL_LEFT";
                            case 16908346:
                                return "ACTION_SCROLL_DOWN";
                            case 16908347:
                                return "ACTION_SCROLL_RIGHT";
                            case 16908348:
                                return "ACTION_CONTEXT_CLICK";
                            case 16908349:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i) {
                                    case 16908356:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case 16908357:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case 16908358:
                                        return "ACTION_PAGE_UP";
                                    case 16908359:
                                        return "ACTION_PAGE_DOWN";
                                    case 16908360:
                                        return "ACTION_PAGE_LEFT";
                                    case 16908361:
                                        return "ACTION_PAGE_RIGHT";
                                    case 16908362:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    /* renamed from: f */
    public static ClickableSpan[] m1027f(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    /* renamed from: a */
    public void m1032a(C1618a c1618a) {
        this.f3986a.addAction((AccessibilityNodeInfo.AccessibilityAction) c1618a.f4000a);
    }

    /* renamed from: b */
    public final List<Integer> m1031b(String str) {
        ArrayList<Integer> integerArrayList = this.f3986a.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.f3986a.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    /* renamed from: d */
    public int m1029d() {
        return this.f3986a.getActions();
    }

    /* renamed from: e */
    public CharSequence m1028e() {
        return this.f3986a.getClassName();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof C1617d5)) {
            C1617d5 c1617d5 = (C1617d5) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.f3986a;
            if (accessibilityNodeInfo == null) {
                if (c1617d5.f3986a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(c1617d5.f3986a)) {
                return false;
            }
            return this.f3988c == c1617d5.f3988c && this.f3987b == c1617d5.f3987b;
        }
        return false;
    }

    /* renamed from: g */
    public CharSequence m1026g() {
        return this.f3986a.getContentDescription();
    }

    /* renamed from: h */
    public Bundle m1025h() {
        return this.f3986a.getExtras();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f3986a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* renamed from: i */
    public CharSequence m1024i() {
        if (!m1031b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty()) {
            List<Integer> m1031b = m1031b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> m1031b2 = m1031b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> m1031b3 = m1031b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> m1031b4 = m1031b("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.f3986a.getText(), 0, this.f3986a.getText().length()));
            for (int i = 0; i < m1031b.size(); i++) {
                spannableString.setSpan(new C0988c5(m1031b4.get(i).intValue(), this, m1025h().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), m1031b.get(i).intValue(), m1031b2.get(i).intValue(), m1031b3.get(i).intValue());
            }
            return spannableString;
        }
        return this.f3986a.getText();
    }

    /* renamed from: j */
    public boolean m1023j() {
        return this.f3986a.isEnabled();
    }

    /* renamed from: k */
    public boolean m1022k() {
        return this.f3986a.isFocusable();
    }

    /* renamed from: l */
    public boolean m1021l(C1618a c1618a) {
        return this.f3986a.removeAction((AccessibilityNodeInfo.AccessibilityAction) c1618a.f4000a);
    }

    /* renamed from: m */
    public final void m1020m(int i, boolean z) {
        Bundle m1025h = m1025h();
        if (m1025h != null) {
            int i2 = m1025h.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i);
            if (!z) {
                i = 0;
            }
            m1025h.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i | i2);
        }
    }

    /* renamed from: n */
    public void m1019n(Object obj) {
        this.f3986a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((C1619b) obj).f4004a);
    }

    /* renamed from: o */
    public void m1018o(Object obj) {
        this.f3986a.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) ((C1620c) obj).f4005a);
    }

    /* renamed from: p */
    public void m1017p(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f3986a.setHintText(charSequence);
        } else {
            this.f3986a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    /* renamed from: q */
    public void m1016q(View view) {
        this.f3987b = -1;
        this.f3986a.setParent(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.ArrayList] */
    public String toString() {
        ?? emptyList;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        this.f3986a.getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        this.f3986a.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(this.f3986a.getPackageName());
        sb.append("; className: ");
        sb.append(m1028e());
        sb.append("; text: ");
        sb.append(m1024i());
        sb.append("; contentDescription: ");
        sb.append(m1026g());
        sb.append("; viewId: ");
        sb.append(this.f3986a.getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(this.f3986a.isCheckable());
        sb.append("; checked: ");
        sb.append(this.f3986a.isChecked());
        sb.append("; focusable: ");
        sb.append(m1022k());
        sb.append("; focused: ");
        sb.append(this.f3986a.isFocused());
        sb.append("; selected: ");
        sb.append(this.f3986a.isSelected());
        sb.append("; clickable: ");
        sb.append(this.f3986a.isClickable());
        sb.append("; longClickable: ");
        sb.append(this.f3986a.isLongClickable());
        sb.append("; enabled: ");
        sb.append(m1023j());
        sb.append("; password: ");
        sb.append(this.f3986a.isPassword());
        sb.append("; scrollable: " + this.f3986a.isScrollable());
        sb.append("; [");
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f3986a.getActionList();
        if (actionList != null) {
            emptyList = new ArrayList();
            int size = actionList.size();
            for (int i = 0; i < size; i++) {
                emptyList.add(new C1618a(actionList.get(i), 0, null, null, null));
            }
        } else {
            emptyList = Collections.emptyList();
        }
        for (int i2 = 0; i2 < emptyList.size(); i2++) {
            C1618a c1618a = (C1618a) emptyList.get(i2);
            String m1030c = m1030c(c1618a.m1015a());
            if (m1030c.equals("ACTION_UNKNOWN") && c1618a.m1014b() != null) {
                m1030c = c1618a.m1014b().toString();
            }
            sb.append(m1030c);
            if (i2 != emptyList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
